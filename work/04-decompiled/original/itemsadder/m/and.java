package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.anb;
import itemsadder.m.anc;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayInFlying;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_20_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

class and
extends PacketAdapter {
    final /* synthetic */ anc ajs;

    and(anc anc2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ajs = anc2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        anb anb2 = (anb)anc.a(this.ajs).get((Object)player);
        if (anb2 == null) {
            return;
        }
        packetEvent.setCancelled(true);
        Object object = packetEvent.getPacket().getHandle();
        if (!(object instanceof PacketPlayInFlying.PacketPlayInLook)) {
            return;
        }
        PacketPlayInFlying.PacketPlayInLook packetPlayInLook = (PacketPlayInFlying.PacketPlayInLook)object;
        float f = packetPlayInLook.d;
        float f2 = packetPlayInLook.e;
        float f3 = anb2.t(f);
        float f4 = anb2.u(f2);
        float f5 = anc.y(f - f3);
        float f6 = anc.z(f2 - f4);
        anb2.v(f);
        anb2.w(f2);
        if (f5 == 0.0f && f6 == 0.0f) {
            return;
        }
        if ((double)Math.abs(f5) > 50.0 || (double)Math.abs(f6) > 50.0) {
            return;
        }
        Entity entity = ((CraftEntity)anb2.up()).getHandle();
        Location location = anc.b(anb2.uo(), f, f2);
        entity.a_(location.getX(), location.getY(), location.getZ());
        entity.r(f);
        entity.s(f2);
        Vec3D vec3D = new Vec3D(anb2.uo().getX(), anb2.uo().getY(), anb2.uo().getZ());
        double d = vec3D.c - entity.du();
        double d2 = vec3D.e - entity.dA();
        double d3 = vec3D.d - (entity.dw() + (double)entity.cL());
        float f7 = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f8 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.c.b((Packet)new PacketPlayOutEntityTeleport(entity));
        entityPlayer.c.b((Packet)new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.al(), anc.x(f7), anc.x(f8), false));
        entityPlayer.c.b((Packet)new PacketPlayOutEntityHeadRotation(entity, anc.x(f7)));
    }
}
