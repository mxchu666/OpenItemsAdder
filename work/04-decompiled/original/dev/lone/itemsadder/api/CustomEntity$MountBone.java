package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity$Bone;
import itemsadder.m.da;
import itemsadder.m.ej;
import itemsadder.m.ek;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class CustomEntity$MountBone
extends CustomEntity$Bone {
    CustomEntity$MountBone(int n, ej ej2) {
        super(n, ej2);
    }

    @Nullable
    public LivingEntity getPassenger() {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return null;
        }
        return ek2.qR;
    }

    public boolean setPassenger(LivingEntity livingEntity) {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return false;
        }
        if (ek2.gG()) {
            da.db().removePassenger(ek2.qR);
        }
        return da.db().a(livingEntity, ek2);
    }

    public void removePassenger() {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return;
        }
        da.db().removePassenger(ek2.qR);
    }

    public void setLocked(boolean bl) {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return;
        }
        ek2.b(bl);
    }

    public boolean isLocked() {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return false;
        }
        return ek2.isLocked();
    }

    public void setCanControl(boolean bl) {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return;
        }
        ek2.setCanControl(bl);
    }

    public boolean canControl() {
        ek ek2 = this.internal.gD();
        if (ek2 == null) {
            return false;
        }
        return ek2.canControl();
    }
}
