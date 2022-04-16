package com.less_bug.print;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class PrintErrorHandler extends BaseErrorListener {

    public static final PrintErrorHandler INSTANCE = new PrintErrorHandler();
    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e)
            throws ParseCancellationException {
        if (this.filename == null) {
            this.filename = recognizer.getInputStream().getSourceName();
        }
        throw new ParseCancellationException(filename + ":" + line + ":" + charPositionInLine + " " + msg);
    }
}