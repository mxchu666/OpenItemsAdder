package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomBlock;
import itemsadder.m.afj;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.ms;
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
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(location.getBlock())) {
            return null;
        }
        return ms2.H(location);
    }

    public static void placeInCustomRegion(@NotNull CustomBlock customBlock, Location location) {
        ms ms2 = d.g().a(location);
        ms2.a(location, customBlock.getNamespacedID());
    }

    public static boolean placeInCustomRegion(String string, Location location) {
        if (!d.g().g(string)) {
            return false;
        }
        ms ms2 = d.g().a(location);
        ms2.a(location, string);
        return true;
    }

    public static boolean removeFromCustomRegion(Location location) {
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(location.getBlock())) {
            return false;
        }
        ms2.ag(location.getBlock());
        return true;
    }

    public static void deleteAllCustomBlocksInChunk(Chunk chunk) {
        ms ms2 = d.g().a(chunk);
        if (ms2 == null) {
            return;
        }
        ms2.q(chunk);
    }

    public static void deleteAllCustomBlocksInChunk(Chunk chunk, boolean bl, boolean bl2) {
        if (!bl) {
            CustomBlock$Advanced.deleteAllCustomBlocksInChunk(chunk);
            return;
        }
        ms ms2 = d.g().a(chunk);
        if (ms2 == null) {
            return;
        }
        bcp.i(() -> {
            CustomBlock$Advanced.runActionOnBlocks(chunk, (string, location) -> ms2.c(location.getBlock(), bl));
            ms2.q(chunk);
            if (bl2) {
                for (Player player : chunk.getWorld().getPlayers()) {
                    afj.tG().a(chunk, player);
                }
            }
        });
    }

    @Nullable
    public static List getAllBlocksLocationsList(Chunk chunk) {
        ms ms2 = d.g().a(chunk);
        if (ms2 == null) {
            return null;
        }
        return ms2.getAllBlocksLocationsList(chunk);
    }

    @Nullable
    public static Map getAllBlocksLocations(Chunk chunk) {
        ms ms2 = d.g().a(chunk);
        if (ms2 == null) {
            return null;
        }
        return ms2.getAllBlocksLocations(chunk);
    }

    public static void runActionOnBlocks(Chunk chunk, BiConsumer biConsumer) {
        ms ms2 = d.g().a(chunk);
        if (ms2 == null) {
            return;
        }
        ms2.a(chunk, biConsumer);
    }
}
