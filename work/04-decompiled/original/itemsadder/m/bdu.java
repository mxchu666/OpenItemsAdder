package itemsadder.m;

import itemsadder.m.bds;
import itemsadder.m.bdv;
import itemsadder.m.bdw;
import java.util.HashMap;

public class bdu {
    public int aBT;
    public final HashMap aBU = new HashMap();

    public bdu() {
    }

    public bdu(int n) {
        this.aBT = n;
    }

    public void bS(int n) {
        this.aBT = n;
    }

    public void a(String string, bdw bdw2) {
        this.aBU.put(string, bdw2);
    }

    public bdw je(String string) {
        return (bdw)this.aBU.get(string);
    }

    public void clear() {
        this.aBT = 0;
        this.aBU.clear();
    }

    bdv DU() {
        return new bdv(this, bds.aBM, true);
    }
}
