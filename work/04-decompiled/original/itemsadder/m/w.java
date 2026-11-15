package itemsadder.m;

import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.lg;
import itemsadder.m.x;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class w
implements ai {
    public static w bN;

    public w(Plugin plugin) {
        bev.a(this, plugin);
        for (Player player : Bukkit.getOnlinePlayers()) {
            x.s(player);
        }
    }

    public static void b(Plugin plugin) {
        bN = new w(plugin);
    }

    public BlockFace f(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return x2.bY;
        }
        return null;
    }

    public boolean a(Player player, long l) {
        return System.currentTimeMillis() - l < (long)Math.max(200, player.getPing() + 200);
    }

    public boolean a(Player player, long l, long l2) {
        return System.currentTimeMillis() - l < Math.max(l2, (long)player.getPing() + l2);
    }

    public boolean g(Player player) {
        return this.h(player) || this.m(player) || this.l(player) || this.o(player);
    }

    public boolean h(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bQ);
        }
        return false;
    }

    public boolean i(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bR);
        }
        return false;
    }

    public boolean b(Player player, long l) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bR, l);
        }
        return false;
    }

    public boolean j(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bS);
        }
        return false;
    }

    public boolean c(Player player, long l) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bS, l);
        }
        return false;
    }

    public boolean k(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bP);
        }
        return false;
    }

    public boolean a(Player player, Entity entity) {
        x x2 = x.r(player);
        if (x2 != null) {
            boolean bl = this.a(player, x2.bP);
            if (!bl) {
                return false;
            }
            if (x2.aj() == null) {
                return false;
            }
            return x2.aj().equals((Object)entity);
        }
        return false;
    }

    public boolean b(Player player, Entity entity) {
        x x2 = x.r(player);
        if (x2 != null) {
            boolean bl = this.a(player, x2.bP);
            if (!bl) {
                return false;
            }
            return !entity.equals((Object)x2.aj());
        }
        return false;
    }

    public boolean l(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bV);
        }
        return false;
    }

    public boolean m(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bT);
        }
        return false;
    }

    public boolean n(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bU);
        }
        return false;
    }

    public boolean o(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bW);
        }
        return false;
    }

    public boolean p(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return this.a(player, x2.bX);
        }
        return false;
    }

    public Block q(Player player) {
        x x2 = x.r(player);
        if (x2 != null) {
            return x2.bZ;
        }
        return null;
    }

    @EventHandler
    void b(PlayerJoinEvent playerJoinEvent) {
        x.s(playerJoinEvent.getPlayer());
    }

    @EventHandler
    void a(PlayerQuitEvent playerQuitEvent) {
        x.t(playerQuitEvent.getPlayer());
    }

    @EventHandler
    void a(PlayerInteractEvent playerInteractEvent) {
        x x2 = x.r(playerInteractEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bY = playerInteractEvent.getBlockFace();
        x2.bZ = playerInteractEvent.getClickedBlock();
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            x2.bQ = System.currentTimeMillis();
        } else if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            x2.bR = System.currentTimeMillis();
        }
    }

    @EventHandler
    void a(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        x x2 = x.r(playerAnimationEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bS = System.currentTimeMillis();
    }

    @EventHandler
    void a(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        x x2 = x.r(playerInteractAtEntityEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bQ = System.currentTimeMillis();
    }

    @EventHandler
    void a(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (entityDamageByEntityEvent.getDamager() instanceof Player) {
            x x2 = x.r((Player)entityDamageByEntityEvent.getDamager());
            if (x2 == null) {
                return;
            }
            x2.bP = System.currentTimeMillis();
            x2.b(entityDamageByEntityEvent.getEntity());
        }
    }

    @EventHandler
    void a(HangingBreakByEntityEvent hangingBreakByEntityEvent) {
        if (hangingBreakByEntityEvent.getRemover() instanceof Player) {
            x x2 = x.r((Player)hangingBreakByEntityEvent.getRemover());
            if (x2 == null) {
                return;
            }
            x2.bP = System.currentTimeMillis();
            x2.b((Entity)hangingBreakByEntityEvent.getEntity());
        }
    }

    @EventHandler
    void b(PlayerDropItemEvent playerDropItemEvent) {
        x x2 = x.r(playerDropItemEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bV = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void a(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        x x2 = x.r(blockPlaceEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bT = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void a(CustomBlockPlaceEvent customBlockPlaceEvent) {
        x x2 = x.r(customBlockPlaceEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bT = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void b(BlockBreakEvent blockBreakEvent) {
        x x2 = x.r(blockBreakEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bU = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void a(lg lg2) {
        x x2 = x.r(lg2.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bU = System.currentTimeMillis();
    }

    @EventHandler
    void a(PlayerItemConsumeEvent playerItemConsumeEvent) {
        x x2 = x.r(playerItemConsumeEvent.getPlayer());
        if (x2 == null) {
            return;
        }
        x2.bW = System.currentTimeMillis();
    }

    @EventHandler
    void b(InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        x x2 = x.r((Player)inventoryClickEvent.getWhoClicked());
        if (x2 == null) {
            return;
        }
        x2.bX = System.currentTimeMillis();
    }
}
