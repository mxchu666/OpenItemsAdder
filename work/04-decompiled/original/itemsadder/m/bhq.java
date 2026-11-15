package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhr;

class bhq {
    int bK;

    bhq(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[21];
        this.bK = 953147903;
        byArray[0] = (byte)(this.bK >>> 14);
        this.bK = -726610005;
        byArray[1] = (byte)(this.bK >>> 15);
        this.bK = 984986013;
        byArray[2] = (byte)(this.bK >>> 7);
        this.bK = 1780195638;
        byArray[3] = (byte)(this.bK >>> 11);
        this.bK = -98907320;
        byArray[4] = (byte)(this.bK >>> 3);
        this.bK = -1061413899;
        byArray[5] = (byte)(this.bK >>> 6);
        this.bK = 1511754078;
        byArray[6] = (byte)(this.bK >>> 14);
        this.bK = 1034820398;
        byArray[7] = (byte)(this.bK >>> 24);
        this.bK = -77078718;
        byArray[8] = (byte)(this.bK >>> 16);
        this.bK = 213347120;
        byArray[9] = (byte)(this.bK >>> 21);
        this.bK = -1365420156;
        byArray[10] = (byte)(this.bK >>> 21);
        this.bK = 1665233830;
        byArray[11] = (byte)(this.bK >>> 16);
        this.bK = -1836722278;
        byArray[12] = (byte)(this.bK >>> 10);
        this.bK = 1946599088;
        byArray[13] = (byte)(this.bK >>> 24);
        this.bK = 1420308898;
        byArray[14] = (byte)(this.bK >>> 2);
        this.bK = -838933969;
        byArray[15] = (byte)(this.bK >>> 21);
        this.bK = -1625508016;
        byArray[16] = (byte)(this.bK >>> 14);
        this.bK = -1858703648;
        byArray[17] = (byte)(this.bK >>> 19);
        this.bK = 918801229;
        byArray[18] = (byte)(this.bK >>> 3);
        this.bK = 307440780;
        byArray[19] = (byte)(this.bK >>> 5);
        this.bK = -472147711;
        byArray[20] = (byte)(this.bK >>> 20);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhr(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
