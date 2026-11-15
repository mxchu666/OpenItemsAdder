package itemsadder.m;

import itemsadder.m.EntityCreatureBridge_4;
import itemsadder.m.EntityInsentientBridge_7;
import itemsadder.m.EntityInsentientBridge_8;
import itemsadder.m.EntityInsentientWorldHolder_4;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.RandomSourceEntityCreatureHolder_4;
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
import org.bukkit.craftbukkit.v1_21_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_3_24
implements EntityTypeWrapper {
    private static final Map agm = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.bT.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)agm.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.bT.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_1_21_3_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.bT.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.bT.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_3_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        PathfinderTargetCondition.a a2 = null;
        if (predicate != null) {
            a2 = (entityLiving, worldServer) -> predicate.test(entityLiving.getBukkitLivingEntity());
        }
        entityInsentient.bT.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, a2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.bT.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        WorldServer worldServer = ((CraftWorld)mob.getWorld()).getHandle();
        EntityTypes entityTypes = CraftEntityType.bukkitToMinecraft((EntityType)entityType);
        Entity entity = entityTypes.a((World)worldServer, EntitySpawnReason.n);
        Class<?> clazz = entity.getClass();
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new EntityInsentientBridge_7(this, (EntityInsentient)entityCreature, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new EntityCreatureBridge_4(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_3_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bT.a(n, (PathfinderGoal)new EntityInsentientWorldHolder_4(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bT.a(n, (PathfinderGoal)new RandomSourceEntityCreatureHolder_4(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bT.a(n, (PathfinderGoal)new EntityInsentientBridge_8(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        agm.put(EntityTypes.c, Allay.class);
        agm.put(EntityTypes.e, Armadillo.class);
        agm.put(EntityTypes.h, Axolotl.class);
        agm.put(EntityTypes.k, EntityBat.class);
        agm.put(EntityTypes.l, EntityBee.class);
        agm.put(EntityTypes.o, EntityBlaze.class);
        agm.put(EntityTypes.q, Bogged.class);
        agm.put(EntityTypes.r, Breeze.class);
        agm.put(EntityTypes.t, Camel.class);
        agm.put(EntityTypes.u, EntityCat.class);
        agm.put(EntityTypes.v, EntityCaveSpider.class);
        agm.put(EntityTypes.z, EntityChicken.class);
        agm.put(EntityTypes.A, EntityCod.class);
        agm.put(EntityTypes.C, EntityCow.class);
        agm.put(EntityTypes.F, EntityCreeper.class);
        agm.put(EntityTypes.I, EntityDolphin.class);
        agm.put(EntityTypes.J, EntityHorseDonkey.class);
        agm.put(EntityTypes.L, EntityDrowned.class);
        agm.put(EntityTypes.N, EntityGuardianElder.class);
        agm.put(EntityTypes.O, EntityEnderman.class);
        agm.put(EntityTypes.P, EntityEndermite.class);
        agm.put(EntityTypes.T, EntityEvoker.class);
        agm.put(EntityTypes.ab, EntityFox.class);
        agm.put(EntityTypes.ac, Frog.class);
        agm.put(EntityTypes.ae, EntityGhast.class);
        agm.put(EntityTypes.af, EntityGiantZombie.class);
        agm.put(EntityTypes.ah, GlowSquid.class);
        agm.put(EntityTypes.ai, Goat.class);
        agm.put(EntityTypes.aj, EntityGuardian.class);
        agm.put(EntityTypes.ak, EntityHoglin.class);
        agm.put(EntityTypes.am, EntityHorse.class);
        agm.put(EntityTypes.an, EntityZombieHusk.class);
        agm.put(EntityTypes.ao, EntityIllagerIllusioner.class);
        agm.put(EntityTypes.aq, EntityIronGolem.class);
        agm.put(EntityTypes.ay, EntityLlama.class);
        agm.put(EntityTypes.aA, EntityMagmaCube.class);
        agm.put(EntityTypes.aF, EntityMushroomCow.class);
        agm.put(EntityTypes.aG, EntityHorseMule.class);
        agm.put(EntityTypes.aJ, EntityOcelot.class);
        agm.put(EntityTypes.aO, EntityPanda.class);
        agm.put(EntityTypes.aP, EntityParrot.class);
        agm.put(EntityTypes.aQ, EntityPhantom.class);
        agm.put(EntityTypes.aR, EntityPig.class);
        agm.put(EntityTypes.aS, EntityPiglin.class);
        agm.put(EntityTypes.aT, EntityPiglinBrute.class);
        agm.put(EntityTypes.aU, EntityPillager.class);
        agm.put(EntityTypes.aV, EntityPolarBear.class);
        agm.put(EntityTypes.aX, EntityPufferFish.class);
        agm.put(EntityTypes.aY, EntityRabbit.class);
        agm.put(EntityTypes.aZ, EntityRavager.class);
        agm.put(EntityTypes.ba, EntitySalmon.class);
        agm.put(EntityTypes.bb, EntitySheep.class);
        agm.put(EntityTypes.bc, EntityShulker.class);
        agm.put(EntityTypes.be, EntitySilverfish.class);
        agm.put(EntityTypes.bf, EntitySkeleton.class);
        agm.put(EntityTypes.bg, EntityHorseSkeleton.class);
        agm.put(EntityTypes.bh, EntitySlime.class);
        agm.put(EntityTypes.bj, Sniffer.class);
        agm.put(EntityTypes.bl, EntitySnowman.class);
        agm.put(EntityTypes.bo, EntitySpider.class);
        agm.put(EntityTypes.br, EntitySquid.class);
        agm.put(EntityTypes.bs, EntitySkeletonStray.class);
        agm.put(EntityTypes.bt, EntityStrider.class);
        agm.put(EntityTypes.bu, Tadpole.class);
        agm.put(EntityTypes.by, EntityLlamaTrader.class);
        agm.put(EntityTypes.bA, EntityTropicalFish.class);
        agm.put(EntityTypes.bB, EntityTurtle.class);
        agm.put(EntityTypes.bC, EntityVex.class);
        agm.put(EntityTypes.bD, EntityVillager.class);
        agm.put(EntityTypes.bE, EntityVindicator.class);
        agm.put(EntityTypes.bF, EntityVillagerTrader.class);
        agm.put(EntityTypes.bG, Warden.class);
        agm.put(EntityTypes.bI, EntityWitch.class);
        agm.put(EntityTypes.bJ, EntityWither.class);
        agm.put(EntityTypes.bK, EntitySkeletonWither.class);
        agm.put(EntityTypes.bM, EntityWolf.class);
        agm.put(EntityTypes.bN, EntityZoglin.class);
        agm.put(EntityTypes.bO, EntityZombie.class);
        agm.put(EntityTypes.bP, EntityHorseZombie.class);
        agm.put(EntityTypes.bQ, EntityZombieVillager.class);
        agm.put(EntityTypes.bR, EntityPigZombie.class);
        agm.put(EntityTypes.bS, EntityHuman.class);
    }
}
