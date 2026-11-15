package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.PluginFileConfigurationHolder;
import org.bukkit.plugin.Plugin;

public class SecretYml {
    public static String gc;

    static void an() {
        PluginFileConfigurationHolder pluginFileConfigurationHolder = new PluginFileConfigurationHolder((Plugin)Main.rS(), true, "secret.yml", true, true);
        gc = pluginFileConfigurationHolder.gV("lobfile.api_key");
    }
}
