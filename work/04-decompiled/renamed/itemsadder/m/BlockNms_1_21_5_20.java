package itemsadder.m;

import itemsadder.m.AFunction;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.VersionHelper_3;
import java.lang.reflect.Field;
import net.minecraft.network.syncher.DataWatcherObject;
import net.minecraft.world.entity.monster.EntitySlime;
import org.bukkit.craftbukkit.v1_21_R4.entity.CraftSlime;
import org.bukkit.entity.Entity;

public class BlockNms_1_21_5_20
implements AFunction {
    static Object anW = null;

    @Override
    public void a(Entity entity, int n) {
        Object object;
        if (anW == null) {
            try {
                object = VersionHelper_3.a(EntitySlime.class, DataWatcherObject.class);
                if (object == null) {
                    throw new NullPointerException();
                }
                anW = VersionHelper_3.a((Field)object, null);
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Error getting SIZE field of Slime entity.");
                exception.printStackTrace();
                return;
            }
        }
        object = (CraftSlime)entity;
        object.getHandle().ar().a((DataWatcherObject)anW, (Object)n);
    }
}
