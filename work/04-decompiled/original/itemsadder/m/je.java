package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.jd;
import itemsadder.m.zw;
import net.md_5.bungee.api.chat.BaseComponent;

class je
extends PacketAdapter {
    final /* synthetic */ jd xb;

    je(jd jd2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.xb = jd2;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        if (packetContainer.getChatTypes().read(0) != EnumWrappers.ChatType.GAME_INFO) {
            return;
        }
        BaseComponent[] baseComponentArray = (BaseComponent[])packetEvent.getPacket().getModifier().read(zw.UO ? 2 : 1);
        if (baseComponentArray == null) {
            return;
        }
        if (!this.xb.a(baseComponentArray[0])) {
            this.xb.an(packetEvent.getPlayer());
        }
    }
}
