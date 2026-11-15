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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.network.protocol.game.ClientboundCustomChatCompletionsPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class arc
implements aqo {
    static net.minecraft.world.item.ItemStack abs = Items.AIR.getDefaultInstance();
    static List abt = new ArrayList();

    @Override
    public int bT(org.bukkit.entity.Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        return serverPlayer.containerMenu.containerId;
    }

    @Override
    public void a(PacketContainer packetContainer, EnumWrappers.ItemSlot itemSlot, ItemStack itemStack) {
        List list = (List)packetContainer.getModifier().withType(List.class).read(0);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(list);
        arrayList.add(new Pair((Object)EquipmentSlot.byName((String)itemSlot.name().toLowerCase()), (Object)CraftItemStack.asNMSCopy((ItemStack)itemStack)));
        packetContainer.getModifier().withType(List.class).write(0, arrayList);
    }

    @Override
    public void h(org.bukkit.entity.Player player, Entity entity) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        serverPlayer.attack(entity2);
    }

    @Override
    public void i(org.bukkit.entity.Player player, Entity entity) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity2 = ((CraftEntity)entity).getHandle();
        serverPlayer.interactOn(entity2, InteractionHand.MAIN_HAND, new Vec3(0.5, 0.5, 0.5));
    }

    @Override
    public void a(org.bukkit.entity.Player player, @NotNull Collection collection) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundCustomChatCompletionsPacket(ClientboundCustomChatCompletionsPacket.Action.ADD, new ArrayList(collection)));
    }

    @Override
    public void b(org.bukkit.entity.Player player, @NotNull Collection collection) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundCustomChatCompletionsPacket(ClientboundCustomChatCompletionsPacket.Action.REMOVE, new ArrayList(collection)));
    }

    @Override
    public void a(org.bukkit.entity.Player player, float f) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        AttributeInstance attributeInstance2 = new AttributeInstance(Attributes.BLOCK_BREAK_SPEED, attributeInstance -> {});
        attributeInstance2.setBaseValue((double)f);
        ClientboundUpdateAttributesPacket clientboundUpdateAttributesPacket = new ClientboundUpdateAttributesPacket(serverPlayer.getId(), List.of(attributeInstance2));
        serverPlayer.connection.send((Packet)clientboundUpdateAttributesPacket);
        if (zw.UQ && ap.w(player)) {
            serverPlayer.connection.send((Packet)new ClientboundUpdateMobEffectPacket(serverPlayer.getId(), new MobEffectInstance(MobEffects.MINING_FATIGUE, -1, -1, false, false, false), true));
        }
    }

    @Override
    public void aO(org.bukkit.entity.Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        ClientboundUpdateAttributesPacket clientboundUpdateAttributesPacket = new ClientboundUpdateAttributesPacket(serverPlayer.getId(), List.of(serverPlayer.getAttributes().getInstance(Attributes.BLOCK_BREAK_SPEED)));
        aow.a(clientboundUpdateAttributesPacket, true);
        serverPlayer.connection.send((Packet)clientboundUpdateAttributesPacket);
        if (zw.UQ && ap.w(player)) {
            PotionEffect potionEffect = player.getPotionEffect(PotionEffectType.MINING_FATIGUE);
            if (potionEffect == null) {
                serverPlayer.connection.send((Packet)new ClientboundRemoveMobEffectPacket(serverPlayer.getId(), MobEffects.MINING_FATIGUE));
            } else {
                serverPlayer.connection.send((Packet)new ClientboundUpdateMobEffectPacket(serverPlayer.getId(), new MobEffectInstance(MobEffects.MINING_FATIGUE, potionEffect.getDuration(), potionEffect.getAmplifier(), potionEffect.isAmbient(), potionEffect.hasParticles(), potionEffect.hasIcon()), true));
            }
        }
    }

    @Override
    public double a(org.bukkit.entity.Player player, double d) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        double d2 = serverPlayer.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE);
        AttributeInstance attributeInstance2 = new AttributeInstance(Attributes.BLOCK_INTERACTION_RANGE, attributeInstance -> {});
        attributeInstance2.setBaseValue(d);
        serverPlayer.connection.send((Packet)new ClientboundUpdateAttributesPacket(serverPlayer.getId(), List.of(attributeInstance2)));
        return d2;
    }

    @Override
    public void bV(org.bukkit.entity.Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        ClientboundUpdateAttributesPacket clientboundUpdateAttributesPacket = new ClientboundUpdateAttributesPacket(serverPlayer.getId(), List.of(serverPlayer.getAttributes().getInstance(Attributes.BLOCK_INTERACTION_RANGE)));
        aow.a(clientboundUpdateAttributesPacket, true);
        serverPlayer.connection.send((Packet)clientboundUpdateAttributesPacket);
    }

    @Override
    public boolean a(org.bukkit.entity.Player player, org.bukkit.inventory.EquipmentSlot equipmentSlot, org.bukkit.block.Block block, Location location, BlockFace blockFace) {
        InteractionResult interactionResult;
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.item.ItemStack itemStack = serverPlayer.getItemInHand(equipmentSlot == org.bukkit.inventory.EquipmentSlot.HAND ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        Item item = itemStack.getItem();
        InteractionHand interactionHand = equipmentSlot == org.bukkit.inventory.EquipmentSlot.HAND ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        ServerLevel serverLevel = serverPlayer.level();
        Direction direction = CraftBlock.blockFaceToNotch((BlockFace)blockFace);
        UseOnContext useOnContext = new UseOnContext((Level)serverLevel, (Player)serverPlayer, interactionHand, itemStack, new BlockHitResult(new Vec3(location.getX(), location.getY(), location.getZ()), direction, new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ()), false));
        InteractionResult interactionResult2 = item.useOn(useOnContext);
        if (interactionResult2 instanceof InteractionResult.Success) {
            if (item instanceof BlockItem) {
                BlockEntity blockEntity;
                BlockItem blockItem = (BlockItem)item;
                org.bukkit.block.Block block2 = block.getRelative(blockFace);
                BlockPos blockPos = new BlockPos(block2.getX(), block2.getY(), block2.getZ());
                if (blockItem instanceof SignItem && (blockEntity = serverLevel.getBlockEntity(blockPos)) instanceof SignBlockEntity) {
                    SignBlockEntity signBlockEntity = (SignBlockEntity)blockEntity;
                    signBlockEntity.setAllowedPlayerEditor(serverPlayer.getUUID());
                    serverPlayer.openTextEdit(signBlockEntity, true);
                    this.a(player, block2, block);
                    return true;
                }
                Block block3 = blockItem.getBlock();
                if (block3 instanceof TrapDoorBlock) {
                    blockEntity = (TrapDoorBlock)block3;
                    if (serverLevel.getBlockState(blockPos).getBlock() instanceof TrapDoorBlock && (block3 = useOnContext.getClickedFace()).getAxis().isHorizontal()) {
                        BlockPlaceContext blockPlaceContext = new BlockPlaceContext(useOnContext);
                        BlockState blockState = blockEntity.getStateForPlacement(blockPlaceContext);
                        assert (blockState != null);
                        ((BlockState)blockState.setValue((Property)HorizontalDirectionalBlock.FACING, (Comparable)blockPlaceContext.getClickedFace())).setValue((Property)TrapDoorBlock.HALF, (Comparable)(blockPlaceContext.getClickLocation().y - (double)blockPlaceContext.getClickedPos().getY() > 0.5 ? Half.TOP : Half.BOTTOM));
                        serverLevel.getChunk(blockPos).setBlockState(blockPos, blockState, 0);
                        this.a(player, block2, block);
                        return true;
                    }
                }
                this.a(player, block2, block);
            }
        } else if (interactionResult2 instanceof InteractionResult.Pass && (interactionResult = item.use((Level)serverLevel, (Player)serverPlayer, interactionHand)) instanceof InteractionResult.Success) {
            InteractionResult.Success success = (InteractionResult.Success)interactionResult;
            net.minecraft.world.item.ItemStack itemStack2 = success.heldItemTransformedTo();
            if (itemStack2 != null) {
                serverPlayer.setItemInHand(interactionHand, itemStack2);
            }
            return true;
        }
        return false;
    }

    @Override
    public void c(org.bukkit.entity.Player player, ItemStack itemStack, int n) {
        player.setCooldown(itemStack, n);
    }

    @Override
    public void a(org.bukkit.entity.Player player, org.bukkit.inventory.EquipmentSlot equipmentSlot) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        ClientboundAnimatePacket clientboundAnimatePacket = new ClientboundAnimatePacket((net.minecraft.world.entity.Entity)serverPlayer, equipmentSlot == org.bukkit.inventory.EquipmentSlot.HAND ? 0 : 3);
        serverPlayer.connection.send((Packet)clientboundAnimatePacket);
    }

    static {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            abt.add(new Pair((Object)equipmentSlot, (Object)abs));
        }
    }
}
