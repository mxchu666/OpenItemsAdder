package itemsadder.m;

import itemsadder.m.Opaque131;
import itemsadder.m.ReplaceEnum_2;
import lombok.Generated;

@Generated
public class Builder_15 {
    @Generated
    private boolean IF;
    @Generated
    private ReplaceEnum_2 IG;

    @Generated
    Builder_15() {
    }

    @Generated
    public Builder_15 au(boolean bl) {
        this.IF = bl;
        return this;
    }

    @Generated
    public Builder_15 a(ReplaceEnum_2 replaceEnum_2) {
        this.IG = replaceEnum_2;
        return this;
    }

    @Generated
    public Opaque131 oI() {
        return new Opaque131(this.IF, this.IG);
    }

    @Generated
    public String toString() {
        return "ItemUpdateRules.ItemUpdateRulesBuilder(fixUnstackableItemsOnClick=" + this.IF + ", enchantmentMode=" + String.valueOf((Object)this.IG) + ")";
    }
}
