package itemsadder.m;

import itemsadder.m.rr;
import itemsadder.m.rs;
import lombok.Generated;

@Generated
public class rt {
    @Generated
    private boolean IF;
    @Generated
    private rs IG;

    @Generated
    rt() {
    }

    @Generated
    public rt au(boolean bl) {
        this.IF = bl;
        return this;
    }

    @Generated
    public rt a(rs rs2) {
        this.IG = rs2;
        return this;
    }

    @Generated
    public rr oI() {
        return new rr(this.IF, this.IG);
    }

    @Generated
    public String toString() {
        return "ItemUpdateRules.ItemUpdateRulesBuilder(fixUnstackableItemsOnClick=" + this.IF + ", enchantmentMode=" + String.valueOf((Object)this.IG) + ")";
    }
}
