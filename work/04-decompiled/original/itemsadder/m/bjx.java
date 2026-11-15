package itemsadder.m;

import itemsadder.m.bkt;

public final class bjx {
    private bjx() {
    }

    public static int b(byte[] byArray, int n, int n2, int n3) {
        if (n2 == 0) {
            throw new NumberFormatException(bkt.k(byArray, n, n2));
        }
        if (byArray[n] == 45) {
            if (n2 == 1) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            return bjx.a(byArray, n + 1, n2 - 1, n3, false);
        }
        return bjx.a(byArray, n, n2, n3, true);
    }

    static int a(byte[] byArray, int n, int n2, int n3, boolean bl) {
        int n4 = Integer.MIN_VALUE / n3;
        int n5 = 0;
        int n6 = n;
        int n7 = n + n2;
        while (n6 < n7) {
            int n8;
            if ((n8 = Character.digit(byArray[n6++], n3)) == -1) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            if (n4 > n5) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            int n9 = n5 * n3 - n8;
            if (n9 > n5) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            n5 = n9;
        }
        if (bl && (n5 = -n5) < 0) {
            throw new NumberFormatException(bkt.k(byArray, n, n2));
        }
        return n5;
    }

    public static long c(byte[] byArray, int n, int n2, int n3) {
        if (n2 == 0) {
            throw new NumberFormatException(bkt.k(byArray, n, n2));
        }
        if (byArray[n] == 45) {
            if (n2 == 1) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            return bjx.b(byArray, n + 1, n2 - 1, n3, false);
        }
        return bjx.b(byArray, n, n2, n3, true);
    }

    static long b(byte[] byArray, int n, int n2, int n3, boolean bl) {
        long l = Long.MIN_VALUE / (long)n3;
        long l2 = 0L;
        int n4 = n;
        int n5 = n + n2;
        while (n4 < n5) {
            int n6;
            if ((n6 = Character.digit(byArray[n4++], n3)) == -1) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            if (l > l2) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            long l3 = l2 * (long)n3 - (long)n6;
            if (l3 > l2) {
                throw new NumberFormatException(bkt.k(byArray, n, n2));
            }
            l2 = l3;
        }
        if (bl && (l2 = -l2) < 0L) {
            throw new NumberFormatException(bkt.k(byArray, n, n2));
        }
        return l2;
    }
}
