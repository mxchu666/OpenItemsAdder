package itemsadder.m;

import itemsadder.m.BlockNms_26_2_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

class RandomSourcePathfinderMobHolder_3
extends Goal {
    private int afx = 0;
    private final RandomSource ajd = this.aje.getRandom();
    final /* synthetic */ PathfinderMob aje;
    final /* synthetic */ int ajf;
    final /* synthetic */ int ajg;

    RandomSourcePathfinderMobHolder_3(BlockNms_26_2_24 blockNms_26_2_24, PathfinderMob pathfinderMob, int n, int n2) {
        this.aje = pathfinderMob;
        this.ajf = n;
        this.ajg = n2;
    }

    public boolean uj() {
        return this.aje.tickCount >= this.afx;
    }

    public void hn() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.aje.tickCount + this.ajd.nextInt(this.ajf - this.ajg + 1) + this.ajg;
    }

    private void uh() {
        if (!this.aje.level().isClientSide() && this.aje.isAlive()) {
            double d = this.aje.getX() + (this.ajd.nextDouble() - 0.5) * 32.0;
            double d2 = this.aje.getY() + (double)(this.ajd.nextInt(16) - 8);
            double d3 = this.aje.getZ() + (this.ajd.nextDouble() - 0.5) * 32.0;
            this.aje.randomTeleport(d, d2, d3, true);
        }
    }
}
