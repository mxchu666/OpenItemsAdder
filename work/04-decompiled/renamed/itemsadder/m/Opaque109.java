package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Opaque108;
import itemsadder.m.PluginBridge_6;
import java.util.HashMap;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public class Opaque109 {
    final HashMap lg = new HashMap();
    final HashMap lh = new HashMap();

    public void k(String string, String string2) {
        this.lh.put(string, Opaque108.a(PluginBridge_6.gK(string2)));
    }

    public void l(String string, String string2) {
        this.lg.put(string, Opaque108.a(PluginBridge_6.gK(string2)));
    }

    public Component ah(String string) {
        if (this.al(string)) {
            Opaque108 opaque108 = this.ak(string);
            if (opaque108 == null) {
                return PluginBridge_6.gK(string);
            }
            return opaque108.lf;
        }
        if (string.startsWith("{") && ((string = string.replace("\\\"", "\"")).startsWith("{\"") || string.startsWith("{'"))) {
            try {
                Component component = PluginBridge_6.gE(string);
                if (component != null) {
                    return component;
                }
            }
            catch (Exception exception) {
                CommandSenderBridge_5.warn("Failed to parse string as JSON component: " + string);
            }
        }
        return PluginBridge_6.gK(string);
    }

    public String ai(String string) {
        if (this.al(string)) {
            Opaque108 opaque108 = this.ak(string);
            if (opaque108 == null) {
                return PluginBridge_6.p(PluginBridge_6.gK(string));
            }
            return opaque108.le;
        }
        return PluginBridge_6.p(PluginBridge_6.gK(string));
    }

    public String aj(String string) {
        return this.e(string, false);
    }

    public String e(String string, boolean bl) {
        Opaque108 opaque108;
        String string2 = this.al(string) ? ((opaque108 = this.ak(string)) == null ? ColorBridge.x(PluginBridge_6.gK(string)) : opaque108.cX()) : ColorBridge.x(PluginBridge_6.gK(string));
        if (!bl && string2.startsWith("\u00a7f")) {
            string2 = string2.substring(2);
        }
        return string2;
    }

    @Nullable
    Opaque108 ak(String string) {
        Opaque108 opaque108 = (Opaque108)this.lh.get(string);
        if (opaque108 == null) {
            opaque108 = (Opaque108)this.lg.get(string);
        }
        return opaque108;
    }

    public boolean al(String string) {
        return this.lh.containsKey(string) || this.lg.containsKey(string);
    }
}
