package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import itemsadder.m.aaa;
import itemsadder.m.ai;
import itemsadder.m.aiz;
import itemsadder.m.aow;
import itemsadder.m.ase;
import itemsadder.m.asf;
import itemsadder.m.asg;
import itemsadder.m.atp;
import itemsadder.m.atq;
import itemsadder.m.bbs;
import itemsadder.m.bbu;
import itemsadder.m.bbv;
import itemsadder.m.bce;
import itemsadder.m.bcw;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.vi;
import itemsadder.m.vj;
import itemsadder.m.vk;
import itemsadder.m.zw;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.PacketPlayInAutoRecipe;
import net.minecraft.network.protocol.game.PacketPlayOutAutoRecipe;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.inventory.InventoryCrafting;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingManager;
import net.minecraft.world.item.crafting.IRecipe;
import net.minecraft.world.item.crafting.RecipeBlasting;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeItemStack;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeSmoking;
import net.minecraft.world.item.crafting.Recipes;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.item.crafting.ShapedRecipes;
import net.minecraft.world.item.crafting.ShapelessRecipes;
import net.minecraft.world.item.crafting.display.RecipeDisplayEntry;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.entity.TileEntityFurnace;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Furnace;
import org.bukkit.craftbukkit.v1_21_R5.block.CraftFurnace;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftBlastingRecipe;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftFurnaceRecipe;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftInventoryCrafting;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftRecipe;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftShapedRecipe;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftShapelessRecipe;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftSmokingRecipe;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.inventory.recipe.CookingBookCategory;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class ato
extends asf
implements ai {
    private static Method amE;
    protected PacketAdapter amF;
    private final Map anj = new ConcurrentHashMap();
    Map amH = new ConcurrentHashMap();
    Map amI = new ConcurrentHashMap();
    Map amJ = new ConcurrentHashMap();
    static Field amu;
    static Field amv;
    static Field amw;
    Map amx = new Object2ObjectOpenHashMap();
    static Field amK;
    static Method amL;

    private static boolean a(RecipeHolder recipeHolder) {
        return recipeHolder.a().a().b().startsWith(asf.ami);
    }

    @Override
    public void register() {
        this.amm = new atp(this, (Plugin)this.amj, ListenerPriority.LOWEST, PacketType.fromClass(ClientboundRecipeBookAddPacket.class));
        if (!aaa.Va) {
            this.amF = new atq(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)this.amj).listenerPriority(ListenerPriority.NORMAL).types(new PacketType[]{PacketType.fromClass(PacketPlayInAutoRecipe.class)}));
            aow.b((PacketListener)this.amF);
        }
        this.vk();
        bev.b(this, (Plugin)this.amj);
    }

    void a(Player player, CraftingInventory craftingInventory) {
        ItemStack[] itemStackArray = (ItemStack[])craftingInventory.getMatrix().clone();
        for (int i = 0; i <= 9; ++i) {
            craftingInventory.setItem(i, null);
        }
        bbs.a(player, itemStackArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(int n, boolean bl, Player player, RecipeDisplayEntry recipeDisplayEntry, RecipeHolder recipeHolder, uw uw2) {
        Object object = player.getOpenInventory().getTopInventory();
        if (!(object instanceof CraftingInventory)) {
            return;
        }
        CraftingInventory craftingInventory = (CraftingInventory)object;
        if (!this.amH.containsKey(player.getUniqueId())) {
            this.a(player, craftingInventory);
        }
        if (this.amH.getOrDefault(player.getUniqueId(), recipeHolder.a().a()) != recipeHolder.a().a()) {
            this.a(player, craftingInventory);
            object = this.amI.computeIfAbsent(player.getUniqueId(), uUID -> new bcw(player, bl ? 800 : 200, 750, 10));
            try {
                if (((bcw)object).Dr()) {
                    bce.error("Player '" + player.getName() + "' is abusing the recipe book changing recipe too fast. Hacking?");
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You are abusing the recipe book changing recipe too fast!");
                    player.closeInventory();
                    this.amJ.put(player.getUniqueId(), System.currentTimeMillis());
                    return;
                }
                if (((bcw)object).Dq()) {
                    return;
                }
            }
            finally {
                ((bcw)object).Dp();
            }
        }
        this.amH.put(player.getUniqueId(), recipeHolder.a().a());
        if (uw2 instanceof vk) {
            object = (vk)uw2;
            Map map = ((vk)object).rr();
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
            map.forEach((arg_0, arg_1) -> ato.a((Map)object2ObjectOpenHashMap, arg_0, arg_1));
            Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap();
            bbu bbu2 = new bbu(player);
            if (bl) {
                block4: for (int i = 0; i < bbu2.Dd(); ++i) {
                    boolean bl2;
                    bbv bbv2 = bbu2.bJ(i);
                    if (bbv2 == null || bbv2.aAy) continue;
                    do {
                        bl2 = false;
                        if (bbv2.De() - 1 <= 0) continue block4;
                        for (Map.Entry entry : map.entrySet()) {
                            vj vj2 = (vj)entry.getValue();
                            if (vj2 == null) continue;
                            int n2 = (Integer)entry.getKey();
                            int n3 = n2 + 1;
                            ItemStack itemStack = (ItemStack)object2ObjectOpenHashMap2.get(n3);
                            if (vj2.ny()) {
                                qm qm2 = d.g().a(bbv2.aAx);
                                if (qm2 == null || qm2.Gi != vj2.MI) continue;
                                bl2 = true;
                                bbv2.bH(1);
                                if (itemStack == null) {
                                    itemStack = bbv2.aAx.clone();
                                    itemStack.setAmount(1);
                                    object2ObjectOpenHashMap2.put(n3, itemStack);
                                    object2ObjectOpenHashMap.put(n2, true);
                                    continue;
                                }
                                if (itemStack.getAmount() + 1 > bbs.am(itemStack)) continue;
                                itemStack.setAmount(itemStack.getAmount() + 1);
                                continue;
                            }
                            if (!vj2.rd().test(bbv2.aAx)) continue;
                            bl2 = true;
                            bbv2.bH(1);
                            if (itemStack == null) {
                                itemStack = bbv2.aAx.clone();
                                itemStack.setAmount(1);
                                object2ObjectOpenHashMap2.put(n3, itemStack);
                                object2ObjectOpenHashMap.put(n2, true);
                                continue;
                            }
                            if (itemStack.getAmount() + 1 > bbs.am(itemStack)) {
                                bbv2.bK(0);
                                continue;
                            }
                            itemStack.setAmount(itemStack.getAmount() + 1);
                        }
                    } while (bl2);
                }
                this.a(player, bbu2, craftingInventory, (Map)object2ObjectOpenHashMap, (Map)object2ObjectOpenHashMap2, n, recipeDisplayEntry);
            } else {
                block7: for (Map.Entry entry : map.entrySet()) {
                    ItemStack itemStack;
                    bbv bbv3;
                    int n4;
                    vj vj3 = (vj)entry.getValue();
                    if (vj3 == null) continue;
                    int n5 = (Integer)entry.getKey();
                    int n6 = n5 + 1;
                    if (vj3.ny()) {
                        for (n4 = 0; n4 < bbu2.Dd(); ++n4) {
                            qm qm3;
                            bbv3 = bbu2.bJ(n4);
                            if (bbv3 == null || bbv3.aAy || (qm3 = d.g().a(bbv3.aAx)) == null || qm3.Gi != vj3.MI) continue;
                            itemStack = bbv3.aAx.clone();
                            itemStack.setAmount(1);
                            object2ObjectOpenHashMap2.put(n6, itemStack);
                            object2ObjectOpenHashMap.put(n5, true);
                            continue block7;
                        }
                        continue;
                    }
                    for (n4 = 0; n4 < bbu2.Dd(); ++n4) {
                        bbv3 = bbu2.bJ(n4);
                        if (bbv3 == null || bbv3.aAy || !vj3.rd().test(bbv3.aAx)) continue;
                        itemStack = bbv3.aAx.clone();
                        itemStack.setAmount(1);
                        object2ObjectOpenHashMap2.put(n6, itemStack);
                        object2ObjectOpenHashMap.put(n5, true);
                        continue block7;
                    }
                }
                this.a(player, bbu2, craftingInventory, (Map)object2ObjectOpenHashMap, (Map)object2ObjectOpenHashMap2, n, recipeDisplayEntry);
            }
        } else {
            bce.error("Custom recipe type not supported, probably a bug: " + uw2.getClass().getSimpleName());
        }
    }

    private void a(Player player, bbu bbu2, CraftingInventory craftingInventory, Map map, Map map2, int n, RecipeDisplayEntry recipeDisplayEntry) {
        if (map.values().stream().allMatch(bl -> bl)) {
            bbu2.applyChanges();
            for (Map.Entry entry : map2.entrySet()) {
                if (entry.getValue() == null) continue;
                craftingInventory.setItem(((Integer)entry.getKey()).intValue(), (ItemStack)entry.getValue());
            }
        } else {
            PacketPlayOutAutoRecipe packetPlayOutAutoRecipe = new PacketPlayOutAutoRecipe(n, recipeDisplayEntry.b());
            aow.uN().d(player, packetPlayOutAutoRecipe);
        }
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.vl();
        aow.c((PacketListener)this.amF);
        this.amx.clear();
    }

    @Override
    public Object f(NamespacedKey namespacedKey) {
        return MinecraftServer.getServer().aI().b(CraftRecipe.toMinecraft((NamespacedKey)namespacedKey)).orElse(null);
    }

    @Override
    public Object g(NamespacedKey namespacedKey) {
        return MinecraftKey.a((String)namespacedKey.toString());
    }

    @Override
    public void b(Player player, List list) {
        ((CraftPlayer)player).getHandle().a((Collection)list);
    }

    @Override
    public void g(Set set) {
        CraftingManager craftingManager = MinecraftServer.getServer().aI();
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(craftingManager.e.b);
        boolean bl = false;
        for (ase ase2 : ase.values()) {
            Recipes recipes = switch (ase2) {
                default -> throw new MatchException(null, null);
                case ase.CRAFTING -> Recipes.a;
                case ase.SMELTING -> Recipes.b;
                case ase.BLASTING -> Recipes.c;
                case ase.SMOKING -> Recipes.d;
                case ase.CAMPFIRE_COOKING -> Recipes.e;
                case ase.STONECUTTING -> Recipes.f;
                case ase.SMITHING -> Recipes.g;
            };
            Set set2 = linkedHashMultimap.get(recipes);
            if (set2.isEmpty()) continue;
            ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
            ArrayList<RecipeHolder> arrayList2 = new ArrayList<RecipeHolder>();
            for (RecipeHolder recipeHolder : set2) {
                if (set.contains(recipeHolder.a().a().b())) {
                    arrayList.add(recipeHolder);
                    continue;
                }
                arrayList2.add(recipeHolder);
            }
            if (arrayList.isEmpty()) continue;
            ArrayList arrayList3 = new ArrayList(set2.size());
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            linkedHashMultimap.replaceValues(recipes, (Iterable)arrayList3);
            bl = true;
        }
        if (!bl) {
            return;
        }
        try {
            amu.set(craftingManager.e, linkedHashMultimap);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void vm() {
        CraftingManager craftingManager = MinecraftServer.getServer().aI();
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(craftingManager.e.b);
        boolean bl = false;
        for (ase ase2 : ase.values()) {
            Recipes recipes = switch (ase2) {
                default -> throw new MatchException(null, null);
                case ase.CRAFTING -> Recipes.a;
                case ase.SMELTING -> Recipes.b;
                case ase.BLASTING -> Recipes.c;
                case ase.SMOKING -> Recipes.d;
                case ase.CAMPFIRE_COOKING -> Recipes.e;
                case ase.STONECUTTING -> Recipes.f;
                case ase.SMITHING -> Recipes.g;
            };
            Set set = linkedHashMultimap.get(recipes);
            if (set.isEmpty()) continue;
            ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
            ArrayList<RecipeHolder> arrayList2 = new ArrayList<RecipeHolder>();
            for (RecipeHolder recipeHolder : set) {
                if (ato.a(recipeHolder)) {
                    arrayList.add(recipeHolder);
                    continue;
                }
                arrayList2.add(recipeHolder);
            }
            if (arrayList.isEmpty()) continue;
            ArrayList arrayList3 = new ArrayList(set.size());
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            linkedHashMultimap.replaceValues(recipes, (Iterable)arrayList3);
            bl = true;
        }
        if (!bl) {
            return;
        }
        try {
            amu.set(craftingManager.e, linkedHashMultimap);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public NamespacedKey a(Furnace furnace) {
        CraftFurnace craftFurnace = (CraftFurnace)furnace;
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)craftFurnace.getBlockEntity();
        CraftingManager.a a2 = (CraftingManager.a)zw.a(amv, tileEntityFurnace);
        if (amw == null) {
            amw = zw.a(a2.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        Object object = zw.a(amw, a2);
        if (object instanceof ResourceKey) {
            ResourceKey resourceKey = (ResourceKey)object;
            object = MinecraftServer.getServer().aI().b(resourceKey);
            if (((Optional)object).isPresent()) {
                return new NamespacedKey(resourceKey.a().b(), resourceKey.a().a());
            }
        }
        return null;
    }

    @Override
    public void a(Furnace furnace, NamespacedKey namespacedKey) {
        CraftFurnace craftFurnace = (CraftFurnace)furnace;
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)craftFurnace.getBlockEntity();
        CraftingManager.a a2 = (CraftingManager.a)zw.a(amv, tileEntityFurnace);
        if (amw == null) {
            amw = zw.a(a2.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        RecipeHolder recipeHolder = MinecraftServer.getServer().aI().b(CraftRecipe.toMinecraft((NamespacedKey)namespacedKey)).orElse(null);
        zw.a(amw, a2, (Object)(recipeHolder == null ? null : recipeHolder.a()));
    }

    @Override
    public Set h(Set set) {
        CraftingManager craftingManager = MinecraftServer.getServer().aI();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (RecipeHolder recipeHolder : craftingManager.e.b.get(Recipes.a)) {
            if (!set.contains(recipeHolder.a().a().b())) continue;
            objectOpenHashSet.add(recipeHolder.a().a().toString());
        }
        return objectOpenHashSet;
    }

    @Override
    public String c(CraftingInventory craftingInventory) {
        CraftInventoryCrafting craftInventoryCrafting = (CraftInventoryCrafting)craftingInventory;
        InventoryHolder inventoryHolder = craftInventoryCrafting.getInventory().getOwner();
        if (inventoryHolder instanceof CraftPlayer) {
            CraftPlayer craftPlayer = (CraftPlayer)inventoryHolder;
            inventoryHolder = MinecraftServer.getServer().aI();
            CraftingInput craftingInput = craftInventoryCrafting.getMatrixInventory().aB_();
            WorldServer worldServer = craftPlayer.getHandle().y();
            for (RecipeHolder recipeHolder : inventoryHolder.e.b.get(Recipes.a)) {
                IRecipe iRecipe = recipeHolder.b();
                if (ato.a(recipeHolder) || !iRecipe.a((RecipeInput)craftingInput, (World)worldServer)) continue;
                return recipeHolder.a().a().toString();
            }
        }
        return null;
    }

    @Override
    public void vn() {
        vi vi2 = new vi();
        bev.a(vi2, (Plugin)this.amj);
    }

    @Override
    public boolean e(Recipe recipe) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        ShapedRecipe shapedRecipe;
        int n;
        Recipe recipe2;
        CraftRecipe craftRecipe;
        if (recipe instanceof SmithingRecipe) {
            Bukkit.addRecipe((Recipe)recipe);
            return true;
        }
        if (recipe instanceof CraftRecipe) {
            craftRecipe = (CraftRecipe)recipe;
        } else {
            recipe2 = recipe;
            n = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ShapedRecipe.class, ShapelessRecipe.class, FurnaceRecipe.class, BlastingRecipe.class, SmokingRecipe.class}, (Object)recipe2, n)) {
                case 0: {
                    shapedRecipe = (ShapedRecipe)recipe2;
                    craftRecipe = CraftShapedRecipe.fromBukkitRecipe((ShapedRecipe)shapedRecipe);
                    break;
                }
                case 1: {
                    object4 = (ShapelessRecipe)recipe2;
                    craftRecipe = CraftShapelessRecipe.fromBukkitRecipe((ShapelessRecipe)object4);
                    break;
                }
                case 2: {
                    object3 = (FurnaceRecipe)recipe2;
                    craftRecipe = CraftFurnaceRecipe.fromBukkitRecipe((FurnaceRecipe)object3);
                    break;
                }
                case 3: {
                    object2 = (BlastingRecipe)recipe2;
                    craftRecipe = CraftBlastingRecipe.fromBukkitRecipe((BlastingRecipe)object2);
                    break;
                }
                case 4: {
                    object = (SmokingRecipe)recipe2;
                    craftRecipe = CraftSmokingRecipe.fromBukkitRecipe((SmokingRecipe)object);
                    break;
                }
                default: {
                    return false;
                }
            }
        }
        if (amE == null) {
            craftRecipe.addToCraftingManager();
            return true;
        }
        Recipe recipe3 = recipe;
        Objects.requireNonNull(recipe3);
        recipe2 = recipe3;
        n = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ShapedRecipe.class, ShapelessRecipe.class, FurnaceRecipe.class, BlastingRecipe.class, SmokingRecipe.class}, (Object)recipe2, n)) {
            case 0: {
                shapedRecipe = (ShapedRecipe)recipe2;
                object4 = shapedRecipe.getChoiceMap();
                object3 = ato.a(shapedRecipe.getShape(), (Map)object4);
                object4.values().removeIf(Objects::isNull);
                object2 = Maps.transformValues(object4, recipeChoice -> ato.a(craftRecipe, recipeChoice, false));
                object = ShapedRecipePattern.a((Map)object2, (String[])object3);
                MinecraftServer.getServer().aI().e.addRecipe(new RecipeHolder(CraftRecipe.toMinecraft((NamespacedKey)shapedRecipe.getKey()), (IRecipe)new ShapedRecipes(shapedRecipe.getGroup(), CraftRecipe.getCategory((CraftingBookCategory)shapedRecipe.getCategory()), (ShapedRecipePattern)object, CraftItemStack.asNMSCopy((ItemStack)shapedRecipe.getResult()))));
                break;
            }
            case 1: {
                object4 = (ShapelessRecipe)recipe2;
                object3 = object4.getChoiceList();
                object2 = new ArrayList(object3.size());
                object = object3.iterator();
                while (object.hasNext()) {
                    RecipeChoice recipeChoice2 = (RecipeChoice)object.next();
                    object2.add(ato.a(craftRecipe, recipeChoice2, true));
                }
                MinecraftServer.getServer().aI().addRecipe(new RecipeHolder(CraftRecipe.toMinecraft((NamespacedKey)object4.getKey()), (IRecipe)new ShapelessRecipes(object4.getGroup(), CraftRecipe.getCategory((CraftingBookCategory)object4.getCategory()), CraftItemStack.asNMSCopy((ItemStack)object4.getResult()), (List)object2)));
                break;
            }
            case 2: {
                object3 = (FurnaceRecipe)recipe2;
                object2 = object3.getResult();
                MinecraftServer.getServer().aI().addRecipe(new RecipeHolder(CraftRecipe.toMinecraft((NamespacedKey)object3.getKey()), (IRecipe)new net.minecraft.world.item.crafting.FurnaceRecipe(object3.getGroup(), CraftRecipe.getCategory((CookingBookCategory)object3.getCategory()), ato.a(craftRecipe, object3.getInputChoice(), true), CraftItemStack.asNMSCopy((ItemStack)object2), object3.getExperience(), object3.getCookingTime())));
                break;
            }
            case 3: {
                object2 = (BlastingRecipe)recipe2;
                object = object2.getResult();
                MinecraftServer.getServer().aI().addRecipe(new RecipeHolder(CraftRecipe.toMinecraft((NamespacedKey)object2.getKey()), (IRecipe)new RecipeBlasting(object2.getGroup(), CraftRecipe.getCategory((CookingBookCategory)object2.getCategory()), ato.a(craftRecipe, object2.getInputChoice(), true), CraftItemStack.asNMSCopy((ItemStack)object), object2.getExperience(), object2.getCookingTime())));
                break;
            }
            case 4: {
                object = (SmokingRecipe)recipe2;
                ItemStack itemStack = object.getResult();
                MinecraftServer.getServer().aI().addRecipe(new RecipeHolder(CraftRecipe.toMinecraft((NamespacedKey)object.getKey()), (IRecipe)new RecipeSmoking(object.getGroup(), CraftRecipe.getCategory((CookingBookCategory)object.getCategory()), ato.a(craftRecipe, object.getInputChoice(), true), CraftItemStack.asNMSCopy((ItemStack)itemStack), object.getExperience(), object.getCookingTime())));
                break;
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + String.valueOf(recipe));
            }
        }
        return true;
    }

    static RecipeItemStack a(CraftRecipe craftRecipe, RecipeChoice recipeChoice, boolean bl) {
        try {
            return (RecipeItemStack)amE.invoke((Object)craftRecipe, recipeChoice, bl);
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    private static String[] a(String[] stringArray, Map map) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            StringBuilder stringBuilder = new StringBuilder(string.length());
            for (char c : string.toCharArray()) {
                stringBuilder.append(map.get(Character.valueOf(c)) == null ? (char)' ' : c);
            }
            stringArray[i] = stringBuilder.toString();
        }
        return stringArray;
    }

    @Override
    public boolean h(NamespacedKey namespacedKey) {
        ResourceKey resourceKey = CraftRecipe.toMinecraft((NamespacedKey)namespacedKey);
        return MinecraftServer.getServer().aI().e.removeRecipe(resourceKey);
    }

    @Override
    public void vo() {
        MinecraftServer.getServer().ag().reloadRecipes();
        MinecraftServer.getServer().aI().finalizeRecipeLoading();
    }

    @Override
    public boolean a(ShapedRecipe shapedRecipe, CraftingInventory craftingInventory) {
        InventoryCrafting inventoryCrafting = ((CraftInventoryCrafting)craftingInventory).getMatrixInventory();
        ShapedRecipePattern shapedRecipePattern = this.amx.computeIfAbsent(shapedRecipe.getKey(), namespacedKey -> {
            CraftShapedRecipe craftShapedRecipe = (CraftShapedRecipe)Bukkit.getRecipe((NamespacedKey)shapedRecipe.getKey());
            assert (craftShapedRecipe != null);
            Map map = craftShapedRecipe.getChoiceMap();
            String[] stringArray = asg.a(craftShapedRecipe.getShape(), map);
            map.values().removeIf(Objects::isNull);
            Map map2 = Maps.transformValues(map, recipeChoice -> craftShapedRecipe.toNMS(recipeChoice, false));
            return ShapedRecipePattern.a(map2, (String[])stringArray);
        });
        List list = shapedRecipePattern.c();
        for (int i = 0; i <= inventoryCrafting.ay_() - shapedRecipePattern.a(); ++i) {
            for (int j = 0; j <= inventoryCrafting.g() - shapedRecipePattern.b(); ++j) {
                if (this.a(inventoryCrafting, i, j, list, shapedRecipePattern.a(), shapedRecipePattern.b(), true)) {
                    return true;
                }
                if (!this.a(inventoryCrafting, i, j, list, shapedRecipePattern.a(), shapedRecipePattern.b(), false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean a(InventoryCrafting inventoryCrafting, int n, int n2, List list, int n3, int n4, boolean bl) {
        for (int i = 0; i < inventoryCrafting.ay_(); ++i) {
            for (int j = 0; j < inventoryCrafting.g(); ++j) {
                int n5 = i - n;
                int n6 = j - n2;
                Optional optional = Optional.empty();
                int n7 = n6 * n3;
                if (n5 >= 0 && n6 >= 0 && n5 < n3 && n6 < n4) {
                    optional = bl ? (Optional)list.get(n3 - n5 - 1 + n7) : (Optional)list.get(n5 + n7);
                }
                net.minecraft.world.item.ItemStack itemStack = inventoryCrafting.a(i + j * inventoryCrafting.ay_());
                if (ato.a(optional.orElse(null), itemStack)) continue;
                return false;
            }
        }
        return true;
    }

    static Collection a(RecipeItemStack recipeItemStack) {
        try {
            Object object;
            if (amL == null) {
                amL = recipeItemStack.getClass().getMethod("itemStacks", new Class[0]);
            }
            if ((object = amL.invoke((Object)recipeItemStack, new Object[0])) instanceof Collection) {
                return (Collection)object;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return Collections.emptyList();
    }

    private static boolean a(@Nullable RecipeItemStack recipeItemStack, net.minecraft.world.item.ItemStack itemStack) {
        if (recipeItemStack == null && itemStack == null) {
            return true;
        }
        if (recipeItemStack == null) {
            return itemStack.f();
        }
        if (itemStack == null) {
            return false;
        }
        if (recipeItemStack.isExact()) {
            for (net.minecraft.world.item.ItemStack itemStack2 : ato.a(recipeItemStack)) {
                if (itemStack2.h() != itemStack.h() || itemStack2.d().d() != itemStack.d().d() || !(aiz.a(itemStack2) && aiz.a(itemStack) ? aiz.a(itemStack2, itemStack) : net.minecraft.world.item.ItemStack.c((net.minecraft.world.item.ItemStack)itemStack, (net.minecraft.world.item.ItemStack)itemStack2))) continue;
                return true;
            }
        } else {
            for (Holder holder : recipeItemStack.a().toList()) {
                if (!itemStack.a(holder) || aiz.a(itemStack)) continue;
                return true;
            }
        }
        return false;
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.amH.remove(playerQuitEvent.getPlayer().getUniqueId());
        this.amI.remove(playerQuitEvent.getPlayer().getUniqueId());
        this.amJ.remove(playerQuitEvent.getPlayer().getUniqueId());
        this.anj.remove(playerQuitEvent.getPlayer().getUniqueId());
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        this.amH.remove(inventoryCloseEvent.getPlayer().getUniqueId());
        this.anj.remove(inventoryCloseEvent.getPlayer().getUniqueId());
    }

    private static /* synthetic */ void a(Map map, Integer n, vj vj2) {
        if (vj2 == null || vj2.getItem() == null || vj2.getItem().getType() == Material.AIR) {
            map.put(n, true);
        } else {
            map.put(n, false);
        }
    }

    static {
        try {
            for (Method method : CraftRecipe.class.getMethods()) {
                Class<?>[] classArray;
                if (method.getReturnType() != RecipeItemStack.class || (classArray = method.getParameterTypes()).length != 2 || !RecipeChoice.class.isAssignableFrom(classArray[0]) || classArray[1] != Boolean.TYPE) continue;
                method.setAccessible(true);
                amE = method;
            }
        }
        catch (Exception exception) {
            bce.error("Failed to find CraftRecipe#toIngredient method, this is a bug, please report it.", exception);
            amE = null;
        }
        amu = zw.b(RecipeMap.class, Multimap.class, 0);
        if (amu == null) {
            throw new RuntimeException("RecipeMap#byType not found! Try to update the server or downgrade it to a previous build.");
        }
        amv = zw.a(TileEntityFurnace.class, CraftingManager.a.class);
        amK = zw.b(TileEntityFurnace.class, CraftingManager.a.class, 0);
        if (amK == null) {
            bce.error("Failed to find quickCheck field from AbstractFurnaceBlockEntity.");
        }
    }
}
