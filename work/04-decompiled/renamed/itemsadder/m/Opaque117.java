package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque028;
import java.util.LinkedHashMap;
import org.bukkit.ChatColor;

public class Opaque117 {
    LinkedHashMap bn = new LinkedHashMap();
    Opaque028 bo;

    public void d(String string, boolean bl) {
        if (bl && this.bn.size() > 0) {
            this.K();
        }
        this.bo = new Opaque028();
        this.bn.put(string, this.bo);
    }

    public void K() {
        this.bo.save();
    }

    public void A(String string) {
        this.d(string, true);
    }

    public void B(String string) {
        Opaque028 opaque028 = (Opaque028)this.bn.get(string);
        opaque028.save();
    }

    public Opaque028 C(String string) {
        return (Opaque028)this.bn.get(string);
    }

    public void L() {
        if (MaterialBarColorHolder.cl) {
            new LinkedHashMap<String, Opaque028>(this.bn).forEach((string, opaque028) -> {
                long l = opaque028.DM();
                String string2 = "";
                if (l > 100L) {
                    string2 = ChatColor.GOLD.toString();
                }
                if (l > 150L) {
                    string2 = ChatColor.YELLOW.toString();
                }
                if (l > 200L) {
                    string2 = ChatColor.DARK_RED.toString();
                }
                if (l > 250L) {
                    string2 = ChatColor.RED.toString();
                }
                CommandSenderBridge_5.log(string + " took " + string2 + l + "ms");
            });
        }
    }

    public void clear() {
        this.bn.clear();
    }
}
