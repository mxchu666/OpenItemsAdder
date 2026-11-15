package itemsadder.m;

import itemsadder.m.fo;
import itemsadder.m.fq;
import itemsadder.m.fs;
import java.util.Arrays;
import java.util.Map;

final class fn {
    static final fn tE = new fn(new int[0], new fq[0]);
    private final int[] tF;
    private final fq[] tG;

    private fn(int[] nArray, fq[] fqArray) {
        this.tF = nArray;
        this.tG = fqArray;
    }

    private static fn c(Map map) {
        int[] nArray = map.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();
        fq[] fqArray = new fq[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            fqArray[i] = ((fo)map.get(nArray[i])).hM();
        }
        return new fn(nArray, fqArray);
    }

    fn a(int n, short s, int n2, byte by) {
        fq fq2;
        int n3 = Arrays.binarySearch(this.tF, n);
        fq fq3 = n3 < 0 ? fq.tO : this.tG[n3];
        if (fq3 == (fq2 = fq3.a(s, n2, by))) {
            return this;
        }
        if (n3 >= 0 && fq2.isEmpty()) {
            int[] nArray = new int[this.tF.length - 1];
            fq[] fqArray = new fq[this.tG.length - 1];
            System.arraycopy(this.tF, 0, nArray, 0, n3);
            System.arraycopy(this.tF, n3 + 1, nArray, n3, nArray.length - n3);
            System.arraycopy(this.tG, 0, fqArray, 0, n3);
            System.arraycopy(this.tG, n3 + 1, fqArray, n3, fqArray.length - n3);
            return nArray.length == 0 ? tE : new fn(nArray, fqArray);
        }
        if (n3 >= 0) {
            fq[] fqArray = (fq[])this.tG.clone();
            fqArray[n3] = fq2;
            return new fn(this.tF, fqArray);
        }
        int n4 = -n3 - 1;
        int[] nArray = new int[this.tF.length + 1];
        fq[] fqArray = new fq[this.tG.length + 1];
        System.arraycopy(this.tF, 0, nArray, 0, n4);
        System.arraycopy(this.tF, n4, nArray, n4 + 1, this.tF.length - n4);
        System.arraycopy(this.tG, 0, fqArray, 0, n4);
        System.arraycopy(this.tG, n4, fqArray, n4 + 1, this.tG.length - n4);
        nArray[n4] = n;
        fqArray[n4] = fq2;
        return new fn(nArray, fqArray);
    }

    private fn a(int n, fs fs2) {
        int n2 = Arrays.binarySearch(this.tF, n);
        if (n2 < 0) {
            return this;
        }
        fq fq2 = this.tG[n2];
        fq fq3 = fq2.a(fs2.ua, fs2.ub, fs2.tK);
        if (fq2 == fq3) {
            return this;
        }
        fq[] fqArray = (fq[])this.tG.clone();
        fqArray[n2] = fq3;
        return new fn(this.tF, fqArray);
    }

    boolean isEmpty() {
        return this.tG.length == 0;
    }

    int hL() {
        return this.tG.length;
    }

    int C(int n) {
        return this.tF[n];
    }

    fq D(int n) {
        return this.tG[n];
    }

    fq E(int n) {
        int n2 = Arrays.binarySearch(this.tF, n);
        return n2 < 0 ? null : this.tG[n2];
    }
}
