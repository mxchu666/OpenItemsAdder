package itemsadder.m;

import itemsadder.m.BlockNms_1_21_1_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class RandomSourceEntityCreatureHolder
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource afy = this.afz.dR();
    final /* synthetic */ EntityCreature afz;
    final /* synthetic */ int afA;
    final /* synthetic */ int afB;

    RandomSourceEntityCreatureHolder(BlockNms_1_21_1_24 blockNms_1_21_1_24, EntityCreature entityCreature, int n, int n2) {
        this.afz = entityCreature;
        this.afA = n;
        this.afB = n2;
    }

    public boolean ub() {
        return this.afz.ai >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.afz.ai + this.afy.a(this.afA - this.afB + 1) + this.afB;
    }

    private void uh() {
        if (!this.afz.dO().x_() && this.afz.bE()) {
            double d = this.afz.dt() + (this.afy.j() - 0.5) * 32.0;
            double d2 = this.afz.dv() + (double)(this.afy.a(16) - 8);
            double d3 = this.afz.dz() + (this.afy.j() - 0.5) * 32.0;
            this.afz.b(d, d2, d3, true);
        }
    }
}
