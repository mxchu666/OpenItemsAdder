package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.scriptinginternal.ScriptingUtils;
import ia.sh.customblockdata.CustomBlockData;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockPlaceListener_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.SoundCategoryBridge;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class WorldUtils {
    public static boolean isCustom(Block block) {
        if (block == null) {
            return false;
        }
        if (block.getType() == Material.AIR) {
            return false;
        }
        return ItemStackRegistry.isCustomBlock(block);
    }

    @Nullable
    public static CustomBlock customBlock(Block block) {
        if (block == null) {
            return null;
        }
        if (block.getType() == Material.AIR) {
            return null;
        }
        return CustomBlock.byAlreadyPlaced(block);
    }

    @Nullable
    public static CustomBlock customBlock(Location location) {
        if (location == null) {
            return null;
        }
        Block block = location.getBlock();
        return WorldUtils.customBlock(block);
    }

    @Nullable
    public static Block block(String string, int n, int n2, int n3) {
        if (string == null) {
            return null;
        }
        World world = Bukkit.getWorld((String)string);
        if (world == null) {
            return null;
        }
        return world.getBlockAt(n, n2, n3);
    }

    public static Block block(World world, int n, int n2, int n3) {
        return world.getBlockAt(n, n2, n3);
    }

    @Nullable
    public static Block block(Location location) {
        if (location.getWorld() == null) {
            return null;
        }
        return location.getWorld().getBlockAt(location);
    }

    public static void removeBlock(Block block) {
        if (block == null) {
            return;
        }
        if (block.getType() == Material.AIR) {
            return;
        }
        Location location = block.getLocation();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(block)) {
            block.setType(Material.AIR);
            return;
        }
        blockBridge_9.ag(block);
        BlockBridge_2.bk(block);
    }

    public static void placeBlock(Block block, Material material) {
        if (block == null) {
            return;
        }
        if (block.getType() == material) {
            return;
        }
        Location location = block.getLocation();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (blockBridge_9.isCustomBlock(block)) {
            blockBridge_9.ag(block);
            BlockBridge_2.bk(block);
        }
        block.setType(material);
    }

    public static boolean placeBlock(Block block, String string) {
        BlockBridge_2.bk(block);
        Material material = Material.matchMaterial((String)string);
        if (material != null) {
            WorldUtils.placeBlock(block, material);
            return true;
        }
        CustomBlock customBlock = CustomBlock.getInstance(string);
        if (customBlock != null) {
            customBlock.place(block.getLocation());
            return true;
        }
        return false;
    }

    public static void placeBlock(Block block, CustomBlock customBlock) {
        BlockBridge_2.bk(block);
        customBlock.place(block.getLocation());
    }

    public static Location location(String string, int n, int n2, int n3) {
        if (string == null) {
            return null;
        }
        World world = Bukkit.getWorld((String)string);
        if (world == null) {
            return null;
        }
        return new Location(world, (double)n, (double)n2, (double)n3);
    }

    public static void breakBlockNaturally(Player player, int n, int n2, int n3) {
        Location location = new Location(player.getWorld(), (double)n, (double)n2, (double)n3);
        Block block = location.getBlock();
        WorldUtils.breakBlockNaturally(player, block);
    }

    public static void breakBlockNaturally(Player player, Block block) {
        if (block == null || block.getType() == Material.AIR) {
            return;
        }
        Location location = block.getLocation();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(block)) {
            block.breakNaturally();
            return;
        }
        String string = blockBridge_9.Y(block);
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        if (locationBridgeBuilder_2 == null) {
            throw new RuntimeException("Unknown custom block: " + string);
        }
        PlayerBlockHolder_2 playerBlockHolder_2 = new PlayerBlockHolder_2(player, block, locationBridgeBuilder_2, blockBridge_9);
        BlockPlaceListener_2.b(playerBlockHolder_2);
    }

    public static void breakBlockNaturally(Block block) {
        if (block == null || block.getType() == Material.AIR) {
            return;
        }
        Location location = block.getLocation();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(block)) {
            block.breakNaturally();
            return;
        }
        String string = blockBridge_9.Y(block);
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        if (locationBridgeBuilder_2 == null) {
            throw new RuntimeException("Unknown custom block: " + string);
        }
        BlockPlaceListener_2.a(blockBridge_9, block, locationBridgeBuilder_2);
    }

    public static void playParticle(Location location, String string) {
        WorldUtils.playParticle(location, string, 1, 0.0, 0.0, 0.0, 0.0);
    }

    public static void playParticle(Location location, String string, int n) {
        WorldUtils.playParticle(location, string, n, 0.0, 0.0, 0.0, 0.0);
    }

    public static void playParticle(World world, double d, double d2, double d3, String string, int n, double d4, double d5, double d6, double d7) {
        WorldUtils.playParticle(new Location(world, d, d2, d3), string, n, d4, d5, d6, d7);
    }

    public static void playParticle(Location location, String string, int n, double d, double d2, double d3, double d4) {
        if (location == null || string == null || string.isEmpty()) {
            throw new RuntimeException("Invalid parameters for playParticle");
        }
        Particle particle = SoundCategoryBridge.id(string);
        if (particle == null) {
            throw new RuntimeException("Invalid particle name: " + string);
        }
        location.getWorld().spawnParticle(particle, location, n, d, d2, d3, d4);
    }

    public static void playSound(Location location, String string) {
        if (location == null || string == null || string.isEmpty()) {
            throw new RuntimeException("Invalid parameters for playSound");
        }
        location.getWorld().playSound(location, string, 1.0f, 1.0f);
    }

    public static void playSound(Location location, String string, float f, float f2) {
        if (location == null || string == null || string.isEmpty()) {
            throw new RuntimeException("Invalid parameters for playSound");
        }
        location.getWorld().playSound(location, string, f, f2);
    }

    private static PersistentDataContainer getContainer(Block block) {
        if (block == null) {
            throw new IllegalArgumentException("Block cannot be null");
        }
        ItemStackRegistry.g().A.rx();
        return new CustomBlockData(block, (Plugin)Main.rS());
    }

    public static boolean hasData(Block block, String string, String string2) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.hasData(persistentDataContainer, string, string2);
    }

    public static void removeData(Block block, String string, String string2) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.removeData(persistentDataContainer, string, string2);
    }

    public static void setDataByte(Block block, String string, String string2, byte by) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataByte(persistentDataContainer, string, string2, by);
    }

    public static void setDataShort(Block block, String string, String string2, short s) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataShort(persistentDataContainer, string, string2, s);
    }

    public static void setDataInt(Block block, String string, String string2, int n) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataInt(persistentDataContainer, string, string2, n);
    }

    public static void setDataLong(Block block, String string, String string2, long l) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataLong(persistentDataContainer, string, string2, l);
    }

    public static void setDataFloat(Block block, String string, String string2, float f) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataFloat(persistentDataContainer, string, string2, f);
    }

    public static void setDataDouble(Block block, String string, String string2, double d) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataDouble(persistentDataContainer, string, string2, d);
    }

    public static void setDataBool(Block block, String string, String string2, boolean bl) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataBool(persistentDataContainer, string, string2, bl);
    }

    public static void setDataString(Block block, String string, String string2, String string3) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataString(persistentDataContainer, string, string2, string3);
    }

    public static byte getDataByte(Block block, String string, String string2, byte by) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataByte(persistentDataContainer, string, string2, by);
    }

    public static short getDataShort(Block block, String string, String string2, short s) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataShort(persistentDataContainer, string, string2, s);
    }

    public static int getDataInt(Block block, String string, String string2, int n) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataInt(persistentDataContainer, string, string2, n);
    }

    public static long getDataLong(Block block, String string, String string2, long l) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataLong(persistentDataContainer, string, string2, l);
    }

    public static float getDataFloat(Block block, String string, String string2, float f) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataFloat(persistentDataContainer, string, string2, f);
    }

    public static double getDataDouble(Block block, String string, String string2, double d) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataDouble(persistentDataContainer, string, string2, d);
    }

    public static boolean getDataBool(Block block, String string, String string2, boolean bl) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataBool(persistentDataContainer, string, string2, bl);
    }

    public static String getDataString(Block block, String string, String string2, String string3) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataString(persistentDataContainer, string, string2, string3);
    }
}
