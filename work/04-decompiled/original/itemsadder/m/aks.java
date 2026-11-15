package itemsadder.m;

import itemsadder.m.ake;
import itemsadder.m.akt;
import itemsadder.m.aku;
import itemsadder.m.akv;
import itemsadder.m.akw;
import itemsadder.m.akx;
import itemsadder.m.hb;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
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
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.bee.EntityBee;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.chicken.EntityChicken;
import net.minecraft.world.entity.animal.cow.EntityCow;
import net.minecraft.world.entity.animal.cow.EntityMushroomCow;
import net.minecraft.world.entity.animal.dolphin.EntityDolphin;
import net.minecraft.world.entity.animal.equine.EntityHorse;
import net.minecraft.world.entity.animal.equine.EntityHorseDonkey;
import net.minecraft.world.entity.animal.equine.EntityHorseMule;
import net.minecraft.world.entity.animal.equine.EntityHorseSkeleton;
import net.minecraft.world.entity.animal.equine.EntityHorseZombie;
import net.minecraft.world.entity.animal.equine.EntityLlama;
import net.minecraft.world.entity.animal.equine.EntityLlamaTrader;
import net.minecraft.world.entity.animal.feline.EntityCat;
import net.minecraft.world.entity.animal.feline.EntityOcelot;
import net.minecraft.world.entity.animal.fish.EntityCod;
import net.minecraft.world.entity.animal.fish.EntityPufferFish;
import net.minecraft.world.entity.animal.fish.EntitySalmon;
import net.minecraft.world.entity.animal.fish.EntityTropicalFish;
import net.minecraft.world.entity.animal.fox.EntityFox;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.golem.EntityIronGolem;
import net.minecraft.world.entity.animal.golem.EntitySnowman;
import net.minecraft.world.entity.animal.panda.EntityPanda;
import net.minecraft.world.entity.animal.parrot.EntityParrot;
import net.minecraft.world.entity.animal.pig.EntityPig;
import net.minecraft.world.entity.animal.polarbear.EntityPolarBear;
import net.minecraft.world.entity.animal.rabbit.EntityRabbit;
import net.minecraft.world.entity.animal.sheep.EntitySheep;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.animal.squid.EntitySquid;
import net.minecraft.world.entity.animal.squid.GlowSquid;
import net.minecraft.world.entity.animal.turtle.EntityTurtle;
import net.minecraft.world.entity.animal.wolf.EntityWolf;
import net.minecraft.world.entity.boss.wither.EntityWither;
import net.minecraft.world.entity.monster.EntityBlaze;
import net.minecraft.world.entity.monster.EntityCreeper;
import net.minecraft.world.entity.monster.EntityEnderman;
import net.minecraft.world.entity.monster.EntityEndermite;
import net.minecraft.world.entity.monster.EntityGhast;
import net.minecraft.world.entity.monster.EntityGiantZombie;
import net.minecraft.world.entity.monster.EntityGuardian;
import net.minecraft.world.entity.monster.EntityGuardianElder;
import net.minecraft.world.entity.monster.EntityMagmaCube;
import net.minecraft.world.entity.monster.EntityMonster;
import net.minecraft.world.entity.monster.EntityPhantom;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityShulker;
import net.minecraft.world.entity.monster.EntitySilverfish;
import net.minecraft.world.entity.monster.EntitySlime;
import net.minecraft.world.entity.monster.EntityStrider;
import net.minecraft.world.entity.monster.EntityVex;
import net.minecraft.world.entity.monster.EntityWitch;
import net.minecraft.world.entity.monster.EntityZoglin;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.entity.monster.hoglin.EntityHoglin;
import net.minecraft.world.entity.monster.illager.EntityEvoker;
import net.minecraft.world.entity.monster.illager.EntityIllagerIllusioner;
import net.minecraft.world.entity.monster.illager.EntityPillager;
import net.minecraft.world.entity.monster.illager.EntityVindicator;
import net.minecraft.world.entity.monster.piglin.EntityPiglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglinBrute;
import net.minecraft.world.entity.monster.skeleton.Bogged;
import net.minecraft.world.entity.monster.skeleton.EntitySkeleton;
import net.minecraft.world.entity.monster.skeleton.EntitySkeletonStray;
import net.minecraft.world.entity.monster.skeleton.EntitySkeletonWither;
import net.minecraft.world.entity.monster.spider.EntityCaveSpider;
import net.minecraft.world.entity.monster.spider.EntitySpider;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.zombie.EntityDrowned;
import net.minecraft.world.entity.monster.zombie.EntityPigZombie;
import net.minecraft.world.entity.monster.zombie.EntityZombie;
import net.minecraft.world.entity.monster.zombie.EntityZombieHusk;
import net.minecraft.world.entity.monster.zombie.EntityZombieVillager;
import net.minecraft.world.entity.npc.villager.EntityVillager;
import net.minecraft.world.entity.npc.wanderingtrader.EntityVillagerTrader;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class aks
implements ake {
    private static final Map afV = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.cs.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)afV.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.cs.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = aks.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            aks.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.cs.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            aks.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.cs.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = aks.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            aks.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        a2 = predicate != null ? (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity()) && IEntitySelector.e.test(entityLiving) : (entityLiving, worldServer) -> IEntitySelector.e.test(entityLiving);
        entityInsentient.cs.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.cs.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = aks.l(entityType);
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable hb[] hbArray, @Nullable hb[] hbArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new akt(this, (EntityInsentient)entityCreature, true, hbArray2, hbArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new aku(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            aks.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.cs.a(n, (PathfinderGoal)new akv(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.cs.a(n, (PathfinderGoal)new akw(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.cs.a(n, (PathfinderGoal)new akx(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        afV.put(EntityTypes.e, Allay.class);
        afV.put(EntityTypes.g, Armadillo.class);
        afV.put(EntityTypes.j, Axolotl.class);
        afV.put(EntityTypes.m, EntityBat.class);
        afV.put(EntityTypes.n, EntityBee.class);
        afV.put(EntityTypes.q, EntityBlaze.class);
        afV.put(EntityTypes.s, Bogged.class);
        afV.put(EntityTypes.t, Breeze.class);
        afV.put(EntityTypes.v, Camel.class);
        afV.put(EntityTypes.x, EntityCat.class);
        afV.put(EntityTypes.y, EntityCaveSpider.class);
        afV.put(EntityTypes.C, EntityChicken.class);
        afV.put(EntityTypes.D, EntityCod.class);
        afV.put(EntityTypes.G, EntityCow.class);
        afV.put(EntityTypes.I, EntityCreeper.class);
        afV.put(EntityTypes.L, EntityDolphin.class);
        afV.put(EntityTypes.M, EntityHorseDonkey.class);
        afV.put(EntityTypes.O, EntityDrowned.class);
        afV.put(EntityTypes.Q, EntityGuardianElder.class);
        afV.put(EntityTypes.R, EntityEnderman.class);
        afV.put(EntityTypes.S, EntityEndermite.class);
        afV.put(EntityTypes.W, EntityEvoker.class);
        afV.put(EntityTypes.ae, EntityFox.class);
        afV.put(EntityTypes.af, Frog.class);
        afV.put(EntityTypes.ah, EntityGhast.class);
        afV.put(EntityTypes.aj, EntityGiantZombie.class);
        afV.put(EntityTypes.al, GlowSquid.class);
        afV.put(EntityTypes.am, Goat.class);
        afV.put(EntityTypes.an, EntityGuardian.class);
        afV.put(EntityTypes.ao, EntityHoglin.class);
        afV.put(EntityTypes.aq, EntityHorse.class);
        afV.put(EntityTypes.ar, EntityZombieHusk.class);
        afV.put(EntityTypes.as, EntityIllagerIllusioner.class);
        afV.put(EntityTypes.au, EntityIronGolem.class);
        afV.put(EntityTypes.aC, EntityLlama.class);
        afV.put(EntityTypes.aE, EntityMagmaCube.class);
        afV.put(EntityTypes.aK, EntityMushroomCow.class);
        afV.put(EntityTypes.aL, EntityHorseMule.class);
        afV.put(EntityTypes.aP, EntityOcelot.class);
        afV.put(EntityTypes.aU, EntityPanda.class);
        afV.put(EntityTypes.aW, EntityParrot.class);
        afV.put(EntityTypes.aX, EntityPhantom.class);
        afV.put(EntityTypes.aY, EntityPig.class);
        afV.put(EntityTypes.aZ, EntityPiglin.class);
        afV.put(EntityTypes.ba, EntityPiglinBrute.class);
        afV.put(EntityTypes.bb, EntityPillager.class);
        afV.put(EntityTypes.bc, EntityPolarBear.class);
        afV.put(EntityTypes.bf, EntityPufferFish.class);
        afV.put(EntityTypes.bg, EntityRabbit.class);
        afV.put(EntityTypes.bh, EntityRavager.class);
        afV.put(EntityTypes.bi, EntitySalmon.class);
        afV.put(EntityTypes.bj, EntitySheep.class);
        afV.put(EntityTypes.bk, EntityShulker.class);
        afV.put(EntityTypes.bm, EntitySilverfish.class);
        afV.put(EntityTypes.bn, EntitySkeleton.class);
        afV.put(EntityTypes.bo, EntityHorseSkeleton.class);
        afV.put(EntityTypes.bp, EntitySlime.class);
        afV.put(EntityTypes.br, Sniffer.class);
        afV.put(EntityTypes.bt, EntitySnowman.class);
        afV.put(EntityTypes.bw, EntitySpider.class);
        afV.put(EntityTypes.bz, EntitySquid.class);
        afV.put(EntityTypes.bA, EntitySkeletonStray.class);
        afV.put(EntityTypes.bB, EntityStrider.class);
        afV.put(EntityTypes.bC, Tadpole.class);
        afV.put(EntityTypes.bG, EntityLlamaTrader.class);
        afV.put(EntityTypes.bI, EntityTropicalFish.class);
        afV.put(EntityTypes.bJ, EntityTurtle.class);
        afV.put(EntityTypes.bK, EntityVex.class);
        afV.put(EntityTypes.bL, EntityVillager.class);
        afV.put(EntityTypes.bM, EntityVindicator.class);
        afV.put(EntityTypes.bN, EntityVillagerTrader.class);
        afV.put(EntityTypes.bO, Warden.class);
        afV.put(EntityTypes.bQ, EntityWitch.class);
        afV.put(EntityTypes.bR, EntityWither.class);
        afV.put(EntityTypes.bS, EntitySkeletonWither.class);
        afV.put(EntityTypes.bU, EntityWolf.class);
        afV.put(EntityTypes.bV, EntityZoglin.class);
        afV.put(EntityTypes.bW, EntityZombie.class);
        afV.put(EntityTypes.bX, EntityHorseZombie.class);
        afV.put(EntityTypes.bZ, EntityZombieVillager.class);
        afV.put(EntityTypes.ca, EntityPigZombie.class);
        afV.put(EntityTypes.cb, EntityHuman.class);
    }
}
