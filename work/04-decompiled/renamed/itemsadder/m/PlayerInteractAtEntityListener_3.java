package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_31;
import itemsadder.m.ItemStackBridge_7;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.PluginContract;
import itemsadder.m.StringData_2;
import itemsadder.m.StringData_3;
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

public class PlayerInteractAtEntityListener_3
implements PluginContract {
    private final ItemStackRegistry zI;
    final WeakHashMap zJ = new WeakHashMap();

    public PlayerInteractAtEntityListener_3(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zI = itemStackRegistry;
        ListenerBridge.a(this, plugin);
    }

    public boolean az(Player player) {
        return this.zJ.containsKey(player);
    }

    public void a(Player player, ItemStackBridge_7 itemStackBridge_7) {
        this.zJ.put(player, itemStackBridge_7);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void d(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (ItemStackBridge_2.d((PlayerInteractEntityEvent)playerInteractAtEntityEvent)) {
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
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("furniture_trade_machine")) {
            return;
        }
        playerInteractAtEntityEvent.setCancelled(true);
        StringData_3 stringData_3 = (StringData_3)itemStackBuilder_4.Ge.bn("furniture_trade_machine");
        if (!s.b((Permissible)playerInteractAtEntityEvent.getPlayer(), stringData_3.getPermission(), true)) {
            return;
        }
        this.zJ.put(playerInteractAtEntityEvent.getPlayer(), stringData_3);
        stringData_3.au(playerInteractAtEntityEvent.getPlayer());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void e(PlayerInteractEvent playerInteractEvent) {
        if (ItemStackBridge_2.q(playerInteractEvent)) {
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
        Entity entity = NamespacedKeyEntityTypeHolder.ao(playerInteractEvent.getPlayer());
        if (entity == null) {
            return;
        }
        if (!ProtectionPlugins.canInteract_tradeMachineArmorstand(playerInteractEvent.getPlayer(), entity, playerInteractEvent.isCancelled())) {
            return;
        }
        ItemStack itemStack = entity instanceof ArmorStand ? ((ArmorStand)entity).getHelmet() : (entity instanceof ItemFrame ? ((ItemFrame)entity).getItem() : ((ItemDisplay)entity).getItemStack());
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.zI.a(itemStack);
        if (!itemStackBuilder_4.Ge.bm("furniture_trade_machine")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        StringData_3 stringData_3 = (StringData_3)itemStackBuilder_4.Ge.bn("furniture_trade_machine");
        if (!s.b((Permissible)playerInteractEvent.getPlayer(), stringData_3.getPermission(), true)) {
            return;
        }
        this.zJ.put(playerInteractEvent.getPlayer(), stringData_3);
        stringData_3.au(playerInteractEvent.getPlayer());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(CustomBlockInteractEvent customBlockInteractEvent) {
        if (customBlockInteractEvent.getPlayer().isSneaking()) {
            return;
        }
        if (this.zI.aE.aJ(customBlockInteractEvent.getPlayer())) {
            return;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = customBlockInteractEvent.internal;
        StringData_2 stringData_2 = (StringData_2)locationBridgeBuilder_2.Ge.bn("block_trade_machine");
        if (stringData_2 != null) {
            if (!ProtectionPlugins.canInteract_tradeMachineBlock(customBlockInteractEvent)) {
                return;
            }
            if (!s.b((Permissible)customBlockInteractEvent.getPlayer(), stringData_2.getPermission(), true)) {
                return;
            }
            this.zJ.put(customBlockInteractEvent.getPlayer(), stringData_2);
            stringData_2.au(customBlockInteractEvent.getPlayer());
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
        ItemStackBridge_31 itemStackBridge_31 = new ItemStackBridge_31((ItemStack)merchantRecipe.getIngredients().get(0));
        if (merchantRecipe.getIngredients().size() == 1) {
            if (itemStack != null ? !this.a(itemStack, itemStackBridge_31) : itemStack2 != null && !this.a(itemStack2, itemStackBridge_31)) {
                return true;
            }
        } else {
            if (!this.a(itemStack, itemStackBridge_31)) {
                return true;
            }
            ItemStackBridge_31 itemStackBridge_312 = new ItemStackBridge_31((ItemStack)merchantRecipe.getIngredients().get(1));
            if (!this.a(itemStack2, itemStackBridge_312)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(ItemStack itemStack, ItemStackBridge_31 itemStackBridge_31) {
        if (itemStackBridge_31.ny() && !itemStackBridge_31.K(itemStack)) {
            return false;
        }
        return itemStackBridge_31.ny() || !ItemStackBuilder_4.isCustomItem(itemStack);
    }

    ItemStack d(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return itemStack2;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack2);
        if (itemStackBuilder_4 != null && itemStackBuilder_4.Go) {
            return itemStack2;
        }
        for (Map.Entry entry : itemStack.getEnchantments().entrySet()) {
            if (itemStackBuilder_4 != null && itemStackBuilder_4.mT() != null && itemStackBuilder_4.mT().contains(entry.getKey())) continue;
            itemStack2.addUnsafeEnchantment((Enchantment)entry.getKey(), ((Integer)entry.getValue()).intValue());
        }
        return itemStack2;
    }
}
