package fr.lernejo.logger;

public class LoggerFactory {
    private static final Logger consoleLogger = new ConsoleLogger();
    private static final Logger fileLogger = new FileLogger("application.log");

    public static <T> Logger getContextualLogger(Class<T> callerClass) {
        String className = callerClass.getSimpleName();
        Logger contextualLogger = new ContextualLogger(className, consoleLogger);
        Logger compositeLogger = new CompositeLogger(contextualLogger, fileLogger);
        return compositeLogger;
    }
}

