package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.bbs;
import itemsadder.m.bcp;
import itemsadder.m.bo;
import itemsadder.m.bx;
import itemsadder.m.ci;
import itemsadder.m.cj;
import itemsadder.m.co;
import itemsadder.m.d;
import itemsadder.m.ql;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

class ct
extends PacketAdapter {
    final /* synthetic */ co kX;

    ct(co co2, Plugin plugin, PacketType ... packetTypeArray) {
        this.kX = co2;
        super(plugin, packetTypeArray);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (!this.kX.cU()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            return;
        }
        bcp.i(() -> {
            if (!this.kX.cU()) {
                return;
            }
            ci ci2 = this.kX.kO.A(player);
            if (ci2 == null) {
                return;
            }
            cj cj2 = ci2.K(player);
            if (cj2 != null) {
                int n;
                packetEvent.setCancelled(true);
                Block block = cj2.getLocation().getBlock();
                bo bo2 = this.kX.kO.f(block);
                if (bo2 == null) {
                    return;
                }
                bx bx2 = (bx)d.g().ab.get(bo2.bj());
                ItemStack itemStack = bx2.hE.mP();
                packetEvent.setCancelled(true);
                PlayerInventory playerInventory = player.getInventory();
                for (n = 0; n <= 8; ++n) {
                    if (bbs.at(playerInventory.getItem(n)) || !ql.b(playerInventory.getItem(n), itemStack)) continue;
                    playerInventory.setHeldItemSlot(n);
                    playerInventory.setItem(n, itemStack);
                    return;
                }
                if (bbs.at(playerInventory.getItemInMainHand())) {
                    playerInventory.setItemInMainHand(itemStack);
                } else {
                    for (n = 0; n <= 8; ++n) {
                        if (!bbs.at(playerInventory.getItem(n))) continue;
                        playerInventory.setHeldItemSlot(n);
                        playerInventory.setItem(n, itemStack);
                        return;
                    }
                    playerInventory.setItemInMainHand(itemStack);
                }
            }
        });
    }
}
