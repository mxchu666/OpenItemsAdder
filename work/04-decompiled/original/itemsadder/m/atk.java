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
import itemsadder.m.aiy;
import itemsadder.m.aow;
import itemsadder.m.ase;
import itemsadder.m.asf;
import itemsadder.m.asg;
import itemsadder.m.atl;
import itemsadder.m.atm;
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
import java.lang.reflect.Method;
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
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeItemStack;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.Recipes;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
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
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftInventoryCrafting;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftRecipe;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftShapedRecipe;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class atk
extends asf
implements ai {
    protected PacketAdapter amF;
    private final Map anf = new ConcurrentHashMap();
    Map amH = new ConcurrentHashMap();
    Map amI = new ConcurrentHashMap();
    Map amJ = new ConcurrentHashMap();
    static Field amu = zw.b(RecipeMap.class, Multimap.class, 0);
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
        this.amm = new atl(this, (Plugin)this.amj, ListenerPriority.LOWEST, PacketType.fromClass(ClientboundRecipeBookAddPacket.class));
        if (!aaa.Va) {
            this.amF = new atm(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)this.amj).listenerPriority(ListenerPriority.NORMAL).types(new PacketType[]{PacketType.fromClass(PacketPlayInAutoRecipe.class)}));
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
            map.forEach((arg_0, arg_1) -> atk.a((Map)object2ObjectOpenHashMap, arg_0, arg_1));
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
                if (atk.a(recipeHolder)) {
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
                if (atk.a(recipeHolder) || !iRecipe.a((RecipeInput)craftingInput, (World)worldServer)) continue;
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
                if (atk.a(optional.orElse(null), itemStack)) continue;
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
            for (net.minecraft.world.item.ItemStack itemStack2 : atk.a(recipeItemStack)) {
                if (itemStack2.h() != itemStack.h() || itemStack2.d().d() != itemStack.d().d() || !(aiy.a(itemStack2) && aiy.a(itemStack) ? aiy.a(itemStack2, itemStack) : net.minecraft.world.item.ItemStack.c((net.minecraft.world.item.ItemStack)itemStack, (net.minecraft.world.item.ItemStack)itemStack2))) continue;
                return true;
            }
        } else {
            for (Holder holder : recipeItemStack.a().toList()) {
                if (!itemStack.a(holder) || aiy.a(itemStack)) continue;
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
        this.anf.remove(playerQuitEvent.getPlayer().getUniqueId());
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        this.amH.remove(inventoryCloseEvent.getPlayer().getUniqueId());
        this.anf.remove(inventoryCloseEvent.getPlayer().getUniqueId());
    }

    private static /* synthetic */ void a(Map map, Integer n, vj vj2) {
        if (vj2 == null || vj2.getItem() == null || vj2.getItem().getType() == Material.AIR) {
            map.put(n, true);
        } else {
            map.put(n, false);
        }
    }

    static {
        if (amu == null) {
            throw new RuntimeException("RecipeMap#byType not found! Try to update the server or downgrade it to a previous build.");
        }
        amv = zw.a(TileEntityFurnace.class, CraftingManager.a.class);
        amK = zw.b(TileEntityFurnace.class, CraftingManager.a.class, 0);
        if (amK == null) {
            new RuntimeException("Error getting fieldQuickCheck from AbstractFurnaceBlockEntity.").printStackTrace();
        }
    }
}
