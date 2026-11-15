package ia.sh.libby.logging.adapters;

import ia.sh.libby.logging.LogLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LogAdapter {
    public void log(@NotNull LogLevel var1, @Nullable String var2);

    public void log(@NotNull LogLevel var1, @Nullable String var2, @Nullable Throwable var3);
}
