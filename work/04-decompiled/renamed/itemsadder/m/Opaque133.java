package itemsadder.m;

import itemsadder.m.BiomeHolder;
import itemsadder.m.Opaque140;

public class Opaque133
extends Opaque140 {
    int JJ;

    public Opaque133(String string, String string2, int n) {
        super(string, string2);
        this.JJ = n;
    }

    public int getColor() {
        return this.JJ;
    }

    @Deprecated
    public Object pp() {
        return BiomeHolder.tG().M(this.bL, this.bM);
    }
}
