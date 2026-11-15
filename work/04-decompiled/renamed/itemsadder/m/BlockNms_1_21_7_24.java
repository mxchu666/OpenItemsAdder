package itemsadder.m;

import itemsadder.m.EntityCreatureBridge_8;
import itemsadder.m.EntityInsentientBridge_15;
import itemsadder.m.EntityInsentientBridge_16;
import itemsadder.m.EntityInsentientWorldHolder_8;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.RandomSourceEntityCreatureHolder_8;
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

public class BlockNms_1_21_7_24
implements EntityTypeWrapper {
    private static final Map ahC = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.ch.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)ahC.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.ch.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_1_21_7_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.ch.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.ch.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_7_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        a2 = predicate != null ? (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity()) && IEntitySelector.e.test(entityLiving) : (entityLiving, worldServer) -> IEntitySelector.e.test(entityLiving);
        entityInsentient.ch.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
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
            BlockNms_1_21_7_24.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.ch.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_7_24.l(entityType);
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new EntityInsentientBridge_15(this, (EntityInsentient)entityCreature, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new EntityCreatureBridge_8(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_7_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.ch.a(n, (PathfinderGoal)new EntityInsentientWorldHolder_8(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.ch.a(n, (PathfinderGoal)new RandomSourceEntityCreatureHolder_8(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.ch.a(n, (PathfinderGoal)new EntityInsentientBridge_16(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        ahC.put(EntityTypes.d, Allay.class);
        ahC.put(EntityTypes.f, Armadillo.class);
        ahC.put(EntityTypes.i, Axolotl.class);
        ahC.put(EntityTypes.l, EntityBat.class);
        ahC.put(EntityTypes.m, EntityBee.class);
        ahC.put(EntityTypes.p, EntityBlaze.class);
        ahC.put(EntityTypes.r, Bogged.class);
        ahC.put(EntityTypes.s, Breeze.class);
        ahC.put(EntityTypes.u, Camel.class);
        ahC.put(EntityTypes.v, EntityCat.class);
        ahC.put(EntityTypes.w, EntityCaveSpider.class);
        ahC.put(EntityTypes.A, EntityChicken.class);
        ahC.put(EntityTypes.B, EntityCod.class);
        ahC.put(EntityTypes.D, EntityCow.class);
        ahC.put(EntityTypes.F, EntityCreeper.class);
        ahC.put(EntityTypes.I, EntityDolphin.class);
        ahC.put(EntityTypes.J, EntityHorseDonkey.class);
        ahC.put(EntityTypes.L, EntityDrowned.class);
        ahC.put(EntityTypes.N, EntityGuardianElder.class);
        ahC.put(EntityTypes.O, EntityEnderman.class);
        ahC.put(EntityTypes.P, EntityEndermite.class);
        ahC.put(EntityTypes.T, EntityEvoker.class);
        ahC.put(EntityTypes.ab, EntityFox.class);
        ahC.put(EntityTypes.ac, Frog.class);
        ahC.put(EntityTypes.ae, EntityGhast.class);
        ahC.put(EntityTypes.ag, EntityGiantZombie.class);
        ahC.put(EntityTypes.ai, GlowSquid.class);
        ahC.put(EntityTypes.aj, Goat.class);
        ahC.put(EntityTypes.ak, EntityGuardian.class);
        ahC.put(EntityTypes.al, EntityHoglin.class);
        ahC.put(EntityTypes.an, EntityHorse.class);
        ahC.put(EntityTypes.ao, EntityZombieHusk.class);
        ahC.put(EntityTypes.ap, EntityIllagerIllusioner.class);
        ahC.put(EntityTypes.ar, EntityIronGolem.class);
        ahC.put(EntityTypes.az, EntityLlama.class);
        ahC.put(EntityTypes.aB, EntityMagmaCube.class);
        ahC.put(EntityTypes.aG, EntityMushroomCow.class);
        ahC.put(EntityTypes.aH, EntityHorseMule.class);
        ahC.put(EntityTypes.aK, EntityOcelot.class);
        ahC.put(EntityTypes.aP, EntityPanda.class);
        ahC.put(EntityTypes.aQ, EntityParrot.class);
        ahC.put(EntityTypes.aR, EntityPhantom.class);
        ahC.put(EntityTypes.aS, EntityPig.class);
        ahC.put(EntityTypes.aT, EntityPiglin.class);
        ahC.put(EntityTypes.aU, EntityPiglinBrute.class);
        ahC.put(EntityTypes.aV, EntityPillager.class);
        ahC.put(EntityTypes.aW, EntityPolarBear.class);
        ahC.put(EntityTypes.aZ, EntityPufferFish.class);
        ahC.put(EntityTypes.ba, EntityRabbit.class);
        ahC.put(EntityTypes.bb, EntityRavager.class);
        ahC.put(EntityTypes.bc, EntitySalmon.class);
        ahC.put(EntityTypes.bd, EntitySheep.class);
        ahC.put(EntityTypes.be, EntityShulker.class);
        ahC.put(EntityTypes.bg, EntitySilverfish.class);
        ahC.put(EntityTypes.bh, EntitySkeleton.class);
        ahC.put(EntityTypes.bi, EntityHorseSkeleton.class);
        ahC.put(EntityTypes.bj, EntitySlime.class);
        ahC.put(EntityTypes.bl, Sniffer.class);
        ahC.put(EntityTypes.bn, EntitySnowman.class);
        ahC.put(EntityTypes.bq, EntitySpider.class);
        ahC.put(EntityTypes.bt, EntitySquid.class);
        ahC.put(EntityTypes.bu, EntitySkeletonStray.class);
        ahC.put(EntityTypes.bv, EntityStrider.class);
        ahC.put(EntityTypes.bw, Tadpole.class);
        ahC.put(EntityTypes.bA, EntityLlamaTrader.class);
        ahC.put(EntityTypes.bC, EntityTropicalFish.class);
        ahC.put(EntityTypes.bD, EntityTurtle.class);
        ahC.put(EntityTypes.bE, EntityVex.class);
        ahC.put(EntityTypes.bF, EntityVillager.class);
        ahC.put(EntityTypes.bG, EntityVindicator.class);
        ahC.put(EntityTypes.bH, EntityVillagerTrader.class);
        ahC.put(EntityTypes.bI, Warden.class);
        ahC.put(EntityTypes.bK, EntityWitch.class);
        ahC.put(EntityTypes.bL, EntityWither.class);
        ahC.put(EntityTypes.bM, EntitySkeletonWither.class);
        ahC.put(EntityTypes.bO, EntityWolf.class);
        ahC.put(EntityTypes.bP, EntityZoglin.class);
        ahC.put(EntityTypes.bQ, EntityZombie.class);
        ahC.put(EntityTypes.bR, EntityHorseZombie.class);
        ahC.put(EntityTypes.bS, EntityZombieVillager.class);
        ahC.put(EntityTypes.bT, EntityPigZombie.class);
        ahC.put(EntityTypes.bU, EntityHuman.class);
    }
}
