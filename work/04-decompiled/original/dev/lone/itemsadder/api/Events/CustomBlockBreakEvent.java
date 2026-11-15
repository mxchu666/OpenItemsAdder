package dev.lone.itemsadder.api.Events;

import itemsadder.m.ql;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomBlockBreakEvent
extends PlayerEvent
implements Cancellable {
    final Block block;
    final ql internal;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public CustomBlockBreakEvent(Player player, Block block, ql ql2) {
        super(player);
        this.player = player;
        this.block = block;
        this.internal = ql2;
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

    public Block getBlock() {
        return this.block;
    }
}
