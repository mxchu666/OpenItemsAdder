package itemsadder.m;

import itemsadder.m.aaa;
import itemsadder.m.aab;
import itemsadder.m.agb;
import itemsadder.m.bbs;
import itemsadder.m.bdf;
import org.bukkit.Material;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Trident;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.Nullable;

public final class afz {
    private final agb abo = (agb)aab.n(agb.class);
    private static afz abp;

    afz() {
    }

    private static afz tJ() {
        if (abp == null) {
            abp = new afz();
        }
        return abp;
    }

    public static agb tK() {
        return afz.tJ().abo;
    }

    public static void a(ArmorStand armorStand, boolean bl) {
        if (!aaa.Va) {
            return;
        }
        try {
            armorStand.setCanTick(bl);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            // empty catch block
        }
    }

    public static void a(Entity entity, float f) {
        afz.tJ().abo.a(entity, f);
    }

    public static void b(Entity entity, boolean bl) {
        afz.tJ().abo.b(entity, bl);
    }

    public static void b(Entity entity, float f) {
        afz.tJ().abo.b(entity, f);
    }

    @Deprecated
    public static void a(Entity entity, double d, double d2, double d3) {
        afz.tJ().abo.a(entity, d, d2, d3);
    }

    @Deprecated
    public static void a(Entity entity, BoundingBox boundingBox) {
        afz.tJ().abo.b(entity, boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
    }

    @Deprecated
    public static BoundingBox a(Entity entity, double d, double d2, double d3, double d4, double d5, double d6) {
        afz.tJ().abo.b(entity, d, d2, d3, d4, d5, d6);
        return entity.getBoundingBox();
    }

    public static boolean k(LivingEntity livingEntity) {
        switch (livingEntity.getType()) {
            case BAT: 
            case BLAZE: 
            case PARROT: 
            case PHANTOM: 
            case ENDER_DRAGON: 
            case VEX: 
            case GHAST: 
            case WITHER: {
                return true;
            }
        }
        return false;
    }

    public static boolean K(Entity entity) {
        if (!afz.h(entity.getType())) {
            return false;
        }
        return entity.getLocation().getBlock().getLightFromSky() > 11;
    }

    public static boolean h(EntityType entityType) {
        switch (entityType) {
            case PHANTOM: 
            case ZOMBIE: 
            case ZOMBIE_VILLAGER: 
            case STRAY: 
            case DROWNED: {
                return true;
            }
        }
        return false;
    }

    public static void a(Projectile projectile) {
        ItemStack itemStack = bbs.c(projectile);
        if (itemStack != null) {
            itemStack = itemStack.clone();
        }
        projectile.remove();
        if (projectile instanceof Arrow && ((Arrow)projectile).getPickupStatus() != AbstractArrow.PickupStatus.ALLOWED) {
            return;
        }
        if (itemStack != null) {
            bdf.b(projectile.getLocation(), itemStack);
        }
    }

    public static boolean J(Material material) {
        return material == Material.ITEM_FRAME || material == Material.GLOW_ITEM_FRAME;
    }

    public static boolean i(EntityType entityType) {
        return entityType == EntityType.ITEM_FRAME || entityType == EntityType.GLOW_ITEM_FRAME;
    }

    public static boolean b(Projectile projectile) {
        return switch (projectile.getType()) {
            case EntityType.ARROW, EntityType.SPECTRAL_ARROW, EntityType.TRIDENT -> {
                if (projectile instanceof Trident) {
                    if (bbs.aA(afz.c(projectile)) <= 0) {
                        yield true;
                    }
                    yield false;
                }
                if (projectile instanceof AbstractArrow) {
                    AbstractArrow var1_1 = (AbstractArrow)projectile;
                    if (var1_1.getPickupStatus() != AbstractArrow.PickupStatus.DISALLOWED) {
                        yield true;
                    }
                    yield false;
                }
                yield true;
            }
            default -> false;
        };
    }

    @Nullable
    public static ItemStack c(Projectile projectile) {
        try {
            switch (projectile.getType()) {
                case EXPERIENCE_BOTTLE: {
                    return ((ThrownExpBottle)projectile).getItem();
                }
                case EGG: {
                    return ((Egg)projectile).getItem();
                }
                case ENDER_PEARL: {
                    return ((EnderPearl)projectile).getItem();
                }
                case POTION: {
                    return ((ThrownPotion)projectile).getItem();
                }
                case SNOWBALL: {
                    return ((Snowball)projectile).getItem();
                }
            }
            if (projectile instanceof AbstractArrow) {
                if (aaa.Va) {
                    return ((AbstractArrow)projectile).getItemStack();
                }
                return afz.tK().d(projectile);
            }
        }
        catch (NoSuchMethodError noSuchMethodError) {
            // empty catch block
        }
        return null;
    }
}
