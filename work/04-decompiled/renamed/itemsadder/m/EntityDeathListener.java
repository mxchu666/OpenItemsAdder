package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomEntityDeathEvent;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.ColorBridge;
import itemsadder.m.EntityWrapper_2;
import itemsadder.m.ItemBridge;
import itemsadder.m.ItemStackBridgeImpl;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBridge_17;
import itemsadder.m.NamespacedKeyPluginHolder;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PluginContract;
import java.util.List;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public class EntityDeathListener
implements PluginContract {
    public void qm() {
        ListenerBridge.a(this, Main.rT());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(EntityDeathEvent entityDeathEvent) {
        LivingEntity livingEntity = entityDeathEvent.getEntity();
        if (livingEntity.getKiller() == null || livingEntity.getKiller().getType() != EntityType.PLAYER) {
            return;
        }
        if (LivingEntityRegistry.P() && LivingEntityRegistry.db().f((Entity)livingEntity)) {
            return;
        }
        @Nullable List list = ItemStackRegistry.g().aq.h(livingEntity);
        if (list != null && !list.isEmpty()) {
            list.forEach(entityTypeBridge_6 -> entityTypeBridge_6.g(livingEntity.getKiller(), livingEntity.getLocation()));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(CustomEntityDeathEvent customEntityDeathEvent) {
        if (customEntityDeathEvent.getKiller() == null || customEntityDeathEvent.getKiller().getType() != EntityType.PLAYER) {
            return;
        }
        @Nullable List list = ItemStackRegistry.g().aq.m(customEntityDeathEvent.internal);
        if (list != null) {
            list.forEach(opaque135 -> opaque135.g(customEntityDeathEvent.getKiller(), customEntityDeathEvent.getEntity().getLocation()));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!BlockBridge_2.bn(block)) {
            return;
        }
        List list = ItemStackRegistry.g().aq.c(block, block.getType());
        if (list != null && !list.isEmpty()) {
            for (MaterialBridge_17 materialBridge_17 : list) {
                if (materialBridge_17.a(blockBreakEvent.getPlayer().getItemInHand(), block.getType())) continue;
                boolean bl = true;
                if (materialBridge_17.qG()) {
                    for (EntityWrapper_2 entityWrapper_2 : materialBridge_17.qF()) {
                        if (entityWrapper_2.aD(block)) continue;
                        bl = false;
                        break;
                    }
                }
                if (!bl) continue;
                materialBridge_17.g(blockBreakEvent.getPlayer(), block.getLocation());
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerBlockHolder_2 playerBlockHolder_2) {
        if (playerBlockHolder_2.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (!playerBlockHolder_2.lp()) {
            return;
        }
        if (playerBlockHolder_2.lq()) {
            return;
        }
        Block block = playerBlockHolder_2.getBlock();
        List list = ItemStackRegistry.g().aq.e(block, playerBlockHolder_2.ln());
        if (list != null && !list.isEmpty()) {
            for (ItemStackBridgeImpl itemStackBridgeImpl : list) {
                if (itemStackBridgeImpl.b(playerBlockHolder_2.getPlayer().getInventory().getItemInMainHand(), playerBlockHolder_2.ln().FD.pc())) continue;
                itemStackBridgeImpl.g(playerBlockHolder_2.getPlayer(), block.getLocation());
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(PlayerFishEvent playerFishEvent) {
        if (playerFishEvent.getCaught() == null) {
            return;
        }
        if (playerFishEvent.getState() == PlayerFishEvent.State.CAUGHT_ENTITY || playerFishEvent.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            if (playerFishEvent.getCaught().getTicksLived() > 3) {
                return;
            }
            if (!(playerFishEvent.getCaught() instanceof Item)) {
                return;
            }
            if (!((Item)playerFishEvent.getCaught()).getItemStack().getType().isEdible()) {
                return;
            }
            List list = ItemStackRegistry.g().aq.aC(playerFishEvent.getCaught().getLocation().getBlock());
            if (list != null && list.size() > 0) {
                int n = ColorBridge.v(0, list.size() - 1);
                ItemBridge itemBridge = (ItemBridge)list.get(n);
                itemBridge.a((Item)playerFishEvent.getCaught(), playerFishEvent.getPlayer());
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(SpawnerSpawnEvent spawnerSpawnEvent) {
        spawnerSpawnEvent.getEntity().getPersistentDataContainer().set(NamespacedKeyPluginHolder.KZ, PersistentDataType.BOOLEAN, (Object)true);
    }
}
