package itemsadder.m;

import itemsadder.m.afz;
import itemsadder.m.au;
import itemsadder.m.ax;
import itemsadder.m.ay;
import itemsadder.m.bbf;
import itemsadder.m.da;
import itemsadder.m.dq;
import itemsadder.m.dr;
import itemsadder.m.dt;
import itemsadder.m.ec;
import itemsadder.m.gy;
import java.util.Objects;
import lombok.Generated;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class dp {
    public final ec nO;
    @Nullable
    public final bbf nP;
    public final String nQ;
    public final boolean nR;
    public final EntityType nS;
    BarStyle nT;
    BarColor nU;
    public boolean nV;
    @Nullable
    public Double nW;
    @Nullable
    Float nX;
    @Nullable
    Double nY;
    public final boolean nZ;
    public final boolean oa;
    public final boolean ob;
    public final boolean oc;
    public final boolean od;
    public final boolean oe;
    public final boolean of;
    public final boolean og;
    public final double oh;
    @Nullable
    public final dr oi;
    @Nullable
    public final String oj;
    @Nullable
    public final String ok;
    @Nullable
    public final String ol;
    @Nullable
    public final String om;
    public final ay on = new ay(this);
    public final gy oo = new gy(this);

    public String bj() {
        return this.nO.getNamespacedID();
    }

    public void a(@Nullable LivingEntity livingEntity, @Nullable String string, boolean bl) {
        if (livingEntity == null) {
            return;
        }
        da.a((Entity)livingEntity, this.nO.getNamespacedID());
        if (string != null) {
            da.b((Entity)livingEntity, string);
        }
        if (livingEntity instanceof EnderDragon) {
            ((EnderDragon)livingEntity).setPhase(EnderDragon.Phase.CIRCLING);
        }
        if (this.nX != null && this.nX.floatValue() >= 0.0f) {
            afz.tK().b(livingEntity, (double)this.nX.floatValue());
        }
        if (this.nY != null && this.nY >= 0.0) {
            afz.tK().a(livingEntity, this.nY);
        }
        if (livingEntity.getType() == EntityType.WITHER || livingEntity.getType() == EntityType.ENDER_DRAGON) {
            livingEntity.setCustomName(this.nQ);
        }
        if (this.nW != null && this.nW > 0.0) {
            livingEntity.setMaxHealth(this.nW.doubleValue());
            if (bl) {
                livingEntity.setHealth(this.nW.doubleValue());
            }
        }
        if (!bl || this.nZ) {
            livingEntity.setSilent(this.nZ);
        }
        if (!bl || this.oe) {
            livingEntity.setInvulnerable(this.oe);
        }
        if (!bl || !this.of) {
            livingEntity.setGravity(this.of);
        }
        if (!bl || !this.og) {
            livingEntity.setAI(this.og);
        }
        if (!this.nR || this.nS == EntityType.WITHER || this.nS != EntityType.ENDER_DRAGON) {
            // empty if block
        }
    }

    @Nullable
    public dt ar(String string) {
        return (dt)this.nO.pB.get(string);
    }

    public double ft() {
        return Objects.requireNonNullElse(this.nY, 0.23);
    }

    public float fu() {
        return Objects.requireNonNullElse(this.nX, Float.valueOf(0.0f)).floatValue();
    }

    public void a(Entity entity, ax ax2, au au2) {
        this.on.a(entity, ax2, au2);
    }

    @Generated
    private static BarStyle fv() {
        return BarStyle.SEGMENTED_6;
    }

    @Generated
    private static BarColor fw() {
        return BarColor.PURPLE;
    }

    @Generated
    private static double fx() {
        return 0.25;
    }

    @Generated
    dp(ec ec2, @Nullable bbf bbf2, String string, boolean bl, EntityType entityType, BarStyle barStyle, BarColor barColor, boolean bl2, @Nullable Double d, @Nullable Float f, @Nullable Double d2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, double d3, @Nullable dr dr2, @Nullable String string2, @Nullable String string3, @Nullable String string4, @Nullable String string5) {
        this.nO = ec2;
        this.nP = bbf2;
        this.nQ = string;
        this.nR = bl;
        this.nS = entityType;
        this.nT = barStyle;
        this.nU = barColor;
        this.nV = bl2;
        this.nW = d;
        this.nX = f;
        this.nY = d2;
        this.nZ = bl3;
        this.oa = bl4;
        this.ob = bl5;
        this.oc = bl6;
        this.od = bl7;
        this.oe = bl8;
        this.of = bl9;
        this.og = bl10;
        this.oh = d3;
        this.oi = dr2;
        this.oj = string2;
        this.ok = string3;
        this.ol = string4;
        this.om = string5;
    }

    @Generated
    public static dq fy() {
        return new dq();
    }

    @Nullable
    @Generated
    public bbf fz() {
        return this.nP;
    }
}
