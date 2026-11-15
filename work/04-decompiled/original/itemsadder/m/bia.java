package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bib;

class bia {
    int bK;

    bia(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[1];
        this.bK = 454485339;
        byArray[0] = (byte)(this.bK >>> 19);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bib(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
