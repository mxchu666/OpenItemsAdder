package dev.lone.itemsadder.resourcepack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ResourcePackSendEvent;
import dev.lone.itemsadder.resourcepack.aa;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.ax;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginBridge_2;
import itemsadder.m.PluginBridge_6;
import java.util.Optional;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

class ab
extends PacketAdapter {
    final /* synthetic */ av arZ;

    ab(aa aa2, Plugin plugin, ListenerPriority listenerPriority, PacketType[] packetTypeArray,  /* corrupt varargs signature?! */ avav av2) {
        this.arZ = av2;
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        if (this.arZ.aui instanceof PluginBridge_2) {
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        PacketType packetType = packetEvent.getPacketType();
        Player player = packetEvent.getPlayer();
        UUID uUID = (UUID)packetContainer.getUUIDs().read(0);
        String string = (String)packetContainer.getStrings().read(0);
        String string2 = (String)packetContainer.getStrings().read(1);
        if (MaterialBarColorHolder.fA) {
            CommandSenderBridge_5.log("Installing resourcepack: " + player.getName() + " | " + string + " | " + String.valueOf(uUID) + " | " + string2);
        }
        if (string.equals(this.arZ.aui.Ca())) {
            this.arZ.a(player, ax.SERVER_SENT);
            if (packetType.getProtocol() == PacketType.Protocol.CONFIGURATION) {
                packetContainer.getBooleans().write(0, (Object)(MaterialBarColorHolder.de && (packetEvent.isPlayerTemporary() || !player.hasPermission("ia.resourcepack.bypasskick")) ? 1 : 0));
                Component component = PluginBridge_6.gF(Main.PQ.c("resourcepack-popup-message", player));
                packetContainer.getModifier().write(4, Optional.of(PluginBridge_6.r(component)));
            }
            if (packetEvent.isAsync()) {
                BukkitTaskBridge.i(() -> ListenerBridge.b((Event)new ResourcePackSendEvent(player, string, string2, true)));
            } else {
                ListenerBridge.b((Event)new ResourcePackSendEvent(player, string, string2, true));
            }
        } else {
            if (packetEvent.isAsync()) {
                BukkitTaskBridge.i(() -> ListenerBridge.b((Event)new ResourcePackSendEvent(player, string, string2, false)));
            } else {
                ListenerBridge.b((Event)new ResourcePackSendEvent(player, string, string2, false));
            }
            if (MaterialBarColorHolder.dc) {
                if (!MaterialBarColorHolder.eA) {
                    packetEvent.setCancelled(true);
                    if (MaterialBarColorHolder.df) {
                        CommandSenderBridge_5.warn("Another plugin sent a resourcepack. Cancelling it. URL: " + String.valueOf(ChatColor.GRAY) + string);
                    }
                } else if (MaterialBarColorHolder.df) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "Another plugin sent a resourcepack. URL: " + String.valueOf(ChatColor.GRAY) + string);
                }
            }
        }
    }
}
