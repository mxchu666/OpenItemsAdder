package dev.lone.itemsadder.Core.OtherPlugins;

import dev.lone.itemsadder.Core.OtherPlugins.RetPar;
import fr.skytasul.glowingentities.GlowingEntities;
import java.util.Collection;
import java.util.function.BiConsumer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class Glow {
    @Nullable
    private static GlowingEntities API;
    private static RetPar getNearbyPlayers;
    private static boolean hasFailedOneTime;
    private static BiConsumer errorLogger;

    public static void init(Plugin plugin, RetPar retPar, /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @Nullable BiConsumer biConsumer) {
        errorLogger = biConsumer;
        try {
            getNearbyPlayers = retPar;
            plugin.getLogger().info("Loading GlowingEntities API");
            API = new GlowingEntities(plugin);
        }
        catch (Exception exception) {
            biConsumer.accept("Failed to initialize the Glow API.", exception);
            API = null;
        }
    }

    public static void set(Entity entity, String string) {
        if (API == null) {
            return;
        }
        for (Player player : (Collection)getNearbyPlayers.call(entity.getLocation())) {
            try {
                API.setGlowing(entity, player, ChatColor.valueOf((String)string));
            }
            catch (Exception exception) {
                if (hasFailedOneTime) continue;
                errorLogger.accept("Failed to set glow color for entity " + entity.getType().name() + " to " + string + ". Disabling feature.", exception);
                hasFailedOneTime = true;
            }
        }
    }

    static {
        hasFailedOneTime = false;
    }
}
