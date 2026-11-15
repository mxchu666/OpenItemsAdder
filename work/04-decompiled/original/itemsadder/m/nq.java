package itemsadder.m;

import itemsadder.m.aeg;
import itemsadder.m.aei;
import itemsadder.m.np;
import me.clip.placeholderapi.util.Msg;

class nq {
    nq() {
    }

    public static boolean a(String string, np np2) {
        aei aei2 = aeg.tE().i(string, np2.CJ);
        if (aei2.aau != null && np2.CK != null && aei2.aau.contains(np2.CK)) {
            return true;
        }
        if (aei2.aav == null) {
            return false;
        }
        if (!np2.CJ) {
            Msg.info((String)("Executed item command: " + string + " | Response: " + String.valueOf(aei2)), (Object[])new Object[0]);
        }
        return aei2.aav;
    }
}
