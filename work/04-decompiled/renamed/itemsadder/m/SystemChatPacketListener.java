package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.Opaque123;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PlayerJoinListener_4;

class SystemChatPacketListener
extends PacketAdapter {
    final /* synthetic */ PlayerJoinListener_4 xc;

    SystemChatPacketListener(PlayerJoinListener_4 playerJoinListener_4, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.xc = playerJoinListener_4;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.getPacket().getType() == PacketType.Play.Server.SYSTEM_CHAT && !((Boolean)packetEvent.getPacket().getBooleans().read(0)).booleanValue()) {
            return;
        }
        if (!PacketContainerHolder.tp().b(packetEvent.getPacket().getModifier().read(0), (String)Opaque123.wo.get(1))) {
            this.xc.an(packetEvent.getPlayer());
        }
    }
}
