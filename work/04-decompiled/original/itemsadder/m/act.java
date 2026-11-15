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
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftMob;
import org.bukkit.entity.LivingEntity;

public class act
extends EntityAIBodyControl
implements acm {
    private final float WR;
    private EntityInsentient WF;
    Field WG = zw.a(EntityInsentient.class, EntityAIBodyControl.class);
    Field WH = zw.a(EntityAIBodyControl.class, EntityInsentient.class);
    public float WI;
    public float WJ;
    private float WK;
    private float WL;
    private int WM = 0;

    public act(LivingEntity livingEntity, float f) {
        super(null);
        if (!(livingEntity instanceof CraftMob)) {
            throw new IllegalArgumentException("bukkitEntity must be an instance of CraftMob");
        }
        this.WF = ((CraftMob)livingEntity).getHandle();
        this.WK = this.WF.aX;
        this.WL = this.WF.aZ;
        this.WI = this.WK;
        this.WJ = this.WL;
        this.WR = f;
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
        float f = this.WF.dL();
        float f2 = this.WF.aZ;
        boolean bl = this.eu();
        if (bl) {
            this.WM = 0;
            this.WK = bcc.e(this.WK, f, 0.2f);
            this.WL = bcc.e(this.WL, f2, 0.5f);
        } else {
            float f3 = bcc.D(f2 - this.WK);
            if (Math.abs(f3) > this.WR) {
                ++this.WM;
                if (this.WM > 10) {
                    this.WK = bcc.e(this.WK, f2, 0.1f);
                }
            } else {
                this.WM = 0;
            }
            float f4 = bcc.D(f2 - this.WI);
            f4 = MathHelper.a((float)f4, (float)(-this.WR), (float)this.WR);
            float f5 = this.WI + f4;
            this.WL = bcc.e(this.WL, f5, 0.3f);
        }
        this.WF.aZ = this.WJ = this.WL;
        this.WF.ba = this.WJ;
        this.WF.aX = this.WI;
        this.WF.aY = this.WI;
    }

    @Override
    public boolean eu() {
        double d;
        double d2 = this.WF.dA() - this.WF.K;
        return d2 * d2 + (d = this.WF.dG() - this.WF.M) * d > 2.500000277905201E-7;
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
