package itemsadder.m;

import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityDamageListenerBase;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener;
import itemsadder.m.RecordOfString_6;
import itemsadder.m.SoundCategoryBridge_2;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;

public class PlayerBukkitTaskHolder {
    public Player iW;
    public LivingEntityBuilder renderer;
    private final boolean li;
    public AtomicBoolean lj;
    @Nullable
    private Float lk;
    @Nullable
    private Float ll;
    @Nullable
    BukkitTask lm;
    @Nullable
    RecordOfString_6 ln;

    public PlayerBukkitTaskHolder(Player player, LivingEntityBuilder livingEntityBuilder, boolean bl) {
        this.iW = player;
        this.renderer = livingEntityBuilder;
        this.li = bl;
        this.lj = new AtomicBoolean();
    }

    public void cY() {
        SoundCategoryBridge_2 soundCategoryBridge_2;
        if (this.renderer.mN != null && this.renderer.mN.qb != null && this.renderer.mN.qb.oN) {
            EntityDamageListenerBase.ul().i(this.iW, this.iW.getLocation().add(0.0, 1.5, 0.0));
        }
        PlayerJoinListener.tf().bC(this.iW);
        this.renderer.eO();
        if (this.li && (soundCategoryBridge_2 = this.renderer.mN.qb) != null) {
            if (!soundCategoryBridge_2.oM) {
                BukkitTaskBridge.i(() -> PlayerHolder_4.bY(this.iW));
            } else {
                this.lk = Float.valueOf(this.iW.getWalkSpeed());
                this.ll = Float.valueOf(this.iW.getFlySpeed());
                if (soundCategoryBridge_2.oW != null) {
                    this.iW.setWalkSpeed(soundCategoryBridge_2.oW.floatValue());
                }
                if (soundCategoryBridge_2.oX != null) {
                    this.iW.setFlySpeed(soundCategoryBridge_2.oX.floatValue());
                }
                this.ln = soundCategoryBridge_2.fM();
                if (this.ln != null) {
                    if (this.ln.fR() > 0.0f) {
                        this.lm = BukkitTaskBridge.b(bukkitRunnable -> LocationBridge_3.a(this.iW.getLocation(), this.ln.fN(), this.ln.fO(), this.ln.fP(), this.ln.fQ()), 0L, (long)(this.ln.fR() * 20.0f));
                    } else {
                        LocationBridge_3.a(this.iW.getLocation(), this.ln.fN(), this.ln.fO(), this.ln.fP(), this.ln.fQ());
                    }
                }
            }
        }
        if (this.renderer.my.fu() > 0.0f) {
            if (this.ll == null) {
                this.ll = Float.valueOf(this.iW.getFlySpeed());
            }
            this.iW.setFlySpeed(this.renderer.my.fu());
            this.iW.setAllowFlight(true);
            this.iW.setFlying(true);
        }
    }

    public void cZ() {
        EntityDamageListenerBase.ul().aN(this.iW);
        if (this.lk != null) {
            this.iW.setWalkSpeed(this.lk.floatValue());
        }
        if (this.ll != null) {
            this.iW.setFlySpeed(this.ll.floatValue());
        }
        PlayerJoinListener.tf().bD(this.iW);
        if (this.lj.get()) {
            return;
        }
        this.lj.set(true);
        if (this.li) {
            PlayerHolder_4.bX(this.iW);
        }
        if (this.renderer.my.fu() > 0.0f) {
            this.iW.setAllowFlight(false);
            this.iW.setFlying(false);
            this.iW.setFlySpeed(this.ll != null ? this.ll.floatValue() : 0.1f);
        }
        if (this.lm != null) {
            this.lm.cancel();
            this.lm = null;
            if (this.ln != null) {
                LocationBridge_3.a(this.iW.getLocation(), this.ln.fO(), this.ln.fN());
            }
        }
        this.iW.updateInventory();
    }
}
