package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.aaf;
import itemsadder.m.abk;
import itemsadder.m.ae;
import itemsadder.m.aqp;
import itemsadder.m.bay;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bdf;
import itemsadder.m.beu;
import itemsadder.m.bev;
import itemsadder.m.bfo;
import itemsadder.m.bfp;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.lg;
import itemsadder.m.li;
import itemsadder.m.lj;
import itemsadder.m.lq;
import itemsadder.m.lw;
import itemsadder.m.mg;
import itemsadder.m.ms;
import itemsadder.m.my;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.ra;
import itemsadder.m.sd;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class lh
extends lq {
    lj Aj;
    private static final beu Ak = beu.s(Player.class);

    public lh() {
        super(50);
        if (ae.fl) {
            this.Aj = new lj();
        }
        bev.a(this, (Plugin)Main.rS());
        lw.lF().register();
        d.g().ar.a(new my(PlayerInteractEvent.class, this::h));
        d.g().ar.a(new my(PlayerInteractEvent.class, this::i));
    }

    public static boolean aI(Player player) {
        return Ak.contains(player);
    }

    public static void g(Player player, boolean bl) {
        if (bl) {
            Ak.add(player);
        } else {
            Ak.remove(player);
        }
    }

    @Override
    public void unregister() {
        super.unregister();
        lw.lF().unregister();
        if (this.Aj != null) {
            this.Aj.unregister();
        }
        Ak.clear();
    }

    private void h(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        this.a(playerInteractEvent, qm2, itemStack, true, true);
    }

    public boolean a(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack, boolean bl, boolean bl2) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return false;
        }
        if (playerInteractEvent.getPlayer().getGameMode() == GameMode.ADVENTURE || playerInteractEvent.getPlayer().getGameMode() == GameMode.SPECTATOR) {
            return false;
        }
        if (!(qm2 instanceof ra)) {
            return false;
        }
        if (itemStack.getType().isBlock()) {
            return false;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (bl2 && block.getType() == Material.NOTE_BLOCK) {
            return false;
        }
        boolean bl3 = this.a(playerInteractEvent, block, qm2, block, itemStack, bl);
        if (!bl3) {
            return this.a(playerInteractEvent, block.getRelative(playerInteractEvent.getBlockFace()), qm2, block, itemStack, bl);
        }
        return bl3;
    }

    private boolean a(PlayerInteractEvent playerInteractEvent, Block block, qm qm2, Block block2, ItemStack itemStack, boolean bl) {
        ra ra2 = (ra)qm2;
        Player player = playerInteractEvent.getPlayer();
        if (aaf.aJ(block) && s.c((HumanEntity)player, ra2.kM()) && bcc.b(block, player)) {
            if (bcc.e(player, block)) {
                playerInteractEvent.setUseItemInHand(Event.Result.DENY);
                return false;
            }
            if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && d.g().b(player.getItemInHand())) {
                playerInteractEvent.setUseItemInHand(Event.Result.DENY);
                return false;
            }
            li li2 = this.a(player, itemStack, ra2, block, block2, playerInteractEvent.getBlockFace(), false, false);
            if (li2 == li.PLACED) {
                if (bl && player.getGameMode() != GameMode.CREATIVE) {
                    playerInteractEvent.getItem().setAmount(playerInteractEvent.getItem().getAmount() - 1);
                }
                aqp.a(player, playerInteractEvent.getHand());
                Block block3 = block.getRelative(BlockFace.UP);
                if (aaf.aM(block3)) {
                    abk.aV(block3);
                } else {
                    Block block4 = block.getRelative(BlockFace.DOWN);
                    if (aaf.aM(block4)) {
                        abk.aV(block4);
                    }
                }
                return true;
            }
        } else {
            playerInteractEvent.setUseItemInHand(Event.Result.DENY);
        }
        return false;
    }

    private void i(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        if (playerInteractEvent.getPlayer().getGameMode() == GameMode.ADVENTURE || playerInteractEvent.getPlayer().getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (!(qm2 instanceof ql)) {
            return;
        }
        ql ql2 = (ql)qm2;
        if (ql2.FD != null && !ql2.FD.Jd && !ql2.FD.Je) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        bfo bfo2 = new bfo(player, 5.0);
        bfo2.be(true);
        if (!bfo2.a(bfp.BLOCK)) {
            return;
        }
        if (!bfo2.EG()) {
            return;
        }
        Block block = bfo2.EF();
        Block block2 = block.getRelative(BlockFace.UP);
        if (block2.getType() != Material.AIR) {
            return;
        }
        if (ql2.FD.Jd && block.getType() == Material.WATER || ql2.FD.Je && block.getType() == Material.LAVA) {
            if (bcc.b(block2, playerInteractEvent.getPlayer()) && aaf.aJ(block2)) {
                if (bcc.e(playerInteractEvent.getPlayer(), block2)) {
                    playerInteractEvent.setCancelled(true);
                    return;
                }
                if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && d.g().b(playerInteractEvent.getPlayer().getItemInHand())) {
                    playerInteractEvent.setCancelled(true);
                    return;
                }
                if (this.a(playerInteractEvent.getPlayer(), itemStack, (ra)qm2, block2, block, playerInteractEvent.getBlockFace(), true, false) == li.PLACED) {
                    aqp.a(playerInteractEvent.getPlayer(), playerInteractEvent.getHand());
                    if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                        playerInteractEvent.getItem().setAmount(playerInteractEvent.getItem().getAmount() - 1);
                    }
                }
            } else {
                playerInteractEvent.setCancelled(true);
            }
        }
    }

    private li a(Player player, ItemStack itemStack, ra ra2, Block block, Block block2, @Nullable BlockFace blockFace, boolean bl, boolean bl2) {
        li li2 = this.b(player, itemStack, ra2, block, block2, blockFace, bl, bl2);
        if (li2 == li.PLACED) {
            ItemStack itemStack2;
            if (player.getGameMode() != GameMode.CREATIVE && !bbs.at(itemStack2 = player.getInventory().getItemInOffHand()) && itemStack2.getType().isBlock()) {
                aqp.bW(player);
            }
            mg.D(block);
        }
        return li2;
    }

    private li b(Player player, ItemStack itemStack, ra ra2, Block block, Block block2, @Nullable BlockFace blockFace, boolean bl, boolean bl2) {
        Object object;
        ql ql2;
        if (this.aJ(player)) {
            return li.NOT_PLACED;
        }
        if (!player.isSneaking() && lh.a(blockFace, block2.getType()) && !d.isCustomBlock(block2)) {
            return li.NOT_PLACED;
        }
        if (!player.isSneaking() && block2.getType() != Material.NOTE_BLOCK && aaf.aO(block2)) {
            return li.NOT_PLACED_INTERACTABLE;
        }
        if (!bl && ra2.Hq == sd.REAL_WIRE) {
            ql2 = (ql)ra2;
            if (!(ql2.FD != null && ql2.FD.Jc || (object = block.getRelative(BlockFace.DOWN)).getType() != Material.TRIPWIRE && (aaf.aQ((Block)object) || !aaf.aJ((Block)object)))) {
                return li.NOT_PLACED;
            }
        }
        if (ra2.Hq == sd.FIRE) {
            if (block2.getType() != Material.FIRE) {
                if (ra2.f(block, true)) {
                    return li.PLACED;
                }
                return li.NOT_PLACED;
            }
        } else {
            if (!ae.eT.x(block.getWorld())) {
                return li.NOT_PLACED;
            }
            ql2 = (ql)ra2;
            object = new CustomBlockPlaceEvent(player, block, ql2, true, block2, block.getState(), itemStack);
            Bukkit.getPluginManager().callEvent((Event)object);
            if (((CustomBlockPlaceEvent)((Object)object)).isCancelled()) {
                return li.NOT_PLACED;
            }
            boolean bl3 = ql2.a(player, block.getLocation(), blockFace, true, bl2);
            if (bl3) {
                ql2.xu.HQ.f(player, block.getLocation());
            }
            if (ql2.Hq == sd.REAL_TRANSPARENT) {
                d.g();
                d.g().aT.C(block.getLocation());
            }
            if (!bl3) {
                return li.NOT_PLACED;
            }
        }
        this.aK(player);
        return li.PLACED;
    }

    static boolean a(@Nullable BlockFace blockFace, Material material) {
        return blockFace != BlockFace.SELF && material == Material.NOTE_BLOCK;
    }

    public li a(Player player, ItemStack itemStack, Block block, Block block2, @Nullable BlockFace blockFace, boolean bl) {
        ql ql2 = d.g().c(itemStack);
        if (ql2 != null) {
            return this.a(player, itemStack, ql2, block, block2, blockFace, false, bl);
        }
        return li.VANILLA_ITEM_NOT_PLACED;
    }

    public static void b(lg lg2) {
        Block block = lg2.getBlock();
        Player player = lg2.getPlayer();
        ql ql2 = lg2.ln();
        lg2.lo().a(block, true, false);
        bay.bk(lg2.getBlock());
        ql2.FD.T(block.getLocation());
        ItemStack itemStack = bcc.ad(block.getLocation()).iterator();
        while (itemStack.hasNext()) {
            Player player2 = (Player)itemStack.next();
            player2.sendBlockChange(block.getLocation(), block.getBlockData());
            ql2.xu.HP.f(player2, lg2.getBlock().getLocation());
        }
        if (ae.cT) {
            try {
                abk.tl().aZ(block);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                // empty catch block
            }
        }
        if (ae.cU) {
            abk.tl().aX(block);
        }
        if (!bbs.af(itemStack = player.getInventory().getItemInMainHand())) {
            ql2.a((LivingEntity)player, jj.PLACED_BLOCK_BREAK, ou2 -> ou2.a(lg2, (qm)ql2, null));
        }
        if (player.getGameMode() != GameMode.CREATIVE && lg2.lp()) {
            if (!ql2.mG()) {
                if (bbs.af(itemStack)) {
                    if (ql2.mH()) {
                        lg2.ad(true);
                        bdf.b(block.getLocation(), ql2);
                    }
                } else if (itemStack.getType() == Material.SHEARS && ql2.mI()) {
                    lg2.ad(true);
                    bdf.b(block.getLocation(), ql2);
                }
            } else {
                bdf.b(block.getLocation(), ql2);
            }
        }
    }

    public static void a(ms ms2, Block block, ql ql2) {
        ms2.a(block, true, false);
        bay.bk(block);
        ql2.FD.T(block.getLocation());
        for (Player player : bcc.ad(block.getLocation())) {
            player.sendBlockChange(block.getLocation(), block.getBlockData());
            ql2.xu.HP.f(player, block.getLocation());
        }
        if (ae.cT) {
            try {
                abk.tl().aZ(block);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                // empty catch block
            }
        }
        if (ae.cU) {
            abk.tl().aX(block);
        }
        if (ql2.mG()) {
            bdf.b(block.getLocation(), ql2);
        }
    }

    public static void a(Block block, Material material) {
        if (material == Material.SPAWNER) {
            block.getWorld().spawnParticle(Particle.BLOCK, block.getLocation().clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)Material.OBSIDIAN.createBlockData());
        } else {
            abk.aW(block);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(lg lg2) {
        lh.b(lg2);
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    void b(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        Player player = blockPlaceEvent.getPlayer();
        if (blockPlaceEvent.getHand() == EquipmentSlot.OFF_HAND && d.g().b(player.getItemInHand())) {
            blockPlaceEvent.setCancelled(true);
            return;
        }
        ItemStack itemStack = blockPlaceEvent.getItemInHand().clone();
        Block block = blockPlaceEvent.getBlockAgainst();
        Block block2 = blockPlaceEvent.getBlockPlaced();
        BlockFace blockFace = block.getFace(block2);
        li li2 = this.a(blockPlaceEvent.getPlayer(), itemStack, blockPlaceEvent.getBlock(), blockPlaceEvent.getBlockAgainst(), blockFace, true);
        if (li2 == li.NOT_PLACED) {
            blockPlaceEvent.setCancelled(true);
        }
        lh.g(blockPlaceEvent.getPlayer(), li2 == li.PLACED);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void d(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!ql.av(block)) {
            return;
        }
        Material material = block.getType();
        ms ms2 = d.g().b(block);
        if (ms2.isCustomBlock(block)) {
            boolean bl;
            blockBreakEvent.setCancelled(true);
            Player player = blockBreakEvent.getPlayer();
            if (player.getGameMode() != GameMode.CREATIVE && material == Material.TRIPWIRE) {
                return;
            }
            ql ql2 = d.g().h(ms2.Y(block));
            if (ql2 == null) {
                blockBreakEvent.setCancelled(false);
                return;
            }
            if (player.getGameMode() != GameMode.CREATIVE) {
                if (ae.dD) {
                    bce.warn("Player '" + player.getName() + "' somehow tried to break a custom block even when not normally possible. They are probably hacking or using Minecraft Bedrock client (Geyser).");
                }
                return;
            }
            Location location = block.getLocation();
            if (material == Material.NOTE_BLOCK) {
                d.g();
                d.g().aT.B(location);
            }
            ql2.FD.T(block.getLocation());
            boolean bl2 = bl = !bev.b((Event)new CustomBlockBreakEvent(player, block, ql2));
            if (!bl) {
                ms2.a(block, true, false);
                bay.bk(block);
            }
            if (player.getGameMode() == GameMode.CREATIVE) {
                for (Player player2 : bcc.ad(location)) {
                    player2.sendBlockChange(location, block.getBlockData());
                }
                ql2.xu.HP.a(location, SoundCategory.BLOCKS);
            }
            d.g();
            d.g().aT.a(location, false);
            if (!bl) {
                if (ae.cT) {
                    try {
                        abk.tl().aZ(block);
                    }
                    catch (NoSuchMethodError noSuchMethodError) {
                        // empty catch block
                    }
                }
                if (ae.cU) {
                    abk.tl().aX(block);
                }
            }
        } else if (material == Material.SPAWNER || ae.cG && ql.h(material) || ae.cI && ql.m(material) || ae.cH && ql.l(material)) {
            lh.a(block, material);
            if (ae.cT) {
                try {
                    abk.tl().aZ(block);
                }
                catch (NoSuchMethodError noSuchMethodError) {
                    // empty catch block
                }
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void f(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (block == null) {
            return;
        }
        if (d.g().aE.aJ(playerInteractEvent.getPlayer())) {
            return;
        }
        if (!ProtectionPlugins.canInteract_placedBlock(playerInteractEvent)) {
            return;
        }
        if (ql.av(block)) {
            d.g();
            ms ms2 = d.g().b(block);
            if (!ms2.isCustomBlock(block)) {
                return;
            }
            d.g();
            ql ql2 = d.g().h(ms2.Y(block));
            if (ql2 == null) {
                return;
            }
            CustomBlockInteractEvent customBlockInteractEvent = new CustomBlockInteractEvent(playerInteractEvent.getPlayer(), playerInteractEvent.getAction(), playerInteractEvent.getItem(), block, playerInteractEvent.getBlockFace(), playerInteractEvent.getHand(), ql2);
            Bukkit.getPluginManager().callEvent((Event)customBlockInteractEvent);
            if (customBlockInteractEvent.isCancelled()) {
                playerInteractEvent.setCancelled(true);
                return;
            }
            ql2.a((LivingEntity)playerInteractEvent.getPlayer(), jj.PLACED_BLOCK_INTERACT, ou2 -> ou2.j(playerInteractEvent, ql2, ql2.mP()));
        }
    }
}
