package itemsadder.m;

import itemsadder.m.rl;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.Nullable;

public class rj {
    public final rl Ic;
    @Nullable
    public final String Id;
    @Nullable
    public final Float Ie;
    private BarColor If;
    private BarStyle Ig;

    public rj(rl rl2, @Nullable String string, @Nullable Float f) {
        this.Ic = rl2;
        this.Id = string;
        this.Ie = f;
    }

    public rj(rl rl2) {
        this(rl2, (String)null, (Float)null);
    }

    public rj(rl rl2, BarColor barColor, BarStyle barStyle) {
        this.Ic = rl2;
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
