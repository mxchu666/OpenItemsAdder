package itemsadder.m;

import itemsadder.m.BlockWrapper_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PublicEnum;
import itemsadder.m.RecordOfString_2;
import itemsadder.m.VersionHelper_3;
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
import org.bukkit.craftbukkit.v1_21_R3.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_4_7
implements BlockWrapper_2 {
    @Override
    @Nullable
    public Object M(String string, String string2) {
        return this.N(string, string2);
    }

    @Nullable
    public Holder N(String string, String string2) {
        IRegistry iRegistry = MinecraftServer.getServer().ba().e(Registries.aI);
        Optional optional = iRegistry.a(ResourceKey.a((ResourceKey)Registries.aI, (MinecraftKey)MinecraftKey.a((String)string, (String)string2)));
        return optional.orElse(null);
    }

    @Override
    public String bd(Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_4_7.y(block.getChunk());
        if (chunk != null) {
            Holder holder = chunk.H().t(new BlockPosition(block.getX(), block.getY(), block.getZ()));
            IRegistry iRegistry = MinecraftServer.getServer().ba().e(Registries.aI);
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
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_4_7.y(location.getChunk());
        ChunkSection chunkSection = chunk.b(chunk.f(location.getBlockY()));
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    chunkSection.setBiome(i, j, k, holder);
                }
            }
        }
        chunk.i();
        craftWorld.getHandle().m().a.a(List.of(chunk));
    }

    @Override
    public void a(Chunk chunk, Player player) {
        net.minecraft.world.level.chunk.Chunk chunk2 = BlockNms_1_21_4_7.y(chunk);
        PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().f;
        if (!playerConnection.isDisconnected()) {
            playerConnection.b((Packet)new ClientboundLevelChunkWithLightPacket(chunk2, chunk2.H().S().p(), null, null));
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
        Field field2 = VersionHelper_3.b(RegistryMaterials.class, Map.class, 5);
        if (field2 == null) {
            throw new RuntimeException("Error injecting blocks: field_unregisteredIntrusiveHolders is null");
        }
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        IRegistryCustom.Dimension dimension = minecraftServer.ba();
        RegistryMaterials registryMaterials = (RegistryMaterials)dimension.e(Registries.aI);
        try {
            field = VersionHelper_3.b(RegistryMaterials.class, Boolean.TYPE, 0);
            if (field == null) {
                throw new RuntimeException("Error injecting Biome: field_frozen is null");
            }
            field.set(registryMaterials, false);
        }
        catch (IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException exception) {
            CommandSenderBridge_5.warn("Error injecting Biome: " + exception.getMessage());
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
            for (RecordOfString_2 recordOfString_2 : list) {
                try {
                    MinecraftKey minecraftKey = MinecraftKey.a((String)recordOfString_2.pD(), (String)recordOfString_2.tH());
                    ResourceKey resourceKey = ResourceKey.a((ResourceKey)Registries.aI, (MinecraftKey)minecraftKey);
                    if (registryMaterials.e(resourceKey)) {
                        if (atomicBoolean.get()) continue;
                        int n = recordOfString_2.tI();
                        registryMaterials.a(resourceKey).ifPresent(c2 -> {
                            BiomeBase biomeBase = (BiomeBase)c2.a();
                            if (biomeBase.i() != n) {
                                CommandSenderBridge_5.warn("Biome '" + recordOfString_2.pD() + ":" + recordOfString_2.tH() + "' properties changed. Restart the server to apply.");
                                atomicBoolean.set(true);
                            }
                        });
                        continue;
                    }
                    Holder holder = this.N("minecraft", "plains");
                    if (holder == null) {
                        CommandSenderBridge_5.warn("Failed to find plains biome in Minecraft registry. Cannot register custom biome '" + recordOfString_2.pD() + ":" + recordOfString_2.tH() + "'.");
                        continue;
                    }
                    Integer n = ((BiomeBase)holder.a()).h().e().orElse(null);
                    Integer n2 = ((BiomeBase)holder.a()).h().f().orElse(null);
                    BiomeFog.a a2 = new BiomeFog.a().a(((BiomeBase)holder.a()).h().a()).b(recordOfString_2.tI()).c(((BiomeBase)holder.a()).h().c()).d(((BiomeBase)holder.a()).h().d()).a(((BiomeBase)holder.a()).h().g()).a(((BiomeBase)holder.a()).h().m());
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
                    BiomeFog biomeFog = a2.b();
                    BiomeBase biomeBase = new BiomeBase.a().a(((BiomeBase)holder.a()).i.a()).a(((BiomeBase)holder.a()).g()).b(((BiomeBase)holder.a()).i.d()).a(biomeFog).a(((BiomeBase)holder.a()).b()).a(((BiomeBase)holder.a()).d()).a(((BiomeBase)holder.a()).i.c()).a(((BiomeBase)holder.a()).i.b()).a();
                    registryMaterials.f((Object)biomeBase);
                    Holder.c c3 = registryMaterials.a(resourceKey, (Object)biomeBase, RegistrationInfo.a);
                    HashSet hashSet = new HashSet();
                    Holder.a((Object)biomeBase).c().forEach(hashSet::add);
                    Method method = VersionHelper_3.a(Holder.c.class, "bindTags", Collection.class);
                    if (method == null) {
                        method = VersionHelper_3.a(Void.TYPE, Holder.c.class, PublicEnum.PACKAGE_PRIVATE, Collection.class);
                    }
                    if (method == null) {
                        throw new RuntimeException("Error injecting Biome: method_bindTags is null");
                    }
                    method.invoke((Object)c3, hashSet);
                    CommandSenderBridge_5.iA("Injected Biome into Minecraft Registry: " + recordOfString_2.pD() + ":" + recordOfString_2.tH());
                    atomicInteger.incrementAndGet();
                }
                catch (Throwable throwable) {
                    CommandSenderBridge_5.warn("Error registering Biome '" + recordOfString_2.pD() + ":" + recordOfString_2.tH() + "'.", throwable);
                }
            }
            try {
                field2.set(registryMaterials, null);
            }
            catch (IllegalAccessException illegalAccessException) {
                CommandSenderBridge_5.warn("Failed to reset unregisteredIntrusiveHolders: " + illegalAccessException.getMessage(), illegalAccessException);
                boolean bl = false;
                try {
                    field.set(registryMaterials, true);
                }
                catch (IllegalAccessException illegalAccessException2) {
                    CommandSenderBridge_5.warn("Failed to freeze registry: " + illegalAccessException2.getMessage(), illegalAccessException2);
                }
                return bl;
            }
        }
        finally {
            try {
                field.set(registryMaterials, true);
            }
            catch (IllegalAccessException illegalAccessException) {
                CommandSenderBridge_5.warn("Failed to freeze registry: " + illegalAccessException.getMessage(), illegalAccessException);
            }
        }
        return atomicInteger.get() > 0;
    }
}
