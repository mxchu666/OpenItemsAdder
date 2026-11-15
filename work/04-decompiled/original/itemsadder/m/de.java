package itemsadder.m;

import itemsadder.m.afz;
import itemsadder.m.agc;
import itemsadder.m.df;
import itemsadder.m.dg;
import itemsadder.m.di;
import itemsadder.m.dj;
import itemsadder.m.dk;
import itemsadder.m.dm;
import itemsadder.m.dp;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public final class de
extends Record {
    private final dp mf;
    private final float mg;
    private final int mh;
    @Nullable
    private final List mi;
    @Nullable
    private final List mj;
    private final dj mk;
    @Nullable
    private final dg ml;
    @Nullable
    private final List mm;
    @Nullable
    private final List mn;
    @Nullable
    private final di mo;

    public de(dp dp2, float f, int n, @Nullable List list, @Nullable List list2, dj dj2, @Nullable dg dg2, @Nullable List list3, @Nullable List list4, @Nullable di di2) {
        this.mf = dp2;
        this.mg = f;
        this.mh = n;
        this.mi = list;
        this.mj = list2;
        this.mk = dj2;
        this.ml = dg2;
        this.mm = list3;
        this.mn = list4;
        this.mo = di2;
    }

    public static de a(dp dp2, float f, int n, @Nullable List list, @Nullable List list2, dj dj2, @Nullable dg dg2, @Nullable List list3, @Nullable List list4, @Nullable di di2) {
        agc agc2;
        if (dp2 == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        if (f < 0.0f || f > 100.0f) {
            throw new IllegalArgumentException("chance must be between 0 and 100");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("amount must be greater than 0");
        }
        if (dj2 == null) {
            throw new IllegalArgumentException("spawnLogic must not be null");
        }
        if (dj2.mw == dk.REPLACE && dj2.mx.isEmpty()) {
            dj2.mx.add(dp2.nS);
        }
        if ((agc2 = afz.tK().k(dp2.nS)) == null) {
            throw new IllegalArgumentException("Failed to calculate the entity category for " + String.valueOf(dp2.nS));
        }
        boolean bl = dj2.mx.stream().map(afz.tK()::k).allMatch(agc3 -> agc3 != null && agc3 == agc2);
        if (!bl) {
            throw new IllegalArgumentException("The 'type' '" + String.valueOf(dp2.nS) + "' with category " + String.valueOf((Object)agc2) + " is not compatible with the 'types' specified in 'spawn_logic': " + String.valueOf(dj2.mx) + ". All 'types' must belong to the same category as the entity to be spawned. If you want to use types from different categories, set 'spawn_logic.method' to 'SPAWN_NEAR'. This is a technical limitation of the game. Allowing different categories would cause infinite spawning and lag.");
        }
        return new de(dp2, f, n, list, list2, dj2, dg2, list3, list4, di2);
    }

    public boolean d(World world) {
        if (this.mj == null || this.mj.isEmpty()) {
            return true;
        }
        if (this.mj.contains(world.getName())) {
            return true;
        }
        for (String string : this.mj) {
            if (!FilenameUtils.wildcardMatch((String)world.getName(), (String)string)) continue;
            return true;
        }
        return false;
    }

    public boolean a(EntityType entityType, Location location) {
        Biome biome;
        int n;
        if (!this.mk.mx.contains(entityType)) {
            return false;
        }
        if (this.ml != null && !this.ml.o(location)) {
            return false;
        }
        if (this.mo != null && !this.mo.m(n = location.getBlock().getLightLevel())) {
            return false;
        }
        if (this.mn != null && !this.mn.isEmpty()) {
            n = (int)(location.getWorld().getTime() % 24000L);
            boolean bl = this.mn.stream().anyMatch(di2 -> di2.m(n));
            if (!bl) {
                return false;
            }
        }
        if (this.mi != null && !this.mi.isEmpty() && !this.mi.contains((biome = location.getBlock().getBiome()).getKey())) {
            return false;
        }
        if (this.mm != null && !this.mm.isEmpty()) {
            dm dm2 = dm.p(location);
            return dm2 != null && this.mm.contains((Object)dm2);
        }
        return true;
    }

    public boolean dy() {
        return ThreadLocalRandom.current().nextDouble(0.0, 100.0) < (double)this.mg;
    }

    @Generated
    public static df dz() {
        return new df();
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{de.class, "entity;chance;amount;biomes;worldNameMatchRules;spawnLogic;locationRange;weathers;timeIntervals;lightLevelRange", "mf", "mg", "mh", "mi", "mj", "mk", "ml", "mm", "mn", "mo"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{de.class, "entity;chance;amount;biomes;worldNameMatchRules;spawnLogic;locationRange;weathers;timeIntervals;lightLevelRange", "mf", "mg", "mh", "mi", "mj", "mk", "ml", "mm", "mn", "mo"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{de.class, "entity;chance;amount;biomes;worldNameMatchRules;spawnLogic;locationRange;weathers;timeIntervals;lightLevelRange", "mf", "mg", "mh", "mi", "mj", "mk", "ml", "mm", "mn", "mo"}, this, object);
    }

    public dp dA() {
        return this.mf;
    }

    public float dB() {
        return this.mg;
    }

    public int dC() {
        return this.mh;
    }

    @Nullable
    public List dD() {
        return this.mi;
    }

    @Nullable
    public List dE() {
        return this.mj;
    }

    public dj dF() {
        return this.mk;
    }

    @Nullable
    public dg dG() {
        return this.ml;
    }

    @Nullable
    public List dH() {
        return this.mm;
    }

    @Nullable
    public List dI() {
        return this.mn;
    }

    @Nullable
    public di dJ() {
        return this.mo;
    }
}
