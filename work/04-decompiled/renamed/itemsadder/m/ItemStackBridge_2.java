package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import beer.devs.fastnbt.nms.nbt.NBT;
import beer.devs.fastnbt.nms.nbt.NItem;
import itemsadder.m.ColorBridge;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.VersionHelper;
import java.lang.runtime.SwitchBootstraps;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemStackBridge_2 {
    public static ItemStack aAp = new ItemStack(Material.AIR);
    public static EquipmentSlot[] aAq = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    public static EquipmentSlot[] aAr = new EquipmentSlot[]{EquipmentSlot.HAND, EquipmentSlot.OFF_HAND, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static boolean i(InventoryClickEvent inventoryClickEvent) {
        return inventoryClickEvent.getRawSlot() < inventoryClickEvent.getView().getTopInventory().getSize();
    }

    public static boolean cx(Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

    public static boolean ae(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        return ItemStackBridge_2.U(itemStack.getType());
    }

    public static boolean U(Material material) {
        if (material == null || material == Material.AIR) {
            return false;
        }
        switch (material) {
            case NETHERITE_SWORD: 
            case NETHERITE_AXE: 
            case NETHERITE_HOE: 
            case NETHERITE_SHOVEL: 
            case NETHERITE_PICKAXE: 
            case DIAMOND_SWORD: 
            case IRON_SWORD: 
            case GOLDEN_SWORD: 
            case STONE_SWORD: 
            case WOODEN_SWORD: 
            case DIAMOND_AXE: 
            case IRON_AXE: 
            case GOLDEN_AXE: 
            case STONE_AXE: 
            case WOODEN_AXE: 
            case DIAMOND_HOE: 
            case IRON_HOE: 
            case GOLDEN_HOE: 
            case STONE_HOE: 
            case WOODEN_HOE: 
            case DIAMOND_SHOVEL: 
            case IRON_SHOVEL: 
            case GOLDEN_SHOVEL: 
            case STONE_SHOVEL: 
            case WOODEN_SHOVEL: 
            case DIAMOND_PICKAXE: 
            case IRON_PICKAXE: 
            case GOLDEN_PICKAXE: 
            case STONE_PICKAXE: 
            case WOODEN_PICKAXE: {
                return true;
            }
        }
        if (Version.isAtLeast((Version)Version.v1_21)) {
            if (material == Material.MACE) {
                return true;
            }
            if (Version.isAtLeast((Version)Version.v1_21_10)) {
                String string = material.toString();
                return string.equals("COPPER_SWORD") || string.equals("COPPER_PICKAXE") || string.equals("COPPER_AXE") || string.equals("COPPER_HOE") || string.equals("COPPER_SHOVEL");
            }
        }
        return false;
    }

    public static boolean V(Material material) {
        return EnchantmentTarget.ARMOR.includes(material);
    }

    public static boolean W(Material material) {
        return material.toString().endsWith("_HEAD");
    }

    public static boolean af(ItemStack itemStack) {
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasEnchants()) {
            return false;
        }
        return itemStack.getEnchantments().containsKey(Enchantment.SILK_TOUCH);
    }

    public static boolean a(ItemStack itemStack, Enchantment enchantment) {
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasEnchants()) {
            return false;
        }
        return itemStack.getItemMeta().hasEnchant(enchantment);
    }

    public static int b(ItemStack itemStack, Enchantment enchantment) {
        return itemStack.getItemMeta().getEnchantLevel(enchantment);
    }

    public static boolean c(ItemStack itemStack, Enchantment enchantment) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        boolean bl = itemMeta.removeEnchant(enchantment);
        itemStack.setItemMeta(itemMeta);
        return bl;
    }

    public static void h(ItemStack itemStack, ItemStack itemStack2) {
        NItem nItem = new NItem(itemStack2);
        NItem nItem2 = new NItem(itemStack);
        nItem2.merge(nItem);
        nItem2.save();
    }

    public static void g(ItemStack itemStack, String string) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(string);
        itemStack.setItemMeta(itemMeta);
    }

    public static void a(ItemStack itemStack, Component component) {
        NItem nItem = new NItem(itemStack);
        ItemStackBridge_2.a(nItem, component);
    }

    public static void a(NItem nItem, Component component) {
        nItem.setCustomName(PluginBridge_6.p(component));
        nItem.save();
    }

    @Nullable
    public static String ag(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        return nItem.getCustomNameJson();
    }

    @Nullable
    public static Component ah(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        Object object = nItem.getCustomName();
        if (object == null) {
            object = nItem.getItemName();
        }
        if (object == null) {
            return null;
        }
        return PluginBridge_6.F(object);
    }

    public static void b(ItemStackBuilder_4 itemStackBuilder_4, ItemStackBuilder_4 itemStackBuilder_42) {
        ItemStack itemStack = NBT.item.convertToCraft((ItemStack)itemStackBuilder_4);
        NBT.dataComponents.copyLore(NBT.item.convertToCraft((ItemStack)itemStackBuilder_42), itemStack);
        itemStackBuilder_4.na();
    }

    public static void a(NItem nItem, List list) {
        NBT.dataComponents.appendLoreJson(nItem.getItem(), list);
        nItem.save();
    }

    public static void d(ItemStack itemStack, @NotNull List list) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(list);
        itemStack.setItemMeta(itemMeta);
    }

    public static void e(ItemStack itemStack, List list) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLoreComponents(list);
        itemStack.setItemMeta(itemMeta);
    }

    public static ItemStack b(ItemStack itemStack, Color color) {
        PotionMeta potionMeta = (PotionMeta)itemStack.getItemMeta();
        potionMeta.setColor(color);
        itemStack.setItemMeta((ItemMeta)potionMeta);
        return itemStack;
    }

    public static ItemStack ai(ItemStack itemStack) {
        return ItemStackBridge_2.b(itemStack, null);
    }

    public static void cy(Player player) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.AIR || itemStack.getAmount() <= 0 || itemStack.getAmount() - 1 < 0) {
            return;
        }
        itemStack.setAmount(itemStack.getAmount() - 1);
    }

    public static void cz(Player player) {
        ItemStack itemStack = player.getInventory().getItemInOffHand();
        if (itemStack.getType() == Material.AIR || itemStack.getAmount() <= 0 || itemStack.getAmount() - 1 < 0) {
            return;
        }
        itemStack.setAmount(itemStack.getAmount() - 1);
    }

    public static ItemStack h(ItemStack itemStack, int n) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return itemStack;
        }
        itemStack.setAmount(itemStack.getAmount() - n);
        return itemStack;
    }

    public static int aj(ItemStack itemStack) {
        return ItemStackBridge_2.i(itemStack, 1);
    }

    public static int i(ItemStack itemStack, int n) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return 0;
        }
        itemStack.setAmount(itemStack.getAmount() - n);
        return itemStack.getAmount();
    }

    public static void b(Player player, EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.OFF_HAND) {
            ItemStackBridge_2.cz(player);
        } else {
            ItemStackBridge_2.cy(player);
        }
    }

    public static void ak(ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR || itemStack.getAmount() <= 0 || itemStack.getAmount() + 1 > itemStack.getType().getMaxStackSize()) {
            return;
        }
        itemStack.setAmount(itemStack.getAmount() + 1);
    }

    public static int al(ItemStack itemStack) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return 0;
        }
        Damageable damageable = (Damageable)itemMeta;
        return ItemStackBridge_2.E(itemStack) - damageable.getDamage();
    }

    public static int E(ItemStack itemStack) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return 0;
        }
        Damageable damageable = (Damageable)itemMeta;
        return ItemStackBridge_2.a(damageable, itemStack.getType());
    }

    public static int a(Damageable damageable, Material material) {
        if (damageable.hasMaxDamage()) {
            return damageable.getMaxDamage();
        }
        return material.getMaxDurability();
    }

    public static int am(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.hasMaxStackSize()) {
            return itemMeta.getMaxStackSize();
        }
        return itemStack.getType().getMaxStackSize();
    }

    public static void d(ItemStack itemStack, int n) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return;
        }
        Damageable damageable = (Damageable)itemMeta;
        if (n > ItemStackBridge_2.E(itemStack)) {
            n = ItemStackBridge_2.E(itemStack);
        }
        damageable.setDamage(ItemStackBridge_2.E(itemStack) - n);
        itemStack.setItemMeta((ItemMeta)damageable);
    }

    public static void e(ItemStack itemStack, int n) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return;
        }
        Damageable damageable = (Damageable)itemMeta;
        if (damageable.getDamage() - n < 0) {
            damageable.setDamage(0);
            itemStack.setItemMeta((ItemMeta)damageable);
            return;
        }
        damageable.setDamage(damageable.getDamage() - n);
        itemStack.setItemMeta((ItemMeta)damageable);
    }

    public static void f(ItemStack itemStack, int n) {
        ItemStackBridge_2.b(itemStack, n, false);
    }

    public static void b(ItemStack itemStack, int n, boolean bl) {
        ItemStackBridge_2.a(itemStack, n, bl, false);
    }

    public static void a(ItemStack itemStack, int n, boolean bl, boolean bl2) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return;
        }
        Damageable damageable = (Damageable)itemMeta;
        if (bl && !ItemStackBridge_2.ao(itemStack)) {
            return;
        }
        if (damageable.getDamage() + n > ItemStackBridge_2.a(damageable, itemStack.getType())) {
            damageable.setDamage(ItemStackBridge_2.a(damageable, itemStack.getType()));
            return;
        }
        damageable.setDamage(damageable.getDamage() + n);
        if (bl2 && damageable.getDamage() >= ItemStackBridge_2.a(damageable, itemStack.getType())) {
            itemStack.setAmount(itemStack.getAmount() - 1);
            damageable.setDamage(0);
        }
        itemStack.setItemMeta((ItemMeta)damageable);
    }

    public static void c(ItemStack itemStack, int n) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return;
        }
        Damageable damageable = (Damageable)itemMeta;
        damageable.setMaxDamage(Integer.valueOf(n));
        itemStack.setItemMeta((ItemMeta)damageable);
    }

    public static void c(ItemStackBuilder_4 itemStackBuilder_4, boolean bl) {
        ItemMeta itemMeta;
        if (itemStackBuilder_4 == null || !((itemMeta = itemStackBuilder_4.getItemMeta()) instanceof Damageable)) {
            return;
        }
        Damageable damageable = (Damageable)itemMeta;
        damageable.setUnbreakable(bl);
        itemStackBuilder_4.setItemMeta((ItemMeta)damageable);
    }

    public static ItemStack an(ItemStack itemStack) {
        ItemMeta itemMeta;
        if (itemStack == null || !((itemMeta = itemStack.getItemMeta()) instanceof Damageable)) {
            return itemStack;
        }
        Damageable damageable = (Damageable)itemMeta;
        damageable.setDamage(0);
        itemStack.setItemMeta((ItemMeta)damageable);
        return itemStack;
    }

    public static boolean G(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (!(itemMeta instanceof Damageable)) {
            return false;
        }
        Damageable damageable = (Damageable)itemMeta;
        int n = ItemStackBridge_2.a(damageable, itemStack.getType());
        if (n <= 0) {
            return false;
        }
        return damageable.getDamage() > n;
    }

    public static boolean ao(ItemStack itemStack) {
        if (itemStack.getItemMeta().hasEnchant(Enchantment.UNBREAKING)) {
            return ItemStackBridge_2.bE(itemStack.getItemMeta().getEnchantLevel(Enchantment.UNBREAKING));
        }
        return true;
    }

    public static boolean bE(int n) {
        return ColorBridge.v(1, 1 + n) == 1;
    }

    public static ItemStack cA(Player player) {
        return player.getInventory().getItemInMainHand();
    }

    public static void f(Player player, ItemStack itemStack) {
        ItemStackBridge_2.b(player, itemStack);
    }

    public static void a(Player player, ItemStack ... itemStackArray) {
        for (ItemStack itemStack : itemStackArray) {
            if (itemStack == null) continue;
            ItemStackBridge_2.f(player, itemStack);
        }
    }

    public static void g(Player player, ItemStack itemStack) {
        if (itemStack != null) {
            ItemStackBridge_2.f(player, itemStack);
        }
    }

    public static void b(Player player, ItemStack ... itemStackArray) {
        player.getInventory().addItem(itemStackArray).forEach((n, itemStack) -> {
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                return;
            }
            Item item = player.getWorld().dropItem(player.getLocation(), itemStack);
            try {
                item.setOwner(player.getUniqueId());
            }
            catch (NoSuchMethodError noSuchMethodError) {
                // empty catch block
            }
            item.setPickupDelay(0);
        });
    }

    public static boolean X(Material material) {
        return material.getMaxDurability() > 0;
    }

    public static boolean ap(ItemStack itemStack) {
        if (itemStack.getType().getMaxDurability() > 0) {
            return true;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta instanceof Damageable) {
            Damageable damageable = (Damageable)itemMeta;
            return damageable.hasMaxDamage();
        }
        return false;
    }

    public static String a(ItemStack itemStack, net.md_5.bungee.api.ChatColor chatColor) {
        if (itemStack == null) {
            return null;
        }
        String string = "";
        if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            string = itemStack.getItemMeta().getDisplayName();
        } else {
            try {
                string = itemStack.getI18NDisplayName();
            }
            catch (NoSuchMethodError noSuchMethodError) {
                string = WordUtils.capitalizeFully((String)itemStack.getType().toString()).replace("_", " ");
            }
        }
        if (string.startsWith(ChatColor.WHITE.toString())) {
            return ChatColor.stripColor((String)string);
        }
        return string;
    }

    public static String a(ItemStack itemStack, ChatColor chatColor) {
        return ItemStackBridge_2.h(itemStack, chatColor.toString());
    }

    public static String h(ItemStack itemStack, String string) {
        Object object = "";
        if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            object = string + itemStack.getItemMeta().getDisplayName();
        } else {
            try {
                object = string + itemStack.getI18NDisplayName();
            }
            catch (NoSuchMethodError noSuchMethodError) {
                object = string + WordUtils.capitalizeFully((String)itemStack.getType().toString()).replace("_", " ");
            }
        }
        return object;
    }

    public static String Y(Material material) {
        Object object = "";
        try {
            object = new ItemStack(material).getI18NDisplayName();
        }
        catch (NoSuchMethodError noSuchMethodError) {
            object = String.valueOf(ChatColor.GRAY) + WordUtils.capitalizeFully((String)material.toString()).replace("_", " ");
        }
        return object;
    }

    public static String Z(Material material) {
        return String.format(String.format("%s.minecraft.%%s", material.isBlock() ? "block" : "item"), material.toString().toLowerCase());
    }

    public static double aa(Material material) {
        if (Version.isAtLeast((Version)Version.v1_21)) {
            if (material == Material.MACE) {
                return 6.0;
            }
            if (Version.isAtLeast((Version)Version.v1_21_10)) {
                String string;
                switch (string = material.toString()) {
                    case "COPPER_SWORD": {
                        return 5.0;
                    }
                    case "COPPER_PICKAXE": {
                        return 3.0;
                    }
                    case "COPPER_AXE": {
                        return 9.0;
                    }
                    case "COPPER_HOE": {
                        return 1.0;
                    }
                    case "COPPER_SHOVEL": {
                        return 3.5;
                    }
                }
            }
        }
        return switch (material) {
            case Material.NETHERITE_SWORD -> 8.0;
            case Material.NETHERITE_AXE -> 7.0;
            case Material.NETHERITE_HOE -> 6.0;
            case Material.NETHERITE_SHOVEL -> 6.0;
            case Material.NETHERITE_PICKAXE -> 6.0;
            case Material.WOODEN_SWORD -> 4.0;
            case Material.GOLDEN_SWORD -> 4.0;
            case Material.STONE_SWORD -> 5.0;
            case Material.IRON_SWORD -> 6.0;
            case Material.DIAMOND_SWORD -> 7.0;
            case Material.WOODEN_SHOVEL -> 2.5;
            case Material.GOLDEN_SHOVEL -> 2.5;
            case Material.STONE_SHOVEL -> 3.5;
            case Material.IRON_SHOVEL -> 4.5;
            case Material.DIAMOND_SHOVEL -> 5.5;
            case Material.WOODEN_PICKAXE -> 2.0;
            case Material.GOLDEN_PICKAXE -> 2.0;
            case Material.STONE_PICKAXE -> 3.0;
            case Material.IRON_PICKAXE -> 4.0;
            case Material.DIAMOND_PICKAXE -> 5.0;
            case Material.WOODEN_AXE -> 7.0;
            case Material.GOLDEN_AXE -> 7.0;
            case Material.STONE_AXE -> 9.0;
            case Material.IRON_AXE -> 9.0;
            case Material.DIAMOND_AXE -> 9.0;
            case Material.DIAMOND_HOE, Material.IRON_HOE, Material.GOLDEN_HOE, Material.STONE_HOE, Material.WOODEN_HOE -> 1.0;
            case Material.TRIDENT -> 9.0;
            default -> 1.0;
        };
    }

    public static boolean ip(String string) {
        try {
            Material.valueOf((String)string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static boolean q(PlayerInteractEvent playerInteractEvent) {
        return playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND;
    }

    public static boolean d(PlayerInteractEntityEvent playerInteractEntityEvent) {
        return playerInteractEntityEvent.getHand() == EquipmentSlot.OFF_HAND;
    }

    public static boolean ab(Material material) {
        switch (material) {
            case OAK_LOG: 
            case SPRUCE_LOG: 
            case BIRCH_LOG: 
            case JUNGLE_LOG: 
            case ACACIA_LOG: 
            case DARK_OAK_LOG: 
            case CRIMSON_STEM: 
            case WARPED_STEM: {
                return true;
            }
        }
        return false;
    }

    public static boolean ac(Material material) {
        switch (material) {
            case OAK_LEAVES: 
            case SPRUCE_LEAVES: 
            case BIRCH_LEAVES: 
            case JUNGLE_LEAVES: 
            case ACACIA_LEAVES: 
            case DARK_OAK_LEAVES: 
            case NETHER_WART_BLOCK: 
            case WARPED_WART_BLOCK: {
                return true;
            }
        }
        return false;
    }

    public static void j(BlockPlaceEvent blockPlaceEvent) {
        if (blockPlaceEvent.getHand() == EquipmentSlot.OFF_HAND) {
            ItemStackBridge_2.cz(blockPlaceEvent.getPlayer());
        } else {
            ItemStackBridge_2.cy(blockPlaceEvent.getPlayer());
        }
    }

    @Nullable
    public static ItemStack c(Projectile projectile) {
        return EntityHolder.c(projectile);
    }

    public static boolean aq(ItemStack itemStack) {
        return switch (itemStack.getType()) {
            case Material.TRIDENT, Material.EXPERIENCE_BOTTLE, Material.EGG, Material.ENDER_PEARL, Material.SPLASH_POTION, Material.SNOWBALL -> true;
            default -> false;
        };
    }

    public static void h(@Nullable Player player, ItemStack itemStack) {
        if (player != null) {
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 10.0f, 1.0f);
            player.getWorld().spawnParticle(Particle.ITEM, player.getLocation().add(player.getLocation().getDirection()).add(0.0, 0.5, 0.0), 10, 0.3, 0.5, 0.3, 0.1, (Object)itemStack);
        }
    }

    public static void a(Location location, ItemStack itemStack) {
        location = location.clone();
        location.getWorld().playSound(location, Sound.ENTITY_ITEM_BREAK, 10.0f, 1.0f);
        location.getWorld().spawnParticle(Particle.ITEM, location.add(location.getDirection()).add(0.0, 0.5, 0.0), 10, 0.3, 0.5, 0.3, 0.1, (Object)itemStack);
    }

    public static float ar(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR) {
            return 1.0f;
        }
        return switch (itemStack.getType()) {
            case Material.NETHERITE_SWORD, Material.NETHERITE_AXE, Material.NETHERITE_HOE, Material.NETHERITE_SHOVEL, Material.NETHERITE_PICKAXE -> 9.0f;
            case Material.WOODEN_SWORD, Material.WOODEN_AXE, Material.WOODEN_HOE, Material.WOODEN_SHOVEL, Material.WOODEN_PICKAXE -> 2.0f;
            case Material.STONE_SWORD, Material.STONE_AXE, Material.STONE_HOE, Material.STONE_SHOVEL, Material.STONE_PICKAXE -> 4.0f;
            case Material.IRON_SWORD, Material.IRON_AXE, Material.IRON_HOE, Material.IRON_SHOVEL, Material.IRON_PICKAXE -> 6.0f;
            case Material.GOLDEN_SWORD, Material.GOLDEN_AXE, Material.GOLDEN_HOE, Material.GOLDEN_SHOVEL, Material.GOLDEN_PICKAXE -> 12.0f;
            case Material.DIAMOND_SWORD, Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_SHOVEL, Material.DIAMOND_PICKAXE -> 8.0f;
            default -> 1.0f;
        };
    }

    public static void i(ItemStack itemStack, ItemStack itemStack2) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (itemMeta.hasEnchants()) {
            for (Map.Entry entry : itemMeta.getEnchants().entrySet()) {
                if (itemMeta2.getEnchantLevel((Enchantment)entry.getKey()) >= (Integer)entry.getValue()) continue;
                itemMeta2.addEnchant((Enchantment)entry.getKey(), ((Integer)entry.getValue()).intValue(), true);
            }
        }
        itemStack2.setItemMeta(itemMeta2);
    }

    public static void j(ItemStack itemStack, ItemStack itemStack2) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (itemMeta.hasCustomModelData()) {
            itemMeta2.setCustomModelData(Integer.valueOf(itemMeta.getCustomModelData()));
        } else {
            itemMeta2.setCustomModelData(Integer.valueOf(0));
        }
        itemStack2.setItemMeta(itemMeta2);
    }

    public static boolean as(ItemStack itemStack) {
        boolean bl = false;
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.hasEnchants()) {
            for (Map.Entry entry : itemMeta.getEnchants().entrySet()) {
                if (!itemMeta.removeEnchant((Enchantment)entry.getKey())) continue;
                bl = true;
            }
        }
        itemStack.setItemMeta(itemMeta);
        return bl;
    }

    public static int C(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (!itemMeta.hasCustomModelData()) {
            return 0;
        }
        return itemMeta.getCustomModelData();
    }

    public static void b(ItemStack itemStack, int n) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(Integer.valueOf(n));
        itemStack.setItemMeta(itemMeta);
    }

    public static boolean at(@Nullable ItemStack itemStack) {
        return itemStack == null || itemStack.getType() == Material.AIR;
    }

    public static ItemStack Dc() {
        return new ItemStack(Material.AIR);
    }

    public static boolean c(PlayerPickupItemEvent playerPickupItemEvent) {
        Integer n = ItemStackBridge_2.d(playerPickupItemEvent);
        if (n == null) {
            return false;
        }
        return n.intValue() == playerPickupItemEvent.getPlayer().getInventory().getHeldItemSlot();
    }

    public static Integer d(PlayerPickupItemEvent playerPickupItemEvent) {
        return ItemStackBridge_2.i(playerPickupItemEvent.getPlayer(), playerPickupItemEvent.getItem().getItemStack());
    }

    public static Integer i(Player player, ItemStack itemStack) {
        PlayerInventory playerInventory = player.getInventory();
        int n = playerInventory.first(itemStack);
        if (n != -1) {
            ItemStack itemStack2 = playerInventory.getItem(n);
            if (itemStack2 == null) {
                n = -1;
            } else if (itemStack2.getAmount() >= itemStack2.getMaxStackSize()) {
                n = -1;
            }
        }
        if (n == -1) {
            n = playerInventory.firstEmpty();
        }
        if (n == -1) {
            return null;
        }
        return n;
    }

    public static ItemStack j(ItemStack itemStack, int n) {
        ItemStack itemStack2 = itemStack.clone();
        itemStack2.setAmount(n);
        return itemStack2;
    }

    public static boolean b(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.HEAD || equipmentSlot == EquipmentSlot.CHEST || equipmentSlot == EquipmentSlot.LEGS || equipmentSlot == EquipmentSlot.FEET;
    }

    public static ItemStack au(ItemStack itemStack) {
        ItemStack itemStack2 = new ItemStack(itemStack.getType());
        itemStack2.setAmount(itemStack.getAmount());
        itemStack2.setItemMeta(itemStack.getItemMeta());
        return itemStack2;
    }

    public static boolean av(ItemStack itemStack) {
        return ItemStackBridge_2.al(itemStack) < ItemStackBridge_2.E(itemStack);
    }

    public static EquipmentSlot ad(Material material) {
        if (material.toString().endsWith("_HELMET") || material.toString().endsWith("_SCUTE")) {
            return EquipmentSlot.HEAD;
        }
        if (material.toString().endsWith("_CHESTPLATE")) {
            return EquipmentSlot.CHEST;
        }
        if (material.toString().endsWith("_LEGGINGS")) {
            return EquipmentSlot.LEGS;
        }
        if (material.toString().endsWith("_BOOTS")) {
            return EquipmentSlot.FEET;
        }
        return switch (material) {
            case Material.ELYTRA -> EquipmentSlot.CHEST;
            case Material.CARVED_PUMPKIN -> EquipmentSlot.HEAD;
            case Material.SHIELD -> EquipmentSlot.OFF_HAND;
            default -> null;
        };
    }

    public static boolean ae(Material material) {
        return switch (material) {
            case Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS -> true;
            default -> false;
        };
    }

    public static ItemStack a(AnvilInventory anvilInventory) {
        if (VersionHelper.Va) {
            return anvilInventory.getResult();
        }
        return anvilInventory.getItem(2);
    }

    public static boolean af(Material material) {
        return material == Material.POTION || material == Material.SPLASH_POTION || material == Material.LINGERING_POTION;
    }

    public static ItemMeta c(ItemStack itemStack, Color color) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        ItemStackBridge_2.a(itemMeta, color);
        return itemMeta;
    }

    public static void a(ItemMeta itemMeta, Color color) {
        ItemMeta itemMeta2 = itemMeta;
        Objects.requireNonNull(itemMeta2);
        ItemMeta itemMeta3 = itemMeta2;
        int n = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{PotionMeta.class, LeatherArmorMeta.class}, (Object)itemMeta3, n)) {
            case 0: {
                PotionMeta potionMeta = (PotionMeta)itemMeta3;
                potionMeta.setColor(color);
                potionMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ADDITIONAL_TOOLTIP});
                break;
            }
            case 1: {
                LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemMeta3;
                leatherArmorMeta.setColor(color);
                leatherArmorMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DYE});
                break;
            }
        }
    }

    public static void b(ItemMeta itemMeta) {
        ItemMeta itemMeta2 = itemMeta;
        Objects.requireNonNull(itemMeta2);
        ItemMeta itemMeta3 = itemMeta2;
        int n = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{PotionMeta.class, LeatherArmorMeta.class}, (Object)itemMeta3, n)) {
            case 0: {
                PotionMeta potionMeta = (PotionMeta)itemMeta3;
                potionMeta.setColor(null);
                potionMeta.removeItemFlags(new ItemFlag[]{ItemFlag.HIDE_ADDITIONAL_TOOLTIP});
                break;
            }
            case 1: {
                LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemMeta3;
                leatherArmorMeta.setColor(null);
                leatherArmorMeta.removeItemFlags(new ItemFlag[]{ItemFlag.HIDE_DYE});
                break;
            }
        }
    }

    @Nullable
    public static Integer aw(ItemStack itemStack) {
        Color color = ItemStackBridge_2.ax(itemStack);
        if (color == null) {
            return null;
        }
        return color.asRGB();
    }

    @Nullable
    public static Color ax(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        int n = 0;
        return switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{PotionMeta.class, LeatherArmorMeta.class}, (Object)itemMeta, n)) {
            case 0 -> {
                PotionMeta var3_3 = (PotionMeta)itemMeta;
                yield var3_3.getColor();
            }
            case 1 -> {
                LeatherArmorMeta var4_4 = (LeatherArmorMeta)itemMeta;
                yield var4_4.getColor();
            }
            default -> null;
        };
    }

    public static boolean ay(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        return itemStack.getItemMeta() instanceof PotionMeta || itemStack.getItemMeta() instanceof LeatherArmorMeta;
    }

    public static boolean az(@Nullable ItemStack itemStack) {
        return itemStack != null && itemStack.getItemMeta() != null && itemStack.getItemMeta().hasEnchant(Enchantment.LOYALTY);
    }

    public static int aA(@Nullable ItemStack itemStack) {
        return itemStack != null && itemStack.getItemMeta() != null ? itemStack.getItemMeta().getEnchantLevel(Enchantment.LOYALTY) : 0;
    }

    public static void ac(Location location) {
        location.getWorld().playSound(location, Sound.ENTITY_ITEM_PICKUP, 0.2f, (ColorBridge.Bl.nextFloat() - ColorBridge.Bl.nextFloat()) * 1.4f + 2.0f);
    }
}
