package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ChunkBridge_3;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_20;
import itemsadder.m.PluginFileConfigurationHolder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class WorldBridge_8
extends MaterialBridge_20 {
    public static HashMap Oz = new HashMap();
    public final int OA;
    public final HashSet OB;

    public WorldBridge_8(String string, String string2, @NotNull List list, LocationBridgeBuilder_2 locationBridgeBuilder_2, int n, int n2, int n3, int n4, double d) {
        super(string, string2, list, locationBridgeBuilder_2, n, n2, n3, d);
        this.OA = n4;
        this.OB = new HashSet();
        if (n3 >= n2) {
            throw new IllegalArgumentException("min_height must be less than max_height");
        }
    }

    public void A(Material material) {
        this.OB.add(material);
    }

    public boolean aH(Block block) {
        if (this.OB.isEmpty()) {
            return true;
        }
        return this.OB.contains(block.getType());
    }

    public static void h(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        String string = pluginFileConfigurationHolder.gV("info.namespace");
        List list = pluginFileConfigurationHolder.gR("blocks_populators");
        if (list == null || list.isEmpty()) {
            list = pluginFileConfigurationHolder.gR("worlds_populators");
        }
        if (list == null) {
            if (Main.KO.gY("debug.blocks-populators.log-loading-no-populators")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No blocks_populators found in file " + pluginFileConfigurationHolder.qd());
            }
            return;
        }
        for (String string2 : list) {
            WorldBridge_8 worldBridge_8;
            ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("blocks_populators." + string2);
            if (configurationSection == null) {
                configurationSection = pluginFileConfigurationHolder.hi("worlds_populators." + string2);
            }
            assert (configurationSection != null);
            if (!configurationSection.getBoolean("enabled", true)) {
                if (!Main.KO.gY("debug.blocks-populators.log-loading-disabled")) continue;
                CommandSenderBridge_5.log("    Ignored disabled world populator: " + string2 + ", namespace: " + string);
                continue;
            }
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = itemStackRegistry.h(configurationSection.getString("block"));
            if (locationBridgeBuilder_2 == null) {
                CommandSenderBridge_5.error("&cWorld populator &6" + string2 + " &cfailed to load. Unknown block &6" + configurationSection.getString("block") + "&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            try {
                worldBridge_8 = new WorldBridge_8(string2, pluginFileConfigurationHolder.nh(), configurationSection.getStringList("worlds"), locationBridgeBuilder_2, configurationSection.getInt("vein_blocks", configurationSection.getInt("amount")), configurationSection.getInt("max_height"), configurationSection.getInt("min_height"), configurationSection.getInt("chunk_veins", configurationSection.getInt("iterations")), configurationSection.getDouble("chunk_chance", (double)configurationSection.getInt("chance")));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                CommandSenderBridge_5.error("&cWorld populator &6" + string2 + " &cfailed to load. " + illegalArgumentException.getMessage() + "&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            if (configurationSection.contains("replaceable_blocks")) {
                for (Object object : configurationSection.getStringList("replaceable_blocks")) {
                    if (!ItemStackBridge_2.ip((String)object)) continue;
                    worldBridge_8.A(Material.valueOf((String)((String)object).toUpperCase()));
                }
            }
            if (configurationSection.contains("biomes")) {
                Object object;
                boolean bl = true;
                object = configurationSection.getStringList("biomes").iterator();
                while (object.hasNext()) {
                    String string3 = (String)object.next();
                    if (worldBridge_8.cK(string3)) continue;
                    CommandSenderBridge_5.error("[world_populator} &6'" + string2 + "'&c. Error: Unknown biome &6'" + string3 + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                    bl = false;
                }
                if (!bl) continue;
            }
            Oz.put(string2, worldBridge_8);
            Bukkit.getWorlds().forEach(worldBridge_8::k);
        }
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        ChunkBridge_3 chunkBridge_32 = ChunkBridge_3.md.stream().filter(chunkBridge_3 -> world.equals((Object)chunkBridge_3.cE())).findFirst().orElseGet(() -> {
            ChunkBridge_3 chunkBridge_3 = new ChunkBridge_3(world);
            ChunkBridge_3.md.add(chunkBridge_3);
            return chunkBridge_3;
        });
        chunkBridge_32.a(this);
        chunkBridge_32.hn();
    }
}
