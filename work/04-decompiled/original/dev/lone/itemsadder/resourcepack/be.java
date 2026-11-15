package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.bf;
import dev.lone.itemsadder.resourcepack.bg;
import dev.lone.itemsadder.resourcepack.bh;
import dev.lone.itemsadder.resourcepack.bi;
import dev.lone.itemsadder.resourcepack.bj;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

final class be {
    static final int avc = 0x8000000;
    static final int avd = 0x4000000;
    static final int ave = 0x10000000;
    private static final byte[] avf = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int avg = be.fz("IHDR");
    private static final int avh = be.fz("PLTE");
    private static final int avi = be.fz("IDAT");
    private static final int avj = be.fz("IEND");
    private static final int avk = be.fz("iaPR");
    private static final byte[] avl = new byte[]{73, 65, 80, 1};
    private static final int avm = -1513885317;
    private static final byte[] avn = new byte[]{90, 107, 124, -115};

    private be() {
    }

    static String d(byte[] byArray) {
        if (byArray.length < 24) {
            return "truncated PNG header";
        }
        if (!Arrays.equals(avf, Arrays.copyOf(byArray, avf.length))) {
            return "invalid PNG signature";
        }
        if (be.c(byArray, 8) != 13 || be.c(byArray, 12) != avg) {
            return "IHDR must be the first PNG chunk";
        }
        if (be.b(byArray, 16) == 0L || be.b(byArray, 20) == 0L) {
            return "PNG width and height must be positive";
        }
        return null;
    }

    static long e(byte[] byArray) {
        return be.b(byArray, 16);
    }

    static long f(byte[] byArray) {
        return be.b(byArray, 20);
    }

    static bi g(byte[] byArray) {
        return be.a(byArray, true);
    }

    static bi a(byte[] byArray, boolean bl) {
        Objects.requireNonNull(byArray, "input");
        if (!bl) {
            return new bi(bj.NOT_NEEDED, byArray, "disabled");
        }
        if (byArray.length > 0x8000000) {
            return new bi(bj.UNSUPPORTED_FORMAT, byArray, "PNG exceeds size limit");
        }
        try {
            bg bg2 = be.h(byArray);
            byte[] byArray2 = be.a(byArray, bg2);
            if (bg2.zS()) {
                be.i(byArray2);
            }
            be.a(byArray2, bg2.zR());
            if (bg2.zS()) {
                return new bi(bj.ALREADY_PROCESSED, byArray, "already processed");
            }
            byte[] byArray3 = (byte[])byArray.clone();
            be.b(byArray3, bg2);
            return new bi(bj.APPLIED, be.c(byArray3, bg2), "protected");
        }
        catch (bh bh2) {
            return new bi(bh2.avw, byArray, bh2.getMessage());
        }
    }

    private static bg h(byte[] byArray) {
        int n;
        if (byArray.length < avf.length || !Arrays.equals(avf, Arrays.copyOf(byArray, avf.length))) {
            throw be.fA("invalid PNG signature");
        }
        ArrayList<bf> arrayList = new ArrayList<bf>();
        int n2 = avf.length;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        long l = 0L;
        long l2 = -1L;
        int n3 = -1;
        int n4 = -1;
        while (n2 < byArray.length) {
            if (byArray.length - n2 < 12) {
                throw be.fA("truncated PNG chunk");
            }
            long l3 = be.b(byArray, n2);
            if (l3 > 0x4000000L) {
                throw be.fB("PNG chunk exceeds size limit");
            }
            n = (int)l3;
            long l4 = (long)n2 + 12L + (long)n;
            if (l4 > (long)byArray.length) {
                throw be.fA("truncated PNG chunk");
            }
            int n5 = be.c(byArray, n2 + 4);
            be.bf(n5);
            int n6 = n2 + 8;
            int n7 = n6 + n;
            bf bf2 = new bf(n5, n6, n, n7);
            if (!bl && n5 != avg) {
                throw be.fA("IHDR must be the first chunk");
            }
            if (n5 == avg) {
                if (bl || n != 13) {
                    throw be.fA("invalid IHDR chunk");
                }
                bl = true;
                long l5 = be.b(byArray, n6);
                long l6 = be.b(byArray, n6 + 4);
                n4 = byArray[n6 + 8] & 0xFF;
                n3 = byArray[n6 + 9] & 0xFF;
                l2 = be.a(l5, l6, n4, n3, byArray[n6 + 10] & 0xFF, byArray[n6 + 11] & 0xFF, byArray[n6 + 12] & 0xFF);
            } else if (n5 == avh) {
                if (bl2 || bl3 || n == 0 || n % 3 != 0 || n > 768) {
                    throw be.fA("invalid PLTE chunk");
                }
                bl2 = true;
                if (n3 == 3 && n / 3 > 1 << n4) {
                    throw be.fA("PLTE has too many entries");
                }
                if (n3 == 0 || n3 == 4) {
                    throw be.fA("PLTE is not allowed for this color type");
                }
            } else if (n5 == avi) {
                if (bl4) {
                    throw be.fB("non-consecutive IDAT chunks");
                }
                bl3 = true;
                if ((l += (long)n) > 0x8000000L) {
                    throw be.fB("IDAT payload exceeds size limit");
                }
            } else if (n5 == avk) {
                if (bl6 || !bl3 || n != avl.length || !be.a(byArray, n6, avl)) {
                    throw be.fB("unsupported ItemsAdder PNG marker");
                }
                bl6 = true;
                bl4 = true;
            } else if (n5 == avj) {
                if (bl5 || !bl3 || n != 0) {
                    throw be.fA("invalid IEND chunk");
                }
                bl5 = true;
                bl4 = true;
            } else {
                if (be.bg(n5)) {
                    throw be.fB("unknown critical PNG chunk " + be.bi(n5));
                }
                if (bl3) {
                    bl4 = true;
                }
            }
            arrayList.add(bf2);
            n2 = (int)l4;
            if (!bl5 || n2 == byArray.length) continue;
            throw be.fA("data found after IEND");
        }
        if (!(bl && bl3 && bl5 && l >= 6L)) {
            throw be.fA("missing required PNG chunks");
        }
        if (n3 == 3 && !bl2) {
            throw be.fA("indexed PNG is missing PLTE");
        }
        for (bf bf3 : arrayList) {
            int n8;
            n = be.a(byArray, bf3.zM() - 4, bf3.zN() + 4);
            int n9 = be.c(byArray, bf3.zO());
            if (n9 == (n8 = bl6 && bf3.zL() != avk ? n ^ 0xA5C3F17B : n)) continue;
            throw be.fA("invalid CRC for " + be.bi(bf3.zL()));
        }
        return new bg(List.copyOf(arrayList), (int)l, (int)l2, bl6);
    }

