package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.mojang.datafixers.util.Pair;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque052;
import itemsadder.m.PlayerWrapper_4;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.core.Holder;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.chat.numbers.BlankFormat;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.network.protocol.common.CommonPacketTypes;
import net.minecraft.network.protocol.cookie.CookiePacketTypes;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.GamePacketTypes;
import net.minecraft.network.protocol.game.GameProtocols;
import net.minecraft.network.protocol.game.PacketPlayInBlockDig;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import net.minecraft.network.protocol.game.PacketPlayOutNamedSoundEffect;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.network.protocol.game.PacketPlayOutStopSound;
import net.minecraft.network.protocol.ping.PingPacketTypes;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.level.ChunkProviderServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.PlayerChunkMap;
import net.minecraft.server.network.PlayerConnection;
import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import net.minecraft.server.network.ServerConnection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.World;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.craftbukkit.v1_20_R4.CraftServer;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;

public class BlockNms_1_20_6_13
implements PlayerWrapper_4 {
    private static final boolean akz = VersionHelper_3.a(net.minecraft.world.entity.Entity.class, PlayerChunkMap.EntityTracker.class) != null;
    static Field akA = VersionHelper_3.a(ServerCommonPacketListenerImpl.class, NetworkManager.class);
    private static final Field akB = VersionHelper_3.a(PacketPlayOutNamedSoundEffect.class, Holder.class);

    public void a(Player player, PacketDataSerializer packetDataSerializer) {
        PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().c;
        if (!playerConnection.isDisconnected()) {
            ChannelHandlerContext channelHandlerContext = (ChannelHandlerContext)ajU.get(player);
            if (channelHandlerContext == null) {
                try {
                    NetworkManager networkManager = (NetworkManager)akA.get(playerConnection);
                    channelHandlerContext = networkManager.n.pipeline().context("encoder");
                    ajU.put(player, channelHandlerContext);
                }
                catch (IllegalAccessException illegalAccessException) {
                    CommandSenderBridge_5.error("Failed to read player connection field. Some features might not work correctly!", illegalAccessException);
                }
            }
            if (channelHandlerContext != null) {
                if (MaterialBarColorHolder.dO) {
                    Opaque052.a(channelHandlerContext, packetDataSerializer);
                } else {
                    channelHandlerContext.writeAndFlush((Object)packetDataSerializer);
                }
            }
        }
    }

    @Override
    public void ak(Player player) {
        PlayerWrapper_4.super.ak(player);
        PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().c;
        if (!playerConnection.isDisconnected()) {
            try {
                NetworkManager networkManager = (NetworkManager)akA.get(playerConnection);
                for (String string : networkManager.n.pipeline().names()) {
                    Opaque052.b(networkManager.n.pipeline().context(string));
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                CommandSenderBridge_5.error("Failed to read player connection field. Some features might not work correctly!", illegalAccessException);
            }
        }
    }

    public void b(Player player, Packet packet) {
        PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().c;
        if (!playerConnection.isDisconnected()) {
            ChannelPipeline channelPipeline = null;
            if (!ajV.containsKey(player)) {
                try {
                    NetworkManager networkManager = (NetworkManager)akA.get(playerConnection);
                    channelPipeline = networkManager.n.pipeline();
                    ajV.put(player, channelPipeline);
                }
                catch (IllegalAccessException illegalAccessException) {
                    CommandSenderBridge_5.error("Failed to read player connection field. Some features might not work correctly!", illegalAccessException);
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
        return new PacketPlayOutEntityDestroy(new int[]{n});
    }

    public void a(net.minecraft.world.entity.Entity entity, Packet packet) {
        if (akz && entity.tracker != null) {
            entity.tracker.b(packet);
            return;
        }
        ((ChunkProviderServer)entity.dP().N()).a.a(entity, packet);
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (!entityPlayer.c.isDisconnected()) {
                entityPlayer.c.b(packet);
            }
        }
    }

    @Override
    public void c(Object object, Object object2) {
        if (akB == null) {
            return;
        }
        VersionHelper_3.a(akB, object, (Object)Holder.a((Object)object2));
    }

    @Override
    public Object dI(String string) {
        return SoundEffect.a((MinecraftKey)new MinecraftKey(string));
    }

    @Override
    public String j(Object object) {
        return ((SoundEffect)((PacketPlayOutNamedSoundEffect)object).b().a()).a().toString();
    }

    @Override
    public EnumWrappers.PlayerDigType d(PacketContainer packetContainer) {
        PacketPlayInBlockDig packetPlayInBlockDig = (PacketPlayInBlockDig)packetContainer.getHandle();
        return switch (packetPlayInBlockDig.f()) {
            default -> throw new MatchException(null, null);
            case PacketPlayInBlockDig.EnumPlayerDigType.a -> EnumWrappers.PlayerDigType.START_DESTROY_BLOCK;
            case PacketPlayInBlockDig.EnumPlayerDigType.b -> EnumWrappers.PlayerDigType.ABORT_DESTROY_BLOCK;
            case PacketPlayInBlockDig.EnumPlayerDigType.c -> EnumWrappers.PlayerDigType.STOP_DESTROY_BLOCK;
            case PacketPlayInBlockDig.EnumPlayerDigType.d -> EnumWrappers.PlayerDigType.DROP_ALL_ITEMS;
            case PacketPlayInBlockDig.EnumPlayerDigType.e -> EnumWrappers.PlayerDigType.DROP_ITEM;
            case PacketPlayInBlockDig.EnumPlayerDigType.f -> EnumWrappers.PlayerDigType.RELEASE_USE_ITEM;
            case PacketPlayInBlockDig.EnumPlayerDigType.g -> EnumWrappers.PlayerDigType.SWAP_HELD_ITEMS;
        };
    }

    @Override
    public void a(String string, float f, float f2, SoundCategory soundCategory, Location location) {
        int n = location.getWorld().getViewDistance() * 16;
        long l = ((CraftWorld)location.getWorld()).getHandle().z.g();
        Holder holder = Holder.a((Object)SoundEffect.a((MinecraftKey)new MinecraftKey(string)));
        PacketPlayOutNamedSoundEffect packetPlayOutNamedSoundEffect = new PacketPlayOutNamedSoundEffect(holder, net.minecraft.sounds.SoundCategory.valueOf((String)soundCategory.name()), location.getX(), location.getY(), location.getZ(), f, f2, l);
        for (EntityPlayer entityPlayer : ((CraftWorld)location.getWorld()).getHandle().x()) {
            if (!(entityPlayer.i(location.getX(), location.getY(), location.getZ()) < (double)(n * n))) continue;
            entityPlayer.c.b((Packet)packetPlayOutNamedSoundEffect);
        }
    }

    @Override
    public void a(String string, SoundCategory soundCategory, Location location) {
        int n = location.getWorld().getViewDistance() * 16;
        PacketPlayOutStopSound packetPlayOutStopSound = new PacketPlayOutStopSound(new MinecraftKey(string), net.minecraft.sounds.SoundCategory.valueOf((String)soundCategory.name()));
        for (EntityPlayer entityPlayer : ((CraftWorld)location.getWorld()).getHandle().x()) {
            if (!(entityPlayer.i(location.getX(), location.getY(), location.getZ()) < (double)(n * n))) continue;
            entityPlayer.c.b((Packet)packetPlayOutStopSound);
        }
    }

    @Override
    public void b(String string, float f, float f2, SoundCategory soundCategory, Location location) {
        int n = location.getWorld().getViewDistance() * 16;
        long l = ((CraftWorld)location.getWorld()).getHandle().z.g();
        Holder holder = Holder.a((Object)SoundEffect.a((MinecraftKey)new MinecraftKey(string)));
        PacketPlayOutStopSound packetPlayOutStopSound = new PacketPlayOutStopSound(new MinecraftKey(string), net.minecraft.sounds.SoundCategory.valueOf((String)soundCategory.name()));
        PacketPlayOutNamedSoundEffect packetPlayOutNamedSoundEffect = new PacketPlayOutNamedSoundEffect(holder, net.minecraft.sounds.SoundCategory.valueOf((String)soundCategory.name()), location.getX(), location.getY(), location.getZ(), f, f2, l);
        for (EntityPlayer entityPlayer : ((CraftWorld)location.getWorld()).getHandle().x()) {
            if (!(entityPlayer.i(location.getX(), location.getY(), location.getZ()) < (double)(n * n))) continue;
            entityPlayer.c.b((Packet)packetPlayOutStopSound);
            entityPlayer.c.b((Packet)packetPlayOutNamedSoundEffect);
        }
    }

    @Override
    public void f(PacketContainer packetContainer) {
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair((Object)EnumItemSlot.f, (Object)ItemStack.l));
        arrayList.add(new Pair((Object)EnumItemSlot.e, (Object)ItemStack.l));
        arrayList.add(new Pair((Object)EnumItemSlot.d, (Object)ItemStack.l));
        arrayList.add(new Pair((Object)EnumItemSlot.c, (Object)ItemStack.l));
        arrayList.add(new Pair((Object)EnumItemSlot.a, (Object)ItemStack.l));
        arrayList.add(new Pair((Object)EnumItemSlot.b, (Object)ItemStack.l));
        packetContainer.getModifier().write(1, arrayList);
    }

    @Override
    public void a(Player player, String string, int n) {
        ((DedicatedServer)MinecraftServer.getServer()).r.a().aa = true;
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.c.b((Packet)new ClientboundTransferPacket(string, n));
    }

    @Override
    public void g(PacketContainer packetContainer) {
        packetContainer.getSpecificModifier(Optional.class).write(1, Optional.of(BlankFormat.a));
    }

    @Override
    public ItemDisplay b(Location location, Consumer consumer) {
        Display.ItemDisplay itemDisplay = new Display.ItemDisplay(EntityTypes.ah, (World)((CraftWorld)location.getWorld()).getHandle());
        ItemDisplay itemDisplay2 = (ItemDisplay)itemDisplay.getBukkitEntity();
        if (consumer != null) {
            consumer.accept(itemDisplay2);
        }
        return (ItemDisplay)itemDisplay.getBukkitEntity();
    }

    @Override
    public void h(Entity entity, Player player) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        Location location = entity.getLocation();
        ClientboundBundlePacket clientboundBundlePacket = new ClientboundBundlePacket(List.of(new PacketPlayOutSpawnEntity(entity2.al(), entity2.cz(), location.getX(), location.getY(), location.getZ(), entity.getLocation().getPitch(), entity.getLocation().getYaw(), entity2.ak(), 0, new Vec3D(0.0, 0.0, 0.0), 0.0), new PacketPlayOutEntityMetadata(entity2.al(), entity2.ap().packAll()), new PacketPlayOutEntityTeleport(entity2), new PacketPlayOutEntityHeadRotation(entity2, (byte)MathHelper.d((float)(entity.getLocation().getYaw() * 256.0f / 360.0f)))));
        ((CraftPlayer)player).getHandle().c.b((Packet)clientboundBundlePacket);
    }

    @Override
    public void S(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(entity2.al(), entity2.ap().packAll());
        for (EntityHuman entityHuman : entity2.dP().x()) {
            if (!(entityHuman instanceof EntityPlayer)) continue;
            EntityPlayer entityPlayer = (EntityPlayer)entityHuman;
            entityPlayer.c.b((Packet)packetPlayOutEntityMetadata);
        }
    }

    @Override
    public void a(Entity entity, Location location) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.p(location.getX(), location.getY(), location.getZ());
        entity2.r(location.getYaw());
        entity2.n(location.getYaw());
        entity2.s(location.getPitch());
        ClientboundBundlePacket clientboundBundlePacket = new ClientboundBundlePacket(List.of(new PacketPlayOutEntityTeleport(entity2), new PacketPlayOutEntityHeadRotation(entity2, (byte)MathHelper.d((float)(entity.getLocation().getYaw() * 256.0f / 360.0f)))));
        for (EntityHuman entityHuman : entity2.dP().x()) {
            if (!(entityHuman instanceof EntityPlayer)) continue;
            EntityPlayer entityPlayer = (EntityPlayer)entityHuman;
            entityPlayer.c.b((Packet)clientboundBundlePacket);
        }
    }

    @Override
    public void a(Entity entity, Player player, Location location) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.p(location.getX(), location.getY(), location.getZ());
        entity2.r(location.getYaw());
        entity2.n(location.getYaw());
        entity2.s(location.getPitch());
        ClientboundBundlePacket clientboundBundlePacket = new ClientboundBundlePacket(List.of(new PacketPlayOutEntityTeleport(entity2), new PacketPlayOutEntityHeadRotation(entity2, (byte)MathHelper.d((float)(entity.getLocation().getYaw() * 256.0f / 360.0f)))));
        ((CraftPlayer)player).getHandle().c.b((Packet)clientboundBundlePacket);
    }

    @Override
    public void c(Entity entity, Player player, boolean bl) {
        List list;
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        if (bl ? (list = entity2.ap().b()) == null : (list = entity2.ap().packAll()).isEmpty()) {
            return;
        }
        ((CraftPlayer)player).getHandle().c.b((Packet)new PacketPlayOutEntityMetadata(entity2.al(), list));
    }

    @Override
    public void i(Entity entity, Player player) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[]{entity2.al()});
        ((CraftPlayer)player).getHandle().c.b((Packet)packetPlayOutEntityDestroy);
    }

    @Override
    public void a(Player player, IntList intList) {
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(intList);
        ((CraftPlayer)player).getHandle().c.b((Packet)packetPlayOutEntityDestroy);
    }

    @Override
    public List uw() {
        CraftServer craftServer = (CraftServer)Bukkit.getServer();
        ServerConnection serverConnection = craftServer.getServer().ai();
        Field field = PlayerWrapper_4.k(serverConnection);
        List list = (List)field.get(serverConnection);
        return list;
    }

    @Override
    public Integer a(PacketType packetType) {
        Type type;
        Object object;
        Class clazz = packetType.getPacketClass();
        if (clazz == null) {
            return null;
        }
        net.minecraft.network.protocol.PacketType packetType2 = null;
        Class[] classArray = new Class[]{GamePacketTypes.class, CommonPacketTypes.class, CookiePacketTypes.class, PingPacketTypes.class};
        for (Class fieldArray : classArray) {
            Field[] fieldArray2 = fieldArray.getDeclaredFields();
            int n = fieldArray2.length;
            for (int i = 0; i < n; ++i) {
                ParameterizedType parameterizedType;
                Type type2;
                object = fieldArray2[i];
                if (!Modifier.isStatic(((Field)object).getModifiers()) || !net.minecraft.network.protocol.PacketType.class.isAssignableFrom(((Field)object).getType()) || !((type = ((Field)object).getGenericType()) instanceof ParameterizedType) || (type2 = (parameterizedType = (ParameterizedType)type).getActualTypeArguments()[0]) != clazz) continue;
                try {
                    packetType2 = (net.minecraft.network.protocol.PacketType)((Field)object).get(null);
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
        try {
            Field field = GameProtocols.class.getDeclaredField(packetType.isClient() ? "SERVERBOUND" : "CLIENTBOUND");
            Object object2 = field.get(null);
            Object object3 = object2.getClass().getMethod("codec", new Class[0]).invoke(object2, new Object[0]);
            for (Field field2 : object3.getClass().getDeclaredFields()) {
                field2.setAccessible(true);
                object = field2.get(object3);
                if (!(object instanceof Object2IntMap) || !(type = (Object2IntMap)object).containsKey(packetType2)) continue;
                return type.getInt(packetType2);
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
        return null;
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
    public /* synthetic */ void d(Player player, Object object) {
        this.b(player, (Packet)object);
    }

    @Override
    public /* synthetic */ void c(Player player, Object object) {
        this.a(player, (PacketDataSerializer)object);
    }
}
