package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;
import itemsadder.m.co;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class cr
extends PacketAdapter {
    final /* synthetic */ co kV;

    cr(co co2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.kV = co2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (!this.kV.cU()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        int n = ((ChunkCoordIntPair)packetEvent.getPacket().getChunkCoordIntPairs().read(0)).getChunkX();
        int n2 = ((ChunkCoordIntPair)packetEvent.getPacket().getChunkCoordIntPairs().read(0)).getChunkZ();
        this.kV.kQ.a(player, n, n2, player.getWorld());
    }
}
