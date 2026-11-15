package itemsadder.m;

import itemsadder.m.RecordOfValue_15;
import itemsadder.m.ReplaceEnum;
import java.util.List;

public class ReplaceEnumBuilder {
    private ReplaceEnum mw;
    private List mx;

    public ReplaceEnumBuilder a(ReplaceEnum replaceEnum) {
        this.mw = replaceEnum;
        return this;
    }

    public ReplaceEnumBuilder g(List list) {
        this.mx = list;
        return this;
    }

    public ReplaceEnum dQ() {
        return this.mw;
    }

    public List dR() {
        return this.mx;
    }

    public RecordOfValue_15 dT() {
        return new RecordOfValue_15(this.mw, this.mx);
    }
}
