package fr.lernejo.logger;

public class LoggerFactory {
    private static final Logger logger = new ConsoleLogger();

    public static Logger getLogger() {
        return logger;
    }

    public static Logger getContextualLogger(Class<?> clazz) {
        return new ContextualLogger(clazz.getSimpleName(), logger);
    }
}
