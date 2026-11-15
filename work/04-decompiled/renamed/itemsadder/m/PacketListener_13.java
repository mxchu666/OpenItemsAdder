package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BlockNms_26_1_1_17;
import itemsadder.m.PlayerLocationHolder;
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

class PacketListener_13
extends PacketAdapter {
    final /* synthetic */ BlockNms_26_1_1_17 ajC;

    PacketListener_13(BlockNms_26_1_1_17 blockNms_26_1_1_17, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ajC = blockNms_26_1_1_17;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        PlayerLocationHolder playerLocationHolder = (PlayerLocationHolder)BlockNms_26_1_1_17.a(this.ajC).get((Object)player);
        if (playerLocationHolder == null) {
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
        float f3 = playerLocationHolder.t(f);
        float f4 = playerLocationHolder.u(f2);
        float f5 = BlockNms_26_1_1_17.y(f - f3);
        float f6 = BlockNms_26_1_1_17.z(f2 - f4);
        playerLocationHolder.v(f);
        playerLocationHolder.w(f2);
        if (f5 == 0.0f && f6 == 0.0f) {
            return;
        }
        if ((double)Math.abs(f5) > 50.0 || (double)Math.abs(f6) > 50.0) {
            return;
        }
        Entity entity = ((CraftEntity)playerLocationHolder.up()).getHandle();
        Location location = BlockNms_26_1_1_17.b(playerLocationHolder.uo(), f, f2);
        entity.setPos(location.getX(), location.getY(), location.getZ());
        entity.setYRot(f);
        entity.setXRot(f2);
        Vec3 vec3 = new Vec3(playerLocationHolder.uo().getX(), playerLocationHolder.uo().getY(), playerLocationHolder.uo().getZ());
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
