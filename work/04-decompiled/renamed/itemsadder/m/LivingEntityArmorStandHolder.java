package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import dev.lone.itemsadder.api.Events.ComplexFurniturePreSitEvent;
import dev.lone.itemsadder.api.Events.ComplexFurniturePreUnsitEvent;
import dev.lone.itemsadder.api.Events.ComplexFurnitureSitEvent;
import dev.lone.itemsadder.api.Events.ComplexFurnitureUnsitEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityHolder;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationHolder;
import itemsadder.m.LocationHolder_2;
import itemsadder.m.PacketEventHelper;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_7;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LivingEntityArmorStandHolder {
    public final LocationHolder_2 qQ;
    public LivingEntity qR;
    public LivingEntity oy;
    public boolean qS;
    private boolean qT;
    public ArmorStand qU;
    private boolean qV;
    private PacketEventHelper qW;
    private float qX;
    private float qY;
    private Location qZ;

    public LivingEntityArmorStandHolder(LocationHolder_2 locationHolder_2, boolean bl) {
        this.qQ = locationHolder_2;
        this.oy = locationHolder_2.qv.eg();
        this.qT = this.qS = bl;
    }

    public boolean gG() {
        return this.qR != null;
    }

    public LivingEntityBuilder gH() {
        return this.qQ.qv;
    }

    void gI() {
        Location location = this.qQ.gC();
        this.qR.teleport(location);
        this.gJ();
        this.gM();
    }

    public void d(LivingEntity livingEntity) {
        Player player;
        if (livingEntity instanceof Player && !ListenerBridge.b(new ComplexFurniturePreSitEvent(player = (Player)livingEntity, this.oy, this.qQ.qv))) {
            return;
        }
        if (this.oy != null) {
            this.oy.setCollidable(false);
            if (this.oy instanceof Mob) {
                EntityHolder.tK().a((Mob)this.oy, false);
            }
        }
        this.qR = livingEntity;
        this.gI();
        if (livingEntity instanceof Player) {
            player = (Player)livingEntity;
            ListenerBridge.b(new ComplexFurnitureSitEvent(player, this.oy, this.qQ.qv));
        }
    }

    public void removePassenger() {
        this.P(true);
    }

    public void P(boolean bl) {
        Player player;
        if (this.qR == null) {
            return;
        }
        LivingEntity livingEntity = this.qR;
        if (livingEntity instanceof Player && !ListenerBridge.b(new ComplexFurniturePreUnsitEvent(player = (Player)livingEntity, this.oy, this.qQ.qv))) {
            return;
        }
        player = this.qR;
        this.qR = null;
        this.gO();
        if (this.oy != null && this.qQ.qv.eG() == 0) {
            this.oy.setCollidable(true);
            if (this.oy instanceof Mob) {
                EntityHolder.tK().a((Mob)this.oy, true);
            }
        }
        if (this.qU != null) {
            if (bl) {
                BukkitTaskBridge.i(() -> this.f((LivingEntity)player));
            } else {
                this.e((LivingEntity)player);
            }
        }
        this.qT = this.qS;
        LivingEntity livingEntity2 = this.qR;
        if (livingEntity2 instanceof Player) {
            livingEntity = (Player)livingEntity2;
            ListenerBridge.b(new ComplexFurnitureUnsitEvent((Player)livingEntity, this.oy, this.qQ.qv));
        }
    }

    private void e(LivingEntity livingEntity) {
        Vector vector = LocationHolder.c(this.qU.getLocation().clone().add(0.0, 1.0, 0.0), this.qU.getLocation().clone().add(0.0, -5.0, 0.0));
        this.qU.eject();
        this.qU.remove();
        LivingEntityRegistry.db().lU.remove((Object)this.qU.getEntityId());
        if (vector != null) {
            Location location = livingEntity.getLocation();
            vector.setY((int)vector.getY() + 1);
            Location location2 = vector.toLocation(livingEntity.getWorld());
            location2.setYaw(location.getYaw());
            location2.setPitch(location.getPitch());
            livingEntity.teleport(location2);
        }
    }

    public void gJ() {
        this.qU = (ArmorStand)this.qR.getWorld().spawn(this.qQ.qw.tu(), ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setMarker(true);
            armorStand.setCollidable(false);
            EntityHolder.a(armorStand, false);
            armorStand.setAI(false);
            armorStand.setRemoveWhenFarAway(true);
            armorStand.setCustomName("IA_mount");
            armorStand.setCustomNameVisible(false);
        });
        LivingEntityRegistry.db().lU.add(this.qU.getEntityId());
        EntityHolder.tK().O((Entity)this.qU);
        this.qU.addPassenger((Entity)this.qR);
        this.gK();
    }

    public void gK() {
        if (this.qU == null) {
            return;
        }
        PacketContainer packetContainer = PacketListenerRegistry.aK(this.qU.getEntityId());
        List list = this.gH().ea();
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            PacketListenerRegistry.a(playerBridge_7.iW, packetContainer);
        }
    }

    private void gL() {
        if (this.qW == null) {
            this.qW = new PacketEventHelper();
            this.qW.aM(this.qQ.qw.Yb);
        }
    }

    public void gM() {
        if (this.gG()) {
            this.gL();
            this.qW.a(new int[]{this.qR.getEntityId()});
            List list = this.qQ.qv.ea();
            for (int i = 0; i < list.size(); ++i) {
                PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
                this.qW.cc(playerBridge_7.iW);
            }
        }
    }

    public void gN() {
        if (this.gG()) {
            this.gL();
            this.qW.a(new int[]{this.qR.getEntityId()});
            List list = this.qQ.qv.ea();
            for (int i = 0; i < list.size(); ++i) {
                PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
                if (!playerBridge_7.fr()) continue;
                this.qW.cc(playerBridge_7.iW);
            }
        }
    }

    void gO() {
        this.gL();
        this.qW.a(new int[0]);
        List list = this.qQ.qv.ea();
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            this.qW.cc(playerBridge_7.iW);
        }
    }

    public void gk() {
        if (this.qU == null) {
            return;
        }
        this.qX = this.qQ.qv.ed().getYaw();
        this.qY = this.qQ.qv.ed().getPitch();
        this.qZ = this.qQ.qw.tu();
        EntityHolder.tK().a((Entity)this.qU, this.qZ.getX(), this.qZ.getY(), this.qZ.getZ(), this.qX, this.qY, false);
        this.qQ.qw.q(this.qX);
    }

    public void bV() {
        if (this.qZ == null) {
            return;
        }
        EntityHolder.tK().b((Entity)this.qR, this.qZ.getX(), this.qZ.getY() + 1.213, this.qZ.getZ());
    }

    public void b(Boolean bl) {
        this.qV = bl;
    }

    public boolean isLocked() {
        return this.qV;
    }

    public boolean canControl() {
        return this.qT;
    }

    public void setCanControl(boolean bl) {
        this.qT = bl;
    }

    private /* synthetic */ void f(LivingEntity livingEntity) {
        this.e(livingEntity);
    }
}
