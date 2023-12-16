package backend.compiler;

import antlr4.*;

import intermediate.symtab.*;
import intermediate.symtab.Predefined;

/**
 * Compile cpp to Jasmin assembly language.
 */
public class Compiler extends cppBaseVisitor<Object>
{
    private SymtabEntry programId;  // symbol table entry of the program name
    private String programName;     // the program name

    private CodeGenerator       code;            // base code generator
    private ProgramGenerator    programCode;     // program code generator
    private StatementGenerator  statementCode;   // statement code generator
    private ExpressionGenerator expressionCode;  // expression code generator

    /**
     * Constructor for the base compiler.
     * @param programId the symtab entry for the program name.
     */
    public Compiler(SymtabEntry programId)
    {
        this.programId = programId;
        programName = programId.getName();

        code = new CodeGenerator(programName, "j", this);
    }

    /**
     * Constructor for child compilers of procedures and functions.
     * @param parent the parent compiler.
     */
    public Compiler(Compiler parent)
    {
        this.code        = parent.code;
        this.programCode = parent.programCode;
        this.programId   = parent.programId;
        this.programName = parent.programName;
    }

    /**
     * Constructor for child compilers of records.
     * @param parent the parent compiler.
     * @param recordId the symbol table entry of the name of the record to compile.
     */
    public Compiler(Compiler parent, SymtabEntry recordId)
    {
        String recordTypePath = recordId.getType().getRecordTypePath();
        code = new CodeGenerator(recordTypePath, "j", this);
        createNewGenerators(code);

        programCode.emitRecord(recordId, recordTypePath);
    }

    /**
     * Create new child code generators.
     * @param parentGenerator the parent code generator.
     */
    private void createNewGenerators(CodeGenerator parentGenerator)
    {
        programCode    = new ProgramGenerator(parentGenerator, this);
        statementCode  = new StatementGenerator(programCode, this);
        expressionCode = new ExpressionGenerator(programCode, this);
    }

    /**
     * Get the name of the object (Jasmin) file.
     * @return the name.
     */
    public String getObjectFileName() { return code.getObjectFileName(); }

    @Override
    public Object visitProgram(cppParser.ProgramContext ctx)
    {
        createNewGenerators(code);
        programCode.emitProgram(ctx);
        return null;
    }

    @Override
    public Object visitRoutineDefinition(
                                    cppParser.RoutineDefinitionContext ctx)
    {
        createNewGenerators(programCode);
        programCode.emitRoutine(ctx);
        return null;
    }

    @Override
    public Object visitStatement(cppParser.StatementContext ctx)
    {
        if (   (ctx.compoundStatement() == null)
            && (ctx.emptyStatement() == null))
        {
            statementCode.emitComment(ctx);
        }

        return visitChildren(ctx);
    }

    @Override
    public Object visitAssignmentStatement(
                                    cppParser.AssignmentStatementContext ctx)
    {
        statementCode.emitAssignment(ctx);
        return null;
    }

    @Override
    public Object visitIfStatement(cppParser.IfStatementContext ctx)
    {
        statementCode.emitIf(ctx);
        return null;
    }

    @Override
    public Object visitWhileStatement(cppParser.WhileStatementContext ctx)
    {
        statementCode.emitWhile(ctx);
        return null;
    }

    @Override
    public Object visitForStatement(cppParser.ForStatementContext ctx)
    {
        statementCode.emitFor(ctx);
        return null;
    }

    @Override
    public Object visitProcedureCallStatement(
                                cppParser.ProcedureCallStatementContext ctx)
    {
        statementCode.emitProcedureCall(ctx);
        return null;
    }

    @Override
    public Object visitExpression(cppParser.ExpressionContext ctx)
    {
        expressionCode.emitExpression(ctx);
        return null;
    }

    @Override
    public Object visitVariableFactor(cppParser.VariableFactorContext ctx)
    {
        expressionCode.emitLoadValue(ctx.variable());
        return null;
    }

    @Override
    public Object visitVariable(cppParser.VariableContext ctx)
    {
        expressionCode.emitLoadVariable(ctx);
        return null;
    }

    @Override
    public Object visitNumberFactor(cppParser.NumberFactorContext ctx)
    {
        if (ctx.type == Predefined.intType)
        {
            expressionCode.emitLoadIntegerConstant(ctx.number());
        }
        else
        {
            expressionCode.emitLoadRealConstant(ctx.number());
        }

        return null;
    }

    @Override
    public Object visitCharacterFactor(cppParser.CharacterFactorContext ctx)
    {
        char ch = ctx.getText().charAt(1);
        expressionCode.emitLoadConstant(ch);

        return null;
    }

    @Override
    public Object visitStringFactor(cppParser.StringFactorContext ctx)
    {
        String jasminString = convertString(ctx.getText());
        expressionCode.emitLoadConstant(jasminString);

        return null;
    }

    /**
     * Convert a cpp string to a Java string.
     * @param cppString the cpp string.
     * @return the Java string.
     */
    String convertString(String cppString)
    {
        String unquoted = cppString.substring(1, cppString.length()-1);
        return unquoted.replace("''", "'").replace("\"", "\\\"");
    }

    @Override
    public Object visitFunctionCallFactor(
                                    cppParser.FunctionCallFactorContext ctx)
    {
        statementCode.emitFunctionCall(ctx.functionCall());
        return null;
    }

    @Override
    public Object visitReturnStatement(cppParser.ReturnStatementContext ctx) {
        statementCode.emitComment(ctx);
        statementCode.emitReturnStatement(ctx);
        return null;
    }

    @Override
    public Object visitNotFactor(cppParser.NotFactorContext ctx)
    {
        expressionCode.emitNotFactor(ctx);
        return null;
    }

    @Override
    public Object visitParenthesizedFactor(
                                    cppParser.ParenthesizedFactorContext ctx)
    {
        return visit(ctx.expression());
    }

    @Override
    public Object visitWriteStatement(cppParser.WriteStatementContext ctx)
    {
        statementCode.emitWrite(ctx);
        return null;
    }

    @Override
    public Object visitWritelnStatement(cppParser.WritelnStatementContext ctx)
    {
        statementCode.emitWriteln(ctx);
        return null;
    }

    @Override
    public Object visitReadStatement(cppParser.ReadStatementContext ctx)
    {
        statementCode.emitRead(ctx);
        return null;
    }

    @Override
    public Object visitReadlnStatement(cppParser.ReadlnStatementContext ctx)
    {
        statementCode.emitReadln(ctx);
        return null;
    }
}
