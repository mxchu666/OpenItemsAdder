package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.da;
import itemsadder.m.db;
import itemsadder.m.dn;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class CustomPlayer
extends CustomEntity {
    private String playerName;

    CustomPlayer(dn dn2) {
        super(dn2);
    }

    CustomPlayer(dn dn2, String string) {
        this(dn2);
        this.playerName = string;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public boolean playAnimation(String string) {
        db db2 = da.a(this.renderer, string);
        return db2.lZ;
    }

    @Override
    public void stopAnimation() {
        this.renderer.ec().gm();
    }

    public static CustomPlayer spawn(String string, Location location) {
        if (!da.P() || !da.db().dc()) {
            throw new RuntimeException("Entities API not available. Check if it's disabled in config.yml of ItemsAdder");
        }
        dn dn2 = da.db().a(null, string, location, "_iainternal:player", null);
        return new CustomPlayer(dn2, string);
    }

    @Nullable
    public static CustomPlayer byAlreadySpawned(Entity entity) {
        if (!da.P() || !da.db().dc()) {
            throw new RuntimeException("Entities API not available. Check if it's disabled in config.yml of ItemsAdder");
        }
        dn dn2 = da.db().h(entity);
        if (dn2 == null || !dn2.my.nO.pD) {
            return null;
        }
        return new CustomPlayer(dn2);
    }

    public static void playEmote(Player player, String string) {
        da.db().b(player, string);
    }

    public static void stopEmote(Player player) {
        da.db().X(player);
    }
}
