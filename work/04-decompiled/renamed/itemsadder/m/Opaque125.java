package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.Opaque126;

public class Opaque125
extends Opaque126 {
    public static final String yA = "furniture_sit";
    final double yB;
    final boolean yC;
    @Deprecated
    final boolean yD;
    final boolean yE;
    final boolean yF;

    public Opaque125(ItemStackBuilder_4 itemStackBuilder_4, double d, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super(itemStackBuilder_4);
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
