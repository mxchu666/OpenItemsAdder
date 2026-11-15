package dev.lone.itemsadder.api.FontImages;

import itemsadder.m.d;
import itemsadder.m.jg;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class PlayerHudsHolderWrapper {
    private final Player player;
    private final jg internal;

    public PlayerHudsHolderWrapper(Player player) {
        this.player = player;
        this.internal = (jg)d.g().ao.wW.get(player);
    }

    @Nullable
    public jg getInternal() {
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
