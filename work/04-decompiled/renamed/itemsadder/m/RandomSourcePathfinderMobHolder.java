package itemsadder.m;

import itemsadder.m.BlockNms_26_1_1_24;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

class RandomSourcePathfinderMobHolder
extends Goal {
    private int afx = 0;
    private final RandomSource aiw = this.aix.getRandom();
    final /* synthetic */ PathfinderMob aix;
    final /* synthetic */ int aiy;
    final /* synthetic */ int aiz;

    RandomSourcePathfinderMobHolder(BlockNms_26_1_1_24 blockNms_26_1_1_24, PathfinderMob pathfinderMob, int n, int n2) {
        this.aix = pathfinderMob;
        this.aiy = n;
        this.aiz = n2;
    }

    public boolean uj() {
        return this.aix.tickCount >= this.afx;
    }

    public void hn() {
        this.uh();
        this.ug();
    }

    private void ug() {
        this.afx = this.aix.tickCount + this.aiw.nextInt(this.aiy - this.aiz + 1) + this.aiz;
    }

    private void uh() {
        if (!this.aix.level().isClientSide() && this.aix.isAlive()) {
            double d = this.aix.getX() + (this.aiw.nextDouble() - 0.5) * 32.0;
            double d2 = this.aix.getY() + (double)(this.aiw.nextInt(16) - 8);
            double d3 = this.aix.getZ() + (this.aiw.nextDouble() - 0.5) * 32.0;
            this.aix.randomTeleport(d, d2, d3, true);
        }
    }
}
