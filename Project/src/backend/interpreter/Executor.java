package backend.interpreter;

import antlr4.cppBaseVisitor;
import antlr4.cppParser;
import intermediate.symtab.Predefined;
import intermediate.symtab.SymtabEntry;
import intermediate.symtab.SymtabEntry.Kind;
import intermediate.type.Typespec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static backend.interpreter.RuntimeErrorHandler.Code.DIVISION_BY_ZERO;
import static intermediate.symtab.SymtabEntry.Kind.*;
import static intermediate.type.Typespec.Form.SUBRANGE;

/**
 * Execute cpp programs.
 */
public class Executor extends cppBaseVisitor<Object>
{
    private int executionCount = 0;     // count of executed statements
    private SymtabEntry programId;      // program identifier's symbol table entry
    private RuntimeStack runtimeStack;  // runtime stack
    private Scanner sysin;              // runtime input
    private RuntimeErrorHandler error;  // runtime error handler

    public Executor(SymtabEntry programId)
    {
        this.programId = programId;
        runtimeStack = new RuntimeStack();
        sysin = new Scanner(System.in);
        error = new RuntimeErrorHandler();
    }

    @Override
    public Object visitProgram(cppParser.ProgramContext ctx)
    {
        long startTime = System.currentTimeMillis();

        StackFrame programFrame = new StackFrame(programId);
        runtimeStack.push(programFrame);

        visit(ctx.block().intMain().compoundStatement());

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.printf("\n%,20d statements executed." +
                          "\n%,20d runtime errors." +
                          "\n%,20d milliseconds execution time.\n",
                          executionCount, error.getCount(), elapsedTime);

        return null;
    }

    @Override
    public Object visitStatement(cppParser.StatementContext ctx)
    {
        executionCount++;
        visitChildren(ctx);

        return null;
    }

    @Override
    public Object visitAssignmentStatement(
                                    cppParser.AssignmentStatementContext ctx)
    {
        cppParser.ExpressionContext exprCtx = ctx.rhs().expression();
        Object value = visit(exprCtx);
        assignValue(ctx.lhs().variable(), value, exprCtx.type);

        return null;
    }

    /**
     * Assign a value to a target variable's memory cell.
     * @param varCtx the VariableContext of the target.
     * @param value the value to assign.
     * @param valueType the datatype of the value.
     * @return the target variable's memory cell.
     */
    private Cell assignValue(cppParser.VariableContext varCtx,
                             Object value, Typespec valueType)
    {
        Typespec targetType = varCtx.type;
        Cell targetCell = (Cell) visit(varCtx);

        assignValue(targetCell, targetType, value, valueType);

        return targetCell;
    }

    /**
     * Assign a value to a target variable's memory cell.
     * @param targetCell the target variable's memory cell.
     * @param targetType the datatype of the target variable.
     * @param value the value to assign.
     * @param valueType the datatype of the value.
     */
    private void assignValue(Cell targetCell, Typespec targetType,
                             Object value, Typespec valueType)
    {
        // Assign with any necessary type conversions.
        if (   (targetType == Predefined.integerType)
            && (valueType  == Predefined.charType))
        {
            int charValue = (Character) value;
            targetCell.setValue(charValue);
        }
        else if (targetType == Predefined.realType)
        {
            double doubleValue =
                    (valueType == Predefined.integerType) ? (Integer)   value
                  : (valueType == Predefined.charType)    ? (Character) value
                  :                                         (Double)    value;
            targetCell.setValue(doubleValue);
        }
        else
        {
            targetCell.setValue(value);
        }
    }

    @Override
    public Object visitIfStatement(cppParser.IfStatementContext ctx) {
        cppParser.TrueStatementContext trueCtx = ctx.trueStatement();
        cppParser.FalseStatementContext falseCtx = ctx.falseStatement();
        boolean value = (Boolean) visit(ctx.expression());

        if (value) visit(trueCtx);
        else if (falseCtx != null) visit(falseCtx);

        return null;
    }

