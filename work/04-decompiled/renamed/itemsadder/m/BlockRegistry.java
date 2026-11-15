package itemsadder.m;

import com.google.common.collect.Maps;
import itemsadder.m.AirEnum;
import itemsadder.m.BlockNms;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.NmsWrapperFactory;
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

public final class BlockRegistry {
    private final BlockNms Vj;
    private static BlockRegistry Vk;
    public HashMap Vl = new HashMap();
    private static final Map Vm;

    @Nullable
    public static Instrument c(byte by) {
        return (Instrument)Vm.get(by);
    }

    BlockRegistry() {
        this.Vj = (BlockNms)NmsWrapperFactory.n(BlockNms.class);
        for (AirEnum airEnum : AirEnum.values()) {
            Field field = FieldUtils.getField((Class)this.Vj.tj(), (String)airEnum.name(), (boolean)true);
            if (field == null) continue;
            try {
                this.Vl.put(airEnum, FieldUtils.readStaticField((Field)field));
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    public static BlockNms tg() {
        return BlockRegistry.th().Vj;
    }

    private static BlockRegistry th() {
        if (Vk == null) {
            Vk = new BlockRegistry();
        }
        return Vk;
    }

    @Deprecated
    public static boolean a(Block block, AirEnum airEnum) {
        return BlockRegistry.th().Vj.a(block, airEnum);
    }

    public static boolean a(Block block, Tag tag) {
        return tag.isTagged((Keyed)block.getType());
    }

    public static boolean aK(Block block) {
        return BlockRegistry.th().Vj.aK(block);
    }

    public static boolean B(Material material) {
        return BlockRegistry.th().Vj.B(material);
    }

    public static boolean aL(Block block) {
        return BlockRegistry.th().Vj.aL(block);
    }

    public static boolean aJ(Block block) {
        return BlockRegistry.th().Vj.aJ(block);
    }

    public static boolean aM(Block block) {
        return block.getType() == Material.TALL_GRASS || block.getType() == Material.LARGE_FERN;
    }

    public static boolean aN(Block block) {
        return BlockRegistry.th().Vj.aN(block);
    }

    public static boolean aO(Block block) {
        Material material = block.getType();
        if (LocationBridgeBuilder_2.j(material) && ItemStackRegistry.isCustomBlock(block)) {
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
        return BlockRegistry.th().Vj.aQ(block);
    }

    public static int a(Chunk chunk, int n, int n2, HeightMap heightMap) {
        return BlockRegistry.th().Vj.a(chunk, n, n2, heightMap);
    }

    static {
        Vm = Maps.newHashMap();
        for (Instrument instrument : Instrument.values()) {
            Vm.put(instrument.ordinal(), instrument);
        }
    }
}
