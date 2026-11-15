package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;

final class fi
extends Record {
    private final UUID sG;
    private final UUID sH;
    private final int sI;
    private final int sJ;
    private final int sK;

    fi(UUID uUID, UUID uUID2, int n, int n2, int n3) {
        this.sG = uUID;
        this.sH = uUID2;
        this.sI = n;
        this.sJ = n2;
        this.sK = n3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{fi.class, "playerId;worldId;chunkX;chunkZ;rendererLifecycle", "sG", "sH", "sI", "sJ", "sK"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{fi.class, "playerId;worldId;chunkX;chunkZ;rendererLifecycle", "sG", "sH", "sI", "sJ", "sK"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{fi.class, "playerId;worldId;chunkX;chunkZ;rendererLifecycle", "sG", "sH", "sI", "sJ", "sK"}, this, object);
    }

    public UUID hu() {
        return this.sG;
    }

    public UUID bu() {
        return this.sH;
    }

    public int hG() {
        return this.sI;
    }

    public int hH() {
        return this.sJ;
    }

    public int hw() {
        return this.sK;
    }
}
