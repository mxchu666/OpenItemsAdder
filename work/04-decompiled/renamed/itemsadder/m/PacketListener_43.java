package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.PlayerInteractListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PacketListener_43
extends PacketAdapter {
    final /* synthetic */ PlayerInteractListener kW;

    PacketListener_43(PlayerInteractListener playerInteractListener, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kW = playerInteractListener;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (!this.kW.cU() || packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        BukkitTaskBridge.c(() -> {
            if (this.kW.cU() && player.isOnline()) {
                this.kW.kQ.H(player);
            }
        }, 1L);
    }
}
