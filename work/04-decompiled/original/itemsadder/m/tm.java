package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.axi;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.tl;
import itemsadder.m.wv;
import itemsadder.m.ww;
import itemsadder.m.wy;
import itemsadder.m.wz;
import itemsadder.m.xb;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class tm
implements Listener {
    tm() {
        bev.a(this, Main.rT());
    }

    @EventHandler
    private void c(WorldLoadEvent worldLoadEvent) {
        tl.a(worldLoadEvent.getWorld(), wv.Oz);
        tl.a(worldLoadEvent.getWorld(), wz.Oz);
        tl.a(worldLoadEvent.getWorld(), wy.OF);
        tl.a(worldLoadEvent.getWorld(), ww.Oz);
    }

    @EventHandler
    private void a(WorldUnloadEvent worldUnloadEvent) {
        tl.h(worldUnloadEvent.getWorld());
    }

    @EventHandler
    private void a(ChunkPopulateEvent chunkPopulateEvent) {
        xb xb2 = (xb)xb.OQ.get(chunkPopulateEvent.getWorld().getUID());
        if (xb2 == null) {
            return;
        }
        List list = axi.vC().aoJ.a(chunkPopulateEvent.getChunk(), xb2.OR, xb2.OS);
        for (ww ww2 : xb2.Ow) {
            xb2.a(list, chunkPopulateEvent.getChunk(), bcy.Bl, ww2);
        }
    }
}
