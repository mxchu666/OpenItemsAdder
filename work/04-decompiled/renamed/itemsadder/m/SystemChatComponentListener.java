package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PlayerJoinListener_10;
import itemsadder.m.PluginBridge_6;
import net.kyori.adventure.text.Component;

class SystemChatComponentListener
extends PacketAdapter {
    final /* synthetic */ PlayerJoinListener_10 Sn;

    SystemChatComponentListener(PlayerJoinListener_10 playerJoinListener_10, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Sn = playerJoinListener_10;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        Object object;
        PacketContainer packetContainer = packetEvent.getPacket();
        if (PacketContainerHolder.b(packetContainer)) {
            return;
        }
        int n = -1;
        if (MaterialBarColorHolder.eD && (object = (PacketContainer)this.Sn.gf.getIfPresent(n = PacketContainerHolder.c(packetContainer).intValue())) != null) {
            PacketContainerHolder.a((PacketContainer)object, packetContainer);
            return;
        }
        object = packetContainer.getModifier().read(0);
        String string = PluginBridge_6.g(object);
        if (!(MaterialBarColorHolder.eE && PermissibleBridge_2.dk(string) || MaterialBarColorHolder.fr && PermissibleBridge_4.dk(string))) {
            return;
        }
        Component component = PluginBridge_6.F(object);
        if (component == null) {
            CommandSenderBridge_5.iA("System chat component is null, ignoring.");
            return;
        }
        Opaque020 opaque020 = Opaque020.G(false);
        if (MaterialBarColorHolder.eE) {
            component = PermissibleBridge_2.a(null, component, MaterialBarColorHolder.eF, PlayerJoinListener_10.Sf, opaque020);
        }
        if (MaterialBarColorHolder.eN) {
            component = PermissibleBridge_4.a(component, opaque020);
        }
        if (!((Boolean)opaque020.aAW).booleanValue()) {
            return;
        }
        packetContainer.getModifier().write(0, PluginBridge_6.r(component));
        if (MaterialBarColorHolder.eD) {
            this.Sn.gf.put(n, packetContainer);
        }
    }
}
