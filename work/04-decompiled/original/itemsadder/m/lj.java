package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import itemsadder.m.abk;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.aow;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcv;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.lk;
import itemsadder.m.ll;
import itemsadder.m.ln;
import itemsadder.m.ql;
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

public class lj
implements ai {
    private final PacketAdapter Al;
    private final PacketAdapter Am;
    Map An = new HashMap();
    Map Ao = new HashMap();
    Map Ap = Collections.synchronizedMap(new HashMap());

    public lj() {
        if (Main.cP("BlockSounds")) {
            bce.error("Disabled BlockSounds to avoid issues. Please uninstall it.");
            bce.error("ItemsAdder now supports custom block sounds natively.");
            bce.error("To enable custom block sounds please run /iazip to regenerate the resourcepack.");
        }
        bev.a(this, (Plugin)Main.rS());
        this.Al = new lk(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.NAMED_SOUND_EFFECT}));
        aow.b((PacketListener)this.Al);
        this.Am = new ll(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Client.BLOCK_DIG}));
        aow.b((PacketListener)this.Am);
        this.ls();
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        aow.c((PacketListener)this.Al);
        aow.c((PacketListener)this.Am);
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
                this.An.put(string, aow.uN().dI(string2));
                for (Sound sound : Sound.values()) {
                    if (!sound.getKey().toString().equals(string)) continue;
                    this.Ao.put(sound, string2);
                    continue block0;
                }
            }
        }, (T b2) -> bce.error("Unable to read custom_blocks_sounds.json file from the plugin Jar. Try to redownload the plugin. Error: " + String.valueOf(b2.BO())));
    }

    @EventHandler
    private void a(GenericGameEvent genericGameEvent) {
        if (!ae.fm) {
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
        entity = lj.E((Entity)player);
        boolean bl = d.g().a((Block)entity, arg_0 -> lj.d((Block)entity, arg_0));
        if (!bl) {
            this.u((Block)entity);
        }
    }

    @EventHandler
    private void b(EntityDamageEvent entityDamageEvent) {
        if (!ae.fn) {
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
        entity = lj.E((Entity)player);
        boolean bl = d.g().a((Block)entity, arg_0 -> lj.c((Block)entity, arg_0));
        if (!bl) {
            this.v((Block)entity);
        }
    }

    @EventHandler
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        if (!ae.fn) {
            return;
        }
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        Player player = playerAnimationEvent.getPlayer();
        ln ln2 = (ln)this.Ap.get(player);
        if (ln2 == null || !ln2.lt()) {
            return;
        }
        ln2.lu();
        Block block = ln2.Ae;
        if (!bcc.br(block)) {
            return;
        }
        boolean bl = d.g().a(block, ql2 -> ql2.xu.HR.f(player, block.getLocation()));
        if (!bl) {
            this.b(player, block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (!ae.fn) {
            return;
        }
        if (bev.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        boolean bl = d.g().a(block, ql2 -> ql2.xu.HR.a(block.getLocation(), SoundCategory.BLOCKS));
        if (!bl) {
            this.s(block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockPlaceEvent blockPlaceEvent) {
        if (!ae.fn) {
            return;
        }
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        Block block = blockPlaceEvent.getBlock();
        boolean bl = d.g().a(block, ql2 -> ql2.xu.HQ.a(block.getLocation(), SoundCategory.BLOCKS));
        if (!bl) {
            this.t(block);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.Ap.remove(playerQuitEvent.getPlayer());
    }

    private void s(Block block) {
        this.a(block, abk.tl().E(block.getType()), 1.0f, 0.8f);
    }

    private void t(Block block) {
        this.a(block, abk.tl().F(block.getType()), 1.0f, 0.8f);
    }

    private void b(Player player, Block block) {
        this.a(player, block, abk.tl().G(block.getType()), 0.25f, 0.5f);
    }

    private void u(Block block) {
        this.a(block, abk.tl().H(block.getType()), 0.15f, 1.0f);
    }

    private void v(Block block) {
        this.a(block, abk.tl().I(block.getType()), 0.5f, 0.75f);
    }

    private void a(Block block, Sound sound, float f2, float f3) {
        if (sound == null) {
            return;
        }
        @Nullable String string = (String)this.Ao.get(sound);
        if (string == null) {
            return;
        }
        bcv.a(block.getLocation(), string, SoundCategory.BLOCKS, f2, f3);
    }

    private void a(Player player, Block block, Sound sound, float f2, float f3) {
        if (sound == null) {
            return;
        }
        @Nullable String string = (String)this.Ao.get(sound);
        if (string == null) {
            return;
        }
        bcv.a(player, block.getLocation(), string, SoundCategory.BLOCKS, f2, f3);
    }

    private static Block E(Entity entity) {
        return entity.getLocation().subtract(0.0, (double)0.2f, 0.0).getBlock();
    }

    private static /* synthetic */ void c(Block block, ql ql2) {
        ql2.xu.HT.a(block.getLocation(), SoundCategory.BLOCKS);
    }

    private static /* synthetic */ void d(Block block, ql ql2) {
        ql2.xu.HS.a(block.getLocation(), SoundCategory.BLOCKS);
    }
}
