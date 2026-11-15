package itemsadder.m;

import itemsadder.m.Consumer;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityTypeBarStyleHolderBuilder;
import itemsadder.m.Hitbox;
import itemsadder.m.InteractEnum;
import itemsadder.m.LivingEntityBridge_5;
import itemsadder.m.LivingEntityBridge_7;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfString_5;
import itemsadder.m.SoundCategoryBridge_2;
import java.util.Objects;
import lombok.Generated;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class EntityTypeBarStyleHolder {
    public final Hitbox nO;
    @Nullable
    public final PluginFileConfigurationHolder nP;
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
    public final RecordOfString_5 oi;
    @Nullable
    public final String oj;
    @Nullable
    public final String ok;
    @Nullable
    public final String ol;
    @Nullable
    public final String om;
    public final LivingEntityBridge_5 on = new LivingEntityBridge_5(this);
    public final LivingEntityBridge_7 oo = new LivingEntityBridge_7(this);

    public String bj() {
        return this.nO.getNamespacedID();
    }

    public void a(@Nullable LivingEntity livingEntity, @Nullable String string, boolean bl) {
        if (livingEntity == null) {
            return;
        }
        LivingEntityRegistry.a((Entity)livingEntity, this.nO.getNamespacedID());
        if (string != null) {
            LivingEntityRegistry.b((Entity)livingEntity, string);
        }
        if (livingEntity instanceof EnderDragon) {
            ((EnderDragon)livingEntity).setPhase(EnderDragon.Phase.CIRCLING);
        }
        if (this.nX != null && this.nX.floatValue() >= 0.0f) {
            EntityHolder.tK().b(livingEntity, (double)this.nX.floatValue());
        }
        if (this.nY != null && this.nY >= 0.0) {
            EntityHolder.tK().a(livingEntity, this.nY);
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
    public SoundCategoryBridge_2 ar(String string) {
        return (SoundCategoryBridge_2)this.nO.pB.get(string);
    }

    public double ft() {
        return Objects.requireNonNullElse(this.nY, 0.23);
    }

    public float fu() {
        return Objects.requireNonNullElse(this.nX, Float.valueOf(0.0f)).floatValue();
    }

    public void a(Entity entity, InteractEnum interactEnum, Consumer consumer) {
        this.on.a(entity, interactEnum, consumer);
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
    EntityTypeBarStyleHolder(Hitbox hitbox, @Nullable PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, boolean bl, EntityType entityType, BarStyle barStyle, BarColor barColor, boolean bl2, @Nullable Double d, @Nullable Float f, @Nullable Double d2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, double d3, @Nullable RecordOfString_5 recordOfString_5, @Nullable String string2, @Nullable String string3, @Nullable String string4, @Nullable String string5) {
        this.nO = hitbox;
        this.nP = pluginFileConfigurationHolder;
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
        this.oi = recordOfString_5;
        this.oj = string2;
        this.ok = string3;
        this.ol = string4;
        this.om = string5;
    }

    @Generated
    public static EntityTypeBarStyleHolderBuilder fy() {
        return new EntityTypeBarStyleHolderBuilder();
    }

    @Nullable
    @Generated
    public PluginFileConfigurationHolder fz() {
        return this.nP;
    }
}
