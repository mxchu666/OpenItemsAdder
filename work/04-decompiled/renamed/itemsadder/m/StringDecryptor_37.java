package itemsadder.m;

import itemsadder.m.ItemsAdderLoadDataEventHelper;

class StringDecryptor_37 {
    int bK;

    StringDecryptor_37(ItemsAdderLoadDataEventHelper itemsAdderLoadDataEventHelper) {
    }

    public String toString() {
        byte[] byArray = new byte[1];
        this.bK = -904355031;
        byArray[0] = (byte)(this.bK >>> 14);
        return new String(byArray);
    }
}
