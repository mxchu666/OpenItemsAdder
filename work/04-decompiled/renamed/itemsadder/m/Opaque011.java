package itemsadder.m;

import itemsadder.m.EventBridge;
import itemsadder.m.Opaque001;
import itemsadder.m.StringBoolBooleanData;
import me.clip.placeholderapi.util.Msg;

class Opaque011 {
    Opaque011() {
    }

    public static boolean a(String string, EventBridge eventBridge) {
        StringBoolBooleanData stringBoolBooleanData = Opaque001.tE().i(string, eventBridge.gH);
        if (stringBoolBooleanData.aau != null && eventBridge.gI != null && stringBoolBooleanData.aau.contains(eventBridge.gI)) {
            return true;
        }
        if (stringBoolBooleanData.aav == null) {
            return false;
        }
        if (!eventBridge.gH) {
            Msg.info((String)("Executed item command: " + string + " | Response: " + String.valueOf(stringBoolBooleanData)), (Object[])new Object[0]);
        }
        return stringBoolBooleanData.aav;
    }
}
