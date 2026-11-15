package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.js;
import itemsadder.m.kh;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
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

public class kp
implements ai {
    private final d zq;

    public kp(Plugin plugin, d d2) {
        this.zq = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(PlayerInteractEvent.class, this::d));
        d2.ar.a(new my(InventoryClickEvent.class, this::d));
        d2.ar.a(new my(InventoryClickEvent.class, this::c));
    }

    @mz
    private void c(InventoryClickEvent inventoryClickEvent, qm qm2, ItemStack itemStack) {
        Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (inventoryClickEvent.getInventory().getType() != InventoryType.CRAFTING) {
            return;
        }
        qm qm3 = this.zq.a(inventoryClickEvent.getCurrentItem());
        if (qm3 != null) {
            if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && (player.getInventory().getHelmet() == null || player.getInventory().getHelmet().getType() == Material.AIR) && qm3.Ge.bm("hat")) {
                qm3.a((LivingEntity)player, jj.WEAR, ou2 -> ou2.e(inventoryClickEvent, qm3, inventoryClickEvent.getCurrentItem()));
                inventoryClickEvent.setCancelled(true);
                player.getInventory().setHelmet(inventoryClickEvent.getCurrentItem());
                inventoryClickEvent.setCurrentItem(null);
            } else if (inventoryClickEvent.getAction() == InventoryAction.PLACE_ALL || inventoryClickEvent.getAction() == InventoryAction.NOTHING) {
                qm3.a((LivingEntity)player, jj.WEAR, ou2 -> ou2.e(inventoryClickEvent, qm3, inventoryClickEvent.getCurrentItem()));
                qm qm4 = this.zq.a(inventoryClickEvent.getCursor());
                if (qm4 != null && qm4.nu() && qm3.Ge.bm("hat")) {
                    qm3.a((LivingEntity)inventoryClickEvent.getWhoClicked(), jj.UNWEAR, ou2 -> ou2.e(inventoryClickEvent, qm3, inventoryClickEvent.getCurrentItem()));
                }
            }
        } else {
            qm qm5 = this.zq.a(inventoryClickEvent.getCursor());
            if (qm5 != null && inventoryClickEvent.getRawSlot() == 5 && qm5.Ge.bm("hat") && (player.getInventory().getHelmet() == null || player.getInventory().getHelmet().getType() == Material.AIR)) {
                qm5.a((LivingEntity)player, jj.WEAR, ou2 -> ou2.e(inventoryClickEvent, qm5, inventoryClickEvent.getCursor()));
                inventoryClickEvent.setCancelled(true);
                player.getInventory().setHelmet(inventoryClickEvent.getCursor());
                inventoryClickEvent.setCursor(null);
            }
        }
    }

    @mz
    private void d(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK && playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        if (playerInteractEvent.getPlayer().getInventory().getHelmet() != null && playerInteractEvent.getPlayer().getInventory().getHelmet().getType() != Material.AIR) {
            return;
        }
        if (!qm2.Ge.bm("hat")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        if (Main.PO && new NItem(itemStack).hasKey("BPIsBackPack")) {
            return;
        }
        ItemStack itemStack2 = playerInteractEvent.getItem().clone();
        itemStack2.setAmount(1);
        playerInteractEvent.getPlayer().getInventory().setHelmet(itemStack2);
        bbs.cy(playerInteractEvent.getPlayer());
        qm2.a((LivingEntity)playerInteractEvent.getPlayer(), jj.UNHELD, ou2 -> ou2.j(playerInteractEvent, qm2, itemStack));
        qm2.a((LivingEntity)playerInteractEvent.getPlayer(), jj.WEAR, ou2 -> ou2.j(playerInteractEvent, qm2, itemStack));
    }

    @mz
    private void d(InventoryClickEvent inventoryClickEvent, qm qm2, ItemStack itemStack) {
        qm qm3;
        if (!inventoryClickEvent.getSlotType().equals((Object)InventoryType.SlotType.ARMOR)) {
            return;
        }
        if (inventoryClickEvent.getCursor() == null) {
            return;
        }
        if (qm2 != null) {
            if (qm2.Ge.bm("hat")) {
                qm2.a((LivingEntity)inventoryClickEvent.getWhoClicked(), jj.UNWEAR, ou2 -> ou2.e(inventoryClickEvent, qm2, itemStack));
            }
        } else if (qm.isCustomItem(inventoryClickEvent.getCursor()) && (qm3 = this.zq.a(inventoryClickEvent.getCursor())) != null) {
            if (!qm3.Ge.bm("hat")) {
                return;
            }
            qm3.a((LivingEntity)inventoryClickEvent.getWhoClicked(), jj.UNWEAR, ou2 -> ou2.e(inventoryClickEvent, qm3, inventoryClickEvent.getCursor()));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (!(playerInteractAtEntityEvent.getRightClicked() instanceof ArmorStand)) {
            return;
        }
        ItemStack itemStack = playerInteractAtEntityEvent.getPlayer().getInventory().getItemInMainHand();
        qm qm2 = this.zq.a(itemStack);
        if (qm2 == null || !qm2.Ge.bm("hat")) {
            return;
        }
        ArmorStand armorStand = (ArmorStand)playerInteractAtEntityEvent.getRightClicked();
        if (armorStand.getEquipment() != null) {
            playerInteractAtEntityEvent.setCancelled(true);
            if (js.w((Entity)armorStand) || kh.D((Entity)armorStand)) {
                return;
            }
            if (armorStand.getEquipment().getHelmet().getType() != Material.AIR) {
                bbs.f(playerInteractAtEntityEvent.getPlayer(), armorStand.getEquipment().getHelmet());
            }
            ItemStack itemStack2 = itemStack.clone();
            itemStack2.setAmount(1);
            bbs.cy(playerInteractAtEntityEvent.getPlayer());
            armorStand.getEquipment().setHelmet(itemStack2);
            ItemStack itemStack3 = armorStand.getEquipment().getHelmet();
            qm2.a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), jj.ARMOR_STAND_PUT_ITEM, ou2 -> ou2.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, qm2, itemStack3));
            qm2.a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), jj.UNHELD, ou2 -> ou2.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, qm2, itemStack3));
            qm2.a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), jj.UNHELD_OFFHAND, ou2 -> ou2.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, qm2, itemStack3));
        }
    }
}
