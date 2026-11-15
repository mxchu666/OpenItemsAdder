package itemsadder.m;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;
import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class VectorBuilder {
    private int ha;
    private int gW;
    private int hc;

    public VectorBuilder() {
    }

    public VectorBuilder(Block block) {
        this(block.getX(), block.getY(), block.getZ());
    }

    public VectorBuilder(Location location) {
        this(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public VectorBuilder(Vector vector) {
        this(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
    }

    public VectorBuilder(BlockPosition blockPosition) {
        this(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ());
    }

    public VectorBuilder(ChunkCoordIntPair chunkCoordIntPair) {
        this(chunkCoordIntPair.getChunkX() << 4, 0, chunkCoordIntPair.getChunkZ() << 4);
    }

    public VectorBuilder(short s) {
        this.ha = s >>> 8 & 0xF;
        this.gW = s & 0xF;
        this.hc = s >>> 4 & 0xF;
    }

    public VectorBuilder(int n, int n2, int n3) {
        this.ha = n;
        this.gW = n2;
        this.hc = n3;
    }

    public int Cu() {
        return this.ha;
    }

    public void bA(int n) {
        this.ha = n;
    }

    public int Cv() {
        return this.hc;
    }

    public void bB(int n) {
        this.hc = n;
    }

    public int Cw() {
        return this.gW;
    }

    public void bC(int n) {
        this.gW = n;
    }

    public VectorBuilder a(VectorBuilder vectorBuilder) {
        return this.l(vectorBuilder.ha, vectorBuilder.gW, vectorBuilder.hc);
    }

    public VectorBuilder l(int n, int n2, int n3) {
        this.ha += n;
        this.gW += n2;
        this.hc += n3;
        return this;
    }

    public VectorBuilder b(VectorBuilder vectorBuilder) {
        this.ha -= vectorBuilder.Cu();
        this.gW -= vectorBuilder.Cw();
        this.hc -= vectorBuilder.Cv();
        return this;
    }

    public VectorBuilder bD(int n) {
        this.ha *= n;
        this.gW *= n;
        this.hc *= n;
        return this;
    }

    public static VectorBuilder a(VectorBuilder vectorBuilder, VectorBuilder vectorBuilder2) {
        return new VectorBuilder(Math.min(vectorBuilder.ha, vectorBuilder2.ha), Math.min(vectorBuilder.gW, vectorBuilder2.gW), Math.min(vectorBuilder.hc, vectorBuilder2.hc));
    }

    public static VectorBuilder b(VectorBuilder vectorBuilder, VectorBuilder vectorBuilder2) {
        return new VectorBuilder(Math.max(vectorBuilder.ha, vectorBuilder2.ha), Math.max(vectorBuilder.gW, vectorBuilder2.gW), Math.max(vectorBuilder.hc, vectorBuilder2.hc));
    }

    public Vector Cx() {
        return new Vector(this.ha, this.gW, this.hc);
    }

    public Location u(World world) {
        return new Location(world, (double)this.ha, (double)this.gW, (double)this.hc);
    }

    public Block v(World world) {
        return world.getBlockAt(this.ha, this.gW, this.hc);
    }

    public BlockPosition Cy() {
        return new BlockPosition(this.ha, this.gW, this.hc);
    }

    public VectorBuilder Cz() {
        return new VectorBuilder(this.ha, this.gW, this.hc);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof VectorBuilder)) {
            return false;
        }
        VectorBuilder vectorBuilder = (VectorBuilder)object;
        return this.ha == vectorBuilder.ha && this.gW == vectorBuilder.gW && this.hc == vectorBuilder.hc;
    }

    public int hashCode() {
        return Objects.hash(this.ha, this.gW, this.hc);
    }

    public String toString() {
        return this.ha + "," + this.gW + "," + this.hc;
    }

    public short CA() {
        return (short)((this.ha & 0xF) << 8 | (this.hc & 0xF) << 4 | this.gW & 0xF);
    }

    public static VectorBuilder gv(String string) {
        if (string.length() < 11) {
            throw new IllegalArgumentException("Failed to deserialize BlockVecWrap " + string + ": Wrong string length.");
        }
        String[] stringArray = string.split(",");
        if (stringArray.length != 3) {
            throw new IllegalArgumentException("Failed to deserialize BlockVecWrap " + string + ": Check coordinates count.");
        }
        try {
            int n = Integer.parseInt(stringArray[0].substring(2));
            int n2 = Integer.parseInt(stringArray[1].substring(2));
            int n3 = Integer.parseInt(stringArray[2].substring(2));
            return new VectorBuilder(n, n2, n3);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Failed to deserialize BlockVecWrap " + string + ": " + numberFormatException.getMessage());
        }
    }

    public /* synthetic */ Object clone() {
        return this.Cz();
    }
}
