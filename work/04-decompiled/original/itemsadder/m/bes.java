package itemsadder.m;

import itemsadder.m.bdy;
import java.util.Collection;

@Deprecated
public class bes
extends bdy {
    public bes() {
    }

    public bes(int n) {
        super(n);
    }

    public bes(Collection collection) {
        super(collection);
    }

    @Override
    public int hashCode() {
        int[] nArray = this.bb(true);
        int n = 1;
        for (int n2 : nArray) {
            n = 31 * n + n2;
        }
        n = 31 * n + this.size();
        return n;
    }
}
