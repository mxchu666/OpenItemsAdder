package itemsadder.m;

import itemsadder.m.AFunction_3;
import itemsadder.m.Opaque124;
import lombok.Generated;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

@Deprecated
public abstract class Builder_14
implements AFunction_3 {
    private String gv;
    public long DR = -1L;
    private boolean gz;
    public String gx;
    @Nullable
    Opaque124 gy;

    public Builder_14 ad(int n) {
        this.DR = n;
        return this;
    }

    public boolean aD() {
        return this.DR > 0L;
    }

    public Builder_14 bw(String string) {
        if (string == null) {
            this.gx = null;
            return this;
        }
        if (string.startsWith("!") || string.startsWith("-")) {
            this.gz = true;
            this.gx = string.substring(1);
        } else {
            this.gz = false;
            this.gx = string;
        }
        return this;
    }

    public boolean aE() {
        return this.gx != null;
    }

    @Nullable
    public Opaque124 mh() {
        return this.gy;
    }

    public Builder_14 b(Opaque124 opaque124) {
        this.gy = opaque124;
        return this;
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
    public String aF() {
        return this.gv;
    }

    @Generated
    public void bx(String string) {
        this.gv = string;
    }

    @Generated
    public long mi() {
        return this.DR;
    }
}
