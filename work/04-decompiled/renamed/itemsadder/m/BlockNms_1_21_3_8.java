package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.mojang.datafixers.util.Pair;
import itemsadder.m.BlockNms_1_21_3_2;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityBridge_5;
import itemsadder.m.EntityWrapper;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MonsterEnum;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.network.protocol.game.PacketPlayOutUpdateAttributes;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.network.syncher.DataWatcherObject;
import net.minecraft.server.level.ChunkProviderServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.EntityAttachments;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntitySize;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EnumCreatureType;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.IEntityAngerable;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalArrowAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalCrossbowAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalSelector;
import net.minecraft.world.entity.monster.EntityShulker;
import net.minecraft.world.entity.projectile.EntityArrow;
import net.minecraft.world.entity.projectile.EntityTippedArrow;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.World;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import net.minecraft.world.phys.AxisAlignedBB;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_21_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R2.attribute.CraftAttribute;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftArrow;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftEntityType;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftMob;
import org.bukkit.craftbukkit.v1_21_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R2.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class BlockNms_1_21_3_8
implements EntityWrapper {
    static net.minecraft.world.item.ItemStack abs = Items.a.n();
    static List abt = new ArrayList();
    Field abu = VersionHelper_3.a(net.minecraft.world.entity.Entity.class, EntitySize.class);
    static Method abv;
    DataWatcherObject abw = (DataWatcherObject)VersionHelper_3.a(net.minecraft.world.entity.Entity.class, DataWatcherObject.class, 0);

    @Override
    public void a(Entity entity, float f) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        if (entity2.dM() == f) {
            return;
        }
        entity2.v(f);
        if (entity.getType() != EntityType.ARMOR_STAND) {
            PacketPlayOutEntityHeadRotation packetPlayOutEntityHeadRotation = new PacketPlayOutEntityHeadRotation(entity2, (byte)(f * 256.0f / 360.0f));
            BukkitTaskBridge.i(() -> {
                for (Player player : LocationBridge_2.a(entity.getLocation(), 25)) {
                    PacketListenerRegistry.uN().d(player, packetPlayOutEntityHeadRotation);
                }
            });
        }
    }

    @Override
    public float L(Entity entity) {
        return ((CraftEntity)entity).getHandle().cA();
    }

    @Override
    public float M(Entity entity) {
        if (entity instanceof LivingEntity) {
            return ((CraftLivingEntity)entity).getHandle().aX;
        }
        return ((CraftEntity)entity).getHandle().dM();
    }

    @Override
    public void c(Entity entity, float f) {
        ((CraftEntity)entity).getHandle().r(f);
    }

    @Override
    public void b(Entity entity, boolean bl) {
        ((CraftEntity)entity).getHandle().k(bl);
        this.N(entity);
    }

    @Override
    public void N(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(entity2.ar(), entity2.au().c());
        ((ChunkProviderServer)entity2.dW().R()).a.a(entity2, (Packet)packetPlayOutEntityMetadata);
        PacketListenerRegistry.uN().b(entity2, packetPlayOutEntityMetadata);
    }

    @Override
    public void b(Entity entity, float f) {
        ((CraftLivingEntity)entity).getHandle().g(GenericAttributes.B).a((double)f);
    }

    @Override
    public void a(Entity entity, double d, double d2, double d3) {
        ((CraftEntity)entity).getHandle().a(new AxisAlignedBB(entity.getLocation().getX() - d / 2.0, entity.getLocation().getY(), entity.getLocation().getZ() - d3 / 2.0, entity.getLocation().getX() + d / 2.0, entity.getLocation().getY() + d2, entity.getLocation().getZ() + d3 / 2.0));
    }

    @Override
    public void b(Entity entity, double d, double d2, double d3, double d4, double d5, double d6) {
        ((CraftEntity)entity).getHandle().a(new AxisAlignedBB(d, d3, d5, d2, d4, d6));
    }

    @Override
    public void a(Entity entity, double d, double d2, double d3, float f, float f2, boolean bl) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        if (bl) {
            entity2.a(EntityInLevelCallback.a);
        }
        entity2.a(d, d2, d3, f, f2);
        entity2.q(f);
    }

    @Override
    public void b(Entity entity, double d, double d2, double d3) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.h(d, d2, d3);
    }

    @Override
    public void O(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.a(EntityInLevelCallback.a);
    }

    @Override
    public void a(Mob mob, boolean bl) {
        ((CraftMob)mob).getHandle().aware = bl;
    }

    @Override
    public void a(Entity entity, float f, float f2) {
        if (this.abu == null) {
            throw new RuntimeException("Can't set entity dimensions");
        }
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        VersionHelper_3.a(this.abu, entity2, (Object)new EntitySize(f, f2, entity2.cS(), EntityAttachments.a((float)f, (float)f2), true));
        entity2.b(entity2.du());
    }

    @Override
    public boolean P(Entity entity) {
        return entity instanceof CraftMob;
    }

    @Override
    public void f(Player player, int n) {
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[]{n});
        PacketListenerRegistry.uN().d(player, packetPlayOutEntityDestroy);
    }

    @Override
    public void a(Player player, int ... nArray) {
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(nArray);
        PacketListenerRegistry.uN().d(player, packetPlayOutEntityDestroy);
    }

    @Override
    public ItemStack d(Projectile projectile) {
        if (abv == null) {
            return null;
        }
        if (projectile instanceof CraftArrow) {
            CraftArrow craftArrow = (CraftArrow)projectile;
            try {
                EntityTippedArrow entityTippedArrow = craftArrow.getHandle();
                return CraftItemStack.asBukkitCopy((net.minecraft.world.item.ItemStack)((net.minecraft.world.item.ItemStack)abv.invoke((Object)entityTippedArrow, new Object[0])));
            }
            catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
                reflectiveOperationException.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void a(Entity entity, byte by) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.dW().a(entity2, by);
    }

    @Override
    public int V(Location location) {
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        EntityShulker entityShulker = new EntityShulker(EntityTypes.bc, (World)worldServer);
        entityShulker.a_(location.getX(), location.getY(), location.getZ());
        entityShulker.k(true);
        entityShulker.f(true);
        entityShulker.n(true);
        entityShulker.h(Vec3D.c);
        entityShulker.j(true);
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = new PacketPlayOutSpawnEntity(entityShulker.ar(), entityShulker.cG(), entityShulker.dv().a(), entityShulker.dv().b(), entityShulker.dv().c(), entityShulker.dO(), entityShulker.cA(), entityShulker.aq(), 0, entityShulker.dz(), (double)entityShulker.cA());
        List list = entityShulker.au().b();
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(entityShulker.ar(), list);
        for (EntityPlayer entityPlayer : worldServer.y()) {
            if (!(entityPlayer.f((net.minecraft.world.entity.Entity)entityShulker) < 128.0f)) continue;
            entityPlayer.f.b((Packet)packetPlayOutSpawnEntity);
            entityPlayer.f.b((Packet)packetPlayOutEntityMetadata);
        }
        return entityShulker.ar();
    }

    @Override
    public void a(Player player, LivingEntity livingEntity) {
        EntityLiving entityLiving = ((CraftLivingEntity)livingEntity).getHandle();
        entityLiving.g(GenericAttributes.s).a(1.0);
        PacketPlayOutUpdateAttributes packetPlayOutUpdateAttributes = new PacketPlayOutUpdateAttributes(entityLiving.ar(), entityLiving.eY().c());
        PacketListenerRegistry.uN().d(player, packetPlayOutUpdateAttributes);
    }

    @Override
    public void a(PacketEvent packetEvent, boolean bl) {
        PacketContainer packetContainer = packetEvent.getPacket();
        Entity entity = (Entity)packetContainer.getEntityModifier(packetEvent.getPlayer().getWorld()).read(0);
        if (entity == null) {
            return;
        }
        EntityLiving entityLiving = ((CraftLivingEntity)entity).getHandle();
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = (PacketPlayOutEntityMetadata)packetContainer.getHandle();
        ArrayList<DataWatcher.c> arrayList = packetPlayOutEntityMetadata.e();
        if (arrayList.isEmpty()) {
            return;
        }
        DataWatcher.c c2 = DataWatcher.c.a((DataWatcherObject)this.abw, (Object)this.a(bl, (Byte)entityLiving.au().a(this.abw), 5));
        for (int i = 0; i < arrayList.size(); ++i) {
            DataWatcher.c c3 = (DataWatcher.c)arrayList.get(i);
            if (c3.a() != 0) continue;
            try {
                arrayList.set(i, c2);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                arrayList = new ArrayList<DataWatcher.c>(packetPlayOutEntityMetadata.e());
                arrayList.set(i, c2);
            }
            return;
        }
        arrayList.add(c2);
    }

    @Override
    public void c(LivingEntity livingEntity, boolean bl) {
        EntityLiving entityLiving = ((CraftLivingEntity)livingEntity).getHandle();
        PacketListenerRegistry.uN().b(entityLiving, new PacketPlayOutEntityMetadata(entityLiving.ar(), List.of(DataWatcher.c.a((DataWatcherObject)this.abw, (Object)this.a(bl, (Byte)entityLiving.au().a(this.abw), 5)))));
    }

    private byte a(boolean bl, byte by, int n) {
        if (bl) {
            return (byte)(by | 1 << n);
        }
        return (byte)(by & ~(1 << n));
    }

    @Override
    public void bM(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(player.getEntityId(), abt);
        PacketListenerRegistry.a(packetPlayOutEntityEquipment, true);
        ((ChunkProviderServer)entityPlayer.dW().R()).a.a((net.minecraft.world.entity.Entity)entityPlayer, (Packet)packetPlayOutEntityEquipment);
        entityPlayer.f.b((Packet)packetPlayOutEntityEquipment);
    }

    @Override
    public void bN(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        for (EnumItemSlot enumItemSlot : EnumItemSlot.values()) {
            net.minecraft.world.item.ItemStack itemStack = entityPlayer.a(enumItemSlot);
            arrayList.add(new Pair((Object)enumItemSlot, (Object)itemStack));
        }
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(player.getEntityId(), arrayList);
        ((ChunkProviderServer)entityPlayer.dW().R()).a.a((net.minecraft.world.entity.Entity)entityPlayer, (Packet)packetPlayOutEntityEquipment);
        entityPlayer.f.b((Packet)packetPlayOutEntityEquipment);
    }

    @Override
    public boolean a(Entity entity, EntityBridge_5 entityBridge_5) {
        EntityLiving entityLiving = ((CraftLivingEntity)entity).getHandle();
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        entityLiving.f(nBTTagCompound);
        return BlockNms_1_21_3_2.a(nBTTagCompound, entityBridge_5);
    }

    @Override
    public boolean R(Entity entity) {
        if (entity instanceof Mob) {
            Mob mob = (Mob)entity;
            LivingEntity livingEntity = mob.getTarget();
            if (livingEntity == null || livingEntity.isDead()) {
                return false;
            }
            EntityInsentient entityInsentient = ((CraftMob)entity).getHandle();
            PathfinderGoalSelector pathfinderGoalSelector = entityInsentient.bT;
            return pathfinderGoalSelector.b().stream().anyMatch(pathfinderGoalWrapped -> {
                PathfinderGoal pathfinderGoal = pathfinderGoalWrapped.k();
                return pathfinderGoal instanceof PathfinderGoalMeleeAttack || pathfinderGoal instanceof PathfinderGoalArrowAttack || pathfinderGoal instanceof PathfinderGoalCrossbowAttack;
            });
        }
        return false;
    }

    @Override
    public void a(LivingEntity livingEntity, NamespacedKey namespacedKey, double d) {
        try {
            Attribute attribute = CraftAttribute.stringToBukkit((String)namespacedKey.toString());
            AttributeInstance attributeInstance = livingEntity.getAttribute(attribute);
            if (attributeInstance == null) {
                return;
            }
            attributeInstance.setBaseValue(d);
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Failed to set attribute " + String.valueOf(namespacedKey) + " to entity " + String.valueOf(livingEntity.getType()) + ". Error: " + exception.getMessage());
        }
    }

    @Override
    public Location l(LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftMob)) {
            return null;
        }
        EntityInsentient entityInsentient = ((CraftMob)livingEntity).getHandle();
        if (entityInsentient.H().e() == 0.0 && entityInsentient.H().f() == 0.0 && entityInsentient.H().g() == 0.0) {
            return null;
        }
        if (entityInsentient.O_() != null && entityInsentient.O_().bL()) {
            return new Location(livingEntity.getWorld(), entityInsentient.O_().bF().d, entityInsentient.O_().bF().e, entityInsentient.O_().bF().f, livingEntity.getLocation().getYaw(), livingEntity.getLocation().getPitch());
        }
        return new Location(livingEntity.getWorld(), entityInsentient.H().e(), entityInsentient.H().f(), entityInsentient.H().g(), livingEntity.getLocation().getYaw(), livingEntity.getLocation().getPitch());
    }

    @Override
    public boolean m(@UnknownNullability LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftLivingEntity)) {
            return false;
        }
        EntityLiving entityLiving = ((CraftLivingEntity)livingEntity).getHandle();
        return entityLiving.bn || !entityLiving.aJ() && entityLiving.dz().e < -0.08;
    }

    @Override
    public MonsterEnum k(EntityType entityType) {
        if (entityType == null) {
            return null;
        }
        return switch (CraftEntityType.bukkitToMinecraft((EntityType)entityType).f()) {
            case EnumCreatureType.a -> MonsterEnum.MONSTER;
            case EnumCreatureType.b -> MonsterEnum.CREATURE;
            case EnumCreatureType.c -> MonsterEnum.AMBIENT;
            case EnumCreatureType.d -> MonsterEnum.AXOLOTLS;
            case EnumCreatureType.e -> MonsterEnum.UNDERGROUND_WATER_CREATURE;
            case EnumCreatureType.f -> MonsterEnum.WATER_CREATURE;
            case EnumCreatureType.g -> MonsterEnum.WATER_AMBIENT;
            default -> MonsterEnum.MISC;
        };
    }

    @Override
    public boolean a(LivingEntity livingEntity, LivingEntity livingEntity2) {
        EntityLiving entityLiving = ((CraftLivingEntity)livingEntity).getHandle();
        if (entityLiving instanceof IEntityAngerable) {
            IEntityAngerable iEntityAngerable = (IEntityAngerable)entityLiving;
            EntityLiving entityLiving2 = ((CraftLivingEntity)livingEntity2).getHandle();
            return iEntityAngerable.a(entityLiving2, entityLiving2.dW().getMinecraftWorld());
        }
        return false;
    }

    @Override
    @Nullable
    public Entity a(@NotNull org.bukkit.World world, UUID uUID) {
        if (!(world instanceof CraftWorld)) {
            return null;
        }
        CraftWorld craftWorld = (CraftWorld)world;
        WorldServer worldServer = craftWorld.getHandle();
        net.minecraft.world.entity.Entity entity = worldServer.a(uUID);
        if (entity == null) {
            return null;
        }
        return entity.getBukkitEntity();
    }

    @Override
    @Nullable
    public Entity a(@NotNull org.bukkit.World world, int n) {
        if (!(world instanceof CraftWorld)) {
            return null;
        }
        CraftWorld craftWorld = (CraftWorld)world;
        WorldServer worldServer = craftWorld.getHandle();
        net.minecraft.world.entity.Entity entity = worldServer.a(n);
        if (entity == null) {
            return null;
        }
        return entity.getBukkitEntity();
    }

    static {
        for (EnumItemSlot enumItemSlot : EnumItemSlot.values()) {
            abt.add(new Pair((Object)enumItemSlot, (Object)abs));
        }
        abv = VersionHelper_3.c(EntityArrow.class, net.minecraft.world.item.ItemStack.class, 0);
        if (abv == null) {
            CommandSenderBridge_5.error("Failed to find AbstractArrow getPickupItem method.");
        }
    }
}
