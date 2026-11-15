package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;

final class RecordOfUUID_2
extends Record {
    private final UUID sq;
    private final UUID sr;
    private final int ss;
    private final int st;
    private final int su;
    private final double sv;
    private final double sw;
    private final double sx;
    private final double sy;
    private final double sz;
    private final int sA;
    private final int sB;
    private final int sC;

    private RecordOfUUID_2(UUID uUID, UUID uUID2, int n, int n2, int n3, double d, double d2, double d3, double d4, double d5, int n4, int n5, int n6) {
        this.sq = uUID;
        this.sr = uUID2;
        this.ss = n;
        this.st = n2;
        this.su = n3;
        this.sv = d;
        this.sw = d2;
        this.sx = d3;
        this.sy = d4;
        this.sz = d5;
        this.sA = n4;
        this.sB = n5;
        this.sC = n6;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfUUID_2.class, "playerId;worldId;viewerLifecycle;rendererLifecycle;tick;eyeX;eyeY;eyeZ;lookX;lookZ;centerChunkX;centerChunkZ;chunkRadius", "sq", "sr", "ss", "st", "su", "sv", "sw", "sx", "sy", "sz", "sA", "sB", "sC"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfUUID_2.class, "playerId;worldId;viewerLifecycle;rendererLifecycle;tick;eyeX;eyeY;eyeZ;lookX;lookZ;centerChunkX;centerChunkZ;chunkRadius", "sq", "sr", "ss", "st", "su", "sv", "sw", "sx", "sy", "sz", "sA", "sB", "sC"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfUUID_2.class, "playerId;worldId;viewerLifecycle;rendererLifecycle;tick;eyeX;eyeY;eyeZ;lookX;lookZ;centerChunkX;centerChunkZ;chunkRadius", "sq", "sr", "ss", "st", "su", "sv", "sw", "sx", "sy", "sz", "sA", "sB", "sC"}, this, object);
    }

    public UUID hu() {
        return this.sq;
    }

    public UUID bu() {
        return this.sr;
    }

    public int hv() {
        return this.ss;
    }

    public int hw() {
        return this.st;
    }

    public int hx() {
        return this.su;
    }

    public double cs() {
        return this.sv;
    }

    public double ct() {
        return this.sw;
    }

    public double cu() {
        return this.sx;
    }

    public double hy() {
        return this.sy;
    }

    public double hz() {
        return this.sz;
    }

    public int hA() {
        return this.sA;
    }

    public int hB() {
        return this.sB;
    }

    public int hC() {
        return this.sC;
    }
}
