package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityArmorStandHolder;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBossBarHolder;
import itemsadder.m.PluginDisableListener;
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

class OnIAVehicleListener
extends PacketAdapter {
    OnIAVehicleListener(Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
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
        if (!PluginDisableListener.zO.containsKey(player)) {
            return;
        }
        packetEvent.setCancelled(true);
        if (!ItemStackRegistry.g().v) {
            BukkitTaskBridge.i(() -> {
                player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 5));
                player.leaveVehicle();
            });
            player.removeMetadata("onIAVehicle", (Plugin)Main.rS());
            return;
        }
        EntityArmorStandHolder entityArmorStandHolder = (EntityArmorStandHolder)PluginDisableListener.zO.get(player);
        PacketContainer packetContainer = packetEvent.getPacket();
        boolean bl2 = (Boolean)packetContainer.getBooleans().read(0);
        boolean bl3 = (Boolean)packetContainer.getBooleans().read(1);
        boolean bl4 = ((Float)packetContainer.getFloat().read(1)).floatValue() > 0.0f;
        boolean bl5 = bl = ((Float)packetContainer.getFloat().read(1)).floatValue() < 0.0f;
        if (entityArmorStandHolder == null || entityArmorStandHolder.zY == null) {
            BukkitTaskBridge.i(() -> {
                player.leaveVehicle();
                player.removeMetadata("onIAVehicle", (Plugin)Main.rS());
            });
            return;
        }
        ArmorStand armorStand = entityArmorStandHolder.zY;
        Location location = armorStand.getLocation().subtract(0.0, 1.0, 0.0);
        if (bl3) {
            if (location.getBlock().getType().isSolid() || location.getBlock().getType() == Material.WATER || location.getBlock().getType() == Material.LAVA) {
                PluginDisableListener.aB(player);
                return;
            }
            if (entityArmorStandHolder.zW.fu() > 0.0f) {
                nItem = player.getLocation().getDirection();
                nItem = nItem.multiply(entityArmorStandHolder.zW.fu());
                nItem.setY(-1);
                armorStand.setVelocity((Vector)nItem);
            }
        }
        nItem = entityArmorStandHolder.zZ;
        if (entityArmorStandHolder.zW.le() != -1 && nItem.getInt("Fuel") <= 0) {
            return;
        }
        entityArmorStandHolder.Ab = armorStand.getLocation().getYaw();
        EntityHolder.a((Entity)armorStand, player.getLocation().getYaw());
        if (armorStand.getPassenger() != null && armorStand.getPassenger().getType() == EntityType.SLIME) {
            EntityHolder.a(armorStand.getPassenger(), armorStand.getLocation().getYaw());
        }
        if ((bl4 || bl || bl2) && entityArmorStandHolder.zW.le() != -1 && System.currentTimeMillis() - entityArmorStandHolder.Aa >= 1000L) {
            entityArmorStandHolder.Aa = System.currentTimeMillis();
            nItem.setInt("Fuel", nItem.getInt("Fuel") - 1);
            object = PluginDisableListener.aA(player);
            ((PlayerBossBarHolder)object).gF();
            ((PlayerBossBarHolder)object).bf(Main.PQ.ir("fuel-indicator").replace("{value}", "" + nItem.getInt("Fuel")).replace("{max}", "" + entityArmorStandHolder.zW.le()));
            nItem.save();
            armorStand.setHelmet(nItem.getItem());
        }
        if (bl4) {
            boolean bl6 = armorStand.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType().isSolid();
            double d = entityArmorStandHolder.zW.lb();
            if (entityArmorStandHolder.zW.fu() > 0.0f && !bl6) {
                d = entityArmorStandHolder.zW.fu();
            }
            Vector vector = armorStand.getLocation().getDirection();
            if (entityArmorStandHolder.zW.fu() > 0.0f) {
                vector.setY(0.078);
            } else {
                vector.setY(-1);
            }
            vector = vector.multiply(d);
            armorStand.setVelocity(vector);
            if (entityArmorStandHolder.zW.fu() > 0.0f && !bl6) {
                return;
            }
        } else if (bl) {
            object = armorStand.getLocation().getDirection();
            object = object.multiply(-entityArmorStandHolder.zW.lb() / 2.0f);
            object.setY(armorStand.getVelocity().getY());
            armorStand.setVelocity((Vector)object);
        } else if (entityArmorStandHolder.zW.kY() > 0) {
            entityArmorStandHolder.z(armorStand.getLocation());
        }
        if (bl2) {
            if (location.getBlock().getType().isSolid() && !armorStand.getLocation().subtract(0.0, 0.0, 0.0).getBlock().getType().isSolid()) {
                if (entityArmorStandHolder.zW.lc() > 0.0f) {
                    Vector vector = armorStand.getVelocity();
                    vector.setY(1);
                    vector = vector.multiply(entityArmorStandHolder.zW.lc());
                    armorStand.setVelocity(vector);
                }
            } else if (entityArmorStandHolder.zW.fu() > 0.0f) {
                Vector vector = player.getLocation().getDirection();
                vector.setY(1);
                vector = vector.multiply(entityArmorStandHolder.zW.fu());
                armorStand.setVelocity(vector);
            }
        }
    }
}
