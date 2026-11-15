package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.ComplexFurnitureEvent;
import itemsadder.m.LivingEntityBuilder;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ComplexFurnitureSitEvent
extends ComplexFurnitureEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public ComplexFurnitureSitEvent(Player player, LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder) {
        super(player, livingEntity, livingEntityBuilder);
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
