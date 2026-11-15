package itemsadder.m;

import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import itemsadder.m.aaf;
import itemsadder.m.awb;
import itemsadder.m.awc;
import itemsadder.m.awd;
import itemsadder.m.awg;
import itemsadder.m.awk;
import itemsadder.m.bce;
import itemsadder.m.zw;
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
import org.bukkit.craftbukkit.v1_21_R1.CraftWorld;

public class awj
implements awc {
    private final awd aol = new awd();
    RandomSource aoj = RandomSource.a();
    List Vv = Arrays.asList(Blocks.bt, Blocks.bu, Blocks.bv, Blocks.ff, Blocks.fg, Blocks.iD, Blocks.iE, Blocks.iF, Blocks.iG, Blocks.iH, Blocks.iI, Blocks.sG, Blocks.kC, Blocks.bw);

    @Override
    public boolean a(Location location, TreeType treeType, awb awb2, boolean bl) {
        BlockPosition blockPosition;
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        WorldServer worldServer = craftWorld.getHandle();
        Chunk chunk = worldServer.d(location.getBlockX() >> 4, location.getBlockZ() >> 4);
        IBlockData iBlockData = chunk.a_(blockPosition = new BlockPosition(location.getBlockX(), bl ? aaf.a(location.getChunk(), location.getBlockX() >> 4, location.getBlockZ() >> 4, HeightMap.WORLD_SURFACE) : location.getBlockY(), location.getBlockZ()));
        if (iBlockData.k()) {
            return false;
        }
        BlockPosition blockPosition2 = new BlockPosition(blockPosition.u(), blockPosition.v() - 1, blockPosition.w());
        IBlockData iBlockData2 = chunk.a_(blockPosition2);
        if (iBlockData2.k() || iBlockData2.i() || iBlockData2.a(TagsBlock.u) || iBlockData2.a(TagsBlock.P) || this.Vv.contains(iBlockData2.b())) {
            return false;
        }
        chunk.setBlockState(blockPosition2, Blocks.i.o(), false, false);
        worldServer.captureTreeGeneration = true;
        worldServer.captureBlockStates = true;
        boolean bl2 = craftWorld.generateTree((GeneratorAccessSeed)worldServer, worldServer.getMinecraftWorld().l().g(), blockPosition, this.aoj, treeType);
        worldServer.captureBlockStates = false;
        worldServer.captureTreeGeneration = false;
        if (bl2) {
            for (BlockState blockState : worldServer.capturedBlockStates.values()) {
                awb2.setBlockData(blockState.getBlock(), blockState.getBlockData());
            }
        }
        worldServer.capturedBlockStates.clear();
        chunk.setBlockState(blockPosition2, iBlockData2, false, false);
        return bl2;
    }

    @Override
    public void vw() {
        if (!awg.aoh.compareAndSet(false, true)) {
            return;
        }
        try {
            IRegistryCustom.Dimension dimension = MinecraftServer.getServer().bc();
            RegistryMaterials registryMaterials = (RegistryMaterials)dimension.b(Registries.aI);
            this.a(registryMaterials);
            this.a(registryMaterials, "huge_brown_mushroom", WorldGenerator.r, Blocks.eT.o());
            this.a(registryMaterials, "huge_red_mushroom", WorldGenerator.q, Blocks.eU.o());
        }
        catch (Throwable throwable) {
            this.vx();
            bce.warn("Failed to inject force-default-blockstate tree features: " + throwable.getMessage());
        }
    }

    private void a(RegistryMaterials registryMaterials) {
        ResourceKey resourceKey = awj.dN("chorus_plant");
        this.a(registryMaterials, resourceKey, awj.a((WorldGenFeatureConfigured)registryMaterials.f(resourceKey)));
    }

    private void a(RegistryMaterials registryMaterials, String string, WorldGenerator worldGenerator, IBlockData iBlockData) {
        ResourceKey resourceKey = awj.dN(string);
        WorldGenFeatureMushroomConfiguration worldGenFeatureMushroomConfiguration = (WorldGenFeatureMushroomConfiguration)((WorldGenFeatureConfigured)registryMaterials.f(resourceKey)).c();
        WorldGenFeatureMushroomConfiguration worldGenFeatureMushroomConfiguration2 = new WorldGenFeatureMushroomConfiguration((WorldGenFeatureStateProvider)WorldGenFeatureStateProvider.a((IBlockData)iBlockData), (WorldGenFeatureStateProvider)WorldGenFeatureStateProvider.a((IBlockData)Blocks.eV.o()), worldGenFeatureMushroomConfiguration.d);
        this.a(registryMaterials, resourceKey, new WorldGenFeatureConfigured(worldGenerator, (WorldGenFeatureConfiguration)worldGenFeatureMushroomConfiguration2));
    }

    @Override
    public void vx() {
        try {
            IRegistryCustom.Dimension dimension = MinecraftServer.getServer().bc();
            RegistryMaterials registryMaterials = (RegistryMaterials)dimension.b(Registries.aI);
            this.aol.a(arg_0 -> ((RegistryMaterials)registryMaterials).f(arg_0), (resourceKey, worldGenFeatureConfigured) -> awj.a(registryMaterials, resourceKey, worldGenFeatureConfigured));
        }
        catch (Throwable throwable) {
            bce.warn("Failed to restore force-default-blockstate tree features: " + throwable.getMessage());
        }
        finally {
            this.aol.clear();
            awg.aoh.set(false);
        }
    }

    private void a(RegistryMaterials registryMaterials, ResourceKey resourceKey, WorldGenFeatureConfigured worldGenFeatureConfigured) {
        WorldGenFeatureConfigured worldGenFeatureConfigured2 = (WorldGenFeatureConfigured)registryMaterials.f(resourceKey);
        this.aol.a(resourceKey, worldGenFeatureConfigured2, worldGenFeatureConfigured);
        awj.a(registryMaterials, resourceKey, worldGenFeatureConfigured);
    }

    private static ResourceKey dN(String string) {
        return ResourceKey.a((ResourceKey)Registries.aI, (MinecraftKey)MinecraftKey.a((String)"minecraft", (String)string));
    }

    private static WorldGenFeatureConfigured a(WorldGenFeatureConfigured worldGenFeatureConfigured) {
        WorldGenerator worldGenerator = worldGenFeatureConfigured.b();
        WorldGenFeatureEmptyConfiguration worldGenFeatureEmptyConfiguration = (WorldGenFeatureEmptyConfiguration)worldGenFeatureConfigured.c();
        return new WorldGenFeatureConfigured((WorldGenerator)new awk(WorldGenFeatureEmptyConfiguration.a, worldGenerator), (WorldGenFeatureConfiguration)worldGenFeatureEmptyConfiguration);
    }

    private static GeneratorAccessSeed a(GeneratorAccessSeed generatorAccessSeed) {
        return (GeneratorAccessSeed)Proxy.newProxyInstance(GeneratorAccessSeed.class.getClassLoader(), new Class[]{GeneratorAccessSeed.class}, (object, method, objectArray) -> {
            IBlockData iBlockData;
            Object object2;
            if ("setBlock".equals(method.getName()) && objectArray != null && objectArray.length >= 3 && (object2 = objectArray[1]) instanceof IBlockData && (object2 = awj.b(iBlockData = (IBlockData)object2)) != null) {
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
        if (iBlockData.a(Blocks.ku) || iBlockData.a(Blocks.kv)) {
            return Blocks.ku.o();
        }
        return null;
    }

    private static void a(RegistryMaterials registryMaterials, ResourceKey resourceKey, Object object) {
        Object object2 = registryMaterials.f(resourceKey);
        Holder.c c2 = registryMaterials.g(resourceKey);
        Field field = zw.b(Holder.c.class, Object.class, 0);
        Field field2 = zw.b(RegistryMaterials.class, Map.class, 2);
        Field field3 = zw.b(RegistryMaterials.class, Reference2IntMap.class, 0);
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
