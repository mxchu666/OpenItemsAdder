package itemsadder.m;

import itemsadder.m.asf;
import itemsadder.m.asg;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.ve;
import itemsadder.m.vj;
import itemsadder.m.vk;
import itemsadder.m.vo;
import itemsadder.m.wb;
import itemsadder.m.wc;
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

public class ux {
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

    public ux() {
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
            if (namespacedKey.getNamespace().startsWith(asf.ami)) {
                NamespacedKey namespacedKey2 = new NamespacedKey(namespacedKey.getNamespace().substring(asf.ami.length()), namespacedKey.getKey());
                if (d.g().aW.cx(namespacedKey2.toString()) != null) continue;
                asg.vq().h(namespacedKey2);
                iterator.remove();
                bce.warn("---- Removed fake unused/disabled/failed to load recipe: " + String.valueOf(namespacedKey));
                bl = true;
                continue;
            }
            if (d.g().aW.cx(namespacedKey.toString()) != null) continue;
            asg.vq().h(namespacedKey);
            iterator.remove();
            bce.warn("---- Removed unused/disabled/failed to load recipe: " + String.valueOf(namespacedKey));
            bl = true;
        }
        if (bl) {
            asg.vq().vo();
        }
    }

    public void b(boolean bl) {
        if (!bl && !Me.isEmpty()) {
            Me.forEach((namespacedKey, keyed) -> asg.vq().h((NamespacedKey)namespacedKey));
            Me.clear();
            asg.vq().vo();
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

    public void a(uw uw2) {
        this.Mf.put(uw2.LZ.getNamespace() + ":" + uw2.LZ.getKey(), uw2);
        this.Mn.add(uw2.Hg);
        this.Mo.add(asg.vq().g(uw2.LZ));
        @Nullable qm qm2 = uw2.qO();
        if (qm2 != null) {
            this.Mm.computeIfAbsent(uw2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(uw2);
            this.Mi.computeIfAbsent(uw2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(uw2);
        }
    }

    public void a(ve ve2) {
        qm qm2;
        qm qm3 = d.g().a(ve2.re().getItemStack());
        if (qm3 != null) {
            this.Ml.computeIfAbsent(qm3.Gi, n -> new LinkedList()).add(ve2);
            this.Mh.computeIfAbsent(qm3.Gi, n -> new LinkedList()).add(ve2.LZ);
            this.Mj.computeIfAbsent(ve2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm3.Gi, n -> new LinkedList()).add(ve2);
            this.Mi.computeIfAbsent(ve2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm3.Gi, n -> new LinkedList()).add(ve2);
            this.Mg.computeIfAbsent(qm3.Gi, n -> new LinkedList()).add(ve2.LZ);
        }
        if ((qm2 = ve2.qO()) != null) {
            this.Mg.computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(ve2.LZ);
            this.Mi.computeIfAbsent(ve2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(ve2);
        }
    }

    public void a(vk vk2, vj vj2) {
        if (vj2.ny()) {
            Integer n2 = vj2.rj();
            this.Mg.computeIfAbsent(n2, n -> new LinkedList()).add(vk2.LZ);
            this.Mk.computeIfAbsent(n2, n -> new LinkedList()).add(vk2);
            this.Mh.computeIfAbsent(n2, n -> new LinkedList()).add(vk2.LZ);
            this.Ml.computeIfAbsent(n2, n -> new LinkedList()).add(vk2);
            this.Mj.computeIfAbsent(vk2.getClass(), clazz -> new HashMap()).computeIfAbsent(n2, n -> new LinkedList()).add(vk2);
            this.Mi.computeIfAbsent(vk2.getClass(), clazz -> new HashMap()).computeIfAbsent(n2, n -> new LinkedList()).add(vk2);
        }
    }

    public void a(vk vk2) {
        if (vk2.qO() != null) {
            this.Mg.computeIfAbsent(vk2.qO().Gi, n -> new LinkedList()).add(vk2.LZ);
        }
    }

    public void a(wc wc2) {
        this.a(wc2, wc2.Nj);
        this.a(wc2, wc2.Nk);
        @Nullable qm qm2 = wc2.qO();
        if (qm2 != null) {
            this.Mg.computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2.LZ);
            this.Mi.computeIfAbsent(wc2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2);
        }
    }

    public void a(wc wc2, wb wb2) {
        qm qm2 = d.g().a(wb2.getItem());
        if (qm2 != null) {
            this.Ml.computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2);
            this.Mh.computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2.LZ);
            this.Mj.computeIfAbsent(wc2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2);
            this.Mi.computeIfAbsent(wc2.getClass(), clazz -> new HashMap()).computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2);
            this.Mg.computeIfAbsent(qm2.Gi, n -> new LinkedList()).add(wc2.LZ);
        }
    }

    public vo s(qm qm2) {
        vo vo2 = (vo)this.Mp.get(qm2);
        if (vo2 != null) {
            return vo2;
        }
        vo2 = new vo(qm2);
        this.Mp.put(qm2, vo2);
        return vo2;
    }

    public boolean cw(String string) {
        return this.Mf.containsKey(string);
    }

    public LinkedList a(Class clazz, qm qm2) {
        return this.a(clazz, qm2, (HashMap)this.Mm.get(clazz));
    }

    public LinkedList b(Class clazz, qm qm2) {
        return this.a(clazz, qm2, (HashMap)this.Mi.get(clazz));
    }

    public LinkedList c(Class clazz, qm qm2) {
        return this.a(clazz, qm2, (HashMap)this.Mj.get(clazz));
    }

    @NotNull
    private LinkedList a(Class clazz, qm qm2, HashMap hashMap) {
        if (hashMap == null) {
            return new LinkedList();
        }
        LinkedList linkedList = (LinkedList)hashMap.get(qm2.Gi);
        if (linkedList == null) {
            return new LinkedList();
        }
        return linkedList;
    }

    public LinkedList t(qm qm2) {
        return (LinkedList)this.Mg.get(qm2.Gi);
    }

    @Nullable
    public uw cx(String string) {
        return (uw)this.Mf.get(string);
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
    public LinkedList u(qm qm2) {
        return (LinkedList)this.Mk.get(qm2.Gi);
    }

    @Nullable
    public LinkedList v(qm qm2) {
        return (LinkedList)this.Ml.get(qm2.Gi);
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
            asg.vq().e(recipe);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            asg.vq().h(namespacedKey);
            asg.vq().e(recipe);
            return;
        }
        finally {
            Me.put(namespacedKey, (Keyed)recipe);
        }
    }

    public Set qZ() {
        return this.Mf.values().stream().map(uw2 -> uw2.LZ.getNamespace()).collect(Collectors.toSet());
    }
}
