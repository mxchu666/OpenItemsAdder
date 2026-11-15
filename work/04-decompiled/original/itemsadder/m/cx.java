package itemsadder.m;

import itemsadder.m.bbe;
import itemsadder.m.bcy;
import net.kyori.adventure.text.Component;

public class cx {
    public final String le;
    public final Component lf;

    public cx(Component component) {
        this.lf = component;
        this.le = bbe.p(component);
    }

    public static cx a(Component component) {
        return new cx(component);
    }

    public String cX() {
        return bcy.x(this.lf);
    }
}
