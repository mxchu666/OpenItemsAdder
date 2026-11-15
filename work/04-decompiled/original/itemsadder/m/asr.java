package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.asq;
import java.util.Iterator;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.CraftingManager;
import org.bukkit.plugin.Plugin;

class asr
extends PacketAdapter {
    asr(asq asq2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        ClientboundRecipeBookAddPacket clientboundRecipeBookAddPacket = (ClientboundRecipeBookAddPacket)packetEvent.getPacket().getHandle();
        Iterator iterator = clientboundRecipeBookAddPacket.b().iterator();
        while (iterator.hasNext()) {
            ClientboundRecipeBookAddPacket.a a2 = (ClientboundRecipeBookAddPacket.a)iterator.next();
            CraftingManager.d d2 = MinecraftServer.getServer().aN().a(a2.c().a());
            if (!asq.a(d2.b())) continue;
            iterator.remove();
        }
    }
}
