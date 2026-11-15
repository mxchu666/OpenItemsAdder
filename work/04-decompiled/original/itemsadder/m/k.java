package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.afz;
import itemsadder.m.j;
import itemsadder.m.jx;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class k
extends PacketAdapter {
    final /* synthetic */ j bD;

    k(j j2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.bD = j2;
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
            object = (jx)this.bD.bC.get(player);
            if (object != null && ((jx)object).kT()) {
                afz.tK().a((Entity)armorStand, player.getLocation().getYaw());
            }
        }
    }
}
