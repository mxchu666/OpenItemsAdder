package itemsadder.m;

import itemsadder.m.Builder;
import itemsadder.m.PluginContractBuilder_2;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.HashMap;
import java.util.Map;

public final class InstanceRegistry
implements PluginContract_14 {
    private static final InstanceRegistry apF = new InstanceRegistry();
    private static final Map apG = new HashMap();

    public Builder we() {
        return Builder.vE();
    }

    @Override
    public Class wf() {
        return Builder.class;
    }

    @Override
    public String wg() {
        return Builder.class.getSimpleName();
    }

    @Override
    public String wh() {
        return Builder.class.getName();
    }

    @Deprecated
    public boolean a(Builder builder) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, Builder builder) {
        int n;
        block10: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    builder.apv = (PluginContractBuilder_2)pluginContract_11.a(builder.apv, PluginContractBuilder_2.aqc);
                    builder.apD |= 1;
                    continue block10;
                }
                case 2: {
                    builder.apw = pluginContract_11.Fw();
                    builder.apD |= 2;
                    continue block10;
                }
                case 3: {
                    builder.apx = pluginContract_11.Fz();
                    builder.apD |= 4;
                    continue block10;
                }
                case 4: {
                    builder.apy = pluginContract_11.Fw();
                    builder.apD |= 8;
                    continue block10;
                }
                case 5: {
                    builder.apz = pluginContract_11.FG();
                    builder.apD |= 0x10;
                    continue block10;
                }
                case 6: {
                    builder.apA = pluginContract_11.Fw();
                    builder.apD |= 0x20;
                    continue block10;
                }
                case 7: {
                    builder.apB = pluginContract_11.Fw();
                    builder.apD |= 0x40;
                    continue block10;
                }
                case 8: {
                    builder.apC = pluginContract_11.Fz();
                    builder.apD |= 0x80;
                    continue block10;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        builder.vD();
    }

    public void a(PluginContract_12 pluginContract_12, Builder builder) {
        if ((builder.apD & 1) == 1) {
            pluginContract_12.a(1, builder.apv, PluginContractBuilder_2.aqc, false);
        }
        if ((builder.apD & 2) == 2) {
            pluginContract_12.d(2, builder.apw, false);
        }
        if ((builder.apD & 4) == 4) {
            pluginContract_12.a(3, builder.apx, false);
        }
        if ((builder.apD & 8) == 8) {
            pluginContract_12.d(4, builder.apy, false);
        }
        if ((builder.apD & 0x10) == 16) {
            pluginContract_12.a(5, builder.apz, false);
        }
        if ((builder.apD & 0x20) == 32) {
            pluginContract_12.d(6, builder.apA, false);
        }
        if ((builder.apD & 0x40) == 64) {
            pluginContract_12.d(7, builder.apB, false);
        }
        if ((builder.apD & 0x80) == 128) {
            pluginContract_12.a(8, builder.apC, false);
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
        return this.a((Builder)object);
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
