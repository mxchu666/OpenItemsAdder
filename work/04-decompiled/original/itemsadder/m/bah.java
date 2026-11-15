package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.ae;
import itemsadder.m.bai;
import itemsadder.m.bce;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class bah {
    private final Cache ayO = CacheBuilder.newBuilder().expireAfterAccess(ae.cy, TimeUnit.MINUTES).build();
    private final Cache ayP = CacheBuilder.newBuilder().expireAfterAccess(ae.cy, TimeUnit.MINUTES).build();
    private final Cache ayQ = CacheBuilder.newBuilder().expireAfterAccess(ae.cy, TimeUnit.MINUTES).build();
    private final int ayR;
    private final int ayS;

    public bah(int n, int n2) {
        this.ayR = n;
        this.ayS = n2;
    }

    public boolean a(String string, UUID uUID) {
        if (ae.cx && this.ayQ.asMap().getOrDefault(uUID, 0L) > System.currentTimeMillis()) {
            return false;
        }
        bai bai2 = (bai)this.ayO.getIfPresent(uUID);
        long l = System.currentTimeMillis();
        if (bai2 == null || l - bai2.ayT > (long)this.ayS * 1000L) {
            this.ayO.put(uUID, new bai(1, l));
            return true;
        }
        if (bai2.pU < this.ayR) {
            ++bai2.pU;
            this.ayO.put(uUID, bai2);
            return true;
        }
        if (ae.cx) {
            if (this.ayP.asMap().getOrDefault(uUID, 0) > ae.cz) {
                bce.warn("[SelfHost] '" + string + "' requests are ignored for " + ae.cy + " minutes.");
                bce.warn("[SelfHost] It might be a bot or a user trying to abuse the system.");
                this.ayQ.put(uUID, System.currentTimeMillis() + (long)(ae.cy * 60) * 1000L);
                this.ayP.put(uUID, 0);
            } else {
                this.ayP.put(uUID, this.ayP.asMap().getOrDefault(uUID, 0) + 1);
            }
        }
        return false;
    }
}
