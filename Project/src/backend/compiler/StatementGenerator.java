package backend.compiler;

import antlr4.cppParser;
import intermediate.symtab.Predefined;
import intermediate.symtab.SymtabEntry;
import intermediate.type.Typespec;
import intermediate.type.Typespec.Form;

import static backend.compiler.Instruction.*;
import static intermediate.type.Typespec.Form.ENUMERATION;
import static intermediate.type.Typespec.Form.SCALAR;

/**
 * <h1>StatementGenerator</h1>
 *
 * <p>
 * Emit code for executable statements.
 * </p>
 *
 * <p>
 * Copyright (c) 2020 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class StatementGenerator extends CodeGenerator {
    /**
     * Constructor.
     *
     * @param parent   the parent generator.
     * @param compiler the compiler to use.
     */
    public StatementGenerator(CodeGenerator parent, Compiler compiler) {
        super(parent, compiler);
    }

    /**
     * Emit code for an assignment statement.
     *
     * @param ctx the AssignmentStatementContext.
     */
    public void emitAssignment(cppParser.AssignmentStatementContext ctx) {
        cppParser.VariableContext varCtx = ctx.lhs().variable();
        cppParser.ExpressionContext exprCtx = ctx.rhs().expression();
        SymtabEntry varId = varCtx.entry;
        Typespec varType = varCtx.type;
        Typespec exprType = exprCtx.type;

        // The last modifier, if any, is the variable's last subscript or field.
        int modifierCount = varCtx.modifier().size();
        cppParser.ModifierContext lastModCtx = modifierCount == 0
                ? null
                : varCtx.modifier().get(modifierCount - 1);

        // The target variable has subscripts and/or fields.
        if (modifierCount > 0) {
            lastModCtx = varCtx.modifier().get(modifierCount - 1);
            compiler.visit(varCtx);
        }

        // Emit code to evaluate the expression.
        compiler.visit(exprCtx);

        // float variable := integer constant
        if ((varType == Predefined.doubleType)
                && (exprType.baseType() == Predefined.intType))
            emit(I2F);

        // Emit code to store the expression value into the target variable.
        // The target variable has no subscripts or fields.
        if (lastModCtx == null)
            emitStoreValue(varId, varId.getType());

            // The target variable is a field.
        else if (lastModCtx.field() != null) {
            emitStoreValue(lastModCtx.field().entry, lastModCtx.field().type);
        }

        // The target variable is an array element.
        else {
            emitStoreValue(null, varType);
        }
    }

    /**
     * Emit code for an IF statement.
     *
     * @param ctx the IfStatementContext.
     */
    public void emitIf(cppParser.IfStatementContext ctx) {
        cppParser.TrueStatementContext tctx = ctx.trueStatement();
        cppParser.FalseStatementContext fctx = ctx.falseStatement();
        Label exitloop = new Label();

        compiler.visit(ctx.expression());

        if (fctx == null) {
            emit(IFEQ, exitloop);
            compiler.visit(tctx);
        } else {
            Label flabel = new Label();

            emit(IFEQ, flabel);
            compiler.visit(tctx);
            emit(GOTO, exitloop);

            emitLabel(flabel);
            compiler.visit(fctx);
        }

        emitLabel(exitloop);
    }

    /**
     * Emit code for a WHILE statement.
     *
     * @param ctx the WhileStatementContext.
     */
    public void emitWhile(cppParser.WhileStatementContext ctx) {
        /***** Complete this method. *****/
        Label loopTopLabel = new Label();
        Label loopExitLabel = new Label();

        emitLabel(loopTopLabel);

        compiler.visit(ctx.expression());
        emit(IFEQ, loopExitLabel);
        compiler.visit(ctx.statement());

        emit(GOTO, loopTopLabel);

        emitLabel(loopExitLabel);
    }

    /**
     * Emit code for a FOR statement.
     *
     * @param ctx the ForStatementContext.
     */
    public void emitFor(cppParser.ForStatementContext ctx)
    {
        /***** Complete this method. *****/
        Label loopTopLabel = new Label();
        Label loopExitLabel = new Label();
        Label loopAgainLabel = new Label();
        Label loopStopLabel = new Label();

        cppParser.VariableIdentifierContext controlCtx = ctx.variableDeclarations().variableIdentifierList().variableIdentifier(0);
        compiler.visit(controlCtx);
        compiler.visit(ctx.rhs());

        if (controlCtx.entry.getSlotNumber() != 0) {
            emit(ISTORE, controlCtx.entry.getSlotNumber());
        } else {
            emit(PUTSTATIC, programName + "/" + controlCtx.getText() + " " + typeDescriptor(ctx.variableDeclarations().typeSpecification().type));
        }

        emitLabel(loopTopLabel);
        compiler.visit(ctx.variable(0));
        compiler.visit(ctx.expression());

        if (ctx.lessOp() != null) {
            emit(IF_ICMPGE, loopStopLabel);
        } else if (ctx.lessEqOp() != null) {
            emit(IF_ICMPGT, loopStopLabel);
        } else if (ctx.greaterOp() != null) {
            emit(IF_ICMPLE, loopStopLabel);
        } else {
            emit(IF_ICMPLT, loopStopLabel);
        }

        emit(ICONST_0);
        emit(GOTO, loopAgainLabel);

        emitLabel(loopStopLabel);
        emit(ICONST_1);

        emitLabel(loopAgainLabel);
        emit(IFNE, loopExitLabel);
        compiler.visit(ctx.compoundStatement());
        emitLine();
        compiler.visit(ctx.variable(1));
        emit(ICONST_1);

        if (ctx.incrementOp() != null) {
            emit(IADD);
        } else {
            emit(ISUB);
        }

        if (controlCtx.entry.getSlotNumber() != 0) {
            emit(ISTORE, controlCtx.entry.getSlotNumber());
        } else {
            emit(PUTSTATIC, programName + "/" + controlCtx.getText() + " " + typeDescriptor(ctx.variableDeclarations().typeSpecification().type));
        }

        emit(GOTO, loopTopLabel);
        emitLabel(loopExitLabel);
    }

    /**
     * Emit code for a procedure call statement.
     *
     * @param ctx the ProcedureCallStatementContext.
     */
    public void emitProcedureCall(cppParser.ProcedureCallStatementContext ctx)
    {
        /***** Complete this method. *****/
        SymtabEntry procedureId = ctx.procedureName().entry;
        String procedureName = procedureId.getName();
        String procedureParams = procedureName + "(";

        cppParser.ArgumentListContext argListCtx = ctx.argumentList();
        if (argListCtx != null) {

            for (int i = 0; i < argListCtx.argument().size(); i++) {
                compiler.visit(argListCtx.argument(i));

                String argType = typeDescriptor(argListCtx.argument(i).expression().type);
                String paramType = typeDescriptor(procedureId.getRoutineParameters().get(i).getType());

                if (!argType.equals(paramType)) {
                    if (paramType.equals("F")) {
                        if (argType.equals("I")) {
                            emit(I2F);
                        } else if (argType.equals("D")){
                            emit(D2F);
                        }
                    }

                    if (paramType.equals("D")) {
                        if (argType.equals("I")) {
                            emit(I2D);
                        } else if (argType.equals("F")){
                            emit(F2D);
                        }
                    }

                    if (paramType.equals("C") && argType.equals("I")) {
                        emit(I2C);
                    }

                    if (paramType.equals("I") && argType.equals("F")) {
                        emit(F2I);
                    }
                }
                procedureParams = procedureParams + typeDescriptor(procedureId.getRoutineParameters().get(i).getType());
            }
        }

        procedureParams = procedureParams + ")" + typeDescriptor(procedureId);
        emit(INVOKESTATIC, programName + "/" + procedureParams);
        compiler.visit(ctx.procedureName());
    }

    /**
     * Emit code for a function call statement.
     * @param ctx the FunctionCallContext.
     */
    public void emitFunctionCall(cppParser.FunctionCallContext ctx) {
        SymtabEntry functionId = ctx.functionName().entry;
        String functionName = functionId.getName();
        String functionParams = functionName + "(";

        cppParser.ArgumentListContext argListCtx = ctx.argumentList();
        if (argListCtx != null) {
            for (int i = 0; i < argListCtx.argument().size(); i++) {
                compiler.visit(argListCtx.argument(i));
                String argType = typeDescriptor(argListCtx.argument(i).expression().type);
                String paramType = typeDescriptor(functionId.getRoutineParameters().get(i).getType());

                if (!argType.equals(paramType)) {
                    // Handle type conversions as needed
                    if (paramType.equals("F") && argType.equals("I")) {
                        emit(I2F);
                    } else if (paramType.equals("D") && argType.equals("I")) {
                        emit(I2D);
                    } else if (paramType.equals("D") && argType.equals("F")) {
                        emit(F2D);
                        // Add more conversions as needed
                    }
                }

                functionParams = functionParams + typeDescriptor(functionId.getRoutineParameters().get(i).getType());
            }
        }

        functionParams = functionParams + ")" + typeDescriptor(functionId);

        // Emit the function call
        emit(INVOKESTATIC, programName + "/" + functionParams);

        // Handle the return value if needed
        if (ctx.getParent() instanceof cppParser.AssignmentStatementContext) {
            // If the function call is part of an assignment statement, store the return value
            cppParser.AssignmentStatementContext assignmentCtx = (cppParser.AssignmentStatementContext) ctx.getParent();
            cppParser.VariableContext varCtx = assignmentCtx.lhs().variable();
            Typespec varType = varCtx.type;
            SymtabEntry varId = varCtx.entry;
            emitStoreValue(varId, varType);
        }
    }

    public void emitReturnStatement(cppParser.ReturnStatementContext retStmtCtx) {
        if (retStmtCtx.getParent() instanceof cppParser.RoutineDefinitionContext) {
            cppParser.RoutineDefinitionContext routCtx = (cppParser.RoutineDefinitionContext) retStmtCtx.getParent();
            SymtabEntry functionId = routCtx.functionHead().routineIdentifier().entry;
            Typespec functionType = routCtx.functionHead().routineIdentifier().type;

            cppParser.ExpressionContext exprCtx = retStmtCtx.rhs().expression();
            Typespec exprType = exprCtx.type;

            compiler.visit(exprCtx);

            // float variable := integer constant
            if ((functionType == Predefined.doubleType)
                    && (exprType.baseType() == Predefined.intType))
                emit(I2F);

            String varName = functionId.getName();
            SymtabEntry varId = functionId.getRoutineSymtab().lookup(varName);

            emitStoreLocal(functionId.getType(), varId.getSlotNumber());

        }
    }

    /**
     * Emit a call to a procedure or a function.
     * @param routineId the routine name's symbol table entry.
     * @param argListCtx the ArgumentListContext.
     *
     */
    private void emitCall(SymtabEntry routineId,
                          cppParser.ArgumentListContext argListCtx)
    {
             //no need for this because emitProcedure and emitFunction handles it already.
    }

    /**
     * Emit code for a WRITE statement.
     *
     * @param ctx the WriteStatementContext.
     */
    public void emitWrite(cppParser.WriteStatementContext ctx) {
        emitWrite(ctx.writeArguments(), false);
    }

    /**
     * Emit code for a WRITELN statement.
     *
     * @param ctx the WritelnStatementContext.
     */
    public void emitWriteln(cppParser.WritelnStatementContext ctx) {
        emitWrite(ctx.writeArguments(), true);
    }

    /**
     * Emit code for a call to WRITE or WRITELN.
     *
     * @param argsCtx the WriteArgumentsContext.
     * @param needLF  true if need a line feed.
     */
    private void emitWrite(cppParser.WriteArgumentsContext argsCtx,
                           boolean needLF) {
        emit(GETSTATIC, "java/lang/System/out", "Ljava/io/PrintStream;");

        // WRITELN with no arguments.
        if (argsCtx == null) {
            emit(INVOKEVIRTUAL, "java/io/PrintStream.println()V");
            localStack.decrease(1);
        }

        // Generate code for the arguments.
        else {
            StringBuffer format = new StringBuffer();
            int exprCount = createWriteFormat(argsCtx, format, needLF);

            // Load the format string.
            emit(LDC, format.toString());

            // Emit the arguments array.
            if (exprCount > 0) {
                emitArgumentsArray(argsCtx, exprCount);

                emit(INVOKEVIRTUAL,
                        "java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)" +
                                "Ljava/io/PrintStream;");
                localStack.decrease(2);
                emit(POP);
            } else {
                emit(INVOKEVIRTUAL,
                        "java/io/PrintStream/print(Ljava/lang/String;)V");
                localStack.decrease(2);
            }
        }
    }

    /**
     * Create the printf format string.
     *
     * @param argsCtx the WriteArgumentsContext.
     * @param format  the format string to create.
     * @return the count of expression arguments.
     */
    private int createWriteFormat(cppParser.WriteArgumentsContext argsCtx,
                                  StringBuffer format, boolean needLF) {
        int exprCount = 0;
        format.append("\"");

        // Loop over the write arguments.
        for (cppParser.WriteArgumentContext argCtx : argsCtx.writeArgument()) {
            Typespec type = argCtx.expression().type;
            String argText = argCtx.getText();

            // Append any literal strings.
            if (argText.charAt(0) == '\'') {
                format.append(convertString(argText));
            }

            // For any other expressions, append a field specifier.
            else {
                exprCount++;
                format.append("%");

                cppParser.FieldWidthContext fwCtx = argCtx.fieldWidth();
                if (fwCtx != null) {
                    String sign = ((fwCtx.sign() != null)
                            && (fwCtx.sign().getText().equals("-")))
                            ? "-"
                            : "";
                    format.append(sign)
                            .append(fwCtx.intConstant().getText());

                    cppParser.DecimalPlacesContext dpCtx = fwCtx.decimalPlaces();
                    if (dpCtx != null) {
                        format.append(".")
                                .append(dpCtx.intConstant().getText());
                    }
                }

                String typeFlag = type == Predefined.intType ? "d"
                        : type == Predefined.doubleType ? "f"
                        : type == Predefined.booleanType ? "b"
                        : type == Predefined.charType ? "c"
                        : "s";
                format.append(typeFlag);
            }
        }

        format.append(needLF ? "\\n\"" : "\"");

        return exprCount;
    }

    /**
     * Emit the printf arguments array.
     *
     * @param argsCtx
     * @param exprCount
     */
    private void emitArgumentsArray(cppParser.WriteArgumentsContext argsCtx,
                                    int exprCount) {
        // Create the arguments array.
        emitLoadConstant(exprCount);
        emit(ANEWARRAY, "java/lang/Object");

        int index = 0;

        // Loop over the write arguments to fill the arguments array.
        for (cppParser.WriteArgumentContext argCtx : argsCtx.writeArgument()) {
            String argText = argCtx.getText();
            cppParser.ExpressionContext exprCtx = argCtx.expression();
            Typespec type = exprCtx.type.baseType();

            // Skip string constants, which were made part of
            // the format string.
            if (argText.charAt(0) != '\'') {
                emit(DUP);
                emitLoadConstant(index++);

                compiler.visit(exprCtx);

                Form form = type.getForm();
                if (((form == SCALAR) || (form == ENUMERATION))
                        && (type != Predefined.stringType)) {
                    emit(INVOKESTATIC, valueOfSignature(type));
                }

                // Store the value into the array.
                emit(AASTORE);
            }
        }
    }

    /**
     * Emit code for a READ statement.
     *
     * @param ctx the ReadStatementContext.
     */
    public void emitRead(cppParser.ReadStatementContext ctx) {
        emitRead(ctx.readArguments(), false);
    }

    /**
     * Emit code for a READLN statement.
     *
     * @param ctx the ReadlnStatementContext.
     */
    public void emitReadln(cppParser.ReadlnStatementContext ctx) {
        emitRead(ctx.readArguments(), true);
    }

    /**
     * Generate code for a call to READ or READLN.
     *
     * @param argsCtx  the ReadArgumentsContext.
     * @param needSkip true if need to skip the rest of the input line.
     */
    private void emitRead(cppParser.ReadArgumentsContext argsCtx,
                          boolean needSkip) {
        int size = argsCtx.variable().size();

        // Loop over read arguments.
        for (int i = 0; i < size; i++) {
            cppParser.VariableContext varCtx = argsCtx.variable().get(i);
            Typespec varType = varCtx.type;

            if (varType == Predefined.intType) {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/nextInt()I");
                emitStoreValue(varCtx.entry, null);
            } else if (varType == Predefined.doubleType) {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/nextFloat()F");
                emitStoreValue(varCtx.entry, null);
            } else if (varType == Predefined.booleanType) {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/nextBoolean()Z");
                emitStoreValue(varCtx.entry, null);
            } else if (varType == Predefined.charType) {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(LDC, "\"\"");
                emit(INVOKEVIRTUAL, "java/util/Scanner/useDelimiter(Ljava/lang/String;)" +
                        "Ljava/util/Scanner;");
                emit(POP);
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/next()Ljava/lang/String;");
                emit(ICONST_0);
                emit(INVOKEVIRTUAL, "java/lang/String/charAt(I)C");
                emitStoreValue(varCtx.entry, null);

                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/reset()Ljava/util/Scanner;");

            } else // string
            {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/next()Ljava/lang/String;");
                emitStoreValue(varCtx.entry, null);
            }
        }

        // READLN: Skip the rest of the input line.
        if (needSkip) {
            emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
            emit(INVOKEVIRTUAL, "java/util/Scanner/nextLine()Ljava/lang/String;");
            emit(POP);
        }
    }

}