    @Override
    public Object visitWhileStatement(cppParser.WhileStatementContext ctx)
    {
        cppParser.StatementContext stmtCtx = ctx.statement();
        boolean value = (Boolean) visit(ctx.expression());

        while (value)
        {
            visit(stmtCtx);
            value = (Boolean) visit(ctx.expression());
        }

        return null;
    }

    @Override
    public Object visitForStatement(cppParser.ForStatementContext ctx)
    {
        cppParser.VariableContext   controlCtx   = ctx.variable();
        cppParser.ExpressionContext startExprCtx = ctx.expression().get(0);
        cppParser.ExpressionContext stopExprCtx  = ctx.expression().get(1);

        // Initial control value.
        Object startValue = visit(startExprCtx);
        assignValue(controlCtx, startValue, startExprCtx.type);

        // Terminal control value.
        boolean to = ctx.TO() != null;
        Object stopValue = visit(stopExprCtx);

        // Integer control values.
        if (controlCtx.type.baseType() == Predefined.integerType)
        {
            int control = (Integer) startValue;
            int stop    = (Integer) stopValue;

            if (to)
            {
                while (control <= stop)
                {
                    visit(ctx.statement());
                    Object nextValue = ++control;
                    assignValue(controlCtx, nextValue, Predefined.integerType);
                }
            }
            else  // downto
            {
                while (control >= stop)
                {
                    visit(ctx.statement());
                    Object nextValue = --control;
                    assignValue(controlCtx, nextValue, Predefined.integerType);
                }
            }
        }

        // Character control values.
        else
        {
            char control = (Character) startValue;
            char stop    = (Character) stopValue;

            if (to)
            {
                while (control <= stop)
                {
                    visit(ctx.statement());
                    Object nextValue = ++control;
                    assignValue(controlCtx, nextValue, Predefined.charType);
                }
            }
            else  // downto
            {
                while (control >= stop)
                {
                    visit(ctx.statement());
                    Object nextValue = --control;
                    assignValue(controlCtx, nextValue, Predefined.charType);
                }
            }
        }

        return null;
    }

    @Override
    public Object visitProcedureCallStatement(
                                cppParser.ProcedureCallStatementContext ctx)
    {
        SymtabEntry routineId = ctx.procedureName().entry;
        cppParser.ArgumentListContext argListCtx = ctx.argumentList();
        StackFrame newFrame = new StackFrame(routineId);

        // Execute any actual parameters and initialize
        // the formal parameters in the routine's new stack frame.
        if (argListCtx != null)
        {
            ArrayList<SymtabEntry> parameters = routineId.getRoutineParameters();
            executeCallArguments(argListCtx, parameters, newFrame);
        }

        // Push the routine's stack frame onto the runtime stack
        // and execute the procedure.
        runtimeStack.push(newFrame);

        // Execute the routine.
        cppParser.CompoundStatementContext stmtCtx =
            (cppParser.CompoundStatementContext) routineId.getExecutable();
        visit(stmtCtx);

        // Pop off the routine's stack frame.
        runtimeStack.pop();

        return null;
    }

    /**
     * Execute procedure and function call arguments.
     * @param argListCtx the ArgumentListContext
     * @param parameters the routine's parameters.
     * @param frame the routine's stack frame.
     */
    private void executeCallArguments(cppParser.ArgumentListContext argListCtx,
                                     ArrayList<SymtabEntry> parameters,
                                     StackFrame frame)
    {
        // Loop over the parameters.
        for (int i = 0; i < parameters.size(); i++)
        {
            SymtabEntry parmId = parameters.get(i);
            String parmName = parmId.getName();
            Kind parmKind = parmId.getKind();
            Cell parmCell = frame.getCell(parmName);
            cppParser.ArgumentContext argCtx = argListCtx.argument().get(i);
            Object value = visit(argCtx);

            // Value parameter: Copy the argument's value.
            if (parmKind == VALUE_PARAMETER)
            {
                assignValue(parmCell, parmId.getType(),
                            value, argCtx.expression().type);
            }

            // Reference parameter: Copy the argument's cell.
            else
            {
                cppParser.FactorContext factorCtx =
                        argCtx.expression().simpleExpression().get(0)
                              .term().get(0).factor().get(0);
                cppParser.VariableContext varCtx =
                    ((cppParser.VariableFactorContext) factorCtx).variable();

                Cell argCell = (Cell) visitVariable(varCtx);
                frame.replaceCell(parmName, argCell);
            }
        }
    }

