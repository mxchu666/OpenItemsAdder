package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.Builder_14;
import itemsadder.m.ColorBridge;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.Opaque127;
import me.clip.placeholderapi.PlaceholderAPI;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.jetbrains.annotations.Nullable;

public class ItemStackBridge_16
extends Builder_14 {
    public final String CI;
    public boolean gG;
    private final boolean CJ;
    @Nullable
    private final String CK;

    public ItemStackBridge_16(String string, boolean bl, boolean bl2, @Nullable String string2) {
        this.CI = string;
        this.gG = bl;
        this.CJ = bl2;
        this.CK = string2;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        String string = ItemStackBridge_16.a(event, player, player, player.getLocation(), this.CI);
        if (this.gG) {
            if (!Opaque127.a(string, this)) {
                return ItemStackBuilder_3.mk();
            }
        } else {
            player.performCommand(string);
        }
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Player player = playerInteractEvent.getPlayer();
        Location location = ColorBridge.r(playerInteractEvent);
        if (location == null) {
            if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR) {
                location = player.getEyeLocation().add(player.getLocation().getDirection().multiply(5));
            } else {
                return ItemStackBuilder_3.mk();
            }
        }
        String string = ItemStackBridge_16.a((Event)playerInteractEvent, player, player, ColorBridge.r(playerInteractEvent), this.CI);
        if (Main.Pz) {
            string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
        }
        if (this.gG) {
            if (!Opaque127.a(string, this)) {
                return ItemStackBuilder_3.mk();
            }
        } else {
            player.performCommand(string);
        }
        return ItemStackBuilder_3.m(itemStack);
    }

    @Override
    public ItemStackBuilder_3 a(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (this.a((Event)entityDamageByEntityEvent, (Player)entityDamageByEntityEvent.getDamager(), entityDamageByEntityEvent.getEntity())) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (this.a((Event)playerInteractEntityEvent, playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getRightClicked())) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Player player;
        if (projectileHitEvent.getHitEntity() == null) {
            return ItemStackBuilder_3.mk();
        }
        if (projectileHitEvent.getEntity().hasMetadata("playerName") && (player = Bukkit.getServer().getPlayer(((MetadataValue)projectileHitEvent.getEntity().getMetadata("playerName").getFirst()).asString())) != null && !this.a((Event)projectileHitEvent, player, projectileHitEvent.getHitEntity())) {
            return ItemStackBuilder_3.mk();
        }
        return ItemStackBuilder_3.ml();
    }

    private boolean a(Event event, Player player, Entity entity) {
        Player player2;
        String string = ItemStackBridge_16.a(event, player, entity instanceof Player ? (player2 = (Player)entity) : null, entity.getLocation(), this.CI);
        if (Main.Pz) {
            string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
        }
        if (this.gG) {
            return Opaque127.a(string, this);
        }
        player.performCommand(string);
        return true;
    }

    public static String a(@Nullable Event event, @Nullable Player player, @Nullable Player player2, @Nullable Location location, String string) {
        if (event != null) {
            string = StringUtils.replace((String)string, (String)"{debug-event-name}", (String)event.getEventName());
        }
        if (player != null) {
            Location location2 = player.getLocation();
            string = StringUtils.replace((String)string, (String)"{player}", (String)player.getName());
            string = StringUtils.replace((String)string, (String)"{player-x}", (String)("" + location2.getX()));
            string = StringUtils.replace((String)string, (String)"{player-y}", (String)("" + location2.getY()));
            string = StringUtils.replace((String)string, (String)"{player-z}", (String)("" + location2.getZ()));
            string = StringUtils.replace((String)string, (String)"{player-yaw}", (String)("" + location2.getYaw()));
            string = StringUtils.replace((String)string, (String)"{player-inverse-yaw}", (String)("" + (location2.getYaw() + 180.0f)));
            string = StringUtils.replace((String)string, (String)"{player-pitch}", (String)("" + location2.getPitch()));
            string = StringUtils.replace((String)string, (String)"{player-world}", (String)location2.getWorld().getName());
        }
        if (player2 != null) {
            string = StringUtils.replace((String)string, (String)"{target-player}", (String)player2.getName());
        }
        if (location != null) {
            string = StringUtils.replace((String)string, (String)"{world}", (String)location.getWorld().getName());
            string = StringUtils.replace((String)string, (String)"{target-world}", (String)location.getWorld().getName());
            string = StringUtils.replace((String)string, (String)"{target-x}", (String)("" + location.getX()));
            string = StringUtils.replace((String)string, (String)"{target-y}", (String)("" + location.getY()));
            string = StringUtils.replace((String)string, (String)"{target-z}", (String)("" + location.getZ()));
            string = StringUtils.replace((String)string, (String)"{target-yaw}", (String)("" + location.getYaw()));
            string = StringUtils.replace((String)string, (String)"{target-inverse-yaw}", (String)("" + (location.getYaw() + 180.0f)));
            string = StringUtils.replace((String)string, (String)"{target-pitch}", (String)("" + location.getPitch()));
        }
        if (Main.Pz) {
            string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
        }
        return string;
    }

    public static String e(Player player, String string) {
        return ItemStackBridge_16.a(null, player, player, player.getLocation(), string);
    }
}
