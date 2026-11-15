package itemsadder.m;

import itemsadder.m.bjq;
import itemsadder.m.blf;

public final class bks {
    static final int[] aFO = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] aFP = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] aFQ = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] aFR = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final byte[] aFS = new byte[]{45, 50, 49, 52, 55, 52, 56, 51, 54, 52, 56};
    static final byte[] aFT = new byte[]{45, 57, 50, 50, 51, 51, 55, 50, 48, 51, 54, 56, 53, 52, 55, 55, 53, 56, 48, 56};
    static final int aFU = 128;
    static final int aFV = 43;
    static final int aFW = 16384;
    static final int aFX = 5462;
    static final int aFY = 0x200000;
    static final int aFZ = 699051;
    static final int aGa = 0x10000000;
    static final int aGb = 0x5555556;

    private bks() {
    }

    static void a(int n, int n2, int n3, byte[] byArray) {
        int n4;
        int n5;
        int n6 = n2 + n3;
        int n7 = 0;
        if (n < 0) {
            n7 = 45;
            n = -n;
        }
        while (n >= 65536) {
            n5 = n / 100;
            n4 = n - ((n5 << 6) + (n5 << 5) + (n5 << 2));
            n = n5;
            byArray[--n6] = (byte)aFQ[n4];
            byArray[--n6] = (byte)aFP[n4];
        }
        do {
            n5 = n * 52429 >>> 19;
            n4 = n - ((n5 << 3) + (n5 << 1));
            byArray[--n6] = (byte)aFR[n4];
        } while ((n = n5) != 0);
        if (n7 != 0) {
            byArray[--n6] = (byte)n7;
        }
    }

    static void a(long l, int n, int n2, byte[] byArray) {
        int n3;
        int n4;
        int n5 = n + n2;
        int n6 = 0;
        if (l < 0L) {
            n6 = 45;
            l = -l;
        }
        while (l > Integer.MAX_VALUE) {
            long l2 = l / 100L;
            n4 = (int)(l - ((l2 << 6) + (l2 << 5) + (l2 << 2)));
            l = l2;
            byArray[--n5] = (byte)aFQ[n4];
            byArray[--n5] = (byte)aFP[n4];
        }
        int n7 = (int)l;
        while (n7 >= 65536) {
            n3 = n7 / 100;
            n4 = n7 - ((n3 << 6) + (n3 << 5) + (n3 << 2));
            n7 = n3;
            byArray[--n5] = (byte)aFQ[n4];
            byArray[--n5] = (byte)aFP[n4];
        }
        do {
            n3 = n7 * 52429 >>> 19;
            n4 = n7 - ((n3 << 3) + (n3 << 1));
            byArray[--n5] = (byte)aFR[n4];
        } while ((n7 = n3) != 0);
        if (n6 != 0) {
            byArray[--n5] = (byte)n6;
        }
    }

    static int cz(int n) {
        int n2 = 0;
        while (n > aFO[n2]) {
            ++n2;
        }
        return n2 + 1;
    }

    static int t(long l) {
        long l2 = 10L;
        for (int i = 1; i < 19; ++i) {
            if (l < l2) {
                return i;
            }
            l2 = 10L * l2;
        }
        return 19;
    }

    public static bjq b(int n, blf blf2, bjq bjq2) {
        int n2;
        if (n == Integer.MIN_VALUE) {
            int n3 = aFS.length;
            if (bjq2.offset + n3 > bjq2.aFs.length) {
                bjq2 = new bjq(blf2.aGD, bjq2);
            }
            System.arraycopy(aFS, 0, bjq2.aFs, bjq2.offset, n3);
            bjq2.offset += n3;
            blf2.tK += n3;
            return bjq2;
        }
        int n4 = n2 = n < 0 ? bks.cz(-n) + 1 : bks.cz(n);
        if (bjq2.offset + n2 > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        bks.a(n, bjq2.offset, n2, bjq2.aFs);
        bjq2.offset += n2;
        blf2.tK += n2;
        return bjq2;
    }

    public static bjq a(long l, blf blf2, bjq bjq2) {
        int n;
        if (l == Long.MIN_VALUE) {
            int n2 = aFT.length;
            if (bjq2.offset + n2 > bjq2.aFs.length) {
                bjq2 = new bjq(blf2.aGD, bjq2);
            }
            System.arraycopy(aFT, 0, bjq2.aFs, bjq2.offset, n2);
            bjq2.offset += n2;
            blf2.tK += n2;
            return bjq2;
        }
        int n3 = n = l < 0L ? bks.t(-l) + 1 : bks.t(l);
        if (bjq2.offset + n > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        bks.a(l, bjq2.offset, n, bjq2.aFs);
        bjq2.offset += n;
        blf2.tK += n;
        return bjq2;
    }

    public static bjq a(float f, blf blf2, bjq bjq2) {
        return bks.b(Float.toString(f), blf2, bjq2);
    }

    public static bjq a(double d, blf blf2, bjq bjq2) {
        return bks.b(Double.toString(d), blf2, bjq2);
    }

    public static int a(CharSequence charSequence, int n, int n2) {
        int n3 = n2;
        for (int i = n; i < n2; ++i) {
            char c = charSequence.charAt(i);
            if (c < '\u0080') continue;
            if (c < '\u0800') {
                ++n3;
                continue;
            }
            n3 += 2;
        }
        return n3;
    }

    static bjq a(CharSequence charSequence, int n, int n2, byte[] byArray, int n3, int n4, blf blf2, bjq bjq2) {
        char c = '\u0000';
        while (true) {
            if (n != n2 && n3 != n4) {
                char c2 = charSequence.charAt(n++);
                c = c2;
                if (c2 < '\u0080') {
                    byArray[n3++] = (byte)c;
                    continue;
                }
            }
            if (n == n2 && c < '\u0080') {
                blf2.tK += n3 - bjq2.offset;
                bjq2.offset = n3;
                return bjq2;
            }
            if (n3 == n4) {
                blf2.tK += n3 - bjq2.offset;
                bjq2.offset = n3;
                if (bjq2.aFu == null) {
                    n3 = 0;
                    n4 = blf2.aGD;
                    byArray = new byte[n4];
                    bjq2 = new bjq(byArray, 0, bjq2);
                } else {
                    bjq2 = bjq2.aFu;
                    bjq2.offset = n3 = bjq2.aFt;
                    byArray = bjq2.aFs;
                    n4 = byArray.length;
                }
            } else if (c < '\u0800') {
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0xC0 | c >> 6 & 0x1F);
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            } else if (Character.isHighSurrogate(c) && n < n2 && Character.isLowSurrogate(charSequence.charAt(n))) {
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                int n5 = Character.toCodePoint(c, charSequence.charAt(n));
                byArray[n3++] = (byte)(0xF0 | n5 >> 18 & 7);
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | n5 >> 12 & 0x3F);
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | n5 >> 0 & 0x3F);
                ++n;
            } else {
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0xE0 | c >> 12 & 0xF);
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
                if (n3 == n4) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    if (bjq2.aFu == null) {
                        n3 = 0;
                        n4 = blf2.aGD;
                        byArray = new byte[n4];
                        bjq2 = new bjq(byArray, 0, bjq2);
                    } else {
                        bjq2 = bjq2.aFu;
                        bjq2.offset = n3 = bjq2.aFt;
                        byArray = bjq2.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            }
            c = '\u0000';
        }
    }

    static bjq b(CharSequence charSequence, int n, int n2, blf blf2, bjq bjq2) {
        byte[] byArray = bjq2.aFs;
        char c = '\u0000';
        int n3 = bjq2.offset;
        int n4 = n3 + n2;
        while (true) {
            if (n != n2 && (c = charSequence.charAt(n++)) < '\u0080') {
                byArray[n3++] = (byte)c;
                continue;
            }
            if (n == n2 && c < '\u0080') {
                blf2.tK += n3 - bjq2.offset;
                bjq2.offset = n3;
                return bjq2;
            }
            if (c < '\u0800') {
                if (++n4 > byArray.length) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    return bks.a(charSequence, n - 1, n2, byArray, n3, byArray.length, blf2, bjq2);
                }
                byArray[n3++] = (byte)(0xC0 | c >> 6 & 0x1F);
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            } else if (Character.isHighSurrogate(c) && n < n2 && Character.isLowSurrogate(charSequence.charAt(n))) {
                if ((n4 += 3) > byArray.length) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    return bks.a(charSequence, n - 1, n2, byArray, n3, byArray.length, blf2, bjq2);
                }
                int n5 = Character.toCodePoint(c, charSequence.charAt(n));
                byArray[n3++] = (byte)(0xF0 | n5 >> 18 & 7);
                byArray[n3++] = (byte)(0x80 | n5 >> 12 & 0x3F);
                byArray[n3++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                byArray[n3++] = (byte)(0x80 | n5 >> 0 & 0x3F);
                ++n;
            } else {
                if ((n4 += 2) > byArray.length) {
                    blf2.tK += n3 - bjq2.offset;
                    bjq2.offset = n3;
                    return bks.a(charSequence, n - 1, n2, byArray, n3, byArray.length, blf2, bjq2);
                }
                byArray[n3++] = (byte)(0xE0 | c >> 12 & 0xF);
                byArray[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            }
            c = '\u0000';
        }
    }

    public static bjq a(CharSequence charSequence, blf blf2, bjq bjq2) {
        int n = charSequence.length();
        if (n == 0) {
            return bjq2;
        }
        return bjq2.offset + n > bjq2.aFs.length ? bks.a(charSequence, 0, n, bjq2.aFs, bjq2.offset, bjq2.aFs.length, blf2, bjq2) : bks.b(charSequence, 0, n, blf2, bjq2);
    }

    public static bjq b(CharSequence charSequence, blf blf2, bjq bjq2) {
        int n = charSequence.length();
        if (n == 0) {
            return bjq2;
        }
        byte[] byArray = bjq2.aFs;
        int n2 = bjq2.offset;
        int n3 = bjq2.aFs.length;
        blf2.tK += n;
        if (n2 + n > n3) {
            for (int i = 0; i < n; ++i) {
                if (n2 == n3) {
                    bjq2.offset = n2;
                    n2 = 0;
                    n3 = blf2.aGD;
                    byArray = new byte[n3];
                    bjq2 = new bjq(byArray, 0, bjq2);
                }
                byArray[n2++] = (byte)charSequence.charAt(i);
            }
        } else {
            for (int i = 0; i < n; ++i) {
                byArray[n2++] = (byte)charSequence.charAt(i);
            }
        }
        bjq2.offset = n2;
        return bjq2;
    }

    static void a(int n, byte[] byArray, int n2, boolean bl) {
        if (bl) {
            byArray[n2++] = (byte)n;
            byArray[n2] = (byte)(n >>> 8 & 0xFF);
        } else {
            byArray[n2++] = (byte)(n >>> 8 & 0xFF);
            byArray[n2] = (byte)n;
        }
    }

    public static bjq c(CharSequence charSequence, blf blf2, bjq bjq2) {
        return bks.a(charSequence, false, blf2, bjq2);
    }

    public static bjq a(CharSequence charSequence, boolean bl, blf blf2, bjq bjq2) {
        int n = blf2.tK;
        int n2 = charSequence.length();
        int n3 = bjq2.offset + 2;
        if (n3 > bjq2.aFs.length) {
            bjq2 = new bjq(n2 + 2 > blf2.aGD ? n2 + 2 : blf2.aGD, bjq2);
            bjq2.offset = 2;
            if (n2 == 0) {
                bks.a(0, bjq2.aFs, 0, bl);
                blf2.tK += 2;
                return bjq2;
            }
            bjq bjq3 = bks.b(charSequence, 0, n2, blf2, bjq2);
            bks.a(blf2.tK - n, bjq2.aFs, 0, bl);
            blf2.tK += 2;
            return bjq3;
        }
        if (n2 == 0) {
            bks.a(0, bjq2.aFs, bjq2.offset, bl);
            bjq2.offset = n3;
            blf2.tK += 2;
            return bjq2;
        }
        if (n3 + n2 > bjq2.aFs.length) {
            bjq2.offset = n3;
            bjq bjq4 = bks.a(charSequence, 0, n2, bjq2.aFs, n3, bjq2.aFs.length, blf2, bjq2);
            bks.a(blf2.tK - n, bjq2.aFs, n3 - 2, bl);
            blf2.tK += 2;
            return bjq4;
        }
        bjq2.offset = n3;
        bjq bjq5 = bks.b(charSequence, 0, n2, blf2, bjq2);
        bks.a(blf2.tK - n, bjq2.aFs, n3 - 2, bl);
        blf2.tK += 2;
        return bjq5;
    }

    private static bjq a(CharSequence charSequence, int n, int n2, blf blf2, bjq bjq2) {
        int n3 = blf2.tK;
        if (bjq2.offset == bjq2.aFs.length) {
            bjq2 = new bjq(n2 + 1 > blf2.aGD ? n2 + 1 : blf2.aGD, bjq2);
            bjq2.offset = 1;
            bjq bjq3 = bks.b(charSequence, n, n2, blf2, bjq2);
            bjq2.aFs[0] = (byte)(blf2.tK - n3);
            ++blf2.tK;
            return bjq3;
        }
        int n4 = bjq2.offset + 1;
        if (n4 + n2 > bjq2.aFs.length) {
            bjq2.offset = n4;
            byte[] byArray = bjq2.aFs;
            bjq bjq4 = bks.a(charSequence, n, n2, byArray, n4, byArray.length, blf2, bjq2);
            byArray[n4 - 1] = (byte)(blf2.tK - n3);
            ++blf2.tK;
            return bjq4;
        }
        bjq2.offset = n4;
        bjq bjq5 = bks.b(charSequence, n, n2, blf2, bjq2);
        bjq2.aFs[n4 - 1] = (byte)(blf2.tK - n3);
        ++blf2.tK;
        return bjq5;
    }

    private static bjq a(CharSequence charSequence, int n, int n2, int n3, int n4, blf blf2, bjq bjq2) {
        int n5 = blf2.tK;
        int n6 = bjq2.offset;
        int n7 = n6 + n4;
        if (n7 > bjq2.aFs.length) {
            bjq2 = new bjq(n2 + n4 > blf2.aGD ? n2 + n4 : blf2.aGD, bjq2);
            n6 = bjq2.aFt;
            bjq2.offset = n7 = n6 + n4;
            bjq bjq3 = bks.b(charSequence, n, n2, blf2, bjq2);
            int n8 = blf2.tK - n5;
            if (n8 < n3) {
                System.arraycopy(bjq2.aFs, n7, bjq2.aFs, n7 - 1, bjq2.offset - n7);
                --n4;
                --bjq2.offset;
            }
            blf2.tK += n4;
            while (--n4 > 0) {
                bjq2.aFs[n6++] = (byte)(n8 & 0x7F | 0x80);
                n8 >>>= 7;
            }
            bjq2.aFs[n6] = (byte)n8;
            return bjq3;
        }
        if (n7 + n2 > bjq2.aFs.length) {
            bjq2.offset = n7;
            bjq bjq4 = bks.a(charSequence, n, n2, bjq2.aFs, n7, bjq2.aFs.length, blf2, bjq2);
            int n9 = blf2.tK - n5;
            if (n9 < n3) {
                System.arraycopy(bjq2.aFs, n7, bjq2.aFs, n7 - 1, bjq2.offset - n7);
                --n4;
                --bjq2.offset;
            }
            blf2.tK += n4;
            while (--n4 > 0) {
                bjq2.aFs[n6++] = (byte)(n9 & 0x7F | 0x80);
                n9 >>>= 7;
            }
            bjq2.aFs[n6] = (byte)n9;
            return bjq4;
        }
        bjq2.offset = n7;
        bjq bjq5 = bks.b(charSequence, n, n2, blf2, bjq2);
        int n10 = blf2.tK - n5;
        if (n10 < n3) {
            System.arraycopy(bjq2.aFs, n7, bjq2.aFs, n7 - 1, bjq2.offset - n7);
            --n4;
            --bjq2.offset;
        }
        blf2.tK += n4;
        while (--n4 > 0) {
            bjq2.aFs[n6++] = (byte)(n10 & 0x7F | 0x80);
            n10 >>>= 7;
        }
        bjq2.aFs[n6] = (byte)n10;
        return bjq5;
    }

    public static bjq d(CharSequence charSequence, blf blf2, bjq bjq2) {
        int n = charSequence.length();
        if (n == 0) {
            if (bjq2.offset == bjq2.aFs.length) {
                bjq2 = new bjq(blf2.aGD, bjq2);
            }
            bjq2.aFs[bjq2.offset++] = 0;
            ++blf2.tK;
            return bjq2;
        }
        if (n < 43) {
            return bks.a(charSequence, 0, n, blf2, bjq2);
        }
        if (n < 5462) {
            return bks.a(charSequence, 0, n, 128, 2, blf2, bjq2);
        }
        if (n < 699051) {
            return bks.a(charSequence, 0, n, 16384, 3, blf2, bjq2);
        }
        if (n < 0x5555556) {
            return bks.a(charSequence, 0, n, 0x200000, 4, blf2, bjq2);
        }
        return bks.a(charSequence, 0, n, 0x10000000, 5, blf2, bjq2);
    }

    public static char cA(int n) {
        return (char)((n >>> 10) + 55232);
    }

    public static char cB(int n) {
        return (char)((n & 0x3FF) + 56320);
    }
}
