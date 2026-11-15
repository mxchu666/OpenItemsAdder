package itemsadder.m;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BoundingBox;

public final class BlockBridge {
    private BlockBridge() {
    }

    public static void a(Block block, BoundingBox boundingBox, ItemStack itemStack, double d, double d2) {
        if (itemStack == null || itemStack.getType().isAir()) {
            return;
        }
        World world = block.getWorld();
        double d3 = boundingBox.getMinX() - (double)block.getX();
        double d4 = boundingBox.getMinY() - (double)block.getY();
        double d5 = boundingBox.getMinZ() - (double)block.getZ();
        double d6 = Math.min(1.0, boundingBox.getWidthX());
        double d7 = Math.min(1.0, boundingBox.getHeight());
        double d8 = Math.min(1.0, boundingBox.getWidthZ());
        int n = Math.max(2, (int)Math.ceil(d6 / d));
        int n2 = Math.max(2, (int)Math.ceil(d7 / d));
        int n3 = Math.max(2, (int)Math.ceil(d8 / d));
        double d9 = block.getX();
        double d10 = block.getY();
        double d11 = block.getZ();
        for (int i = 0; i < n; ++i) {
            double d12 = ((double)i + 0.5) / (double)n;
            double d13 = d9 + d3 + d12 * d6;
            for (int j = 0; j < n2; ++j) {
                double d14 = ((double)j + 0.5) / (double)n2;
                double d15 = d10 + d4 + d14 * d7;
                for (int k = 0; k < n3; ++k) {
                    double d16 = ((double)k + 0.5) / (double)n3;
                    double d17 = d11 + d5 + d16 * d8;
                    world.spawnParticle(Particle.ITEM, d13, d15, d17, 1, 0.2, 0.2, 0.2, d2, (Object)itemStack, true);
                }
            }
        }
    }

    public static void c(Block block, ItemStack itemStack) {
        BoundingBox boundingBox = BlockBridge.bi(block);
        BlockBridge.a(block, boundingBox, itemStack, 0.25, 0.05);
    }

    public static void b(Block block, BoundingBox boundingBox, ItemStack itemStack) {
        BlockBridge.a(block, boundingBox, itemStack, 0.2, 0.05);
    }

    public static void bh(Block block) {
        block.getWorld().playEffect(block.getLocation(), Effect.BONE_MEAL_USE, 0);
        Location location = block.getLocation().add(0.5, 0.5, 0.5);
        for (int i = 0; i < 15; ++i) {
            double d = (Math.random() - 0.5) * 0.8;
            double d2 = (Math.random() - 0.5) * 0.8;
            double d3 = (Math.random() - 0.5) * 0.8;
            block.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, location.clone().add(d, d2, d3), 1, 0.0, 0.0, 0.0, 0.0);
        }
    }

    private static BoundingBox bi(Block block) {
        try {
            return block.getBoundingBox();
        }
        catch (NoSuchMethodError | UnsupportedOperationException throwable) {
            double d = block.getX();
            double d2 = block.getY();
            double d3 = block.getZ();
            return new BoundingBox(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0);
        }
    }
}
