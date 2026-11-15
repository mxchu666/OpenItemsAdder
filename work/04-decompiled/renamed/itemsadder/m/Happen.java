package itemsadder.m;

import itemsadder.m.FluentBuilder_3;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque105;

public final class Happen {
    static final byte aEv = 61;
    static final byte[] aEw;
    static final byte[] aEx;

    private Happen() {
    }

    public static byte[] n(byte[] byArray) {
        return Happen.b(byArray, 0, byArray.length);
    }

    public static byte[] b(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[(n2 + 2) / 3 * 4];
        Happen.a(byArray, n, n2, byArray2, 0);
        return byArray2;
    }

    public static char[] o(byte[] byArray) {
        return Happen.c(byArray, 0, byArray.length);
    }

    public static char[] c(byte[] byArray, int n, int n2) {
        char[] cArray = new char[(n2 + 2) / 3 * 4];
        Happen.a(byArray, n, n2, cArray, 0);
        return cArray;
    }

    private static void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        byte by;
        byte by2;
        int n4 = n2 % 3;
        int n5 = n + (n2 - n4);
        while (n < n5) {
            by2 = byArray[n++];
            by = byArray[n++];
            byte by3 = byArray[n++];
            byArray2[n3++] = aEw[by2 >>> 2 & 0x3F];
            byArray2[n3++] = aEw[by2 << 4 & 0x3F | by >>> 4 & 0xF];
            byArray2[n3++] = aEw[by << 2 & 0x3F | by3 >>> 6 & 3];
            byArray2[n3++] = aEw[by3 & 0x3F];
        }
        switch (n4) {
            case 0: {
                break;
            }
            case 1: {
                by2 = byArray[n++];
                byArray2[n3++] = aEw[by2 >>> 2 & 0x3F];
                byArray2[n3++] = aEw[by2 << 4 & 0x3F];
                byArray2[n3++] = 61;
                byArray2[n3++] = 61;
                break;
            }
            case 2: {
                by2 = byArray[n++];
                by = byArray[n++];
                byArray2[n3++] = aEw[by2 >>> 2 & 0x3F];
                byArray2[n3++] = aEw[by2 << 4 & 0x3F | by >>> 4 & 0xF];
                byArray2[n3++] = aEw[by << 2 & 0x3F];
                byArray2[n3++] = 61;
                break;
            }
            default: {
                throw new IllegalStateException("should not happen");
            }
        }
    }

    private static void a(byte[] byArray, int n, int n2, char[] cArray, int n3) {
        byte by;
        byte by2;
        int n4 = n2 % 3;
        int n5 = n + (n2 - n4);
        while (n < n5) {
            by2 = byArray[n++];
            by = byArray[n++];
            byte by3 = byArray[n++];
            cArray[n3++] = (char)aEw[by2 >>> 2 & 0x3F];
            cArray[n3++] = (char)aEw[by2 << 4 & 0x3F | by >>> 4 & 0xF];
            cArray[n3++] = (char)aEw[by << 2 & 0x3F | by3 >>> 6 & 3];
            cArray[n3++] = (char)aEw[by3 & 0x3F];
        }
        switch (n4) {
            case 0: {
                break;
            }
            case 1: {
                by2 = byArray[n++];
                cArray[n3++] = (char)aEw[by2 >>> 2 & 0x3F];
                cArray[n3++] = (char)aEw[by2 << 4 & 0x3F];
                cArray[n3++] = 61;
                cArray[n3++] = 61;
                break;
            }
            case 2: {
                by2 = byArray[n++];
                by = byArray[n++];
                cArray[n3++] = (char)aEw[by2 >>> 2 & 0x3F];
                cArray[n3++] = (char)aEw[by2 << 4 & 0x3F | by >>> 4 & 0xF];
                cArray[n3++] = (char)aEw[by << 2 & 0x3F];
                cArray[n3++] = 61;
                break;
            }
            default: {
                throw new IllegalStateException("should not happen");
            }
        }
    }

    public static FluentBuilder_5 a(byte[] byArray, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n3 = (n2 + 2) / 3 * 4;
        opaque105.tK += n3;
        int n4 = fluentBuilder_5.aFs.length - fluentBuilder_5.offset;
        if (n3 > n4) {
            int n5 = n4 / 4;
            if (n5 == 0) {
                if (n3 > opaque105.aGD) {
                    byte[] byArray2 = new byte[n3];
                    Happen.a(byArray, n, n2, byArray2, 0);
                    return new FluentBuilder_5(opaque105.aGD, new FluentBuilder_5(byArray2, 0, n3, fluentBuilder_5));
                }
                byte[] byArray3 = new byte[opaque105.aGD];
                Happen.a(byArray, n, n2, byArray3, 0);
                return new FluentBuilder_5(byArray3, 0, n3, fluentBuilder_5);
            }
            int n6 = n;
            byte[] byArray4 = fluentBuilder_5.aFs;
            int n7 = fluentBuilder_5.offset;
            while (n5-- > 0) {
                byte by = byArray[n++];
                byte by2 = byArray[n++];
                byte by3 = byArray[n++];
                byArray4[n7++] = aEw[by >>> 2 & 0x3F];
                byArray4[n7++] = aEw[by << 4 & 0x3F | by2 >>> 4 & 0xF];
                byArray4[n7++] = aEw[by2 << 2 & 0x3F | by3 >>> 6 & 3];
                byArray4[n7++] = aEw[by3 & 0x3F];
            }
            n2 -= n - n6;
            fluentBuilder_5.offset = n7;
            if ((n3 -= n7 - fluentBuilder_5.offset) > opaque105.aGD) {
                byte[] byArray5 = new byte[n3];
                Happen.a(byArray, n, n2, byArray5, 0);
                return new FluentBuilder_5(opaque105.aGD, new FluentBuilder_5(byArray5, 0, n3, fluentBuilder_5));
            }
            byte[] byArray6 = new byte[opaque105.aGD];
            Happen.a(byArray, n, n2, byArray6, 0);
            return new FluentBuilder_5(byArray6, 0, n3, fluentBuilder_5);
        }
        Happen.a(byArray, n, n2, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += n3;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 b(byte[] byArray, int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n3 = (n2 + 2) / 3 * 4;
        opaque105.tK += n3;
        int n4 = fluentBuilder_5.aFs.length - fluentBuilder_5.offset;
        if (n3 > n4) {
            byte by;
            byte by2;
            byte[] byArray2 = fluentBuilder_5.aFs;
            int n5 = fluentBuilder_5.offset;
            int n6 = n2 % 3;
            int n7 = n4 / 4;
            int n8 = n + (n2 - n6);
            while (n < n8) {
                if (n7 == 0) {
                    n5 = opaque105.m(byArray2, fluentBuilder_5.aFt, n5 - fluentBuilder_5.aFt);
                    n7 = (byArray2.length - n5) / 4;
                }
                by2 = byArray[n++];
                by = byArray[n++];
                byte by3 = byArray[n++];
                byArray2[n5++] = aEw[by2 >>> 2 & 0x3F];
                byArray2[n5++] = aEw[by2 << 4 & 0x3F | by >>> 4 & 0xF];
                byArray2[n5++] = aEw[by << 2 & 0x3F | by3 >>> 6 & 3];
                byArray2[n5++] = aEw[by3 & 0x3F];
                --n7;
            }
            switch (n6) {
                case 0: {
                    break;
                }
                case 1: {
                    if (n7 == 0) {
                        n5 = opaque105.m(byArray2, fluentBuilder_5.aFt, n5 - fluentBuilder_5.aFt);
                    }
                    by2 = byArray[n++];
                    byArray2[n5++] = aEw[by2 >>> 2 & 0x3F];
                    byArray2[n5++] = aEw[by2 << 4 & 0x3F];
                    byArray2[n5++] = 61;
                    byArray2[n5++] = 61;
                    break;
                }
                case 2: {
                    if (n7 == 0) {
                        n5 = opaque105.m(byArray2, fluentBuilder_5.aFt, n5 - fluentBuilder_5.aFt);
                    }
                    by2 = byArray[n++];
                    by = byArray[n++];
                    byArray2[n5++] = aEw[by2 >>> 2 & 0x3F];
                    byArray2[n5++] = aEw[by2 << 4 & 0x3F | by >>> 4 & 0xF];
                    byArray2[n5++] = aEw[by << 2 & 0x3F];
                    byArray2[n5++] = 61;
                    break;
                }
                default: {
                    throw new IllegalStateException("should not happen");
                }
            }
            fluentBuilder_5.offset = n5;
            return fluentBuilder_5;
        }
        Happen.a(byArray, n, n2, fluentBuilder_5.aFs, fluentBuilder_5.offset);
        fluentBuilder_5.offset += n3;
        return fluentBuilder_5;
    }

    public static byte[] p(byte[] byArray) {
        return Happen.d(byArray, 0, byArray.length);
    }

    public static byte[] a(char[] cArray) {
        return Happen.a(cArray, 0, cArray.length);
    }

    public static byte[] d(byte[] byArray, int n, int n2) {
        if (n2 == 0) {
            return FluentBuilder_3.aEI;
        }
        if (n2 % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int n3 = n2;
        int n4 = n + n2;
        while (byArray[--n4] == 61) {
            --n3;
        }
        int n5 = n3 * 3 / 4;
        byte[] byArray2 = new byte[n5];
        Happen.a(byArray, n, n2, byArray2, 0, n5);
        return byArray2;
    }

    public static byte[] a(char[] cArray, int n, int n2) {
        if (n2 == 0) {
            return FluentBuilder_3.aEI;
        }
        if (n2 % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int n3 = n2;
        int n4 = n + n2;
        while (cArray[--n4] == '=') {
            --n3;
        }
        int n5 = n3 * 3 / 4;
        byte[] byArray = new byte[n5];
        Happen.a(cArray, n, n2, byArray, 0, n5);
        return byArray;
    }

    public static int a(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        if (n3 % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int n4 = n3;
        int n5 = n2 + n3;
        while (byArray2[--n5] == 61) {
            --n4;
        }
        int n6 = n4 * 3 / 4;
        assert (byArray.length - n >= n6);
        Happen.a(byArray2, n2, n3, byArray, n, n6);
        return n6;
    }

    private static void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3, int n4) {
        int n5 = n4 / 3 * 3;
        try {
            byte by;
            byte by2;
            byte by3;
            while (n3 < n5) {
                by3 = aEx[byArray[n++]];
                by2 = aEx[byArray[n++]];
                by = aEx[byArray[n++]];
                byte by4 = aEx[byArray[n++]];
                if (by3 < 0 || by2 < 0 || by < 0 || by4 < 0) {
                    throw new IllegalArgumentException("Not B64 encoded");
                }
                byArray2[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                byArray2[n3++] = (byte)(by2 << 4 | by >>> 2);
                byArray2[n3++] = (byte)(by << 6 | by4);
            }
            if (n4 != n3) {
                switch (n4 % 3) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        by3 = aEx[byArray[n++]];
                        by2 = aEx[byArray[n++]];
                        if (by3 < 0 || by2 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        byArray2[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                        break;
                    }
                    case 2: {
                        by3 = aEx[byArray[n++]];
                        by2 = aEx[byArray[n++]];
                        by = aEx[byArray[n++]];
                        if (by3 < 0 || by2 < 0 || by < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        byArray2[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                        byArray2[n3++] = (byte)(by2 << 4 | by >>> 2);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("should not happen");
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IllegalArgumentException("char " + n + " was not B64 encoded");
        }
    }

    private static void a(char[] cArray, int n, int n2, byte[] byArray, int n3, int n4) {
        int n5 = n4 / 3 * 3;
        try {
            byte by;
            byte by2;
            byte by3;
            while (n3 < n5) {
                by3 = aEx[cArray[n++]];
                by2 = aEx[cArray[n++]];
                by = aEx[cArray[n++]];
                byte by4 = aEx[cArray[n++]];
                if (by3 < 0 || by2 < 0 || by < 0 || by4 < 0) {
                    throw new IllegalArgumentException("Not B64 encoded");
                }
                byArray[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                byArray[n3++] = (byte)(by2 << 4 | by >>> 2);
                byArray[n3++] = (byte)(by << 6 | by4);
            }
            if (n4 != n3) {
                switch (n4 % 3) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        by3 = aEx[cArray[n++]];
                        by2 = aEx[cArray[n++]];
                        if (by3 < 0 || by2 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        byArray[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                        break;
                    }
                    case 2: {
                        by3 = aEx[cArray[n++]];
                        by2 = aEx[cArray[n++]];
                        by = aEx[cArray[n++]];
                        if (by3 < 0 || by2 < 0 || by < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        byArray[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                        byArray[n3++] = (byte)(by2 << 4 | by >>> 2);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("should not happen");
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IllegalArgumentException("char " + n + " was not B64 encoded");
        }
    }

    public static byte[] jv(String string) {
        return Happen.d(string, 0, string.length());
    }

    public static byte[] d(String string, int n, int n2) {
        if (n2 == 0) {
            return new byte[0];
        }
        if (n2 % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int n3 = n2;
        int n4 = n + n2;
        while (string.charAt(--n4) == '=') {
            --n3;
        }
        int n5 = n3 * 3 / 4;
        byte[] byArray = new byte[n5];
        Happen.a(string, n, n2, byArray, 0, n5);
        return byArray;
    }

    public static int a(byte[] byArray, int n, String string, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        if (n3 % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
        }
        int n4 = n3;
        int n5 = n2 + n3;
        while (string.charAt(--n5) == '=') {
            --n4;
        }
        int n6 = n4 * 3 / 4;
        assert (byArray.length - n >= n6);
        Happen.a(string, n2, n3, byArray, n, n6);
        return n6;
    }

    private static void a(String string, int n, int n2, byte[] byArray, int n3, int n4) {
        int n5 = n4 / 3 * 3;
        try {
            byte by;
            byte by2;
            byte by3;
            while (n3 < n5) {
                by3 = aEx[string.charAt(n++)];
                by2 = aEx[string.charAt(n++)];
                by = aEx[string.charAt(n++)];
                byte by4 = aEx[string.charAt(n++)];
                if (by3 < 0 || by2 < 0 || by < 0 || by4 < 0) {
                    throw new IllegalArgumentException("Not B64 encoded");
                }
                byArray[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                byArray[n3++] = (byte)(by2 << 4 | by >>> 2);
                byArray[n3++] = (byte)(by << 6 | by4);
            }
            if (n4 != n3) {
                switch (n4 % 3) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        by3 = aEx[string.charAt(n++)];
                        by2 = aEx[string.charAt(n++)];
                        if (by3 < 0 || by2 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        byArray[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                        break;
                    }
                    case 2: {
                        by3 = aEx[string.charAt(n++)];
                        by2 = aEx[string.charAt(n++)];
                        by = aEx[string.charAt(n++)];
                        if (by3 < 0 || by2 < 0 || by < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        byArray[n3++] = (byte)(by3 << 2 | by2 >>> 4);
                        byArray[n3++] = (byte)(by2 << 4 | by >>> 2);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("should not happen");
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IllegalArgumentException("char " + n + " was not B64 encoded");
        }
    }

    static {
        int n;
        aEw = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        aEx = new byte[256];
        for (n = 0; n < 256; ++n) {
            Happen.aEx[n] = -1;
        }
        for (n = 0; n < 64; n = (int)((byte)(n + 1))) {
            Happen.aEx[Happen.aEw[n]] = n;
        }
        Happen.aEx[61] = 0;
    }
}