    @Override
    public Object visitExpression(cppParser.ExpressionContext ctx)
    {
        cppParser.SimpleExpressionContext simpleCtx1 =
                                                ctx.simpleExpression().get(0);
        cppParser.RelOpContext relOpCtx = ctx.relOp();
        Object operand1 = visit(simpleCtx1);
        Typespec type1 = simpleCtx1.type;

        // More than one simple expression?
        if (relOpCtx != null)
        {
            String op = relOpCtx.getText();
            cppParser.SimpleExpressionContext simpleCtx2 =
                                                ctx.simpleExpression().get(1);
            Object operand2 = visit(simpleCtx2);
            Typespec type2 = simpleCtx2.type;

            boolean integerMode   = false;
            boolean realMode      = false;
            boolean characterMode = false;

            if (   (type1 == Predefined.integerType)
                && (type2 == Predefined.integerType))
            {
                integerMode = true;
            }
            else if (   (type1 == Predefined.realType)
                     || (type2 == Predefined.realType))
            {
                realMode = true;
            }
            else if (   (type1 == Predefined.charType)
                     && (type2 == Predefined.charType))
            {
                characterMode = true;
            }

            if (integerMode || characterMode)
            {
                int value1 = type1 == Predefined.integerType
                        ? (Integer) operand1 : (Character) operand1;
                int value2 = type2 == Predefined.integerType
                        ? (Integer) operand2 : (Character) operand2;
                Boolean result = false;

                if      (op.equals("=" )) result = value1 == value2;
                else if (op.equals("<>")) result = value1 != value2;
                else if (op.equals("<" )) result = value1 <  value2;
                else if (op.equals("<=")) result = value1 <= value2;
                else if (op.equals(">" )) result = value1 >  value2;
                else if (op.equals(">=")) result = value1 >= value2;

                return result;
            }
            else if (realMode)
            {
                double value1 = type1 == Predefined.integerType
                        ? (Integer) operand1 : (Double) operand1;
                double value2 = type2 == Predefined.integerType
                        ? (Integer) operand2 : (Double) operand2;
                Boolean result = false;

                if      (op.equals("=" )) result = value1 == value2;
                else if (op.equals("<>")) result = value1 != value2;
                else if (op.equals("<" )) result = value1 <  value2;
                else if (op.equals("<=")) result = value1 <= value2;
                else if (op.equals(">" )) result = value1 >  value2;
                else if (op.equals(">=")) result = value1 >= value2;

                return result;
            }
            else  // stringMode)
            {
                String value1 = (String) operand1;
                String value2 = (String) operand2;
                Boolean result = false;
                int comp = value1.compareTo(value2);

                if      (op.equals("=" )) result = comp == 0;
                else if (op.equals("<>")) result = comp != 0;
                else if (op.equals("<" )) result = comp <  0;
                else if (op.equals("<=")) result = comp <= 0;
                else if (op.equals(">" )) result = comp >  0;
                else if (op.equals(">=")) result = comp >= 0;

                return result;
            }
        }

        return operand1;
    }

