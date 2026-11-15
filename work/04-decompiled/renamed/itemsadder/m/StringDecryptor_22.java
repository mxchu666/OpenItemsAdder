package itemsadder.m;

import itemsadder.m.PluginBridge_8;

class StringDecryptor_22 {
    int bK;

    StringDecryptor_22(PluginBridge_8 pluginBridge_8) {
    }

    public String toString() {
        byte[] byArray = new byte[1];
        this.bK = -699280593;
        byArray[0] = (byte)(this.bK >>> 3);
        return new String(byArray);
    }
}
