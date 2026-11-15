package itemsadder.m;

import itemsadder.m.BlockNms_1_21_8_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class RandomSourceEntityCreatureHolder_9
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource aif = this.aig.ec();
    final /* synthetic */ EntityCreature aig;
    final /* synthetic */ int aih;
    final /* synthetic */ int aii;

    RandomSourceEntityCreatureHolder_9(BlockNms_1_21_8_24 blockNms_1_21_8_24, EntityCreature entityCreature, int n, int n2) {
        this.aig = entityCreature;
        this.aih = n;
        this.aii = n2;
    }

    public boolean ub() {
        return this.aig.as >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.aig.as + this.aif.a(this.aih - this.aii + 1) + this.aii;
    }

    private void uh() {
        if (!this.aig.ai().B_() && this.aig.bO()) {
            double d = this.aig.dC() + (this.aif.j() - 0.5) * 32.0;
            double d2 = this.aig.dE() + (double)(this.aif.a(16) - 8);
            double d3 = this.aig.dI() + (this.aif.j() - 0.5) * 32.0;
            this.aig.b(d, d2, d3, true);
        }
    }
}
