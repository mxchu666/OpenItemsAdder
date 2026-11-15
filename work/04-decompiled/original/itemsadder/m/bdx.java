package itemsadder.m;

import itemsadder.m.bdu;
import itemsadder.m.bdw;
import itemsadder.m.bea;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class bdx {
    public static byte[] bT(int n) {
        return bdx.bU(n);
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
        return bdx.k(byArray);
    }

    public static String a(RandomAccessFile randomAccessFile, int n) {
        byte[] byArray = new byte[n];
        randomAccessFile.read(byArray);
        return new String(byArray);
    }

    public static String a(RandomAccessFile randomAccessFile, long l) {
        int n = bdx.a(randomAccessFile);
        if ((long)n > l || n < 0) {
            throw new IOException("String length is invalid! wtf? " + n);
        }
        return bdx.a(randomAccessFile, n);
    }

    public static bea a(RandomAccessFile randomAccessFile, int n, int n2, int n3) {
        int n4;
        int n5;
        randomAccessFile.seek(n + n2);
        byte[] byArray = new byte[Math.min(16384, n3)];
        bea bea2 = new bea(byArray.length);
        while (randomAccessFile.getFilePointer() < (long)(n + n2 + n3) && (n5 = randomAccessFile.read(byArray, 0, Math.min(n4 = n3 - bea2.size(), byArray.length))) > 0) {
            bea2.write(byArray, 0, n5);
        }
        return bea2;
    }

    public static bea a(RandomAccessFile randomAccessFile, bdu bdu2, bdw bdw2) {
        return bdx.a(randomAccessFile, bdu2.aBT, bdw2.aBX, bdw2.aBY);
    }
}
