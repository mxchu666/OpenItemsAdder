package dev.lone.itemsadder.api.Events;

import itemsadder.m.js;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
public class FurniturePlaceEvent
extends PlayerEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    final js internal;
    private boolean isCancelled;

    public FurniturePlaceEvent(Player player, js js2) {
        super(player);
        this.internal = js2;
        this.isCancelled = false;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }

    @Nullable
    public String getNamespacedID() {
        return this.internal.zk.Gh;
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
