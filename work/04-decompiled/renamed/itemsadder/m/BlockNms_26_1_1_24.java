package itemsadder.m;

import itemsadder.m.EntityTypeBridge;
import itemsadder.m.EntityTypeWrapper;
import itemsadder.m.LivingEntityBridge_2;
import itemsadder.m.MobLevelHolder;
import itemsadder.m.Opaque004;
import itemsadder.m.PathfinderMobBridge;
import itemsadder.m.RandomSourcePathfinderMobHolder;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.bee.Bee;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.cow.MushroomCow;
import net.minecraft.world.entity.animal.dolphin.Dolphin;
import net.minecraft.world.entity.animal.equine.Donkey;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.equine.Llama;
import net.minecraft.world.entity.animal.equine.Mule;
import net.minecraft.world.entity.animal.equine.SkeletonHorse;
import net.minecraft.world.entity.animal.equine.TraderLlama;
import net.minecraft.world.entity.animal.equine.ZombieHorse;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.feline.Ocelot;
import net.minecraft.world.entity.animal.fish.Cod;
import net.minecraft.world.entity.animal.fish.Pufferfish;
import net.minecraft.world.entity.animal.fish.Salmon;
import net.minecraft.world.entity.animal.fish.TropicalFish;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.entity.animal.panda.Panda;
import net.minecraft.world.entity.animal.parrot.Parrot;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.animal.polarbear.PolarBear;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.animal.squid.GlowSquid;
import net.minecraft.world.entity.animal.squid.Squid;
import net.minecraft.world.entity.animal.turtle.Turtle;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.illager.Evoker;
import net.minecraft.world.entity.monster.illager.Illusioner;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.skeleton.Bogged;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.skeleton.Stray;
import net.minecraft.world.entity.monster.skeleton.WitherSkeleton;
import net.minecraft.world.entity.monster.spider.CaveSpider;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.zombie.Drowned;
import net.minecraft.world.entity.monster.zombie.Husk;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import org.bukkit.craftbukkit.entity.CraftEntityType;
import org.bukkit.craftbukkit.entity.CraftMob;
import org.jetbrains.annotations.Nullable;

