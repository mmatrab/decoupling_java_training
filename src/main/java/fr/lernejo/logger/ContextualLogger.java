package fr.lernejo.logger;

public class ContextualLogger implements Logger {
    private final String callerClass;
    private final Logger delegateLogger;

    public ContextualLogger(String callerClass, Logger delegateLogger) {
        this.callerClass = callerClass;
        this.delegateLogger = delegateLogger;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(callerClass + " " + message);
    }
}
