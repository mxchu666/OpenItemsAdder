package itemsadder.m;

import itemsadder.m.axy;
import itemsadder.m.ayi;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.HashMap;
import java.util.Map;

public final class axz
implements bko {
    private static final axz apF = new axz();
    private static final Map apG = new HashMap();

    public axy we() {
        return axy.vE();
    }

    @Override
    public Class wf() {
        return axy.class;
    }

    @Override
    public String wg() {
        return axy.class.getSimpleName();
    }

    @Override
    public String wh() {
        return axy.class.getName();
    }

    @Deprecated
    public boolean a(axy axy2) {
        return true;
    }

    public void a(bjm bjm2, axy axy2) {
        int n;
        block10: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    axy2.apv = (ayi)bjm2.a(axy2.apv, ayi.aqc);
                    axy2.apD |= 1;
                    continue block10;
                }
                case 2: {
                    axy2.apw = bjm2.Fw();
                    axy2.apD |= 2;
                    continue block10;
                }
                case 3: {
                    axy2.apx = bjm2.Fz();
                    axy2.apD |= 4;
                    continue block10;
                }
                case 4: {
                    axy2.apy = bjm2.Fw();
                    axy2.apD |= 8;
                    continue block10;
                }
                case 5: {
                    axy2.apz = bjm2.FG();
                    axy2.apD |= 0x10;
                    continue block10;
                }
                case 6: {
                    axy2.apA = bjm2.Fw();
                    axy2.apD |= 0x20;
                    continue block10;
                }
                case 7: {
                    axy2.apB = bjm2.Fw();
                    axy2.apD |= 0x40;
                    continue block10;
                }
                case 8: {
                    axy2.apC = bjm2.Fz();
                    axy2.apD |= 0x80;
                    continue block10;
                }
            }
            bjm2.a(n, (bko)this);
        }
        axy2.vD();
    }

    public void a(bjy bjy2, axy axy2) {
        if ((axy2.apD & 1) == 1) {
            bjy2.a(1, axy2.apv, ayi.aqc, false);
        }
        if ((axy2.apD & 2) == 2) {
            bjy2.d(2, axy2.apw, false);
        }
        if ((axy2.apD & 4) == 4) {
            bjy2.a(3, axy2.apx, false);
        }
        if ((axy2.apD & 8) == 8) {
            bjy2.d(4, axy2.apy, false);
        }
        if ((axy2.apD & 0x10) == 16) {
            bjy2.a(5, axy2.apz, false);
        }
        if ((axy2.apD & 0x20) == 32) {
            bjy2.d(6, axy2.apA, false);
        }
        if ((axy2.apD & 0x40) == 64) {
            bjy2.d(7, axy2.apB, false);
        }
        if ((axy2.apD & 0x80) == 128) {
            bjy2.a(8, axy2.apC, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "inventory";
            }
            case 2: {
                return "cropSeedId";
            }
            case 3: {
                return "isLiquid";
            }
            case 4: {
                return "realBiomeId";
            }
            case 5: {
                return "song";
            }
            case 6: {
                return "instrument";
            }
            case 7: {
                return "fireAge";
            }
            case 8: {
                return "isOtherPluginCustomBlock";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apG.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.we();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((axy)object);
    }

    static {
        apG.put("inventory", 1);
        apG.put("cropSeedId", 2);
        apG.put("isLiquid", 3);
        apG.put("realBiomeId", 4);
        apG.put("song", 5);
        apG.put("instrument", 6);
        apG.put("fireAge", 7);
        apG.put("isOtherPluginCustomBlock", 8);
    }
}
