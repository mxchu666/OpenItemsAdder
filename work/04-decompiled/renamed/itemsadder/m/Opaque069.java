package itemsadder.m;

import itemsadder.m.Json_2;
import itemsadder.m.Opaque070;

class Opaque069 {
    int bK;

    Opaque069(Json_2 json_2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[16];
        this.bK = 2081153767;
        byArray[0] = (byte)(this.bK >>> 4);
        this.bK = -1585393086;
        byArray[1] = (byte)(this.bK >>> 9);
        this.bK = 1637688185;
        byArray[2] = (byte)(this.bK >>> 14);
        this.bK = 1254768252;
        byArray[3] = (byte)(this.bK >>> 17);
        this.bK = 812505258;
        byArray[4] = (byte)(this.bK >>> 16);
        this.bK = 1301654988;
        byArray[5] = (byte)(this.bK >>> 2);
        this.bK = -1508026211;
        byArray[6] = (byte)(this.bK >>> 20);
        this.bK = -14492893;
        byArray[7] = (byte)(this.bK >>> 3);
        this.bK = -1607708984;
        byArray[8] = (byte)(this.bK >>> 1);
        this.bK = -707684914;
        byArray[9] = (byte)(this.bK >>> 10);
        this.bK = 1914225172;
        byArray[10] = (byte)(this.bK >>> 24);
        this.bK = 390071792;
        byArray[11] = (byte)(this.bK >>> 23);
        this.bK = -98137516;
        byArray[12] = (byte)(this.bK >>> 15);
        this.bK = -801012291;
        byArray[13] = (byte)(this.bK >>> 10);
        this.bK = 155405368;
        byArray[14] = (byte)(this.bK >>> 11);
        this.bK = 1847313984;
        byArray[15] = (byte)(this.bK >>> 24);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new Opaque070(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
