// Generated from Print.g4 by ANTLR 4.10.1

    package com.less_bug.print;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PrintParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PrintVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PrintParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PrintParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PrintParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(PrintParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PrintParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PrintParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#stringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(PrintParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#numberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(PrintParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrintParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(PrintParser.BooleanExpressionContext ctx);
}