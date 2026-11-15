package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent$Cause;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bcj;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.fu;
import itemsadder.m.pc;
import itemsadder.m.ps;
import itemsadder.m.qm;
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

public class pq
implements ai {
    private static final NamespacedKey Ex = new NamespacedKey(Main.rT(), "prev_custom_items_equipment");
    private final Map Ey = Collections.synchronizedMap(new HashMap());

    public void register() {
        bev.b(this, (Plugin)Main.rS());
        bcp.b(bukkitRunnable -> {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                this.be(player);
            }
        }, 35L, 35L);
        new pc().register();
    }

    public void a(HumanEntity humanEntity, qm qm2, EquipmentSlot equipmentSlot) {
        Map map = (Map)this.Ey.get(humanEntity.getUniqueId());
        if (map != null) {
            map.put(equipmentSlot, qm2);
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
        map.forEach((equipmentSlot, qm2) -> hashMap.put(equipmentSlot.name(), qm2 != null ? qm2.Gh : null));
        String string = c.p(hashMap);
        bcj.b((PersistentDataHolder)player, Ex, string);
    }

    private void bd(Player player) {
        String string3 = bcj.d((PersistentDataHolder)player, Ex);
        if (string3 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.Ey.put(player.getUniqueId(), hashMap);
        Map map = c.jj(string3);
        map.forEach((string, string2) -> hashMap.put(EquipmentSlot.valueOf((String)string), d.g().e((String)string2)));
        this.be(player);
    }

    /*
     * Issues handling annotations - annotations may be inaccurate
     */
    void be(Player player) {
        PlayerInventory playerInventory = player.getInventory();
        @Nullable Map map = this.Ey.computeIfAbsent(player.getUniqueId(), uUID -> new HashMap());
        ArrayList<ps> arrayList = new ArrayList<ps>();
        for (EquipmentSlot equipmentSlot : bbs.aAr) {
            qm qm2;
            ItemStack itemStack = playerInventory.getItem(equipmentSlot);
            @Nullable qm qm3 = d.g().a(itemStack);
            if (qm.a(qm3, qm2 = (qm)map.get(equipmentSlot))) continue;
            arrayList.add(new ps(equipmentSlot, player, qm2, qm3));
        }
        arrayList.forEach(ps::run);
        map.clear();
        map.putAll(this.b(playerInventory));
    }

    private /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @Nullable Map b(PlayerInventory playerInventory) {
        HashMap<EquipmentSlot, @Nullable qm> hashMap = new HashMap<EquipmentSlot, qm>();
        for (EquipmentSlot equipmentSlot : bbs.aAr) {
            hashMap.put(equipmentSlot, d.g().a(playerInventory.getItem(equipmentSlot)));
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
    private void b(fu fu2) {
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
