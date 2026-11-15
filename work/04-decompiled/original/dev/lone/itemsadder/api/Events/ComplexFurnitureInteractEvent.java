package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.ComplexFurnitureEvent;
import itemsadder.m.dn;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.jetbrains.annotations.NotNull;

public class ComplexFurnitureInteractEvent
extends ComplexFurnitureEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    @NotNull
    private final Action action;
    private boolean isCancelled = false;

    public ComplexFurnitureInteractEvent(Player player, LivingEntity livingEntity, @NotNull Action action, dn dn2) {
        super(player, livingEntity, dn2);
        this.action = action;
    }

    @Deprecated
    public ComplexFurnitureInteractEvent(Player player, LivingEntity livingEntity, dn dn2) {
        super(player, livingEntity, dn2);
        this.action = Action.LEFT_CLICK_AIR;
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

    @NotNull
    public Action getAction() {
        return this.action;
    }
}
