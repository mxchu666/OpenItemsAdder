package itemsadder.m;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemStackPlayerHolder
extends Event
implements Cancellable {
    private final ItemStack SU;
    private final int SV;
    private final Player SW;
    private boolean cancelled = false;
    private static final HandlerList SX = new HandlerList();

    public ItemStackPlayerHolder(Player player, ItemStack itemStack, int n) {
        super(true);
        this.SW = player;
        this.SU = itemStack;
        this.SV = n;
    }

    public ItemStackPlayerHolder(Player player) {
        this(player, player.getInventory().getItemInMainHand(), player.getInventory().getHeldItemSlot());
    }

    public ItemStack getItemStack() {
        return this.SU;
    }

    public int sC() {
        return this.SV;
    }

    public Player getPlayer() {
        return this.SW;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean bl) {
        this.cancelled = true;
    }

    @NotNull
    public HandlerList getHandlers() {
        return SX;
    }

    public static HandlerList getHandlerList() {
        return SX;
    }
}
