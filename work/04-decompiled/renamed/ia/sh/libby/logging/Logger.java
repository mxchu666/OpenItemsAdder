package ia.sh.libby.logging;

import ia.sh.libby.logging.LogLevel;
import ia.sh.libby.logging.adapters.LogAdapter;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Logger {
    private final LogAdapter adapter;
    private LogLevel level = LogLevel.INFO;

    public Logger(@NotNull LogAdapter logAdapter) {
        this.adapter = Objects.requireNonNull(logAdapter, "adapter");
    }

    @NotNull
    public LogLevel getLevel() {
        return this.level;
    }

    public void setLevel(@NotNull LogLevel logLevel) {
        this.level = Objects.requireNonNull(logLevel, "level");
    }

    private boolean canLog(@NotNull LogLevel logLevel) {
        return Objects.requireNonNull(logLevel, "level").compareTo(this.level) >= 0;
    }

    public void log(@NotNull LogLevel logLevel, @Nullable String string) {
        if (this.canLog(logLevel)) {
            this.adapter.log(logLevel, string);
        }
    }

    public void log(@NotNull LogLevel logLevel, @Nullable String string, @Nullable Throwable throwable) {
        if (this.canLog(logLevel)) {
            this.adapter.log(logLevel, string, throwable);
        }
    }

    public void debug(String string) {
        this.log(LogLevel.DEBUG, string);
    }

    public void debug(@Nullable String string, @Nullable Throwable throwable) {
        this.log(LogLevel.DEBUG, string, throwable);
    }

    public void info(@Nullable String string) {
        this.log(LogLevel.INFO, string);
    }

    public void info(@Nullable String string, @Nullable Throwable throwable) {
        this.log(LogLevel.INFO, string, throwable);
    }

    public void warn(@Nullable String string) {
        this.log(LogLevel.WARN, string);
    }

    public void warn(@Nullable String string, @Nullable Throwable throwable) {
        this.log(LogLevel.WARN, string, throwable);
    }

    public void error(@Nullable String string) {
        this.log(LogLevel.ERROR, string);
    }

    public void error(@Nullable String string, @Nullable Throwable throwable) {
        this.log(LogLevel.ERROR, string, throwable);
    }
}
