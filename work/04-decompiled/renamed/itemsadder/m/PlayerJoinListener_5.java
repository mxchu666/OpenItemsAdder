package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockChangedAckPacketListener;
import itemsadder.m.BlockRegistry;
import itemsadder.m.BoolLongBlockData;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBlockHolder_3;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.PluginContract;
import itemsadder.m.VersionHelper_3;
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

public class PlayerJoinListener_5
implements PluginContract {
    private static PlayerJoinListener_5 Ba;
    Plugin f;
    private final List Bb = new ArrayList();
    private final Map Bc = Collections.synchronizedMap(new WeakHashMap());
    private final Map Bd = Collections.synchronizedMap(new WeakHashMap());

    BoolLongBlockData aM(Player player2) {
        return this.Bd.computeIfAbsent(player2, player -> new BoolLongBlockData());
    }

    public static PlayerJoinListener_5 lF() {
        if (Ba == null) {
            Ba = new PlayerJoinListener_5((Plugin)Main.rS());
        }
        return Ba;
    }

    private PlayerJoinListener_5(Plugin plugin) {
        Ba = this;
        this.f = plugin;
        this.aR(null);
    }

    public void register() {
        ListenerBridge.a(this, this.f);
        this.lG();
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.Bb.forEach(PacketListenerRegistry::c);
        this.Bb.clear();
        Bukkit.getOnlinePlayers().forEach(this::aO);
    }

    private void lG() {
        PacketAdapter.AdapterParameteters adapterParameteters = new PacketAdapter.AdapterParameteters().plugin(this.f).listenerPriority(ListenerPriority.NORMAL).types(new PacketType[]{PacketType.Play.Client.BLOCK_DIG});
        if (Main.rS().Pw) {
            adapterParameteters.options(new ListenerOptions[]{ListenerOptions.SYNC});
        }
        this.Bb.add(new BlockChangedAckPacketListener(this, adapterParameteters));
        this.Bb.forEach(PacketListenerRegistry::b);
    }

    private void a(BlockBridge_9 blockBridge_9, Player player, @Nullable Block block) {
        PlayerBlockHolder_3 playerBlockHolder_3;
        BoolLongBlockData boolLongBlockData = this.aM(player);
        if (boolLongBlockData.Bk != null) {
            this.aN(player);
            return;
        }
        if (block == null) {
            return;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
        if (locationBridgeBuilder_2 == null) {
            BukkitTaskBridge.i(() -> blockBridge_9.c(block, true));
            if (MaterialBarColorHolder.dE) {
                CommandSenderBridge_5.warn(player.getName() + " mined unknown block " + blockBridge_9.Y(block) + " " + LocationBridge_4.ai(block.getLocation()));
            }
            return;
        }
        boolLongBlockData.Bk = playerBlockHolder_3 = new PlayerBlockHolder_3(block, player, locationBridgeBuilder_2, blockBridge_9);
        playerBlockHolder_3.lv();
        if (VersionHelper_3.UQ && PlayerJoinListener_2.w(player) && locationBridgeBuilder_2.FD.pc().getHardness() <= 0.0f) {
            playerBlockHolder_3.lz();
        }
    }

    private void aN(Player player) {
        BoolLongBlockData boolLongBlockData = this.aM(player);
        if (boolLongBlockData.Bk == null) {
            return;
        }
        boolLongBlockData.Bk.lx();
        boolLongBlockData.Bj = null;
    }

    public void ak(Player player) {
        this.Bd.remove(player);
    }

    public synchronized boolean b(Location location) {
        return this.Bc.containsKey(location);
    }

    public synchronized void a(Location location, PlayerBlockHolder_3 playerBlockHolder_3) {
        this.Bc.put(location, playerBlockHolder_3);
    }

    public synchronized void b(Location location, PlayerBlockHolder_3 playerBlockHolder_3) {
        this.Bc.remove(location, playerBlockHolder_3);
    }

    private void aO(Player player) {
        BoolLongBlockData boolLongBlockData = this.aM(player);
        if (boolLongBlockData.Bg) {
            return;
        }
        boolLongBlockData.Bg = true;
        PlayerHolder_4.uW().aO(player);
    }

    private void aP(Player player) {
        BoolLongBlockData boolLongBlockData = this.aM(player);
        boolLongBlockData.Bg = false;
        CommandSenderBridge_5.iA(String.valueOf(ChatColor.AQUA) + "Sending fake break speed 0 to " + player.getName());
        PlayerHolder_4.uW().a(player, 0.0f);
    }

    private void a(Player player, float f) {
        BoolLongBlockData boolLongBlockData = this.aM(player);
        boolLongBlockData.Bg = false;
        CommandSenderBridge_5.iA(String.valueOf(ChatColor.AQUA) + "Sending fake break speed " + f + " to " + player.getName());
        PlayerHolder_4.uW().a(player, f);
    }

    boolean aQ(Player player) {
        BoolLongBlockData boolLongBlockData = this.aM(player);
        return boolLongBlockData.Bh != null && System.currentTimeMillis() - boolLongBlockData.Bh < 150L;
    }

    private void aR(@Nullable Player player) {
        if (MaterialBarColorHolder.cG || MaterialBarColorHolder.cI || MaterialBarColorHolder.cH) {
            BlockRegistry.tg().bH(player);
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
        BoolLongBlockData boolLongBlockData = this.aM(blockDamageEvent.getPlayer());
        boolLongBlockData.Bi = blockDamageEvent.getPlayer().getGameMode() != GameMode.CREATIVE && blockDamageEvent.getInstaBreak() ? blockDamageEvent.getBlock() : null;
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            BoolLongBlockData boolLongBlockData = this.aM(playerAnimationEvent.getPlayer());
            boolLongBlockData.Bh = System.currentTimeMillis();
            if (boolLongBlockData.Bk != null && boolLongBlockData.Bk.lw()) {
                boolLongBlockData.Bk = null;
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        Material material = block.getType();
        BoolLongBlockData boolLongBlockData = this.aM(blockBreakEvent.getPlayer());
        Block block2 = boolLongBlockData.Bi;
        boolLongBlockData.Bi = null;
        if (material == Material.TRIPWIRE) {
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (blockBridge_9.isCustomBlock(block)) {
                blockBreakEvent.setCancelled(true);
                Player player = blockBreakEvent.getPlayer();
                this.aP(player);
                this.aN(player);
                this.a(blockBridge_9, player, block);
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
