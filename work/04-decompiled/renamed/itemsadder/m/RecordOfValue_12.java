package itemsadder.m;

import itemsadder.m.ClearEnum;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.MonsterEnum;
import itemsadder.m.RecordOfValueBuilder;
import itemsadder.m.RecordOfValue_13;
import itemsadder.m.RecordOfValue_14;
import itemsadder.m.RecordOfValue_15;
import itemsadder.m.ReplaceEnum;
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

public final class RecordOfValue_12
extends Record {
    private final EntityTypeBarStyleHolder mf;
    private final float mg;
    private final int mh;
    @Nullable
    private final List mi;
    @Nullable
    private final List mj;
    private final RecordOfValue_15 mk;
    @Nullable
    private final RecordOfValue_13 ml;
    @Nullable
    private final List mm;
    @Nullable
    private final List mn;
    @Nullable
    private final RecordOfValue_14 mo;

    public RecordOfValue_12(EntityTypeBarStyleHolder entityTypeBarStyleHolder, float f, int n, @Nullable List list, @Nullable List list2, RecordOfValue_15 recordOfValue_15, @Nullable RecordOfValue_13 recordOfValue_13, @Nullable List list3, @Nullable List list4, @Nullable RecordOfValue_14 recordOfValue_14) {
        this.mf = entityTypeBarStyleHolder;
        this.mg = f;
        this.mh = n;
        this.mi = list;
        this.mj = list2;
        this.mk = recordOfValue_15;
        this.ml = recordOfValue_13;
        this.mm = list3;
        this.mn = list4;
        this.mo = recordOfValue_14;
    }

    public static RecordOfValue_12 a(EntityTypeBarStyleHolder entityTypeBarStyleHolder, float f, int n, @Nullable List list, @Nullable List list2, RecordOfValue_15 recordOfValue_15, @Nullable RecordOfValue_13 recordOfValue_13, @Nullable List list3, @Nullable List list4, @Nullable RecordOfValue_14 recordOfValue_14) {
        MonsterEnum monsterEnum;
        if (entityTypeBarStyleHolder == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        if (f < 0.0f || f > 100.0f) {
            throw new IllegalArgumentException("chance must be between 0 and 100");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("amount must be greater than 0");
        }
        if (recordOfValue_15 == null) {
            throw new IllegalArgumentException("spawnLogic must not be null");
        }
        if (recordOfValue_15.mw == ReplaceEnum.REPLACE && recordOfValue_15.mx.isEmpty()) {
            recordOfValue_15.mx.add(entityTypeBarStyleHolder.nS);
        }
        if ((monsterEnum = EntityHolder.tK().k(entityTypeBarStyleHolder.nS)) == null) {
            throw new IllegalArgumentException("Failed to calculate the entity category for " + String.valueOf(entityTypeBarStyleHolder.nS));
        }
        boolean bl = recordOfValue_15.mx.stream().map(EntityHolder.tK()::k).allMatch(monsterEnum2 -> monsterEnum2 != null && monsterEnum2 == monsterEnum);
        if (!bl) {
            throw new IllegalArgumentException("The 'type' '" + String.valueOf(entityTypeBarStyleHolder.nS) + "' with category " + String.valueOf((Object)monsterEnum) + " is not compatible with the 'types' specified in 'spawn_logic': " + String.valueOf(recordOfValue_15.mx) + ". All 'types' must belong to the same category as the entity to be spawned. If you want to use types from different categories, set 'spawn_logic.method' to 'SPAWN_NEAR'. This is a technical limitation of the game. Allowing different categories would cause infinite spawning and lag.");
        }
        return new RecordOfValue_12(entityTypeBarStyleHolder, f, n, list, list2, recordOfValue_15, recordOfValue_13, list3, list4, recordOfValue_14);
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
            boolean bl = this.mn.stream().anyMatch(recordOfValue_14 -> recordOfValue_14.m(n));
            if (!bl) {
                return false;
            }
        }
        if (this.mi != null && !this.mi.isEmpty() && !this.mi.contains((biome = location.getBlock().getBiome()).getKey())) {
            return false;
        }
        if (this.mm != null && !this.mm.isEmpty()) {
            ClearEnum clearEnum = ClearEnum.p(location);
            return clearEnum != null && this.mm.contains((Object)clearEnum);
        }
        return true;
    }

    public boolean dy() {
        return ThreadLocalRandom.current().nextDouble(0.0, 100.0) < (double)this.mg;
    }

    @Generated
    public static RecordOfValueBuilder dz() {
        return new RecordOfValueBuilder();
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_12.class, "entity;chance;amount;biomes;worldNameMatchRules;spawnLogic;locationRange;weathers;timeIntervals;lightLevelRange", "mf", "mg", "mh", "mi", "mj", "mk", "ml", "mm", "mn", "mo"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_12.class, "entity;chance;amount;biomes;worldNameMatchRules;spawnLogic;locationRange;weathers;timeIntervals;lightLevelRange", "mf", "mg", "mh", "mi", "mj", "mk", "ml", "mm", "mn", "mo"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_12.class, "entity;chance;amount;biomes;worldNameMatchRules;spawnLogic;locationRange;weathers;timeIntervals;lightLevelRange", "mf", "mg", "mh", "mi", "mj", "mk", "ml", "mm", "mn", "mo"}, this, object);
    }

    public EntityTypeBarStyleHolder dA() {
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

    public RecordOfValue_15 dF() {
        return this.mk;
    }

    @Nullable
    public RecordOfValue_13 dG() {
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
    public RecordOfValue_14 dJ() {
        return this.mo;
    }
}
