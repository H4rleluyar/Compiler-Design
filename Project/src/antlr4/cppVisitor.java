// Generated from C:/Users/10333642/Desktop/CS153/Project/Project/cpp.g4 by ANTLR 4.13.1

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link cppParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface cppVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link cppParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(cppParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#programHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeader(cppParser.ProgramHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#programParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramParameters(cppParser.ProgramParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#programIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramIdentifier(cppParser.ProgramIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#intMain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntMain(cppParser.IntMainContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(cppParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(cppParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#variablesPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesPart(cppParser.VariablesPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#variableDeclarationsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationsList(cppParser.VariableDeclarationsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#variableDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarations(cppParser.VariableDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#variableIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableIdentifierList(cppParser.VariableIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#variableIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableIdentifier(cppParser.VariableIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#constantsPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantsPart(cppParser.ConstantsPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#constantDefinitionsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinitionsList(cppParser.ConstantDefinitionsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#constantDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinition(cppParser.ConstantDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#constantIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantIdentifier(cppParser.ConstantIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(cppParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(cppParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#typesPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypesPart(cppParser.TypesPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#typeDefinitionsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinitionsList(cppParser.TypeDefinitionsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(cppParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(cppParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypespec(cppParser.SimpleTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypespec(cppParser.ArrayTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code recordTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordTypespec(cppParser.RecordTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeIdentifierTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifierTypespec(cppParser.TypeIdentifierTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumerationTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationTypespec(cppParser.EnumerationTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subrangeTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrangeTypespec(cppParser.SubrangeTypespecContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#enumerationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationType(cppParser.EnumerationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#enumerationConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationConstant(cppParser.EnumerationConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#subrangeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrangeType(cppParser.SubrangeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(cppParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#arrayDimensionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDimensionList(cppParser.ArrayDimensionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#recordType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(cppParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#recordFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordFields(cppParser.RecordFieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#routinesPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutinesPart(cppParser.RoutinesPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#routineDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineDefinition(cppParser.RoutineDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#procedureHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureHead(cppParser.ProcedureHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#functionHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHead(cppParser.FunctionHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#routineIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineIdentifier(cppParser.RoutineIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(cppParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameterDeclarationsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclarationsList(cppParser.ParameterDeclarationsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameterDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclarations(cppParser.ParameterDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameterIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterIdentifierList(cppParser.ParameterIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterIdentifier(cppParser.ParameterIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(cppParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(cppParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(cppParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(cppParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(cppParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(cppParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhs(cppParser.RhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(cppParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#trueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueStatement(cppParser.TrueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#falseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseStatement(cppParser.FalseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(cppParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(cppParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#procedureCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCallStatement(cppParser.ProcedureCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#procedureName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureName(cppParser.ProcedureNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(cppParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(cppParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(cppParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#writelnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritelnStatement(cppParser.WritelnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#writeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteArguments(cppParser.WriteArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#writeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteArgument(cppParser.WriteArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#fieldWidth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldWidth(cppParser.FieldWidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#decimalPlaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalPlaces(cppParser.DecimalPlacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(cppParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#readlnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadlnStatement(cppParser.ReadlnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#readArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadArguments(cppParser.ReadArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(cppParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(cppParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(cppParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableFactor(cppParser.VariableFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberFactor(cppParser.NumberFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterFactor(cppParser.CharacterFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFactor(cppParser.StringFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFactor(cppParser.FunctionCallFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFactor(cppParser.NotFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedFactor(cppParser.ParenthesizedFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(cppParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(cppParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#indexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexList(cppParser.IndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(cppParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(cppParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(cppParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(cppParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(cppParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#unsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(cppParser.UnsignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#integerConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConstant(cppParser.IntegerConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#realConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealConstant(cppParser.RealConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#characterConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterConstant(cppParser.CharacterConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(cppParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(cppParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(cppParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(cppParser.MulOpContext ctx);
}