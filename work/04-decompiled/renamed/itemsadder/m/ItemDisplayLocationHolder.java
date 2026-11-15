package itemsadder.m;

import itemsadder.m.BoundingBoxBuilder;
import itemsadder.m.RecordOfValue_6;
import itemsadder.m.VectorBridge_3;
import lombok.Generated;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public class ItemDisplayLocationHolder {
    private volatile boolean kf;
    final ItemDisplay kg;
    @Nullable
    String namespacedId;
    int kh;
    long ki;
    private boolean kj = false;
    public float kk;
    public long kl;
    int km = 3;
    VectorBridge_3 kn;
    private volatile BoundingBoxBuilder ko = BoundingBoxBuilder.a(new Vector(0, 0, 0), new Vector(0, 0, 0));
    private final Location kp = new Location(null, 0.0, 0.0, 0.0);

    ItemDisplayLocationHolder(ItemDisplay itemDisplay, Location location, @Nullable String string, int n) {
        this.kg = itemDisplay;
        this.kn = new VectorBridge_3(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        this.namespacedId = string;
        this.kh = n;
        this.ki = System.currentTimeMillis();
    }

    public void q(boolean bl) {
        this.kj = bl;
    }

    public boolean a(RecordOfValue_6 recordOfValue_6, boolean bl, boolean bl2) {
        return this.b(this.a(recordOfValue_6), bl, bl2);
    }

    public boolean a(byte by, String string, boolean bl, boolean bl2) {
        return this.b(this.a(by, string), bl, bl2);
    }

    boolean a(RecordOfValue_6 recordOfValue_6) {
        return this.a(recordOfValue_6.bk(), recordOfValue_6.bj());
    }

    boolean b(RecordOfValue_6 recordOfValue_6) {
        return this.kh != recordOfValue_6.bk();
    }

    boolean c(RecordOfValue_6 recordOfValue_6) {
        return !recordOfValue_6.bj().equals(this.namespacedId);
    }

    private boolean a(byte by, String string) {
        return this.kh != by || !string.equals(this.namespacedId);
    }

    boolean b(boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        boolean bl5 = bl4 = this.kj && !bl2 || !this.kj && bl2;
        if (!bl && bl3 && bl2) {
            return false;
        }
        return bl || bl4;
    }

    public void cC() {
        this.ki = System.currentTimeMillis();
    }

    public boolean cD() {
        if (this.km - 1 > 0) {
            --this.km;
            return false;
        }
        this.km = 3;
        return true;
    }

    public World cE() {
        return this.kg.getWorld();
    }

    public Chunk cF() {
        return this.kg.getChunk();
    }

    public void k(Location location) {
        this.kn.ha = location.getBlockX();
        this.kn.gW = location.getBlockY();
        this.kn.hc = location.getBlockZ();
        this.kp.setWorld(location.getWorld());
        this.kp.set(location.getX(), location.getY(), location.getZ());
    }

    public Location getLocation() {
        return this.kp;
    }

    public Block getBlock() {
        return this.kp.getBlock();
    }

    @Generated
    public boolean cG() {
        return this.kf;
    }

    @Generated
    public void r(boolean bl) {
        this.kf = bl;
    }

    @Generated
    public void s(boolean bl) {
        this.kj = bl;
    }

    @Generated
    public boolean cH() {
        return this.kj;
    }

    @Generated
    public void a(BoundingBoxBuilder boundingBoxBuilder) {
        this.ko = boundingBoxBuilder;
    }

    @Generated
    public BoundingBoxBuilder cI() {
        return this.ko;
    }
}
