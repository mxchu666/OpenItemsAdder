package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginFileConfigurationHolder;
import org.bukkit.Material;

public class BoolDoubleData
extends ItemStackBuilder_4 {
    public final boolean Fn;
    public final boolean Fo;
    public final double Fp;

    public BoolDoubleData(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, boolean bl, boolean bl2, double d) {
        super(pluginFileConfigurationHolder, string, string2, material);
        this.Fn = bl;
        this.Fo = bl2;
        this.Fp = d;
    }
}
