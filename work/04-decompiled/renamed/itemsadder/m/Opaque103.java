package itemsadder.m;

public final class Opaque103 {
    public static final int aGk = 0;
    public static final int aGl = 1;
    public static final int aGm = 2;
    public static final int aGn = 3;
    public static final int aGo = 4;
    public static final int aGp = 5;
    public static final int aGq = 6;
    public static final int aGr = 7;
    static final int aGs = 3;
    static final int aGt = 7;
    static final int aGu = 1;
    static final int aGv = 2;
    static final int aGw = 3;
    static final int aGx = Opaque103.K(1, 3);
    static final int aGy = Opaque103.K(1, 4);
    static final int aGz = Opaque103.K(2, 0);
    static final int aGA = Opaque103.K(3, 2);

    private Opaque103() {
    }

    public static int cF(int n) {
        return n & 7;
    }

    public static int cG(int n) {
        return n >>> 3;
    }

    public static int K(int n, int n2) {
        return n << 3 | n2;
    }
}
