package itemsadder.m;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import itemsadder.m.adq;
import itemsadder.m.aow;
import itemsadder.m.aox;
import itemsadder.m.aoy;
import itemsadder.m.aqp;
import itemsadder.m.bcy;
import itemsadder.m.bcz;
import itemsadder.m.do;
import itemsadder.m.zw;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Rotations;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.enchantments.CraftEnchantment;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class aed
extends adq {
    static Field Ys = zw.a(SynchedEntityData.class, SynchedEntityData.DataItem[].class);
    private final ArmorStand ZW;
    private final AreaEffectCloud ZX;
    private final ClientboundRemoveEntitiesPacket ZY;
    ClientboundBundlePacket Yw;
    private final List ZZ;
    private final List aaa;
    private final SynchedEntityData.DataItem aab;
    private final SynchedEntityData.DataItem aac;
    private final EquipmentSlot aad;

    public aed(Location location, org.bukkit.inventory.EquipmentSlot equipmentSlot, boolean bl, boolean bl2, boolean bl3) {
        super(location, bl);
        ServerLevel serverLevel = ((CraftWorld)location.getWorld()).getHandle();
        this.ZW = new ArmorStand((Level)serverLevel, location.getX(), location.getY(), location.getZ());
        this.XY = new bcz(this.ZW.position().x, this.ZW.position().y, this.ZW.position().z);
        this.Yb = this.ZW.getId();
        this.ZW.setNoGravity(true);
        this.ZW.setCustomNameVisible(false);
        this.ZW.setInvisible(true);
        this.ZW.setNoBasePlate(true);
        this.ZW.setMarker(bl2 || !bl3);
        this.ZW.setYRot(0.0f);
        this.ZW.setXRot(0.0f);
        this.ZX = new AreaEffectCloud((Level)serverLevel, location.getX(), location.getY(), location.getZ());
        this.Ya = this.ZX.getId();
        this.XZ = new bcz(this.ZX.position().x, this.ZX.position().y, this.ZX.position().z);
        this.ZX.tickCount = Integer.MIN_VALUE;
        this.ZX.setDuration(-1);
        this.ZX.setWaitTime(Integer.MIN_VALUE);
        this.ZX.setRadius(0.0f);
        this.ZX.setPotionContents(new PotionContents(this.ZX.potionContents.potion(), Optional.of(new Color(0, 0, 0, 0).getRGB()), this.ZX.potionContents.customEffects(), this.ZX.potionContents.customName()));
        this.ZX.setInvisible(true);
        this.Yk = (double)this.ZX.getType().getDimensions().height() * 0.75;
        this.XU = this.XZ.Dw();
        this.XV = this.XY.Dw();
        this.XW = this.XZ.Dw();
        this.XX = this.XY.Dw();
        this.ZY = new ClientboundRemoveEntitiesPacket(new int[]{this.ZW.getId(), this.ZX.getId()});
        this.aad = EquipmentSlot.byName((String)aqp.a(equipmentSlot));
        if (zw.sZ()) {
            this.aab = this.ZW.getEntityData().getItem(this.aad == EquipmentSlot.MAINHAND ? ArmorStand.DATA_RIGHT_ARM_POSE : ArmorStand.DATA_HEAD_POSE);
            this.aac = this.ZW.getEntityData().getItem((EntityDataAccessor)zw.a(Entity.class, EntityDataAccessor.class, 0));
        } else {
            try {
                SynchedEntityData.DataItem[] dataItemArray = (SynchedEntityData.DataItem[])Ys.get(this.ZW.getEntityData());
                this.aab = dataItemArray[this.aad == EquipmentSlot.MAINHAND ? ArmorStand.DATA_RIGHT_ARM_POSE.id() : ArmorStand.DATA_HEAD_POSE.id()];
                this.aac = dataItemArray[((EntityDataAccessor)zw.a(Entity.class, EntityDataAccessor.class, 0)).id()];
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        }
        this.ZZ = Lists.newArrayList(this.aab);
        this.aaa = Lists.newArrayList(this.aac);
    }

    @Override
    public void c(float f, float f2, float f3) {
        Rotations rotations = (Rotations)this.aab.getValue();
        if (aed.c(rotations.x(), f) && aed.c(rotations.y(), f2) && aed.c(rotations.z(), f3)) {
            return;
        }
        this.aab.setValue((Object)new Rotations(f, f2, f3));
        this.Yf = true;
    }

    @Override
    public boolean q(float f) {
        if (!super.q(f)) {
            return false;
        }
        this.ZW.yHeadRot = f;
        this.ZW.setYRot(f);
        return true;
    }

    private static ClientboundAddEntityPacket b(Entity entity, bcz bcz2, double d) {
        return new ClientboundAddEntityPacket(entity.getId(), entity.getUUID(), bcz2.akd, bcz2.ake, bcz2.akf, entity.getXRot(), entity.getYRot(), entity.getType(), 0, entity.getDeltaMovement(), d);
    }

    private ClientboundBundlePacket tD() {
        if (this.aad == EquipmentSlot.MAINHAND) {
            this.ZW.setRightArmPose((Rotations)this.aab.getValue());
        } else {
            this.ZW.setHeadPose((Rotations)this.aab.getValue());
        }
        ClientboundAddEntityPacket clientboundAddEntityPacket = aed.b((Entity)this.ZW, this.XY, this.ZW.yHeadRot);
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(this.ZW.getId(), this.ZW.getEntityData().getNonDefaultValues());
        ClientboundAddEntityPacket clientboundAddEntityPacket2 = aed.b((Entity)this.ZX, this.XZ, 0.0);
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket2 = new ClientboundSetEntityDataPacket(this.ZX.getId(), this.ZX.getEntityData().getNonDefaultValues());
        this.ZX.passengers = ImmutableList.of(this.ZW);
        ClientboundSetPassengersPacket clientboundSetPassengersPacket = new ClientboundSetPassengersPacket((Entity)this.ZX);
        return new ClientboundBundlePacket(List.of(clientboundAddEntityPacket, clientboundSetEntityDataPacket, clientboundAddEntityPacket2, clientboundSetEntityDataPacket2, clientboundSetPassengersPacket));
    }

    @Override
    public void v(List list) {
        ClientboundBundlePacket clientboundBundlePacket = this.tD();
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_, (Packet)clientboundBundlePacket);
        }
    }

    @Override
    public void h(do do_) {
        ClientboundBundlePacket clientboundBundlePacket = this.tD();
        this.a(do_, (Packet)clientboundBundlePacket);
    }

    @Override
    public void f(do do_) {
        this.a(do_.iW, (Packet)this.ZY);
    }

    @Override
    public void d(List list, int n) {
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = this.aG(n);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (do_.fs()) continue;
            this.a(do_.iW, (Packet)clientboundSetEquipmentPacket);
        }
    }

    @Override
    public void a(do do_, int n) {
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = this.aG(n);
        if (!do_.fs()) {
            this.a(do_.iW, (Packet)clientboundSetEquipmentPacket);
        }
    }

    @Override
    public void e(List list, int n) {
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = this.aF(n);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (do_.fs()) continue;
            this.a(do_.iW, (Packet)clientboundSetEquipmentPacket);
        }
    }

    @Override
    public void a(@Nullable Player player, List list, ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.remove(DataComponents.ITEM_NAME);
        itemStack2.remove(DataComponents.CUSTOM_NAME);
        itemStack2.remove(DataComponents.LORE);
        itemStack2.remove(DataComponents.ATTRIBUTE_MODIFIERS);
        itemStack2.remove(DataComponents.PROFILE);
        itemStack2.remove(DataComponents.CUSTOM_DATA);
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair((Object)this.aad, (Object)itemStack2));
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = new ClientboundSetEquipmentPacket(this.ZW.getId(), arrayList);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_.iW, (Packet)clientboundSetEquipmentPacket);
        }
    }

    private net.minecraft.world.item.ItemStack b(int n, boolean bl) {
        if (n == -1) {
            return CraftItemStack.asNMSCopy((ItemStack)new ItemStack(Material.AIR));
        }
        if (this.Yh && this.playerSkin != null) {
            ItemStack itemStack = this.c(n, this.playerSkin);
            net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
            return itemStack2;
        }
        net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((ItemLike)Items.POTION, 1);
        if (bl) {
            itemStack.set(DataComponents.POTION_CONTENTS, (Object)new PotionContents(PotionContents.EMPTY.potion(), Optional.of(0xFF7E7E), PotionContents.EMPTY.customEffects(), PotionContents.EMPTY.customName()));
        } else {
            itemStack.set(DataComponents.POTION_CONTENTS, (Object)new PotionContents(PotionContents.EMPTY.potion(), Optional.of(this.JJ), PotionContents.EMPTY.customEffects(), PotionContents.EMPTY.customName()));
        }
        if (this.Yi) {
            itemStack.enchant(CraftEnchantment.bukkitToMinecraftHolder((Enchantment)Enchantment.SHARPNESS), 1);
        }
        itemStack.set(DataComponents.CUSTOM_MODEL_DATA, (Object)new CustomModelData(List.of(Float.valueOf(Integer.valueOf(n).floatValue())), List.of(), List.of(), List.of()));
        return itemStack;
    }

    private ClientboundSetEquipmentPacket aF(int n) {
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = (ClientboundSetEquipmentPacket)this.XS.get(n);
        if (clientboundSetEquipmentPacket == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, true);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.aad, (Object)itemStack));
            clientboundSetEquipmentPacket = new ClientboundSetEquipmentPacket(this.ZW.getId(), arrayList);
            this.XS.put(n, clientboundSetEquipmentPacket);
        }
        return clientboundSetEquipmentPacket;
    }

    private ClientboundSetEquipmentPacket aG(int n) {
        ClientboundSetEquipmentPacket clientboundSetEquipmentPacket = (ClientboundSetEquipmentPacket)this.XR.get(n);
        if (clientboundSetEquipmentPacket == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, false);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.aad, (Object)itemStack));
            clientboundSetEquipmentPacket = new ClientboundSetEquipmentPacket(this.ZW.getId(), arrayList);
            this.XR.put(n, clientboundSetEquipmentPacket);
        }
        return clientboundSetEquipmentPacket;
    }

    @Override
    public void w(List list) {
        if (!(this.Yg || !list.isEmpty() && this.Yf)) {
            return;
        }
        this.b(list, this.ZZ);
        this.Yf = false;
    }

    @Override
    public void a(boolean bl, @Nullable LivingEntity livingEntity, List list) {
        if (!this.Yg && list.isEmpty() && !this.Yd && !this.Ye) {
            return;
        }
        if (bl) {
            this.y(list);
            return;
        }
        this.Yw = null;
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl() || !do_.fn()) continue;
            this.a(do_, this.Yc.getYaw(), this.XZ, this.XY);
        }
        this.Yd = false;
        this.Ye = false;
    }

    public void y(List list) {
        this.tw();
        this.Yw = null;
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl() || !do_.fn()) continue;
            this.a(do_, this.Yc.getYaw(), this.XU, this.XV);
        }
        this.Yd = false;
    }

    FriendlyByteBuf b(boolean bl, int n, double d, double d2, double d3, float f, float f2, boolean bl2) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer((int)30));
        if (bl) {
            friendlyByteBuf.writeByte(aox.aku);
        }
        friendlyByteBuf.writeVarInt(n);
        PositionMoveRotation.STREAM_CODEC.encode((Object)friendlyByteBuf, (Object)new PositionMoveRotation(new Vec3(d, d2, d3), Vec3.ZERO, f, f2));
        Relative.SET_STREAM_CODEC.encode((Object)friendlyByteBuf, Set.of());
        friendlyByteBuf.writeBoolean(bl2);
        return friendlyByteBuf;
    }

    FriendlyByteBuf b(int n, List list) {
        RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf((ByteBuf)new FriendlyByteBuf(Unpooled.buffer((int)30)), (RegistryAccess)RegistryAccess.EMPTY);
        registryFriendlyByteBuf.writeByte(aox.akv);
        registryFriendlyByteBuf.writeVarInt(n);
        aed.a(list, registryFriendlyByteBuf);
        return registryFriendlyByteBuf;
    }

    protected void a(do do_, float f, bcz bcz2, bcz bcz3) {
        FriendlyByteBuf friendlyByteBuf;
        if (this.Ye) {
            friendlyByteBuf = this.b(true, this.Yb, bcz3.akd, bcz3.ake, bcz3.akf, f, 0.0f, false);
            this.a(do_.iW, friendlyByteBuf);
        }
        if (this.Yd) {
            friendlyByteBuf = this.b(true, this.Ya, bcz2.akd, bcz2.ake, bcz2.akf, 0.0f, 0.0f, false);
            this.a(do_.iW, friendlyByteBuf);
        }
    }

    @Override
    public void x(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.XT) {
            this.aac.setValue((Object)((byte)((Byte)this.aac.getValue() | 1)));
        } else {
            this.aac.setValue((Object)((byte)((Byte)this.aac.getValue() & 0xFFFFFFFE)));
        }
        this.b(list, this.aaa);
    }

    private void b(List list, List list2) {
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl() || !do_.fm()) continue;
            this.a(do_.iW, this.b(this.Yb, list2));
        }
    }

    @Override
    public void bK(Player player) {
        this.ZW.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1.0);
        this.a(player, (Packet)new ClientboundUpdateAttributesPacket(this.Yb, this.ZW.getAttributes().getSyncableAttributes()));
    }

    public void a(do do_, Packet packet) {
        aow.uN().d(do_.iW, packet);
    }

    public void a(Player player, Packet packet) {
        aow.uN().d(player, packet);
    }

    public void a(Player player, FriendlyByteBuf friendlyByteBuf) {
        aow.c(player, friendlyByteBuf);
    }

    public static void a(List list, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (SynchedEntityData.DataItem dataItem : list) {
            new SynchedEntityData.DataValue(dataItem.getAccessor().id(), dataItem.getAccessor().serializer(), dataItem.getValue()).write(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.writeByte(255);
    }

    private void a(Packet packet) {
        aoy.dK(packet.getClass().getName());
        if (packet instanceof ClientboundBundlePacket) {
            ClientboundBundlePacket clientboundBundlePacket = (ClientboundBundlePacket)packet;
            Iterable iterable = clientboundBundlePacket.subPackets();
            for (Packet packet2 : iterable) {
                aoy.dK(packet2.getClass().getName());
            }
        }
    }

    private void a(FriendlyByteBuf friendlyByteBuf) {
        aoy.dK(bcy.A(3, 5));
    }

    @Override
    public /* synthetic */ void b(Player player, Object object) {
        this.a(player, (Packet)object);
    }

    static {
        if (Ys == null) {
            throw new RuntimeException("Failed to get field SynchedEntityData.DataItem[]");
        }
    }
}
