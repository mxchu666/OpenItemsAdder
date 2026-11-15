package itemsadder.m;

import itemsadder.m.EntityCreatureBridge_2;
import itemsadder.m.EntityInsentientBridge_3;
import itemsadder.m.EntityInsentientBridge_4;
import itemsadder.m.EntityInsentientWorldHolder_2;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.RandomSourceEntityCreatureHolder_2;
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
import org.bukkit.craftbukkit.v1_21_R6.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R6.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_10_24
implements EntityTypeWrapper {
    private static final Map afE = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.cq.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)afE.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.cq.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_1_21_10_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.cq.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.cq.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_10_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        a2 = predicate != null ? (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity()) && IEntitySelector.e.test(entityLiving) : (entityLiving, worldServer) -> IEntitySelector.e.test(entityLiving);
        entityInsentient.cq.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.cq.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_10_24.l(entityType);
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new EntityInsentientBridge_3(this, (EntityInsentient)entityCreature, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new EntityCreatureBridge_2(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_10_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.cq.a(n, (PathfinderGoal)new EntityInsentientWorldHolder_2(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.cq.a(n, (PathfinderGoal)new RandomSourceEntityCreatureHolder_2(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.cq.a(n, (PathfinderGoal)new EntityInsentientBridge_4(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        afE.put(EntityTypes.e, Allay.class);
        afE.put(EntityTypes.g, Armadillo.class);
        afE.put(EntityTypes.j, Axolotl.class);
        afE.put(EntityTypes.m, EntityBat.class);
        afE.put(EntityTypes.n, EntityBee.class);
        afE.put(EntityTypes.q, EntityBlaze.class);
        afE.put(EntityTypes.s, Bogged.class);
        afE.put(EntityTypes.t, Breeze.class);
        afE.put(EntityTypes.v, Camel.class);
        afE.put(EntityTypes.w, EntityCat.class);
        afE.put(EntityTypes.x, EntityCaveSpider.class);
        afE.put(EntityTypes.B, EntityChicken.class);
        afE.put(EntityTypes.C, EntityCod.class);
        afE.put(EntityTypes.F, EntityCow.class);
        afE.put(EntityTypes.H, EntityCreeper.class);
        afE.put(EntityTypes.K, EntityDolphin.class);
        afE.put(EntityTypes.L, EntityHorseDonkey.class);
        afE.put(EntityTypes.N, EntityDrowned.class);
        afE.put(EntityTypes.P, EntityGuardianElder.class);
        afE.put(EntityTypes.Q, EntityEnderman.class);
        afE.put(EntityTypes.R, EntityEndermite.class);
        afE.put(EntityTypes.V, EntityEvoker.class);
        afE.put(EntityTypes.ad, EntityFox.class);
        afE.put(EntityTypes.ae, Frog.class);
        afE.put(EntityTypes.ag, EntityGhast.class);
        afE.put(EntityTypes.ai, EntityGiantZombie.class);
        afE.put(EntityTypes.ak, GlowSquid.class);
        afE.put(EntityTypes.al, Goat.class);
        afE.put(EntityTypes.am, EntityGuardian.class);
        afE.put(EntityTypes.an, EntityHoglin.class);
        afE.put(EntityTypes.ap, EntityHorse.class);
        afE.put(EntityTypes.aq, EntityZombieHusk.class);
        afE.put(EntityTypes.ar, EntityIllagerIllusioner.class);
        afE.put(EntityTypes.at, EntityIronGolem.class);
        afE.put(EntityTypes.aB, EntityLlama.class);
        afE.put(EntityTypes.aD, EntityMagmaCube.class);
        afE.put(EntityTypes.aJ, EntityMushroomCow.class);
        afE.put(EntityTypes.aK, EntityHorseMule.class);
        afE.put(EntityTypes.aN, EntityOcelot.class);
        afE.put(EntityTypes.aS, EntityPanda.class);
        afE.put(EntityTypes.aT, EntityParrot.class);
        afE.put(EntityTypes.aU, EntityPhantom.class);
        afE.put(EntityTypes.aV, EntityPig.class);
        afE.put(EntityTypes.aW, EntityPiglin.class);
        afE.put(EntityTypes.aX, EntityPiglinBrute.class);
        afE.put(EntityTypes.aY, EntityPillager.class);
        afE.put(EntityTypes.aZ, EntityPolarBear.class);
        afE.put(EntityTypes.bc, EntityPufferFish.class);
        afE.put(EntityTypes.bd, EntityRabbit.class);
        afE.put(EntityTypes.be, EntityRavager.class);
        afE.put(EntityTypes.bf, EntitySalmon.class);
        afE.put(EntityTypes.bg, EntitySheep.class);
        afE.put(EntityTypes.bh, EntityShulker.class);
        afE.put(EntityTypes.bj, EntitySilverfish.class);
        afE.put(EntityTypes.bk, EntitySkeleton.class);
        afE.put(EntityTypes.bl, EntityHorseSkeleton.class);
        afE.put(EntityTypes.bm, EntitySlime.class);
        afE.put(EntityTypes.bo, Sniffer.class);
        afE.put(EntityTypes.bq, EntitySnowman.class);
        afE.put(EntityTypes.bt, EntitySpider.class);
        afE.put(EntityTypes.bw, EntitySquid.class);
        afE.put(EntityTypes.bx, EntitySkeletonStray.class);
        afE.put(EntityTypes.by, EntityStrider.class);
        afE.put(EntityTypes.bz, Tadpole.class);
        afE.put(EntityTypes.bD, EntityLlamaTrader.class);
        afE.put(EntityTypes.bF, EntityTropicalFish.class);
        afE.put(EntityTypes.bG, EntityTurtle.class);
        afE.put(EntityTypes.bH, EntityVex.class);
        afE.put(EntityTypes.bI, EntityVillager.class);
        afE.put(EntityTypes.bJ, EntityVindicator.class);
        afE.put(EntityTypes.bK, EntityVillagerTrader.class);
        afE.put(EntityTypes.bL, Warden.class);
        afE.put(EntityTypes.bN, EntityWitch.class);
        afE.put(EntityTypes.bO, EntityWither.class);
        afE.put(EntityTypes.bP, EntitySkeletonWither.class);
        afE.put(EntityTypes.bR, EntityWolf.class);
        afE.put(EntityTypes.bS, EntityZoglin.class);
        afE.put(EntityTypes.bT, EntityZombie.class);
        afE.put(EntityTypes.bU, EntityHorseZombie.class);
        afE.put(EntityTypes.bV, EntityZombieVillager.class);
        afE.put(EntityTypes.bW, EntityPigZombie.class);
        afE.put(EntityTypes.bX, EntityHuman.class);
    }
}
