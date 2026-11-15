package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.co;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class cq
extends PacketAdapter {
    final /* synthetic */ co kU;

    cq(co co2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kU = co2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (!this.kU.cU()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        int n = (Integer)packetEvent.getPacket().getIntegers().read(0);
        int n2 = (Integer)packetEvent.getPacket().getIntegers().read(1);
        bcp.c(() -> {
            if (!this.kU.cU() || !player.isOnline()) {
                return;
            }
            if (!bcc.h(player.getWorld(), n, n2)) {
                return;
            }
            Chunk chunk = player.getWorld().getChunkAt(n, n2);
            this.kU.kO.a(player, chunk);
        }, 5L);
    }
}
