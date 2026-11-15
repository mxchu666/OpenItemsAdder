package itemsadder.m;

import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.cx;
import java.util.HashMap;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public class cy {
    final HashMap lg = new HashMap();
    final HashMap lh = new HashMap();

    public void k(String string, String string2) {
        this.lh.put(string, cx.a(bbe.gK(string2)));
    }

    public void l(String string, String string2) {
        this.lg.put(string, cx.a(bbe.gK(string2)));
    }

    public Component ah(String string) {
        if (this.al(string)) {
            cx cx2 = this.ak(string);
            if (cx2 == null) {
                return bbe.gK(string);
            }
            return cx2.lf;
        }
        if (string.startsWith("{") && ((string = string.replace("\\\"", "\"")).startsWith("{\"") || string.startsWith("{'"))) {
            try {
                Component component = bbe.gE(string);
                if (component != null) {
                    return component;
                }
            }
            catch (Exception exception) {
                bce.warn("Failed to parse string as JSON component: " + string);
            }
        }
        return bbe.gK(string);
    }

    public String ai(String string) {
        if (this.al(string)) {
            cx cx2 = this.ak(string);
            if (cx2 == null) {
                return bbe.p(bbe.gK(string));
            }
            return cx2.le;
        }
        return bbe.p(bbe.gK(string));
    }

    public String aj(String string) {
        return this.e(string, false);
    }

    public String e(String string, boolean bl) {
        cx cx2;
        String string2 = this.al(string) ? ((cx2 = this.ak(string)) == null ? bcy.x(bbe.gK(string)) : cx2.cX()) : bcy.x(bbe.gK(string));
        if (!bl && string2.startsWith("\u00a7f")) {
            string2 = string2.substring(2);
        }
        return string2;
    }

    @Nullable
    cx ak(String string) {
        cx cx2 = (cx)this.lh.get(string);
        if (cx2 == null) {
            cx2 = (cx)this.lg.get(string);
        }
        return cx2;
    }

    public boolean al(String string) {
        return this.lh.containsKey(string) || this.lg.containsKey(string);
    }
}
