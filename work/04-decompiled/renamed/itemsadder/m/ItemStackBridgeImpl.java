package itemsadder.m;

import itemsadder.m.ItemStackBridge_33;
import itemsadder.m.LocationBridgeBuilder_2;

public class ItemStackBridgeImpl
extends ItemStackBridge_33 {
    final LocationBridgeBuilder_2 Ll;

    public ItemStackBridgeImpl(LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        this.Ll = locationBridgeBuilder_2;
    }

    public LocationBridgeBuilder_2 ln() {
        return this.Ll;
    }
}
