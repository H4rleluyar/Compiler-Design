// Generated from D:/Download/cs153/Project/untitled/cpp.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link cppParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(cppParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#intMain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntMain(cppParser.IntMainContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(cppParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#numberVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberVariableDeclaration(cppParser.NumberVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(cppParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(cppParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(cppParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(cppParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(cppParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(cppParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(cppParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(cppParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(cppParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(cppParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(cppParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cppParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(cppParser.PrintStatementContext ctx);
}