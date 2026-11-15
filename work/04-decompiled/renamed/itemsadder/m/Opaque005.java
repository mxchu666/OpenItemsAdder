package itemsadder.m;

import itemsadder.m.BlockNms_26_1_2_24;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.level.gamerules.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class Opaque005
extends TargetGoal {
    private int afC;
    final /* synthetic */ float aiR;

    Opaque005(BlockNms_26_1_2_24 blockNms_26_1_2_24, Mob mob, boolean bl, float f) {
        this.aiR = f;
        super(mob, bl);
    }

    public boolean uj() {
        int n = this.mob.getLastHurtByMobTimestamp();
        LivingEntity livingEntity = this.mob.getLastHurtByMob();
        if (n != this.afC && livingEntity != null) {
            if (livingEntity.getType() == EntityType.PLAYER && ((Boolean)Opaque005.getServerLevel((Entity)this.mob).getGameRules().get(GameRules.UNIVERSAL_ANGER)).booleanValue()) {
                return false;
            }
            this.afC = n;
            if (this.mob.getRandom().nextFloat() < this.aiR) {
                return this.ui();
            }
            return true;
        }
        return false;
    }

    public boolean uk() {
        return false;
    }

    public void hn() {
        this.mob.setTarget(this.mob.getLastHurtByMob(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.targetMob = this.mob.getTarget();
        this.unseenMemoryTicks = 300;
        super.start();
    }

    private boolean ui() {
        double d = this.mob.getX() + (this.mob.getRandom().nextDouble() - 0.5) * 32.0;
        double d2 = this.mob.getY() + (double)(this.mob.getRandom().nextInt(16) - 8);
        double d3 = this.mob.getZ() + (this.mob.getRandom().nextDouble() - 0.5) * 32.0;
        return this.mob.randomTeleport(d, d2, d3, true);
    }
}
