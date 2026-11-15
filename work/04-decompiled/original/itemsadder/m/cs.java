package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.bcp;
import itemsadder.m.co;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class cs
extends PacketAdapter {
    final /* synthetic */ co kW;

    cs(co co2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kW = co2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (!this.kW.cU() || packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        bcp.c(() -> {
            if (this.kW.cU() && player.isOnline()) {
                this.kW.kQ.H(player);
            }
        }, 1L);
    }
}
