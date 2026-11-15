package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import dev.lone.itemsadder.api.CustomFurniture;
import itemsadder.m.bbs;
import itemsadder.m.d;
import itemsadder.m.jl;
import itemsadder.m.js;
import itemsadder.m.mc;
import itemsadder.m.ms;
import itemsadder.m.ql;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class md
extends PacketAdapter {
    md(mc mc2, PacketAdapter.AdapterParameteters adapterParameteters) {
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        Player player = packetEvent.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            return;
        }
        World world = player.getWorld();
        if (packetEvent.getPacketType().equals((Object)PacketType.Play.Client.PICK_ITEM)) {
            this.a((Entity)packetEvent.getPacket().getEntityModifier(world).readSafely(0), player, packetEvent);
            return;
        }
        BlockPosition blockPosition = (BlockPosition)packetEvent.getPacket().getBlockPositionModifier().read(0);
        Block block = blockPosition.toLocation(world).getBlock();
        ms ms2 = d.g().b(block);
        if (ms2.isCustomBlock(block)) {
            packetEvent.setCancelled(true);
            ql ql2 = d.g().h(ms2.Y(block));
            if (ql2 != null) {
                if (ql2.FD == null) {
                    return;
                }
                this.a(ql2.mP(), player);
            }
        } else {
            this.a(jl.ao(player), player, packetEvent);
        }
    }

    private void a(Entity entity, Player player, PacketEvent packetEvent) {
        if (entity == null || !js.w(entity)) {
            return;
        }
        CustomFurniture customFurniture = CustomFurniture.byAlreadySpawned(entity);
        if (customFurniture == null) {
            return;
        }
        packetEvent.setCancelled(true);
        this.a(customFurniture.getItemStack(), player);
    }

    private void a(ItemStack itemStack, Player player) {
        int n;
        ItemStack itemStack2;
        int n2;
        if (itemStack == null) {
            return;
        }
        itemStack = itemStack.clone();
        itemStack.setAmount(1);
        PlayerInventory playerInventory = player.getInventory();
        @Nullable ItemStack @NotNull [] itemStackArray = playerInventory.getStorageContents();
        for (n2 = 0; n2 < itemStackArray.length; ++n2) {
            ItemStack itemStack3 = itemStackArray[n2];
            if (bbs.at(itemStack3) || !itemStack3.isSimilar(itemStack)) continue;
            if (n2 >= 9) {
                int n3 = playerInventory.getHeldItemSlot();
                playerInventory.setItem(n2, playerInventory.getItem(n3));
                playerInventory.setItem(n3, itemStack3);
            } else {
                playerInventory.setHeldItemSlot(n2);
            }
            return;
        }
        n2 = playerInventory.getHeldItemSlot();
        for (int i = 0; i < 9; ++i) {
            if (!bbs.at(playerInventory.getItem(i))) continue;
            n2 = i;
            break;
        }
        if (!bbs.at(itemStack2 = playerInventory.getItem(n2)) && (n = playerInventory.firstEmpty()) != -1) {
            playerInventory.setItem(n, itemStack2);
        }
        playerInventory.setHeldItemSlot(n2);
        playerInventory.setItem(n2, itemStack);
    }
}
