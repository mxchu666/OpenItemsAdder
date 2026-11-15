package itemsadder.m;

import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.Error_3;
import itemsadder.m.PluginContractImpl_8;
import itemsadder.m.PluginFileConfigurationHolder;
import lombok.Generated;
import org.bukkit.Material;

public class AppendEquipmentLegacy
extends PluginContractImpl_8 {
    private String KM;
    private String KN;

    public AppendEquipmentLegacy(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, ConfigurationSectionBridge configurationSectionBridge) {
        super(pluginFileConfigurationHolder, string, configurationSectionBridge);
    }

    @Override
    public String pX() {
        return "append_equipment_to_legacy_armor";
    }

    @Override
    public boolean pY() {
        if (!this.KQ.gP("specific_properties.armor.custom_armor")) {
            return false;
        }
        this.KM = this.KQ.gV("specific_properties.armor.slot");
        if (this.KM == null) {
            throw new Error_3("Item '" + this.KP + "' has null slot", true);
        }
        this.KM = this.KM.toUpperCase();
        this.KN = this.KQ.gV("specific_properties.armor.custom_armor");
        if (this.KO.gP("equipments." + this.KN)) {
            throw new Error_3("Item '" + this.KP + "' equipment already exists", true);
        }
        if (!this.KO.gP("armors_rendering." + this.KN)) {
            throw new Error_3("Item '" + this.KP + "' armors_rendering not in same file", true);
        }
        if (!("HEAD".equals(this.KM) || "CHEST".equals(this.KM) || "LEGS".equals(this.KM) || "FEET".equals(this.KM))) {
            throw new Error_3("Item '" + this.KP + "' has unknown armor slot '" + this.KM + "'", false);
        }
        return true;
    }

    @Override
    public void pZ() {
        try {
            switch (this.KM) {
                case "HEAD": {
                    this.KQ.d("resource.material", (Object)Material.LEATHER_HELMET.toString());
                    break;
                }
                case "CHEST": {
                    this.KQ.d("resource.material", (Object)Material.LEATHER_CHESTPLATE.toString());
                    break;
                }
                case "LEGS": {
                    this.KQ.d("resource.material", (Object)Material.LEATHER_LEGGINGS.toString());
                    break;
                }
                case "FEET": {
                    this.KQ.d("resource.material", (Object)Material.LEATHER_BOOTS.toString());
                }
            }
            this.KO.d("equipments." + this.KN + ".layer_1", this.KO.gV("armors_rendering." + this.KN + ".layer_1"));
            this.KO.d("equipments." + this.KN + ".layer_2", this.KO.gV("armors_rendering." + this.KN + ".layer_2"));
            this.KQ.d("equipment.id", (Object)this.KN);
            this.KQ.d("equipment.legacy_armor_rendering_id", (Object)this.KN);
            this.KQ.d("equipment.slot", (Object)this.KM);
            if (this.KQ.gP("attribute_modifiers." + this.KM.toLowerCase() + ".armor")) {
                for (String string : this.KQ.gR("attribute_modifiers." + this.KM.toLowerCase())) {
                    this.KQ.d("equipment.slot_attribute_modifiers." + string, this.KQ.hm("attribute_modifiers." + this.KM.toLowerCase() + "." + string));
                }
            }
            if (this.KQ.gR("attribute_modifiers").size() <= 1) {
                this.KQ.d("attribute_modifiers", (Object)null);
            }
            this.KQ.d("specific_properties.armor", (Object)null);
            if (this.KQ.gR("specific_properties").size() <= 1) {
                this.KQ.d("specific_properties", (Object)null);
            }
        }
        catch (Exception exception) {
            throw new Error_3("Failed to apply append_equipment conversion for item '" + this.KP + "'", exception);
        }
    }

    @Override
    public String qa() {
        return "Append new equipment to legacy armor '" + this.KP + "'";
    }

    @Generated
    public String qb() {
        return this.KN;
    }
}
