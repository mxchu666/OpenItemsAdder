package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import dev.lone.itemsadder.Main;
import itemsadder.m.aaf;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.aqp;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.lu;
import itemsadder.m.lx;
import itemsadder.m.lz;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class lw
implements ai {
    private static lw Ba;
    Plugin f;
    private final List Bb = new ArrayList();
    private final Map Bc = Collections.synchronizedMap(new WeakHashMap());
    private final Map Bd = Collections.synchronizedMap(new WeakHashMap());

    lz aM(Player player2) {
        return this.Bd.computeIfAbsent(player2, player -> new lz());
    }

    public static lw lF() {
        if (Ba == null) {
            Ba = new lw((Plugin)Main.rS());
        }
        return Ba;
    }

    private lw(Plugin plugin) {
        Ba = this;
        this.f = plugin;
        this.aR(null);
    }

    public void register() {
        bev.a(this, this.f);
        this.lG();
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.Bb.forEach(aow::c);
        this.Bb.clear();
        Bukkit.getOnlinePlayers().forEach(this::aO);
    }

    private void lG() {
        PacketAdapter.AdapterParameteters adapterParameteters = new PacketAdapter.AdapterParameteters().plugin(this.f).listenerPriority(ListenerPriority.NORMAL).types(new PacketType[]{PacketType.Play.Client.BLOCK_DIG});
        if (Main.rS().Pw) {
            adapterParameteters.options(new ListenerOptions[]{ListenerOptions.SYNC});
        }
        this.Bb.add(new lx(this, adapterParameteters));
        this.Bb.forEach(aow::b);
    }

    private void a(ms ms2, Player player, @Nullable Block block) {
        lu lu2;
        lz lz2 = this.aM(player);
        if (lz2.Bk != null) {
            this.aN(player);
            return;
        }
        if (block == null) {
            return;
        }
        ql ql2 = d.g().h(ms2.Y(block));
        if (ql2 == null) {
            bcp.i(() -> ms2.c(block, true));
            if (ae.dE) {
                bce.warn(player.getName() + " mined unknown block " + ms2.Y(block) + " " + bdf.ai(block.getLocation()));
            }
            return;
        }
        lz2.Bk = lu2 = new lu(block, player, ql2, ms2);
        lu2.lv();
        if (zw.UQ && ap.w(player) && ql2.FD.pc().getHardness() <= 0.0f) {
            lu2.lz();
        }
    }

    private void aN(Player player) {
        lz lz2 = this.aM(player);
        if (lz2.Bk == null) {
            return;
        }
        lz2.Bk.lx();
        lz2.Bj = null;
    }

    public void ak(Player player) {
        this.Bd.remove(player);
    }

    public synchronized boolean b(Location location) {
        return this.Bc.containsKey(location);
    }

    public synchronized void a(Location location, lu lu2) {
        this.Bc.put(location, lu2);
    }

    public synchronized void b(Location location, lu lu2) {
        this.Bc.remove(location, lu2);
    }

    private void aO(Player player) {
        lz lz2 = this.aM(player);
        if (lz2.Bg) {
            return;
        }
        lz2.Bg = true;
        aqp.uW().aO(player);
    }

    private void aP(Player player) {
        lz lz2 = this.aM(player);
        lz2.Bg = false;
        bce.iA(String.valueOf(ChatColor.AQUA) + "Sending fake break speed 0 to " + player.getName());
        aqp.uW().a(player, 0.0f);
    }

    private void a(Player player, float f2) {
        lz lz2 = this.aM(player);
        lz2.Bg = false;
        bce.iA(String.valueOf(ChatColor.AQUA) + "Sending fake break speed " + f2 + " to " + player.getName());
        aqp.uW().a(player, f2);
    }

    boolean aQ(Player player) {
        lz lz2 = this.aM(player);
        return lz2.Bh != null && System.currentTimeMillis() - lz2.Bh < 150L;
    }

    private void aR(@Nullable Player player) {
        if (ae.cG || ae.cI || ae.cH) {
            aaf.tg().bH(player);
        }
    }

    @EventHandler
    private void b(PlayerJoinEvent playerJoinEvent) {
        this.aR(playerJoinEvent.getPlayer());
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.ak(playerQuitEvent.getPlayer());
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockDamageEvent blockDamageEvent) {
        lz lz2 = this.aM(blockDamageEvent.getPlayer());
        lz2.Bi = blockDamageEvent.getPlayer().getGameMode() != GameMode.CREATIVE && blockDamageEvent.getInstaBreak() ? blockDamageEvent.getBlock() : null;
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            lz lz2 = this.aM(playerAnimationEvent.getPlayer());
            lz2.Bh = System.currentTimeMillis();
            if (lz2.Bk != null && lz2.Bk.lw()) {
                lz2.Bk = null;
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        Material material = block.getType();
        lz lz2 = this.aM(blockBreakEvent.getPlayer());
        Block block2 = lz2.Bi;
        lz2.Bi = null;
        if (material == Material.TRIPWIRE) {
            ms ms2 = d.g().b(block);
            if (ms2.isCustomBlock(block)) {
                blockBreakEvent.setCancelled(true);
                Player player = blockBreakEvent.getPlayer();
                this.aP(player);
                this.aN(player);
                this.a(ms2, player, block);
                return;
            }
        } else if (blockBreakEvent.isCancelled()) {
            this.aO(blockBreakEvent.getPlayer());
        }
        if (!blockBreakEvent.isCancelled() && block.equals((Object)block2) && material != Material.DRAGON_EGG) {
            block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, (Object)material);
        }
    }
}
