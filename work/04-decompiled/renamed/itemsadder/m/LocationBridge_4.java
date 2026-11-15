package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public class LocationBridge_4 {
    public static final BlockFace[] aBu = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
    public static final BlockFace[] aBv = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH_EAST, BlockFace.NORTH_WEST, BlockFace.SOUTH_EAST, BlockFace.SOUTH_WEST};
    public static final BlockFace[] aBw = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH_EAST, BlockFace.NORTH_WEST, BlockFace.SOUTH_EAST, BlockFace.SOUTH_WEST, BlockFace.UP, BlockFace.DOWN};

    public static boolean b(Location location, @Nullable ItemStack itemStack) {
        return LocationBridge_4.a(location, itemStack, null);
    }

    public static boolean a(Location location, @Nullable ItemStack itemStack, @Nullable Player player) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return false;
        }
        int n = itemStack.getAmount();
        if (n <= 0) {
            return false;
        }
        try {
            World world;
            location = location.add(0.5, 0.5, 0.5);
            if (location.getBlock().getType().isSolid()) {
                world = location.getBlock().getRelative(BlockFace.UP);
                Block block = location.getBlock().getRelative(BlockFace.DOWN);
                if (player != null) {
                    if (location.getY() > player.getLocation().getY()) {
                        if (!block.getType().isSolid()) {
                            location = block.getLocation();
                        } else if (!world.getType().isSolid()) {
                            location = world.getLocation();
                        }
                    } else if (!world.getType().isSolid()) {
                        location = world.getLocation();
                    } else if (!block.getType().isSolid()) {
                        location = block.getLocation();
                    }
                    location = location.add(0.5, 0.5, 0.5);
                } else {
                    if (!world.getType().isSolid()) {
                        location = world.getLocation();
                    } else if (!block.getType().isSolid()) {
                        location = block.getLocation();
                    }
                    location = location.add(0.5, 0.5, 0.5);
                }
            }
            world = location.getWorld();
            int n2 = itemStack.getType().getMaxStackSize();
            if (n > n2) {
                float f = (float)n / (float)n2;
                int n3 = 0;
                while ((float)n3 < f - 1.0f) {
                    world.dropItemNaturally(location, ItemStackBridge_2.j(itemStack, n2));
                    ++n3;
                }
                if (f % 1.0f != 0.0f) {
                    n3 = n - n2 * (int)f;
                    world.dropItemNaturally(location, ItemStackBridge_2.j(itemStack, n3));
                }
            } else {
                world.dropItemNaturally(location, itemStack);
            }
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    public static void a(Location location, Collection collection) {
        for (ItemStack itemStack : collection) {
            LocationBridge_4.b(location, itemStack);
        }
    }

    public static boolean iX(String string) {
        try {
            Biome.valueOf((String)string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static boolean iY(String string) {
        try {
            TreeType.valueOf((String)string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static Collection m(Player player, boolean bl) {
        return LocationBridge_4.a(player, bl, -5, 0, 5);
    }

    public static Collection cF(Player player) {
        return LocationBridge_4.a(player, false, -5, 0, 5);
    }

    public static Collection a(Player player, boolean bl, int n, int n2, int n3) {
        return LocationBridge_4.a(player.getLocation(), bl, n, n2, n3);
    }

    public static List b(Location location, int n) {
        World world = location.getWorld();
        int n2 = location.getBlockX();
        int n3 = location.getBlockZ();
        int n4 = location.getBlockY();
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    arrayList.add(new Location(world, (double)(n2 + i), (double)(n4 + k), (double)(n3 + j)));
                }
            }
        }
        return arrayList;
    }

    public static Collection c(Location location, int n) {
        return LocationBridge_4.a(location, true, n, n, n);
    }

    public static Collection a(Location location, boolean bl, int n, int n2, int n3) {
        int[] nArray = new int[]{n, n2, n3};
        World world = location.getWorld();
        int n4 = location.getChunk().getX();
        int n5 = location.getChunk().getZ();
        HashSet<Chunk> hashSet = new HashSet<Chunk>();
        for (int n6 : nArray) {
            for (int n7 : nArray) {
                if (!world.isChunkLoaded(n4 + n6, n5 + n7)) continue;
                Chunk chunk = world.getChunkAt(n4 + n6, n5 + n7);
                hashSet.add(chunk);
            }
        }
        return hashSet;
    }

    public static List d(Location location, int n) {
        World world = location.getWorld();
        int n2 = (int)location.getX();
        int n3 = (int)location.getZ();
        int n4 = (int)location.getY();
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    arrayList.add(new Location(world, (double)(n2 + i), (double)(n4 + k), (double)(n3 + j)).getBlock());
                }
            }
        }
        return arrayList;
    }

    public static List ah(Location location) {
        return LocationBridge_4.a(location, 2, 0);
    }

    public static List a(Location location, int n, int n2) {
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (int i = location.getBlockX() - n; i <= location.getBlockX() + n; ++i) {
            for (int j = location.getBlockY() - n2; j <= location.getBlockY() + n2; ++j) {
                for (int k = location.getBlockZ() - n; k <= location.getBlockZ() + n; ++k) {
                    arrayList.add(new Location(location.getWorld(), (double)i, (double)j, (double)k));
                }
            }
        }
        return arrayList;
    }

    public static List b(Location location, int n, int n2) {
        World world = location.getWorld();
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (int i = location.getBlockX() - n; i <= location.getBlockX() + n; ++i) {
            for (int j = location.getBlockY() - n2; j <= location.getBlockY() + n2; ++j) {
                for (int k = location.getBlockZ() - n; k <= location.getBlockZ() + n; ++k) {
                    if (i == location.getBlockX() && j == location.getBlockY() && k == location.getBlockZ()) continue;
                    arrayList.add(new Location(world, (double)i, (double)j, (double)k).getBlock());
                }
            }
        }
        return arrayList;
    }

    public static List c(Location location, int n, int n2) {
        ArrayList<Vector> arrayList = new ArrayList<Vector>();
        for (int i = location.getBlockX() - n; i <= location.getBlockX() + n; ++i) {
            for (int j = location.getBlockY() - n2; j <= location.getBlockY() + n2; ++j) {
                for (int k = location.getBlockZ() - n; k <= location.getBlockZ() + n; ++k) {
                    if (i == location.getBlockX() && j == location.getBlockY() && k == location.getBlockZ()) continue;
                    arrayList.add(new Vector(i, j, k));
                }
            }
        }
        return arrayList;
    }

    public static List a(Location location, int n, int n2, List list) {
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (int i = location.getBlockX() - n; i <= location.getBlockX() + n; ++i) {
            for (int j = location.getBlockY() - n2; j <= location.getBlockY() + n2; ++j) {
                for (int k = location.getBlockZ() - n; k <= location.getBlockZ() + n; ++k) {
                    Block block;
                    if (i == location.getBlockX() && j == location.getBlockY() && k == location.getBlockZ() || !list.contains((block = new Location(location.getWorld(), (double)i, (double)j, (double)k).getBlock()).getType())) continue;
                    arrayList.add(block);
                }
            }
        }
        return arrayList;
    }

    public static List d(Location location, int n, int n2) {
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (int i = location.getBlockX() - n; i <= location.getBlockX() + n; ++i) {
            for (int j = location.getBlockY() - n2; j <= location.getBlockY() + n2; ++j) {
                for (int k = location.getBlockZ() - n; k <= location.getBlockZ() + n; ++k) {
                    Block block;
                    if (i == location.getBlockX() && j == location.getBlockY() && k == location.getBlockZ() || !ItemStackBridge_2.ac((block = new Location(location.getWorld(), (double)i, (double)j, (double)k).getBlock()).getType()) && !ItemStackBridge_2.ab(block.getType())) continue;
                    arrayList.add(block);
                }
            }
        }
        return arrayList;
    }

    public static List bu(Block block) {
        return LocationBridge_4.b(block, false, false);
    }

    public static List b(Block block, boolean bl, boolean bl2) {
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (BlockFace blockFace : bl2 ? aBw : aBv) {
            arrayList.add(block.getRelative(blockFace));
        }
        if (bl) {
            arrayList.add(block.getRelative(BlockFace.SELF));
        }
        return arrayList;
    }

    public static List e(Block block, int n) {
        ArrayList<Location> arrayList = new ArrayList<Location>();
        Location location = block.getLocation().clone();
        for (int i = -n / 2; i < n / 2; ++i) {
            arrayList.add(location.clone().add(0.0, (double)i, 0.0));
        }
        return arrayList;
    }

    public static String ai(Location location) {
        return location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ();
    }

    public int j(double d, double d2, double d3) {
        int n = 3;
        n = 19 * n + (int)(Double.doubleToLongBits(d) ^ Double.doubleToLongBits(d) >>> 32);
        n = 19 * n + (int)(Double.doubleToLongBits(d2) ^ Double.doubleToLongBits(d2) >>> 32);
        n = 19 * n + (int)(Double.doubleToLongBits(d3) ^ Double.doubleToLongBits(d3) >>> 32);
        return n;
    }
}
