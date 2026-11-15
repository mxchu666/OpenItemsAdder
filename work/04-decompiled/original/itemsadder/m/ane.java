package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketListener;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.ana;
import itemsadder.m.anb;
import itemsadder.m.anf;
import itemsadder.m.aow;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.zw;
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
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ane
extends ana {
    static MethodHandle ajr = zw.a(PacketPlayOutMount.class, new Class[]{PacketDataSerializer.class});

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
            this.a((anb)entry.getValue());
        }
        aow.l(this);
    }

    @Override
    protected void au() {
        bev.a(this);
        aow.a((PacketListener)new anf(this, aow.uO().types(new PacketType[]{aow.o(PacketPlayInFlying.PacketPlayInPositionLook.class), aow.o(PacketPlayInFlying.PacketPlayInPosition.class), aow.o(PacketPlayInFlying.PacketPlayInLook.class)}).optionAsync()));
    }

    public static byte x(float f) {
        return (byte)MathHelper.d((float)(f * 256.0f / 360.0f));
    }

    @Override
    public boolean i(Player player, Location location) {
        if (ane.bU(player)) {
            return false;
        }
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        EntityZombie entityZombie = new EntityZombie(EntityTypes.bu, entityPlayer.dO());
        Location location2 = player.getLocation().add(player.getLocation().getDirection().normalize().multiply(-3.0));
        entityZombie.o(location2.getX(), location2.getY(), location2.getZ());
        entityZombie.f(true);
        entityZombie.n(true);
        entityZombie.k(true);
        Vec3D vec3D = new Vec3D(location.getX(), location.getY(), location.getZ());
        double d = vec3D.c - entityZombie.dt();
        double d2 = vec3D.e - entityZombie.dz();
        double d3 = vec3D.d - (entityZombie.dv() + (double)entityZombie.cL());
        float f = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        entityZombie.t(f);
        entityZombie.u(f2);
        entityZombie.o(f);
        entityZombie.a(ArgumentAnchor.Anchor.b, vec3D);
        this.a(entityZombie, player);
        anb anb2 = new anb(player, player.getEyeLocation(), (Entity)entityZombie.getBukkitEntity(), player.getLocation().clone());
        this.ajl.put((Object)player, (Object)anb2);
        entityPlayer.c.b((Packet)new PacketPlayOutEntityTeleport((net.minecraft.world.entity.Entity)entityZombie));
        entityPlayer.c.b((Packet)new PacketPlayOutEntity.PacketPlayOutEntityLook(entityZombie.an(), ane.x(entityZombie.dE()), ane.x(entityZombie.dG()), false));
        entityPlayer.c.b((Packet)new PacketPlayOutEntityHeadRotation((net.minecraft.world.entity.Entity)entityZombie, ane.x(entityZombie.dE())));
        entityPlayer.c.b((Packet)new PacketPlayOutCamera((net.minecraft.world.entity.Entity)entityZombie));
        int[] nArray = new int[]{entityPlayer.an()};
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer());
        packetDataSerializer.c(entityZombie.an());
        packetDataSerializer.a(nArray);
        PacketPlayOutMount packetPlayOutMount = (PacketPlayOutMount)ane.i(packetDataSerializer);
        entityPlayer.c.b((Packet)packetPlayOutMount);
        entityPlayer.c.b((Packet)new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.e, (float)EnumGamemode.d.a()));
        player.sendActionBar((Component)Component.text((String)"Press SHIFT to exit"));
        return true;
    }

    @Override
    protected void a(anb anb2) {
        Player player = anb2.un();
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = ((CraftEntity)anb2.up()).getHandle();
        PacketPlayOutCamera packetPlayOutCamera = new PacketPlayOutCamera((net.minecraft.world.entity.Entity)entityPlayer);
        entityPlayer.c.b((Packet)packetPlayOutCamera);
        this.b(player, entity.an());
        entityPlayer.c.b((Packet)new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.e, (float)entityPlayer.e.b().a()));
        entityPlayer.c.b((Packet)new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.a.c), new ClientboundPlayerInfoUpdatePacket.b(entityPlayer.cz(), entityPlayer.fX(), true, entityPlayer.c.k(), entityPlayer.e.b(), entityPlayer.O(), (RemoteChatSession.a)Optionull.a((Object)entityPlayer.ac(), RemoteChatSession::a))));
        this.ajl.remove((Object)player);
        if (player.getWorld().equals((Object)anb2.uq().getWorld())) {
            bcp.b((Entity)player, anb2.uq());
        }
    }

    @Override
    public void a(Object object, Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = (net.minecraft.world.entity.Entity)object;
        entityPlayer.c.b((Packet)new PacketPlayOutSpawnEntity(entity.an(), entity.cz(), entity.dn().a(), entity.dn().b(), entity.dn().c(), entity.dG(), entity.dE(), entity.am(), 0, entity.dr(), (double)entity.ct()));
        entityPlayer.c.b((Packet)new PacketPlayOutEntityMetadata(entity.an(), entity.ar().c()));
    }

    @Override
    public void b(Player player, int ... nArray) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.c.b((Packet)new PacketPlayOutEntityDestroy(nArray));
    }

    static /* synthetic */ Object2ObjectOpenHashMap a(ane ane2) {
        return ane2.ajl;
    }

    static /* synthetic */ float y(float f) {
        return ane.s(f);
    }

    static /* synthetic */ float z(float f) {
        return ane.s(f);
    }

    static /* synthetic */ Location b(Location location, float f, float f2) {
        return ane.a(location, f, f2);
    }
}
