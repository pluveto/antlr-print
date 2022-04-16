package com.less_bug.print;

import java.util.logging.Logger;

import com.less_bug.print.PrintParser.AssignmentContext;
import com.less_bug.print.PrintParser.BooleanExpressionContext;
import com.less_bug.print.PrintParser.ExpressionContext;
import com.less_bug.print.PrintParser.NumberExpressionContext;
import com.less_bug.print.PrintParser.PrintStatementContext;
import com.less_bug.print.PrintParser.ProgramContext;
import com.less_bug.print.PrintParser.StatementContext;
import com.less_bug.print.PrintParser.StringExpressionContext;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Visitor implements PrintVisitor<Object> {

    private SymbolTable rootSymtab = new SymbolTable();
    private SymbolTable currentSymtab = rootSymtab;
    private Logger logger;

    public Visitor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Object visit(ParseTree arg0) {
        logger.finer("[visit] ");
        return null;
    }

    @Override
    public Object visitChildren(RuleNode arg0) {
        logger.finer("[visit] Children");
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode arg0) {
        logger.finer("[visit] ErrorNode");
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode arg0) {
        logger.finer("[visit] Terminal");
        return null;
    }

    @Override
    public Object visitProgram(ProgramContext ctx) {
        if (ctx.exception != null) {
            logger.finer("[visit] Program: " + ctx.exception.getMessage());
            System.exit(1);
        }
        logger.finer("[visit] Program");
        ctx.children.forEach(child -> {
            if (child instanceof StatementContext) {
                visitStatement((StatementContext) child);
            }
        });
        return null;
    }

    @Override
    public Object visitStatement(StatementContext ctx) {
        logger.finer("[visit] Statement");
        ctx.children.forEach(child -> {
            if (child instanceof PrintStatementContext) {
                visitPrintStatement((PrintStatementContext) child);
            } else if (child instanceof AssignmentContext) {
                visitAssignment((AssignmentContext) child);
            }
        });
        return null;
    }

    @Override
    public Object visitPrintStatement(PrintStatementContext ctx) {
        logger.finer("[visit] PrintStatement");
        var child = ctx.getChild(1);
        Object value = null;
        if (child instanceof ExpressionContext) {
            value = visitExpression((ExpressionContext) child);
        } else {
            value = currentSymtab.lookup(child.getText());
        }
        if (value != null) {
            System.out.println(value);
        } else {
            logger.finer("null");
        }

        return null;
    }

    @Override
    public Object visitAssignment(AssignmentContext ctx) {
        logger.finer("[visit] Assignment");
        var valueNode = ctx.getChild(2);
        Object value = null;
        if (valueNode instanceof ExpressionContext) {
            value = visitExpression((ExpressionContext) valueNode);
        } else {
            logger.finer("[visit] Assignment: valueNode is not supported: " + valueNode.getClass().getName());
        }
        var name = ctx.getChild(0).getText();
        if (currentSymtab.lookup(name) != null) {
            logger.finer("warning: " + name + " is already defined");
        }
        currentSymtab.set(name, value);
        logger.finer("set " + name + " to " + value);
        return null;
    }

    @Override
    public Object visitExpression(ExpressionContext ctx) {
        logger.finer("[visit] Expression");
        Object value = null;
        var child = ctx.getChild(0);
        if (child instanceof StringExpressionContext) {
            value = visitStringExpression((StringExpressionContext) child);
        } else if (child instanceof NumberExpressionContext) {
            value = visitNumberExpression((NumberExpressionContext) child);
        } else if (child instanceof BooleanExpressionContext) {
            value = visitBooleanExpression((BooleanExpressionContext) child);
        } else if (child instanceof TerminalNode) {
            value = currentSymtab.lookup(child.getText());
            if (value == null) {
                logger.finer("[visit] identifer: " + child.getText() + " is not defined");
            }
        } else {
            logger.finer("[visit] Expression: child is not supported: " + child.getClass().getName());
        }
        return value;
    }

    @Override
    public Object visitStringExpression(StringExpressionContext ctx) {
        logger.finer("[visit] StringExpression");
        var raw = ctx.getText();
        var value = raw.substring(1, raw.length() - 1);
        return value;
    }

    @Override
    public Object visitNumberExpression(NumberExpressionContext ctx) {
        logger.finer("[visit] NumberExpression");
        var raw = ctx.getText();
        var value = Integer.parseInt(raw);
        return value;
    }

    @Override
    public Object visitBooleanExpression(BooleanExpressionContext ctx) {
        logger.finer("[visit] BooleanExpression");
        var raw = ctx.getText();
        var value = Boolean.parseBoolean(raw);
        return value;
    }

}
