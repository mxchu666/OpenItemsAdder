package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbl;
import itemsadder.m.bbm;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.tq;
import itemsadder.m.tr;
import itemsadder.m.ts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.bukkit.ChatColor;

public class sy {
    public static void pt() {
        String string = "conversion_backup_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        for (bbf bbf2 : d.g().b()) {
            List list = bbf2.gR("items");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No item found in file " + bbf2.qd());
                continue;
            }
            sy.a(bbf2, list, string);
        }
    }

    private static void a(bbf bbf2, List list, String string) {
        bbm bbm2 = null;
        try {
            ts ts2 = new ts(bbf2, list);
            tr tr2 = ts2.qk();
            if (tr2.isEmpty()) {
                return;
            }
            bbm2 = bbl.f(bbf2.getFile(), string);
            tr2.qg();
            bbf2.save();
            bbm2.CU();
            bce.log(String.valueOf(ChatColor.GREEN) + "[Converter] Successfully converted " + tr2.size() + " item(s) in file: " + bbf2.nh());
        }
        catch (tq tq2) {
            bce.error("[Converter] Conversion failed, rolling back. File: " + bbf2.nh(), tq2);
            sy.a(bbf2, bbm2);
        }
        catch (Exception exception) {
            bce.error("[Converter] Unexpected error during conversion, rolling back. File: " + bbf2.nh(), exception);
            sy.a(bbf2, bbm2);
        }
    }

    private static void a(bbf bbf2, bbm bbm2) {
        if (bbm2 == null) {
            return;
        }
        try {
            bbm2.CT();
            bbf2.reload();
            bce.warn("[Converter] Rolled back changes for file: " + bbf2.nh());
        }
        catch (Exception exception) {
            bce.error("[Converter] Failed to rollback file: " + bbf2.nh(), exception);
        }
    }
}
