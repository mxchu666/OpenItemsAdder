package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bih;

class big {
    int bK;

    big(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[10];
        this.bK = 226822810;
        byArray[0] = (byte)(this.bK >>> 1);
        this.bK = -2010282492;
        byArray[1] = (byte)(this.bK >>> 10);
        this.bK = -630336681;
        byArray[2] = (byte)(this.bK >>> 22);
        this.bK = -1569825295;
        byArray[3] = (byte)(this.bK >>> 16);
        this.bK = 1797112550;
        byArray[4] = (byte)(this.bK >>> 4);
        this.bK = -1874671630;
        byArray[5] = (byte)(this.bK >>> 9);
        this.bK = 711749029;
        byArray[6] = (byte)(this.bK >>> 16);
        this.bK = 211706342;
        byArray[7] = (byte)(this.bK >>> 8);
        this.bK = 1779525071;
        byArray[8] = (byte)(this.bK >>> 2);
        this.bK = 1805346218;
        byArray[9] = (byte)(this.bK >>> 19);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bih(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
