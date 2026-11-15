package itemsadder.m;

import net.kyori.adventure.text.Component;

public class ComponentBoolData {
    public final Component component;
    public final boolean GZ;

    public ComponentBoolData(Component component, boolean bl) {
        this.component = component;
        this.GZ = bl;
    }

    public ComponentBoolData(Component component) {
        this.component = component;
        this.GZ = true;
    }
}
