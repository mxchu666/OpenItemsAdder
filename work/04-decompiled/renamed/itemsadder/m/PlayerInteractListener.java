package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import itemsadder.m.BlockBridge;
import itemsadder.m.BlockBridge_5;
import itemsadder.m.BreakEnum;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ChunkLoadListener;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemDisplayLocationHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBoundingBoxHolder;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque107;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_40;
import itemsadder.m.PacketListener_41;
import itemsadder.m.PacketListener_42;
import itemsadder.m.PacketListener_43;
import itemsadder.m.PacketListener_44;
import itemsadder.m.PlayerBlockHolder;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PlayerToggleSneakListener;
import itemsadder.m.PluginBukkitTaskHolder;
import itemsadder.m.RecordOfString_4;
import itemsadder.m.RecordOfValue_11;
import itemsadder.m.VersionHelper_3;
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

public class PlayerInteractListener
implements Listener {
    private static NamespacedKey kL;
    private static final Map kM;
    private static final Map kN;
    public ChunkLoadListener kO;
    private PluginBukkitTaskHolder kP;
    public PlayerToggleSneakListener kQ;
    private volatile boolean kR;

    public void onEnable() {
        kL = new NamespacedKey((Plugin)Main.rS(), "lightweight_crops_enabled");
        this.kO = new ChunkLoadListener((Plugin)Main.rS());
        this.kP = new PluginBukkitTaskHolder((Plugin)Main.rS(), this.kO, 1);
        this.kQ = new PlayerToggleSneakListener(this);
        PacketListenerRegistry.a((PacketListener)new PacketListener_40(this, (Plugin)Main.rS(), ListenerPriority.LOWEST, PacketType.Play.Client.BLOCK_DIG));
        PacketListenerRegistry.a((PacketListener)new PacketListener_41(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Server.MAP_CHUNK));
        PacketListenerRegistry.a((PacketListener)new PacketListener_42(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Server.UNLOAD_CHUNK));
        PacketListenerRegistry.a((PacketListener)new PacketListener_43(this, (Plugin)Main.rS(), ListenerPriority.MONITOR, PacketType.Play.Server.RESPAWN));
        if (Version.isAtLeast((Version)Version.v1_21_4) && VersionHelper_3.b(PacketType.Play.Client.class, "PICK_ITEM_FROM_BLOCK") != null) {
            PacketListenerRegistry.a((PacketListener)new PacketListener_44(this, (Plugin)Main.rS(), PacketType.Play.Client.PICK_ITEM_FROM_BLOCK));
        }
        ListenerBridge.b(this, (Plugin)Main.rS());
        this.cS();
        Bukkit.getOnlinePlayers().forEach(PlayerInteractListener::L);
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
                if (!ChunkLoadListener.h(chunk)) continue;
                arrayList.add(chunk);
            }
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        new Opaque107(this, atomicInteger, arrayList).runTaskTimer((Plugin)Main.rS(), 0L, 2L);
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
        ListenerBridge.b(this);
        PacketListenerRegistry.l(this);
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
        PlayerInteractListener.d(player, false);
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
        if (PlayerInteractListener.L(player)) {
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
            ItemDisplayLocationHolder itemDisplayLocationHolder;
            PlayerBlockHolder playerBlockHolder = this.kO.A(player);
            ItemDisplayLocationHolder itemDisplayLocationHolder2 = itemDisplayLocationHolder = playerBlockHolder == null ? null : playerBlockHolder.c(player, false);
            if (itemDisplayLocationHolder != null) {
                block = itemDisplayLocationHolder.getBlock();
                playerInteractEvent.setCancelled(true);
            } else {
                if (block2 == null) {
                    return;
                }
                block = block2.getRelative(playerInteractEvent.getBlockFace());
            }
        }
        this.a(player, playerInteractEvent.getHand(), null, block, playerInteractEvent.getItem(), ListenerBridge.s(playerInteractEvent), playerInteractEvent);
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
        this.a(playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getHand(), interaction, ((ItemDisplayLocationHolder)object).getBlock(), null, false, null);
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
        this.a(((ItemDisplayLocationHolder)object).getBlock(), (ItemDisplayLocationHolder)object, player, true);
    }

    @Nullable
    private ItemDisplayLocationHolder a(Player player, Interaction interaction) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.kQ.F(player);
        PlayerBlockHolder playerBlockHolder = this.kO.A(player);
        if (locationBoundingBoxHolder == null || playerBlockHolder == null || !locationBoundingBoxHolder.a(interaction) || locationBoundingBoxHolder.jl == null) {
            return null;
        }
        ItemDisplayLocationHolder itemDisplayLocationHolder = playerBlockHolder.c(player, false);
        if (itemDisplayLocationHolder == null || !itemDisplayLocationHolder.getBlock().equals((Object)locationBoundingBoxHolder.jl.getBlock())) {
            return null;
        }
        locationBoundingBoxHolder.cj();
        return itemDisplayLocationHolder;
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
            ItemStackBuilder_4 itemStackBuilder_4;
            LocationBridge_7 locationBridge_7;
            Object object;
            Object object2;
            @Nullable RecordOfString_4 recordOfString_4 = this.kO.f(block);
            PlayerBlockHolder playerBlockHolder = this.kO.A(player);
            if (recordOfString_4 != null && (object2 = this.kQ.F(player)) != null) {
                ((LocationBoundingBoxHolder)object2).cj();
                if (bl) {
                    ((LocationBoundingBoxHolder)object2).cl();
                }
            }
            if (playerBlockHolder != null && itemStack.getType() == Material.BONE_MEAL && !bl && recordOfString_4 != null) {
                object2 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
                if (object2 == null) {
                    CommandSenderBridge_5.warn(player.getName() + " interacted with an unknown crop '" + recordOfString_4.bj() + "' at " + LocationBridge_2.b(block.getLocation(), true));
                    return;
                }
                int n = Math.min(recordOfString_4.bk() + (int)Math.ceil((float)((LocationBridge_7)object2).hK * ((LocationBridge_7)object2).hS), ((LocationBridge_7)object2).hK);
                if (recordOfString_4.bk() < ((LocationBridge_7)object2).hK) {
                    if (player.getGameMode() != GameMode.CREATIVE) {
                        ItemStackBridge_2.aj(itemStack);
                    }
                    this.kO.a(block, recordOfString_4.bj(), n);
                    BlockBridge.bh(block);
                    PlayerToggleSneakListener.a(player, true);
                    return;
                }
            }
            object2 = block.getLocation();
            if (playerBlockHolder != null && equipmentSlot == EquipmentSlot.HAND && recordOfString_4 != null) {
                if (!LocationBridge_2.a(object2.getBlock().getRelative(BlockFace.DOWN), player)) {
                    return;
                }
                if (bl) {
                    ItemDisplayLocationHolder itemDisplayLocationHolder = playerBlockHolder.K(player);
                    if (itemDisplayLocationHolder != null && (object = itemDisplayLocationHolder.kg) instanceof ItemDisplay && !this.a((Block)(object = (locationBridge_7 = object).getLocation().getBlock()), itemDisplayLocationHolder, player, true)) {
                        return;
                    }
                } else {
                    LocationBridge_7 locationBridge_72 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
                    if (locationBridge_72 == null) {
                        return;
                    }
                    if (locationBridge_72.a(player, recordOfString_4.bk(), (Location)object2, BreakEnum.INTERACT, true)) {
                        return;
                    }
                }
            }
            if ((itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack)) != null && !bl) {
                locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ac.get(itemStackBuilder_4);
                if (locationBridge_7 == null) {
                    return;
                }
                if (!block.getType().isAir() && !block.isReplaceable()) {
                    return;
                }
                if (!locationBridge_7.j(block)) {
                    return;
                }
                if (!object2.getBlock().getType().isAir()) {
                    return;
                }
                if (!locationBridge_7.i(object2.getBlock())) {
                    return;
                }
                if (equipmentSlot == EquipmentSlot.HAND && recordOfString_4 != null) {
                    return;
                }
                if (!LocationBridge_2.b(object2.getBlock(), player)) {
                    return;
                }
                if (this.a((Location)object2, locationBridge_7)) {
                    object2.getWorld().spawnParticle(Particle.SMOKE, object2.add(0.5, 0.5, 0.5), 10, 0.3, 0.3, 0.3, 0.01);
                    return;
                }
                if (this.m((Location)object2)) {
                    object2.getWorld().spawnParticle(Particle.SMOKE, object2.add(0.5, 0.5, 0.5), 10, 0.3, 0.3, 0.3, 0.01);
                    object = this.l((Location)object2);
                    if (object != null) {
                        CommandSenderBridge_5.a((CommandSender)player, "max-crops-reached-directions", arg_0 -> PlayerInteractListener.a((RecordOfValue_11)object, arg_0));
                    } else {
                        CommandSenderBridge_5.g((CommandSender)player, "max-crops-reached-no-directions");
                    }
                    return;
                }
                if (playerInteractEvent != null) {
                    playerInteractEvent.setCancelled(true);
                }
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    ItemStackBridge_2.aj(itemStack);
                }
                this.kO.a(object2.getBlock(), locationBridge_7.hD, 0);
                locationBridge_7.f((Location)object2);
                if (equipmentSlot == EquipmentSlot.HAND) {
                    player.swingMainHand();
                } else {
                    player.swingOffHand();
                }
                if (playerBlockHolder != null) {
                    object = playerBlockHolder.K(player);
                }
            }
        }
        finally {
            this.a(player, block);
        }
    }

    @Nullable
    private RecordOfValue_11 l(Location location) {
        int n = MaterialBarColorHolder.ec;
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
                double d = (double)n2 / (double)n4;
                double d2 = (double)n3 / (double)n4;
                double d3 = -d;
                double d4 = -d2;
                double d5 = Math.toDegrees(Math.atan2(d4, d3)) + 180.0;
                String[] stringArray = new String[]{"west", "north-west", "north", "north-east", "east", "south-east", "south", "south-west"};
                int n5 = (int)Math.round(d5 / 45.0) % 8;
                String string = stringArray[n5];
                double d6 = (double)n - Math.sqrt(d * d + d2 * d2);
                if (d6 < 1.0) {
                    d6 = 1.0;
                }
                return new RecordOfValue_11(d6, string);
            }
        }
        return null;
    }

    public boolean m(Location location) {
        int n = MaterialBarColorHolder.ec;
        int n2 = MaterialBarColorHolder.eb;
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
                BlockBridge_5 blockBridge_5 = this.kO.c(chunk);
                if (blockBridge_5 == null) continue;
                if (blockBridge_5.size() >= n2) {
                    return true;
                }
                if ((n3 += blockBridge_5.size()) < n2) continue;
                return true;
            }
        }
        return false;
    }

    private boolean a(Location location, LocationBridge_7 locationBridge_7) {
        if (locationBridge_7.hR == null || locationBridge_7.hR <= 0) {
            return false;
        }
        World world = location.getWorld();
        if (world == null) {
            return false;
        }
        int n = locationBridge_7.hR;
        int n2 = location.getBlockX();
        int n3 = location.getBlockY();
        int n4 = location.getBlockZ();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                Block block;
                int n5;
                if (i == 0 && j == 0 || (n5 = Math.max(Math.abs(i), Math.abs(j))) >= n || !LocationBridge_2.h(world, n2 + i >> 4, n4 + j >> 4) || !this.kO.g(block = world.getBlockAt(n2 + i, n3, n4 + j))) continue;
                return true;
            }
        }
        return false;
    }

    private void a(Player player, Block block) {
        RecordOfString_4 recordOfString_4;
        if (PlayerInteractListener.L(player) && (recordOfString_4 = this.kO.f(block)) != null) {
            BukkitTaskBridge.c(() -> {
                if (!this.cU()) {
                    return;
                }
                this.kO.a(player, block.getLocation(), recordOfString_4);
            }, 3L);
        }
    }

    @EventHandler
    private void b(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        Player player = playerAnimationEvent.getPlayer();
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.kQ.F(player);
        if (locationBoundingBoxHolder != null) {
            locationBoundingBoxHolder.cj();
            locationBoundingBoxHolder.cl();
        }
        this.O(player);
    }

    void b(Player player, LocationBoundingBoxHolder locationBoundingBoxHolder) {
        if (locationBoundingBoxHolder.cm()) {
            this.O(player);
        }
    }

    private void O(Player player) {
        ItemDisplay itemDisplay;
        if (player.getGameMode() == GameMode.CREATIVE && PlayerJoinListener_9.bN.n(player)) {
            return;
        }
        if (PlayerJoinListener_9.bN.h(player)) {
            return;
        }
        if (PlayerJoinListener_9.bN.l(player)) {
            return;
        }
        if (this.M(player)) {
            return;
        }
        PlayerBlockHolder playerBlockHolder = this.kO.A(player);
        if (playerBlockHolder == null) {
            return;
        }
        ItemDisplayLocationHolder itemDisplayLocationHolder = playerBlockHolder.K(player);
        if (itemDisplayLocationHolder != null && (itemDisplay = itemDisplayLocationHolder.kg) instanceof ItemDisplay) {
            ItemDisplay itemDisplay2 = itemDisplay;
            this.a(itemDisplay2.getLocation().getBlock(), itemDisplayLocationHolder, player, true);
        }
    }

    private boolean a(Block block, ItemDisplayLocationHolder itemDisplayLocationHolder, Player player, boolean bl) {
        Object object;
        RecordOfString_4 recordOfString_4 = this.kO.f(block);
        if (recordOfString_4 == null) {
            return false;
        }
        LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
        if (locationBridge_7 == null) {
            return false;
        }
        if (bl && !LocationBridge_2.a(block.getRelative(BlockFace.DOWN), player)) {
            return false;
        }
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.kQ.F(player);
        if (locationBoundingBoxHolder != null) {
            locationBoundingBoxHolder.ck();
            locationBoundingBoxHolder.cn();
        }
        if (itemDisplayLocationHolder != null) {
            object = itemDisplayLocationHolder.cI().cJ();
            ItemStack itemStack = itemDisplayLocationHolder.kg.getItemStack();
            BukkitTaskBridge.h(() -> PlayerInteractListener.a(block, (BoundingBox)object, itemStack));
        }
        this.kO.h(block);
        if (itemDisplayLocationHolder != null && (object = this.kO.A(player)) != null) {
            ((PlayerBlockHolder)object).c(itemDisplayLocationHolder.kg.getUniqueId());
        }
        if (locationBoundingBoxHolder != null) {
            locationBoundingBoxHolder.cr();
        }
        locationBridge_7.a(player, recordOfString_4.bk(), block.getLocation(), BreakEnum.BREAK, true);
        if (PlayerInteractListener.L(player)) {
            player.sendBlockChange(block.getLocation(), block.getBlockData());
        }
        this.N(player);
        return true;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockFromToEvent blockFromToEvent) {
        RecordOfString_4 recordOfString_4;
        if (blockFromToEvent.getBlock().getType() == Material.WATER) {
            RecordOfString_4 recordOfString_42 = this.kO.f(blockFromToEvent.getToBlock());
            if (recordOfString_42 != null) {
                this.kO.h(blockFromToEvent.getToBlock());
                LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_42.bj());
                locationBridge_7.a(null, recordOfString_42.bk(), blockFromToEvent.getToBlock().getLocation(), BreakEnum.WATER, true);
            }
        } else if (blockFromToEvent.getBlock().getType() == Material.LAVA && (recordOfString_4 = this.kO.f(blockFromToEvent.getToBlock())) != null) {
            this.kO.h(blockFromToEvent.getToBlock());
            LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
            locationBridge_7.a(null, recordOfString_4.bk(), blockFromToEvent.getToBlock().getLocation(), BreakEnum.LAVA, true);
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
            RecordOfString_4 recordOfString_4 = this.kO.f(block);
            assert (recordOfString_4 != null);
            this.kO.h(block);
            object = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
            ((LocationBridge_7)object).a(null, recordOfString_4.bk(), block.getLocation(), BreakEnum.BREAK, true);
            for (Map.Entry entry : kM.entrySet()) {
                Player player = (Player)entry.getKey();
                Boolean bl = (Boolean)entry.getValue();
                if (!bl.booleanValue()) continue;
                this.kO.a(player, block.getLocation(), recordOfString_4);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    public void a(BlockFertilizeEvent blockFertilizeEvent) {
        List<BlockState> list;
        if (blockFertilizeEvent.getPlayer() != null && this.kO.g(blockFertilizeEvent.getBlock().getRelative(PlayerJoinListener_9.bN.f(blockFertilizeEvent.getPlayer())))) {
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
            RecordOfString_4 recordOfString_4 = this.kO.f(block2);
            assert (recordOfString_4 != null);
            LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
            this.kO.h(block2);
            locationBridge_7.a(null, recordOfString_4.bk(), block2.getLocation(), BreakEnum.TRAMPLE, true);
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
            RecordOfString_4 recordOfString_4 = this.kO.f(block2);
            assert (recordOfString_4 != null);
            LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
            this.kO.h(block2);
            locationBridge_7.a(null, recordOfString_4.bk(), block2.getLocation(), BreakEnum.FARMLAND_DRY, true);
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
        if (ListenerBridge.g(blockBreakEvent)) {
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
            ItemDisplayLocationHolder itemDisplayLocationHolder = ((PlayerBlockHolder)object).K(blockBreakEvent.getPlayer());
            if (itemDisplayLocationHolder != null && (block = blockBreakEvent.getBlock()).getType().getHardness() > 0.0f) {
                blockBreakEvent.setCancelled(true);
                if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
                    this.a(itemDisplayLocationHolder.getBlock(), itemDisplayLocationHolder, blockBreakEvent.getPlayer(), false);
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
        BlockBridge.b(block, boundingBox, itemStack);
    }

    private static /* synthetic */ String a(RecordOfValue_11 recordOfValue_11, String string) {
        string = string.replace("{direction}", recordOfValue_11.cW());
        string = string.replace("{distance}", String.format("%.1f", recordOfValue_11.cV()));
        return string;
    }

    static {
        kM = new WeakHashMap();
        kN = new WeakHashMap();
    }
}
