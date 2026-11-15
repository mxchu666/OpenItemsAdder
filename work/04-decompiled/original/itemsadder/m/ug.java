package itemsadder.m;

import itemsadder.m.bcy;
import itemsadder.m.bdf;
import itemsadder.m.ru;
import itemsadder.m.rx;
import itemsadder.m.ry;
import itemsadder.m.uh;
import itemsadder.m.ui;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ug {
    protected final List Lp;
    protected final List Lq;
    protected final List Lr;
    protected final HashSet Ls;
    protected final HashSet Lt;
    protected boolean Lu;
    private boolean Lv;

    public ug() {
        this.Lp = new ArrayList();
        this.Lq = new ArrayList();
        this.Lr = new ArrayList();
        this.Ls = new HashSet();
        this.Lt = new HashSet();
    }

    public void c(ry ry2) {
        this.Lp.add(ry2);
    }

    public void a(rx rx2) {
        this.Lq.add(rx2);
    }

    public void a(ru ru2) {
        this.Lr.add(ru2);
    }

    public void U(Location location) {
        this.g(null, location);
    }

    public boolean g(@Nullable Player player, Location location) {
        boolean bl = false;
        ItemStack itemStack = null;
        if (player != null) {
            itemStack = player.getInventory().getItemInMainHand();
        }
        bl = this.b(player, itemStack, location);
        this.c(itemStack, location);
        this.h(player, location);
        return bl;
    }

    public boolean b(@Nullable Player player, @Nullable ItemStack itemStack, Location location) {
        boolean bl = false;
        for (ry ry2 : this.Lp) {
            ItemStack itemStack2;
            if (!ry2.dy() || (itemStack2 = ry2.b(itemStack, true)).getAmount() <= 0) continue;
            bl = true;
            bdf.a(location, itemStack2, player);
            if (!this.Lu) continue;
            return bl;
        }
        return bl;
    }

    public List N(@Nullable ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (ry ry2 : this.Lp) {
            ItemStack itemStack2;
            if (!ry2.dy() || (itemStack2 = ry2.b(itemStack, true)).getAmount() <= 0) continue;
            arrayList.add(itemStack2);
            if (!this.Lu) continue;
            break;
        }
        return arrayList;
    }

    public void c(@Nullable ItemStack itemStack, Location location) {
        for (rx rx2 : this.Lq) {
            double d = Math.random();
            if (d * 100.0 > (double)rx2.dB()) continue;
            ((ExperienceOrb)location.getWorld().spawn(location, ExperienceOrb.class)).setExperience(bcy.v(rx2.oN(), rx2.oO()));
        }
    }

    public void h(@Nullable Player player, Location location) {
        for (ru ru2 : this.Lr) {
            ru2.e(player, location);
        }
    }

    public void d(NamespacedKey namespacedKey) {
        this.Ls.add(namespacedKey);
    }

    public boolean a(Biome biome) {
        if (biome == null) {
            return false;
        }
        if (this.Ls.isEmpty()) {
            return true;
        }
        try {
            return this.Ls.contains(biome.getKey());
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    public boolean i(World world) {
        if (this.Lt.isEmpty()) {
            return true;
        }
        String string = world.getName();
        if (this.Lt.contains(string)) {
            return true;
        }
        if (this.Lv) {
            for (String string2 : this.Lt) {
                if (!string2.endsWith("*")) continue;
                if ((string2 = string2.substring(0, string2.length() - 1)).startsWith("!")) {
                    if (!string.startsWith(string2 = string2.substring(1))) continue;
                    return false;
                }
                if (!string.startsWith(string2)) continue;
                return true;
            }
        }
        return false;
    }

    public void cv(String string) {
        if (string.endsWith("*")) {
            this.Lv = true;
        }
        this.Lt.add(string);
    }

    @Generated
    private static List qr() {
        return new ArrayList();
    }

    @Generated
    private static List qs() {
        return new ArrayList();
    }

    @Generated
    private static List qt() {
        return new ArrayList();
    }

    @Generated
    private static HashSet qu() {
        return new HashSet();
    }

    @Generated
    private static HashSet qv() {
        return new HashSet();
    }

    @Generated
    protected ug(uh uh2) {
        this.Lp = uh2.Lw ? uh2.Lx : ug.qr();
        this.Lq = uh2.Ly ? uh2.Lz : ug.qs();
        this.Lr = uh2.LA ? uh2.LB : ug.qt();
        this.Ls = uh2.LC ? uh2.LD : ug.qu();
        this.Lt = uh2.LE ? uh2.LF : ug.qv();
        this.Lu = uh2.Lu;
        this.Lv = uh2.Lv;
    }

    @Generated
    public static uh qw() {
        return new ui();
    }

    @Generated
    public List qx() {
        return this.Lp;
    }

    @Generated
    public List qy() {
        return this.Lq;
    }

    @Generated
    public List qz() {
        return this.Lr;
    }

    @Generated
    public HashSet qA() {
        return this.Ls;
    }

    @Generated
    public void aA(boolean bl) {
        this.Lu = bl;
    }

    @Generated
    public boolean qB() {
        return this.Lu;
    }
}
