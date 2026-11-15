package itemsadder.m;

import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.IntBoolData;
import itemsadder.m.PluginFileConfigurationHolder;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface Loader {
    @Nullable
    public IntBoolData load(String var1, EntityTypeBarStyleHolder var2, ConfigurationSectionBridge var3, String var4, PluginFileConfigurationHolder var5);
}
