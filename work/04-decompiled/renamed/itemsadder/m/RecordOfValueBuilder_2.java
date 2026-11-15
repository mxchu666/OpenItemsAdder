package itemsadder.m;

import itemsadder.m.RecordOfValue_19;
import itemsadder.m.WorldBridge_2;
import java.util.Arrays;

final class RecordOfValueBuilder_2 {
    static final RecordOfValueBuilder_2 tO = new RecordOfValueBuilder_2(new short[0], new int[0], new byte[0]);
    private final short[] tP;
    private final int[] tQ;
    private final byte[] tR;
    private final short[] tS;
    private final int[] tT;
    private final byte[] tU;
    private final byte[] tV;

    private RecordOfValueBuilder_2(short[] sArray, int[] nArray, byte[] byArray) {
        this(sArray, nArray, byArray, RecordOfValueBuilder_2.b(sArray, nArray, byArray));
    }

    private RecordOfValueBuilder_2(short[] sArray, int[] nArray, byte[] byArray, RecordOfValue_19 recordOfValue_19) {
        this.tP = sArray;
        this.tQ = nArray;
        this.tR = byArray;
        this.tS = recordOfValue_19.tW;
        this.tT = recordOfValue_19.tX;
        this.tU = recordOfValue_19.tY;
        this.tV = recordOfValue_19.tZ;
    }

    private RecordOfValueBuilder_2 a(short s, int n, byte by) {
        int n2 = Arrays.binarySearch(this.tP, s);
        if (n2 >= 0) {
            if (n == -1) {
                short[] sArray = new short[this.tP.length - 1];
                int[] nArray = new int[this.tQ.length - 1];
                byte[] byArray = new byte[this.tR.length - 1];
                System.arraycopy(this.tP, 0, sArray, 0, n2);
                System.arraycopy(this.tP, n2 + 1, sArray, n2, sArray.length - n2);
                System.arraycopy(this.tQ, 0, nArray, 0, n2);
                System.arraycopy(this.tQ, n2 + 1, nArray, n2, nArray.length - n2);
                System.arraycopy(this.tR, 0, byArray, 0, n2);
                System.arraycopy(this.tR, n2 + 1, byArray, n2, byArray.length - n2);
                return sArray.length == 0 ? tO : this.a(sArray, nArray, byArray);
            }
            if (this.tQ[n2] == n && this.tR[n2] == by) {
                return this;
            }
            int[] nArray = this.tQ;
            byte[] byArray = this.tR;
            if (this.tQ[n2] != n) {
                nArray = (int[])this.tQ.clone();
                nArray[n2] = n;
            }
            if (this.tR[n2] != by) {
                byArray = (byte[])this.tR.clone();
                byArray[n2] = by;
            }
            return this.a(this.tP, nArray, byArray);
        }
        if (n == -1) {
            return this;
        }
        int n3 = -n2 - 1;
        short[] sArray = new short[this.tP.length + 1];
        int[] nArray = new int[this.tQ.length + 1];
        byte[] byArray = new byte[this.tR.length + 1];
        System.arraycopy(this.tP, 0, sArray, 0, n3);
        System.arraycopy(this.tP, n3, sArray, n3 + 1, this.tP.length - n3);
        System.arraycopy(this.tQ, 0, nArray, 0, n3);
        System.arraycopy(this.tQ, n3, nArray, n3 + 1, this.tQ.length - n3);
        System.arraycopy(this.tR, 0, byArray, 0, n3);
        System.arraycopy(this.tR, n3, byArray, n3 + 1, this.tR.length - n3);
        sArray[n3] = s;
        nArray[n3] = n;
        byArray[n3] = by;
        return this.a(sArray, nArray, byArray);
    }

    private RecordOfValueBuilder_2 a(short[] sArray, int[] nArray, byte[] byArray) {
        return new RecordOfValueBuilder_2(sArray, nArray, byArray);
    }

    RecordOfValueBuilder_2 a(short[] sArray, byte[] byArray, int n) {
        byte[] byArray2 = null;
        for (int i = 0; i < n; ++i) {
            int n2 = Arrays.binarySearch(this.tP, sArray[i]);
            if (n2 < 0 || this.tR[n2] == byArray[i]) continue;
            if (byArray2 == null) {
                byArray2 = (byte[])this.tR.clone();
            }
            byArray2[n2] = byArray[i];
        }
        return byArray2 == null ? this : new RecordOfValueBuilder_2(this.tP, this.tQ, byArray2);
    }

    boolean isEmpty() {
        return this.tP.length == 0;
    }

    int size() {
        return this.tP.length;
    }

