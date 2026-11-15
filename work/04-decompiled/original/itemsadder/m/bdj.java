package itemsadder.m;

import itemsadder.m.bbg;
import java.util.Map;
import org.bukkit.configuration.file.YamlConfiguration;

public class bdj {
    public static YamlConfiguration f(bbg bbg2) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        Map map = bbg2.aY(true);
        map.forEach((string, object) -> yamlConfiguration.set(string, object));
        String string2 = yamlConfiguration.saveToString();
        YamlConfiguration yamlConfiguration2 = new YamlConfiguration();
        yamlConfiguration2.loadFromString(string2);
        return yamlConfiguration2;
    }
}
