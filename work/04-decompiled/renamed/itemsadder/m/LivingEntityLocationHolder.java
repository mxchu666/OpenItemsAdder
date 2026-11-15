package itemsadder.m;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class LivingEntityLocationHolder {
    @Nullable
    public LivingEntity oy;
    @Nullable
    Location iZ;

    public LivingEntityLocationHolder(LivingEntity livingEntity) {
        this.oy = livingEntity;
    }

    public LivingEntityLocationHolder(Location location) {
        this.iZ = location;
    }

    public Location fE() {
        if (this.oy == null) {
            return this.iZ;
        }
        return this.oy.getLocation();
    }

    public void s(Location location) {
        if (this.oy != null) {
            this.oy.teleport(location);
        } else {
            this.iZ = location;
        }
    }

    public World cE() {
        return this.fE().getWorld();
    }

    public boolean fF() {
        return this.oy != null;
    }
}
