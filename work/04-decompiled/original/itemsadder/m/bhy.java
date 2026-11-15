package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhz;

class bhy {
    int bK;

    bhy(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[2];
        this.bK = 776763722;
        byArray[0] = (byte)(this.bK >>> 14);
        this.bK = 1080802687;
        byArray[1] = (byte)(this.bK >>> 17);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhz(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
