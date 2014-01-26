package com.sevogle;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;

public class JavaLoggerStub {

    /**
     * @param args
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Args must be: <log4jprops> -<e|w|i> <message>");
        }
        String file = args[0];
        String type = args[1];
        String message = args[2];

        Logger logger = Logger.getLogger(JavaLoggerStub.class);
        try {
            PropertyConfigurator.configure(file);
        } catch (Exception e) {
            System.out.println("Invalid or no log4j path specified");
            return;
        }

        if ("-e".equals(type)) {

        }
        Priority priority = Priority.INFO;
        if ("-e".equalsIgnoreCase(type)) {
            priority = Priority.ERROR;
        } else if ("-w".equalsIgnoreCase(type)) {
            priority = Priority.WARN;
        }
        logger.log(priority, message);
    }
}
