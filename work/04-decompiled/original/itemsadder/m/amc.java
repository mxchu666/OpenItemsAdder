package itemsadder.m;

import itemsadder.m.ake;
import itemsadder.m.amd;
import itemsadder.m.ame;
import itemsadder.m.amf;
import itemsadder.m.amg;
import itemsadder.m.amh;
import itemsadder.m.hb;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.IEntitySelector;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalAvoidTarget;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBowShoot;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBreakDoor;
import net.minecraft.world.entity.ai.goal.PathfinderGoalDoorOpen;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFloat;
import net.minecraft.world.entity.ai.goal.PathfinderGoalGotoTarget;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomLookaround;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStroll;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRestrictSun;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.ambient.EntityBat;
import net.minecraft.world.entity.animal.EntityBee;
import net.minecraft.world.entity.animal.EntityCat;
import net.minecraft.world.entity.animal.EntityChicken;
import net.minecraft.world.entity.animal.EntityCod;
import net.minecraft.world.entity.animal.EntityCow;
import net.minecraft.world.entity.animal.EntityDolphin;
import net.minecraft.world.entity.animal.EntityFox;
import net.minecraft.world.entity.animal.EntityIronGolem;
import net.minecraft.world.entity.animal.EntityMushroomCow;
import net.minecraft.world.entity.animal.EntityOcelot;
import net.minecraft.world.entity.animal.EntityPanda;
import net.minecraft.world.entity.animal.EntityParrot;
import net.minecraft.world.entity.animal.EntityPig;
import net.minecraft.world.entity.animal.EntityPolarBear;
import net.minecraft.world.entity.animal.EntityPufferFish;
import net.minecraft.world.entity.animal.EntityRabbit;
import net.minecraft.world.entity.animal.EntitySalmon;
import net.minecraft.world.entity.animal.EntitySnowman;
import net.minecraft.world.entity.animal.EntitySquid;
import net.minecraft.world.entity.animal.EntityTropicalFish;
import net.minecraft.world.entity.animal.EntityTurtle;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.EntityHorse;
import net.minecraft.world.entity.animal.horse.EntityHorseDonkey;
import net.minecraft.world.entity.animal.horse.EntityHorseMule;
import net.minecraft.world.entity.animal.horse.EntityHorseSkeleton;
import net.minecraft.world.entity.animal.horse.EntityHorseZombie;
import net.minecraft.world.entity.animal.horse.EntityLlama;
import net.minecraft.world.entity.animal.horse.EntityLlamaTrader;
import net.minecraft.world.entity.animal.sheep.EntitySheep;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.animal.wolf.EntityWolf;
import net.minecraft.world.entity.boss.wither.EntityWither;
import net.minecraft.world.entity.monster.Bogged;
import net.minecraft.world.entity.monster.EntityBlaze;
import net.minecraft.world.entity.monster.EntityCaveSpider;
import net.minecraft.world.entity.monster.EntityCreeper;
import net.minecraft.world.entity.monster.EntityDrowned;
import net.minecraft.world.entity.monster.EntityEnderman;
import net.minecraft.world.entity.monster.EntityEndermite;
import net.minecraft.world.entity.monster.EntityEvoker;
import net.minecraft.world.entity.monster.EntityGhast;
import net.minecraft.world.entity.monster.EntityGiantZombie;
import net.minecraft.world.entity.monster.EntityGuardian;
import net.minecraft.world.entity.monster.EntityGuardianElder;
import net.minecraft.world.entity.monster.EntityIllagerIllusioner;
import net.minecraft.world.entity.monster.EntityMagmaCube;
import net.minecraft.world.entity.monster.EntityMonster;
import net.minecraft.world.entity.monster.EntityPhantom;
import net.minecraft.world.entity.monster.EntityPigZombie;
import net.minecraft.world.entity.monster.EntityPillager;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityShulker;
import net.minecraft.world.entity.monster.EntitySilverfish;
import net.minecraft.world.entity.monster.EntitySkeleton;
import net.minecraft.world.entity.monster.EntitySkeletonStray;
import net.minecraft.world.entity.monster.EntitySkeletonWither;
import net.minecraft.world.entity.monster.EntitySlime;
import net.minecraft.world.entity.monster.EntitySpider;
import net.minecraft.world.entity.monster.EntityStrider;
import net.minecraft.world.entity.monster.EntityVex;
import net.minecraft.world.entity.monster.EntityVindicator;
import net.minecraft.world.entity.monster.EntityWitch;
import net.minecraft.world.entity.monster.EntityZoglin;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.entity.monster.EntityZombieHusk;
import net.minecraft.world.entity.monster.EntityZombieVillager;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.entity.monster.hoglin.EntityHoglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.EntityVillagerTrader;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class amc
implements ake {
    private static final Map ahT = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.ch.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)ahT.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.ch.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = amc.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            amc.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.ch.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            amc.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.ch.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = amc.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            amc.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        a2 = predicate != null ? (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity()) && IEntitySelector.e.test(entityLiving) : (entityLiving, worldServer) -> IEntitySelector.e.test(entityLiving);
        entityInsentient.ch.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.ch.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = amc.l(entityType);
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable hb[] hbArray, @Nullable hb[] hbArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new amd(this, (EntityInsentient)entityCreature, true, hbArray2, hbArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new ame(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            amc.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new amf(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.ch.a(n, (PathfinderGoal)new amg(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.ch.a(n, (PathfinderGoal)new amh(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        ahT.put(EntityTypes.d, Allay.class);
        ahT.put(EntityTypes.f, Armadillo.class);
        ahT.put(EntityTypes.i, Axolotl.class);
        ahT.put(EntityTypes.l, EntityBat.class);
        ahT.put(EntityTypes.m, EntityBee.class);
        ahT.put(EntityTypes.p, EntityBlaze.class);
        ahT.put(EntityTypes.r, Bogged.class);
        ahT.put(EntityTypes.s, Breeze.class);
        ahT.put(EntityTypes.u, Camel.class);
        ahT.put(EntityTypes.v, EntityCat.class);
        ahT.put(EntityTypes.w, EntityCaveSpider.class);
        ahT.put(EntityTypes.A, EntityChicken.class);
        ahT.put(EntityTypes.B, EntityCod.class);
        ahT.put(EntityTypes.D, EntityCow.class);
        ahT.put(EntityTypes.F, EntityCreeper.class);
        ahT.put(EntityTypes.I, EntityDolphin.class);
        ahT.put(EntityTypes.J, EntityHorseDonkey.class);
        ahT.put(EntityTypes.L, EntityDrowned.class);
        ahT.put(EntityTypes.N, EntityGuardianElder.class);
        ahT.put(EntityTypes.O, EntityEnderman.class);
        ahT.put(EntityTypes.P, EntityEndermite.class);
        ahT.put(EntityTypes.T, EntityEvoker.class);
        ahT.put(EntityTypes.ab, EntityFox.class);
        ahT.put(EntityTypes.ac, Frog.class);
        ahT.put(EntityTypes.ae, EntityGhast.class);
        ahT.put(EntityTypes.ag, EntityGiantZombie.class);
        ahT.put(EntityTypes.ai, GlowSquid.class);
        ahT.put(EntityTypes.aj, Goat.class);
        ahT.put(EntityTypes.ak, EntityGuardian.class);
        ahT.put(EntityTypes.al, EntityHoglin.class);
        ahT.put(EntityTypes.an, EntityHorse.class);
        ahT.put(EntityTypes.ao, EntityZombieHusk.class);
        ahT.put(EntityTypes.ap, EntityIllagerIllusioner.class);
        ahT.put(EntityTypes.ar, EntityIronGolem.class);
        ahT.put(EntityTypes.az, EntityLlama.class);
        ahT.put(EntityTypes.aB, EntityMagmaCube.class);
        ahT.put(EntityTypes.aG, EntityMushroomCow.class);
        ahT.put(EntityTypes.aH, EntityHorseMule.class);
        ahT.put(EntityTypes.aK, EntityOcelot.class);
        ahT.put(EntityTypes.aP, EntityPanda.class);
        ahT.put(EntityTypes.aQ, EntityParrot.class);
        ahT.put(EntityTypes.aR, EntityPhantom.class);
        ahT.put(EntityTypes.aS, EntityPig.class);
        ahT.put(EntityTypes.aT, EntityPiglin.class);
        ahT.put(EntityTypes.aU, EntityPiglinBrute.class);
        ahT.put(EntityTypes.aV, EntityPillager.class);
        ahT.put(EntityTypes.aW, EntityPolarBear.class);
        ahT.put(EntityTypes.aZ, EntityPufferFish.class);
        ahT.put(EntityTypes.ba, EntityRabbit.class);
        ahT.put(EntityTypes.bb, EntityRavager.class);
        ahT.put(EntityTypes.bc, EntitySalmon.class);
        ahT.put(EntityTypes.bd, EntitySheep.class);
        ahT.put(EntityTypes.be, EntityShulker.class);
        ahT.put(EntityTypes.bg, EntitySilverfish.class);
        ahT.put(EntityTypes.bh, EntitySkeleton.class);
        ahT.put(EntityTypes.bi, EntityHorseSkeleton.class);
        ahT.put(EntityTypes.bj, EntitySlime.class);
        ahT.put(EntityTypes.bl, Sniffer.class);
        ahT.put(EntityTypes.bn, EntitySnowman.class);
        ahT.put(EntityTypes.bq, EntitySpider.class);
        ahT.put(EntityTypes.bt, EntitySquid.class);
        ahT.put(EntityTypes.bu, EntitySkeletonStray.class);
        ahT.put(EntityTypes.bv, EntityStrider.class);
        ahT.put(EntityTypes.bw, Tadpole.class);
        ahT.put(EntityTypes.bA, EntityLlamaTrader.class);
        ahT.put(EntityTypes.bC, EntityTropicalFish.class);
        ahT.put(EntityTypes.bD, EntityTurtle.class);
        ahT.put(EntityTypes.bE, EntityVex.class);
        ahT.put(EntityTypes.bF, EntityVillager.class);
        ahT.put(EntityTypes.bG, EntityVindicator.class);
        ahT.put(EntityTypes.bH, EntityVillagerTrader.class);
        ahT.put(EntityTypes.bI, Warden.class);
        ahT.put(EntityTypes.bK, EntityWitch.class);
        ahT.put(EntityTypes.bL, EntityWither.class);
        ahT.put(EntityTypes.bM, EntitySkeletonWither.class);
        ahT.put(EntityTypes.bO, EntityWolf.class);
        ahT.put(EntityTypes.bP, EntityZoglin.class);
        ahT.put(EntityTypes.bQ, EntityZombie.class);
        ahT.put(EntityTypes.bR, EntityHorseZombie.class);
        ahT.put(EntityTypes.bS, EntityZombieVillager.class);
        ahT.put(EntityTypes.bT, EntityPigZombie.class);
        ahT.put(EntityTypes.bU, EntityHuman.class);
    }
}
