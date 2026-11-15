package itemsadder.m;

import itemsadder.m.Opaque086;

class Opaque085 {
    int bK;

    Opaque085() {
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
            Class<?> clazz = Class.forName((String)new Opaque086(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
