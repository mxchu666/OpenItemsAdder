package itemsadder.m;

import itemsadder.m.bgp;

class bgo {
    int bK;

    bgo() {
    }

    public Object EQ() {
        byte[] byArray = new byte[6];
        this.bK = -631495494;
        byArray[0] = (byte)(this.bK >>> 2);
        this.bK = -2087568612;
        byArray[1] = (byte)(this.bK >>> 3);
        this.bK = 906564197;
        byArray[2] = (byte)(this.bK >>> 23);
        this.bK = 1971767795;
        byArray[3] = (byte)(this.bK >>> 18);
        this.bK = -946947601;
        byArray[4] = (byte)(this.bK >>> 7);
        this.bK = 463140254;
        byArray[5] = (byte)(this.bK >>> 19);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bgp(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
