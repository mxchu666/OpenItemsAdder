package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.qm;

public class so {
    public static boolean c(bbg bbg2) {
        return bbg2.fo("durability");
    }

    public static boolean b(qm qm2, bbg bbg2, bbf bbf2, String string, String string2) {
        boolean bl;
        boolean bl2 = bbg2.C("durability.disappear_when_broken", true);
        boolean bl3 = bbg2.C("durability.unbreakable", false);
        boolean bl4 = bbg2.gP("durability.durability") || bbg2.gP("durability.custom_durability");
        boolean bl5 = bl = bbg2.gP("durability.max_durability") || bbg2.gP("durability.max_custom_durability");
        if (bl4 || bl) {
            int n = bbg2.t("durability.max_durability", bbg2.t("durability.max_custom_durability", qm2.getType().getMaxDurability()));
            int n2 = bbg2.t("durability.custom_durability", bbg2.t("durability.durability", n));
            if (bl && !bl4) {
                n2 = n;
            }
            if (bl4 && !bl) {
                n = bbs.E(qm2);
            }
            if (n <= 0) {
                bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'max_durability' must be > 0. File: " + bbf2.nh());
                return false;
            }
            if (n2 < 0) {
                bce.error("[Items] '" + string + ":" + string2 + "' - Error: 'durability' must >= 0. File: " + bbf2.nh());
                return false;
            }
            if (n2 > n) {
                bce.error("[Items] '" + string + ":" + string2 + "' - Error: 'durability' must be <= 'max_durability'. File: " + bbf2.nh());
                return false;
            }
            qm2.a(n2, n, bl2, bl3);
        } else {
            qm2.a(null, null, bl2, bl3);
        }
        return true;
    }
}
