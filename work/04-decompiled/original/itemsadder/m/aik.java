package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.potion.PotionEffectType;

public final class aik
extends Record {
    private final PotionEffectType acs;
    private final int act;
    private final int acu;
    private final boolean acv;
    private final boolean acw;
    private final boolean acx;

    public aik(PotionEffectType potionEffectType, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.acs = potionEffectType;
        this.act = n;
        this.acu = n2;
        this.acv = bl;
        this.acw = bl2;
        this.acx = bl3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{aik.class, "potionEffectType;duration;amplifier;ambient;particles;showIcon", "acs", "act", "acu", "acv", "acw", "acx"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{aik.class, "potionEffectType;duration;amplifier;ambient;particles;showIcon", "acs", "act", "acu", "acv", "acw", "acx"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{aik.class, "potionEffectType;duration;amplifier;ambient;particles;showIcon", "acs", "act", "acu", "acv", "acw", "acx"}, this, object);
    }

    public PotionEffectType tQ() {
        return this.acs;
    }

    public int tR() {
        return this.act;
    }

    public int tS() {
        return this.acu;
    }

    public boolean tT() {
        return this.acv;
    }

    public boolean tU() {
        return this.acw;
    }

    public boolean tV() {
        return this.acx;
    }
}
