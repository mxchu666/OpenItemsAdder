package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomEntityDeathEvent;
import itemsadder.m.ai;
import itemsadder.m.bay;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.lg;
import itemsadder.m.ty;
import itemsadder.m.ub;
import itemsadder.m.ue;
import itemsadder.m.uf;
import itemsadder.m.uo;
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

public class tx
implements ai {
    public void qm() {
        bev.a(this, Main.rT());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(EntityDeathEvent entityDeathEvent) {
        LivingEntity livingEntity = entityDeathEvent.getEntity();
        if (livingEntity.getKiller() == null || livingEntity.getKiller().getType() != EntityType.PLAYER) {
            return;
        }
        if (da.P() && da.db().f((Entity)livingEntity)) {
            return;
        }
        @Nullable List list = d.g().aq.h(livingEntity);
        if (list != null && !list.isEmpty()) {
            list.forEach(up2 -> up2.g(livingEntity.getKiller(), livingEntity.getLocation()));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(CustomEntityDeathEvent customEntityDeathEvent) {
        if (customEntityDeathEvent.getKiller() == null || customEntityDeathEvent.getKiller().getType() != EntityType.PLAYER) {
            return;
        }
        @Nullable List list = d.g().aq.m(customEntityDeathEvent.internal);
        if (list != null) {
            list.forEach(uc2 -> uc2.g(customEntityDeathEvent.getKiller(), customEntityDeathEvent.getEntity().getLocation()));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!bay.bn(block)) {
            return;
        }
        List list = d.g().aq.c(block, block.getType());
        if (list != null && !list.isEmpty()) {
            for (uo uo2 : list) {
                if (uo2.a(blockBreakEvent.getPlayer().getItemInHand(), block.getType())) continue;
                boolean bl = true;
                if (uo2.qG()) {
                    for (uf uf2 : uo2.qF()) {
                        if (uf2.aD(block)) continue;
                        bl = false;
                        break;
                    }
                }
                if (!bl) continue;
                uo2.g(blockBreakEvent.getPlayer(), block.getLocation());
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(lg lg2) {
        if (lg2.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (!lg2.lp()) {
            return;
        }
        if (lg2.lq()) {
            return;
        }
        Block block = lg2.getBlock();
        List list = d.g().aq.e(block, lg2.ln());
        if (list != null && !list.isEmpty()) {
            for (ub ub2 : list) {
                if (ub2.b(lg2.getPlayer().getInventory().getItemInMainHand(), lg2.ln().FD.pc())) continue;
                ub2.g(lg2.getPlayer(), block.getLocation());
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
            List list = d.g().aq.aC(playerFishEvent.getCaught().getLocation().getBlock());
            if (list != null && list.size() > 0) {
                int n = bcy.v(0, list.size() - 1);
                ue ue2 = (ue)list.get(n);
                ue2.a((Item)playerFishEvent.getCaught(), playerFishEvent.getPlayer());
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void a(SpawnerSpawnEvent spawnerSpawnEvent) {
        spawnerSpawnEvent.getEntity().getPersistentDataContainer().set(ty.KZ, PersistentDataType.BOOLEAN, (Object)true);
    }
}
