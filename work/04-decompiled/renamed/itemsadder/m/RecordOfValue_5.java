package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Chunk;
import org.bukkit.Location;

public final class RecordOfValue_5
extends Record {
    private final int gV;
    private final int gW;
    private final int gX;
    private final String gY;
    private final byte gZ;

    public RecordOfValue_5(int n, int n2, int n3, String string, byte by) {
        this.gV = n;
        this.gW = n2;
        this.gX = n3;
        this.gY = string;
        this.gZ = by;
    }

    public Location b(Chunk chunk) {
        return new Location(chunk.getWorld(), (double)(chunk.getX() * 16 + this.gV), (double)this.gW, (double)(chunk.getZ() * 16 + this.gX));
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_5.class, "relX;y;relZ;namespacedId;age", "gV", "gW", "gX", "gY", "gZ"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_5.class, "relX;y;relZ;namespacedId;age", "gV", "gW", "gX", "gY", "gZ"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_5.class, "relX;y;relZ;namespacedId;age", "gV", "gW", "gX", "gY", "gZ"}, this, object);
    }

    public int bl() {
        return this.gV;
    }

    public int bm() {
        return this.gW;
    }

    public int bn() {
        return this.gX;
    }

    public String bj() {
        return this.gY;
    }

    public byte bk() {
        return this.gZ;
    }
}
