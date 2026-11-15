package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.anb;
import itemsadder.m.any;
import java.util.Set;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

class anz
extends PacketAdapter {
    final /* synthetic */ any ajD;

    anz(any any2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ajD = any2;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        anb anb2 = (anb)any.a(this.ajD).get((Object)player);
        if (anb2 == null) {
            return;
        }
        packetEvent.setCancelled(true);
        Object object = packetEvent.getPacket().getHandle();
        if (!(object instanceof ServerboundMovePlayerPacket.Rot)) {
            return;
        }
        ServerboundMovePlayerPacket.Rot rot = (ServerboundMovePlayerPacket.Rot)object;
        float f = rot.yRot;
        float f2 = rot.xRot;
        float f3 = anb2.t(f);
        float f4 = anb2.u(f2);
        float f5 = any.y(f - f3);
        float f6 = any.z(f2 - f4);
        anb2.v(f);
        anb2.w(f2);
        if (f5 == 0.0f && f6 == 0.0f) {
            return;
        }
        if ((double)Math.abs(f5) > 50.0 || (double)Math.abs(f6) > 50.0) {
            return;
        }
        Entity entity = ((CraftEntity)anb2.up()).getHandle();
        Location location = any.b(anb2.uo(), f, f2);
        entity.setPos(location.getX(), location.getY(), location.getZ());
        entity.setYRot(f);
        entity.setXRot(f2);
        Vec3 vec3 = new Vec3(anb2.uo().getX(), anb2.uo().getY(), anb2.uo().getZ());
        double d = vec3.x - entity.getX();
        double d2 = vec3.z - entity.getZ();
        double d3 = vec3.y - (entity.getY() + (double)entity.getEyeHeight());
        float f7 = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f8 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundTeleportEntityPacket(entity.getId(), new PositionMoveRotation(new Vec3(location.getX(), location.getY(), location.getZ()), Vec3.ZERO, f7, f8), Set.of(), false));
        serverPlayer.connection.send((Packet)new ClientboundMoveEntityPacket.Rot(entity.getId(), Mth.packDegrees((float)f7), Mth.packDegrees((float)f8), false));
        serverPlayer.connection.send((Packet)new ClientboundRotateHeadPacket(entity, Mth.packDegrees((float)f7)));
    }
}
