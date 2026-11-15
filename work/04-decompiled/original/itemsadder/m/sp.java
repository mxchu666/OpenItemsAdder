package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.rm;
import itemsadder.m.rn;
import itemsadder.m.ro;
import itemsadder.m.rq;
import itemsadder.m.ss;
import itemsadder.m.v;
import java.util.function.Predicate;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

public final class sp {
    private sp() {
    }

    public static boolean c(bbg bbg2) {
        return bbg2.fo("elytra");
    }

    public static void a(qm qm2, bbg bbg2, bbf bbf2, String string2, String string3) {
        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
            throw new IllegalArgumentException("'elytra' is only available in 1.21.2+. File: " + bbf2.nh());
        }
        ConfigurationSection configurationSection = bbg2.hi("elytra");
        if (configurationSection == null) {
            throw new IllegalArgumentException("'elytra' must be a section. File: " + bbf2.nh());
        }
        NamespacedKey namespacedKey = new NamespacedKey(string2, string3);
        rm rm2 = sp.a(configurationSection, string2, namespacedKey, sp.o(qm2), (T string) -> d.t(string) != null);
        ss.a(qm2, bbg2, bbf2, string2, string3, namespacedKey);
        qm2.a(rm2);
        if (qm2.FX != null) {
            qm2.FX.a(rm2);
        }
        d.g().F().put(namespacedKey, ro.a(namespacedKey, rm2.oo()));
    }

    static rm a(ConfigurationSection configurationSection, String string, NamespacedKey namespacedKey, @Nullable String string2, Predicate predicate) {
        String string3 = sp.a(configurationSection.get("wings_texture"), string, "elytra.wings_texture", false);
        if (!predicate.test(string3)) {
            throw new IllegalArgumentException("Can't find 'elytra.wings_texture' texture '" + string3 + "'.");
        }
        String string4 = sp.a(configurationSection.get("broken_item_texture"), string, "elytra.broken_item_texture", true);
        String string5 = sp.a(string2, string4, predicate);
        if (string4 != null && string5 == null) {
            throw new IllegalArgumentException("Can't find 'elytra.broken_item_texture' texture '" + string4 + "'.");
        }
        int n = sp.a(configurationSection, "max_flight_ticks", 0);
        int n2 = sp.a(configurationSection, "firework.cooldown_ticks", 0);
        double d2 = sp.a(configurationSection, "durability_damage_multiplier", 1.0);
        double d3 = sp.a(configurationSection, "collision_damage_multiplier", 1.0);
        return new rm(namespacedKey, string3, string5, n, new rn(configurationSection.getBoolean("firework.enabled", true), configurationSection.getBoolean("firework.consume", true), n2), d2, d3);
    }

    @Nullable
    static String a(@Nullable String string, @Nullable String string2, Predicate predicate) {
        if (string2 != null) {
            return predicate.test(string2) ? string2 : null;
        }
        if (string == null) {
            return null;
        }
        String string3 = string.replaceFirst("\\.png$", "") + "_broken";
        return predicate.test(string3) ? string3 : null;
    }

    private static int a(ConfigurationSection configurationSection, String string, int n) {
        Number number;
        Object object = configurationSection.get(string);
        if (object == null) {
            return n;
        }
        if (!(object instanceof Number) || !Double.isFinite((number = (Number)object).doubleValue()) || number.doubleValue() < 0.0 || number.doubleValue() != Math.rint(number.doubleValue()) || number.doubleValue() > 2.147483647E9) {
            throw new IllegalArgumentException("'elytra." + string + "' must be a non-negative integer.");
        }
        return number.intValue();
    }

    private static double a(ConfigurationSection configurationSection, String string, double d2) {
        Number number;
        Object object = configurationSection.get(string);
        if (object == null) {
            return d2;
        }
        if (!(object instanceof Number) || !Double.isFinite((number = (Number)object).doubleValue()) || number.doubleValue() < 0.0) {
            throw new IllegalArgumentException("'elytra." + string + "' must be a non-negative finite number.");
        }
        return number.doubleValue();
    }

    @Nullable
    private static String a(@Nullable Object object, String string, String string2, boolean bl) {
        String string3;
        if (object == null && bl) {
            return null;
        }
        if (!(object instanceof String) || (string3 = (String)object).isBlank()) {
            throw new IllegalArgumentException("'" + string2 + "' must be a resource path.");
        }
        String string4 = v.i(string3.replaceFirst("\\.png$", ""), string);
        if (string4 == null) {
            throw new IllegalArgumentException("'" + string2 + "' has invalid resource path '" + string3 + "'.");
        }
        return string4;
    }

    @Nullable
    private static String o(qm qm2) {
        Object object = qm2.FX;
        if (object instanceof rq) {
            rq rq2 = (rq)object;
            String string = (String)(object = rq2.oD()).get("normal");
            if (string == null) {
                string = (String)object.get("layer0");
            }
            if (string == null) {
                string = object.values().stream().findFirst().orElse(null);
            }
            return string;
        }
        if (qm2.FX != null || qm2.getTextures() == null || qm2.getTextures().isEmpty()) {
            return null;
        }
        return (String)qm2.getTextures().getFirst();
    }
}
