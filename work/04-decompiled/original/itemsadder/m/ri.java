package itemsadder.m;

import itemsadder.m.rh;
import java.util.List;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public class ri {
    @Generated
    private int HU;
    @Generated
    private float yy;
    @Generated
    private boolean HW;
    @Generated
    private int HX;
    @Generated
    private String HY;
    @Generated
    private String ov;
    @Generated
    private Boolean Ia;
    @Generated
    private List Ib;

    @Generated
    ri() {
    }

    @Generated
    public ri ai(int n) {
        this.HU = n;
        return this;
    }

    @Generated
    public ri n(float f) {
        this.yy = f;
        return this;
    }

    @Generated
    public ri at(boolean bl) {
        this.HW = bl;
        return this;
    }

    @Generated
    public ri aj(int n) {
        this.HX = n;
        return this;
    }

    @Generated
    public ri bZ(@Nullable String string) {
        this.HY = string;
        return this;
    }

    @Generated
    public ri ca(@Nullable String string) {
        this.ov = string;
        return this;
    }

    @Generated
    public ri c(@Nullable Boolean bl) {
        this.Ia = bl;
        return this;
    }

    @Generated
    public ri n(@Nullable List list) {
        this.Ib = list;
        return this;
    }

    @Generated
    public rh oa() {
        return new rh(this.HU, this.yy, this.HW, this.HX, this.HY, this.ov, this.Ia, this.Ib);
    }

    @Generated
    public String toString() {
        return "ConsumableData.ConsumableDataBuilder(nutrition=" + this.HU + ", saturation=" + this.yy + ", canAlwaysEat=" + this.HW + ", consumeSeconds=" + this.HX + ", animation=" + this.HY + ", sound=" + this.ov + ", particles=" + this.Ia + ", effects=" + String.valueOf(this.Ib) + ")";
    }
}
