package itemsadder.m;

import itemsadder.m.BukkitTaskBridge;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
public class BukkitTaskBridge_2
extends ConcurrentHashMap {
    private final Map aCG = new ConcurrentHashMap();
    private long aCH = 6000L;
    @Nullable
    private BukkitTask aCI;

    public BukkitTaskBridge_2() {
        this.init();
    }

    public BukkitTaskBridge_2(long l) {
        this.aCH = l;
        this.init();
    }

    public void init() {
        this.aCI = BukkitTaskBridge.b(bukkitRunnable -> this.cy(), this.aCH, this.aCH);
    }

    @Override
    public Object put(@NotNull Object object, @NotNull Object object2) {
        this.aCG.put(object, System.currentTimeMillis());
        return super.put(object, object2);
    }

    @Override
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        Object object3 = super.putIfAbsent(object, object2);
        this.aCG.put(object, System.currentTimeMillis());
        return object3;
    }

    @Override
    public Object remove(@NotNull Object object) {
        Object v = super.remove(object);
        if (v != null) {
            this.aCG.remove(object);
            if (this.size() == 0) {
                this.Ej();
            }
        }
        return v;
    }

    @Override
    public boolean remove(Object object, Object object2) {
        boolean bl = super.remove(object, object2);
        if (bl) {
            this.aCG.remove(object, object2);
            if (this.size() == 0) {
                this.Ej();
            }
        }
        return bl;
    }

    public void Ei() {
        this.clear();
        this.aCG.clear();
        this.Ej();
    }

    private void cy() {
        long l = System.currentTimeMillis();
        Iterator iterator = this.aCG.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (l < (Long)this.aCG.get(entry.getKey()) + this.aCH) continue;
            iterator.remove();
            this.aCG.remove(entry.getKey());
        }
        if (this.size() == 0) {
            this.Ej();
        }
    }

    private void Ej() {
        if (this.aCI == null) {
            return;
        }
        this.aCI.cancel();
        this.aCI = null;
    }
}
