package itemsadder.m;

import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.NmsWrapperFactory;

public final class InstanceHolder {
    private final EntityTypeWrapper afg = (EntityTypeWrapper)NmsWrapperFactory.n(EntityTypeWrapper.class);
    private static InstanceHolder afh;

    private static InstanceHolder tZ() {
        if (afh == null) {
            afh = new InstanceHolder();
        }
        return afh;
    }

    public static EntityTypeWrapper ua() {
        return InstanceHolder.tZ().afg;
    }

    InstanceHolder() {
    }
}
