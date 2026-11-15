package itemsadder.m;

import itemsadder.m.BlockBridge_3;
import itemsadder.m.BlockBridge_4;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.EntityBridge_2;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PlayerLocationHolder_2;
import itemsadder.m.VectorBridge_3;
import itemsadder.m.VersionHelper;
import itemsadder.m.VersionHelper_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

public class LocationBridge_2 {
    public static final BlockFace[] aAN = new BlockFace[]{BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST};
    public static final BlockFace[] aAO = new BlockFace[]{BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST};
    public static final Set aAP = new HashSet<Material>(Arrays.asList(Material.AIR, Material.CAVE_AIR, Material.VOID_AIR, Material.LIGHT, Material.ACACIA_FENCE, Material.BIRCH_FENCE, Material.DARK_OAK_FENCE, Material.JUNGLE_FENCE, Material.SPRUCE_FENCE, Material.NETHER_BRICK_FENCE, Material.OAK_FENCE, Material.TORCH, Material.END_ROD, Material.BLACK_CARPET, Material.BLUE_CARPET, Material.BROWN_CARPET, Material.CYAN_CARPET, Material.GRAY_CARPET, Material.GREEN_CARPET, Material.LIGHT_BLUE_CARPET, Material.LIGHT_GRAY_CARPET, Material.LIME_CARPET, Material.MAGENTA_CARPET, Material.ORANGE_CARPET, Material.PINK_CARPET, Material.PURPLE_CARPET, Material.RED_CARPET, Material.RED_CARPET, Material.WHITE_CARPET, Material.YELLOW_CARPET, Material.LANTERN, Material.SHORT_GRASS, Material.TALL_GRASS, Material.FERN, Material.LARGE_FERN));
    public static final Set aAQ = new HashSet<Material>(Arrays.asList(Material.AIR, Material.CAVE_AIR, Material.VOID_AIR, Material.LIGHT, Material.WATER, Material.LAVA));

    public static Location bp(Block block) {
        Location location = block.getLocation();
        location.setY(location.getY() + (double)0.9f);
        location.setX(location.getX() + 0.5);
        location.setZ(location.getZ() + 0.5);
        return location;
    }

    public static boolean a(Block block, Player player) {
        if (block.getType() == Material.AIR) {
            return true;
        }
        BlockBridge_3 blockBridge_3 = new BlockBridge_3(block, player);
        blockBridge_3.setDropItems(false);
        Bukkit.getServer().getPluginManager().callEvent((Event)blockBridge_3);
        boolean bl = false;
        if (!blockBridge_3.isCancelled()) {
            bl = true;
        }
        blockBridge_3.setCancelled(true);
        return bl;
    }

    public static boolean b(Block block, Player player) {
        BlockBridge_4 blockBridge_4 = new BlockBridge_4(block, block.getState(), block.getRelative(BlockFace.DOWN), new ItemStack(Material.STONE), player, true);
        Bukkit.getServer().getPluginManager().callEvent((Event)blockBridge_4);
        boolean bl = false;
        if (!blockBridge_4.isCancelled()) {
            bl = true;
        }
        blockBridge_4.setCancelled(true);
        return bl;
    }

    public static boolean a(Block block, Player player, Block block2, ItemStack itemStack) {
        BlockBridge_4 blockBridge_4 = new BlockBridge_4(block, block.getState(), block2, itemStack, player, true);
        Bukkit.getServer().getPluginManager().callEvent((Event)blockBridge_4);
        return !blockBridge_4.isCancelled();
    }

    public static boolean bq(Block block) {
        return ListenerBridge.b((Event)new TNTPrimeEvent(block, TNTPrimeEvent.PrimeCause.FIRE, null, null));
    }

    public static BlockFace B(float f) {
        return LocationBridge_2.a(f, true);
    }

    public static BlockFace a(float f, boolean bl) {
        if (bl) {
            return aAO[Math.round(f / 45.0f) & 7];
        }
        return aAN[Math.round(f / 90.0f) & 3];
    }

    public static int b(float f, boolean bl) {
        return switch (LocationBridge_2.a(f, bl)) {
            case BlockFace.NORTH -> -180;
            case BlockFace.WEST, BlockFace.NORTH_WEST, BlockFace.SOUTH_WEST -> 90;
            case BlockFace.EAST, BlockFace.NORTH_EAST, BlockFace.SOUTH_EAST -> -90;
            default -> 0;
        };
    }

    public static BlockFace cB(Player player) {
        float f = player.getLocation().getYaw();
        if ((f = (f % 360.0f + 360.0f) % 360.0f) >= 45.0f && f < 135.0f) {
            return BlockFace.WEST;
        }
        if (f >= 135.0f && f < 225.0f) {
            return BlockFace.NORTH;
        }
        if (f >= 225.0f && f < 315.0f) {
            return BlockFace.EAST;
        }
        return BlockFace.SOUTH;
    }

