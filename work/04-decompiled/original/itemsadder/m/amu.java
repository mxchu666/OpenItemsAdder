package itemsadder.m;

import itemsadder.m.ake;
import itemsadder.m.amv;
import itemsadder.m.amw;
import itemsadder.m.amx;
import itemsadder.m.amy;
import itemsadder.m.amz;
import itemsadder.m.hb;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import org.bukkit.craftbukkit.entity.CraftEntityTypes;
import org.bukkit.craftbukkit.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public class amu
implements ake {
    private static void a(Mob mob, Class clazz) {
        mob.getGoalSelector().removeAllGoals(goal -> goal.getClass().equals(clazz));
    }

    private static Class m(EntityType entityType) {
        return CraftEntityTypes.getEntityTypeData((EntityType)entityType).entityType().getEntityClass();
    }

    @Override
    public void b(org.bukkit.entity.Mob mob) {
        Mob mob2 = ((CraftMob)mob).getHandle();
        mob2.getGoalSelector().removeAllGoals(goal -> true);
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = amu.m(entityType);
        Mob mob2 = ((CraftMob)mob).getHandle();
        if (bl) {
            amu.a(mob2, LookAtPlayerGoal.class);
        }
        mob2.getGoalSelector().addGoal(n, (Goal)new LookAtPlayerGoal(mob2, clazz, f, f2, bl2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n) {
        Mob mob2 = ((CraftMob)mob).getHandle();
        if (bl) {
            amu.a(mob2, RandomLookAroundGoal.class);
        }
        mob2.getGoalSelector().addGoal(n, (Goal)new RandomLookAroundGoal(mob2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, double d, int n2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, RandomStrollGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new RandomStrollGoal(pathfinderMob, d, n2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = amu.m(entityType);
        Mob mob2 = ((CraftMob)mob).getHandle();
        if (bl) {
            amu.a(mob2, NearestAttackableTargetGoal.class);
        }
        TargetingConditions.Selector selector = null;
        selector = predicate != null ? (livingEntity, serverLevel) -> predicate.test(livingEntity.getBukkitLivingEntity()) && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingEntity) : (livingEntity, serverLevel) -> EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingEntity);
        mob2.getGoalSelector().addGoal(n, (Goal)new NearestAttackableTargetGoal(mob2, clazz, n2, bl2, bl3, selector));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, double d, boolean bl2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, MeleeAttackGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new MeleeAttackGoal(pathfinderMob, d, bl2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(org.bukkit.entity.Mob mob, boolean bl, int n, double d, int n2, float f) {
        Monster monster = (Monster)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)monster, RangedBowAttackGoal.class);
        }
        monster.getGoalSelector().addGoal(n, (Goal)new RangedBowAttackGoal(monster, d, n2, f));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = amu.m(entityType);
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, AvoidEntityGoal.class);
        }
        Predicate<LivingEntity> predicate2 = predicate != null ? livingEntity -> predicate.test(livingEntity.getBukkitLivingEntity()) : livingEntity -> true;
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new AvoidEntityGoal(pathfinderMob, clazz, predicate2, f, d, d2, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, @Nullable hb[] hbArray, @Nullable hb[] hbArray2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, HurtByTargetGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new amv(this, (Mob)pathfinderMob, true, hbArray2, hbArray));
    }

    @Override
    public void b(org.bukkit.entity.Mob mob, boolean bl, int n) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, RestrictSunGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new RestrictSunGoal(pathfinderMob));
    }

    @Override
    public void c(org.bukkit.entity.Mob mob, boolean bl, int n) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, FloatGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new FloatGoal((Mob)pathfinderMob));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, MoveToBlockGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new amw(this, pathfinderMob, d, n2, predicate));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, boolean bl2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, OpenDoorGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new OpenDoorGoal((Mob)pathfinderMob, bl2));
    }

    @Override
    public void d(org.bukkit.entity.Mob mob, boolean bl, int n) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, BreakDoorGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new BreakDoorGoal((Mob)pathfinderMob, difficulty -> true));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, Predicate predicate) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            amu.a((Mob)pathfinderMob, MoveToBlockGoal.class);
        }
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new amx(this, mob, predicate));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, int n, int n2, int n3) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new amy(this, pathfinderMob, n3, n2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, int n, boolean bl, float f) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        pathfinderMob.getGoalSelector().addGoal(n, (Goal)new amz(this, (Mob)pathfinderMob, bl, f));
    }
}
