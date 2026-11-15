package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhp;

class bho {
    int bK;

    bho(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[11];
        this.bK = -1429607334;
        byArray[0] = (byte)(this.bK >>> 17);
        this.bK = -1259869261;
        byArray[1] = (byte)(this.bK >>> 23);
        this.bK = -1941493488;
        byArray[2] = (byte)(this.bK >>> 12);
        this.bK = 1124281151;
        byArray[3] = (byte)(this.bK >>> 11);
        this.bK = 895737314;
        byArray[4] = (byte)(this.bK >>> 16);
        this.bK = 1562588066;
        byArray[5] = (byte)(this.bK >>> 22);
        this.bK = 385573468;
        byArray[6] = (byte)(this.bK >>> 11);
        this.bK = 706844609;
        byArray[7] = (byte)(this.bK >>> 10);
        this.bK = -1290244354;
        byArray[8] = (byte)(this.bK >>> 14);
        this.bK = 1808012385;
        byArray[9] = (byte)(this.bK >>> 24);
        this.bK = 1977037342;
        byArray[10] = (byte)(this.bK >>> 12);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhp(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
