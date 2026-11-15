package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.ql;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public class bay {
    public static List a(Location location, Location location2, World world) {
        int n;
        int n2;
        int n3;
        ArrayList<Block> arrayList = new ArrayList<Block>();
        int n4 = location.getBlockX();
        int n5 = location.getBlockY();
        int n6 = location.getBlockZ();
        int n7 = location2.getBlockX();
        int n8 = location2.getBlockY();
        int n9 = location2.getBlockZ();
        if (n4 > n7) {
            var10_10 = n7;
            n3 = n4;
        } else {
            var10_10 = n4;
            n3 = n7;
        }
        if (n5 > n8) {
            var11_12 = n8;
            n2 = n5;
        } else {
            var11_12 = n5;
            n2 = n8;
        }
        if (n6 > n9) {
            var12_14 = n9;
            n = n6;
        } else {
            var12_14 = n6;
            n = n9;
        }
        for (int i = var10_10; i <= n3; ++i) {
            for (int j = var11_12; j <= n2; ++j) {
                for (int k = var12_14; k <= n; ++k) {
                    Block block = new Location(world, (double)i, (double)j, (double)k).getBlock();
                    arrayList.add(block);
                }
            }
        }
        return arrayList;
    }

    public static List d(Location location, Location location2) {
        return bay.a(location, location2, location.getWorld());
    }

    public static boolean S(Material material) {
        if (material.getHardness() == -1.0f) {
            return true;
        }
        return material == Material.END_PORTAL || material == Material.END_PORTAL_FRAME || material == Material.NETHER_PORTAL || material == Material.END_GATEWAY || material == Material.BEDROCK || material == Material.BARRIER || material == Material.AIR || material == Material.CAVE_AIR || material == Material.VOID_AIR || material == Material.TORCH || material == Material.LAVA || material == Material.WATER || material == Material.COMPARATOR || material == Material.REPEATER || material == Material.SPAWNER || material.name().equals("TRIAL_SPAWNER") || material.name().equals("VAULT") || material == Material.SHULKER_BOX || material == Material.CHEST || material == Material.BARREL || material == Material.SMOKER || material == Material.STONECUTTER || material == Material.GRINDSTONE || material == Material.SMITHING_TABLE || material == Material.ENCHANTING_TABLE || material == Material.BELL || material == Material.LOOM || material == Material.BLAST_FURNACE || material == Material.FURNACE || material == Material.REDSTONE || material == Material.REDSTONE_LAMP || material == Material.REDSTONE_TORCH || material == Material.REDSTONE_WALL_TORCH || material == Material.ANCIENT_DEBRIS || material == Material.RESPAWN_ANCHOR || material == Material.LODESTONE;
    }

    public static boolean bj(Block block) {
        boolean bl;
        Material material = block.getType();
        boolean bl2 = bl = material.toString().contains("ORE") || material.toString().equals("ANCIENT_DEBRIS") || material.toString().equals("CRYING_OBSIDIAN");
        if (bl) {
            return true;
        }
        if (ql.av(block)) {
            ms ms2 = d.g().b(block);
            return ms2.isCustomBlock(block);
        }
        return false;
    }

    public static void d(Block block, int n) {
        if (n == -1) {
            return;
        }
        if (Main.Pv == null) {
            return;
        }
        Main.Pv.e(block.getLocation(), n);
    }

    public static void bk(Block block) {
        if (Main.Pv == null) {
            return;
        }
        Main.Pv.aj(block.getLocation());
    }

    @Deprecated
    public static Location bl(Block block) {
        Location location;
        return location.add((location = block.getLocation()).getX() > 0.0 ? 0.5 : -0.5, 0.0, location.getZ() > 0.0 ? 0.5 : -0.5);
    }

    @Nullable
    public static Entity a(Block block, EntityType entityType, double d2) {
        Location location = block.getLocation().add(0.5, 0.0, 0.5);
        double d3 = 999.0;
        Entity entity = null;
        for (Entity entity2 : block.getWorld().getNearbyEntities(location, 1.0, 1.0, 1.0)) {
            double d4;
            if (entity2 != null && entity2.getType() != entityType || (d4 = location.distance(entity2.getLocation())) > d2 || !(d4 < d3)) continue;
            entity = entity2;
            d3 = d4;
        }
        return entity;
    }

    @Deprecated
    @Nullable
    public static Entity a(Block block, EntityType entityType) {
        return bay.a(block, entityType, 0.1);
    }

    @Deprecated
    @Nullable
    public static Entity bm(Block block) {
        return bay.a(block, null, 0.1f);
    }

    public static boolean T(Material material) {
        return material == Material.BEETROOT || material == Material.CARROTS || material == Material.WHEAT || material == Material.NETHER_WART || material == Material.POTATOES || material == Material.SWEET_BERRY_BUSH;
    }

    public static boolean bn(Block block) {
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable)block.getBlockData();
            return ageable.getAge() == ageable.getMaximumAge();
        }
        return true;
    }

    public static int getAge(Block block) {
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable)block.getBlockData();
            return ageable.getAge();
        }
        return 9999;
    }

    public static void setAge(Block block, int n) {
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable)block.getBlockData();
            ageable.setAge(n);
            block.setBlockData((BlockData)ageable);
        }
    }

    public static int bo(Block block) {
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable)block.getBlockData();
            return ageable.getMaximumAge();
        }
        return -1;
    }

    public static BlockFace ab(Location location) {
        if (location.getX() % 1.0 == 0.0 || location.getY() % 1.0 == 0.0 || location.getZ() % 1.0 == 0.0) {
            throw new IllegalArgumentException("Cannot identify the face of the block if location is between 2 blocks. Make sure that the location is touching a face but a bit inside of it.");
        }
        Block block = location.getBlock();
        Location location2 = block.getLocation().add(0.5, 0.5, 0.5);
        double d2 = location.getX() - location2.getX();
        double d3 = location.getY() - location2.getY();
        double d4 = location.getZ() - location2.getZ();
        double d5 = Math.abs(d2);
        double d6 = Math.abs(d3);
        double d7 = Math.abs(d4);
        bce.iA("dx: " + d2 + ", dy: " + d3 + ", dz: " + d4 + ", absDx: " + d5 + ", absDy: " + d6 + ", absDz: " + d7);
        bce.iA("x: " + location.getX() + ", y: " + location.getY() + ", z: " + location.getZ());
        if (d6 > d5 && d6 > d7) {
            return d3 > 0.0 ? BlockFace.UP : BlockFace.DOWN;
        }
        if (d5 > d6 && d5 > d7) {
            return d2 > 0.0 ? BlockFace.EAST : BlockFace.WEST;
        }
        return d4 > 0.0 ? BlockFace.SOUTH : BlockFace.NORTH;
    }
}
