package itemsadder.m;

import itemsadder.m.LivingEntityBridge_8;
import itemsadder.m.LivingEntityWrapper;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PluginContract_4;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.control.EntityAIBodyControl;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftMob;
import org.bukkit.entity.LivingEntity;

public class BlockNms_1_21_3_3
extends EntityAIBodyControl
implements LivingEntityWrapper {
    private final float WQ;
    private EntityInsentient WF;
    Field WG = VersionHelper_3.a(EntityInsentient.class, EntityAIBodyControl.class);
    Field WH = VersionHelper_3.a(EntityAIBodyControl.class, EntityInsentient.class);
    public float WI;
    public float WJ;
    private float WK;
    private float WL;
    private int WM = 0;

    public BlockNms_1_21_3_3(LivingEntity livingEntity, float f) {
        super(null);
        if (!(livingEntity instanceof CraftMob)) {
            throw new IllegalArgumentException("bukkitEntity must be an instance of CraftMob");
        }
        this.WF = ((CraftMob)livingEntity).getHandle();
        this.WK = this.WF.aX;
        this.WL = this.WF.aZ;
        this.WI = this.WK;
        this.WJ = this.WL;
        this.WQ = f;
        LivingEntityBridge_8.a(livingEntity, this.WH, this.WG, this, this.WF);
    }

    @Override
    public boolean j(LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftMob)) {
            return false;
        }
        this.WF = ((CraftMob)livingEntity).getHandle();
        LivingEntityBridge_8.a(livingEntity, this.WH, this.WG, new EntityAIBodyControl(this.WF), this.WF);
        return true;
    }

    @PluginContract_4
    public void a() {
        float f = this.WF.dM();
        float f2 = this.WF.aZ;
        boolean bl = this.eu();
        if (bl) {
            this.WM = 0;
            this.WK = LocationBridge_2.e(this.WK, f, 0.2f);
            this.WL = LocationBridge_2.e(this.WL, f2, 0.5f);
        } else {
            float f3 = LocationBridge_2.D(f2 - this.WK);
            if (Math.abs(f3) > this.WQ) {
                ++this.WM;
                if (this.WM > 10) {
                    this.WK = LocationBridge_2.e(this.WK, f2, 0.1f);
                }
            } else {
                this.WM = 0;
            }
            float f4 = LocationBridge_2.D(f2 - this.WI);
            f4 = MathHelper.a((float)f4, (float)(-this.WQ), (float)this.WQ);
            float f5 = this.WI + f4;
            this.WL = LocationBridge_2.e(this.WL, f5, 0.3f);
        }
        this.WF.aZ = this.WJ = this.WL;
        this.WF.ba = this.WJ;
        this.WF.aX = this.WI;
        this.WF.aY = this.WI;
    }

    @Override
    public boolean eu() {
        double d;
        double d2 = this.WF.dB() - this.WF.K;
        return d2 * d2 + (d = this.WF.dH() - this.WF.M) * d > 2.500000277905201E-7;
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
