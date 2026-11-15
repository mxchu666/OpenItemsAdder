package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.da;
import itemsadder.m.dp;
import itemsadder.m.ek;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class et
extends PacketAdapter {
    public et() {
        super(new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).listenerPriority(ListenerPriority.MONITOR).types(new PacketType[]{PacketType.Play.Client.STEER_VEHICLE}));
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (packetEvent.isCancelled()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        if (player.getVehicle() != null && !(player.getVehicle() instanceof ArmorStand)) {
            return;
        }
        ek ek2 = da.db().c((LivingEntity)player);
        if (ek2 != null) {
            PacketContainer packetContainer = packetEvent.getPacket();
            LivingEntity livingEntity = ek2.oy;
            boolean bl = ek2.gH().eK();
            boolean bl2 = (Boolean)packetContainer.getBooleans().read(1);
            if (ek2.canControl()) {
                Vector vector = livingEntity.getVelocity();
                float f = ((Float)packetContainer.getFloat().read(0)).floatValue();
                float f2 = ((Float)packetContainer.getFloat().read(1)).floatValue();
                boolean bl3 = (Boolean)packetContainer.getBooleans().read(0);
                if (bl3 && livingEntity.isOnGround()) {
                    vector.add(new Vector(0.0, 0.5, 0.0));
                } else if (bl3 && ek2.gH().eK()) {
                    vector.add(new Vector(0.0, 0.1, 0.0));
                }
                if (bl2) {
                    if (!bl || livingEntity.isOnGround() || !livingEntity.hasAI() || !livingEntity.hasGravity()) {
                        if (!ek2.isLocked()) {
                            da.db().removePassenger((LivingEntity)player);
                        }
                    } else {
                        vector.add(new Vector(0.0, -0.05, 0.0));
                    }
                }
                dp dp2 = ek2.gH().my;
                Vector vector2 = et.a(vector, player, f, f2, livingEntity.isOnGround() ? dp2.ft() : (double)dp2.fu());
                livingEntity.setVelocity(vector2);
                livingEntity.setRotation(player.getEyeLocation().getYaw(), livingEntity.getEyeLocation().getPitch());
            } else if (bl2 && !ek2.isLocked()) {
                da.db().removePassenger((LivingEntity)player);
            }
        }
    }

    public static Vector a(Vector vector, Player player, float f, float f2, double d) {
        vector.setX(0.0);
        vector.setZ(0.0);
        Vector vector2 = new Vector(f, 0.0f, f2);
        if (vector2.length() > 0.0) {
            double d2 = Math.toRadians(player.getLocation().getYaw());
            double d3 = Math.cos(d2);
            double d4 = Math.sin(d2);
            double d5 = vector2.getX() * d3 - vector2.getZ() * d4;
            double d6 = vector2.getX() * d4 + vector2.getZ() * d3;
            vector2.setX(d5);
            vector2.setZ(d6);
            vector2.normalize().multiply(d);
        }
        return vector2.add(vector);
    }
}
