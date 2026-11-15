package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity$Bone;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationHolder_2;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class CustomEntity$MountBone
extends CustomEntity$Bone {
    CustomEntity$MountBone(int n, LocationHolder_2 locationHolder_2) {
        super(n, locationHolder_2);
    }

    @Nullable
    public LivingEntity getPassenger() {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return null;
        }
        return livingEntityArmorStandHolder.qR;
    }

    public boolean setPassenger(LivingEntity livingEntity) {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return false;
        }
        if (livingEntityArmorStandHolder.gG()) {
            LivingEntityRegistry.db().removePassenger(livingEntityArmorStandHolder.qR);
        }
        return LivingEntityRegistry.db().a(livingEntity, livingEntityArmorStandHolder);
    }

    public void removePassenger() {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return;
        }
        LivingEntityRegistry.db().removePassenger(livingEntityArmorStandHolder.qR);
    }

    public void setLocked(boolean bl) {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return;
        }
        livingEntityArmorStandHolder.b(bl);
    }

    public boolean isLocked() {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return false;
        }
        return livingEntityArmorStandHolder.isLocked();
    }

    public void setCanControl(boolean bl) {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return;
        }
        livingEntityArmorStandHolder.setCanControl(bl);
    }

    public boolean canControl() {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = this.internal.gD();
        if (livingEntityArmorStandHolder == null) {
            return false;
        }
        return livingEntityArmorStandHolder.canControl();
    }
}
