package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.bk;
import dev.lone.itemsadder.resourcepack.e;
import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.sd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class f {
    private static f aqv;
    public static int aqw;
    public static int aqx;
    public static int aqy;
    public static int aqz;
    public static int aqA;
    public static int aqB;
    private final d aqC;
    public bbf aqD;
    public bbf aqE;
    public bbf aqF;
    public bbf aqG;
    public bbf aqH;
    public bbf aqI;
    public final Map aqJ = new HashMap();
    private int aqK;
    private int aqL;
    private int aqM;
    private int aqN;
    private int aqO;
    private Map aqP = Collections.emptyMap();
    private Map aqQ;
    private final Map aqR = new TreeMap();
    private final Set aqS = new TreeSet();
    private volatile boolean aqT;

    public f() {
        aqv = this;
        this.aqC = d.g();
    }

    public static f xl() {
        if (aqv == null) {
            aqv = new f();
        }
        return aqv;
    }

    public void init() {
        this.xn();
        Main main = Main.rS();
        this.aqD = new bbf((Plugin)main, true, "storage/items_ids_cache.yml", false, false, Character.valueOf('~'));
        this.aqE = new bbf((Plugin)main, true, "storage/real_blocks_ids_cache.yml", false, false);
        this.aqF = new bbf((Plugin)main, true, "storage/real_blocks_note_ids_cache.yml", false, false);
        this.aqG = new bbf((Plugin)main, true, "storage/real_transparent_blocks_ids_cache.yml", false, false);
        this.aqH = new bbf((Plugin)main, true, "storage/real_wire_ids_cache.yml", false, false);
        this.aqI = new bbf((Plugin)main, true, "storage/custom_fires_ids_cache.yml", false, false);
        this.xr();
    }

    public void xm() {
        this.aqQ = new HashMap();
        this.aqR.clear();
        this.aqS.clear();
        this.aqT = false;
    }

    public void xn() {
        this.aqQ = null;
        this.aqR.clear();
        this.aqS.clear();
        this.aqT = false;
    }

    public void xo() {
        if (this.aqQ == null) {
            return;
        }
        this.aqP = Map.copyOf(this.aqQ);
        this.aqQ = null;
        this.aqT = true;
        this.xs();
    }

    public boolean xp() {
        return this.aqT;
    }

    private void a(bbf bbf2, String string, int n) {
        if (this.aqQ != null) {
            this.aqQ.put(f.a(bbf2, string), n);
        }
    }

    private boolean b(bbf bbf2, String string, int n) {
        return Objects.equals(this.aqP.get(f.a(bbf2, string)), n);
    }

    private static String a(bbf bbf2, String string) {
        return bbf2.nh() + "\u0000" + string;
    }

    public void sJ() {
        this.aqK = this.xu();
        this.aqM = this.xw();
        this.aqL = this.xv();
        this.aqN = this.xy();
        this.aqO = this.xx();
        int n = this.aqC.al.hW();
        if (ae.ar()) {
            int n2 = 0;
            for (ql ql2 : d.g().S) {
                if (ql2.FD == null || !ql2.FD.oX()) continue;
                ++n2;
            }
            bce.log(String.valueOf(ChatColor.GRAY) + "Used Blocks IDs:");
            if (ae.cG) {
                bce.log(String.valueOf(ChatColor.GRAY) + " - REAL " + String.valueOf(ChatColor.AQUA) + this.aqK + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "188");
            }
            if (ae.cI) {
                bce.log(String.valueOf(ChatColor.GRAY) + " - REAL_NOTE " + String.valueOf(ChatColor.AQUA) + this.aqL + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "750");
            }
            if (ae.cH) {
                bce.log(String.valueOf(ChatColor.GRAY) + " - REAL_TRANSPARENT " + String.valueOf(ChatColor.AQUA) + this.aqM + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "63");
            }
            if (ae.cJ) {
                bce.log(String.valueOf(ChatColor.GRAY) + " - REAL_WIRE " + String.valueOf(ChatColor.AQUA) + this.aqN + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "127");
            }
            if (ae.cK) {
                bce.log(String.valueOf(ChatColor.GRAY) + " - FIRE " + String.valueOf(ChatColor.AQUA) + this.aqO + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + "14");
            }
            if (n2 > 0) {
                bce.log(String.valueOf(ChatColor.GRAY) + " - Directional states: " + String.valueOf(ChatColor.AQUA) + n2);
            }
        }
        bce.log(String.valueOf(ChatColor.GRAY) + "Used Font Images: " + String.valueOf(ChatColor.AQUA) + n + String.valueOf(ChatColor.GRAY) + "/" + String.valueOf(ChatColor.AQUA) + this.aqC.al.uj);
    }

    public void xq() {
        this.aqD.save();
        this.aqE.save();
        this.aqF.save();
        this.aqG.save();
        this.aqH.save();
        this.aqI.save();
        this.xr();
    }

    private void xr() {
        aqw = this.aqD.gW("PLAYER_HEAD" + this.aqD.CL() + "__manually_handled:_iainternal__player_phead_0");
        aqx = this.aqD.gW("PLAYER_HEAD" + this.aqD.CL() + "__manually_handled:_iainternal__player_parm_left_3");
        aqy = this.aqD.gW("PLAYER_HEAD" + this.aqD.CL() + "__manually_handled:_iainternal__player_pbody_2");
        aqz = this.aqD.gW("PLAYER_HEAD" + this.aqD.CL() + "__manually_handled:_iainternal__player_pleg_left_1");
        aqA = this.aqD.gW("PLAYER_HEAD" + this.aqD.CL() + "__manually_handled:_iainternal__player_pleg_right_5");
        aqB = this.aqD.gW("PLAYER_HEAD" + this.aqD.CL() + "__manually_handled:_iainternal__player_parm_right_4");
    }

    public static int eb(String string) {
        return switch (string) {
            case "phead_0" -> aqw;
            case "parm_left_3" -> aqx;
            case "pbody_2" -> aqy;
            case "pleg_left_1" -> aqz;
            case "pleg_right_5" -> aqA;
            case "parm_right_4" -> aqB;
            default -> -1;
        };
    }

    public int a(Material material, sd sd2, String string, String string2) {
        if (sd2 == sd.TILE) {
            return this.a(material, string, string2);
        }
        return this.a(sd2, string, string2);
    }

    public int a(sd sd2, String string, String string2) {
        int n;
        ArrayList arrayList;
        int n2;
        int n3;
        int n4;
        bbf bbf2;
        String string3 = string + ":" + string2;
        int[] nArray = new int[]{};
        switch (sd2) {
            case REAL: {
                bbf2 = this.aqE;
                n4 = 0;
                n3 = 190;
                nArray = new int[]{63, 127};
                break;
            }
            case REAL_TRANSPARENT: {
                bbf2 = this.aqG;
                n4 = 193;
                n3 = 254;
                break;
            }
            case REAL_NOTE: {
                bbf2 = this.aqF;
                n4 = 256;
                n3 = 1005;
                if (!bbf2.gP(string3) || !this.aqJ.containsKey(n2 = bbf2.gW(string3))) break;
                bce.warn("Warning: block id '" + n2 + "' for type '" + String.valueOf((Object)sd2) + "' of block '" + string3 + "' is already used by your customized blockstates " + Arrays.toString(sd2.pf()) + " file. Entry: '" + (String)this.aqJ.get(n2) + "'");
                bbf2.gQ(string3);
                break;
            }
            case FIRE: {
                bbf2 = this.aqI;
                n4 = 1;
                n3 = 15;
                break;
            }
            case REAL_WIRE: {
                bbf2 = this.aqH;
                n4 = 1008;
                n3 = 1135;
                break;
            }
            default: {
                return -1;
            }
        }
        if (bbf2.gP(string3)) {
            n2 = bbf2.gW(string3);
            this.a(bbf2, string3, n2);
            return n2;
        }
        Map map = bbf2.gS("");
        ArrayList<Object> arrayList2 = arrayList = map == null ? new ArrayList() : new ArrayList(map.values());
        if (sd2 == sd.REAL_NOTE) {
            arrayList.addAll(this.aqJ.keySet());
        }
        if ((n = e.a(arrayList, n4, n3, nArray)) == -1) {
            return -1;
        }
        bbf2.d(string3, n);
        this.a(bbf2, string3, n);
        return n;
    }

    public int a(Material material, String string, String string2) {
        String string3 = material.toString();
        int n = this.N(material);
        String string4 = string3 + this.aqD.CL() + string + ":" + string2;
        if (this.aqD.gP(string4)) {
            int n2 = this.aqD.gW(string4);
            this.a(this.aqD, string4, n2);
            return n2;
        }
        List list = this.aqD.gU(string3);
        int n3 = e.a(list == null ? Collections.emptyList() : list, n, Integer.MAX_VALUE, new int[0]);
        if (n3 == -1) {
            return -1;
        }
        this.aqD.d(string4, n3);
        this.a(this.aqD, string4, n3);
        return n3;
    }

    private int N(Material material) {
        return Main.KO.t("resource-pack.items.CustomModelData-starting-value." + String.valueOf(material), Main.KO.t("resource-pack.items.CustomModelData-starting-value.ALL", 100000));
    }

    public int a(Material material, String string2, String string3, int n, boolean bl, String string4) {
        String string5 = material.toString();
        String string6 = string2 + ":" + string3;
        String string7 = string5 + this.aqD.CL() + string6;
        boolean bl2 = this.aqD.gP(string7);
        if (bl2 && this.aqD.gW(string7) == n) {
            this.a(this.aqD, string7, n);
            return n;
        }
        Map map = this.aqD.gS(string5);
        if (map != null && map.containsValue(n)) {
            String string8 = String.valueOf(bcy.c(map, (Object)n));
            String string9 = String.valueOf(material) + "/" + n + " reserved by " + string8;
            this.aqR.computeIfAbsent(string9, string -> new TreeSet()).add(string6);
            this.aqS.add(string4);
            bk.k("Custom model data collisions", "Material/CMD: " + String.valueOf(material) + "/" + n + "\nRequested by: " + string6 + "\nFile: " + string4 + "\nReserved in storage/items_ids_cache.yml by: " + string8);
            if (bl2) {
                this.a(this.aqD, string7, this.aqD.gW(string7));
            }
            return -1;
        }
        this.aqD.d(string7, n);
        this.a(this.aqD, string7, n);
        if (bl) {
            this.aqD.save();
        }
        return n;
    }

    private void xs() {
        if (this.aqR.isEmpty()) {
            return;
        }
        int n = this.aqR.values().stream().mapToInt(Set::size).sum();
        StringBuilder stringBuilder = new StringBuilder("[Items] ").append(n).append(" item").append(n == 1 ? "" : "s").append(" could not be loaded because ").append(this.aqR.size()).append(" manually assigned custom_model_data value").append(this.aqR.size() == 1 ? " is" : "s are").append(" already used by other items in the ID cache.\nFiles containing conflicting items:");
        this.aqS.forEach(string -> stringBuilder.append("\n  - ").append((String)string));
        stringBuilder.append("\nChange or remove the custom_model_data value from each conflicting item.").append("\nIf the previous items were removed, run '/iacleancache items' to remove their unused IDs, then generate the pack again.").append("\nFull details: ItemsAdder/output/resource-pack-diagnostics.txt");
        bce.error(stringBuilder.toString());
    }

    public void xt() {
        this.aqD.save();
    }

    public int xu() {
        return this.aqE.CK().size();
    }

    public int xv() {
        return this.aqF.CK().size();
    }

    public int xw() {
        return this.aqG.CK().size();
    }

    public int xx() {
        return this.aqI.CK().size();
    }

    public int xy() {
        return this.aqH.CK().size();
    }

    public int xz() {
        return this.aqK;
    }

    public int xA() {
        return this.aqL;
    }

    public int xB() {
        return this.aqM;
    }

    public int xC() {
        return this.aqN;
    }

    public int xD() {
        return this.aqO;
    }

    public int h(CommandSender commandSender) {
        if (!this.aqT) {
            bce.warn("Cannot clean item IDs because the latest content load did not complete successfully.");
            return 0;
        }
        int n = 0;
        for (String string : this.aqD.CK()) {
            for (String string2 : this.aqD.gR(string)) {
                int n2;
                String string3 = string + this.aqD.CL() + string2;
                if (this.b(this.aqD, string3, n2 = this.aqD.gW(string3))) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "Removed unused or outdated item ID " + string2 + " (" + string + ") with id " + n2 + " from " + this.aqD.nh());
                this.aqD.d(string3, null);
                ++n;
            }
        }
        if (n > 0) {
            this.aqD.save();
        }
        bce.f(commandSender, "Removed " + n + " unused or outdated item IDs from cache. Check console for more info.");
        return n;
    }

    public int xE() {
        if (!this.aqT) {
            bce.warn("Cannot clean block IDs because the latest content load did not complete successfully.");
            return 0;
        }
        int n = 0;
        n += this.i(this.aqE);
        n += this.i(this.aqF);
        n += this.i(this.aqG);
        n += this.i(this.aqH);
        return n += this.i(this.aqI);
    }

    private int i(bbf bbf2) {
        int n = 0;
        for (String string : bbf2.CK()) {
            int n2;
            if (this.b(bbf2, string, n2 = bbf2.gW(string))) continue;
            bce.log(String.valueOf(ChatColor.YELLOW) + "Removed unused or outdated block ID " + string + " with id " + n2 + " from " + bbf2.nh());
            bbf2.d(string, null);
            ++n;
        }
        if (n > 0) {
            bbf2.save();
        }
        return n;
    }

    public void e(Integer n, String string) {
        this.aqJ.put(n, string);
    }

    public void xF() {
        this.aqJ.clear();
    }
}
