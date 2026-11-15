package itemsadder.m;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import itemsadder.m.AvgPacketsSent;
import itemsadder.m.ColorBridge;
import itemsadder.m.GetPacketID;
import itemsadder.m.LocationEquipmentSlotHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.VectorBridge;
import itemsadder.m.VersionHelper_3;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.IRegistryCustom;
import net.minecraft.core.Vector3f;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEquipment;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutMount;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.network.protocol.game.PacketPlayOutUpdateAttributes;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.network.syncher.DataWatcherObject;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityAreaEffectCloud;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.IMaterial;
import net.minecraft.world.level.World;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_21_R6.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R6.enchantments.CraftEnchantment;
import org.bukkit.craftbukkit.v1_21_R6.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_10_5
extends LocationEquipmentSlotHolder {
    static Field Ys = VersionHelper_3.a(DataWatcher.class, DataWatcher.Item[].class);
    private final EntityArmorStand YK;
    private final EntityAreaEffectCloud YL;
    private final PacketPlayOutEntityDestroy YM;
    ClientboundBundlePacket Yw;
    private final List YN;
    private final List YO;
    private final DataWatcher.Item YP;
    private final DataWatcher.Item YQ;
    private final EnumItemSlot YR;

    public BlockNms_1_21_10_5(Location location, EquipmentSlot equipmentSlot, boolean bl, boolean bl2, boolean bl3) {
        super(location, bl);
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        this.YK = new EntityArmorStand((World)worldServer, location.getX(), location.getY(), location.getZ());
        this.XY = new VectorBridge(this.YK.dD().g, this.YK.dD().h, this.YK.dD().i);
        this.Yb = this.YK.az();
        this.YK.g(true);
        this.YK.p(false);
        this.YK.l(true);
        this.YK.b(true);
        this.YK.v(bl2 || !bl3);
        this.YK.v(0.0f);
        this.YK.w(0.0f);
        this.YL = new EntityAreaEffectCloud((World)worldServer, location.getX(), location.getY(), location.getZ());
        this.Ya = this.YL.az();
        this.XZ = new VectorBridge(this.YL.dD().g, this.YL.dD().h, this.YL.dD().i);
        this.YL.at = Integer.MIN_VALUE;
        this.YL.a(-1);
        this.YL.c(Integer.MIN_VALUE);
        this.YL.a(0.0f);
        this.YL.a(new PotionContents(this.YL.u.e(), Optional.of(new Color(0, 0, 0, 0).getRGB()), this.YL.u.d(), this.YL.u.g()));
        this.YL.l(true);
        this.Yk = (double)this.YL.ax().n().b() * 0.75;
        this.XU = this.XZ.Dw();
        this.XV = this.XY.Dw();
        this.XW = this.XZ.Dw();
        this.XX = this.XY.Dw();
        this.YM = new PacketPlayOutEntityDestroy(new int[]{this.YK.az(), this.YL.az()});
        this.YR = EnumItemSlot.a((String)PlayerHolder_4.a(equipmentSlot));
        if (VersionHelper_3.sZ()) {
            this.YP = this.YK.aC().b(this.YR == EnumItemSlot.a ? EntityArmorStand.r : EntityArmorStand.o);
            this.YQ = this.YK.aC().b((DataWatcherObject)VersionHelper_3.a(Entity.class, DataWatcherObject.class, 0));
        } else {
            try {
                DataWatcher.Item[] itemArray = (DataWatcher.Item[])Ys.get(this.YK.aC());
                this.YP = itemArray[this.YR == EnumItemSlot.a ? EntityArmorStand.r.a() : EntityArmorStand.o.a()];
                this.YQ = itemArray[((DataWatcherObject)VersionHelper_3.a(Entity.class, DataWatcherObject.class, 0)).a()];
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        }
        this.YN = Lists.newArrayList(this.YP);
        this.YO = Lists.newArrayList(this.YQ);
    }

    @Override
    public void c(float f, float f2, float f3) {
        Vector3f vector3f = (Vector3f)this.YP.b();
        if (BlockNms_1_21_10_5.c(vector3f.a(), f) && BlockNms_1_21_10_5.c(vector3f.b(), f2) && BlockNms_1_21_10_5.c(vector3f.c(), f3)) {
            return;
        }
        this.YP.a((Object)new Vector3f(f, f2, f3));
        this.Yf = true;
    }

    @Override
    public boolean q(float f) {
        if (!super.q(f)) {
            return false;
        }
        this.YK.bD = f;
        this.YK.v(f);
        return true;
    }

    private static PacketPlayOutSpawnEntity a(Entity entity, VectorBridge vectorBridge, double d) {
        return new PacketPlayOutSpawnEntity(entity.az(), entity.cT(), vectorBridge.akd, vectorBridge.ake, vectorBridge.akf, entity.dZ(), entity.dX(), entity.ax(), 0, entity.dI(), d);
    }

    private ClientboundBundlePacket tD() {
        if (this.YR == EnumItemSlot.a) {
            this.YK.d((Vector3f)this.YP.b());
        } else {
            this.YK.a((Vector3f)this.YP.b());
        }
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = BlockNms_1_21_10_5.a((Entity)this.YK, this.XY, (double)this.YK.bD);
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(this.YK.az(), this.YK.aC().c());
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity2 = BlockNms_1_21_10_5.a((Entity)this.YL, this.XZ, 0.0);
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata2 = new PacketPlayOutEntityMetadata(this.YL.az(), this.YL.aC().c());
        this.YL.aS = ImmutableList.of(this.YK);
        PacketPlayOutMount packetPlayOutMount = new PacketPlayOutMount((Entity)this.YL);
        return new ClientboundBundlePacket(List.of(packetPlayOutSpawnEntity, packetPlayOutEntityMetadata, packetPlayOutSpawnEntity2, packetPlayOutEntityMetadata2, packetPlayOutMount));
    }

    @Override
    public void v(List list) {
        ClientboundBundlePacket clientboundBundlePacket = this.tD();
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl()) continue;
            this.a(playerBridge_7, (Packet)clientboundBundlePacket);
        }
    }

    @Override
    public void h(PlayerBridge_7 playerBridge_7) {
        ClientboundBundlePacket clientboundBundlePacket = this.tD();
        this.a(playerBridge_7, (Packet)clientboundBundlePacket);
    }

    @Override
    public void f(PlayerBridge_7 playerBridge_7) {
        this.a(playerBridge_7.iW, (Packet)this.YM);
    }

    @Override
    public void d(List list, int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = this.aE(n);
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (playerBridge_7.fs()) continue;
            this.a(playerBridge_7.iW, (Packet)packetPlayOutEntityEquipment);
        }
    }

    @Override
    public void a(PlayerBridge_7 playerBridge_7, int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = this.aE(n);
        if (!playerBridge_7.fs()) {
            this.a(playerBridge_7.iW, (Packet)packetPlayOutEntityEquipment);
        }
    }

    @Override
    public void e(List list, int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = this.aD(n);
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (playerBridge_7.fs()) continue;
            this.a(playerBridge_7.iW, (Packet)packetPlayOutEntityEquipment);
        }
    }

    @Override
    public void a(@Nullable Player player, List list, ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.e(DataComponents.h);
        itemStack2.e(DataComponents.g);
        itemStack2.e(DataComponents.j);
        itemStack2.e(DataComponents.o);
        itemStack2.e(DataComponents.ak);
        itemStack2.e(DataComponents.b);
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair((Object)this.YR, (Object)itemStack2));
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.YK.az(), arrayList);
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl()) continue;
            this.a(playerBridge_7.iW, (Packet)packetPlayOutEntityEquipment);
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
        net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((IMaterial)Items.up, 1);
        if (bl) {
            itemStack.b(DataComponents.R, (Object)new PotionContents(PotionContents.a.e(), Optional.of(0xFF7E7E), PotionContents.a.d(), PotionContents.a.g()));
        } else {
            itemStack.b(DataComponents.R, (Object)new PotionContents(PotionContents.a.e(), Optional.of(this.JJ), PotionContents.a.d(), PotionContents.a.g()));
        }
        if (this.Yi) {
            itemStack.a(CraftEnchantment.bukkitToMinecraftHolder((Enchantment)Enchantment.SHARPNESS), 1);
        }
        itemStack.b(DataComponents.p, (Object)new CustomModelData(List.of(Float.valueOf(Integer.valueOf(n).floatValue())), List.of(), List.of(), List.of()));
        return itemStack;
    }

    private PacketPlayOutEntityEquipment aD(int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = (PacketPlayOutEntityEquipment)this.XS.get(n);
        if (packetPlayOutEntityEquipment == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, true);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.YR, (Object)itemStack));
            packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.YK.az(), arrayList);
            this.XS.put(n, packetPlayOutEntityEquipment);
        }
        return packetPlayOutEntityEquipment;
    }

    private PacketPlayOutEntityEquipment aE(int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = (PacketPlayOutEntityEquipment)this.XR.get(n);
        if (packetPlayOutEntityEquipment == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, false);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.YR, (Object)itemStack));
            packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.YK.az(), arrayList);
            this.XR.put(n, packetPlayOutEntityEquipment);
        }
        return packetPlayOutEntityEquipment;
    }

    @Override
    public void w(List list) {
        if (!(this.Yg || !list.isEmpty() && this.Yf)) {
            return;
        }
        this.b(list, this.YN);
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
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl() || !playerBridge_7.fn()) continue;
            this.a(playerBridge_7, this.Yc.getYaw(), this.XZ, this.XY);
        }
        this.Yd = false;
        this.Ye = false;
    }

    public void y(List list) {
        this.tw();
        this.Yw = null;
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl() || !playerBridge_7.fn()) continue;
            this.a(playerBridge_7, this.Yc.getYaw(), this.XU, this.XV);
        }
        this.Yd = false;
    }

    PacketDataSerializer a(boolean bl, int n, double d, double d2, double d3, float f, float f2, boolean bl2) {
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer((int)30));
        if (bl) {
            packetDataSerializer.l(GetPacketID.aku);
        }
        packetDataSerializer.c(n);
        PositionMoveRotation.a.encode((Object)packetDataSerializer, (Object)new PositionMoveRotation(new Vec3D(d, d2, d3), Vec3D.c, f, f2));
        Relative.m.encode((Object)packetDataSerializer, Set.of());
        packetDataSerializer.a(bl2);
        return packetDataSerializer;
    }

    PacketDataSerializer a(int n, List list) {
        RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf((ByteBuf)new PacketDataSerializer(Unpooled.buffer((int)30)), (IRegistryCustom)IRegistryCustom.b);
        registryFriendlyByteBuf.l(GetPacketID.akv);
        registryFriendlyByteBuf.c(n);
        BlockNms_1_21_10_5.a(list, registryFriendlyByteBuf);
        return registryFriendlyByteBuf;
    }

    protected void a(PlayerBridge_7 playerBridge_7, float f, VectorBridge vectorBridge, VectorBridge vectorBridge2) {
        PacketDataSerializer packetDataSerializer;
        if (this.Ye) {
            packetDataSerializer = this.a(true, this.Yb, vectorBridge2.akd, vectorBridge2.ake, vectorBridge2.akf, f, 0.0f, false);
            this.a(playerBridge_7.iW, packetDataSerializer);
        }
        if (this.Yd) {
            packetDataSerializer = this.a(true, this.Ya, vectorBridge.akd, vectorBridge.ake, vectorBridge.akf, 0.0f, 0.0f, false);
            this.a(playerBridge_7.iW, packetDataSerializer);
        }
    }

    @Override
    public void x(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.XT) {
            this.YQ.a((Object)((byte)((Byte)this.YQ.b() | 1)));
        } else {
            this.YQ.a((Object)((byte)((Byte)this.YQ.b() & 0xFFFFFFFE)));
        }
        this.b(list, this.YO);
    }

    private void b(List list, List list2) {
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl() || !playerBridge_7.fm()) continue;
            this.a(playerBridge_7.iW, this.a(this.Yb, list2));
        }
    }

    @Override
    public void bK(Player player) {
        this.YK.h(GenericAttributes.t).a(1.0);
        this.a(player, (Packet)new PacketPlayOutUpdateAttributes(this.Yb, this.YK.fp().c()));
    }

    public void a(PlayerBridge_7 playerBridge_7, Packet packet) {
        PacketListenerRegistry.uN().d(playerBridge_7.iW, packet);
    }

    public void a(Player player, Packet packet) {
        PacketListenerRegistry.uN().d(player, packet);
    }

    public void a(Player player, PacketDataSerializer packetDataSerializer) {
        PacketListenerRegistry.c(player, packetDataSerializer);
    }

    public static void a(List list, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (DataWatcher.Item item : list) {
            new DataWatcher.c(item.a().a(), item.a().b(), item.b()).a(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.l(255);
    }

    private void a(Packet packet) {
        AvgPacketsSent.dK(packet.getClass().getName());
        if (packet instanceof ClientboundBundlePacket) {
            ClientboundBundlePacket clientboundBundlePacket = (ClientboundBundlePacket)packet;
            Iterable iterable = clientboundBundlePacket.b();
            for (Packet packet2 : iterable) {
                AvgPacketsSent.dK(packet2.getClass().getName());
            }
        }
    }

    private void a(PacketDataSerializer packetDataSerializer) {
        AvgPacketsSent.dK(ColorBridge.A(3, 5));
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
