package itemsadder.m;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

class x {
    private static final HashMap bO = new HashMap();
    public long bP;
    public long bQ;
    public long bR;
    public long bS;
    public long bT;
    public long bU;
    public long bV;
    public long bW;
    public long bX;
    @Nullable
    public BlockFace bY;
    @Nullable
    public Block bZ;
    private WeakReference ca = new WeakReference<Object>(null);

    x() {
    }

    @Nullable
    public static x r(Player player) {
        return (x)bO.get(player.getUniqueId());
    }

    public static x s(Player player) {
        return bO.put(player.getUniqueId(), new x());
    }

    public static void t(Player player) {
        bO.remove(player.getUniqueId());
    }

    public void b(Entity entity) {
        this.ca = new WeakReference<Entity>(entity);
    }

    @Nullable
    public Entity aj() {
        return (Entity)this.ca.get();
    }
}
