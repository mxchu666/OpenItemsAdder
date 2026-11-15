package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aad;
import itemsadder.m.afz;

class aae
extends PacketAdapter {
    aae(aad aad2, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        if (aad.Vi.contains(packetEvent.getPacket().getIntegers().read(0)) && packetEvent.getPacket().getType() == PacketType.Play.Server.ENTITY_METADATA) {
            afz.tK().a(packetEvent, true);
        }
    }
}
