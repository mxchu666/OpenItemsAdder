package itemsadder.m;

import itemsadder.m.IntData_2;
import itemsadder.m.Opaque030;
import itemsadder.m.Opaque034;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class Opaque031 {
    public static byte[] bT(int n) {
        return Opaque031.bU(n);
    }

    public static int k(byte[] byArray) {
        return byArray[3] & 0xFF | (byArray[2] & 0xFF) << 8 | (byArray[1] & 0xFF) << 16 | (byArray[0] & 0xFF) << 24;
    }

    public static byte[] bU(int n) {
        return new byte[]{(byte)(n >> 24 & 0xFF), (byte)(n >> 16 & 0xFF), (byte)(n >> 8 & 0xFF), (byte)(n & 0xFF)};
    }

    public static int a(RandomAccessFile randomAccessFile) {
        byte[] byArray = new byte[4];
        randomAccessFile.read(byArray);
        return Opaque031.k(byArray);
    }

    public static String a(RandomAccessFile randomAccessFile, int n) {
        byte[] byArray = new byte[n];
        randomAccessFile.read(byArray);
        return new String(byArray);
    }

    public static String a(RandomAccessFile randomAccessFile, long l) {
        int n = Opaque031.a(randomAccessFile);
        if ((long)n > l || n < 0) {
            throw new IOException("String length is invalid! wtf? " + n);
        }
        return Opaque031.a(randomAccessFile, n);
    }

    public static Opaque034 a(RandomAccessFile randomAccessFile, int n, int n2, int n3) {
        int n4;
        int n5;
        randomAccessFile.seek(n + n2);
        byte[] byArray = new byte[Math.min(16384, n3)];
        Opaque034 opaque034 = new Opaque034(byArray.length);
        while (randomAccessFile.getFilePointer() < (long)(n + n2 + n3) && (n5 = randomAccessFile.read(byArray, 0, Math.min(n4 = n3 - opaque034.size(), byArray.length))) > 0) {
            opaque034.write(byArray, 0, n5);
        }
        return opaque034;
    }

    public static Opaque034 a(RandomAccessFile randomAccessFile, Opaque030 opaque030, IntData_2 intData_2) {
        return Opaque031.a(randomAccessFile, opaque030.aBT, intData_2.aBX, intData_2.aBY);
    }
}
