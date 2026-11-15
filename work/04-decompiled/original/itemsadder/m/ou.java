package itemsadder.m;

import itemsadder.m.jh;
import itemsadder.m.ot;
import lombok.Generated;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

@Deprecated
public abstract class ou
implements ot {
    private String gv;
    public long DR = -1L;
    private boolean gz;
    public String gx;
    @Nullable
    jh gy;

    public ou ad(int n) {
        this.DR = n;
        return this;
    }

    public boolean aD() {
        return this.DR > 0L;
    }

    public ou bw(String string) {
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
    public jh mh() {
        return this.gy;
    }

    public ou b(jh jh2) {
        this.gy = jh2;
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
