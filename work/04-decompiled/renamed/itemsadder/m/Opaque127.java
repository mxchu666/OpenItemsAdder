package itemsadder.m;

import itemsadder.m.ItemStackBridge_16;
import itemsadder.m.Opaque001;
import itemsadder.m.StringBoolBooleanData;
import me.clip.placeholderapi.util.Msg;

class Opaque127 {
    Opaque127() {
    }

    public static boolean a(String string, ItemStackBridge_16 itemStackBridge_16) {
        StringBoolBooleanData stringBoolBooleanData = Opaque001.tE().i(string, itemStackBridge_16.CJ);
        if (stringBoolBooleanData.aau != null && itemStackBridge_16.CK != null && stringBoolBooleanData.aau.contains(itemStackBridge_16.CK)) {
            return true;
        }
        if (stringBoolBooleanData.aav == null) {
            return false;
        }
        if (!itemStackBridge_16.CJ) {
            Msg.info((String)("Executed item command: " + string + " | Response: " + String.valueOf(stringBoolBooleanData)), (Object[])new Object[0]);
        }
        return stringBoolBooleanData.aav;
    }
}
