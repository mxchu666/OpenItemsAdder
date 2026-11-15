package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.RecordOfValue_21;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_21 {
    @Nullable
    private final List bF;
    public final boolean bG;

    public PlayerBridge_21(@Nullable List list) {
        this.bF = list;
        boolean bl = false;
        for (RecordOfValue_21 recordOfValue_21 : list) {
            String string = recordOfValue_21.pattern;
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
            RecordOfValue_21 recordOfValue_21 = (RecordOfValue_21)iterator.next();
            if (!recordOfValue_21.X().contains(":") && string.contains(":")) {
                string = string.substring(string.indexOf(":") + 1);
            }
            return switch (recordOfValue_21.W().ordinal()) {
                default -> throw new MatchException(null, null);
                case 2 -> string.equals(recordOfValue_21.X());
                case 1 -> FilenameUtils.wildcardMatch((String)string, (String)recordOfValue_21.X());
                case 0 -> string.matches(recordOfValue_21.X());
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
        if (ItemStackRegistry.g().isCustomItem(itemStack)) {
            ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
            if (itemStackBuilder_4 != null) {
                return this.D(itemStackBuilder_4.getNamespacedID());
            }
            return false;
        }
        return this.D(itemStack.getType().toString().toLowerCase(Locale.ROOT));
    }
}
