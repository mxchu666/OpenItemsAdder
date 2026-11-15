package itemsadder.m;

import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.Error_3;
import itemsadder.m.PluginContractImpl_8;
import itemsadder.m.PluginFileConfigurationHolder;
import org.bukkit.entity.EntityType;

public class EntityTypeBridge_5
extends PluginContractImpl_8 {
    private EntityType nS;

    public EntityTypeBridge_5(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, ConfigurationSectionBridge configurationSectionBridge) {
        super(pluginFileConfigurationHolder, string, configurationSectionBridge);
    }

    @Override
    public String pX() {
        return "furniture_to_item_display";
    }

    @Override
    public boolean pY() {
        if (!this.KQ.gP("behaviours.furniture")) {
            return false;
        }
        this.nS = this.KQ.a("behaviours.furniture.entity", EntityType.ARMOR_STAND, null);
        if (this.nS == null) {
            throw new Error_3("Item '" + this.KP + "' has null entity type", true);
        }
        if ("item_display".equals(this.KQ.gV("behaviours.furniture.entity"))) {
            throw new Error_3("Item '" + this.KP + "' is already item_display", true);
        }
        return true;
    }

    @Override
    public void pZ() {
        try {
            boolean bl;
            this.KQ.d("behaviours.furniture.entity", (Object)"item_display");
            switch (this.nS) {
                case ITEM_FRAME: {
                    this.KQ.d("behaviours.furniture.display_transformation.adjust_legacy_model", (Object)"item_frame");
                    boolean bl2 = true;
                    break;
                }
                case ARMOR_STAND: {
                    if (this.KQ.C("behaviours.furniture.small", false)) {
                        this.KQ.d("behaviours.furniture.display_transformation.adjust_legacy_model", (Object)"small_armor_stand");
                        this.KQ.d("behaviours.furniture.small", (Object)null);
                    } else {
                        this.KQ.d("behaviours.furniture.display_transformation.adjust_legacy_model", (Object)"armor_stand");
                    }
                    boolean bl2 = true;
                    break;
                }
                default: {
                    boolean bl2 = bl = false;
                }
            }
            if (bl && this.KQ.gP("behaviours.furniture.hitbox.width_offset")) {
                this.KQ.d("behaviours.furniture.hitbox.width_offset", Float.valueOf(-this.KQ.gX("behaviours.furniture.hitbox.width_offset")));
            }
        }
        catch (Exception exception) {
            throw new Error_3("Failed to apply furniture_to_item_display conversion for item '" + this.KP + "'", exception);
        }
    }

    @Override
    public String qa() {
        return "Convert furniture entity to item_display for item '" + this.KP + "'";
    }
}
