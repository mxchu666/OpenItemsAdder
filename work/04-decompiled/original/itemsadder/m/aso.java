package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.asf;
import itemsadder.m.asm;
import java.util.ArrayList;
import net.minecraft.network.protocol.game.PacketPlayOutRecipes;
import net.minecraft.resources.MinecraftKey;
import org.bukkit.plugin.Plugin;

class aso
extends PacketAdapter {
    aso(asm asm2, Plugin plugin, ListenerPriority listenerPriority, PacketType ... packetTypeArray) {
        super(plugin, listenerPriority, packetTypeArray);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        PacketPlayOutRecipes packetPlayOutRecipes = (PacketPlayOutRecipes)packetEvent.getPacket().getHandle();
        ArrayList<MinecraftKey> arrayList = new ArrayList<MinecraftKey>();
        ArrayList<MinecraftKey> arrayList2 = new ArrayList<MinecraftKey>();
        for (MinecraftKey minecraftKey : packetPlayOutRecipes.b()) {
            if (minecraftKey.b().startsWith(asf.ami)) continue;
            arrayList.add(minecraftKey);
        }
        for (MinecraftKey minecraftKey : packetPlayOutRecipes.e()) {
            if (minecraftKey.b().startsWith(asf.ami)) continue;
            arrayList2.add(minecraftKey);
        }
        packetEvent.getPacket().getModifier().write(1, arrayList);
        packetEvent.getPacket().getModifier().write(2, arrayList2);
    }
}