    @Override
    public Object visitSimpleExpression(cppParser.SimpleExpressionContext ctx)
    {
        int count = ctx.term().size();
        Boolean negate =    (ctx.sign() != null)
                         && ctx.sign().getText().equals("-");

        // First term.
        cppParser.TermContext termCtx1 = ctx.term().get(0);
        Object operand1 = visit(termCtx1);
        Typespec type1 = termCtx1.type;

        if (negate)
        {
            if (type1 == Predefined.integerType)
            {
                operand1 = -((Integer) operand1);
            }
            else if (type1 == Predefined.realType)
            {
                operand1 = -((Double) operand1);
            }
        }

        // Loop over the subsequent terms.
        for (int i = 1; i < count; i++)
        {
            String op = ctx.addOp().get(i-1).getText().toLowerCase();
            cppParser.TermContext termCtx2 = ctx.term().get(i);
            Object operand2 = visit(termCtx2);
            Typespec type2 = termCtx2.type;

            boolean integerMode = false;
            boolean realMode    = false;
            boolean booleanMode = false;

            if (   (type1 == Predefined.integerType)
                && (type2 == Predefined.integerType))
            {
                integerMode = true;
            }
            else if (   (type1 == Predefined.realType)
                     || (type2 == Predefined.realType))
            {
                realMode = true;
            }
            else if (   (type1 == Predefined.booleanType)
                     && (type2 == Predefined.booleanType))
            {
                booleanMode = true;
            }

            if (integerMode)
            {
                int value1 = (Integer) operand1;
                int value2 = (Integer) operand2;
                operand1 = (op.equals("+")) ? value1 + value2
                                            : value1 - value2;
            }
            else if (realMode)
            {
                double value1 = type1 == Predefined.integerType
                              ? (Integer) operand1 : (Double) operand1;
                double value2 = type2 == Predefined.integerType
                              ? (Integer) operand2 : (Double) operand2;
                operand1 = (op.equals("+")) ? value1 + value2
                                            : value1 - value2;
            }
            else if (booleanMode)
            {
                operand1 = ((Boolean) operand1) || ((Boolean) operand2);
            }
            else  // stringMode
            {
                operand1 = ((String) operand1) + ((String) operand2);
            }
        }

        return operand1;
    }

    @Override
    public Object visitTerm(cppParser.TermContext ctx)
    {
        int count = ctx.factor().size();

        // First factor.
        cppParser.FactorContext factorCtx1 = ctx.factor().get(0);
        Object operand1 = visit(factorCtx1);
        Typespec type1 = factorCtx1.type;

        // Loop over the subsequent factors.
        for (int i = 1; i < count; i++)
        {
            String op = ctx.mulOp().get(i-1).getText().toLowerCase();
            cppParser.FactorContext factorCtx2 = ctx.factor().get(i);
            Object operand2 = visit(factorCtx2);
            Typespec type2 = factorCtx2.type;

            boolean integerMode = false;
            boolean realMode    = false;

            if (   (type1 == Predefined.integerType)
                && (type2 == Predefined.integerType))
            {
                integerMode = true;
            }
            else if (   (type1 == Predefined.realType)
                     || (type2 == Predefined.realType))
            {
                realMode = true;
            }

            if (integerMode)
            {
                int value1 = (Integer) operand1;
                int value2 = (Integer) operand2;

                if (op.equals("*")) operand1 = value1*value2;

                else if (op.equals("div") || op.equals("/") || op.equals("mod"))
                {
                    // Check for division by zero.
                    if (value2 == 0)
                    {
                        error.flag(DIVISION_BY_ZERO, factorCtx2);
                        operand1 = 0;
                    }

                    if (op.equals("div"))
                    {
                        operand1 = value1/value2;
                    }
                    else if (op.equals("/"))
                    {
                        double doubleValue = value1;
                        operand1 = doubleValue/value2;
                    }
                    else  // mod
                    {
                        operand1 = value1 % value2;
                    }
                }
            }
            else if (realMode)
            {
                double value1 = type1 == Predefined.integerType
                        ? (Integer) operand1 : (Double) operand1;
                double value2 = type2 == Predefined.integerType
                        ? (Integer) operand2 : (Double) operand2;

                if (op.equals("*")) operand1 = value1*value2;

                else if (op.equals("/"))
                {
                    // Check for division by zero.
                    if (value2 == 0)
                    {
                        error.flag(DIVISION_BY_ZERO, factorCtx2);
                        operand1 = 0;
                    }
                    else operand1 = value1/value2;
                }
            }
            else  // booleanMode
            {
                operand1 = ((Boolean) operand1) && ((Boolean) operand2);
            }
        }

        return operand1;
    }

