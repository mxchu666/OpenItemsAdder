package itemsadder.m;

import itemsadder.m.o;
import itemsadder.m.se;
import lombok.Generated;

@Generated
public class sf {
    @Generated
    private o Jz;
    @Generated
    private int Cv;
    @Generated
    private double JB;
    @Generated
    private boolean JC;
    @Generated
    private boolean JD;
    @Generated
    private int JE;
    @Generated
    private int JF;

    @Generated
    sf() {
    }

    @Generated
    public sf b(o o2) {
        this.Jz = o2;
        return this;
    }

    @Generated
    public sf at(int n) {
        this.Cv = n;
        return this;
    }

    @Generated
    public sf o(double d) {
        this.JB = d;
        return this;
    }

    @Generated
    public sf ax(boolean bl) {
        this.JC = bl;
        return this;
    }

    @Generated
    public sf ay(boolean bl) {
        this.JD = bl;
        return this;
    }

    @Generated
    public sf au(int n) {
        this.JE = n;
        return this;
    }

    @Generated
    public sf av(int n) {
        this.JF = n;
        return this;
    }

    @Generated
    public se pl() {
        return new se(this.Jz, this.Cv, this.JB, this.JC, this.JD, this.JE, this.JF);
    }

    @Generated
    public String toString() {
        return "PrimeableSettings.PrimeableSettingsBuilder(itemsMatcher=" + String.valueOf(this.Jz) + ", radius=" + this.Cv + ", damageMultiplier=" + this.JB + ", waterproof=" + this.JC + ", incendiary=" + this.JD + ", fuseTicks=" + this.JE + ", triggers=" + this.JF + ")";
    }
}
