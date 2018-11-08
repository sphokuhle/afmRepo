package za.ac.afm.util;


import org.slf4j.Logger;

public class LoggingUtil {

    private LoggingUtil() {
    }

    public static void logTrace(Logger logger, Object... messages) {
        if (logger.isTraceEnabled()) {
            logger.trace(getMessage(messages));
        }
    }

    public static void logDebug(Logger logger, Object... messages) {
        if (logger.isDebugEnabled()) {
            logger.debug(getMessage(messages));
        }
    }

    public static void logInfo(Logger logger, Object... messages) {
        if (logger.isInfoEnabled()) {
            logger.info(getMessage(messages));
        }
    }

    public static void logWarn(Logger logger, Object... messages) {
        if (logger.isWarnEnabled()) {
            logger.warn(getMessage(messages));
        }
    }

    public static void logWarn(Logger logger, Throwable th, Object... messages) {
        if (logger.isWarnEnabled()) {
            logger.warn(getMessage(messages), th);
        }
    }

    public static void logError(Logger logger, Object... messages) {
    	  
        if (logger.isErrorEnabled()) {
            logger.error(getMessage(messages));
        }
    }
    
    public static void logError(Logger logger, Throwable th, Object... messages) {
        if (logger.isErrorEnabled()) {
            logger.error(getMessage(messages), th);
        }
    }

    private static String getMessage(Object... messages) {
        StringBuilder sb = new StringBuilder();
        for (Object message : messages) {
            sb.append(message);
        }
        return sb.toString();
    }
}

