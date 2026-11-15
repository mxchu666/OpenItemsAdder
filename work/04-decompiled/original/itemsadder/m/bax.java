package itemsadder.m;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;
import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class bax {
    private int ha;
    private int gW;
    private int hc;

    public bax() {
    }

    public bax(Block block) {
        this(block.getX(), block.getY(), block.getZ());
    }

    public bax(Location location) {
        this(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public bax(Vector vector) {
        this(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
    }

    public bax(BlockPosition blockPosition) {
        this(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ());
    }

    public bax(ChunkCoordIntPair chunkCoordIntPair) {
        this(chunkCoordIntPair.getChunkX() << 4, 0, chunkCoordIntPair.getChunkZ() << 4);
    }

    public bax(short s) {
        this.ha = s >>> 8 & 0xF;
        this.gW = s & 0xF;
        this.hc = s >>> 4 & 0xF;
    }

    public bax(int n, int n2, int n3) {
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

    public bax a(bax bax2) {
        return this.l(bax2.ha, bax2.gW, bax2.hc);
    }

    public bax l(int n, int n2, int n3) {
        this.ha += n;
        this.gW += n2;
        this.hc += n3;
        return this;
    }

    public bax b(bax bax2) {
        this.ha -= bax2.Cu();
        this.gW -= bax2.Cw();
        this.hc -= bax2.Cv();
        return this;
    }

    public bax bD(int n) {
        this.ha *= n;
        this.gW *= n;
        this.hc *= n;
        return this;
    }

    public static bax a(bax bax2, bax bax3) {
        return new bax(Math.min(bax2.ha, bax3.ha), Math.min(bax2.gW, bax3.gW), Math.min(bax2.hc, bax3.hc));
    }

    public static bax b(bax bax2, bax bax3) {
        return new bax(Math.max(bax2.ha, bax3.ha), Math.max(bax2.gW, bax3.gW), Math.max(bax2.hc, bax3.hc));
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

    public bax Cz() {
        return new bax(this.ha, this.gW, this.hc);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof bax)) {
            return false;
        }
        bax bax2 = (bax)object;
        return this.ha == bax2.ha && this.gW == bax2.gW && this.hc == bax2.hc;
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

    public static bax gv(String string) {
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
            return new bax(n, n2, n3);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Failed to deserialize BlockVecWrap " + string + ": " + numberFormatException.getMessage());
        }
    }

    public /* synthetic */ Object clone() {
        return this.Cz();
    }
}
