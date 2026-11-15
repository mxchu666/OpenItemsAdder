package itemsadder.m;

import itemsadder.m.bks;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;

public final class bkt {
    static final boolean aGc = Boolean.getBoolean("io.protostuff.cesu8_compat");

    private bkt() {
    }

    public static String x(byte[] byArray) {
        return bkt.k(byArray, 0, byArray.length);
    }

    public static String k(byte[] byArray, int n, int n2) {
        String string;
        try {
            string = new String(byArray, n, n2, "UTF-8");
            if (aGc && string.indexOf(65533) != -1) {
                try {
                    return bkt.l(byArray, n, n2);
                }
                catch (UTFDataFormatException uTFDataFormatException) {
                    return string;
                }
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
        return string;
    }

    static String y(byte[] byArray) {
        try {
            return bkt.l(byArray, 0, byArray.length);
        }
        catch (UTFDataFormatException uTFDataFormatException) {
            throw new RuntimeException(uTFDataFormatException);
        }
    }

    public static byte[] jA(String string) {
        try {
            return string.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }

    private static String l(byte[] byArray, int n, int n2) {
        int n3;
        int n4;
        char[] cArray = new char[n2];
        int n5 = 0;
        for (n4 = 0; n4 < n2 && (n3 = byArray[n + n4] & 0xFF) <= 127; ++n4) {
            cArray[n5++] = (char)n3;
        }
        while (n4 < n2) {
            byte by;
            byte by2;
            n3 = byArray[n + n4] & 0xFF;
            int n6 = n3 >> 4;
            if (n6 <= 7) {
                cArray[n5++] = (char)n3;
                ++n4;
                continue;
            }
            if (n6 == 12 || n6 == 13) {
                if ((n4 += 2) > n2) {
                    throw new UTFDataFormatException("Malformed input: Partial character at end");
                }
                by2 = byArray[n + n4 - 1];
                if ((by2 & 0xC0) != 128) {
                    throw new UTFDataFormatException("Malformed input around byte " + n4);
                }
                cArray[n5++] = (char)((n3 & 0x1F) << 6 | by2 & 0x3F);
                continue;
            }
            if (n6 == 14) {
                if ((n4 += 3) > n2) {
                    throw new UTFDataFormatException("Malformed input: Partial character at end");
                }
                by2 = byArray[n + n4 - 2];
                by = byArray[n + n4 - 1];
                if ((by2 & 0xC0) != 128 || (by & 0xC0) != 128) {
                    throw new UTFDataFormatException("Malformed input around byte " + (n4 - 1));
                }
                cArray[n5++] = (char)((n3 & 0xF) << 12 | (by2 & 0x3F) << 6 | by & 0x3F);
                continue;
            }
            n6 = n3 >> 3;
            if (n6 == 30) {
                if ((n4 += 4) > n2) {
                    throw new UTFDataFormatException("Malformed input: Partial character at end");
                }
                by2 = byArray[n + n4 - 3];
                by = byArray[n + n4 - 2];
                byte by3 = byArray[n + n4 - 1];
                int n7 = (n3 & 7) << 18 | (by2 & 0x3F) << 12 | (by & 0x3F) << 6 | by3 & 0x3F;
                cArray[n5++] = bks.cA(n7);
                cArray[n5++] = bks.cB(n7);
                continue;
            }
            throw new UTFDataFormatException("Malformed input at byte " + n4);
        }
        return new String(cArray, 0, n5);
    }
}
