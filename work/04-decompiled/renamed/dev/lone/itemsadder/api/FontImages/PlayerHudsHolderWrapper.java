package dev.lone.itemsadder.api.FontImages;

import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_15;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class PlayerHudsHolderWrapper {
    private final Player player;
    private final PlayerBridge_15 internal;

    public PlayerHudsHolderWrapper(Player player) {
        this.player = player;
        this.internal = (PlayerBridge_15)ItemStackRegistry.g().ao.wW.get(player);
    }

    @Nullable
    public PlayerBridge_15 getInternal() {
        return this.internal;
    }

    public boolean exists() {
        return this.internal != null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void recalculateOffsets() {
        this.internal.recalculateOffsets();
    }

    public void sendUpdate() {
        this.internal.kv();
    }
}
