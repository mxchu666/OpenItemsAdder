package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.agc;
import itemsadder.m.bcp;
import itemsadder.m.um;
import java.lang.runtime.SwitchBootstraps;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public interface agb {
    public static final Vector3f abr = new Vector3f(1.0f, 1.0f, 1.0f);

    public void a(Entity var1, float var2);

    public float L(Entity var1);

    public float M(Entity var1);

    public void c(Entity var1, float var2);

    public void b(Entity var1, boolean var2);

    public void N(Entity var1);

    public void b(Entity var1, float var2);

    @Deprecated
    public void a(Entity var1, double var2, double var4, double var6);

    @Deprecated
    public void b(Entity var1, double var2, double var4, double var6, double var8, double var10, double var12);

    default public void a(Entity entity, BoundingBox boundingBox) {
        this.b(entity, boundingBox.getMinX(), boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxY(), boundingBox.getMinZ(), boundingBox.getMaxZ());
    }

    public void a(Entity var1, double var2, double var4, double var6, float var8, float var9, boolean var10);

    public void b(Entity var1, double var2, double var4, double var6);

    public void O(Entity var1);

    public void a(Mob var1, boolean var2);

    default public boolean j(EntityType entityType) {
        return true;
    }

    public void a(Entity var1, float var2, float var3);

    public boolean P(Entity var1);

    public void f(Player var1, int var2);

    public void a(Player var1, int ... var2);

    @Nullable
    public ItemStack d(Projectile var1);

    public void a(Entity var1, byte var2);

    default public void Q(Entity entity) {
        Entity entity2 = entity;
        int n = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ArmorStand.class, ItemDisplay.class}, (Object)entity2, n)) {
            case 0: {
                ArmorStand armorStand = (ArmorStand)entity2;
                this.a((Entity)armorStand, (byte)32);
                break;
            }
            case 1: {
                ItemDisplay itemDisplay = (ItemDisplay)entity2;
                itemDisplay.setInterpolationDelay(0);
                itemDisplay.setInterpolationDuration(2);
                float f = (float)Math.toRadians(3.0);
                Transformation transformation = itemDisplay.getTransformation();
                Quaternionf quaternionf = new Quaternionf((Quaternionfc)transformation.getLeftRotation());
                Quaternionf quaternionf2 = new Quaternionf().fromAxisAngleRad((Vector3fc)new Vector3f(0.0f, 1.0f, 0.0f), f);
                Quaternionf quaternionf3 = new Quaternionf().fromAxisAngleRad((Vector3fc)new Vector3f(0.0f, 1.0f, 0.0f), -f);
                transformation.getLeftRotation().mul((Quaternionfc)quaternionf2);
                itemDisplay.setTransformation(transformation);
                bcp.c(() -> {
                    transformation.getLeftRotation().mul((Quaternionfc)quaternionf3);
                    itemDisplay.setTransformation(transformation);
                    bcp.c(() -> {
                        transformation.getLeftRotation().set((Quaternionfc)quaternionf);
                        itemDisplay.setTransformation(transformation);
                    }, 2L);
                }, 2L);
                break;
            }
        }
    }

    public int V(Location var1);

    public void a(Player var1, LivingEntity var2);

    public void a(PacketEvent var1, boolean var2);

    public void c(LivingEntity var1, boolean var2);

    public void bM(Player var1);

    public void bN(Player var1);

    public boolean a(Entity var1, um var2);

    public boolean R(Entity var1);

    default public void a(LivingEntity livingEntity, double d) {
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            this.a(livingEntity, new NamespacedKey("minecraft", "movement_speed"), d);
        } else {
            this.a(livingEntity, new NamespacedKey("minecraft", "generic.movement_speed"), d);
        }
    }

    default public void b(LivingEntity livingEntity, double d) {
        if (Version.isAtLeast((Version)Version.v1_21_3)) {
            this.a(livingEntity, new NamespacedKey("minecraft", "flying_speed"), d);
        } else {
            this.a(livingEntity, new NamespacedKey("minecraft", "generic.flying_speed"), d);
        }
    }

    public void a(LivingEntity var1, NamespacedKey var2, double var3);

    @Nullable
    public Location l(LivingEntity var1);

    public boolean m(@UnknownNullability LivingEntity var1);

    @Nullable
    public agc k(EntityType var1);

    public boolean a(LivingEntity var1, LivingEntity var2);

    @Nullable
    public Entity a(@NotNull World var1, UUID var2);

    @Nullable
    public Entity a(@NotNull World var1, int var2);

    default public void a(ItemDisplay itemDisplay, Vector3f vector3f, Quaternionf quaternionf) {
        throw new RuntimeException("Not implemented for the current server version (1.21.4+ only)");
    }
}
