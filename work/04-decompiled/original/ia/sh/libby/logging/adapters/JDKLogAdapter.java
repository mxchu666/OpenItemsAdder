package ia.sh.libby.logging.adapters;

import ia.sh.libby.logging.LogLevel;
import ia.sh.libby.logging.adapters.LogAdapter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JDKLogAdapter
implements LogAdapter {
    private final Logger logger;

    public JDKLogAdapter(@NotNull Logger logger) {
        this.logger = Objects.requireNonNull(logger, "logger");
    }

    @Override
    public void log(@NotNull LogLevel logLevel, @Nullable String string) {
        switch (Objects.requireNonNull(logLevel, "level")) {
            case DEBUG: {
                this.logger.log(Level.FINE, string);
                break;
            }
            case INFO: {
                this.logger.log(Level.INFO, string);
                break;
            }
            case WARN: {
                this.logger.log(Level.WARNING, string);
                break;
            }
            case ERROR: {
                this.logger.log(Level.SEVERE, string);
            }
        }
    }

    @Override
    public void log(@NotNull LogLevel logLevel, @Nullable String string, @Nullable Throwable throwable) {
        switch (Objects.requireNonNull(logLevel, "level")) {
            case DEBUG: {
                this.logger.log(Level.FINE, string, throwable);
                break;
            }
            case INFO: {
                this.logger.log(Level.INFO, string, throwable);
                break;
            }
            case WARN: {
                this.logger.log(Level.WARNING, string, throwable);
                break;
            }
            case ERROR: {
                this.logger.log(Level.SEVERE, string, throwable);
            }
        }
    }
}
