package itemsadder.m;

import itemsadder.m.Json_2;
import itemsadder.m.Opaque078;

class Opaque077 {
    int bK;

    Opaque077(Json_2 json_2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[1];
        this.bK = 454485339;
        byArray[0] = (byte)(this.bK >>> 19);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new Opaque078(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
