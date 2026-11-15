package dev.lone.itemsadder.Core.OtherPlugins.vulcan;

import dev.lone.itemsadder.Core.OtherPlugins.RetPar;
import java.util.function.Consumer;
import me.frep.vulcan.api.VulcanAPI;
import me.frep.vulcan.api.check.Check;
import me.frep.vulcan.api.event.VulcanFlagEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class VulcanHook
implements Listener {
    private final RetPar isPlayerProtected;
    private final Consumer msg;

    public static void register(Plugin plugin, RetPar retPar, Consumer consumer) {
        new VulcanHook(plugin, retPar, consumer);
    }

    VulcanHook(Plugin plugin, RetPar retPar, Consumer consumer) {
        this.isPlayerProtected = retPar;
        this.msg = consumer;
        try {
            if (VulcanAPI.Factory.getApi().getEnabledChecks().containsKey("BadPacketsV")) {
                Bukkit.getPluginManager().registerEvents((Listener)this, plugin);
                FileConfiguration fileConfiguration = Bukkit.getPluginManager().getPlugin("Vulcan").getConfig();
                if (!fileConfiguration.getBoolean("settings.enable-api") && !fileConfiguration.getBoolean("enable-api")) {
                    consumer.accept("Please set 'enable-api: true' in Vulcan anticheat config.yml in order to enable compatibility and run '/vulcan reload'.");
                }
            }
        }
        catch (Throwable throwable) {
            consumer.accept("Failed to check Vulcan anticheat compatibility");
            throwable.printStackTrace();
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void onVulcanFlag(VulcanFlagEvent vulcanFlagEvent) {
        Check check = vulcanFlagEvent.getCheck();
        if (check.getName().equals("badpackets") && check.getType() == 'v' && ((Boolean)this.isPlayerProtected.call(vulcanFlagEvent.getPlayer())).booleanValue()) {
            vulcanFlagEvent.setCancelled(true);
        }
    }
}
