package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockHolder;
import itemsadder.m.BlockPhysicsListener_2;
import itemsadder.m.BlockRegistry;
import itemsadder.m.ClassRefData;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.FluentBuilder_2;
import itemsadder.m.GenericGameListener;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PlacedEnum;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PlayerBridge_18;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_5;
import itemsadder.m.PlayerLocationHolder_2;
import itemsadder.m.RealEnum;
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

public class BlockPlaceListener_2
extends PlayerBridge_18 {
    GenericGameListener Aj;
    private static final FluentBuilder_2 Ak = FluentBuilder_2.s(Player.class);

    public BlockPlaceListener_2() {
        super(50);
        if (MaterialBarColorHolder.fl) {
            this.Aj = new GenericGameListener();
        }
        ListenerBridge.a(this, (Plugin)Main.rS());
        PlayerJoinListener_5.lF().register();
        ItemStackRegistry.g().ar.a(new ClassRefData(PlayerInteractEvent.class, this::h));
        ItemStackRegistry.g().ar.a(new ClassRefData(PlayerInteractEvent.class, this::i));
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
        PlayerJoinListener_5.lF().unregister();
        if (this.Aj != null) {
            this.Aj.unregister();
        }
        Ak.clear();
    }

    private void h(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        this.a(playerInteractEvent, itemStackBuilder_4, itemStack, true, true);
    }

    public boolean a(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, boolean bl, boolean bl2) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return false;
        }
        if (playerInteractEvent.getPlayer().getGameMode() == GameMode.ADVENTURE || playerInteractEvent.getPlayer().getGameMode() == GameMode.SPECTATOR) {
            return false;
        }
        if (!(itemStackBuilder_4 instanceof BlockBridge_13)) {
            return false;
        }
        if (itemStack.getType().isBlock()) {
            return false;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (bl2 && block.getType() == Material.NOTE_BLOCK) {
            return false;
        }
        boolean bl3 = this.a(playerInteractEvent, block, itemStackBuilder_4, block, itemStack, bl);
        if (!bl3) {
            return this.a(playerInteractEvent, block.getRelative(playerInteractEvent.getBlockFace()), itemStackBuilder_4, block, itemStack, bl);
        }
        return bl3;
    }

    private boolean a(PlayerInteractEvent playerInteractEvent, Block block, ItemStackBuilder_4 itemStackBuilder_4, Block block2, ItemStack itemStack, boolean bl) {
        BlockBridge_13 blockBridge_13 = (BlockBridge_13)itemStackBuilder_4;
        Player player = playerInteractEvent.getPlayer();
        if (BlockRegistry.aJ(block) && s.c((HumanEntity)player, blockBridge_13.kM()) && LocationBridge_2.b(block, player)) {
            if (LocationBridge_2.e(player, block)) {
                playerInteractEvent.setUseItemInHand(Event.Result.DENY);
                return false;
            }
            if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && ItemStackRegistry.g().b(player.getItemInHand())) {
                playerInteractEvent.setUseItemInHand(Event.Result.DENY);
                return false;
            }
            PlacedEnum placedEnum = this.a(player, itemStack, blockBridge_13, block, block2, playerInteractEvent.getBlockFace(), false, false);
            if (placedEnum == PlacedEnum.PLACED) {
                if (bl && player.getGameMode() != GameMode.CREATIVE) {
                    playerInteractEvent.getItem().setAmount(playerInteractEvent.getItem().getAmount() - 1);
                }
                PlayerHolder_4.a(player, playerInteractEvent.getHand());
                Block block3 = block.getRelative(BlockFace.UP);
                if (BlockRegistry.aM(block3)) {
                    BlockHolder.aV(block3);
                } else {
                    Block block4 = block.getRelative(BlockFace.DOWN);
                    if (BlockRegistry.aM(block4)) {
                        BlockHolder.aV(block4);
                    }
                }
                return true;
            }
        } else {
            playerInteractEvent.setUseItemInHand(Event.Result.DENY);
        }
        return false;
    }

    private void i(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        if (playerInteractEvent.getPlayer().getGameMode() == GameMode.ADVENTURE || playerInteractEvent.getPlayer().getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (!(itemStackBuilder_4 instanceof LocationBridgeBuilder_2)) {
            return;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = (LocationBridgeBuilder_2)itemStackBuilder_4;
        if (locationBridgeBuilder_2.FD != null && !locationBridgeBuilder_2.FD.Jd && !locationBridgeBuilder_2.FD.Je) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        PlayerLocationHolder_2 playerLocationHolder_2 = new PlayerLocationHolder_2(player, 5.0);
        playerLocationHolder_2.be(true);
        if (!playerLocationHolder_2.a(EntityAndBlockEnum.BLOCK)) {
            return;
        }
        if (!playerLocationHolder_2.EG()) {
            return;
        }
        Block block = playerLocationHolder_2.EF();
        Block block2 = block.getRelative(BlockFace.UP);
        if (block2.getType() != Material.AIR) {
            return;
        }
        if (locationBridgeBuilder_2.FD.Jd && block.getType() == Material.WATER || locationBridgeBuilder_2.FD.Je && block.getType() == Material.LAVA) {
            if (LocationBridge_2.b(block2, playerInteractEvent.getPlayer()) && BlockRegistry.aJ(block2)) {
                if (LocationBridge_2.e(playerInteractEvent.getPlayer(), block2)) {
                    playerInteractEvent.setCancelled(true);
                    return;
                }
                if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && ItemStackRegistry.g().b(playerInteractEvent.getPlayer().getItemInHand())) {
                    playerInteractEvent.setCancelled(true);
                    return;
                }
                if (this.a(playerInteractEvent.getPlayer(), itemStack, (BlockBridge_13)itemStackBuilder_4, block2, block, playerInteractEvent.getBlockFace(), true, false) == PlacedEnum.PLACED) {
                    PlayerHolder_4.a(playerInteractEvent.getPlayer(), playerInteractEvent.getHand());
                    if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                        playerInteractEvent.getItem().setAmount(playerInteractEvent.getItem().getAmount() - 1);
                    }
                }
            } else {
                playerInteractEvent.setCancelled(true);
            }
        }
    }

    private PlacedEnum a(Player player, ItemStack itemStack, BlockBridge_13 blockBridge_13, Block block, Block block2, @Nullable BlockFace blockFace, boolean bl, boolean bl2) {
        PlacedEnum placedEnum = this.b(player, itemStack, blockBridge_13, block, block2, blockFace, bl, bl2);
        if (placedEnum == PlacedEnum.PLACED) {
            ItemStack itemStack2;
            if (player.getGameMode() != GameMode.CREATIVE && !ItemStackBridge_2.at(itemStack2 = player.getInventory().getItemInOffHand()) && itemStack2.getType().isBlock()) {
                PlayerHolder_4.bW(player);
            }
            BlockPhysicsListener_2.D(block);
        }
        return placedEnum;
    }

    private PlacedEnum b(Player player, ItemStack itemStack, BlockBridge_13 blockBridge_13, Block block, Block block2, @Nullable BlockFace blockFace, boolean bl, boolean bl2) {
        Object object;
        LocationBridgeBuilder_2 locationBridgeBuilder_2;
        if (this.aJ(player)) {
            return PlacedEnum.NOT_PLACED;
        }
        if (!player.isSneaking() && BlockPlaceListener_2.a(blockFace, block2.getType()) && !ItemStackRegistry.isCustomBlock(block2)) {
            return PlacedEnum.NOT_PLACED;
        }
        if (!player.isSneaking() && block2.getType() != Material.NOTE_BLOCK && BlockRegistry.aO(block2)) {
            return PlacedEnum.NOT_PLACED_INTERACTABLE;
        }
        if (!bl && blockBridge_13.Hq == RealEnum.REAL_WIRE) {
            locationBridgeBuilder_2 = (LocationBridgeBuilder_2)blockBridge_13;
            if (!(locationBridgeBuilder_2.FD != null && locationBridgeBuilder_2.FD.Jc || (object = block.getRelative(BlockFace.DOWN)).getType() != Material.TRIPWIRE && (BlockRegistry.aQ((Block)object) || !BlockRegistry.aJ((Block)object)))) {
                return PlacedEnum.NOT_PLACED;
            }
        }
        if (blockBridge_13.Hq == RealEnum.FIRE) {
            if (block2.getType() != Material.FIRE) {
                if (blockBridge_13.f(block, true)) {
                    return PlacedEnum.PLACED;
                }
                return PlacedEnum.NOT_PLACED;
            }
        } else {
            if (!MaterialBarColorHolder.eT.x(block.getWorld())) {
                return PlacedEnum.NOT_PLACED;
            }
            locationBridgeBuilder_2 = (LocationBridgeBuilder_2)blockBridge_13;
            object = new CustomBlockPlaceEvent(player, block, locationBridgeBuilder_2, true, block2, block.getState(), itemStack);
            Bukkit.getPluginManager().callEvent((Event)object);
            if (((CustomBlockPlaceEvent)((Object)object)).isCancelled()) {
                return PlacedEnum.NOT_PLACED;
            }
            boolean bl3 = locationBridgeBuilder_2.a(player, block.getLocation(), blockFace, true, bl2);
            if (bl3) {
                locationBridgeBuilder_2.xu.HQ.f(player, block.getLocation());
            }
            if (locationBridgeBuilder_2.Hq == RealEnum.REAL_TRANSPARENT) {
                ItemStackRegistry.g();
                ItemStackRegistry.g().aT.C(block.getLocation());
            }
            if (!bl3) {
                return PlacedEnum.NOT_PLACED;
            }
        }
        this.aK(player);
        return PlacedEnum.PLACED;
    }

    static boolean a(@Nullable BlockFace blockFace, Material material) {
        return blockFace != BlockFace.SELF && material == Material.NOTE_BLOCK;
    }

    public PlacedEnum a(Player player, ItemStack itemStack, Block block, Block block2, @Nullable BlockFace blockFace, boolean bl) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().c(itemStack);
        if (locationBridgeBuilder_2 != null) {
            return this.a(player, itemStack, locationBridgeBuilder_2, block, block2, blockFace, false, bl);
        }
        return PlacedEnum.VANILLA_ITEM_NOT_PLACED;
    }

    public static void b(PlayerBlockHolder_2 playerBlockHolder_2) {
        Block block = playerBlockHolder_2.getBlock();
        Player player = playerBlockHolder_2.getPlayer();
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = playerBlockHolder_2.ln();
        playerBlockHolder_2.lo().a(block, true, false);
        BlockBridge_2.bk(playerBlockHolder_2.getBlock());
        locationBridgeBuilder_2.FD.T(block.getLocation());
        ItemStack itemStack = LocationBridge_2.ad(block.getLocation()).iterator();
        while (itemStack.hasNext()) {
            Player player2 = (Player)itemStack.next();
            player2.sendBlockChange(block.getLocation(), block.getBlockData());
            locationBridgeBuilder_2.xu.HP.f(player2, playerBlockHolder_2.getBlock().getLocation());
        }
        if (MaterialBarColorHolder.cT) {
            try {
                BlockHolder.tl().aZ(block);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                // empty catch block
            }
        }
        if (MaterialBarColorHolder.cU) {
            BlockHolder.tl().aX(block);
        }
        if (!ItemStackBridge_2.af(itemStack = player.getInventory().getItemInMainHand())) {
            locationBridgeBuilder_2.a((LivingEntity)player, BlockBreakEnum.PLACED_BLOCK_BREAK, builder_14 -> builder_14.a(playerBlockHolder_2, (ItemStackBuilder_4)locationBridgeBuilder_2, null));
        }
        if (player.getGameMode() != GameMode.CREATIVE && playerBlockHolder_2.lp()) {
            if (!locationBridgeBuilder_2.mG()) {
                if (ItemStackBridge_2.af(itemStack)) {
                    if (locationBridgeBuilder_2.mH()) {
                        playerBlockHolder_2.ad(true);
                        LocationBridge_4.b(block.getLocation(), locationBridgeBuilder_2);
                    }
                } else if (itemStack.getType() == Material.SHEARS && locationBridgeBuilder_2.mI()) {
                    playerBlockHolder_2.ad(true);
                    LocationBridge_4.b(block.getLocation(), locationBridgeBuilder_2);
                }
            } else {
                LocationBridge_4.b(block.getLocation(), locationBridgeBuilder_2);
            }
        }
    }

    public static void a(BlockBridge_9 blockBridge_9, Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        blockBridge_9.a(block, true, false);
        BlockBridge_2.bk(block);
        locationBridgeBuilder_2.FD.T(block.getLocation());
        for (Player player : LocationBridge_2.ad(block.getLocation())) {
            player.sendBlockChange(block.getLocation(), block.getBlockData());
            locationBridgeBuilder_2.xu.HP.f(player, block.getLocation());
        }
        if (MaterialBarColorHolder.cT) {
            try {
                BlockHolder.tl().aZ(block);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                // empty catch block
            }
        }
        if (MaterialBarColorHolder.cU) {
            BlockHolder.tl().aX(block);
        }
        if (locationBridgeBuilder_2.mG()) {
            LocationBridge_4.b(block.getLocation(), locationBridgeBuilder_2);
        }
    }

    public static void a(Block block, Material material) {
        if (material == Material.SPAWNER) {
            block.getWorld().spawnParticle(Particle.BLOCK, block.getLocation().clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)Material.OBSIDIAN.createBlockData());
        } else {
            BlockHolder.aW(block);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(PlayerBlockHolder_2 playerBlockHolder_2) {
        BlockPlaceListener_2.b(playerBlockHolder_2);
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    void b(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        Player player = blockPlaceEvent.getPlayer();
        if (blockPlaceEvent.getHand() == EquipmentSlot.OFF_HAND && ItemStackRegistry.g().b(player.getItemInHand())) {
            blockPlaceEvent.setCancelled(true);
            return;
        }
        ItemStack itemStack = blockPlaceEvent.getItemInHand().clone();
        Block block = blockPlaceEvent.getBlockAgainst();
        Block block2 = blockPlaceEvent.getBlockPlaced();
        BlockFace blockFace = block.getFace(block2);
        PlacedEnum placedEnum = this.a(blockPlaceEvent.getPlayer(), itemStack, blockPlaceEvent.getBlock(), blockPlaceEvent.getBlockAgainst(), blockFace, true);
        if (placedEnum == PlacedEnum.NOT_PLACED) {
            blockPlaceEvent.setCancelled(true);
        }
        BlockPlaceListener_2.g(blockPlaceEvent.getPlayer(), placedEnum == PlacedEnum.PLACED);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void d(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!LocationBridgeBuilder_2.av(block)) {
            return;
        }
        Material material = block.getType();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (blockBridge_9.isCustomBlock(block)) {
            boolean bl;
            blockBreakEvent.setCancelled(true);
            Player player = blockBreakEvent.getPlayer();
            if (player.getGameMode() != GameMode.CREATIVE && material == Material.TRIPWIRE) {
                return;
            }
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
            if (locationBridgeBuilder_2 == null) {
                blockBreakEvent.setCancelled(false);
                return;
            }
            if (player.getGameMode() != GameMode.CREATIVE) {
                if (MaterialBarColorHolder.dD) {
                    CommandSenderBridge_5.warn("Player '" + player.getName() + "' somehow tried to break a custom block even when not normally possible. They are probably hacking or using Minecraft Bedrock client (Geyser).");
                }
                return;
            }
            Location location = block.getLocation();
            if (material == Material.NOTE_BLOCK) {
                ItemStackRegistry.g();
                ItemStackRegistry.g().aT.B(location);
            }
            locationBridgeBuilder_2.FD.T(block.getLocation());
            boolean bl2 = bl = !ListenerBridge.b((Event)new CustomBlockBreakEvent(player, block, locationBridgeBuilder_2));
            if (!bl) {
                blockBridge_9.a(block, true, false);
                BlockBridge_2.bk(block);
            }
            if (player.getGameMode() == GameMode.CREATIVE) {
                for (Player player2 : LocationBridge_2.ad(location)) {
                    player2.sendBlockChange(location, block.getBlockData());
                }
                locationBridgeBuilder_2.xu.HP.a(location, SoundCategory.BLOCKS);
            }
            ItemStackRegistry.g();
            ItemStackRegistry.g().aT.a(location, false);
            if (!bl) {
                if (MaterialBarColorHolder.cT) {
                    try {
                        BlockHolder.tl().aZ(block);
                    }
                    catch (NoSuchMethodError noSuchMethodError) {
                        // empty catch block
                    }
                }
                if (MaterialBarColorHolder.cU) {
                    BlockHolder.tl().aX(block);
                }
            }
        } else if (material == Material.SPAWNER || MaterialBarColorHolder.cG && LocationBridgeBuilder_2.h(material) || MaterialBarColorHolder.cI && LocationBridgeBuilder_2.m(material) || MaterialBarColorHolder.cH && LocationBridgeBuilder_2.l(material)) {
            BlockPlaceListener_2.a(block, material);
            if (MaterialBarColorHolder.cT) {
                try {
                    BlockHolder.tl().aZ(block);
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
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (block == null) {
            return;
        }
        if (ItemStackRegistry.g().aE.aJ(playerInteractEvent.getPlayer())) {
            return;
        }
        if (!ProtectionPlugins.canInteract_placedBlock(playerInteractEvent)) {
            return;
        }
        if (LocationBridgeBuilder_2.av(block)) {
            ItemStackRegistry.g();
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (!blockBridge_9.isCustomBlock(block)) {
                return;
            }
            ItemStackRegistry.g();
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
            if (locationBridgeBuilder_2 == null) {
                return;
            }
            CustomBlockInteractEvent customBlockInteractEvent = new CustomBlockInteractEvent(playerInteractEvent.getPlayer(), playerInteractEvent.getAction(), playerInteractEvent.getItem(), block, playerInteractEvent.getBlockFace(), playerInteractEvent.getHand(), locationBridgeBuilder_2);
            Bukkit.getPluginManager().callEvent((Event)customBlockInteractEvent);
            if (customBlockInteractEvent.isCancelled()) {
                playerInteractEvent.setCancelled(true);
                return;
            }
            locationBridgeBuilder_2.a((LivingEntity)playerInteractEvent.getPlayer(), BlockBreakEnum.PLACED_BLOCK_INTERACT, builder_14 -> builder_14.j(playerInteractEvent, locationBridgeBuilder_2, locationBridgeBuilder_2.mP()));
        }
    }
}
