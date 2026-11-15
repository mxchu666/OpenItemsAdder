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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftChunk;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class afw
implements afk {
    @Override
    @Nullable
    public Object M(String string, String string2) {
        return this.N(string, string2);
    }

    @Nullable
    public Holder N(String string, String string2) {
        Registry registry = MinecraftServer.getServer().registryAccess().lookupOrThrow(Registries.BIOME);
        Optional optional = registry.get(ResourceKey.create((ResourceKey)Registries.BIOME, (Identifier)Identifier.fromNamespaceAndPath((String)string, (String)string2)));
        return optional.orElse(null);
    }

    @Override
    public String bd(Block block) {
        LevelChunk levelChunk = afw.z(block.getChunk());
        if (levelChunk != null) {
            Holder holder = levelChunk.getLevel().getBiome(new BlockPos(block.getX(), block.getY(), block.getZ()));
            Registry registry = MinecraftServer.getServer().registryAccess().lookupOrThrow(Registries.BIOME);
            Identifier identifier = registry.getKey((Object)((Biome)holder.value()));
            if (identifier == null) {
                return null;
            }
            return identifier.toString();
        }
        return null;
    }

    public static LevelChunk z(Chunk chunk) {
        return (LevelChunk)((CraftChunk)chunk).getHandle(ChunkStatus.FULL);
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
        LevelChunk levelChunk = afw.z(location.getChunk());
        LevelChunkSection levelChunkSection = levelChunk.getSection(levelChunk.getSectionIndex(location.getBlockY()));
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    levelChunkSection.setNoiseBiome(i, j, k, holder);
                }
            }
        }
        levelChunk.markUnsaved();
        craftWorld.getHandle().getChunkSource().chunkMap.resendBiomesForChunks(List.of(levelChunk));
    }

    @Override
    public void a(Chunk chunk, Player player) {
        LevelChunk levelChunk = afw.z(chunk);
        ServerGamePacketListenerImpl serverGamePacketListenerImpl = ((CraftPlayer)player).getHandle().connection;
        if (!serverGamePacketListenerImpl.isDisconnected()) {
            serverGamePacketListenerImpl.send((Packet)new ClientboundLevelChunkWithLightPacket(levelChunk, levelChunk.getLevel().getChunkSource().getLightEngine(), null, null));
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
        Field field2 = zw.b(MappedRegistry.class, Map.class, 5);
        if (field2 == null) {
            throw new RuntimeException("Error injecting blocks: field_unregisteredIntrusiveHolders is null");
        }
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        RegistryAccess.Frozen frozen = minecraftServer.registryAccess();
        MappedRegistry mappedRegistry = (MappedRegistry)frozen.lookupOrThrow(Registries.BIOME);
        try {
            field = zw.b(MappedRegistry.class, Boolean.TYPE, 0);
            if (field == null) {
                throw new RuntimeException("Error injecting Biome: field_frozen is null");
            }
            field.set(mappedRegistry, false);
        }
        catch (IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException exception) {
            bce.warn("Error injecting Biome: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        try {
            try {
                field2.set(mappedRegistry, new IdentityHashMap());
            }
            catch (Throwable throwable) {
                throw new RuntimeException("Failed to reset unregisteredIntrusiveHolders", throwable);
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            for (afl afl2 : list) {
                try {
                    Identifier identifier = Identifier.fromNamespaceAndPath((String)afl2.pD(), (String)afl2.tH());
                    ResourceKey resourceKey = ResourceKey.create((ResourceKey)Registries.BIOME, (Identifier)identifier);
                    if (mappedRegistry.containsKey(resourceKey)) {
                        if (atomicBoolean.get()) continue;
                        int n = afl2.tI();
                        mappedRegistry.get(resourceKey).ifPresent(reference -> {
                            Biome biome = (Biome)reference.value();
                            if (biome.getWaterColor() != n) {
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
                    Integer n = ((Biome)holder.value()).getSpecialEffects().foliageColorOverride().orElse(null);
                    Integer n2 = ((Biome)holder.value()).getSpecialEffects().grassColorOverride().orElse(null);
                    BiomeSpecialEffects.Builder builder = new BiomeSpecialEffects.Builder().waterColor(afl2.tI()).dryFoliageColorOverride(((Biome)holder.value()).getDryFoliageColor()).grassColorModifier(((Biome)holder.value()).getSpecialEffects().grassColorModifier());
                    if (n != null) {
                        builder.foliageColorOverride(n.intValue());
                    }
                    if (n2 != null) {
                        builder.grassColorOverride(n2.intValue());
                    }
                    BiomeSpecialEffects biomeSpecialEffects = builder.build();
                    Biome biome = new Biome.BiomeBuilder().hasPrecipitation(((Biome)holder.value()).climateSettings.hasPrecipitation()).temperature(((Biome)holder.value()).getBaseTemperature()).downfall(((Biome)holder.value()).climateSettings.downfall()).specialEffects(biomeSpecialEffects).mobSpawnSettings(((Biome)holder.value()).getMobSettings()).generationSettings(((Biome)holder.value()).getGenerationSettings()).temperatureAdjustment(((Biome)holder.value()).climateSettings.temperatureModifier()).temperature(((Biome)holder.value()).climateSettings.temperature()).build();
                    mappedRegistry.createIntrusiveHolder((Object)biome);
                    Holder.Reference reference2 = mappedRegistry.register(resourceKey, (Object)biome, RegistrationInfo.BUILT_IN);
                    HashSet hashSet = new HashSet();
                    Holder.direct((Object)biome).tags().forEach(hashSet::add);
                    Method method = zw.a(Holder.Reference.class, "bindTags", Collection.class);
                    if (method == null) {
                        method = zw.a(Void.TYPE, Holder.Reference.class, zy.PACKAGE_PRIVATE, Collection.class);
                    }
                    if (method == null) {
                        throw new RuntimeException("Error injecting Biome: method_bindTags is null");
                    }
                    method.invoke((Object)reference2, hashSet);
                    bce.iA("Injected Biome into Minecraft Registry: " + afl2.pD() + ":" + afl2.tH());
                    atomicInteger.incrementAndGet();
                }
                catch (Throwable throwable) {
                    bce.warn("Error registering Biome '" + afl2.pD() + ":" + afl2.tH() + "'.", throwable);
                }
            }
            try {
                field2.set(mappedRegistry, null);
            }
            catch (IllegalAccessException illegalAccessException) {
                bce.warn("Failed to reset unregisteredIntrusiveHolders: " + illegalAccessException.getMessage(), illegalAccessException);
                boolean bl = false;
                try {
                    field.set(mappedRegistry, true);
                }
                catch (IllegalAccessException illegalAccessException2) {
                    bce.warn("Failed to freeze registry: " + illegalAccessException2.getMessage(), illegalAccessException2);
                }
                return bl;
            }
        }
        finally {
            try {
                field.set(mappedRegistry, true);
            }
            catch (IllegalAccessException illegalAccessException) {
                bce.warn("Failed to freeze registry: " + illegalAccessException.getMessage(), illegalAccessException);
            }
        }
        return atomicInteger.get() > 0;
    }
}