    public static BlockFace cC(Player player) {
        float f = player.getLocation().getPitch();
        if (f >= 45.0f) {
            return BlockFace.DOWN;
        }
        if (f <= -45.0f) {
            return BlockFace.UP;
        }
        return BlockFace.SELF;
    }

    public static float c(float f, boolean bl) {
        if (bl) {
            return (float)Math.round(f / 45.0f) * 45.0f;
        }
        return (float)Math.round(f / 90.0f) * 90.0f;
    }

    public static Rotation C(float f) {
        BlockFace blockFace = LocationBridge_2.B(f);
        return switch (blockFace) {
            case BlockFace.NORTH -> Rotation.FLIPPED;
            case BlockFace.NORTH_EAST -> Rotation.FLIPPED_45;
            case BlockFace.EAST -> Rotation.COUNTER_CLOCKWISE;
            case BlockFace.SOUTH_EAST -> Rotation.COUNTER_CLOCKWISE_45;
            case BlockFace.SOUTH -> Rotation.NONE;
            case BlockFace.SOUTH_WEST -> Rotation.CLOCKWISE_45;
            case BlockFace.WEST -> Rotation.CLOCKWISE;
            case BlockFace.NORTH_WEST -> Rotation.CLOCKWISE_135;
            default -> Rotation.NONE;
        };
    }

    public static BlockFace a(Rotation rotation) {
        return switch (rotation) {
            default -> throw new MatchException(null, null);
            case Rotation.FLIPPED -> BlockFace.NORTH;
            case Rotation.FLIPPED_45 -> BlockFace.NORTH_EAST;
            case Rotation.COUNTER_CLOCKWISE -> BlockFace.EAST;
            case Rotation.COUNTER_CLOCKWISE_45 -> BlockFace.SOUTH_EAST;
            case Rotation.NONE -> BlockFace.SOUTH;
            case Rotation.CLOCKWISE_45 -> BlockFace.SOUTH_WEST;
            case Rotation.CLOCKWISE -> BlockFace.WEST;
            case Rotation.CLOCKWISE_135 -> BlockFace.NORTH_WEST;
        };
    }

    public static int b(BlockFace blockFace) {
        return switch (blockFace) {
            case BlockFace.NORTH, BlockFace.EAST_NORTH_EAST, BlockFace.WEST_NORTH_WEST -> 180;
            case BlockFace.NORTH_EAST, BlockFace.NORTH_NORTH_EAST -> -135;
            case BlockFace.NORTH_WEST, BlockFace.NORTH_NORTH_WEST -> 135;
            case BlockFace.SOUTH, BlockFace.EAST_SOUTH_EAST, BlockFace.WEST_SOUTH_WEST -> 0;
            case BlockFace.SOUTH_EAST, BlockFace.SOUTH_SOUTH_EAST -> -45;
            case BlockFace.SOUTH_WEST, BlockFace.SOUTH_SOUTH_WEST -> 45;
            case BlockFace.EAST -> -90;
            case BlockFace.WEST -> 90;
            default -> 0;
        };
    }

    public static BlockFace a(Vector vector) {
        if (vector.getY() == 1.0 && vector.getZ() > 0.0) {
            return BlockFace.UP;
        }
        if (vector.getY() == -1.0 && vector.getZ() > 0.0) {
            return BlockFace.DOWN;
        }
        if (vector.getX() == 1.0 && vector.getZ() < 0.0) {
            return BlockFace.EAST;
        }
        if (vector.getX() == -1.0 && vector.getZ() > 0.0) {
            return BlockFace.WEST;
        }
        if (vector.getZ() == 1.0) {
            return BlockFace.SOUTH;
        }
        if (vector.getZ() == -1.0) {
            return BlockFace.NORTH;
        }
        return BlockFace.DOWN;
    }

    public static List cD(Player player) {
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        for (Entity entity : player.getNearbyEntities(10.0, 10.0, 10.0)) {
            if (!(entity instanceof LivingEntity) || !LocationBridge_2.b(player, (LivingEntity)entity)) continue;
            arrayList.add(entity);
        }
        return arrayList;
    }

    public static boolean b(Player player, LivingEntity livingEntity) {
        Location location = player.getEyeLocation();
        Vector vector = livingEntity.getEyeLocation().toVector().subtract(location.toVector());
        double d = vector.normalize().dot(location.getDirection());
        return d > 0.99;
    }

    public static boolean f(Entity entity, Entity entity2) {
        EntityBridge_2 entityBridge_2 = new EntityBridge_2(entity, entity2, EntityDamageEvent.DamageCause.ENTITY_ATTACK, 0.0);
        Bukkit.getPluginManager().callEvent((Event)entityBridge_2);
        boolean bl = !entityBridge_2.isCancelled();
        entityBridge_2.setCancelled(true);
        return bl;
    }

    public static boolean br(Block block) {
        return block.getWorld().isChunkLoaded(Math.floorDiv(block.getX(), 16), Math.floorDiv(block.getZ(), 16));
    }

