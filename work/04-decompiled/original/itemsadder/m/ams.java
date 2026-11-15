package itemsadder.m;

import itemsadder.m.amo;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

class ams
extends Goal {
    private int afx = 0;
    private final RandomSource aiN = this.aiO.getRandom();
    final /* synthetic */ PathfinderMob aiO;
    final /* synthetic */ int aiP;
    final /* synthetic */ int aiQ;

    ams(amo amo2, PathfinderMob pathfinderMob, int n, int n2) {
        this.aiO = pathfinderMob;
        this.aiP = n;
        this.aiQ = n2;
    }

    public boolean uj() {
        return this.aiO.tickCount >= this.afx;
    }

    public void hn() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.aiO.tickCount + this.aiN.nextInt(this.aiP - this.aiQ + 1) + this.aiQ;
    }

    private void uh() {
        if (!this.aiO.level().isClientSide() && this.aiO.isAlive()) {
            double d = this.aiO.getX() + (this.aiN.nextDouble() - 0.5) * 32.0;
            double d2 = this.aiO.getY() + (double)(this.aiN.nextInt(16) - 8);
            double d3 = this.aiO.getZ() + (this.aiN.nextDouble() - 0.5) * 32.0;
            this.aiO.randomTeleport(d, d2, d3, true);
        }
    }
}
