package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.biz;
import itemsadder.m.bjl;
import itemsadder.m.bjm;
import itemsadder.m.bjo;
import itemsadder.m.bjq;
import itemsadder.m.bjz;
import itemsadder.m.bkb;
import itemsadder.m.bkd;
import itemsadder.m.bke;
import itemsadder.m.bkf;
import itemsadder.m.bko;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class bkc {
    private bkc() {
    }

    public static bjz w(byte[] byArray) {
        return bkc.j(byArray, 0, byArray.length);
    }

    public static bjz j(byte[] byArray, int n, int n2) {
        biw biw2 = new biw(byArray, n, n2, false);
        return new bkd(biw2);
    }

    public static bjz g(InputStream inputStream) {
        biz biz2 = new biz(inputStream, false);
        return new bke(biz2);
    }

    public static void a(byte[] byArray, Object object, bko bko2) {
        bjl.a(byArray, 0, byArray.length, object, bko2, false);
    }

    public static void a(byte[] byArray, int n, int n2, Object object, bko bko2) {
        bjl.a(byArray, n, n2, object, bko2, false);
    }

    public static void a(InputStream inputStream, Object object, bko bko2) {
        bjl.a(inputStream, object, bko2, false);
    }

    public static void a(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        bjl.a(inputStream, bjq2.aFs, object, bko2, false);
    }

    public static int b(InputStream inputStream, Object object, bko bko2) {
        return bjl.b(inputStream, object, bko2, false);
    }

    public static int b(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        return bjl.b(inputStream, bjq2.aFs, object, bko2, false);
    }

    public static int a(DataInput dataInput, Object object, bko bko2) {
        return bjl.a(dataInput, object, bko2, false);
    }

    public static byte[] a(Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkf bkf2 = new bkf(bjq2);
        try {
            bko2.a(bkf2, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
        }
        return bkf2.GE();
    }

    public static int a(bjq bjq2, Object object, bko bko2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkf bkf2 = new bkf(bjq2);
        try {
            bko2.a(bkf2, object);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a LinkedBuffer threw an IOException (should never happen).", iOException);
        }
        return bkf2.GD();
    }

    public static int a(OutputStream outputStream, Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkf bkf2 = new bkf(bjq2);
        bko2.a(bkf2, object);
        return bjq.a(outputStream, bjq2);
    }

    public static int b(OutputStream outputStream, Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkf bkf2 = new bkf(bjq2);
        bko2.a(bkf2, object);
        int n = bkf2.GD();
        bkf.a(outputStream, n);
        int n2 = bjq.a(outputStream, bjq2);
        assert (n == n2);
        return n;
    }

    public static int a(DataOutput dataOutput, Object object, bko bko2) {
        bjq bjq2 = new bjq(256);
        bkf bkf2 = new bkf(bjq2);
        bko2.a(bkf2, object);
        int n = bkf2.GD();
        bkf.a(dataOutput, n);
        int n2 = bjq.a(dataOutput, bjq2);
        assert (n == n2);
        return n;
    }

    public static int a(OutputStream outputStream, List list, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkf bkf2 = new bkf(bjq2);
        int n = 0;
        for (Object e : list) {
            bko2.a(bkf2, e);
            int n2 = bkf2.GD();
            bkf.a(outputStream, n2);
            int n3 = bjq.a(outputStream, bjq2);
            assert (n2 == n3);
            n += n2;
            bkf2.Gr();
        }
        return n;
    }

    public static List a(InputStream inputStream, bko bko2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        byte[] byArray = null;
        int n = 0;
        bjo bjo2 = null;
        int n2 = inputStream.read();
        while (n2 != -1) {
            int n3;
            Object object = bko2.wi();
            arrayList.add(object);
            int n4 = n3 = n2 < 128 ? n2 : biz.c(inputStream, n2);
            if (n3 != 0) {
                bjm bjm2;
                if (n3 > 4096) {
                    if (bjo2 == null) {
                        bjo2 = new bjo(inputStream);
                    }
                    bjm2 = new biz(bjo2.co(n3), false);
                    bko2.a(bjm2, object);
                    ((biz)bjm2).cc(0);
                } else {
                    if (n < n3) {
                        byArray = new byte[n3];
                        n = n3;
                    }
                    bjl.a(inputStream, byArray, 0, n3);
                    bjm2 = new biw(byArray, 0, n3, false);
                    try {
                        bko2.a(bjm2, object);
                    }
                    catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                        throw bkb.b(arrayIndexOutOfBoundsException);
                    }
                    ((biw)bjm2).cc(0);
                }
            }
            n2 = inputStream.read();
        }
        return arrayList;
    }

    public static boolean c(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        return bkc.a(inputStream, object, bko2, true, bjq2);
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
        biw biw2 = new biw(bjq2.aFs, bjq2.offset, n, false);
        try {
            bko2.a(biw2, object);
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
        bkf bkf2 = new bkf(bjq2);
        bjq2.offset = bjq2.aFt + 5;
        bkf2.tK += 5;
        bko2.a(bkf2, object);
        int n = bkf2.tK - 5;
        int n2 = bjl.a(n, bjq2.aFs, bjq2.aFt);
        outputStream.write(bjq2.aFs, n2, bjq2.offset - n2);
        if (bjq2.aFu != null) {
            bjq.a(outputStream, bjq2.aFu);
        }
        return n;
    }
}
