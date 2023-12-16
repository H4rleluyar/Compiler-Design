// Generated from C:/Users/kevin/Downloads/CS153-Project/grammar/cpp.g4 by ANTLR 4.13.1

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link cppParser}.
 */
public interface cppListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link cppParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(cppParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(cppParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#programHeader}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeader(cppParser.ProgramHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#programHeader}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeader(cppParser.ProgramHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#programParameters}.
	 * @param ctx the parse tree
	 */
	void enterProgramParameters(cppParser.ProgramParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#programParameters}.
	 * @param ctx the parse tree
	 */
	void exitProgramParameters(cppParser.ProgramParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#programIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterProgramIdentifier(cppParser.ProgramIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#programIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitProgramIdentifier(cppParser.ProgramIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#intMain}.
	 * @param ctx the parse tree
	 */
	void enterIntMain(cppParser.IntMainContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#intMain}.
	 * @param ctx the parse tree
	 */
	void exitIntMain(cppParser.IntMainContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(cppParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(cppParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(cppParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(cppParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#variablesPart}.
	 * @param ctx the parse tree
	 */
	void enterVariablesPart(cppParser.VariablesPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#variablesPart}.
	 * @param ctx the parse tree
	 */
	void exitVariablesPart(cppParser.VariablesPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#variableDeclarationsList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationsList(cppParser.VariableDeclarationsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#variableDeclarationsList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationsList(cppParser.VariableDeclarationsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#variableDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarations(cppParser.VariableDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#variableDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarations(cppParser.VariableDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#variableIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterVariableIdentifierList(cppParser.VariableIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#variableIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitVariableIdentifierList(cppParser.VariableIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#variableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableIdentifier(cppParser.VariableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#variableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableIdentifier(cppParser.VariableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#constantsPart}.
	 * @param ctx the parse tree
	 */
	void enterConstantsPart(cppParser.ConstantsPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#constantsPart}.
	 * @param ctx the parse tree
	 */
	void exitConstantsPart(cppParser.ConstantsPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#constantDefinitionsList}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinitionsList(cppParser.ConstantDefinitionsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#constantDefinitionsList}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinitionsList(cppParser.ConstantDefinitionsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinition(cppParser.ConstantDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinition(cppParser.ConstantDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#constantIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantIdentifier(cppParser.ConstantIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#constantIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantIdentifier(cppParser.ConstantIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(cppParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(cppParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(cppParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(cppParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#typesPart}.
	 * @param ctx the parse tree
	 */
	void enterTypesPart(cppParser.TypesPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#typesPart}.
	 * @param ctx the parse tree
	 */
	void exitTypesPart(cppParser.TypesPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#typeDefinitionsList}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinitionsList(cppParser.TypeDefinitionsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#typeDefinitionsList}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinitionsList(cppParser.TypeDefinitionsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(cppParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(cppParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(cppParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(cppParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypespec(cppParser.SimpleTypespecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypespec(cppParser.SimpleTypespecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypespec(cppParser.ArrayTypespecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypespec(cppParser.ArrayTypespecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code recordTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 */
	void enterRecordTypespec(cppParser.RecordTypespecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code recordTypespec}
	 * labeled alternative in {@link cppParser#typeSpecification}.
	 * @param ctx the parse tree
	 */
	void exitRecordTypespec(cppParser.RecordTypespecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeIdentifierTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifierTypespec(cppParser.TypeIdentifierTypespecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeIdentifierTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifierTypespec(cppParser.TypeIdentifierTypespecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enumerationTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationTypespec(cppParser.EnumerationTypespecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumerationTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationTypespec(cppParser.EnumerationTypespecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subrangeTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSubrangeTypespec(cppParser.SubrangeTypespecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subrangeTypespec}
	 * labeled alternative in {@link cppParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSubrangeTypespec(cppParser.SubrangeTypespecContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#enumerationType}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationType(cppParser.EnumerationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#enumerationType}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationType(cppParser.EnumerationTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#enumerationConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationConstant(cppParser.EnumerationConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#enumerationConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationConstant(cppParser.EnumerationConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#subrangeType}.
	 * @param ctx the parse tree
	 */
	void enterSubrangeType(cppParser.SubrangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#subrangeType}.
	 * @param ctx the parse tree
	 */
	void exitSubrangeType(cppParser.SubrangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(cppParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(cppParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#arrayDimensionList}.
	 * @param ctx the parse tree
	 */
	void enterArrayDimensionList(cppParser.ArrayDimensionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#arrayDimensionList}.
	 * @param ctx the parse tree
	 */
	void exitArrayDimensionList(cppParser.ArrayDimensionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#recordType}.
	 * @param ctx the parse tree
	 */
	void enterRecordType(cppParser.RecordTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#recordType}.
	 * @param ctx the parse tree
	 */
	void exitRecordType(cppParser.RecordTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#recordFields}.
	 * @param ctx the parse tree
	 */
	void enterRecordFields(cppParser.RecordFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#recordFields}.
	 * @param ctx the parse tree
	 */
	void exitRecordFields(cppParser.RecordFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#routinesPart}.
	 * @param ctx the parse tree
	 */
	void enterRoutinesPart(cppParser.RoutinesPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#routinesPart}.
	 * @param ctx the parse tree
	 */
	void exitRoutinesPart(cppParser.RoutinesPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#routineDefinition}.
	 * @param ctx the parse tree
	 */
	void enterRoutineDefinition(cppParser.RoutineDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#routineDefinition}.
	 * @param ctx the parse tree
	 */
	void exitRoutineDefinition(cppParser.RoutineDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#procedureHead}.
	 * @param ctx the parse tree
	 */
	void enterProcedureHead(cppParser.ProcedureHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#procedureHead}.
	 * @param ctx the parse tree
	 */
	void exitProcedureHead(cppParser.ProcedureHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#functionHead}.
	 * @param ctx the parse tree
	 */
	void enterFunctionHead(cppParser.FunctionHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#functionHead}.
	 * @param ctx the parse tree
	 */
	void exitFunctionHead(cppParser.FunctionHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(cppParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(cppParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#routineIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterRoutineIdentifier(cppParser.RoutineIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#routineIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitRoutineIdentifier(cppParser.RoutineIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(cppParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(cppParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameterDeclarationsList}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarationsList(cppParser.ParameterDeclarationsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameterDeclarationsList}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarationsList(cppParser.ParameterDeclarationsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameterDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarations(cppParser.ParameterDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameterDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarations(cppParser.ParameterDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameterIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterParameterIdentifierList(cppParser.ParameterIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameterIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitParameterIdentifierList(cppParser.ParameterIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterParameterIdentifier(cppParser.ParameterIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitParameterIdentifier(cppParser.ParameterIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(cppParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(cppParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(cppParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(cppParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(cppParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(cppParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(cppParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(cppParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(cppParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(cppParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#lhs}.
	 * @param ctx the parse tree
	 */
	void enterLhs(cppParser.LhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#lhs}.
	 * @param ctx the parse tree
	 */
	void exitLhs(cppParser.LhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#rhs}.
	 * @param ctx the parse tree
	 */
	void enterRhs(cppParser.RhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#rhs}.
	 * @param ctx the parse tree
	 */
	void exitRhs(cppParser.RhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(cppParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(cppParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#trueStatement}.
	 * @param ctx the parse tree
	 */
	void enterTrueStatement(cppParser.TrueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#trueStatement}.
	 * @param ctx the parse tree
	 */
	void exitTrueStatement(cppParser.TrueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#falseStatement}.
	 * @param ctx the parse tree
	 */
	void enterFalseStatement(cppParser.FalseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#falseStatement}.
	 * @param ctx the parse tree
	 */
	void exitFalseStatement(cppParser.FalseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(cppParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(cppParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(cppParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(cppParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#procedureCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCallStatement(cppParser.ProcedureCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#procedureCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCallStatement(cppParser.ProcedureCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#procedureName}.
	 * @param ctx the parse tree
	 */
	void enterProcedureName(cppParser.ProcedureNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#procedureName}.
	 * @param ctx the parse tree
	 */
	void exitProcedureName(cppParser.ProcedureNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(cppParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(cppParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(cppParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(cppParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(cppParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(cppParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#writelnStatement}.
	 * @param ctx the parse tree
	 */
	void enterWritelnStatement(cppParser.WritelnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#writelnStatement}.
	 * @param ctx the parse tree
	 */
	void exitWritelnStatement(cppParser.WritelnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#writeArguments}.
	 * @param ctx the parse tree
	 */
	void enterWriteArguments(cppParser.WriteArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#writeArguments}.
	 * @param ctx the parse tree
	 */
	void exitWriteArguments(cppParser.WriteArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#writeArgument}.
	 * @param ctx the parse tree
	 */
	void enterWriteArgument(cppParser.WriteArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#writeArgument}.
	 * @param ctx the parse tree
	 */
	void exitWriteArgument(cppParser.WriteArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#fieldWidth}.
	 * @param ctx the parse tree
	 */
	void enterFieldWidth(cppParser.FieldWidthContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#fieldWidth}.
	 * @param ctx the parse tree
	 */
	void exitFieldWidth(cppParser.FieldWidthContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#decimalPlaces}.
	 * @param ctx the parse tree
	 */
	void enterDecimalPlaces(cppParser.DecimalPlacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#decimalPlaces}.
	 * @param ctx the parse tree
	 */
	void exitDecimalPlaces(cppParser.DecimalPlacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(cppParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(cppParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#readlnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadlnStatement(cppParser.ReadlnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#readlnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadlnStatement(cppParser.ReadlnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#readArguments}.
	 * @param ctx the parse tree
	 */
	void enterReadArguments(cppParser.ReadArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#readArguments}.
	 * @param ctx the parse tree
	 */
	void exitReadArguments(cppParser.ReadArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(cppParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(cppParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(cppParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(cppParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(cppParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(cppParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterVariableFactor(cppParser.VariableFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitVariableFactor(cppParser.VariableFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterNumberFactor(cppParser.NumberFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitNumberFactor(cppParser.NumberFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code characterFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterCharacterFactor(cppParser.CharacterFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code characterFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitCharacterFactor(cppParser.CharacterFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterStringFactor(cppParser.StringFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitStringFactor(cppParser.StringFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallFactor(cppParser.FunctionCallFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallFactor(cppParser.FunctionCallFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterNotFactor(cppParser.NotFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitNotFactor(cppParser.NotFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedFactor(cppParser.ParenthesizedFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedFactor}
	 * labeled alternative in {@link cppParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedFactor(cppParser.ParenthesizedFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(cppParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(cppParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(cppParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(cppParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#indexList}.
	 * @param ctx the parse tree
	 */
	void enterIndexList(cppParser.IndexListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#indexList}.
	 * @param ctx the parse tree
	 */
	void exitIndexList(cppParser.IndexListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(cppParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(cppParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(cppParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(cppParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(cppParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(cppParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(cppParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(cppParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(cppParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(cppParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#unsignedNumber}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedNumber(cppParser.UnsignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#unsignedNumber}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedNumber(cppParser.UnsignedNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#intConstant}.
	 * @param ctx the parse tree
	 */
	void enterIntConstant(cppParser.IntConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#intConstant}.
	 * @param ctx the parse tree
	 */
	void exitIntConstant(cppParser.IntConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#doubleConstant}.
	 * @param ctx the parse tree
	 */
	void enterDoubleConstant(cppParser.DoubleConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#doubleConstant}.
	 * @param ctx the parse tree
	 */
	void exitDoubleConstant(cppParser.DoubleConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#characterConstant}.
	 * @param ctx the parse tree
	 */
	void enterCharacterConstant(cppParser.CharacterConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#characterConstant}.
	 * @param ctx the parse tree
	 */
	void exitCharacterConstant(cppParser.CharacterConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(cppParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(cppParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(cppParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(cppParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(cppParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(cppParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(cppParser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(cppParser.MulOpContext ctx);
}