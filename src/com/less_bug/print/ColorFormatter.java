package com.less_bug.print;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ColorFormatter extends Formatter {

    // https://stackoverflow.com/questions/5947742/how-to-change-the-output-color-of-echo-in-linux

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String DARK_GRAY = "\u001B[90m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private String padding(String str, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = str.length(); i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getColor(Level level) {
        if (level.intValue() >= java.util.logging.Level.SEVERE.intValue()) {
            return RED;
        } else if (level.intValue() >= java.util.logging.Level.WARNING.intValue()) {
            return YELLOW;
        } else if (level.intValue() >= java.util.logging.Level.INFO.intValue()) {
            return BLUE;
        } else if (level.intValue() >= java.util.logging.Level.FINE.intValue()) {
            return WHITE;
        } else {
            return DARK_GRAY;
        }
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append(getColor(record.getLevel()));

        builder.append("[");
        builder.append(padding(record.getLevel().getName(), 8));
        builder.append("] ");

        builder.append(RESET);
        builder.append(record.getMessage());

        Object[] params = record.getParameters();

        if (params != null) {
            builder.append("\t");
            for (int i = 0; i < params.length; i++) {
                builder.append(params[i]);
                if (i < params.length - 1)
                    builder.append(", ");
            }
        }

        builder.append(RESET);
        builder.append("\n");
        return builder.toString();
    }

}
