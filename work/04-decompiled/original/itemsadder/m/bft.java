package itemsadder.m;

import itemsadder.m.bfr;

class bft {
    int bK;

    bft(bfr bfr2) {
    }

    public String toString() {
        byte[] byArray = new byte[10];
        this.bK = 853428666;
        byArray[0] = (byte)(this.bK >>> 17);
        this.bK = -644075565;
        byArray[1] = (byte)(this.bK >>> 14);
        this.bK = 1823197287;
        byArray[2] = (byte)(this.bK >>> 21);
        this.bK = -801989751;
        byArray[3] = (byte)(this.bK >>> 6);
        this.bK = -1257596572;
        byArray[4] = (byte)(this.bK >>> 11);
        this.bK = -858306757;
        byArray[5] = (byte)(this.bK >>> 12);
        this.bK = 661826728;
        byArray[6] = (byte)(this.bK >>> 16);
        this.bK = 811984613;
        byArray[7] = (byte)(this.bK >>> 16);
        this.bK = 2137481526;
        byArray[8] = (byte)(this.bK >>> 8);
        this.bK = 1130994079;
        byArray[9] = (byte)(this.bK >>> 19);
        return new String(byArray);
    }
}
