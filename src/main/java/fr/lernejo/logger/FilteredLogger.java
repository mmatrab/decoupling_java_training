package fr.lernejo.logger;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.function.Predicate;

public class FilteredLogger implements Logger {

    private final Logger delegateLogger;
    private final Predicate<String> condition;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public FilteredLogger(Logger delegateLogger, Predicate<String> condition) {
        this.delegateLogger = delegateLogger;
        this.condition = condition;
    }

    @Override
    public void log(String message) {
        if (condition.test(message)) {
            delegateLogger.log(LocalDateTime.now().format(formatter) + " " + message);
        }
    }
}
