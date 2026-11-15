package dev.lone.itemsadder.api.Events;

import itemsadder.m.PlayerBridge_16;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ComplexFurniturePrePlaceEvent
extends Event
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    @Nullable
    private final Player player;
    final PlayerBridge_16 internal;
    private final Location location;
    private boolean isCancelled;

    public ComplexFurniturePrePlaceEvent(@Nullable Player player, PlayerBridge_16 playerBridge_16, Location location) {
        this.player = player;
        this.internal = playerBridge_16;
        this.location = location;
        this.isCancelled = false;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }

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

    @Nullable
    @Generated
    public Player getPlayer() {
        return this.player;
    }

    @Generated
    public Location getLocation() {
        return this.location;
    }
}
