package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity$MountBone;
import itemsadder.m.ej;
import org.bukkit.Location;

public class CustomEntity$Bone {
    int ordinal;
    int id;
    ej internal;

    static CustomEntity$Bone wrap(ej ej2, int n) {
        if (ej2.gD() != null) {
            return new CustomEntity$MountBone(n, ej2);
        }
        return new CustomEntity$Bone(n, ej2);
    }

    CustomEntity$Bone(int n, ej ej2) {
        this.ordinal = n;
        this.internal = ej2;
        this.id = ej2.qw.Yb;
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
