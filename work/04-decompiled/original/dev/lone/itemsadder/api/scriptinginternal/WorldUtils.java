package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.scriptinginternal.ScriptingUtils;
import ia.sh.customblockdata.CustomBlockData;
import itemsadder.m.bay;
import itemsadder.m.bbi;
import itemsadder.m.d;
import itemsadder.m.lg;
import itemsadder.m.lh;
import itemsadder.m.ms;
import itemsadder.m.ql;
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
        return d.isCustomBlock(block);
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
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(block)) {
            block.setType(Material.AIR);
            return;
        }
        ms2.ag(block);
        bay.bk(block);
    }

    public static void placeBlock(Block block, Material material) {
        if (block == null) {
            return;
        }
        if (block.getType() == material) {
            return;
        }
        Location location = block.getLocation();
        ms ms2 = d.g().a(location);
        if (ms2.isCustomBlock(block)) {
            ms2.ag(block);
            bay.bk(block);
        }
        block.setType(material);
    }

    public static boolean placeBlock(Block block, String string) {
        bay.bk(block);
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
        bay.bk(block);
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
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(block)) {
            block.breakNaturally();
            return;
        }
        String string = ms2.Y(block);
        ql ql2 = d.g().h(string);
        if (ql2 == null) {
            throw new RuntimeException("Unknown custom block: " + string);
        }
        lg lg2 = new lg(player, block, ql2, ms2);
        lh.b(lg2);
    }

    public static void breakBlockNaturally(Block block) {
        if (block == null || block.getType() == Material.AIR) {
            return;
        }
        Location location = block.getLocation();
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(block)) {
            block.breakNaturally();
            return;
        }
        String string = ms2.Y(block);
        ql ql2 = d.g().h(string);
        if (ql2 == null) {
            throw new RuntimeException("Unknown custom block: " + string);
        }
        lh.a(ms2, block, ql2);
    }

    public static void playParticle(Location location, String string) {
        WorldUtils.playParticle(location, string, 1, 0.0, 0.0, 0.0, 0.0);
    }

    public static void playParticle(Location location, String string, int n) {
        WorldUtils.playParticle(location, string, n, 0.0, 0.0, 0.0, 0.0);
    }

    public static void playParticle(World world, double d2, double d3, double d4, String string, int n, double d5, double d6, double d7, double d8) {
        WorldUtils.playParticle(new Location(world, d2, d3, d4), string, n, d5, d6, d7, d8);
    }

    public static void playParticle(Location location, String string, int n, double d2, double d3, double d4, double d5) {
        if (location == null || string == null || string.isEmpty()) {
            throw new RuntimeException("Invalid parameters for playParticle");
        }
        Particle particle = bbi.id(string);
        if (particle == null) {
            throw new RuntimeException("Invalid particle name: " + string);
        }
        location.getWorld().spawnParticle(particle, location, n, d2, d3, d4, d5);
    }

    public static void playSound(Location location, String string) {
        if (location == null || string == null || string.isEmpty()) {
            throw new RuntimeException("Invalid parameters for playSound");
        }
        location.getWorld().playSound(location, string, 1.0f, 1.0f);
    }

    public static void playSound(Location location, String string, float f2, float f3) {
        if (location == null || string == null || string.isEmpty()) {
            throw new RuntimeException("Invalid parameters for playSound");
        }
        location.getWorld().playSound(location, string, f2, f3);
    }

    private static PersistentDataContainer getContainer(Block block) {
        if (block == null) {
            throw new IllegalArgumentException("Block cannot be null");
        }
        d.g().A.rx();
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

    public static void setDataFloat(Block block, String string, String string2, float f2) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataFloat(persistentDataContainer, string, string2, f2);
    }

    public static void setDataDouble(Block block, String string, String string2, double d2) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        ScriptingUtils.setDataDouble(persistentDataContainer, string, string2, d2);
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

    public static float getDataFloat(Block block, String string, String string2, float f2) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataFloat(persistentDataContainer, string, string2, f2);
    }

    public static double getDataDouble(Block block, String string, String string2, double d2) {
        PersistentDataContainer persistentDataContainer = WorldUtils.getContainer(block);
        return ScriptingUtils.getDataDouble(persistentDataContainer, string, string2, d2);
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
