package dev.lone.itemsadder.api.FontImages;

import dev.lone.itemsadder.api.FontImages.PlayerHudWrapper;
import dev.lone.itemsadder.api.FontImages.PlayerHudsHolderWrapper;
import dev.lone.itemsadder.s;
import dev.lone.itemsadder.t;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_8;
import org.bukkit.entity.HumanEntity;

@Deprecated
public class PlayerQuantityHudWrapper
extends PlayerHudWrapper {
    boolean warnedAboutApiPermission = false;
    protected final PlayerBridge_8 internalQuantityHud = (PlayerBridge_8)this.internal;

    public PlayerQuantityHudWrapper(PlayerHudsHolderWrapper playerHudsHolderWrapper, String string) {
        super(playerHudsHolderWrapper, string);
    }

    @Override
    public PlayerBridge_8 getInternal() {
        return (PlayerBridge_8)this.internal;
    }

    public void setFloatValue(float f) {
        if (s.a((HumanEntity)this.playerHUDsHolderWrapper.getPlayer(), this.internalQuantityHud, t.API, true)) {
            if (!this.warnedAboutApiPermission) {
                CommandSenderBridge_5.warn("Player " + this.playerHUDsHolderWrapper.getPlayer().getName() + " has HUDs API bypass permission. HUD value won't change. More info: https://itemsadder.devs.beer/plugin-usage/permissions");
                this.warnedAboutApiPermission = true;
            }
            return;
        }
        this.warnedAboutApiPermission = false;
        ItemStackRegistry.g().ao.c(this.playerHUDsHolderWrapper.getPlayer(), this.internalQuantityHud.wa, f);
    }

    public float getFloatValue() {
        return this.internalQuantityHud.jW();
    }
}
