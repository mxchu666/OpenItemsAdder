package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PlayerBridge_33;
import itemsadder.m.PlayerJoinListener_10;
import itemsadder.m.PluginBridge_6;
import net.kyori.adventure.text.Component;

class DisguisedChatComponentListener_2
extends PacketAdapter {
    DisguisedChatComponentListener_2(PlayerJoinListener_10 playerJoinListener_10, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        Object object = PlayerBridge_33.bA(packetEvent.getPlayer());
        if (object != null) {
            packetEvent.getPacket().getModifier().write(2, object);
            PlayerBridge_33.bB(packetEvent.getPlayer());
            return;
        }
        if (MaterialBarColorHolder.da) {
            Component component = PluginBridge_6.F(packetEvent.getPacket().getModifier().read(2));
            if (component == null) {
                CommandSenderBridge_5.iA("Disguised chat component is null, ignoring.");
                return;
            }
            Opaque020 opaque020 = Opaque020.G(false);
            component = PermissibleBridge_2.a(component, opaque020);
            if (MaterialBarColorHolder.fr) {
                component = PermissibleBridge_4.a(component, opaque020);
            }
            if (!((Boolean)opaque020.aAW).booleanValue()) {
                return;
            }
            packetEvent.getPacket().getModifier().write(2, PluginBridge_6.r(component));
        }
    }
}
