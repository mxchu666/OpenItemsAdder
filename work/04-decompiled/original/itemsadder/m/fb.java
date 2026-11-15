package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Material;

final class fb
extends Record {
    private final String rM;
    private final String rN;
    private final int rO;
    private final int rP;
    private final Material rQ;

    fb(String string, String string2, int n, int n2, Material material) {
        this.rM = string;
        this.rN = string2;
        this.rO = n;
        this.rP = n2;
        this.rQ = material;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{fb.class, "itemModel;groupItemModel;rotX;rotY;fallbackMaterial", "rM", "rN", "rO", "rP", "rQ"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{fb.class, "itemModel;groupItemModel;rotX;rotY;fallbackMaterial", "rM", "rN", "rO", "rP", "rQ"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{fb.class, "itemModel;groupItemModel;rotX;rotY;fallbackMaterial", "rM", "rN", "rO", "rP", "rQ"}, this, object);
    }

    public String hi() {
        return this.rM;
    }

    public String hj() {
        return this.rN;
    }

    public int hk() {
        return this.rO;
    }

    public int hl() {
        return this.rP;
    }

    public Material hm() {
        return this.rQ;
    }
}
