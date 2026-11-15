package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.as;
import itemsadder.m.av;
import itemsadder.m.bbi;
import itemsadder.m.bj;
import itemsadder.m.bk;
import itemsadder.m.da;
import itemsadder.m.dn;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class bi
extends as {
    @Nullable
    public final String gL;
    @Nullable
    public final EntityType gM;
    @Nullable
    public final Integer gN;

    public static bj Z(String string) {
        EntityType entityType = (EntityType)bbi.e(string.toUpperCase(), EntityType.class);
        if (entityType != null) {
            return new bk().a(entityType);
        }
        if (da.db().lJ.containsKey(string)) {
            return new bk().aa(string);
        }
        throw new IllegalArgumentException("Invalid entity id: " + string);
    }

    int ba() {
        return this.gN != null ? this.gN : ae.dR;
    }

    @Override
    public av a(Event event, dn dn2, Player player) {
        return this.a(event, dn2);
    }

    @Override
    public av a(Event event, dn dn2) {
        Location location = dn2.getLocation();
        boolean bl = false;
        int n = this.ba();
        int n2 = 0;
        if (this.gM != null) {
            for (Entity entity : location.getChunk().getEntities()) {
                if (entity.getType() != this.gM || ++n2 < n) continue;
                return av.aM();
            }
            location.getWorld().spawnEntity(location, this.gM);
            bl = true;
        } else {
            for (Entity entity : location.getChunk().getEntities()) {
                if (!da.db().f(entity) || ++n2 < n) continue;
                return av.aM();
            }
            dn dn3 = da.db().a(this.gL, location, true);
            if (dn3 != null) {
                bl = true;
            }
        }
        if (bl) {
            return av.aN();
        }
        return av.aN();
    }

    @Generated
    protected bi(bj bj2) {
        super(bj2);
        this.gL = bj2.gL;
        this.gM = bj2.gM;
        this.gN = bj2.gN;
    }
}
