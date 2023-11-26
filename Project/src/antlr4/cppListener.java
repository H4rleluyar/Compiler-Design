// Generated from D:/Download/cs153/Project/untitled/cpp.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link cppParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(cppParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(cppParser.IncludeContext ctx);
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
	 * Enter a parse tree produced by {@link cppParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(cppParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(cppParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#numberVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNumberVariableDeclaration(cppParser.NumberVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#numberVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNumberVariableDeclaration(cppParser.NumberVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(cppParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(cppParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(cppParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(cppParser.ParameterContext ctx);
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
	 * Enter a parse tree produced by {@link cppParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(cppParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(cppParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(cppParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(cppParser.AssignmentContext ctx);
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
	 * Enter a parse tree produced by {@link cppParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(cppParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(cppParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(cppParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(cppParser.LoopContext ctx);
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
	 * Enter a parse tree produced by {@link cppParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(cppParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(cppParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cppParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(cppParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link cppParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(cppParser.PrintStatementContext ctx);
}