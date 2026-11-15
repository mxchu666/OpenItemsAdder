package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.NamespacedKeyVectorHolder;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PlayerInteractAtEntityListener_2
implements PluginContract {
    private final ItemStackRegistry zq;

    public PlayerInteractAtEntityListener_2(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zq = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::d));
        itemStackRegistry.ar.a(new ClassRefData(InventoryClickEvent.class, this::d));
        itemStackRegistry.ar.a(new ClassRefData(InventoryClickEvent.class, this::c));
    }

    @PluginContract_19
    private void c(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (inventoryClickEvent.getInventory().getType() != InventoryType.CRAFTING) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_42 = this.zq.a(inventoryClickEvent.getCurrentItem());
        if (itemStackBuilder_42 != null) {
            if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && (player.getInventory().getHelmet() == null || player.getInventory().getHelmet().getType() == Material.AIR) && itemStackBuilder_42.Ge.bm("hat")) {
                itemStackBuilder_42.a((LivingEntity)player, BlockBreakEnum.WEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, inventoryClickEvent.getCurrentItem()));
                inventoryClickEvent.setCancelled(true);
                player.getInventory().setHelmet(inventoryClickEvent.getCurrentItem());
                inventoryClickEvent.setCurrentItem(null);
            } else if (inventoryClickEvent.getAction() == InventoryAction.PLACE_ALL || inventoryClickEvent.getAction() == InventoryAction.NOTHING) {
                itemStackBuilder_42.a((LivingEntity)player, BlockBreakEnum.WEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, inventoryClickEvent.getCurrentItem()));
                ItemStackBuilder_4 itemStackBuilder_43 = this.zq.a(inventoryClickEvent.getCursor());
                if (itemStackBuilder_43 != null && itemStackBuilder_43.nu() && itemStackBuilder_42.Ge.bm("hat")) {
                    itemStackBuilder_42.a((LivingEntity)inventoryClickEvent.getWhoClicked(), BlockBreakEnum.UNWEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, inventoryClickEvent.getCurrentItem()));
                }
            }
        } else {
            ItemStackBuilder_4 itemStackBuilder_44 = this.zq.a(inventoryClickEvent.getCursor());
            if (itemStackBuilder_44 != null && inventoryClickEvent.getRawSlot() == 5 && itemStackBuilder_44.Ge.bm("hat") && (player.getInventory().getHelmet() == null || player.getInventory().getHelmet().getType() == Material.AIR)) {
                itemStackBuilder_44.a((LivingEntity)player, BlockBreakEnum.WEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_44, inventoryClickEvent.getCursor()));
                inventoryClickEvent.setCancelled(true);
                player.getInventory().setHelmet(inventoryClickEvent.getCursor());
                inventoryClickEvent.setCursor(null);
            }
        }
    }

    @PluginContract_19
    private void d(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK && playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        if (playerInteractEvent.getPlayer().getInventory().getHelmet() != null && playerInteractEvent.getPlayer().getInventory().getHelmet().getType() != Material.AIR) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("hat")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        if (Main.PO && new NItem(itemStack).hasKey("BPIsBackPack")) {
            return;
        }
        ItemStack itemStack2 = playerInteractEvent.getItem().clone();
        itemStack2.setAmount(1);
        playerInteractEvent.getPlayer().getInventory().setHelmet(itemStack2);
        ItemStackBridge_2.cy(playerInteractEvent.getPlayer());
        itemStackBuilder_4.a((LivingEntity)playerInteractEvent.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
        itemStackBuilder_4.a((LivingEntity)playerInteractEvent.getPlayer(), BlockBreakEnum.WEAR, builder_14 -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void d(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_42;
        if (!inventoryClickEvent.getSlotType().equals((Object)InventoryType.SlotType.ARMOR)) {
            return;
        }
        if (inventoryClickEvent.getCursor() == null) {
            return;
        }
        if (itemStackBuilder_4 != null) {
            if (itemStackBuilder_4.Ge.bm("hat")) {
                itemStackBuilder_4.a((LivingEntity)inventoryClickEvent.getWhoClicked(), BlockBreakEnum.UNWEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_4, itemStack));
            }
        } else if (ItemStackBuilder_4.isCustomItem(inventoryClickEvent.getCursor()) && (itemStackBuilder_42 = this.zq.a(inventoryClickEvent.getCursor())) != null) {
            if (!itemStackBuilder_42.Ge.bm("hat")) {
                return;
            }
            itemStackBuilder_42.a((LivingEntity)inventoryClickEvent.getWhoClicked(), BlockBreakEnum.UNWEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, inventoryClickEvent.getCursor()));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (!(playerInteractAtEntityEvent.getRightClicked() instanceof ArmorStand)) {
            return;
        }
        ItemStack itemStack = playerInteractAtEntityEvent.getPlayer().getInventory().getItemInMainHand();
        ItemStackBuilder_4 itemStackBuilder_4 = this.zq.a(itemStack);
        if (itemStackBuilder_4 == null || !itemStackBuilder_4.Ge.bm("hat")) {
            return;
        }
        ArmorStand armorStand = (ArmorStand)playerInteractAtEntityEvent.getRightClicked();
        if (armorStand.getEquipment() != null) {
            playerInteractAtEntityEvent.setCancelled(true);
            if (NamespacedKeyItemDisplayHolder.w((Entity)armorStand) || NamespacedKeyVectorHolder.D((Entity)armorStand)) {
                return;
            }
            if (armorStand.getEquipment().getHelmet().getType() != Material.AIR) {
                ItemStackBridge_2.f(playerInteractAtEntityEvent.getPlayer(), armorStand.getEquipment().getHelmet());
            }
            ItemStack itemStack2 = itemStack.clone();
            itemStack2.setAmount(1);
            ItemStackBridge_2.cy(playerInteractAtEntityEvent.getPlayer());
            armorStand.getEquipment().setHelmet(itemStack2);
            ItemStack itemStack3 = armorStand.getEquipment().getHelmet();
            itemStackBuilder_4.a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), BlockBreakEnum.ARMOR_STAND_PUT_ITEM, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, itemStackBuilder_4, itemStack3));
            itemStackBuilder_4.a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, itemStackBuilder_4, itemStack3));
            itemStackBuilder_4.a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), BlockBreakEnum.UNHELD_OFFHAND, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, itemStackBuilder_4, itemStack3));
        }
    }
}
