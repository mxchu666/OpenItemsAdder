package itemsadder.m;

import dev.lone.itemsadder.Main;
import io.papermc.paper.configuration.WorldConfiguration;
import itemsadder.m.ChunkWrapper;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.VersionHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.Chunk;
import net.minecraft.world.level.chunk.ChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.HeightMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.v1_20_R4.CraftChunk;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R4.block.data.CraftBlockData;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_20_6_23
implements ChunkWrapper {
    static Predicate aoM;
    static Block aoN;
    static Predicate aoO;
    static Block aoP;
    static Predicate aoQ;
    static Block aoR;
    static Predicate aoS;
    static Block aoT;
    private static final HashSet aoU;
    private static final HashSet aoV;
    static Method aoW;

    private static Predicate L(Material material) {
        Block block = BlockNms_1_20_6_23.M(material);
        return iBlockData -> block.equals(iBlockData.b());
    }

    public static Chunk y(org.bukkit.Chunk chunk) {
        return (Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }

    private static Block M(Material material) {
        IBlockData iBlockData = ((CraftBlockData)Bukkit.createBlockData((Material)material)).getState();
        return iBlockData.b();
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
            WorldServer worldServer = ((CraftWorld)world).getHandle();
            try {
                WorldConfiguration worldConfiguration = (WorldConfiguration)aoW.invoke((Object)worldServer, new Object[0]);
                return worldConfiguration.anticheat.antiXray.enabled;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List a(org.bukkit.Chunk chunk, int n, int n2) {
        World world = chunk.getWorld();
        Chunk chunk2 = BlockNms_1_20_6_23.y(chunk);
        ChunkSection[] chunkSectionArray = chunk2.d();
        int n3 = chunk.getX() << 4;
        int n4 = chunk.getZ() << 4;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            int n5;
            int n6;
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.c() || (n6 = (n5 = chunk2.r.g(i) << 4) + 15) < n || n5 > n2) continue;
            int n7 = Math.max(n5, n);
            int n8 = Math.min(n6, n2);
            if (!chunkSection.a(aoM) && !chunkSection.a(aoO) && !chunkSection.a(aoQ)) continue;
            this.a(world, chunk2, n3, n4, arrayList, chunkSection, n7, n8);
        }
        return arrayList;
    }

    private void a(World world, Chunk chunk, int n, int n2, List list, ChunkSection chunkSection, int n3, int n4) {
        for (int i = 0; i < 16; ++i) {
            int n5 = n + i;
            for (int j = 0; j < 16; ++j) {
                int n6 = n2 + j;
                int n7 = chunk.a(HeightMap.Type.b, i, j);
                int n8 = Math.min(n4, n7);
                for (int k = n3; k <= n8; ++k) {
                    Block block = chunkSection.a(i, k & 0xF, j).b();
                    if (block != aoN && block != aoP && block != aoR) continue;
                    list.add(world.getBlockAt(n5, k, n6));
                }
            }
        }
    }

    @Override
    public List A(org.bukkit.Chunk chunk) {
        World world = chunk.getWorld();
        Chunk chunk2 = BlockNms_1_20_6_23.y(chunk);
        ChunkSection[] chunkSectionArray = chunk2.d();
        int n = chunk.getX() << 4;
        int n2 = chunk.getZ() << 4;
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.c()) continue;
            int n3 = chunk2.r.g(i) << 4;
            boolean bl = false;
            for (Predicate predicate : aoU) {
                if (!chunkSection.a(predicate)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            for (int j = n; j < n + 16; ++j) {
                for (int k = n2; k < n2 + 16; ++k) {
                    for (int i2 = n3; i2 < n3 + 16; ++i2) {
                        Block block = chunkSection.a(j & 0xF, i2 & 0xF, k & 0xF).b();
                        if (!aoV.contains(block)) continue;
                        arrayList.add(new Location(world, (double)j, (double)i2, (double)k));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override
    public List aa(Location location) {
        org.bukkit.Chunk chunk = location.getChunk();
        World world = chunk.getWorld();
        Chunk chunk2 = BlockNms_1_20_6_23.y(chunk);
        ChunkSection[] chunkSectionArray = chunk2.d();
        int n = location.getBlockX();
        int n2 = location.getBlockZ();
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.c()) continue;
            int n3 = chunk2.r.g(i) << 4;
            if (!chunkSection.a(aoS)) continue;
            for (int j = n3; j < n3 + 16; ++j) {
                Block block = chunkSection.a(n & 0xF, j & 0xF, n2 & 0xF).b();
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
        WorldServer worldServer = ((CraftWorld)world).getHandle();
        Optional optional = worldServer.getNoiseBiome(n >> 2, n2 >> 2, n3 >> 2).e();
        if (optional.isEmpty()) {
            return null;
        }
        ResourceKey resourceKey = (ResourceKey)optional.get();
        return resourceKey.a();
    }

    @Override
    public Object j(NamespacedKey namespacedKey) {
        return MinecraftKey.a((String)namespacedKey.getNamespace(), (String)namespacedKey.getKey());
    }

    @Override
    public NamespacedKey dO(String string) {
        if (string == null) {
            return null;
        }
        try {
            Biome biome = Biome.valueOf((String)string.toUpperCase());
            return biome.getKey();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Biome biome = this.dP(string);
            if (biome != null) {
                return biome.getKey();
            }
            return null;
        }
    }

    @Override
    public void D(List list) {
        CommandSenderBridge_5.error("injectSoundsIntoRegistry() is not supported in this version of Minecraft!");
    }

    static {
        if (VersionHelper.Va) {
            try {
                aoW = WorldServer.class.getMethod("paperConfig", new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                CommandSenderBridge_5.error("Failed to get ServerLevel#paperConfig() method.", noSuchMethodException);
            }
        }
        IBlockData iBlockData3 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.CAVE_AIR)).getState();
        aoN = iBlockData3.b();
        aoM = iBlockData2 -> Objects.equals(iBlockData2, iBlockData3);
        IBlockData iBlockData4 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.AIR)).getState();
        aoP = iBlockData4.b();
        aoO = iBlockData2 -> Objects.equals(iBlockData2, iBlockData4);
        IBlockData iBlockData5 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.VOID_AIR)).getState();
        aoR = iBlockData5.b();
        aoQ = iBlockData2 -> Objects.equals(iBlockData2, iBlockData5);
        IBlockData iBlockData6 = ((CraftBlockData)Bukkit.createBlockData((Material)Material.NOTE_BLOCK)).getState();
        aoT = iBlockData6.b();
        aoS = iBlockData -> aoT.equals(iBlockData.b());
        aoU = new HashSet();
        aoU.addAll(Arrays.asList(BlockNms_1_20_6_23.L(Material.NOTE_BLOCK), BlockNms_1_20_6_23.L(Material.CHORUS_PLANT), BlockNms_1_20_6_23.L(Material.BROWN_MUSHROOM_BLOCK), BlockNms_1_20_6_23.L(Material.RED_MUSHROOM_BLOCK), BlockNms_1_20_6_23.L(Material.MUSHROOM_STEM), BlockNms_1_20_6_23.L(Material.TRIPWIRE)));
        aoV = new HashSet();
        aoV.addAll(Arrays.asList(BlockNms_1_20_6_23.M(Material.NOTE_BLOCK), BlockNms_1_20_6_23.M(Material.CHORUS_PLANT), BlockNms_1_20_6_23.M(Material.BROWN_MUSHROOM_BLOCK), BlockNms_1_20_6_23.M(Material.RED_MUSHROOM_BLOCK), BlockNms_1_20_6_23.M(Material.MUSHROOM_STEM), BlockNms_1_20_6_23.M(Material.TRIPWIRE)));
    }
}
