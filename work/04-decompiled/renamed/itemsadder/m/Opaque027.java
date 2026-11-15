package itemsadder.m;

import itemsadder.m.InstalledIsNewerEnum;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Opaque027 {
    public static InstalledIsNewerEnum aH(String string, String string2) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(string);
        if (plugin == null) {
            return InstalledIsNewerEnum.UNKNOWN;
        }
        return Opaque027.aI(string2, plugin.getDescription().getVersion().split("-")[0].split("_")[0]);
    }

    public static InstalledIsNewerEnum aI(String string, String string2) {
        int n = Opaque027.aJ(string, string2);
        return switch (n) {
            case 1 -> InstalledIsNewerEnum.INSTALLED_IS_LOWER;
            case -1 -> InstalledIsNewerEnum.INSTALLED_IS_NEWER;
            case 0 -> InstalledIsNewerEnum.INSTALLED_IS_SAME;
            default -> InstalledIsNewerEnum.UNKNOWN;
        };
    }

    public static int aJ(String string, String string2) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; n3 < string.length() || i < string2.length(); ++n3, ++i) {
            while (n3 < string.length() && string.charAt(n3) != '.') {
                n = n * 10 + (string.charAt(n3) - 48);
                ++n3;
            }
            while (i < string2.length() && string2.charAt(i) != '.') {
                n2 = n2 * 10 + (string2.charAt(i) - 48);
                ++i;
            }
            if (n > n2) {
                return 1;
            }
            if (n2 > n) {
                return -1;
            }
            n2 = 0;
            n = 0;
        }
        return 0;
    }
}
