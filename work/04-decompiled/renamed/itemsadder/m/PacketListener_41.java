package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PlayerInteractListener;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PacketListener_41
extends PacketAdapter {
    final /* synthetic */ PlayerInteractListener kU;

    PacketListener_41(PlayerInteractListener playerInteractListener, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kU = playerInteractListener;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (!this.kU.cU()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        int n = (Integer)packetEvent.getPacket().getIntegers().read(0);
        int n2 = (Integer)packetEvent.getPacket().getIntegers().read(1);
        BukkitTaskBridge.c(() -> {
            if (!this.kU.cU() || !player.isOnline()) {
                return;
            }
            if (!LocationBridge_2.h(player.getWorld(), n, n2)) {
                return;
            }
            Chunk chunk = player.getWorld().getChunkAt(n, n2);
            this.kU.kO.a(player, chunk);
        }, 5L);
    }
}
