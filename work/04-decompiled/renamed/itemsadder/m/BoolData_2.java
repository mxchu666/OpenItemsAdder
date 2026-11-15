package itemsadder.m;

import itemsadder.m.BoolDoubleData;
import itemsadder.m.PluginFileConfigurationHolder;
import org.bukkit.Material;

public class BoolData_2
extends BoolDoubleData {
    public final boolean Fq;
    public final boolean Fr;

    public BoolData_2(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, boolean bl, boolean bl2, double d, boolean bl3, boolean bl4) {
        super(pluginFileConfigurationHolder, string, string2, material, bl, bl2, d);
        this.Fq = bl3;
        this.Fr = bl4;
    }
}
