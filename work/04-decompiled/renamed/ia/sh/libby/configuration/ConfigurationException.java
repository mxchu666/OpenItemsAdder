package ia.sh.libby.configuration;

import org.jetbrains.annotations.NotNull;

public class ConfigurationException
extends RuntimeException {
    public ConfigurationException(@NotNull String string) {
        super(string);
    }

    public ConfigurationException(@NotNull String string, @NotNull Throwable throwable) {
        super(string, throwable);
    }

    public ConfigurationException(@NotNull Throwable throwable) {
        super(throwable);
    }
}
