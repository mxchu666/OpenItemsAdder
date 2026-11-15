package itemsadder.m;

import itemsadder.m.ez;
import itemsadder.m.fl;
import itemsadder.m.fn;
import itemsadder.m.fq;
import itemsadder.m.ft;

final class ey {
    private static final double rw = 4.0;

    private ey() {
    }

    static void a(ft ft2, fl fl2, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        fl2.hI();
        for (int i = 0; i < ft2.hT(); ++i) {
            fn fn2 = ft2.M(i);
            if (fn2 == null) continue;
            int n = ft2.N(i);
            int n2 = ft2.O(i);
            for (int j = 0; j < fn2.hL(); ++j) {
                int n3 = fn2.C(j);
                fq fq2 = fn2.D(j);
                for (int k = 0; k < fq2.hO(); ++k) {
                    byte by = fq2.K(k);
                    if (by == 0) continue;
                    int n4 = fq2.I(k) & 0xFFF;
                    int n5 = n << 4 | n4 & 0xF;
                    int n6 = n3 << 4 | n4 >>> 8;
                    int n7 = n2 << 4 | n4 >>> 4 & 0xF;
                    long l = ez.f(n5, n6, n7);
                    byte by2 = fq2.L(k);
                    double d8 = ey.a(n5, n6, n7, by, by2, d, d2, d3, d4, d5, d6, d7);
                    if (!(d8 >= 0.0)) continue;
                    fl2.a(l, fq2.J(k), by2, d8);
                }
            }
        }
    }

    static double a(long l, byte by, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return ey.a(l, by, (byte)0, d, d2, d3, d4, d5, d6, d7);
    }

    static double a(long l, byte by, byte by2, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return ey.a(ez.c(l), ez.d(l), ez.e(l), by, by2, d, d2, d3, d4, d5, d6, d7);
    }

    private static double a(int n, int n2, int n3, byte by, byte by2, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = by2 != 0 ? 1.5 : 0.5;
        double d9 = by2 == 1 ? 1.5 : 0.5;
        double d10 = by2 == 2 ? 1.5 : 0.5;
        double d11 = (double)n + d8;
        double d12 = (double)n2 + d9;
        double d13 = (double)n3 + d10;
        double d14 = ey.c(d, d11 - d8, d11 + d8);
        double d15 = ey.c(d2, d12 - d9, d12 + d9);
        double d16 = ey.c(d3, d13 - d10, d13 + d10);
        double d17 = d14 - d;
        double d18 = d15 - d2;
        double d19 = d16 - d3;
        double d20 = d17 * d17 + d18 * d18 + d19 * d19;
        if (by == 0 || d20 > d6) {
            return -1.0;
        }
        if (d20 <= 4.0) {
            return d20;
        }
        if (!ez.a(d17, d18, d19, d4, d5, d20, d7)) {
            return -1.0;
        }
        return d20;
    }

    private static double c(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }
}
