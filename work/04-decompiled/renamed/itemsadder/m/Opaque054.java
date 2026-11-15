package itemsadder.m;

import itemsadder.m.Opaque055;

class Opaque054 {
    int bK;

    Opaque054() {
    }

    public Object EQ() {
        byte[] byArray = new byte[2];
        this.bK = 1629629486;
        byArray[0] = (byte)(this.bK >>> 24);
        this.bK = 120462621;
        byArray[1] = (byte)(this.bK >>> 6);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new Opaque055(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
