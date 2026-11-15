package dev.lone.itemsadder.resourcepack;

import itemsadder.m.aad;
import itemsadder.m.adb;
import itemsadder.m.adq;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.do;
import java.util.List;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

class az {
    private adq aun;
    @Nullable
    private do auo;
    private final Player aup;

    public az(Player player) {
        this.aup = player;
    }

    public void zD() {
        try {
            this.auo = new do(this.aup, null);
            this.aun = adq.a(this.aup.getLocation(), EquipmentSlot.HAND, false, true, true);
            this.aun.h(this.auo);
            this.aun.a(List.of(this.auo), (LivingEntity)this.aup);
            this.aun.bK(this.aup);
            bcp.c(() -> adb.bI(this.aup), 1L);
            aad.tf().bC(this.aup);
        }
        catch (Throwable throwable) {
            bce.error("Failed to lock player movements.", throwable);
        }
    }

    public void zE() {
        if (this.aun != null) {
            this.aun.f(this.auo);
            aad.tf().bD(this.aup);
        }
    }
}
