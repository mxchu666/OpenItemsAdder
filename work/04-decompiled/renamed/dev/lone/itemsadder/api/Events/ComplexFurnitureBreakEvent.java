package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.ComplexFurnitureEvent;
import itemsadder.m.LivingEntityBuilder;
import lombok.Generated;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ComplexFurnitureBreakEvent
extends ComplexFurnitureEvent
implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean dropItem;
    private boolean isCancelled;

    public ComplexFurnitureBreakEvent(Player player, LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder, boolean bl) {
        super(player, livingEntity, livingEntityBuilder);
        this.dropItem = bl;
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

    @Generated
    public boolean isDropItem() {
        return this.dropItem;
    }

    @Generated
    public void setDropItem(boolean bl) {
        this.dropItem = bl;
    }
}
