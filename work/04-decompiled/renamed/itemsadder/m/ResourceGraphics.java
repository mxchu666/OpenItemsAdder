package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Error_3;
import itemsadder.m.PluginContract_21;
import itemsadder.m.PluginFileConfigurationHolder;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

public class ResourceGraphics {
    private final PluginFileConfigurationHolder KT;
    private final List KU = new ArrayList();

    public ResourceGraphics(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        this.KT = pluginFileConfigurationHolder;
    }

    public void a(PluginContract_21 pluginContract_21) {
        this.KU.add(pluginContract_21);
    }

    public boolean isEmpty() {
        return this.KU.isEmpty();
    }

    public int size() {
        return this.KU.size();
    }

    public void qg() {
        for (PluginContract_21 pluginContract_21 : this.KU) {
            try {
                pluginContract_21.pZ();
                this.b(pluginContract_21);
            }
            catch (Error_3 error_3) {
                throw new Error_3("Failed to apply conversion '" + pluginContract_21.pX() + "' for item '" + pluginContract_21.qc() + "': " + error_3.getMessage(), error_3);
            }
        }
        this.qh();
        this.qi();
    }

    private void b(PluginContract_21 pluginContract_21) {
        switch (pluginContract_21.pX()) {
            case "resource_to_graphics": {
                CommandSenderBridge_5.iA("Converted 'resource' to 'graphics' for item '" + pluginContract_21.qc() + "'. File: " + this.KT.nh());
                break;
            }
            case "furniture_to_item_display": {
                CommandSenderBridge_5.iA("Converted furniture to item_display for item '" + pluginContract_21.qc() + "'. File: " + this.KT.nh());
                break;
            }
            case "legacy_armor_complete": {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Converter] Converted legacy armor '" + pluginContract_21.qc() + "' to new equipment format. File: " + this.KT.nh());
                break;
            }
            case "append_equipment_to_legacy_armor": {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Converter] Append new equipment to legacy armor '" + pluginContract_21.qc() + "'. File: " + this.KT.nh());
            }
        }
    }

    private void qh() {
        if (this.KT.gP("equipments_tmp")) {
            this.KT.d("equipments", this.KT.hi("equipments_tmp"));
            this.KT.d("equipments_tmp", null);
        }
        if (this.KT.gP("armors_rendering") && this.KT.gR("armors_rendering").isEmpty()) {
            this.KT.d("armors_rendering", null);
        }
    }

    private void qi() {
        try {
            ConfigurationSection configurationSection;
            if (this.KT.gP("items") && (configurationSection = this.KT.hi("items")) != null) {
                this.KT.d("items", null);
                this.KT.d("items", configurationSection);
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("[Converter] Error moving 'items' key to the end of the file. File: " + this.KT.nh(), exception);
        }
    }

    @Generated
    public PluginFileConfigurationHolder qj() {
        return this.KT;
    }
}
