package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bdq;
import java.util.LinkedHashMap;
import org.bukkit.ChatColor;

public class f {
    LinkedHashMap bn = new LinkedHashMap();
    bdq bo;

    public void d(String string, boolean bl) {
        if (bl && this.bn.size() > 0) {
            this.K();
        }
        this.bo = new bdq();
        this.bn.put(string, this.bo);
    }

    public void K() {
        this.bo.save();
    }

    public void A(String string) {
        this.d(string, true);
    }

    public void B(String string) {
        bdq bdq2 = (bdq)this.bn.get(string);
        bdq2.save();
    }

    public bdq C(String string) {
        return (bdq)this.bn.get(string);
    }

    public void L() {
        if (ae.cl) {
            new LinkedHashMap<String, bdq>(this.bn).forEach((string, bdq2) -> {
                long l = bdq2.DM();
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
                bce.log(string + " took " + string2 + l + "ms");
            });
        }
    }

    public void clear() {
        this.bn.clear();
    }
}
