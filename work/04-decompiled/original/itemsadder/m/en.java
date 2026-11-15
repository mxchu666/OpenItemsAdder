package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.em;
import org.bukkit.plugin.Plugin;

class en
extends PacketAdapter {
    final /* synthetic */ em rh;

    en(em em2, Plugin plugin, PacketType ... packetTypeArray) {
        this.rh = em2;
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        this.rh.rg.gP();
    }

    public void onPacketSending(PacketEvent packetEvent) {
    }
}
