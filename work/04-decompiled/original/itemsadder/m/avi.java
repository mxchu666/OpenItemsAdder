package itemsadder.m;

import itemsadder.m.auw;
import itemsadder.m.bce;
import itemsadder.m.zw;
import java.lang.reflect.Field;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.Slime;
import org.bukkit.craftbukkit.entity.CraftSlime;
import org.bukkit.entity.Entity;

public class avi
implements auw {
    static Object anW = null;

    @Override
    public void a(Entity entity, int n) {
        Object object;
        if (anW == null) {
            try {
                object = zw.a(Slime.class, EntityDataAccessor.class);
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
        object.getHandle().getEntityData().set((EntityDataAccessor)anW, (Object)n);
    }
}
