package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.biz;
import itemsadder.m.bjl;
import itemsadder.m.bjq;
import itemsadder.m.bjz;
import itemsadder.m.bkb;
import itemsadder.m.bkf;
import itemsadder.m.bki;
import itemsadder.m.bkj;
import itemsadder.m.bkk;
import itemsadder.m.bko;
import itemsadder.m.blf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bkh {
    private bkh() {
    }

    public static bjz w(byte[] byArray) {
        return bkh.j(byArray, 0, byArray.length);
    }

    public static bjz j(byte[] byArray, int n, int n2) {
        biw biw2 = new biw(byArray, n, n2, true);
        return new bki(biw2);
    }

    public static bjz g(InputStream inputStream) {
        biz biz2 = new biz(inputStream, true);
        return new bkj(biz2);
    }

    public static void a(byte[] byArray, Object object, bko bko2) {
        bjl.a(byArray, 0, byArray.length, object, bko2, true);
    }

    public static void a(byte[] byArray, int n, int n2, Object object, bko bko2) {
        bjl.a(byArray, n, n2, object, bko2, true);
    }

    public static void a(InputStream inputStream, Object object, bko bko2) {
        bjl.a(inputStream, object, bko2, true);
    }

    public static void a(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        bjl.a(inputStream, bjq2.aFs, object, bko2, true);
    }

    public static int b(InputStream inputStream, Object object, bko bko2) {
        return bjl.b(inputStream, object, bko2, true);
    }

    public static int b(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        return bjl.b(inputStream, bjq2.aFs, object, bko2, true);
    }

    public static int a(DataInput dataInput, Object object, bko bko2) {
        return bjl.a(dataInput, object, bko2, true);
    }

    public static byte[] a(Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2);
        try {
            bko2.a(bkk2, object);
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
        try {
            bko2.a(bkk2, object);
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
        bko2.a(bkk2, object);
        bjq.a(outputStream, bjq2);
        return bkk2.tK;
    }

    public static int b(OutputStream outputStream, Object object, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        bkk bkk2 = new bkk(bjq2);
        bko2.a(bkk2, object);
        bkf.a(outputStream, bkk2.tK);
        bjq.a(outputStream, bjq2);
        return bkk2.tK;
    }

    public static int a(DataOutput dataOutput, Object object, bko bko2) {
        bjq bjq2 = new bjq(256);
        bkk bkk2 = new bkk(bjq2);
        bko2.a(bkk2, object);
        bkf.a(dataOutput, bkk2.tK);
        bjq.a(dataOutput, bjq2);
        return bkk2.tK;
    }

    public static int a(OutputStream outputStream, List list, bko bko2, bjq bjq2) {
        if (bjq2.aFt != bjq2.offset) {
            throw new IllegalArgumentException("Buffer previously used and had not been reset.");
        }
        int n = list.size();
        if (n == 0) {
            return 0;
        }
        bkk bkk2 = new bkk(bjq2, outputStream);
        bkk2.aGG.g(n, (blf)bkk2, bjq2);
        for (Object e : list) {
            bko2.a(bkk2, e);
            bkk2.aGG.a((byte)7, (blf)bkk2, bjq2);
        }
        bjq.a(outputStream, bjq2);
        return bkk2.tK;
    }

    public static List a(InputStream inputStream, bko bko2) {
        int n = inputStream.read();
        if (n == -1) {
            return Collections.emptyList();
        }
        if (n > 127) {
            n = biz.c(inputStream, n);
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        biz biz2 = new biz(inputStream, true);
        for (int i = 0; i < n; ++i) {
            Object object = bko2.wi();
            arrayList.add(object);
            bko2.a(biz2, object);
            biz2.cc(0);
        }
        assert (inputStream.read() == -1);
        return arrayList;
    }

    public static boolean c(InputStream inputStream, Object object, bko bko2, bjq bjq2) {
        return bkh.a(inputStream, object, bko2, true, bjq2);
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
        bkk bkk2 = new bkk(bjq2);
        bjq2.offset = bjq2.aFt + 5;
        bkk2.tK += 5;
        bko2.a(bkk2, object);
        int n = bkk2.tK - 5;
        int n2 = bjl.a(n, bjq2.aFs, bjq2.aFt);
        outputStream.write(bjq2.aFs, n2, bjq2.offset - n2);
        if (bjq2.aFu != null) {
            bjq.a(outputStream, bjq2.aFu);
        }
        return n;
    }
}
