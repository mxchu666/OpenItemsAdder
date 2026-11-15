package itemsadder.m;

import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.RecordOfValue_12;
import itemsadder.m.RecordOfValue_13;
import itemsadder.m.RecordOfValue_14;
import itemsadder.m.RecordOfValue_15;
import java.util.List;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public class RecordOfValueBuilder {
    @Generated
    private EntityTypeBarStyleHolder mf;
    @Generated
    private float mg;
    @Generated
    private int mh;
    @Generated
    private List mi;
    @Generated
    private List mj;
    @Generated
    private RecordOfValue_15 mk;
    @Generated
    private RecordOfValue_13 ml;
    @Generated
    private List mm;
    @Generated
    private List mn;
    @Generated
    private RecordOfValue_14 mo;

    @Generated
    RecordOfValueBuilder() {
    }

    @Generated
    public RecordOfValueBuilder b(EntityTypeBarStyleHolder entityTypeBarStyleHolder) {
        this.mf = entityTypeBarStyleHolder;
        return this;
    }

    @Generated
    public RecordOfValueBuilder e(float f) {
        this.mg = f;
        return this;
    }

    @Generated
    public RecordOfValueBuilder l(int n) {
        this.mh = n;
        return this;
    }

    @Generated
    public RecordOfValueBuilder c(@Nullable List list) {
        this.mi = list;
        return this;
    }

    @Generated
    public RecordOfValueBuilder d(@Nullable List list) {
        this.mj = list;
        return this;
    }

    @Generated
    public RecordOfValueBuilder a(RecordOfValue_15 recordOfValue_15) {
        this.mk = recordOfValue_15;
        return this;
    }

    @Generated
    public RecordOfValueBuilder a(@Nullable RecordOfValue_13 recordOfValue_13) {
        this.ml = recordOfValue_13;
        return this;
    }

    @Generated
    public RecordOfValueBuilder e(@Nullable List list) {
        this.mm = list;
        return this;
    }

    @Generated
    public RecordOfValueBuilder f(@Nullable List list) {
        this.mn = list;
        return this;
    }

    @Generated
    public RecordOfValueBuilder a(@Nullable RecordOfValue_14 recordOfValue_14) {
        this.mo = recordOfValue_14;
        return this;
    }

    @Generated
    public RecordOfValue_12 dK() {
        return RecordOfValue_12.a(this.mf, this.mg, this.mh, this.mi, this.mj, this.mk, this.ml, this.mm, this.mn, this.mo);
    }

    @Generated
    public String toString() {
        return "EntityPopulator.EntityPopulatorBuilder(entity=" + String.valueOf(this.mf) + ", chance=" + this.mg + ", amount=" + this.mh + ", biomes=" + String.valueOf(this.mi) + ", worldNameMatchRules=" + String.valueOf(this.mj) + ", spawnLogic=" + String.valueOf(this.mk) + ", locationRange=" + String.valueOf(this.ml) + ", weathers=" + String.valueOf(this.mm) + ", timeIntervals=" + String.valueOf(this.mn) + ", lightLevelRange=" + String.valueOf(this.mo) + ")";
    }
}
