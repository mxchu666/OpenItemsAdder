package itemsadder.m;

import itemsadder.m.afj;
import itemsadder.m.v;

public class sh
extends v {
    int JJ;

    public sh(String string, String string2, int n) {
        super(string, string2);
        this.JJ = n;
    }

    public int getColor() {
        return this.JJ;
    }

    @Deprecated
    public Object pp() {
        return afj.tG().M(this.bL, this.bM);
    }
}
