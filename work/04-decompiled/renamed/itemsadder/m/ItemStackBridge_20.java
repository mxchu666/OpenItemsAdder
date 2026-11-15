package itemsadder.m;

import itemsadder.m.BoolData;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque021;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_20
extends BoolData {
    final NamespacedKeyItemDisplayHolder Dd;

    public ItemStackBridge_20(NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder, boolean bl) {
        super(bl);
        this.Dd = namespacedKeyItemDisplayHolder;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStack, player.getLocation().getBlock());
    }

    @Override
    public ItemStackBuilder_3 a(Event event, Block block, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStack, block);
    }

    @Override
    public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.getClickedBlock() == null) {
            return ItemStackBuilder_3.l(itemStack);
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || ItemStackBridge_2.G(itemStack) || ItemStackBuilder_4.G(itemStack)) {
            return ItemStackBuilder_3.l(itemStack);
        }
        Opaque021 opaque021 = NamespacedKeyEntityTypeHolder.ap(playerInteractEvent.getPlayer());
        if (opaque021 != null) {
            return ItemStackBuilder_3.mk();
        }
        if (LocationBridge_2.b(playerInteractEvent.getClickedBlock(), playerInteractEvent.getPlayer())) {
            if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE && this.Cq) {
                ItemStackBridge_2.aj(itemStack);
            }
            BukkitTaskBridge.c(() -> {
                Block block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
                this.Dd.a(this.Dd.zk.mP(), block.getLocation(), block, playerInteractEvent.getHand(), playerInteractEvent.getPlayer(), null, playerInteractEvent.getBlockFace());
            }, 2L);
        }
        return ItemStackBuilder_3.m(itemStack);
    }

    private ItemStackBuilder_3 a(Event event, Player player, ItemStack itemStack, Block block) {
        Opaque021 opaque021 = NamespacedKeyEntityTypeHolder.ap(player);
        if (opaque021 != null) {
            return ItemStackBuilder_3.mk();
        }
        if (LocationBridge_2.b(block, player)) {
            this.Dd.a(this.Dd.zk.mP(), block.getLocation(), block, null, player, null, null);
            if (player.getGameMode() != GameMode.CREATIVE && this.Cq) {
                ItemStackBridge_2.aj(itemStack);
            }
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
