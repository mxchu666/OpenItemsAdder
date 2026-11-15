package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.adb;
import itemsadder.m.ae;
import itemsadder.m.aqp;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.lg;
import itemsadder.m.lv;
import itemsadder.m.lw;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.sd;
import java.util.UUID;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class lu {
    private final Player AJ;
    Block Ae;
    ql Af;
    ItemStack AK;
    ms Ag;
    Vector AL;
    long AM;
    long AN;
    int AO = -1;
    private boolean AP;
    BukkitTask AQ;
    private long AR;
    private long AS;
    private long AT;
    private volatile boolean AU;
    private final UUID AV;
    private final int AW;
    private final int AX;
    private final int AY;
    private final int AZ;

    public lu(Block block, Player player, ql ql2, ms ms2) {
        this.Ae = block;
        this.AJ = player;
        this.Af = ql2;
        this.Ag = ms2;
        this.AL = block.getLocation().toVector();
        this.AV = block.getWorld().getUID();
        this.AW = block.getX();
        this.AX = block.getY();
        this.AY = block.getZ();
        this.AZ = -player.getEntityId();
    }

    public void lv() {
        this.ab(-1);
        this.AK = this.AJ.getInventory().getItemInMainHand();
        this.AS = (long)(this.lB() * 1.0E9f);
        this.AP = this.Af.p(this.AK);
        if (this.AS <= 10000000L) {
            this.lz();
            return;
        }
        this.AT = this.AS / 10L;
        this.AM = 0L;
        this.AN = 0L;
        this.AR = System.nanoTime();
        if (!this.AP) {
            this.aL(this.AJ);
        }
        this.AQ = bcp.b(bukkitRunnable -> {
            if (System.nanoTime() - this.AR <= 500000000L) {
                return;
            }
            this.lx();
        }, 0L, 1L);
    }

    public boolean lw() {
        if (this.AM >= this.AS) {
            this.lz();
            return true;
        }
        if (!this.AK.equals((Object)this.AJ.getInventory().getItemInMainHand())) {
            this.ae(false);
            this.lv();
            return false;
        }
        this.AM += System.nanoTime() - this.AR;
        this.AN += System.nanoTime() - this.AR;
        this.AR = System.nanoTime();
        if (this.AN >= this.AT) {
            ++this.AO;
            this.AN = 0L;
        }
        this.ab(this.AO);
        return false;
    }

    public void lx() {
        this.ae(true);
    }

    public void ae(boolean bl) {
        this.ly();
        this.ab(-1);
        if (bl) {
            lw.lF().ak(this.AJ);
        }
    }

    public void ly() {
        if (this.AQ != null) {
            this.AQ.cancel();
        }
    }

    public void lz() {
        if (this.AU) {
            return;
        }
        Location location = this.Ae.getLocation();
        this.AU = true;
        this.ly();
        if (lw.lF().b(location) || this.Ag.H(location) == null) {
            this.lA();
            return;
        }
        lw.lF().a(location, this);
        bcp.i(() -> {
            if (s.b((HumanEntity)this.AJ, this.Af.kL()) && bcc.a(this.Ae, this.AJ)) {
                lg lg2 = new lg(this.AJ, this.Ae, this.Af, this.Ag);
                lg2.ac(this.AP);
                lv lv2 = this.a(this.AJ, lg2);
                if (lv2 == lv.CANCEL) {
                    if (this.Ae.getType().getHardness() == 0.0f) {
                        this.Af.e(this.Ae, false);
                    }
                } else {
                    CustomBlockBreakEvent customBlockBreakEvent = new CustomBlockBreakEvent(this.AJ, this.Ae, this.Af);
                    customBlockBreakEvent.setCancelled(lg2.isCancelled());
                    if (bev.b((Event)customBlockBreakEvent) && bev.b(lg2)) {
                        bcp.i(() -> qm.a(1, this.AJ));
                    }
                }
            }
            lw.lF().b(location, this);
            this.lA();
        });
    }

    private void lA() {
        bcp.b(() -> this.ab(-1), 2L);
        lw.lF().ak(this.AJ);
    }

    private lv a(Player player, lg lg2) {
        lv lv2 = lv.RIGHT_TOOL;
        if (player.getGameMode() == GameMode.CREATIVE) {
            lv2 = lv.CREATIVE_ALLOW;
        }
        if (!ae.fp && !ae.fq) {
            lv2 = lv.WRONG_BUT_DO_NOTHING;
        }
        if (!this.AP) {
            if (this.aL(player)) {
                lv2 = lv.MSG;
            }
            if (ae.fp) {
                if (lg2 != null) {
                    lg2.setCancelled(true);
                }
                lv2 = lv.CANCEL;
            }
            if (lg2 != null) {
                lg2.ac(false);
            }
        }
        return lv2;
    }

    private boolean aL(Player player) {
        if (ae.fq) {
            adb.i(player, Main.PQ.ir("cannot-break-with-this-tool"));
            return true;
        }
        return false;
    }

    private void ab(int n) {
        if (this.Af.Hq == sd.ENTITY) {
            d.g().X.a(this.AV, this.AW, this.AX, this.AY, this.AZ, n);
        } else {
            lu.a(this.AJ, this.AL, n, this.AZ);
        }
    }

    public static void a(Player player, Vector vector, int n, int n2) {
        aqp.a(player, vector, n, n2);
    }

    public float lB() {
        int n;
        float f2 = this.Af.FG;
        float f3 = 0.0f;
        float f4 = 1.0f;
        this.AP = this.Af.p(this.AK);
        f3 = this.AP ? f2 * 0.75f : f2 * 5.0f;
        if (this.AP) {
            f4 = bbs.ar(this.AK) / 1.5f;
        }
        if (!this.AP && !bbs.U(this.AK.getType())) {
            f4 = 0.2f;
        }
        if (this.AP && this.AK.hasItemMeta() && (n = this.AK.getItemMeta().getEnchantLevel(Enchantment.EFFICIENCY)) > 0) {
            f4 += (float)(n * n + 1);
        }
        if (this.AJ.hasPotionEffect(PotionEffectType.HASTE)) {
            f4 *= (float)(1.0 + 0.2 * (double)this.AJ.getPotionEffect(PotionEffectType.HASTE).getAmplifier());
        }
        if (this.AJ.hasPotionEffect(PotionEffectType.MINING_FATIGUE)) {
            f4 /= (float)(3 ^ this.AJ.getPotionEffect(PotionEffectType.MINING_FATIGUE).getAmplifier());
        }
        f3 /= f4;
        if (this.AJ.isInWater()) {
            f3 *= 5.0f;
        }
        return f3;
    }
}
