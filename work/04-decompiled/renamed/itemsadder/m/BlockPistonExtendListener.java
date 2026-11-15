package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BiomeHolder;
import itemsadder.m.BlockBridge_7;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockRegistry;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ClassRefData;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.FluidLevelChangeEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class BlockPistonExtendListener
implements PluginContract {
    private final ItemStackRegistry zt;

    public BlockPistonExtendListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zt = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::f));
        itemStackRegistry.ar.a(new ClassRefData(PlayerItemConsumeEvent.class, this::a));
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPistonExtendEvent blockPistonExtendEvent) {
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            BlockBridge_9 blockBridge_9;
            if (!BlockBridge_7.m(block) || !(blockBridge_9 = this.zt.a(block.getChunk())).T(block)) continue;
            blockPistonExtendEvent.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EntityChangeBlockEvent entityChangeBlockEvent) {
        if (entityChangeBlockEvent.getEntityType() != EntityType.FALLING_BLOCK) {
            return;
        }
        if (!entityChangeBlockEvent.getTo().isSolid()) {
            return;
        }
        this.n(entityChangeBlockEvent.getBlock());
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerBucketFillEvent playerBucketFillEvent) {
        String string;
        Block block = playerBucketFillEvent.getBlock();
        String string2 = this.n(block);
        if (string2 != null && (string = (String)ItemStackRegistry.g().bf.get(string2)) != null) {
            playerBucketFillEvent.setItemStack(ItemStackRegistry.g().q(string));
            this.n(block);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        this.n(blockPlaceEvent.getBlockReplacedState().getBlock());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockFromToEvent blockFromToEvent) {
        Block block = blockFromToEvent.getBlock();
        Block block2 = blockFromToEvent.getToBlock();
        if (block.getType() != Material.WATER || !BlockRegistry.aJ(block2)) {
            return;
        }
        BlockBridge_9 blockBridge_9 = this.zt.a(block.getChunk());
        String string = blockBridge_9.ab(block);
        if (string == null) {
            return;
        }
        blockFromToEvent.setCancelled(true);
        if (!(block.getBlockData() instanceof Levelled)) {
            return;
        }
        Levelled levelled = (Levelled)block.getBlockData();
        if (levelled.getLevel() == 0) {
            Levelled levelled2 = (Levelled)Material.WATER.createBlockData();
            levelled2.setLevel(1);
            block2.setBlockData((BlockData)levelled2, false);
            String string2 = blockBridge_9.ac(block);
            String[] stringArray = string.split(":");
            blockBridge_9.c(block2, string);
            blockBridge_9.d(block2, string2);
            BiomeHolder.tG().a(block2, stringArray[0], stringArray[1]);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(FluidLevelChangeEvent fluidLevelChangeEvent) {
        Block block = fluidLevelChangeEvent.getBlock();
        if (block.getType() != Material.WATER) {
            return;
        }
        BlockBridge_9 blockBridge_9 = this.zt.a(block.getChunk());
        String string = blockBridge_9.ab(block);
        if (string != null) {
            if (block.getBlockData() instanceof Levelled && fluidLevelChangeEvent.getNewData() instanceof Levelled) {
                fluidLevelChangeEvent.setCancelled(true);
            } else if (fluidLevelChangeEvent.getNewData().getMaterial().isAir()) {
                this.n(block);
            }
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getItem() != null && (playerInteractEvent.getItem().getType() == Material.GLASS_BOTTLE || playerInteractEvent.getItem().getType() == Material.POTION)) {
            BlockBridge_9 blockBridge_9;
            Block block;
            if (ItemStackRegistry.g().isCustomItem(playerInteractEvent.getItem())) {
                return;
            }
            if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK && (block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace())).getType() == Material.WATER && (blockBridge_9 = this.zt.b(block)).ab(block) != null) {
                playerInteractEvent.setCancelled(true);
            }
        }
    }

    @PluginContract_19
    private void a(PlayerItemConsumeEvent playerItemConsumeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (!itemStackBuilder_4.Ge.bm("liquid_bucket")) {
            return;
        }
        playerItemConsumeEvent.setCancelled(true);
    }

    @PluginContract_19
    private void f(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Object object;
        if (playerInteractEvent.useInteractedBlock() == Event.Result.DENY) {
            return;
        }
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || playerInteractEvent.getClickedBlock() == null) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
        if (!BlockRegistry.aJ(block)) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("liquid_bucket")) {
            return;
        }
        if (!LocationBridge_2.b(block, playerInteractEvent.getPlayer())) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        BlockBridge_7 blockBridge_7 = (BlockBridge_7)itemStackBuilder_4.Ge.bn("liquid_bucket");
        if (blockBridge_7.kU().getNamespacedID().equals(BiomeHolder.tG().bd(block)) && block.getBlockData() instanceof Levelled && (object = (Levelled)block.getBlockData()).getLevel() == 0) {
            BiomeHolder.tG().a(block, blockBridge_7.kU().getNamespace(), blockBridge_7.kU().getId());
            return;
        }
        if (BiomeHolder.tG().M(blockBridge_7.kU().getNamespace(), blockBridge_7.kU().getId()) == null) {
            CommandSenderBridge_5.a((CommandSender)playerInteractEvent.getPlayer(), "liquid-not-completely-registered", string -> string.replace("{liquid}", blockBridge_7.kU().getNamespacedID()));
            CommandSenderBridge_5.error("Fluid " + blockBridge_7.kU().getNamespacedID() + " is not completely registered. Please restart the server.");
            return;
        }
        object = this.zt.b(block);
        if (((BlockBridge_9)object).o(block.getChunk())) {
            for (String string2 : ((BlockBridge_9)object).p(block.getChunk())) {
                if (blockBridge_7.kU().getNamespacedID().equals(string2)) continue;
                CommandSenderBridge_5.f((CommandSender)playerInteractEvent.getPlayer(), Main.PQ.ir("liquid-bucket-place-near-error"));
                return;
            }
        }
        for (String string2 : LocationBridge_4.c(block.getLocation(), 1)) {
            BlockBridge_9 blockBridge_9 = this.zt.a((Chunk)string2);
            for (String string3 : blockBridge_9.p((Chunk)string2)) {
                if (blockBridge_7.kU().getNamespacedID().equals(string3)) continue;
                CommandSenderBridge_5.f((CommandSender)playerInteractEvent.getPlayer(), Main.PQ.ir("liquid-bucket-place-near-error"));
                return;
            }
        }
        ((BlockBridge_9)object).c(block, blockBridge_7.kU().getNamespacedID());
        ((BlockBridge_9)object).d(block, BiomeHolder.a(block, Biome.PLAINS).getKey().toString());
        if (!blockBridge_7.kU().getNamespacedID().equals(BiomeHolder.tG().bd(block))) {
            BiomeHolder.tG().a(block, blockBridge_7.kU().getNamespace(), blockBridge_7.kU().getId());
        }
        BukkitTaskBridge.c(() -> block.setType(Material.WATER), 2L);
        if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
            ItemStackBridge_2.aj(playerInteractEvent.getItem());
            playerInteractEvent.getPlayer().getInventory().addItem(new ItemStack[]{new ItemStack(Material.BUCKET)});
        }
    }

    private String n(Block block) {
        BlockBridge_9 blockBridge_9 = this.zt.a(block.getChunk());
        if (!blockBridge_9.T(block)) {
            return null;
        }
        String string = blockBridge_9.ac(block);
        if (string == null) {
            return null;
        }
        String string2 = blockBridge_9.ab(block);
        String[] stringArray = string.split(":");
        String[] stringArray2 = string2.split(":");
        BiomeHolder.tG().a(block.getLocation(), stringArray[0], stringArray[1], false);
        blockBridge_9.ag(block);
        this.a(block, stringArray2);
        return string2;
    }

    private void a(Block block, String[] stringArray) {
        for (BlockFace blockFace : LocationBridge_4.aBu) {
            String string;
            Block block2 = block.getRelative(blockFace);
            if (block2.getType() != Material.WATER || (string = this.zt.a(block2.getChunk()).ab(block2)) == null) continue;
            BiomeHolder.tG().a(block2, stringArray[0], stringArray[1]);
            break;
        }
    }
}
