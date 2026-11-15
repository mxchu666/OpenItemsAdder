package itemsadder.m;

import itemsadder.m.Opaque032;
import java.util.Collection;

@Deprecated
public class Opaque047
extends Opaque032 {
    public Opaque047() {
    }

    public Opaque047(int n) {
        super(n);
    }

    public Opaque047(Collection collection) {
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
