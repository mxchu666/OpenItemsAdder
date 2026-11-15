package itemsadder.m;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import itemsadder.m.fm;
import itemsadder.m.fn;

final class ft {
    static final ft uc = new ft(0, 0, 0, new fn[0]);
    private final int ud;
    private final int ue;
    private final int uf;
    private final fn[] ug;

    ft(int n, int n2, int n3, fn[] fnArray) {
        this.ud = n;
        this.ue = n2;
        this.uf = n3;
        this.ug = fnArray;
    }

    boolean a(Long2ObjectOpenHashMap long2ObjectOpenHashMap) {
        for (int i = 0; i < this.ug.length; ++i) {
            fn fn2;
            fn fn3 = fn2 = long2ObjectOpenHashMap == null ? null : (fn)long2ObjectOpenHashMap.get(fm.a(this.N(i), this.O(i)));
            if (this.ug[i] == fn2) continue;
            return false;
        }
        return true;
    }

    int hT() {
        return this.ug.length;
    }

    fn M(int n) {
        return this.ug[n];
    }

    fn g(int n, int n2) {
        if (!this.h(n, n2)) {
            return null;
        }
        return this.ug[(n - this.ud) * this.uf + n2 - this.ue];
    }

    boolean h(int n, int n2) {
        if (this.uf == 0) {
            return false;
        }
        int n3 = n - this.ud;
        int n4 = n2 - this.ue;
        return n3 >= 0 && n3 < this.ug.length / this.uf && n4 >= 0 && n4 < this.uf;
    }

    int N(int n) {
        return this.ud + n / this.uf;
    }

    int O(int n) {
        return this.ue + n % this.uf;
    }
}
