package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import itemsadder.m.PacketAdapterHelper;
import itemsadder.m.PlayerBridge_32;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class PacketListener_57
extends PacketAdapter {
    final /* synthetic */ PacketAdapterHelper Uu;

    PacketListener_57(PacketAdapterHelper packetAdapterHelper, Plugin plugin, PacketType ... packetTypeArray) {
        this.Uu = packetAdapterHelper;
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        Player player = packetEvent.getPlayer();
        String[] stringArray = (String[])packetContainer.getStringArrays().read(0);
        PlayerBridge_32 playerBridge_32 = (PlayerBridge_32)this.Uu.Ur.remove(player);
        BlockPosition blockPosition = (BlockPosition)this.Uu.Us.remove(player);
        if (playerBridge_32 == null || blockPosition == null) {
            return;
        }
        packetEvent.setCancelled(true);
        boolean bl = playerBridge_32.Ux.test(player, stringArray);
        if (!bl && playerBridge_32.Uy) {
            Bukkit.getScheduler().runTaskLater(this.plugin, playerBridge_32::sT, 2L);
        }
        player.sendBlockChange(blockPosition.toLocation(player.getWorld()), Material.AIR.createBlockData());
    }
}
