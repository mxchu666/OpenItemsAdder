package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.CustomComplexFurniture;
import itemsadder.m.LivingEntityBuilder;
import lombok.Generated;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

abstract class ComplexFurnitureEvent
extends Event {
    @Nullable
    private final Player player;
    @Nullable
    final LivingEntity bukkitEntity;
    final LivingEntityBuilder internal;

    public ComplexFurnitureEvent(@Nullable Player player, @Nullable LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder) {
        this.player = player;
        this.bukkitEntity = livingEntity;
        this.internal = livingEntityBuilder;
    }

    @Nullable
    public CustomComplexFurniture getFurniture() {
        return CustomComplexFurniture.byAlreadySpawned(this.bukkitEntity);
    }

    @Nullable
    public String getNamespacedID() {
        if (this.internal == null) {
            return null;
        }
        return this.internal.es();
    }

    @Nullable
    public Player getPlayer() {
        return this.player;
    }

    @Nullable
    @Generated
    public LivingEntity getBukkitEntity() {
        return this.bukkitEntity;
    }
}
