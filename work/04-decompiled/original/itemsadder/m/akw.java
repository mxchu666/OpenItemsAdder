package itemsadder.m;

import itemsadder.m.aks;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class akw
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource agh = this.agi.ep();
    final /* synthetic */ EntityCreature agi;
    final /* synthetic */ int agj;
    final /* synthetic */ int agk;

    akw(aks aks2, EntityCreature entityCreature, int n, int n2) {
        this.agi = entityCreature;
        this.agj = n;
        this.agk = n2;
    }

    public boolean ub() {
        return this.agi.at >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.agi.at + this.agh.a(this.agj - this.agk + 1) + this.agk;
    }

    private void uh() {
        if (!this.agi.ao().B_() && this.agi.cb()) {
            double d = this.agi.dP() + (this.agh.j() - 0.5) * 32.0;
            double d2 = this.agi.dR() + (double)(this.agh.a(16) - 8);
            double d3 = this.agi.dV() + (this.agh.j() - 0.5) * 32.0;
            this.agi.b(d, d2, d3, true);
        }
    }
}
