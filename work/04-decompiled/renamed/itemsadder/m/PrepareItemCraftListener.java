package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.IntBoolRefData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.NamespacedKeyWrapper;
import itemsadder.m.Opaque139;
import itemsadder.m.Opaque141;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
import itemsadder.m.RecipeBridge;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
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

public class PrepareItemCraftListener
implements PluginContract,
NamespacedKeyWrapper {
    public final List MW = new ArrayList();
    public final Map MX = new HashMap();
    public final Map MY = new HashMap();
    private final ItemStackRegistry MZ;
    private final WeakHashMap Na = new WeakHashMap();

    public PrepareItemCraftListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.MZ = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        PlayerHolder_5.vq().vn();
    }

    @Override
    public String ra() {
        return "Crafting";
    }

    public void a(ItemStackBridge_35 itemStackBridge_35, String string, String string2) {
        try {
            NamespacedKey namespacedKey = new NamespacedKey(string.toLowerCase(), string2.toLowerCase());
            try {
                namespacedKey = this.a(this.MY, itemStackBridge_35, namespacedKey, string, string2);
            }
            catch (Opaque139 opaque139) {
                // empty catch block
            }
            itemStackBridge_35.e(namespacedKey);
            if (!itemStackBridge_35.MS) {
                RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_22;
                ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStackBridge_35.qN());
                shapedRecipe.shape(itemStackBridge_35.rm());
                for (RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_22 : itemStackBridge_35.MK) {
                    shapedRecipe.setIngredient(recipeChoiceItemStackHolder_22.ri().charValue(), recipeChoiceItemStackHolder_22.MG);
                    this.MZ.aW.a(itemStackBridge_35, recipeChoiceItemStackHolder_22);
                }
                shapedRecipe.setCategory(itemStackBridge_35.qU());
                itemStackBridge_35.a(shapedRecipe);
                itemStackBridge_35.a((Recipe)shapedRecipe);
                NamespacedKey namespacedKey2 = new NamespacedKey(PlayerQuitListenerBase.ami + namespacedKey.getNamespace(), namespacedKey.getKey());
                recipeChoiceItemStackHolder_22 = new ShapedRecipe(namespacedKey2, itemStackBridge_35.qN());
                recipeChoiceItemStackHolder_22.shape(itemStackBridge_35.rm());
                for (RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_23 : itemStackBridge_35.MK) {
                    recipeChoiceItemStackHolder_22.setIngredient(recipeChoiceItemStackHolder_23.ri().charValue(), recipeChoiceItemStackHolder_23.MG.getItemStack().getType());
                }
                RecipeBridge.a((Recipe)recipeChoiceItemStackHolder_22);
                this.MW.add(itemStackBridge_35);
            } else {
                ShapelessRecipe shapelessRecipe = new ShapelessRecipe(namespacedKey, itemStackBridge_35.qN());
                for (Object object : itemStackBridge_35.MK) {
                    shapelessRecipe.addIngredient(((RecipeChoiceItemStackHolder_2)object).MG);
                    this.MZ.aW.a(itemStackBridge_35, (RecipeChoiceItemStackHolder_2)object);
                }
                itemStackBridge_35.a(shapelessRecipe);
                itemStackBridge_35.a((Recipe)shapelessRecipe);
                ShapelessRecipe shapelessRecipe2 = new ShapelessRecipe(new NamespacedKey(PlayerQuitListenerBase.ami + namespacedKey.getNamespace(), namespacedKey.getKey()), itemStackBridge_35.qN());
                for (RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 : itemStackBridge_35.MK) {
                    shapelessRecipe2.addIngredient(recipeChoiceItemStackHolder_2.MG.getItemStack().getType());
                }
                RecipeBridge.a((Recipe)shapelessRecipe2);
                this.MW.add(itemStackBridge_35);
            }
            this.MY.put(itemStackBridge_35.qQ().toString(), itemStackBridge_35);
            this.MX.put(string, itemStackBridge_35);
            this.MZ.aW.a((NamespacedKeyItemStackHolder)itemStackBridge_35);
            this.MZ.aW.a(itemStackBridge_35);
            if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                if (itemStackBridge_35.qO() != null) {
                    CommandSenderBridge_5.log("Registered crafting recipe " + String.valueOf(itemStackBridge_35.qQ()) + " for: " + itemStackBridge_35.qO().getNamespacedID());
                } else {
                    CommandSenderBridge_5.log("Registered crafting recipe " + String.valueOf(itemStackBridge_35.qQ()) + " for: " + String.valueOf(itemStackBridge_35.qN().getType()));
                }
            }
        }
        catch (Throwable throwable) {
            if (throwable.getMessage().contains("Symbol does not appear in the shape")) {
                CommandSenderBridge_5.error("Error loading recipe '" + string + ":" + string2 + "'. " + throwable.getMessage());
            }
            CommandSenderBridge_5.error("Error loading recipe '" + string + ":" + string2 + "'. Please check shape characters and materials. You may have missed one or used a wrong character", throwable);
        }
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.MW.clear();
        this.MY.clear();
        this.MX.clear();
    }

    @Override
    public List w(ItemStackBuilder_4 itemStackBuilder_4) {
        return this.MZ.aW.a(ItemStackBridge_35.class, itemStackBuilder_4);
    }

    @Override
    public List x(ItemStackBuilder_4 itemStackBuilder_4) {
        return this.MZ.aW.b(ItemStackBridge_35.class, itemStackBuilder_4);
    }

    public Set y(ItemStackBuilder_4 itemStackBuilder_4) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(itemStackBuilder_4));
        linkedHashSet.addAll(this.x(itemStackBuilder_4));
        return linkedHashSet;
    }

    public static boolean a(ItemStack[] itemStackArray) {
        for (int i = 1; i < itemStackArray.length; ++i) {
            if (!ItemStackBuilder_4.s(itemStackArray[i])) continue;
            return true;
        }
        return false;
    }

    public static boolean a(Recipe recipe, ItemStack itemStack) {
        if (recipe instanceof Keyed && ((Keyed)recipe).getKey().getKey().equals("armor_dye") && ItemStackBuilder_4.s(itemStack)) {
            return itemStack.getType() != Material.LEATHER_HORSE_ARMOR;
        }
        return false;
    }

    public static boolean a(Recipe recipe, @NotNull CraftingInventory craftingInventory) {
        if (recipe instanceof Keyed) {
            ItemStackBuilder_4 itemStackBuilder_4;
            if (craftingInventory.getResult() == null || craftingInventory.getResult().getType() != Material.LEATHER_HORSE_ARMOR) {
                return false;
            }
            if (((Keyed)recipe).getKey().getKey().equals("armor_dye") && (itemStackBuilder_4 = ItemStackRegistry.g().e(ItemStackBuilder_4.t(craftingInventory.getResult()))) != null) {
                return itemStackBuilder_4.Gv;
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
        if (PrepareItemCraftListener.a(recipe, itemStack)) {
            craftingInventory.setResult(ItemStackBridge_2.aAp);
            return;
        }
        if (recipe instanceof Keyed && (keyed = (Keyed)recipe).getKey().getNamespace().equals("minecraft") && keyed.getKey().getKey().equals("repair_item")) {
            ItemMeta itemMeta;
            int n = 0;
            ItemStackBuilder_4 itemStackBuilder_4 = null;
            if (itemStack != null && itemStack.hasItemMeta() && (itemMeta = itemStack.getItemMeta()) instanceof Damageable) {
                ItemStack itemStack2;
                int n2;
                Damageable damageable = (Damageable)itemMeta;
                boolean bl = false;
                @Nullable ItemStack @NotNull [] itemStackArray = inventoryView.getTopInventory().getContents();
                for (n2 = 1; n2 < itemStackArray.length; ++n2) {
                    itemStack2 = itemStackArray[n2];
                    if (!ItemStackRegistry.g().isCustomItem(itemStack2)) continue;
                    bl = true;
                    break;
                }
                if (bl) {
                    ItemStackBuilder_4 itemStackBuilder_42;
                    for (n2 = 1; n2 < itemStackArray.length; ++n2) {
                        itemStack2 = itemStackArray[n2];
                        if (ItemStackBridge_2.at(itemStack2)) continue;
                        itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack2);
                        if (itemStackBuilder_42 == null) {
                            craftingInventory.setResult(ItemStackBridge_2.aAp);
                            return;
                        }
                        if (itemStackBuilder_4 != null && itemStackBuilder_42.Gi != itemStackBuilder_4.Gi) {
                            craftingInventory.setResult(ItemStackBridge_2.aAp);
                            return;
                        }
                        itemStackBuilder_4 = itemStackBuilder_42;
                        if (++n <= 2) continue;
                        craftingInventory.setResult(ItemStackBridge_2.aAp);
                        return;
                    }
                    if (n == 2) {
                        ItemMeta itemMeta2;
                        n2 = damageable.getDamage();
                        itemStack2 = itemStackBuilder_4.mP();
                        if (itemStack2.hasItemMeta() && (itemMeta2 = itemStack2.getItemMeta()) instanceof Damageable) {
                            itemStackBuilder_42 = (Damageable)itemMeta2;
                            itemStackBuilder_42.setDamage(n2);
                            itemStack2.setItemMeta((ItemMeta)itemStackBuilder_42);
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
        if (!keyed.getKey().getNamespace().startsWith(PlayerQuitListenerBase.ami) && !this.d(recipe)) {
            if (!recipe.getResult().equals((Object)craftingInventory.getResult())) {
                return;
            }
            if (PrepareItemCraftListener.a(inventoryView.getTopInventory().getContents())) {
                ItemStackBridge_35 itemStackBridge_35 = this.a(craftingInventory, false, keyed);
                if (itemStackBridge_35 != null) {
                    craftingInventory.setResult(itemStackBridge_35.qN());
                } else {
                    craftingInventory.setResult(ItemStackBridge_2.aAp);
                }
            }
            return;
        }
        ItemStackBridge_35 itemStackBridge_35 = this.a(craftingInventory, keyed);
        if (itemStackBridge_35 != null) {
            craftingInventory.setResult(itemStackBridge_35.qN());
        } else {
            if (keyed.getKey().getNamespace().startsWith(PlayerQuitListenerBase.ami)) {
                craftingInventory.setResult(ItemStackBridge_2.aAp);
                return;
            }
            if (PrepareItemCraftListener.a(inventoryView.getTopInventory().getContents())) {
                if (PrepareItemCraftListener.a(recipe, craftingInventory)) {
                    return;
                }
                if (Main.PF && keyed.getKey().getNamespace().equals("craftenhance")) {
                    return;
                }
                if (Main.PE && CustomCraftingWrapper.inst().isCustomCraftingRecipe(inventoryView)) {
                    return;
                }
                craftingInventory.setResult(ItemStackBridge_2.aAp);
            }
        }
    }

    private boolean d(Recipe recipe) {
        return this.MY.containsKey(((Keyed)recipe).getKey().toString());
    }

    private boolean b(CraftingInventory craftingInventory) {
        for (String string : PlayerHolder_5.vq().h(this.MX.keySet())) {
            ItemStackBridge_35 itemStackBridge_35 = (ItemStackBridge_35)this.MY.get(string);
            if (itemStackBridge_35 == null || !itemStackBridge_35.a(craftingInventory)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    private ItemStackBridge_35 a(CraftingInventory craftingInventory, Keyed keyed) {
        return this.a(craftingInventory, false, keyed);
    }

    @Nullable
    private ItemStackBridge_35 a(CraftingInventory craftingInventory, boolean bl, @Nullable Keyed keyed) {
        Object object;
        Object object2;
        if (bl && (craftingInventory.getResult() == null || craftingInventory.getResult().getType() == Material.AIR)) {
            return null;
        }
        if (keyed != null && this.MY.containsKey(keyed.getKey().toString()) && ((ItemStackBridge_35)(object2 = (ItemStackBridge_35)this.MY.get(keyed.getKey().toString()))).a(craftingInventory)) {
            return object2;
        }
        object2 = PlayerHolder_5.vq().c(craftingInventory);
        if (object2 != null && (object = (ItemStackBridge_35)this.MY.get(object2)) != null && ((ItemStackBridge_35)object).a(craftingInventory)) {
            return object;
        }
        for (String string : PlayerHolder_5.vq().h(this.MX.keySet())) {
            ItemStackBridge_35 itemStackBridge_35 = (ItemStackBridge_35)this.MY.get(string);
            if (itemStackBridge_35 == null || !itemStackBridge_35.a(craftingInventory)) continue;
            return itemStackBridge_35;
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
            if (ItemStackBridge_2.i(inventoryClickEvent)) {
                if (ItemStackBuilder_4.s(inventoryClickEvent.getCursor())) {
                    inventoryClickEvent.setCancelled(true);
                }
            } else if (ItemStackBuilder_4.s(inventoryClickEvent.getCurrentItem())) {
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
        ItemStackBridge_35 itemStackBridge_35 = this.a(craftingInventory, true, null);
        if (itemStackBridge_35 == null) {
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
        if (!s.a(inventoryClickEvent.getView().getPlayer(), itemStackBridge_35)) {
            inventoryClickEvent.setCancelled(true);
            craftingInventory.setResult(ItemStackBridge_2.aAp);
            PlayerQuitListenerBase.a((Player)inventory2, itemStackBridge_35);
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
        if (!itemStackBridge_35.ro().isEmpty()) {
            for (n = 0; n < itemStackArray.length; ++n) {
                if (itemStackArray[n] == null || itemStackArray[n].getType() == Material.AIR) continue;
                boolean bl6 = ItemStackBuilder_4.F(itemStackArray[n]);
                boolean bl7 = ItemStackBuilder_4.H(itemStackArray[n]);
                bl = ItemStackBuilder_4.G(itemStackArray[n]);
                boolean bl8 = ItemStackBridge_2.G(itemStackArray[n]);
                for (Map.Entry entry : itemStackBridge_35.ro().entrySet()) {
                    IntBoolRefData intBoolRefData = (IntBoolRefData)entry.getValue();
                    if (intBoolRefData.MU) {
                        if (!intBoolRefData.MV.e(itemStackArray[n])) continue;
                        if (bl6) {
                            ItemStackBuilder_4 itemStackBuilder_4 = intBoolRefData.MV;
                            if (bl7) {
                                itemStackArray[n] = itemStackBuilder_4.nl() ? ItemStackBridge_2.Dc() : ItemStackBuilder_4.a(itemStackArray[n], intBoolRefData.MT, false);
                            } else if (bl) {
                                craftingInventory.setResult(null);
                                if (itemStackBuilder_4.nl()) {
                                    itemStackArray[n] = ItemStackBridge_2.Dc();
                                }
                                bl3 = true;
                                bl4 = false;
                                bl5 = true;
                            } else {
                                itemStackArray[n] = ItemStackBuilder_4.a(itemStackArray[n], intBoolRefData.MT, true);
                            }
                        } else {
                            if (bl8) {
                                craftingInventory.setResult(null);
                                return;
                            }
                            ItemStackBridge_2.f(itemStackArray[n], intBoolRefData.MT);
                        }
                        arrayList.add(n);
                        continue;
                    }
                    if (((ItemStack)entry.getKey()).getType() != itemStackArray[n].getType()) continue;
                    if (bl8) {
                        craftingInventory.setResult(null);
                        return;
                    }
                    ItemStackBridge_2.f(itemStackArray[n], intBoolRefData.MT);
                    arrayList.add(n);
                }
            }
            bl2 = true;
        }
        if (!itemStackBridge_35.rp().isEmpty()) {
            for (n = 0; n < itemStackArray.length; ++n) {
                if (itemStackArray[n] == null || itemStackArray[n].getType() == Material.AIR) continue;
                for (Map.Entry entry : itemStackBridge_35.rp().entrySet()) {
                    if (((IntBoolRefData)entry.getValue()).MU) {
                        if (!((IntBoolRefData)entry.getValue()).MV.e(itemStackArray[n])) continue;
                        ItemStackBridge_2.e(itemStackArray[n], ((IntBoolRefData)entry.getValue()).MT);
                        arrayList.add(n);
                        continue;
                    }
                    if (((ItemStack)entry.getKey()).getType() != itemStackArray[n].getType()) continue;
                    ItemStackBridge_2.e(itemStackArray[n], ((IntBoolRefData)entry.getValue()).MT);
                    arrayList.add(n);
                }
            }
            bl2 = true;
        }
        if (!bl5 && !itemStackBridge_35.rn().isEmpty()) {
            for (n = 0; n < itemStackArray.length; ++n) {
                if (itemStackArray[n] == null || itemStackArray[n].getType() == Material.AIR) continue;
                for (Map.Entry entry : itemStackBridge_35.rn().entrySet()) {
                    ItemStack itemStack3;
                    bl = false;
                    if (ItemStackBuilder_4.isCustomItem((ItemStack)entry.getKey())) {
                        if (ItemStackBuilder_4.b((ItemStack)entry.getKey(), itemStackArray[n])) {
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
                        ItemStackBridge_2.f((Player)inventory2, itemStack3);
                    }
                    itemStack3 = ((ItemStack)entry.getValue()).clone();
                    itemStack3.setAmount(itemStackArray[n].getAmount());
                    itemStackArray[n] = itemStack3;
                    arrayList.add(n);
                }
            }
            bl2 = true;
        }
        if (bl4 && itemStackBridge_35.rq() != null) {
            itemStackBridge_35.rq().a((Event)inventoryClickEvent, null, null, (Player)inventory2);
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
                this.a((Player)inventory2, itemStackBridge_35.MN, itemStackArray, craftingInventory.getResult());
            }
            if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                if (craftingInventory.getResult() != null) {
                    ItemStack itemStack4 = craftingInventory.getResult().clone();
                    MmoItemsHook.injectMmoItem(itemStack4);
                    craftingInventory.setResult(null);
                    ItemStackBridge_2.f((Player)inventory2, itemStack4);
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
            this.a((Player)inventoryClickEvent.getWhoClicked(), itemStackBridge_35.MN, itemStackArray, craftingInventory.getResult());
        }
        PlayerHolder_5.a((Player)inventory2, itemStackBridge_35, false);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGH)
    private void b(InventoryMoveItemEvent inventoryMoveItemEvent) {
        if (inventoryMoveItemEvent.getDestination().getType() == InventoryType.CRAFTER && ItemStackBuilder_4.s(inventoryMoveItemEvent.getItem())) {
            inventoryMoveItemEvent.setCancelled(true);
            Location location = inventoryMoveItemEvent.getDestination().getLocation();
            if (location != null && location.getBlock().getType() == Material.CRAFTER) {
                location.getBlock().setType(Material.AIR, false);
                LocationBridge_4.b(location, new ItemStack(Material.CRAFTER));
                LocationBridge_2.a(location, 5).forEach(player -> CommandSenderBridge_5.g((CommandSender)player, "warning-crafter-broken-hopper"));
            }
        }
    }

    private void a(Player player, boolean bl, ItemStack[] itemStackArray, ItemStack itemStack) {
        BukkitTaskBridge.j(() -> {
            for (int i = 0; i < (bl ? 4 : itemStackArray.length); ++i) {
                PlayerHolder_4.b(player, itemStackArray[i], i + 1);
            }
            if (itemStack == null) {
                PlayerHolder_4.b(player, ItemStackBridge_2.aAp, 0);
            } else {
                PlayerHolder_4.b(player, itemStack, 0);
            }
        });
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        if ((inventoryCloseEvent.getPlayer().getOpenInventory().getType() == InventoryType.CRAFTING || inventoryCloseEvent.getPlayer().getOpenInventory().getType() == InventoryType.WORKBENCH) && inventoryCloseEvent.getPlayer().getOpenInventory().getTopInventory() instanceof CraftingInventory) {
            CraftingInventory craftingInventory = (CraftingInventory)inventoryCloseEvent.getPlayer().getOpenInventory().getTopInventory();
            if (this.bj((Player)inventoryCloseEvent.getPlayer())) {
                CommandSenderBridge_5.iz(String.valueOf(ChatColor.RED) + "Warning: '" + inventoryCloseEvent.getPlayer().getName() + "' probably tried to trigger a crafting duplication glitch " + String.valueOf(ChatColor.GOLD) + "(cancelled automatically).");
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
            this.Na.put(player, new Opaque141());
        } else {
            this.Na.remove(player);
        }
    }

    private void bi(Player player) {
        this.h(player, true);
    }

    public boolean bj(Player player) {
        Opaque141 opaque141 = (Opaque141)this.Na.get(player);
        return opaque141 != null && opaque141.rs();
    }
}
