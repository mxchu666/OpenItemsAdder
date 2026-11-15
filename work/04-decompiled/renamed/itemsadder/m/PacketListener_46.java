package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.PlayerMoveListener;
import itemsadder.m.RecordOfUUID_3;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PacketListener_46
extends PacketAdapter {
    final /* synthetic */ PlayerMoveListener sk;

    PacketListener_46(PlayerMoveListener playerMoveListener, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        this.sk = playerMoveListener;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        int n = (Integer)packetEvent.getPacket().getIntegers().read(0);
        int n2 = (Integer)packetEvent.getPacket().getIntegers().read(1);
        this.sk.sd.add(new RecordOfUUID_3(player.getUniqueId(), player.getWorld().getUID(), n, n2, this.sk.sj));
    }
}
