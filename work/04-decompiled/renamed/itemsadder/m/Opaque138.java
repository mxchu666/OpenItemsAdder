package itemsadder.m;

import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.NamespacedKeyWrapper;

public class Opaque138 {
    private final NamespacedKeyItemStackHolder LV;
    private final String LW;
    private final String LX;

    public Opaque138(NamespacedKeyItemStackHolder namespacedKeyItemStackHolder, String string, String string2) {
        this.LV = namespacedKeyItemStackHolder;
        this.LW = string;
        this.LX = string2;
    }

    public void a(NamespacedKeyWrapper namespacedKeyWrapper) {
        namespacedKeyWrapper.a(this.LV, this.LW, this.LX);
    }

    public static void a(NamespacedKeyWrapper namespacedKeyWrapper, Iterable iterable) {
        for (Opaque138 opaque138 : iterable) {
            opaque138.a(namespacedKeyWrapper);
        }
    }
}
