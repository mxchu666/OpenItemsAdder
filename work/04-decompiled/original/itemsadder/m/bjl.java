package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.biz;
import itemsadder.m.bjo;
import itemsadder.m.bjq;
import itemsadder.m.bkb;
import itemsadder.m.bkf;
import itemsadder.m.bko;
import itemsadder.m.bkv;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class bjl {
    private bjl() {
    }

    static void a(byte[] byArray, int n, int n2, Object object, bko bko2, boolean bl) {
        try {
            biw biw2 = new biw(byArray, n, n2, bl);
            bko2.a(biw2, object);
            biw2.cc(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new RuntimeException("Truncated.", bkb.b(arrayIndexOutOfBoundsException));
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
        }
    }

    static void a(InputStream inputStream, byte[] byArray, Object object, bko bko2, boolean bl) {
        biz biz2 = new biz(inputStream, byArray, bl);
        bko2.a(biz2, object);
        biz2.cc(0);
    }

    static void a(InputStream inputStream, Object object, bko bko2, boolean bl) {
        biz biz2 = new biz(inputStream, bl);
        bko2.a(biz2, object);
        biz2.cc(0);
    }

    static int b(InputStream inputStream, byte[] byArray, Object object, bko bko2, boolean bl) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw new EOFException("mergeDelimitedFrom");
        }
        int n3 = n = n2 < 128 ? n2 : biz.c(inputStream, n2);
        if (n < 0) {
            throw bkb.Gk();
        }
        if (n != 0) {
            if (n > byArray.length) {
                throw new bkb("size limit exceeded. " + n + " > " + byArray.length);
            }
            bjl.a(inputStream, byArray, 0, n);
            biw biw2 = new biw(byArray, 0, n, bl);
            try {
                bko2.a(biw2, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw bkb.b(arrayIndexOutOfBoundsException);
            }
            biw2.cc(0);
        }
        return n;
    }

    static int b(InputStream inputStream, Object object, bko bko2, boolean bl) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw new EOFException("mergeDelimitedFrom");
        }
        int n3 = n = n2 < 128 ? n2 : biz.c(inputStream, n2);
        if (n < 0) {
            throw bkb.Gk();
        }
        if (n != 0) {
            if (n > 4096) {
                biz biz2 = new biz(new bjo(inputStream, n), bl);
                bko2.a(biz2, object);
                biz2.cc(0);
                return n;
            }
            byte[] byArray = new byte[n];
            bjl.a(inputStream, byArray, 0, n);
            biw biw2 = new biw(byArray, 0, n, bl);
            try {
                bko2.a(biw2, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw bkb.b(arrayIndexOutOfBoundsException);
            }
            biw2.cc(0);
        }
        return n;
    }

    static int a(DataInput dataInput, Object object, bko bko2, boolean bl) {
        int n;
        int n2 = dataInput.readByte();
        int n3 = n = 0 == (n2 & 0x80) ? n2 : biz.a(dataInput, (byte)n2);
        if (n < 0) {
            throw bkb.Gk();
        }
        if (n != 0) {
            if (n > 4096 && dataInput instanceof InputStream) {
                biz biz2 = new biz(new bjo((InputStream)((Object)dataInput), n), bl);
                bko2.a(biz2, object);
                biz2.cc(0);
            } else {
                byte[] byArray = new byte[n];
                dataInput.readFully(byArray, 0, n);
                biw biw2 = new biw(byArray, 0, n, bl);
                try {
                    bko2.a(biw2, object);
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    throw bkb.b(arrayIndexOutOfBoundsException);
                }
                biw2.cc(0);
            }
        }
        if (!bko2.r(object)) {
            throw new bkv(object, bko2);
        }
        return n;
    }

    static void a(InputStream inputStream, byte[] byArray, int n, int n2) {
        int n3 = 0;
        while (n2 > 0) {
            n3 = inputStream.read(byArray, n, n2);
            if (n3 == -1) {
                throw bkb.Gi();
            }
            n2 -= n3;
            n += n3;
        }
    }

    static int a(InputStream inputStream, boolean bl, bjq bjq2) {
        int n;
        int n2;
        int n3;
        int n4;
        byte[] byArray = bjq2.aFs;
        int n5 = bjq2.aFt;
        int n6 = byArray.length - n5;
        int n7 = inputStream.read(byArray, n5, n6);
        if (n7 < 1) {
            throw new EOFException("fillBufferWithDelimitedMessageFrom");
        }
        int n8 = n5 + n7;
        if (0 != ((n4 = byArray[n5++]) & 0x80)) {
            n4 &= 0x7F;
            n3 = 7;
            while (true) {
                block16: {
                    if (n5 == n8) {
                        n7 = inputStream.read(byArray, n8, n6 - (n8 - bjq2.aFt));
                        if (n7 < 1) {
                            throw new EOFException("fillBufferWithDelimitedMessageFrom");
                        }
                        n8 += n7;
                    }
                    n2 = byArray[n5++];
                    n4 |= (n2 & 0x7F) << n3;
                    if (0 == (n2 & 0x80)) break;
                    if (n3 == 28) {
                        n = 0;
                        do {
                            if (n5 == n8) {
                                n7 = inputStream.read(byArray, n8, n6 - (n8 - bjq2.aFt));
                                if (n7 < 1) {
                                    throw new EOFException("fillBufferWithDelimitedMessageFrom");
                                }
                                n8 += n7;
                            }
                            if (byArray[n5++] >= 0) break block16;
                        } while (5 != ++n);
                        throw bkb.Gl();
                    }
                }
                n3 += 7;
            }
        }
        if (n4 == 0) {
            if (n5 != n8) {
                throw bkb.Gj();
            }
            return n4;
        }
        if (n4 < 0) {
            throw bkb.Gk();
        }
        n3 = n8 - n5;
        if (n3 < n4) {
            n2 = n5 - bjq2.aFt;
            if (n4 + n2 > n6) {
                if (!bl) {
                    return n4;
                }
                for (n = n4 - n3; n > 0; n -= n7) {
                    n7 = inputStream.read(byArray, bjq2.aFt, Math.min(n, n6));
                    if (n7 >= 1) continue;
                    throw new EOFException("fillBufferWithDelimitedMessageFrom");
                }
                return n4;
            }
            bjl.a(inputStream, byArray, n8, n4 - n3);
        }
        bjq2.offset = n5;
        return n4;
    }

    static int a(int n, byte[] byArray, int n2) {
        switch (bkf.cx(n)) {
            case 1: {
                byArray[n2 + 4] = (byte)n;
                return n2 + 4;
            }
            case 2: {
                byArray[n2 + 3] = (byte)(n & 0x7F | 0x80);
                byArray[n2 + 4] = (byte)(n >>> 7);
                return n2 + 3;
            }
            case 3: {
                byArray[n2 + 2] = (byte)(n & 0x7F | 0x80);
                byArray[n2 + 3] = (byte)(n >>> 7 & 0x7F | 0x80);
                byArray[n2 + 4] = (byte)(n >>> 14);
                return n2 + 2;
            }
            case 4: {
                byArray[n2 + 1] = (byte)(n & 0x7F | 0x80);
                byArray[n2 + 2] = (byte)(n >>> 7 & 0x7F | 0x80);
                byArray[n2 + 3] = (byte)(n >>> 14 & 0x7F | 0x80);
                byArray[n2 + 4] = (byte)(n >>> 21);
                return n2 + 1;
            }
        }
        byArray[n2] = (byte)(n & 0x7F | 0x80);
        byArray[n2 + 1] = (byte)(n >>> 7 & 0x7F | 0x80);
        byArray[n2 + 2] = (byte)(n >>> 14 & 0x7F | 0x80);
        byArray[n2 + 3] = (byte)(n >>> 21 & 0x7F | 0x80);
        byArray[n2 + 4] = (byte)(n >>> 28);
        return n2;
    }
}
