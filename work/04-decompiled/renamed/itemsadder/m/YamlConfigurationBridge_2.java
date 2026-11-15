package itemsadder.m;

import itemsadder.m.ConfigurationSectionBridge;
import java.util.Map;
import org.bukkit.configuration.file.YamlConfiguration;

public class YamlConfigurationBridge_2 {
    public static YamlConfiguration f(ConfigurationSectionBridge configurationSectionBridge) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        Map map = configurationSectionBridge.aY(true);
        map.forEach((string, object) -> yamlConfiguration.set(string, object));
        String string2 = yamlConfiguration.saveToString();
        YamlConfiguration yamlConfiguration2 = new YamlConfiguration();
        yamlConfiguration2.loadFromString(string2);
        return yamlConfiguration2;
    }
}
