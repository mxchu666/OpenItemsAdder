package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.asf;
import itemsadder.m.asg;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.ux;
import itemsadder.m.uy;
import itemsadder.m.uz;
import itemsadder.m.ve;
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

public class vg
implements ai,
uy {
    public final List MB = new ArrayList();
    public final Map MC = new HashMap();
    private final d MD;

    public vg(Plugin plugin, d d2) {
        this.MD = d2;
        bev.a(this, plugin);
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.MB.clear();
        this.MC.clear();
    }

    @Override
    public String ra() {
        return "Cooking";
    }

    public void a(ve ve2, String string, String string2) {
        ve ve32;
        for (ve ve32 : this.MB) {
            if (ve32.Mz != ve2.Mz || !ve32.Q(ve2.Mw.Mv)) continue;
            bce.error("Cooking recipe '" + String.valueOf(ve2.qQ()) + "' not registered. A recipe '" + String.valueOf(ve32.qQ()) + "' already exists with the same ingredient. Ingredients must be unique. File: " + ve32.nh());
            return;
        }
        NamespacedKey namespacedKey = new NamespacedKey(string, ve2.rh().toString().toLowerCase() + "_" + string2.toLowerCase());
        try {
            namespacedKey = this.a(this.MC, ve2, namespacedKey, string, string2);
        }
        catch (uz uz2) {
            // empty catch block
        }
        ve2.e(namespacedKey);
        switch (ve2.rh()) {
            case FURNACE: {
                Object object = new FurnaceRecipe(namespacedKey, ve2.qN(), ve2.re().rd(), ve2.rf(), ve2.rg());
                break;
            }
            case BLAST_FURNACE: {
                Object object = new BlastingRecipe(namespacedKey, ve2.qN(), ve2.re().rd(), ve2.rf(), ve2.rg());
                break;
            }
            case SMOKER: {
                Object object = new SmokingRecipe(namespacedKey, ve2.qN(), ve2.re().rd(), ve2.rf(), ve2.rg());
                break;
            }
            default: {
                Object object = ve32 = null;
            }
        }
        if (ve32 != null) {
            qm qm2 = d.g().a(ve2.re().Mv);
            if (qm2 != null) {
                FurnaceRecipe furnaceRecipe;
                NamespacedKey namespacedKey2 = new NamespacedKey(asf.ami + namespacedKey.getNamespace(), namespacedKey.getKey());
                ItemStack itemStack = new ItemStack(Material.STICK);
                RecipeChoice.MaterialChoice materialChoice = new RecipeChoice.MaterialChoice(qm2.getType());
                switch (ve2.rh()) {
                    case FURNACE: {
                        FurnaceRecipe furnaceRecipe2 = new FurnaceRecipe(namespacedKey2, itemStack, (RecipeChoice)materialChoice, ve2.rf(), ve2.rg());
                        break;
                    }
                    case BLAST_FURNACE: {
                        FurnaceRecipe furnaceRecipe2 = new BlastingRecipe(namespacedKey2, itemStack, (RecipeChoice)materialChoice, ve2.rf(), ve2.rg());
                        break;
                    }
                    case SMOKER: {
                        FurnaceRecipe furnaceRecipe2 = new SmokingRecipe(namespacedKey2, itemStack, (RecipeChoice)materialChoice, ve2.rf(), ve2.rg());
                        break;
                    }
                    default: {
                        FurnaceRecipe furnaceRecipe2 = furnaceRecipe = null;
                    }
                }
                if (furnaceRecipe != null) {
                    furnaceRecipe.setCookingTime(600);
                    furnaceRecipe.setExperience(0.0f);
                    ux.a((Recipe)furnaceRecipe);
                } else {
                    bce.error("Failed to register fake recipe '" + String.valueOf(namespacedKey2) + "' for custom cooking. Invalid furance type '" + String.valueOf(ve2.rh()) + "'. This is a bug.");
                }
            }
            ve2.a((CookingRecipe)ve32);
            ve2.a((Recipe)ve32);
            this.MB.add(ve2);
            this.MC.put(ve2.qQ().toString(), ve2);
            this.MD.aW.a((uw)ve2);
            this.MD.aW.a(ve2);
        }
        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
            if (ve2.qO() != null) {
                bce.log("Registered cooking recipe " + String.valueOf(ve2.qQ()) + " for: " + ve2.qO().getNamespacedID());
            } else {
                bce.log("Registered cooking recipe " + String.valueOf(ve2.qQ()) + " for: " + String.valueOf(ve2.qN().getType()));
            }
        }
    }

    @Override
    public List w(qm qm2) {
        return this.MD.aW.a(ve.class, qm2);
    }

    @Override
    public List x(qm qm2) {
        return this.MD.aW.b(ve.class, qm2);
    }

    public Set y(qm qm2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(qm2));
        linkedHashSet.addAll(this.x(qm2));
        return linkedHashSet;
    }

    public ve R(ItemStack itemStack) {
        Object object;
        qm qm2 = d.g().a(itemStack);
        if (qm2 != null && (object = d.g().aW.v(qm2)) != null) {
            Object object2 = ((AbstractSequentialList)object).iterator();
            while (object2.hasNext()) {
                ve ve2;
                uw uw2 = (uw)object2.next();
                if (!(uw2 instanceof ve) || !(ve2 = (ve)uw2).Q(itemStack)) continue;
                return ve2;
            }
        }
        for (Object object2 : this.MB) {
            if (!((ve)object2).Q(itemStack)) continue;
            return object2;
        }
        return null;
    }

    public boolean b(Recipe recipe) {
        if (recipe instanceof Keyed) {
            Keyed keyed = (Keyed)recipe;
            return keyed.getKey().getNamespace().startsWith(asf.ami) || keyed.getKey().getNamespace().equals("minecraft");
        }
        return false;
    }

    public boolean c(Recipe recipe) {
        if (recipe instanceof Keyed) {
            Keyed keyed = (Keyed)recipe;
            return keyed.getKey().getNamespace().startsWith(asf.ami);
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
        boolean bl = qm.isCustomItem(itemStack);
        if (this.c((Recipe)cookingRecipe) && !bl) {
            return;
        }
        ve ve2 = null;
        if (this.b((Recipe)cookingRecipe)) {
            if (bl) {
                ve2 = this.R(itemStack);
            }
        } else {
            ve2 = (ve)this.MD.aW.cx(cookingRecipe.getKey().toString());
        }
        if (ve2 != null && ve2.aE(furnaceStartSmeltEvent.getBlock())) {
            furnaceStartSmeltEvent.setTotalCookTime(ve2.My);
            asg.vq().a(furnace, ve2.qQ());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(FurnaceSmeltEvent furnaceSmeltEvent) {
        if (Main.PE && CustomCraftingWrapper.inst().isCustomCraftingRecipe(furnaceSmeltEvent)) {
            return;
        }
        NamespacedKey namespacedKey = asg.vq().a((Furnace)furnaceSmeltEvent.getBlock().getState());
        if (namespacedKey == null) {
            return;
        }
        if (namespacedKey.getNamespace().startsWith(asf.ami)) {
            if (!qm.isCustomItem(furnaceSmeltEvent.getSource())) {
                furnaceSmeltEvent.setResult(bbs.j(furnaceSmeltEvent.getSource(), 1));
                return;
            }
            ve ve2 = this.R(furnaceSmeltEvent.getSource());
            if (ve2 == null || !ve2.aE(furnaceSmeltEvent.getBlock())) {
                furnaceSmeltEvent.setResult(bbs.j(furnaceSmeltEvent.getSource(), 1));
                return;
            }
            if (ve2.Q(furnaceSmeltEvent.getSource())) {
                furnaceSmeltEvent.setResult(ve2.qN());
                bcp.c(() -> {
                    Object object;
                    Furnace furnace;
                    BlockState blockState = furnaceSmeltEvent.getBlock().getState();
                    if (blockState instanceof Furnace && !bbs.at((ItemStack)(blockState = (furnace = (Furnace)blockState).getInventory().getResult())) && !furnace.getInventory().getViewers().isEmpty() && (object = furnace.getInventory().getViewers().getFirst()) instanceof Player) {
                        Player player = (Player)object;
                        object = bbs.j((ItemStack)blockState, 1);
                        furnace.getInventory().setResult(null);
                        bbs.f(player, object);
                    }
                }, 3L);
            } else {
                bce.error("Recipe '" + String.valueOf(ve2.qQ()) + "' is not matching the item in the furnace. This is a bug.");
                furnaceSmeltEvent.setResult(bbs.j(furnaceSmeltEvent.getSource(), 1));
            }
        }
    }

    private static boolean e(Inventory inventory) {
        return inventory instanceof FurnaceInventory && (inventory.getType() == InventoryType.BLAST_FURNACE || inventory.getType() == InventoryType.FURNACE || inventory.getType() == InventoryType.SMOKER);
    }
}
