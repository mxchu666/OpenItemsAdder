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
import org.bukkit.craftbukkit.v1_21_R7.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R7.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_11_7
implements BlockWrapper_2 {
    @Override
    @Nullable
    public Object M(String string, String string2) {
        return this.N(string, string2);
    }

    @Nullable
    public Holder N(String string, String string2) {
        IRegistry iRegistry = MinecraftServer.getServer().bc().f(Registries.aS);
        Optional optional = iRegistry.a(ResourceKey.a((ResourceKey)Registries.aS, (MinecraftKey)MinecraftKey.a((String)string, (String)string2)));
        return optional.orElse(null);
    }

    @Override
    public String bd(Block block) {
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_11_7.y(block.getChunk());
        if (chunk != null) {
            Holder holder = chunk.I().z(new BlockPosition(block.getX(), block.getY(), block.getZ()));
            IRegistry iRegistry = MinecraftServer.getServer().bc().f(Registries.aS);
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
        net.minecraft.world.level.chunk.Chunk chunk = BlockNms_1_21_11_7.y(location.getChunk());
        ChunkSection chunkSection = chunk.b(chunk.f(location.getBlockY()));
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    chunkSection.setBiome(i, j, k, holder);
                }
            }
        }
        chunk.i();
        craftWorld.getHandle().p().a.b(List.of(chunk));
    }

    @Override
    public void a(Chunk chunk, Player player) {
        net.minecraft.world.level.chunk.Chunk chunk2 = BlockNms_1_21_11_7.y(chunk);
        PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().g;
        if (!playerConnection.isDisconnected()) {
            playerConnection.b((Packet)new ClientboundLevelChunkWithLightPacket(chunk2, chunk2.I().ac().r(), null, null));
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
        IRegistryCustom.Dimension dimension = minecraftServer.bc();
        RegistryMaterials registryMaterials = (RegistryMaterials)dimension.f(Registries.aS);
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
                    ResourceKey resourceKey = ResourceKey.a((ResourceKey)Registries.aS, (MinecraftKey)minecraftKey);
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
                    Integer n = ((BiomeBase)holder.a()).h().b().orElse(null);
                    Integer n2 = ((BiomeBase)holder.a()).h().d().orElse(null);
                    BiomeFog.a a2 = new BiomeFog.a().a(recordOfString_2.tI()).c(((BiomeBase)holder.a()).e()).a(((BiomeBase)holder.a()).h().e());
                    if (n != null) {
                        a2.b(n.intValue());
                    }
                    if (n2 != null) {
                        a2.d(n2.intValue());
                    }
                    BiomeFog biomeFog = a2.a();
                    BiomeBase biomeBase = new BiomeBase.a().a(((BiomeBase)holder.a()).i.a()).a(((BiomeBase)holder.a()).f()).b(((BiomeBase)holder.a()).i.d()).a(biomeFog).a(((BiomeBase)holder.a()).a()).a(((BiomeBase)holder.a()).c()).a(((BiomeBase)holder.a()).i.c()).a(((BiomeBase)holder.a()).i.b()).a();
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
