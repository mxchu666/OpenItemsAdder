package itemsadder.m;

import itemsadder.m.InstanceHolder_7;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Opaque051 {
    private static final InstanceHolder_7 aCV = new InstanceHolder_7();
    private final AtomicReference aCW = new AtomicReference<InstanceHolder_7>(aCV);

    public boolean add(Object object) {
        InstanceHolder_7 instanceHolder_7;
        InstanceHolder_7 instanceHolder_72 = new InstanceHolder_7();
        instanceHolder_72.aCY = object;
        do {
            instanceHolder_72.aCX = instanceHolder_7 = (InstanceHolder_7)this.aCW.get();
            instanceHolder_72.tK = instanceHolder_7.tK + 1;
        } while (!this.aCW.compareAndSet(instanceHolder_7, instanceHolder_72));
        return true;
    }

    public int size() {
        return ((InstanceHolder_7)this.aCW.get()).tK;
    }

    public List Em() {
        InstanceHolder_7 instanceHolder_7;
        ArrayList<Object> arrayList = new ArrayList<Object>(this.size() + 100);
        while (!this.aCW.compareAndSet(instanceHolder_7 = (InstanceHolder_7)this.aCW.get(), aCV)) {
        }
        while (instanceHolder_7 != aCV) {
            arrayList.add(instanceHolder_7.aCY);
            instanceHolder_7 = instanceHolder_7.aCX;
        }
        return arrayList;
    }
}
