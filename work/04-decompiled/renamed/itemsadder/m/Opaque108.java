package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.PluginBridge_6;
import net.kyori.adventure.text.Component;

public class Opaque108 {
    public final String le;
    public final Component lf;

    public Opaque108(Component component) {
        this.lf = component;
        this.le = PluginBridge_6.p(component);
    }

    public static Opaque108 a(Component component) {
        return new Opaque108(component);
    }

    public String cX() {
        return ColorBridge.x(this.lf);
    }
}
