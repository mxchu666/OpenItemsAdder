package itemsadder.m;

import itemsadder.m.ki;
import itemsadder.m.qm;

public class jx
extends ki {
    public static final String yA = "furniture_sit";
    final double yB;
    final boolean yC;
    @Deprecated
    final boolean yD;
    final boolean yE;
    final boolean yF;

    public jx(qm qm2, double d, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super(qm2);
        this.yB = d;
        this.yC = bl;
        this.yD = bl2;
        this.yE = bl3;
        this.yF = bl4;
    }

    public double kQ() {
        return this.yB;
    }

    public boolean kR() {
        return this.yC;
    }

    public boolean kS() {
        return this.yE;
    }

    public boolean kT() {
        return this.yF;
    }
}
