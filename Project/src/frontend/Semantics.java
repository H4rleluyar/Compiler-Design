package frontend;

import java.util.ArrayList;
import java.util.HashSet;

import antlr4.*;

import intermediate.symtab.*;
import intermediate.symtab.SymtabEntry.Kind;
import intermediate.type.*;
import intermediate.type.Typespec.*;
import intermediate.util.*;

import static frontend.SemanticErrorHandler.Code.*;
import static intermediate.symtab.SymtabEntry.Kind.*;
import static intermediate.symtab.SymtabEntry.Routine.*;
import static intermediate.type.Typespec.Form.*;
import static intermediate.util.BackendMode.*;

/**
 * Semantic operations.
 * Perform type checking and create symbol tables.
 */
public class Semantics extends cppBaseVisitor<Object>
{
    private BackendMode mode;
    private SymtabStack symtabStack;
    private SymtabEntry programId;
    private SemanticErrorHandler error;

    public Semantics(BackendMode mode)
    {
        // Create and initialize the symbol table stack.
        this.symtabStack = new SymtabStack();
        Predefined.initialize(symtabStack);

        this.mode = mode;
        this.error = new SemanticErrorHandler();
    }

    public SymtabEntry getProgramId() { return programId; }
    public int getErrorCount() { return error.getCount(); };

    /**
     * Return the default value for a data type.
     * @param type the data type.
     * @return the default value.
     */
    public static Object defaultValue(Typespec type)
    {
        type = type.baseType();

        if      (type == Predefined.intType) return Integer.valueOf(0);
        else if (type == Predefined.doubleType)    return Float.valueOf(0.0f);
        else if (type == Predefined.booleanType) return Boolean.valueOf(false);
        else if (type == Predefined.charType)    return Character.valueOf('#');
        else /* string */                        return String.valueOf("#");
    }

    @Override
    public Object visitProgram(cppParser.ProgramContext ctx)
    {
        visit(ctx.programHeader());
        visit(ctx.block().declarations());
        visit(ctx.block().intMain().compoundStatement());

        // Print the cross-reference table.
        CrossReferencer crossReferencer = new CrossReferencer();
        crossReferencer.print(symtabStack);

        return null;
    }

    @Override
    public Object visitProgramHeader(cppParser.ProgramHeaderContext ctx)
    {
        cppParser.ProgramIdentifierContext idCtx = ctx.programIdentifier();
        String programName = idCtx.IDENTIFIER().getText();  // don't shift case

        programId = symtabStack.enterLocal(programName, PROGRAM);
        programId.setRoutineSymtab(symtabStack.push());

        symtabStack.setProgramId(programId);
        symtabStack.getLocalSymtab().setOwner(programId);

        idCtx.entry = programId;
        return null;
    }

    @Override
    public Object visitConstantDefinition(
                                cppParser.ConstantDefinitionContext ctx)
    {
        cppParser.ConstantIdentifierContext idCtx = ctx.constantIdentifier();
        String constantName = idCtx.IDENTIFIER().getText().toLowerCase();
        SymtabEntry constantId = symtabStack.lookupLocal(constantName);

        if (constantId == null)
        {
            cppParser.ConstantContext constCtx = ctx.constant();
            Object constValue = visit(constCtx);

            constantId = symtabStack.enterLocal(constantName, CONSTANT);
            constantId.setValue(constValue);
            constantId.setType(constCtx.type);

            idCtx.entry = constantId;
            idCtx.type  = constCtx.type;
        }
        else
        {
            error.flag(REDECLARED_IDENTIFIER, ctx);

            idCtx.entry = constantId;
            idCtx.type  = Predefined.intType;
        }

        constantId.appendLineNumber(ctx.getStart().getLine());
        return null;
    }

    @Override
    public Object visitConstant(cppParser.ConstantContext ctx)
    {
        if (ctx.IDENTIFIER() != null)
        {
            String constantName = ctx.IDENTIFIER().getText().toLowerCase();
            SymtabEntry constantId = symtabStack.lookup(constantName);

            if (constantId != null)
            {
                Kind kind = constantId.getKind();
                if ((kind != CONSTANT) && (kind != ENUMERATION_CONSTANT))
                {
                    error.flag(INVALID_CONSTANT, ctx);
                }

                ctx.type  = constantId.getType();
                ctx.value = constantId.getValue();

                constantId.appendLineNumber(ctx.getStart().getLine());
            }
            else
            {
                error.flag(UNDECLARED_IDENTIFIER, ctx);

                ctx.type = Predefined.intType;
                ctx.value = 0;
            }
        }
        else if (ctx.characterConstant() != null)
        {
            ctx.type  = Predefined.charType;
            ctx.value = (char) ctx.getText().charAt(1);
        }
        else if (ctx.stringConstant() != null)
        {
            String cppString = ctx.stringConstant().STRING().getText();
            String unquoted = cppString.substring(1, cppString.length()-1);
            ctx.type  = Predefined.stringType;
            ctx.value = unquoted.replace("''", "'").replace("\"", "\\\"");
        }
        else  // number
        {
            if (ctx.unsignedNumber().intConstant() != null)
            {
                ctx.type  = Predefined.intType;
                ctx.value = Integer.parseInt(ctx.getText());
            }
            else
            {
                ctx.type  = Predefined.doubleType;
                ctx.value = Float.parseFloat(ctx.getText());
            }
        }

        return ctx.value;
    }

