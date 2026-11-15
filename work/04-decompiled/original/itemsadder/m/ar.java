package itemsadder.m;

import itemsadder.m.aq;
import itemsadder.m.jh;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public abstract class ar {
    @Generated
    private String gv;
    @Generated
    private Long gw;
    @Generated
    private String gx;
    @Generated
    private jh gy;
    @Generated
    private boolean gz;

    public ar U(String string) {
        this.gx = string;
        if (string != null && (string.startsWith("!") || string.startsWith("-"))) {
            this.gz = true;
            this.gx = string.substring(1);
        } else {
            this.gz = false;
        }
        return this.aI();
    }

    @Generated
    public ar V(String string) {
        this.gv = string;
        return this.aI();
    }

    @Generated
    public ar a(@Nullable Long l) {
        this.gw = l;
        return this.aI();
    }

    @Generated
    public ar a(@Nullable jh jh2) {
        this.gy = jh2;
        return this.aI();
    }

    @Generated
    public ar j(boolean bl) {
        this.gz = bl;
        return this.aI();
    }

    @Generated
    protected abstract ar aI();

    @Generated
    public abstract aq aJ();

    @Generated
    public String toString() {
        return "AbstractEventAction.AbstractEventActionBuilder(key=" + this.gv + ", delay=" + this.gw + ", permission=" + this.gx + ", flowModifier=" + String.valueOf(this.gy) + ", permissionInverted=" + this.gz + ")";
    }
}
