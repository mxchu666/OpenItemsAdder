package itemsadder.m;

import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface axh {
    default public void vw() {
        throw new RuntimeException("Not implemented yet");
    }

    public boolean t(World var1);

    default public List a(Chunk chunk, int n, int n2) {
        return new ArrayList();
    }

    public List A(Chunk var1);

    public List aa(Location var1);

    @Nullable
    public Object bg(Block var1);

    public Object j(NamespacedKey var1);

    public NamespacedKey dO(String var1);

    public void D(List var1);

    default public TNTPrimed a(Location location, int n, @NotNull BlockData blockData, @Nullable Player player, @Nullable Consumer consumer) {
        return (TNTPrimed)location.getWorld().spawn(location, TNTPrimed.class, tNTPrimed -> {
            if (zw.sZ()) {
                tNTPrimed.setBlockData(blockData);
            }
            tNTPrimed.setSource((Entity)player);
            tNTPrimed.setFuseTicks(n);
            if (consumer != null) {
                consumer.accept(tNTPrimed);
            }
        });
    }

    default public Biome dP(String string) {
        return switch (string) {
            case "NETHER" -> Biome.NETHER_WASTES;
            case "TALL_BIRCH_FOREST" -> Biome.OLD_GROWTH_BIRCH_FOREST;
            case "GIANT_TREE_TAIGA" -> Biome.OLD_GROWTH_PINE_TAIGA;
            case "GIANT_SPRUCE_TAIGA" -> Biome.OLD_GROWTH_SPRUCE_TAIGA;
            case "SNOWY_TUNDRA" -> Biome.SNOWY_PLAINS;
            case "JUNGLE_EDGE" -> Biome.SPARSE_JUNGLE;
            case "STONE_SHORE" -> Biome.STONY_SHORE;
            case "MOUNTAINS" -> Biome.WINDSWEPT_HILLS;
            case "WOODED_MOUNTAINS" -> Biome.WINDSWEPT_FOREST;
            case "GRAVELLY_MOUNTAINS" -> Biome.WINDSWEPT_GRAVELLY_HILLS;
            case "SHATTERED_SAVANNA" -> Biome.WINDSWEPT_SAVANNA;
            case "WOODED_BADLANDS_PLATEAU" -> Biome.WOODED_BADLANDS;
            case "MOUNTAIN_EDGE" -> Biome.WINDSWEPT_HILLS;
            case "DESERT_HILLS" -> Biome.DESERT;
            case "TAIGA_HILLS" -> Biome.TAIGA;
            case "BIRCH_FOREST_HILLS" -> Biome.BIRCH_FOREST;
            case "DESERT_LAKES " -> Biome.DESERT;
            case "TALL_BIRCH_HILLS" -> Biome.OLD_GROWTH_BIRCH_FOREST;
            case "EXTREME_HILLS" -> Biome.WINDSWEPT_HILLS;
            case "SWAMPLAND" -> Biome.SWAMP;
            case "HELL" -> Biome.NETHER_WASTES;
            case "SKY" -> Biome.THE_END;
            case "ICE_FLATS" -> Biome.SNOWY_PLAINS;
            case "ICE_MOUNTAINS" -> Biome.SNOWY_SLOPES;
            case "MUSHROOM_ISLAND" -> Biome.MUSHROOM_FIELDS;
            case "MUSHROOM_ISLAND_SHORE" -> Biome.MUSHROOM_FIELDS;
            case "BEACHES" -> Biome.BEACH;
            case "FOREST_HILLS" -> Biome.WINDSWEPT_FOREST;
            case "SMALLER_EXTREME_HILLS" -> Biome.WINDSWEPT_HILLS;
            case "STONE_BEACH" -> Biome.STONY_SHORE;
            case "COLD_BEACH" -> Biome.SNOWY_BEACH;
            case "ROOFED_FOREST" -> Biome.DARK_FOREST;
            case "TAIGA_COLD" -> Biome.SNOWY_TAIGA;
            case "TAIGA_COLD_HILLS" -> Biome.SNOWY_TAIGA;
            case "REDWOOD_TAIGA" -> Biome.OLD_GROWTH_PINE_TAIGA;
            case "REDWOOD_TAIGA_HILLS" -> Biome.OLD_GROWTH_PINE_TAIGA;
            case "EXTREME_HILLS_WITH_TREES" -> Biome.WINDSWEPT_FOREST;
            case "SAVANNA_ROCK" -> Biome.SAVANNA_PLATEAU;
            case "MESA" -> Biome.BADLANDS;
            case "MESA_ROCK" -> Biome.WOODED_BADLANDS;
            case "MESA_CLEAR_ROCK" -> Biome.BADLANDS;
            case "SKY_ISLAND_LOW" -> Biome.SMALL_END_ISLANDS;
            case "SKY_ISLAND_MEDIUM" -> Biome.END_MIDLANDS;
            case "SKY_ISLAND_HIGH" -> Biome.END_HIGHLANDS;
            case "SKY_ISLAND_BARREN" -> Biome.END_BARRENS;
            case "VOID" -> Biome.THE_VOID;
            case "MUTATED_PLAINS" -> Biome.SUNFLOWER_PLAINS;
            case "MUTATED_DESERT" -> Biome.DESERT;
            case "MUTATED_EXTREME_HILLS" -> Biome.WINDSWEPT_GRAVELLY_HILLS;
            case "MUTATED_FOREST" -> Biome.FLOWER_FOREST;
            case "MUTATED_TAIGA" -> Biome.TAIGA;
            case "MUTATED_SWAMPLAND" -> Biome.SWAMP;
            case "MUTATED_ICE_FLATS" -> Biome.ICE_SPIKES;
            case "MUTATED_JUNGLE" -> Biome.JUNGLE;
            case "MUTATED_JUNGLE_EDGE" -> Biome.SPARSE_JUNGLE;
            case "MUTATED_BIRCH_FOREST" -> Biome.OLD_GROWTH_BIRCH_FOREST;
            case "MUTATED_BIRCH_FOREST_HILLS" -> Biome.OLD_GROWTH_BIRCH_FOREST;
            case "MUTATED_ROOFED_FOREST" -> Biome.DARK_FOREST;
            case "MUTATED_TAIGA_COLD" -> Biome.SNOWY_TAIGA;
            case "MUTATED_REDWOOD_TAIGA" -> Biome.OLD_GROWTH_SPRUCE_TAIGA;
            case "MUTATED_REDWOOD_TAIGA_HILLS" -> Biome.OLD_GROWTH_SPRUCE_TAIGA;
            case "MUTATED_EXTREME_HILLS_WITH_TREES" -> Biome.WINDSWEPT_GRAVELLY_HILLS;
            case "MUTATED_SAVANNA" -> Biome.WINDSWEPT_SAVANNA;
            case "MUTATED_SAVANNA_ROCK" -> Biome.WINDSWEPT_SAVANNA;
            case "MUTATED_MESA" -> Biome.ERODED_BADLANDS;
            case "MUTATED_MESA_ROCK" -> Biome.WOODED_BADLANDS;
            case "MUTATED_MESA_CLEAR_ROCK" -> Biome.BADLANDS;
            case "WARM_DEEP_OCEAN" -> Biome.DEEP_LUKEWARM_OCEAN;
            case "LUKEWARM_DEEP_OCEAN" -> Biome.DEEP_LUKEWARM_OCEAN;
            case "COLD_DEEP_OCEAN" -> Biome.DEEP_COLD_OCEAN;
            case "FROZEN_DEEP_OCEAN" -> Biome.DEEP_FROZEN_OCEAN;
            case "DEEP_WARM_OCEAN" -> Biome.WARM_OCEAN;
            case "JUNGLE_HILLS" -> Biome.JUNGLE;
            case "BIRCH_HILLS" -> Biome.BIRCH_FOREST;
            case "SWAMP_HILLS" -> Biome.SWAMP;
            case "MODIFIED_JUNGLE" -> Biome.JUNGLE;
            case "DARK_FOREST_HILLS" -> Biome.DARK_FOREST;
            case "MODIFIED_JUNGLE_EDGE" -> Biome.JUNGLE;
            case "TAIGA_MOUNTAINS" -> Biome.TAIGA;
            case "SNOWY_TAIGA_MOUNTAINS" -> Biome.SNOWY_TAIGA;
            default -> null;
        };
    }
}
