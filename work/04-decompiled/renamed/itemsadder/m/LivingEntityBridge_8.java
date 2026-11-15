package itemsadder.m;

import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import org.bukkit.entity.LivingEntity;

public abstract class LivingEntityBridge_8 {
    public static void a(LivingEntity livingEntity, Field field, Field field2, Object object, Object object2) {
        VersionHelper_3.a(field, object, object2);
        VersionHelper_3.a(field2, object2, object);
    }
}
