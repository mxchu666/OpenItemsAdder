package itemsadder.m;

import com.google.common.collect.Maps;
import itemsadder.m.aab;
import itemsadder.m.aah;
import itemsadder.m.aai;
import itemsadder.m.d;
import itemsadder.m.ql;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.Instrument;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Nullable;

public final class aaf {
    private final aai Vj;
    private static aaf Vk;
    public HashMap Vl = new HashMap();
    private static final Map Vm;

    @Nullable
    public static Instrument c(byte by) {
        return (Instrument)Vm.get(by);
    }

    aaf() {
        this.Vj = (aai)aab.n(aai.class);
        for (aah aah2 : aah.values()) {
            Field field = FieldUtils.getField((Class)this.Vj.tj(), (String)aah2.name(), (boolean)true);
            if (field == null) continue;
            try {
                this.Vl.put(aah2, FieldUtils.readStaticField((Field)field));
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    public static aai tg() {
        return aaf.th().Vj;
    }

    private static aaf th() {
        if (Vk == null) {
            Vk = new aaf();
        }
        return Vk;
    }

    @Deprecated
    public static boolean a(Block block, aah aah2) {
        return aaf.th().Vj.a(block, aah2);
    }

    public static boolean a(Block block, Tag tag) {
        return tag.isTagged((Keyed)block.getType());
    }

    public static boolean aK(Block block) {
        return aaf.th().Vj.aK(block);
    }

    public static boolean B(Material material) {
        return aaf.th().Vj.B(material);
    }

    public static boolean aL(Block block) {
        return aaf.th().Vj.aL(block);
    }

    public static boolean aJ(Block block) {
        return aaf.th().Vj.aJ(block);
    }

    public static boolean aM(Block block) {
        return block.getType() == Material.TALL_GRASS || block.getType() == Material.LARGE_FERN;
    }

    public static boolean aN(Block block) {
        return aaf.th().Vj.aN(block);
    }

    public static boolean aO(Block block) {
        Material material = block.getType();
        if (ql.j(material) && d.isCustomBlock(block)) {
            return false;
        }
        boolean bl = material.isInteractable();
        if (!bl) {
            return false;
        }
        switch (material) {
            case ACACIA_STAIRS: 
            case ANDESITE_STAIRS: 
            case BIRCH_STAIRS: 
            case BLACKSTONE_STAIRS: 
            case BRICK_STAIRS: 
            case COBBLESTONE_STAIRS: 
            case CRIMSON_STAIRS: 
            case DARK_OAK_STAIRS: 
            case DARK_PRISMARINE_STAIRS: 
            case DIORITE_STAIRS: 
            case END_STONE_BRICK_STAIRS: 
            case GRANITE_STAIRS: 
            case JUNGLE_STAIRS: 
            case MOSSY_COBBLESTONE_STAIRS: 
            case MOSSY_STONE_BRICK_STAIRS: 
            case NETHER_BRICK_STAIRS: 
            case OAK_STAIRS: 
            case POLISHED_ANDESITE_STAIRS: 
            case POLISHED_BLACKSTONE_BRICK_STAIRS: 
            case POLISHED_BLACKSTONE_STAIRS: 
            case POLISHED_DIORITE_STAIRS: 
            case POLISHED_GRANITE_STAIRS: 
            case PRISMARINE_BRICK_STAIRS: 
            case PRISMARINE_STAIRS: 
            case PURPUR_STAIRS: 
            case QUARTZ_STAIRS: 
            case RED_NETHER_BRICK_STAIRS: 
            case RED_SANDSTONE_STAIRS: 
            case SANDSTONE_STAIRS: 
            case SMOOTH_QUARTZ_STAIRS: 
            case SMOOTH_RED_SANDSTONE_STAIRS: 
            case SMOOTH_SANDSTONE_STAIRS: 
            case SPRUCE_STAIRS: 
            case STONE_BRICK_STAIRS: 
            case STONE_STAIRS: 
            case WARPED_STAIRS: 
            case ACACIA_FENCE: 
            case BIRCH_FENCE: 
            case CRIMSON_FENCE: 
            case DARK_OAK_FENCE: 
            case JUNGLE_FENCE: 
            case MOVING_PISTON: 
            case NETHER_BRICK_FENCE: 
            case OAK_FENCE: 
            case PUMPKIN: 
            case REDSTONE_ORE: 
            case REDSTONE_WIRE: 
            case SPRUCE_FENCE: 
            case WARPED_FENCE: {
                return false;
            }
        }
        return true;
    }

    public static boolean aP(Block block) {
        Material material = block.getType();
        return material == Material.FURNACE || material == Material.BLAST_FURNACE || material == Material.SMOKER;
    }

    public static boolean aQ(Block block) {
        return aaf.th().Vj.aQ(block);
    }

    public static int a(Chunk chunk, int n, int n2, HeightMap heightMap) {
        return aaf.th().Vj.a(chunk, n, n2, heightMap);
    }

    static {
        Vm = Maps.newHashMap();
        for (Instrument instrument : Instrument.values()) {
            Vm.put(instrument.ordinal(), instrument);
        }
    }
}
