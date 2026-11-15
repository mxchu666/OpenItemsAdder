package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_20;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.SurfaceEnum;
import itemsadder.m.WorldBridge_12;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class WorldBridge_9
extends MaterialBridge_20 {
    public static HashMap Oz = new HashMap();
    public final SurfaceEnum OD;

    public WorldBridge_9(String string, String string2, @NotNull List list, LocationBridgeBuilder_2 locationBridgeBuilder_2, int n, int n2, int n3, double d, SurfaceEnum surfaceEnum) {
        super(string, string2, list, locationBridgeBuilder_2, n, n2, n3, d);
        this.OD = surfaceEnum;
    }

    public static void h(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        String string = pluginFileConfigurationHolder.gV("info.namespace");
        List list = pluginFileConfigurationHolder.gR("cave_decorators");
        if (list == null) {
            if (Main.KO.gY("debug.cave-decorators.log-loading-no-populators")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No cave_decorators found in file " + pluginFileConfigurationHolder.qd());
            }
            return;
        }
        for (String string2 : list) {
            SurfaceEnum surfaceEnum;
            Object object;
            ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("cave_decorators." + string2);
            assert (configurationSection != null);
            if (!configurationSection.getBoolean("enabled", true)) {
                if (!Main.KO.gY("debug.cave-decorators.log-loading-disabled")) continue;
                CommandSenderBridge_5.log("    Ignored disabled cave decorator: " + string2 + ", namespace: " + string);
                continue;
            }
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(configurationSection.getString("block"));
            if (locationBridgeBuilder_2 == null) {
                CommandSenderBridge_5.error("&cCave decorator &6" + string2 + " &cfailed to load. Unknown block &6" + configurationSection.getString("block") + "&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            Iterator iterator = configurationSection.get("position");
            if (iterator instanceof String) {
                object = (String)((Object)iterator);
                surfaceEnum = (SurfaceEnum)SoundCategoryBridge.e((String)object, SurfaceEnum.class);
                if (surfaceEnum == null) {
                    CommandSenderBridge_5.error("&cCave decorator &6" + string2 + " &cfailed to load. Unknown 'position' &6" + (String)object + "&c. &6File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
            } else {
                surfaceEnum = SurfaceEnum.SURFACE;
            }
            object = new WorldBridge_9(string2, pluginFileConfigurationHolder.nh(), configurationSection.getStringList("worlds"), locationBridgeBuilder_2, configurationSection.getInt("amount"), configurationSection.getInt("max_height"), configurationSection.getInt("min_height"), configurationSection.getDouble("chance"), surfaceEnum);
            if (configurationSection.contains("biomes")) {
                boolean bl = true;
                for (String string3 : configurationSection.getStringList("biomes")) {
                    if (((MaterialBridge_20)object).cK(string3)) continue;
                    CommandSenderBridge_5.error("[cave_decorator} &6'" + string2 + "'&c. Error: Unknown biome &6'" + string3 + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                    bl = false;
                }
                if (!bl) continue;
            }
            if (configurationSection.contains("bottom_blocks")) {
                for (Object object2 : configurationSection.getStringList("bottom_blocks")) {
                    String string3;
                    string3 = (Material)SoundCategoryBridge.e(((String)object2).toUpperCase(), Material.class);
                    if (string3 == null) continue;
                    ((MaterialBridge_20)object).y((Material)string3);
                }
            }
            Oz.put(string2, object);
            Bukkit.getWorlds().forEach(((WorldBridge_9)object)::k);
        }
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        WorldBridge_12 worldBridge_122 = WorldBridge_12.md.stream().filter(worldBridge_12 -> world.equals((Object)worldBridge_12.cE())).findFirst().orElseGet(() -> {
            WorldBridge_12 worldBridge_12 = new WorldBridge_12(world);
            WorldBridge_12.md.add(worldBridge_12);
            WorldBridge_12.OQ.put(world.getUID(), worldBridge_12);
            return worldBridge_12;
        });
        worldBridge_122.a(this);
        worldBridge_122.hn();
    }
}
