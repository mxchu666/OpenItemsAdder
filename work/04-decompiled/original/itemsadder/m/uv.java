package itemsadder.m;

import itemsadder.m.uw;
import itemsadder.m.uy;

public class uv {
    private final uw LV;
    private final String LW;
    private final String LX;

    public uv(uw uw2, String string, String string2) {
        this.LV = uw2;
        this.LW = string;
        this.LX = string2;
    }

    public void a(uy uy2) {
        uy2.a(this.LV, this.LW, this.LX);
    }

    public static void a(uy uy2, Iterable iterable) {
        for (uv uv2 : iterable) {
            uv2.a(uy2);
        }
    }
}
