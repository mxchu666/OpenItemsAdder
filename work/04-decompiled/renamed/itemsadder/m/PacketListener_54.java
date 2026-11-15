package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemDisplayTridentHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.ProjectileLaunchListener;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;

class PacketListener_54
extends PacketAdapter {
    final /* synthetic */ ProjectileLaunchListener EW;

    PacketListener_54(ProjectileLaunchListener projectileLaunchListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.EW = projectileLaunchListener;
        super(adapterParameteters);
    }

    public void onPacketSending(PacketEvent packetEvent) {
        try {
            PacketContainer packetContainer = packetEvent.getPacket();
            Player player = packetEvent.getPlayer();
            if (!PlayerJoinListener_2.y(player)) {
                return;
            }
            List list = (List)packetContainer.getIntLists().read(0);
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ItemDisplayTridentHolder itemDisplayTridentHolder;
                int n = (Integer)iterator.next();
                Trident trident = (Trident)this.EW.ET.get(n);
                if (trident == null || (itemDisplayTridentHolder = (ItemDisplayTridentHolder)this.EW.ES.get(trident)) == null) continue;
                BukkitTaskBridge.b(() -> PacketListenerRegistry.uN().i((Entity)itemDisplayTridentHolder.EZ, player), 5L);
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.warn("Failed to handle ENTITY_DESTROY packet for Trident: " + exception.getMessage());
        }
    }
}
