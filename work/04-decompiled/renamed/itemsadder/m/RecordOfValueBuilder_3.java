package itemsadder.m;

import itemsadder.m.RecordOfValue_23;
import java.util.List;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public class RecordOfValueBuilder_3 {
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
    RecordOfValueBuilder_3() {
    }

    @Generated
    public RecordOfValueBuilder_3 ai(int n) {
        this.HU = n;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 n(float f) {
        this.yy = f;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 at(boolean bl) {
        this.HW = bl;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 aj(int n) {
        this.HX = n;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 bZ(@Nullable String string) {
        this.HY = string;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 ca(@Nullable String string) {
        this.ov = string;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 c(@Nullable Boolean bl) {
        this.Ia = bl;
        return this;
    }

    @Generated
    public RecordOfValueBuilder_3 n(@Nullable List list) {
        this.Ib = list;
        return this;
    }

    @Generated
    public RecordOfValue_23 oa() {
        return new RecordOfValue_23(this.HU, this.yy, this.HW, this.HX, this.HY, this.ov, this.Ia, this.Ib);
    }

    @Generated
    public String toString() {
        return "ConsumableData.ConsumableDataBuilder(nutrition=" + this.HU + ", saturation=" + this.yy + ", canAlwaysEat=" + this.HW + ", consumeSeconds=" + this.HX + ", animation=" + this.HY + ", sound=" + this.ov + ", particles=" + this.Ia + ", effects=" + String.valueOf(this.Ib) + ")";
    }
}
