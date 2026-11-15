package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.n;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.UUID;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class g {
    private final Plugin PW;
    private final n PX;

    public g(Plugin plugin, int n2) {
        this.PW = plugin;
        File file = new File(plugin.getDataFolder().getParentFile(), "pStats");
        File file2 = new File(file, "config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration((File)file2);
        if (!yamlConfiguration.isSet("serverUuid")) {
            yamlConfiguration.addDefault("enabled", (Object)true);
            yamlConfiguration.addDefault("serverUuid", (Object)UUID.randomUUID().toString());
            yamlConfiguration.addDefault("logFailedRequests", (Object)false);
            yamlConfiguration.addDefault("logSentData", (Object)false);
            yamlConfiguration.addDefault("logResponseStatusText", (Object)false);
            yamlConfiguration.options().copyDefaults(true);
            yamlConfiguration.options().header("pStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://pstats.devs.beer/ to learn more :)");
            try {
                yamlConfiguration.save(file2);
            }
            catch (IOException iOException) {
                plugin.getLogger().log(Level.WARNING, "Failed to save Metrics config.yml", iOException);
            }
        }
        boolean bl = yamlConfiguration.getBoolean("enabled", true);
        String string2 = yamlConfiguration.getString("serverUuid");
        boolean bl2 = yamlConfiguration.getBoolean("logFailedRequests", false);
        boolean bl3 = yamlConfiguration.getBoolean("logSentData", false);
        boolean bl4 = yamlConfiguration.getBoolean("logResponseStatusText", false);
        boolean bl5 = false;
        try {
            bl5 = Class.forName("io.papermc.paper.threadedregions.RegionizedServer") != null;
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.PX = new n("bukkit", string2, n2, bl, this::a, this::b, bl5 ? null : runnable -> Bukkit.getScheduler().runTask(plugin, runnable), () -> ((Plugin)plugin).isEnabled(), (string, throwable) -> this.PW.getLogger().log(Level.WARNING, (String)string, (Throwable)throwable), string -> this.PW.getLogger().log(Level.INFO, (String)string), bl2, bl3, bl4, false);
    }

    public void Z() {
        this.PX.Z();
    }

    public void a(j j2) {
        this.PX.a(j2);
    }

    private void a(l l2) {
        l2.h("playerAmount", this.sc());
        l2.h("onlineMode", Bukkit.getOnlineMode() ? 1 : 0);
        l2.x("bukkitVersion", Bukkit.getVersion());
        l2.x("bukkitName", Bukkit.getName());
        l2.x("javaVersion", System.getProperty("java.version"));
        l2.x("osName", System.getProperty("os.name"));
        l2.x("osArch", System.getProperty("os.arch"));
        l2.x("osVersion", System.getProperty("os.version"));
        l2.h("coreCount", Runtime.getRuntime().availableProcessors());
    }

    private void b(l l2) {
        l2.x("pluginVersion", this.PW.getDescription().getVersion());
    }

    private int sc() {
        try {
            Method method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", new Class[0]);
            return method.getReturnType().equals(Collection.class) ? ((Collection)method.invoke((Object)Bukkit.getServer(), new Object[0])).size() : ((Player[])method.invoke((Object)Bukkit.getServer(), new Object[0])).length;
        }
        catch (Exception exception) {
            return Bukkit.getOnlinePlayers().size();
        }
    }
}
