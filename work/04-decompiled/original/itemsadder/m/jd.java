package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.injector.GamePhase;
import dev.lone.itemsadder.s;
import dev.lone.itemsadder.t;
import itemsadder.m.ai;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.ii;
import itemsadder.m.ij;
import itemsadder.m.il;
import itemsadder.m.iq;
import itemsadder.m.je;
import itemsadder.m.jf;
import itemsadder.m.jg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;

public class jd
implements ai {
    private static final long wT = 1700L;
    final Plugin wU;
    final d wV;
    public final Map wW = new ConcurrentHashMap();
    public final Map wX = Collections.synchronizedMap(new WeakHashMap());
    BukkitTask wY;
    BukkitTask wZ;
    BukkitTask xa;

    public jd(Plugin plugin, d d2) {
        this.wU = plugin;
        this.wV = d2;
    }

    public void init() {
        Bukkit.getServer().getScheduler().runTaskAsynchronously(this.wU, () -> {
            ArrayList arrayList = new ArrayList(Bukkit.getOnlinePlayers());
            while (!arrayList.isEmpty()) {
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    Player player = (Player)listIterator.next();
                    if (this.wV.an.v(player)) {
                        this.u(player);
                        if (this.wW.containsKey(player)) {
                            ((jg)this.wW.get(player)).kx();
                        }
                        listIterator.remove();
                        continue;
                    }
                    this.wV.an.u(player);
                }
            }
        });
        bev.a(this, this.wU);
        this.ko();
        this.kq();
    }

    private void u(Player player) {
        jg jg2 = new jg(player);
        this.wW.put(player, jg2);
        for (ii ii2 : this.wV.am.vF.values()) {
            ii ii3 = ii2.a(jg2);
            if (!(ii3 instanceof ij)) continue;
            ij ij2 = (ij)ii3;
            if (!this.wV.an.a(player, ij2.jX())) {
                this.wV.an.a(player, ij2.jX(), ij2.jW());
            } else {
                ij2.k(this.wV.an.b(player, ij2.jX(), ij2.jW()));
            }
            jg2.a(ij2);
        }
        jg2.recalculateOffsets();
    }

    void ko() {
        int n = 5;
        this.wY = bcp.b(bukkitRunnable -> {
            for (Map.Entry entry : this.wW.entrySet()) {
                Player player = (Player)entry.getKey();
                jg jg2 = (jg)entry.getValue();
                for (ij ij2 : jg2.xf) {
                    ij2.b(player, 5);
                }
            }
        }, 0L, 5L);
        this.wZ = bcp.b(bukkitRunnable -> {
            block0: for (Map.Entry entry : this.wW.entrySet()) {
                Player player = (Player)entry.getKey();
                jg jg2 = (jg)entry.getValue();
                if (jg2 == null || !this.wV.an.v(player)) continue;
                for (ij ij2 : jg2.xf) {
                    if (!ij2.jS() || !ij2.jL()) continue;
                    jg2.recalculateOffsets();
                    continue block0;
                }
            }
        }, 0L, 1L);
        int n2 = 20;
        this.xa = Bukkit.getServer().getScheduler().runTaskTimer(this.wU, () -> {
            for (Map.Entry entry : this.wW.entrySet()) {
                Player player = (Player)entry.getKey();
                jg jg2 = (jg)entry.getValue();
                if (this.wV.an.v(player)) {
                    jg2.ky();
                    if (!s.a((HumanEntity)player, t.TRIGGERS)) {
                        for (ij ij2 : jg2.xf) {
                            if (s.a((HumanEntity)player, ij2, t.TRIGGERS)) continue;
                            ij2.c(player, 20);
                        }
                    }
                }
                if (this.wX.containsKey(player)) {
                    if (System.currentTimeMillis() - (Long)this.wX.get(player) <= 1700L) continue;
                    this.wX.remove(player);
                }
                this.al(player);
            }
        }, 0L, 20L);
    }

    public void kp() {
        if (this.wY != null) {
            this.wY.cancel();
        }
        if (this.xa != null) {
            this.xa.cancel();
        }
    }

    public boolean a(BaseComponent baseComponent) {
        return baseComponent.toLegacyText().contains((CharSequence)il.wo.get(1));
    }

    private void kq() {
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new je(this, PacketAdapter.params().plugin(this.wU).serverSide().optionAsync().gamePhase(GamePhase.PLAYING).types(new PacketType[]{PacketType.Play.Server.CHAT})));
        PacketType[] packetTypeArray = new PacketType[]{PacketType.Play.Server.SET_ACTION_BAR_TEXT, PacketType.Play.Server.SYSTEM_CHAT};
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new jf(this, PacketAdapter.params().plugin(this.wU).serverSide().optionAsync().gamePhase(GamePhase.PLAYING).types(packetTypeArray)));
    }

    public void c(Player player, String string, float f2) {
        jg jg2 = (jg)this.wW.get(player);
        if (jg2 != null && this.wV.an.v(player)) {
            ij ij2 = (ij)jg2.xi.get(string);
            if (ij2 != null && ij2.wa.equals(string)) {
                ij2.k(f2);
            }
            this.al(player);
        }
    }

    public void al(Player player) {
        if (player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (this.wV.as.aug.cn(player)) {
            return;
        }
        if (this.am(player)) {
            return;
        }
        jg jg2 = (jg)this.wW.get(player);
        if (jg2 != null) {
            jg2.kv();
        }
    }

    private boolean am(Player player) {
        Long l = (Long)this.wX.get(player);
        if (l == null) {
            return false;
        }
        return System.currentTimeMillis() - l < 1700L;
    }

    private void an(Player player) {
        this.wX.put(player, System.currentTimeMillis());
    }

    public boolean a(String string, Player player) {
        jg jg2 = (jg)this.wW.get(player);
        if (jg2 != null) {
            ij ij2 = jg2.ba(string);
            return ij2 != null && s.a((HumanEntity)player, ij2, t.COMMANDS);
        }
        return false;
    }

    @Nullable
    public ij d(Player player, String string) {
        jg jg2 = (jg)this.wW.get(player);
        if (jg2 == null) {
            return null;
        }
        return (ij)jg2.xh.get(string);
    }

    @EventHandler(priority=EventPriority.LOW)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        this.wV.an.u(playerJoinEvent.getPlayer());
        this.u(player);
        if (this.wW.containsKey(player)) {
            ((jg)this.wW.get(player)).kx();
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        this.wW.remove(player);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void a(PlayerGameModeChangeEvent playerGameModeChangeEvent) {
        if (playerGameModeChangeEvent.getNewGameMode() == GameMode.SPECTATOR) {
            if (this.wW.containsKey(playerGameModeChangeEvent.getPlayer())) {
                ((jg)this.wW.get(playerGameModeChangeEvent.getPlayer())).kw();
            }
        } else {
            bcp.c(() -> this.al(playerGameModeChangeEvent.getPlayer()), 1L);
        }
        bcp.c(() -> {
            if (this.wW.containsKey(playerGameModeChangeEvent.getPlayer())) {
                ((jg)this.wW.get(playerGameModeChangeEvent.getPlayer())).recalculateOffsets();
            }
        }, 1L);
    }

    @EventHandler(ignoreCancelled=true)
    private void a(FoodLevelChangeEvent foodLevelChangeEvent) {
        if (bev.c(foodLevelChangeEvent)) {
            return;
        }
        Player player = (Player)foodLevelChangeEvent.getEntity();
        jg jg2 = (jg)this.wW.get(player);
        if (jg2 == null) {
            return;
        }
        for (ij ij2 : jg2.xf) {
            for (iq iq2 : ij2.jV()) {
                iq2.a(ij2, player, foodLevelChangeEvent);
            }
        }
        if (this.wW.containsKey(player)) {
            ((jg)this.wW.get(player)).recalculateOffsets();
        }
    }

    @EventHandler
    private void b(PlayerRespawnEvent playerRespawnEvent) {
        Player player = playerRespawnEvent.getPlayer();
        jg jg2 = (jg)this.wW.get(player);
        if (jg2 == null) {
            return;
        }
        for (ij ij2 : jg2.xf) {
            for (iq iq2 : ij2.jV()) {
                iq2.a(ij2, player, playerRespawnEvent);
            }
        }
        if (this.wW.containsKey(player)) {
            jg2.recalculateOffsets();
            jg2.kx();
        }
    }

    @EventHandler
    private void c(PlayerChangedWorldEvent playerChangedWorldEvent) {
        Player player = playerChangedWorldEvent.getPlayer();
        if (this.wW.containsKey(player)) {
            ((jg)this.wW.get(player)).kx();
        }
    }

    @EventHandler
    private void c(PlayerTeleportEvent playerTeleportEvent) {
        Player player = playerTeleportEvent.getPlayer();
        if (this.wW.containsKey(player)) {
            ((jg)this.wW.get(player)).kx();
        }
    }
}
