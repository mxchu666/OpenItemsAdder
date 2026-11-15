package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import itemsadder.m.BlockHolder;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_50;
import itemsadder.m.PacketListener_51;
import itemsadder.m.PluginContract;
import itemsadder.m.WorldBlockHolder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.GameEvent;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.GenericGameEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class GenericGameListener
implements PluginContract {
    private final PacketAdapter Al;
    private final PacketAdapter Am;
    Map An = new HashMap();
    Map Ao = new HashMap();
    Map Ap = Collections.synchronizedMap(new HashMap());

    public GenericGameListener() {
        if (Main.cP("BlockSounds")) {
            CommandSenderBridge_5.error("Disabled BlockSounds to avoid issues. Please uninstall it.");
            CommandSenderBridge_5.error("ItemsAdder now supports custom block sounds natively.");
            CommandSenderBridge_5.error("To enable custom block sounds please run /iazip to regenerate the resourcepack.");
        }
        ListenerBridge.a(this, (Plugin)Main.rS());
        this.Al = new PacketListener_50(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.NAMED_SOUND_EFFECT}));
        PacketListenerRegistry.b((PacketListener)this.Al);
        this.Am = new PacketListener_51(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Client.BLOCK_DIG}));
        PacketListenerRegistry.b((PacketListener)this.Am);
        this.ls();
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        PacketListenerRegistry.c((PacketListener)this.Al);
        PacketListenerRegistry.c((PacketListener)this.Am);
    }

    private void ls() {
        this.Ao.clear();
        this.An.clear();
        b.a("internal/custom_blocks_sounds.json", (T b2) -> {
            JSONObject jSONObject = b2.BQ();
            block0: for (Map.Entry entry : jSONObject.entrySet()) {
                if (((String)entry.getKey()).startsWith("internal.")) continue;
                String string = "minecraft:" + (String)entry.getKey();
                String string2 = "minecraft:internal." + (String)entry.getKey();
                this.An.put(string, PacketListenerRegistry.uN().dI(string2));
                for (Sound sound : Sound.values()) {
                    if (!sound.getKey().toString().equals(string)) continue;
                    this.Ao.put(sound, string2);
                    continue block0;
                }
            }
        }, (T b2) -> CommandSenderBridge_5.error("Unable to read custom_blocks_sounds.json file from the plugin Jar. Try to redownload the plugin. Error: " + String.valueOf(b2.BO())));
    }

    @EventHandler
    private void a(GenericGameEvent genericGameEvent) {
        if (!MaterialBarColorHolder.fm) {
            return;
        }
        GameEvent gameEvent = genericGameEvent.getEvent();
        if (gameEvent != GameEvent.STEP) {
            return;
        }
        if (!genericGameEvent.getLocation().isWorldLoaded()) {
            return;
        }
        Entity entity = genericGameEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player)entity;
        if (player.isSneaking()) {
            return;
        }
        entity = GenericGameListener.E((Entity)player);
        boolean bl = ItemStackRegistry.g().a((Block)entity, arg_0 -> GenericGameListener.d((Block)entity, arg_0));
        if (!bl) {
            this.u((Block)entity);
        }
    }

    @EventHandler
    private void b(EntityDamageEvent entityDamageEvent) {
        if (!MaterialBarColorHolder.fn) {
            return;
        }
        if (entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        Entity entity = entityDamageEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player)entity;
        entity = GenericGameListener.E((Entity)player);
        boolean bl = ItemStackRegistry.g().a((Block)entity, arg_0 -> GenericGameListener.c((Block)entity, arg_0));
        if (!bl) {
            this.v((Block)entity);
        }
    }

    @EventHandler
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        if (!MaterialBarColorHolder.fn) {
            return;
        }
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        Player player = playerAnimationEvent.getPlayer();
        WorldBlockHolder worldBlockHolder = (WorldBlockHolder)this.Ap.get(player);
        if (worldBlockHolder == null || !worldBlockHolder.lt()) {
            return;
        }
        worldBlockHolder.lu();
        Block block = worldBlockHolder.Ae;
        if (!LocationBridge_2.br(block)) {
            return;
        }
        boolean bl = ItemStackRegistry.g().a(block, locationBridgeBuilder_2 -> locationBridgeBuilder_2.xu.HR.f(player, block.getLocation()));
        if (!bl) {
            this.b(player, block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (!MaterialBarColorHolder.fn) {
            return;
        }
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        boolean bl = ItemStackRegistry.g().a(block, locationBridgeBuilder_2 -> locationBridgeBuilder_2.xu.HR.a(block.getLocation(), SoundCategory.BLOCKS));
        if (!bl) {
            this.s(block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockPlaceEvent blockPlaceEvent) {
        if (!MaterialBarColorHolder.fn) {
            return;
        }
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        Block block = blockPlaceEvent.getBlock();
        boolean bl = ItemStackRegistry.g().a(block, locationBridgeBuilder_2 -> locationBridgeBuilder_2.xu.HQ.a(block.getLocation(), SoundCategory.BLOCKS));
        if (!bl) {
            this.t(block);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.Ap.remove(playerQuitEvent.getPlayer());
    }

    private void s(Block block) {
        this.a(block, BlockHolder.tl().E(block.getType()), 1.0f, 0.8f);
    }

    private void t(Block block) {
        this.a(block, BlockHolder.tl().F(block.getType()), 1.0f, 0.8f);
    }

    private void b(Player player, Block block) {
        this.a(player, block, BlockHolder.tl().G(block.getType()), 0.25f, 0.5f);
    }

    private void u(Block block) {
        this.a(block, BlockHolder.tl().H(block.getType()), 0.15f, 1.0f);
    }

    private void v(Block block) {
        this.a(block, BlockHolder.tl().I(block.getType()), 0.5f, 0.75f);
    }

    private void a(Block block, Sound sound, float f, float f2) {
        if (sound == null) {
            return;
        }
        @Nullable String string = (String)this.Ao.get(sound);
        if (string == null) {
            return;
        }
        LocationBridge_3.a(block.getLocation(), string, SoundCategory.BLOCKS, f, f2);
    }

    private void a(Player player, Block block, Sound sound, float f, float f2) {
        if (sound == null) {
            return;
        }
        @Nullable String string = (String)this.Ao.get(sound);
        if (string == null) {
            return;
        }
        LocationBridge_3.a(player, block.getLocation(), string, SoundCategory.BLOCKS, f, f2);
    }

    private static Block E(Entity entity) {
        return entity.getLocation().subtract(0.0, (double)0.2f, 0.0).getBlock();
    }

    private static /* synthetic */ void c(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        locationBridgeBuilder_2.xu.HT.a(block.getLocation(), SoundCategory.BLOCKS);
    }

    private static /* synthetic */ void d(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        locationBridgeBuilder_2.xu.HS.a(block.getLocation(), SoundCategory.BLOCKS);
    }
}
