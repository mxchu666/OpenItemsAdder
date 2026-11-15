package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jl;
import itemsadder.m.jm;
import itemsadder.m.jy;
import itemsadder.m.kg;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.qv;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.Plugin;

public class kz
implements ai {
    private final d zI;
    final WeakHashMap zJ = new WeakHashMap();

    public kz(Plugin plugin, d d2) {
        this.zI = d2;
        bev.a(this, plugin);
    }

    public boolean az(Player player) {
        return this.zJ.containsKey(player);
    }

    public void a(Player player, kg kg2) {
        this.zJ.put(player, kg2);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void d(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (bbs.d((PlayerInteractEntityEvent)playerInteractAtEntityEvent)) {
            return;
        }
        if (playerInteractAtEntityEvent.getPlayer().isSneaking()) {
            return;
        }
        if (!(playerInteractAtEntityEvent.getRightClicked() instanceof ArmorStand)) {
            return;
        }
        if (!ProtectionPlugins.canInteract_tradeMachineArmorstand(playerInteractAtEntityEvent)) {
            return;
        }
        ArmorStand armorStand = (ArmorStand)playerInteractAtEntityEvent.getRightClicked();
        ItemStack itemStack = armorStand.getHelmet();
        if (itemStack == null) {
            return;
        }
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        if (!qm2.Ge.bm("furniture_trade_machine")) {
            return;
        }
        playerInteractAtEntityEvent.setCancelled(true);
        jy jy2 = (jy)qm2.Ge.bn("furniture_trade_machine");
        if (!s.b((Permissible)playerInteractAtEntityEvent.getPlayer(), jy2.getPermission(), true)) {
            return;
        }
        this.zJ.put(playerInteractAtEntityEvent.getPlayer(), jy2);
        jy2.au(playerInteractAtEntityEvent.getPlayer());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void e(PlayerInteractEvent playerInteractEvent) {
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (playerInteractEvent.getPlayer().isSneaking()) {
            return;
        }
        if (playerInteractEvent.useInteractedBlock() == Event.Result.DENY) {
            return;
        }
        if (playerInteractEvent.getClickedBlock().getType() != Material.BARRIER) {
            return;
        }
        Entity entity = jl.ao(playerInteractEvent.getPlayer());
        if (entity == null) {
            return;
        }
        if (!ProtectionPlugins.canInteract_tradeMachineArmorstand(playerInteractEvent.getPlayer(), entity, playerInteractEvent.isCancelled())) {
            return;
        }
        ItemStack itemStack = entity instanceof ArmorStand ? ((ArmorStand)entity).getHelmet() : (entity instanceof ItemFrame ? ((ItemFrame)entity).getItem() : ((ItemDisplay)entity).getItemStack());
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        qm qm2 = this.zI.a(itemStack);
        if (!qm2.Ge.bm("furniture_trade_machine")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        jy jy2 = (jy)qm2.Ge.bn("furniture_trade_machine");
        if (!s.b((Permissible)playerInteractEvent.getPlayer(), jy2.getPermission(), true)) {
            return;
        }
        this.zJ.put(playerInteractEvent.getPlayer(), jy2);
        jy2.au(playerInteractEvent.getPlayer());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(CustomBlockInteractEvent customBlockInteractEvent) {
        if (customBlockInteractEvent.getPlayer().isSneaking()) {
            return;
        }
        if (this.zI.aE.aJ(customBlockInteractEvent.getPlayer())) {
            return;
        }
        ql ql2 = customBlockInteractEvent.internal;
        jm jm2 = (jm)ql2.Ge.bn("block_trade_machine");
        if (jm2 != null) {
            if (!ProtectionPlugins.canInteract_tradeMachineBlock(customBlockInteractEvent)) {
                return;
            }
            if (!s.b((Permissible)customBlockInteractEvent.getPlayer(), jm2.getPermission(), true)) {
                return;
            }
            this.zJ.put(customBlockInteractEvent.getPlayer(), jm2);
            jm2.au(customBlockInteractEvent.getPlayer());
        }
    }

    @EventHandler
    void a(InventoryCloseEvent inventoryCloseEvent) {
        if (inventoryCloseEvent.getInventory().getType() != InventoryType.MERCHANT) {
            return;
        }
        this.zJ.remove(inventoryCloseEvent.getPlayer());
    }

    @EventHandler
    void a(PlayerQuitEvent playerQuitEvent) {
        this.zJ.remove(playerQuitEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true)
    void c(InventoryClickEvent inventoryClickEvent) {
        ItemStack itemStack;
        if (inventoryClickEvent.getInventory().getType() != InventoryType.MERCHANT) {
            return;
        }
        if (!this.zJ.containsKey((Player)inventoryClickEvent.getWhoClicked())) {
            return;
        }
        if (inventoryClickEvent.getSlot() != 2) {
            return;
        }
        ItemStack itemStack2 = inventoryClickEvent.getInventory().getStorageContents()[2];
        if (itemStack2 == null) {
            return;
        }
        ItemStack itemStack3 = inventoryClickEvent.getInventory().getStorageContents()[0];
        if (this.a(inventoryClickEvent, itemStack3, itemStack = inventoryClickEvent.getInventory().getStorageContents()[1])) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        itemStack2 = this.d(itemStack3, itemStack2);
        itemStack2 = this.d(itemStack, itemStack2);
        inventoryClickEvent.getInventory().setItem(2, itemStack2);
    }

    private boolean a(InventoryClickEvent inventoryClickEvent, ItemStack itemStack, ItemStack itemStack2) {
        MerchantInventory merchantInventory = (MerchantInventory)inventoryClickEvent.getInventory();
        MerchantRecipe merchantRecipe = merchantInventory.getSelectedRecipe();
        qv qv2 = new qv((ItemStack)merchantRecipe.getIngredients().get(0));
        if (merchantRecipe.getIngredients().size() == 1) {
            if (itemStack != null ? !this.a(itemStack, qv2) : itemStack2 != null && !this.a(itemStack2, qv2)) {
                return true;
            }
        } else {
            if (!this.a(itemStack, qv2)) {
                return true;
            }
            qv qv3 = new qv((ItemStack)merchantRecipe.getIngredients().get(1));
            if (!this.a(itemStack2, qv3)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(ItemStack itemStack, qv qv2) {
        if (qv2.ny() && !qv2.K(itemStack)) {
            return false;
        }
        return qv2.ny() || !qm.isCustomItem(itemStack);
    }

    ItemStack d(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return itemStack2;
        }
        qm qm2 = d.g().a(itemStack2);
        if (qm2 != null && qm2.Go) {
            return itemStack2;
        }
        for (Map.Entry entry : itemStack.getEnchantments().entrySet()) {
            if (qm2 != null && qm2.mT() != null && qm2.mT().contains(entry.getKey())) continue;
            itemStack2.addUnsafeEnchantment((Enchantment)entry.getKey(), ((Integer)entry.getValue()).intValue());
        }
        return itemStack2;
    }
}
