package itemsadder.m;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

class EntityBuilder {
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

    EntityBuilder() {
    }

    @Nullable
    public static EntityBuilder r(Player player) {
        return (EntityBuilder)bO.get(player.getUniqueId());
    }

    public static EntityBuilder s(Player player) {
        return bO.put(player.getUniqueId(), new EntityBuilder());
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
