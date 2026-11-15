package itemsadder.m;

import itemsadder.m.LocationBridge_14;
import java.util.HashSet;
import java.util.List;
import lombok.Generated;

@Generated
public abstract class LocationBridgeBuilder_4 {
    @Generated
    private boolean Lw;
    @Generated
    private List Lx;
    @Generated
    private boolean Ly;
    @Generated
    private List Lz;
    @Generated
    private boolean LA;
    @Generated
    private List LB;
    @Generated
    private boolean LC;
    @Generated
    private HashSet LD;
    @Generated
    private boolean LE;
    @Generated
    private HashSet LF;
    @Generated
    private boolean Lu;
    @Generated
    private boolean Lv;

    @Generated
    public LocationBridgeBuilder_4 r(List list) {
        this.Lx = list;
        this.Lw = true;
        return this.bQ();
    }

    @Generated
    public LocationBridgeBuilder_4 s(List list) {
        this.Lz = list;
        this.Ly = true;
        return this.bQ();
    }

    @Generated
    public LocationBridgeBuilder_4 t(List list) {
        this.LB = list;
        this.LA = true;
        return this.bQ();
    }

    @Generated
    public LocationBridgeBuilder_4 a(HashSet hashSet) {
        this.LD = hashSet;
        this.LC = true;
        return this.bQ();
    }

    @Generated
    public LocationBridgeBuilder_4 b(HashSet hashSet) {
        this.LF = hashSet;
        this.LE = true;
        return this.bQ();
    }

    @Generated
    public LocationBridgeBuilder_4 aB(boolean bl) {
        this.Lu = bl;
        return this.bQ();
    }

    @Generated
    public LocationBridgeBuilder_4 aC(boolean bl) {
        this.Lv = bl;
        return this.bQ();
    }

    @Generated
    protected abstract LocationBridgeBuilder_4 bQ();

    @Generated
    public abstract LocationBridge_14 bP();

    @Generated
    public String toString() {
        return "LootEntry.LootEntryBuilder(lootItems$value=" + String.valueOf(this.Lx) + ", lootExpDrops$value=" + String.valueOf(this.Lz) + ", lootExecuteCommands$value=" + String.valueOf(this.LB) + ", biomes$value=" + String.valueOf(this.LD) + ", worlds$value=" + String.valueOf(this.LF) + ", dropOnlyFirst=" + this.Lu + ", hasAnyWorldRule=" + this.Lv + ")";
    }
}
