package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import org.bukkit.plugin.Plugin;

public class ah {
    public static String gc;

    static void an() {
        bbf bbf2 = new bbf((Plugin)Main.rS(), true, "secret.yml", true, true);
        gc = bbf2.gV("lobfile.api_key");
    }
}
