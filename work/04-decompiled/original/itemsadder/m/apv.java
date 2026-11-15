package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.mojang.datafixers.util.Pair;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import it.unimi.dsi.fastutil.ints.IntList;
import itemsadder.m.ae;
import itemsadder.m.aor;
import itemsadder.m.aot;
import itemsadder.m.aou;
import itemsadder.m.aov;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bfl;
import itemsadder.m.zw;
import java.lang.constant.Constable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.core.Holder;
import net.minecraft.network.Connection;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.numbers.BlankFormat;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.network.protocol.common.CommonPacketTypes;
import net.minecraft.network.protocol.cookie.CookiePacketTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.network.protocol.game.GamePacketTypes;
import net.minecraft.network.protocol.game.GameProtocols;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerInputPacket;
import net.minecraft.network.protocol.ping.PingPacketTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import net.minecraft.server.network.ServerConnectionListener;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.jetbrains.annotations.Nullable;

public class apv
implements aor {
    private static final boolean alh = zw.a(net.minecraft.world.entity.Entity.class, ChunkMap.TrackedEntity.class) != null;
    static Field akA = zw.a(ServerCommonPacketListenerImpl.class, Connection.class);
    private static final Field ali = zw.a(ClientboundSoundPacket.class, Holder.class);

    public void a(org.bukkit.entity.Player player, FriendlyByteBuf friendlyByteBuf) {
        ServerGamePacketListenerImpl serverGamePacketListenerImpl = ((CraftPlayer)player).getHandle().connection;
        if (!serverGamePacketListenerImpl.isDisconnected()) {
            ChannelHandlerContext channelHandlerContext = (ChannelHandlerContext)ajU.get(player);
            if (channelHandlerContext == null) {
                try {
                    Connection connection = (Connection)akA.get(serverGamePacketListenerImpl);
                    channelHandlerContext = connection.channel.pipeline().context("encoder");
                    ajU.put(player, channelHandlerContext);
                }
                catch (IllegalAccessException illegalAccessException) {
                    bce.error("Failed to read player connection field. Some features might not work correctly!", illegalAccessException);
                }
            }
            if (channelHandlerContext != null) {
                if (ae.dO) {
                    bfl.a(channelHandlerContext, friendlyByteBuf);
                } else {
                    channelHandlerContext.writeAndFlush((Object)friendlyByteBuf);
                }
            }
        }
    }

    @Override
    public void ak(org.bukkit.entity.Player player) {
        aor.super.ak(player);
        ServerGamePacketListenerImpl serverGamePacketListenerImpl = ((CraftPlayer)player).getHandle().connection;
        if (!serverGamePacketListenerImpl.isDisconnected()) {
            try {
                Connection connection = (Connection)akA.get(serverGamePacketListenerImpl);
                for (String string : connection.channel.pipeline().names()) {
                    bfl.b(connection.channel.pipeline().context(string));
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                bce.error("Failed to read player connection field. Some features might not work correctly!", illegalAccessException);
            }
        }
    }

    public void b(org.bukkit.entity.Player player, Packet packet) {
        ServerGamePacketListenerImpl serverGamePacketListenerImpl = ((CraftPlayer)player).getHandle().connection;
        if (!serverGamePacketListenerImpl.isDisconnected()) {
            ChannelPipeline channelPipeline = null;
            if (!ajV.containsKey(player)) {
                try {
                    Connection connection = (Connection)akA.get(serverGamePacketListenerImpl);
                    channelPipeline = connection.channel.pipeline();
                    ajV.put(player, channelPipeline);
                }
                catch (IllegalAccessException illegalAccessException) {
                    bce.error("Failed to read player connection field. Some features might not work correctly!", illegalAccessException);
                }
            } else {
                channelPipeline = (ChannelPipeline)ajV.get(player);
            }
            if (channelPipeline != null) {
                channelPipeline.writeAndFlush((Object)packet);
            }
        }
    }

    public Packet aL(int n) {
        return new ClientboundRemoveEntitiesPacket(new int[]{n});
    }

    @Override
    public boolean ut() {
        return true;
    }

    @Override
    public Object c(ItemDisplay itemDisplay) {
        net.minecraft.world.entity.Entity entity = ((CraftEntity)itemDisplay).getHandle();
        return List.copyOf(entity.getEntityData().packAll());
    }

    @Override
    public void a(org.bukkit.entity.Player player, aot aot2, double d, double d2, double d3, Object object) {
        ClientboundAddEntityPacket clientboundAddEntityPacket = new ClientboundAddEntityPacket(aot2.ux(), aot2.uy(), d, d2, d3, 0.0f, 0.0f, EntityType.ITEM_DISPLAY, 0, Vec3.ZERO, 0.0);
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(aot2.ux(), apv.o(object));
        ((CraftPlayer)player).getHandle().connection.send((Packet)new ClientboundBundlePacket(List.of(clientboundAddEntityPacket, clientboundSetEntityDataPacket)));
    }

    @Override
    public void a(org.bukkit.entity.Player player, int n, Object object) {
        ((CraftPlayer)player).getHandle().connection.send((Packet)new ClientboundSetEntityDataPacket(n, apv.o(object)));
    }

    @Override
    public void a(org.bukkit.entity.Player player, int n, double d, double d2, double d3) {
        ((CraftPlayer)player).getHandle().connection.send((Packet)new ClientboundTeleportEntityPacket(n, new PositionMoveRotation(new Vec3(d, d2, d3), Vec3.ZERO, 0.0f, 0.0f), Set.of(), false));
    }

    @Override
    public void a(org.bukkit.entity.Player player, int[] nArray, int n) {
        ((CraftPlayer)player).getHandle().connection.send((Packet)new ClientboundRemoveEntitiesPacket(Arrays.copyOf(nArray, n)));
    }

    @Override
    public void a(org.bukkit.entity.Player player, List list, int[] nArray, int n) {
        ArrayList<Object> arrayList = new ArrayList<Object>(list.size() * 2 + (n > 0 ? 1 : 0));
        for (aou aou2 : list) {
            if (aou2.uE()) {
                arrayList.add(new ClientboundAddEntityPacket(aou2.uz().ux(), aou2.uz().uy(), aou2.uA(), aou2.uB(), aou2.uC(), 0.0f, 0.0f, EntityType.ITEM_DISPLAY, 0, Vec3.ZERO, 0.0));
            } else if (aou2.uF()) {
                arrayList.add(new ClientboundTeleportEntityPacket(aou2.uz().ux(), new PositionMoveRotation(new Vec3(aou2.uA(), aou2.uB(), aou2.uC()), Vec3.ZERO, 0.0f, 0.0f), Set.of(), false));
            }
            if (aou2.uD() == null) continue;
            arrayList.add(new ClientboundSetEntityDataPacket(aou2.uz().ux(), apv.o(aou2.uD())));
        }
        if (n > 0) {
            arrayList.add(new ClientboundRemoveEntitiesPacket(Arrays.copyOf(nArray, n)));
        }
        if (!arrayList.isEmpty()) {
            ((CraftPlayer)player).getHandle().connection.send((Packet)new ClientboundBundlePacket(arrayList));
        }
    }

    private static List o(Object object) {
        return (List)object;
    }

    public void a(net.minecraft.world.entity.Entity entity, Packet packet) {
        if (alh && entity.moonrise$getTrackedEntity() != null) {
            entity.moonrise$getTrackedEntity().sendToTrackingPlayersAndSelf(packet);
            return;
        }
        ((ServerChunkCache)entity.level().getChunkSource()).chunkMap.sendToTrackingPlayers(entity, packet);
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (!serverPlayer.connection.isDisconnected()) {
                serverPlayer.connection.send(packet);
            }
        }
    }

    @Override
    public void c(Object object, Object object2) {
        if (ali == null) {
            return;
        }
        zw.a(ali, object, (Object)Holder.direct((Object)object2));
    }

    @Override
    public Object dI(String string) {
        return SoundEvent.createVariableRangeEvent((Identifier)Identifier.parse((String)string));
    }

    @Override
    public String j(Object object) {
        return ((SoundEvent)((ClientboundSoundPacket)object).getSound().value()).location().toString();
    }

    @Override
    public EnumWrappers.PlayerDigType d(PacketContainer packetContainer) {
        ServerboundPlayerActionPacket serverboundPlayerActionPacket = (ServerboundPlayerActionPacket)packetContainer.getHandle();
        return switch (serverboundPlayerActionPacket.getAction()) {
            default -> throw new MatchException(null, null);
            case ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK -> EnumWrappers.PlayerDigType.START_DESTROY_BLOCK;
            case ServerboundPlayerActionPacket.Action.ABORT_DESTROY_BLOCK -> EnumWrappers.PlayerDigType.ABORT_DESTROY_BLOCK;
            case ServerboundPlayerActionPacket.Action.STOP_DESTROY_BLOCK -> EnumWrappers.PlayerDigType.STOP_DESTROY_BLOCK;
            case ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS -> EnumWrappers.PlayerDigType.DROP_ALL_ITEMS;
            case ServerboundPlayerActionPacket.Action.DROP_ITEM -> EnumWrappers.PlayerDigType.DROP_ITEM;
            case ServerboundPlayerActionPacket.Action.RELEASE_USE_ITEM -> EnumWrappers.PlayerDigType.RELEASE_USE_ITEM;
            case ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND -> EnumWrappers.PlayerDigType.SWAP_HELD_ITEMS;
            case ServerboundPlayerActionPacket.Action.STAB -> EnumWrappers.PlayerDigType.RELEASE_USE_ITEM;
        };
    }

    @Override
    public aov e(PacketContainer packetContainer) {
        ServerboundPlayerInputPacket serverboundPlayerInputPacket = (ServerboundPlayerInputPacket)packetContainer.getHandle();
        return new aov(serverboundPlayerInputPacket.input().forward(), serverboundPlayerInputPacket.input().backward(), serverboundPlayerInputPacket.input().left(), serverboundPlayerInputPacket.input().right(), serverboundPlayerInputPacket.input().jump(), serverboundPlayerInputPacket.input().shift(), serverboundPlayerInputPacket.input().sprint());
    }

    @Override
    public void a(String string, float f, float f2, SoundCategory soundCategory, Location location) {
        Collection collection = bcc.ad(location);
        if (collection.isEmpty()) {
            return;
        }
        long l = ((CraftWorld)location.getWorld()).getHandle().getRandom().nextLong();
        Holder holder = Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)Identifier.parse((String)string)));
        ClientboundSoundPacket clientboundSoundPacket = new ClientboundSoundPacket(holder, SoundSource.valueOf((String)soundCategory.name()), location.getX(), location.getY(), location.getZ(), f, f2, l);
        for (org.bukkit.entity.Player player : collection) {
            ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
            serverPlayer.connection.send((Packet)clientboundSoundPacket);
        }
    }

    @Override
    public void a(String string, SoundCategory soundCategory, Location location) {
        Collection collection = bcc.ad(location);
        if (collection.isEmpty()) {
            return;
        }
        ClientboundStopSoundPacket clientboundStopSoundPacket = new ClientboundStopSoundPacket(Identifier.parse((String)string), SoundSource.valueOf((String)soundCategory.name()));
        for (org.bukkit.entity.Player player : collection) {
            ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
            serverPlayer.connection.send((Packet)clientboundStopSoundPacket);
        }
    }

    @Override
    public void b(String string, float f, float f2, SoundCategory soundCategory, Location location) {
        Collection collection = bcc.ad(location);
        if (collection.isEmpty()) {
            return;
        }
        long l = ((CraftWorld)location.getWorld()).getHandle().getRandom().nextLong();
        Holder holder = Holder.direct((Object)SoundEvent.createVariableRangeEvent((Identifier)Identifier.parse((String)string)));
        ClientboundStopSoundPacket clientboundStopSoundPacket = new ClientboundStopSoundPacket(Identifier.parse((String)string), SoundSource.valueOf((String)soundCategory.name()));
        ClientboundSoundPacket clientboundSoundPacket = new ClientboundSoundPacket(holder, SoundSource.valueOf((String)soundCategory.name()), location.getX(), location.getY(), location.getZ(), f, f2, l);
        for (org.bukkit.entity.Player player : collection) {
            ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
            serverPlayer.connection.send((Packet)clientboundStopSoundPacket);
            serverPlayer.connection.send((Packet)clientboundSoundPacket);
        }
    }

    @Override
    public void f(PacketContainer packetContainer) {
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair((Object)EquipmentSlot.HEAD, (Object)ItemStack.EMPTY));
        arrayList.add(new Pair((Object)EquipmentSlot.CHEST, (Object)ItemStack.EMPTY));
        arrayList.add(new Pair((Object)EquipmentSlot.LEGS, (Object)ItemStack.EMPTY));
        arrayList.add(new Pair((Object)EquipmentSlot.FEET, (Object)ItemStack.EMPTY));
        arrayList.add(new Pair((Object)EquipmentSlot.MAINHAND, (Object)ItemStack.EMPTY));
        arrayList.add(new Pair((Object)EquipmentSlot.OFFHAND, (Object)ItemStack.EMPTY));
        packetContainer.getModifier().write(1, arrayList);
    }

    @Override
    public void a(org.bukkit.entity.Player player, String string, int n) {
        ServerPlayer serverPlayer;
        DedicatedServerProperties dedicatedServerProperties = ((DedicatedServer)MinecraftServer.getServer()).getProperties();
        try {
            serverPlayer = dedicatedServerProperties.acceptsTransfers.getClass();
            Constructor<?> constructor = serverPlayer.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            Object obj = constructor.newInstance(dedicatedServerProperties, "", true, object -> true);
            Field field = DedicatedServerProperties.class.getDeclaredField("acceptsTransfers");
            field.setAccessible(true);
            field.set(dedicatedServerProperties, obj);
            ServerPlayer serverPlayer2 = ((CraftPlayer)player).getHandle();
            serverPlayer2.connection.send((Packet)new ClientboundTransferPacket(string, n));
        }
        catch (Exception exception) {
            bce.error("Failed to set acceptsTransfers property", exception);
        }
        serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundTransferPacket(string, n));
    }

    @Override
    public void g(PacketContainer packetContainer) {
        packetContainer.getSpecificModifier(Optional.class).write(1, Optional.of(BlankFormat.INSTANCE));
    }

    @Override
    public ItemDisplay b(Location location, Consumer consumer) {
        Display.ItemDisplay itemDisplay = new Display.ItemDisplay(EntityType.ITEM_DISPLAY, (Level)((CraftWorld)location.getWorld()).getHandle());
        itemDisplay.setPos(location.getX(), location.getY(), location.getZ());
        ItemDisplay itemDisplay2 = (ItemDisplay)itemDisplay.getBukkitEntity();
        if (consumer != null) {
            consumer.accept(itemDisplay2);
        }
        return (ItemDisplay)itemDisplay.getBukkitEntity();
    }

    @Override
    public void h(Entity entity, org.bukkit.entity.Player player) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        Location location = entity.getLocation();
        ClientboundBundlePacket clientboundBundlePacket = new ClientboundBundlePacket(List.of(new ClientboundAddEntityPacket(entity2.getId(), entity2.getUUID(), location.getX(), location.getY(), location.getZ(), entity.getLocation().getPitch(), entity.getLocation().getYaw(), entity2.getType(), 0, new Vec3(0.0, 0.0, 0.0), 0.0), new ClientboundSetEntityDataPacket(entity2.getId(), entity2.getEntityData().packAll())));
        ((CraftPlayer)player).getHandle().connection.send((Packet)clientboundBundlePacket);
    }

    @Override
    public void S(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(entity2.getId(), entity2.getEntityData().packAll());
        for (Player player : entity2.level().players()) {
            if (!(player instanceof ServerPlayer)) continue;
            ServerPlayer serverPlayer = (ServerPlayer)player;
            serverPlayer.connection.send((Packet)clientboundSetEntityDataPacket);
        }
    }

    @Override
    public void a(Entity entity, Location location) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.setPosRaw(location.getX(), location.getY(), location.getZ());
        entity2.setYRot(location.getYaw());
        entity2.setYHeadRot(location.getYaw());
        entity2.setXRot(location.getPitch());
        ClientboundBundlePacket clientboundBundlePacket = new ClientboundBundlePacket(List.of(new ClientboundTeleportEntityPacket(entity2.getId(), new PositionMoveRotation(new Vec3(location.getX(), location.getY(), location.getZ()), new Vec3(0.0, 0.0, 0.0), location.getYaw(), location.getPitch()), Set.of(), false), new ClientboundRotateHeadPacket(entity2, Mth.packDegrees((float)location.getYaw()))));
        for (Player player : entity2.level().players()) {
            if (!(player instanceof ServerPlayer)) continue;
            ServerPlayer serverPlayer = (ServerPlayer)player;
            serverPlayer.connection.send((Packet)clientboundBundlePacket);
        }
    }

    @Override
    public void a(Entity entity, org.bukkit.entity.Player player, Location location) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.setPosRaw(location.getX(), location.getY(), location.getZ());
        entity2.setYRot(location.getYaw());
        entity2.setYHeadRot(location.getYaw());
        entity2.setXRot(location.getPitch());
        ClientboundBundlePacket clientboundBundlePacket = new ClientboundBundlePacket(List.of(new ClientboundTeleportEntityPacket(entity2.getId(), new PositionMoveRotation(new Vec3(location.getX(), location.getY(), location.getZ()), new Vec3(0.0, 0.0, 0.0), location.getYaw(), location.getPitch()), Set.of(), false), new ClientboundRotateHeadPacket(entity2, Mth.packDegrees((float)location.getYaw()))));
        ((CraftPlayer)player).getHandle().connection.connection.send((Packet)clientboundBundlePacket);
    }

    @Override
    public void c(Entity entity, org.bukkit.entity.Player player, boolean bl) {
        List list;
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        if (bl ? (list = entity2.getEntityData().packDirty()) == null : (list = entity2.getEntityData().packAll()).isEmpty()) {
            return;
        }
        ((CraftPlayer)player).getHandle().connection.send((Packet)new ClientboundSetEntityDataPacket(entity2.getId(), list));
    }

    @Override
    public void i(Entity entity, org.bukkit.entity.Player player) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(new int[]{entity2.getId()});
        ((CraftPlayer)player).getHandle().connection.send((Packet)clientboundRemoveEntitiesPacket);
    }

    @Override
    public void T(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(new int[]{entity2.getId()});
        for (Player player : entity2.level().players()) {
            if (!(player instanceof ServerPlayer)) continue;
            ServerPlayer serverPlayer = (ServerPlayer)player;
            serverPlayer.connection.send((Packet)clientboundRemoveEntitiesPacket);
        }
    }

    @Override
    public void a(org.bukkit.entity.Player player, IntList intList) {
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(intList);
        ((CraftPlayer)player).getHandle().connection.send((Packet)clientboundRemoveEntitiesPacket);
    }

    @Override
    public List uw() {
        CraftServer craftServer = (CraftServer)Bukkit.getServer();
        ServerConnectionListener serverConnectionListener = craftServer.getServer().getConnection();
        Field field = aor.k(serverConnectionListener);
        List list = (List)field.get(serverConnectionListener);
        return list;
    }

    @Override
    @Nullable
    public Integer a(PacketType packetType) {
        Class clazz = packetType.getPacketClass();
        if (clazz == null) {
            return null;
        }
        net.minecraft.network.protocol.PacketType packetType2 = null;
        Class[] classArray = new Class[]{GamePacketTypes.class, CommonPacketTypes.class, CookiePacketTypes.class, PingPacketTypes.class};
        for (Class clazz2 : classArray) {
            for (Field field : clazz2.getDeclaredFields()) {
                ParameterizedType parameterizedType;
                Type type;
                Type type2;
                if (!Modifier.isStatic(field.getModifiers()) || !net.minecraft.network.protocol.PacketType.class.isAssignableFrom(field.getType()) || !((type2 = field.getGenericType()) instanceof ParameterizedType) || (type = (parameterizedType = (ParameterizedType)type2).getActualTypeArguments()[0]) != clazz) continue;
                try {
                    packetType2 = (net.minecraft.network.protocol.PacketType)field.get(null);
                    break;
                }
                catch (IllegalAccessException illegalAccessException) {
                    return null;
                }
            }
            if (packetType2 != null) break;
        }
        if (packetType2 == null) {
            return null;
        }
        Constable[] constableArray = new Integer[]{null};
        net.minecraft.network.protocol.PacketType packetType3 = packetType2;
        (packetType.isClient() ? GameProtocols.SERVERBOUND_TEMPLATE : GameProtocols.CLIENTBOUND_TEMPLATE).details().listPackets((arg_0, arg_1) -> apv.a(packetType3, (Integer[])constableArray, arg_0, arg_1));
        return constableArray[0];
    }

    @Override
    public /* synthetic */ void b(Object object, Object object2) {
        this.a((net.minecraft.world.entity.Entity)object, (Packet)object2);
    }

    @Override
    public /* synthetic */ Object aJ(int n) {
        return this.aL(n);
    }

    @Override
    public /* synthetic */ void d(org.bukkit.entity.Player player, Object object) {
        this.b(player, (Packet)object);
    }

    @Override
    public /* synthetic */ void c(org.bukkit.entity.Player player, Object object) {
        this.a(player, (FriendlyByteBuf)object);
    }

    private static /* synthetic */ void a(net.minecraft.network.protocol.PacketType packetType, Integer[] integerArray, net.minecraft.network.protocol.PacketType packetType2, int n) {
        if (packetType2.equals((Object)packetType)) {
            integerArray[0] = n;
        }
    }
}
