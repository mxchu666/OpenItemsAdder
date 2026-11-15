package itemsadder.m;

final class ez {
    private ez() {
    }

    static boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d6 - d;
        double d11 = d7 - d2;
        double d12 = d8 - d3;
        double d13 = d10 * d10 + d11 * d11 + d12 * d12;
        return ez.a(d10, d11, d12, d4, d5, d13, d9);
    }

    static boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        if (d6 == 0.0) {
            return true;
        }
        double d8 = d7 * d7;
        if (d2 * d2 >= d8 * d6) {
            return true;
        }
        double d9 = d4 * d4 + d5 * d5;
        if (d9 <= 1.0E-12) {
            return true;
        }
        double d10 = d4 * d + d5 * d3;
        double d11 = d * d + d3 * d3;
        return d10 > 0.0 && d10 * d10 >= d8 * d11 * d9;
    }

    static long f(int n, int n2, int n3) {
        return ((long)n & 0x3FFFFFFL) << 38 | ((long)n3 & 0x3FFFFFFL) << 12 | (long)n2 & 0xFFFL;
    }

    static int c(long l) {
        return (int)(l >> 38);
    }

    static int d(long l) {
        return (int)(l << 52 >> 52);
    }

    static int e(long l) {
        return (int)(l << 26 >> 38);
    }
}
