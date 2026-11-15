package itemsadder.m;

import itemsadder.m.EntityCreatureBridge_6;
import itemsadder.m.EntityInsentientBridge_11;
import itemsadder.m.EntityInsentientBridge_12;
import itemsadder.m.EntityInsentientWorldHolder_6;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.RandomSourceEntityCreatureHolder_6;
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
import org.bukkit.craftbukkit.v1_21_R4.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R4.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_5_24
implements EntityTypeWrapper {
    private static final Map agU = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.bF.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)agU.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.bF.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_1_21_5_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.bF.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.bF.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_5_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        if (predicate != null) {
            a2 = (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity());
        }
        entityInsentient.bF.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.bF.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_5_24.l(entityType);
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new EntityInsentientBridge_11(this, (EntityInsentient)entityCreature, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new EntityCreatureBridge_6(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_5_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bF.a(n, (PathfinderGoal)new EntityInsentientWorldHolder_6(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bF.a(n, (PathfinderGoal)new RandomSourceEntityCreatureHolder_6(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bF.a(n, (PathfinderGoal)new EntityInsentientBridge_12(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        agU.put(EntityTypes.d, Allay.class);
        agU.put(EntityTypes.f, Armadillo.class);
        agU.put(EntityTypes.i, Axolotl.class);
        agU.put(EntityTypes.l, EntityBat.class);
        agU.put(EntityTypes.m, EntityBee.class);
        agU.put(EntityTypes.p, EntityBlaze.class);
        agU.put(EntityTypes.r, Bogged.class);
        agU.put(EntityTypes.s, Breeze.class);
        agU.put(EntityTypes.u, Camel.class);
        agU.put(EntityTypes.v, EntityCat.class);
        agU.put(EntityTypes.w, EntityCaveSpider.class);
        agU.put(EntityTypes.A, EntityChicken.class);
        agU.put(EntityTypes.B, EntityCod.class);
        agU.put(EntityTypes.D, EntityCow.class);
        agU.put(EntityTypes.F, EntityCreeper.class);
        agU.put(EntityTypes.I, EntityDolphin.class);
        agU.put(EntityTypes.J, EntityHorseDonkey.class);
        agU.put(EntityTypes.L, EntityDrowned.class);
        agU.put(EntityTypes.N, EntityGuardianElder.class);
        agU.put(EntityTypes.O, EntityEnderman.class);
        agU.put(EntityTypes.P, EntityEndermite.class);
        agU.put(EntityTypes.T, EntityEvoker.class);
        agU.put(EntityTypes.ab, EntityFox.class);
        agU.put(EntityTypes.ac, Frog.class);
        agU.put(EntityTypes.ae, EntityGhast.class);
        agU.put(EntityTypes.af, EntityGiantZombie.class);
        agU.put(EntityTypes.ah, GlowSquid.class);
        agU.put(EntityTypes.ai, Goat.class);
        agU.put(EntityTypes.aj, EntityGuardian.class);
        agU.put(EntityTypes.ak, EntityHoglin.class);
        agU.put(EntityTypes.am, EntityHorse.class);
        agU.put(EntityTypes.an, EntityZombieHusk.class);
        agU.put(EntityTypes.ao, EntityIllagerIllusioner.class);
        agU.put(EntityTypes.aq, EntityIronGolem.class);
        agU.put(EntityTypes.ay, EntityLlama.class);
        agU.put(EntityTypes.aA, EntityMagmaCube.class);
        agU.put(EntityTypes.aF, EntityMushroomCow.class);
        agU.put(EntityTypes.aG, EntityHorseMule.class);
        agU.put(EntityTypes.aJ, EntityOcelot.class);
        agU.put(EntityTypes.aO, EntityPanda.class);
        agU.put(EntityTypes.aP, EntityParrot.class);
        agU.put(EntityTypes.aQ, EntityPhantom.class);
        agU.put(EntityTypes.aR, EntityPig.class);
        agU.put(EntityTypes.aS, EntityPiglin.class);
        agU.put(EntityTypes.aT, EntityPiglinBrute.class);
        agU.put(EntityTypes.aU, EntityPillager.class);
        agU.put(EntityTypes.aV, EntityPolarBear.class);
        agU.put(EntityTypes.aY, EntityPufferFish.class);
        agU.put(EntityTypes.aZ, EntityRabbit.class);
        agU.put(EntityTypes.ba, EntityRavager.class);
        agU.put(EntityTypes.bb, EntitySalmon.class);
        agU.put(EntityTypes.bc, EntitySheep.class);
        agU.put(EntityTypes.bd, EntityShulker.class);
        agU.put(EntityTypes.bf, EntitySilverfish.class);
        agU.put(EntityTypes.bg, EntitySkeleton.class);
        agU.put(EntityTypes.bh, EntityHorseSkeleton.class);
        agU.put(EntityTypes.bi, EntitySlime.class);
        agU.put(EntityTypes.bk, Sniffer.class);
        agU.put(EntityTypes.bm, EntitySnowman.class);
        agU.put(EntityTypes.bp, EntitySpider.class);
        agU.put(EntityTypes.bs, EntitySquid.class);
        agU.put(EntityTypes.bt, EntitySkeletonStray.class);
        agU.put(EntityTypes.bu, EntityStrider.class);
        agU.put(EntityTypes.bv, Tadpole.class);
        agU.put(EntityTypes.bz, EntityLlamaTrader.class);
        agU.put(EntityTypes.bB, EntityTropicalFish.class);
        agU.put(EntityTypes.bC, EntityTurtle.class);
        agU.put(EntityTypes.bD, EntityVex.class);
        agU.put(EntityTypes.bE, EntityVillager.class);
        agU.put(EntityTypes.bF, EntityVindicator.class);
        agU.put(EntityTypes.bG, EntityVillagerTrader.class);
        agU.put(EntityTypes.bH, Warden.class);
        agU.put(EntityTypes.bJ, EntityWitch.class);
        agU.put(EntityTypes.bK, EntityWither.class);
        agU.put(EntityTypes.bL, EntitySkeletonWither.class);
        agU.put(EntityTypes.bN, EntityWolf.class);
        agU.put(EntityTypes.bO, EntityZoglin.class);
        agU.put(EntityTypes.bP, EntityZombie.class);
        agU.put(EntityTypes.bQ, EntityHorseZombie.class);
        agU.put(EntityTypes.bR, EntityZombieVillager.class);
        agU.put(EntityTypes.bS, EntityPigZombie.class);
        agU.put(EntityTypes.bT, EntityHuman.class);
    }
}
