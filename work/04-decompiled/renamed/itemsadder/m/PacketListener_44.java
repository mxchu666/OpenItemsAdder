package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemDisplayLocationHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.PlayerBlockHolder;
import itemsadder.m.PlayerInteractListener;
import itemsadder.m.RecordOfString_4;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

class PacketListener_44
extends PacketAdapter {
    final /* synthetic */ PlayerInteractListener kX;

    PacketListener_44(PlayerInteractListener playerInteractListener, Plugin plugin, PacketType ... packetTypeArray) {
        this.kX = playerInteractListener;
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
        BukkitTaskBridge.i(() -> {
            if (!this.kX.cU()) {
                return;
            }
            PlayerBlockHolder playerBlockHolder = this.kX.kO.A(player);
            if (playerBlockHolder == null) {
                return;
            }
            ItemDisplayLocationHolder itemDisplayLocationHolder = playerBlockHolder.K(player);
            if (itemDisplayLocationHolder != null) {
                int n;
                packetEvent.setCancelled(true);
                Block block = itemDisplayLocationHolder.getLocation().getBlock();
                RecordOfString_4 recordOfString_4 = this.kX.kO.f(block);
                if (recordOfString_4 == null) {
                    return;
                }
                LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
                ItemStack itemStack = locationBridge_7.hE.mP();
                packetEvent.setCancelled(true);
                PlayerInventory playerInventory = player.getInventory();
                for (n = 0; n <= 8; ++n) {
                    if (ItemStackBridge_2.at(playerInventory.getItem(n)) || !LocationBridgeBuilder_2.b(playerInventory.getItem(n), itemStack)) continue;
                    playerInventory.setHeldItemSlot(n);
                    playerInventory.setItem(n, itemStack);
                    return;
                }
                if (ItemStackBridge_2.at(playerInventory.getItemInMainHand())) {
                    playerInventory.setItemInMainHand(itemStack);
                } else {
                    for (n = 0; n <= 8; ++n) {
                        if (!ItemStackBridge_2.at(playerInventory.getItem(n))) continue;
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
