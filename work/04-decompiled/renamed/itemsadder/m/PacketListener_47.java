package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.PlayerJoinListener_4;
import itemsadder.m.VersionHelper_3;
import net.md_5.bungee.api.chat.BaseComponent;

class PacketListener_47
extends PacketAdapter {
    final /* synthetic */ PlayerJoinListener_4 xb;

    PacketListener_47(PlayerJoinListener_4 playerJoinListener_4, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.xb = playerJoinListener_4;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        if (packetContainer.getChatTypes().read(0) != EnumWrappers.ChatType.GAME_INFO) {
            return;
        }
        BaseComponent[] baseComponentArray = (BaseComponent[])packetEvent.getPacket().getModifier().read(VersionHelper_3.UO ? 2 : 1);
        if (baseComponentArray == null) {
            return;
        }
        if (!this.xb.a(baseComponentArray[0])) {
            this.xb.an(packetEvent.getPlayer());
        }
    }
}
