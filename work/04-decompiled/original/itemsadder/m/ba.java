package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.as;
import itemsadder.m.av;
import itemsadder.m.bb;
import itemsadder.m.bc;
import itemsadder.m.bcy;
import itemsadder.m.bd;
import itemsadder.m.dn;
import lombok.Generated;
import me.clip.placeholderapi.PlaceholderAPI;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.MetadataValue;
import org.jetbrains.annotations.Nullable;

public class ba
extends as {
    public final String gF;
    public boolean gG;
    private final boolean gH;
    @Nullable
    private final String gI;

    @Override
    public av a(Event event, dn dn2, Player player) {
        String string = this.gF;
        string = StringUtils.replace((String)string, (String)"{debug-event-name}", (String)event.getEventName());
        if (player != null) {
            string = StringUtils.replace((String)this.gF, (String)"{player}", (String)player.getName());
            if (Main.Pz) {
                string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
            }
        }
        if (this.gG) {
            if (!bb.a(string, this)) {
                return av.aM();
            }
        } else {
            if (player == null) {
                return av.aM();
            }
            player.performCommand(string);
        }
        return av.aN();
    }

    @Override
    public av a(Event event, dn dn2) {
        if (event instanceof PlayerEvent) {
            PlayerEvent playerEvent = (PlayerEvent)event;
            if (this.c(playerEvent.getPlayer(), (Entity)dn2.eh())) {
                return av.aN();
            }
            return av.aM();
        }
        return av.aM();
    }

    @Override
    public av a(PlayerInteractEvent playerInteractEvent, dn dn2) {
        Player player = playerInteractEvent.getPlayer();
        Location location = bcy.r(playerInteractEvent);
        if (location == null) {
            if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR) {
                location = player.getEyeLocation().add(player.getLocation().getDirection().multiply(5));
            } else {
                return av.aM();
            }
        }
        String string = StringUtils.replace((String)this.gF, (String)"{player}", (String)player.getName());
        string = StringUtils.replace((String)string, (String)"{target-player}", (String)player.getName());
        string = StringUtils.replace((String)string, (String)"{world}", (String)location.getWorld().getName());
        string = StringUtils.replace((String)string, (String)"{target-world}", (String)location.getWorld().getName());
        string = StringUtils.replace((String)string, (String)"{target-x}", (String)("" + location.getX()));
        string = StringUtils.replace((String)string, (String)"{target-y}", (String)("" + location.getY()));
        string = StringUtils.replace((String)string, (String)"{target-z}", (String)("" + location.getZ()));
        string = StringUtils.replace((String)string, (String)"{target-yaw}", (String)("" + player.getLocation().getYaw()));
        string = StringUtils.replace((String)string, (String)"{target-inverse-yaw}", (String)("" + (player.getLocation().getYaw() + 180.0f)));
        string = StringUtils.replace((String)string, (String)"{target-pitch}", (String)("" + player.getLocation().getPitch()));
        if (Main.Pz) {
            string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
        }
        if (this.gG) {
            if (!bb.a(string, this)) {
                return av.aM();
            }
        } else {
            player.performCommand(string);
        }
        return av.aN();
    }

    @Override
    public av a(EntityDamageByEntityEvent entityDamageByEntityEvent, dn dn2) {
        Entity entity = entityDamageByEntityEvent.getDamager();
        if (!(entity instanceof Player)) {
            return av.aM();
        }
        Player player = (Player)entity;
        if (this.c(player, entityDamageByEntityEvent.getEntity())) {
            return av.aN();
        }
        return av.aM();
    }

    @Override
    public av a(EntityDamageEvent entityDamageEvent, dn dn2) {
        if (this.d(entityDamageEvent.getEntity())) {
            return av.aN();
        }
        return av.aM();
    }

    @Override
    public av a(PlayerInteractEntityEvent playerInteractEntityEvent, dn dn2) {
        if (this.c(playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getRightClicked())) {
            return av.aN();
        }
        return av.aM();
    }

    @Override
    public av a(ProjectileHitEvent projectileHitEvent, dn dn2) {
        Player player;
        if (projectileHitEvent.getHitEntity() == null) {
            return av.aM();
        }
        if (projectileHitEvent.getEntity().hasMetadata("playerName") && (player = Bukkit.getServer().getPlayer(((MetadataValue)projectileHitEvent.getEntity().getMetadata("playerName").get(0)).asString())) != null && !this.c(player, projectileHitEvent.getHitEntity())) {
            return av.aM();
        }
        return av.aN();
    }

    private boolean d(Entity entity) {
        String string = this.gF;
        string = StringUtils.replace((String)string, (String)"{world}", (String)entity.getLocation().getWorld().getName());
        string = StringUtils.replace((String)string, (String)"{target-world}", (String)entity.getLocation().getWorld().getName());
        string = StringUtils.replace((String)string, (String)"{target-x}", (String)("" + entity.getLocation().getBlockX()));
        string = StringUtils.replace((String)string, (String)"{target-y}", (String)("" + entity.getLocation().getBlockY()));
        string = StringUtils.replace((String)string, (String)"{target-z}", (String)("" + entity.getLocation().getBlockZ()));
        string = StringUtils.replace((String)string, (String)"{target-yaw}", (String)("" + entity.getLocation().getYaw()));
        string = StringUtils.replace((String)string, (String)"{target-inverse-yaw}", (String)("" + (entity.getLocation().getYaw() + 180.0f)));
        string = StringUtils.replace((String)string, (String)"{target-pitch}", (String)("" + entity.getLocation().getPitch()));
        if (this.gG) {
            return bb.a(string, this);
        }
        return false;
    }

    private boolean c(Player player, Entity entity) {
        String string = StringUtils.replace((String)this.gF, (String)"{player}", (String)player.getName());
        if (entity.getType() == EntityType.PLAYER) {
            string = StringUtils.replace((String)string, (String)"{target-player}", (String)entity.getName());
        }
        string = StringUtils.replace((String)string, (String)"{world}", (String)entity.getLocation().getWorld().getName());
        string = StringUtils.replace((String)string, (String)"{target-world}", (String)entity.getLocation().getWorld().getName());
        string = StringUtils.replace((String)string, (String)"{target-x}", (String)("" + entity.getLocation().getBlockX()));
        string = StringUtils.replace((String)string, (String)"{target-y}", (String)("" + entity.getLocation().getBlockY()));
        string = StringUtils.replace((String)string, (String)"{target-z}", (String)("" + entity.getLocation().getBlockZ()));
        string = StringUtils.replace((String)string, (String)"{target-yaw}", (String)("" + entity.getLocation().getYaw()));
        string = StringUtils.replace((String)string, (String)"{target-inverse-yaw}", (String)("" + (entity.getLocation().getYaw() + 180.0f)));
        string = StringUtils.replace((String)string, (String)"{target-pitch}", (String)("" + entity.getLocation().getPitch()));
        if (Main.Pz) {
            string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
        }
        if (this.gG) {
            return bb.a(string, this);
        }
        player.performCommand(string);
        return true;
    }

    @Generated
    protected ba(bc bc2) {
        super(bc2);
        this.gF = bc2.gF;
        this.gG = bc2.gG;
        this.gH = bc2.gH;
        this.gI = bc2.gI;
    }

    @Generated
    public static bc aS() {
        return new bd();
    }
}
