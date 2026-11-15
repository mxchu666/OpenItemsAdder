package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.FurnitureEvent;
import itemsadder.m.js;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
public class FurniturePlaceSuccessEvent
extends FurnitureEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public FurniturePlaceSuccessEvent(Player player, Entity entity, js js2) {
        super(player, entity, js2);
    }

    @Override
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
