package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhn;

class bhm {
    int bK;

    bhm(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[27];
        this.bK = 97298183;
        byArray[0] = (byte)(this.bK >>> 21);
        this.bK = -1142863173;
        byArray[1] = (byte)(this.bK >>> 6);
        this.bK = 170703952;
        byArray[2] = (byte)(this.bK >>> 1);
        this.bK = 344097945;
        byArray[3] = (byte)(this.bK >>> 12);
        this.bK = -951871294;
        byArray[4] = (byte)(this.bK >>> 6);
        this.bK = -2129474102;
        byArray[5] = (byte)(this.bK >>> 2);
        this.bK = 538462535;
        byArray[6] = (byte)(this.bK >>> 14);
        this.bK = 1178465500;
        byArray[7] = (byte)(this.bK >>> 20);
        this.bK = -1695754583;
        byArray[8] = (byte)(this.bK >>> 22);
        this.bK = 1694584367;
        byArray[9] = (byte)(this.bK >>> 11);
        this.bK = -605983156;
        byArray[10] = (byte)(this.bK >>> 19);
        this.bK = -2069728810;
        byArray[11] = (byte)(this.bK >>> 18);
        this.bK = 1438178755;
        byArray[12] = (byte)(this.bK >>> 9);
        this.bK = 1956762926;
        byArray[13] = (byte)(this.bK >>> 10);
        this.bK = 1819768309;
        byArray[14] = (byte)(this.bK >>> 24);
        this.bK = 596488398;
        byArray[15] = (byte)(this.bK >>> 10);
        this.bK = -901545651;
        byArray[16] = (byte)(this.bK >>> 3);
        this.bK = 993943568;
        byArray[17] = (byte)(this.bK >>> 15);
        this.bK = -905195438;
        byArray[18] = (byte)(this.bK >>> 22);
        this.bK = -1923691312;
        byArray[19] = (byte)(this.bK >>> 12);
        this.bK = 1915956263;
        byArray[20] = (byte)(this.bK >>> 11);
        this.bK = -665871501;
        byArray[21] = (byte)(this.bK >>> 22);
        this.bK = -1374103788;
        byArray[22] = (byte)(this.bK >>> 9);
        this.bK = 110402347;
        byArray[23] = (byte)(this.bK >>> 15);
        this.bK = -1973860186;
        byArray[24] = (byte)(this.bK >>> 2);
        this.bK = -1150957960;
        byArray[25] = (byte)(this.bK >>> 13);
        this.bK = 1298344466;
        byArray[26] = (byte)(this.bK >>> 8);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhn(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
