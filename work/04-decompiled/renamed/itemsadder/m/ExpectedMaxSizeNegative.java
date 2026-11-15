package itemsadder.m;

import itemsadder.m.Opaque103;
import itemsadder.m.Opaque105;
import java.util.Map;

final class ExpectedMaxSizeNegative {
    private static final int aFh = 32;
    private static final int aFi = 4;
    private static final int aFj = 0x20000000;
    private transient Object[] aFk;
    private int tK;
    private transient int ayR;

    public ExpectedMaxSizeNegative() {
        this.cm(32);
    }

    public ExpectedMaxSizeNegative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("expectedMaxSize is negative: " + n);
        }
        this.cm(this.cl(n));
    }

    private int cl(int n) {
        int n2;
        int n3 = 3 * n / 2;
        if (n3 > 0x20000000 || n3 < 0) {
            n2 = 0x20000000;
        } else {
            for (n2 = 4; n2 < n3; n2 <<= 1) {
            }
        }
        return n2;
    }

    private void cm(int n) {
        this.ayR = n * 2 / 3;
        this.aFk = new Object[2 * n];
    }

    private static int b(Object object, int n) {
        int n2 = System.identityHashCode(object);
        return (n2 << 1) - (n2 << 8) & n - 1;
    }

    private static int G(int n, int n2) {
        return n + 2 < n2 ? n + 2 : 0;
    }

    public boolean a(int n, Object object, Opaque105 opaque105, int n2) {
        Object object2;
        Object[] objectArray = this.aFk;
        int n3 = objectArray.length;
        int n4 = ExpectedMaxSizeNegative.b(object, n3);
        while ((object2 = objectArray[n4]) != null) {
            if (object2 == object) {
                if (object instanceof Map.Entry && object.getClass().getName().startsWith("java.util")) {
                    return true;
                }
                opaque105.aGC = opaque105.aGG.g((Integer)objectArray[n4 + 1], opaque105, opaque105.aGG.g(Opaque103.K(n2, 6), opaque105, opaque105.aGC));
                return false;
            }
            n4 = ExpectedMaxSizeNegative.G(n4, n3);
        }
        objectArray[n4] = object;
        objectArray[n4 + 1] = n;
        if (++this.tK >= this.ayR) {
            this.cn(n3);
        }
        return true;
    }

    private void cn(int n) {
        int n2 = n * 2;
        Object[] objectArray = this.aFk;
        int n3 = objectArray.length;
        if (n3 == 0x40000000) {
            if (this.ayR == 0x1FFFFFFF) {
                throw new IllegalStateException("Capacity exhausted.");
            }
            this.ayR = 0x1FFFFFFF;
            return;
        }
        if (n3 >= n2) {
            return;
        }
        Object[] objectArray2 = new Object[n2];
        this.ayR = n2 / 3;
        for (int i = 0; i < n3; i += 2) {
            Object object = objectArray[i];
            if (object == null) continue;
            Object object2 = objectArray[i + 1];
            objectArray[i] = null;
            objectArray[i + 1] = null;
            int n4 = ExpectedMaxSizeNegative.b(object, n2);
            while (objectArray2[n4] != null) {
                n4 = ExpectedMaxSizeNegative.G(n4, n2);
            }
            objectArray2[n4] = object;
            objectArray2[n4 + 1] = object2;
        }
        this.aFk = objectArray2;
    }
}
