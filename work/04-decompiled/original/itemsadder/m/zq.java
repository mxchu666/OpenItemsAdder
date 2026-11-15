package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import itemsadder.m.zp;
import itemsadder.m.zr;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

class zq
extends PacketAdapter {
    final /* synthetic */ zp Uu;

    zq(zp zp2, Plugin plugin, PacketType ... packetTypeArray) {
        this.Uu = zp2;
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        PacketContainer packetContainer = packetEvent.getPacket();
        Player player = packetEvent.getPlayer();
        String[] stringArray = (String[])packetContainer.getStringArrays().read(0);
        zr zr2 = (zr)this.Uu.Ur.remove(player);
        BlockPosition blockPosition = (BlockPosition)this.Uu.Us.remove(player);
        if (zr2 == null || blockPosition == null) {
            return;
        }
        packetEvent.setCancelled(true);
        boolean bl = zr2.Ux.test(player, stringArray);
        if (!bl && zr2.Uy) {
            Bukkit.getScheduler().runTaskLater(this.plugin, zr2::sT, 2L);
        }
        player.sendBlockChange(blockPosition.toLocation(player.getWorld()), Material.AIR.createBlockData());
    }
}