    int a(short s) {
        int n = this.b(s);
        return n == -1 ? -1 : WorldBridge_2.B(n);
    }

    private int b(short s) {
        int n = Arrays.binarySearch(this.tP, s);
        return n < 0 ? -1 : this.tQ[n];
    }

    byte c(short s) {
        int n = Arrays.binarySearch(this.tP, s);
        return n < 0 ? (byte)0 : this.tR[n];
    }

    short F(int n) {
        return this.tP[n];
    }

    int G(int n) {
        return WorldBridge_2.B(this.tQ[n]);
    }

    byte H(int n) {
        return this.tR[n];
    }

    int hO() {
        return this.tS.length;
    }

    short I(int n) {
        return this.tS[n];
    }

    int J(int n) {
        return this.tT[n];
    }

    byte K(int n) {
        return this.tU[n];
    }

    byte L(int n) {
        return this.tV[n];
    }

    private static RecordOfValue_19 b(short[] sArray, int[] nArray, byte[] byArray) {
        int[] nArray2 = new int[4096];
        Arrays.fill(nArray2, -1);
        byte[] byArray2 = new byte[4096];
        for (int i = 0; i < sArray.length; ++i) {
            int n = sArray[i] & 0xFFF;
            nArray2[n] = nArray[i];
            byArray2[n] = byArray[i];
        }
        long[] lArray = new long[sArray.length];
        boolean[] blArray = new boolean[4096];
        int n = RecordOfValueBuilder_2.a(lArray, nArray2, byArray2, blArray, (byte)1, 0);
        n = RecordOfValueBuilder_2.a(lArray, nArray2, byArray2, blArray, (byte)2, n);
        for (int i = 0; i < nArray2.length; ++i) {
            if (nArray2[i] == -1 || blArray[i]) continue;
            lArray[n++] = RecordOfValueBuilder_2.a((short)i, WorldBridge_2.B(nArray2[i]), byArray2[i], (byte)0);
        }
        Arrays.sort(lArray, 0, n);
        short[] sArray2 = new short[n];
        int[] nArray3 = new int[n];
        byte[] byArray3 = new byte[n];
        byte[] byArray4 = new byte[n];
        for (int i = 0; i < n; ++i) {
            sArray2[i] = (short)(lArray[i] >>> 40);
            nArray3[i] = (int)(lArray[i] >>> 8);
            byArray3[i] = (byte)(lArray[i] >>> 2 & 0x3FL);
            byArray4[i] = (byte)(lArray[i] & 3L);
        }
        return new RecordOfValue_19(sArray2, nArray3, byArray3, byArray4);
    }

    private static int a(long[] lArray, int[] nArray, byte[] byArray, boolean[] blArray, byte by, int n) {
        int n2 = 3;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j <= 16 - n2; j += n2) {
                for (int k = 0; k <= 16 - n2; k += n2) {
                    int n3;
                    int n4 = RecordOfValueBuilder_2.a(by, k, j, i);
                    if (nArray[n4] == -1 || !WorldBridge_2.s(nArray[n4]) || !RecordOfValueBuilder_2.a(nArray, blArray, n3 = WorldBridge_2.B(nArray[n4]), k, j, i, n2, by)) continue;
                    byte by2 = 0;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        for (int i3 = 0; i3 < n2; ++i3) {
                            int n5 = RecordOfValueBuilder_2.a(by, k + i3, j + i2, i);
                            blArray[n5] = true;
                            by2 = (byte)(by2 | byArray[n5]);
                        }
                    }
                    lArray[n++] = RecordOfValueBuilder_2.a((short)n4, n3, by2, by);
                }
            }
        }
        return n;
    }

    private static int a(byte by, int n, int n2, int n3) {
        return by == 1 ? n | n3 << 4 | n2 << 8 : n | n2 << 4 | n3 << 8;
    }

    private static boolean a(int[] nArray, boolean[] blArray, int n, int n2, int n3, int n4, int n5, byte by) {
        for (int i = 0; i < n5; ++i) {
            for (int j = 0; j < n5; ++j) {
                int n6 = RecordOfValueBuilder_2.a(by, n2 + j, n3 + i, n4);
                if (nArray[n6] != -1 && !blArray[n6] && WorldBridge_2.B(nArray[n6]) == n && WorldBridge_2.s(nArray[n6])) continue;
                return false;
            }
        }
        return true;
    }

    private static long a(short s, int n, byte by, byte by2) {
        return (long)(s & 0xFFFF) << 40 | ((long)n & 0xFFFFFFFFL) << 8 | (long)(by & 0x3F) << 2 | (long)by2;
    }
}
