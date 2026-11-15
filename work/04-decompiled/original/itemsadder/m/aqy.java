package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.mojang.datafixers.util.Pair;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.aqo;
import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundCustomChatCompletionsPacket;
import net.minecraft.network.protocol.game.PacketPlayOutAnimation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityEffect;
import net.minecraft.network.protocol.game.PacketPlayOutRemoveEntityEffect;
import net.minecraft.network.protocol.game.PacketPlayOutUpdateAttributes;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.EnumHand;
import net.minecraft.world.EnumInteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifiable;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemBlock;
import net.minecraft.world.item.ItemSign;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockActionContext;
import net.minecraft.world.item.context.ItemActionContext;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BlockFacingHorizontal;
import net.minecraft.world.level.block.BlockTrapdoor;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntitySign;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.block.state.properties.BlockPropertyHalf;
import net.minecraft.world.level.block.state.properties.IBlockState;
import net.minecraft.world.phys.MovingObjectPositionBlock;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_21_R5.block.CraftBlock;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class aqy
implements aqo {
    static net.minecraft.world.item.ItemStack abs = Items.a.m();
    static List abt = new ArrayList();

    @Override
    public int bT(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        return entityPlayer.cn.l;
    }

    @Override
    public void a(PacketContainer packetContainer, EnumWrappers.ItemSlot itemSlot, ItemStack itemStack) {
        List list = (List)packetContainer.getModifier().withType(List.class).read(0);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(list);
        arrayList.add(new Pair((Object)EnumItemSlot.a((String)itemSlot.name().toLowerCase()), (Object)CraftItemStack.asNMSCopy((ItemStack)itemStack)));
        packetContainer.getModifier().withType(List.class).write(0, arrayList);
    }

    @Override
    public void h(Player player, Entity entity) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entityPlayer.e(entity2);
    }

    @Override
    public void i(Player player, Entity entity) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        entityPlayer.a(entity2, EnumHand.a);
    }

    @Override
    public void a(Player player, @NotNull Collection collection) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new ClientboundCustomChatCompletionsPacket(ClientboundCustomChatCompletionsPacket.Action.a, new ArrayList(collection)));
    }

    @Override
    public void b(Player player, @NotNull Collection collection) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new ClientboundCustomChatCompletionsPacket(ClientboundCustomChatCompletionsPacket.Action.b, new ArrayList(collection)));
    }

    @Override
    public void a(Player player, float f) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        AttributeModifiable attributeModifiable2 = new AttributeModifiable(GenericAttributes.f, attributeModifiable -> {});
        attributeModifiable2.a((double)f);
        PacketPlayOutUpdateAttributes packetPlayOutUpdateAttributes = new PacketPlayOutUpdateAttributes(entityPlayer.ar(), List.of(attributeModifiable2));
        entityPlayer.g.b((Packet)packetPlayOutUpdateAttributes);
        if (zw.UQ && ap.w(player)) {
            entityPlayer.g.b((Packet)new PacketPlayOutEntityEffect(entityPlayer.ar(), new MobEffect(MobEffects.d, -1, -1, false, false, false), true));
        }
    }

    @Override
    public void aO(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PacketPlayOutUpdateAttributes packetPlayOutUpdateAttributes = new PacketPlayOutUpdateAttributes(entityPlayer.ar(), List.of(entityPlayer.fg().a(GenericAttributes.f)));
        aow.a(packetPlayOutUpdateAttributes, true);
        entityPlayer.g.b((Packet)packetPlayOutUpdateAttributes);
        if (zw.UQ && ap.w(player)) {
            PotionEffect potionEffect = player.getPotionEffect(PotionEffectType.MINING_FATIGUE);
            if (potionEffect == null) {
                entityPlayer.g.b((Packet)new PacketPlayOutRemoveEntityEffect(entityPlayer.ar(), MobEffects.d));
            } else {
                entityPlayer.g.b((Packet)new PacketPlayOutEntityEffect(entityPlayer.ar(), new MobEffect(MobEffects.d, potionEffect.getDuration(), potionEffect.getAmplifier(), potionEffect.isAmbient(), potionEffect.hasParticles(), potionEffect.hasIcon()), true));
            }
        }
    }

    @Override
    public double a(Player player, double d) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        double d2 = entityPlayer.i(GenericAttributes.g);
        AttributeModifiable attributeModifiable2 = new AttributeModifiable(GenericAttributes.g, attributeModifiable -> {});
        attributeModifiable2.a(d);
        entityPlayer.g.b((Packet)new PacketPlayOutUpdateAttributes(entityPlayer.ar(), List.of(attributeModifiable2)));
        return d2;
    }

    @Override
    public void bV(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PacketPlayOutUpdateAttributes packetPlayOutUpdateAttributes = new PacketPlayOutUpdateAttributes(entityPlayer.ar(), List.of(entityPlayer.fg().a(GenericAttributes.g)));
        aow.a(packetPlayOutUpdateAttributes, true);
        entityPlayer.g.b((Packet)packetPlayOutUpdateAttributes);
    }

    @Override
    public boolean a(Player player, EquipmentSlot equipmentSlot, org.bukkit.block.Block block, Location location, BlockFace blockFace) {
        EnumInteractionResult enumInteractionResult;
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.item.ItemStack itemStack = entityPlayer.b(equipmentSlot == EquipmentSlot.HAND ? EnumHand.a : EnumHand.b);
        Item item = itemStack.h();
        EnumHand enumHand = equipmentSlot == EquipmentSlot.HAND ? EnumHand.a : EnumHand.b;
        WorldServer worldServer = entityPlayer.y();
        EnumDirection enumDirection = CraftBlock.blockFaceToNotch((BlockFace)blockFace);
        ItemActionContext itemActionContext = new ItemActionContext((World)worldServer, (EntityHuman)entityPlayer, enumHand, itemStack, new MovingObjectPositionBlock(new Vec3D(location.getX(), location.getY(), location.getZ()), enumDirection, new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ()), false));
        EnumInteractionResult enumInteractionResult2 = item.a(itemActionContext);
        if (enumInteractionResult2 instanceof EnumInteractionResult.d) {
            if (item instanceof ItemBlock) {
                TileEntity tileEntity;
                ItemBlock itemBlock = (ItemBlock)item;
                org.bukkit.block.Block block2 = block.getRelative(blockFace);
                BlockPosition blockPosition = new BlockPosition(block2.getX(), block2.getY(), block2.getZ());
                if (itemBlock instanceof ItemSign && (tileEntity = worldServer.c_(blockPosition)) instanceof TileEntitySign) {
                    TileEntitySign tileEntitySign = (TileEntitySign)tileEntity;
                    tileEntitySign.a(entityPlayer.cK());
                    entityPlayer.a(tileEntitySign, true);
                    this.a(player, block2, block);
                    return true;
                }
                Block block3 = itemBlock.c();
                if (block3 instanceof BlockTrapdoor) {
                    tileEntity = (BlockTrapdoor)block3;
                    if (worldServer.a_(blockPosition).b() instanceof BlockTrapdoor && (block3 = itemActionContext.k()).o().d()) {
                        BlockActionContext blockActionContext = new BlockActionContext(itemActionContext);
                        IBlockData iBlockData = tileEntity.a(blockActionContext);
                        assert (iBlockData != null);
                        ((IBlockData)iBlockData.b((IBlockState)BlockFacingHorizontal.f, (Comparable)blockActionContext.k())).b((IBlockState)BlockTrapdoor.c, (Comparable)(blockActionContext.l().e - (double)blockActionContext.a().v() > 0.5 ? BlockPropertyHalf.a : BlockPropertyHalf.b));
                        worldServer.A(blockPosition).a(blockPosition, iBlockData, 0);
                        this.a(player, block2, block);
                        return true;
                    }
                }
                this.a(player, block2, block);
            }
        } else if (enumInteractionResult2 instanceof EnumInteractionResult.c && (enumInteractionResult = item.a((World)worldServer, (EntityHuman)entityPlayer, enumHand)) instanceof EnumInteractionResult.d) {
            EnumInteractionResult.d d2 = (EnumInteractionResult.d)enumInteractionResult;
            net.minecraft.world.item.ItemStack itemStack2 = d2.d();
            if (itemStack2 != null) {
                entityPlayer.a(enumHand, itemStack2);
            }
            return true;
        }
        return false;
    }

    @Override
    public void c(Player player, ItemStack itemStack, int n) {
        player.setCooldown(itemStack, n);
    }

    @Override
    public void a(Player player, EquipmentSlot equipmentSlot) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation((net.minecraft.world.entity.Entity)entityPlayer, equipmentSlot == EquipmentSlot.HAND ? 0 : 3);
        entityPlayer.g.b((Packet)packetPlayOutAnimation);
    }

    static {
        for (EnumItemSlot enumItemSlot : EnumItemSlot.values()) {
            abt.add(new Pair((Object)enumItemSlot, (Object)abs));
        }
    }
}
