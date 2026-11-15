package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PlayerJoinListener_10;
import itemsadder.m.PluginBridge_6;
import net.kyori.adventure.text.Component;

class PlayerChatComponentListener
extends PacketAdapter {
    PlayerChatComponentListener(PlayerJoinListener_10 playerJoinListener_10, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        Component component;
        PacketContainer packetContainer = packetEvent.getPacket();
        if (packetContainer.getChatTypes().read(0) == EnumWrappers.ChatType.GAME_INFO) {
            return;
        }
        StructureModifier structureModifier = packetContainer.getModifier();
        Object object = structureModifier.read(Version.isAtLeast((Version)Version.v1_21_5) ? 5 : 4);
        if (object == null) {
            Object object2 = packetContainer.getModifier().read(Version.isAtLeast((Version)Version.v1_21_5) ? 4 : 3);
            String string = PacketContainerHolder.tp().d(object2);
            if (!(MaterialBarColorHolder.eE && PermissibleBridge_2.dk(string) || MaterialBarColorHolder.fr && PermissibleBridge_4.dk(string))) {
                return;
            }
            component = PluginBridge_6.gF(string);
        } else {
            String string = PluginBridge_6.g(object);
            if (!(MaterialBarColorHolder.eE && PermissibleBridge_2.dk(string) || MaterialBarColorHolder.fr && PermissibleBridge_4.dk(string))) {
                return;
            }
            component = PluginBridge_6.F(object);
        }
        if (component == null) {
            CommandSenderBridge_5.error("Player chat component is null, this is a bug.");
            return;
        }
        if (MaterialBarColorHolder.eN) {
            component = PermissibleBridge_4.h(component);
        }
        if (MaterialBarColorHolder.eE) {
            component = PermissibleBridge_2.a(component, MaterialBarColorHolder.eF, PlayerJoinListener_10.Sf);
        }
        object = PluginBridge_6.r(component);
        packetContainer.getModifier().write(Version.isAtLeast((Version)Version.v1_21_5) ? 5 : 4, object);
    }
}
