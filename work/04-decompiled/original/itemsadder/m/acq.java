package itemsadder.m;

import itemsadder.m.acm;
import itemsadder.m.bcc;
import itemsadder.m.bcg;
import itemsadder.m.zt;
import itemsadder.m.zw;
import java.lang.reflect.Field;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.control.EntityAIBodyControl;
import org.bukkit.craftbukkit.v1_21_R6.entity.CraftMob;
import org.bukkit.entity.LivingEntity;

public class acq
extends EntityAIBodyControl
implements acm {
    private final float WO;
    private EntityInsentient WF;
    Field WG = zw.a(EntityInsentient.class, EntityAIBodyControl.class);
    Field WH = zw.a(EntityAIBodyControl.class, EntityInsentient.class);
    public float WI;
    public float WJ;
    private float WK;
    private float WL;
    private int WM = 0;

    public acq(LivingEntity livingEntity, float f) {
        super(null);
        if (!(livingEntity instanceof CraftMob)) {
            throw new IllegalArgumentException("bukkitEntity must be an instance of CraftMob");
        }
        this.WF = ((CraftMob)livingEntity).getHandle();
        this.WK = this.WF.bB;
        this.WL = this.WF.bD;
        this.WI = this.WK;
        this.WJ = this.WL;
        this.WO = f;
        zt.a(livingEntity, this.WH, this.WG, this, this.WF);
    }

    @Override
    public boolean j(LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftMob)) {
            return false;
        }
        this.WF = ((CraftMob)livingEntity).getHandle();
        zt.a(livingEntity, this.WH, this.WG, new EntityAIBodyControl(this.WF), this.WF);
        return true;
    }

    @bcg
    public void a() {
        float f = this.WF.dX();
        float f2 = this.WF.bD;
        boolean bl = this.eu();
        if (bl) {
            this.WM = 0;
            this.WK = bcc.e(this.WK, f, 0.2f);
            this.WL = bcc.e(this.WL, f2, 0.5f);
            this.WI = this.WK;
        } else {
            float f3 = bcc.D(f2 - this.WK);
            if (Math.abs(f3) > this.WO) {
                ++this.WM;
                if (this.WM > 10) {
                    this.WI = this.WK = bcc.e(this.WK, f2, 0.1f);
                }
            } else {
                this.WM = 0;
            }
            float f4 = bcc.D(f2 - this.WI);
            f4 = MathHelper.a((float)f4, (float)(-this.WO), (float)this.WO);
            float f5 = this.WI + f4;
            this.WL = bcc.e(this.WL, f5, 0.3f);
        }
        this.WF.bD = this.WJ = this.WL;
        this.WF.bE = this.WJ;
        this.WF.bB = this.WI;
        this.WF.bC = this.WI;
    }

    @Override
    public boolean eu() {
        double d;
        double d2 = this.WF.dK() - this.WF.Y;
        return d2 * d2 + (d = this.WF.dQ() - this.WF.aa) * d > 2.500000277905201E-7;
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
