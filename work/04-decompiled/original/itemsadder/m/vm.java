package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ai;
import itemsadder.m.aqp;
import itemsadder.m.asf;
import itemsadder.m.asg;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.ux;
import itemsadder.m.uy;
import itemsadder.m.uz;
import itemsadder.m.vj;
import itemsadder.m.vk;
import itemsadder.m.vl;
import itemsadder.m.vn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.bukkit.ChatColor;
import org.bukkit.Keyed;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class vm
implements ai,
uy {
    public final List MW = new ArrayList();
    public final Map MX = new HashMap();
    public final Map MY = new HashMap();
    private final d MZ;
    private final WeakHashMap Na = new WeakHashMap();

    public vm(Plugin plugin, d d2) {
        this.MZ = d2;
        bev.a(this, plugin);
        asg.vq().vn();
    }

    @Override
    public String ra() {
        return "Crafting";
    }

    public void a(vk vk2, String string, String string2) {
        try {
            NamespacedKey namespacedKey = new NamespacedKey(string.toLowerCase(), string2.toLowerCase());
            try {
                namespacedKey = this.a(this.MY, vk2, namespacedKey, string, string2);
            }
            catch (uz uz2) {
                // empty catch block
            }
            vk2.e(namespacedKey);
            if (!vk2.MS) {
                vj vj22;
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, vk2.qN());
                shapedRecipe.shape(vk2.rm());
                for (vj vj22 : vk2.MK) {
                    shapedRecipe.setIngredient(vj22.ri().charValue(), vj22.MG);
                    this.MZ.aW.a(vk2, vj22);
                }
                shapedRecipe.setCategory(vk2.qU());
                vk2.a(shapedRecipe);
                vk2.a((Recipe)shapedRecipe);
                NamespacedKey namespacedKey2 = new NamespacedKey(asf.ami + namespacedKey.getNamespace(), namespacedKey.getKey());
                vj22 = new ShapedRecipe(namespacedKey2, vk2.qN());
                vj22.shape(vk2.rm());
                for (vj vj3 : vk2.MK) {
                    vj22.setIngredient(vj3.ri().charValue(), vj3.MG.getItemStack().getType());
                }
                ux.a((Recipe)vj22);
                this.MW.add(vk2);
            } else {
                ShapelessRecipe shapelessRecipe = new ShapelessRecipe(namespacedKey, vk2.qN());
                for (Object object : vk2.MK) {
                    shapelessRecipe.addIngredient(((vj)object).MG);
                    this.MZ.aW.a(vk2, (vj)object);
                }
                vk2.a(shapelessRecipe);
                vk2.a((Recipe)shapelessRecipe);
                ShapelessRecipe shapelessRecipe2 = new ShapelessRecipe(new NamespacedKey(asf.ami + namespacedKey.getNamespace(), namespacedKey.getKey()), vk2.qN());
                for (vj vj4 : vk2.MK) {
                    shapelessRecipe2.addIngredient(vj4.MG.getItemStack().getType());
                }
                ux.a((Recipe)shapelessRecipe2);
                this.MW.add(vk2);
            }
            this.MY.put(vk2.qQ().toString(), vk2);
            this.MX.put(string, vk2);
            this.MZ.aW.a((uw)vk2);
            this.MZ.aW.a(vk2);
            if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                if (vk2.qO() != null) {
                    bce.log("Registered crafting recipe " + String.valueOf(vk2.qQ()) + " for: " + vk2.qO().getNamespacedID());
                } else {
                    bce.log("Registered crafting recipe " + String.valueOf(vk2.qQ()) + " for: " + String.valueOf(vk2.qN().getType()));
                }
            }
        }
        catch (Throwable throwable) {
            if (throwable.getMessage().contains("Symbol does not appear in the shape")) {
                bce.error("Error loading recipe '" + string + ":" + string2 + "'. " + throwable.getMessage());
            }
            bce.error("Error loading recipe '" + string + ":" + string2 + "'. Please check shape characters and materials. You may have missed one or used a wrong character", throwable);
        }
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.MW.clear();
        this.MY.clear();
        this.MX.clear();
    }

    @Override
    public List w(qm qm2) {
        return this.MZ.aW.a(vk.class, qm2);
    }

    @Override
    public List x(qm qm2) {
        return this.MZ.aW.b(vk.class, qm2);
    }

    public Set y(qm qm2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(qm2));
        linkedHashSet.addAll(this.x(qm2));
        return linkedHashSet;
    }

    public static boolean a(ItemStack[] itemStackArray) {
        for (int i = 1; i < itemStackArray.length; ++i) {
            if (!qm.s(itemStackArray[i])) continue;
            return true;
        }
        return false;
    }

    public static boolean a(Recipe recipe, ItemStack itemStack) {
        if (recipe instanceof Keyed && ((Keyed)recipe).getKey().getKey().equals("armor_dye") && qm.s(itemStack)) {
            return itemStack.getType() != Material.LEATHER_HORSE_ARMOR;
        }
        return false;
    }

    public static boolean a(Recipe recipe, @NotNull CraftingInventory craftingInventory) {
        if (recipe instanceof Keyed) {
            qm qm2;
            if (craftingInventory.getResult() == null || craftingInventory.getResult().getType() != Material.LEATHER_HORSE_ARMOR) {
                return false;
            }
            if (((Keyed)recipe).getKey().getKey().equals("armor_dye") && (qm2 = d.g().e(qm.t(craftingInventory.getResult()))) != null) {
                return qm2.Gv;
            }
        }
        return false;
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void a(PrepareItemCraftEvent prepareItemCraftEvent) {
        Keyed keyed;
        Recipe recipe = prepareItemCraftEvent.getRecipe();
        CraftingInventory craftingInventory = prepareItemCraftEvent.getInventory();
        InventoryView inventoryView = prepareItemCraftEvent.getView();
        ItemStack itemStack = craftingInventory.getResult();
        if (vm.a(recipe, itemStack)) {
            craftingInventory.setResult(bbs.aAp);
            return;
        }
        if (recipe instanceof Keyed && (keyed = (Keyed)recipe).getKey().getNamespace().equals("minecraft") && keyed.getKey().getKey().equals("repair_item")) {
            ItemMeta itemMeta;
            int n = 0;
            qm qm2 = null;
            if (itemStack != null && itemStack.hasItemMeta() && (itemMeta = itemStack.getItemMeta()) instanceof Damageable) {
                ItemStack itemStack2;
                int n2;
                Damageable damageable = (Damageable)itemMeta;
                boolean bl = false;
                @Nullable ItemStack @NotNull [] itemStackArray = inventoryView.getTopInventory().getContents();
                for (n2 = 1; n2 < itemStackArray.length; ++n2) {
                    itemStack2 = itemStackArray[n2];
                    if (!d.g().isCustomItem(itemStack2)) continue;
                    bl = true;
                    break;
                }
                if (bl) {
                    qm qm3;
                    for (n2 = 1; n2 < itemStackArray.length; ++n2) {
                        itemStack2 = itemStackArray[n2];
                        if (bbs.at(itemStack2)) continue;
                        qm3 = d.g().a(itemStack2);
                        if (qm3 == null) {
                            craftingInventory.setResult(bbs.aAp);
                            return;
                        }
                        if (qm2 != null && qm3.Gi != qm2.Gi) {
                            craftingInventory.setResult(bbs.aAp);
                            return;
                        }
                        qm2 = qm3;
                        if (++n <= 2) continue;
                        craftingInventory.setResult(bbs.aAp);
                        return;
                    }
                    if (n == 2) {
                        ItemMeta itemMeta2;
                        n2 = damageable.getDamage();
                        itemStack2 = qm2.mP();
                        if (itemStack2.hasItemMeta() && (itemMeta2 = itemStack2.getItemMeta()) instanceof Damageable) {
                            qm3 = (Damageable)itemMeta2;
                            qm3.setDamage(n2);
                            itemStack2.setItemMeta((ItemMeta)qm3);
                            craftingInventory.setResult(itemStack2);
                        }
                    }
                }
            }
        }
        if (!(recipe instanceof Keyed)) {
            return;
        }
        keyed = (Keyed)recipe;
        if (!keyed.getKey().getNamespace().startsWith(asf.ami) && !this.d(recipe)) {
            if (!recipe.getResult().equals((Object)craftingInventory.getResult())) {
                return;
            }
            if (vm.a(inventoryView.getTopInventory().getContents())) {
                vk vk2 = this.a(craftingInventory, false, keyed);
                if (vk2 != null) {
                    craftingInventory.setResult(vk2.qN());
                } else {
                    craftingInventory.setResult(bbs.aAp);
                }
            }
            return;
        }
        vk vk3 = this.a(craftingInventory, keyed);
        if (vk3 != null) {
            craftingInventory.setResult(vk3.qN());
        } else {
            if (keyed.getKey().getNamespace().startsWith(asf.ami)) {
                craftingInventory.setResult(bbs.aAp);
                return;
            }
            if (vm.a(inventoryView.getTopInventory().getContents())) {
                if (vm.a(recipe, craftingInventory)) {
                    return;
                }
                if (Main.PF && keyed.getKey().getNamespace().equals("craftenhance")) {
                    return;
                }
                if (Main.PE && CustomCraftingWrapper.inst().isCustomCraftingRecipe(inventoryView)) {
                    return;
                }
                craftingInventory.setResult(bbs.aAp);
            }
        }
    }

    private boolean d(Recipe recipe) {
        return this.MY.containsKey(((Keyed)recipe).getKey().toString());
    }

    private boolean b(CraftingInventory craftingInventory) {
        for (String string : asg.vq().h(this.MX.keySet())) {
            vk vk2 = (vk)this.MY.get(string);
            if (vk2 == null || !vk2.a(craftingInventory)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    private vk a(CraftingInventory craftingInventory, Keyed keyed) {
        return this.a(craftingInventory, false, keyed);
    }

    @Nullable
    private vk a(CraftingInventory craftingInventory, boolean bl, @Nullable Keyed keyed) {
        Object object;
        Object object2;
        if (bl && (craftingInventory.getResult() == null || craftingInventory.getResult().getType() == Material.AIR)) {
            return null;
        }
        if (keyed != null && this.MY.containsKey(keyed.getKey().toString()) && ((vk)(object2 = (vk)this.MY.get(keyed.getKey().toString()))).a(craftingInventory)) {
            return object2;
        }
        object2 = asg.vq().c(craftingInventory);
        if (object2 != null && (object = (vk)this.MY.get(object2)) != null && ((vk)object).a(craftingInventory)) {
            return object;
        }
        for (String string : asg.vq().h(this.MX.keySet())) {
            vk vk2 = (vk)this.MY.get(string);
            if (vk2 == null || !vk2.a(craftingInventory)) continue;
            return vk2;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(InventoryClickEvent inventoryClickEvent) {
        boolean bl;
        int n;
        ItemStack itemStack;
        Inventory inventory = inventoryClickEvent.getView().getTopInventory();
        if (inventory.getType() == InventoryType.CRAFTER) {
            if (bbs.i(inventoryClickEvent)) {
                if (qm.s(inventoryClickEvent.getCursor())) {
                    inventoryClickEvent.setCancelled(true);
                }
            } else if (qm.s(inventoryClickEvent.getCurrentItem())) {
                inventoryClickEvent.setCancelled(true);
            }
        }
        if (inventoryClickEvent.getInventory().getType() != InventoryType.WORKBENCH && inventoryClickEvent.getInventory().getType() != InventoryType.CRAFTING) {
            return;
        }
        Inventory inventory2 = inventoryClickEvent.getInventory();
        if (!(inventory2 instanceof CraftingInventory)) {
            return;
        }
        CraftingInventory craftingInventory = (CraftingInventory)inventory2;
        inventory2 = (Player)inventoryClickEvent.getWhoClicked();
        if (inventoryClickEvent.getSlotType() != InventoryType.SlotType.RESULT) return;
        vk vk2 = this.a(craftingInventory, true, null);
        if (vk2 == null) {
            return;
        }
        this.bi((Player)inventory2);
        ItemStack itemStack2 = inventory2.getItemOnCursor();
        if (craftingInventory.getResult() != null && itemStack2.getType() != Material.AIR && itemStack2.getAmount() + craftingInventory.getResult().getAmount() > craftingInventory.getResult().getType().getMaxStackSize() && inventoryClickEvent.getClick() != ClickType.SHIFT_LEFT && inventoryClickEvent.getClick() != ClickType.SHIFT_RIGHT) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.NUMBER_KEY && (itemStack = inventory2.getInventory().getItem(inventoryClickEvent.getHotbarButton())) != null && itemStack.getType() != Material.AIR) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (!s.a(inventoryClickEvent.getView().getPlayer(), vk2)) {
            inventoryClickEvent.setCancelled(true);
            craftingInventory.setResult(bbs.aAp);
            asf.a((Player)inventory2, vk2);
            return;
        }
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = true;
        boolean bl5 = false;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ItemStack[] itemStackArray = new ItemStack[craftingInventory.getMatrix().length];
        for (n = 0; n < craftingInventory.getMatrix().length; ++n) {
            if (craftingInventory.getMatrix()[n] == null) continue;
            itemStackArray[n] = craftingInventory.getMatrix()[n];
        }
        if (!vk2.ro().isEmpty()) {
            for (n = 0; n < itemStackArray.length; ++n) {
                if (itemStackArray[n] == null || itemStackArray[n].getType() == Material.AIR) continue;
                boolean bl6 = qm.F(itemStackArray[n]);
                boolean bl7 = qm.H(itemStackArray[n]);
                bl = qm.G(itemStackArray[n]);
                boolean bl8 = bbs.G(itemStackArray[n]);
                for (Map.Entry entry : vk2.ro().entrySet()) {
                    vl vl2 = (vl)entry.getValue();
                    if (vl2.MU) {
                        if (!vl2.MV.e(itemStackArray[n])) continue;
                        if (bl6) {
                            qm qm2 = vl2.MV;
                            if (bl7) {
                                itemStackArray[n] = qm2.nl() ? bbs.Dc() : qm.a(itemStackArray[n], vl2.MT, false);
                            } else if (bl) {
                                craftingInventory.setResult(null);
                                if (qm2.nl()) {
                                    itemStackArray[n] = bbs.Dc();
                                }
                                bl3 = true;
                                bl4 = false;
                                bl5 = true;
                            } else {
                                itemStackArray[n] = qm.a(itemStackArray[n], vl2.MT, true);
                            }
                        } else {
                            if (bl8) {
                                craftingInventory.setResult(null);
                                return;
                            }
                            bbs.f(itemStackArray[n], vl2.MT);
                        }
                        arrayList.add(n);
                        continue;
                    }
                    if (((ItemStack)entry.getKey()).getType() != itemStackArray[n].getType()) continue;
                    if (bl8) {
                        craftingInventory.setResult(null);
                        return;
                    }
                    bbs.f(itemStackArray[n], vl2.MT);
                    arrayList.add(n);
                }
            }
            bl2 = true;
        }
        if (!vk2.rp().isEmpty()) {
            for (n = 0; n < itemStackArray.length; ++n) {
                if (itemStackArray[n] == null || itemStackArray[n].getType() == Material.AIR) continue;
                for (Map.Entry entry : vk2.rp().entrySet()) {
                    if (((vl)entry.getValue()).MU) {
                        if (!((vl)entry.getValue()).MV.e(itemStackArray[n])) continue;
                        bbs.e(itemStackArray[n], ((vl)entry.getValue()).MT);
                        arrayList.add(n);
                        continue;
                    }
                    if (((ItemStack)entry.getKey()).getType() != itemStackArray[n].getType()) continue;
                    bbs.e(itemStackArray[n], ((vl)entry.getValue()).MT);
                    arrayList.add(n);
                }
            }
            bl2 = true;
        }
        if (!bl5 && !vk2.rn().isEmpty()) {
            for (n = 0; n < itemStackArray.length; ++n) {
                if (itemStackArray[n] == null || itemStackArray[n].getType() == Material.AIR) continue;
                for (Map.Entry entry : vk2.rn().entrySet()) {
                    ItemStack itemStack3;
                    bl = false;
                    if (qm.isCustomItem((ItemStack)entry.getKey())) {
                        if (qm.b((ItemStack)entry.getKey(), itemStackArray[n])) {
                            bl = true;
                        }
                    } else if (((ItemStack)entry.getKey()).getType() == itemStackArray[n].getType()) {
                        bl = true;
                    }
                    if (!bl) continue;
                    if (itemStackArray[n].getAmount() > 1) {
                        itemStack3 = itemStackArray[n].clone();
                        itemStackArray[n].setAmount(1);
                        itemStack3.setAmount(itemStack3.getAmount() - 1);
                        bbs.f((Player)inventory2, itemStack3);
                    }
                    itemStack3 = ((ItemStack)entry.getValue()).clone();
                    itemStack3.setAmount(itemStackArray[n].getAmount());
                    itemStackArray[n] = itemStack3;
                    arrayList.add(n);
                }
            }
            bl2 = true;
        }
        if (bl4 && vk2.rq() != null) {
            vk2.rq().a((Event)inventoryClickEvent, null, null, (Player)inventory2);
        }
        if (bl2) {
            inventoryClickEvent.setCancelled(true);
            if (!bl3) {
                for (n = 0; n < itemStackArray.length; ++n) {
                    if (itemStackArray[n] == null || arrayList.contains(n)) continue;
                    itemStackArray[n].setAmount(itemStackArray[n].getAmount() - 1);
                }
            }
            if (bl5) {
                craftingInventory.setResult(null);
                this.a((Player)inventory2, vk2.MN, itemStackArray, craftingInventory.getResult());
            }
            if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                if (craftingInventory.getResult() != null) {
                    ItemStack itemStack4 = craftingInventory.getResult().clone();
                    MmoItemsHook.injectMmoItem(itemStack4);
                    craftingInventory.setResult(null);
                    bbs.f((Player)inventory2, itemStack4);
                }
            } else if (craftingInventory.getResult() != null) {
                if (itemStack2.getType() != Material.AIR) {
                    if (!itemStack2.isSimilar(craftingInventory.getResult())) return;
                    MmoItemsHook.injectMmoItem(itemStack2);
                    itemStack2.setAmount(itemStack2.getAmount() + craftingInventory.getResult().getAmount());
                    inventory2.setItemOnCursor(itemStack2);
                } else {
                    ItemStack itemStack5 = craftingInventory.getResult().clone();
                    MmoItemsHook.injectMmoItem(itemStack5);
                    craftingInventory.setResult(null);
                    inventory2.setItemOnCursor(itemStack5);
                }
            }
            craftingInventory.setMatrix(itemStackArray);
            this.a((Player)inventoryClickEvent.getWhoClicked(), vk2.MN, itemStackArray, craftingInventory.getResult());
        }
        asg.a((Player)inventory2, vk2, false);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGH)
    private void b(InventoryMoveItemEvent inventoryMoveItemEvent) {
        if (inventoryMoveItemEvent.getDestination().getType() == InventoryType.CRAFTER && qm.s(inventoryMoveItemEvent.getItem())) {
            inventoryMoveItemEvent.setCancelled(true);
            Location location = inventoryMoveItemEvent.getDestination().getLocation();
            if (location != null && location.getBlock().getType() == Material.CRAFTER) {
                location.getBlock().setType(Material.AIR, false);
                bdf.b(location, new ItemStack(Material.CRAFTER));
                bcc.a(location, 5).forEach(player -> bce.g((CommandSender)player, "warning-crafter-broken-hopper"));
            }
        }
    }

    private void a(Player player, boolean bl, ItemStack[] itemStackArray, ItemStack itemStack) {
        bcp.j(() -> {
            for (int i = 0; i < (bl ? 4 : itemStackArray.length); ++i) {
                aqp.b(player, itemStackArray[i], i + 1);
            }
            if (itemStack == null) {
                aqp.b(player, bbs.aAp, 0);
            } else {
                aqp.b(player, itemStack, 0);
            }
        });
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        if ((inventoryCloseEvent.getPlayer().getOpenInventory().getType() == InventoryType.CRAFTING || inventoryCloseEvent.getPlayer().getOpenInventory().getType() == InventoryType.WORKBENCH) && inventoryCloseEvent.getPlayer().getOpenInventory().getTopInventory() instanceof CraftingInventory) {
            CraftingInventory craftingInventory = (CraftingInventory)inventoryCloseEvent.getPlayer().getOpenInventory().getTopInventory();
            if (this.bj((Player)inventoryCloseEvent.getPlayer())) {
                bce.iz(String.valueOf(ChatColor.RED) + "Warning: '" + inventoryCloseEvent.getPlayer().getName() + "' probably tried to trigger a crafting duplication glitch " + String.valueOf(ChatColor.GOLD) + "(cancelled automatically).");
                craftingInventory.setContents(new ItemStack[craftingInventory.getContents().length]);
                this.h((Player)inventoryCloseEvent.getPlayer(), false);
            }
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.h(playerQuitEvent.getPlayer(), false);
    }

    private void h(Player player, boolean bl) {
        if (bl) {
            this.Na.put(player, new vn());
        } else {
            this.Na.remove(player);
        }
    }

    private void bi(Player player) {
        this.h(player, true);
    }

    public boolean bj(Player player) {
        vn vn2 = (vn)this.Na.get(player);
        return vn2 != null && vn2.rs();
    }
}
