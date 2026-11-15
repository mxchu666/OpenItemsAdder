package itemsadder.m;

import itemsadder.m.BlockNms_1_21_7_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class RandomSourceEntityCreatureHolder_8
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource ahO = this.ahP.ec();
    final /* synthetic */ EntityCreature ahP;
    final /* synthetic */ int ahQ;
    final /* synthetic */ int ahR;

    RandomSourceEntityCreatureHolder_8(BlockNms_1_21_7_24 blockNms_1_21_7_24, EntityCreature entityCreature, int n, int n2) {
        this.ahP = entityCreature;
        this.ahQ = n;
        this.ahR = n2;
    }

    public boolean ub() {
        return this.ahP.as >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.ahP.as + this.ahO.a(this.ahQ - this.ahR + 1) + this.ahR;
    }

    private void uh() {
        if (!this.ahP.ai().B_() && this.ahP.bO()) {
            double d = this.ahP.dC() + (this.ahO.j() - 0.5) * 32.0;
            double d2 = this.ahP.dE() + (double)(this.ahO.a(16) - 8);
            double d3 = this.ahP.dI() + (this.ahO.j() - 0.5) * 32.0;
            this.ahP.b(d, d2, d3, true);
        }
    }
}
