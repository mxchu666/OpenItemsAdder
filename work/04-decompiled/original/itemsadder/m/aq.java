package itemsadder.m;

import itemsadder.m.ar;
import itemsadder.m.jh;
import lombok.Generated;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

public abstract class aq {
    final String gv;
    @Nullable
    final Long gw;
    final String gx;
    @Nullable
    final jh gy;
    final boolean gz;

    public boolean aD() {
        return this.gw != null && this.gw > 0L;
    }

    public boolean aE() {
        return this.gx != null;
    }

    public boolean c(Entity entity) {
        if (this.gx == null) {
            return true;
        }
        if (this.gz) {
            return !entity.hasPermission(this.gx);
        }
        return entity.hasPermission(this.gx);
    }

    @Generated
    protected aq(ar ar2) {
        this.gv = ar2.gv;
        this.gw = ar2.gw;
        this.gx = ar2.gx;
        this.gy = ar2.gy;
        this.gz = ar2.gz;
    }

    @Generated
    public String aF() {
        return this.gv;
    }

    @Nullable
    @Generated
    public Long aG() {
        return this.gw;
    }

    @Generated
    public String getPermission() {
        return this.gx;
    }

    @Nullable
    @Generated
    public jh aH() {
        return this.gy;
    }
}
