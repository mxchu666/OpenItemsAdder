package itemsadder.m;

import itemsadder.m.PluginContract_20;

public class PluginContractImpl_7
implements PluginContract_20 {
    private final int Hm;
    private final String Hn;
    private final String Ho;
    private final String Hp;

    public PluginContractImpl_7(int n, String string, String string2, String string3) {
        this.Hm = n;
        this.Hn = string;
        this.Ho = string2;
        this.Hp = string3;
    }

    @Override
    public boolean fW() {
        return true;
    }

    @Override
    public int fX() {
        return this.Hm;
    }

    @Override
    public boolean fZ() {
        return false;
    }

    @Override
    public String d(boolean bl, boolean bl2) {
        return this.Hn;
    }

    @Override
    public String ga() {
        return this.Hn;
    }

    @Override
    public String getNamespace() {
        return this.Ho;
    }

    @Override
    public String getId() {
        return this.Hp;
    }

    @Override
    public String getNamespacedID() {
        return this.Ho + ":" + this.Hp;
    }
}
