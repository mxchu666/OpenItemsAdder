package itemsadder.m;

import itemsadder.m.afz;
import itemsadder.m.bcp;
import itemsadder.m.ou;
import itemsadder.m.ox;
import itemsadder.m.pa;
import itemsadder.m.qm;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class nu
extends ou {
    public final Vector CR;
    public final ox CS;
    public final int CT;

    public nu(ox ox2, int n, int n2, int n3, int n4) {
        this.CS = ox2;
        this.CT = n4;
        this.CR = new Vector(n, n2, n3);
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player2) {
        Location location = player2.getLocation();
        int n = location.getBlockX();
        int n2 = location.getBlockY();
        int n3 = location.getBlockZ();
        int n4 = (int)this.CR.getX();
        int n5 = (int)this.CR.getY();
        int n6 = (int)this.CR.getZ();
        long l = (long)n4 * (long)n4;
        World world = location.getWorld();
        ArrayList<Integer> arrayList = new ArrayList<Integer>(101);
        block0: for (int i = n - n4; i <= n + n4; ++i) {
            long l2 = (long)(n - i) * (long)(n - i);
            for (int j = n3 - n6; j <= n3 + n6; ++j) {
                long l3 = l2 + (long)(n3 - j) * (long)(n3 - j);
                for (int k = n2 - n5; k < n2 + n5; ++k) {
                    Block block;
                    long l4 = l3 + (long)(n2 - k) * (long)(n2 - k);
                    if (l4 >= l || !this.CS.ap(block = world.getBlockAt(i, k + 2, j))) continue;
                    if (arrayList.size() > 100) break block0;
                    arrayList.add(afz.tK().V(new Location(world, (double)i + 0.5, (double)(k + 2), (double)j + 0.5)));
                }
            }
        }
        if (arrayList.size() > 0) {
            double d = 128.0 + new Vector(this.CR.getX(), this.CR.getY() + 2.0, this.CR.getZ()).length();
            double d2 = d * d;
            List<Player> list = world.getPlayers().stream().filter(player -> player.getLocation().distanceSquared(location) < d2).toList();
            int[] nArray = arrayList.stream().mapToInt(Integer::intValue).toArray();
            bcp.c(() -> list.stream().filter(OfflinePlayer::isOnline).forEach(player -> afz.tK().a((Player)player, nArray)), this.CT);
            return pa.ml();
        }
        return pa.mk();
    }
}
