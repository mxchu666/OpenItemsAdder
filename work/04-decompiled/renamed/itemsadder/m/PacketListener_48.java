package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.EntityHolder;
import itemsadder.m.Opaque125;
import itemsadder.m.PlayerJoinListener_3;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PacketListener_48
extends PacketAdapter {
    final /* synthetic */ PlayerJoinListener_3 bD;

    PacketListener_48(PlayerJoinListener_3 playerJoinListener_3, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.bD = playerJoinListener_3;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        if (!this.bD.d(player)) {
            return;
        }
        Object object = player.getVehicle();
        if (object instanceof ArmorStand) {
            ArmorStand armorStand = (ArmorStand)object;
            object = (Opaque125)this.bD.bC.get(player);
            if (object != null && ((Opaque125)object).kT()) {
                EntityHolder.tK().a((Entity)armorStand, player.getLocation().getYaw());
            }
        }
    }
}
