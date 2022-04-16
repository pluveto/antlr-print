// Generated from Print.g4 by ANTLR 4.10.1

    package com.less_bug.print;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrintParser}.
 */
public interface PrintListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrintParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PrintParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PrintParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PrintParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PrintParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(PrintParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(PrintParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PrintParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PrintParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PrintParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PrintParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(PrintParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(PrintParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#numberExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(PrintParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#numberExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(PrintParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrintParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(PrintParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrintParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(PrintParser.BooleanExpressionContext ctx);
}