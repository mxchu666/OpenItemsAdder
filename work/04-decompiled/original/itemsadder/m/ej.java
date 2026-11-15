package itemsadder.m;

import itemsadder.m.adq;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.bbk;
import itemsadder.m.bbq;
import itemsadder.m.bce;
import itemsadder.m.bda;
import itemsadder.m.dn;
import itemsadder.m.do;
import itemsadder.m.dx;
import itemsadder.m.dy;
import itemsadder.m.dz;
import itemsadder.m.ed;
import itemsadder.m.eh;
import itemsadder.m.ek;
import itemsadder.m.ev;
import itemsadder.m.ew;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ej {
    private static final double qr = 0.2;
    private static final double qs = 0.3;
    private static final double qt = 0.5;
    private static final boolean qu = false;
    public final dn qv;
    public final adq qw;
    public final dx qx;
    @Nullable
    ek qy;
    double[] qz;
    double qA;
    double qB;
    double qC;
    private double qD;
    double qE;
    double qF;
    private final ew qG;
    private final ew qH;
    protected int qI = -1;
    @Nullable
    protected Boolean qJ;
    long qK;
    boolean qL;
    protected ej qM;
    boolean qN;
    private final eh qO;
    private final EquipmentSlot qP;

    public ej(dn dn2, dx dx2, eh eh2) {
        this.qv = dn2;
        this.qx = dx2;
        this.qN = dx2.pw;
        this.qO = eh2;
        this.qA = this.qB = (double)dn2.ey();
        this.qD = this.qB;
        this.qP = dx2.pw && dx2.po != dz.HAT_PIVOT ? EquipmentSlot.HAND : (dx2.po == dz.LEFT_HAND_PIVOT || dx2.po == dz.RIGHT_HAND_PIVOT ? EquipmentSlot.HAND : EquipmentSlot.HEAD);
        this.qG = new ew(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, 0.0, 0.0, 0.0);
        this.qH = new ew(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, 0.0, 0.0, 0.0);
        Location location = dn2.getLocation();
        dn2.ex();
        Location location2 = location.clone().add(dx2.fT().Dv());
        double[] dArray = new double[]{location2.getX() + (this.qN ? (double)0.3f : 0.0), location2.getY(), location2.getZ()};
        if (dx2.po.gd()) {
            this.a(location, dArray, dn2.eC(), dn2.ey());
        } else {
            this.a(location, dArray, 0.0, dn2.eB());
        }
        location2.setX(dArray[0]);
        location2.setY(dArray[1]);
        location2.setZ(dArray[2]);
        if (dn2.my.nO.pD) {
            location2.add(0.0, -0.03, 0.0);
        }
        this.qw = adq.a(location2, this.qP, dx2.pw, dn2.mD, dn2.mE);
        if (this.qw == null) {
            System.err.println("Failed to get constructor for the client entity.");
            return;
        }
        this.qw.a(location2.getX(), location2.getY(), location2.getZ(), true);
        this.qz = this.qw.tr();
        if (dn2.ei()) {
            if (dx2.po.gd()) {
                this.qB = dn2.eB();
                this.qC = dn2.eC();
            } else {
                this.qB = dn2.ey();
                this.qC = 0.0;
            }
            this.qA = dn2.ey();
            if (dn2.my.nO.pI == dy.PRECISE) {
                this.a(this.qC, this.qB);
                ev ev2 = dx2.fV().a(this.qG);
                double[] dArray2 = ev2.a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
                this.a(dArray2[0], dArray2[1], dArray2[2]);
                this.qH.g(ev2);
            } else {
                this.a(this.qC, 0.0);
                ev ev3 = dx2.fV().a(this.qG);
                double[] dArray3 = ev3.a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
                this.a(dArray3[0], 0.0, dArray3[2]);
                if (dx2.po.gd() || dx2.gb()) {
                    this.qw.q((float)Math.toDegrees(this.qB));
                } else {
                    this.qw.q((float)Math.toDegrees(this.qD));
                }
                this.qH.g(ev3);
            }
            this.qF = this.qC;
            this.qE = this.qB;
        }
        this.qw.tx();
        this.qw.dz(dn2.ek());
        this.qI = dx2.fX();
        if (ae.fU) {
            bce.log("Spawning bone: " + dx2.getNamespacedID());
        }
        if (dx2.po != dz.LOCATOR_PIVOT) {
            this.gy();
        }
        if (dx2.po == dz.MOUNT_PIVOT) {
            this.qy = new ek(this, dn2.mZ.isEmpty());
            dn2.mZ.add(this.qy);
        }
        this.gB();
    }

    public void d(do do_) {
        this.a(do_, true);
    }

    public void a(do do_, boolean bl) {
        if (bl) {
            this.f(do_);
        }
        this.e(do_);
        this.g(do_);
        if (this.qx.po == dz.MOUNT_PIVOT && this.qy != null) {
            this.qy.gM();
        }
    }

    public void h(String string, boolean bl) {
        this.qw.dz(string);
        this.O(bl);
    }

    public void O(boolean bl) {
        if (this.qx.pr) {
            this.qw.tq();
            if (bl) {
                this.qw.d(this.qv.ea(), this.qI);
            }
        }
    }

    private double[] gv() {
        if (this.qz == null) {
            this.qz = this.qw.tr();
        }
        return this.qz;
    }

    public void a(Location location, ed ed2) {
        ej ej2;
        if (this.qx.pr) {
            int n = this.qx.f(ed2.pQ);
            if (!(this.qI == -1 && ed2.pP.Bc() || this.qI == n)) {
                this.qI = n;
                if (!this.qN && ed2.pP.Bc()) {
                    this.qI = -1;
                }
                this.gB();
            }
            if (!this.qL && System.currentTimeMillis() - this.qK > (long)(this.qN ? 0 : 40)) {
                this.qL = true;
                this.qw.tx();
                if (!this.qv.nv) {
                    this.qv.nv = true;
                    this.qv.dY();
                }
            }
        }
        this.a(location, ed2.pM);
        this.gw();
        this.qz = this.qw.tr();
        if (!this.qv.fk() && this.qv.nw && !this.qv.my.nO.pD) {
            if (this.qv.ee()) {
                this.qz[1] = this.qz[1] + 0.0;
                this.qz[2] = this.qz[2] - 0.3;
            } else if (this.qv.ef()) {
                this.qz[1] = this.qz[1] + 1.3;
                this.qz[2] = this.qz[2] - 0.05;
            } else {
                this.qz[1] = this.qz[1] + 1.2;
            }
        }
        if (this.qv.my.nO.pD) {
            this.qz[1] = this.qz[1] - 0.03;
        }
        if (this.qx.pq && !ed2.pP.Bc()) {
            this.a(this.qB, this.qC, ed2.pO, true);
        }
        if (this.qx.pv != null && (ej2 = this.qv.an(this.qx.pv.getId())) != null && ej2.qx.po.gd() && ej2.qG != null) {
            bbk.a(this.qz, location.getX(), 0.0, location.getZ(), 0.0, this.qv.ey());
            double[] dArray = ej2.gv();
            bbk.a(this.qz, dArray[0] + (this.qN ? (double)0.3f : 0.0), dArray[1], dArray[2], ej2.qC, ej2.qB);
            this.qB = ej2.qB;
            this.qC = ej2.qC;
            this.a(this.qC, this.qB);
        }
        this.a(location, this.qz, this.qC, this.qB);
        if (this.qx.po == dz.MOUNT_PIVOT) {
            this.qz[1] = this.qz[1] - 0.562;
        }
        this.a(this.qz);
        if (this.qx.po == dz.MOUNT_PIVOT && this.qy != null && this.qy.gG()) {
            this.qy.gk();
        }
        this.gz();
        this.qE = this.qB;
        this.qF = this.qC;
    }

    private void a(Location location, double[] dArray, double d, double d2) {
        if (this.qx.pv != null) {
            return;
        }
        if (this.qO.qb == null) {
            return;
        }
        if (this.qP != EquipmentSlot.HEAD) {
            if (this.qx.po.gd()) {
                bbk.a(dArray, location.getX() + (double)0.3f, dArray[1], location.getZ(), 0.0, this.qA);
            } else {
                bbk.a(dArray, location.getX() + (double)0.3f, dArray[1], location.getZ(), d, d2);
            }
        } else if (this.qx.po.gd()) {
            bbk.a(dArray, location.getX(), dArray[1], location.getZ(), 0.0, this.qA);
        } else if (!this.qv.fk() && this.qv.nw && !this.qv.my.nO.pD) {
            double d3 = location.getX();
            double d4 = location.getZ();
            double d5 = location.getY() - 1.413 - 0.4;
            bbk.a(dArray, d3, d5, d4, d, d2);
        } else {
            bbk.a(dArray, location.getX(), dArray[1], location.getZ(), d, d2);
        }
    }

    void gw() {
        if (this.qx.pv != null) {
            return;
        }
        if (this.qO.qb == null) {
            return;
        }
        if (this.qv.eY()) {
            return;
        }
        if (!this.qv.fk() && this.qv.nw && !this.qv.my.nO.pD && (this.qv.ee() || this.qv.ef())) {
            this.qC = (double)this.qv.eC() + Math.toRadians(90.0);
            this.qB = this.qv.ey();
            return;
        }
        if (this.qx.po.gd()) {
            if (this.qO.qb.fK()) {
                this.qB = this.qv.eB();
                this.qC = this.qv.eC();
            }
        } else if (this.qO.qb.fL()) {
            this.qB = this.qv.ey();
            this.qC = 0.0;
        }
        if (this.qO.qb.fL()) {
            this.qA = this.qv.ey();
        }
    }

    void a(double d, double d2, ev ev2, boolean bl) {
        Object object;
        Object object2;
        if (this.qx.po.gd() && !this.qv.et().pD && this.qv.ei() && (object2 = this.qx.fT()) != null && (((bbq)object2).aBp != 0.0f || ((bbq)object2).aBq != 0.0f || ((bbq)object2).aBr != 0.0f) && (object = afz.tK().l(this.qv.eh())) != null) {
            Location location = this.qw.tt().clone();
            location.add(0.0, this.qv.my.oh, 0.0);
            location = bbk.e(location, object);
            double d3 = location.getPitch();
            d2 = Math.toRadians(d3);
        }
        if (this.qv.my.nO.pI == dy.PRECISE) {
            if (this.qG == null || this.qE != d || this.qF != d2) {
                this.a(d2, d);
            }
            object2 = ev2.a(this.qG);
            object2 = ev.a(this.qH, (ev)object2, 0.7);
            object = ((ev)object2).a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
            this.a((double)object[0], (double)object[1], (double)object[2]);
            this.qH.g((ev)object2);
        } else {
            if (this.qG == null || this.qF != d2) {
                this.a(d2, 0.0);
            }
            object2 = ev2.a(this.qG);
            object2 = ev.a(this.qH, (ev)object2, 0.5);
            object = ((ev)object2).a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
            this.a((double)object[0], 0.0, (double)object[2]);
            if (this.qx.po.gd() || this.qx.gb()) {
                this.qw.q((float)Math.toDegrees(d));
            } else {
                double d4 = bbk.r(d - this.qD);
                double d5 = this.qD = d;
                if (Math.abs(d4) > (double)0.01f) {
                    d5 += Math.signum(d4) * 0.3;
                }
                d5 = bbk.r(d5);
                this.qw.q((float)Math.toDegrees(d5));
            }
            this.qH.g((ev)object2);
        }
        if (bl) {
            this.gA();
        }
    }

    void gx() {
        float f;
        float f2;
        if (this.qx.pv != null) {
            return;
        }
        if (this.qv.eY()) {
            return;
        }
        if (this.qx.po.gd()) {
            f2 = this.qv.eB();
            f = this.qv.eC();
        } else {
            f2 = this.qv.ey();
            f = 0.0f;
        }
        this.qG.b(f, f2, 0.0);
    }

    private void a(double d, double d2) {
        this.qG.b(d, d2, 0.0);
    }

    public void a(ItemStack itemStack, EquipmentSlot equipmentSlot) {
        if (!this.qv.ni.fF()) {
            return;
        }
        if (this.qx.po == dz.LEFT_HAND_PIVOT && equipmentSlot != EquipmentSlot.OFF_HAND) {
            return;
        }
        if (this.qx.po == dz.RIGHT_HAND_PIVOT && equipmentSlot != EquipmentSlot.HAND) {
            return;
        }
        if (this.qx.po == dz.HAT_PIVOT && equipmentSlot != EquipmentSlot.HEAD) {
            return;
        }
        this.qJ = itemStack != null && itemStack.getType() != Material.AIR;
        this.qw.a(this.qv.eg() instanceof Player ? (Player)this.qv.eg() : null, this.qv.ea(), itemStack);
        this.qw.tx();
    }

    public void a(HashMap hashMap) {
        if (this.qx.po.gd()) {
            for (String string : this.qx.pn) {
                ej ej2 = (ej)hashMap.get(string);
                if (ej2 == null || !ej2.qx.po.gd()) continue;
                this.qM = ej2;
            }
            if (this.qM == null) {
                this.qM = this;
            }
        }
    }

    public void a(double d, double d2, double d3) {
        this.qw.c((float)d, (float)d2, (float)d3);
    }

    public void a(Location location, bda bda2) {
        if (this.qw.Yj != EquipmentSlot.HEAD) {
            this.qw.a(location.getX() + this.qv.nD + (double)0.3f, location.getY() + this.qv.nB, location.getZ() + this.qv.nC, bda2);
        } else {
            this.qw.a(location.getX() + this.qv.nD, location.getY() + this.qv.nB, location.getZ() + this.qv.nC, bda2);
        }
    }

    public void a(double[] dArray) {
        this.qw.d(dArray[0], dArray[1], dArray[2]);
    }

    public void gy() {
        if (this.qx.po != dz.LOCATOR_PIVOT) {
            this.qw.v(this.qv.ea());
        }
        this.qK = System.currentTimeMillis();
    }

    public void e(do do_) {
        if (this.qx.po != dz.LOCATOR_PIVOT) {
            this.qw.h(do_);
        }
        this.qK = System.currentTimeMillis();
    }

    void f(do do_) {
        if (this.qx.po != dz.LOCATOR_PIVOT) {
            this.qw.f(do_);
        }
    }

    public void gz() {
        if (this.qx.po != dz.LOCATOR_PIVOT) {
            this.qw.a(!this.qv.fk() && this.qv.nw && !this.qv.fj(), this.qv.eg(), this.qv.ea());
        }
    }

    public void gA() {
        if (this.qx.po != dz.MOUNT_PIVOT && this.qx.po != dz.LOCATOR_PIVOT && (this.qJ == null || this.qJ.booleanValue())) {
            this.qw.w(this.qv.ea());
        }
    }

    public void g(do do_) {
        if (this.qx.pr) {
            this.qw.a(do_, this.qI);
        }
    }

    public void gB() {
        if (this.qx.pr) {
            this.qw.d(this.qv.ea(), this.qI);
        }
    }

    public void i(List list) {
        if (this.qx.pr) {
            this.qw.b(list, this.qI);
        }
    }

    public void j(List list) {
        if (this.qx.pr) {
            this.qw.c(list, this.qI);
        }
    }

    public Location gC() {
        return this.qw.tu();
    }

    @Nullable
    public ek gD() {
        return this.qy;
    }

    public void a(List list, boolean bl) {
        if (bl) {
            this.gF();
        } else {
            this.gE();
        }
    }

    public void gE() {
        List list = this.qv.ea();
        int n = list.size();
        for (int i = 0; i < n; ++i) {
            do do_ = (do)list.get(i);
            this.qw.f(do_);
        }
    }

    public void gF() {
        this.gy();
    }

    public void setEnchanted(boolean bl) {
        this.qw.setEnchanted(bl);
    }

    public void setColor(int n) {
        this.qw.setColor(n);
    }
}
