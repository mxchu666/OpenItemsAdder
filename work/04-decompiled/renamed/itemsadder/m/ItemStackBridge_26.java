package itemsadder.m;

import itemsadder.m.BlockHolder;
import itemsadder.m.BoolData;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.RelativeEnum;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_26
extends BoolData {
    final LocationBridgeBuilder_2 DD;
    final Material DE;
    private final RelativeEnum DF;

    public ItemStackBridge_26(LocationBridgeBuilder_2 locationBridgeBuilder_2, RelativeEnum relativeEnum, boolean bl) {
        super(bl);
        this.DD = locationBridgeBuilder_2;
        this.DF = relativeEnum;
        this.DE = null;
    }

    public ItemStackBridge_26(Material material, RelativeEnum relativeEnum, boolean bl) {
        super(bl);
        this.DE = material;
        this.DF = relativeEnum;
        this.DD = null;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStack, player.getLocation().getBlock());
    }

    @Override
    public ItemStackBuilder_3 a(Event event, Block block, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStack, block);
    }

    @Override
    public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.getClickedBlock() == null) {
            return ItemStackBuilder_3.l(itemStack);
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || ItemStackBridge_2.G(itemStack) || ItemStackBuilder_4.G(itemStack)) {
            return ItemStackBuilder_3.l(itemStack);
        }
        BukkitTaskBridge.c(() -> {
            Player player = playerInteractEvent.getPlayer();
            Block block = this.DF == RelativeEnum.CLICKED ? playerInteractEvent.getClickedBlock() : playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
            boolean bl = false;
            if (this.DD != null) {
                bl = ItemStackRegistry.g().aE.a(playerInteractEvent, this.DD, this.DD.mP(), false, false);
            } else if (this.DE != null && LocationBridge_2.b(block, player)) {
                block.setType(this.DE);
                BlockHolder.t(block);
                bl = true;
            }
            if (bl && this.Cq) {
                ItemStackBridge_2.aj(itemStack);
            }
        }, 2L);
        return ItemStackBuilder_3.m(itemStack);
    }

    private ItemStackBuilder_3 a(Event event, Player player, ItemStack itemStack, Block block) {
        if (itemStack == null || itemStack.getType() == Material.AIR || ItemStackBridge_2.G(itemStack) || ItemStackBuilder_4.G(itemStack)) {
            return ItemStackBuilder_3.mk();
        }
        Block block2 = PlayerHolder_4.bZ(player);
        if (LocationBridge_2.b(block2, player)) {
            boolean bl = false;
            if (this.DD != null) {
                bl = this.DD.as(block2);
                if (bl) {
                    this.DD.xu.HQ.a(block2.getLocation(), SoundCategory.BLOCKS);
                }
            } else if (this.DE != null) {
                block2.setType(this.DE);
                BlockHolder.t(block2);
                bl = true;
            }
            if (bl) {
                PlayerHolder_4.a(player, EquipmentSlot.HAND);
                if (this.Cq) {
                    ItemStackBridge_2.aj(itemStack);
                }
                return ItemStackBuilder_3.ml();
            }
        }
        return ItemStackBuilder_3.mk();
    }
}
