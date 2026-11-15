package itemsadder.m;

import itemsadder.m.bhb;
import itemsadder.m.bhx;

class bhw {
    int bK;

    bhw(bhb bhb2) {
    }

    public Object EQ() {
        byte[] byArray = new byte[1];
        this.bK = 639169990;
        byArray[0] = (byte)(this.bK >>> 20);
        return this.m(byArray);
    }

    Object m(byte[] byArray) {
        try {
            Class<?> clazz = Class.forName((String)new bhx(this).EQ());
            return clazz.getConstructor(byte[].class).newInstance(new Object[]{byArray});
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
