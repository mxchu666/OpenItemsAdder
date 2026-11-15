package itemsadder.m;

import java.math.BigInteger;

public final class bkw {
    public static final long aGf = -1L;
    static final long aGg = 0xFFFFFFFFL;
    private static final long[] aGh = new long[37];
    private static final int[] aGi = new int[37];
    private static final int[] aGj = new int[37];

    private bkw() {
    }

    private static int cC(int n) {
        return n ^ Integer.MIN_VALUE;
    }

    private static long u(long l) {
        return l ^ Long.MIN_VALUE;
    }

    private static long cD(int n) {
        return (long)n & 0xFFFFFFFFL;
    }

    public static int jB(String string) {
        return bkw.x(string, 10);
    }

    private static int x(String string, int n) {
        long l = Long.parseLong(string, n);
        if ((l & 0xFFFFFFFFL) != l) {
            throw new NumberFormatException("Input " + string + " in base " + n + " is not in the range of an unsigned integer");
        }
        return (int)l;
    }

    public static String cE(int n) {
        return bkw.J(n, 10);
    }

    private static int a(long l, long l2) {
        return bkw.b(bkw.u(l), bkw.u(l2));
    }

    private static int b(long l, long l2) {
        return l < l2 ? -1 : (l > l2 ? 1 : 0);
    }

    private static String J(int n, int n2) {
        long l = (long)n & 0xFFFFFFFFL;
        return Long.toString(l, n2);
    }

    private static long c(long l, long l2) {
        long l3;
        if (l2 < 0L) {
            if (bkw.a(l, l2) < 0) {
                return 0L;
            }
            return 1L;
        }
        if (l >= 0L) {
            return l / l2;
        }
        long l4 = l - (l3 = (l >>> 1) / l2 << 1) * l2;
        return l3 + (long)(bkw.a(l4, l2) >= 0 ? 1 : 0);
    }

    private static long d(long l, long l2) {
        long l3;
        if (l2 < 0L) {
            if (bkw.a(l, l2) < 0) {
                return l;
            }
            return l - l2;
        }
        if (l >= 0L) {
            return l % l2;
        }
        long l4 = (l >>> 1) / l2 << 1;
        return l3 - (bkw.a(l3 = l - l4 * l2, l2) >= 0 ? l2 : 0L);
    }

    public static long jC(String string) {
        return bkw.y(string, 10);
    }

    private static long y(String string, int n) {
        if (string.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (n < 2 || n > 36) {
            throw new NumberFormatException("illegal radix: " + n);
        }
        int n2 = aGj[n] - 1;
        long l = 0L;
        for (int i = 0; i < string.length(); ++i) {
            int n3 = Character.digit(string.charAt(i), n);
            if (n3 == -1) {
                throw new NumberFormatException(string);
            }
            if (i > n2 && bkw.d(l, n3, n)) {
                throw new NumberFormatException("Too large for unsigned long: " + string);
            }
            l = l * (long)n + (long)n3;
        }
        return l;
    }

    private static boolean d(long l, int n, int n2) {
        if (l >= 0L) {
            if (l < aGh[n2]) {
                return false;
            }
            if (l > aGh[n2]) {
                return true;
            }
            return n > aGi[n2];
        }
        return true;
    }

    public static String v(long l) {
        return bkw.a(l, 10);
    }

    private static String a(long l, int n) {
        if (n < 2 || n > 36) {
            throw new IllegalArgumentException("Invalid radix: " + n);
        }
        if (l == 0L) {
            return "0";
        }
        char[] cArray = new char[64];
        int n2 = cArray.length;
        if (l < 0L) {
            long l2 = bkw.c(l, n);
            long l3 = l - l2 * (long)n;
            cArray[--n2] = Character.forDigit((int)l3, n);
            l = l2;
        }
        while (l > 0L) {
            cArray[--n2] = Character.forDigit((int)(l % (long)n), n);
            l /= (long)n;
        }
        return new String(cArray, n2, cArray.length - n2);
    }

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; ++i) {
            bkw.aGh[i] = bkw.c(-1L, i);
            bkw.aGi[i] = (int)bkw.d(-1L, i);
            bkw.aGj[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
