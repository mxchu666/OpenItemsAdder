package itemsadder.m;

import dev.lone.itemsadder.api.CustomBlock;
import itemsadder.m.axi;
import itemsadder.m.bdf;
import itemsadder.m.d;
import itemsadder.m.o;
import itemsadder.m.ql;
import itemsadder.m.sf;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public class se {
    public static NamespacedKey Jt = NamespacedKey.fromString((String)"itemsadder:primeable_block_id");
    public static final int Ju = 1;
    public static final int Jv = 2;
    public static final int Jw = 4;
    public static final int Jx = 8;
    public static boolean Jy;
    public final o Jz;
    public final int JA;
    public final double JB;
    public final boolean JC;
    public final boolean JD;
    public final int JE;
    public final int JF;

    public static int o(int n, int n2) {
        return n | n2;
    }

    public boolean as(int n) {
        return (this.JF & n) != 0;
    }

    public boolean a(ql ql2, Location location) {
        return this.a(ql2, location, null);
    }

    public boolean a(ql ql2, Location location, @Nullable Player player) {
        TNTPrimed tNTPrimed2;
        int n;
        BlockData blockData;
        if (!this.JC) {
            blockData = bdf.aBu;
            int n2 = ((BlockFace[])blockData).length;
            for (n = 0; n < n2; n += 1) {
                BlockData blockData2 = blockData[n];
                if (location.getBlock().getRelative((BlockFace)blockData2).getType() != Material.WATER) continue;
                return false;
            }
        }
        int n3 = n = (tNTPrimed2 = axi.vC().aoJ.a(location = location.clone().add(0.5, 0.5, 0.5), this.JE, blockData = ql2.FD.pb(), player, tNTPrimed -> tNTPrimed.getPersistentDataContainer().set(Jt, PersistentDataType.STRING, (Object)ql2.getNamespacedID()))) != null && !tNTPrimed2.isDead() ? 1 : 0;
        if (n) {
            CustomBlock.remove(location);
        }
        return n != 0;
    }

    public static void pi() {
        se.pj();
        for (ql ql2 : d.g().S) {
            se se2 = ql2.mK();
            if (se2 == null || !se2.as(2)) continue;
            Jy = true;
        }
    }

    public static void pj() {
        Jy = false;
    }

    @Generated
    se(o o2, int n, double d2, boolean bl, boolean bl2, int n2, int n3) {
        this.Jz = o2;
        this.JA = n;
        this.JB = d2;
        this.JC = bl;
        this.JD = bl2;
        this.JE = n2;
        this.JF = n3;
    }

    @Generated
    public static sf pk() {
        return new sf();
    }
}
