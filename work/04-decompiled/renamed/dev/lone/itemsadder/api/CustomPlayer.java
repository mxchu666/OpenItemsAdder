package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.BoolStringData;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class CustomPlayer
extends CustomEntity {
    private String playerName;

    CustomPlayer(LivingEntityBuilder livingEntityBuilder) {
        super(livingEntityBuilder);
    }

    CustomPlayer(LivingEntityBuilder livingEntityBuilder, String string) {
        this(livingEntityBuilder);
        this.playerName = string;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public boolean playAnimation(String string) {
        BoolStringData boolStringData = LivingEntityRegistry.a(this.renderer, string);
        return boolStringData.lZ;
    }

    @Override
    public void stopAnimation() {
        this.renderer.ec().gm();
    }

    public static CustomPlayer spawn(String string, Location location) {
        if (!LivingEntityRegistry.P() || !LivingEntityRegistry.db().dc()) {
            throw new RuntimeException("Entities API not available. Check if it's disabled in config.yml of ItemsAdder");
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(null, string, location, "_iainternal:player", null);
        return new CustomPlayer(livingEntityBuilder, string);
    }

    @Nullable
    public static CustomPlayer byAlreadySpawned(Entity entity) {
        if (!LivingEntityRegistry.P() || !LivingEntityRegistry.db().dc()) {
            throw new RuntimeException("Entities API not available. Check if it's disabled in config.yml of ItemsAdder");
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        if (livingEntityBuilder == null || !livingEntityBuilder.my.nO.pD) {
            return null;
        }
        return new CustomPlayer(livingEntityBuilder);
    }

    public static void playEmote(Player player, String string) {
        LivingEntityRegistry.db().b(player, string);
    }

    public static void stopEmote(Player player) {
        LivingEntityRegistry.db().X(player);
    }
}
