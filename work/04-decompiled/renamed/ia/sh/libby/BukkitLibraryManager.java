package ia.sh.libby;

import ia.sh.libby.LibraryManager;
import ia.sh.libby.classloader.URLClassLoaderHelper;
import ia.sh.libby.logging.adapters.JDKLogAdapter;
import ia.sh.libby.logging.adapters.LogAdapter;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.Objects;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BukkitLibraryManager
extends LibraryManager {
    @NotNull
    private final URLClassLoaderHelper classLoader;
    @NotNull
    private final Plugin plugin;

    public BukkitLibraryManager(@NotNull Plugin plugin) {
        this(plugin, "lib");
    }

    public BukkitLibraryManager(@NotNull Plugin plugin, @NotNull String string) {
        this(plugin, string, new JDKLogAdapter(Objects.requireNonNull(plugin, "plugin").getLogger()));
    }

    public BukkitLibraryManager(@NotNull Plugin plugin, @NotNull String string, @NotNull LogAdapter logAdapter) {
        super(logAdapter, plugin.getDataFolder().toPath(), string);
        this.classLoader = new URLClassLoaderHelper((URLClassLoader)plugin.getClass().getClassLoader(), this);
        this.plugin = plugin;
    }

    @Override
    protected void addToClasspath(@NotNull Path path) {
        this.classLoader.addToClasspath(path);
    }

    @Override
    protected InputStream getResourceAsStream(@NotNull String string) {
        return this.plugin.getResource(string);
    }
}
