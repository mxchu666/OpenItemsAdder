package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.dp;
import itemsadder.m.dr;
import itemsadder.m.ec;
import lombok.Generated;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public class dq {
    @Generated
    private ec nO;
    @Generated
    private bbf nP;
    @Generated
    private String nQ;
    @Generated
    private boolean nR;
    @Generated
    private EntityType nS;
    @Generated
    private boolean op;
    @Generated
    private BarStyle oq;
    @Generated
    private boolean or;
    @Generated
    private BarColor os;
    @Generated
    private boolean nV;
    @Generated
    private Double nW;
    @Generated
    private Float nX;
    @Generated
    private Double nY;
    @Generated
    private boolean nZ;
    @Generated
    private boolean oa;
    @Generated
    private boolean ob;
    @Generated
    private boolean oc;
    @Generated
    private boolean od;
    @Generated
    private boolean oe;
    @Generated
    private boolean of;
    @Generated
    private boolean og;
    @Generated
    private boolean ot;
    @Generated
    private double ou;
    @Generated
    private dr oi;
    @Generated
    private String oj;
    @Generated
    private String ok;
    @Generated
    private String ol;
    @Generated
    private String om;

    @Generated
    dq() {
    }

    @Generated
    public dq a(ec ec2) {
        this.nO = ec2;
        return this;
    }

    @Generated
    public dq d(@Nullable bbf bbf2) {
        this.nP = bbf2;
        return this;
    }

    @Generated
    public dq au(String string) {
        this.nQ = string;
        return this;
    }

    @Generated
    public dq x(boolean bl) {
        this.nR = bl;
        return this;
    }

    @Generated
    public dq b(EntityType entityType) {
        this.nS = entityType;
        return this;
    }

    @Generated
    public dq a(BarStyle barStyle) {
        this.oq = barStyle;
        this.op = true;
        return this;
    }

    @Generated
    public dq a(BarColor barColor) {
        this.os = barColor;
        this.or = true;
        return this;
    }

    @Generated
    public dq y(boolean bl) {
        this.nV = bl;
        return this;
    }

    @Generated
    public dq a(@Nullable Double d) {
        this.nW = d;
        return this;
    }

    @Generated
    public dq a(@Nullable Float f) {
        this.nX = f;
        return this;
    }

    @Generated
    public dq b(@Nullable Double d) {
        this.nY = d;
        return this;
    }

    @Generated
    public dq z(boolean bl) {
        this.nZ = bl;
        return this;
    }

    @Generated
    public dq A(boolean bl) {
        this.oa = bl;
        return this;
    }

    @Generated
    public dq B(boolean bl) {
        this.ob = bl;
        return this;
    }

    @Generated
    public dq C(boolean bl) {
        this.oc = bl;
        return this;
    }

    @Generated
    public dq D(boolean bl) {
        this.od = bl;
        return this;
    }

    @Generated
    public dq E(boolean bl) {
        this.oe = bl;
        return this;
    }

    @Generated
    public dq F(boolean bl) {
        this.of = bl;
        return this;
    }

    @Generated
    public dq G(boolean bl) {
        this.og = bl;
        return this;
    }

    @Generated
    public dq e(double d) {
        this.ou = d;
        this.ot = true;
        return this;
    }

    @Generated
    public dq b(@Nullable dr dr2) {
        this.oi = dr2;
        return this;
    }

    @Generated
    public dq av(@Nullable String string) {
        this.oj = string;
        return this;
    }

    @Generated
    public dq aw(@Nullable String string) {
        this.ok = string;
        return this;
    }

    @Generated
    public dq ax(@Nullable String string) {
        this.ol = string;
        return this;
    }

    @Generated
    public dq ay(@Nullable String string) {
        this.om = string;
        return this;
    }

    @Generated
    public dp fA() {
        BarStyle barStyle = this.oq;
        if (!this.op) {
            barStyle = dp.fv();
        }
        BarColor barColor = this.os;
        if (!this.or) {
            barColor = dp.fw();
        }
        double d = this.ou;
        if (!this.ot) {
            d = dp.fx();
        }
        return new dp(this.nO, this.nP, this.nQ, this.nR, this.nS, barStyle, barColor, this.nV, this.nW, this.nX, this.nY, this.nZ, this.oa, this.ob, this.oc, this.od, this.oe, this.of, this.og, d, this.oi, this.oj, this.ok, this.ol, this.om);
    }

    @Generated
    public String toString() {
        return "EntitySettings.EntitySettingsBuilder(model=" + String.valueOf(this.nO) + ", configFile=" + String.valueOf(this.nP) + ", displayName=" + this.nQ + ", hasBossbar=" + this.nR + ", entityType=" + String.valueOf(this.nS) + ", bossBarStyle$value=" + String.valueOf(this.oq) + ", bossBarColor$value=" + String.valueOf(this.os) + ", jumpOnAttack=" + this.nV + ", maxHealth=" + this.nW + ", flyingSpeed=" + this.nX + ", movementSpeed=" + this.nY + ", isSilent=" + this.nZ + ", canSunBurn=" + this.oa + ", canDropLoot=" + this.ob + ", mountOnInteract=" + this.oc + ", shadow=" + this.od + ", invulnerable=" + this.oe + ", gravity=" + this.of + ", ai=" + this.og + ", eyesHeight$value=" + this.ou + ", soundAmbient=" + String.valueOf(this.oi) + ", soundAttack=" + this.oj + ", soundHurt=" + this.ok + ", soundDeath=" + this.ol + ", allActionsPermission=" + this.om + ")";
    }
}
