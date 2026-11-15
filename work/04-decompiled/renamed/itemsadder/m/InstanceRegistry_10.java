package itemsadder.m;

import itemsadder.m.FluentBuilder_6;
import itemsadder.m.Hitbox;
import itemsadder.m.Implemented_2;
import itemsadder.m.NormalEnum;
import itemsadder.m.PluginContract_20;
import itemsadder.m.VectorBridgeImpl;
import java.util.HashMap;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.jetbrains.annotations.Nullable;

public class InstanceRegistry_10
implements PluginContract_20 {
    private final Hitbox pg;
    private final String ph;
    private final String pi;
    private VectorBridgeImpl pj;
    private VectorBridgeImpl pk;
    private FluentBuilder_6 pl;
    private final int pm;
    public final String[] pn;
    public NormalEnum po;
    public boolean pp;
    public boolean pq;
    public boolean pr;
    private final String ps;
    final HashMap pt;
    final Implemented_2 pu;
    @Nullable
    public InstanceRegistry_10 pv;
    public final boolean pw;

    public InstanceRegistry_10(Hitbox hitbox, String string, String string2, VectorBridgeImpl vectorBridgeImpl, VectorBridgeImpl vectorBridgeImpl2, int n, NormalEnum normalEnum, String[] stringArray, HashMap hashMap) {
        this(hitbox, hitbox.getNamespace(), string, string2, vectorBridgeImpl, vectorBridgeImpl2, n, normalEnum, stringArray, hashMap);
    }

    public InstanceRegistry_10(Hitbox hitbox, String string2, String string3, String string4, VectorBridgeImpl vectorBridgeImpl, VectorBridgeImpl vectorBridgeImpl2, int n2, NormalEnum normalEnum, String[] stringArray, HashMap hashMap) {
        this.pg = hitbox;
        this.ph = string2;
        this.pi = string3;
        this.pj = new VectorBridgeImpl(vectorBridgeImpl.aBp / 16.0f, vectorBridgeImpl.aBq / 16.0f, vectorBridgeImpl.aBr / 16.0f);
        this.pk = vectorBridgeImpl2;
        this.pm = n2;
        this.pn = stringArray;
        this.pt = hashMap;
        this.pw = hitbox.pD && InstanceRegistry_10.aB(string3);
        this.pl = new FluentBuilder_6(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, Math.toRadians(vectorBridgeImpl2.aBp), Math.toRadians(vectorBridgeImpl2.aBq), Math.toRadians(vectorBridgeImpl2.aBr));
        this.pu = new Implemented_2();
        hashMap.forEach((string, n) -> this.pu.put((Object)string.hashCode(), n));
        this.ps = this.pw ? (hashMap.isEmpty() ? InstanceRegistry_10.aE(string3) : hitbox.getNamespace() + ":entity/" + string4 + "/" + string3) : this.getNamespace() + ":entity/" + string4 + "/" + string3;
        this.a(normalEnum);
    }

    public static boolean aB(String string) {
        return InstanceRegistry_10.aD(string) || InstanceRegistry_10.aC(string);
    }

    public static boolean aC(String string) {
        switch (string) {
            case "hat_slot": 
            case "left_arm_slot": 
            case "right_arm_slot": {
                return true;
            }
        }
        return string.contains("dummy_");
    }

    public static boolean aD(String string) {
        switch (string) {
            case "parm_left_3": 
            case "parm_right_4": 
            case "pbody_2": 
            case "phead_0": 
            case "pleg_left_1": 
            case "pleg_right_5": {
                return true;
            }
        }
        return string.contains("dummy_");
    }

    public static String aE(String string) {
        return "_iainternal:entity/player/" + string;
    }

    public void a(NormalEnum normalEnum) {
        this.po = normalEnum;
        this.pq = normalEnum != NormalEnum.MOUNT_PIVOT && normalEnum != NormalEnum.LOCATOR_PIVOT;
        this.pr = normalEnum.ge();
        this.pp = normalEnum == NormalEnum.LEFT_HAND_PIVOT || normalEnum == NormalEnum.RIGHT_HAND_PIVOT || normalEnum == NormalEnum.HAT_PIVOT;
    }

    public void a(VectorBridgeImpl vectorBridgeImpl, VectorBridgeImpl vectorBridgeImpl2, FluentBuilder_6 fluentBuilder_6) {
        this.pj = vectorBridgeImpl;
        this.pk = vectorBridgeImpl2;
        this.pl = fluentBuilder_6;
    }

    public void a(@Nullable InstanceRegistry_10 instanceRegistry_10) {
        this.pv = instanceRegistry_10;
    }

    public VectorBridgeImpl fT() {
        return this.pj;
    }

    public VectorBridgeImpl fU() {
        return this.pk;
    }

    public FluentBuilder_6 fV() {
        return this.pl;
    }

    @Override
    public boolean fW() {
        return true;
    }

    @Override
    public int fX() {
        return this.pm;
    }

    public HashMap fY() {
        return this.pt;
    }

    @Override
    public boolean fZ() {
        return false;
    }

    @Override
    @Deprecated
    public String d(boolean bl, boolean bl2) {
        if (this.fW()) {
            if (this.ps.contains(":")) {
                return this.ps;
            }
            return (String)(bl2 ? this.getNamespace() + ":" : "") + this.ps;
        }
        return (String)(bl2 ? this.getNamespace() + ":" : "") + "item/ia_auto/" + this.getId() + (bl ? ".json" : "");
    }

    @Override
    public String ga() {
        return this.ps;
    }

    @Override
    public String getNamespace() {
        return this.ph;
    }

    @Override
    public String getId() {
        return this.pi;
    }

    @Override
    public String getNamespacedID() {
        return this.ph + ":" + this.pi;
    }

    public int f(Integer n) {
        Integer n2 = (Integer)this.pu.get(n);
        if (n2 == null) {
            return this.pm;
        }
        return n2;
    }

    public String toString() {
        return "Bone{entityModel=" + this.pg.getNamespacedID() + ", id='" + this.pi + "', localPos=" + String.valueOf(this.pj) + ", localRot=" + String.valueOf(this.pk) + ", customModelData=" + this.pm + ", type=" + String.valueOf((Object)this.po) + ", isRenderable=" + this.pq + ", hasModel=" + this.pr + ", modelPath='" + this.ps + "', baseHeadBone=" + (this.pv != null ? this.pv.getNamespacedID() : "none") + "}";
    }

    public boolean gb() {
        return this.po.gd() || this.pv != null && this.pv.po.gd();
    }
}