    @Override
    public Object visitTypeDefinition(cppParser.TypeDefinitionContext ctx)
    {
        cppParser.TypeIdentifierContext idCtx = ctx.typeIdentifier();
        String typeName = idCtx.IDENTIFIER().getText().toLowerCase();
        SymtabEntry typeId = symtabStack.lookupLocal(typeName);

        cppParser.TypeSpecificationContext typespecCtx =
                                                        ctx.typeSpecification();

        // If it's a record type, create a named record type.
        if (typespecCtx instanceof cppParser.RecordTypespecContext)
        {
            typeId = createRecordType(
                    (cppParser.RecordTypespecContext) typespecCtx, typeName);
        }

        // Enter the type name of any other type into the symbol table.
        else if (typeId == null)
        {
            visit(typespecCtx);

            typeId = symtabStack.enterLocal(typeName, TYPE);
            typeId.setType(typespecCtx.type);
            typespecCtx.type.setIdentifier(typeId);
        }

        // Redeclared identifier.
        else
        {
            error.flag(REDECLARED_IDENTIFIER, ctx);
        }

        idCtx.entry = typeId;
        idCtx.type  = typespecCtx.type;

        typeId.appendLineNumber(ctx.getStart().getLine());
        return null;
    }

    @Override
    public Object visitRecordTypespec(cppParser.RecordTypespecContext ctx)
    {
        // Create an unnamed record type.
        String recordTypeName = Symtab.generateUnnamedName();
        createRecordType(ctx, recordTypeName);

        return null;
    }

    /**
     * Create a new record type.
     * @param recordTypeSpecCtx the RecordTypespecContext.
     * @param recordTypeName the name of the record type.
     * @return the symbol table entry of the record type identifier.
     */
    private SymtabEntry createRecordType(
                        cppParser.RecordTypespecContext recordTypeSpecCtx,
                        String recordTypeName)
    {
        cppParser.RecordTypeContext recordTypeCtx =
                                                recordTypeSpecCtx.recordType();
        Typespec recordType = new Typespec(RECORD);

        SymtabEntry recordTypeId = symtabStack.enterLocal(recordTypeName, TYPE);
        recordTypeId.setType(recordType);
        recordType.setIdentifier(recordTypeId);

        String recordTypePath = createRecordTypePath(recordType);
        recordType.setRecordTypePath(recordTypePath);

        // Enter the record fields into the record type's symbol table.
        Symtab recordSymtab = createRecordSymtab(recordTypeCtx.recordFields(),
                                                 recordTypeId);
        recordType.setRecordSymtab(recordSymtab);

        recordTypeCtx.entry    = recordTypeId;
        recordTypeSpecCtx.type = recordType;

        return recordTypeId;
    }

    /**
     * Create the fully qualified type pathname of a record type.
     * @param recordType the record type.
     * @return the pathname.
     */
    private String createRecordTypePath(Typespec recordType)
    {
        SymtabEntry recordId = recordType.getIdentifier();
        SymtabEntry parentId = recordId.getSymtab().getOwner();
        String path = recordId.getName();

        while (   (parentId.getKind() == TYPE)
               && (parentId.getType().getForm() == RECORD))
        {
            path = parentId.getName() + "$" + path;
            parentId = parentId.getSymtab().getOwner();
        }

        path = parentId.getName() + "$" + path;
        return path;
    }

    /**
     * Create the symbol table for a record type.
     * @param ctx the RecordFieldsContext,
     * @param ownerId the symbol table entry of the owner's identifier.
     * @return the symbol table.
     */
    private Symtab createRecordSymtab(cppParser.RecordFieldsContext ctx,
                                      SymtabEntry ownerId)
    {
        Symtab recordSymtab = symtabStack.push();

        recordSymtab.setOwner(ownerId);
        visit(ctx.variableDeclarationsList());
        recordSymtab.resetVariables(RECORD_FIELD);
        symtabStack.pop();

        return recordSymtab;
    }

    @Override
    public Object visitSimpleTypespec(cppParser.SimpleTypespecContext ctx)
    {
        visit(ctx.simpleType());
        ctx.type = ctx.simpleType().type;

        return null;
    }

    @Override
    public Object visitTypeIdentifierTypespec(
                                cppParser.TypeIdentifierTypespecContext ctx)
    {
        visit(ctx.typeIdentifier());
        ctx.type = ctx.typeIdentifier().type;

        return null;
    }

    @Override
    public Object visitTypeIdentifier(cppParser.TypeIdentifierContext ctx)
    {
        String typeName = ctx.IDENTIFIER().getText().toLowerCase();
        SymtabEntry typeId = symtabStack.lookup(typeName);

        if (typeId != null)
        {
            if (typeId.getKind() != TYPE)
            {
                error.flag(INVALID_TYPE, ctx);
                ctx.type = Predefined.intType;
            }
            else
            {
                ctx.type = typeId.getType();
            }

            typeId.appendLineNumber(ctx.start.getLine());
        }
        else
        {
            error.flag(UNDECLARED_IDENTIFIER, ctx);
            ctx.type = Predefined.intType;
        }

        ctx.entry = typeId;
        return null;
    }

