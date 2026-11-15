package itemsadder.m;

import itemsadder.m.afk;
import itemsadder.m.afl;
import itemsadder.m.bce;
import itemsadder.m.zw;
import itemsadder.m.zy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.Holder;
import net.minecraft.core.IRegistry;
import net.minecraft.core.IRegistryCustom;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.RegistryMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.PlayerConnection;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.BiomeFog;
import net.minecraft.world.level.chunk.ChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_20_R4.CraftChunk;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class afm
implements afk {
    @Override
    @Nullable
    public Object M(String string, String string2) {
        return this.N(string, string2);
    }

    @Nullable
    public Holder N(String string, String string2) {
        IRegistry iRegistry = MinecraftServer.getServer().bc().d(Registries.az);
        Optional optional = iRegistry.b(ResourceKey.a((ResourceKey)Registries.az, (MinecraftKey)new MinecraftKey(string, string2)));
        return optional.orElse(null);
    }

    @Override
    public String bd(Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = afm.y(block.getChunk());
        if (chunk != null) {
            Holder holder = chunk.F().t(new BlockPosition(block.getX(), block.getY(), block.getZ()));
            IRegistry iRegistry = MinecraftServer.getServer().bc().d(Registries.az);
            MinecraftKey minecraftKey = iRegistry.b((Object)((BiomeBase)holder.a()));
            if (minecraftKey == null) {
                return null;
            }
            return minecraftKey.toString();
        }
        return null;
    }

    public static net.minecraft.world.level.chunk.Chunk y(Chunk chunk) {
        return (net.minecraft.world.level.chunk.Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }

    @Override
    public void a(Block block, String string, String string2) {
        this.a(block.getLocation(), string, string2, true);
    }

    @Override
    public void a(Location location, String string, String string2, boolean bl) {
        CraftWorld craftWorld = (CraftWorld)location.getWorld();
        Holder holder = this.N(string, string2);
        if (holder == null) {
            return;
        }
        if (craftWorld == null) {
            return;
        }
        net.minecraft.world.level.chunk.Chunk chunk = afm.y(location.getChunk());
        ChunkSection chunkSection = chunk.b(chunk.e(location.getBlockY()));
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    chunkSection.setBiome(i, j, k, holder);
                }
            }
        }
        chunk.a(true);
        craftWorld.getHandle().l().a.a(List.of(chunk));
    }

    @Override
    public void a(Chunk chunk, Player player) {
        net.minecraft.world.level.chunk.Chunk chunk2 = afm.y(chunk);
        PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().c;
        if (!playerConnection.isDisconnected()) {
            playerConnection.b((Packet)new ClientboundLevelChunkWithLightPacket(chunk2, chunk2.F().N().p(), null, null));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean z(List list) {
        Field field;
        if (list.isEmpty()) {
            return false;
        }
        Field field2 = zw.b(RegistryMaterials.class, Map.class, 5);
        if (field2 == null) {
            throw new RuntimeException("Error injecting blocks: field_unregisteredIntrusiveHolders is null");
        }
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        IRegistryCustom.Dimension dimension = minecraftServer.bc();
        RegistryMaterials registryMaterials = (RegistryMaterials)dimension.d(Registries.az);
        try {
            field = zw.b(RegistryMaterials.class, Boolean.TYPE, 0);
            if (field == null) {
                throw new RuntimeException("Error injecting Biome: field_frozen is null");
            }
            field.set(registryMaterials, false);
        }
        catch (IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException exception) {
            bce.warn("Error injecting Biome: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        try {
            try {
                field2.set(registryMaterials, new IdentityHashMap());
            }
            catch (Throwable throwable) {
                throw new RuntimeException("Failed to reset unregisteredIntrusiveHolders", throwable);
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            for (afl afl2 : list) {
                try {
                    MinecraftKey minecraftKey = MinecraftKey.a((String)afl2.pD(), (String)afl2.tH());
                    ResourceKey resourceKey = ResourceKey.a((ResourceKey)Registries.az, (MinecraftKey)minecraftKey);
                    if (registryMaterials.d(resourceKey)) {
                        if (atomicBoolean.get()) continue;
                        int n = afl2.tI();
                        Optional.ofNullable((BiomeBase)registryMaterials.a(resourceKey)).ifPresent(biomeBase -> {
                            BiomeBase biomeBase2 = biomeBase;
                            if (biomeBase2.i() != n) {
                                bce.warn("Biome '" + afl2.pD() + ":" + afl2.tH() + "' properties changed. Restart the server to apply.");
                                atomicBoolean.set(true);
                            }
                        });
                        continue;
                    }
                    Holder holder = this.N("minecraft", "plains");
                    if (holder == null) {
                        bce.warn("Failed to find plains biome in Minecraft registry. Cannot register custom biome '" + afl2.pD() + ":" + afl2.tH() + "'.");
                        continue;
                    }
                    Integer n = ((BiomeBase)holder.a()).h().e().orElse(null);
                    Integer n2 = ((BiomeBase)holder.a()).h().f().orElse(null);
                    BiomeFog.a a2 = new BiomeFog.a().a(((BiomeBase)holder.a()).h().a()).b(afl2.tI()).c(((BiomeBase)holder.a()).h().c()).d(((BiomeBase)holder.a()).h().d()).a(((BiomeBase)holder.a()).h().g());
                    if (n != null) {
                        a2.e(n.intValue());
                    }
                    if (n2 != null) {
                        a2.f(n2.intValue());
                    }
                    ((BiomeBase)holder.a()).h().h().ifPresent(arg_0 -> ((BiomeFog.a)a2).a(arg_0));
                    ((BiomeBase)holder.a()).h().i().ifPresent(arg_0 -> ((BiomeFog.a)a2).a(arg_0));
                    ((BiomeBase)holder.a()).h().j().ifPresent(arg_0 -> ((BiomeFog.a)a2).a(arg_0));
                    ((BiomeBase)holder.a()).h().k().ifPresent(arg_0 -> ((BiomeFog.a)a2).a(arg_0));
                    ((BiomeBase)holder.a()).o().ifPresent(arg_0 -> ((BiomeFog.a)a2).a(arg_0));
                    BiomeFog biomeFog = a2.a();
                    BiomeBase biomeBase2 = new BiomeBase.a().a(((BiomeBase)holder.a()).i.a()).a(((BiomeBase)holder.a()).g()).b(((BiomeBase)holder.a()).i.d()).a(biomeFog).a(((BiomeBase)holder.a()).b()).a(((BiomeBase)holder.a()).d()).a(((BiomeBase)holder.a()).i.c()).a(((BiomeBase)holder.a()).i.b()).a();
                    registryMaterials.f((Object)biomeBase2);
                    Holder.c c2 = registryMaterials.a(resourceKey, (Object)biomeBase2, RegistrationInfo.a);
                    HashSet hashSet = new HashSet();
                    Holder.a((Object)biomeBase2).c().forEach(hashSet::add);
                    Method method = zw.a(Holder.c.class, "bindTags", Collection.class);
                    if (method == null) {
                        method = zw.a(Void.TYPE, Holder.c.class, zy.PACKAGE_PRIVATE, Collection.class);
                    }
                    if (method == null) {
                        throw new RuntimeException("Error injecting Biome: method_bindTags is null");
                    }
                    method.invoke((Object)c2, hashSet);
                    bce.iA("Injected Biome into Minecraft Registry: " + afl2.pD() + ":" + afl2.tH());
                    atomicInteger.incrementAndGet();
                }
                catch (Throwable throwable) {
                    bce.warn("Error registering Biome '" + afl2.pD() + ":" + afl2.tH() + "'.", throwable);
                }
            }
            try {
                field2.set(registryMaterials, null);
            }
            catch (IllegalAccessException illegalAccessException) {
                bce.warn("Failed to reset unregisteredIntrusiveHolders: " + illegalAccessException.getMessage(), illegalAccessException);
                boolean bl = false;
                try {
                    field.set(registryMaterials, true);
                }
                catch (IllegalAccessException illegalAccessException2) {
                    bce.warn("Failed to freeze registry: " + illegalAccessException2.getMessage(), illegalAccessException2);
                }
                return bl;
            }
        }
        finally {
            try {
                field.set(registryMaterials, true);
            }
            catch (IllegalAccessException illegalAccessException) {
                bce.warn("Failed to freeze registry: " + illegalAccessException.getMessage(), illegalAccessException);
            }
        }
        return atomicInteger.get() > 0;
    }
}
