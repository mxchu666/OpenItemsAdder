package itemsadder.m;

import itemsadder.m.d;
import itemsadder.m.p;
import itemsadder.m.qm;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class o {
    @Nullable
    private final List bF;
    public final boolean bG;

    public o(@Nullable List list) {
        this.bF = list;
        boolean bl = false;
        for (p p2 : list) {
            String string = p2.pattern;
            if (!string.equalsIgnoreCase("hand") && !string.equalsIgnoreCase("empty") && !string.toLowerCase().contains("hand")) continue;
            bl = true;
            break;
        }
        this.bG = bl;
    }

    public boolean D(@Nullable String string) {
        if (this.bF == null || this.bF.isEmpty()) {
            return true;
        }
        if (string == null || string.isEmpty() || string.equalsIgnoreCase("air")) {
            return this.bG;
        }
        string = string.toLowerCase();
        Iterator iterator = this.bF.iterator();
        if (iterator.hasNext()) {
            p p2 = (p)iterator.next();
            if (!p2.X().contains(":") && string.contains(":")) {
                string = string.substring(string.indexOf(":") + 1);
            }
            return switch (p2.W().ordinal()) {
                default -> throw new MatchException(null, null);
                case 2 -> string.equals(p2.X());
                case 1 -> FilenameUtils.wildcardMatch((String)string, (String)p2.X());
                case 0 -> string.matches(p2.X());
            };
        }
        return false;
    }

    public boolean e(@Nullable Player player) {
        if (player == null) {
            return true;
        }
        if (this.bF == null || this.bF.isEmpty()) {
            return true;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType().isAir()) {
            return this.bG;
        }
        if (d.g().isCustomItem(itemStack)) {
            qm qm2 = d.g().a(itemStack);
            if (qm2 != null) {
                return this.D(qm2.getNamespacedID());
            }
            return false;
        }
        return this.D(itemStack.getType().toString().toLowerCase(Locale.ROOT));
    }
}
