package itemsadder.m;

import itemsadder.m.de;
import itemsadder.m.dg;
import itemsadder.m.di;
import itemsadder.m.dj;
import itemsadder.m.dp;
import java.util.List;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public class df {
    @Generated
    private dp mf;
    @Generated
    private float mg;
    @Generated
    private int mh;
    @Generated
    private List mi;
    @Generated
    private List mj;
    @Generated
    private dj mk;
    @Generated
    private dg ml;
    @Generated
    private List mm;
    @Generated
    private List mn;
    @Generated
    private di mo;

    @Generated
    df() {
    }

    @Generated
    public df b(dp dp2) {
        this.mf = dp2;
        return this;
    }

    @Generated
    public df e(float f) {
        this.mg = f;
        return this;
    }

    @Generated
    public df l(int n) {
        this.mh = n;
        return this;
    }

    @Generated
    public df c(@Nullable List list) {
        this.mi = list;
        return this;
    }

    @Generated
    public df d(@Nullable List list) {
        this.mj = list;
        return this;
    }

    @Generated
    public df a(dj dj2) {
        this.mk = dj2;
        return this;
    }

    @Generated
    public df a(@Nullable dg dg2) {
        this.ml = dg2;
        return this;
    }

    @Generated
    public df e(@Nullable List list) {
        this.mm = list;
        return this;
    }

    @Generated
    public df f(@Nullable List list) {
        this.mn = list;
        return this;
    }

    @Generated
    public df a(@Nullable di di2) {
        this.mo = di2;
        return this;
    }

    @Generated
    public de dK() {
        return de.a(this.mf, this.mg, this.mh, this.mi, this.mj, this.mk, this.ml, this.mm, this.mn, this.mo);
    }

    @Generated
    public String toString() {
        return "EntityPopulator.EntityPopulatorBuilder(entity=" + String.valueOf(this.mf) + ", chance=" + this.mg + ", amount=" + this.mh + ", biomes=" + String.valueOf(this.mi) + ", worldNameMatchRules=" + String.valueOf(this.mj) + ", spawnLogic=" + String.valueOf(this.mk) + ", locationRange=" + String.valueOf(this.ml) + ", weathers=" + String.valueOf(this.mm) + ", timeIntervals=" + String.valueOf(this.mn) + ", lightLevelRange=" + String.valueOf(this.mo) + ")";
    }
}