    @Override
    public Object visitEnumerationTypespec(
                                    cppParser.EnumerationTypespecContext ctx)
    {
        Typespec enumType = new Typespec(ENUMERATION);
        ArrayList<SymtabEntry> constants = new ArrayList<>();
        int value = -1;

        // Loop over the enumeration constants.
        for (cppParser.EnumerationConstantContext constCtx :
                                    ctx.enumerationType().enumerationConstant())
        {
            cppParser.ConstantIdentifierContext constIdCtx =
                                                constCtx.constantIdentifier();
            String constantName = constIdCtx.IDENTIFIER().getText()
                                                         .toLowerCase();
            SymtabEntry constantId = symtabStack.lookupLocal(constantName);

            if (constantId == null)
            {
                constantId = symtabStack.enterLocal(constantName,
                                                    ENUMERATION_CONSTANT);
                constantId.setType(enumType);
                constantId.setValue(++value);

                constants.add(constantId);
            }
            else
            {
                error.flag(REDECLARED_IDENTIFIER, constCtx);
            }

            constIdCtx.entry = constantId;
            constIdCtx.type  = enumType;

            constantId.appendLineNumber(ctx.getStart().getLine());
        }

        enumType.setEnumerationConstants(constants);
        ctx.type = enumType;

        return null;
    }

    @Override
    public Object visitSubrangeTypespec(
                                    cppParser.SubrangeTypespecContext ctx)
    {
        Typespec type = new Typespec(SUBRANGE);
        cppParser.SubrangeTypeContext subCtx = ctx.subrangeType();
        cppParser.ConstantContext minCtx = subCtx.constant().get(0);
        cppParser.ConstantContext maxCtx = subCtx.constant().get(1);

        Object minObj = visit(minCtx);
        Object maxObj = visit(maxCtx);

        Typespec minType = minCtx.type;
        Typespec maxType = maxCtx.type;

        if (   (   (minType.getForm() != SCALAR)
                && (minType.getForm() != ENUMERATION))
            || (minType == Predefined.doubleType)
            || (minType == Predefined.stringType))
        {
            error.flag(INVALID_CONSTANT, minCtx);
            minType = Predefined.intType;
            minObj = 0;
        }

        int minValue;
        int maxValue;

        if (minType == Predefined.intType)
        {
            minValue = (Integer) minObj;
            maxValue = (Integer) maxObj;
        }
        else if (minType == Predefined.charType)
        {
            minValue = (Character) minObj;
            maxValue = (Character) maxObj;
        }
        else  // enumeration constants
        {
            minValue = (Integer) minCtx.value;
            maxValue = (Integer) maxCtx.value;
        }

        if ((maxType != minType) || (minValue > maxValue))
        {
            error.flag(INVALID_CONSTANT, maxCtx);
            maxType = minType;
            maxObj  = minObj;
        }

        type.setSubrangeBaseType(minType);
        type.setSubrangeMinValue((Integer) minValue);
        type.setSubrangeMaxValue((Integer) maxValue);

        ctx.type = type;
        return null;
    }

    @Override
    public Object visitArrayTypespec(cppParser.ArrayTypespecContext ctx)
    {
        Typespec arrayType = new Typespec(ARRAY);
        cppParser.ArrayTypeContext arrayCtx = ctx.arrayType();
        cppParser.ArrayDimensionListContext listCtx =
                                                arrayCtx.arrayDimensionList();

        ctx.type = arrayType;

        // Loop over the array dimensions.
        int count = listCtx.simpleType().size();
        for (int i = 0; i < count; i++)
        {
            cppParser.SimpleTypeContext simpleCtx =
                                                    listCtx.simpleType().get(i);
            visit(simpleCtx);
            arrayType.setArrayIndexType(simpleCtx.type);
            arrayType.setArrayElementCount(typeCount(simpleCtx.type));

            if (i < count-1)
            {
                Typespec elmtType = new Typespec(ARRAY);
                arrayType.setArrayElementType(elmtType);
                arrayType = elmtType;
            }
        }

        visit(arrayCtx.typeSpecification());
        Typespec elmtType = arrayCtx.typeSpecification().type;
        arrayType.setArrayElementType(elmtType);

        return null;
    }

    /**
     * Return the number of values in a datatype.
     * @param type the datatype.
     * @return the number of values.
     */
    private int typeCount(Typespec type)
    {
        int count = 0;

        if (type.getForm() == ENUMERATION)
        {
            ArrayList<SymtabEntry> constants = type.getEnumerationConstants();
            count = constants.size();
        }
        else  // subrange
        {
            int minValue = type.getSubrangeMinValue();
            int maxValue = type.getSubrangeMaxValue();
            count = maxValue - minValue + 1;
        }

        return count;
    }

