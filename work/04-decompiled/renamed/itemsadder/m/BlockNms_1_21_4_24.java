package itemsadder.m;

import itemsadder.m.EntityCreatureBridge_5;
import itemsadder.m.EntityInsentientBridge_10;
import itemsadder.m.EntityInsentientBridge_9;
import itemsadder.m.EntityInsentientWorldHolder_5;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.RandomSourceEntityCreatureHolder_5;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntitySpawnReason;
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
import net.minecraft.world.entity.animal.EntitySheep;
import net.minecraft.world.entity.animal.EntitySnowman;
import net.minecraft.world.entity.animal.EntitySquid;
import net.minecraft.world.entity.animal.EntityTropicalFish;
import net.minecraft.world.entity.animal.EntityTurtle;
import net.minecraft.world.entity.animal.EntityWolf;
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
import net.minecraft.world.entity.animal.sniffer.Sniffer;
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
import net.minecraft.world.level.World;
import org.bukkit.craftbukkit.v1_21_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_4_24
implements EntityTypeWrapper {
    private static final Map agD = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.bS.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)agD.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.bS.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_1_21_4_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.bS.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.bS.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_4_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        if (predicate != null) {
            a2 = (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity());
        }
        entityInsentient.bS.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.bS.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        WorldServer worldServer = ((CraftWorld)mob.getWorld()).getHandle();
        EntityTypes entityTypes = CraftEntityType.bukkitToMinecraft((EntityType)entityType);
        Entity entity = entityTypes.a((World)worldServer, EntitySpawnReason.n);
        Class<?> clazz = entity.getClass();
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new EntityInsentientBridge_9(this, (EntityInsentient)entityCreature, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new EntityCreatureBridge_5(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_4_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bS.a(n, (PathfinderGoal)new EntityInsentientWorldHolder_5(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bS.a(n, (PathfinderGoal)new RandomSourceEntityCreatureHolder_5(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bS.a(n, (PathfinderGoal)new EntityInsentientBridge_10(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        agD.put(EntityTypes.c, Allay.class);
        agD.put(EntityTypes.e, Armadillo.class);
        agD.put(EntityTypes.h, Axolotl.class);
        agD.put(EntityTypes.k, EntityBat.class);
        agD.put(EntityTypes.l, EntityBee.class);
        agD.put(EntityTypes.o, EntityBlaze.class);
        agD.put(EntityTypes.q, Bogged.class);
        agD.put(EntityTypes.r, Breeze.class);
        agD.put(EntityTypes.t, Camel.class);
        agD.put(EntityTypes.u, EntityCat.class);
        agD.put(EntityTypes.v, EntityCaveSpider.class);
        agD.put(EntityTypes.z, EntityChicken.class);
        agD.put(EntityTypes.A, EntityCod.class);
        agD.put(EntityTypes.C, EntityCow.class);
        agD.put(EntityTypes.E, EntityCreeper.class);
        agD.put(EntityTypes.H, EntityDolphin.class);
        agD.put(EntityTypes.I, EntityHorseDonkey.class);
        agD.put(EntityTypes.K, EntityDrowned.class);
        agD.put(EntityTypes.M, EntityGuardianElder.class);
        agD.put(EntityTypes.N, EntityEnderman.class);
        agD.put(EntityTypes.O, EntityEndermite.class);
        agD.put(EntityTypes.S, EntityEvoker.class);
        agD.put(EntityTypes.aa, EntityFox.class);
        agD.put(EntityTypes.ab, Frog.class);
        agD.put(EntityTypes.ad, EntityGhast.class);
        agD.put(EntityTypes.ae, EntityGiantZombie.class);
        agD.put(EntityTypes.ag, GlowSquid.class);
        agD.put(EntityTypes.ah, Goat.class);
        agD.put(EntityTypes.ai, EntityGuardian.class);
        agD.put(EntityTypes.aj, EntityHoglin.class);
        agD.put(EntityTypes.al, EntityHorse.class);
        agD.put(EntityTypes.am, EntityZombieHusk.class);
        agD.put(EntityTypes.an, EntityIllagerIllusioner.class);
        agD.put(EntityTypes.ap, EntityIronGolem.class);
        agD.put(EntityTypes.ax, EntityLlama.class);
        agD.put(EntityTypes.az, EntityMagmaCube.class);
        agD.put(EntityTypes.aE, EntityMushroomCow.class);
        agD.put(EntityTypes.aF, EntityHorseMule.class);
        agD.put(EntityTypes.aI, EntityOcelot.class);
        agD.put(EntityTypes.aN, EntityPanda.class);
        agD.put(EntityTypes.aO, EntityParrot.class);
        agD.put(EntityTypes.aP, EntityPhantom.class);
        agD.put(EntityTypes.aQ, EntityPig.class);
        agD.put(EntityTypes.aR, EntityPiglin.class);
        agD.put(EntityTypes.aS, EntityPiglinBrute.class);
        agD.put(EntityTypes.aT, EntityPillager.class);
        agD.put(EntityTypes.aU, EntityPolarBear.class);
        agD.put(EntityTypes.aW, EntityPufferFish.class);
        agD.put(EntityTypes.aX, EntityRabbit.class);
        agD.put(EntityTypes.aY, EntityRavager.class);
        agD.put(EntityTypes.aZ, EntitySalmon.class);
        agD.put(EntityTypes.ba, EntitySheep.class);
        agD.put(EntityTypes.bb, EntityShulker.class);
        agD.put(EntityTypes.bd, EntitySilverfish.class);
        agD.put(EntityTypes.be, EntitySkeleton.class);
        agD.put(EntityTypes.bf, EntityHorseSkeleton.class);
        agD.put(EntityTypes.bg, EntitySlime.class);
        agD.put(EntityTypes.bi, Sniffer.class);
        agD.put(EntityTypes.bk, EntitySnowman.class);
        agD.put(EntityTypes.bn, EntitySpider.class);
        agD.put(EntityTypes.bq, EntitySquid.class);
        agD.put(EntityTypes.br, EntitySkeletonStray.class);
        agD.put(EntityTypes.bs, EntityStrider.class);
        agD.put(EntityTypes.bt, Tadpole.class);
        agD.put(EntityTypes.bx, EntityLlamaTrader.class);
        agD.put(EntityTypes.bz, EntityTropicalFish.class);
        agD.put(EntityTypes.bA, EntityTurtle.class);
        agD.put(EntityTypes.bB, EntityVex.class);
        agD.put(EntityTypes.bC, EntityVillager.class);
        agD.put(EntityTypes.bD, EntityVindicator.class);
        agD.put(EntityTypes.bE, EntityVillagerTrader.class);
        agD.put(EntityTypes.bF, Warden.class);
        agD.put(EntityTypes.bH, EntityWitch.class);
        agD.put(EntityTypes.bI, EntityWither.class);
        agD.put(EntityTypes.bJ, EntitySkeletonWither.class);
        agD.put(EntityTypes.bL, EntityWolf.class);
        agD.put(EntityTypes.bM, EntityZoglin.class);
        agD.put(EntityTypes.bN, EntityZombie.class);
        agD.put(EntityTypes.bO, EntityHorseZombie.class);
        agD.put(EntityTypes.bP, EntityZombieVillager.class);
        agD.put(EntityTypes.bQ, EntityPigZombie.class);
        agD.put(EntityTypes.bR, EntityHuman.class);
    }
}
