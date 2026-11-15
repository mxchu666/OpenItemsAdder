package itemsadder.m;

import itemsadder.m.aeg;
import itemsadder.m.aei;
import itemsadder.m.ba;
import me.clip.placeholderapi.util.Msg;

class bb {
    bb() {
    }

    public static boolean a(String string, ba ba2) {
        aei aei2 = aeg.tE().i(string, ba2.gH);
        if (aei2.aau != null && ba2.gI != null && aei2.aau.contains(ba2.gI)) {
            return true;
        }
        if (aei2.aav == null) {
            return false;
        }
        if (!ba2.gH) {
            Msg.info((String)("Executed item command: " + string + " | Response: " + String.valueOf(aei2)), (Object[])new Object[0]);
        }
        return aei2.aav;
    }
}
