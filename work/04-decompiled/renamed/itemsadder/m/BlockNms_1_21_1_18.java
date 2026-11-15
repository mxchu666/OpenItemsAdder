package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import itemsadder.m.BlockNms_1_21_1_11;
import itemsadder.m.CrafterCraftListener;
import itemsadder.m.CraftingEnum;
import itemsadder.m.HowFuckListener_2;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketListener_17;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.inventory.InventoryCrafting;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingManager;
import net.minecraft.world.item.crafting.IRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeItemStack;
import net.minecraft.world.item.crafting.Recipes;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.entity.TileEntityFurnace;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Furnace;
import org.bukkit.craftbukkit.v1_21_R1.block.CraftFurnace;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftInventoryCrafting;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftShapedRecipe;
import org.bukkit.craftbukkit.v1_21_R1.util.CraftNamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class BlockNms_1_21_1_18
extends PlayerQuitListenerBase
implements PluginContract {
    static Field amu = VersionHelper_3.b(CraftingManager.class, Multimap.class, 0);
    static Field amv;
    static Field amw;
    Map amx = new Object2ObjectOpenHashMap();

    private static boolean a(RecipeHolder recipeHolder) {
        return recipeHolder.a().b().startsWith(PlayerQuitListenerBase.ami);
    }

    @Override
    public void register() {
        this.aml = new HowFuckListener_2(this, (Plugin)this.amj, ListenerPriority.NORMAL, PacketType.Play.Server.RECIPE_UPDATE);
        this.amm = new PacketListener_17(this, (Plugin)this.amj, ListenerPriority.LOWEST, PacketType.Play.Server.RECIPES);
        this.vk();
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.vl();
        this.amx.clear();
    }

    @Override
    public Object f(NamespacedKey namespacedKey) {
        CraftingManager craftingManager = MinecraftServer.getServer().aJ();
        Optional optional = craftingManager.a(CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey));
        return optional.orElse(null);
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
        CraftingManager craftingManager = MinecraftServer.getServer().aJ();
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(craftingManager.d);
        boolean bl = false;
        for (CraftingEnum craftingEnum : CraftingEnum.values()) {
            Recipes recipes = switch (craftingEnum) {
                default -> throw new MatchException(null, null);
                case CraftingEnum.CRAFTING -> Recipes.a;
                case CraftingEnum.SMELTING -> Recipes.b;
                case CraftingEnum.BLASTING -> Recipes.c;
                case CraftingEnum.SMOKING -> Recipes.d;
                case CraftingEnum.CAMPFIRE_COOKING -> Recipes.e;
                case CraftingEnum.STONECUTTING -> Recipes.f;
                case CraftingEnum.SMITHING -> Recipes.g;
            };
            Set set2 = linkedHashMultimap.get(recipes);
            if (set2.isEmpty()) continue;
            ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
            ArrayList<RecipeHolder> arrayList2 = new ArrayList<RecipeHolder>();
            for (RecipeHolder recipeHolder : set2) {
                if (set.contains(recipeHolder.a().a())) {
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
            amu.set(craftingManager, linkedHashMultimap);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void vm() {
        for (CraftingEnum craftingEnum : CraftingEnum.values()) {
            Recipes recipes = switch (craftingEnum) {
                default -> throw new MatchException(null, null);
                case CraftingEnum.CRAFTING -> Recipes.a;
                case CraftingEnum.SMELTING -> Recipes.b;
                case CraftingEnum.BLASTING -> Recipes.c;
                case CraftingEnum.SMOKING -> Recipes.d;
                case CraftingEnum.CAMPFIRE_COOKING -> Recipes.e;
                case CraftingEnum.STONECUTTING -> Recipes.f;
                case CraftingEnum.SMITHING -> Recipes.g;
            };
            CraftingManager craftingManager = MinecraftServer.getServer().aJ();
            Collection collection = craftingManager.d.get(recipes);
            List<RecipeHolder> list = collection.stream().filter(BlockNms_1_21_1_18::a).toList();
            if (list.isEmpty()) continue;
            LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(craftingManager.d);
            for (RecipeHolder recipeHolder : list) {
                linkedHashMultimap.put(recipes, recipeHolder);
                LinkedList<RecipeHolder> linkedList = new LinkedList<RecipeHolder>(linkedHashMultimap.get(recipes));
                linkedList.addFirst(recipeHolder);
                linkedHashMultimap.replaceValues(recipes, linkedList);
                craftingManager.d = linkedHashMultimap;
            }
        }
    }

    @Override
    public NamespacedKey a(Furnace furnace) {
        CraftFurnace craftFurnace = (CraftFurnace)furnace;
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)craftFurnace.getTileEntity();
        CraftingManager.a a2 = (CraftingManager.a)VersionHelper_3.a(amv, tileEntityFurnace);
        if (amw == null) {
            amw = VersionHelper_3.a(a2.getClass(), MinecraftKey.class);
        }
        assert (amw != null);
        Object object = VersionHelper_3.a(amw, a2);
        if (object instanceof MinecraftKey) {
            MinecraftKey minecraftKey = (MinecraftKey)object;
            object = MinecraftServer.getServer().aJ().a(minecraftKey);
            if (((Optional)object).isPresent()) {
                return new NamespacedKey(minecraftKey.b(), minecraftKey.a());
            }
        }
        return null;
    }

    @Override
    public void a(Furnace furnace, NamespacedKey namespacedKey) {
        CraftFurnace craftFurnace = (CraftFurnace)furnace;
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)craftFurnace.getTileEntity();
        CraftingManager.a a2 = (CraftingManager.a)VersionHelper_3.a(amv, tileEntityFurnace);
        if (amw == null) {
            amw = VersionHelper_3.a(a2.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        RecipeHolder recipeHolder = (RecipeHolder)this.f(namespacedKey);
        VersionHelper_3.a(amw, a2, (Object)(recipeHolder == null ? null : recipeHolder.a()));
    }

    @Override
    public Set h(Set set) {
        CraftingManager craftingManager = MinecraftServer.getServer().aJ();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (RecipeHolder recipeHolder : craftingManager.d.get(Recipes.a)) {
            if (!set.contains(recipeHolder.a().b())) continue;
            objectOpenHashSet.add(recipeHolder.a().toString());
        }
        return objectOpenHashSet;
    }

    @Override
    public String c(CraftingInventory craftingInventory) {
        CraftInventoryCrafting craftInventoryCrafting = (CraftInventoryCrafting)craftingInventory;
        InventoryHolder inventoryHolder = craftInventoryCrafting.getInventory().getOwner();
        if (inventoryHolder instanceof CraftPlayer) {
            CraftPlayer craftPlayer = (CraftPlayer)inventoryHolder;
            inventoryHolder = MinecraftServer.getServer().aJ();
            CraftingInput craftingInput = craftInventoryCrafting.getMatrixInventory().aE_();
            World world = craftPlayer.getHandle().dO();
            for (RecipeHolder recipeHolder : inventoryHolder.d.get(Recipes.a)) {
                IRecipe iRecipe = recipeHolder.b();
                if (recipeHolder.a().b().startsWith(PlayerQuitListenerBase.ami) || !iRecipe.a((RecipeInput)craftingInput, world)) continue;
                return recipeHolder.a().toString();
            }
        }
        return null;
    }

    @Override
    public void vn() {
        CrafterCraftListener crafterCraftListener = new CrafterCraftListener();
        ListenerBridge.a(crafterCraftListener, (Plugin)this.amj);
    }

    @Override
    public boolean a(ShapedRecipe shapedRecipe, CraftingInventory craftingInventory) {
        InventoryCrafting inventoryCrafting = ((CraftInventoryCrafting)craftingInventory).getMatrixInventory();
        ShapedRecipePattern shapedRecipePattern = this.amx.computeIfAbsent(shapedRecipe.getKey(), namespacedKey -> {
            CraftShapedRecipe craftShapedRecipe = (CraftShapedRecipe)Bukkit.getRecipe((NamespacedKey)shapedRecipe.getKey());
            assert (craftShapedRecipe != null);
            Map map = craftShapedRecipe.getChoiceMap();
            String[] stringArray = PlayerHolder_5.a(craftShapedRecipe.getShape(), map);
            map.values().removeIf(Objects::isNull);
            Map map2 = Maps.transformValues(map, recipeChoice -> craftShapedRecipe.toNMS(recipeChoice, false));
            return ShapedRecipePattern.a(map2, (String[])stringArray);
        });
        NonNullList nonNullList = shapedRecipePattern.c();
        for (int i = 0; i <= inventoryCrafting.f() - shapedRecipePattern.a(); ++i) {
            for (int j = 0; j <= inventoryCrafting.g() - shapedRecipePattern.b(); ++j) {
                if (this.a(inventoryCrafting, i, j, nonNullList, shapedRecipePattern.a(), shapedRecipePattern.b(), true)) {
                    return true;
                }
                if (!this.a(inventoryCrafting, i, j, nonNullList, shapedRecipePattern.a(), shapedRecipePattern.b(), false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean a(InventoryCrafting inventoryCrafting, int n, int n2, NonNullList nonNullList, int n3, int n4, boolean bl) {
        for (int i = 0; i < inventoryCrafting.f(); ++i) {
            for (int j = 0; j < inventoryCrafting.g(); ++j) {
                ItemStack itemStack;
                int n5 = i - n;
                int n6 = j - n2;
                RecipeItemStack recipeItemStack = RecipeItemStack.a;
                int n7 = n6 * n3;
                if (n5 >= 0 && n6 >= 0 && n5 < n3 && n6 < n4) {
                    recipeItemStack = bl ? (RecipeItemStack)nonNullList.get(n3 - n5 - 1 + n7) : (RecipeItemStack)nonNullList.get(n5 + n7);
                }
                if (BlockNms_1_21_1_18.a(recipeItemStack, itemStack = inventoryCrafting.a(i + j * inventoryCrafting.f()))) continue;
                return false;
            }
        }
        return true;
    }

    private static boolean a(RecipeItemStack recipeItemStack, ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (recipeItemStack.c()) {
            return itemStack.e();
        }
        int n = 0;
        ItemStack[] itemStackArray = recipeItemStack.a();
        ItemStack[] itemStackArray2 = itemStackArray;
        int n2 = itemStackArray2.length;
        if (n < n2) {
            ItemStack itemStack2 = itemStackArray2[n];
            if (itemStack2.g() != itemStack.g()) {
                return false;
            }
            if (itemStack2.d().d() != itemStack.d().d()) {
                return false;
            }
            if (BlockNms_1_21_1_11.a(itemStack2) && BlockNms_1_21_1_11.a(itemStack)) {
                return BlockNms_1_21_1_11.a(itemStack2, itemStack);
            }
            return ItemStack.c((ItemStack)itemStack2, (ItemStack)itemStack);
        }
        return false;
    }

    static /* synthetic */ HashMap a(BlockNms_1_21_1_18 blockNms_1_21_1_18) {
        return blockNms_1_21_1_18.amq;
    }

    static /* synthetic */ HashMap b(BlockNms_1_21_1_18 blockNms_1_21_1_18) {
        return blockNms_1_21_1_18.amq;
    }

    static /* synthetic */ HashMap c(BlockNms_1_21_1_18 blockNms_1_21_1_18) {
        return blockNms_1_21_1_18.amq;
    }

    static {
        if (amu == null) {
            throw new RuntimeException("RecipeManager#byType not found! Try to update the server or downgrade it to a previous build.");
        }
        amv = VersionHelper_3.a(TileEntityFurnace.class, CraftingManager.a.class);
    }
}
