package itemsadder.m;

import itemsadder.m.alk;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class alo
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource ahg = this.ahh.dY();
    final /* synthetic */ EntityCreature ahh;
    final /* synthetic */ int ahi;
    final /* synthetic */ int ahj;

    alo(alk alk2, EntityCreature entityCreature, int n, int n2) {
        this.ahh = entityCreature;
        this.ahi = n;
        this.ahj = n2;
    }

    public boolean ub() {
        return this.ahh.af >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.ahh.af + this.ahg.a(this.ahi - this.ahj + 1) + this.ahj;
    }

    private void uh() {
        if (!this.ahh.dV().A_() && this.ahh.bJ()) {
            double d = this.ahh.dA() + (this.ahg.j() - 0.5) * 32.0;
            double d2 = this.ahh.dC() + (double)(this.ahg.a(16) - 8);
            double d3 = this.ahh.dG() + (this.ahg.j() - 0.5) * 32.0;
            this.ahh.b(d, d2, d3, true);
        }
    }
}
