package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aov;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.la;
import itemsadder.m.zw;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class lc
extends PacketAdapter {
    lc(Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        if (zw.UQ && !ap.x(player)) {
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        aov aov2 = aow.uN().e(packetContainer);
        la.zQ.put(player, aov2);
    }
}
