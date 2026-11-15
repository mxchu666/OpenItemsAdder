package itemsadder.m;

import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.Hitbox;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfString_5;
import lombok.Generated;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public class EntityTypeBarStyleHolderBuilder {
    @Generated
    private Hitbox nO;
    @Generated
    private PluginFileConfigurationHolder nP;
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
    private RecordOfString_5 oi;
    @Generated
    private String oj;
    @Generated
    private String ok;
    @Generated
    private String ol;
    @Generated
    private String om;

    @Generated
    EntityTypeBarStyleHolderBuilder() {
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder a(Hitbox hitbox) {
        this.nO = hitbox;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder d(@Nullable PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        this.nP = pluginFileConfigurationHolder;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder au(String string) {
        this.nQ = string;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder x(boolean bl) {
        this.nR = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder b(EntityType entityType) {
        this.nS = entityType;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder a(BarStyle barStyle) {
        this.oq = barStyle;
        this.op = true;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder a(BarColor barColor) {
        this.os = barColor;
        this.or = true;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder y(boolean bl) {
        this.nV = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder a(@Nullable Double d) {
        this.nW = d;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder a(@Nullable Float f) {
        this.nX = f;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder b(@Nullable Double d) {
        this.nY = d;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder z(boolean bl) {
        this.nZ = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder A(boolean bl) {
        this.oa = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder B(boolean bl) {
        this.ob = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder C(boolean bl) {
        this.oc = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder D(boolean bl) {
        this.od = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder E(boolean bl) {
        this.oe = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder F(boolean bl) {
        this.of = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder G(boolean bl) {
        this.og = bl;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder e(double d) {
        this.ou = d;
        this.ot = true;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder b(@Nullable RecordOfString_5 recordOfString_5) {
        this.oi = recordOfString_5;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder av(@Nullable String string) {
        this.oj = string;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder aw(@Nullable String string) {
        this.ok = string;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder ax(@Nullable String string) {
        this.ol = string;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolderBuilder ay(@Nullable String string) {
        this.om = string;
        return this;
    }

    @Generated
    public EntityTypeBarStyleHolder fA() {
        BarStyle barStyle = this.oq;
        if (!this.op) {
            barStyle = EntityTypeBarStyleHolder.fv();
        }
        BarColor barColor = this.os;
        if (!this.or) {
            barColor = EntityTypeBarStyleHolder.fw();
        }
        double d = this.ou;
        if (!this.ot) {
            d = EntityTypeBarStyleHolder.fx();
        }
        return new EntityTypeBarStyleHolder(this.nO, this.nP, this.nQ, this.nR, this.nS, barStyle, barColor, this.nV, this.nW, this.nX, this.nY, this.nZ, this.oa, this.ob, this.oc, this.od, this.oe, this.of, this.og, d, this.oi, this.oj, this.ok, this.ol, this.om);
    }

    @Generated
    public String toString() {
        return "EntitySettings.EntitySettingsBuilder(model=" + String.valueOf(this.nO) + ", configFile=" + String.valueOf(this.nP) + ", displayName=" + this.nQ + ", hasBossbar=" + this.nR + ", entityType=" + String.valueOf(this.nS) + ", bossBarStyle$value=" + String.valueOf(this.oq) + ", bossBarColor$value=" + String.valueOf(this.os) + ", jumpOnAttack=" + this.nV + ", maxHealth=" + this.nW + ", flyingSpeed=" + this.nX + ", movementSpeed=" + this.nY + ", isSilent=" + this.nZ + ", canSunBurn=" + this.oa + ", canDropLoot=" + this.ob + ", mountOnInteract=" + this.oc + ", shadow=" + this.od + ", invulnerable=" + this.oe + ", gravity=" + this.of + ", ai=" + this.og + ", eyesHeight$value=" + this.ou + ", soundAmbient=" + String.valueOf(this.oi) + ", soundAttack=" + this.oj + ", soundHurt=" + this.ok + ", soundDeath=" + this.ol + ", allActionsPermission=" + this.om + ")";
    }
}
