package itemsadder.m;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import itemsadder.m.fe;
import java.util.Arrays;

final class ff {
    private final Long2ObjectOpenHashMap so = new Long2ObjectOpenHashMap();
    private volatile fe sp = fe.sn;

    ff() {
    }

    synchronized boolean a(long l, int n, int n2) {
        int n3;
        Int2IntOpenHashMap int2IntOpenHashMap = (Int2IntOpenHashMap)this.so.get(l);
        int n4 = ff.a(int2IntOpenHashMap);
        if (n2 < 0) {
            if (int2IntOpenHashMap == null) {
                return false;
            }
            int2IntOpenHashMap.remove(n);
            if (int2IntOpenHashMap.isEmpty()) {
                this.so.remove(l);
            }
        } else {
            if (int2IntOpenHashMap == null) {
                int2IntOpenHashMap = new Int2IntOpenHashMap();
                this.so.put(l, (Object)int2IntOpenHashMap);
            }
            int2IntOpenHashMap.put(n, Math.min(n2, 9));
        }
        if (n4 != (n3 = ff.a((Int2IntOpenHashMap)this.so.get(l)))) {
            this.sp = this.ht();
        }
        return n4 != n3;
    }

    int f(long l) {
        return this.sp.f(l);
    }

    private static int a(Int2IntOpenHashMap int2IntOpenHashMap) {
        if (int2IntOpenHashMap == null) {
            return -1;
        }
        int n = -1;
        IntIterator intIterator = int2IntOpenHashMap.values().iterator();
        while (intIterator.hasNext()) {
            int n2 = (Integer)intIterator.next();
            n = Math.max(n, n2);
        }
        return n;
    }

    synchronized boolean isEmpty() {
        return this.so.isEmpty();
    }

    fe hs() {
        return this.sp;
    }

    private fe ht() {
        if (this.so.isEmpty()) {
            return fe.sn;
        }
        long[] lArray = new long[this.so.size()];
        int n = 0;
        Object object = this.so.keySet().iterator();
        while (object.hasNext()) {
            long l = (Long)object.next();
            lArray[n++] = l;
        }
        Arrays.sort(lArray);
        object = new byte[lArray.length];
        for (n = 0; n < lArray.length; ++n) {
            object[n] = (LongIterator)((byte)ff.a((Int2IntOpenHashMap)this.so.get(lArray[n])));
        }
        return new fe(lArray, (byte[])object);
    }
}
