package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.ComplexFurnitureEvent;
import itemsadder.m.LivingEntityBuilder;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ComplexFurniturePreSitEvent
extends ComplexFurnitureEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled = false;

    public ComplexFurniturePreSitEvent(Player player, LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder) {
        super(player, livingEntity, livingEntityBuilder);
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
