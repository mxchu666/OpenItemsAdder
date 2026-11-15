package itemsadder.m;

import itemsadder.m.EntityBridge_5;
import itemsadder.m.LocationBridge_14;
import java.util.ArrayList;
import java.util.List;

public class LocationBridgeImpl
extends LocationBridge_14 {
    final List LI = new ArrayList();

    public void a(EntityBridge_5 entityBridge_5) {
        this.LI.add(entityBridge_5);
    }

    public List qF() {
        return this.LI;
    }

    public boolean qG() {
        return this.LI.size() > 0;
    }
}
