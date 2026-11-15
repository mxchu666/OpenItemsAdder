package itemsadder.m;

import itemsadder.m.afz;
import org.bukkit.entity.Entity;

public class le {
    private int zU = -1;
    private long zV;
    private int pU;

    public boolean a(Entity entity, long l) {
        afz.tK().Q(entity);
        return this.a(entity.getEntityId(), System.currentTimeMillis(), l);
    }

    boolean a(int n, long l, long l2) {
        if (n != this.zU || l - this.zV > l2) {
            this.zU = n;
            this.pU = 0;
        }
        this.zV = l;
        return ++this.pU >= 2;
    }
}
