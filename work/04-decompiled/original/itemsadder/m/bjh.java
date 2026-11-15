package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.biz;
import itemsadder.m.bjf;
import itemsadder.m.bjg;
import itemsadder.m.bjj;
import itemsadder.m.bjl;
import itemsadder.m.bjo;
import itemsadder.m.bjq;
import itemsadder.m.bkb;
import itemsadder.m.bkf;
import itemsadder.m.bkk;
import itemsadder.m.bko;
import itemsadder.m.bkv;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class bjh {
    private bjh() {
    }

    public static void a(byte[] byArray, Object object, bko bko2) {
        bjh.a(byArray, 0, byArray.length, object, bko2);
    }

    public static void a(byte[] byArray, int n, int n2, Object object, bko bko2) {
        try {
            biw biw2 = new biw(byArray, n, n2, true);
            bjf bjf2 = new bjf(biw2);
            bko2.a(bjf2, object);
            biw2.cc(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new RuntimeException("Truncated.", bkb.b(arrayIndexOutOfBoundsException));
        }
        catch (IOException iOException) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
        }
    }

    public static void a(biz biz2, Object object, bko bko2) {
        bjg bjg2 = new bjg(biz2);
        bko2.a(bjg2, object);
        biz2.cc(0);
    }

    public static void a(InputStream inputStream, Object object, bko bko2) {
        biz biz2 = new biz(inputStream, true);
        bjh.a(biz2, object, bko2);
    }

    public static void a(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        biz biz2 = new biz(inputStream, bjq2.aFs, true);
        bjg bjg2 = new bjg(biz2);
        bko2.a(bjg2, object);
        biz2.cc(0);
    }

    public static int b(InputStream inputStream, Object object, bko bko2) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw bkb.Gi();
        }
        int n3 = n = n2 < 128 ? n2 : biz.c(inputStream, n2);
        if (n < 0) {
            throw bkb.Gk();
        }
        if (n != 0) {
            if (n > 4096) {
                biz biz2 = new biz(new bjo(inputStream, n), true);
                bjg bjg2 = new bjg(biz2);
                bko2.a(bjg2, object);
                biz2.cc(0);
                return n;
            }
            byte[] byArray = new byte[n];
            bjl.a(inputStream, byArray, 0, n);
            biw biw2 = new biw(byArray, 0, n, true);
            bjf bjf2 = new bjf(biw2);
            try {
                bko2.a(bjf2, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw bkb.b(arrayIndexOutOfBoundsException);
            }
            biw2.cc(0);
        }
        return n;
    }

    public static int b(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        int n;
        int n2 = inputStream.read();
        if (n2 == -1) {
            throw bkb.Gi();
        }
        byte[] byArray = bjq2.aFs;
        int n3 = n = n2 < 128 ? n2 : biz.c(inputStream, n2);
        if (n < 0) {
            throw bkb.Gk();
        }
        if (n != 0) {
            if (n > byArray.length) {
                throw new bkb("size limit exceeded. " + n + " > " + byArray.length);
            }
            bjl.a(inputStream, byArray, 0, n);
            biw biw2 = new biw(byArray, 0, n, true);
            bjf bjf2 = new bjf(biw2);
            try {
                bko2.a(bjf2, object);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw bkb.b(arrayIndexOutOfBoundsException);
            }
            biw2.cc(0);
        }
        return n;
    }

    public static int a(DataInput dataInput, Object object, bko bko2) {
        int n;
        int n2 = dataInput.readByte();
        int n3 = n = 0 == (n2 & 0x80) ? n2 : biz.a(dataInput, (byte)n2);
        if (n < 0) {
            throw bkb.Gk();
        }
        if (n != 0) {
            if (n > 4096 && dataInput instanceof InputStream) {
                biz biz2 = new biz(new bjo((InputStream)((Object)dataInput), n), true);
                bjg bjg2 = new bjg(biz2);
                bko2.a(bjg2, object);
                biz2.cc(0);
            } else {
                byte[] byArray = new byte[n];
                dataInput.readFully(byArray, 0, n);
                biw biw2 = new biw(byArray, 0, n, true);
                bjf bjf2 = new bjf(biw2);
                try {
                    bko2.a(bjf2, object);
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

    public static byte[] a(Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2);
        bjj bjj2 = new bjj(bkk2);
        try {
            bko2.a(bjj2, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
        }
        return bkk2.GE();
    }

    public static int a(bjq bjq2, Object object, bko bko2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2);
        bjj bjj2 = new bjj(bkk2);
        try {
            bko2.a(bjj2, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a LinkedBuffer threw an IOException (should never happen).", iOException);
        }
        return bkk2.GD();
    }

    public static int a(OutputStream outputStream, Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2, outputStream);
        bjj bjj2 = new bjj(bkk2);
        bko2.a(bjj2, object);
        bjq.a(outputStream, bjq2);
        return bkk2.tK;
    }

    public static int b(OutputStream outputStream, Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2);
        bjj bjj2 = new bjj(bkk2);
        bko2.a(bjj2, object);
        bkf.a(outputStream, bkk2.tK);
        bjq.a(outputStream, bjq2);
        return bkk2.tK;
    }

    public static int a(DataOutput dataOutput, Object object, bko bko2) {
        bjq bjq2 = new bjq(256);
        bkk bkk2 = new bkk(bjq2);
        bjj bjj2 = new bjj(bkk2);
        bko2.a(bjj2, object);
        bkf.a(dataOutput, bkk2.tK);
        bjq.a(dataOutput, bjq2);
        return bkk2.tK;
    }

    public static boolean c(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        return bjh.a(inputStream, object, bko2, true, bjq2);
    }

    public static boolean a(InputStream inputStream, Object object, bko bko2, boolean bl, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        int n = bjl.a(inputStream, bl, bjq2);
        if (n == 0) {
            return true;
        }
        if (bjq2.aFt == bjq2.offset) {
            return false;
        }
        biw biw2 = new biw(bjq2.aFs, bjq2.offset, n, true);
        bjf bjf2 = new bjf(biw2);
        try {
            bko2.a(bjf2, object);
            biw2.cc(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw bkb.b(arrayIndexOutOfBoundsException);
        }
        finally {
            bjq2.offset = bjq2.aFt;
        }
        return true;
    }

    public static int c(OutputStream outputStream, Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2);
        bjj bjj2 = new bjj(bkk2);
        bjq2.offset = bjq2.aFt + 5;
        bkk2.tK += 5;
        bko2.a(bjj2, object);
        int n = bkk2.tK - 5;
        int n2 = bjl.a(n, bjq2.aFs, bjq2.aFt);
        outputStream.write(bjq2.aFs, n2, bjq2.offset - n2);
        if (bjq2.aFu != null) {
            bjq.a(outputStream, bjq2.aFu);
        }
        return n;
    }
}
