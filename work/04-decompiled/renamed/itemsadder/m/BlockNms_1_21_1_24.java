package itemsadder.m;

import itemsadder.m.EntityCreatureBridge;
import itemsadder.m.EntityInsentientBridge;
import itemsadder.m.EntityInsentientBridge_2;
import itemsadder.m.EntityInsentientWorldHolder;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.RandomSourceEntityCreatureHolder;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;
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
import org.bukkit.craftbukkit.v1_21_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftMob;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_1_24
implements EntityTypeWrapper {
    private static final Map afi = new HashMap();

    private static void a(EntityInsentient entityInsentient, Class clazz) {
        entityInsentient.bW.a((T pathfinderGoal) -> pathfinderGoal.getClass().equals(clazz));
    }

    private static Class l(EntityType entityType) {
        return (Class)afi.get(CraftEntityType.bukkitToMinecraft((EntityType)entityType));
    }

    @Override
    public void b(Mob mob) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        entityInsentient.bW.a((T pathfinderGoal) -> true);
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_1_21_1_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a(entityInsentient, PathfinderGoalLookAtPlayer.class);
        }
        entityInsentient.bW.a(n, (PathfinderGoal)new PathfinderGoalLookAtPlayer(entityInsentient, clazz, f, f2, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n) {
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a(entityInsentient, PathfinderGoalRandomLookaround.class);
        }
        entityInsentient.bW.a(n, (PathfinderGoal)new PathfinderGoalRandomLookaround(entityInsentient));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalRandomStroll.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalRandomStroll(entityCreature, d, n2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_1_21_1_24.l(entityType);
        EntityInsentient entityInsentient = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a(entityInsentient, PathfinderGoalNearestAttackableTarget.class);
        }
        Predicate<EntityLiving> predicate2 = null;
        if (predicate != null) {
            predicate2 = entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity());
        }
        entityInsentient.bW.a(n, (PathfinderGoal)new PathfinderGoalNearestAttackableTarget(entityInsentient, clazz, n2, bl2, bl3, predicate2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalMeleeAttack.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalMeleeAttack(entityCreature, d, bl2));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(Mob mob, boolean bl, int n, double d, int n2, float f) {
        EntityMonster entityMonster = (EntityMonster)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityMonster, PathfinderGoalBowShoot.class);
        }
        entityMonster.bW.a(n, (PathfinderGoal)new PathfinderGoalBowShoot(entityMonster, d, n2, f));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        WorldServer worldServer = ((CraftWorld)mob.getWorld()).getHandle();
        EntityTypes entityTypes = CraftEntityType.bukkitToMinecraft((EntityType)entityType);
        Entity entity = entityTypes.a((World)worldServer);
        Class<?> clazz = entity.getClass();
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalAvoidTarget.class);
        }
        Predicate<EntityLiving> predicate2 = predicate != null ? entityLiving -> predicate.test(entityLiving.getBukkitLivingEntity()) : entityLiving -> true;
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalAvoidTarget(entityCreature, clazz, predicate2, f, d, d2, IEntitySelector.e::test));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalHurtByTarget.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new EntityInsentientBridge(this, (EntityInsentient)entityCreature, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalRestrictSun.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalRestrictSun(entityCreature));
    }

    @Override
    public void c(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalFloat.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)entityCreature));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new EntityCreatureBridge(this, entityCreature, d, n2, predicate));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, boolean bl2) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalDoorOpen.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalDoorOpen((EntityInsentient)entityCreature, bl2));
    }

    @Override
    public void d(Mob mob, boolean bl, int n) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalBreakDoor.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new PathfinderGoalBreakDoor((EntityInsentient)entityCreature, enumDifficulty -> true));
    }

    @Override
    public void a(Mob mob, boolean bl, int n, Predicate predicate) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_1_21_1_24.a((EntityInsentient)entityCreature, PathfinderGoalGotoTarget.class);
        }
        entityCreature.bW.a(n, (PathfinderGoal)new EntityInsentientWorldHolder(this, mob, predicate));
    }

    @Override
    public void a(Mob mob, int n, int n2, int n3) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bW.a(n, (PathfinderGoal)new RandomSourceEntityCreatureHolder(this, entityCreature, n3, n2));
    }

    @Override
    public void a(Mob mob, int n, boolean bl, float f) {
        EntityCreature entityCreature = (EntityCreature)((CraftMob)mob).getHandle();
        entityCreature.bW.a(n, (PathfinderGoal)new EntityInsentientBridge_2(this, (EntityInsentient)entityCreature, bl, f));
    }

    static {
        afi.put(EntityTypes.a, Allay.class);
        afi.put(EntityTypes.c, Armadillo.class);
        afi.put(EntityTypes.f, Axolotl.class);
        afi.put(EntityTypes.g, EntityBat.class);
        afi.put(EntityTypes.h, EntityBee.class);
        afi.put(EntityTypes.i, EntityBlaze.class);
        afi.put(EntityTypes.l, Bogged.class);
        afi.put(EntityTypes.m, Breeze.class);
        afi.put(EntityTypes.o, Camel.class);
        afi.put(EntityTypes.p, EntityCat.class);
        afi.put(EntityTypes.q, EntityCaveSpider.class);
        afi.put(EntityTypes.t, EntityChicken.class);
        afi.put(EntityTypes.u, EntityCod.class);
        afi.put(EntityTypes.w, EntityCow.class);
        afi.put(EntityTypes.x, EntityCreeper.class);
        afi.put(EntityTypes.y, EntityDolphin.class);
        afi.put(EntityTypes.z, EntityHorseDonkey.class);
        afi.put(EntityTypes.B, EntityDrowned.class);
        afi.put(EntityTypes.D, EntityGuardianElder.class);
        afi.put(EntityTypes.H, EntityEnderman.class);
        afi.put(EntityTypes.I, EntityEndermite.class);
        afi.put(EntityTypes.J, EntityEvoker.class);
        afi.put(EntityTypes.Q, EntityFox.class);
        afi.put(EntityTypes.R, Frog.class);
        afi.put(EntityTypes.T, EntityGhast.class);
        afi.put(EntityTypes.U, EntityGiantZombie.class);
        afi.put(EntityTypes.W, GlowSquid.class);
        afi.put(EntityTypes.X, Goat.class);
        afi.put(EntityTypes.Y, EntityGuardian.class);
        afi.put(EntityTypes.Z, EntityHoglin.class);
        afi.put(EntityTypes.ab, EntityHorse.class);
        afi.put(EntityTypes.ac, EntityZombieHusk.class);
        afi.put(EntityTypes.ad, EntityIllagerIllusioner.class);
        afi.put(EntityTypes.af, EntityIronGolem.class);
        afi.put(EntityTypes.an, EntityLlama.class);
        afi.put(EntityTypes.ap, EntityMagmaCube.class);
        afi.put(EntityTypes.as, EntityMushroomCow.class);
        afi.put(EntityTypes.at, EntityHorseMule.class);
        afi.put(EntityTypes.au, EntityOcelot.class);
        afi.put(EntityTypes.aw, EntityPanda.class);
        afi.put(EntityTypes.ax, EntityParrot.class);
        afi.put(EntityTypes.ay, EntityPhantom.class);
        afi.put(EntityTypes.az, EntityPig.class);
        afi.put(EntityTypes.aA, EntityPiglin.class);
        afi.put(EntityTypes.aB, EntityPiglinBrute.class);
        afi.put(EntityTypes.aC, EntityPillager.class);
        afi.put(EntityTypes.aD, EntityPolarBear.class);
        afi.put(EntityTypes.aF, EntityPufferFish.class);
        afi.put(EntityTypes.aG, EntityRabbit.class);
        afi.put(EntityTypes.aH, EntityRavager.class);
        afi.put(EntityTypes.aI, EntitySalmon.class);
        afi.put(EntityTypes.aJ, EntitySheep.class);
        afi.put(EntityTypes.aK, EntityShulker.class);
        afi.put(EntityTypes.aM, EntitySilverfish.class);
        afi.put(EntityTypes.aN, EntitySkeleton.class);
        afi.put(EntityTypes.aO, EntityHorseSkeleton.class);
        afi.put(EntityTypes.aP, EntitySlime.class);
        afi.put(EntityTypes.aR, Sniffer.class);
        afi.put(EntityTypes.aS, EntitySnowman.class);
        afi.put(EntityTypes.aW, EntitySpider.class);
        afi.put(EntityTypes.aX, EntitySquid.class);
        afi.put(EntityTypes.aY, EntitySkeletonStray.class);
        afi.put(EntityTypes.aZ, EntityStrider.class);
        afi.put(EntityTypes.ba, Tadpole.class);
        afi.put(EntityTypes.be, EntityLlamaTrader.class);
        afi.put(EntityTypes.bg, EntityTropicalFish.class);
        afi.put(EntityTypes.bh, EntityTurtle.class);
        afi.put(EntityTypes.bi, EntityVex.class);
        afi.put(EntityTypes.bj, EntityVillager.class);
        afi.put(EntityTypes.bk, EntityVindicator.class);
        afi.put(EntityTypes.bl, EntityVillagerTrader.class);
        afi.put(EntityTypes.bm, Warden.class);
        afi.put(EntityTypes.bo, EntityWitch.class);
        afi.put(EntityTypes.bp, EntityWither.class);
        afi.put(EntityTypes.bq, EntitySkeletonWither.class);
        afi.put(EntityTypes.bs, EntityWolf.class);
        afi.put(EntityTypes.bt, EntityZoglin.class);
        afi.put(EntityTypes.bu, EntityZombie.class);
        afi.put(EntityTypes.bv, EntityHorseZombie.class);
        afi.put(EntityTypes.bw, EntityZombieVillager.class);
        afi.put(EntityTypes.bx, EntityPigZombie.class);
        afi.put(EntityTypes.by, EntityHuman.class);
    }
}
