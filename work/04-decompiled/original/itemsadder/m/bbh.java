package itemsadder.m;

import itemsadder.m.bcc;
import org.apache.commons.lang.WordUtils;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public class bbh {
    public static String n(EntityType entityType) {
        return WordUtils.capitalizeFully((String)entityType.toString()).replace("_", " ");
    }

    public static String o(EntityType entityType) {
        return String.format("entity.minecraft.%s", entityType.toString().toLowerCase());
    }

    public static boolean hY(String string) {
        try {
            BarStyle.valueOf((String)string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static boolean hZ(String string) {
        try {
            BarColor.valueOf((String)string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static boolean ia(String string) {
        try {
            EntityType.valueOf((String)string);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public static boolean a(LivingEntity livingEntity, LivingEntity livingEntity2, double d, float f) {
        if (!livingEntity.hasLineOfSight((Entity)livingEntity2)) {
            return false;
        }
        if (bcc.f((Entity)livingEntity, (Entity)livingEntity2)) {
            livingEntity2.damage((double)f);
            return true;
        }
        return false;
    }

    public static boolean a(Projectile projectile, LivingEntity livingEntity, double d, float f) {
        if (bcc.f((Entity)projectile, (Entity)livingEntity)) {
            livingEntity.damage((double)f);
            return true;
        }
        return false;
    }

    public static Transformation b(Transformation transformation) {
        Vector3f vector3f = transformation.getTranslation();
        Quaternionf quaternionf = transformation.getLeftRotation();
        Vector3f vector3f2 = transformation.getScale();
        Quaternionf quaternionf2 = transformation.getRightRotation();
        Vector3f vector3f3 = new Vector3f((Vector3fc)vector3f);
        Quaternionf quaternionf3 = new Quaternionf((Quaternionfc)quaternionf);
        Vector3f vector3f4 = new Vector3f((Vector3fc)vector3f2);
        Quaternionf quaternionf4 = new Quaternionf((Quaternionfc)quaternionf2);
        return new Transformation(vector3f3, quaternionf3, vector3f4, quaternionf4);
    }

    public static Transformation CQ() {
        return new Transformation(new Vector3f(0.0f, 0.0f, 0.0f), new Quaternionf(), new Vector3f(1.0f, 1.0f, 1.0f), new Quaternionf());
    }
}
