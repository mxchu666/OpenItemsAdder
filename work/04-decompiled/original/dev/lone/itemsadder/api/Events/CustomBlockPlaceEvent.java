package dev.lone.itemsadder.api.Events;

import itemsadder.m.ql;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomBlockPlaceEvent
extends PlayerEvent
implements Cancellable {
    final Block block;
    public final ql internal;
    protected final boolean canBuild;
    protected final Block placedAgainst;
    protected final BlockState replacedBlockState;
    protected final ItemStack itemInHand;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public CustomBlockPlaceEvent(Player player, Block block, ql ql2, boolean bl, Block block2, BlockState blockState, ItemStack itemStack) {
        super(player);
        this.block = block;
        this.internal = ql2;
        this.canBuild = bl;
        this.placedAgainst = block2;
        this.replacedBlockState = blockState;
        this.itemInHand = itemStack;
    }

    public CustomBlockPlaceEvent(BlockPlaceEvent blockPlaceEvent, ql ql2) {
        super(blockPlaceEvent.getPlayer());
        this.internal = ql2;
        this.canBuild = blockPlaceEvent.canBuild();
        this.placedAgainst = blockPlaceEvent.getBlockAgainst();
        this.replacedBlockState = blockPlaceEvent.getBlockReplacedState();
        this.itemInHand = blockPlaceEvent.getItemInHand();
        this.block = blockPlaceEvent.getBlock();
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

    public boolean isCanBuild() {
        return this.canBuild;
    }

    public Block getPlacedAgainst() {
        return this.placedAgainst;
    }

    public BlockState getReplacedBlockState() {
        return this.replacedBlockState;
    }

    public ItemStack getItemInHand() {
        return this.itemInHand;
    }
}
