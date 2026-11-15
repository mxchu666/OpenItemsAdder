package itemsadder.m;

import itemsadder.m.aab;
import itemsadder.m.acm;
import itemsadder.m.bce;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.bukkit.entity.LivingEntity;

public class acn {
    static Constructor WD;

    public static acm a(LivingEntity livingEntity, float f) {
        if (WD == null && (WD = aab.a(acm.class, false, LivingEntity.class, Float.TYPE)) == null) {
            throw new RuntimeException("Failed to get constructor for the body controller.");
        }
        try {
            return (acm)WD.newInstance(livingEntity, Float.valueOf(f));
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            bce.error("Error finding constructor for IBodyRotController", reflectiveOperationException);
            return null;
        }
    }
}
