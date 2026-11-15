package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.azg;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.qj;
import itemsadder.m.qm;
import itemsadder.m.qt;
import itemsadder.m.rd;
import itemsadder.m.ta;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class sz {
    public static boolean c(bbg bbg2) {
        return bbg2.fo("specific_properties.armor") || bbg2.fo("equipment.legacy_armor_rendering_id");
    }

    @Nullable
    public static ta a(Material material, bbg bbg2, bbf bbf2, String string, String string2) {
        String string3;
        if (material != null && !bbs.ae(material)) {
            bce.warn("[Items] '" + string + ":" + string2 + "'. Warning: Trying to create a custom legacy armor using an incompatible material. '" + String.valueOf(material) + "' is not a leather armor material. File: " + bbf2.nh());
            material = null;
        }
        if (material == null && (material = qj.a(qt.bQ(string3 = bbg2.gP("equipment.slot") ? qt.bS(bbg2.az("equipment.slot", null)) : bbg2.az("specific_properties.armor.slot", null)))) == null) {
            bce.error("[Items] '" + string + ":" + string2 + "'. Error: The slot '" + string3 + "' is not a valid armor slot. File: " + bbf2.nh());
            return null;
        }
        boolean bl = false;
        Color color = bcy.iL(bbg2.az("specific_properties.armor.color", null));
        qj qj2 = new qj(bbf2, string, string2, material, color, bbg2.C("specific_properties.armor.can_wear", true));
        Object object = bbg2.az("specific_properties.armor.custom_armor", bbg2.az("equipment.legacy_armor_rendering_id", null));
        if (object != null) {
            rd rd2;
            if (!((String)object).contains(":")) {
                object = string + ":" + (String)object;
            }
            if ((rd2 = (rd)d.g().L.get(object)) != null) {
                if (ae.dz) {
                    bce.log(String.valueOf(ChatColor.GREEN) + "Set custom_armor '" + (String)object + "' for item '" + qj2.getNamespacedID() + "'. File: " + qj2.nh());
                }
                qj2.a(rd2);
            } else {
                bce.error("[Items] '" + qj2.getNamespacedID() + "'. Error: Unknown custom_armor '" + (String)object + "'. File: " + qj2.nh());
            }
        }
        if (qj2.mB() == null && color != null) {
            int n = color.asRGB();
            HashMap hashMap = (HashMap)d.g().H.get((Object)qj2.Fs);
            if (hashMap != null && hashMap.containsKey(n)) {
                Integer n2;
                if (ae.dz) {
                    bce.warn(String.valueOf(ChatColor.YELLOW) + "Armor piece " + String.valueOf((Object)qj2.Fs) + " " + ((qm)hashMap.get(n)).getNamespacedID() + " is using the same color as " + qj2.getNamespacedID() + ". Trying to generate a new similar color...");
                }
                if ((n2 = azg.b(n, hashMap)) == null) {
                    if (ae.dz) {
                        bce.error(String.valueOf(ChatColor.RED) + "Failed to find a proper color for armor piece " + String.valueOf((Object)qj2.Fs) + " " + qj2.getNamespacedID() + ". Decide another color. File: " + bbf2.nh());
                    }
                } else {
                    if (ae.dz) {
                        bce.error(String.valueOf(ChatColor.GREEN) + "Fixed color for armor '" + qj2.getNamespacedID() + "'. File: " + bbf2.nh());
                    }
                    qj2.setColor(bcy.bQ(n2));
                    bbg2.d("specific_properties.armor.color", (Object)bcy.bP(n2));
                    d.g().H.computeIfAbsent(qj2.Fs, qt2 -> new HashMap()).put(n2, qj2);
                    bl = true;
                }
            } else {
                d.g().H.computeIfAbsent(qj2.Fs, qt2 -> new HashMap()).put(n, qj2);
            }
        }
        return new ta(qj2, bl, material);
    }
}
