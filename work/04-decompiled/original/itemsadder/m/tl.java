package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.tm;
import itemsadder.m.wu;
import itemsadder.m.wv;
import itemsadder.m.ww;
import itemsadder.m.wy;
import itemsadder.m.wz;
import itemsadder.m.xa;
import itemsadder.m.xb;
import itemsadder.m.xc;
import itemsadder.m.xd;
import java.util.List;
import java.util.Map;
import org.bukkit.World;
import org.bukkit.event.Listener;

public class tl
implements Listener {
    static tm KL;

    public static void reload() {
        tl.pW();
        KL = new tm();
        for (bbf bbf2 : d.g().b()) {
            wv.h(bbf2);
            wz.h(bbf2);
            wy.h(bbf2);
            ww.h(bbf2);
        }
        tl.q(xa.md);
        tl.q(xd.md);
        tl.q(xc.md);
        tl.q(xb.md);
    }

    public static void pW() {
        if (KL != null) {
            bev.b(KL);
        }
        tl.mc();
    }

    public static void mc() {
        for (wu wu2 : xa.md) {
            ((xa)wu2).rN();
        }
        xa.md.clear();
        for (wu wu2 : xd.md) {
            ((xd)wu2).rN();
        }
        xd.md.clear();
        for (wu wu2 : xc.md) {
            ((xc)wu2).rN();
        }
        xc.md.clear();
        for (wu wu2 : xb.md) {
            ((xb)wu2).rN();
        }
        xb.md.clear();
        xb.OQ.clear();
    }

    static void p(List list) {
        list.removeIf(wu2 -> {
            wu2.rN();
            return true;
        });
    }

    static void q(List list) {
        list.forEach(wu2 -> wu2.hn());
    }

    static void a(World world, Map map) {
        map.forEach((string, wt2) -> wt2.k(world));
    }

    static void a(World world, List list) {
        world.getPopulators().removeIf(blockPopulator -> blockPopulator instanceof wu);
        list.removeIf(wu2 -> {
            if (!world.equals((Object)wu2.cE())) {
                return false;
            }
            wu2.rN();
            return true;
        });
    }

    public static void h(World world) {
        tl.a(world, xa.md);
        tl.a(world, xd.md);
        tl.a(world, xc.md);
        tl.a(world, xb.md);
        xb.OQ.remove(world.getUID());
    }
}
