package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.to;
import itemsadder.m.tq;
import lombok.Generated;
import org.bukkit.Material;

public class tv
extends to {
    private String KM;
    private String KN;
    private Material bE;

    public tv(bbf bbf2, String string, bbg bbg2) {
        super(bbf2, string, bbg2);
    }

    @Override
    public String pX() {
        return "legacy_armor_complete";
    }

    @Override
    public boolean pY() {
        if (!this.KQ.gP("specific_properties.armor.custom_armor")) {
            return false;
        }
        this.KM = this.KQ.gV("specific_properties.armor.slot");
        if (this.KM == null) {
            throw new tq("Item '" + this.KP + "' has null slot", true);
        }
        this.KM = this.KM.toUpperCase();
        this.KN = this.KQ.gV("specific_properties.armor.custom_armor");
        if (this.KO.gP("equipments." + this.KN)) {
            throw new tq("Item '" + this.KP + "' equipment already exists", true);
        }
        if (!this.KO.gP("armors_rendering." + this.KN)) {
            throw new tq("Item '" + this.KP + "' armors_rendering not in same file", true);
        }
        switch (this.KM) {
            case "HEAD": {
                this.bE = (Material)bbi.b(ae.fN + "_HELMET", Material.class, null);
                break;
            }
            case "CHEST": {
                this.bE = (Material)bbi.b(ae.fN + "_CHESTPLATE", Material.class, null);
                break;
            }
            case "LEGS": {
                this.bE = (Material)bbi.b(ae.fN + "_LEGGINGS", Material.class, null);
                break;
            }
            case "FEET": {
                this.bE = (Material)bbi.b(ae.fN + "_BOOTS", Material.class, null);
                break;
            }
            default: {
                throw new tq("Item '" + this.KP + "' has unknown armor slot '" + this.KM + "'", false);
            }
        }
        if (this.bE == null) {
            throw new tq("Item '" + this.KP + "' could not determine material for slot '" + this.KM + "'", false);
        }
        return true;
    }

    @Override
    public void pZ() {
        try {
            this.KQ.d("resource.material", (Object)this.bE.toString());
            this.KO.d("equipments." + this.KN + ".layer_1", this.KO.gV("armors_rendering." + this.KN + ".layer_1"));
            this.KO.d("equipments." + this.KN + ".layer_2", this.KO.gV("armors_rendering." + this.KN + ".layer_2"));
            this.KQ.d("equipment.id", (Object)this.KN);
            this.KQ.d("equipment.slot", (Object)this.KM);
            if (this.KQ.gP("attribute_modifiers." + this.KM.toLowerCase() + ".armor")) {
                for (String string : this.KQ.gR("attribute_modifiers." + this.KM.toLowerCase())) {
                    this.KQ.d("equipment.slot_attribute_modifiers." + string, this.KQ.hm("attribute_modifiers." + this.KM.toLowerCase() + "." + string));
                }
            }
            if (this.KQ.gR("attribute_modifiers").size() == 1) {
                this.KQ.d("attribute_modifiers", (Object)null);
            }
            this.KQ.d("specific_properties.armor", (Object)null);
            if (this.KQ.gR("specific_properties").isEmpty()) {
                this.KQ.d("specific_properties", (Object)null);
            }
            this.KO.d("armors_rendering." + this.KN, null);
        }
        catch (Exception exception) {
            throw new tq("Failed to apply legacy_armor conversion for item '" + this.KP + "'", exception);
        }
    }

    @Override
    public String qa() {
        return "Convert legacy armor '" + this.KP + "' to new equipment format";
    }

    @Generated
    public String qb() {
        return this.KN;
    }
}
