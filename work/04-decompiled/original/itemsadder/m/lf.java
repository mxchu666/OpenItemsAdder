package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import itemsadder.m.kh;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class lf {
    public kh zW;
    public Entity zX;
    public ArmorStand zY;
    public NItem zZ;
    public Long Aa;
    public double Ab;
    public Vector zj;
    public Location Ac;
    double Ad;
    BukkitTask kH;

    public lf(kh kh2, ArmorStand armorStand, Entity entity, NItem nItem, Long l) {
        this.zW = kh2;
        this.zY = armorStand;
        this.zX = entity;
        this.zZ = nItem;
        this.Aa = l;
        this.zj = kh2.kX().clone();
        this.Ab = armorStand.getLocation().getYaw();
        this.Ac = armorStand.getLocation().clone();
    }

    public void z(Location location) {
        if (Math.abs(this.zY.getVelocity().getX()) > (double)0.35f || Math.abs(this.zY.getVelocity().getY()) > (double)0.35f || Math.abs(this.zY.getVelocity().getZ()) > (double)0.35f) {
            return;
        }
        this.Ad = Math.toRadians(location.getYaw());
        this.Ac.setX(location.getX() + this.zj.getX() * Math.cos(this.Ad) + this.zj.getZ() * -Math.sin(this.Ad));
        this.Ac.setY(location.getY() + this.zj.getY());
        this.Ac.setZ(location.getZ() + this.zj.getX() * Math.sin(this.Ad) + this.zj.getZ() * Math.cos(this.Ad));
        location.getWorld().spawnParticle(Particle.SMOKE, this.Ac.getX(), this.Ac.getY(), this.Ac.getZ(), this.zW.kY(), 0.0, 0.0, 0.0, 0.0);
    }

    public void lk() {
        if (this.zW.kY() <= 0) {
            return;
        }
        this.kH = Bukkit.getScheduler().runTaskTimer((Plugin)Main.rS(), () -> {
            if (this.zY.getPassenger() == null) {
                this.ll();
            } else {
                this.z(this.zY.getLocation());
            }
        }, 5L, 10L);
    }

    public void ll() {
        if (this.zW.kY() <= 0) {
            return;
        }
        if (this.kH != null) {
            this.kH.cancel();
        }
    }
}
