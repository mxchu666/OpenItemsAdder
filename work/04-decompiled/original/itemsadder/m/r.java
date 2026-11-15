package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NCompound;
import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import itemsadder.m.aiq;
import itemsadder.m.bbg;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.fu;
import itemsadder.m.qm;
import itemsadder.m.rr;
import itemsadder.m.rs;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.jpountz.xxhash.StreamingXXHash64;
import net.jpountz.xxhash.XXHashFactory;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.TileState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class r
implements Listener {
    private static final NamespacedKey bI = new NamespacedKey("itemsadder", "base_items_properties_hashes");

    public r() {
        bev.a(this, (Plugin)Main.rS());
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        r.G(String.valueOf(ChatColor.GREEN) + "Player joined: " + player.getName() + ", updating inventory...");
        Map map = r.a((Inventory)playerInventory, player.getPersistentDataContainer());
        r.a((Inventory)playerInventory, map);
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        try {
            r.a(player.getInventory());
        }
        catch (Exception exception) {
            bce.error("Failed to save custom items configs for player: " + player.getName(), exception);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(BlockBreakEvent blockBreakEvent) {
        blockBreakEvent.getBlock().removeMetadata(bI.toString(), (Plugin)Main.rS());
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(fu fu2) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            try {
                r.a(player.getInventory());
            }
            catch (Exception exception) {
                bce.error("Failed to save custom items configs for player: " + player.getName(), exception);
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            r.G(String.valueOf(ChatColor.GREEN) + "Reloaded plugin. Player : " + player.getName() + ", updating inventory...");
            PlayerInventory playerInventory = player.getInventory();
            Map map = r.a((Inventory)playerInventory, player.getPersistentDataContainer());
            r.a((Inventory)playerInventory, map);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        HumanEntity humanEntity = inventoryCloseEvent.getPlayer();
        r.G(String.valueOf(ChatColor.YELLOW) + "Closed inventory: " + String.valueOf(humanEntity));
        Inventory inventory = inventoryCloseEvent.getInventory();
        if (inventory instanceof CraftingInventory) {
            try {
                r.a(humanEntity.getInventory());
            }
            catch (Exception exception) {
                bce.error("Failed to serialize custom items configs for player: " + humanEntity.getName(), exception);
            }
        } else if (inventory.getType() == InventoryType.CHEST) {
            if (inventory.getHolder() instanceof Entity || inventory.getHolder() instanceof LivingEntity) {
                return;
            }
            Location location = inventory.getLocation();
            if (location != null) {
                try {
                    r.b(inventory);
                }
                catch (Exception exception) {
                    bce.error("Failed to serialize custom items configs for block: " + bcc.ae(location), exception);
                }
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(InventoryOpenEvent inventoryOpenEvent) {
        r.G(String.valueOf(ChatColor.GREEN) + "Opened inventory");
        Inventory inventory = inventoryOpenEvent.getInventory();
        TileState tileState = r.c(inventory);
        Location location = inventory.getLocation();
        if (location != null & tileState != null) {
            r.G(String.valueOf(ChatColor.GREEN) + "TileState found for inventory: " + bcc.ae(location) + ", updating inventory...");
            Map map = r.a(inventory, tileState.getPersistentDataContainer());
            r.a(inventory, map);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(EntityPickupItemEvent entityPickupItemEvent) {
        Map map;
        if (!(entityPickupItemEvent.getEntity() instanceof Player)) {
            return;
        }
        ItemStack itemStack = entityPickupItemEvent.getItem().getItemStack();
        qm qm2 = d.g().a(itemStack);
        if (qm2 != null && (map = r.b(entityPickupItemEvent.getItem())) != null) {
            @Nullable Long l = (Long)map.get(0);
            if (l != null) {
                r.G(String.valueOf(ChatColor.GREEN) + "Updating item: " + qm2.getNamespacedID() + " with hash: " + l);
                r.a(entityPickupItemEvent.getItem(), l);
            } else {
                r.G(String.valueOf(ChatColor.YELLOW) + "No previous data found for item: " + qm2.getNamespacedID());
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(PlayerDropItemEvent playerDropItemEvent) {
        try {
            r.c(playerDropItemEvent.getItemDrop());
        }
        catch (Exception exception) {
            bce.warn("Failed to save custom items configs for dropped item: " + String.valueOf(playerDropItemEvent.getItemDrop().getItemStack()), exception);
        }
    }

    private static Map a(Inventory inventory) {
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        for (int i = 0; i < inventory.getSize(); ++i) {
            bbg bbg2;
            ItemStack itemStack = inventory.getItem(i);
            qm qm2 = d.g().a(itemStack);
            if (qm2 == null || (bbg2 = qm2.np()) == null) continue;
            Long l = qm2.no();
            r.G(i + " - Hash: " + l);
            hashMap.put(i, l);
        }
        return hashMap;
    }

    private static Map a(Item item) {
        bbg bbg2;
        HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();
        ItemStack itemStack = item.getItemStack();
        qm qm2 = d.g().a(itemStack);
        if (qm2 != null && (bbg2 = qm2.np()) != null) {
            Long l = qm2.no();
            r.G(" - Hash: " + l);
            hashMap.put(0, l);
        }
        return hashMap;
    }

    @Nullable
    private static Map a(Metadatable metadatable) {
        List list = metadatable.getMetadata(bI.toString());
        if (list.isEmpty()) {
            return null;
        }
        MetadataValue metadataValue = (MetadataValue)list.getFirst();
        if (metadataValue != null && metadataValue.value() instanceof Map) {
            return (Map)metadataValue.value();
        }
        return null;
    }

    @Nullable
    private static Map a(PersistentDataContainer persistentDataContainer) {
        Map map;
        byte[] byArray = (byte[])persistentDataContainer.get(bI, PersistentDataType.BYTE_ARRAY);
        if (byArray == null) {
            r.G(String.valueOf(ChatColor.DARK_GRAY) + "CustomItemsConfigs is null");
            return null;
        }
        try {
            map = r.a(byArray);
        }
        catch (Exception exception) {
            bce.error("Failed to deserialize custom items configs", exception);
            return null;
        }
        if (map.isEmpty()) {
            r.G("CustomItemsConfigs is empty");
            return null;
        }
        return map;
    }

    @Nullable
    private static Map a(Inventory inventory, PersistentDataContainer persistentDataContainer) {
        Player player;
        PlayerInventory playerInventory;
        HumanEntity humanEntity;
        Location location = inventory.getLocation();
        Map map = null;
        if (inventory instanceof PlayerInventory && (humanEntity = (playerInventory = (PlayerInventory)inventory).getHolder()) instanceof Player) {
            player = (Player)humanEntity;
            map = r.a((Metadatable)player);
        } else if (location != null) {
            map = r.a((Metadatable)location.getBlock());
        }
        if (map == null) {
            map = r.a(persistentDataContainer);
            if (map == null) {
                return null;
            }
            if (location != null) {
                location.getBlock().setMetadata(bI.toString(), (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)map));
            } else if (inventory instanceof PlayerInventory && (humanEntity = (playerInventory = (PlayerInventory)inventory).getHolder()) instanceof Player) {
                player = (Player)humanEntity;
                player.setMetadata(bI.toString(), (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)map));
            } else {
                r.G("CustomItemsConfigs is not saved, no location or holder found");
            }
        }
        return map;
    }

    @Nullable
    private static Map b(Item item) {
        Map map = r.a((Metadatable)item);
        if (map == null) {
            map = r.a(item.getPersistentDataContainer());
            if (map == null) {
                return null;
            }
            item.setMetadata(bI.toString(), (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)map));
        }
        return map;
    }

    private static void b(Inventory inventory) {
        Location location = inventory.getLocation();
        if (location == null) {
            throw new RuntimeException("Inventory location is null, cannot save custom items configs");
        }
        TileState tileState = r.c(inventory);
        if (tileState == null) {
            return;
        }
        Map map = r.a(inventory);
        if (!r.a(r.a((Metadatable)location.getBlock()), map)) {
            return;
        }
        location.getBlock().setMetadata(bI.toString(), (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)map));
        try {
            tileState.getPersistentDataContainer().set(bI, PersistentDataType.BYTE_ARRAY, (Object)r.b(map));
            tileState.update(true, false);
        }
        catch (Exception exception) {
            bce.error("Failed to serialize custom items configs for block: " + bcc.ae(location), exception);
        }
    }

    private static void a(PlayerInventory playerInventory) {
        HumanEntity humanEntity = playerInventory.getHolder();
        if (!(humanEntity instanceof Player)) {
            throw new RuntimeException("Inventory holder is null or not a player, cannot save custom items configs");
        }
        Map map = r.a((Inventory)playerInventory);
        if (!r.a(r.a((Metadatable)humanEntity), map)) {
            return;
        }
        humanEntity.setMetadata(bI.toString(), (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)map));
        humanEntity.getPersistentDataContainer().set(bI, PersistentDataType.BYTE_ARRAY, (Object)r.b(r.a((Inventory)playerInventory)));
    }

    private static void c(Item item) {
        Map map = r.a(item);
        item.setMetadata(bI.toString(), (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)map));
        item.getPersistentDataContainer().set(bI, PersistentDataType.BYTE_ARRAY, (Object)r.b(r.a(item)));
    }

    private static boolean a(Map map, Map map2) {
        if (map != null && !map.isEmpty() && map.equals(map2)) {
            r.G("CustomItemsConfigs is the same, skipping update");
            return false;
        }
        return true;
    }

    private static void a(Inventory inventory, Map map) {
        if (map == null || map.isEmpty()) {
            r.G("CustomItemsConfigs is empty");
            return;
        }
        for (int i = 0; i < inventory.getSize(); ++i) {
            bbg bbg2;
            ItemStack itemStack = inventory.getItem(i);
            qm qm2 = d.g().a(itemStack);
            if (qm2 == null || (bbg2 = qm2.np()) == null) continue;
            @Nullable Long l = qm2.no();
            @Nullable Long l2 = (Long)map.get(i);
            if (!Objects.equals(l2, l)) {
                r.G(String.valueOf(ChatColor.YELLOW) + i + " - Prev " + l2 + " | New " + l + " - UPDATED");
                ItemStack itemStack2 = r.f(itemStack);
                if (itemStack2 == null) continue;
                inventory.setItem(i, itemStack2);
                continue;
            }
            r.G(String.valueOf(ChatColor.DARK_GRAY) + i + " - Prev " + l2 + " | New " + l + " - NO CHANGE");
        }
    }

    private static void a(Item item, @Nullable Long l) {
        if (l == null) {
            r.G(String.valueOf(ChatColor.YELLOW) + "Stored YAML hash is null, skipping update for item: " + String.valueOf(item.getItemStack()));
            return;
        }
        ItemStack itemStack = item.getItemStack();
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        bbg bbg2 = qm2.np();
        if (bbg2 != null) {
            @Nullable Long l2 = qm2.no();
            if (!Objects.equals(l, l2)) {
                r.G(String.valueOf(ChatColor.YELLOW) + "- Prev " + l + " | New " + l2 + " - UPDATED");
                ItemStack itemStack2 = r.f(itemStack);
                if (itemStack2 == null) {
                    return;
                }
                item.setItemStack(itemStack2);
            } else {
                r.G(String.valueOf(ChatColor.DARK_GRAY) + " - Prev " + l + " | New " + l2 + " - NO CHANGE");
            }
        }
    }

    @Nullable
    public static ItemStack f(ItemStack itemStack) {
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return null;
        }
        if (r.g(itemStack)) {
            return null;
        }
        rr rr2 = qm2.nq();
        if (rr2 == null) {
            r.G("Item " + qm2.getNamespacedID() + " is not enabled for updates, skipping.");
            return null;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        ItemStack itemStack2 = qm2.mP();
        itemStack2.setAmount(itemStack.getAmount());
        if (bbs.av(itemStack)) {
            bbs.c(itemStack2, bbs.E(itemStack));
            int n = bbs.al(itemStack);
            int n2 = bbs.E(itemStack2);
            int n3 = (int)Math.ceil((double)n / (double)bbs.E(itemStack) * (double)n2);
            bbs.d(itemStack2, n3);
        } else if (bbs.ap(itemStack)) {
            bbs.d(itemStack2, bbs.al(itemStack));
            bbs.c(itemStack2, bbs.E(itemStack));
        }
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta.getPersistentDataContainer().copyTo(itemMeta2.getPersistentDataContainer(), true);
        if (itemMeta instanceof ArmorMeta) {
            ArmorMeta armorMeta = (ArmorMeta)itemMeta;
            if (itemMeta2 instanceof ArmorMeta) {
                ArmorMeta armorMeta2 = (ArmorMeta)itemMeta2;
                if (armorMeta.hasTrim()) {
                    armorMeta2.setTrim(armorMeta.getTrim());
                }
            }
        }
        if (itemMeta.hasDisplayName()) {
            try {
                itemMeta2.displayName(itemMeta.displayName());
                itemStack2.setItemMeta(itemMeta2);
            }
            catch (Exception exception) {
                bce.b(null, "Failed to set display name on item: " + String.valueOf(itemStack2), exception);
            }
        }
        if (qm2.isBlockAllEnchants()) {
            itemMeta2.removeEnchantments();
        } else if (rr2.oG() == rs.MERGE) {
            for (Map.Entry entry : itemMeta.getEnchants().entrySet()) {
                Enchantment enchantment = (Enchantment)entry.getKey();
                Integer n = (Integer)entry.getValue();
                if (qm2.mT() != null && qm2.mT().contains(enchantment)) continue;
                itemMeta2.addEnchant(enchantment, n.intValue(), true);
            }
        } else if (rr2.oG() == rs.REPLACE) {
            itemMeta2.removeEnchantments();
            for (Map.Entry entry : qm2.nr().entrySet()) {
                Enchantment enchantment = (Enchantment)entry.getKey();
                Integer n = (Integer)entry.getValue();
                itemMeta2.addEnchant(enchantment, n.intValue(), true);
            }
        }
        if (itemMeta instanceof Repairable) {
            Repairable repairable = (Repairable)itemMeta;
            if (itemMeta2 instanceof Repairable) {
                Repairable repairable2 = (Repairable)itemMeta2;
                if (repairable.hasRepairCost()) {
                    repairable2.setRepairCost(repairable.getRepairCost() + 1);
                    itemStack2.setItemMeta((ItemMeta)repairable2);
                }
            }
        }
        itemStack2.setItemMeta(itemMeta2);
        return itemStack2;
    }

    @Nullable
    private static TileState c(Inventory inventory) {
        Location location = inventory.getLocation();
        if (location == null) {
            return null;
        }
        Block block = inventory.getLocation().getBlock();
        BlockState blockState = block.getState();
        if (blockState instanceof TileState) {
            TileState tileState = (TileState)blockState;
            return tileState;
        }
        return null;
    }

    public static void a(InventoryClickEvent inventoryClickEvent) {
        ItemStack itemStack;
        ItemStack itemStack2;
        ItemStack itemStack3 = inventoryClickEvent.getCurrentItem();
        ItemStack itemStack4 = inventoryClickEvent.getCursor();
        if (bbs.at(itemStack3) || bbs.at(itemStack4)) {
            return;
        }
        if (itemStack3.getType() != itemStack4.getType()) {
            return;
        }
        if (itemStack3.isSimilar(itemStack4)) {
            return;
        }
        int n = bbs.am(itemStack3);
        int n2 = bbs.am(itemStack4);
        if (n <= 1 || n2 <= 1) {
            return;
        }
        if (n == itemStack3.getAmount() || n2 == itemStack4.getAmount()) {
            return;
        }
        qm qm2 = d.g().a(itemStack3);
        qm qm3 = d.g().a(itemStack4);
        if (qm2 == null || qm3 == null) {
            return;
        }
        if (!(qm3.nq() == null || qm2.nq() == null || qm2.nq().oF() && qm3.nq().oF())) {
            return;
        }
        if (!qm2.getNamespacedID().equals(qm3.getNamespacedID())) {
            return;
        }
        if (r.g(itemStack3) || !r.g(itemStack4)) {
            return;
        }
        if (qm2.isSimilar(itemStack3)) {
            itemStack2 = itemStack3;
            itemStack = itemStack4;
        } else {
            itemStack2 = itemStack4;
            itemStack = itemStack3;
        }
        if (!aiq.tX().g(itemStack3, itemStack4)) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        int n3 = itemStack2.getAmount() + itemStack.getAmount();
        if (n3 <= bbs.am(itemStack2)) {
            inventoryClickEvent.setCursor(null);
            itemStack2.setAmount(n3);
            inventoryClickEvent.setCurrentItem(itemStack2);
            r.G("Stacked items: " + qm2.getNamespacedID() + " x" + itemStack2.getAmount());
        } else {
            itemStack2.setAmount(n);
            itemStack.setAmount(n3 - n);
            inventoryClickEvent.setCurrentItem(itemStack2);
            inventoryClickEvent.setCursor(itemStack);
            r.G("Stacked items: " + qm2.getNamespacedID() + " x" + itemStack2.getAmount() + " and " + qm3.getNamespacedID() + " x" + itemStack4.getAmount());
        }
    }

    public static byte[] b(Map map) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(map);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static Map a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Map)objectInputStream.readObject();
    }

    public static void a(ItemStack itemStack, @Nullable Boolean bl) {
        NItem nItem = new NItem(itemStack);
        NCompound nCompound = nItem.getCompound("itemsadder");
        if (nCompound == null) {
            return;
        }
        if (bl == null || !bl.booleanValue()) {
            nCompound.remove("override_auto_update");
        } else {
            nCompound.setBoolean("override_auto_update", true);
        }
        nItem.save();
    }

    public static boolean g(ItemStack itemStack) {
        NItem nItem = new NItem(itemStack);
        NCompound nCompound = nItem.getCompound("itemsadder");
        if (nCompound == null) {
            return false;
        }
        return nCompound.hasKey("override_auto_update") && nCompound.getBoolean("override_auto_update");
    }

    public static long F(String string) {
        if (string == null || string.isEmpty()) {
            return 0L;
        }
        byte[] byArray = string.getBytes();
        byte[] byArray2 = new byte[8192];
        XXHashFactory xXHashFactory = XXHashFactory.fastestInstance();
        try (StreamingXXHash64 streamingXXHash64 = xXHashFactory.newStreamingHash64(0L);){
            int n;
            int n2 = 0;
            for (int i = byArray.length; i > 0; i -= n) {
                n = Math.min(byArray2.length, i);
                System.arraycopy(byArray, n2, byArray2, 0, n);
                streamingXXHash64.update(byArray2, 0, n);
                n2 += n;
            }
            long l = streamingXXHash64.getValue();
            return l;
        }
    }

    private static void G(String string) {
    }
}
