package itemsadder.m;

import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.PluginContract_21;
import itemsadder.m.PluginFileConfigurationHolder;

public abstract class PluginContractImpl_8
implements PluginContract_21 {
    protected final PluginFileConfigurationHolder KO;
    protected final String KP;
    protected final ConfigurationSectionBridge KQ;

    public PluginContractImpl_8(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, ConfigurationSectionBridge configurationSectionBridge) {
        this.KO = pluginFileConfigurationHolder;
        this.KP = string;
        this.KQ = configurationSectionBridge;
    }

    @Override
    public String qc() {
        return this.KP;
    }

    protected String qd() {
        return this.KO.nh();
    }
}
