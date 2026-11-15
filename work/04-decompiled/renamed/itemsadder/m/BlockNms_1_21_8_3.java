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
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftMob;
import org.bukkit.entity.LivingEntity;

public class BlockNms_1_21_8_3
extends EntityAIBodyControl
implements LivingEntityWrapper {
    private final float WV;
    private EntityInsentient WF;
    Field WG = VersionHelper_3.a(EntityInsentient.class, EntityAIBodyControl.class);
    Field WH = VersionHelper_3.a(EntityAIBodyControl.class, EntityInsentient.class);
    public float WI;
    public float WJ;
    private float WK;
    private float WL;
    private int WM = 0;

    public BlockNms_1_21_8_3(LivingEntity livingEntity, float f) {
        super(null);
        if (!(livingEntity instanceof CraftMob)) {
            throw new IllegalArgumentException("bukkitEntity must be an instance of CraftMob");
        }
        this.WF = ((CraftMob)livingEntity).getHandle();
        this.WK = this.WF.br;
        this.WL = this.WF.bt;
        this.WI = this.WK;
        this.WJ = this.WL;
        this.WV = f;
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
        float f = this.WF.dP();
        float f2 = this.WF.bt;
        boolean bl = this.eu();
        if (bl) {
            this.WM = 0;
            this.WK = LocationBridge_2.e(this.WK, f, 0.2f);
            this.WL = LocationBridge_2.e(this.WL, f2, 0.5f);
            this.WI = this.WK;
        } else {
            float f3 = LocationBridge_2.D(f2 - this.WK);
            if (Math.abs(f3) > this.WV) {
                ++this.WM;
                if (this.WM > 10) {
                    this.WI = this.WK = LocationBridge_2.e(this.WK, f2, 0.1f);
                }
            } else {
                this.WM = 0;
            }
            float f4 = LocationBridge_2.D(f2 - this.WI);
            f4 = MathHelper.a((float)f4, (float)(-this.WV), (float)this.WV);
            float f5 = this.WI + f4;
            this.WL = LocationBridge_2.e(this.WL, f5, 0.3f);
        }
        this.WF.bt = this.WJ = this.WL;
        this.WF.bu = this.WJ;
        this.WF.br = this.WI;
        this.WF.bs = this.WI;
    }

    @Override
    public boolean eu() {
        double d;
        double d2 = this.WF.dC() - this.WF.X;
        return d2 * d2 + (d = this.WF.dI() - this.WF.Z) * d > 2.500000277905201E-7;
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
