package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityRegistry;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class SteerVehiclePacketListener
extends PacketAdapter {
    public SteerVehiclePacketListener() {
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
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = LivingEntityRegistry.db().c((LivingEntity)player);
        if (livingEntityArmorStandHolder != null) {
            PacketContainer packetContainer = packetEvent.getPacket();
            LivingEntity livingEntity = livingEntityArmorStandHolder.oy;
            boolean bl = livingEntityArmorStandHolder.gH().eK();
            boolean bl2 = (Boolean)packetContainer.getBooleans().read(1);
            if (livingEntityArmorStandHolder.canControl()) {
                Vector vector = livingEntity.getVelocity();
                float f = ((Float)packetContainer.getFloat().read(0)).floatValue();
                float f2 = ((Float)packetContainer.getFloat().read(1)).floatValue();
                boolean bl3 = (Boolean)packetContainer.getBooleans().read(0);
                if (bl3 && livingEntity.isOnGround()) {
                    vector.add(new Vector(0.0, 0.5, 0.0));
                } else if (bl3 && livingEntityArmorStandHolder.gH().eK()) {
                    vector.add(new Vector(0.0, 0.1, 0.0));
                }
                if (bl2) {
                    if (!bl || livingEntity.isOnGround() || !livingEntity.hasAI() || !livingEntity.hasGravity()) {
                        if (!livingEntityArmorStandHolder.isLocked()) {
                            LivingEntityRegistry.db().removePassenger((LivingEntity)player);
                        }
                    } else {
                        vector.add(new Vector(0.0, -0.05, 0.0));
                    }
                }
                EntityTypeBarStyleHolder entityTypeBarStyleHolder = livingEntityArmorStandHolder.gH().my;
                Vector vector2 = SteerVehiclePacketListener.a(vector, player, f, f2, livingEntity.isOnGround() ? entityTypeBarStyleHolder.ft() : (double)entityTypeBarStyleHolder.fu());
                livingEntity.setVelocity(vector2);
                livingEntity.setRotation(player.getEyeLocation().getYaw(), livingEntity.getEyeLocation().getPitch());
            } else if (bl2 && !livingEntityArmorStandHolder.isLocked()) {
                LivingEntityRegistry.db().removePassenger((LivingEntity)player);
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
