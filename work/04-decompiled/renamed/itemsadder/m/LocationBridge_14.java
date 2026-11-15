package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.LocationBridgeBuilderImpl;
import itemsadder.m.LocationBridgeBuilder_4;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.RecordOfList_2;
import itemsadder.m.RecordOfValue_25;
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

public class LocationBridge_14 {
    protected final List Lp;
    protected final List Lq;
    protected final List Lr;
    protected final HashSet Ls;
    protected final HashSet Lt;
    protected boolean Lu;
    private boolean Lv;

    public LocationBridge_14() {
        this.Lp = new ArrayList();
        this.Lq = new ArrayList();
        this.Lr = new ArrayList();
        this.Ls = new HashSet();
        this.Lt = new HashSet();
    }

    public void c(ItemStackBridge_32 itemStackBridge_32) {
        this.Lp.add(itemStackBridge_32);
    }

    public void a(RecordOfValue_25 recordOfValue_25) {
        this.Lq.add(recordOfValue_25);
    }

    public void a(RecordOfList_2 recordOfList_2) {
        this.Lr.add(recordOfList_2);
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
        for (ItemStackBridge_32 itemStackBridge_32 : this.Lp) {
            ItemStack itemStack2;
            if (!itemStackBridge_32.dy() || (itemStack2 = itemStackBridge_32.b(itemStack, true)).getAmount() <= 0) continue;
            bl = true;
            LocationBridge_4.a(location, itemStack2, player);
            if (!this.Lu) continue;
            return bl;
        }
        return bl;
    }

    public List N(@Nullable ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (ItemStackBridge_32 itemStackBridge_32 : this.Lp) {
            ItemStack itemStack2;
            if (!itemStackBridge_32.dy() || (itemStack2 = itemStackBridge_32.b(itemStack, true)).getAmount() <= 0) continue;
            arrayList.add(itemStack2);
            if (!this.Lu) continue;
            break;
        }
        return arrayList;
    }

    public void c(@Nullable ItemStack itemStack, Location location) {
        for (RecordOfValue_25 recordOfValue_25 : this.Lq) {
            double d = Math.random();
            if (d * 100.0 > (double)recordOfValue_25.dB()) continue;
            ((ExperienceOrb)location.getWorld().spawn(location, ExperienceOrb.class)).setExperience(ColorBridge.v(recordOfValue_25.oN(), recordOfValue_25.oO()));
        }
    }

    public void h(@Nullable Player player, Location location) {
        for (RecordOfList_2 recordOfList_2 : this.Lr) {
            recordOfList_2.e(player, location);
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
    protected LocationBridge_14(LocationBridgeBuilder_4 locationBridgeBuilder_4) {
        this.Lp = locationBridgeBuilder_4.Lw ? locationBridgeBuilder_4.Lx : LocationBridge_14.qr();
        this.Lq = locationBridgeBuilder_4.Ly ? locationBridgeBuilder_4.Lz : LocationBridge_14.qs();
        this.Lr = locationBridgeBuilder_4.LA ? locationBridgeBuilder_4.LB : LocationBridge_14.qt();
        this.Ls = locationBridgeBuilder_4.LC ? locationBridgeBuilder_4.LD : LocationBridge_14.qu();
        this.Lt = locationBridgeBuilder_4.LE ? locationBridgeBuilder_4.LF : LocationBridge_14.qv();
        this.Lu = locationBridgeBuilder_4.Lu;
        this.Lv = locationBridgeBuilder_4.Lv;
    }

    @Generated
    public static LocationBridgeBuilder_4 qw() {
        return new LocationBridgeBuilderImpl();
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
