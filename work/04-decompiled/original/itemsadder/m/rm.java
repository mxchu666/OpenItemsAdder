package itemsadder.m;

import itemsadder.m.rn;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

public final class rm
extends Record {
    private final NamespacedKey Io;
    private final String Ip;
    @Nullable
    private final String Iq;
    private final int Ir;
    private final rn Is;
    private final double It;
    private final double Iu;

    public rm(NamespacedKey namespacedKey, String string, @Nullable String string2, int n, rn rn2, double d, double d2) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("'elytra.wings_texture' is required.");
        }
        if (n < 0) {
            throw new IllegalArgumentException("'elytra.max_flight_ticks' must be non-negative.");
        }
        rm.a("elytra.durability_damage_multiplier", d);
        rm.a("elytra.collision_damage_multiplier", d2);
        this.Io = namespacedKey;
        this.Ip = string;
        this.Iq = string2;
        this.Ir = n;
        this.Is = rn2;
        this.It = d;
        this.Iu = d2;
    }

    public boolean ak(int n) {
        return this.Ir > 0 && n >= this.Ir;
    }

    public int al(int n) {
        return Math.max(0, (int)Math.round((double)n * this.It));
    }

    public double n(double d) {
        return d * this.Iu;
    }

    private static void a(String string, double d) {
        if (!Double.isFinite(d) || d < 0.0) {
            throw new IllegalArgumentException("'" + string + "' must be a non-negative finite number.");
        }
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{rm.class, "equipmentId;wingsTexture;brokenItemTexture;maxFlightTicks;firework;durabilityDamageMultiplier;collisionDamageMultiplier", "Io", "Ip", "Iq", "Ir", "Is", "It", "Iu"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{rm.class, "equipmentId;wingsTexture;brokenItemTexture;maxFlightTicks;firework;durabilityDamageMultiplier;collisionDamageMultiplier", "Io", "Ip", "Iq", "Ir", "Is", "It", "Iu"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{rm.class, "equipmentId;wingsTexture;brokenItemTexture;maxFlightTicks;firework;durabilityDamageMultiplier;collisionDamageMultiplier", "Io", "Ip", "Iq", "Ir", "Is", "It", "Iu"}, this, object);
    }

    public NamespacedKey on() {
        return this.Io;
    }

    public String oo() {
        return this.Ip;
    }

    @Nullable
    public String op() {
        return this.Iq;
    }

    public int oq() {
        return this.Ir;
    }

    public rn or() {
        return this.Is;
    }

    public double os() {
        return this.It;
    }

    public double ot() {
        return this.Iu;
    }
}
