package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.fc;
import itemsadder.m.fi;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class fd
extends PacketAdapter {
    final /* synthetic */ fc sk;

    fd(fc fc2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.sk = fc2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        int n = (Integer)packetEvent.getPacket().getIntegers().read(0);
        int n2 = (Integer)packetEvent.getPacket().getIntegers().read(1);
        this.sk.sd.add(new fi(player.getUniqueId(), player.getWorld().getUID(), n, n2, this.sk.sj));
    }
}