public class BlockNms_26_1_1_24
implements EntityTypeWrapper {
    private static final Map aik = new HashMap();

    private static void a(Mob mob, Class clazz) {
        mob.goalSelector.removeAllGoals(goal -> goal.getClass().equals(clazz));
    }

    private static Class l(org.bukkit.entity.EntityType entityType) {
        return (Class)aik.get(CraftEntityType.bukkitToMinecraft((org.bukkit.entity.EntityType)entityType));
    }

    @Override
    public void b(org.bukkit.entity.Mob mob) {
        Mob mob2 = ((CraftMob)mob).getHandle();
        mob2.goalSelector.removeAllGoals(goal -> true);
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, org.bukkit.entity.EntityType entityType, float f, float f2, boolean bl2) {
        Class clazz = BlockNms_26_1_1_24.l(entityType);
        Mob mob2 = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a(mob2, LookAtPlayerGoal.class);
        }
        mob2.goalSelector.addGoal(n, (Goal)new LookAtPlayerGoal(mob2, clazz, f, f2, bl2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n) {
        Mob mob2 = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a(mob2, RandomLookAroundGoal.class);
        }
        mob2.goalSelector.addGoal(n, (Goal)new RandomLookAroundGoal(mob2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, double d, int n2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, RandomStrollGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new RandomStrollGoal(pathfinderMob, d, n2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, org.bukkit.entity.EntityType entityType, int n2, boolean bl2, boolean bl3, @Nullable Predicate predicate) {
        Class clazz = BlockNms_26_1_1_24.l(entityType);
        Mob mob2 = ((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a(mob2, NearestAttackableTargetGoal.class);
        }
        TargetingConditions.Selector selector = null;
        selector = predicate != null ? (livingEntity, serverLevel) -> predicate.test(livingEntity.getBukkitLivingEntity()) && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingEntity) : (livingEntity, serverLevel) -> EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingEntity);
        mob2.goalSelector.addGoal(n, (Goal)new NearestAttackableTargetGoal(mob2, clazz, n2, bl2, bl3, selector));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, double d, boolean bl2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, MeleeAttackGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new MeleeAttackGoal(pathfinderMob, d, bl2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, double d, int n2, float f) {
        this.b(mob, bl, n, d, n2, f);
    }

    public void b(org.bukkit.entity.Mob mob, boolean bl, int n, double d, int n2, float f) {
        Monster monster = (Monster)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)monster, RangedBowAttackGoal.class);
        }
        monster.goalSelector.addGoal(n, (Goal)new RangedBowAttackGoal(monster, d, n2, f));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, org.bukkit.entity.EntityType entityType, float f, double d, double d2, @Nullable Predicate predicate) {
        Class clazz = BlockNms_26_1_1_24.l(entityType);
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, AvoidEntityGoal.class);
        }
        Predicate<LivingEntity> predicate2 = predicate != null ? livingEntity -> predicate.test(livingEntity.getBukkitLivingEntity()) : livingEntity -> true;
        pathfinderMob.goalSelector.addGoal(n, (Goal)new AvoidEntityGoal(pathfinderMob, clazz, predicate2, f, d, d2, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, @Nullable EntityTypeBridge[] entityTypeBridgeArray, @Nullable EntityTypeBridge[] entityTypeBridgeArray2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, HurtByTargetGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new LivingEntityBridge_2(this, (Mob)pathfinderMob, true, entityTypeBridgeArray2, entityTypeBridgeArray));
    }

    @Override
    public void b(org.bukkit.entity.Mob mob, boolean bl, int n) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, RestrictSunGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new RestrictSunGoal(pathfinderMob));
    }

    @Override
    public void c(org.bukkit.entity.Mob mob, boolean bl, int n) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, FloatGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new FloatGoal((Mob)pathfinderMob));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, Predicate predicate, double d, int n2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, MoveToBlockGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new PathfinderMobBridge(this, pathfinderMob, d, n2, predicate));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, boolean bl2) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, OpenDoorGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new OpenDoorGoal((Mob)pathfinderMob, bl2));
    }

    @Override
    public void d(org.bukkit.entity.Mob mob, boolean bl, int n) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, BreakDoorGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new BreakDoorGoal((Mob)pathfinderMob, difficulty -> true));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl, int n, Predicate predicate) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        if (bl) {
            BlockNms_26_1_1_24.a((Mob)pathfinderMob, MoveToBlockGoal.class);
        }
        pathfinderMob.goalSelector.addGoal(n, (Goal)new MobLevelHolder(this, mob, predicate));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, int n, int n2, int n3) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        pathfinderMob.goalSelector.addGoal(n, (Goal)new RandomSourcePathfinderMobHolder(this, pathfinderMob, n3, n2));
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, int n, boolean bl, float f) {
        PathfinderMob pathfinderMob = (PathfinderMob)((CraftMob)mob).getHandle();
        pathfinderMob.goalSelector.addGoal(n, (Goal)new Opaque004(this, (Mob)pathfinderMob, bl, f));
    }

    static {
        aik.put(EntityType.ALLAY, Allay.class);
        aik.put(EntityType.ARMADILLO, Armadillo.class);
        aik.put(EntityType.AXOLOTL, Axolotl.class);
        aik.put(EntityType.BAT, Bat.class);
        aik.put(EntityType.BEE, Bee.class);
        aik.put(EntityType.BLAZE, Blaze.class);
        aik.put(EntityType.BOGGED, Bogged.class);
        aik.put(EntityType.BREEZE, Breeze.class);
        aik.put(EntityType.CAMEL, Camel.class);
        aik.put(EntityType.CAT, Cat.class);
        aik.put(EntityType.CAVE_SPIDER, CaveSpider.class);
        aik.put(EntityType.CHICKEN, Chicken.class);
        aik.put(EntityType.COD, Cod.class);
        aik.put(EntityType.COW, Cow.class);
        aik.put(EntityType.CREEPER, Creeper.class);
        aik.put(EntityType.DOLPHIN, Dolphin.class);
        aik.put(EntityType.DONKEY, Donkey.class);
        aik.put(EntityType.DROWNED, Drowned.class);
        aik.put(EntityType.ELDER_GUARDIAN, ElderGuardian.class);
        aik.put(EntityType.ENDERMAN, EnderMan.class);
        aik.put(EntityType.ENDERMITE, Endermite.class);
        aik.put(EntityType.EVOKER, Evoker.class);
        aik.put(EntityType.FOX, Fox.class);
        aik.put(EntityType.FROG, Frog.class);
        aik.put(EntityType.GHAST, Ghast.class);
        aik.put(EntityType.GIANT, Giant.class);
        aik.put(EntityType.GLOW_SQUID, GlowSquid.class);
        aik.put(EntityType.GOAT, Goat.class);
        aik.put(EntityType.GUARDIAN, Guardian.class);
        aik.put(EntityType.HOGLIN, Hoglin.class);
        aik.put(EntityType.HORSE, Horse.class);
        aik.put(EntityType.HUSK, Husk.class);
        aik.put(EntityType.ILLUSIONER, Illusioner.class);
        aik.put(EntityType.IRON_GOLEM, IronGolem.class);
        aik.put(EntityType.LLAMA, Llama.class);
        aik.put(EntityType.MAGMA_CUBE, MagmaCube.class);
        aik.put(EntityType.MOOSHROOM, MushroomCow.class);
        aik.put(EntityType.MULE, Mule.class);
        aik.put(EntityType.OCELOT, Ocelot.class);
        aik.put(EntityType.PANDA, Panda.class);
        aik.put(EntityType.PARROT, Parrot.class);
        aik.put(EntityType.PHANTOM, Phantom.class);
        aik.put(EntityType.PIG, Pig.class);
        aik.put(EntityType.PIGLIN, Piglin.class);
        aik.put(EntityType.PIGLIN_BRUTE, PiglinBrute.class);
        aik.put(EntityType.PILLAGER, Pillager.class);
        aik.put(EntityType.POLAR_BEAR, PolarBear.class);
        aik.put(EntityType.PUFFERFISH, Pufferfish.class);
        aik.put(EntityType.RABBIT, Rabbit.class);
        aik.put(EntityType.RAVAGER, Ravager.class);
        aik.put(EntityType.SALMON, Salmon.class);
        aik.put(EntityType.SHEEP, Sheep.class);
        aik.put(EntityType.SHULKER, Shulker.class);
        aik.put(EntityType.SILVERFISH, Silverfish.class);
        aik.put(EntityType.SKELETON, Skeleton.class);
        aik.put(EntityType.SKELETON_HORSE, SkeletonHorse.class);
        aik.put(EntityType.SLIME, Slime.class);
        aik.put(EntityType.SNIFFER, Sniffer.class);
        aik.put(EntityType.SNOW_GOLEM, SnowGolem.class);
        aik.put(EntityType.SPIDER, Spider.class);
        aik.put(EntityType.SQUID, Squid.class);
        aik.put(EntityType.STRAY, Stray.class);
        aik.put(EntityType.STRIDER, Strider.class);
        aik.put(EntityType.TADPOLE, Tadpole.class);
        aik.put(EntityType.TRADER_LLAMA, TraderLlama.class);
        aik.put(EntityType.TROPICAL_FISH, TropicalFish.class);
        aik.put(EntityType.TURTLE, Turtle.class);
        aik.put(EntityType.VEX, Vex.class);
        aik.put(EntityType.VILLAGER, Villager.class);
        aik.put(EntityType.VINDICATOR, Vindicator.class);
        aik.put(EntityType.WANDERING_TRADER, WanderingTrader.class);
        aik.put(EntityType.WARDEN, Warden.class);
        aik.put(EntityType.WITCH, Witch.class);
        aik.put(EntityType.WITHER, WitherBoss.class);
        aik.put(EntityType.WITHER_SKELETON, WitherSkeleton.class);
        aik.put(EntityType.WOLF, Wolf.class);
        aik.put(EntityType.ZOGLIN, Zoglin.class);
        aik.put(EntityType.ZOMBIE, Zombie.class);
        aik.put(EntityType.ZOMBIE_HORSE, ZombieHorse.class);
        aik.put(EntityType.ZOMBIE_VILLAGER, ZombieVillager.class);
        aik.put(EntityType.ZOMBIFIED_PIGLIN, ZombifiedPiglin.class);
        aik.put(EntityType.PLAYER, Player.class);
    }
}
