package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bif;

class bie {
    int bK;

    bie(bhb bhb2) {
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
            Class<?> clazz = Class.forName((String)new bif(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
