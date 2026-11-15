package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBridge_18;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.NamespacedKeyWrapper;
import itemsadder.m.Opaque139;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
import itemsadder.m.RecipeBridge;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.plugin.Plugin;

public class FurnaceStartSmeltListener
implements PluginContract,
NamespacedKeyWrapper {
    public final List MB = new ArrayList();
    public final Map MC = new HashMap();
    private final ItemStackRegistry MD;

    public FurnaceStartSmeltListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.MD = itemStackRegistry;
        ListenerBridge.a(this, plugin);
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.MB.clear();
        this.MC.clear();
    }

    @Override
    public String ra() {
        return "Cooking";
    }

    public void a(MaterialBridge_18 materialBridge_18, String string, String string2) {
        MaterialBridge_18 materialBridge_1822;
        for (MaterialBridge_18 materialBridge_1822 : this.MB) {
            if (materialBridge_1822.Mz != materialBridge_18.Mz || !materialBridge_1822.Q(materialBridge_18.Mw.Mv)) continue;
            CommandSenderBridge_5.error("Cooking recipe '" + String.valueOf(materialBridge_18.qQ()) + "' not registered. A recipe '" + String.valueOf(materialBridge_1822.qQ()) + "' already exists with the same ingredient. Ingredients must be unique. File: " + materialBridge_1822.nh());
            return;
        }
        NamespacedKey namespacedKey = new NamespacedKey(string, materialBridge_18.rh().toString().toLowerCase() + "_" + string2.toLowerCase());
        try {
            namespacedKey = this.a(this.MC, materialBridge_18, namespacedKey, string, string2);
        }
        catch (Opaque139 opaque139) {
            // empty catch block
        }
        materialBridge_18.e(namespacedKey);
        switch (materialBridge_18.rh()) {
            case FURNACE: {
                Object object = new FurnaceRecipe(namespacedKey, materialBridge_18.qN(), materialBridge_18.re().rd(), materialBridge_18.rf(), materialBridge_18.rg());
                break;
            }
            case BLAST_FURNACE: {
                Object object = new BlastingRecipe(namespacedKey, materialBridge_18.qN(), materialBridge_18.re().rd(), materialBridge_18.rf(), materialBridge_18.rg());
                break;
            }
            case SMOKER: {
                Object object = new SmokingRecipe(namespacedKey, materialBridge_18.qN(), materialBridge_18.re().rd(), materialBridge_18.rf(), materialBridge_18.rg());
                break;
            }
            default: {
                Object object = materialBridge_1822 = null;
            }
        }
        if (materialBridge_1822 != null) {
            ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(materialBridge_18.re().Mv);
            if (itemStackBuilder_4 != null) {
                FurnaceRecipe furnaceRecipe;
                NamespacedKey namespacedKey2 = new NamespacedKey(PlayerQuitListenerBase.ami + namespacedKey.getNamespace(), namespacedKey.getKey());
                ItemStack itemStack = new ItemStack(Material.STICK);
                RecipeChoice.MaterialChoice materialChoice = new RecipeChoice.MaterialChoice(itemStackBuilder_4.getType());
                switch (materialBridge_18.rh()) {
                    case FURNACE: {
                        FurnaceRecipe furnaceRecipe2 = new FurnaceRecipe(namespacedKey2, itemStack, (RecipeChoice)materialChoice, materialBridge_18.rf(), materialBridge_18.rg());
                        break;
                    }
                    case BLAST_FURNACE: {
                        FurnaceRecipe furnaceRecipe2 = new BlastingRecipe(namespacedKey2, itemStack, (RecipeChoice)materialChoice, materialBridge_18.rf(), materialBridge_18.rg());
                        break;
                    }
                    case SMOKER: {
                        FurnaceRecipe furnaceRecipe2 = new SmokingRecipe(namespacedKey2, itemStack, (RecipeChoice)materialChoice, materialBridge_18.rf(), materialBridge_18.rg());
                        break;
                    }
                    default: {
                        FurnaceRecipe furnaceRecipe2 = furnaceRecipe = null;
                    }
                }
                if (furnaceRecipe != null) {
                    furnaceRecipe.setCookingTime(600);
                    furnaceRecipe.setExperience(0.0f);
                    RecipeBridge.a((Recipe)furnaceRecipe);
                } else {
                    CommandSenderBridge_5.error("Failed to register fake recipe '" + String.valueOf(namespacedKey2) + "' for custom cooking. Invalid furance type '" + String.valueOf(materialBridge_18.rh()) + "'. This is a bug.");
                }
            }
            materialBridge_18.a((CookingRecipe)materialBridge_1822);
            materialBridge_18.a((Recipe)materialBridge_1822);
            this.MB.add(materialBridge_18);
            this.MC.put(materialBridge_18.qQ().toString(), materialBridge_18);
            this.MD.aW.a((NamespacedKeyItemStackHolder)materialBridge_18);
            this.MD.aW.a(materialBridge_18);
        }
        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
            if (materialBridge_18.qO() != null) {
                CommandSenderBridge_5.log("Registered cooking recipe " + String.valueOf(materialBridge_18.qQ()) + " for: " + materialBridge_18.qO().getNamespacedID());
            } else {
                CommandSenderBridge_5.log("Registered cooking recipe " + String.valueOf(materialBridge_18.qQ()) + " for: " + String.valueOf(materialBridge_18.qN().getType()));
            }
        }
    }

    @Override
    public List w(ItemStackBuilder_4 itemStackBuilder_4) {
        return this.MD.aW.a(MaterialBridge_18.class, itemStackBuilder_4);
    }

    @Override
    public List x(ItemStackBuilder_4 itemStackBuilder_4) {
        return this.MD.aW.b(MaterialBridge_18.class, itemStackBuilder_4);
    }

    public Set y(ItemStackBuilder_4 itemStackBuilder_4) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(itemStackBuilder_4));
        linkedHashSet.addAll(this.x(itemStackBuilder_4));
        return linkedHashSet;
    }

    public MaterialBridge_18 R(ItemStack itemStack) {
        Object object;
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 != null && (object = ItemStackRegistry.g().aW.v(itemStackBuilder_4)) != null) {
            Object object2 = ((AbstractSequentialList)object).iterator();
            while (object2.hasNext()) {
                MaterialBridge_18 materialBridge_18;
                NamespacedKeyItemStackHolder namespacedKeyItemStackHolder = (NamespacedKeyItemStackHolder)object2.next();
                if (!(namespacedKeyItemStackHolder instanceof MaterialBridge_18) || !(materialBridge_18 = (MaterialBridge_18)namespacedKeyItemStackHolder).Q(itemStack)) continue;
                return materialBridge_18;
            }
        }
        for (Object object2 : this.MB) {
            if (!((MaterialBridge_18)object2).Q(itemStack)) continue;
            return object2;
        }
        return null;
    }

    public boolean b(Recipe recipe) {
        if (recipe instanceof Keyed) {
            Keyed keyed = (Keyed)recipe;
            return keyed.getKey().getNamespace().startsWith(PlayerQuitListenerBase.ami) || keyed.getKey().getNamespace().equals("minecraft");
        }
        return false;
    }

    public boolean c(Recipe recipe) {
        if (recipe instanceof Keyed) {
            Keyed keyed = (Keyed)recipe;
            return keyed.getKey().getNamespace().startsWith(PlayerQuitListenerBase.ami);
        }
        return false;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(FurnaceStartSmeltEvent furnaceStartSmeltEvent) {
        CookingRecipe cookingRecipe = furnaceStartSmeltEvent.getRecipe();
        ItemStack itemStack = furnaceStartSmeltEvent.getSource();
        BlockState blockState = furnaceStartSmeltEvent.getBlock().getState();
        if (!(blockState instanceof Furnace)) {
            return;
        }
        Furnace furnace = (Furnace)blockState;
        boolean bl = ItemStackBuilder_4.isCustomItem(itemStack);
        if (this.c((Recipe)cookingRecipe) && !bl) {
            return;
        }
        MaterialBridge_18 materialBridge_18 = null;
        if (this.b((Recipe)cookingRecipe)) {
            if (bl) {
                materialBridge_18 = this.R(itemStack);
            }
        } else {
            materialBridge_18 = (MaterialBridge_18)this.MD.aW.cx(cookingRecipe.getKey().toString());
        }
        if (materialBridge_18 != null && materialBridge_18.aE(furnaceStartSmeltEvent.getBlock())) {
            furnaceStartSmeltEvent.setTotalCookTime(materialBridge_18.My);
            PlayerHolder_5.vq().a(furnace, materialBridge_18.qQ());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(FurnaceSmeltEvent furnaceSmeltEvent) {
        if (Main.PE && CustomCraftingWrapper.inst().isCustomCraftingRecipe(furnaceSmeltEvent)) {
            return;
        }
        NamespacedKey namespacedKey = PlayerHolder_5.vq().a((Furnace)furnaceSmeltEvent.getBlock().getState());
        if (namespacedKey == null) {
            return;
        }
        if (namespacedKey.getNamespace().startsWith(PlayerQuitListenerBase.ami)) {
            if (!ItemStackBuilder_4.isCustomItem(furnaceSmeltEvent.getSource())) {
                furnaceSmeltEvent.setResult(ItemStackBridge_2.j(furnaceSmeltEvent.getSource(), 1));
                return;
            }
            MaterialBridge_18 materialBridge_18 = this.R(furnaceSmeltEvent.getSource());
            if (materialBridge_18 == null || !materialBridge_18.aE(furnaceSmeltEvent.getBlock())) {
                furnaceSmeltEvent.setResult(ItemStackBridge_2.j(furnaceSmeltEvent.getSource(), 1));
                return;
            }
            if (materialBridge_18.Q(furnaceSmeltEvent.getSource())) {
                furnaceSmeltEvent.setResult(materialBridge_18.qN());
                BukkitTaskBridge.c(() -> {
                    Object object;
                    Furnace furnace;
                    BlockState blockState = furnaceSmeltEvent.getBlock().getState();
                    if (blockState instanceof Furnace && !ItemStackBridge_2.at((ItemStack)(blockState = (furnace = (Furnace)blockState).getInventory().getResult())) && !furnace.getInventory().getViewers().isEmpty() && (object = furnace.getInventory().getViewers().getFirst()) instanceof Player) {
                        Player player = (Player)object;
                        object = ItemStackBridge_2.j((ItemStack)blockState, 1);
                        furnace.getInventory().setResult(null);
                        ItemStackBridge_2.f(player, object);
                    }
                }, 3L);
            } else {
                CommandSenderBridge_5.error("Recipe '" + String.valueOf(materialBridge_18.qQ()) + "' is not matching the item in the furnace. This is a bug.");
                furnaceSmeltEvent.setResult(ItemStackBridge_2.j(furnaceSmeltEvent.getSource(), 1));
            }
        }
    }

    private static boolean e(Inventory inventory) {
        return inventory instanceof FurnaceInventory && (inventory.getType() == InventoryType.BLAST_FURNACE || inventory.getType() == InventoryType.FURNACE || inventory.getType() == InventoryType.SMOKER);
    }
}
