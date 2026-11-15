package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketListener;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityDamageListenerBase;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_3;
import itemsadder.m.PlayerLocationHolder;
import itemsadder.m.VersionHelper_3;
import java.lang.invoke.MethodHandle;
import java.util.EnumSet;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.minecraft.Optionull;
import net.minecraft.commands.arguments.ArgumentAnchor;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.chat.RemoteChatSession;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.PacketPlayInFlying;
import net.minecraft.network.protocol.game.PacketPlayOutCamera;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import net.minecraft.network.protocol.game.PacketPlayOutGameStateChange;
import net.minecraft.network.protocol.game.PacketPlayOutMount;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.level.EnumGamemode;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class BlockNms_1_20_6_17
extends EntityDamageListenerBase {
    static MethodHandle ajr = VersionHelper_3.a(PacketPlayOutMount.class, new Class[]{PacketDataSerializer.class});

    public static Object i(Object object) {
        try {
            return ajr.invokeExact((PacketDataSerializer)object);
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    @Override
    protected void um() {
        for (Map.Entry entry : this.ajl.entrySet()) {
            this.a((PlayerLocationHolder)entry.getValue());
        }
        PacketListenerRegistry.l(this);
    }

    @Override
    protected void au() {
        ListenerBridge.a(this);
        PacketListenerRegistry.a((PacketListener)new PacketListener_3(this, PacketListenerRegistry.uO().types(new PacketType[]{PacketListenerRegistry.o(PacketPlayInFlying.PacketPlayInPositionLook.class), PacketListenerRegistry.o(PacketPlayInFlying.PacketPlayInPosition.class), PacketListenerRegistry.o(PacketPlayInFlying.PacketPlayInLook.class)}).optionAsync()));
    }

    public static byte x(float f) {
        return (byte)MathHelper.d((float)(f * 256.0f / 360.0f));
    }

    @Override
    public boolean i(Player player, Location location) {
        if (BlockNms_1_20_6_17.bU(player)) {
            return false;
        }
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        EntityZombie entityZombie = new EntityZombie(EntityTypes.bu, entityPlayer.dP());
        Location location2 = player.getLocation().add(player.getLocation().getDirection().normalize().multiply(-3.0));
        entityZombie.p(location2.getX(), location2.getY(), location2.getZ());
        entityZombie.f(true);
        entityZombie.n(true);
        entityZombie.k(true);
        Vec3D vec3D = new Vec3D(location.getX(), location.getY(), location.getZ());
        double d = vec3D.c - entityZombie.du();
        double d2 = vec3D.e - entityZombie.dA();
        double d3 = vec3D.d - (entityZombie.dw() + (double)entityZombie.cL());
        float f = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        entityZombie.r(f);
        entityZombie.s(f2);
        entityZombie.n(f);
        entityZombie.a(ArgumentAnchor.Anchor.b, vec3D);
        this.a(entityZombie, player);
        PlayerLocationHolder playerLocationHolder = new PlayerLocationHolder(player, player.getEyeLocation(), (Entity)entityZombie.getBukkitEntity(), player.getLocation().clone());
        this.ajl.put((Object)player, (Object)playerLocationHolder);
        entityPlayer.c.b((Packet)new PacketPlayOutEntityTeleport((net.minecraft.world.entity.Entity)entityZombie));
        entityPlayer.c.b((Packet)new PacketPlayOutEntity.PacketPlayOutEntityLook(entityZombie.al(), BlockNms_1_20_6_17.x(entityZombie.dF()), BlockNms_1_20_6_17.x(entityZombie.dH()), false));
        entityPlayer.c.b((Packet)new PacketPlayOutEntityHeadRotation((net.minecraft.world.entity.Entity)entityZombie, BlockNms_1_20_6_17.x(entityZombie.dF())));
        entityPlayer.c.b((Packet)new PacketPlayOutCamera((net.minecraft.world.entity.Entity)entityZombie));
        int[] nArray = new int[]{entityPlayer.al()};
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer());
        packetDataSerializer.c(entityZombie.al());
        packetDataSerializer.a(nArray);
        PacketPlayOutMount packetPlayOutMount = (PacketPlayOutMount)BlockNms_1_20_6_17.i(packetDataSerializer);
        entityPlayer.c.b((Packet)packetPlayOutMount);
        entityPlayer.c.b((Packet)new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.e, (float)EnumGamemode.d.a()));
        player.sendActionBar((Component)Component.text((String)"Press SHIFT to exit"));
        return true;
    }

    @Override
    protected void a(PlayerLocationHolder playerLocationHolder) {
        Player player = playerLocationHolder.un();
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = ((CraftEntity)playerLocationHolder.up()).getHandle();
        PacketPlayOutCamera packetPlayOutCamera = new PacketPlayOutCamera((net.minecraft.world.entity.Entity)entityPlayer);
        entityPlayer.c.b((Packet)packetPlayOutCamera);
        this.b(player, entity.al());
        entityPlayer.c.b((Packet)new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.e, (float)entityPlayer.e.b().a()));
        entityPlayer.c.b((Packet)new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.a.c), new ClientboundPlayerInfoUpdatePacket.b(entityPlayer.cz(), entityPlayer.gb(), true, entityPlayer.c.k(), entityPlayer.e.b(), entityPlayer.N(), (RemoteChatSession.a)Optionull.a((Object)entityPlayer.ab(), RemoteChatSession::a))));
        this.ajl.remove((Object)player);
        if (player.getWorld().equals((Object)playerLocationHolder.uq().getWorld())) {
            BukkitTaskBridge.b((Entity)player, playerLocationHolder.uq());
        }
    }

    @Override
    public void a(Object object, Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = (net.minecraft.world.entity.Entity)object;
        entityPlayer.c.b((Packet)new PacketPlayOutSpawnEntity(entity.al(), entity.cz(), entity.do().a(), entity.do().b(), entity.do().c(), entity.dH(), entity.dF(), entity.ak(), 0, entity.ds(), (double)entity.cs()));
        entityPlayer.c.b((Packet)new PacketPlayOutEntityMetadata(entity.al(), entity.ap().c()));
    }

    @Override
    public void b(Player player, int ... nArray) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.c.b((Packet)new PacketPlayOutEntityDestroy(nArray));
    }

    static /* synthetic */ Object2ObjectOpenHashMap a(BlockNms_1_20_6_17 blockNms_1_20_6_17) {
        return blockNms_1_20_6_17.ajl;
    }

    static /* synthetic */ float y(float f) {
        return BlockNms_1_20_6_17.s(f);
    }

    static /* synthetic */ float z(float f) {
        return BlockNms_1_20_6_17.s(f);
    }

    static /* synthetic */ Location b(Location location, float f, float f2) {
        return BlockNms_1_20_6_17.a(location, f, f2);
    }
}
