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
import itemsadder.m.BlockNms_26_2_11;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.CrafterCraftListener;
import itemsadder.m.CraftingEnum;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_3;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_38;
import itemsadder.m.PacketListener_39;
import itemsadder.m.PlayerBridge_4;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerInventoryPlayerHolder;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
import itemsadder.m.VersionHelper;
import itemsadder.m.VersionHelper_3;
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
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundPlaceGhostRecipePacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.ServerboundPlaceRecipePacket;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.display.RecipeDisplayEntry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Furnace;
import org.bukkit.craftbukkit.block.CraftFurnace;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftBlastingRecipe;
import org.bukkit.craftbukkit.inventory.CraftFurnaceRecipe;
import org.bukkit.craftbukkit.inventory.CraftInventoryCrafting;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.craftbukkit.inventory.CraftRecipe;
import org.bukkit.craftbukkit.inventory.CraftShapedRecipe;
import org.bukkit.craftbukkit.inventory.CraftShapelessRecipe;
import org.bukkit.craftbukkit.inventory.CraftSmokingRecipe;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.inventory.recipe.CookingBookCategory;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockNms_26_2_18
extends PlayerQuitListenerBase
implements PluginContract {
    private static Method amE;
    protected PacketAdapter amF;
    private final Map anz = new ConcurrentHashMap();
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
        return recipeHolder.id().identifier().getNamespace().startsWith(PlayerQuitListenerBase.ami);
    }

    @Override
    public void register() {
        this.amm = new PacketListener_38(this, (Plugin)this.amj, ListenerPriority.LOWEST, PacketType.fromClass(ClientboundRecipeBookAddPacket.class));
        if (!VersionHelper.Va) {
            this.amF = new PacketListener_39(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)this.amj).listenerPriority(ListenerPriority.NORMAL).types(new PacketType[]{PacketType.fromClass(ServerboundPlaceRecipePacket.class)}));
            PacketListenerRegistry.b((PacketListener)this.amF);
        }
        this.vk();
        ListenerBridge.b(this, (Plugin)this.amj);
    }

    void a(Player player, CraftingInventory craftingInventory) {
        ItemStack[] itemStackArray = (ItemStack[])craftingInventory.getMatrix().clone();
        for (int i = 0; i <= 9; ++i) {
            craftingInventory.setItem(i, null);
        }
        ItemStackBridge_2.a(player, itemStackArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(int n, boolean bl, Player player, RecipeDisplayEntry recipeDisplayEntry, RecipeHolder recipeHolder, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        Object object = player.getOpenInventory().getTopInventory();
        if (!(object instanceof CraftingInventory)) {
            return;
        }
        CraftingInventory craftingInventory = (CraftingInventory)object;
        if (!this.amH.containsKey(player.getUniqueId())) {
            this.a(player, craftingInventory);
        }
        if (this.amH.getOrDefault(player.getUniqueId(), recipeHolder.id().identifier()) != recipeHolder.id().identifier()) {
            this.a(player, craftingInventory);
            object = this.amI.computeIfAbsent(player.getUniqueId(), uUID -> new PlayerBridge_4(player, bl ? 800 : 200, 750, 10));
            try {
                if (((PlayerBridge_4)object).Dr()) {
                    CommandSenderBridge_5.error("Player '" + player.getName() + "' is abusing the recipe book changing recipe too fast. Hacking?");
                    player.sendMessage(String.valueOf(ChatColor.RED) + "You are abusing the recipe book changing recipe too fast!");
                    player.closeInventory();
                    this.amJ.put(player.getUniqueId(), System.currentTimeMillis());
                    return;
                }
                if (((PlayerBridge_4)object).Dq()) {
                    return;
                }
            }
            finally {
                ((PlayerBridge_4)object).Dp();
            }
        }
        this.amH.put(player.getUniqueId(), recipeHolder.id().identifier());
        if (namespacedKeyItemStackHolder instanceof ItemStackBridge_35) {
            object = (ItemStackBridge_35)namespacedKeyItemStackHolder;
            Map map = ((ItemStackBridge_35)object).rr();
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
            map.forEach((arg_0, arg_1) -> BlockNms_26_2_18.a((Map)object2ObjectOpenHashMap, arg_0, arg_1));
            Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap();
            PlayerInventoryPlayerHolder playerInventoryPlayerHolder = new PlayerInventoryPlayerHolder(player);
            if (bl) {
                block4: for (int i = 0; i < playerInventoryPlayerHolder.Dd(); ++i) {
                    boolean bl2;
                    ItemStackBridge_3 itemStackBridge_3 = playerInventoryPlayerHolder.bJ(i);
                    if (itemStackBridge_3 == null || itemStackBridge_3.aAy) continue;
                    do {
                        bl2 = false;
                        if (itemStackBridge_3.De() - 1 <= 0) continue block4;
                        for (Map.Entry entry : map.entrySet()) {
                            RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 = (RecipeChoiceItemStackHolder_2)entry.getValue();
                            if (recipeChoiceItemStackHolder_2 == null) continue;
                            int n2 = (Integer)entry.getKey();
                            int n3 = n2 + 1;
                            ItemStack itemStack = (ItemStack)object2ObjectOpenHashMap2.get(n3);
                            if (recipeChoiceItemStackHolder_2.ny()) {
                                ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStackBridge_3.aAx);
                                if (itemStackBuilder_4 == null || itemStackBuilder_4.Gi != recipeChoiceItemStackHolder_2.MI) continue;
                                bl2 = true;
                                itemStackBridge_3.bH(1);
                                if (itemStack == null) {
                                    itemStack = itemStackBridge_3.aAx.clone();
                                    itemStack.setAmount(1);
                                    object2ObjectOpenHashMap2.put(n3, itemStack);
                                    object2ObjectOpenHashMap.put(n2, true);
                                    continue;
                                }
                                if (itemStack.getAmount() + 1 > ItemStackBridge_2.am(itemStack)) continue;
                                itemStack.setAmount(itemStack.getAmount() + 1);
                                continue;
                            }
                            if (!recipeChoiceItemStackHolder_2.rd().test(itemStackBridge_3.aAx)) continue;
                            bl2 = true;
                            itemStackBridge_3.bH(1);
                            if (itemStack == null) {
                                itemStack = itemStackBridge_3.aAx.clone();
                                itemStack.setAmount(1);
                                object2ObjectOpenHashMap2.put(n3, itemStack);
                                object2ObjectOpenHashMap.put(n2, true);
                                continue;
                            }
                            if (itemStack.getAmount() + 1 > ItemStackBridge_2.am(itemStack)) {
                                itemStackBridge_3.bK(0);
                                continue;
                            }
                            itemStack.setAmount(itemStack.getAmount() + 1);
                        }
                    } while (bl2);
                }
                this.a(player, playerInventoryPlayerHolder, craftingInventory, (Map)object2ObjectOpenHashMap, (Map)object2ObjectOpenHashMap2, n, recipeDisplayEntry);
            } else {
                block7: for (Map.Entry entry : map.entrySet()) {
                    ItemStack itemStack;
                    ItemStackBridge_3 itemStackBridge_3;
                    int n4;
                    RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 = (RecipeChoiceItemStackHolder_2)entry.getValue();
                    if (recipeChoiceItemStackHolder_2 == null) continue;
                    int n5 = (Integer)entry.getKey();
                    int n6 = n5 + 1;
                    if (recipeChoiceItemStackHolder_2.ny()) {
                        for (n4 = 0; n4 < playerInventoryPlayerHolder.Dd(); ++n4) {
                            ItemStackBuilder_4 itemStackBuilder_4;
                            itemStackBridge_3 = playerInventoryPlayerHolder.bJ(n4);
                            if (itemStackBridge_3 == null || itemStackBridge_3.aAy || (itemStackBuilder_4 = ItemStackRegistry.g().a(itemStackBridge_3.aAx)) == null || itemStackBuilder_4.Gi != recipeChoiceItemStackHolder_2.MI) continue;
                            itemStack = itemStackBridge_3.aAx.clone();
                            itemStack.setAmount(1);
                            object2ObjectOpenHashMap2.put(n6, itemStack);
                            object2ObjectOpenHashMap.put(n5, true);
                            continue block7;
                        }
                        continue;
                    }
                    for (n4 = 0; n4 < playerInventoryPlayerHolder.Dd(); ++n4) {
                        itemStackBridge_3 = playerInventoryPlayerHolder.bJ(n4);
                        if (itemStackBridge_3 == null || itemStackBridge_3.aAy || !recipeChoiceItemStackHolder_2.rd().test(itemStackBridge_3.aAx)) continue;
                        itemStack = itemStackBridge_3.aAx.clone();
                        itemStack.setAmount(1);
                        object2ObjectOpenHashMap2.put(n6, itemStack);
                        object2ObjectOpenHashMap.put(n5, true);
                        continue block7;
                    }
                }
                this.a(player, playerInventoryPlayerHolder, craftingInventory, (Map)object2ObjectOpenHashMap, (Map)object2ObjectOpenHashMap2, n, recipeDisplayEntry);
            }
        } else {
            CommandSenderBridge_5.error("Custom recipe type not supported, probably a bug: " + namespacedKeyItemStackHolder.getClass().getSimpleName());
        }
    }

    private void a(Player player, PlayerInventoryPlayerHolder playerInventoryPlayerHolder, CraftingInventory craftingInventory, Map map, Map map2, int n, RecipeDisplayEntry recipeDisplayEntry) {
        if (map.values().stream().allMatch(bl -> bl)) {
            playerInventoryPlayerHolder.applyChanges();
            for (Map.Entry entry : map2.entrySet()) {
                if (entry.getValue() == null) continue;
                craftingInventory.setItem(((Integer)entry.getKey()).intValue(), (ItemStack)entry.getValue());
            }
        } else {
            ClientboundPlaceGhostRecipePacket clientboundPlaceGhostRecipePacket = new ClientboundPlaceGhostRecipePacket(n, recipeDisplayEntry.display());
            PacketListenerRegistry.uN().d(player, clientboundPlaceGhostRecipePacket);
        }
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.vl();
        PacketListenerRegistry.c((PacketListener)this.amF);
        this.amx.clear();
    }

    @Override
    public Object f(NamespacedKey namespacedKey) {
        return MinecraftServer.getServer().getRecipeManager().byKey(BlockNms_26_2_18.i(namespacedKey)).orElse(null);
    }

    static /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @NotNull ResourceKey i(NamespacedKey namespacedKey) {
        return ResourceKey.create((ResourceKey)Registries.RECIPE, (Identifier)CraftNamespacedKey.toMinecraft((NamespacedKey)namespacedKey));
    }

    @Override
    public Object g(NamespacedKey namespacedKey) {
        return Identifier.parse((String)namespacedKey.toString());
    }

    @Override
    public void b(Player player, List list) {
        ((CraftPlayer)player).getHandle().awardRecipes((Collection)list);
    }

    @Override
    public void g(Set set) {
        RecipeManager recipeManager = MinecraftServer.getServer().getRecipeManager();
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(recipeManager.recipes.byType);
        boolean bl = false;
        for (CraftingEnum craftingEnum : CraftingEnum.values()) {
            RecipeType recipeType = switch (craftingEnum) {
                default -> throw new MatchException(null, null);
                case CraftingEnum.CRAFTING -> RecipeType.CRAFTING;
                case CraftingEnum.SMELTING -> RecipeType.SMELTING;
                case CraftingEnum.BLASTING -> RecipeType.BLASTING;
                case CraftingEnum.SMOKING -> RecipeType.SMOKING;
                case CraftingEnum.CAMPFIRE_COOKING -> RecipeType.CAMPFIRE_COOKING;
                case CraftingEnum.STONECUTTING -> RecipeType.STONECUTTING;
                case CraftingEnum.SMITHING -> RecipeType.SMITHING;
            };
            Set set2 = linkedHashMultimap.get(recipeType);
            if (set2.isEmpty()) continue;
            ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
            ArrayList<RecipeHolder> arrayList2 = new ArrayList<RecipeHolder>();
            for (RecipeHolder recipeHolder : set2) {
                if (set.contains(recipeHolder.id().identifier().getNamespace())) {
                    arrayList.add(recipeHolder);
                    continue;
                }
                arrayList2.add(recipeHolder);
            }
            if (arrayList.isEmpty()) continue;
            ArrayList arrayList3 = new ArrayList(set2.size());
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            linkedHashMultimap.replaceValues(recipeType, (Iterable)arrayList3);
            bl = true;
        }
        if (!bl) {
            return;
        }
        try {
            amu.set(recipeManager.recipes, linkedHashMultimap);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void vm() {
        RecipeManager recipeManager = MinecraftServer.getServer().getRecipeManager();
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(recipeManager.recipes.byType);
        boolean bl = false;
        for (CraftingEnum craftingEnum : CraftingEnum.values()) {
            RecipeType recipeType = switch (craftingEnum) {
                default -> throw new MatchException(null, null);
                case CraftingEnum.CRAFTING -> RecipeType.CRAFTING;
                case CraftingEnum.SMELTING -> RecipeType.SMELTING;
                case CraftingEnum.BLASTING -> RecipeType.BLASTING;
                case CraftingEnum.SMOKING -> RecipeType.SMOKING;
                case CraftingEnum.CAMPFIRE_COOKING -> RecipeType.CAMPFIRE_COOKING;
                case CraftingEnum.STONECUTTING -> RecipeType.STONECUTTING;
                case CraftingEnum.SMITHING -> RecipeType.SMITHING;
            };
            Set set = linkedHashMultimap.get(recipeType);
            if (set.isEmpty()) continue;
            ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
            ArrayList<RecipeHolder> arrayList2 = new ArrayList<RecipeHolder>();
            for (RecipeHolder recipeHolder : set) {
                if (BlockNms_26_2_18.a(recipeHolder)) {
                    arrayList.add(recipeHolder);
                    continue;
                }
                arrayList2.add(recipeHolder);
            }
            if (arrayList.isEmpty()) continue;
            ArrayList arrayList3 = new ArrayList(set.size());
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            linkedHashMultimap.replaceValues(recipeType, (Iterable)arrayList3);
            bl = true;
        }
        if (!bl) {
            return;
        }
        try {
            amu.set(recipeManager.recipes, linkedHashMultimap);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public NamespacedKey a(Furnace furnace) {
        CraftFurnace craftFurnace = (CraftFurnace)furnace;
        AbstractFurnaceBlockEntity abstractFurnaceBlockEntity = (AbstractFurnaceBlockEntity)craftFurnace.getBlockEntity();
        RecipeManager.CachedCheck cachedCheck = (RecipeManager.CachedCheck)VersionHelper_3.a(amv, abstractFurnaceBlockEntity);
        if (amw == null) {
            amw = VersionHelper_3.a(cachedCheck.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        Object object = VersionHelper_3.a(amw, cachedCheck);
        if (object instanceof ResourceKey) {
            ResourceKey resourceKey = (ResourceKey)object;
            object = MinecraftServer.getServer().getRecipeManager().byKey(resourceKey);
            if (((Optional)object).isPresent()) {
                return new NamespacedKey(resourceKey.identifier().getNamespace(), resourceKey.identifier().getPath());
            }
        }
        return null;
    }

    @Override
    public void a(Furnace furnace, NamespacedKey namespacedKey) {
        CraftFurnace craftFurnace = (CraftFurnace)furnace;
        AbstractFurnaceBlockEntity abstractFurnaceBlockEntity = (AbstractFurnaceBlockEntity)craftFurnace.getBlockEntity();
        RecipeManager.CachedCheck cachedCheck = (RecipeManager.CachedCheck)VersionHelper_3.a(amv, abstractFurnaceBlockEntity);
        if (amw == null) {
            amw = VersionHelper_3.a(cachedCheck.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        RecipeHolder recipeHolder = MinecraftServer.getServer().getRecipeManager().byKey(BlockNms_26_2_18.i(namespacedKey)).orElse(null);
        VersionHelper_3.a(amw, cachedCheck, (Object)(recipeHolder == null ? null : recipeHolder.id()));
    }

    @Override
    public Set h(Set set) {
        RecipeManager recipeManager = MinecraftServer.getServer().getRecipeManager();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (RecipeHolder recipeHolder : recipeManager.recipes.byType.get(RecipeType.CRAFTING)) {
            if (!set.contains(recipeHolder.id().identifier().getNamespace())) continue;
            objectOpenHashSet.add(recipeHolder.id().identifier().toString());
        }
        return objectOpenHashSet;
    }

    @Override
    public String c(CraftingInventory craftingInventory) {
        CraftInventoryCrafting craftInventoryCrafting = (CraftInventoryCrafting)craftingInventory;
        InventoryHolder inventoryHolder = craftInventoryCrafting.getInventory().getOwner();
        if (inventoryHolder instanceof CraftPlayer) {
            CraftPlayer craftPlayer = (CraftPlayer)inventoryHolder;
            inventoryHolder = MinecraftServer.getServer().getRecipeManager();
            CraftingInput craftingInput = craftInventoryCrafting.getMatrixInventory().asCraftInput();
            ServerLevel serverLevel = craftPlayer.getHandle().level();
            for (RecipeHolder recipeHolder : inventoryHolder.recipes.byType.get(RecipeType.CRAFTING)) {
                Recipe recipe = recipeHolder.value();
                if (BlockNms_26_2_18.a(recipeHolder) || !recipe.matches((RecipeInput)craftingInput, (Level)serverLevel)) continue;
                return recipeHolder.id().identifier().toString();
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
    public boolean e(org.bukkit.inventory.Recipe recipe) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        org.bukkit.inventory.ShapedRecipe shapedRecipe;
        int n;
        org.bukkit.inventory.Recipe recipe2;
        CraftRecipe craftRecipe;
        if (recipe instanceof SmithingRecipe) {
            Bukkit.addRecipe((org.bukkit.inventory.Recipe)recipe);
            return true;
        }
        if (recipe instanceof CraftRecipe) {
            craftRecipe = (CraftRecipe)recipe;
        } else {
            recipe2 = recipe;
            n = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{org.bukkit.inventory.ShapedRecipe.class, org.bukkit.inventory.ShapelessRecipe.class, FurnaceRecipe.class, BlastingRecipe.class, SmokingRecipe.class}, (Object)recipe2, n)) {
                case 0: {
                    shapedRecipe = (org.bukkit.inventory.ShapedRecipe)recipe2;
                    craftRecipe = CraftShapedRecipe.fromBukkitRecipe((org.bukkit.inventory.ShapedRecipe)shapedRecipe);
                    break;
                }
                case 1: {
                    object4 = (org.bukkit.inventory.ShapelessRecipe)recipe2;
                    craftRecipe = CraftShapelessRecipe.fromBukkitRecipe((org.bukkit.inventory.ShapelessRecipe)object4);
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
            craftRecipe.addToRecipeManager();
            return true;
        }
        org.bukkit.inventory.Recipe recipe3 = recipe;
        Objects.requireNonNull(recipe3);
        recipe2 = recipe3;
        n = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{org.bukkit.inventory.ShapedRecipe.class, org.bukkit.inventory.ShapelessRecipe.class, FurnaceRecipe.class, BlastingRecipe.class, SmokingRecipe.class}, (Object)recipe2, n)) {
            case 0: {
                shapedRecipe = (org.bukkit.inventory.ShapedRecipe)recipe2;
                object4 = shapedRecipe.getChoiceMap();
                object3 = BlockNms_26_2_18.a(shapedRecipe.getShape(), (Map)object4);
                object4.values().removeIf(Objects::isNull);
                object2 = Maps.transformValues(object4, recipeChoice -> BlockNms_26_2_18.a(craftRecipe, recipeChoice, false));
                MinecraftServer.getServer().getRecipeManager().recipes.addRecipe(new RecipeHolder(BlockNms_26_2_18.i(shapedRecipe.getKey()), (Recipe)new ShapedRecipe(new Recipe.CommonInfo(true), new CraftingRecipe.CraftingBookInfo(CraftRecipe.getCategory((CraftingBookCategory)shapedRecipe.getCategory()), shapedRecipe.getGroup()), ShapedRecipePattern.of((Map)object2, (String[])object3), ItemStackTemplate.fromNonEmptyStack((net.minecraft.world.item.ItemStack)CraftItemStack.asNMSCopy((ItemStack)shapedRecipe.getResult())))));
                break;
            }
            case 1: {
                object4 = (org.bukkit.inventory.ShapelessRecipe)recipe2;
                object3 = object4.getChoiceList();
                object2 = new ArrayList(object3.size());
                object = object3.iterator();
                while (object.hasNext()) {
                    RecipeChoice recipeChoice2 = (RecipeChoice)object.next();
                    object2.add(BlockNms_26_2_18.a(craftRecipe, recipeChoice2, true));
                }
                MinecraftServer.getServer().getRecipeManager().addRecipe(new RecipeHolder(BlockNms_26_2_18.i(object4.getKey()), (Recipe)new ShapelessRecipe(new Recipe.CommonInfo(true), new CraftingRecipe.CraftingBookInfo(CraftRecipe.getCategory((CraftingBookCategory)object4.getCategory()), object4.getGroup()), ItemStackTemplate.fromNonEmptyStack((net.minecraft.world.item.ItemStack)CraftItemStack.asNMSCopy((ItemStack)object4.getResult())), (List)object2)));
                break;
            }
            case 2: {
                object3 = (FurnaceRecipe)recipe2;
                object2 = object3.getResult();
                MinecraftServer.getServer().getRecipeManager().addRecipe(new RecipeHolder(BlockNms_26_2_18.i(object3.getKey()), (Recipe)new SmeltingRecipe(new Recipe.CommonInfo(true), new AbstractCookingRecipe.CookingBookInfo(CraftRecipe.getCategory((CookingBookCategory)object3.getCategory()), object3.getGroup()), BlockNms_26_2_18.a(craftRecipe, object3.getInputChoice(), true), ItemStackTemplate.fromNonEmptyStack((net.minecraft.world.item.ItemStack)CraftItemStack.asNMSCopy((ItemStack)object2)), object3.getExperience(), object3.getCookingTime())));
                break;
            }
            case 3: {
                object2 = (BlastingRecipe)recipe2;
                object = object2.getResult();
                MinecraftServer.getServer().getRecipeManager().addRecipe(new RecipeHolder(BlockNms_26_2_18.i(object2.getKey()), (Recipe)new net.minecraft.world.item.crafting.BlastingRecipe(new Recipe.CommonInfo(true), new AbstractCookingRecipe.CookingBookInfo(CraftRecipe.getCategory((CookingBookCategory)object2.getCategory()), object2.getGroup()), BlockNms_26_2_18.a(craftRecipe, object2.getInputChoice(), true), ItemStackTemplate.fromNonEmptyStack((net.minecraft.world.item.ItemStack)CraftItemStack.asNMSCopy((ItemStack)object)), object2.getExperience(), object2.getCookingTime())));
                break;
            }
            case 4: {
                object = (SmokingRecipe)recipe2;
                ItemStack itemStack = object.getResult();
                MinecraftServer.getServer().getRecipeManager().addRecipe(new RecipeHolder(BlockNms_26_2_18.i(object.getKey()), (Recipe)new net.minecraft.world.item.crafting.SmokingRecipe(new Recipe.CommonInfo(true), new AbstractCookingRecipe.CookingBookInfo(CraftRecipe.getCategory((CookingBookCategory)object.getCategory()), object.getGroup()), BlockNms_26_2_18.a(craftRecipe, object.getInputChoice(), true), ItemStackTemplate.fromNonEmptyStack((net.minecraft.world.item.ItemStack)CraftItemStack.asNMSCopy((ItemStack)itemStack)), object.getExperience(), object.getCookingTime())));
                break;
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + String.valueOf(recipe));
            }
        }
        return true;
    }

    static Ingredient a(CraftRecipe craftRecipe, RecipeChoice recipeChoice, boolean bl) {
        try {
            return (Ingredient)amE.invoke((Object)craftRecipe, recipeChoice, bl);
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
        ResourceKey resourceKey = BlockNms_26_2_18.i(namespacedKey);
        return MinecraftServer.getServer().getRecipeManager().recipes.removeRecipe(resourceKey);
    }

    @Override
    public void vo() {
        MinecraftServer.getServer().getPlayerList().reloadRecipes();
        MinecraftServer.getServer().getRecipeManager().finalizeRecipeLoading();
    }

    @Override
    public boolean a(org.bukkit.inventory.ShapedRecipe shapedRecipe, CraftingInventory craftingInventory) {
        CraftingContainer craftingContainer = ((CraftInventoryCrafting)craftingInventory).getMatrixInventory();
        ShapedRecipePattern shapedRecipePattern = this.amx.computeIfAbsent(shapedRecipe.getKey(), namespacedKey -> {
            CraftShapedRecipe craftShapedRecipe = (CraftShapedRecipe)Bukkit.getRecipe((NamespacedKey)shapedRecipe.getKey());
            assert (craftShapedRecipe != null);
            Map map = craftShapedRecipe.getChoiceMap();
            String[] stringArray = PlayerHolder_5.a(craftShapedRecipe.getShape(), map);
            map.values().removeIf(Objects::isNull);
            Map map2 = Maps.transformValues(map, recipeChoice -> BlockNms_26_2_18.a((CraftRecipe)craftShapedRecipe, recipeChoice, false));
            return ShapedRecipePattern.of(map2, (String[])stringArray);
        });
        List list = shapedRecipePattern.ingredients();
        for (int i = 0; i <= craftingContainer.getWidth() - shapedRecipePattern.width(); ++i) {
            for (int j = 0; j <= craftingContainer.getHeight() - shapedRecipePattern.height(); ++j) {
                if (this.a(craftingContainer, i, j, list, shapedRecipePattern.width(), shapedRecipePattern.height(), true)) {
                    return true;
                }
                if (!this.a(craftingContainer, i, j, list, shapedRecipePattern.width(), shapedRecipePattern.height(), false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean a(CraftingContainer craftingContainer, int n, int n2, List list, int n3, int n4, boolean bl) {
        for (int i = 0; i < craftingContainer.getWidth(); ++i) {
            for (int j = 0; j < craftingContainer.getHeight(); ++j) {
                int n5 = i - n;
                int n6 = j - n2;
                Optional optional = Optional.empty();
                int n7 = n6 * n3;
                if (n5 >= 0 && n6 >= 0 && n5 < n3 && n6 < n4) {
                    optional = bl ? (Optional)list.get(n3 - n5 - 1 + n7) : (Optional)list.get(n5 + n7);
                }
                net.minecraft.world.item.ItemStack itemStack = craftingContainer.getItem(i + j * craftingContainer.getWidth());
                if (BlockNms_26_2_18.a(optional.orElse(null), itemStack)) continue;
                return false;
            }
        }
        return true;
    }

    static Collection a(Ingredient ingredient) {
        try {
            Object object;
            if (amL == null) {
                amL = ingredient.getClass().getMethod("itemStacks", new Class[0]);
            }
            if ((object = amL.invoke((Object)ingredient, new Object[0])) instanceof Collection) {
                return (Collection)object;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return Collections.emptyList();
    }

    private static boolean a(@Nullable Ingredient ingredient, net.minecraft.world.item.ItemStack itemStack) {
        if (ingredient == null && itemStack == null) {
            return true;
        }
        if (ingredient == null) {
            return itemStack.isEmpty();
        }
        if (itemStack == null) {
            return false;
        }
        if (ingredient.isExact()) {
            for (net.minecraft.world.item.ItemStack itemStack2 : BlockNms_26_2_18.a(ingredient)) {
                if (itemStack2.getItem() != itemStack.getItem() || itemStack2.getComponentsPatch().isEmpty() != itemStack.getComponentsPatch().isEmpty() || !(BlockNms_26_2_11.a(itemStack2) && BlockNms_26_2_11.a(itemStack) ? BlockNms_26_2_11.a(itemStack2, itemStack) : net.minecraft.world.item.ItemStack.isSameItemSameComponents((net.minecraft.world.item.ItemStack)itemStack, (net.minecraft.world.item.ItemStack)itemStack2))) continue;
                return true;
            }
        } else {
            for (Holder holder : ingredient.items().toList()) {
                if (!itemStack.is(holder) || BlockNms_26_2_11.a(itemStack)) continue;
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
        this.anz.remove(playerQuitEvent.getPlayer().getUniqueId());
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        this.amH.remove(inventoryCloseEvent.getPlayer().getUniqueId());
        this.anz.remove(inventoryCloseEvent.getPlayer().getUniqueId());
    }

    private static /* synthetic */ void a(Map map, Integer n, RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2) {
        if (recipeChoiceItemStackHolder_2 == null || recipeChoiceItemStackHolder_2.getItem() == null || recipeChoiceItemStackHolder_2.getItem().getType() == Material.AIR) {
            map.put(n, true);
        } else {
            map.put(n, false);
        }
    }

    static {
        try {
            for (Method method : CraftRecipe.class.getMethods()) {
                Class<?>[] classArray;
                if (method.getReturnType() != Ingredient.class || (classArray = method.getParameterTypes()).length != 2 || !RecipeChoice.class.isAssignableFrom(classArray[0]) || classArray[1] != Boolean.TYPE) continue;
                method.setAccessible(true);
                amE = method;
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Failed to find CraftRecipe#toIngredient method, this is a bug, please report it.", exception);
            amE = null;
        }
        amu = VersionHelper_3.b(RecipeMap.class, Multimap.class, 0);
        if (amu == null) {
            throw new RuntimeException("RecipeMap#byType not found! Try to update the server or downgrade it to a previous build.");
        }
        amv = VersionHelper_3.a(AbstractFurnaceBlockEntity.class, RecipeManager.CachedCheck.class);
        amK = VersionHelper_3.b(AbstractFurnaceBlockEntity.class, RecipeManager.CachedCheck.class, 0);
        if (amK == null) {
            CommandSenderBridge_5.error("Failed to find quickCheck field from AbstractFurnaceBlockEntity.");
        }
    }
}
