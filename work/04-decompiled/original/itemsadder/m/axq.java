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
import net.minecraft.core.IRegistryCustom;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.RegistryMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.ChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.HeightMap;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.v1_21_R3.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R3.block.data.CraftBlockData;
import org.jetbrains.annotations.Nullable;

public class axq
implements axh {
    static Predicate aoM;
    static Block aoN;
    static Predicate aoO;
    static Block aoP;
    static Predicate aoQ;
    static Block aoR;
    static Predicate aoS;
    static Block aoT;
    private static final HashSet apf;
    private static final HashSet apg;
    static Method aoW;

    private static Predicate L(Material material) {
        Block block = axq.M(material);
        return iBlockData -> block.equals(iBlockData.b());
    }

    public static net.minecraft.world.level.chunk.Chunk y(Chunk chunk) {
        return (net.minecraft.world.level.chunk.Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
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
        if (aaa.Va) {
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
    public List a(Chunk chunk, int n, int n2) {
        World world = chunk.getWorld();
        net.minecraft.world.level.chunk.Chunk chunk2 = axq.y(chunk);
        ChunkSection[] chunkSectionArray = chunk2.d();
        int n3 = chunk.getX() << 4;
        int n4 = chunk.getZ() << 4;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            int n5;
            int n6;
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.c() || (n6 = (n5 = chunk2.r.h(i) << 4) + 15) < n || n5 > n2) continue;
            int n7 = Math.max(n5, n);
            int n8 = Math.min(n6, n2);
            if (!chunkSection.a(aoM) && !chunkSection.a(aoO) && !chunkSection.a(aoQ)) continue;
            this.a(world, chunk2, n3, n4, arrayList, chunkSection, n7, n8);
        }
        return arrayList;
    }

    private void a(World world, net.minecraft.world.level.chunk.Chunk chunk, int n, int n2, List list, ChunkSection chunkSection, int n3, int n4) {
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
    public List A(Chunk chunk) {
        World world = chunk.getWorld();
        net.minecraft.world.level.chunk.Chunk chunk2 = axq.y(chunk);
        ChunkSection[] chunkSectionArray = chunk2.d();
        int n = chunk.getX() << 4;
        int n2 = chunk.getZ() << 4;
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.c()) continue;
            int n3 = chunk2.r.h(i) << 4;
            boolean bl = false;
            for (Predicate predicate : apf) {
                if (!chunkSection.a(predicate)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            for (int j = n; j < n + 16; ++j) {
                for (int k = n2; k < n2 + 16; ++k) {
                    for (int i2 = n3; i2 < n3 + 16; ++i2) {
                        Block block = chunkSection.a(j & 0xF, i2 & 0xF, k & 0xF).b();
                        if (!apg.contains(block)) continue;
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
        net.minecraft.world.level.chunk.Chunk chunk2 = axq.y(chunk);
        ChunkSection[] chunkSectionArray = chunk2.d();
        int n = location.getBlockX();
        int n2 = location.getBlockZ();
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            ChunkSection chunkSection = chunkSectionArray[i];
            if (chunkSection == null || chunkSection.c()) continue;
            int n3 = chunk2.r.h(i) << 4;
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
        Field field2 = zw.b(RegistryMaterials.class, Map.class, 5);
        if (field2 == null) {
            throw new RuntimeException("Error injecting blocks: field_unregisteredIntrusiveHolders is null");
        }
        IRegistryCustom.Dimension dimension = MinecraftServer.getServer().ba();
        RegistryMaterials registryMaterials = (RegistryMaterials)dimension.e(Registries.L);
        try {
            field = zw.b(RegistryMaterials.class, Boolean.TYPE, 0);
            if (field == null) {
                throw new RuntimeException("Error injecting JukeboxSong: field_frozen is null");
            }
            field.set(registryMaterials, false);
        }
        catch (IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException exception) {
            bce.warn("Error injecting JukeboxSong: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
        try {
            field2.set(registryMaterials, new IdentityHashMap());
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to reset unregisteredIntrusiveHolders", throwable);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        list.forEach(tg2 -> {
            try {
                float f;
                MinecraftKey minecraftKey = MinecraftKey.a((String)tg2.pD(), (String)tg2.fN());
                ResourceKey resourceKey = ResourceKey.a((ResourceKey)Registries.L, (MinecraftKey)minecraftKey);
                Float f2 = ((ti)tg2.pC().getFirst()).pS();
                if (f2 == null) {
                    bce.warn("Jukebox song '" + tg2.bj() + "' does not have a duration set. Defaulting to 10 seconds. This might be a bug.");
                }
                float f3 = f = f2 == null ? 10.0f : f2.floatValue();
                if (registryMaterials.e(resourceKey)) {
                    if (!atomicBoolean.get()) {
                        registryMaterials.a(resourceKey).ifPresent(c2 -> {
                            JukeboxSong jukeboxSong = (JukeboxSong)c2.a();
                            if (jukeboxSong.e() != (tg2.pH() == null ? 0 : tg2.pH()) || jukeboxSong.d() != f || !jukeboxSong.c().equals(bbe.r(tg2.pB()))) {
                                bce.warn("Jukebox song '" + tg2.bj() + "' properties changed. Restart the server to apply.");
                                atomicBoolean.set(true);
                            }
                        });
                    }
                    return;
                }
                JukeboxSong jukeboxSong = new JukeboxSong(Holder.a((Object)SoundEffect.a((MinecraftKey)ResourceKey.a((ResourceKey)Registries.al, (MinecraftKey)MinecraftKey.a((String)tg2.pD(), (String)tg2.fN())).a())), (IChatBaseComponent)bbe.r(tg2.pB()), f, tg2.pH() == null ? 0 : tg2.pH());
                registryMaterials.f((Object)jukeboxSong);
                Holder.c c3 = registryMaterials.a(resourceKey, (Object)jukeboxSong, RegistrationInfo.a);
                HashSet hashSet = new HashSet();
                Holder.a((Object)jukeboxSong).c().forEach(hashSet::add);
                Method method = zw.a(Holder.c.class, "bindTags", Collection.class);
                if (method == null) {
                    method = zw.a(Void.TYPE, Holder.c.class, zy.PACKAGE_PRIVATE, Collection.class);
                }
                if (method == null) {
                    throw new RuntimeException("Error injecting jukebox song: method_bindTags is null");
                }
                method.invoke((Object)c3, hashSet);
                bce.iA("Injected jukebox song into Minecraft Registry: " + tg2.bj());
            }
            catch (Throwable throwable) {
                bce.warn("Error registering jukebox song '" + tg2.bj() + "'.");
                throw new RuntimeException(throwable);
            }
        });
        try {
            field2.set(registryMaterials, null);
        }
        catch (IllegalAccessException illegalAccessException) {
            bce.warn("Failed to reset unregisteredIntrusiveHolders: " + illegalAccessException.getMessage());
            throw new RuntimeException(illegalAccessException);
        }
        try {
            field.set(registryMaterials, true);
        }
        catch (IllegalAccessException illegalAccessException) {
            bce.warn("Failed to freeze registry: " + illegalAccessException.getMessage());
            throw new RuntimeException(illegalAccessException);
        }
    }

    static {
        if (aaa.Va) {
            try {
                aoW = WorldServer.class.getMethod("paperConfig", new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                bce.error("Failed to get ServerLevel#paperConfig() method.", noSuchMethodException);
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
        apf = new HashSet();
        apf.addAll(Arrays.asList(axq.L(Material.NOTE_BLOCK), axq.L(Material.CHORUS_PLANT), axq.L(Material.BROWN_MUSHROOM_BLOCK), axq.L(Material.RED_MUSHROOM_BLOCK), axq.L(Material.MUSHROOM_STEM), axq.L(Material.TRIPWIRE)));
        apg = new HashSet();
        apg.addAll(Arrays.asList(axq.M(Material.NOTE_BLOCK), axq.M(Material.CHORUS_PLANT), axq.M(Material.BROWN_MUSHROOM_BLOCK), axq.M(Material.RED_MUSHROOM_BLOCK), axq.M(Material.MUSHROOM_STEM), axq.M(Material.TRIPWIRE)));
    }
}
