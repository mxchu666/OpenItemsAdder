package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.FurnitureEvent;
import itemsadder.m.js;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FurniturePreSitEvent
extends FurnitureEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled = false;

    public FurniturePreSitEvent(Player player, Entity entity, js js2) {
        super(player, entity, js2);
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
