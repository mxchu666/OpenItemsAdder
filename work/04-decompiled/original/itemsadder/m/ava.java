package itemsadder.m;

import itemsadder.m.auw;
import itemsadder.m.bce;
import itemsadder.m.zw;
import java.lang.reflect.Field;
import net.minecraft.network.syncher.DataWatcherObject;
import net.minecraft.world.entity.monster.EntitySlime;
import org.bukkit.craftbukkit.v1_21_R6.entity.CraftSlime;
import org.bukkit.entity.Entity;

public class ava
implements auw {
    static Object anW = null;

    @Override
    public void a(Entity entity, int n) {
        Object object;
        if (anW == null) {
            try {
                object = zw.a(EntitySlime.class, DataWatcherObject.class);
                if (object == null) {
                    throw new NullPointerException();
                }
                anW = zw.a((Field)object, null);
            }
            catch (Exception exception) {
                bce.error("Error getting SIZE field of Slime entity.");
                exception.printStackTrace();
                return;
            }
        }
        object = (CraftSlime)entity;
        object.getHandle().aC().a((DataWatcherObject)anW, (Object)n);
    }
}
