package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.FurnitureEvent;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FurniturePlacedEvent
extends FurnitureEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled = false;

    public FurniturePlacedEvent(Player player, Entity entity, NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder) {
        super(player, entity, namespacedKeyItemDisplayHolder);
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
}
