package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomBlock;
import itemsadder.m.BiomeHolder;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackRegistry;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomBlock$Advanced {
    @Nullable
    public static String getInCustomRegion(Location location) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(location.getBlock())) {
            return null;
        }
        return blockBridge_9.H(location);
    }

    public static void placeInCustomRegion(@NotNull CustomBlock customBlock, Location location) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        blockBridge_9.a(location, customBlock.getNamespacedID());
    }

    public static boolean placeInCustomRegion(String string, Location location) {
        if (!ItemStackRegistry.g().g(string)) {
            return false;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        blockBridge_9.a(location, string);
        return true;
    }

    public static boolean removeFromCustomRegion(Location location) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(location.getBlock())) {
            return false;
        }
        blockBridge_9.ag(location.getBlock());
        return true;
    }

    public static void deleteAllCustomBlocksInChunk(Chunk chunk) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(chunk);
        if (blockBridge_9 == null) {
            return;
        }
        blockBridge_9.q(chunk);
    }

    public static void deleteAllCustomBlocksInChunk(Chunk chunk, boolean bl, boolean bl2) {
        if (!bl) {
            CustomBlock$Advanced.deleteAllCustomBlocksInChunk(chunk);
            return;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(chunk);
        if (blockBridge_9 == null) {
            return;
        }
        BukkitTaskBridge.i(() -> {
            CustomBlock$Advanced.runActionOnBlocks(chunk, (string, location) -> blockBridge_9.c(location.getBlock(), bl));
            blockBridge_9.q(chunk);
            if (bl2) {
                for (Player player : chunk.getWorld().getPlayers()) {
                    BiomeHolder.tG().a(chunk, player);
                }
            }
        });
    }

    @Nullable
    public static List getAllBlocksLocationsList(Chunk chunk) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(chunk);
        if (blockBridge_9 == null) {
            return null;
        }
        return blockBridge_9.getAllBlocksLocationsList(chunk);
    }

    @Nullable
    public static Map getAllBlocksLocations(Chunk chunk) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(chunk);
        if (blockBridge_9 == null) {
            return null;
        }
        return blockBridge_9.getAllBlocksLocations(chunk);
    }

    public static void runActionOnBlocks(Chunk chunk, BiConsumer biConsumer) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(chunk);
        if (blockBridge_9 == null) {
            return;
        }
        blockBridge_9.a(chunk, biConsumer);
    }
}
