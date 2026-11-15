package itemsadder.m;

import dev.lone.itemsadder.Main;
import io.papermc.paper.configuration.WorldConfiguration;
import itemsadder.m.ChunkWrapper;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PublicEnum;
import itemsadder.m.RecordOfString_10;
import itemsadder.m.VersionHelper;
import itemsadder.m.VersionHelper_3;
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

public class BlockNms_26_1_2_23
implements ChunkWrapper {
    static Predicate aoM;
    static Block aoN;
    static Predicate aoO;
    static Block aoP;
    static Predicate aoQ;
    static Block aoR;
    static Predicate aoS;
    static Block aoT;
    private static final HashSet apr;
    private static final HashSet aps;
    static Method aoW;

    private static Predicate L(Material material) {
        Block block = BlockNms_26_1_2_23.M(material);
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
        if (VersionHelper.Va) {
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
        LevelChunk levelChunk = BlockNms_26_1_2_23.z(chunk);
        LevelChunkSection[] levelChunkSectionArray = levelChunk.getSections();
        int n3 = chunk.getX() << 4;
        int n4 = chunk.getZ() << 4;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < levelChunkSectionArray.length; ++i) {
            int n5;
            int n6;
            LevelChunkSection levelChunkSection = levelChunkSectionArray[i];
            if (levelChunkSection == null || levelChunkSection.hasOnlyAir() || (n6 = (n5 = levelChunk.level.getSectionYFromSectionIndex(i) << 4) + 15) < n || n5 > n2) continue;
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
        LevelChunk levelChunk = BlockNms_26_1_2_23.z(chunk);
        LevelChunkSection[] levelChunkSectionArray = levelChunk.getSections();
        int n = chunk.getX() << 4;
        int n2 = chunk.getZ() << 4;
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < levelChunkSectionArray.length; ++i) {
            LevelChunkSection levelChunkSection = levelChunkSectionArray[i];
            if (levelChunkSection == null || levelChunkSection.hasOnlyAir()) continue;
            int n3 = levelChunk.level.getSectionYFromSectionIndex(i) << 4;
            boolean bl = false;
            for (Predicate predicate : apr) {
                if (!levelChunkSection.maybeHas(predicate)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            for (int j = n; j < n + 16; ++j) {
                for (int k = n2; k < n2 + 16; ++k) {
                    for (int i2 = n3; i2 < n3 + 16; ++i2) {
                        Block block = levelChunkSection.getBlockState(j & 0xF, i2 & 0xF, k & 0xF).getBlock();
                        if (!aps.contains(block)) continue;
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
        LevelChunk levelChunk = BlockNms_26_1_2_23.z(chunk);
        LevelChunkSection[] levelChunkSectionArray = levelChunk.getSections();
        int n = location.getBlockX();
        int n2 = location.getBlockZ();
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < levelChunkSectionArray.length; ++i) {
            LevelChunkSection levelChunkSection = levelChunkSectionArray[i];
            if (levelChunkSection == null || levelChunkSection.hasOnlyAir()) continue;
            int n3 = levelChunk.level.getSectionYFromSectionIndex(i) << 4;
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
        biome = this.dP(string);
        if (biome != null) {
            return biome.getKey();
        }
        return null;
    }

    @Override
    public void D(List list) {
        Field field;
        Field field2 = VersionHelper_3.b(MappedRegistry.class, Map.class, 5);
        if (field2 == null) {
            throw new RuntimeException("Error injecting blocks: field_unregisteredIntrusiveHolders is null");
        }
        RegistryAccess.Frozen frozen = MinecraftServer.getServer().registryAccess();
        MappedRegistry mappedRegistry = (MappedRegistry)frozen.lookupOrThrow(Registries.JUKEBOX_SONG);
        try {
            field = VersionHelper_3.b(MappedRegistry.class, Boolean.TYPE, 0);
            if (field == null) {
                throw new RuntimeException("Error injecting JukeboxSong: field_frozen is null");
            }
            field.set(mappedRegistry, false);
        }
        catch (IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException exception) {
            CommandSenderBridge_5.warn("Error injecting JukeboxSong: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
        try {
            field2.set(mappedRegistry, new IdentityHashMap());
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to reset unregisteredIntrusiveHolders", throwable);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        list.forEach(recordOfString_9 -> {
            try {
                float f;
                Identifier identifier = Identifier.fromNamespaceAndPath((String)recordOfString_9.pD(), (String)recordOfString_9.fN());
                ResourceKey resourceKey = ResourceKey.create((ResourceKey)Registries.JUKEBOX_SONG, (Identifier)identifier);
                Float f2 = ((RecordOfString_10)recordOfString_9.pC().getFirst()).pS();
                if (f2 == null) {
                    CommandSenderBridge_5.warn("Jukebox song '" + recordOfString_9.bj() + "' does not have a duration set. Defaulting to 10 seconds. This might be a bug.");
                }
                float f3 = f = f2 == null ? 10.0f : f2.floatValue();
                if (mappedRegistry.containsKey(resourceKey)) {
                    if (!atomicBoolean.get()) {
                        mappedRegistry.get(resourceKey).ifPresent(reference -> {
                            JukeboxSong jukeboxSong = (JukeboxSong)reference.value();
                            if (jukeboxSong.comparatorOutput() != (recordOfString_9.pH() == null ? 0 : recordOfString_9.pH()) || jukeboxSong.lengthInSeconds() != f || !jukeboxSong.description().equals(PluginBridge_6.r(recordOfString_9.pB()))) {
                                CommandSenderBridge_5.warn("Jukebox song '" + recordOfString_9.bj() + "' properties changed. Restart the server to apply.");
                                atomicBoolean.set(true);
                            }
                        });
                    }
                    return;
                }
                JukeboxSong jukeboxSong = new JukeboxSong(Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)ResourceKey.create((ResourceKey)Registries.SOUND_EVENT, (Identifier)Identifier.fromNamespaceAndPath((String)recordOfString_9.pD(), (String)recordOfString_9.fN())).identifier())), (Component)PluginBridge_6.r(recordOfString_9.pB()), f, recordOfString_9.pH() == null ? 0 : recordOfString_9.pH());
                mappedRegistry.createIntrusiveHolder((Object)jukeboxSong);
                Holder.Reference reference2 = mappedRegistry.register(resourceKey, (Object)jukeboxSong, RegistrationInfo.BUILT_IN);
                HashSet hashSet = new HashSet();
                Holder.direct((Object)jukeboxSong).tags().forEach(hashSet::add);
                Method method = VersionHelper_3.a(Holder.Reference.class, "bindTags", Collection.class);
                if (method == null) {
                    method = VersionHelper_3.a(Void.TYPE, Holder.Reference.class, PublicEnum.PACKAGE_PRIVATE, Collection.class);
                }
                if (method == null) {
                    throw new RuntimeException("Error injecting jukebox song: method_bindTags is null");
                }
                method.invoke((Object)reference2, hashSet);
                CommandSenderBridge_5.iA("Injected jukebox song into Minecraft Registry: " + recordOfString_9.bj());
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.warn("Error registering jukebox song '" + recordOfString_9.bj() + "'.");
                throw new RuntimeException(throwable);
            }
        });
        try {
            field2.set(mappedRegistry, null);
        }
        catch (IllegalAccessException illegalAccessException) {
            CommandSenderBridge_5.warn("Failed to reset unregisteredIntrusiveHolders: " + illegalAccessException.getMessage());
            throw new RuntimeException(illegalAccessException);
        }
        try {
            field.set(mappedRegistry, true);
        }
        catch (IllegalAccessException illegalAccessException) {
            CommandSenderBridge_5.warn("Failed to freeze registry: " + illegalAccessException.getMessage());
            throw new RuntimeException(illegalAccessException);
        }
    }

    static {
        if (VersionHelper.Va) {
            try {
                aoW = ServerLevel.class.getMethod("paperConfig", new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                CommandSenderBridge_5.error("Failed to get ServerLevel#paperConfig() method.", noSuchMethodException);
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
        apr = new HashSet();
        apr.addAll(Arrays.asList(BlockNms_26_1_2_23.L(Material.NOTE_BLOCK), BlockNms_26_1_2_23.L(Material.CHORUS_PLANT), BlockNms_26_1_2_23.L(Material.BROWN_MUSHROOM_BLOCK), BlockNms_26_1_2_23.L(Material.RED_MUSHROOM_BLOCK), BlockNms_26_1_2_23.L(Material.MUSHROOM_STEM), BlockNms_26_1_2_23.L(Material.TRIPWIRE)));
        aps = new HashSet();
        aps.addAll(Arrays.asList(BlockNms_26_1_2_23.M(Material.NOTE_BLOCK), BlockNms_26_1_2_23.M(Material.CHORUS_PLANT), BlockNms_26_1_2_23.M(Material.BROWN_MUSHROOM_BLOCK), BlockNms_26_1_2_23.M(Material.RED_MUSHROOM_BLOCK), BlockNms_26_1_2_23.M(Material.MUSHROOM_STEM), BlockNms_26_1_2_23.M(Material.TRIPWIRE)));
    }
}
