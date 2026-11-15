package itemsadder.m;

import dev.lone.itemsadder.s;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque123;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.WorldBridge_4;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_15 {
    public final Player xd;
    public final List xe = new CopyOnWriteArrayList();
    public final List xf = new CopyOnWriteArrayList();
    public final HashMap xg = new HashMap();
    public final HashMap xh = new HashMap();
    public final HashMap xi = new HashMap();
    private String xj;
    private Object xk;
    private long xl;

    public PlayerBridge_15(Player player) {
        this.xd = player;
    }

    public WorldBridge_4 aZ(String string) {
        return (WorldBridge_4)this.xg.get(string);
    }

    void a(WorldBridge_4 worldBridge_4) {
        this.xe.add(worldBridge_4);
        this.xg.put(worldBridge_4.getNamespacedID(), worldBridge_4);
        if (worldBridge_4 instanceof PlayerBridge_8) {
            PlayerBridge_8 playerBridge_8 = (PlayerBridge_8)worldBridge_4;
            this.xf.add(playerBridge_8);
            this.xh.put(worldBridge_4.getNamespacedID(), playerBridge_8);
            this.xi.put(playerBridge_8.wa, playerBridge_8);
        }
    }

    public void recalculateOffsets() {
        int n = 0;
        for (int i = 0; i < this.xe.size(); ++i) {
            WorldBridge_4 worldBridge_4 = (WorldBridge_4)this.xe.get(i);
            worldBridge_4.Y(n);
            if (!worldBridge_4.jL()) continue;
            n -= worldBridge_4.jJ();
        }
    }

    @Nullable
    public String kt() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for (WorldBridge_4 worldBridge_4 : this.xe) {
            if (!worldBridge_4.jL()) continue;
            stringBuilder.append(worldBridge_4.jK());
            ++n;
        }
        if (n == 0) {
            return null;
        }
        stringBuilder = new StringBuilder(Opaque123.c(stringBuilder.toString(), this.ku()));
        return stringBuilder.toString();
    }

    public int ku() {
        float f = 0.0f;
        for (WorldBridge_4 worldBridge_4 : this.xe) {
            f += (float)worldBridge_4.jJ();
        }
        return (int)f / 2;
    }

    public void kv() {
        String string = this.kt();
        if (string == null) {
            return;
        }
        if (string.equals(this.xj)) {
            if (System.currentTimeMillis() - this.xl < 1200L) {
                return;
            }
            PacketContainerHolder.a(this.xd, this.xk);
            this.xl = System.currentTimeMillis();
            return;
        }
        this.xj = string;
        this.xk = MaterialBarColorHolder.fe == null ? PacketContainerHolder.dw(string) : PacketContainerHolder.l(string, MaterialBarColorHolder.fe);
        PacketContainerHolder.a(this.xd, this.xk);
        this.xl = System.currentTimeMillis();
    }

    public void kw() {
        PacketContainerHolder.bI(this.xd);
    }

    public void kx() {
        for (WorldBridge_4 worldBridge_4 : this.xe) {
            if (!worldBridge_4.vN && !worldBridge_4.isVisible()) continue;
            worldBridge_4.setVisible(worldBridge_4.g(this.xd.getWorld()));
        }
    }

    public void ky() {
        for (WorldBridge_4 worldBridge_4 : this.xe) {
            worldBridge_4.aa(s.a((HumanEntity)this.xd, worldBridge_4));
        }
    }

    public PlayerBridge_8 ba(String string) {
        for (PlayerBridge_8 playerBridge_8 : this.xf) {
            if (!playerBridge_8.jX().equals(string)) continue;
            return playerBridge_8;
        }
        return null;
    }
}
