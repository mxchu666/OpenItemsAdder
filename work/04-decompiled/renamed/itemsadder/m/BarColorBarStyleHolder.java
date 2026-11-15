package itemsadder.m;

import itemsadder.m.HiddenEnum;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.Nullable;

public class BarColorBarStyleHolder {
    public final HiddenEnum Ic;
    @Nullable
    public final String Id;
    @Nullable
    public final Float Ie;
    private BarColor If;
    private BarStyle Ig;

    public BarColorBarStyleHolder(HiddenEnum hiddenEnum, @Nullable String string, @Nullable Float f) {
        this.Ic = hiddenEnum;
        this.Id = string;
        this.Ie = f;
    }

    public BarColorBarStyleHolder(HiddenEnum hiddenEnum) {
        this(hiddenEnum, (String)null, (Float)null);
    }

    public BarColorBarStyleHolder(HiddenEnum hiddenEnum, BarColor barColor, BarStyle barStyle) {
        this.Ic = hiddenEnum;
        this.If = barColor;
        this.Ig = barStyle;
        this.Id = null;
        this.Ie = null;
    }

    public BarColor ob() {
        return this.If;
    }

    public BarStyle oc() {
        return this.Ig;
    }
}
