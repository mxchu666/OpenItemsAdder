package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityHolder;
import itemsadder.m.FluentBuilder_6;
import itemsadder.m.InstanceHolder_8;
import itemsadder.m.InstanceRegistry_10;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LocationBridge;
import itemsadder.m.LocationEquipmentSlotHolder;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.NormalEnum;
import itemsadder.m.Opaque112;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.RefIntegerData;
import itemsadder.m.SmoothEnum;
import itemsadder.m.VectorBridgeImpl;
import itemsadder.m.VectorBridge_2;
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

public class LocationHolder_2 {
    private static final double qr = 0.2;
    private static final double qs = 0.3;
    private static final double qt = 0.5;
    private static final boolean qu = false;
    public final LivingEntityBuilder qv;
    public final LocationEquipmentSlotHolder qw;
    public final InstanceRegistry_10 qx;
    @Nullable
    LivingEntityArmorStandHolder qy;
    double[] qz;
    double qA;
    double qB;
    double qC;
    private double qD;
    double qE;
    double qF;
    private final InstanceHolder_8 qG;
    private final InstanceHolder_8 qH;
    protected int qI = -1;
    @Nullable
    protected Boolean qJ;
    long qK;
    boolean qL;
    protected LocationHolder_2 qM;
    boolean qN;
    private final Opaque112 qO;
    private final EquipmentSlot qP;

    public LocationHolder_2(LivingEntityBuilder livingEntityBuilder, InstanceRegistry_10 instanceRegistry_10, Opaque112 opaque112) {
        this.qv = livingEntityBuilder;
        this.qx = instanceRegistry_10;
        this.qN = instanceRegistry_10.pw;
        this.qO = opaque112;
        this.qA = this.qB = (double)livingEntityBuilder.ey();
        this.qD = this.qB;
        this.qP = instanceRegistry_10.pw && instanceRegistry_10.po != NormalEnum.HAT_PIVOT ? EquipmentSlot.HAND : (instanceRegistry_10.po == NormalEnum.LEFT_HAND_PIVOT || instanceRegistry_10.po == NormalEnum.RIGHT_HAND_PIVOT ? EquipmentSlot.HAND : EquipmentSlot.HEAD);
        this.qG = new InstanceHolder_8(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, 0.0, 0.0, 0.0);
        this.qH = new InstanceHolder_8(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, 0.0, 0.0, 0.0);
        Location location = livingEntityBuilder.getLocation();
        livingEntityBuilder.ex();
        Location location2 = location.clone().add(instanceRegistry_10.fT().Dv());
        double[] dArray = new double[]{location2.getX() + (this.qN ? (double)0.3f : 0.0), location2.getY(), location2.getZ()};
        if (instanceRegistry_10.po.gd()) {
            this.a(location, dArray, livingEntityBuilder.eC(), livingEntityBuilder.ey());
        } else {
            this.a(location, dArray, 0.0, livingEntityBuilder.eB());
        }
        location2.setX(dArray[0]);
        location2.setY(dArray[1]);
        location2.setZ(dArray[2]);
        if (livingEntityBuilder.my.nO.pD) {
            location2.add(0.0, -0.03, 0.0);
        }
        this.qw = LocationEquipmentSlotHolder.a(location2, this.qP, instanceRegistry_10.pw, livingEntityBuilder.mD, livingEntityBuilder.mE);
        if (this.qw == null) {
            System.err.println("Failed to get constructor for the client entity.");
            return;
        }
        this.qw.a(location2.getX(), location2.getY(), location2.getZ(), true);
        this.qz = this.qw.tr();
        if (livingEntityBuilder.ei()) {
            if (instanceRegistry_10.po.gd()) {
                this.qB = livingEntityBuilder.eB();
                this.qC = livingEntityBuilder.eC();
            } else {
                this.qB = livingEntityBuilder.ey();
                this.qC = 0.0;
            }
            this.qA = livingEntityBuilder.ey();
            if (livingEntityBuilder.my.nO.pI == SmoothEnum.PRECISE) {
                this.a(this.qC, this.qB);
                FluentBuilder_6 fluentBuilder_6 = instanceRegistry_10.fV().a(this.qG);
                double[] dArray2 = fluentBuilder_6.a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
                this.a(dArray2[0], dArray2[1], dArray2[2]);
                this.qH.g(fluentBuilder_6);
            } else {
                this.a(this.qC, 0.0);
                FluentBuilder_6 fluentBuilder_6 = instanceRegistry_10.fV().a(this.qG);
                double[] dArray3 = fluentBuilder_6.a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
                this.a(dArray3[0], 0.0, dArray3[2]);
                if (instanceRegistry_10.po.gd() || instanceRegistry_10.gb()) {
                    this.qw.q((float)Math.toDegrees(this.qB));
                } else {
                    this.qw.q((float)Math.toDegrees(this.qD));
                }
                this.qH.g(fluentBuilder_6);
            }
            this.qF = this.qC;
            this.qE = this.qB;
        }
        this.qw.tx();
        this.qw.dz(livingEntityBuilder.ek());
        this.qI = instanceRegistry_10.fX();
        if (MaterialBarColorHolder.fU) {
            CommandSenderBridge_5.log("Spawning bone: " + instanceRegistry_10.getNamespacedID());
        }
        if (instanceRegistry_10.po != NormalEnum.LOCATOR_PIVOT) {
            this.gy();
        }
        if (instanceRegistry_10.po == NormalEnum.MOUNT_PIVOT) {
            this.qy = new LivingEntityArmorStandHolder(this, livingEntityBuilder.mZ.isEmpty());
            livingEntityBuilder.mZ.add(this.qy);
        }
        this.gB();
    }

