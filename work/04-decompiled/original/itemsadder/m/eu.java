package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.da;
import org.bukkit.plugin.Plugin;

class eu
extends PacketAdapter {
    public eu() {
        super(new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).listenerPriority(ListenerPriority.HIGHEST).types(new PacketType[]{PacketType.Play.Server.RESPAWN}));
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled()) {
            return;
        }
        da.db().X(packetEvent.getPlayer());
    }
}
