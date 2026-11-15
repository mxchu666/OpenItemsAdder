package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.sv;
import java.util.List;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

public class ss {
    public static boolean c(bbg bbg2) {
        return bbg2.fo("equipment");
    }

    public static void a(qm qm2, bbg bbg2, bbf bbf2, String string, String string2) {
        ss.b(qm2, bbg2, bbf2, string, string2, null);
    }

    static void a(qm qm2, bbg bbg2, bbf bbf2, String string, String string2, NamespacedKey namespacedKey) {
        ss.b(qm2, bbg2, bbf2, string, string2, namespacedKey);
    }

    private static void b(qm qm2, bbg bbg2, bbf bbf2, String string2, String string4, @Nullable NamespacedKey namespacedKey) {
        EquipmentSlot equipmentSlot;
        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
            throw new IllegalArgumentException("Error: 'equipment' is only available in 1.21.2+. File: " + bbf2.nh());
        }
        @Nullable bbg bbg3 = bbg2.hj("equipment");
        if (bbg3 == null && namespacedKey == null) {
            throw new IllegalArgumentException("Error: 'equipment' must be a section. File: " + bbf2.nh());
        }
        EquipmentSlot equipmentSlot2 = bbs.ad(qm2.getType());
        String string5 = bbg3 == null ? null : bbg3.az("slot", namespacedKey == null && equipmentSlot2 != null ? equipmentSlot2.name() : null);
        EquipmentSlot equipmentSlot3 = equipmentSlot = namespacedKey != null ? EquipmentSlot.CHEST : bbf.a(string5, (T string3) -> bce.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.slot' value '" + string3 + "'. File: " + bbf2.nh()));
        if (namespacedKey != null && string5 != null && bbf.a(string5, (T string) -> {}) != EquipmentSlot.CHEST) {
            throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.slot: CHEST'. File: " + bbf2.nh());
        }
        if (equipmentSlot != null) {
            ConfigurationSection configurationSection;
            Boolean bl;
            NamespacedKey namespacedKey2;
            @Nullable String string6 = bbg3 == null ? null : bbg3.gV("id");
            @Nullable NamespacedKey namespacedKey3 = bbf.a(string6, string2, true, (T string3) -> bce.error("[Items] '" + string2 + ":" + string4 + "'. Error: Invalid 'equipment.id' value '" + string3 + "'. File: " + bbf2.nh()));
            if (namespacedKey != null && string6 != null && namespacedKey3 == null) {
                throw new IllegalArgumentException("Error: 'elytra' has invalid explicit 'equipment.id: " + string6 + "'. File: " + bbf2.nh());
            }
            if (namespacedKey != null && namespacedKey3 != null && !namespacedKey.equals((Object)namespacedKey3)) {
                throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.id: " + String.valueOf(namespacedKey) + "'. File: " + bbf2.nh());
            }
            NamespacedKey namespacedKey4 = namespacedKey2 = namespacedKey != null ? namespacedKey : namespacedKey3;
            if (namespacedKey2 != null && namespacedKey == null && d.g().a(namespacedKey2) == null) {
                throw new IllegalArgumentException("Error: Unknown 'equipment.id' value '" + String.valueOf(namespacedKey2) + "'. File: " + bbf2.nh());
            }
            @Nullable NamespacedKey namespacedKey5 = bbf.a(bbg3 == null ? null : bbg3.gV("camera_overlay_id"), string2, true, (T string3) -> bce.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.camera_overlay_id' value '" + string3 + "'. File: " + bbf2.nh()));
            @Nullable String string7 = bbf.a(bbg3 == null ? null : bbg3.gV("sound"), true, () -> bce.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.sound'. File: " + bbf2.nh()));
            @Nullable List list = bbf.a(bbg3 == null ? List.of() : bbg3.hg("allowed_entities"), EntityType.class, true, true, (T string3) -> bce.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.allowed_entities' value '" + string3 + "'. File: " + bbf2.nh()));
            if (namespacedKey != null && bbg3 != null && bbg3.fo("allowed_entities") && (list == null || !list.contains(EntityType.PLAYER))) {
                throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.allowed_entities' to include PLAYER. File: " + bbf2.nh());
            }
            Boolean bl2 = bl = bbg3 == null ? null : bbg3.a("glider", (Boolean)null);
            if (namespacedKey != null && bbg3 != null && bbg3.fo("glider") && !Boolean.TRUE.equals(bl)) {
                throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.glider: true'. File: " + bbf2.nh());
            }
            qm2.a(namespacedKey2, equipmentSlot, string7, namespacedKey5, list, bbg3 == null ? null : bbg3.a("dispensable", (Boolean)null), bbg3 == null ? null : bbg3.a("swappable", (Boolean)null), bbg3 == null ? null : bbg3.a("damage_on_hurt", (Boolean)null), ss.a(namespacedKey != null, bl));
            ConfigurationSection configurationSection2 = configurationSection = bbg3 == null ? null : bbg3.hi("slot_attribute_modifiers");
            if (configurationSection != null) {
                for (String string8 : configurationSection.getKeys(false)) {
                    sv.a(qm2, equipmentSlot.name().toLowerCase(), string8, configurationSection);
                }
            }
        }
    }

    @Nullable
    static Boolean a(boolean bl, @Nullable Boolean bl2) {
        return bl ? Boolean.TRUE : bl2;
    }
}
