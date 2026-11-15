package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_20;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.WorldBridge_13;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class WorldBridge_10
extends MaterialBridge_20 {
    public static Map OF = new HashMap();

    protected WorldBridge_10(String string, String string2, @NotNull List list, LocationBridgeBuilder_2 locationBridgeBuilder_2, int n, int n2, int n3, double d) {
        super(string, string2, list, locationBridgeBuilder_2, n, n2, n3, d);
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        WorldBridge_13 worldBridge_132 = WorldBridge_13.md.stream().filter(worldBridge_13 -> world.equals((Object)worldBridge_13.cE())).findFirst().orElseGet(() -> {
            WorldBridge_13 worldBridge_13 = new WorldBridge_13(world);
            WorldBridge_13.md.add(worldBridge_13);
            return worldBridge_13;
        });
        worldBridge_132.a(this);
        worldBridge_132.hn();
    }

    public static void h(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        String string = pluginFileConfigurationHolder.gV("info.namespace");
        List list = pluginFileConfigurationHolder.gR("surface_decorators");
        if (list != null) {
            for (String string2 : list) {
                WorldBridge_10 worldBridge_10;
                ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("surface_decorators." + string2);
                assert (configurationSection != null);
                if (!configurationSection.getBoolean("enabled", true)) {
                    if (!Main.KO.gY("debug.surface-decorators.log-loading-disabled")) continue;
                    CommandSenderBridge_5.log("    Ignored disabled surface decorator: " + string2 + ", namespace: " + string);
                    continue;
                }
                LocationBridgeBuilder_2 locationBridgeBuilder_2 = itemStackRegistry.h(configurationSection.getString("block"));
                if (locationBridgeBuilder_2 == null) {
                    CommandSenderBridge_5.error("[surface_decorator} &6'" + string2 + "'. &cError: Unknown block &6'" + configurationSection.getString("block") + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                try {
                    worldBridge_10 = new WorldBridge_10(string2, pluginFileConfigurationHolder.nh(), configurationSection.getStringList("worlds"), locationBridgeBuilder_2, configurationSection.getInt("amount"), configurationSection.getInt("max_height"), configurationSection.getInt("min_height"), configurationSection.getDouble("chance"));
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    CommandSenderBridge_5.error("[surface_decorator} &6'" + string2 + "'. &cError: " + illegalArgumentException.getMessage() + "&c. &6File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (configurationSection.contains("biomes")) {
                    boolean bl = true;
                    for (String string3 : configurationSection.getStringList("biomes")) {
                        if (worldBridge_10.cK(string3)) continue;
                        CommandSenderBridge_5.error("[surface_decorator} &6'" + string2 + "'. &cError: Unknown biome &6'" + string3 + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                        bl = false;
                    }
                    if (!bl) continue;
                }
                if (configurationSection.contains("bottom_blocks")) {
                    for (Object object : configurationSection.getStringList("bottom_blocks")) {
                        String string3;
                        string3 = (Material)SoundCategoryBridge.e(((String)object).toUpperCase(), Material.class);
                        if (string3 == null) continue;
                        worldBridge_10.y((Material)string3);
                    }
                }
                OF.put(string2, worldBridge_10);
                Bukkit.getWorlds().forEach(worldBridge_10::k);
            }
        } else if (Main.KO.gY("debug.surface-decorators.log-loading-no-populators")) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No surface_decorators found in file " + pluginFileConfigurationHolder.qd());
        }
    }
}
