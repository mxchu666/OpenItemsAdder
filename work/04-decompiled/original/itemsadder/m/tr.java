package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.tp;
import itemsadder.m.tq;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

public class tr {
    private final bbf KT;
    private final List KU = new ArrayList();

    public tr(bbf bbf2) {
        this.KT = bbf2;
    }

    public void a(tp tp2) {
        this.KU.add(tp2);
    }

    public boolean isEmpty() {
        return this.KU.isEmpty();
    }

    public int size() {
        return this.KU.size();
    }

    public void qg() {
        for (tp tp2 : this.KU) {
            try {
                tp2.pZ();
                this.b(tp2);
            }
            catch (tq tq2) {
                throw new tq("Failed to apply conversion '" + tp2.pX() + "' for item '" + tp2.qc() + "': " + tq2.getMessage(), tq2);
            }
        }
        this.qh();
        this.qi();
    }

    private void b(tp tp2) {
        switch (tp2.pX()) {
            case "resource_to_graphics": {
                bce.iA("Converted 'resource' to 'graphics' for item '" + tp2.qc() + "'. File: " + this.KT.nh());
                break;
            }
            case "furniture_to_item_display": {
                bce.iA("Converted furniture to item_display for item '" + tp2.qc() + "'. File: " + this.KT.nh());
                break;
            }
            case "legacy_armor_complete": {
                bce.log(String.valueOf(ChatColor.AQUA) + "[Converter] Converted legacy armor '" + tp2.qc() + "' to new equipment format. File: " + this.KT.nh());
                break;
            }
            case "append_equipment_to_legacy_armor": {
                bce.log(String.valueOf(ChatColor.AQUA) + "[Converter] Append new equipment to legacy armor '" + tp2.qc() + "'. File: " + this.KT.nh());
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
            bce.error("[Converter] Error moving 'items' key to the end of the file. File: " + this.KT.nh(), exception);
        }
    }

    @Generated
    public bbf qj() {
        return this.KT;
    }
}
