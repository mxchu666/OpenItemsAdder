package itemsadder.m;

import itemsadder.m.bfr;

class bfu {
    int bK;

    bfu(bfr bfr2) {
    }

    public String toString() {
        byte[] byArray = new byte[11];
        this.bK = 529960059;
        byArray[0] = (byte)(this.bK >>> 12);
        this.bK = 1179889890;
        byArray[1] = (byte)(this.bK >>> 7);
        this.bK = 1414766029;
        byArray[2] = (byte)(this.bK >>> 2);
        this.bK = -1643527516;
        byArray[3] = (byte)(this.bK >>> 13);
        this.bK = -249988104;
        byArray[4] = (byte)(this.bK >>> 14);
        this.bK = 1162807556;
        byArray[5] = (byte)(this.bK >>> 13);
        this.bK = -990833755;
        byArray[6] = (byte)(this.bK >>> 3);
        this.bK = 1225992801;
        byArray[7] = (byte)(this.bK >>> 14);
        this.bK = 1291212441;
        byArray[8] = (byte)(this.bK >>> 4);
        this.bK = 1188695260;
        byArray[9] = (byte)(this.bK >>> 1);
        this.bK = -646224514;
        byArray[10] = (byte)(this.bK >>> 8);
        return new String(byArray);
    }
}
