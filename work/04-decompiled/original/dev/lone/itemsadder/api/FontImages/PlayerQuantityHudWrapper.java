package dev.lone.itemsadder.api.FontImages;

import dev.lone.itemsadder.api.FontImages.PlayerHudWrapper;
import dev.lone.itemsadder.api.FontImages.PlayerHudsHolderWrapper;
import dev.lone.itemsadder.s;
import dev.lone.itemsadder.t;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import org.bukkit.entity.HumanEntity;

@Deprecated
public class PlayerQuantityHudWrapper
extends PlayerHudWrapper {
    boolean warnedAboutApiPermission = false;
    protected final ij internalQuantityHud = (ij)this.internal;

    public PlayerQuantityHudWrapper(PlayerHudsHolderWrapper playerHudsHolderWrapper, String string) {
        super(playerHudsHolderWrapper, string);
    }

    @Override
    public ij getInternal() {
        return (ij)this.internal;
    }

    public void setFloatValue(float f2) {
        if (s.a((HumanEntity)this.playerHUDsHolderWrapper.getPlayer(), this.internalQuantityHud, t.API, true)) {
            if (!this.warnedAboutApiPermission) {
                bce.warn("Player " + this.playerHUDsHolderWrapper.getPlayer().getName() + " has HUDs API bypass permission. HUD value won't change. More info: https://itemsadder.devs.beer/plugin-usage/permissions");
                this.warnedAboutApiPermission = true;
            }
            return;
        }
        this.warnedAboutApiPermission = false;
        d.g().ao.c(this.playerHUDsHolderWrapper.getPlayer(), this.internalQuantityHud.wa, f2);
    }

    public float getFloatValue() {
        return this.internalQuantityHud.jW();
    }
}
