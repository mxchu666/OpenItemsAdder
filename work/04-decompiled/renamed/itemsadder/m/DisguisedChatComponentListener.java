package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque020;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PlayerJoinListener_10;
import itemsadder.m.PluginBridge_6;
import java.util.Objects;
import net.kyori.adventure.text.Component;

class DisguisedChatComponentListener
extends PacketAdapter {
    final /* synthetic */ PlayerJoinListener_10 Sm;

    DisguisedChatComponentListener(PlayerJoinListener_10 playerJoinListener_10, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Sm = playerJoinListener_10;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        String string;
        Object object;
        PacketContainer packetContainer = packetEvent.getPacket();
        int n = -1;
        if (MaterialBarColorHolder.eD) {
            object = packetEvent.getPacket().getModifier();
            n = Objects.hash(object.read(0) == null ? null : Integer.valueOf(object.read(0).hashCode()));
            string = (PacketContainer)this.Sm.gf.getIfPresent(n);
            if (string != null) {
                StructureModifier structureModifier = string.getModifier();
                object.write(0, structureModifier.read(0));
                return;
            }
        }
        object = packetContainer.getModifier().read(0);
        string = PluginBridge_6.g(object);
        CommandSenderBridge_5.iA(string);
        if (MaterialBarColorHolder.eE && !PermissibleBridge_2.dk(string) && MaterialBarColorHolder.eN && !PermissibleBridge_4.dk(string)) {
            return;
        }
        Component component = PluginBridge_6.F(object);
        if (component == null) {
            CommandSenderBridge_5.iA("Disguised chat component is null, ignoring.");
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
            this.Sm.gf.put(n, packetContainer);
        }
    }
}