    private static long a(long l, long l2, int n, int n2, int n3, int n4, int n5) {
        long l3;
        boolean bl;
        if (l == 0L || l2 == 0L || n3 != 0 || n4 != 0 || n5 != 0 && n5 != 1) {
            throw be.fB("unsupported IHDR layout");
        }
        int n6 = switch (n2) {
            case 0, 3 -> 1;
            case 2 -> 3;
            case 4 -> 2;
            case 6 -> 4;
            default -> throw be.fB("unsupported PNG color type");
        };
        switch (n2) {
            case 0: {
                boolean bl2;
                if (n == 1 || n == 2 || n == 4 || n == 8 || n == 16) {
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 3: {
                boolean bl2;
                if (n == 1 || n == 2 || n == 4 || n == 8) {
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            default: {
                boolean bl2 = bl = n == 8 || n == 16;
            }
        }
        if (!bl) {
            throw be.fB("unsupported PNG bit depth");
        }
        long l4 = (long)n6 * (long)n;
        if (n5 == 0) {
            l3 = be.a(l, l2, l4);
        } else {
            int[] nArray = new int[]{0, 4, 0, 2, 0, 1, 0};
            int[] nArray2 = new int[]{0, 0, 4, 0, 2, 0, 1};
            int[] nArray3 = new int[]{8, 8, 4, 4, 2, 2, 1};
            int[] nArray4 = new int[]{8, 8, 8, 4, 4, 2, 2};
            l3 = 0L;
            try {
                for (int i = 0; i < 7; ++i) {
                    long l5 = be.c(l, nArray[i], nArray3[i]);
                    long l6 = be.c(l2, nArray2[i], nArray4[i]);
                    if (l5 == 0L || l6 == 0L) continue;
                    l3 = Math.addExact(l3, be.a(l5, l6, l4));
                }
            }
            catch (ArithmeticException arithmeticException) {
                throw be.fB("PNG dimensions exceed size limit");
            }
        }
        if (l3 > 0x10000000L) {
            throw be.fB("inflated PNG exceeds size limit");
        }
        return l3;
    }

    private static long a(long l, long l2, long l3) {
        try {
            long l4 = Math.addExact(Math.multiplyExact(l, l3), 7L) / 8L;
            return Math.multiplyExact(Math.addExact(l4, 1L), l2);
        }
        catch (ArithmeticException arithmeticException) {
            throw be.fB("PNG dimensions exceed size limit");
        }
    }

    private static long c(long l, int n, int n2) {
        return l <= (long)n ? 0L : (l - (long)n + (long)n2 - 1L) / (long)n2;
    }

    private static byte[] a(byte[] byArray, bg bg2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bg2.zQ());
        for (bf bf2 : bg2.zP()) {
            if (bf2.zL() != avi) continue;
            byteArrayOutputStream.write(byArray, bf2.zM(), bf2.zN());
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(byte[] byArray, int n) {
        Inflater inflater = new Inflater();
        byte[] byArray2 = new byte[8192];
        int n2 = 0;
        try {
            inflater.setInput(byArray);
            while (!inflater.finished()) {
                int n3 = inflater.inflate(byArray2);
                if ((n2 = Math.addExact(n2, n3)) > n) {
                    throw be.fA("inflated PNG data is larger than expected");
                }
                if (n3 != 0) continue;
                throw be.fA(inflater.needsDictionary() ? "PNG requires a zlib dictionary" : "incomplete PNG zlib stream");
            }
            if (inflater.getRemaining() != 0 || n2 != n) {
                throw be.fA("PNG zlib stream length does not match IHDR");
            }
        }
        catch (ArithmeticException | DataFormatException exception) {
            throw be.fA("invalid PNG zlib stream");
        }
        finally {
            inflater.end();
        }
    }

    private static void b(byte[] byArray, bg bg2) {
        int n = 0;
        int n2 = bg2.zQ() - avn.length;
        for (bf bf2 : bg2.zP()) {
            if (bf2.zL() != avi) continue;
            int n3 = 0;
            while (n3 < bf2.zN()) {
                if (n >= n2) {
                    int n4 = bf2.zM() + n3;
                    byArray[n4] = (byte)(byArray[n4] ^ avn[n - n2]);
                }
                ++n3;
                ++n;
            }
        }
    }

    private static void i(byte[] byArray) {
        for (int i = 0; i < avn.length; ++i) {
            int n = byArray.length - avn.length + i;
            byArray[n] = (byte)(byArray[n] ^ avn[i]);
        }
    }

    private static byte[] c(byte[] byArray, bg bg2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(byArray.length + 16);
        byteArrayOutputStream.write(byArray, 0, avf.length);
        for (bf bf2 : bg2.zP()) {
            if (bf2.zL() == avj) {
                be.a(byteArrayOutputStream, avk, avl);
            }
            be.a(byteArrayOutputStream, bf2.zN());
            byteArrayOutputStream.write(byArray, bf2.zM() - 4, bf2.zN() + 4);
            be.a(byteArrayOutputStream, be.a(byArray, bf2.zM() - 4, bf2.zN() + 4) ^ 0xA5C3F17B);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, int n, byte[] byArray) {
        be.a(byteArrayOutputStream, byArray.length);
        byte[] byArray2 = new byte[]{(byte)(n >>> 24), (byte)(n >>> 16), (byte)(n >>> 8), (byte)n};
        byteArrayOutputStream.writeBytes(byArray2);
        byteArrayOutputStream.writeBytes(byArray);
        CRC32 cRC32 = new CRC32();
        cRC32.update(byArray2);
        cRC32.update(byArray);
        be.a(byteArrayOutputStream, (int)cRC32.getValue());
    }

    private static void bf(int n) {
        for (int i = 24; i >= 0; i -= 8) {
            int n2 = n >>> i & 0xFF;
            if (be.bh(n2)) continue;
            throw be.fA("invalid PNG chunk type");
        }
        if ((n >>> 8 & 0x20) != 0) {
            throw be.fA("invalid PNG reserved chunk bit");
        }
    }

    private static boolean bg(int n) {
        return (n >>> 24 & 0x20) == 0;
    }

    private static boolean bh(int n) {
        return n >= 65 && n <= 90 || n >= 97 && n <= 122;
    }

    private static boolean a(byte[] byArray, int n, byte[] byArray2) {
        if (n < 0 || n + byArray2.length > byArray.length) {
            return false;
        }
        for (int i = 0; i < byArray2.length; ++i) {
            if (byArray[n + i] == byArray2[i]) continue;
            return false;
        }
        return true;
    }

    private static int a(byte[] byArray, int n, int n2) {
        CRC32 cRC32 = new CRC32();
        cRC32.update(byArray, n, n2);
        return (int)cRC32.getValue();
    }

    private static long b(byte[] byArray, int n) {
        return Integer.toUnsignedLong(be.c(byArray, n));
    }

    private static int c(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, int n) {
        byteArrayOutputStream.write(n >>> 24);
        byteArrayOutputStream.write(n >>> 16);
        byteArrayOutputStream.write(n >>> 8);
        byteArrayOutputStream.write(n);
    }

    private static int fz(String string) {
        return string.charAt(0) << 24 | string.charAt(1) << 16 | string.charAt(2) << 8 | string.charAt(3);
    }

    private static String bi(int n) {
        return new String(new byte[]{(byte)(n >>> 24), (byte)(n >>> 16), (byte)(n >>> 8), (byte)n});
    }

    private static bh fA(String string) {
        return new bh(bj.INVALID_PNG, string);
    }

    private static bh fB(String string) {
        return new bh(bj.UNSUPPORTED_FORMAT, string);
    }
}
