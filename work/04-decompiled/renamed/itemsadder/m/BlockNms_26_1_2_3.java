package itemsadder.m;

import itemsadder.m.LivingEntityBridge_8;
import itemsadder.m.LivingEntityWrapper;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PluginContract_4;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import org.bukkit.craftbukkit.entity.CraftMob;
import org.bukkit.entity.LivingEntity;

public class BlockNms_26_1_2_3
extends BodyRotationControl
implements LivingEntityWrapper {
    private final float WY;
    private Mob WX;
    Field WG = VersionHelper_3.a(Mob.class, BodyRotationControl.class);
    Field WH = VersionHelper_3.a(BodyRotationControl.class, Mob.class);
    public float WI;
    public float WJ;
    private float WK;
    private float WL;
    private int WM = 0;

    public BlockNms_26_1_2_3(LivingEntity livingEntity, float f) {
        super(null);
        if (!(livingEntity instanceof CraftMob)) {
            throw new IllegalArgumentException("bukkitEntity must be an instance of CraftMob");
        }
        this.WX = ((CraftMob)livingEntity).getHandle();
        this.WK = this.WX.yBodyRot;
        this.WL = this.WX.yHeadRot;
        this.WI = this.WK;
        this.WJ = this.WL;
        this.WY = f;
        LivingEntityBridge_8.a(livingEntity, this.WH, this.WG, this, this.WX);
    }

    @Override
    public boolean j(LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftMob)) {
            return false;
        }
        this.WX = ((CraftMob)livingEntity).getHandle();
        LivingEntityBridge_8.a(livingEntity, this.WH, this.WG, new BodyRotationControl(this.WX), this.WX);
        return true;
    }

    @PluginContract_4
    public void clientTick() {
        float f = this.WX.getYRot();
        float f2 = this.WX.yHeadRot;
        boolean bl = this.eu();
        if (bl) {
            this.WM = 0;
            this.WK = LocationBridge_2.e(this.WK, f, 0.2f);
            this.WL = LocationBridge_2.e(this.WL, f2, 0.5f);
            this.WI = this.WK;
        } else {
            float f3 = LocationBridge_2.D(f2 - this.WK);
            if (Math.abs(f3) > this.WY) {
                ++this.WM;
                if (this.WM > 10) {
                    this.WI = this.WK = LocationBridge_2.e(this.WK, f2, 0.1f);
                }
            } else {
                this.WM = 0;
            }
            float f4 = LocationBridge_2.D(f2 - this.WI);
            f4 = Mth.clamp((float)f4, (float)(-this.WY), (float)this.WY);
            float f5 = this.WI + f4;
            this.WL = LocationBridge_2.e(this.WL, f5, 0.3f);
        }
        this.WX.yHeadRot = this.WJ = this.WL;
        this.WX.yHeadRotO = this.WJ;
        this.WX.yBodyRot = this.WI;
        this.WX.yBodyRotO = this.WI;
    }

    @Override
    public boolean eu() {
        double d;
        double d2 = this.WX.getX() - this.WX.xo;
        return d2 * d2 + (d = this.WX.getZ() - this.WX.zo) * d > 2.500000277905201E-7;
    }

    @Override
    public float tm() {
        return this.WJ;
    }

    @Override
    public float tn() {
        return this.WI;
    }
}
