package itemsadder.m;

import itemsadder.m.bfr;

class bgu {
    int bK;

    bgu(bfr bfr2) {
    }

    public String toString() {
        byte[] byArray = new byte[12];
        this.bK = 916565878;
        byArray[0] = (byte)(this.bK >>> 20);
        this.bK = -1613203304;
        byArray[1] = (byte)(this.bK >>> 14);
        this.bK = 1974381805;
        byArray[2] = (byte)(this.bK >>> 1);
        this.bK = 290887875;
        byArray[3] = (byte)(this.bK >>> 1);
        this.bK = 1656272918;
        byArray[4] = (byte)(this.bK >>> 10);
        this.bK = -1577054770;
        byArray[5] = (byte)(this.bK >>> 5);
        this.bK = -149812534;
        byArray[6] = (byte)(this.bK >>> 1);
        this.bK = -1495647710;
        byArray[7] = (byte)(this.bK >>> 7);
        this.bK = 1394035599;
        byArray[8] = (byte)(this.bK >>> 6);
        this.bK = 441804016;
        byArray[9] = (byte)(this.bK >>> 16);
        this.bK = 1581075191;
        byArray[10] = (byte)(this.bK >>> 10);
        this.bK = 2089308968;
        byArray[11] = (byte)(this.bK >>> 6);
        return new String(byArray);
    }
}
