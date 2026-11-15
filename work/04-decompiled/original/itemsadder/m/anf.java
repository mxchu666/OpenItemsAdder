package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.anb;
import itemsadder.m.ane;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayInFlying;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

class anf
extends PacketAdapter {
    final /* synthetic */ ane ajt;

    anf(ane ane2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ajt = ane2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        anb anb2 = (anb)ane.a(this.ajt).get((Object)player);
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
        float f5 = ane.y(f - f3);
        float f6 = ane.z(f2 - f4);
        anb2.v(f);
        anb2.w(f2);
        if (f5 == 0.0f && f6 == 0.0f) {
            return;
        }
        if ((double)Math.abs(f5) > 50.0 || (double)Math.abs(f6) > 50.0) {
            return;
        }
        Entity entity = ((CraftEntity)anb2.up()).getHandle();
        Location location = ane.b(anb2.uo(), f, f2);
        entity.a_(location.getX(), location.getY(), location.getZ());
        entity.t(f);
        entity.u(f2);
        Vec3D vec3D = new Vec3D(anb2.uo().getX(), anb2.uo().getY(), anb2.uo().getZ());
        double d = vec3D.c - entity.dt();
        double d2 = vec3D.e - entity.dz();
        double d3 = vec3D.d - (entity.dv() + (double)entity.cL());
        float f7 = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f8 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.c.b((Packet)new PacketPlayOutEntityTeleport(entity));
        entityPlayer.c.b((Packet)new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.an(), ane.x(f7), ane.x(f8), false));
        entityPlayer.c.b((Packet)new PacketPlayOutEntityHeadRotation(entity, ane.x(f7)));
    }
}
