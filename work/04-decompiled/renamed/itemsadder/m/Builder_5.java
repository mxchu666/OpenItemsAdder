package itemsadder.m;

import itemsadder.m.Opaque120;
import itemsadder.m.RecordOfValueBuilder_2;
import itemsadder.m.WorldBridge_3;
import java.util.Arrays;
import java.util.Map;

final class Builder_5 {
    static final Builder_5 tE = new Builder_5(new int[0], new RecordOfValueBuilder_2[0]);
    private final int[] tF;
    private final RecordOfValueBuilder_2[] tG;

    private Builder_5(int[] nArray, RecordOfValueBuilder_2[] recordOfValueBuilder_2Array) {
        this.tF = nArray;
        this.tG = recordOfValueBuilder_2Array;
    }

    private static Builder_5 c(Map map) {
        int[] nArray = map.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();
        RecordOfValueBuilder_2[] recordOfValueBuilder_2Array = new RecordOfValueBuilder_2[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            recordOfValueBuilder_2Array[i] = ((WorldBridge_3)map.get(nArray[i])).hM();
        }
        return new Builder_5(nArray, recordOfValueBuilder_2Array);
    }

    Builder_5 a(int n, short s, int n2, byte by) {
        RecordOfValueBuilder_2 recordOfValueBuilder_2;
        int n3 = Arrays.binarySearch(this.tF, n);
        RecordOfValueBuilder_2 recordOfValueBuilder_22 = n3 < 0 ? RecordOfValueBuilder_2.tO : this.tG[n3];
        if (recordOfValueBuilder_22 == (recordOfValueBuilder_2 = recordOfValueBuilder_22.a(s, n2, by))) {
            return this;
        }
        if (n3 >= 0 && recordOfValueBuilder_2.isEmpty()) {
            int[] nArray = new int[this.tF.length - 1];
            RecordOfValueBuilder_2[] recordOfValueBuilder_2Array = new RecordOfValueBuilder_2[this.tG.length - 1];
            System.arraycopy(this.tF, 0, nArray, 0, n3);
            System.arraycopy(this.tF, n3 + 1, nArray, n3, nArray.length - n3);
            System.arraycopy(this.tG, 0, recordOfValueBuilder_2Array, 0, n3);
            System.arraycopy(this.tG, n3 + 1, recordOfValueBuilder_2Array, n3, recordOfValueBuilder_2Array.length - n3);
            return nArray.length == 0 ? tE : new Builder_5(nArray, recordOfValueBuilder_2Array);
        }
        if (n3 >= 0) {
            RecordOfValueBuilder_2[] recordOfValueBuilder_2Array = (RecordOfValueBuilder_2[])this.tG.clone();
            recordOfValueBuilder_2Array[n3] = recordOfValueBuilder_2;
            return new Builder_5(this.tF, recordOfValueBuilder_2Array);
        }
        int n4 = -n3 - 1;
        int[] nArray = new int[this.tF.length + 1];
        RecordOfValueBuilder_2[] recordOfValueBuilder_2Array = new RecordOfValueBuilder_2[this.tG.length + 1];
        System.arraycopy(this.tF, 0, nArray, 0, n4);
        System.arraycopy(this.tF, n4, nArray, n4 + 1, this.tF.length - n4);
        System.arraycopy(this.tG, 0, recordOfValueBuilder_2Array, 0, n4);
        System.arraycopy(this.tG, n4, recordOfValueBuilder_2Array, n4 + 1, this.tG.length - n4);
        nArray[n4] = n;
        recordOfValueBuilder_2Array[n4] = recordOfValueBuilder_2;
        return new Builder_5(nArray, recordOfValueBuilder_2Array);
    }

    private Builder_5 a(int n, Opaque120 opaque120) {
        int n2 = Arrays.binarySearch(this.tF, n);
        if (n2 < 0) {
            return this;
        }
        RecordOfValueBuilder_2 recordOfValueBuilder_2 = this.tG[n2];
        RecordOfValueBuilder_2 recordOfValueBuilder_22 = recordOfValueBuilder_2.a(opaque120.ua, opaque120.ub, opaque120.tK);
        if (recordOfValueBuilder_2 == recordOfValueBuilder_22) {
            return this;
        }
        RecordOfValueBuilder_2[] recordOfValueBuilder_2Array = (RecordOfValueBuilder_2[])this.tG.clone();
        recordOfValueBuilder_2Array[n2] = recordOfValueBuilder_22;
        return new Builder_5(this.tF, recordOfValueBuilder_2Array);
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

    RecordOfValueBuilder_2 D(int n) {
        return this.tG[n];
    }

    RecordOfValueBuilder_2 E(int n) {
        int n2 = Arrays.binarySearch(this.tF, n);
        return n2 < 0 ? null : this.tG[n2];
    }
}
