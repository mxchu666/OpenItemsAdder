package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.PlayerHolder_6;
import org.bukkit.plugin.Plugin;

class PacketListener_45
extends PacketAdapter {
    final /* synthetic */ PlayerHolder_6 rh;

    PacketListener_45(PlayerHolder_6 playerHolder_6, Plugin plugin, PacketType ... packetTypeArray) {
        this.rh = playerHolder_6;
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        this.rh.rg.gP();
    }

    public void onPacketSending(PacketEvent packetEvent) {
    }
}
