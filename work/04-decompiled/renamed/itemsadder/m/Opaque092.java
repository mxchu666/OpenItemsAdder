package itemsadder.m;

import java.nio.ByteBuffer;

public final class Opaque092 {
    private Opaque092() {
    }

    public static void b(int n, byte[] byArray, int n2) {
        byArray[n2++] = (byte)(n >>> 8 & 0xFF);
        byArray[n2] = (byte)n;
    }

    public static void c(int n, byte[] byArray, int n2) {
        byArray[n2++] = (byte)n;
        byArray[n2] = (byte)(n >>> 8 & 0xFF);
    }

    public static void a(int n, ByteBuffer byteBuffer) {
        byteBuffer.put((byte)n);
        byteBuffer.put((byte)(n >>> 8 & 0xFF));
    }

    public static void d(int n, byte[] byArray, int n2) {
        byArray[n2++] = (byte)(n >>> 24 & 0xFF);
        byArray[n2++] = (byte)(n >>> 16 & 0xFF);
        byArray[n2++] = (byte)(n >>> 8 & 0xFF);
        byArray[n2] = (byte)(n >>> 0 & 0xFF);
    }

    public static void e(int n, byte[] byArray, int n2) {
        byArray[n2++] = (byte)(n >>> 0 & 0xFF);
        byArray[n2++] = (byte)(n >>> 8 & 0xFF);
        byArray[n2++] = (byte)(n >>> 16 & 0xFF);
        byArray[n2] = (byte)(n >>> 24 & 0xFF);
    }

    public static void b(int n, ByteBuffer byteBuffer) {
        byteBuffer.put((byte)(n >>> 0 & 0xFF));
        byteBuffer.put((byte)(n >>> 8 & 0xFF));
        byteBuffer.put((byte)(n >>> 16 & 0xFF));
        byteBuffer.put((byte)(n >>> 24 & 0xFF));
    }

    public static void a(long l, byte[] byArray, int n) {
        byArray[n++] = (byte)(l >>> 56);
        byArray[n++] = (byte)(l >>> 48);
        byArray[n++] = (byte)(l >>> 40);
        byArray[n++] = (byte)(l >>> 32);
        byArray[n++] = (byte)(l >>> 24);
        byArray[n++] = (byte)(l >>> 16);
        byArray[n++] = (byte)(l >>> 8);
        byArray[n] = (byte)(l >>> 0);
    }

    public static void b(long l, byte[] byArray, int n) {
        byArray[n++] = (byte)(l >>> 0);
        byArray[n++] = (byte)(l >>> 8);
        byArray[n++] = (byte)(l >>> 16);
        byArray[n++] = (byte)(l >>> 24);
        byArray[n++] = (byte)(l >>> 32);
        byArray[n++] = (byte)(l >>> 40);
        byArray[n++] = (byte)(l >>> 48);
        byArray[n] = (byte)(l >>> 56);
    }

    public static void a(long l, ByteBuffer byteBuffer) {
        byteBuffer.put((byte)(l >>> 0));
        byteBuffer.put((byte)(l >>> 8));
        byteBuffer.put((byte)(l >>> 16));
        byteBuffer.put((byte)(l >>> 24));
        byteBuffer.put((byte)(l >>> 32));
        byteBuffer.put((byte)(l >>> 40));
        byteBuffer.put((byte)(l >>> 48));
        byteBuffer.put((byte)(l >>> 56));
    }
}
