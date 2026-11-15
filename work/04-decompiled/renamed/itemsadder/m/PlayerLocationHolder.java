package itemsadder.m;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerLocationHolder {
    private final Player ajm;
    private final Location ajn;
    private final Entity ajo;
    @NotNull
    private final Location ajp;
    public long ajq;
    @Nullable
    private Float jI;
    @Nullable
    private Float jJ;

    public PlayerLocationHolder(Player player, Location location, Entity entity, @NotNull Location location2) {
        this.ajm = player;
        this.ajn = location;
        this.ajo = entity;
        this.ajp = location2;
        this.ajq = System.currentTimeMillis();
    }

    public Player un() {
        return this.ajm;
    }

    public Location uo() {
        return this.ajn;
    }

    public Entity up() {
        return this.ajo;
    }

    @NotNull
    public Location uq() {
        return this.ajp;
    }

    public float t(float f) {
        return this.jI != null ? this.jI.floatValue() : f;
    }

    public float u(float f) {
        return this.jJ != null ? this.jJ.floatValue() : f;
    }

    public void v(float f) {
        this.jI = Float.valueOf(f);
    }

    public void w(float f) {
        this.jJ = Float.valueOf(f);
    }
}
