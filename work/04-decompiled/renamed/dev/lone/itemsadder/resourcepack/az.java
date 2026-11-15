package dev.lone.itemsadder.resourcepack;

import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationEquipmentSlotHolder;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.PlayerJoinListener;
import java.util.List;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

class az {
    private LocationEquipmentSlotHolder aun;
    @Nullable
    private PlayerBridge_7 auo;
    private final Player aup;

    public az(Player player) {
        this.aup = player;
    }

    public void zD() {
        try {
            this.auo = new PlayerBridge_7(this.aup, null);
            this.aun = LocationEquipmentSlotHolder.a(this.aup.getLocation(), EquipmentSlot.HAND, false, true, true);
            this.aun.h(this.auo);
            this.aun.a(List.of(this.auo), (LivingEntity)this.aup);
            this.aun.bK(this.aup);
            BukkitTaskBridge.c(() -> PacketContainerHolder.bI(this.aup), 1L);
            PlayerJoinListener.tf().bC(this.aup);
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to lock player movements.", throwable);
        }
    }

    public void zE() {
        if (this.aun != null) {
            this.aun.f(this.auo);
            PlayerJoinListener.tf().bD(this.aup);
        }
    }
}
