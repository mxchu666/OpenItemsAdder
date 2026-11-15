package dev.lone.itemsadder.api.Events;

import itemsadder.m.ql;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomBlockInteractEvent
extends PlayerEvent
implements Cancellable {
    public final ql internal;
    protected final ItemStack item;
    protected final Action action;
    protected final Block blockClicked;
    protected final BlockFace blockFace;
    private final EquipmentSlot hand;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public CustomBlockInteractEvent(Player player, Action action, ItemStack itemStack, Block block, BlockFace blockFace, EquipmentSlot equipmentSlot, ql ql2) {
        super(player);
        this.internal = ql2;
        this.player = player;
        this.action = action;
        this.item = itemStack;
        this.blockClicked = block;
        this.blockFace = blockFace;
        this.hand = equipmentSlot;
        this.isCancelled = false;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public ItemStack getCustomBlockItem() {
        return this.internal.mP();
    }

    public String getNamespacedID() {
        return this.internal.getNamespacedID();
    }

    public ItemStack getItem() {
        return this.item;
    }

    public Action getAction() {
        return this.action;
    }

    public Block getBlockClicked() {
        return this.blockClicked;
    }

    public BlockFace getBlockFace() {
        return this.blockFace;
    }

    public EquipmentSlot getHand() {
        return this.hand;
    }
}
