package itemsadder.m;

import itemsadder.m.BlockNms_1_21_3_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

class RandomSourceEntityCreatureHolder_4
extends PathfinderGoal {
    private int afx = 0;
    private final RandomSource agy = this.agz.dZ();
    final /* synthetic */ EntityCreature agz;
    final /* synthetic */ int agA;
    final /* synthetic */ int agB;

    RandomSourceEntityCreatureHolder_4(BlockNms_1_21_3_24 blockNms_1_21_3_24, EntityCreature entityCreature, int n, int n2) {
        this.agz = entityCreature;
        this.agA = n;
        this.agB = n2;
    }

    public boolean ub() {
        return this.agz.af >= this.afx;
    }

    public void uc() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.agz.af + this.agy.a(this.agA - this.agB + 1) + this.agB;
    }

    private void uh() {
        if (!this.agz.dW().B_() && this.agz.bL()) {
            double d = this.agz.dB() + (this.agy.j() - 0.5) * 32.0;
            double d2 = this.agz.dD() + (double)(this.agy.a(16) - 8);
            double d3 = this.agz.dH() + (this.agy.j() - 0.5) * 32.0;
            this.agz.b(d, d2, d3, true);
        }
    }
}
