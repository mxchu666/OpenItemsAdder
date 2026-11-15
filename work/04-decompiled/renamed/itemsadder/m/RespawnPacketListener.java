package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.LivingEntityRegistry;
import org.bukkit.plugin.Plugin;

class RespawnPacketListener
extends PacketAdapter {
    public RespawnPacketListener() {
        super(new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).listenerPriority(ListenerPriority.HIGHEST).types(new PacketType[]{PacketType.Play.Server.RESPAWN}));
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled()) {
            return;
        }
        LivingEntityRegistry.db().X(packetEvent.getPlayer());
    }
}
