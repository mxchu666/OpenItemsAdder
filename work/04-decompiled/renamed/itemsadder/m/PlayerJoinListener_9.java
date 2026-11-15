package itemsadder.m;

import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import itemsadder.m.EntityBuilder;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PluginContract;
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

public class PlayerJoinListener_9
implements PluginContract {
    public static PlayerJoinListener_9 bN;

    public PlayerJoinListener_9(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        for (Player player : Bukkit.getOnlinePlayers()) {
            EntityBuilder.s(player);
        }
    }

    public static void b(Plugin plugin) {
        bN = new PlayerJoinListener_9(plugin);
    }

    public BlockFace f(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return entityBuilder.bY;
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
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bQ);
        }
        return false;
    }

    public boolean i(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bR);
        }
        return false;
    }

    public boolean b(Player player, long l) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bR, l);
        }
        return false;
    }

    public boolean j(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bS);
        }
        return false;
    }

    public boolean c(Player player, long l) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bS, l);
        }
        return false;
    }

    public boolean k(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bP);
        }
        return false;
    }

    public boolean a(Player player, Entity entity) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            boolean bl = this.a(player, entityBuilder.bP);
            if (!bl) {
                return false;
            }
            if (entityBuilder.aj() == null) {
                return false;
            }
            return entityBuilder.aj().equals((Object)entity);
        }
        return false;
    }

    public boolean b(Player player, Entity entity) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            boolean bl = this.a(player, entityBuilder.bP);
            if (!bl) {
                return false;
            }
            return !entity.equals((Object)entityBuilder.aj());
        }
        return false;
    }

    public boolean l(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bV);
        }
        return false;
    }

    public boolean m(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bT);
        }
        return false;
    }

    public boolean n(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bU);
        }
        return false;
    }

    public boolean o(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bW);
        }
        return false;
    }

    public boolean p(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return this.a(player, entityBuilder.bX);
        }
        return false;
    }

    public Block q(Player player) {
        EntityBuilder entityBuilder = EntityBuilder.r(player);
        if (entityBuilder != null) {
            return entityBuilder.bZ;
        }
        return null;
    }

    @EventHandler
    void b(PlayerJoinEvent playerJoinEvent) {
        EntityBuilder.s(playerJoinEvent.getPlayer());
    }

    @EventHandler
    void a(PlayerQuitEvent playerQuitEvent) {
        EntityBuilder.t(playerQuitEvent.getPlayer());
    }

    @EventHandler
    void a(PlayerInteractEvent playerInteractEvent) {
        EntityBuilder entityBuilder = EntityBuilder.r(playerInteractEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bY = playerInteractEvent.getBlockFace();
        entityBuilder.bZ = playerInteractEvent.getClickedBlock();
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            entityBuilder.bQ = System.currentTimeMillis();
        } else if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            entityBuilder.bR = System.currentTimeMillis();
        }
    }

    @EventHandler
    void a(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        EntityBuilder entityBuilder = EntityBuilder.r(playerAnimationEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bS = System.currentTimeMillis();
    }

    @EventHandler
    void a(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        EntityBuilder entityBuilder = EntityBuilder.r(playerInteractAtEntityEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bQ = System.currentTimeMillis();
    }

    @EventHandler
    void a(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (entityDamageByEntityEvent.getDamager() instanceof Player) {
            EntityBuilder entityBuilder = EntityBuilder.r((Player)entityDamageByEntityEvent.getDamager());
            if (entityBuilder == null) {
                return;
            }
            entityBuilder.bP = System.currentTimeMillis();
            entityBuilder.b(entityDamageByEntityEvent.getEntity());
        }
    }

    @EventHandler
    void a(HangingBreakByEntityEvent hangingBreakByEntityEvent) {
        if (hangingBreakByEntityEvent.getRemover() instanceof Player) {
            EntityBuilder entityBuilder = EntityBuilder.r((Player)hangingBreakByEntityEvent.getRemover());
            if (entityBuilder == null) {
                return;
            }
            entityBuilder.bP = System.currentTimeMillis();
            entityBuilder.b((Entity)hangingBreakByEntityEvent.getEntity());
        }
    }

    @EventHandler
    void b(PlayerDropItemEvent playerDropItemEvent) {
        EntityBuilder entityBuilder = EntityBuilder.r(playerDropItemEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bV = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void a(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        EntityBuilder entityBuilder = EntityBuilder.r(blockPlaceEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bT = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void a(CustomBlockPlaceEvent customBlockPlaceEvent) {
        EntityBuilder entityBuilder = EntityBuilder.r(customBlockPlaceEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bT = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void b(BlockBreakEvent blockBreakEvent) {
        EntityBuilder entityBuilder = EntityBuilder.r(blockBreakEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bU = System.currentTimeMillis();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void a(PlayerBlockHolder_2 playerBlockHolder_2) {
        EntityBuilder entityBuilder = EntityBuilder.r(playerBlockHolder_2.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bU = System.currentTimeMillis();
    }

    @EventHandler
    void a(PlayerItemConsumeEvent playerItemConsumeEvent) {
        EntityBuilder entityBuilder = EntityBuilder.r(playerItemConsumeEvent.getPlayer());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bW = System.currentTimeMillis();
    }

    @EventHandler
    void b(InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        EntityBuilder entityBuilder = EntityBuilder.r((Player)inventoryClickEvent.getWhoClicked());
        if (entityBuilder == null) {
            return;
        }
        entityBuilder.bX = System.currentTimeMillis();
    }
}
