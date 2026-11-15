package itemsadder.m;

import itemsadder.m.Json_2;
import itemsadder.m.Opaque080;

class Opaque079 {
    int bK;

    Opaque079(Json_2 json_2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[31];
        this.bK = 1557482475;
        byArray[0] = (byte)(this.bK >>> 22);
        this.bK = 487017010;
        byArray[1] = (byte)(this.bK >>> 22);
        this.bK = 928765869;
        byArray[2] = (byte)(this.bK >>> 14);
        this.bK = -506907982;
        byArray[3] = (byte)(this.bK >>> 18);
        this.bK = 1637993511;
        byArray[4] = (byte)(this.bK >>> 24);
        this.bK = -1638478098;
        byArray[5] = (byte)(this.bK >>> 9);
        this.bK = 1509495598;
        byArray[6] = (byte)(this.bK >>> 3);
        this.bK = 1332949087;
        byArray[7] = (byte)(this.bK >>> 1);
        this.bK = -1868984491;
        byArray[8] = (byte)(this.bK >>> 10);
        this.bK = -623016430;
        byArray[9] = (byte)(this.bK >>> 10);
        this.bK = -708431361;
        byArray[10] = (byte)(this.bK >>> 7);
        this.bK = -1072889424;
        byArray[11] = (byte)(this.bK >>> 13);
        this.bK = -40573294;
        byArray[12] = (byte)(this.bK >>> 18);
        this.bK = -1210294529;
        byArray[13] = (byte)(this.bK >>> 9);
        this.bK = -1153776507;
        byArray[14] = (byte)(this.bK >>> 23);
        this.bK = 2093090935;
        byArray[15] = (byte)(this.bK >>> 17);
        this.bK = -1993939652;
        byArray[16] = (byte)(this.bK >>> 9);
        this.bK = -315129608;
        byArray[17] = (byte)(this.bK >>> 21);
        this.bK = 469553417;
        byArray[18] = (byte)(this.bK >>> 22);
        this.bK = -1670946838;
        byArray[19] = (byte)(this.bK >>> 12);
        this.bK = 778417894;
        byArray[20] = (byte)(this.bK >>> 1);
        this.bK = 964630438;
        byArray[21] = (byte)(this.bK >>> 19);
        this.bK = 2137446593;
        byArray[22] = (byte)(this.bK >>> 6);
        this.bK = 1984271892;
        byArray[23] = (byte)(this.bK >>> 4);
        this.bK = -1311181145;
        byArray[24] = (byte)(this.bK >>> 14);
        this.bK = 1260006292;
        byArray[25] = (byte)(this.bK >>> 14);
        this.bK = 515042021;
        byArray[26] = (byte)(this.bK >>> 15);
        this.bK = 331727905;
        byArray[27] = (byte)(this.bK >>> 13);
        this.bK = 367434683;
        byArray[28] = (byte)(this.bK >>> 6);
        this.bK = 1050193587;
        byArray[29] = (byte)(this.bK >>> 14);
        this.bK = -432582734;
        byArray[30] = (byte)(this.bK >>> 12);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new Opaque080(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
