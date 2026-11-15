package itemsadder.m;

import itemsadder.m.BlockNms_1_21_6_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class RandomSourceEntityCreatureHolder_7
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource ahx = this.ahy.ec();
    final /* synthetic */ EntityCreature ahy;
    final /* synthetic */ int ahz;
    final /* synthetic */ int ahA;

    RandomSourceEntityCreatureHolder_7(BlockNms_1_21_6_24 blockNms_1_21_6_24, EntityCreature entityCreature, int n, int n2) {
        this.ahy = entityCreature;
        this.ahz = n;
        this.ahA = n2;
    }

    public boolean ub() {
        return this.ahy.as >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.ahy.as + this.ahx.a(this.ahz - this.ahA + 1) + this.ahA;
    }

    private void uh() {
        if (!this.ahy.ai().B_() && this.ahy.bO()) {
            double d = this.ahy.dC() + (this.ahx.j() - 0.5) * 32.0;
            double d2 = this.ahy.dE() + (double)(this.ahx.a(16) - 8);
            double d3 = this.ahy.dI() + (this.ahx.j() - 0.5) * 32.0;
            this.ahy.b(d, d2, d3, true);
        }
    }
}
