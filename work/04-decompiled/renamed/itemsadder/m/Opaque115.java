package itemsadder.m;

import itemsadder.m.Builder_5;
import itemsadder.m.ENTITYBlockViewer;
import itemsadder.m.InstanceHolder_9;
import itemsadder.m.Opaque116;
import itemsadder.m.RecordOfValueBuilder_2;

final class Opaque115 {
    private static final double rw = 4.0;

    private Opaque115() {
    }

    static void a(InstanceHolder_9 instanceHolder_9, ENTITYBlockViewer eNTITYBlockViewer, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        eNTITYBlockViewer.hI();
        for (int i = 0; i < instanceHolder_9.hT(); ++i) {
            Builder_5 builder_5 = instanceHolder_9.M(i);
            if (builder_5 == null) continue;
            int n = instanceHolder_9.N(i);
            int n2 = instanceHolder_9.O(i);
            for (int j = 0; j < builder_5.hL(); ++j) {
                int n3 = builder_5.C(j);
                RecordOfValueBuilder_2 recordOfValueBuilder_2 = builder_5.D(j);
                for (int k = 0; k < recordOfValueBuilder_2.hO(); ++k) {
                    byte by = recordOfValueBuilder_2.K(k);
                    if (by == 0) continue;
                    int n4 = recordOfValueBuilder_2.I(k) & 0xFFF;
                    int n5 = n << 4 | n4 & 0xF;
                    int n6 = n3 << 4 | n4 >>> 8;
                    int n7 = n2 << 4 | n4 >>> 4 & 0xF;
                    long l = Opaque116.f(n5, n6, n7);
                    byte by2 = recordOfValueBuilder_2.L(k);
                    double d8 = Opaque115.a(n5, n6, n7, by, by2, d, d2, d3, d4, d5, d6, d7);
                    if (!(d8 >= 0.0)) continue;
                    eNTITYBlockViewer.a(l, recordOfValueBuilder_2.J(k), by2, d8);
                }
            }
        }
    }

    static double a(long l, byte by, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return Opaque115.a(l, by, (byte)0, d, d2, d3, d4, d5, d6, d7);
    }

    static double a(long l, byte by, byte by2, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return Opaque115.a(Opaque116.c(l), Opaque116.d(l), Opaque116.e(l), by, by2, d, d2, d3, d4, d5, d6, d7);
    }

    private static double a(int n, int n2, int n3, byte by, byte by2, double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = by2 != 0 ? 1.5 : 0.5;
        double d9 = by2 == 1 ? 1.5 : 0.5;
        double d10 = by2 == 2 ? 1.5 : 0.5;
        double d11 = (double)n + d8;
        double d12 = (double)n2 + d9;
        double d13 = (double)n3 + d10;
        double d14 = Opaque115.c(d, d11 - d8, d11 + d8);
        double d15 = Opaque115.c(d2, d12 - d9, d12 + d9);
        double d16 = Opaque115.c(d3, d13 - d10, d13 + d10);
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
        if (!Opaque116.a(d17, d18, d19, d4, d5, d20, d7)) {
            return -1.0;
        }
        return d20;
    }

    private static double c(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }
}
