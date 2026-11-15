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
import itemsadder.m.BlockNms_1_21_4_11;
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
import itemsadder.m.PacketListener_24;
import itemsadder.m.PacketListener_25;
import itemsadder.m.PlayerBridge_4;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerInventoryPlayerHolder;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
import itemsadder.m.VersionHelper;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
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
import net.minecraft.server.level.EntityPlayer;
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
import org.bukkit.craftbukkit.v1_21_R3.block.CraftFurnace;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R3.inventory.CraftInventoryCrafting;
import org.bukkit.craftbukkit.v1_21_R3.inventory.CraftRecipe;
import org.bukkit.craftbukkit.v1_21_R3.inventory.CraftShapedRecipe;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_4_18
extends PlayerQuitListenerBase
implements PluginContract {
    protected PacketAdapter amF;
    private final Map amX = new ConcurrentHashMap();
    Map amH = new ConcurrentHashMap();
    Map amI = new ConcurrentHashMap();
    Map amJ = new ConcurrentHashMap();
    static Field amu = VersionHelper_3.b(RecipeMap.class, Multimap.class, 0);
    static Field amv;
    static Field amw;
    Map amx = new Object2ObjectOpenHashMap();
    static Field amK;

    private static boolean a(RecipeHolder recipeHolder) {
        return recipeHolder.a().a().b().startsWith(PlayerQuitListenerBase.ami);
    }

    @Override
    public void register() {
        this.amm = new PacketListener_24(this, (Plugin)this.amj, ListenerPriority.LOWEST, PacketType.fromClass(ClientboundRecipeBookAddPacket.class));
        if (!VersionHelper.Va) {
            this.amF = new PacketListener_25(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)this.amj).listenerPriority(ListenerPriority.NORMAL).types(new PacketType[]{PacketType.fromClass(PacketPlayInAutoRecipe.class)}));
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
        if (this.amH.getOrDefault(player.getUniqueId(), recipeHolder.a().a()) != recipeHolder.a().a()) {
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
        this.amH.put(player.getUniqueId(), recipeHolder.a().a());
        if (namespacedKeyItemStackHolder instanceof ItemStackBridge_35) {
            object = (ItemStackBridge_35)namespacedKeyItemStackHolder;
            Map map = ((ItemStackBridge_35)object).rr();
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
            map.forEach((arg_0, arg_1) -> BlockNms_1_21_4_18.a((Map)object2ObjectOpenHashMap, arg_0, arg_1));
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
            PacketPlayOutAutoRecipe packetPlayOutAutoRecipe = new PacketPlayOutAutoRecipe(n, recipeDisplayEntry.b());
            PacketListenerRegistry.uN().d(player, packetPlayOutAutoRecipe);
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
    public void a(Player player, @NotNull NamespacedKey namespacedKey) {
        try {
            EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
            int n = entityPlayer.cd.l;
            Optional optional = MinecraftServer.getServer().aI().b(CraftRecipe.toMinecraft((NamespacedKey)namespacedKey));
            if (optional.isEmpty()) {
                return;
            }
            MinecraftServer.getServer().aI().a(((RecipeHolder)optional.get()).a(), (T recipeDisplayEntry) -> {
                PacketPlayOutAutoRecipe packetPlayOutAutoRecipe = new PacketPlayOutAutoRecipe(n, recipeDisplayEntry.b());
                PacketListenerRegistry.uN().d(player, packetPlayOutAutoRecipe);
            });
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void g(Set set) {
        CraftingManager craftingManager = MinecraftServer.getServer().aI();
        LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create(craftingManager.e.b);
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
            Set set = linkedHashMultimap.get(recipes);
            if (set.isEmpty()) continue;
            ArrayList<RecipeHolder> arrayList = new ArrayList<RecipeHolder>();
            ArrayList<RecipeHolder> arrayList2 = new ArrayList<RecipeHolder>();
            for (RecipeHolder recipeHolder : set) {
                if (BlockNms_1_21_4_18.a(recipeHolder)) {
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
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)craftFurnace.getTileEntity();
        CraftingManager.a a2 = (CraftingManager.a)VersionHelper_3.a(amv, tileEntityFurnace);
        if (amw == null) {
            amw = VersionHelper_3.a(a2.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        Object object = VersionHelper_3.a(amw, a2);
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
        TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)craftFurnace.getTileEntity();
        CraftingManager.a a2 = (CraftingManager.a)VersionHelper_3.a(amv, tileEntityFurnace);
        if (amw == null) {
            amw = VersionHelper_3.a(a2.getClass(), ResourceKey.class);
        }
        assert (amw != null);
        RecipeHolder recipeHolder = MinecraftServer.getServer().aI().b(CraftRecipe.toMinecraft((NamespacedKey)namespacedKey)).orElse(null);
        VersionHelper_3.a(amw, a2, (Object)(recipeHolder == null ? null : recipeHolder.a()));
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
            World world = craftPlayer.getHandle().dV();
            for (RecipeHolder recipeHolder : inventoryHolder.e.b.get(Recipes.a)) {
                IRecipe iRecipe = recipeHolder.b();
                if (BlockNms_1_21_4_18.a(recipeHolder) || !iRecipe.a((RecipeInput)craftingInput, world)) continue;
                return recipeHolder.a().a().toString();
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
                if (BlockNms_1_21_4_18.a(optional.orElse(null), itemStack)) continue;
                return false;
            }
        }
        return true;
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
            for (net.minecraft.world.item.ItemStack itemStack2 : recipeItemStack.itemStacks()) {
                if (itemStack2.h() != itemStack.h() || itemStack2.d().d() != itemStack.d().d() || !(BlockNms_1_21_4_11.a(itemStack2) && BlockNms_1_21_4_11.a(itemStack) ? BlockNms_1_21_4_11.a(itemStack2, itemStack) : net.minecraft.world.item.ItemStack.c((net.minecraft.world.item.ItemStack)itemStack, (net.minecraft.world.item.ItemStack)itemStack2))) continue;
                return true;
            }
        } else {
            for (Holder holder : recipeItemStack.a().toList()) {
                if (!itemStack.a(holder) || BlockNms_1_21_4_11.a(itemStack)) continue;
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
        this.amX.remove(playerQuitEvent.getPlayer().getUniqueId());
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        this.amH.remove(inventoryCloseEvent.getPlayer().getUniqueId());
        this.amX.remove(inventoryCloseEvent.getPlayer().getUniqueId());
    }

    private static /* synthetic */ void a(Map map, Integer n, RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2) {
        if (recipeChoiceItemStackHolder_2 == null || recipeChoiceItemStackHolder_2.getItem() == null || recipeChoiceItemStackHolder_2.getItem().getType() == Material.AIR) {
            map.put(n, true);
        } else {
            map.put(n, false);
        }
    }

    static {
        if (amu == null) {
            throw new RuntimeException("RecipeMap#byType not found! Try to update the server or downgrade it to a previous build.");
        }
        amv = VersionHelper_3.a(TileEntityFurnace.class, CraftingManager.a.class);
        amK = VersionHelper_3.b(TileEntityFurnace.class, CraftingManager.a.class, 0);
        if (amK == null) {
            new RuntimeException("Error getting fieldQuickCheck from AbstractFurnaceBlockEntity.").printStackTrace();
        }
    }
}
