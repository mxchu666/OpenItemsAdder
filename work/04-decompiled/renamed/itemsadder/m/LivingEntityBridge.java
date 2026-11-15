package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityWrapper;
import itemsadder.m.NmsWrapperFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.bukkit.entity.LivingEntity;

public class LivingEntityBridge {
    static Constructor WD;

    public static LivingEntityWrapper a(LivingEntity livingEntity, float f) {
        if (WD == null && (WD = NmsWrapperFactory.a(LivingEntityWrapper.class, false, LivingEntity.class, Float.TYPE)) == null) {
            throw new RuntimeException("Failed to get constructor for the body controller.");
        }
        try {
            return (LivingEntityWrapper)WD.newInstance(livingEntity, Float.valueOf(f));
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            CommandSenderBridge_5.error("Error finding constructor for IBodyRotController", reflectiveOperationException);
            return null;
        }
    }
}
