package itemsadder.m;

import dev.lone.itemsadder.api.CustomBlock;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridgeBuilder_3;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PlayerBridge_21;
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

public class LocationBridge_13 {
    public static NamespacedKey Jt = NamespacedKey.fromString((String)"itemsadder:primeable_block_id");
    public static final int Ju = 1;
    public static final int Jv = 2;
    public static final int Jw = 4;
    public static final int Jx = 8;
    public static boolean Jy;
    public final PlayerBridge_21 Jz;
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

    public boolean a(LocationBridgeBuilder_2 locationBridgeBuilder_2, Location location) {
        return this.a(locationBridgeBuilder_2, location, null);
    }

    public boolean a(LocationBridgeBuilder_2 locationBridgeBuilder_2, Location location, @Nullable Player player) {
        TNTPrimed tNTPrimed2;
        int n;
        BlockData blockData;
        if (!this.JC) {
            blockData = LocationBridge_4.aBu;
            int n2 = ((BlockFace[])blockData).length;
            for (n = 0; n < n2; n += 1) {
                BlockData blockData2 = blockData[n];
                if (location.getBlock().getRelative((BlockFace)blockData2).getType() != Material.WATER) continue;
                return false;
            }
        }
        int n3 = n = (tNTPrimed2 = EnumWrappersHolder.vC().aoJ.a(location = location.clone().add(0.5, 0.5, 0.5), this.JE, blockData = locationBridgeBuilder_2.FD.pb(), player, tNTPrimed -> tNTPrimed.getPersistentDataContainer().set(Jt, PersistentDataType.STRING, (Object)locationBridgeBuilder_2.getNamespacedID()))) != null && !tNTPrimed2.isDead() ? 1 : 0;
        if (n) {
            CustomBlock.remove(location);
        }
        return n != 0;
    }

    public static void pi() {
        LocationBridge_13.pj();
        for (LocationBridgeBuilder_2 locationBridgeBuilder_2 : ItemStackRegistry.g().S) {
            LocationBridge_13 locationBridge_13 = locationBridgeBuilder_2.mK();
            if (locationBridge_13 == null || !locationBridge_13.as(2)) continue;
            Jy = true;
        }
    }

    public static void pj() {
        Jy = false;
    }

    @Generated
    LocationBridge_13(PlayerBridge_21 playerBridge_21, int n, double d, boolean bl, boolean bl2, int n2, int n3) {
        this.Jz = playerBridge_21;
        this.JA = n;
        this.JB = d;
        this.JC = bl;
        this.JD = bl2;
        this.JE = n2;
        this.JF = n3;
    }

    @Generated
    public static LocationBridgeBuilder_3 pk() {
        return new LocationBridgeBuilder_3();
    }
}
