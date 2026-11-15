package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.afz;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.la;
import itemsadder.m.ld;
import itemsadder.m.lf;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

class lb
extends PacketAdapter {
    lb(Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Object object;
        NItem nItem;
        boolean bl;
        Player player = packetEvent.getPlayer();
        if (player.getVehicle() == null) {
            return;
        }
        if (player.getVehicle().getType() != EntityType.SLIME && !(player.getVehicle() instanceof ArmorStand)) {
            return;
        }
        if (!la.zO.containsKey(player)) {
            return;
        }
        packetEvent.setCancelled(true);
        if (!d.g().v) {
            bcp.i(() -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 5));
                player.leaveVehicle();
            });
            player.removeMetadata("onIAVehicle", (Plugin)Main.rS());
            return;
        }
        lf lf2 = (lf)la.zO.get(player);
        PacketContainer packetContainer = packetEvent.getPacket();
        boolean bl2 = (Boolean)packetContainer.getBooleans().read(0);
        boolean bl3 = (Boolean)packetContainer.getBooleans().read(1);
        boolean bl4 = ((Float)packetContainer.getFloat().read(1)).floatValue() > 0.0f;
        boolean bl5 = bl = ((Float)packetContainer.getFloat().read(1)).floatValue() < 0.0f;
        if (lf2 == null || lf2.zY == null) {
            bcp.i(() -> {
                player.leaveVehicle();
                player.removeMetadata("onIAVehicle", (Plugin)Main.rS());
            });
            return;
        }
        ArmorStand armorStand = lf2.zY;
        Location location = armorStand.getLocation().subtract(0.0, 1.0, 0.0);
        if (bl3) {
            if (location.getBlock().getType().isSolid() || location.getBlock().getType() == Material.WATER || location.getBlock().getType() == Material.LAVA) {
                la.aB(player);
                return;
            }
            if (lf2.zW.fu() > 0.0f) {
                nItem = player.getLocation().getDirection();
                nItem = nItem.multiply(lf2.zW.fu());
                nItem.setY(-1);
                armorStand.setVelocity((Vector)nItem);
            }
        }
        nItem = lf2.zZ;
        if (lf2.zW.le() != -1 && nItem.getInt("Fuel") <= 0) {
            return;
        }
        lf2.Ab = armorStand.getLocation().getYaw();
        afz.a((Entity)armorStand, player.getLocation().getYaw());
        if (armorStand.getPassenger() != null && armorStand.getPassenger().getType() == EntityType.SLIME) {
            afz.a(armorStand.getPassenger(), armorStand.getLocation().getYaw());
        }
        if ((bl4 || bl || bl2) && lf2.zW.le() != -1 && System.currentTimeMillis() - lf2.Aa >= 1000L) {
            lf2.Aa = System.currentTimeMillis();
            nItem.setInt("Fuel", nItem.getInt("Fuel") - 1);
            object = la.aA(player);
            ((ld)object).gF();
            ((ld)object).bf(Main.PQ.ir("fuel-indicator").replace("{value}", "" + nItem.getInt("Fuel")).replace("{max}", "" + lf2.zW.le()));
            nItem.save();
            armorStand.setHelmet(nItem.getItem());
        }
        if (bl4) {
            boolean bl6 = armorStand.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType().isSolid();
            double d2 = lf2.zW.lb();
            if (lf2.zW.fu() > 0.0f && !bl6) {
                d2 = lf2.zW.fu();
            }
            Vector vector = armorStand.getLocation().getDirection();
            if (lf2.zW.fu() > 0.0f) {
                vector.setY(0.078);
            } else {
                vector.setY(-1);
            }
            vector = vector.multiply(d2);
            armorStand.setVelocity(vector);
            if (lf2.zW.fu() > 0.0f && !bl6) {
                return;
            }
        } else if (bl) {
            object = armorStand.getLocation().getDirection();
            object = object.multiply(-lf2.zW.lb() / 2.0f);
            object.setY(armorStand.getVelocity().getY());
            armorStand.setVelocity((Vector)object);
        } else if (lf2.zW.kY() > 0) {
            lf2.z(armorStand.getLocation());
        }
        if (bl2) {
            if (location.getBlock().getType().isSolid() && !armorStand.getLocation().subtract(0.0, 0.0, 0.0).getBlock().getType().isSolid()) {
                if (lf2.zW.lc() > 0.0f) {
                    Vector vector = armorStand.getVelocity();
                    vector.setY(1);
                    vector = vector.multiply(lf2.zW.lc());
                    armorStand.setVelocity(vector);
                }
            } else if (lf2.zW.fu() > 0.0f) {
                Vector vector = player.getLocation().getDirection();
                vector.setY(1);
                vector = vector.multiply(lf2.zW.fu());
                armorStand.setVelocity(vector);
            }
        }
    }
}
