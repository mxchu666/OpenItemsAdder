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
import org.bukkit.craftbukkit.v1_21_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_21_R2.enchantments.CraftEnchantment;
import org.bukkit.craftbukkit.v1_21_R2.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class adx
extends adq {
    static Field Ys = zw.a(DataWatcher.class, DataWatcher.Item[].class);
    private final EntityArmorStand Za;
    private final EntityAreaEffectCloud Zb;
    private final PacketPlayOutEntityDestroy Zc;
    ClientboundBundlePacket Yw;
    private final List Zd;
    private final List Ze;
    private final DataWatcher.Item Zf;
    private final DataWatcher.Item Zg;
    private final EnumItemSlot Zh;

    public adx(Location location, EquipmentSlot equipmentSlot, boolean bl, boolean bl2, boolean bl3) {
        super(location, bl);
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        this.Za = new EntityArmorStand((World)worldServer, location.getX(), location.getY(), location.getZ());
        this.XY = new bcz(this.Za.du().d, this.Za.du().e, this.Za.du().f);
        this.Yb = this.Za.ar();
        this.Za.f(true);
        this.Za.p(false);
        this.Za.k(true);
        this.Za.b(true);
        this.Za.v(bl2 || !bl3);
        this.Za.v(0.0f);
        this.Za.w(0.0f);
        this.Zb = new EntityAreaEffectCloud((World)worldServer, location.getX(), location.getY(), location.getZ());
        this.Ya = this.Zb.ar();
        this.XZ = new bcz(this.Zb.du().d, this.Zb.du().e, this.Zb.du().f);
        this.Zb.af = Integer.MIN_VALUE;
        this.Zb.a(-1);
        this.Zb.c(Integer.MIN_VALUE);
        this.Zb.a(0.0f);
        this.Zb.a(new PotionContents(this.Zb.k.e(), Optional.of(new Color(0, 0, 0, 0).getRGB()), this.Zb.k.d(), this.Zb.k.g()));
        this.Zb.k(true);
        this.Yk = (double)this.Zb.aq().n().b() * 0.75;
        this.XU = this.XZ.Dw();
        this.XV = this.XY.Dw();
        this.XW = this.XZ.Dw();
        this.XX = this.XY.Dw();
        this.Zc = new PacketPlayOutEntityDestroy(new int[]{this.Za.ar(), this.Zb.ar()});
        this.Zh = EnumItemSlot.a((String)aqp.a(equipmentSlot));
        if (zw.sZ()) {
            this.Zf = this.Za.au().b(this.Zh == EnumItemSlot.a ? EntityArmorStand.bN : EntityArmorStand.bK);
            this.Zg = this.Za.au().b((DataWatcherObject)zw.a(Entity.class, DataWatcherObject.class, 0));
        } else {
            try {
                DataWatcher.Item[] itemArray = (DataWatcher.Item[])Ys.get(this.Za.au());
                this.Zf = itemArray[this.Zh == EnumItemSlot.a ? EntityArmorStand.bN.a() : EntityArmorStand.bK.a()];
                this.Zg = itemArray[((DataWatcherObject)zw.a(Entity.class, DataWatcherObject.class, 0)).a()];
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        }
        this.Zd = Lists.newArrayList(this.Zf);
        this.Ze = Lists.newArrayList(this.Zg);
    }

    @Override
    public void c(float f, float f2, float f3) {
        Vector3f vector3f = (Vector3f)this.Zf.b();
        if (adx.c(vector3f.b(), f) && adx.c(vector3f.c(), f2) && adx.c(vector3f.d(), f3)) {
            return;
        }
        this.Zf.a((Object)new Vector3f(f, f2, f3));
        this.Yf = true;
    }

    @Override
    public boolean q(float f) {
        if (!super.q(f)) {
            return false;
        }
        this.Za.aZ = f;
        this.Za.v(f);
        return true;
    }

    private static PacketPlayOutSpawnEntity a(Entity entity, bcz bcz2, double d) {
        return new PacketPlayOutSpawnEntity(entity.ar(), entity.cG(), bcz2.akd, bcz2.ake, bcz2.akf, entity.dO(), entity.dM(), entity.aq(), 0, entity.dz(), d);
    }

    private ClientboundBundlePacket tD() {
        if (this.Zh == EnumItemSlot.a) {
            this.Za.d((Vector3f)this.Zf.b());
        } else {
            this.Za.a((Vector3f)this.Zf.b());
        }
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = adx.a((Entity)this.Za, this.XY, (double)this.Za.aZ);
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(this.Za.ar(), this.Za.au().c());
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity2 = adx.a((Entity)this.Zb, this.XZ, 0.0);
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata2 = new PacketPlayOutEntityMetadata(this.Zb.ar(), this.Zb.au().c());
        this.Zb.q = ImmutableList.of(this.Za);
        PacketPlayOutMount packetPlayOutMount = new PacketPlayOutMount((Entity)this.Zb);
        return new ClientboundBundlePacket(List.of(packetPlayOutSpawnEntity, packetPlayOutEntityMetadata, packetPlayOutSpawnEntity2, packetPlayOutEntityMetadata2, packetPlayOutMount));
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
        this.a(do_.iW, (Packet)this.Zc);
    }

    @Override
    public void d(List list, int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = this.aE(n);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (do_.fs()) continue;
            this.a(do_.iW, (Packet)packetPlayOutEntityEquipment);
        }
    }

    @Override
    public void a(do do_, int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = this.aE(n);
        if (!do_.fs()) {
            this.a(do_.iW, (Packet)packetPlayOutEntityEquipment);
        }
    }

    @Override
    public void e(List list, int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = this.aD(n);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (do_.fs()) continue;
            this.a(do_.iW, (Packet)packetPlayOutEntityEquipment);
        }
    }

    @Override
    public void a(@Nullable Player player, List list, ItemStack itemStack) {
        net.minecraft.world.item.ItemStack itemStack2 = CraftItemStack.asNMSCopy((ItemStack)itemStack);
        itemStack2.c(DataComponents.h);
        itemStack2.c(DataComponents.g);
        itemStack2.c(DataComponents.j);
        itemStack2.c(DataComponents.o);
        itemStack2.c(DataComponents.ag);
        itemStack2.c(DataComponents.b);
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        arrayList.add(new Pair((Object)this.Zh, (Object)itemStack2));
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.Za.ar(), arrayList);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_.iW, (Packet)packetPlayOutEntityEquipment);
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
        net.minecraft.world.item.ItemStack itemStack = new net.minecraft.world.item.ItemStack((IMaterial)Items.sZ, 1);
        if (bl) {
            itemStack.b(DataComponents.Q, (Object)new PotionContents(PotionContents.a.e(), Optional.of(0xFF7E7E), PotionContents.a.d(), PotionContents.a.g()));
        } else {
            itemStack.b(DataComponents.Q, (Object)new PotionContents(PotionContents.a.e(), Optional.of(this.JJ), PotionContents.a.d(), PotionContents.a.g()));
        }
        if (this.Yi) {
            itemStack.a(CraftEnchantment.bukkitToMinecraftHolder((Enchantment)Enchantment.SHARPNESS), 1);
        }
        itemStack.b(DataComponents.p, (Object)new CustomModelData(n));
        return itemStack;
    }

    private PacketPlayOutEntityEquipment aD(int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = (PacketPlayOutEntityEquipment)this.XS.get(n);
        if (packetPlayOutEntityEquipment == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, true);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.Zh, (Object)itemStack));
            packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.Za.ar(), arrayList);
            this.XS.put(n, packetPlayOutEntityEquipment);
        }
        return packetPlayOutEntityEquipment;
    }

    private PacketPlayOutEntityEquipment aE(int n) {
        PacketPlayOutEntityEquipment packetPlayOutEntityEquipment = (PacketPlayOutEntityEquipment)this.XR.get(n);
        if (packetPlayOutEntityEquipment == null) {
            net.minecraft.world.item.ItemStack itemStack = this.b(n, false);
            ArrayList<Pair> arrayList = new ArrayList<Pair>();
            arrayList.add(new Pair((Object)this.Zh, (Object)itemStack));
            packetPlayOutEntityEquipment = new PacketPlayOutEntityEquipment(this.Za.ar(), arrayList);
            this.XR.put(n, packetPlayOutEntityEquipment);
        }
        return packetPlayOutEntityEquipment;
    }

    @Override
    public void w(List list) {
        if (!(this.Yg || !list.isEmpty() && this.Yf)) {
            return;
        }
        this.b(list, this.Zd);
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

    PacketDataSerializer a(boolean bl, int n, double d, double d2, double d3, float f, float f2, boolean bl2) {
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer((int)30));
        if (bl) {
            packetDataSerializer.l(aox.aku);
        }
        packetDataSerializer.c(n);
        PositionMoveRotation.a.encode((Object)packetDataSerializer, (Object)new PositionMoveRotation(new Vec3D(d, d2, d3), Vec3D.c, f, f2));
        Relative.m.encode((Object)packetDataSerializer, Set.of());
        packetDataSerializer.a(bl2);
        return packetDataSerializer;
    }

    PacketDataSerializer a(int n, List list) {
        RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf((ByteBuf)new PacketDataSerializer(Unpooled.buffer((int)30)), (IRegistryCustom)IRegistryCustom.b);
        registryFriendlyByteBuf.l(aox.akv);
        registryFriendlyByteBuf.c(n);
        this.a(list, registryFriendlyByteBuf);
        return registryFriendlyByteBuf;
    }

    protected void a(do do_, float f, bcz bcz2, bcz bcz3) {
        PacketDataSerializer packetDataSerializer;
        if (this.Ye) {
            packetDataSerializer = this.a(true, this.Yb, bcz3.akd, bcz3.ake, bcz3.akf, f, 0.0f, false);
            this.a(do_.iW, packetDataSerializer);
        }
        if (this.Yd) {
            packetDataSerializer = this.a(true, this.Ya, bcz2.akd, bcz2.ake, bcz2.akf, 0.0f, 0.0f, false);
            this.a(do_.iW, packetDataSerializer);
        }
    }

    @Override
    public void x(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.XT) {
            this.Zg.a((Object)((byte)((Byte)this.Zg.b() | 1)));
        } else {
            this.Zg.a((Object)((byte)((Byte)this.Zg.b() & 0xFFFFFFFE)));
        }
        this.b(list, this.Ze);
    }

    private void b(List list, List list2) {
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl() || !do_.fm()) continue;
            this.a(do_.iW, this.a(this.Yb, list2));
        }
    }

    @Override
    public void bK(Player player) {
        this.Za.g(GenericAttributes.s).a(1.0);
        this.a(player, (Packet)new PacketPlayOutUpdateAttributes(this.Yb, this.Za.eY().c()));
    }

    public void a(do do_, Packet packet) {
        aow.uN().d(do_.iW, packet);
    }

    public void a(Player player, Packet packet) {
        aow.uN().d(player, packet);
    }

    public void a(Player player, PacketDataSerializer packetDataSerializer) {
        aow.c(player, packetDataSerializer);
    }

    public void a(List list, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (DataWatcher.Item item : list) {
            new DataWatcher.c(item.a().a(), item.a().b(), item.b()).a(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.l(255);
    }

    private void a(Packet packet) {
        aoy.dK(packet.getClass().getName());
        if (packet instanceof ClientboundBundlePacket) {
            ClientboundBundlePacket clientboundBundlePacket = (ClientboundBundlePacket)packet;
            Iterable iterable = clientboundBundlePacket.b();
            for (Packet packet2 : iterable) {
                aoy.dK(packet2.getClass().getName());
            }
        }
    }

    private void a(PacketDataSerializer packetDataSerializer) {
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
