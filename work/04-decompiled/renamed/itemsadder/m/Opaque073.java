package itemsadder.m;

import itemsadder.m.Json_2;
import itemsadder.m.Opaque074;

class Opaque073 {
    int bK;

    Opaque073(Json_2 json_2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[1];
        this.bK = 639169990;
        byArray[0] = (byte)(this.bK >>> 20);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new Opaque074(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
