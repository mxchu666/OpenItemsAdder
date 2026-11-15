package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.adb;
import itemsadder.m.il;
import itemsadder.m.jd;

class jf
extends PacketAdapter {
    final /* synthetic */ jd xc;

    jf(jd jd2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.xc = jd2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (packetEvent.getPacket().getType() == PacketType.Play.Server.SYSTEM_CHAT && !((Boolean)packetEvent.getPacket().getBooleans().read(0)).booleanValue()) {
            return;
        }
        if (!adb.tp().b(packetEvent.getPacket().getModifier().read(0), (String)il.wo.get(1))) {
            this.xc.an(packetEvent.getPlayer());
        }
    }
}
