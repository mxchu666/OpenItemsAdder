package itemsadder.m;

import it.unimi.dsi.fastutil.ints.IntArrays;
import java.util.ArrayList;
import java.util.Collection;

@Deprecated
public class Opaque032
extends ArrayList {
    public Opaque032() {
    }

    public Opaque032(int n) {
        super(n);
    }

    public Opaque032(Collection collection) {
        super(collection);
    }

    @Override
    public int hashCode() {
        int[] nArray = this.bb(false);
        int n = 1;
        for (int n2 : nArray) {
            n = 31 * n + n2;
        }
        n = 31 * n + this.size();
        return n;
    }

    public int[] bb(boolean bl) {
        Integer[] integerArray = this.toArray(new Integer[0]);
        int[] nArray = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; ++i) {
            nArray[i] = integerArray[i] == null ? 0 : integerArray[i];
        }
        if (bl) {
            IntArrays.quickSort((int[])nArray);
        }
        return nArray;
    }
}
