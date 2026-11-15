package itemsadder.m;

import itemsadder.m.AppendEquipmentLegacy;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityTypeBridge_5;
import itemsadder.m.Error_3;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_16;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.ResourceGraphics;
import itemsadder.m.ResourceGraphics_2;
import java.util.List;

public class Enabled {
    private final PluginFileConfigurationHolder KV;
    private final List KW;

    public Enabled(PluginFileConfigurationHolder pluginFileConfigurationHolder, List list) {
        this.KV = pluginFileConfigurationHolder;
        this.KW = list;
    }

    public ResourceGraphics qk() {
        ResourceGraphics resourceGraphics = new ResourceGraphics(this.KV);
        for (String string : this.KW) {
            ConfigurationSectionBridge configurationSectionBridge = this.KV.hj("items." + string);
            if (configurationSectionBridge == null || !configurationSectionBridge.C("enabled", true)) continue;
            this.a(resourceGraphics, string, configurationSectionBridge);
            this.b(resourceGraphics, string, configurationSectionBridge);
            this.c(resourceGraphics, string, configurationSectionBridge);
        }
        return resourceGraphics;
    }

    private void a(ResourceGraphics resourceGraphics, String string, ConfigurationSectionBridge configurationSectionBridge) {
        block4: {
            if (!MaterialBarColorHolder.fB) {
                return;
            }
            EntityTypeBridge_5 entityTypeBridge_5 = new EntityTypeBridge_5(this.KV, string, configurationSectionBridge);
            try {
                if (!entityTypeBridge_5.pY()) {
                    return;
                }
                resourceGraphics.a(entityTypeBridge_5);
            }
            catch (Error_3 error_3) {
                if (error_3.qe()) break block4;
                Error_3.a("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
            }
        }
    }

    private void b(ResourceGraphics resourceGraphics, String string, ConfigurationSectionBridge configurationSectionBridge) {
        if (!MaterialBarColorHolder.fO) {
            return;
        }
        ResourceGraphics_2 resourceGraphics_2 = new ResourceGraphics_2(this.KV, string, configurationSectionBridge);
        try {
            if (!resourceGraphics_2.pY()) {
                return;
            }
            resourceGraphics.a(resourceGraphics_2);
        }
        catch (Error_3 error_3) {
            if (error_3.qe()) {
                Error_3.b("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
            }
            Error_3.a("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
        }
    }

    private void c(ResourceGraphics resourceGraphics, String string, ConfigurationSectionBridge configurationSectionBridge) {
        block11: {
            if (MaterialBarColorHolder.fL) {
                AppendEquipmentLegacy appendEquipmentLegacy = new AppendEquipmentLegacy(this.KV, string, configurationSectionBridge);
                try {
                    if (!appendEquipmentLegacy.pY()) {
                        return;
                    }
                    resourceGraphics.a(appendEquipmentLegacy);
                }
                catch (Error_3 error_3) {
                    if (error_3.qe()) {
                        Error_3.b("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
                        break block11;
                    }
                    Error_3.a("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
                }
            } else if (MaterialBarColorHolder.fM) {
                MaterialBridge_16 materialBridge_16 = new MaterialBridge_16(this.KV, string, configurationSectionBridge);
                try {
                    if (!materialBridge_16.pY()) {
                        return;
                    }
                    resourceGraphics.a(materialBridge_16);
                }
                catch (Error_3 error_3) {
                    if (error_3.qe()) {
                        Error_3.b("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
                    }
                    Error_3.a("[Converter] " + error_3.getMessage() + " File: " + this.KV.nh(), error_3);
                }
            }
        }
    }
}
