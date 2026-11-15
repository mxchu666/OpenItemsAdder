package itemsadder.m;

import itemsadder.m.Json_2;
import itemsadder.m.Opaque082;

class Opaque081 {
    int bK;

    Opaque081(Json_2 json_2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[4];
        this.bK = -1422510068;
        byArray[0] = (byte)(this.bK >>> 15);
        this.bK = 784021080;
        byArray[1] = (byte)(this.bK >>> 4);
        this.bK = 1368965851;
        byArray[2] = (byte)(this.bK >>> 9);
        this.bK = 1768544990;
        byArray[3] = (byte)(this.bK >>> 6);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new Opaque082(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
