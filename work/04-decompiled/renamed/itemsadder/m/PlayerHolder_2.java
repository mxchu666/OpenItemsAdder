package itemsadder.m;

import itemsadder.m.ItemStackWrapper;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerHolder_4;
import java.util.Locale;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class PlayerHolder_2 {
    private final ItemStackWrapper acB = (ItemStackWrapper)NmsWrapperFactory.n(ItemStackWrapper.class);
    public static PlayerHolder_2 acC;

    PlayerHolder_2() {
    }

    private static PlayerHolder_2 tW() {
        if (acC == null) {
            acC = new PlayerHolder_2();
        }
        return acC;
    }

    public static ItemStackWrapper tX() {
        return PlayerHolder_2.tW().acB;
    }

    public static void b(Player player, ItemStack itemStack, int n) {
        PlayerHolder_2.a(player, itemStack, n, PlayerHolder_2.tX().bT(player));
    }

    public static void a(Player player, ItemStack itemStack, int n, int n2) {
        PlayerHolder_4.a(player, itemStack, n, n2);
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