    @Override
    public Object visitVariableDeclarations(
                                cppParser.VariableDeclarationsContext ctx)
    {
        cppParser.TypeSpecificationContext typeCtx = ctx.typeSpecification();
        visit(typeCtx);

        cppParser.VariableIdentifierListContext listCtx =
                                                ctx.variableIdentifierList();

        // Loop over the variables being declared.
        for (cppParser.VariableIdentifierContext idCtx :
                                                listCtx.variableIdentifier())
        {
            int lineNumber = idCtx.getStart().getLine();
            String variableName = idCtx.IDENTIFIER().getText().toLowerCase();
            SymtabEntry variableId = symtabStack.lookupLocal(variableName);

            if (variableId == null)
            {
                variableId = symtabStack.enterLocal(variableName, VARIABLE);
                variableId.setType(typeCtx.type);

                // Assign slot numbers to local variables.
                Symtab symtab = variableId.getSymtab();
                if (symtab.getNestingLevel() > 1)
                {
                    variableId.setSlotNumber(symtab.nextSlotNumber());
                }

                idCtx.entry = variableId;
            }
            else
            {
                error.flag(REDECLARED_IDENTIFIER, ctx);
            }

            variableId.appendLineNumber(lineNumber);
        }

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitRoutineDefinition(
                                    cppParser.RoutineDefinitionContext ctx)
    {
        cppParser.FunctionHeadContext  funcCtx = ctx.functionHead();
        cppParser.ProcedureHeadContext procCtx = ctx.procedureHead();
        cppParser.RoutineIdentifierContext idCtx = null;
        cppParser.ParametersContext parameters = null;
        boolean functionDefinition = funcCtx != null;
        Typespec returnType = null;
        String routineName;

        if (functionDefinition)
        {
            idCtx = funcCtx.routineIdentifier();
            parameters = funcCtx.parameters();
        }
        else
        {
            idCtx = procCtx.routineIdentifier();
            parameters = procCtx.parameters();
        }

        routineName = idCtx.IDENTIFIER().getText().toLowerCase();
        SymtabEntry routineId = symtabStack.lookupLocal(routineName);

        if (routineId != null)
        {
            error.flag(REDECLARED_IDENTIFIER,
                       ctx.getStart().getLine(), routineName);
            return null;
        }

        routineId = symtabStack.enterLocal(
                        routineName, functionDefinition ? FUNCTION : PROCEDURE);
        routineId.setRoutineCode(DECLARED);
        idCtx.entry = routineId;

        // Append to the parent routine's list of subroutines.
        SymtabEntry parentId = symtabStack.getLocalSymtab().getOwner();
        parentId.appendSubroutine(routineId);

        routineId.setRoutineSymtab(symtabStack.push());
        idCtx.entry = routineId;

        Symtab symtab = symtabStack.getLocalSymtab();
        symtab.setOwner(routineId);

        if (parameters != null)
        {
            ArrayList<SymtabEntry> parameterIds = (ArrayList<SymtabEntry>)
                                visit(parameters.parameterDeclarationsList());
            routineId.setRoutineParameters(parameterIds);

            for (SymtabEntry parmId : parameterIds)
            {
                parmId.setSlotNumber(symtab.nextSlotNumber());
            }
        }

        if (functionDefinition)
        {
            cppParser.TypeIdentifierContext typeIdCtx =
                                                    funcCtx.typeIdentifier();
            visit(typeIdCtx);
            returnType = typeIdCtx.type;

            if (returnType.getForm() != SCALAR)
            {
                error.flag(INVALID_RETURN_TYPE, typeIdCtx);
                returnType = Predefined.intType;
            }

            routineId.setType(returnType);
            idCtx.type = returnType;
        }
        else
        {
            idCtx.type = null;
        }

        if (ctx.variablesPart() != null) {
            visit(ctx.variablesPart());
        }

        // Enter the function's associated variable into its symbol table.
        if (functionDefinition)
        {
            SymtabEntry assocVarId =
                                symtabStack.enterLocal(routineName, VARIABLE);
            assocVarId.setSlotNumber(symtab.nextSlotNumber());
            assocVarId.setType(returnType);
        }

        if (ctx.statementList() != null) {
            visit(ctx.statementList());
            routineId.setExecutable(ctx.statementList());
        }

        if (functionDefinition) {
            visit(ctx.returnStatement());
        }

        symtabStack.pop();
        return null;
    }

    @Override
    public Object visitReturnStatement(cppParser.ReturnStatementContext ctx) {
        if (ctx.getParent() instanceof cppParser.RoutineDefinitionContext) {
            cppParser.RoutineDefinitionContext routCtx = (cppParser.RoutineDefinitionContext) ctx.getParent();
            String functionName = routCtx.functionHead().routineIdentifier().IDENTIFIER().getText().toLowerCase();
            SymtabEntry functionId = symtabStack.lookupLocal(functionName);

            visitChildren(ctx);

            Typespec funcType = functionId.getType();
            Typespec rhsType = ctx.rhs().expression().type;

            if (!TypeChecker.areAssignmentCompatible(funcType, rhsType))
            {
                error.flag(INCOMPATIBLE_ASSIGNMENT, ctx.rhs());
            }
        }

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitParameterDeclarationsList(
                            cppParser.ParameterDeclarationsListContext ctx)
    {
        ArrayList<SymtabEntry> parameterList = new ArrayList<>();

        // Loop over the parameter declarations.
        for (cppParser.ParameterDeclarationsContext dclCtx :
                                                    ctx.parameterDeclarations())
        {
            ArrayList<SymtabEntry> parameterSublist =
                                        (ArrayList<SymtabEntry>) visit(dclCtx);
            parameterList.addAll(parameterSublist);
        }

        return parameterList;
    }

    @Override
    public Object visitParameterDeclarations(
                                cppParser.ParameterDeclarationsContext ctx)
    {
        Kind kind = ctx.VAR() != null ? REFERENCE_PARAMETER : VALUE_PARAMETER;
        cppParser.TypeIdentifierContext typeCtx = ctx.typeIdentifier();

        visit(typeCtx);
        Typespec parmType = typeCtx.type;

        ArrayList<SymtabEntry> parameterSublist = new ArrayList<>();

        // Loop over the parameter identifiers.
        cppParser.ParameterIdentifierListContext parmListCtx =
                                                ctx.parameterIdentifierList();

            int lineNumber = parmListCtx.parameterIdentifier().getStart().getLine();
            String parmName = parmListCtx.parameterIdentifier().IDENTIFIER().getText().toLowerCase();
            SymtabEntry parmId = symtabStack.lookupLocal(parmName);

            if (parmId == null)
            {
                parmId = symtabStack.enterLocal(parmName, kind);
                parmId.setType(parmType);

                if (   (kind == REFERENCE_PARAMETER)
                    && (mode != EXECUTOR)
                    && (parmType.getForm() == SCALAR))
                {
                    error.flag(INVALID_REFERENCE_PARAMETER, parmListCtx.parameterIdentifier());
                }
            }
            else
            {
                error.flag(REDECLARED_IDENTIFIER, parmListCtx.parameterIdentifier());
            }

            parmListCtx.parameterIdentifier().entry = parmId;
            parmListCtx.parameterIdentifier().type  = parmType;

            parameterSublist.add(parmId);
            parmId.appendLineNumber(lineNumber);


        return parameterSublist;
    }

    @Override
    public Object visitAssignmentStatement(
                                    cppParser.AssignmentStatementContext ctx)
    {
        cppParser.LhsContext lhsCtx = ctx.lhs();
        cppParser.RhsContext rhsCtx = ctx.rhs();

        visitChildren(ctx);

        Typespec lhsType = lhsCtx.type;
        Typespec rhsType = rhsCtx.expression().type;

        if (!TypeChecker.areAssignmentCompatible(lhsType, rhsType))
        {
            error.flag(INCOMPATIBLE_ASSIGNMENT, rhsCtx);
        }

        return null;
    }

    @Override
    public Object visitLhs(cppParser.LhsContext ctx)
    {
        cppParser.VariableContext varCtx = ctx.variable();
        visit(varCtx);
        ctx.type = varCtx.type;

        return null;
    }

    @Override
    public Object visitIfStatement(cppParser.IfStatementContext ctx)
    {
        cppParser.ExpressionContext     exprCtx  = ctx.expression();
        cppParser.TrueStatementContext  trueCtx  = ctx.trueStatement();
        cppParser.FalseStatementContext falseCtx = ctx.falseStatement();

        visit(exprCtx);
        Typespec exprType = exprCtx.type;

        if (!TypeChecker.isBoolean(exprType))
        {
            error.flag(TYPE_MUST_BE_BOOLEAN, exprCtx);
        }

        visit(trueCtx);
        if (falseCtx != null) visit(falseCtx);

        return null;
    }

    @Override
    public Object visitWhileStatement(cppParser.WhileStatementContext ctx)
    {
        cppParser.ExpressionContext exprCtx = ctx.expression();
        visit(exprCtx);
        Typespec exprType = exprCtx.type;

        if (!TypeChecker.isBoolean(exprType))
        {
            error.flag(TYPE_MUST_BE_BOOLEAN, exprCtx);
        }

        visit(ctx.statement());
        return null;
    }

    @Override
    public Object visitForStatement(cppParser.ForStatementContext ctx)
    {
        cppParser.VariableContext varCtx = ctx.variable();
        visit(varCtx);

        String controlName = varCtx.variableIdentifier().getText().toLowerCase();
        Typespec controlType = Predefined.intType;

        if (varCtx.entry != null)
        {
            controlType = varCtx.type;

            if (   (controlType.getForm() != SCALAR )
                || (controlType == Predefined.doubleType)
                || (controlType == Predefined.stringType)
                || (varCtx.modifier().size() != 0))
            {
                error.flag(INVALID_CONTROL_VARIABLE, varCtx);
            }
        }
        else
        {
            error.flag(UNDECLARED_IDENTIFIER, ctx.getStart().getLine(),
                       controlName);
        }

        cppParser.ExpressionContext startCtx = ctx.expression().get(0);
        cppParser.ExpressionContext endCtx   = ctx.expression().get(1);

        visit(startCtx);
        visit(endCtx);

        if (startCtx.type != controlType) error.flag(TYPE_MISMATCH, startCtx);
        if (startCtx.type != endCtx.type) error.flag(TYPE_MISMATCH, endCtx);

        visit(ctx.statement());
        return null;
    }

    @Override
    public Object visitProcedureCallStatement(
                                cppParser.ProcedureCallStatementContext ctx)
    {
        cppParser.ProcedureNameContext nameCtx = ctx.procedureName();
        cppParser.ArgumentListContext listCtx = ctx.argumentList();
        String name = ctx.procedureName().getText().toLowerCase();
        SymtabEntry procedureId = symtabStack.lookup(name);
        boolean badName = false;

        if (procedureId == null)
        {
            error.flag(UNDECLARED_IDENTIFIER, nameCtx);
            badName = true;
        }
        else if (procedureId.getKind() != PROCEDURE)
        {
            error.flag(NAME_MUST_BE_PROCEDURE, nameCtx);
            badName = true;
        }

        // Bad procedure name. Do a simple arguments check and then leave.
        if (badName)
        {
            for (cppParser.ArgumentContext exprCtx : listCtx.argument())
            {
                visit(exprCtx);
            }
        }

        // Good procedure name.
        else
        {
            ArrayList<SymtabEntry> parms = procedureId.getRoutineParameters();
            checkCallArguments(listCtx, parms);
        }

        nameCtx.entry = procedureId;
        return null;
    }

    @Override
    public Object visitFunctionCallFactor(
                                    cppParser.FunctionCallFactorContext ctx)
    {
        cppParser.FunctionCallContext callCtx = ctx.functionCall();
        cppParser.FunctionNameContext nameCtx = callCtx.functionName();
        cppParser.ArgumentListContext listCtx = callCtx.argumentList();
        String name = callCtx.functionName().getText().toLowerCase();
        SymtabEntry functionId = symtabStack.lookup(name);
        boolean badName = false;

        ctx.type = Predefined.intType;

        if (functionId == null)
        {
            error.flag(UNDECLARED_IDENTIFIER, nameCtx);
            badName = true;
        }
        else if (functionId.getKind() != FUNCTION)
        {
            error.flag(NAME_MUST_BE_FUNCTION, nameCtx);
            badName = true;
        }

        // Bad function name. Do a simple arguments check and then leave.
        if (badName)
        {
            for (cppParser.ArgumentContext exprCtx : listCtx.argument())
            {
                visit(exprCtx);
            }
        }

        // Good function name.
        else
        {
            ArrayList<SymtabEntry> parameters = functionId.getRoutineParameters();
            checkCallArguments(listCtx, parameters);
            ctx.type = functionId.getType();
        }

        nameCtx.entry = functionId;
        nameCtx.type  = ctx.type;

        return null;
    }

    /**
     * Perform semantic operations on procedure and function call arguments.
     * @param listCtx the ArgumentListContext.
     * @param parameters the arraylist of parameters to fill.
     */
    private void checkCallArguments(cppParser.ArgumentListContext listCtx,
                                    ArrayList<SymtabEntry> parameters)
    {
        int parmsCount = parameters.size();
        int argsCount = listCtx != null ? listCtx.argument().size() : 0;

        if (parmsCount != argsCount)
        {
            error.flag(ARGUMENT_COUNT_MISMATCH, listCtx);
            return;
        }

        // Check each argument against the corresponding parameter.
        for (int i = 0; i < parmsCount; i++)
        {
            cppParser.ArgumentContext argCtx = listCtx.argument().get(i);
            cppParser.ExpressionContext exprCtx = argCtx.expression();
            visit(exprCtx);

            SymtabEntry parmId = parameters.get(i);
            Typespec parmType = parmId.getType();
            Typespec argType  = exprCtx.type;

            // For a VAR parameter, the argument must be a variable
            // with the same datatype.
            if (parmId.getKind() == REFERENCE_PARAMETER)
            {
                if (expressionIsVariable(exprCtx))
                {
                    if (parmType != argType)
                    {
                        error.flag(TYPE_MISMATCH, exprCtx);
                    }
                }
                else
                {
                    error.flag(ARGUMENT_MUST_BE_VARIABLE, exprCtx);
                }
            }

            // For a value parameter, the argument type must be
            // assignment compatible with the parameter type.
            else if (!TypeChecker.areAssignmentCompatible(parmType, argType))
            {
                error.flag(TYPE_MISMATCH, exprCtx);
            }
        }
    }

    /**
     * Determine whether or not an expression is a variable only.
     * @param exprCtx the ExpressionContext.
     * @return true if it's an expression only, else false.
     */
    private boolean expressionIsVariable(cppParser.ExpressionContext exprCtx)
    {
        // Only a single simple expression?
        if (exprCtx.simpleExpression().size() == 1)
        {
            cppParser.SimpleExpressionContext simpleCtx =
                                              exprCtx.simpleExpression().get(0);
            // Only a single term?
            if (simpleCtx.term().size() == 1)
            {
                cppParser.TermContext termCtx = simpleCtx.term().get(0);

                // Only a single factor?
                if (termCtx.factor().size() == 1)
                {
                    return termCtx.factor().get(0) instanceof
                                            cppParser.VariableFactorContext;
                }
            }
        }

        return false;
    }

    @Override
    public Object visitExpression(cppParser.ExpressionContext ctx)
    {
        cppParser.SimpleExpressionContext simpleCtx1 =
                                                ctx.simpleExpression().get(0);

        // First simple expression.
        visit(simpleCtx1);

        Typespec simpleType1 = simpleCtx1.type;
        ctx.type = simpleType1;

        cppParser.RelOpContext relOpCtx = ctx.relOp();

        // Second simple expression?
        if (relOpCtx != null)
        {
            cppParser.SimpleExpressionContext simpleCtx2 =
                                                ctx.simpleExpression().get(1);
            visit(simpleCtx2);

            Typespec simpleType2 = simpleCtx2.type;
            if (!TypeChecker.areComparisonCompatible(simpleType1, simpleType2))
            {
                error.flag(INCOMPATIBLE_COMPARISON, ctx);
            }

            ctx.type = Predefined.booleanType;
        }

        return null;
    }

    @Override
    public Object visitSimpleExpression(cppParser.SimpleExpressionContext ctx)
    {
        int count = ctx.term().size();
        cppParser.SignContext signCtx = ctx.sign();
        Boolean hasSign = signCtx != null;
        cppParser.TermContext termCtx1 = ctx.term().get(0);

        if (hasSign)
        {
            String sign = signCtx.getText();
            if (sign.equals("+") && sign.equals("-"))
            {
                error.flag(INVALID_SIGN, signCtx);
            }
        }

        // First term.
        visit(termCtx1);
        Typespec termType1 = termCtx1.type;

        // Loop over any subsequent terms.
        for (int i = 1; i < count; i++)
        {
            String op = ctx.addOp().get(i-1).getText().toLowerCase();
            cppParser.TermContext termCtx2 = ctx.term().get(i);
            visit(termCtx2);
            Typespec termType2 = termCtx2.type;

            // Both operands boolean ==> boolean result. Else type mismatch.
            if (op.equals("or"))
            {
                if (!TypeChecker.isBoolean(termType1))
                {
                    error.flag(TYPE_MUST_BE_BOOLEAN, termCtx1);
                }
                if (!TypeChecker.isBoolean(termType2))
                {
                    error.flag(TYPE_MUST_BE_BOOLEAN, termCtx2);
                }
                if (hasSign)
                {
                    error.flag(INVALID_SIGN, signCtx);
                }

                termType2 = Predefined.booleanType;
            }
            else if (op.equals("+"))
            {
                // Both operands integer ==> integer result
                if (TypeChecker.areBothInteger(termType1, termType2))
                {
                    termType2 = Predefined.intType;
                }

                // Both real operands ==> real result
                // One real and one integer operand ==> real result
                else if (TypeChecker.isAtLeastOneReal(termType1, termType2))
                {
                    termType2 = Predefined.doubleType;
                }

                // Both operands string ==> string result
                else if (TypeChecker.areBothString(termType1, termType2))
                {
                    if (hasSign) error.flag(INVALID_SIGN, signCtx);
                    termType2 = Predefined.stringType;
                }

                // Type mismatch.
                else
                {
                    if (!TypeChecker.isIntegerOrReal(termType1))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, termCtx1);
                        termType2 = Predefined.intType;
                    }
                    if (!TypeChecker.isIntegerOrReal(termType2))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, termCtx2);
                        termType2 = Predefined.intType;
                    }
                }
            }
            else  // -
            {
                // Both operands integer ==> integer result
                if (TypeChecker.areBothInteger(termType1, termType2))
                {
                    termType2 = Predefined.intType;
                }

                // Both real operands ==> real result
                // One real and one integer operand ==> real result
                else if (TypeChecker.isAtLeastOneReal(termType1, termType2))
                {
                    termType2 = Predefined.doubleType;
                }

                // Type mismatch.
                else
                {
                    if (!TypeChecker.isIntegerOrReal(termType1))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, termCtx1);
                        termType2 = Predefined.intType;
                    }
                    if (!TypeChecker.isIntegerOrReal(termType2))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, termCtx2);
                        termType2 = Predefined.intType;
                    }
                }
            }

            termType1 = termType2;
        }

        ctx.type = termType1;
        return null;
    }

    @Override
    public Object visitTerm(cppParser.TermContext ctx)
    {
        int count = ctx.factor().size();
        cppParser.FactorContext factorCtx1 = ctx.factor().get(0);

        // First factor.
        visit(factorCtx1);
        Typespec factorType1 = factorCtx1.type;

        // Loop over any subsequent factors.
        for (int i = 1; i < count; i++)
        {
            String op = ctx.mulOp().get(i-1).getText().toLowerCase();
            cppParser.FactorContext factorCtx2 = ctx.factor().get(i);
            visit(factorCtx2);
            Typespec factorType2 = factorCtx2.type;

            if (op.equals("*"))
            {
                // Both operands integer  ==> integer result
                if (TypeChecker.areBothInteger(factorType1, factorType2))
                {
                    factorType2 = Predefined.intType;
                }

                // Both real operands ==> real result
                // One real and one integer operand ==> real result
                else if (TypeChecker.isAtLeastOneReal(factorType1, factorType2))
                {
                    factorType2 = Predefined.doubleType;
                }

                // Type mismatch.
                else
                {
                    if (!TypeChecker.isIntegerOrReal(factorType1))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, factorCtx1);
                        factorType2 = Predefined.intType;
                    }
                    if (!TypeChecker.isIntegerOrReal(factorType2))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, factorCtx2);
                        factorType2 = Predefined.intType;
                    }
                }
            }
            else if (op.equals("/"))
            {
                // All integer and real operand combinations ==> real result
                if (   TypeChecker.areBothInteger(factorType1, factorType2)
                    || TypeChecker.isAtLeastOneReal(factorType1, factorType2))
                {
                    factorType2 = Predefined.doubleType;
                }

                // Type mismatch.
                else
                {
                    if (!TypeChecker.isIntegerOrReal(factorType1))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, factorCtx1);
                        factorType2 = Predefined.intType;
                    }
                    if (!TypeChecker.isIntegerOrReal(factorType2))
                    {
                        error.flag(TYPE_MUST_BE_NUMERIC, factorCtx2);
                        factorType2 = Predefined.intType;
                    }
                }
            }
            else if (op.equals("div") || op.equals("mod"))
            {
                // Both operands integer ==> integer result. Else type mismatch.
                if (!TypeChecker.isInteger(factorType1))
                {
                    error.flag(TYPE_MUST_BE_INTEGER, factorCtx1);
                    factorType2 = Predefined.intType;
                }
                if (!TypeChecker.isInteger(factorType2))
                {
                    error.flag(TYPE_MUST_BE_INTEGER, factorCtx2);
                    factorType2 = Predefined.intType;
                }
            }
            else if (op.equals("and"))
            {
                // Both operands boolean ==> boolean result. Else type mismatch.
                if (!TypeChecker.isBoolean(factorType1))
                {
                    error.flag(TYPE_MUST_BE_BOOLEAN, factorCtx1);
                    factorType2 = Predefined.booleanType;
                }
                if (!TypeChecker.isBoolean(factorType2))
                {
                    error.flag(TYPE_MUST_BE_BOOLEAN, factorCtx2);
                    factorType2 = Predefined.booleanType;
                }
            }

            factorType1 = factorType2;
        }

        ctx.type = factorType1;
        return null;
    }

    @Override
    public Object visitVariableFactor(cppParser.VariableFactorContext ctx)
    {
        cppParser.VariableContext varCtx = ctx.variable();
        visit(varCtx);
        ctx.type  = varCtx.type;

        return null;
    }

    @Override
    public Object visitVariable(cppParser.VariableContext ctx)
    {
        cppParser.VariableIdentifierContext varIdCtx =
                                                    ctx.variableIdentifier();

        visit(varIdCtx);
        ctx.entry = varIdCtx.entry;
        ctx.type  = variableDatatype(ctx, varIdCtx.type);

        return null;
    }

    @Override
    public Object visitVariableIdentifier(
                                    cppParser.VariableIdentifierContext ctx)
    {
        String variableName = ctx.IDENTIFIER().getText().toLowerCase();
        SymtabEntry variableId = symtabStack.lookup(variableName);

        if (variableId != null)
        {
            int lineNumber = ctx.getStart().getLine();
            ctx.type = variableId.getType();
            ctx.entry = variableId;
            variableId.appendLineNumber(lineNumber);

            Kind kind = variableId.getKind();
            switch (kind)
            {
                case TYPE:
                case PROGRAM:
                case PROGRAM_PARAMETER:
                case PROCEDURE:
                case UNDEFINED:
                    error.flag(INVALID_VARIABLE, ctx);
                    break;

                default: break;
            }
        }
        else
        {
            error.flag(UNDECLARED_IDENTIFIER, ctx);
            ctx.type = Predefined.intType;
        }

        return null;
    }

    /**
     * Determine the datatype of a variable that can have modifiers.
     * @param varCtx the VariableContext.
     * @param varType the variable's datatype without the modifiers.
     * @return the datatype with any modifiers.
     */
    private Typespec variableDatatype(
                        cppParser.VariableContext varCtx, Typespec varType)
    {
        Typespec type = varType;

        // Loop over the modifiers.
        for (cppParser.ModifierContext modCtx : varCtx.modifier())
        {
            // Subscripts.
            if (modCtx.indexList() != null)
            {
                cppParser.IndexListContext indexListCtx = modCtx.indexList();

                // Loop over the subscripts.
                for (cppParser.IndexContext indexCtx : indexListCtx.index())
                {
                    if (type.getForm() == ARRAY)
                    {
                        Typespec indexType = type.getArrayIndexType();
                        cppParser.ExpressionContext exprCtx =
                                                        indexCtx.expression();
                        visit(exprCtx);

                        if (indexType.baseType() != exprCtx.type.baseType())
                        {
                            error.flag(TYPE_MISMATCH, exprCtx);
                        }

                        // Datatype of the next dimension.
                        type = type.getArrayElementType();
                    }
                    else
                    {
                        error.flag(TOO_MANY_SUBSCRIPTS, indexCtx);
                    }
                }
            }
            else  // Record field.
            {
                if (type.getForm() == RECORD)
                {
                    Symtab symtab = type.getRecordSymtab();
                    cppParser.FieldContext fieldCtx = modCtx.field();
                    String fieldName =
                                fieldCtx.IDENTIFIER().getText().toLowerCase();
                    SymtabEntry fieldId = symtab.lookup(fieldName);

                    // Field of the record type?
                    if (fieldId != null)
                    {
                        type = fieldId.getType();
                        fieldCtx.entry = fieldId;
                        fieldCtx.type = type;
                        fieldId.appendLineNumber(modCtx.getStart().getLine());
                    }
                    else
                    {
                        error.flag(INVALID_FIELD, modCtx);
                    }
                }

                // Not a record variable.
                else
                {
                    error.flag(INVALID_FIELD, modCtx);
                }
            }
        }

        return type;
    }

    @Override
    public Object visitNumberFactor(cppParser.NumberFactorContext ctx)
    {
        cppParser.NumberContext          numberCtx   = ctx.number();
        cppParser.UnsignedNumberContext  unsignedCtx = numberCtx.unsignedNumber();
        cppParser.IntConstantContext     intCtx  = unsignedCtx.intConstant();

        ctx.type = (intCtx != null) ? Predefined.intType
                                        : Predefined.doubleType;

        return null;
    }

    @Override
    public Object visitCharacterFactor(
                                    cppParser.CharacterFactorContext ctx)
    {
        ctx.type = Predefined.charType;
        return null;
    }

    @Override
    public Object visitStringFactor(cppParser.StringFactorContext ctx)
    {
        ctx.type = Predefined.stringType;
        return null;
    }

    @Override
    public Object visitNotFactor(cppParser.NotFactorContext ctx)
    {
        cppParser.FactorContext factorCtx = ctx.factor();
        visit(factorCtx);

        if (factorCtx.type != Predefined.booleanType)
        {
            error.flag(TYPE_MUST_BE_BOOLEAN, factorCtx);
        }

        ctx.type = Predefined.booleanType;
        return null;
    }

    @Override
    public Object visitParenthesizedFactor(
                                    cppParser.ParenthesizedFactorContext ctx)
    {
        cppParser.ExpressionContext exprCtx = ctx.expression();
        visit(exprCtx);
        ctx.type = exprCtx.type;

        return null;
    }
}