    @Override
    public Object visitVariableFactor(cppParser.VariableFactorContext ctx)
    {
        cppParser.VariableContext varCtx = ctx.variable();
        Kind kind = varCtx.entry.getKind();

        // Obtain a constant's value from its symbol table entry.
        if ((kind == CONSTANT) || (kind == ENUMERATION_CONSTANT))
        {
            Object value = varCtx.entry.getValue();

            if (varCtx.type == Predefined.booleanType)
            {
                value = (Integer) value != 0;
            }

            return value;
        }

        // Obtain a variable's value from its memory cell.
        else
        {
            Cell variableCell = (Cell) visit(varCtx);
            return variableCell.getValue();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitVariable(cppParser.VariableContext ctx)
    {
        SymtabEntry variableId = ctx.entry;
        String variableName = variableId.getName();
        Typespec variableType = variableId.getType();
        int nestingLevel = variableId.getSymtab().getNestingLevel();

        // Get the variable reference from the appropriate activation record.
        StackFrame frame = runtimeStack.getTopmost(nestingLevel);
        Cell variableCell = frame.getCell(variableName);

        // Execute any array subscripts or record fields.
        for (cppParser.ModifierContext modCtx : ctx.modifier())
        {
            // Subscripts.
            if (modCtx.indexList() != null)
            {
                // Compute a new reference for each subscript.
                for (cppParser.IndexContext indexCtx :
                                                    modCtx.indexList().index())
                {
                    Typespec indexType = variableType.getArrayIndexType();
                    int minIndex = 0;

                    if (indexType.getForm() == SUBRANGE)
                    {
                        minIndex = indexType.getSubrangeMinValue();
                    }

                    int value = (Integer) visit(indexCtx.expression());
                    int index = value - minIndex;

                    variableCell = ((Cell[]) variableCell.getValue())[index];
                    variableType = variableType.getArrayElementType();
                }
            }

            // Record field.
            else
            {
                SymtabEntry fieldId = modCtx.field().entry;
                String fieldName = fieldId.getName();

                // Compute a new reference for the field.
                HashMap<String, Cell> map =
                                (HashMap<String, Cell>) variableCell.getValue();
                variableCell = map.get(fieldName);
                variableType = fieldId.getType();
            }
        }

        return variableCell;
    }

    @Override
    public Object visitNumberFactor(cppParser.NumberFactorContext ctx)
    {
        Typespec type = ctx.type;

        if (type == Predefined.integerType)
        {
            return Integer.parseInt(ctx.getText());
        }
        else  // double
        {
            return Double.parseDouble(ctx.getText());
        }
    }

    @Override
    public Object visitCharacterFactor(cppParser.CharacterFactorContext ctx)
    {
        return ctx.getText().charAt(1);
    }

    @Override
    public Object visitStringFactor(cppParser.StringFactorContext ctx)
    {
        String cppString = ctx.stringConstant().STRING().getText();
        return convertString(cppString);
    }

    /**
     * Convert a cpp string to a Java string.
     * @param cppString the cpp string.
     * @return the Java string.
     */
    private String convertString(String cppString)
    {
        String unquoted = cppString.substring(1, cppString.length()-1);
        return unquoted.replace("''", "'");
    }

    @Override
    public Object visitFunctionCallFactor(
                                    cppParser.FunctionCallFactorContext ctx)
    {
        cppParser.FunctionCallContext callCtx = ctx.functionCall();
        SymtabEntry routineId = callCtx.functionName().entry;
        cppParser.ArgumentListContext argListCtx = callCtx.argumentList();
        StackFrame newFrame = new StackFrame(routineId);

        // Execute any call arguments and initialize
        // the parameters in the routine's new stack frame.
        if (argListCtx != null)
        {
            ArrayList<SymtabEntry> parms = routineId.getRoutineParameters();
            executeCallArguments(argListCtx, parms, newFrame);
        }

        // Push the routine's stack frame onto the runtime stack
        // and execute the procedure.
        runtimeStack.push(newFrame);

        // Execute the routine.
        cppParser.CompoundStatementContext stmtCtx =
            (cppParser.CompoundStatementContext) routineId.getExecutable();
        visit(stmtCtx);

        // Get the function value from its associated variable.
        String functionName = routineId.getName();
        Cell valueCell = newFrame.getCell(functionName);
        Object functionValue = valueCell.getValue();

        // Pop off the routine's stack frame.
        runtimeStack.pop();

        return functionValue;
    }

    @Override
    public Object visitNotFactor(cppParser.NotFactorContext ctx)
    {
        boolean value = (boolean) visit(ctx.factor());
        return !value;
    }

    @Override
    public Object visitParenthesizedFactor(
                                    cppParser.ParenthesizedFactorContext ctx)
    {
        return visit(ctx.expression());
    }

    @Override
    public Object visitWritelnStatement(cppParser.WritelnStatementContext ctx)
    {
        visitChildren(ctx);
        System.out.println();

        return null;
    }

    @Override
    public Object visitWriteArguments(cppParser.WriteArgumentsContext ctx)
    {
        // Loop over each argument.
        for (cppParser.WriteArgumentContext argCtx : ctx.writeArgument())
        {
            Typespec type = argCtx.expression().type;
            String argText = argCtx.getText();

            // Print any literal strings.
            if (argText.charAt(0) == '\'')
            {
                System.out.print(convertString(argText));
            }

            // For any other expression, print its value with a format specifier.
            else
            {
                Object value = visit(argCtx.expression());
                StringBuffer format = new StringBuffer("%");

                // Create the format string.
                cppParser.FieldWidthContext fwCtx = argCtx.fieldWidth();
                if (fwCtx != null)
                {
                    String sign = (   (fwCtx.sign() != null)
                                   && (fwCtx.sign().getText().equals("-")))
                                ? "-" : "";
                    format.append(sign)
                          .append(fwCtx.integerConstant().getText());

                    cppParser.DecimalPlacesContext dpCtx =
                                                        fwCtx.decimalPlaces();
                    if (dpCtx != null)
                    {
                        format.append(".")
                              .append(dpCtx.integerConstant().getText());
                    }
                }

                // Use the format string with printf.
                if (type == Predefined.integerType)
                {
                    format.append("d");
                    System.out.printf(format.toString(), (int) value);
                }
                else if (type == Predefined.realType)
                {
                    format.append("f");
                    System.out.printf(format.toString(), (double) value);
                }
                else if (type == Predefined.booleanType)
                {
                    format.append("b");
                    System.out.printf(format.toString(), (boolean) value);
                }
                else if (type == Predefined.charType)
                {
                    format.append("c");
                    System.out.printf(format.toString(), (char) value);
                }
                else  // string
                {
                    format.append("s");
                    System.out.printf(format.toString(), (String) value);
                }
            }
        }

        return null;
    }

    @Override
    public Object visitReadlnStatement(cppParser.ReadlnStatementContext ctx)
    {
        visitChildren(ctx);
        sysin.nextLine();

        return null;
    }

    @Override
    public Object visitReadArguments(cppParser.ReadArgumentsContext ctx)
    {
        int size = ctx.variable().size();

        // Loop over read arguments.
        for (int i = 0; i < size; i++)
        {
            cppParser.VariableContext varCtx = ctx.variable().get(i);
            Typespec varType = varCtx.type;

            if (varType == Predefined.integerType)
            {
                int value = sysin.nextInt();
                assignValue(varCtx, value, Predefined.integerType);
            }
            else if (varType == Predefined.realType)
            {
                double value = sysin.nextDouble();
                assignValue(varCtx, value, Predefined.realType);
            }
            else if (varType == Predefined.booleanType)
            {
                boolean value = sysin.nextBoolean();
                assignValue(varCtx, value, Predefined.booleanType);
            }
            else if (varType == Predefined.charType)
            {
                sysin.useDelimiter("");
                char value = sysin.next().charAt(0);
                sysin.reset();

                assignValue(varCtx, value, Predefined.charType);
            }
            else  // string
            {
                String value = sysin.next();
                assignValue(varCtx, value, Predefined.stringType);
            }
        }

        return null;
    }
}
