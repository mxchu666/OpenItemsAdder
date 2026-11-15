package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BlockNms_1_21_11_17;
import itemsadder.m.PlayerLocationHolder;
import java.util.Set;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayInFlying;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftPlayer;
import org.bukkit.entity.Player;

class PacketListener_6
extends PacketAdapter {
    final /* synthetic */ BlockNms_1_21_11_17 ajv;

    PacketListener_6(BlockNms_1_21_11_17 blockNms_1_21_11_17, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.ajv = blockNms_1_21_11_17;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        PlayerLocationHolder playerLocationHolder = (PlayerLocationHolder)BlockNms_1_21_11_17.a(this.ajv).get((Object)player);
        if (playerLocationHolder == null) {
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
        float f3 = playerLocationHolder.t(f);
        float f4 = playerLocationHolder.u(f2);
        float f5 = BlockNms_1_21_11_17.y(f - f3);
        float f6 = BlockNms_1_21_11_17.z(f2 - f4);
        playerLocationHolder.v(f);
        playerLocationHolder.w(f2);
        if (f5 == 0.0f && f6 == 0.0f) {
            return;
        }
        if ((double)Math.abs(f5) > 50.0 || (double)Math.abs(f6) > 50.0) {
            return;
        }
        Entity entity = ((CraftEntity)playerLocationHolder.up()).getHandle();
        Location location = BlockNms_1_21_11_17.b(playerLocationHolder.uo(), f, f2);
        entity.a_(location.getX(), location.getY(), location.getZ());
        entity.v(f);
        entity.w(f2);
        Vec3D vec3D = new Vec3D(playerLocationHolder.uo().getX(), playerLocationHolder.uo().getY(), playerLocationHolder.uo().getZ());
        double d = vec3D.g - entity.dP();
        double d2 = vec3D.i - entity.dV();
        double d3 = vec3D.h - (entity.dR() + (double)entity.dk());
        float f7 = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f8 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new PacketPlayOutEntityTeleport(entity.aA(), new PositionMoveRotation(new Vec3D(location.getX(), location.getY(), location.getZ()), Vec3D.c, f7, f8), Set.of(), false));
        entityPlayer.g.b((Packet)new PacketPlayOutEntity.PacketPlayOutEntityLook(entity.aA(), MathHelper.e((float)f7), MathHelper.e((float)f8), false));
        entityPlayer.g.b((Packet)new PacketPlayOutEntityHeadRotation(entity, MathHelper.e((float)f7)));
    }
}
