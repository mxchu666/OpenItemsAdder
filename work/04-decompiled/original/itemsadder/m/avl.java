package itemsadder.m;

import com.comphenix.protocol.events.PacketEvent;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import org.bukkit.entity.Player;

public interface avl {
    public static final Cache anX = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.MINUTES).build();

    default public void ch(Player player) {
        anX.invalidate(player);
    }

    default public void d(PacketEvent packetEvent) {
        throw new RuntimeException("Not implemented!");
    }
}
