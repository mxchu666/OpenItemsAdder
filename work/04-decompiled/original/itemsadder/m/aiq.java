package itemsadder.m;

import itemsadder.m.aab;
import itemsadder.m.aii;
import itemsadder.m.aqp;
import java.util.Locale;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class aiq {
    private final aii acB = (aii)aab.n(aii.class);
    public static aiq acC;

    aiq() {
    }

    private static aiq tW() {
        if (acC == null) {
            acC = new aiq();
        }
        return acC;
    }

    public static aii tX() {
        return aiq.tW().acB;
    }

    public static void b(Player player, ItemStack itemStack, int n) {
        aiq.a(player, itemStack, n, aiq.tX().bT(player));
    }

    public static void a(Player player, ItemStack itemStack, int n, int n2) {
        aqp.a(player, itemStack, n, n2);
    }

    public static Material dD(String string) {
        try {
            return Material.getMaterial((String)string.toUpperCase(Locale.ROOT));
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
