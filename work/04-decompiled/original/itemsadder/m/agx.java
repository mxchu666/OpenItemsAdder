package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.math.Transformation;
import itemsadder.m.acg;
import itemsadder.m.agb;
import itemsadder.m.agc;
import itemsadder.m.aow;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.um;
import itemsadder.m.zw;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityAttachments;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityInLevelCallback;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.attribute.CraftAttribute;
import org.bukkit.craftbukkit.entity.CraftArrow;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftEntityType;
import org.bukkit.craftbukkit.entity.CraftItemDisplay;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.entity.CraftMob;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public class agx
implements agb {
    static net.minecraft.world.item.ItemStack abs = Items.AIR.getDefaultInstance();
    static List abt = new ArrayList();
    Field abu = zw.a(net.minecraft.world.entity.Entity.class, EntityDimensions.class);
    static Method abv;
    EntityDataAccessor abH = (EntityDataAccessor)zw.a(net.minecraft.world.entity.Entity.class, EntityDataAccessor.class, 0);

    @Override
    public void a(Entity entity, float f) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        if (entity2.getYRot() == f) {
            return;
        }
        entity2.setYRot(f);
        if (entity.getType() != org.bukkit.entity.EntityType.ARMOR_STAND) {
            ClientboundRotateHeadPacket clientboundRotateHeadPacket = new ClientboundRotateHeadPacket(entity2, (byte)(f * 256.0f / 360.0f));
            bcp.i(() -> {
                for (Player player : bcc.a(entity.getLocation(), 25)) {
                    aow.uN().d(player, clientboundRotateHeadPacket);
                }
            });
        }
    }

    @Override
    public float L(Entity entity) {
        return ((CraftEntity)entity).getHandle().getYHeadRot();
    }

    @Override
    public float M(Entity entity) {
        if (entity instanceof LivingEntity) {
            return ((CraftLivingEntity)entity).getHandle().yBodyRot;
        }
        return ((CraftEntity)entity).getHandle().getYRot();
    }

    @Override
    public void c(Entity entity, float f) {
        ((CraftEntity)entity).getHandle().setYBodyRot(f);
    }

    @Override
    public void b(Entity entity, boolean bl) {
        ((CraftEntity)entity).getHandle().setInvisible(bl);
        this.N(entity);
    }

    @Override
    public void N(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(entity2.getId(), entity2.getEntityData().getNonDefaultValues());
        ((ServerChunkCache)entity2.level().getChunkSource()).chunkMap.sendToTrackingPlayers(entity2, (Packet)clientboundSetEntityDataPacket);
        aow.uN().b(entity2, clientboundSetEntityDataPacket);
    }

    @Override
    public void b(Entity entity, float f) {
        ((CraftLivingEntity)entity).getHandle().getAttribute(Attributes.STEP_HEIGHT).setBaseValue((double)f);
    }

    @Override
    public void a(Entity entity, double d, double d2, double d3) {
        ((CraftEntity)entity).getHandle().setBoundingBox(new AABB(entity.getLocation().getX() - d / 2.0, entity.getLocation().getY(), entity.getLocation().getZ() - d3 / 2.0, entity.getLocation().getX() + d / 2.0, entity.getLocation().getY() + d2, entity.getLocation().getZ() + d3 / 2.0));
    }

    @Override
    public void b(Entity entity, double d, double d2, double d3, double d4, double d5, double d6) {
        ((CraftEntity)entity).getHandle().setBoundingBox(new AABB(d, d3, d5, d2, d4, d6));
    }

    @Override
    public void a(Entity entity, double d, double d2, double d3, float f, float f2, boolean bl) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        if (bl) {
            entity2.setLevelCallback(EntityInLevelCallback.NULL);
        }
        entity2.absSnapTo(d, d2, d3, f, f2);
        entity2.setYHeadRot(f);
    }

    @Override
    public void b(Entity entity, double d, double d2, double d3) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.absSnapTo(d, d2, d3);
    }

    @Override
    public void O(Entity entity) {
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entity2.setLevelCallback(EntityInLevelCallback.NULL);
    }

    @Override
    public void a(org.bukkit.entity.Mob mob, boolean bl) {
        ((CraftMob)mob).getHandle().aware = bl;
    }

    @Override
    public void a(Entity entity, float f, float f2) {
        if (this.abu == null) {
            throw new RuntimeException("Can't set entity dimensions");
        }
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        zw.a(this.abu, entity2, (Object)new EntityDimensions(f, f2, entity2.getEyeHeight(), EntityAttachments.createDefault((float)f, (float)f2), true));
        entity2.setPos(entity2.position());
    }

    @Override
    public boolean P(Entity entity) {
        return entity instanceof CraftMob;
    }

    @Override
    public void f(Player player, int n) {
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(new int[]{n});
        aow.uN().d(player, clientboundRemoveEntitiesPacket);
    }

    @Override
    public void a(Player player, int ... nArray) {
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(nArray);
        aow.uN().d(player, clientboundRemoveEntitiesPacket);
    }

    @Override
    public ItemStack d(Projectile projectile) {
        if (abv == null) {
            return null;
        }
        if (projectile instanceof CraftArrow) {
            CraftArrow craftArrow = (CraftArrow)projectile;
            try {
                Arrow arrow = craftArrow.getHandle();
                return CraftItemStack.asBukkitCopy((net.minecraft.world.item.ItemStack)((net.minecraft.world.item.ItemStack)abv.invoke((Object)arrow, new Object[0])));
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
        entity2.level().broadcastEntityEvent(entity2, by);
    }

    @Override
    public int V(Location location) {
        ServerLevel serverLevel = ((CraftWorld)location.getWorld()).getHandle();
        Shulker shulker = new Shulker(EntityType.SHULKER, (Level)serverLevel);
        shulker.setPos(location.getX(), location.getY(), location.getZ());
        shulker.setInvisible(true);
        shulker.setNoGravity(true);
        shulker.setInvulnerable(true);
        shulker.setDeltaMovement(Vec3.ZERO);
        shulker.setGlowingTag(true);
        ClientboundAddEntityPacket clientboundAddEntityPacket = new ClientboundAddEntityPacket(shulker.getId(), shulker.getUUID(), shulker.trackingPosition().x(), shulker.trackingPosition().y(), shulker.trackingPosition().z(), shulker.getXRot(), shulker.getYHeadRot(), shulker.getType(), 0, shulker.getDeltaMovement(), (double)shulker.getYHeadRot());
        List list = shulker.getEntityData().packDirty();
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(shulker.getId(), list);
        for (ServerPlayer serverPlayer : serverLevel.players()) {
            if (!(serverPlayer.distanceTo((net.minecraft.world.entity.Entity)shulker) < 128.0f)) continue;
            serverPlayer.connection.send((Packet)clientboundAddEntityPacket);
            serverPlayer.connection.send((Packet)clientboundSetEntityDataPacket);
        }
        return shulker.getId();
    }

    @Override
    public void a(Player player, LivingEntity livingEntity) {
        net.minecraft.world.entity.LivingEntity livingEntity2 = ((CraftLivingEntity)livingEntity).getHandle();
        livingEntity2.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1.0);
        ClientboundUpdateAttributesPacket clientboundUpdateAttributesPacket = new ClientboundUpdateAttributesPacket(livingEntity2.getId(), livingEntity2.getAttributes().getSyncableAttributes());
        aow.uN().d(player, clientboundUpdateAttributesPacket);
    }

    @Override
    public void a(PacketEvent packetEvent, boolean bl) {
        PacketContainer packetContainer = packetEvent.getPacket();
        Entity entity = (Entity)packetContainer.getEntityModifier(packetEvent.getPlayer().getWorld()).read(0);
        if (entity == null) {
            return;
        }
        net.minecraft.world.entity.LivingEntity livingEntity = ((CraftLivingEntity)entity).getHandle();
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = (ClientboundSetEntityDataPacket)packetContainer.getHandle();
        ArrayList<SynchedEntityData.DataValue> arrayList = clientboundSetEntityDataPacket.packedItems();
        if (arrayList.isEmpty()) {
            return;
        }
        SynchedEntityData.DataValue dataValue = SynchedEntityData.DataValue.create((EntityDataAccessor)this.abH, (Object)this.a(bl, (Byte)livingEntity.getEntityData().get(this.abH), 5));
        for (int i = 0; i < arrayList.size(); ++i) {
            SynchedEntityData.DataValue dataValue2 = (SynchedEntityData.DataValue)arrayList.get(i);
            if (dataValue2.id() != 0) continue;
            try {
                arrayList.set(i, dataValue);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                arrayList = new ArrayList<SynchedEntityData.DataValue>(clientboundSetEntityDataPacket.packedItems());
                arrayList.set(i, dataValue);
            }
            return;
        }
        arrayList.add(dataValue);
    }

    @Override
    public void c(LivingEntity livingEntity, boolean bl) {
        net.minecraft.world.entity.LivingEntity livingEntity2 = ((CraftLivingEntity)livingEntity).getHandle();
        aow.uN().b(livingEntity2, new ClientboundSetEntityDataPacket(livingEntity2.getId(), List.of(SynchedEntityData.DataValue.create((EntityDataAccessor)this.abH, (Object)this.a(bl, (Byte)livingEntity2.getEntityData().get(this.abH), 5)))));
    }

    private byte a(boolean bl, byte by, int n) {
        if (bl) {
            return (byte)(by | 1 << n);
        }
        return (byte)(by & ~(1 << n));
    }

    @Override
    public void bM(Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = new ClientboundSetEquipmentPacket(player.getEntityId(), abt);
        aow.a(clientboundSetEquipmentPacket, true);
        serverPlayer.level().getChunkSource().chunkMap.sendToTrackingPlayers((net.minecraft.world.entity.Entity)serverPlayer, (Packet)clientboundSetEquipmentPacket);
        serverPlayer.connection.send((Packet)clientboundSetEquipmentPacket);
    }

    @Override
    public void bN(Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            net.minecraft.world.item.ItemStack itemStack = serverPlayer.getItemBySlot(equipmentSlot);
            arrayList.add(new Pair((Object)equipmentSlot, (Object)itemStack));
        }
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = new ClientboundSetEquipmentPacket(player.getEntityId(), arrayList);
        serverPlayer.level().getChunkSource().chunkMap.sendToTrackingPlayers((net.minecraft.world.entity.Entity)serverPlayer, (Packet)clientboundSetEquipmentPacket);
        serverPlayer.connection.send((Packet)clientboundSetEquipmentPacket);
    }

    @Override
    public boolean a(Entity entity, um um2) {
        net.minecraft.world.entity.LivingEntity livingEntity = ((CraftLivingEntity)entity).getHandle();
        CompoundTag compoundTag = new CompoundTag();
        TagValueOutput tagValueOutput = TagValueOutput.createWrappingGlobal((ProblemReporter)new ProblemReporter.ScopedCollector(LogUtils.getLogger()), (CompoundTag)compoundTag);
        livingEntity.saveWithoutId((ValueOutput)tagValueOutput);
        return acg.a(compoundTag, um2);
    }

    @Override
    public boolean R(Entity entity) {
        if (entity instanceof org.bukkit.entity.Mob) {
            org.bukkit.entity.Mob mob = (org.bukkit.entity.Mob)entity;
            LivingEntity livingEntity = mob.getTarget();
            if (livingEntity == null || livingEntity.isDead()) {
                return false;
            }
            Mob mob2 = ((CraftMob)entity).getHandle();
            GoalSelector goalSelector = mob2.goalSelector;
            return goalSelector.getAvailableGoals().stream().anyMatch(wrappedGoal -> {
                Goal goal = wrappedGoal.getGoal();
                return goal instanceof MeleeAttackGoal || goal instanceof RangedAttackGoal || goal instanceof RangedCrossbowAttackGoal;
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
            bce.error("Failed to set attribute " + String.valueOf(namespacedKey) + " to entity " + String.valueOf(livingEntity.getType()) + ". Error: " + exception.getMessage());
        }
    }

    @Override
    public Location l(LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftMob)) {
            return null;
        }
        Mob mob = ((CraftMob)livingEntity).getHandle();
        if (mob.getLookControl().getWantedX() == 0.0 && mob.getLookControl().getWantedY() == 0.0 && mob.getLookControl().getWantedZ() == 0.0) {
            return null;
        }
        if (mob.getTarget() != null && mob.getTarget().isAlive()) {
            return new Location(livingEntity.getWorld(), mob.getTarget().getEyePosition().x, mob.getTarget().getEyePosition().y, mob.getTarget().getEyePosition().z, livingEntity.getLocation().getYaw(), livingEntity.getLocation().getPitch());
        }
        return new Location(livingEntity.getWorld(), mob.getLookControl().getWantedX(), mob.getLookControl().getWantedY(), mob.getLookControl().getWantedZ(), livingEntity.getLocation().getYaw(), livingEntity.getLocation().getPitch());
    }

    @Override
    public boolean m(@UnknownNullability LivingEntity livingEntity) {
        if (!(livingEntity instanceof CraftLivingEntity)) {
            return false;
        }
        net.minecraft.world.entity.LivingEntity livingEntity2 = ((CraftLivingEntity)livingEntity).getHandle();
        return livingEntity2.jumping || !livingEntity2.onGround() && livingEntity2.getDeltaMovement().y < -0.08;
    }

    @Override
    public agc k(org.bukkit.entity.EntityType entityType) {
        if (entityType == null) {
            return null;
        }
        return switch (CraftEntityType.bukkitToMinecraft((org.bukkit.entity.EntityType)entityType).getCategory()) {
            case MobCategory.MONSTER -> agc.MONSTER;
            case MobCategory.CREATURE -> agc.CREATURE;
            case MobCategory.AMBIENT -> agc.AMBIENT;
            case MobCategory.AXOLOTLS -> agc.AXOLOTLS;
            case MobCategory.UNDERGROUND_WATER_CREATURE -> agc.UNDERGROUND_WATER_CREATURE;
            case MobCategory.WATER_CREATURE -> agc.WATER_CREATURE;
            case MobCategory.WATER_AMBIENT -> agc.WATER_AMBIENT;
            default -> agc.MISC;
        };
    }

    @Override
    public boolean a(LivingEntity livingEntity, LivingEntity livingEntity2) {
        net.minecraft.world.entity.LivingEntity livingEntity3 = ((CraftLivingEntity)livingEntity).getHandle();
        if (livingEntity3 instanceof NeutralMob) {
            NeutralMob neutralMob = (NeutralMob)livingEntity3;
            net.minecraft.world.entity.LivingEntity livingEntity4 = ((CraftLivingEntity)livingEntity2).getHandle();
            return neutralMob.isAngryAt(livingEntity4, livingEntity4.level().getMinecraftWorld());
        }
        return false;
    }

    @Override
    @Nullable
    public Entity a(@NotNull World world, UUID uUID) {
        if (!(world instanceof CraftWorld)) {
            return null;
        }
        CraftWorld craftWorld = (CraftWorld)world;
        ServerLevel serverLevel = craftWorld.getHandle();
        net.minecraft.world.entity.Entity entity = serverLevel.getEntity(uUID);
        if (entity == null) {
            return null;
        }
        return entity.getBukkitEntity();
    }

    @Override
    @Nullable
    public Entity a(@NotNull World world, int n) {
        if (!(world instanceof CraftWorld)) {
            return null;
        }
        CraftWorld craftWorld = (CraftWorld)world;
        ServerLevel serverLevel = craftWorld.getHandle();
        net.minecraft.world.entity.Entity entity = serverLevel.getEntity(n);
        if (entity == null) {
            return null;
        }
        return entity.getBukkitEntity();
    }

    @Override
    public void a(ItemDisplay itemDisplay, Vector3f vector3f, Quaternionf quaternionf) {
        Display.ItemDisplay itemDisplay2 = ((CraftItemDisplay)itemDisplay).getHandle();
        itemDisplay2.setTransformation(new Transformation((Vector3fc)vector3f, (Quaternionfc)quaternionf, (Vector3fc)abr, null));
    }

    static {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            abt.add(new Pair((Object)equipmentSlot, (Object)abs));
        }
        abv = zw.c(AbstractArrow.class, net.minecraft.world.item.ItemStack.class, 0);
        if (abv == null) {
            bce.error("Failed to find AbstractArrow getPickupItem method.");
        }
    }
}
