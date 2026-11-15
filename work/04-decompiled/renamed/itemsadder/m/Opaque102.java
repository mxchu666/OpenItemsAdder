package itemsadder.m;

import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque105;

public final class Opaque102 {
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

    private Opaque102() {
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

    public static FluentBuilder_5 b(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n2;
        if (n == Integer.MIN_VALUE) {
            int n3 = aFS.length;
            if (fluentBuilder_5.offset + n3 > fluentBuilder_5.aFs.length) {
                fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
            }
            System.arraycopy(aFS, 0, fluentBuilder_5.aFs, fluentBuilder_5.offset, n3);
            fluentBuilder_5.offset += n3;
            opaque105.tK += n3;
            return fluentBuilder_5;
        }
        int n4 = n2 = n < 0 ? Opaque102.cz(-n) + 1 : Opaque102.cz(n);
        if (fluentBuilder_5.offset + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        Opaque102.a(n, fluentBuilder_5.offset, n2, fluentBuilder_5.aFs);
        fluentBuilder_5.offset += n2;
        opaque105.tK += n2;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n;
        if (l == Long.MIN_VALUE) {
            int n2 = aFT.length;
            if (fluentBuilder_5.offset + n2 > fluentBuilder_5.aFs.length) {
                fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
            }
            System.arraycopy(aFT, 0, fluentBuilder_5.aFs, fluentBuilder_5.offset, n2);
            fluentBuilder_5.offset += n2;
            opaque105.tK += n2;
            return fluentBuilder_5;
        }
        int n3 = n = l < 0L ? Opaque102.t(-l) + 1 : Opaque102.t(l);
        if (fluentBuilder_5.offset + n > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        Opaque102.a(l, fluentBuilder_5.offset, n, fluentBuilder_5.aFs);
        fluentBuilder_5.offset += n;
        opaque105.tK += n;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(float f, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque102.b(Float.toString(f), opaque105, fluentBuilder_5);
    }

    public static FluentBuilder_5 a(double d, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque102.b(Double.toString(d), opaque105, fluentBuilder_5);
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

    static FluentBuilder_5 a(CharSequence charSequence, int n, int n2, byte[] byArray, int n3, int n4, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
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
                opaque105.tK += n3 - fluentBuilder_5.offset;
                fluentBuilder_5.offset = n3;
                return fluentBuilder_5;
            }
            if (n3 == n4) {
                opaque105.tK += n3 - fluentBuilder_5.offset;
                fluentBuilder_5.offset = n3;
                if (fluentBuilder_5.aFu == null) {
                    n3 = 0;
                    n4 = opaque105.aGD;
                    byArray = new byte[n4];
                    fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                } else {
                    fluentBuilder_5 = fluentBuilder_5.aFu;
                    fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                    byArray = fluentBuilder_5.aFs;
                    n4 = byArray.length;
                }
            } else if (c < '\u0800') {
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0xC0 | c >> 6 & 0x1F);
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            } else if (Character.isHighSurrogate(c) && n < n2 && Character.isLowSurrogate(charSequence.charAt(n))) {
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                int n5 = Character.toCodePoint(c, charSequence.charAt(n));
                byArray[n3++] = (byte)(0xF0 | n5 >> 18 & 7);
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | n5 >> 12 & 0x3F);
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | n5 >> 0 & 0x3F);
                ++n;
            } else {
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0xE0 | c >> 12 & 0xF);
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
                if (n3 == n4) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    if (fluentBuilder_5.aFu == null) {
                        n3 = 0;
                        n4 = opaque105.aGD;
                        byArray = new byte[n4];
                        fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                    } else {
                        fluentBuilder_5 = fluentBuilder_5.aFu;
                        fluentBuilder_5.offset = n3 = fluentBuilder_5.aFt;
                        byArray = fluentBuilder_5.aFs;
                        n4 = byArray.length;
                    }
                }
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            }
            c = '\u0000';
        }
    }

    static FluentBuilder_5 b(CharSequence charSequence, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        byte[] byArray = fluentBuilder_5.aFs;
        char c = '\u0000';
        int n3 = fluentBuilder_5.offset;
        int n4 = n3 + n2;
        while (true) {
            if (n != n2 && (c = charSequence.charAt(n++)) < '\u0080') {
                byArray[n3++] = (byte)c;
                continue;
            }
            if (n == n2 && c < '\u0080') {
                opaque105.tK += n3 - fluentBuilder_5.offset;
                fluentBuilder_5.offset = n3;
                return fluentBuilder_5;
            }
            if (c < '\u0800') {
                if (++n4 > byArray.length) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    return Opaque102.a(charSequence, n - 1, n2, byArray, n3, byArray.length, opaque105, fluentBuilder_5);
                }
                byArray[n3++] = (byte)(0xC0 | c >> 6 & 0x1F);
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            } else if (Character.isHighSurrogate(c) && n < n2 && Character.isLowSurrogate(charSequence.charAt(n))) {
                if ((n4 += 3) > byArray.length) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    return Opaque102.a(charSequence, n - 1, n2, byArray, n3, byArray.length, opaque105, fluentBuilder_5);
                }
                int n5 = Character.toCodePoint(c, charSequence.charAt(n));
                byArray[n3++] = (byte)(0xF0 | n5 >> 18 & 7);
                byArray[n3++] = (byte)(0x80 | n5 >> 12 & 0x3F);
                byArray[n3++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                byArray[n3++] = (byte)(0x80 | n5 >> 0 & 0x3F);
                ++n;
            } else {
                if ((n4 += 2) > byArray.length) {
                    opaque105.tK += n3 - fluentBuilder_5.offset;
                    fluentBuilder_5.offset = n3;
                    return Opaque102.a(charSequence, n - 1, n2, byArray, n3, byArray.length, opaque105, fluentBuilder_5);
                }
                byArray[n3++] = (byte)(0xE0 | c >> 12 & 0xF);
                byArray[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
                byArray[n3++] = (byte)(0x80 | c >> 0 & 0x3F);
            }
            c = '\u0000';
        }
    }

    public static FluentBuilder_5 a(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = charSequence.length();
        if (n == 0) {
            return fluentBuilder_5;
        }
        return fluentBuilder_5.offset + n > fluentBuilder_5.aFs.length ? Opaque102.a(charSequence, 0, n, fluentBuilder_5.aFs, fluentBuilder_5.offset, fluentBuilder_5.aFs.length, opaque105, fluentBuilder_5) : Opaque102.b(charSequence, 0, n, opaque105, fluentBuilder_5);
    }

    public static FluentBuilder_5 b(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = charSequence.length();
        if (n == 0) {
            return fluentBuilder_5;
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n2 = fluentBuilder_5.offset;
        int n3 = fluentBuilder_5.aFs.length;
        opaque105.tK += n;
        if (n2 + n > n3) {
            for (int i = 0; i < n; ++i) {
                if (n2 == n3) {
                    fluentBuilder_5.offset = n2;
                    n2 = 0;
                    n3 = opaque105.aGD;
                    byArray = new byte[n3];
                    fluentBuilder_5 = new FluentBuilder_5(byArray, 0, fluentBuilder_5);
                }
                byArray[n2++] = (byte)charSequence.charAt(i);
            }
        } else {
            for (int i = 0; i < n; ++i) {
                byArray[n2++] = (byte)charSequence.charAt(i);
            }
        }
        fluentBuilder_5.offset = n2;
        return fluentBuilder_5;
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

    public static FluentBuilder_5 c(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        return Opaque102.a(charSequence, false, opaque105, fluentBuilder_5);
    }

    public static FluentBuilder_5 a(CharSequence charSequence, boolean bl, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = opaque105.tK;
        int n2 = charSequence.length();
        int n3 = fluentBuilder_5.offset + 2;
        if (n3 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(n2 + 2 > opaque105.aGD ? n2 + 2 : opaque105.aGD, fluentBuilder_5);
            fluentBuilder_5.offset = 2;
            if (n2 == 0) {
                Opaque102.a(0, fluentBuilder_5.aFs, 0, bl);
                opaque105.tK += 2;
                return fluentBuilder_5;
            }
            FluentBuilder_5 fluentBuilder_52 = Opaque102.b(charSequence, 0, n2, opaque105, fluentBuilder_5);
            Opaque102.a(opaque105.tK - n, fluentBuilder_5.aFs, 0, bl);
            opaque105.tK += 2;
            return fluentBuilder_52;
        }
        if (n2 == 0) {
            Opaque102.a(0, fluentBuilder_5.aFs, fluentBuilder_5.offset, bl);
            fluentBuilder_5.offset = n3;
            opaque105.tK += 2;
            return fluentBuilder_5;
        }
        if (n3 + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = n3;
            FluentBuilder_5 fluentBuilder_53 = Opaque102.a(charSequence, 0, n2, fluentBuilder_5.aFs, n3, fluentBuilder_5.aFs.length, opaque105, fluentBuilder_5);
            Opaque102.a(opaque105.tK - n, fluentBuilder_5.aFs, n3 - 2, bl);
            opaque105.tK += 2;
            return fluentBuilder_53;
        }
        fluentBuilder_5.offset = n3;
        FluentBuilder_5 fluentBuilder_54 = Opaque102.b(charSequence, 0, n2, opaque105, fluentBuilder_5);
        Opaque102.a(opaque105.tK - n, fluentBuilder_5.aFs, n3 - 2, bl);
        opaque105.tK += 2;
        return fluentBuilder_54;
    }

    private static FluentBuilder_5 a(CharSequence charSequence, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n3 = opaque105.tK;
        if (fluentBuilder_5.offset == fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(n2 + 1 > opaque105.aGD ? n2 + 1 : opaque105.aGD, fluentBuilder_5);
            fluentBuilder_5.offset = 1;
            FluentBuilder_5 fluentBuilder_52 = Opaque102.b(charSequence, n, n2, opaque105, fluentBuilder_5);
            fluentBuilder_5.aFs[0] = (byte)(opaque105.tK - n3);
            ++opaque105.tK;
            return fluentBuilder_52;
        }
        int n4 = fluentBuilder_5.offset + 1;
        if (n4 + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = n4;
            byte[] byArray = fluentBuilder_5.aFs;
            FluentBuilder_5 fluentBuilder_53 = Opaque102.a(charSequence, n, n2, byArray, n4, byArray.length, opaque105, fluentBuilder_5);
            byArray[n4 - 1] = (byte)(opaque105.tK - n3);
            ++opaque105.tK;
            return fluentBuilder_53;
        }
        fluentBuilder_5.offset = n4;
        FluentBuilder_5 fluentBuilder_54 = Opaque102.b(charSequence, n, n2, opaque105, fluentBuilder_5);
        fluentBuilder_5.aFs[n4 - 1] = (byte)(opaque105.tK - n3);
        ++opaque105.tK;
        return fluentBuilder_54;
    }

    private static FluentBuilder_5 a(CharSequence charSequence, int n, int n2, int n3, int n4, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n5 = opaque105.tK;
        int n6 = fluentBuilder_5.offset;
        int n7 = n6 + n4;
        if (n7 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(n2 + n4 > opaque105.aGD ? n2 + n4 : opaque105.aGD, fluentBuilder_5);
            n6 = fluentBuilder_5.aFt;
            fluentBuilder_5.offset = n7 = n6 + n4;
            FluentBuilder_5 fluentBuilder_52 = Opaque102.b(charSequence, n, n2, opaque105, fluentBuilder_5);
            int n8 = opaque105.tK - n5;
            if (n8 < n3) {
                System.arraycopy(fluentBuilder_5.aFs, n7, fluentBuilder_5.aFs, n7 - 1, fluentBuilder_5.offset - n7);
                --n4;
                --fluentBuilder_5.offset;
            }
            opaque105.tK += n4;
            while (--n4 > 0) {
                fluentBuilder_5.aFs[n6++] = (byte)(n8 & 0x7F | 0x80);
                n8 >>>= 7;
            }
            fluentBuilder_5.aFs[n6] = (byte)n8;
            return fluentBuilder_52;
        }
        if (n7 + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5.offset = n7;
            FluentBuilder_5 fluentBuilder_53 = Opaque102.a(charSequence, n, n2, fluentBuilder_5.aFs, n7, fluentBuilder_5.aFs.length, opaque105, fluentBuilder_5);
            int n9 = opaque105.tK - n5;
            if (n9 < n3) {
                System.arraycopy(fluentBuilder_5.aFs, n7, fluentBuilder_5.aFs, n7 - 1, fluentBuilder_5.offset - n7);
                --n4;
                --fluentBuilder_5.offset;
            }
            opaque105.tK += n4;
            while (--n4 > 0) {
                fluentBuilder_5.aFs[n6++] = (byte)(n9 & 0x7F | 0x80);
                n9 >>>= 7;
            }
            fluentBuilder_5.aFs[n6] = (byte)n9;
            return fluentBuilder_53;
        }
        fluentBuilder_5.offset = n7;
        FluentBuilder_5 fluentBuilder_54 = Opaque102.b(charSequence, n, n2, opaque105, fluentBuilder_5);
        int n10 = opaque105.tK - n5;
        if (n10 < n3) {
            System.arraycopy(fluentBuilder_5.aFs, n7, fluentBuilder_5.aFs, n7 - 1, fluentBuilder_5.offset - n7);
            --n4;
            --fluentBuilder_5.offset;
        }
        opaque105.tK += n4;
        while (--n4 > 0) {
            fluentBuilder_5.aFs[n6++] = (byte)(n10 & 0x7F | 0x80);
            n10 >>>= 7;
        }
        fluentBuilder_5.aFs[n6] = (byte)n10;
        return fluentBuilder_54;
    }

    public static FluentBuilder_5 d(CharSequence charSequence, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n = charSequence.length();
        if (n == 0) {
            if (fluentBuilder_5.offset == fluentBuilder_5.aFs.length) {
                fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
            }
            fluentBuilder_5.aFs[fluentBuilder_5.offset++] = 0;
            ++opaque105.tK;
            return fluentBuilder_5;
        }
        if (n < 43) {
            return Opaque102.a(charSequence, 0, n, opaque105, fluentBuilder_5);
        }
        if (n < 5462) {
            return Opaque102.a(charSequence, 0, n, 128, 2, opaque105, fluentBuilder_5);
        }
        if (n < 699051) {
            return Opaque102.a(charSequence, 0, n, 16384, 3, opaque105, fluentBuilder_5);
        }
        if (n < 0x5555556) {
            return Opaque102.a(charSequence, 0, n, 0x200000, 4, opaque105, fluentBuilder_5);
        }
        return Opaque102.a(charSequence, 0, n, 0x10000000, 5, opaque105, fluentBuilder_5);
    }

    public static char cA(int n) {
        return (char)((n >>> 10) + 55232);
    }

    public static char cB(int n) {
        return (char)((n & 0x3FF) + 56320);
    }
}
