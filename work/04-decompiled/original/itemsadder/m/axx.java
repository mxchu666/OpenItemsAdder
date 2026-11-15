package itemsadder.m;

import dev.lone.itemsadder.Main;
import io.papermc.paper.configuration.WorldConfiguration;
import itemsadder.m.aaa;
import itemsadder.m.axh;
import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.ti;
import itemsadder.m.zw;
import itemsadder.m.zy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.Heightmap;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.CraftChunk;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.data.CraftBlockData;
import org.jetbrains.annotations.Nullable;

public class axx
implements axh {
    static Predicate aoM;
    static Block aoN;
    static Predicate aoO;
    static Block aoP;
    static Predicate aoQ;
    static Block aoR;
    static Predicate aoS;
    static Block aoT;
    private static final HashSet apt;
    private static final HashSet apu;
    static Method aoW;

    private static Predicate L(Material material) {
        Block block = axx.M(material);
        return blockState -> block.equals(blockState.getBlock());
    }

    public static LevelChunk z(Chunk chunk) {
        return (LevelChunk)((CraftChunk)chunk).getHandle(ChunkStatus.FULL);
    }

    private static Block M(Material material) {
        BlockState blockState = ((CraftBlockData)Bukkit.createBlockData((Material)material)).getState();
        return blockState.getBlock();
    }

    @Override
    public boolean t(World world) {
        if (Main.PH) {
            return true;
        }
        if (aaa.Va) {
            if (aoW == null) {
                return false;
            }
            ServerLevel serverLevel = ((CraftWorld)world).getHandle();
            try {
                WorldConfiguration worldConfiguration = (WorldConfiguration)aoW.invoke((Object)serverLevel, new Object[0]);
                return worldConfiguration.anticheat.antiXray.enabled;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List a(Chunk chunk, int n, int n2) {
        World world = chunk.getWorld();
        LevelChunk levelChunk = axx.z(chunk);
        LevelChunkSection[] levelChunkSectionArray = levelChunk.getSections();
        int n3 = chunk.getX() << 4;
        int n4 = chunk.getZ() << 4;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < levelChunkSectionArray.length; ++i) {
            int n5;
            int n6;
            LevelChunkSection levelChunkSection = levelChunkSectionArray[i];
            if (levelChunkSection == null || levelChunkSection.hasOnlyAir() || (n6 = (n5 = levelChunk.getLevel().getSectionYFromSectionIndex(i) << 4) + 15) < n || n5 > n2) continue;
            int n7 = Math.max(n5, n);
            int n8 = Math.min(n6, n2);
            if (!levelChunkSection.maybeHas(aoM) && !levelChunkSection.maybeHas(aoO) && !levelChunkSection.maybeHas(aoQ)) continue;
            this.a(world, levelChunk, n3, n4, arrayList, levelChunkSection, n7, n8);
        }
        return arrayList;
    }

    private void a(World world, LevelChunk levelChunk, int n, int n2, List list, LevelChunkSection levelChunkSection, int n3, int n4) {
        for (int i = 0; i < 16; ++i) {
            int n5 = n + i;
            for (int j = 0; j < 16; ++j) {
                int n6 = n2 + j;
                int n7 = levelChunk.getHeight(Heightmap.Types.WORLD_SURFACE, i, j);
                int n8 = Math.min(n4, n7);
                for (int k = n3; k <= n8; ++k) {
                    Block block = levelChunkSection.getBlockState(i, k & 0xF, j).getBlock();
                    if (block != aoN && block != aoP && block != aoR) continue;
                    list.add(world.getBlockAt(n5, k, n6));
                }
            }
        }
    }

    @Override
    public List A(Chunk chunk) {
        World world = chunk.getWorld();
        LevelChunk levelChunk = axx.z(chunk);
        LevelChunkSection[] levelChunkSectionArray = levelChunk.getSections();
        int n = chunk.getX() << 4;
        int n2 = chunk.getZ() << 4;
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < levelChunkSectionArray.length; ++i) {
            LevelChunkSection levelChunkSection = levelChunkSectionArray[i];
            if (levelChunkSection == null || levelChunkSection.hasOnlyAir()) continue;
            int n3 = levelChunk.getLevel().getSectionYFromSectionIndex(i) << 4;
            boolean bl = false;
            for (Predicate predicate : apt) {
                if (!levelChunkSection.maybeHas(predicate)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            for (int j = n; j < n + 16; ++j) {
                for (int k = n2; k < n2 + 16; ++k) {
                    for (int i2 = n3; i2 < n3 + 16; ++i2) {
                        Block block = levelChunkSection.getBlockState(j & 0xF, i2 & 0xF, k & 0xF).getBlock();
                        if (!apu.contains(block)) continue;
                        arrayList.add(new Location(world, (double)j, (double)i2, (double)k));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override
    public List aa(Location location) {
        Chunk chunk = location.getChunk();
        World world = chunk.getWorld();
        LevelChunk levelChunk = axx.z(chunk);
        LevelChunkSection[] levelChunkSectionArray = levelChunk.getSections();
        int n = location.getBlockX();
        int n2 = location.getBlockZ();
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < levelChunkSectionArray.length; ++i) {
            LevelChunkSection levelChunkSection = levelChunkSectionArray[i];
            if (levelChunkSection == null || levelChunkSection.hasOnlyAir()) continue;
            int n3 = levelChunk.getLevel().getSectionYFromSectionIndex(i) << 4;
            if (!levelChunkSection.maybeHas(aoS)) continue;
            for (int j = n3; j < n3 + 16; ++j) {
                Block block = levelChunkSection.getBlockState(n & 0xF, j & 0xF, n2 & 0xF).getBlock();
                if (block != aoT) continue;
                arrayList.add(new Location(world, (double)n, (double)j, (double)n2));
            }
        }
        return arrayList;
    }

    @Override
    @Nullable
    public Object bg(org.bukkit.block.Block block) {
        Location location = block.getLocation();
        World world = location.getWorld();
        if (world == null) {
            return null;
        }
        int n = location.getBlockX();
        int n2 = location.getBlockY();
        int n3 = location.getBlockZ();
        ServerLevel serverLevel = ((CraftWorld)world).getHandle();
        Optional optional = serverLevel.getNoiseBiome(n >> 2, n2 >> 2, n3 >> 2).unwrapKey();
        if (optional.isEmpty()) {
            return null;
        }
        ResourceKey resourceKey = (ResourceKey)optional.get();
        return resourceKey.identifier();
    }

    @Override
    public Object j(NamespacedKey namespacedKey) {
        return Identifier.fromNamespaceAndPath((String)namespacedKey.getNamespace(), (String)namespacedKey.getKey());
    }

    @Override
    public NamespacedKey dO(String string) {
        if (string == null) {
            return null;
        }
        Biome biome = (Biome)Registry.BIOME.get(NamespacedKey.fromString((String)string.toLowerCase(Locale.ROOT)));
        if (biome != null) {
            return biome.getKey();
        }
        switch (string) {
            case "NETHER": {
                Biome biome2 = Biome.NETHER_WASTES;
                break;
            }
            case "TALL_BIRCH_FOREST": {
                Biome biome2 = Biome.OLD_GROWTH_BIRCH_FOREST;
                break;
            }
            case "GIANT_TREE_TAIGA": {
                Biome biome2 = Biome.OLD_GROWTH_PINE_TAIGA;
                break;
            }
            case "GIANT_SPRUCE_TAIGA": {
                Biome biome2 = Biome.OLD_GROWTH_SPRUCE_TAIGA;
                break;
            }
            case "SNOWY_TUNDRA": {
                Biome biome2 = Biome.SNOWY_PLAINS;
                break;
            }
            case "JUNGLE_EDGE": {
                Biome biome2 = Biome.SPARSE_JUNGLE;
                break;
            }
            case "STONE_SHORE": {
                Biome biome2 = Biome.STONY_SHORE;
                break;
            }
            case "MOUNTAINS": {
                Biome biome2 = Biome.WINDSWEPT_HILLS;
                break;
            }
            case "WOODED_MOUNTAINS": {
                Biome biome2 = Biome.WINDSWEPT_FOREST;
                break;
            }
            case "GRAVELLY_MOUNTAINS": {
                Biome biome2 = Biome.WINDSWEPT_GRAVELLY_HILLS;
                break;
            }
            case "SHATTERED_SAVANNA": {
                Biome biome2 = Biome.WINDSWEPT_SAVANNA;
                break;
            }
            case "WOODED_BADLANDS_PLATEAU": {
                Biome biome2 = Biome.WOODED_BADLANDS;
                break;
            }
            case "MOUNTAIN_EDGE": {
                Biome biome2 = Biome.WINDSWEPT_HILLS;
                break;
            }
            case "DESERT_HILLS": {
                Biome biome2 = Biome.DESERT;
                break;
            }
            case "TAIGA_HILLS": {
                Biome biome2 = Biome.TAIGA;
                break;
            }
            case "BIRCH_FOREST_HILLS": {
                Biome biome2 = Biome.BIRCH_FOREST;
                break;
            }
            case "DESERT_LAKES ": {
                Biome biome2 = Biome.DESERT;
                break;
            }
            case "TALL_BIRCH_HILLS": {
                Biome biome2 = Biome.OLD_GROWTH_BIRCH_FOREST;
                break;
            }
            case "EXTREME_HILLS": {
                Biome biome2 = Biome.WINDSWEPT_HILLS;
                break;
            }
            case "SWAMPLAND": {
                Biome biome2 = Biome.SWAMP;
                break;
            }
            case "HELL": {
                Biome biome2 = Biome.NETHER_WASTES;
                break;
            }
            case "SKY": {
                Biome biome2 = Biome.THE_END;
                break;
            }
            case "ICE_FLATS": {
                Biome biome2 = Biome.SNOWY_PLAINS;
                break;
            }
            case "ICE_MOUNTAINS": {
                Biome biome2 = Biome.SNOWY_SLOPES;
                break;
            }
            case "MUSHROOM_ISLAND": {
                Biome biome2 = Biome.MUSHROOM_FIELDS;
                break;
            }
            case "MUSHROOM_ISLAND_SHORE": {
                Biome biome2 = Biome.MUSHROOM_FIELDS;
                break;
            }
            case "BEACHES": {
                Biome biome2 = Biome.BEACH;
                break;
            }
            case "FOREST_HILLS": {
                Biome biome2 = Biome.WINDSWEPT_FOREST;
                break;
            }
            case "SMALLER_EXTREME_HILLS": {
                Biome biome2 = Biome.WINDSWEPT_HILLS;
                break;
            }
            case "STONE_BEACH": {
                Biome biome2 = Biome.STONY_SHORE;
                break;
            }
            case "COLD_BEACH": {
                Biome biome2 = Biome.SNOWY_BEACH;
                break;
            }
            case "ROOFED_FOREST": {
                Biome biome2 = Biome.DARK_FOREST;
                break;
            }
            case "TAIGA_COLD": {
                Biome biome2 = Biome.SNOWY_TAIGA;
                break;
            }
            case "TAIGA_COLD_HILLS": {
                Biome biome2 = Biome.SNOWY_TAIGA;
                break;
            }
            case "REDWOOD_TAIGA": {
                Biome biome2 = Biome.OLD_GROWTH_PINE_TAIGA;
                break;
            }
            case "REDWOOD_TAIGA_HILLS": {
                Biome biome2 = Biome.OLD_GROWTH_PINE_TAIGA;
                break;
            }
            case "EXTREME_HILLS_WITH_TREES": {
                Biome biome2 = Biome.WINDSWEPT_FOREST;
                break;
            }
            case "SAVANNA_ROCK": {
                Biome biome2 = Biome.SAVANNA_PLATEAU;
                break;
            }
            case "MESA": {
                Biome biome2 = Biome.BADLANDS;
                break;
            }
            case "MESA_ROCK": {
                Biome biome2 = Biome.WOODED_BADLANDS;
                break;
            }
            case "MESA_CLEAR_ROCK": {
                Biome biome2 = Biome.BADLANDS;
                break;
            }
            case "SKY_ISLAND_LOW": {
                Biome biome2 = Biome.SMALL_END_ISLANDS;
                break;
            }
            case "SKY_ISLAND_MEDIUM": {
                Biome biome2 = Biome.END_MIDLANDS;
                break;
            }
            case "SKY_ISLAND_HIGH": {
                Biome biome2 = Biome.END_HIGHLANDS;
                break;
            }
            case "SKY_ISLAND_BARREN": {
                Biome biome2 = Biome.END_BARRENS;
                break;
            }
            case "VOID": {
                Biome biome2 = Biome.THE_VOID;
                break;
            }
            case "MUTATED_PLAINS": {
                Biome biome2 = Biome.SUNFLOWER_PLAINS;
                break;
            }
            case "MUTATED_DESERT": {
                Biome biome2 = Biome.DESERT;
                break;
            }
            case "MUTATED_EXTREME_HILLS": {
                Biome biome2 = Biome.WINDSWEPT_GRAVELLY_HILLS;
                break;
            }
            case "MUTATED_FOREST": {
                Biome biome2 = Biome.FLOWER_FOREST;
                break;
            }
            case "MUTATED_TAIGA": {
                Biome biome2 = Biome.TAIGA;
                break;
            }
            case "MUTATED_SWAMPLAND": {
                Biome biome2 = Biome.SWAMP;
                break;
            }
            case "MUTATED_ICE_FLATS": {
                Biome biome2 = Biome.ICE_SPIKES;
                break;
            }
            case "MUTATED_JUNGLE": {
                Biome biome2 = Biome.JUNGLE;
                break;
            }
            case "MUTATED_JUNGLE_EDGE": {
                Biome biome2 = Biome.SPARSE_JUNGLE;
                break;
            }
            case "MUTATED_BIRCH_FOREST": {
                Biome biome2 = Biome.OLD_GROWTH_BIRCH_FOREST;
                break;
            }
            case "MUTATED_BIRCH_FOREST_HILLS": {
                Biome biome2 = Biome.OLD_GROWTH_BIRCH_FOREST;
                break;
            }
            case "MUTATED_ROOFED_FOREST": {
                Biome biome2 = Biome.DARK_FOREST;
                break;
            }
            case "MUTATED_TAIGA_COLD": {
                Biome biome2 = Biome.SNOWY_TAIGA;
                break;
            }
            case "MUTATED_REDWOOD_TAIGA": {
                Biome biome2 = Biome.OLD_GROWTH_SPRUCE_TAIGA;
                break;
            }
            case "MUTATED_REDWOOD_TAIGA_HILLS": {
                Biome biome2 = Biome.OLD_GROWTH_SPRUCE_TAIGA;
                break;
            }
            case "MUTATED_EXTREME_HILLS_WITH_TREES": {
                Biome biome2 = Biome.WINDSWEPT_GRAVELLY_HILLS;
                break;
            }
            case "MUTATED_SAVANNA": {
                Biome biome2 = Biome.WINDSWEPT_SAVANNA;
                break;
            }
            case "MUTATED_SAVANNA_ROCK": {
                Biome biome2 = Biome.WINDSWEPT_SAVANNA;
                break;
            }
            case "MUTATED_MESA": {
                Biome biome2 = Biome.ERODED_BADLANDS;
                break;
            }
            case "MUTATED_MESA_ROCK": {
                Biome biome2 = Biome.WOODED_BADLANDS;
                break;
            }
            case "MUTATED_MESA_CLEAR_ROCK": {
                Biome biome2 = Biome.BADLANDS;
                break;
            }
            case "WARM_DEEP_OCEAN": {
                Biome biome2 = Biome.DEEP_LUKEWARM_OCEAN;
                break;
            }
            case "LUKEWARM_DEEP_OCEAN": {
                Biome biome2 = Biome.DEEP_LUKEWARM_OCEAN;
                break;
            }
            case "COLD_DEEP_OCEAN": {
                Biome biome2 = Biome.DEEP_COLD_OCEAN;
                break;
            }
            case "FROZEN_DEEP_OCEAN": {
                Biome biome2 = Biome.DEEP_FROZEN_OCEAN;
                break;
            }
            case "DEEP_WARM_OCEAN": {
                Biome biome2 = Biome.WARM_OCEAN;
                break;
            }
            case "JUNGLE_HILLS": {
                Biome biome2 = Biome.JUNGLE;
                break;
            }
            case "BIRCH_HILLS": {
                Biome biome2 = Biome.BIRCH_FOREST;
                break;
            }
            case "SWAMP_HILLS": {
                Biome biome2 = Biome.SWAMP;
                break;
            }
            case "MODIFIED_JUNGLE": {
                Biome biome2 = Biome.JUNGLE;
                break;
            }
            case "DARK_FOREST_HILLS": {
                Biome biome2 = Biome.DARK_FOREST;
                break;
            }
            case "MODIFIED_JUNGLE_EDGE": {
                Biome biome2 = Biome.JUNGLE;
                break;
            }
            case "TAIGA_MOUNTAINS": {
                Biome biome2 = Biome.TAIGA;
                break;
            }
            case "SNOWY_TAIGA_MOUNTAINS": {
                Biome biome2 = Biome.SNOWY_TAIGA;
                break;
            }
            default: {
                Biome biome2 = biome = null;
            }
        }
        if (biome != null) {
            return biome.getKey();
        }
        return null;
    }

    @Override
    public void D(List list) {
        Field field;
        Field field2 = zw.b(MappedRegistry.class, Map.class, 5);
        if (field2 == null) {
            throw new RuntimeException("Error injecting blocks: field_unregisteredIntrusiveHolders is null");
        }
        RegistryAccess.Frozen frozen = MinecraftServer.getServer().registryAccess();
        MappedRegistry mappedRegistry = (MappedRegistry)frozen.lookupOrThrow(Registries.JUKEBOX_SONG);
        try {
            field = zw.b(MappedRegistry.class, Boolean.TYPE, 0);
            if (field == null) {
                throw new RuntimeException("Error injecting JukeboxSong: field_frozen is null");
            }
            field.set(mappedRegistry, false);
        }
        catch (IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException exception) {
            bce.warn("Error injecting JukeboxSong: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
        try {
            field2.set(mappedRegistry, new IdentityHashMap());
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to reset unregisteredIntrusiveHolders", throwable);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        list.forEach(tg2 -> {
            try {
                float f;
                Identifier identifier = Identifier.fromNamespaceAndPath((String)tg2.pD(), (String)tg2.fN());
                ResourceKey resourceKey = ResourceKey.create((ResourceKey)Registries.JUKEBOX_SONG, (Identifier)identifier);
                Float f2 = ((ti)tg2.pC().getFirst()).pS();
                if (f2 == null) {
                    bce.warn("Jukebox song '" + tg2.bj() + "' does not have a duration set. Defaulting to 10 seconds. This might be a bug.");
                }
                float f3 = f = f2 == null ? 10.0f : f2.floatValue();
                if (mappedRegistry.containsKey(resourceKey)) {
                    if (!atomicBoolean.get()) {
                        mappedRegistry.get(resourceKey).ifPresent(reference -> {
                            JukeboxSong jukeboxSong = (JukeboxSong)reference.value();
                            if (jukeboxSong.comparatorOutput() != (tg2.pH() == null ? 0 : tg2.pH()) || jukeboxSong.lengthInSeconds() != f || !jukeboxSong.description().equals(bbe.r(tg2.pB()))) {
                                bce.warn("Jukebox song '" + tg2.bj() + "' properties changed. Restart the server to apply.");
                                atomicBoolean.set(true);
                            }
                        });
                    }
                    return;
                }
                JukeboxSong jukeboxSong = new JukeboxSong(Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)ResourceKey.create((ResourceKey)Registries.SOUND_EVENT, (Identifier)Identifier.fromNamespaceAndPath((String)tg2.pD(), (String)tg2.fN())).identifier())), (Component)bbe.r(tg2.pB()), f, tg2.pH() == null ? 0 : tg2.pH());
                mappedRegistry.createIntrusiveHolder((Object)jukeboxSong);
                Holder.Reference reference2 = mappedRegistry.register(resourceKey, (Object)jukeboxSong, RegistrationInfo.BUILT_IN);
                HashSet hashSet = new HashSet();
                Holder.direct((Object)jukeboxSong).tags().forEach(hashSet::add);
                Method method = zw.a(Holder.Reference.class, "bindTags", Collection.class);
                if (method == null) {
                    method = zw.a(Void.TYPE, Holder.Reference.class, zy.PACKAGE_PRIVATE, Collection.class);
                }
                if (method == null) {
                    throw new RuntimeException("Error injecting jukebox song: method_bindTags is null");
                }
                method.invoke((Object)reference2, hashSet);
                bce.iA("Injected jukebox song into Minecraft Registry: " + tg2.bj());
            }
            catch (Throwable throwable) {
                bce.warn("Error registering jukebox song '" + tg2.bj() + "'.");
                throw new RuntimeException(throwable);
            }
        });
        try {
            field2.set(mappedRegistry, null);
        }
        catch (IllegalAccessException illegalAccessException) {
            bce.warn("Failed to reset unregisteredIntrusiveHolders: " + illegalAccessException.getMessage());
            throw new RuntimeException(illegalAccessException);
        }
        try {
            field.set(mappedRegistry, true);
        }
        catch (IllegalAccessException illegalAccessException) {
            bce.warn("Failed to freeze registry: " + illegalAccessException.getMessage());
            throw new RuntimeException(illegalAccessException);
        }
    }

    static {
        if (aaa.Va) {
            try {
                aoW = ServerLevel.class.getMethod("paperConfig", new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                bce.error("Failed to get ServerLevel#paperConfig() method.", noSuchMethodException);
            }
        }
        BlockState blockState3 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.CAVE_AIR)).getState();
        aoN = blockState3.getBlock();
        aoM = blockState2 -> Objects.equals(blockState2, blockState3);
        BlockState blockState4 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.AIR)).getState();
        aoP = blockState4.getBlock();
        aoO = blockState2 -> Objects.equals(blockState2, blockState4);
        BlockState blockState5 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.VOID_AIR)).getState();
        aoR = blockState5.getBlock();
        aoQ = blockState2 -> Objects.equals(blockState2, blockState5);
        BlockState blockState6 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.NOTE_BLOCK)).getState();
        aoT = blockState6.getBlock();
        aoS = blockState -> aoT.equals(blockState.getBlock());
        apt = new HashSet();
        apt.addAll(Arrays.asList(axx.L(Material.NOTE_BLOCK), axx.L(Material.CHORUS_PLANT), axx.L(Material.BROWN_MUSHROOM_BLOCK), axx.L(Material.RED_MUSHROOM_BLOCK), axx.L(Material.MUSHROOM_STEM), axx.L(Material.TRIPWIRE)));
        apu = new HashSet();
        apu.addAll(Arrays.asList(axx.M(Material.NOTE_BLOCK), axx.M(Material.CHORUS_PLANT), axx.M(Material.BROWN_MUSHROOM_BLOCK), axx.M(Material.RED_MUSHROOM_BLOCK), axx.M(Material.MUSHROOM_STEM), axx.M(Material.TRIPWIRE)));
    }
}
