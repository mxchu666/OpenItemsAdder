package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhd;

class bhc {
    int bK;

    bhc(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[8];
        this.bK = 1949080691;
        byArray[0] = (byte)(this.bK >>> 13);
        this.bK = -228009170;
        byArray[1] = (byte)(this.bK >>> 3);
        this.bK = 1738357682;
        byArray[2] = (byte)(this.bK >>> 3);
        this.bK = 572045920;
        byArray[3] = (byte)(this.bK >>> 10);
        this.bK = -716829853;
        byArray[4] = (byte)(this.bK >>> 3);
        this.bK = 1431174683;
        byArray[5] = (byte)(this.bK >>> 13);
        this.bK = 1909832547;
        byArray[6] = (byte)(this.bK >>> 10);
        this.bK = -106116461;
        byArray[7] = (byte)(this.bK >>> 9);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhd(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
