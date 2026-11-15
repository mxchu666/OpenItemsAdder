package itemsadder.m;

import itemsadder.m.ale;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class ali
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource agP = this.agQ.dY();
    final /* synthetic */ EntityCreature agQ;
    final /* synthetic */ int agR;
    final /* synthetic */ int agS;

    ali(ale ale2, EntityCreature entityCreature, int n, int n2) {
        this.agQ = entityCreature;
        this.agR = n;
        this.agS = n2;
    }

    public boolean ub() {
        return this.agQ.af >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.agQ.af + this.agP.a(this.agR - this.agS + 1) + this.agS;
    }

    private void uh() {
        if (!this.agQ.dV().B_() && this.agQ.bL()) {
            double d = this.agQ.dA() + (this.agP.j() - 0.5) * 32.0;
            double d2 = this.agQ.dC() + (double)(this.agP.a(16) - 8);
            double d3 = this.agQ.dG() + (this.agP.j() - 0.5) * 32.0;
            this.agQ.b(d, d2, d3, true);
        }
    }
}