    public static boolean B(Chunk chunk) {
        return chunk.getWorld().isChunkLoaded(chunk.getX(), chunk.getZ());
    }

    public static boolean h(World world, int n, int n2) {
        return world.isChunkLoaded(n, n2);
    }

    public static Collection ad(Location location) {
        int n = location.getWorld().getViewDistance() * 16;
        return LocationBridge_2.a(location, n);
    }

    public static Collection a(Location location, int n) {
        if (VersionHelper_3.sZ()) {
            return location.getWorld().getNearbyPlayers(location, (double)(location.getWorld().getViewDistance() * 16));
        }
        ArrayList<Player> arrayList = new ArrayList<Player>();
        List list = location.getWorld().getPlayers();
        for (Player player : list) {
            if (player.getWorld() != location.getWorld() || !(player.getLocation().distance(location) <= (double)n)) continue;
            arrayList.add(player);
        }
        return arrayList;
    }

    public static Collection a(Location location, double d, EntityType entityType) {
        if (VersionHelper.Va) {
            return location.getNearbyEntitiesByType(entityType.getEntityClass(), d);
        }
        return location.getWorld().getNearbyEntities(location, d, d, d, entity -> entity.getType() == entityType);
    }

    public static Collection c(Location location, double d) {
        if (VersionHelper.Va) {
            return location.getNearbyEntities(d, d, d);
        }
        return location.getWorld().getNearbyEntities(location, d, d, d);
    }

    public static boolean e(Player player, Block block) {
        return player.getBoundingBox().overlaps(BoundingBox.of((Block)block));
    }

    public static String bs(Block block) {
        return LocationBridge_2.b(block.getLocation(), false);
    }

    public static String ae(Location location) {
        return LocationBridge_2.b(location, false);
    }

    public static String b(Location location, boolean bl) {
        return location.getX() + ", " + location.getY() + ", " + location.getZ() + (String)(bl ? " " + location.getWorld().getName() : "");
    }

    public static String bt(Block block) {
        return LocationBridge_2.af(block.getLocation());
    }

    public static String af(Location location) {
        return "/tppos " + location.getX() + " " + location.getY() + " " + location.getZ();
    }

    public static double f(Location location, Location location2) {
        return Math.sqrt(LocationBridge_2.g(location, location2));
    }

    private static double g(Location location, Location location2) {
        if (location2.getWorld() != null && location.getWorld() != null) {
            if (location2.getWorld() != location.getWorld()) {
                throw new IllegalArgumentException("Cannot measure distance between " + location.getWorld().getName() + " and " + location2.getWorld().getName());
            }
            return NumberConversions.square((double)(location.getX() - location2.getX())) + NumberConversions.square((double)(location.getZ() - location2.getZ()));
        }
        throw new IllegalArgumentException("Cannot measure distance to a null world");
    }

    public static double h(Location location, Location location2) {
        return Math.sqrt(NumberConversions.square((double)(location.getX() - location2.getX())) + NumberConversions.square((double)(location.getZ() - location2.getZ())));
    }

    public static boolean cE(Player player) {
        Location location = player.getLocation();
        Location location2 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ(), 0.0f, 90.0f);
        PlayerLocationHolder_2 playerLocationHolder_2 = new PlayerLocationHolder_2(location2, 1.0);
        if (playerLocationHolder_2.a(EntityAndBlockEnum.BLOCK)) {
            return playerLocationHolder_2.EG();
        }
        return false;
    }

    public static void i(Location location, Location location2) {
        location2.set(location.getX(), location.getY(), location.getZ());
        location2.setPitch(location.getPitch());
        location2.setYaw(location.getYaw());
        location2.setWorld(location.getWorld());
    }

    public static boolean c(Location location, Location location2, boolean bl) {
        World world;
        World world2;
        if (location == null || location2 == null) {
            return false;
        }
        if (bl && !Objects.equals(world2 = location.getWorld(), world = location2.getWorld())) {
            return false;
        }
        return location.getBlockX() == location2.getBlockX() && location.getBlockY() == location2.getBlockY() && location.getBlockZ() == location2.getBlockZ();
    }

    public static boolean a(Location location, VectorBridge_3 vectorBridge_3) {
        return location != null && location.getBlockX() == vectorBridge_3.ha && location.getBlockY() == vectorBridge_3.gW && location.getBlockZ() == vectorBridge_3.hc;
    }

    public static float D(float f) {
        float f2 = f % 360.0f;
        if (f2 >= 180.0f) {
            f2 -= 360.0f;
        }
        if (f2 < -180.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    public static float e(float f, float f2, float f3) {
        float f4 = LocationBridge_2.D(f2 - f);
        return LocationBridge_2.D(f + f4 * f3);
    }

    public static Location ag(Location location) {
        return new Location(location.getWorld(), (double)location.getBlockX(), (double)location.getBlockY(), (double)location.getBlockZ());
    }

    static {
        aAQ.add(Material.LIGHT);
    }
}
