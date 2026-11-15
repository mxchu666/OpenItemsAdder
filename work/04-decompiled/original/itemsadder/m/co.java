package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import itemsadder.m.ae;
import itemsadder.m.aow;
import itemsadder.m.baw;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.bm;
import itemsadder.m.bo;
import itemsadder.m.br;
import itemsadder.m.bx;
import itemsadder.m.cd;
import itemsadder.m.ce;
import itemsadder.m.cg;
import itemsadder.m.ci;
import itemsadder.m.cj;
import itemsadder.m.cm;
import itemsadder.m.cp;
import itemsadder.m.cq;
import itemsadder.m.cr;
import itemsadder.m.cs;
import itemsadder.m.ct;
import itemsadder.m.cu;
import itemsadder.m.cw;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.w;
import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class co
implements Listener {
    private static NamespacedKey kL;
    private static final Map kM;
    private static final Map kN;
    public br kO;
    private cm kP;
    public ce kQ;
    private volatile boolean kR;

    public void onEnable() {
        kL = new NamespacedKey((Plugin)Main.rS(), "lightweight_crops_enabled");
        this.kO = new br((Plugin)Main.rS());
        this.kP = new cm((Plugin)Main.rS(), this.kO, 1);
        this.kQ = new ce(this);
        aow.a((PacketListener)new cp(this, (Plugin)Main.rS(), ListenerPriority.LOWEST, PacketType.Play.Client.BLOCK_DIG));
        aow.a((PacketListener)new cq(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Server.MAP_CHUNK));
        aow.a((PacketListener)new cr(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Server.UNLOAD_CHUNK));
        aow.a((PacketListener)new cs(this, (Plugin)Main.rS(), ListenerPriority.MONITOR, PacketType.Play.Server.RESPAWN));
        if (Version.isAtLeast((Version)Version.v1_21_4) && zw.b(PacketType.Play.Client.class, "PICK_ITEM_FROM_BLOCK") != null) {
            aow.a((PacketListener)new ct(this, (Plugin)Main.rS(), PacketType.Play.Client.PICK_ITEM_FROM_BLOCK));
        }
        bev.b(this, (Plugin)Main.rS());
        this.cS();
        Bukkit.getOnlinePlayers().forEach(co::L);
    }

    public void cS() {
        this.kP.bU();
        this.kQ.bU();
        if (this.kO != null) {
            this.kO.bq();
        }
        this.kQ.bT();
        this.kP.bT();
        ArrayList<Chunk> arrayList = new ArrayList<Chunk>();
        for (World world : Bukkit.getWorlds()) {
            for (Chunk chunk : world.getLoadedChunks()) {
                if (!br.h(chunk)) continue;
                arrayList.add(chunk);
            }
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        new cu(this, atomicInteger, arrayList).runTaskTimer((Plugin)Main.rS(), 0L, 2L);
    }

    public void bU() {
        if (this.kP != null) {
            this.kP.bU();
        }
        if (this.kQ != null) {
            this.kQ.bU();
        }
        if (this.kO != null) {
            this.kO.bq();
        }
    }

    public void O() {
        if (!this.cT()) {
            return;
        }
        this.bU();
        bev.b(this);
        aow.l(this);
    }

    boolean cT() {
        if (this.kR) {
            return false;
        }
        this.kR = true;
        return true;
    }

    boolean cU() {
        return !this.kR;
    }

    public static boolean L(Player player) {
        if (kM.containsKey(player)) {
            return (Boolean)kM.get(player);
        }
        co.d(player, false);
        return false;
    }

    public static void d(Player player, boolean bl) {
        player.getPersistentDataContainer().set(kL, PersistentDataType.BOOLEAN, (Object)bl);
        kM.put(player, bl);
    }

    public boolean M(@NotNull Player player) {
        return System.currentTimeMillis() - kN.getOrDefault(player, 0L) < 60L;
    }

    private void N(Player player) {
        kN.put(player, System.currentTimeMillis());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(PlayerInteractEvent playerInteractEvent) {
        Block block;
        Player player = playerInteractEvent.getPlayer();
        Block block2 = playerInteractEvent.getClickedBlock();
        if (playerInteractEvent.getHand() == null) {
            return;
        }
        if (co.L(player)) {
            if (block2 == null) {
                return;
            }
            block = block2;
            if (block2.getType() == Material.AIR) {
                if (playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
                    this.a(block, null, player, true);
                    return;
                }
            } else {
                block = block2.getRelative(playerInteractEvent.getBlockFace());
            }
        } else {
            cj cj2;
            ci ci2 = this.kO.A(player);
            cj cj3 = cj2 = ci2 == null ? null : ci2.c(player, false);
            if (cj2 != null) {
                block = cj2.getBlock();
                playerInteractEvent.setCancelled(true);
            } else {
                if (block2 == null) {
                    return;
                }
                block = block2.getRelative(playerInteractEvent.getBlockFace());
            }
        }
        this.a(player, playerInteractEvent.getHand(), null, block, playerInteractEvent.getItem(), bev.s(playerInteractEvent), playerInteractEvent);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerInteractEntityEvent playerInteractEntityEvent) {
        Object object = playerInteractEntityEvent.getRightClicked();
        if (!(object instanceof Interaction)) {
            return;
        }
        Interaction interaction = (Interaction)object;
        object = this.a(playerInteractEntityEvent.getPlayer(), interaction);
        if (object == null) {
            return;
        }
        playerInteractEntityEvent.setCancelled(true);
        this.a(playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getHand(), interaction, ((cj)object).getBlock(), null, false, null);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        Player player;
        Object object;
        block5: {
            block4: {
                object = entityDamageByEntityEvent.getDamager();
                if (!(object instanceof Player)) break block4;
                player = (Player)object;
                object = entityDamageByEntityEvent.getEntity();
                if (object instanceof Interaction) break block5;
            }
            return;
        }
        Interaction interaction = (Interaction)object;
        object = this.a(player, interaction);
        if (object == null) {
            return;
        }
        entityDamageByEntityEvent.setCancelled(true);
        this.a(((cj)object).getBlock(), (cj)object, player, true);
    }

    @Nullable
    private cj a(Player player, Interaction interaction) {
        cg cg2 = this.kQ.F(player);
        ci ci2 = this.kO.A(player);
        if (cg2 == null || ci2 == null || !cg2.a(interaction) || cg2.jl == null) {
            return null;
        }
        cj cj2 = ci2.c(player, false);
        if (cj2 == null || !cj2.getBlock().equals((Object)cg2.jl.getBlock())) {
            return null;
        }
        cg2.cj();
        return cj2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(Player player, EquipmentSlot equipmentSlot, @Nullable Interaction interaction, @Nullable Block block, @Nullable ItemStack itemStack, boolean bl, @Nullable PlayerInteractEvent playerInteractEvent) {
        if (player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (interaction == null && block == null) {
            throw new IllegalArgumentException("Either interaction or targetBlock must be non-null");
        }
        if (interaction != null && block == null) {
            block = interaction.getLocation().getBlock();
        }
        if (itemStack == null) {
            itemStack = player.getInventory().getItem(equipmentSlot);
        }
        try {
            qm qm2;
            bx bx2;
            Object object;
            Object object2;
            @Nullable bo bo2 = this.kO.f(block);
            ci ci2 = this.kO.A(player);
            if (bo2 != null && (object2 = this.kQ.F(player)) != null) {
                ((cg)object2).cj();
                if (bl) {
                    ((cg)object2).cl();
                }
            }
            if (ci2 != null && itemStack.getType() == Material.BONE_MEAL && !bl && bo2 != null) {
                object2 = (bx)d.g().ab.get(bo2.bj());
                if (object2 == null) {
                    bce.warn(player.getName() + " interacted with an unknown crop '" + bo2.bj() + "' at " + bcc.b(block.getLocation(), true));
                    return;
                }
                int n = Math.min(bo2.bk() + (int)Math.ceil((float)((bx)object2).hK * ((bx)object2).hS), ((bx)object2).hK);
                if (bo2.bk() < ((bx)object2).hK) {
                    if (player.getGameMode() != GameMode.CREATIVE) {
                        bbs.aj(itemStack);
                    }
                    this.kO.a(block, bo2.bj(), n);
                    baw.bh(block);
                    ce.a(player, true);
                    return;
                }
            }
            object2 = block.getLocation();
            if (ci2 != null && equipmentSlot == EquipmentSlot.HAND && bo2 != null) {
                if (!bcc.a(object2.getBlock().getRelative(BlockFace.DOWN), player)) {
                    return;
                }
                if (bl) {
                    cj cj2 = ci2.K(player);
                    if (cj2 != null && (object = cj2.kg) instanceof ItemDisplay && !this.a((Block)(object = (bx2 = object).getLocation().getBlock()), cj2, player, true)) {
                        return;
                    }
                } else {
                    bx bx3 = (bx)d.g().ab.get(bo2.bj());
                    if (bx3 == null) {
                        return;
                    }
                    if (bx3.a(player, bo2.bk(), (Location)object2, cd.INTERACT, true)) {
                        return;
                    }
                }
            }
            if ((qm2 = d.g().a(itemStack)) != null && !bl) {
                bx2 = (bx)d.g().ac.get(qm2);
                if (bx2 == null) {
                    return;
                }
                if (!block.getType().isAir() && !block.isReplaceable()) {
                    return;
                }
                if (!bx2.j(block)) {
                    return;
                }
                if (!object2.getBlock().getType().isAir()) {
                    return;
                }
                if (!bx2.i(object2.getBlock())) {
                    return;
                }
                if (equipmentSlot == EquipmentSlot.HAND && bo2 != null) {
                    return;
                }
                if (!bcc.b(object2.getBlock(), player)) {
                    return;
                }
                if (this.a((Location)object2, bx2)) {
                    object2.getWorld().spawnParticle(Particle.SMOKE, object2.add(0.5, 0.5, 0.5), 10, 0.3, 0.3, 0.3, 0.01);
                    return;
                }
                if (this.m((Location)object2)) {
                    object2.getWorld().spawnParticle(Particle.SMOKE, object2.add(0.5, 0.5, 0.5), 10, 0.3, 0.3, 0.3, 0.01);
                    object = this.l((Location)object2);
                    if (object != null) {
                        bce.a((CommandSender)player, "max-crops-reached-directions", arg_0 -> co.a((cw)object, arg_0));
                    } else {
                        bce.g((CommandSender)player, "max-crops-reached-no-directions");
                    }
                    return;
                }
                if (playerInteractEvent != null) {
                    playerInteractEvent.setCancelled(true);
                }
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    bbs.aj(itemStack);
                }
                this.kO.a(object2.getBlock(), bx2.hD, 0);
                bx2.f((Location)object2);
                if (equipmentSlot == EquipmentSlot.HAND) {
                    player.swingMainHand();
                } else {
                    player.swingOffHand();
                }
                if (ci2 != null) {
                    object = ci2.K(player);
                }
            }
        }
        finally {
            this.a(player, block);
        }
    }

    @Nullable
    private cw l(Location location) {
        int n = ae.ec;
        World world = location.getWorld();
        if (world != null) {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            for (int i = -n; i <= n; ++i) {
                for (int j = -n; j <= n; ++j) {
                    if (!this.kO.a(location.getBlockX() + i, location.getBlockY(), location.getBlockZ() + j, world, false)) continue;
                    n2 += i;
                    n3 += j;
                    ++n4;
                }
            }
            if (n4 > 0) {
                double d2 = (double)n2 / (double)n4;
                double d3 = (double)n3 / (double)n4;
                double d4 = -d2;
                double d5 = -d3;
                double d6 = Math.toDegrees(Math.atan2(d5, d4)) + 180.0;
                String[] stringArray = new String[]{"west", "north-west", "north", "north-east", "east", "south-east", "south", "south-west"};
                int n5 = (int)Math.round(d6 / 45.0) % 8;
                String string = stringArray[n5];
                double d7 = (double)n - Math.sqrt(d2 * d2 + d3 * d3);
                if (d7 < 1.0) {
                    d7 = 1.0;
                }
                return new cw(d7, string);
            }
        }
        return null;
    }

    public boolean m(Location location) {
        int n = ae.ec;
        int n2 = ae.eb;
        World world = location.getWorld();
        if (world == null) {
            return false;
        }
        int n3 = 0;
        HashSet<Long> hashSet = new HashSet<Long>();
        int n4 = (int)Math.ceil((double)n / 16.0);
        int n5 = location.getBlockX() >> 4;
        int n6 = location.getBlockZ() >> 4;
        for (int i = n5 - n4; i <= n5 + n4; ++i) {
            for (int j = n6 - n4; j <= n6 + n4; ++j) {
                long l = (long)i << 32 | (long)j & 0xFFFFFFFFL;
                if (hashSet.contains(l)) continue;
                hashSet.add(l);
                Chunk chunk = world.getChunkAt(i, j);
                bm bm2 = this.kO.c(chunk);
                if (bm2 == null) continue;
                if (bm2.size() >= n2) {
                    return true;
                }
                if ((n3 += bm2.size()) < n2) continue;
                return true;
            }
        }
        return false;
    }

    private boolean a(Location location, bx bx2) {
        if (bx2.hR == null || bx2.hR <= 0) {
            return false;
        }
        World world = location.getWorld();
        if (world == null) {
            return false;
        }
        int n = bx2.hR;
        int n2 = location.getBlockX();
        int n3 = location.getBlockY();
        int n4 = location.getBlockZ();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                Block block;
                int n5;
                if (i == 0 && j == 0 || (n5 = Math.max(Math.abs(i), Math.abs(j))) >= n || !bcc.h(world, n2 + i >> 4, n4 + j >> 4) || !this.kO.g(block = world.getBlockAt(n2 + i, n3, n4 + j))) continue;
                return true;
            }
        }
        return false;
    }

    private void a(Player player, Block block) {
        bo bo2;
        if (co.L(player) && (bo2 = this.kO.f(block)) != null) {
            bcp.c(() -> {
                if (!this.cU()) {
                    return;
                }
                this.kO.a(player, block.getLocation(), bo2);
            }, 3L);
        }
    }

    @EventHandler
    private void b(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        Player player = playerAnimationEvent.getPlayer();
        cg cg2 = this.kQ.F(player);
        if (cg2 != null) {
            cg2.cj();
            cg2.cl();
        }
        this.O(player);
    }

    void b(Player player, cg cg2) {
        if (cg2.cm()) {
            this.O(player);
        }
    }

    private void O(Player player) {
        ItemDisplay itemDisplay;
        if (player.getGameMode() == GameMode.CREATIVE && w.bN.n(player)) {
            return;
        }
        if (w.bN.h(player)) {
            return;
        }
        if (w.bN.l(player)) {
            return;
        }
        if (this.M(player)) {
            return;
        }
        ci ci2 = this.kO.A(player);
        if (ci2 == null) {
            return;
        }
        cj cj2 = ci2.K(player);
        if (cj2 != null && (itemDisplay = cj2.kg) instanceof ItemDisplay) {
            ItemDisplay itemDisplay2 = itemDisplay;
            this.a(itemDisplay2.getLocation().getBlock(), cj2, player, true);
        }
    }

    private boolean a(Block block, cj cj2, Player player, boolean bl) {
        Object object;
        bo bo2 = this.kO.f(block);
        if (bo2 == null) {
            return false;
        }
        bx bx2 = (bx)d.g().ab.get(bo2.bj());
        if (bx2 == null) {
            return false;
        }
        if (bl && !bcc.a(block.getRelative(BlockFace.DOWN), player)) {
            return false;
        }
        cg cg2 = this.kQ.F(player);
        if (cg2 != null) {
            cg2.ck();
            cg2.cn();
        }
        if (cj2 != null) {
            object = cj2.cI().cJ();
            ItemStack itemStack = cj2.kg.getItemStack();
            bcp.h(() -> co.a(block, (BoundingBox)object, itemStack));
        }
        this.kO.h(block);
        if (cj2 != null && (object = this.kO.A(player)) != null) {
            ((ci)object).c(cj2.kg.getUniqueId());
        }
        if (cg2 != null) {
            cg2.cr();
        }
        bx2.a(player, bo2.bk(), block.getLocation(), cd.BREAK, true);
        if (co.L(player)) {
            player.sendBlockChange(block.getLocation(), block.getBlockData());
        }
        this.N(player);
        return true;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockFromToEvent blockFromToEvent) {
        bo bo2;
        if (blockFromToEvent.getBlock().getType() == Material.WATER) {
            bo bo3 = this.kO.f(blockFromToEvent.getToBlock());
            if (bo3 != null) {
                this.kO.h(blockFromToEvent.getToBlock());
                bx bx2 = (bx)d.g().ab.get(bo3.bj());
                bx2.a(null, bo3.bk(), blockFromToEvent.getToBlock().getLocation(), cd.WATER, true);
            }
        } else if (blockFromToEvent.getBlock().getType() == Material.LAVA && (bo2 = this.kO.f(blockFromToEvent.getToBlock())) != null) {
            this.kO.h(blockFromToEvent.getToBlock());
            bx bx3 = (bx)d.g().ab.get(bo2.bj());
            bx3.a(null, bo2.bk(), blockFromToEvent.getToBlock().getLocation(), cd.LAVA, true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockPistonExtendEvent blockPistonExtendEvent) {
        Block block = null;
        int n = Integer.MIN_VALUE;
        for (Object object : blockPistonExtendEvent.getBlocks()) {
            int n2 = 0;
            switch (blockPistonExtendEvent.getDirection()) {
                case UP: {
                    n2 = object.getY();
                    break;
                }
                case DOWN: {
                    n2 = -object.getY();
                    break;
                }
                case NORTH: {
                    n2 = -object.getZ();
                    break;
                }
                case SOUTH: {
                    n2 = object.getZ();
                    break;
                }
                case EAST: {
                    n2 = object.getX();
                    break;
                }
                case WEST: {
                    n2 = -object.getX();
                }
            }
            if (n2 <= n) continue;
            n = n2;
            block = object;
        }
        if (this.kO.g(block = Objects.requireNonNullElseGet(block, () -> ((BlockPistonExtendEvent)blockPistonExtendEvent).getBlock()).getRelative(blockPistonExtendEvent.getDirection()))) {
            Object object;
            bo bo2 = this.kO.f(block);
            assert (bo2 != null);
            this.kO.h(block);
            object = (bx)d.g().ab.get(bo2.bj());
            ((bx)object).a(null, bo2.bk(), block.getLocation(), cd.BREAK, true);
            for (Map.Entry entry : kM.entrySet()) {
                Player player = (Player)entry.getKey();
                Boolean bl = (Boolean)entry.getValue();
                if (!bl.booleanValue()) continue;
                this.kO.a(player, block.getLocation(), bo2);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    public void a(BlockFertilizeEvent blockFertilizeEvent) {
        List<BlockState> list;
        if (blockFertilizeEvent.getPlayer() != null && this.kO.g(blockFertilizeEvent.getBlock().getRelative(w.bN.f(blockFertilizeEvent.getPlayer())))) {
            blockFertilizeEvent.setCancelled(true);
        }
        if ((list = blockFertilizeEvent.getBlocks().stream().filter(blockState -> this.kO.g(blockState.getBlock())).toList()).isEmpty()) {
            return;
        }
        blockFertilizeEvent.getBlocks().removeAll(list);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    public void c(PlayerInteractEvent playerInteractEvent) {
        Block block;
        Block block2;
        if (playerInteractEvent.getAction() != Action.PHYSICAL) {
            return;
        }
        if (playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedBlock().getType() == Material.FARMLAND && this.kO.g(block2 = (block = playerInteractEvent.getClickedBlock()).getRelative(0, 1, 0))) {
            bo bo2 = this.kO.f(block2);
            assert (bo2 != null);
            bx bx2 = (bx)d.g().ab.get(bo2.bj());
            this.kO.h(block2);
            bx2.a(null, bo2.bk(), block2.getLocation(), cd.TRAMPLE, true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    public void a(BlockFadeEvent blockFadeEvent) {
        if (blockFadeEvent.getBlock().getType() == Material.FARMLAND) {
            this.k(blockFadeEvent.getBlock());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    public void a(EntityExplodeEvent entityExplodeEvent) {
        for (Block block : entityExplodeEvent.blockList()) {
            this.k(block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    public void a(BlockExplodeEvent blockExplodeEvent) {
        for (Block block : blockExplodeEvent.blockList()) {
            this.k(block);
        }
    }

    private void k(Block block) {
        Block block2 = block.getRelative(0, 1, 0);
        if (this.kO.g(block2)) {
            bo bo2 = this.kO.f(block2);
            assert (bo2 != null);
            bx bx2 = (bx)d.g().ab.get(bo2.bj());
            this.kO.h(block2);
            bx2.a(null, bo2.bk(), block2.getLocation(), cd.FARMLAND_DRY, true);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(BlockCanBuildEvent blockCanBuildEvent) {
        if (this.kO.g(blockCanBuildEvent.getBlock())) {
            blockCanBuildEvent.setBuildable(false);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(CustomBlockPlaceEvent customBlockPlaceEvent) {
        if (this.kO.g(customBlockPlaceEvent.getBlock())) {
            customBlockPlaceEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(BlockBreakEvent blockBreakEvent) {
        Object object;
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
            Block block;
            if (this.M(blockBreakEvent.getPlayer())) {
                blockBreakEvent.setCancelled(true);
                return;
            }
            object = this.kO.A(blockBreakEvent.getPlayer());
            if (object == null) {
                return;
            }
            cj cj2 = ((ci)object).K(blockBreakEvent.getPlayer());
            if (cj2 != null && (block = blockBreakEvent.getBlock()).getType().getHardness() > 0.0f) {
                blockBreakEvent.setCancelled(true);
                if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
                    this.a(cj2.getBlock(), cj2, blockBreakEvent.getPlayer(), false);
                }
                return;
            }
        }
        object = blockBreakEvent.getBlock().getRelative(BlockFace.UP);
        this.a((Block)object, null, blockBreakEvent.getPlayer(), false);
    }

    @EventHandler
    public void a(PlayerQuitEvent playerQuitEvent) {
        kM.remove(playerQuitEvent.getPlayer());
        kN.remove(playerQuitEvent.getPlayer());
    }

    private static /* synthetic */ void a(Block block, BoundingBox boundingBox, ItemStack itemStack) {
        baw.b(block, boundingBox, itemStack);
    }

    private static /* synthetic */ String a(cw cw2, String string) {
        string = string.replace("{direction}", cw2.cW());
        string = string.replace("{distance}", String.format("%.1f", cw2.cV()));
        return string;
    }

    static {
        kM = new WeakHashMap();
        kN = new WeakHashMap();
    }
}
