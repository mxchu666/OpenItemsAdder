package itemsadder.m;

import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;

public final class RuntimeError_3
extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    public final Object aGd;
    public final PluginContract_14 aGe;

    public RuntimeError_3(WdFunction wdFunction) {
        this(wdFunction, wdFunction.wd());
    }

    public RuntimeError_3(Object object, PluginContract_14 pluginContract_14) {
        this.aGd = object;
        this.aGe = pluginContract_14;
    }

    public RuntimeError_3(String string, WdFunction wdFunction) {
        this(string, wdFunction, wdFunction.wd());
    }

    public RuntimeError_3(String string, Object object, PluginContract_14 pluginContract_14) {
        super(string);
        this.aGd = object;
        this.aGe = pluginContract_14;
    }

    public Object Gx() {
        return this.aGd;
    }

    public PluginContract_14 Gy() {
        return this.aGe;
    }
}
