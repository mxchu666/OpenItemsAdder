package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhv;

class bhu {
    int bK;

    bhu(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[11];
        this.bK = 718810521;
        byArray[0] = (byte)(this.bK >>> 5);
        this.bK = 377704367;
        byArray[1] = (byte)(this.bK >>> 11);
        this.bK = 746362119;
        byArray[2] = (byte)(this.bK >>> 21);
        this.bK = -1984776749;
        byArray[3] = (byte)(this.bK >>> 15);
        this.bK = 818788468;
        byArray[4] = (byte)(this.bK >>> 10);
        this.bK = -680275718;
        byArray[5] = (byte)(this.bK >>> 16);
        this.bK = 1213816539;
        byArray[6] = (byte)(this.bK >>> 14);
        this.bK = 1254750696;
        byArray[7] = (byte)(this.bK >>> 17);
        this.bK = 2135738369;
        byArray[8] = (byte)(this.bK >>> 6);
        this.bK = 1932431452;
        byArray[9] = (byte)(this.bK >>> 13);
        this.bK = -688328350;
        byArray[10] = (byte)(this.bK >>> 20);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhv(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
