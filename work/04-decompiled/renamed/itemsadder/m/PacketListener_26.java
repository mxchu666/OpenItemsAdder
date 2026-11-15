package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BlockNms_1_21_5_18;
import java.util.Iterator;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.CraftingManager;
import org.bukkit.plugin.Plugin;

class PacketListener_26
extends PacketAdapter {
    PacketListener_26(BlockNms_1_21_5_18 blockNms_1_21_5_18, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        ClientboundRecipeBookAddPacket clientboundRecipeBookAddPacket = (ClientboundRecipeBookAddPacket)packetEvent.getPacket().getHandle();
        Iterator iterator = clientboundRecipeBookAddPacket.b().iterator();
        while (iterator.hasNext()) {
            ClientboundRecipeBookAddPacket.a a2 = (ClientboundRecipeBookAddPacket.a)iterator.next();
            CraftingManager.d d2 = MinecraftServer.getServer().aI().a(a2.c().a());
            if (!BlockNms_1_21_5_18.a(d2.b())) continue;
            iterator.remove();
        }
    }
}
