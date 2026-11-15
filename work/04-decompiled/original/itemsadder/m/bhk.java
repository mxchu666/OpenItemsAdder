package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhl;

class bhk {
    int bK;

    bhk(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[14];
        this.bK = 1906836120;
        byArray[0] = (byte)(this.bK >>> 3);
        this.bK = 1544779873;
        byArray[1] = (byte)(this.bK >>> 22);
        this.bK = -245648686;
        byArray[2] = (byte)(this.bK >>> 1);
        this.bK = -442074179;
        byArray[3] = (byte)(this.bK >>> 12);
        this.bK = -1394629013;
        byArray[4] = (byte)(this.bK >>> 17);
        this.bK = 370623684;
        byArray[5] = (byte)(this.bK >>> 12);
        this.bK = -89564219;
        byArray[6] = (byte)(this.bK >>> 19);
        this.bK = -2052474105;
        byArray[7] = (byte)(this.bK >>> 10);
        this.bK = 1827960951;
        byArray[8] = (byte)(this.bK >>> 24);
        this.bK = -425234542;
        byArray[9] = (byte)(this.bK >>> 8);
        this.bK = -1351447439;
        byArray[10] = (byte)(this.bK >>> 5);
        this.bK = -1766666895;
        byArray[11] = (byte)(this.bK >>> 20);
        this.bK = 1835380541;
        byArray[12] = (byte)(this.bK >>> 16);
        this.bK = -1826398346;
        byArray[13] = (byte)(this.bK >>> 19);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhl(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
