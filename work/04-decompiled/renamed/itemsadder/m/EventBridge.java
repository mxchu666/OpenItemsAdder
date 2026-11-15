package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EventBridgeBuilder;
import itemsadder.m.EventBridgeBuilderImpl;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.Opaque011;
import itemsadder.m.RecordOfValue_4;
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

public class EventBridge
extends EntityBridgeImpl {
    public final String gF;
    public boolean gG;
    private final boolean gH;
    @Nullable
    private final String gI;

    @Override
    public RecordOfValue_4 a(Event event, LivingEntityBuilder livingEntityBuilder, Player player) {
        String string = this.gF;
        string = StringUtils.replace((String)string, (String)"{debug-event-name}", (String)event.getEventName());
        if (player != null) {
            string = StringUtils.replace((String)this.gF, (String)"{player}", (String)player.getName());
            if (Main.Pz) {
                string = PlaceholderAPI.setPlaceholders((Player)player, (String)string);
            }
        }
        if (this.gG) {
            if (!Opaque011.a(string, this)) {
                return RecordOfValue_4.aM();
            }
        } else {
            if (player == null) {
                return RecordOfValue_4.aM();
            }
            player.performCommand(string);
        }
        return RecordOfValue_4.aN();
    }

    @Override
    public RecordOfValue_4 a(Event event, LivingEntityBuilder livingEntityBuilder) {
        if (event instanceof PlayerEvent) {
            PlayerEvent playerEvent = (PlayerEvent)event;
            if (this.c(playerEvent.getPlayer(), (Entity)livingEntityBuilder.eh())) {
                return RecordOfValue_4.aN();
            }
            return RecordOfValue_4.aM();
        }
        return RecordOfValue_4.aM();
    }

    @Override
    public RecordOfValue_4 a(PlayerInteractEvent playerInteractEvent, LivingEntityBuilder livingEntityBuilder) {
        Player player = playerInteractEvent.getPlayer();
        Location location = ColorBridge.r(playerInteractEvent);
        if (location == null) {
            if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR) {
                location = player.getEyeLocation().add(player.getLocation().getDirection().multiply(5));
            } else {
                return RecordOfValue_4.aM();
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
            if (!Opaque011.a(string, this)) {
                return RecordOfValue_4.aM();
            }
        } else {
            player.performCommand(string);
        }
        return RecordOfValue_4.aN();
    }

    @Override
    public RecordOfValue_4 a(EntityDamageByEntityEvent entityDamageByEntityEvent, LivingEntityBuilder livingEntityBuilder) {
        Entity entity = entityDamageByEntityEvent.getDamager();
        if (!(entity instanceof Player)) {
            return RecordOfValue_4.aM();
        }
        Player player = (Player)entity;
        if (this.c(player, entityDamageByEntityEvent.getEntity())) {
            return RecordOfValue_4.aN();
        }
        return RecordOfValue_4.aM();
    }

    @Override
    public RecordOfValue_4 a(EntityDamageEvent entityDamageEvent, LivingEntityBuilder livingEntityBuilder) {
        if (this.d(entityDamageEvent.getEntity())) {
            return RecordOfValue_4.aN();
        }
        return RecordOfValue_4.aM();
    }

    @Override
    public RecordOfValue_4 a(PlayerInteractEntityEvent playerInteractEntityEvent, LivingEntityBuilder livingEntityBuilder) {
        if (this.c(playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getRightClicked())) {
            return RecordOfValue_4.aN();
        }
        return RecordOfValue_4.aM();
    }

    @Override
    public RecordOfValue_4 a(ProjectileHitEvent projectileHitEvent, LivingEntityBuilder livingEntityBuilder) {
        Player player;
        if (projectileHitEvent.getHitEntity() == null) {
            return RecordOfValue_4.aM();
        }
        if (projectileHitEvent.getEntity().hasMetadata("playerName") && (player = Bukkit.getServer().getPlayer(((MetadataValue)projectileHitEvent.getEntity().getMetadata("playerName").get(0)).asString())) != null && !this.c(player, projectileHitEvent.getHitEntity())) {
            return RecordOfValue_4.aM();
        }
        return RecordOfValue_4.aN();
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
            return Opaque011.a(string, this);
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
            return Opaque011.a(string, this);
        }
        player.performCommand(string);
        return true;
    }

    @Generated
    protected EventBridge(EventBridgeBuilder eventBridgeBuilder) {
        super(eventBridgeBuilder);
        this.gF = eventBridgeBuilder.gF;
        this.gG = eventBridgeBuilder.gG;
        this.gH = eventBridgeBuilder.gH;
        this.gI = eventBridgeBuilder.gI;
    }

    @Generated
    public static EventBridgeBuilder aS() {
        return new EventBridgeBuilderImpl();
    }
}
