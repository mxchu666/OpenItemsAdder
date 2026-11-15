package dev.lone.itemsadder.api.FontImages;

import dev.lone.itemsadder.api.FontImages.PlayerHudsHolderWrapper;
import itemsadder.m.WorldBridge_4;
import org.jetbrains.annotations.Nullable;

public class PlayerHudWrapper {
    protected final WorldBridge_4 internal;
    protected final PlayerHudsHolderWrapper playerHUDsHolderWrapper;
    protected final int startOffsetX;

    public PlayerHudWrapper(PlayerHudsHolderWrapper playerHudsHolderWrapper, String string) {
        this.playerHUDsHolderWrapper = playerHudsHolderWrapper;
        this.internal = playerHudsHolderWrapper.getInternal().aZ(string);
        this.startOffsetX = this.internal != null ? this.internal.jH() : 0;
    }

    @Nullable
    public WorldBridge_4 getInternal() {
        return this.internal;
    }

    public boolean exists() {
        return this.internal != null;
    }

    public String getNamespacedID() {
        return this.internal.getNamespacedID();
    }

    public int getInitialOffsetX() {
        return this.startOffsetX;
    }

    public int getOffsetX() {
        return this.internal.jI();
    }

    public void setOffsetX(int n) {
        this.internal.X(n);
    }

    public void setVisible(boolean bl) {
        this.internal.setVisible(bl);
    }

    public boolean isVisible() {
        return this.internal.isVisible();
    }
}