    public void d(PlayerBridge_7 playerBridge_7) {
        this.a(playerBridge_7, true);
    }

    public void a(PlayerBridge_7 playerBridge_7, boolean bl) {
        if (bl) {
            this.f(playerBridge_7);
        }
        this.e(playerBridge_7);
        this.g(playerBridge_7);
        if (this.qx.po == NormalEnum.MOUNT_PIVOT && this.qy != null) {
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

    public void a(Location location, RefIntegerData refIntegerData) {
        LocationHolder_2 locationHolder_2;
        if (this.qx.pr) {
            int n = this.qx.f(refIntegerData.pQ);
            if (!(this.qI == -1 && refIntegerData.pP.Bc() || this.qI == n)) {
                this.qI = n;
                if (!this.qN && refIntegerData.pP.Bc()) {
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
        this.a(location, refIntegerData.pM);
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
        if (this.qx.pq && !refIntegerData.pP.Bc()) {
            this.a(this.qB, this.qC, refIntegerData.pO, true);
        }
        if (this.qx.pv != null && (locationHolder_2 = this.qv.an(this.qx.pv.getId())) != null && locationHolder_2.qx.po.gd() && locationHolder_2.qG != null) {
            LocationBridge.a(this.qz, location.getX(), 0.0, location.getZ(), 0.0, this.qv.ey());
            double[] dArray = locationHolder_2.gv();
            LocationBridge.a(this.qz, dArray[0] + (this.qN ? (double)0.3f : 0.0), dArray[1], dArray[2], locationHolder_2.qC, locationHolder_2.qB);
            this.qB = locationHolder_2.qB;
            this.qC = locationHolder_2.qC;
            this.a(this.qC, this.qB);
        }
        this.a(location, this.qz, this.qC, this.qB);
        if (this.qx.po == NormalEnum.MOUNT_PIVOT) {
            this.qz[1] = this.qz[1] - 0.562;
        }
        this.a(this.qz);
        if (this.qx.po == NormalEnum.MOUNT_PIVOT && this.qy != null && this.qy.gG()) {
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
                LocationBridge.a(dArray, location.getX() + (double)0.3f, dArray[1], location.getZ(), 0.0, this.qA);
            } else {
                LocationBridge.a(dArray, location.getX() + (double)0.3f, dArray[1], location.getZ(), d, d2);
            }
        } else if (this.qx.po.gd()) {
            LocationBridge.a(dArray, location.getX(), dArray[1], location.getZ(), 0.0, this.qA);
        } else if (!this.qv.fk() && this.qv.nw && !this.qv.my.nO.pD) {
            double d3 = location.getX();
            double d4 = location.getZ();
            double d5 = location.getY() - 1.413 - 0.4;
            LocationBridge.a(dArray, d3, d5, d4, d, d2);
        } else {
            LocationBridge.a(dArray, location.getX(), dArray[1], location.getZ(), d, d2);
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

    void a(double d, double d2, FluentBuilder_6 fluentBuilder_6, boolean bl) {
        Object object;
        Object object2;
        if (this.qx.po.gd() && !this.qv.et().pD && this.qv.ei() && (object2 = this.qx.fT()) != null && (((VectorBridgeImpl)object2).aBp != 0.0f || ((VectorBridgeImpl)object2).aBq != 0.0f || ((VectorBridgeImpl)object2).aBr != 0.0f) && (object = EntityHolder.tK().l(this.qv.eh())) != null) {
            Location location = this.qw.tt().clone();
            location.add(0.0, this.qv.my.oh, 0.0);
            location = LocationBridge.e(location, object);
            double d3 = location.getPitch();
            d2 = Math.toRadians(d3);
        }
        if (this.qv.my.nO.pI == SmoothEnum.PRECISE) {
            if (this.qG == null || this.qE != d || this.qF != d2) {
                this.a(d2, d);
            }
            object2 = fluentBuilder_6.a(this.qG);
            object2 = FluentBuilder_6.a(this.qH, (FluentBuilder_6)object2, 0.7);
            object = ((FluentBuilder_6)object2).a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
            this.a((double)object[0], (double)object[1], (double)object[2]);
            this.qH.g((FluentBuilder_6)object2);
        } else {
            if (this.qG == null || this.qF != d2) {
                this.a(d2, 0.0);
            }
            object2 = fluentBuilder_6.a(this.qG);
            object2 = FluentBuilder_6.a(this.qH, (FluentBuilder_6)object2, 0.5);
            object = ((FluentBuilder_6)object2).a(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR);
            this.a((double)object[0], 0.0, (double)object[2]);
            if (this.qx.po.gd() || this.qx.gb()) {
                this.qw.q((float)Math.toDegrees(d));
            } else {
                double d4 = LocationBridge.r(d - this.qD);
                double d5 = this.qD = d;
                if (Math.abs(d4) > (double)0.01f) {
                    d5 += Math.signum(d4) * 0.3;
                }
                d5 = LocationBridge.r(d5);
                this.qw.q((float)Math.toDegrees(d5));
            }
            this.qH.g((FluentBuilder_6)object2);
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
        if (this.qx.po == NormalEnum.LEFT_HAND_PIVOT && equipmentSlot != EquipmentSlot.OFF_HAND) {
            return;
        }
        if (this.qx.po == NormalEnum.RIGHT_HAND_PIVOT && equipmentSlot != EquipmentSlot.HAND) {
            return;
        }
        if (this.qx.po == NormalEnum.HAT_PIVOT && equipmentSlot != EquipmentSlot.HEAD) {
            return;
        }
        this.qJ = itemStack != null && itemStack.getType() != Material.AIR;
        this.qw.a(this.qv.eg() instanceof Player ? (Player)this.qv.eg() : null, this.qv.ea(), itemStack);
        this.qw.tx();
    }

    public void a(HashMap hashMap) {
        if (this.qx.po.gd()) {
            for (String string : this.qx.pn) {
                LocationHolder_2 locationHolder_2 = (LocationHolder_2)hashMap.get(string);
                if (locationHolder_2 == null || !locationHolder_2.qx.po.gd()) continue;
                this.qM = locationHolder_2;
            }
            if (this.qM == null) {
                this.qM = this;
            }
        }
    }

    public void a(double d, double d2, double d3) {
        this.qw.c((float)d, (float)d2, (float)d3);
    }

    public void a(Location location, VectorBridge_2 vectorBridge_2) {
        if (this.qw.Yj != EquipmentSlot.HEAD) {
            this.qw.a(location.getX() + this.qv.nD + (double)0.3f, location.getY() + this.qv.nB, location.getZ() + this.qv.nC, vectorBridge_2);
        } else {
            this.qw.a(location.getX() + this.qv.nD, location.getY() + this.qv.nB, location.getZ() + this.qv.nC, vectorBridge_2);
        }
    }

    public void a(double[] dArray) {
        this.qw.d(dArray[0], dArray[1], dArray[2]);
    }

    public void gy() {
        if (this.qx.po != NormalEnum.LOCATOR_PIVOT) {
            this.qw.v(this.qv.ea());
        }
        this.qK = System.currentTimeMillis();
    }

    public void e(PlayerBridge_7 playerBridge_7) {
        if (this.qx.po != NormalEnum.LOCATOR_PIVOT) {
            this.qw.h(playerBridge_7);
        }
        this.qK = System.currentTimeMillis();
    }

    void f(PlayerBridge_7 playerBridge_7) {
        if (this.qx.po != NormalEnum.LOCATOR_PIVOT) {
            this.qw.f(playerBridge_7);
        }
    }

    public void gz() {
        if (this.qx.po != NormalEnum.LOCATOR_PIVOT) {
            this.qw.a(!this.qv.fk() && this.qv.nw && !this.qv.fj(), this.qv.eg(), this.qv.ea());
        }
    }

    public void gA() {
        if (this.qx.po != NormalEnum.MOUNT_PIVOT && this.qx.po != NormalEnum.LOCATOR_PIVOT && (this.qJ == null || this.qJ.booleanValue())) {
            this.qw.w(this.qv.ea());
        }
    }

    public void g(PlayerBridge_7 playerBridge_7) {
        if (this.qx.pr) {
            this.qw.a(playerBridge_7, this.qI);
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
    public LivingEntityArmorStandHolder gD() {
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
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            this.qw.f(playerBridge_7);
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
