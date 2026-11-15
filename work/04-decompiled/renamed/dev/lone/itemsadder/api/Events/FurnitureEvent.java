package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.CustomFurniture;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;

abstract class FurnitureEvent
extends PlayerEvent {
    final Entity bukkitEntity;
    final NamespacedKeyItemDisplayHolder internal;

    public FurnitureEvent(Player player, Entity entity, NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder) {
        super(player);
        this.bukkitEntity = entity;
        this.internal = namespacedKeyItemDisplayHolder;
    }

    @Nullable
    public CustomFurniture getFurniture() {
        return CustomFurniture.byAlreadySpawned(this.bukkitEntity);
    }

    @Nullable
    public String getNamespacedID() {
        if (this.internal == null) {
            return null;
        }
        return this.internal.zk.Gh;
    }

    public Entity getBukkitEntity() {
        return this.bukkitEntity;
    }
}
