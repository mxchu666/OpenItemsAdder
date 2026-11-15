package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.IntLongData;
import itemsadder.m.MaterialBarColorHolder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Opaque010 {
    private final Cache ayO = CacheBuilder.newBuilder().expireAfterAccess(MaterialBarColorHolder.cy, TimeUnit.MINUTES).build();
    private final Cache ayP = CacheBuilder.newBuilder().expireAfterAccess(MaterialBarColorHolder.cy, TimeUnit.MINUTES).build();
    private final Cache ayQ = CacheBuilder.newBuilder().expireAfterAccess(MaterialBarColorHolder.cy, TimeUnit.MINUTES).build();
    private final int ayR;
    private final int ayS;

    public Opaque010(int n, int n2) {
        this.ayR = n;
        this.ayS = n2;
    }

    public boolean a(String string, UUID uUID) {
        if (MaterialBarColorHolder.cx && this.ayQ.asMap().getOrDefault(uUID, 0L) > System.currentTimeMillis()) {
            return false;
        }
        IntLongData intLongData = (IntLongData)this.ayO.getIfPresent(uUID);
        long l = System.currentTimeMillis();
        if (intLongData == null || l - intLongData.ayT > (long)this.ayS * 1000L) {
            this.ayO.put(uUID, new IntLongData(1, l));
            return true;
        }
        if (intLongData.pU < this.ayR) {
            ++intLongData.pU;
            this.ayO.put(uUID, intLongData);
            return true;
        }
        if (MaterialBarColorHolder.cx) {
            if (this.ayP.asMap().getOrDefault(uUID, 0) > MaterialBarColorHolder.cz) {
                CommandSenderBridge_5.warn("[SelfHost] '" + string + "' requests are ignored for " + MaterialBarColorHolder.cy + " minutes.");
                CommandSenderBridge_5.warn("[SelfHost] It might be a bot or a user trying to abuse the system.");
                this.ayQ.put(uUID, System.currentTimeMillis() + (long)(MaterialBarColorHolder.cy * 60) * 1000L);
                this.ayP.put(uUID, 0);
            } else {
                this.ayP.put(uUID, this.ayP.asMap().getOrDefault(uUID, 0) + 1);
            }
        }
        return false;
    }
}
