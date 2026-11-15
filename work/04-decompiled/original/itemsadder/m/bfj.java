package itemsadder.m;

import itemsadder.m.bfk;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class bfj {
    private static final bfk aCV = new bfk();
    private final AtomicReference aCW = new AtomicReference<bfk>(aCV);

    public boolean add(Object object) {
        bfk bfk2;
        bfk bfk3 = new bfk();
        bfk3.aCY = object;
        do {
            bfk3.aCX = bfk2 = (bfk)this.aCW.get();
            bfk3.tK = bfk2.tK + 1;
        } while (!this.aCW.compareAndSet(bfk2, bfk3));
        return true;
    }

    public int size() {
        return ((bfk)this.aCW.get()).tK;
    }

    public List Em() {
        bfk bfk2;
        ArrayList<Object> arrayList = new ArrayList<Object>(this.size() + 100);
        while (!this.aCW.compareAndSet(bfk2 = (bfk)this.aCW.get(), aCV)) {
        }
        while (bfk2 != aCV) {
            arrayList.add(bfk2.aCY);
            bfk2 = bfk2.aCX;
        }
        return arrayList;
    }
}
