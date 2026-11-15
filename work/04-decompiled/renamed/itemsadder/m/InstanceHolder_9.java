package itemsadder.m;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import itemsadder.m.Builder_5;
import itemsadder.m.WorldBridge_2;

final class InstanceHolder_9 {
    static final InstanceHolder_9 uc = new InstanceHolder_9(0, 0, 0, new Builder_5[0]);
    private final int ud;
    private final int ue;
    private final int uf;
    private final Builder_5[] ug;

    InstanceHolder_9(int n, int n2, int n3, Builder_5[] builder_5Array) {
        this.ud = n;
        this.ue = n2;
        this.uf = n3;
        this.ug = builder_5Array;
    }

    boolean a(Long2ObjectOpenHashMap long2ObjectOpenHashMap) {
        for (int i = 0; i < this.ug.length; ++i) {
            Builder_5 builder_5;
            Builder_5 builder_52 = builder_5 = long2ObjectOpenHashMap == null ? null : (Builder_5)long2ObjectOpenHashMap.get(WorldBridge_2.a(this.N(i), this.O(i)));
            if (this.ug[i] == builder_5) continue;
            return false;
        }
        return true;
    }

    int hT() {
        return this.ug.length;
    }

    Builder_5 M(int n) {
        return this.ug[n];
    }

    Builder_5 g(int n, int n2) {
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
