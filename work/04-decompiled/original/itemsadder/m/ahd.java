package itemsadder.m;

import itemsadder.m.aab;
import itemsadder.m.ahe;
import itemsadder.m.bcc;
import java.util.Collection;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

@Deprecated
public final class ahd {
    private final ahe abL = (ahe)aab.n(ahe.class);
    public static ahd abM;

    ahd() {
    }

    public static ahd tM() {
        if (abM == null) {
            abM = new ahd();
        }
        return abM;
    }

    public static ahe tN() {
        return ahd.tM().abL;
    }

    public static void a(Block block, BlockData blockData) {
        Location location = block.getLocation();
        Collection collection = bcc.ad(location);
        for (Player player : collection) {
            player.sendBlockChange(location, blockData);
        }
    }
}
