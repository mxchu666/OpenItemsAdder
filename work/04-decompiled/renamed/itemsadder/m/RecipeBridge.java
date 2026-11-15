package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBridge_36;
import itemsadder.m.ItemStackBridge_41;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_18;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
import itemsadder.m.RecipeChoiceItemStackHolder_3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.CraftingRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RecipeBridge {
    public static HashMap Me = new LinkedHashMap();
    private final LinkedHashMap Mf;
    private final HashMap Mg;
    private final HashMap Mh;
    private final HashMap Mi;
    private final HashMap Mj;
    private final HashMap Mk;
    private final HashMap Ml;
    private final HashMap Mm;
    private final LinkedList Mn;
    private final LinkedList Mo;
    private final LinkedHashMap Mp = new LinkedHashMap();

    public RecipeBridge() {
        this.Mf = new LinkedHashMap();
        this.Mg = new HashMap();
        this.Mh = new HashMap();
        this.Mi = new HashMap();
        this.Mj = new HashMap();
        this.Mm = new HashMap();
        this.Mn = new LinkedList();
        this.Mo = new LinkedList();
        this.Mk = new HashMap();
        this.Ml = new HashMap();
    }

    public void qV() {
        boolean bl = false;
        Iterator iterator = Me.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            NamespacedKey namespacedKey = (NamespacedKey)entry.getKey();
            if (namespacedKey.getNamespace().startsWith(PlayerQuitListenerBase.ami)) {
                NamespacedKey namespacedKey2 = new NamespacedKey(namespacedKey.getNamespace().substring(PlayerQuitListenerBase.ami.length()), namespacedKey.getKey());
                if (ItemStackRegistry.g().aW.cx(namespacedKey2.toString()) != null) continue;
                PlayerHolder_5.vq().h(namespacedKey2);
                iterator.remove();
                CommandSenderBridge_5.warn("---- Removed fake unused/disabled/failed to load recipe: " + String.valueOf(namespacedKey));
                bl = true;
                continue;
            }
            if (ItemStackRegistry.g().aW.cx(namespacedKey.toString()) != null) continue;
            PlayerHolder_5.vq().h(namespacedKey);
            iterator.remove();
            CommandSenderBridge_5.warn("---- Removed unused/disabled/failed to load recipe: " + String.valueOf(namespacedKey));
            bl = true;
        }
        if (bl) {
            PlayerHolder_5.vq().vo();
        }
    }

    public void b(boolean bl) {
        if (!bl && !Me.isEmpty()) {
            Me.forEach((namespacedKey, keyed) -> PlayerHolder_5.vq().h((NamespacedKey)namespacedKey));
            Me.clear();
            PlayerHolder_5.vq().vo();
        }
        this.Mf.clear();
        this.Mg.clear();
        this.Mh.clear();
        this.Mi.clear();
        this.Mm.clear();
        this.Mn.clear();
        this.Mo.clear();
        this.Mk.clear();
        this.Ml.clear();
    }

    public void a(NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        this.Mf.put(namespacedKeyItemStackHolder.LZ.getNamespace() + ":" + namespacedKeyItemStackHolder.LZ.getKey(), namespacedKeyItemStackHolder);
        this.Mn.add(namespacedKeyItemStackHolder.Hg);
        this.Mo.add(PlayerHolder_5.vq().g(namespacedKeyItemStackHolder.LZ));
        @Nullable ItemStackBuilder_4 itemStackBuilder_4 = namespacedKeyItemStackHolder.qO();
        if (itemStackBuilder_4 != null) {
            this.Mm.computeIfAbsent(namespacedKeyItemStackHolder.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(namespacedKeyItemStackHolder);
            this.Mi.computeIfAbsent(namespacedKeyItemStackHolder.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(namespacedKeyItemStackHolder);
        }
    }

    public void a(MaterialBridge_18 materialBridge_18) {
        ItemStackBuilder_4 itemStackBuilder_4;
        ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(materialBridge_18.re().getItemStack());
        if (itemStackBuilder_42 != null) {
            this.Ml.computeIfAbsent(itemStackBuilder_42.Gi, n -> new LinkedList()).add(materialBridge_18);
            this.Mh.computeIfAbsent(itemStackBuilder_42.Gi, n -> new LinkedList()).add(materialBridge_18.LZ);
            this.Mj.computeIfAbsent(materialBridge_18.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_42.Gi, n -> new LinkedList()).add(materialBridge_18);
            this.Mi.computeIfAbsent(materialBridge_18.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_42.Gi, n -> new LinkedList()).add(materialBridge_18);
            this.Mg.computeIfAbsent(itemStackBuilder_42.Gi, n -> new LinkedList()).add(materialBridge_18.LZ);
        }
        if ((itemStackBuilder_4 = materialBridge_18.qO()) != null) {
            this.Mg.computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(materialBridge_18.LZ);
            this.Mi.computeIfAbsent(materialBridge_18.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(materialBridge_18);
        }
    }

    public void a(ItemStackBridge_35 itemStackBridge_35, RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2) {
        if (recipeChoiceItemStackHolder_2.ny()) {
            Integer n2 = recipeChoiceItemStackHolder_2.rj();
            this.Mg.computeIfAbsent(n2, n -> new LinkedList()).add(itemStackBridge_35.LZ);
            this.Mk.computeIfAbsent(n2, n -> new LinkedList()).add(itemStackBridge_35);
            this.Mh.computeIfAbsent(n2, n -> new LinkedList()).add(itemStackBridge_35.LZ);
            this.Ml.computeIfAbsent(n2, n -> new LinkedList()).add(itemStackBridge_35);
            this.Mj.computeIfAbsent(itemStackBridge_35.getClass(), clazz -> new HashMap()).computeIfAbsent(n2, n -> new LinkedList()).add(itemStackBridge_35);
            this.Mi.computeIfAbsent(itemStackBridge_35.getClass(), clazz -> new HashMap()).computeIfAbsent(n2, n -> new LinkedList()).add(itemStackBridge_35);
        }
    }

    public void a(ItemStackBridge_35 itemStackBridge_35) {
        if (itemStackBridge_35.qO() != null) {
            this.Mg.computeIfAbsent(itemStackBridge_35.qO().Gi, n -> new LinkedList()).add(itemStackBridge_35.LZ);
        }
    }

    public void a(ItemStackBridge_41 itemStackBridge_41) {
        this.a(itemStackBridge_41, itemStackBridge_41.Nj);
        this.a(itemStackBridge_41, itemStackBridge_41.Nk);
        @Nullable ItemStackBuilder_4 itemStackBuilder_4 = itemStackBridge_41.qO();
        if (itemStackBuilder_4 != null) {
            this.Mg.computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41.LZ);
            this.Mi.computeIfAbsent(itemStackBridge_41.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41);
        }
    }

    public void a(ItemStackBridge_41 itemStackBridge_41, RecipeChoiceItemStackHolder_3 recipeChoiceItemStackHolder_3) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(recipeChoiceItemStackHolder_3.getItem());
        if (itemStackBuilder_4 != null) {
            this.Ml.computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41);
            this.Mh.computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41.LZ);
            this.Mj.computeIfAbsent(itemStackBridge_41.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41);
            this.Mi.computeIfAbsent(itemStackBridge_41.getClass(), clazz -> new HashMap()).computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41);
            this.Mg.computeIfAbsent(itemStackBuilder_4.Gi, n -> new LinkedList()).add(itemStackBridge_41.LZ);
        }
    }

    public ItemStackBridge_36 s(ItemStackBuilder_4 itemStackBuilder_4) {
        ItemStackBridge_36 itemStackBridge_36 = (ItemStackBridge_36)this.Mp.get(itemStackBuilder_4);
        if (itemStackBridge_36 != null) {
            return itemStackBridge_36;
        }
        itemStackBridge_36 = new ItemStackBridge_36(itemStackBuilder_4);
        this.Mp.put(itemStackBuilder_4, itemStackBridge_36);
        return itemStackBridge_36;
    }

    public boolean cw(String string) {
        return this.Mf.containsKey(string);
    }

    public LinkedList a(Class clazz, ItemStackBuilder_4 itemStackBuilder_4) {
        return this.a(clazz, itemStackBuilder_4, (HashMap)this.Mm.get(clazz));
    }

    public LinkedList b(Class clazz, ItemStackBuilder_4 itemStackBuilder_4) {
        return this.a(clazz, itemStackBuilder_4, (HashMap)this.Mi.get(clazz));
    }

    public LinkedList c(Class clazz, ItemStackBuilder_4 itemStackBuilder_4) {
        return this.a(clazz, itemStackBuilder_4, (HashMap)this.Mj.get(clazz));
    }

    @NotNull
    private LinkedList a(Class clazz, ItemStackBuilder_4 itemStackBuilder_4, HashMap hashMap) {
        if (hashMap == null) {
            return new LinkedList();
        }
        LinkedList linkedList = (LinkedList)hashMap.get(itemStackBuilder_4.Gi);
        if (linkedList == null) {
            return new LinkedList();
        }
        return linkedList;
    }

    public LinkedList t(ItemStackBuilder_4 itemStackBuilder_4) {
        return (LinkedList)this.Mg.get(itemStackBuilder_4.Gi);
    }

    @Nullable
    public NamespacedKeyItemStackHolder cx(String string) {
        return (NamespacedKeyItemStackHolder)this.Mf.get(string);
    }

    public LinkedHashMap qW() {
        return this.Mf;
    }

    @Nullable
    public LinkedList qX() {
        return this.Mo;
    }

    @Nullable
    public LinkedList qY() {
        return this.Mn;
    }

    @Nullable
    public LinkedList u(ItemStackBuilder_4 itemStackBuilder_4) {
        return (LinkedList)this.Mk.get(itemStackBuilder_4.Gi);
    }

    @Nullable
    public LinkedList v(ItemStackBuilder_4 itemStackBuilder_4) {
        return (LinkedList)this.Ml.get(itemStackBuilder_4.Gi);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Recipe recipe) {
        Keyed keyed;
        NamespacedKey namespacedKey = ((Keyed)recipe).getKey();
        if (!Me.isEmpty() && (keyed = (Keyed)Me.get(namespacedKey)) != null) {
            if (recipe instanceof CraftingRecipe) {
                CraftingRecipe craftingRecipe;
                if (keyed instanceof CraftingRecipe && (craftingRecipe = (CraftingRecipe)keyed).getResult().isSimilar(recipe.getResult()) && craftingRecipe.getCategory().equals((Object)((CraftingRecipe)recipe).getCategory())) {
                    if (keyed instanceof ShapedRecipe) {
                        ShapedRecipe shapedRecipe = (ShapedRecipe)keyed;
                        if (Arrays.equals(shapedRecipe.getShape(), ((ShapedRecipe)recipe).getShape()) && shapedRecipe.getChoiceMap().equals(((ShapedRecipe)recipe).getChoiceMap())) {
                            return;
                        }
                    } else {
                        if (!(keyed instanceof ShapelessRecipe)) throw new IllegalStateException("Recipe type not supported: " + String.valueOf(keyed.getClass()));
                        ShapelessRecipe shapelessRecipe = (ShapelessRecipe)keyed;
                        if (shapelessRecipe.getChoiceList().equals(((ShapelessRecipe)recipe).getChoiceList())) {
                            return;
                        }
                    }
                }
            } else if (recipe instanceof CookingRecipe) {
                CookingRecipe cookingRecipe;
                CookingRecipe cookingRecipe2 = (CookingRecipe)recipe;
                if (keyed instanceof CookingRecipe && (cookingRecipe = (CookingRecipe)keyed).getResult().isSimilar(cookingRecipe2.getResult()) && cookingRecipe.getCookingTime() == cookingRecipe2.getCookingTime() && cookingRecipe.getExperience() == cookingRecipe2.getExperience() && cookingRecipe.getInputChoice().getItemStack().isSimilar(cookingRecipe2.getInputChoice().getItemStack())) {
                    return;
                }
            }
        }
        try {
            PlayerHolder_5.vq().e(recipe);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            PlayerHolder_5.vq().h(namespacedKey);
            PlayerHolder_5.vq().e(recipe);
            return;
        }
        finally {
            Me.put(namespacedKey, (Keyed)recipe);
        }
    }

    public Set qZ() {
        return this.Mf.values().stream().map(namespacedKeyItemStackHolder -> namespacedKeyItemStackHolder.LZ.getNamespace()).collect(Collectors.toSet());
    }
}
