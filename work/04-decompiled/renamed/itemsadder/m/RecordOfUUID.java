package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public final class RecordOfUUID
extends Record {
    private final UUID hr;
    private final int hs;
    private final int ht;

    public RecordOfUUID(UUID uUID, int n, int n2) {
        this.hr = uUID;
        this.hs = n;
        this.ht = n2;
    }

    public static RecordOfUUID k(Chunk chunk) {
        return new RecordOfUUID(chunk.getWorld().getUID(), chunk.getX(), chunk.getZ());
    }

    @Nullable
    public Chunk bt() {
        World world = Bukkit.getWorld((UUID)this.hr);
        if (world == null) {
            return null;
        }
        return world.isChunkLoaded(this.hs, this.ht) ? world.getChunkAt(this.hs, this.ht) : null;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfUUID.class, "worldId;x;z", "hr", "hs", "ht"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfUUID.class, "worldId;x;z", "hr", "hs", "ht"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfUUID.class, "worldId;x;z", "hr", "hs", "ht"}, this, object);
    }

    public UUID bu() {
        return this.hr;
    }

    public int bo() {
        return this.hs;
    }

    public int bp() {
        return this.ht;
    }
}
