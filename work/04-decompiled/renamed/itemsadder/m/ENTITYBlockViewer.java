package itemsadder.m;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Arrays;

final class ENTITYBlockViewer {
    private final Long2IntOpenHashMap tb;
    private final Long2IntOpenHashMap tc;
    final long[] td;
    final int[] te;
    final int[] tf;
    final int[] tg;
    final boolean[] th;
    final boolean[] ti;
    final boolean[] tj;
    final byte[] tk;
    final long[] tl;
    final int[] tm;
    final byte[] tn;
    final double[] to;
    final int[] tp;
    final int[] tq;
    final LongOpenHashSet tr = new LongOpenHashSet();
    final LongOpenHashSet ts = new LongOpenHashSet();
    private final int[] tt;
    private int tu;
    private int tv;
    int tw;
    int tx;
    int ty;

    ENTITYBlockViewer(int n) {
        this(n, n);
    }

    ENTITYBlockViewer(int n, int n2) {
        if (n < 1 || n2 < 1 || n2 > n) {
            throw new IllegalArgumentException("ENTITY block viewer capacity must be positive.");
        }
        this.tb = ENTITYBlockViewer.z(n2);
        this.tc = ENTITYBlockViewer.z(n2);
        this.td = new long[n];
        this.te = new int[n];
        Arrays.fill(this.te, -1);
        this.tf = new int[n];
        this.tg = new int[n];
        this.th = new boolean[n];
        this.ti = new boolean[n];
        this.tj = new boolean[n];
        this.tk = new byte[n];
        this.tl = new long[n2];
        this.tm = new int[n2];
        this.tn = new byte[n2];
        this.to = new double[n2];
        this.tp = new int[n2];
        this.tq = new int[n];
        this.tt = new int[n];
        for (int i = 0; i < n; ++i) {
            this.tt[i] = n - i - 1;
        }
        this.tu = n;
    }

    void hI() {
        if (++this.tv == 0) {
            Arrays.fill(this.tf, 0);
            this.tv = 1;
        }
        this.tw = 0;
    }

    void a(long l, int n, double d) {
        this.a(l, n, (byte)0, d);
    }

    void a(long l, int n, byte by, double d) {
        if (this.tw < this.tl.length) {
            int n2 = this.tw++;
            this.a(n2, l, n, by, d);
            this.v(n2);
            return;
        }
        if (d >= this.to[0]) {
            return;
        }
        this.a(0, l, n, by, d);
        this.hJ();
    }

    private void a(int n, long l, int n2, byte by, double d) {
        this.tl[n] = l;
        this.tm[n] = n2;
        this.tn[n] = by;
        this.to[n] = d;
    }

    private void v(int n) {
        while (n > 0) {
            int n2 = n - 1 >>> 1;
            if (this.to[n2] >= this.to[n]) {
                return;
            }
            this.d(n2, n);
            n = n2;
        }
    }

    private void hJ() {
        int n = 0;
        int n2;
        while ((n2 = n * 2 + 1) < this.tw) {
            int n3;
            int n4 = n2 + 1;
            int n5 = n3 = n4 < this.tw && this.to[n4] > this.to[n2] ? n4 : n2;
            if (this.to[n] >= this.to[n3]) {
                return;
            }
            this.d(n, n3);
            n = n3;
        }
        return;
    }

    private void d(int n, int n2) {
        long l = this.tl[n];
        int n3 = this.tm[n];
        byte by = this.tn[n];
        double d = this.to[n];
        this.a(n, this.tl[n2], this.tm[n2], this.tn[n2], this.to[n2]);
        this.a(n2, l, n3, by, d);
    }

    int b(long l, int n, int n2) {
        return this.a(l, n, (byte)0, n2);
    }

    int a(long l, int n, byte by, int n2) {
        Long2IntOpenHashMap long2IntOpenHashMap = this.b(by);
        int n3 = long2IntOpenHashMap.get(l);
        if (n3 < 0) {
            if (this.tu == 0) {
                return -1;
            }
            n3 = this.tt[--this.tu];
            long2IntOpenHashMap.put(l, n3);
            this.td[n3] = l;
            this.th[n3] = true;
            if (this.ti[n3]) {
                --this.ty;
            }
        }
        this.a(n3, n, by, n2);
        return n3;
    }

    void a(int n, int n2, byte by, int n3) {
        this.tk[n] = by;
        this.te[n] = n2;
        this.tj[n] = false;
        this.tf[n] = this.tv;
        this.tg[n] = n3;
    }

    boolean w(int n) {
        return this.tf[n] == this.tv;
    }

    void e(int n, int n2) {
        this.y(n);
        this.th[n] = false;
        this.tj[n] = false;
        this.tg[n] = n2;
        if (this.ti[n]) {
            ++this.ty;
        }
        this.tt[this.tu++] = n;
    }

    int a(int n, long l, int n2, int n3) {
        return this.a(n, l, n2, (byte)0, n3);
    }

    int a(int n, long l, int n2, byte by, int n3) {
        int n4 = this.te[n];
        this.y(n);
        this.b(by).put(l, n);
        this.td[n] = l;
        this.tk[n] = by;
        this.te[n] = n2;
        this.tj[n] = false;
        this.tf[n] = this.tv;
        this.tg[n] = n3;
        return n4;
    }

    boolean x(int n) {
        if (this.tj[n]) {
            return false;
        }
        this.tj[n] = true;
        this.tf[n] = this.tv;
        return true;
    }

    private void y(int n) {
        long l = this.td[n];
        Long2IntOpenHashMap long2IntOpenHashMap = this.b(this.tk[n]);
        if (long2IntOpenHashMap.get(l) == n) {
            long2IntOpenHashMap.remove(l);
        }
    }

    int g(long l) {
        return this.d(l, (byte)0);
    }

    int d(long l, byte by) {
        return this.b(by).get(l);
    }

    void f(int n, int n2) {
        if (!this.ti[n]) {
            return;
        }
        this.ti[n] = false;
        this.te[n] = -1;
        if (!this.th[n]) {
            --this.ty;
        }
        this.tq[this.tx++] = n2;
    }

    boolean h(long l) {
        return this.e(l, (byte)0);
    }

    boolean e(long l, byte by) {
        return this.d(l, by) >= 0;
    }

    int hf() {
        return this.td.length;
    }

    int hK() {
        return this.tb.size() + this.tc.size();
    }

    void clear() {
        this.tb.clear();
        this.tc.clear();
        Arrays.fill(this.th, false);
        Arrays.fill(this.ti, false);
        Arrays.fill(this.tj, false);
        Arrays.fill(this.te, -1);
        for (int i = 0; i < this.tt.length; ++i) {
            this.tt[i] = this.tt.length - i - 1;
        }
        this.tu = this.tt.length;
        this.tw = 0;
        this.tx = 0;
        this.ty = 0;
        this.tr.clear();
        this.ts.clear();
    }

    private Long2IntOpenHashMap b(byte by) {
        return by == 0 ? this.tb : this.tc;
    }

    private static Long2IntOpenHashMap z(int n) {
        Long2IntOpenHashMap long2IntOpenHashMap = new Long2IntOpenHashMap(n);
        long2IntOpenHashMap.defaultReturnValue(-1);
        return long2IntOpenHashMap;
    }
}
