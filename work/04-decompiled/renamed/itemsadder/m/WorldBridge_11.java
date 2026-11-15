package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.InstanceHolder_4;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBridge_20;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.SetBlockDataFunction;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.WorldBridge_14;
import java.util.HashMap;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class WorldBridge_11
extends MaterialBridge_20 {
    public static HashMap Oz = new HashMap();
    public final int OH;
    public final LocationBridgeBuilder_2 OI;
    public final LocationBridgeBuilder_2 OJ;
    public final TreeType OK;
    private final SetBlockDataFunction OL;

    public WorldBridge_11(String string, String string2, @NotNull List list, int n, int n2, int n3, int n4, double d, LocationBridgeBuilder_2 locationBridgeBuilder_2, LocationBridgeBuilder_2 locationBridgeBuilder_22, TreeType treeType) {
        super(string, string2, list, locationBridgeBuilder_2, n, n2, n3, d);
        this.OH = n4;
        this.OI = locationBridgeBuilder_2;
        this.OJ = locationBridgeBuilder_22;
        this.OK = treeType;
        if (n3 >= n2) {
            throw new IllegalArgumentException("min_height must be less than max_height");
        }
        this.OL = (block, blockData) -> {
            try {
                if (ItemStackBridge_2.ac(blockData.getMaterial())) {
                    locationBridgeBuilder_22.a(null, block, true, false, true, false);
                } else if (ItemStackBridge_2.ab(blockData.getMaterial())) {
                    locationBridgeBuilder_2.a(null, block, true, false, true, false);
                } else {
                    block.setBlockData(blockData, false);
                }
            }
            catch (Exception exception) {
                CommandSenderBridge_5.warn("Error while setting block " + String.valueOf(block == null ? "" : block));
                exception.printStackTrace();
                Bukkit.getServer().getPluginManager().disablePlugin((Plugin)Main.rS());
            }
            return true;
        };
    }

    public boolean aI(Block block) {
        return this.j(block, true);
    }

    public boolean j(Block block, boolean bl) {
        if (this.z(block.getRelative(BlockFace.DOWN).getType())) {
            try {
                return InstanceHolder_4.vB().a(block.getLocation(), this.OK, this.OL, bl);
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Custom tree '" + this.oz + "' failed to spawn at " + LocationBridge_2.ae(block.getLocation()), throwable);
                return true;
            }
        }
        return false;
    }

    public static void h(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        List list = pluginFileConfigurationHolder.gR("trees_populators");
        if (list == null) {
            if (Main.KO.gY("debug.trees-populators.log-loading-no-populators")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No trees_populators found in file " + pluginFileConfigurationHolder.qd());
            }
            return;
        }
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        String string = pluginFileConfigurationHolder.gV("info.namespace");
        for (String string2 : list) {
            WorldBridge_11 worldBridge_11;
            ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("trees_populators." + string2);
            assert (configurationSection != null);
            if (!configurationSection.getBoolean("enabled", true)) {
                if (!Main.KO.gY("debug.trees-populators.log-loading-disabled")) continue;
                CommandSenderBridge_5.log("    Ignored disabled trees populator: " + string2 + ", namespace: " + string);
                continue;
            }
            String string3 = configurationSection.getString("log");
            ItemStackBuilder_4 itemStackBuilder_4 = itemStackRegistry.e(string3);
            if (itemStackBuilder_4 == null) {
                CommandSenderBridge_5.error("&cTree populator &6" + string2 + " &cfailed to load. Missing 'log'&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            if (!LocationBridgeBuilder_2.k(itemStackBuilder_4)) {
                CommandSenderBridge_5.error("&cTree populator &6" + string2 + " &cfailed to load. Attribute 'log' is not a custom block '" + string3 + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            String string4 = configurationSection.getString("leaves");
            ItemStackBuilder_4 itemStackBuilder_42 = itemStackRegistry.e(string4);
            if (itemStackBuilder_42 == null) {
                CommandSenderBridge_5.error("&cTree populator &6" + string2 + " &cfailed to load. Missing 'leaves'&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            if (!LocationBridgeBuilder_2.k(itemStackBuilder_42)) {
                CommandSenderBridge_5.error("&cTree populator &6" + string2 + " &cfailed to load. Attribute 'leaves' is not a custom block '" + string4 + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            String string5 = configurationSection.getString("tree_type", "TREE");
            TreeType treeType = (TreeType)SoundCategoryBridge.b(string5, TreeType.class, (Enum)TreeType.TREE);
            try {
                worldBridge_11 = new WorldBridge_11(string2, pluginFileConfigurationHolder.nh(), configurationSection.getStringList("worlds"), configurationSection.getInt("amount"), configurationSection.getInt("max_height", 100), configurationSection.getInt("min_height", 5), configurationSection.getInt("iterations"), configurationSection.getDouble("chance"), (LocationBridgeBuilder_2)itemStackBuilder_4, (LocationBridgeBuilder_2)itemStackBuilder_42, treeType);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                CommandSenderBridge_5.error("&cTree populator &6" + string2 + " &cfailed to load. " + illegalArgumentException.getMessage() + "&c. &6File: " + pluginFileConfigurationHolder.nh());
                continue;
            }
            ItemStackRegistry.g().aa.add((LocationBridgeBuilder_2)itemStackBuilder_42);
            if (configurationSection.contains("biomes")) {
                boolean bl = true;
                for (String string6 : configurationSection.getStringList("biomes")) {
                    if (worldBridge_11.cK(string6)) continue;
                    CommandSenderBridge_5.error("[tree_populator} &6'" + string2 + "'&c. Error: Unknown biome &6'" + string6 + "'&c. &6File: " + pluginFileConfigurationHolder.nh());
                    bl = false;
                }
                if (!bl) continue;
            }
            if (configurationSection.contains("bottom_blocks")) {
                for (Object object : configurationSection.getStringList("bottom_blocks")) {
                    String string6;
                    string6 = (Material)SoundCategoryBridge.e(((String)object).toUpperCase(), Material.class);
                    if (string6 == null) continue;
                    worldBridge_11.y((Material)string6);
                }
            }
            Oz.put(string2, worldBridge_11);
            Bukkit.getWorlds().forEach(world -> worldBridge_11.k((World)world));
        }
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        WorldBridge_14 worldBridge_142 = WorldBridge_14.md.stream().filter(worldBridge_14 -> world.equals((Object)worldBridge_14.cE())).findFirst().orElseGet(() -> {
            WorldBridge_14 worldBridge_14 = new WorldBridge_14(world);
            WorldBridge_14.md.add(worldBridge_14);
            return worldBridge_14;
        });
        worldBridge_142.a(this);
        worldBridge_142.hn();
    }
}
