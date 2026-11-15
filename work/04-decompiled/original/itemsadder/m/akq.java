package itemsadder.m;

import itemsadder.m.akm;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class akq
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource afQ = this.afR.ek();
    final /* synthetic */ EntityCreature afR;
    final /* synthetic */ int afS;
    final /* synthetic */ int afT;

    akq(akm akm2, EntityCreature entityCreature, int n, int n2) {
        this.afR = entityCreature;
        this.afS = n;
        this.afT = n2;
    }

    public boolean ub() {
        return this.afR.at >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.afR.at + this.afQ.a(this.afS - this.afT + 1) + this.afT;
    }

    private void uh() {
        if (!this.afR.an().D_() && this.afR.bX()) {
            double d = this.afR.dK() + (this.afQ.j() - 0.5) * 32.0;
            double d2 = this.afR.dM() + (double)(this.afQ.a(16) - 8);
            double d3 = this.afR.dQ() + (this.afQ.j() - 0.5) * 32.0;
            this.afR.b(d, d2, d3, true);
        }
    }
}
