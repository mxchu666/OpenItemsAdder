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
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.IMaterial;
import net.minecraft.world.level.World;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R4.inventory.CraftItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_20_6_5
extends LocationEquipmentSlotHolder {
    static Field Ys = VersionHelper_3.a(DataWatcher.class, DataWatcher.Item[].class);
    private final EntityArmorStand Yt;
    private final EntityAreaEffectCloud Yu;
    private final PacketPlayOutEntityDestroy Yv;
    ClientboundBundlePacket Yw;
    private final List Yx;
    private final List Yy;
    private final DataWatcher.Item Yz;
    private final DataWatcher.Item YA;
    private final EnumItemSlot YB;

    public BlockNms_1_20_6_5(Location location, EquipmentSlot equipmentSlot, boolean bl, boolean bl2, boolean bl3) {
        super(location, bl);
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        this.Yt = new EntityArmorStand((World)worldServer, location.getX(), location.getY(), location.getZ());
        this.XY = new VectorBridge(this.Yt.dn().c, this.Yt.dn().d, this.Yt.dn().e);
        this.Yb = this.Yt.al();
        this.Yt.f(true);
        this.Yt.o(false);
        this.Yt.k(true);
        this.Yt.b(true);
        this.Yt.u(bl2 || !bl3);
        this.Yt.r(0.0f);
        this.Yt.s(0.0f);
        this.Yu = new EntityAreaEffectCloud((World)worldServer, location.getX(), location.getY(), location.getZ());
        this.Ya = this.Yu.al();
        this.XZ = new VectorBridge(this.Yu.dn().c, this.Yu.dn().d, this.Yu.dn().e);
        this.Yu.ai = Integer.MIN_VALUE;
        this.Yu.a(-1);
        this.Yu.c(Integer.MIN_VALUE);
        this.Yu.a(0.0f);
        this.Yu.a(new PotionContents(this.Yu.l.e(), Optional.of(new Color(0, 0, 0, 0).getRGB()), this.Yu.l.d()));
        this.Yu.k(true);
        this.Yk = (double)this.Yu.ak().n().b() * 0.75;
        this.XU = this.XZ.Dw();
        this.XV = this.XY.Dw();
        this.XW = this.XZ.Dw();
        this.XX = this.XY.Dw();
        this.Yv = new PacketPlayOutEntityDestroy(new int[]{this.Yt.al(), this.Yu.al()});
        this.YB = EnumItemSlot.a((String)PlayerHolder_4.a(equipmentSlot));
        if (VersionHelper_3.sZ()) {
            this.Yz = this.Yt.ap().b(this.YB == EnumItemSlot.a ? EntityArmorStand.bK : EntityArmorStand.bH);
            this.YA = this.Yt.ap().b((DataWatcherObject)VersionHelper_3.a(Entity.class, DataWatcherObject.class, 0));
        } else {
            try {
                DataWatcher.Item[] itemArray = (DataWatcher.Item[])Ys.get(this.Yt.ap());
                this.Yz = itemArray[this.YB == EnumItemSlot.a ? EntityArmorStand.bK.a() : EntityArmorStand.bH.a()];
                this.YA = itemArray[((DataWatcherObject)VersionHelper_3.a(Entity.class, DataWatcherObject.class, 0)).a()];
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        }
        this.Yx = Lists.newArrayList(this.Yz);
        this.Yy = Lists.newArrayList(this.YA);
    }

    @Override
    public void c(float f, float f2, float f3) {
        Vector3f vector3f = (Vector3f)this.Yz.b();
        if (BlockNms_1_20_6_5.c(vector3f.b(), f) && BlockNms_1_20_6_5.c(vector3f.c(), f2) && BlockNms_1_20_6_5.c(vector3f.d(), f3)) {
            return;
        }
        this.Yz.a((Object)new Vector3f(f, f2, f3));
        this.Yf = true;
    }

    @Override
    public boolean q(float f) {
        if (!super.q(f)) {
            return false;
        }
        this.Yt.ba = f;
        this.Yt.r(f);
        return true;
    }

    private static PacketPlayOutSpawnEntity a(Entity entity, VectorBridge vectorBridge, double d) {
        return new PacketPlayOutSpawnEntity(entity.al(), entity.cz(), vectorBridge.akd, vectorBridge.ake, vectorBridge.akf, entity.dH(), entity.dF(), entity.ak(), 0, entity.ds(), d);
    }

    private ClientboundBundlePacket tD() {
        if (this.YB == EnumItemSlot.a) {
            this.Yt.d((Vector3f)this.Yz.b());
        } else {
            this.Yt.a((Vector3f)this.Yz.b());
        }
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = BlockNms_1_20_6_5.a((Entity)this.Yt, this.XY, (double)this.Yt.ba);
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(this.Yt.al(), this.Yt.ap().c());
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity2 = BlockNms_1_20_6_5.a((Entity)this.Yu, this.XZ, 0.0);
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata2 = new PacketPlayOutEntityMetadata(this.Yu.al(), this.Yu.ap().c());
        this.Yu.p = ImmutableList.of(this.Yt);
        PacketPlayOutMount packetPlayOutMount = new PacketPlayOutMount((Entity)this.Yu);
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
        this.a(playerBridge_7.iW, (Packet)this.Yv);
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
        itemStack2.c(DataComponents.h);
        itemStack2.c(DataComponents.g);
        itemStack2.c(DataComponents.i);
        itemStack2.c(DataComponents.n);
        itemStack2.c(DataComponents.V);
        itemStack2.c(DataComponents.b);
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair((Object)this.YB, (Object)itemStack2));
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.Yt.al(), arrayList);
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
        net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((IMaterial)Items.sk, 1);
        if (bl) {
            itemStack.b(DataComponents.G, (Object)new PotionContents(PotionContents.a.e(), Optional.of(0xFF7E7E), PotionContents.a.d()));
        } else {
            itemStack.b(DataComponents.G, (Object)new PotionContents(PotionContents.a.e(), Optional.of(this.JJ), PotionContents.a.d()));
        }
        if (this.Yi) {
            itemStack.a(Enchantments.n, 1);
        }
        itemStack.b(DataComponents.o, (Object)new CustomModelData(n));
        return itemStack;
    }

    private PacketPlayOutEntityEquipment aD(int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = (PacketPlayOutEntityEquipment)this.XS.get(n);
        if (packetPlayOutEntityEquipment == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, true);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.YB, (Object)itemStack));
            packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.Yt.al(), arrayList);
            this.XS.put(n, packetPlayOutEntityEquipment);
        }
        return packetPlayOutEntityEquipment;
    }

    private PacketPlayOutEntityEquipment aE(int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = (PacketPlayOutEntityEquipment)this.XR.get(n);
        if (packetPlayOutEntityEquipment == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, false);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.YB, (Object)itemStack));
            packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.Yt.al(), arrayList);
            this.XR.put(n, packetPlayOutEntityEquipment);
        }
        return packetPlayOutEntityEquipment;
    }

    @Override
    public void w(List list) {
        if (!(this.Yg || !list.isEmpty() && this.Yf)) {
            return;
        }
        this.b(list, this.Yx);
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
        byte by = BlockNms_1_20_6_5.r(this.Yc.getYaw());
        this.Yw = null;
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl() || !playerBridge_7.fn()) continue;
            this.a(playerBridge_7, by, this.XZ, this.XY);
        }
        this.Yd = false;
        this.Ye = false;
    }

    public void y(List list) {
        this.tw();
        byte by = BlockNms_1_20_6_5.r(this.Yc.getYaw());
        this.Yw = null;
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl() || !playerBridge_7.fn()) continue;
            this.a(playerBridge_7, by, this.XU, this.XV);
        }
        this.Yd = false;
    }

    PacketDataSerializer a(boolean bl, int n, double d, double d2, double d3, byte by, byte by2, boolean bl2) {
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer((int)30));
        if (bl) {
            packetDataSerializer.k(GetPacketID.aku);
        }
        packetDataSerializer.c(n);
        packetDataSerializer.a(d);
        packetDataSerializer.a(d2);
        packetDataSerializer.a(d3);
        packetDataSerializer.k((int)by);
        packetDataSerializer.k((int)by2);
        packetDataSerializer.a(bl2);
        return packetDataSerializer;
    }

    PacketDataSerializer a(int n, List list) {
        RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf((ByteBuf)new PacketDataSerializer(Unpooled.buffer((int)30)), (IRegistryCustom)IRegistryCustom.b);
        registryFriendlyByteBuf.k(GetPacketID.akv);
        registryFriendlyByteBuf.c(n);
        this.a(list, registryFriendlyByteBuf);
        return registryFriendlyByteBuf;
    }

    protected void a(PlayerBridge_7 playerBridge_7, byte by, VectorBridge vectorBridge, VectorBridge vectorBridge2) {
        PacketDataSerializer packetDataSerializer;
        if (this.Ye) {
            packetDataSerializer = this.a(true, this.Yb, vectorBridge2.akd, vectorBridge2.ake, vectorBridge2.akf, by, (byte)0, false);
            this.a(playerBridge_7.iW, packetDataSerializer);
        }
        if (this.Yd) {
            packetDataSerializer = this.a(true, this.Ya, vectorBridge.akd, vectorBridge.ake, vectorBridge.akf, (byte)0, (byte)0, false);
            this.a(playerBridge_7.iW, packetDataSerializer);
        }
    }

    @Override
    public void x(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.XT) {
            this.YA.a((Object)((byte)((Byte)this.YA.b() | 1)));
        } else {
            this.YA.a((Object)((byte)((Byte)this.YA.b() & 0xFFFFFFFE)));
        }
        this.b(list, this.Yy);
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
        this.Yt.f(GenericAttributes.q).a(1.0);
        this.a(player, (Packet)new PacketPlayOutUpdateAttributes(this.Yb, this.Yt.eW().b()));
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

    public void a(List list, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (DataWatcher.Item item : list) {
            new DataWatcher.c(item.a().a(), item.a().b(), item.b()).a(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.k(255);
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
