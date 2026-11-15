package ia.sh.libby.configuration;

import ia.sh.libby.configuration.ConfigurationException;
import org.jetbrains.annotations.NotNull;

public class MalformedConfigurationException
extends ConfigurationException {
    public MalformedConfigurationException(@NotNull String string) {
        super(string);
    }

    public MalformedConfigurationException(@NotNull String string, @NotNull Throwable throwable) {
        super(string, throwable);
    }

    public MalformedConfigurationException(@NotNull Throwable throwable) {
        super(throwable);
    }
}
