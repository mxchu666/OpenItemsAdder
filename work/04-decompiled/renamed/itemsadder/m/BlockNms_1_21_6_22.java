package itemsadder.m;

import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import itemsadder.m.BlockRegistry;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.InstanceHolder_4;
import itemsadder.m.LocationWrapper_2;
import itemsadder.m.Opaque008;
import itemsadder.m.SetBlockDataFunction;
import itemsadder.m.VersionHelper_3;
import itemsadder.m.WorldGeneratorBridge_8;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.Holder;
import net.minecraft.core.IRegistryCustom;
import net.minecraft.core.RegistryMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.tags.TagsBlock;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.GeneratorAccessSeed;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.Chunk;
import net.minecraft.world.level.levelgen.feature.WorldGenFeatureConfigured;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureMushroomConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WorldGenFeatureStateProvider;
import org.bukkit.HeightMap;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_21_R5.CraftWorld;

public class BlockNms_1_21_6_22
implements LocationWrapper_2 {
    private final Opaque008 aox = new Opaque008();
    RandomSource aoj = RandomSource.a();
    List Vv = Arrays.asList(Blocks.bA, Blocks.bB, Blocks.bC, Blocks.fx, Blocks.fy, Blocks.jf, Blocks.jg, Blocks.jh, Blocks.ji, Blocks.jj, Blocks.jk, Blocks.tr, Blocks.li, Blocks.bG);

    @Override
    public boolean a(Location location, TreeType treeType, SetBlockDataFunction setBlockDataFunction, boolean bl) {
        BlockPosition blockPosition;
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        WorldServer worldServer = craftWorld.getHandle();
        Chunk chunk = worldServer.d(location.getBlockX() >> 4, location.getBlockZ() >> 4);
        IBlockData iBlockData = chunk.a_(blockPosition = new BlockPosition(location.getBlockX(), bl ? BlockRegistry.a(location.getChunk(), location.getBlockX() >> 4, location.getBlockZ() >> 4, HeightMap.WORLD_SURFACE) : location.getBlockY(), location.getBlockZ()));
        if (iBlockData.n()) {
            return false;
        }
        BlockPosition blockPosition2 = new BlockPosition(blockPosition.u(), blockPosition.v() - 1, blockPosition.w());
        IBlockData iBlockData2 = chunk.a_(blockPosition2);
        if (iBlockData2.n() || iBlockData2.l() || iBlockData2.a(TagsBlock.D) || iBlockData2.a(TagsBlock.L) || this.Vv.contains(iBlockData2.b())) {
            return false;
        }
        chunk.a(blockPosition2, Blocks.i.m(), 0);
        worldServer.captureTreeGeneration = true;
        worldServer.captureBlockStates = true;
        boolean bl2 = craftWorld.generateTree((GeneratorAccessSeed)worldServer, worldServer.getMinecraftWorld().n().g(), blockPosition, this.aoj, treeType);
        worldServer.captureBlockStates = false;
        worldServer.captureTreeGeneration = false;
        if (bl2) {
            for (BlockState blockState : worldServer.capturedBlockStates.values()) {
                setBlockDataFunction.setBlockData(blockState.getBlock(), blockState.getBlockData());
            }
        }
        worldServer.capturedBlockStates.clear();
        chunk.a(blockPosition2, iBlockData2, 0);
        return bl2;
    }

    @Override
    public void vw() {
        if (!InstanceHolder_4.aoh.compareAndSet(false, true)) {
            return;
        }
        try {
            IRegistryCustom.Dimension dimension = MinecraftServer.getServer().ba();
            RegistryMaterials registryMaterials = (RegistryMaterials)dimension.f(Registries.aP);
            this.a(registryMaterials);
            this.a(registryMaterials, "huge_brown_mushroom", WorldGenerator.s, Blocks.fl.m());
            this.a(registryMaterials, "huge_red_mushroom", WorldGenerator.r, Blocks.fm.m());
        }
        catch (Throwable throwable) {
            this.vx();
            CommandSenderBridge_5.warn("Failed to inject force-default-blockstate tree features: " + throwable.getMessage());
        }
    }

    private void a(RegistryMaterials registryMaterials) {
        ResourceKey resourceKey = BlockNms_1_21_6_22.dN("chorus_plant");
        this.a(registryMaterials, resourceKey, BlockNms_1_21_6_22.a((WorldGenFeatureConfigured)registryMaterials.g(resourceKey)));
    }

    private void a(RegistryMaterials registryMaterials, String string, WorldGenerator worldGenerator, IBlockData iBlockData) {
        ResourceKey resourceKey = BlockNms_1_21_6_22.dN(string);
        WorldGenFeatureMushroomConfiguration worldGenFeatureMushroomConfiguration = (WorldGenFeatureMushroomConfiguration)((WorldGenFeatureConfigured)registryMaterials.g(resourceKey)).c();
        WorldGenFeatureMushroomConfiguration worldGenFeatureMushroomConfiguration2 = new WorldGenFeatureMushroomConfiguration((WorldGenFeatureStateProvider)WorldGenFeatureStateProvider.a((IBlockData)iBlockData), (WorldGenFeatureStateProvider)WorldGenFeatureStateProvider.a((IBlockData)Blocks.fn.m()), worldGenFeatureMushroomConfiguration.d);
        this.a(registryMaterials, resourceKey, new WorldGenFeatureConfigured(worldGenerator, (WorldGenFeatureConfiguration)worldGenFeatureMushroomConfiguration2));
    }

    @Override
    public void vx() {
        try {
            IRegistryCustom.Dimension dimension = MinecraftServer.getServer().ba();
            RegistryMaterials registryMaterials = (RegistryMaterials)dimension.f(Registries.aP);
            this.aox.a(arg_0 -> ((RegistryMaterials)registryMaterials).g(arg_0), (resourceKey, worldGenFeatureConfigured) -> BlockNms_1_21_6_22.a(registryMaterials, resourceKey, worldGenFeatureConfigured));
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.warn("Failed to restore force-default-blockstate tree features: " + throwable.getMessage());
        }
        finally {
            this.aox.clear();
            InstanceHolder_4.aoh.set(false);
        }
    }

    private void a(RegistryMaterials registryMaterials, ResourceKey resourceKey, WorldGenFeatureConfigured worldGenFeatureConfigured) {
        WorldGenFeatureConfigured worldGenFeatureConfigured2 = (WorldGenFeatureConfigured)registryMaterials.g(resourceKey);
        this.aox.a(resourceKey, worldGenFeatureConfigured2, worldGenFeatureConfigured);
        BlockNms_1_21_6_22.a(registryMaterials, resourceKey, worldGenFeatureConfigured);
    }

    private static ResourceKey dN(String string) {
        return ResourceKey.a((ResourceKey)Registries.aP, (MinecraftKey)MinecraftKey.a((String)"minecraft", (String)string));
    }

    private static WorldGenFeatureConfigured a(WorldGenFeatureConfigured worldGenFeatureConfigured) {
        WorldGenerator worldGenerator = worldGenFeatureConfigured.b();
        WorldGenFeatureEmptyConfiguration worldGenFeatureEmptyConfiguration = (WorldGenFeatureEmptyConfiguration)worldGenFeatureConfigured.c();
        return new WorldGenFeatureConfigured((WorldGenerator)new WorldGeneratorBridge_8(WorldGenFeatureEmptyConfiguration.a, worldGenerator), (WorldGenFeatureConfiguration)worldGenFeatureEmptyConfiguration);
    }

    private static GeneratorAccessSeed a(GeneratorAccessSeed generatorAccessSeed) {
        return (GeneratorAccessSeed)Proxy.newProxyInstance(GeneratorAccessSeed.class.getClassLoader(), new Class[]{GeneratorAccessSeed.class}, (object, method, objectArray) -> {
            IBlockData iBlockData;
            Object object2;
            if ("setBlock".equals(method.getName()) && objectArray != null && objectArray.length >= 3 && (object2 = objectArray[1]) instanceof IBlockData && (object2 = BlockNms_1_21_6_22.b(iBlockData = (IBlockData)object2)) != null) {
                objectArray[1] = object2;
            }
            try {
                return method.invoke((Object)generatorAccessSeed, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw invocationTargetException.getCause();
            }
        });
    }

    private static IBlockData b(IBlockData iBlockData) {
        if (iBlockData.a(Blocks.la) || iBlockData.a(Blocks.lb)) {
            return Blocks.la.m();
        }
        return null;
    }

    private static void a(RegistryMaterials registryMaterials, ResourceKey resourceKey, Object object) {
        Object object2 = registryMaterials.g(resourceKey);
        Holder.c c2 = (Holder.c)registryMaterials.a(resourceKey).orElseThrow();
        Field field = VersionHelper_3.b(Holder.c.class, Object.class, 0);
        Field field2 = VersionHelper_3.b(RegistryMaterials.class, Map.class, 2);
        Field field3 = VersionHelper_3.b(RegistryMaterials.class, Reference2IntMap.class, 0);
        if (field == null || field2 == null || field3 == null) {
            throw new NoSuchFieldException("MappedRegistry/Holder fields changed");
        }
        Map map = (Map)field2.get(registryMaterials);
        Reference2IntMap reference2IntMap = (Reference2IntMap)field3.get(registryMaterials);
        int n = registryMaterials.a(object2);
        map.remove(object2);
        reference2IntMap.removeInt(object2);
        field.set(c2, object);
        map.put(object, c2);
        reference2IntMap.put(object, n);
    }
}
