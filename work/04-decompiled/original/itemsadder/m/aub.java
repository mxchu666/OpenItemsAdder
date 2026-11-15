package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aua;
import java.util.Iterator;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.RecipeManager;
import org.bukkit.plugin.Plugin;

class aub
extends PacketAdapter {
    aub(aua aua2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        ClientboundRecipeBookAddPacket clientboundRecipeBookAddPacket = (ClientboundRecipeBookAddPacket)packetEvent.getPacket().getHandle();
        Iterator iterator = clientboundRecipeBookAddPacket.entries().iterator();
        while (iterator.hasNext()) {
            ClientboundRecipeBookAddPacket.Entry entry = (ClientboundRecipeBookAddPacket.Entry)iterator.next();
            RecipeManager.ServerDisplayInfo serverDisplayInfo = MinecraftServer.getServer().getRecipeManager().getRecipeFromDisplay(entry.contents().id());
            if (!aua.a(serverDisplayInfo.parent())) continue;
            iterator.remove();
        }
    }
}
