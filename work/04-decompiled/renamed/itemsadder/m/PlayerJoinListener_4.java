package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.injector.GamePhase;
import dev.lone.itemsadder.s;
import dev.lone.itemsadder.t;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KfFunction;
import itemsadder.m.ListenerBridge;
import itemsadder.m.Opaque123;
import itemsadder.m.PacketListener_47;
import itemsadder.m.PlayerBridge_15;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PluginContract;
import itemsadder.m.SystemChatPacketListener;
import itemsadder.m.WorldBridge_4;
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

public class PlayerJoinListener_4
implements PluginContract {
    private static final long wT = 1700L;
    final Plugin wU;
    final ItemStackRegistry wV;
    public final Map wW = new ConcurrentHashMap();
    public final Map wX = Collections.synchronizedMap(new WeakHashMap());
    BukkitTask wY;
    BukkitTask wZ;
    BukkitTask xa;

    public PlayerJoinListener_4(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.wU = plugin;
        this.wV = itemStackRegistry;
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
                            ((PlayerBridge_15)this.wW.get(player)).kx();
                        }
                        listIterator.remove();
                        continue;
                    }
                    this.wV.an.u(player);
                }
            }
        });
        ListenerBridge.a(this, this.wU);
        this.ko();
        this.kq();
    }

    private void u(Player player) {
        PlayerBridge_15 playerBridge_15 = new PlayerBridge_15(player);
        this.wW.put(player, playerBridge_15);
        for (WorldBridge_4 worldBridge_4 : this.wV.am.vF.values()) {
            WorldBridge_4 worldBridge_42 = worldBridge_4.a(playerBridge_15);
            if (!(worldBridge_42 instanceof PlayerBridge_8)) continue;
            PlayerBridge_8 playerBridge_8 = (PlayerBridge_8)worldBridge_42;
            if (!this.wV.an.a(player, playerBridge_8.jX())) {
                this.wV.an.a(player, playerBridge_8.jX(), playerBridge_8.jW());
            } else {
                playerBridge_8.k(this.wV.an.b(player, playerBridge_8.jX(), playerBridge_8.jW()));
            }
            playerBridge_15.a(playerBridge_8);
        }
        playerBridge_15.recalculateOffsets();
    }

    void ko() {
        int n = 5;
        this.wY = BukkitTaskBridge.b(bukkitRunnable -> {
            for (Map.Entry entry : this.wW.entrySet()) {
                Player player = (Player)entry.getKey();
                PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)entry.getValue();
                for (PlayerBridge_8 playerBridge_8 : playerBridge_15.xf) {
                    playerBridge_8.b(player, 5);
                }
            }
        }, 0L, 5L);
        this.wZ = BukkitTaskBridge.b(bukkitRunnable -> {
            block0: for (Map.Entry entry : this.wW.entrySet()) {
                Player player = (Player)entry.getKey();
                PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)entry.getValue();
                if (playerBridge_15 == null || !this.wV.an.v(player)) continue;
                for (PlayerBridge_8 playerBridge_8 : playerBridge_15.xf) {
                    if (!playerBridge_8.jS() || !playerBridge_8.jL()) continue;
                    playerBridge_15.recalculateOffsets();
                    continue block0;
                }
            }
        }, 0L, 1L);
        int n2 = 20;
        this.xa = Bukkit.getServer().getScheduler().runTaskTimer(this.wU, () -> {
            for (Map.Entry entry : this.wW.entrySet()) {
                Player player = (Player)entry.getKey();
                PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)entry.getValue();
                if (this.wV.an.v(player)) {
                    playerBridge_15.ky();
                    if (!s.a((HumanEntity)player, t.TRIGGERS)) {
                        for (PlayerBridge_8 playerBridge_8 : playerBridge_15.xf) {
                            if (s.a((HumanEntity)player, playerBridge_8, t.TRIGGERS)) continue;
                            playerBridge_8.c(player, 20);
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
        return baseComponent.toLegacyText().contains((CharSequence)Opaque123.wo.get(1));
    }

    private void kq() {
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new PacketListener_47(this, PacketAdapter.params().plugin(this.wU).serverSide().optionAsync().gamePhase(GamePhase.PLAYING).types(new PacketType[]{PacketType.Play.Server.CHAT})));
        PacketType[] packetTypeArray = new PacketType[]{PacketType.Play.Server.SET_ACTION_BAR_TEXT, PacketType.Play.Server.SYSTEM_CHAT};
        ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new SystemChatPacketListener(this, PacketAdapter.params().plugin(this.wU).serverSide().optionAsync().gamePhase(GamePhase.PLAYING).types(packetTypeArray)));
    }

    public void c(Player player, String string, float f) {
        PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)this.wW.get(player);
        if (playerBridge_15 != null && this.wV.an.v(player)) {
            PlayerBridge_8 playerBridge_8 = (PlayerBridge_8)playerBridge_15.xi.get(string);
            if (playerBridge_8 != null && playerBridge_8.wa.equals(string)) {
                playerBridge_8.k(f);
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
        PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)this.wW.get(player);
        if (playerBridge_15 != null) {
            playerBridge_15.kv();
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
        PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)this.wW.get(player);
        if (playerBridge_15 != null) {
            PlayerBridge_8 playerBridge_8 = playerBridge_15.ba(string);
            return playerBridge_8 != null && s.a((HumanEntity)player, playerBridge_8, t.COMMANDS);
        }
        return false;
    }

    @Nullable
    public PlayerBridge_8 d(Player player, String string) {
        PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)this.wW.get(player);
        if (playerBridge_15 == null) {
            return null;
        }
        return (PlayerBridge_8)playerBridge_15.xh.get(string);
    }

    @EventHandler(priority=EventPriority.LOW)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        this.wV.an.u(playerJoinEvent.getPlayer());
        this.u(player);
        if (this.wW.containsKey(player)) {
            ((PlayerBridge_15)this.wW.get(player)).kx();
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
                ((PlayerBridge_15)this.wW.get(playerGameModeChangeEvent.getPlayer())).kw();
            }
        } else {
            BukkitTaskBridge.c(() -> this.al(playerGameModeChangeEvent.getPlayer()), 1L);
        }
        BukkitTaskBridge.c(() -> {
            if (this.wW.containsKey(playerGameModeChangeEvent.getPlayer())) {
                ((PlayerBridge_15)this.wW.get(playerGameModeChangeEvent.getPlayer())).recalculateOffsets();
            }
        }, 1L);
    }

    @EventHandler(ignoreCancelled=true)
    private void a(FoodLevelChangeEvent foodLevelChangeEvent) {
        if (ListenerBridge.c(foodLevelChangeEvent)) {
            return;
        }
        Player player = (Player)foodLevelChangeEvent.getEntity();
        PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)this.wW.get(player);
        if (playerBridge_15 == null) {
            return;
        }
        for (PlayerBridge_8 playerBridge_8 : playerBridge_15.xf) {
            for (KfFunction kfFunction : playerBridge_8.jV()) {
                kfFunction.a(playerBridge_8, player, foodLevelChangeEvent);
            }
        }
        if (this.wW.containsKey(player)) {
            ((PlayerBridge_15)this.wW.get(player)).recalculateOffsets();
        }
    }

    @EventHandler
    private void b(PlayerRespawnEvent playerRespawnEvent) {
        Player player = playerRespawnEvent.getPlayer();
        PlayerBridge_15 playerBridge_15 = (PlayerBridge_15)this.wW.get(player);
        if (playerBridge_15 == null) {
            return;
        }
        for (PlayerBridge_8 playerBridge_8 : playerBridge_15.xf) {
            for (KfFunction kfFunction : playerBridge_8.jV()) {
                kfFunction.a(playerBridge_8, player, playerRespawnEvent);
            }
        }
        if (this.wW.containsKey(player)) {
            playerBridge_15.recalculateOffsets();
            playerBridge_15.kx();
        }
    }

    @EventHandler
    private void c(PlayerChangedWorldEvent playerChangedWorldEvent) {
        Player player = playerChangedWorldEvent.getPlayer();
        if (this.wW.containsKey(player)) {
            ((PlayerBridge_15)this.wW.get(player)).kx();
        }
    }

    @EventHandler
    private void c(PlayerTeleportEvent playerTeleportEvent) {
        Player player = playerTeleportEvent.getPlayer();
        if (this.wW.containsKey(player)) {
            ((PlayerBridge_15)this.wW.get(player)).kx();
        }
    }
}
