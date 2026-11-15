package itemsadder.m;

import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import itemsadder.m.BlockRegistry;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.FeatureBridge;
import itemsadder.m.InstanceHolder_4;
import itemsadder.m.LocationWrapper_2;
import itemsadder.m.Opaque008;
import itemsadder.m.SetBlockDataFunction;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.bukkit.HeightMap;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.CraftWorld;

public class BlockNms_26_1_1_22
implements LocationWrapper_2 {
    private final Opaque008 aoD = new Opaque008();
    RandomSource aoj = RandomSource.create();
    List Vv = Arrays.asList(Blocks.SHORT_GRASS, Blocks.FERN, Blocks.DEAD_BUSH, Blocks.VINE, Blocks.GLOW_LICHEN, Blocks.SUNFLOWER, Blocks.LILAC, Blocks.ROSE_BUSH, Blocks.PEONY, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.HANGING_ROOTS, Blocks.PITCHER_PLANT, Blocks.SEAGRASS);

    @Override
    public boolean a(Location location, TreeType treeType, SetBlockDataFunction setBlockDataFunction, boolean bl) {
        BlockPos blockPos;
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        ServerLevel serverLevel = craftWorld.getHandle();
        LevelChunk levelChunk = serverLevel.getChunk(location.getBlockX() >> 4, location.getBlockZ() >> 4);
        net.minecraft.world.level.block.state.BlockState blockState = levelChunk.getBlockState(blockPos = new BlockPos(location.getBlockX(), bl ? BlockRegistry.a(location.getChunk(), location.getBlockX() >> 4, location.getBlockZ() >> 4, HeightMap.WORLD_SURFACE) : location.getBlockY(), location.getBlockZ()));
        if (blockState.liquid()) {
            return false;
        }
        BlockPos blockPos2 = new BlockPos(blockPos.getX(), blockPos.getY() - 1, blockPos.getZ());
        net.minecraft.world.level.block.state.BlockState blockState2 = levelChunk.getBlockState(blockPos2);
        if (blockState2.liquid() || blockState2.isAir() || blockState2.is(BlockTags.LOGS) || blockState2.is(BlockTags.LEAVES) || this.Vv.contains(blockState2.getBlock())) {
            return false;
        }
        levelChunk.setBlockState(blockPos2, Blocks.GRASS_BLOCK.defaultBlockState(), 0);
        serverLevel.captureTreeGeneration = true;
        serverLevel.captureBlockStates = true;
        boolean bl2 = craftWorld.generateTree((WorldGenLevel)serverLevel, serverLevel.getMinecraftWorld().getChunkSource().getGenerator(), blockPos, this.aoj, treeType);
        serverLevel.captureBlockStates = false;
        serverLevel.captureTreeGeneration = false;
        if (bl2) {
            for (BlockState blockState3 : serverLevel.capturedBlockStates.values()) {
                setBlockDataFunction.setBlockData(blockState3.getBlock(), blockState3.getBlockData());
            }
        }
        serverLevel.capturedBlockStates.clear();
        levelChunk.setBlockState(blockPos2, blockState2, 0);
        return bl2;
    }

    @Override
    public void vw() {
        if (!InstanceHolder_4.aoh.compareAndSet(false, true)) {
            return;
        }
        try {
            RegistryAccess.Frozen frozen = MinecraftServer.getServer().registryAccess();
            MappedRegistry mappedRegistry = (MappedRegistry)frozen.lookupOrThrow(Registries.CONFIGURED_FEATURE);
            this.a(mappedRegistry);
            this.a(mappedRegistry, "huge_brown_mushroom", Feature.HUGE_BROWN_MUSHROOM, Blocks.BROWN_MUSHROOM_BLOCK.defaultBlockState());
            this.a(mappedRegistry, "huge_red_mushroom", Feature.HUGE_RED_MUSHROOM, Blocks.RED_MUSHROOM_BLOCK.defaultBlockState());
        }
        catch (Throwable throwable) {
            this.vx();
            CommandSenderBridge_5.warn("Failed to inject force-default-blockstate tree features: " + throwable.getMessage());
        }
    }

    private void a(MappedRegistry mappedRegistry) {
        ResourceKey resourceKey = BlockNms_26_1_1_22.dN("chorus_plant");
        this.a(mappedRegistry, resourceKey, BlockNms_26_1_1_22.a((ConfiguredFeature)mappedRegistry.getValueOrThrow(resourceKey)));
    }

    private void a(MappedRegistry mappedRegistry, String string, Feature feature, net.minecraft.world.level.block.state.BlockState blockState) {
        ResourceKey resourceKey = BlockNms_26_1_1_22.dN(string);
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfiguration = (HugeMushroomFeatureConfiguration)((ConfiguredFeature)mappedRegistry.getValueOrThrow(resourceKey)).config();
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfiguration2 = new HugeMushroomFeatureConfiguration((BlockStateProvider)BlockStateProvider.simple((net.minecraft.world.level.block.state.BlockState)blockState), (BlockStateProvider)BlockStateProvider.simple((net.minecraft.world.level.block.state.BlockState)Blocks.MUSHROOM_STEM.defaultBlockState()), hugeMushroomFeatureConfiguration.foliageRadius(), hugeMushroomFeatureConfiguration.canPlaceOn());
        this.a(mappedRegistry, resourceKey, new ConfiguredFeature(feature, (FeatureConfiguration)hugeMushroomFeatureConfiguration2));
    }

    @Override
    public void vx() {
        try {
            RegistryAccess.Frozen frozen = MinecraftServer.getServer().registryAccess();
            MappedRegistry mappedRegistry = (MappedRegistry)frozen.lookupOrThrow(Registries.CONFIGURED_FEATURE);
            this.aoD.a(arg_0 -> ((MappedRegistry)mappedRegistry).getValueOrThrow(arg_0), (resourceKey, configuredFeature) -> BlockNms_26_1_1_22.a(mappedRegistry, resourceKey, configuredFeature));
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.warn("Failed to restore force-default-blockstate tree features: " + throwable.getMessage());
        }
        finally {
            this.aoD.clear();
            InstanceHolder_4.aoh.set(false);
        }
    }

    private void a(MappedRegistry mappedRegistry, ResourceKey resourceKey, ConfiguredFeature configuredFeature) {
        ConfiguredFeature configuredFeature2 = (ConfiguredFeature)mappedRegistry.getValueOrThrow(resourceKey);
        this.aoD.a(resourceKey, configuredFeature2, configuredFeature);
        BlockNms_26_1_1_22.a(mappedRegistry, resourceKey, configuredFeature);
    }

    private static ResourceKey dN(String string) {
        return ResourceKey.create((ResourceKey)Registries.CONFIGURED_FEATURE, (Identifier)Identifier.fromNamespaceAndPath((String)"minecraft", (String)string));
    }

    private static ConfiguredFeature a(ConfiguredFeature configuredFeature) {
        Feature feature = configuredFeature.feature();
        NoneFeatureConfiguration noneFeatureConfiguration = (NoneFeatureConfiguration)configuredFeature.config();
        return new ConfiguredFeature((Feature)new FeatureBridge(NoneFeatureConfiguration.CODEC, feature), (FeatureConfiguration)noneFeatureConfiguration);
    }

    private static WorldGenLevel a(WorldGenLevel worldGenLevel) {
        return (WorldGenLevel)Proxy.newProxyInstance(WorldGenLevel.class.getClassLoader(), new Class[]{WorldGenLevel.class}, (object, method, objectArray) -> {
            net.minecraft.world.level.block.state.BlockState blockState;
            Object object2;
            if ("setBlock".equals(method.getName()) && objectArray != null && objectArray.length >= 3 && (object2 = objectArray[1]) instanceof net.minecraft.world.level.block.state.BlockState && (object2 = BlockNms_26_1_1_22.b(blockState = (net.minecraft.world.level.block.state.BlockState)object2)) != null) {
                objectArray[1] = object2;
            }
            try {
                return method.invoke((Object)worldGenLevel, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw invocationTargetException.getCause();
            }
        });
    }

    private static net.minecraft.world.level.block.state.BlockState b(net.minecraft.world.level.block.state.BlockState blockState) {
        if (blockState.is((Object)Blocks.CHORUS_PLANT) || blockState.is((Object)Blocks.CHORUS_FLOWER)) {
            return Blocks.CHORUS_PLANT.defaultBlockState();
        }
        return null;
    }

    private static void a(MappedRegistry mappedRegistry, ResourceKey resourceKey, Object object) {
        Object object2 = mappedRegistry.getValueOrThrow(resourceKey);
        Holder.Reference reference = (Holder.Reference)mappedRegistry.get(resourceKey).orElseThrow();
        Field field = VersionHelper_3.b(Holder.Reference.class, Object.class, 0);
        Field field2 = VersionHelper_3.b(MappedRegistry.class, Map.class, 2);
        Field field3 = VersionHelper_3.b(MappedRegistry.class, Reference2IntMap.class, 0);
        if (field == null || field2 == null || field3 == null) {
            throw new NoSuchFieldException("MappedRegistry/Holder fields changed");
        }
        Map map = (Map)field2.get(mappedRegistry);
        Reference2IntMap reference2IntMap = (Reference2IntMap)field3.get(mappedRegistry);
        int n = mappedRegistry.getId(object2);
        map.remove(object2);
        reference2IntMap.removeInt(object2);
        field.set(reference, object);
        map.put(object, reference);
        reference2IntMap.put(object, n);
    }
}
