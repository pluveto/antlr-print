package com.less_bug.print;

import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.logging.Logger;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public class Interpreter {
    private static Logger logger;

    public static void main(String[] args) {

        initLogger();

        if (args.length == 0) {
            System.out.println("Usage: java Interpret <filename>");
            System.exit(1);
        }

        var filename = args[0];
        CharStream chstream;
        var abspath = new java.io.File(filename).getAbsolutePath();
        try {
            chstream = CharStreams.fromFileName(filename);
        } catch (IOException e) {
            System.out.println("Error: on reading" + abspath + ": " + e.getMessage());
            System.exit(1);
            return;
        }
        var lexer = new PrintLexer(chstream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new PrintParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(PrintErrorHandler.INSTANCE);

        var program = parser.program();

        logger.fine(program.toStringTree());

        var visitor = new Visitor(logger);
        visitor.visitProgram(program);

    }

    private static void initLogger() {
        logger = Logger.getGlobal();

        var level = System.getProperty("print.logLevel");
        var formatter = new ColorFormatter();
        var handler = new java.util.logging.ConsoleHandler();
        if (level == null || level.isEmpty()) {
            logger.setLevel(java.util.logging.Level.OFF);
            return;
        }
        try {
            var loglevel = java.util.logging.Level.parse(level.toUpperCase());

            handler.setLevel(loglevel);
            logger.setLevel(loglevel);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: invalid log level: " + level);
            System.exit(1);
        }

        handler.setFormatter(formatter);
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        logger.info("Log level set to " + level);

    }
}
