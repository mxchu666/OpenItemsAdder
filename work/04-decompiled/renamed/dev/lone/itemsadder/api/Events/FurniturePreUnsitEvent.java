package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.FurnitureEvent;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FurniturePreUnsitEvent
extends FurnitureEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancelled;

    public FurniturePreUnsitEvent(Player player, Entity entity, NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder) {
        super(player, entity, namespacedKeyItemDisplayHolder);
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean bl) {
        this.cancelled = this.cancelled;
    }
}
