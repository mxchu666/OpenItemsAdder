package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent$Cause;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.HandlerListBridge_2;
import itemsadder.m.InventoryClickListener_3;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.NamespacedKeyBridge;
import itemsadder.m.PlayerItemStackHolder;
import itemsadder.m.PluginContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PlayerJoinListener_6
implements PluginContract {
    private static final NamespacedKey Ex = new NamespacedKey(Main.rT(), "prev_custom_items_equipment");
    private final Map Ey = Collections.synchronizedMap(new HashMap());

    public void register() {
        ListenerBridge.b(this, (Plugin)Main.rS());
        BukkitTaskBridge.b(bukkitRunnable -> {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                this.be(player);
            }
        }, 35L, 35L);
        new InventoryClickListener_3().register();
    }

    public void a(HumanEntity humanEntity, ItemStackBuilder_4 itemStackBuilder_4, EquipmentSlot equipmentSlot) {
        Map map = (Map)this.Ey.get(humanEntity.getUniqueId());
        if (map != null) {
            map.put(equipmentSlot, itemStackBuilder_4);
        }
    }

    public void a(HumanEntity humanEntity, EquipmentSlot equipmentSlot) {
        Map map = (Map)this.Ey.get(humanEntity.getUniqueId());
        if (map != null) {
            map.remove(equipmentSlot);
        }
    }

    private void bc(Player player) {
        Map map = (Map)this.Ey.get(player.getUniqueId());
        this.Ey.remove(player.getUniqueId());
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        map.forEach((equipmentSlot, itemStackBuilder_4) -> hashMap.put(equipmentSlot.name(), itemStackBuilder_4 != null ? itemStackBuilder_4.Gh : null));
        String string = c.p(hashMap);
        NamespacedKeyBridge.b((PersistentDataHolder)player, Ex, string);
    }

    private void bd(Player player) {
        String string3 = NamespacedKeyBridge.d((PersistentDataHolder)player, Ex);
        if (string3 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.Ey.put(player.getUniqueId(), hashMap);
        Map map = c.jj(string3);
        map.forEach((string, string2) -> hashMap.put(EquipmentSlot.valueOf((String)string), ItemStackRegistry.g().e((String)string2)));
        this.be(player);
    }

    /*
     * Issues handling annotations - annotations may be inaccurate
     */
    void be(Player player) {
        PlayerInventory playerInventory = player.getInventory();
        @Nullable Map map = this.Ey.computeIfAbsent(player.getUniqueId(), uUID -> new HashMap());
        ArrayList<PlayerItemStackHolder> arrayList = new ArrayList<PlayerItemStackHolder>();
        for (EquipmentSlot equipmentSlot : ItemStackBridge_2.aAr) {
            ItemStackBuilder_4 itemStackBuilder_4;
            ItemStack itemStack = playerInventory.getItem(equipmentSlot);
            @Nullable ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack);
            if (ItemStackBuilder_4.a(itemStackBuilder_42, itemStackBuilder_4 = (ItemStackBuilder_4)map.get(equipmentSlot))) continue;
            arrayList.add(new PlayerItemStackHolder(equipmentSlot, player, itemStackBuilder_4, itemStackBuilder_42));
        }
        arrayList.forEach(PlayerItemStackHolder::run);
        map.clear();
        map.putAll(this.b(playerInventory));
    }

    private /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @Nullable Map b(PlayerInventory playerInventory) {
        HashMap<EquipmentSlot, @Nullable ItemStackBuilder_4> hashMap = new HashMap<EquipmentSlot, ItemStackBuilder_4>();
        for (EquipmentSlot equipmentSlot : ItemStackBridge_2.aAr) {
            hashMap.put(equipmentSlot, ItemStackRegistry.g().a(playerInventory.getItem(equipmentSlot)));
        }
        return hashMap;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(PlayerJoinEvent playerJoinEvent) {
        this.bd(playerJoinEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.bc(playerQuitEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(PlayerRespawnEvent playerRespawnEvent) {
        this.be(playerRespawnEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerDeathEvent playerDeathEvent) {
        this.Ey.remove(playerDeathEvent.getEntity().getUniqueId());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(HandlerListBridge_2 handlerListBridge_2) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.bc(player);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        if (itemsAdderLoadDataEvent.getCause() == ItemsAdderLoadDataEvent$Cause.RELOAD) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                this.bd(player);
            }
        }
    }
}
