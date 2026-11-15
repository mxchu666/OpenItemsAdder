package itemsadder.m;

import itemsadder.m.bbq;
import itemsadder.m.bec;
import itemsadder.m.dz;
import itemsadder.m.ec;
import itemsadder.m.ev;
import itemsadder.m.qx;
import java.util.HashMap;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.jetbrains.annotations.Nullable;

public class dx
implements qx {
    private final ec pg;
    private final String ph;
    private final String pi;
    private bbq pj;
    private bbq pk;
    private ev pl;
    private final int pm;
    public final String[] pn;
    public dz po;
    public boolean pp;
    public boolean pq;
    public boolean pr;
    private final String ps;
    final HashMap pt;
    final bec pu;
    @Nullable
    public dx pv;
    public final boolean pw;

    public dx(ec ec2, String string, String string2, bbq bbq2, bbq bbq3, int n, dz dz2, String[] stringArray, HashMap hashMap) {
        this(ec2, ec2.getNamespace(), string, string2, bbq2, bbq3, n, dz2, stringArray, hashMap);
    }

    public dx(ec ec2, String string2, String string3, String string4, bbq bbq2, bbq bbq3, int n2, dz dz2, String[] stringArray, HashMap hashMap) {
        this.pg = ec2;
        this.ph = string2;
        this.pi = string3;
        this.pj = new bbq(bbq2.aBp / 16.0f, bbq2.aBq / 16.0f, bbq2.aBr / 16.0f);
        this.pk = bbq3;
        this.pm = n2;
        this.pn = stringArray;
        this.pt = hashMap;
        this.pw = ec2.pD && dx.aB(string3);
        this.pl = new ev(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, Math.toRadians(bbq3.aBp), Math.toRadians(bbq3.aBq), Math.toRadians(bbq3.aBr));
        this.pu = new bec();
        hashMap.forEach((string, n) -> this.pu.put((Object)string.hashCode(), n));
        this.ps = this.pw ? (hashMap.isEmpty() ? dx.aE(string3) : ec2.getNamespace() + ":entity/" + string4 + "/" + string3) : this.getNamespace() + ":entity/" + string4 + "/" + string3;
        this.a(dz2);
    }

    public static boolean aB(String string) {
        return dx.aD(string) || dx.aC(string);
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

    public void a(dz dz2) {
        this.po = dz2;
        this.pq = dz2 != dz.MOUNT_PIVOT && dz2 != dz.LOCATOR_PIVOT;
        this.pr = dz2.ge();
        this.pp = dz2 == dz.LEFT_HAND_PIVOT || dz2 == dz.RIGHT_HAND_PIVOT || dz2 == dz.HAT_PIVOT;
    }

    public void a(bbq bbq2, bbq bbq3, ev ev2) {
        this.pj = bbq2;
        this.pk = bbq3;
        this.pl = ev2;
    }

    public void a(@Nullable dx dx2) {
        this.pv = dx2;
    }

    public bbq fT() {
        return this.pj;
    }

    public bbq fU() {
        return this.pk;
    }

    public ev fV() {
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
