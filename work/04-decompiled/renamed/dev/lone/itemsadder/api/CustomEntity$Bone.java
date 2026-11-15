package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity$MountBone;
import itemsadder.m.LocationHolder_2;
import org.bukkit.Location;

public class CustomEntity$Bone {
    int ordinal;
    int id;
    LocationHolder_2 internal;

    static CustomEntity$Bone wrap(LocationHolder_2 locationHolder_2, int n) {
        if (locationHolder_2.gD() != null) {
            return new CustomEntity$MountBone(n, locationHolder_2);
        }
        return new CustomEntity$Bone(n, locationHolder_2);
    }

    CustomEntity$Bone(int n, LocationHolder_2 locationHolder_2) {
        this.ordinal = n;
        this.internal = locationHolder_2;
        this.id = locationHolder_2.qw.Yb;
    }

    public String getName() {
        return this.internal.qx.getId();
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public int getId() {
        return this.id;
    }

    public Location getLocation() {
        return this.internal.gC();
    }

    public int getColor() {
        if (this.internal.qw == null) {
            throw new RuntimeException("Client entity is null! Something failed to load.");
        }
        return this.internal.qw.getColor();
    }

    public void setColor(int n) {
        if (this.internal.qw == null) {
            throw new RuntimeException("Client entity is null! Something failed to load.");
        }
        this.internal.setColor(n);
    }

    public boolean getEnchanted() {
        if (this.internal.qw == null) {
            throw new RuntimeException("Client entity is null! Something failed to load.");
        }
        return this.internal.qw.getEnchanted();
    }

    public void setEnchanted(boolean bl) {
        if (this.internal.qw == null) {
            throw new RuntimeException("Client entity is null! Something failed to load.");
        }
        this.internal.setEnchanted(bl);
    }
}
