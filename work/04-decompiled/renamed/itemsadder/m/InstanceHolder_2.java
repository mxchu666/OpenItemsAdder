package itemsadder.m;

import itemsadder.m.DMFunction;
import itemsadder.m.NmsWrapperFactory;

public final class InstanceHolder_2 {
    private final DMFunction alo = (DMFunction)NmsWrapperFactory.n(DMFunction.class);
    private static InstanceHolder_2 alp;

    InstanceHolder_2() {
    }

    private static InstanceHolder_2 uT() {
        if (alp == null) {
            alp = new InstanceHolder_2();
        }
        return alp;
    }

    public static DMFunction uU() {
        return InstanceHolder_2.uT().alo;
    }
}
