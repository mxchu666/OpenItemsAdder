package itemsadder.m;

import itemsadder.m.bcy;
import itemsadder.m.bfr;
import java.awt.Color;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class bha
implements Listener {
    final Plugin aDI;

    public bha(Plugin plugin) {
        this.aDI = plugin;
    }

    @EventHandler
    private void b(PluginEnableEvent pluginEnableEvent) {
        if (pluginEnableEvent.getPlugin().getName().equals(this.aDI.getName())) {
            Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(this.aDI, () -> Bukkit.getServer().getScheduler().runTaskAsynchronously(this.aDI, () -> new bfr(this.aDI).a()), (long)(1200 * bcy.v(60, 120)));
        }
    }

    public static void aB(ItemStack itemStack) {
        for (Enchantment enchantment : itemStack.getEnchantments().keySet()) {
            itemStack.removeEnchantment(enchantment);
        }
    }

    public static String jl(String string) {
        return string.replace("-", " ");
    }

    public static float jm(String string) {
        if (string.contains("-")) {
            String[] stringArray = string.split("-");
            return bha.a(bha.f(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1])), 2);
        }
        return Integer.parseInt(string);
    }

    public static int jn(String string) {
        if (string.contains("-")) {
            String[] stringArray = string.split("-");
            return bha.v(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
        }
        return Integer.parseInt(string);
    }

    public static float a(float f, int n) {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(n, 4);
        return bigDecimal.floatValue();
    }

    public static float f(float f, float f2) {
        Random random = new Random();
        float f3 = random.nextFloat() * (f2 - f) + f;
        return random.nextFloat() * (f2 - f) + f;
    }

    public static int v(int n, int n2) {
        Random random = new Random();
        return random.nextInt(n2 - n + 1) + n;
    }

    public static boolean bO(int n) {
        int n2 = bha.v(1, 100);
        return n2 <= n;
    }

    public static boolean j(Player player, String string) {
        if (player.hasPermission(string)) {
            return true;
        }
        return player.isOp();
    }

    public static String iH(String string) {
        return string.replace("\u00a7", "&");
    }

    public static String gH(String string) {
        return string.replace("&", "\u00a7");
    }

    public static boolean iJ(String string) {
        return string.matches("\\d+");
    }

    public static int[] jo(String string) {
        int[] nArray = new int[3];
        for (int i = 0; i < 3; ++i) {
            nArray[i] = Integer.parseInt(string.substring(i * 2, i * 2 + 2), 16);
        }
        return nArray;
    }

    public static int jp(String string) {
        try {
            return Integer.parseInt(new StringBuffer(string).reverse().toString(), 16);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    private static Color iK(String string) {
        return new Color(Integer.valueOf(string.substring(1, 3), 16), Integer.valueOf(string.substring(3, 5), 16), Integer.valueOf(string.substring(5, 7), 16));
    }

    public static org.bukkit.Color jq(String object) {
        Serializable serializable;
        if (((String)object).endsWith(".0")) {
            serializable = new StringBuilder(((String)object).replace(".0", ""));
            while (((StringBuilder)serializable).length() < 7) {
                ((StringBuilder)serializable).insert(0, "0");
            }
            object = ((StringBuilder)serializable).toString();
        }
        if (!((String)object).startsWith("#")) {
            object = "#" + (String)object;
        }
        serializable = bha.iK((String)object);
        return org.bukkit.Color.fromRGB((int)((Color)serializable).getRed(), (int)((Color)serializable).getGreen(), (int)((Color)serializable).getBlue());
    }

    public static int g(float f, float f2) {
        return (int)Math.ceil(f / f2);
    }

    public static ItemStack i(ItemStack itemStack, String string) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(string);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
