package itemsadder.m;

import itemsadder.m.InstanceHolder_9;
import itemsadder.m.LocationBridge_12;
import itemsadder.m.RecordOfUUID_2;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class RecordOfValue_17
extends Record {
    private final RecordOfUUID_2 sD;
    private final InstanceHolder_9 sE;
    private final LocationBridge_12 sF;

    private RecordOfValue_17(RecordOfUUID_2 recordOfUUID_2, InstanceHolder_9 instanceHolder_9, LocationBridge_12 locationBridge_12) {
        this.sD = recordOfUUID_2;
        this.sE = instanceHolder_9;
        this.sF = locationBridge_12;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_17.class, "frame;snapshot;viewer", "sD", "sE", "sF"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_17.class, "frame;snapshot;viewer", "sD", "sE", "sF"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_17.class, "frame;snapshot;viewer", "sD", "sE", "sF"}, this, object);
    }

    public RecordOfUUID_2 hD() {
        return this.sD;
    }

    public InstanceHolder_9 hE() {
        return this.sE;
    }

    public LocationBridge_12 hF() {
        return this.sF;
    }
}
