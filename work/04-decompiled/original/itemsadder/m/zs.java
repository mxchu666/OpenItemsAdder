package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.aaa;
import itemsadder.m.bbh;
import itemsadder.m.bbs;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dp;
import itemsadder.m.kh;
import itemsadder.m.mm;
import itemsadder.m.qm;
import itemsadder.m.rb;
import itemsadder.m.ry;
import itemsadder.m.ub;
import itemsadder.m.uc;
import itemsadder.m.ud;
import itemsadder.m.ue;
import itemsadder.m.ug;
import itemsadder.m.uj;
import itemsadder.m.um;
import itemsadder.m.uo;
import itemsadder.m.up;
import itemsadder.m.wv;
import itemsadder.m.wy;
import itemsadder.m.wz;
import itemsadder.m.xa;
import itemsadder.m.xc;
import itemsadder.m.xd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.TranslatableComponent;

public class zs {
    final d UA;
    final qm UB;
    public final List UC;
    public final List UD;
    public final List UE;
    public final List UF;
    public final List UG;
    public final List UH;
    public final List UI;
    public final List UJ;
    public final List UK;
    public final List UL;

    public zs(d d2, qm qm2) {
        this.UA = d2;
        this.UB = qm2;
        this.UC = new ArrayList();
        this.UD = new ArrayList();
        this.UE = new ArrayList();
        this.UF = new ArrayList();
        this.UG = new ArrayList();
        this.UH = new ArrayList();
        this.UI = new ArrayList();
        this.UJ = new ArrayList();
        this.UK = new ArrayList();
        this.UL = new ArrayList();
        this.sU();
    }

    private static String[] k(String string, int n) {
        String string2 = string.replaceAll("((?:\\w+\\s){" + --n + "}\\w+)(\\s)", "$1\n");
        return string2.split("\n");
    }

    private String[] a(Set set, int n) {
        String string = set.toString().replace("[", "").replace("]", "").replace(",", "");
        String[] stringArray = zs.k(string, n);
        int n2 = stringArray.length;
        for (int i = 0; i < n2; ++i) {
            String string2 = stringArray[i];
            stringArray[i] = string2.replace(" ", ", ");
        }
        return stringArray;
    }

    public void sU() {
        Object object5;
        Object object2;
        Object object32;
        Object object42;
        boolean bl = false;
        for (xa object5 : xa.md) {
            object42 = (List)object5.OO.get(this.UB.Gi);
            if (object42 == null) continue;
            object32 = object42.iterator();
            while (object32.hasNext()) {
                object2 = (wv)object32.next();
                object5 = object5.cE();
                if (object5 == null) continue;
                if (!bl) {
                    this.UC.add(Main.PQ.ir("worlds"));
                }
                bl = true;
                this.UC.add(String.valueOf(ChatColor.AQUA) + object5.getName());
                this.UC.add(Main.PQ.ir("chance").replace("{value}", "" + ((wv)object2).On));
                this.UC.add(Main.PQ.ir("amount").replace("{value}", "" + ((wv)object2).Oj));
                this.UC.add(Main.PQ.ir("min-height").replace("{value}", "" + ((wv)object2).Om));
                this.UC.add(Main.PQ.ir("max-height").replace("{value}", "" + ((wv)object2).Ol));
                if (((wv)object2).Oo.isEmpty()) continue;
                this.UC.add(Main.PQ.ir("biome"));
                for (String string : this.a(((wv)object2).Oo, 3)) {
                    this.UC.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                }
            }
        }
        for (xc xc2 : xc.md) {
            object42 = (List)xc2.OO.get(this.UB.Gi);
            if (object42 == null) continue;
            object32 = object42.iterator();
            while (object32.hasNext()) {
                object2 = (wy)object32.next();
                object5 = xc2.cE();
                if (object5 == null) continue;
                if (!bl) {
                    this.UD.add(Main.PQ.ir("worlds"));
                }
                bl = true;
                this.UD.add(String.valueOf(ChatColor.AQUA) + object5.getName());
                this.UD.add(Main.PQ.ir("chance").replace("{value}", "" + ((wy)object2).On));
                this.UD.add(Main.PQ.ir("amount").replace("{value}", "" + ((wy)object2).Oj));
                this.UD.add(Main.PQ.ir("min-height").replace("{value}", "" + ((wy)object2).Om));
                this.UD.add(Main.PQ.ir("max-height").replace("{value}", "" + ((wy)object2).Ol));
                if (((wy)object2).Oo.isEmpty()) continue;
                this.UD.add(Main.PQ.ir("biome"));
                for (String string : this.a(((wy)object2).Oo, 3)) {
                    this.UD.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                }
            }
        }
        for (xd xd2 : xd.md) {
            for (Object object32 : xd2.Ow) {
                object2 = xd2.cE();
                if (object2 == null || !this.UB.l(((wz)object32).OI) && !this.UB.l(((wz)object32).OJ)) continue;
                if (!bl) {
                    this.UE.add(Main.PQ.ir("worlds"));
                }
                bl = true;
                this.UE.add(String.valueOf(ChatColor.AQUA) + object2.getName());
                this.UE.add(Main.PQ.ir("chance").replace("{value}", "" + ((wz)object32).On));
                this.UE.add(Main.PQ.ir("amount").replace("{value}", "" + ((wz)object32).Oj));
                this.UE.add(Main.PQ.ir("min-height").replace("{value}", "" + ((wz)object32).Om));
                this.UE.add(Main.PQ.ir("max-height").replace("{value}", "" + ((wz)object32).Ol));
                if (((wz)object32).Oo.size() <= 0) continue;
                this.UE.add(Main.PQ.ir("biome"));
                for (String string : this.a(((wz)object32).Oo, 3)) {
                    this.UE.add(String.valueOf(ChatColor.GRAY) + "     " + (String)string);
                }
            }
        }
        for (rb rb2 : this.UA.I.values()) {
            for (Object object32 : rb2.Hs) {
                if (!((ry)object32).oQ() || !this.UB.l(((ry)object32).oP())) continue;
                this.UF.add(String.valueOf(ChatColor.AQUA) + rb2.getItemMeta().getDisplayName());
                this.UF.add(Main.PQ.ir("chance").replace("{value}", "" + ((ry)object32).oT()));
                if (((ry)object32).oR() == ((ry)object32).oS()) {
                    this.UF.add(Main.PQ.ir("amount").replace("{value}", "" + ((ry)object32).oR()));
                    continue;
                }
                this.UF.add(Main.PQ.ir("amount").replace("{value}", ((ry)object32).oR() + "-" + ((ry)object32).oS()));
            }
        }
        for (Map.Entry entry : this.UA.aq.Lc.entrySet()) {
            for (Object object32 : (List)entry.getValue()) {
                for (Object object5 : ((ug)object32).qx()) {
                    if (!((ry)object5).oQ() || !this.UB.l(((ry)object5).oP())) continue;
                    if (aaa.Vc) {
                        this.UI.add(String.valueOf(ChatColor.AQUA) + "TRANSLATE_" + bbs.Z(((uo)object32).nM()));
                    } else {
                        this.UI.add(String.valueOf(ChatColor.AQUA) + bbs.Y(((uo)object32).nM()));
                    }
                    if (!((ug)object32).qA().isEmpty()) {
                        this.UI.add(Main.PQ.ir("biome"));
                        for (String string : this.a(((ug)object32).qA(), 3)) {
                            this.UI.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                        }
                    }
                    this.UI.add(Main.PQ.ir("chance").replace("{value}", "" + ((ry)object5).oT()));
                    if (((ry)object5).oR() == ((ry)object5).oS()) {
                        this.UI.add(Main.PQ.ir("amount").replace("{value}", "" + ((ry)object5).oR()));
                        continue;
                    }
                    this.UI.add(Main.PQ.ir("amount").replace("{value}", ((ry)object5).oR() + "-" + ((ry)object5).oS()));
                }
            }
        }
        for (Map.Entry entry : this.UA.aq.Ld.entrySet()) {
            for (Object object32 : (List)entry.getValue()) {
                for (Object object5 : ((ug)object32).qx()) {
                    if (!((ry)object5).oQ() || !this.UB.l(((ry)object5).oP())) continue;
                    this.UI.add(String.valueOf(ChatColor.AQUA) + ((ub)object32).ln().getItemMeta().getDisplayName());
                    if (!((ug)object32).qA().isEmpty()) {
                        this.UI.add(Main.PQ.ir("biome"));
                        for (String string : this.a(((ug)object32).qA(), 3)) {
                            this.UI.add(String.valueOf(ChatColor.GRAY) + "     " + string);
                        }
                    }
                    this.UI.add(Main.PQ.ir("chance").replace("{value}", "" + ((ry)object5).oT()));
                    if (((ry)object5).oR() == ((ry)object5).oS()) {
                        this.UI.add(Main.PQ.ir("amount").replace("{value}", "" + ((ry)object5).oR()));
                        continue;
                    }
                    this.UI.add(Main.PQ.ir("amount").replace("{value}", ((ry)object5).oR() + "-" + ((ry)object5).oS()));
                }
            }
        }
        for (ue ue2 : this.UA.aq.Le) {
            for (Object object32 : ue2.qx()) {
                if (!((ry)object32).oQ() || !this.UB.l(((ry)object32).oP())) continue;
                if (!ue2.qA().isEmpty()) {
                    this.UK.add(Main.PQ.ir("biome"));
                    for (String string : this.a(ue2.qA(), 3)) {
                        this.UK.add(String.valueOf(ChatColor.GRAY) + "     " + (String)string);
                    }
                }
                this.UK.add(Main.PQ.ir("chance").replace("{value}", "" + ((ry)object32).oT()));
            }
        }
        for (ud ud2 : this.UA.aq.Lf) {
            for (Object object32 : ud2.qx()) {
                if (!((ry)object32).oQ() || !this.UB.l(((ry)object32).oP())) continue;
                if (ud2 instanceof up) {
                    dp dp2;
                    object2 = (up)ud2;
                    Optional optional = ud2.cu("ItemsAdderEntity");
                    if (optional.isPresent() && da.P() && (dp2 = da.db().am((String)((uj)optional.get()).qD())) != null) {
                        String string = ChatColor.stripColor((String)dp2.nQ);
                        this.UG.add(String.valueOf(ChatColor.AQUA) + string);
                        this.a((up)object2);
                    }
                }
                if (ud2 instanceof uc) {
                    object2 = (uc)ud2;
                    this.UG.add(String.valueOf(ChatColor.AQUA) + ((uc)object2).nL());
                    this.a((uc)object2);
                }
                if (!ud2.qA().isEmpty()) {
                    this.UG.add(Main.PQ.ir("biome"));
                    for (String string : this.a(ud2.qA(), 3)) {
                        this.UG.add(String.valueOf(ChatColor.GRAY) + "     " + (String)string);
                    }
                }
                this.UG.add(Main.PQ.ir("chance").replace("{value}", "" + ((ry)object32).oT()));
                for (um um2 : ud2.qF()) {
                    this.UG.add(Main.PQ.ir("nbt-rule").replace("{rule}", um2.qH()).replace("{value}", String.valueOf(um2.qI())));
                }
            }
        }
        if (this.UB.Ge.bm("vehicle")) {
            kh kh2 = (kh)this.UB.Ge.bn("vehicle");
            assert (kh2 != null);
            for (Object object42 : kh2.zh) {
                if (((mm)object42).itemStack.hasItemMeta()) {
                    this.UL.add(Main.PQ.ir("fuel-item").replace("{type}", ChatColor.stripColor((String)((mm)object42).itemStack.getItemMeta().getDisplayName())).replace("{amount}", "" + ((mm)object42).BG));
                    continue;
                }
                this.UL.add(Main.PQ.ir("fuel-item").replace("{type}", bbs.a(((mm)object42).itemStack, ChatColor.GRAY)).replace("{amount}", "" + ((mm)object42).BG));
            }
        }
        if (aaa.Vc) {
            this.a(this.UI, this.UJ);
            this.a(this.UG, this.UH);
        }
    }

    private void a(uc uc2) {
        if (!da.P()) {
            return;
        }
        dp dp2 = (dp)da.db().lJ.get(uc2.nL());
        if (dp2 == null) {
            return;
        }
        this.UG.add(dp2.nQ);
    }

    private void a(up up2) {
        if (aaa.Vc) {
            this.UG.add(String.valueOf(ChatColor.AQUA) + "TRANSLATE_" + bbh.o(up2.getType()));
        } else {
            this.UG.add(String.valueOf(ChatColor.AQUA) + bbh.n(up2.getType()));
        }
    }

    private void a(List list, List list2) {
        for (String string : list) {
            Object object;
            if (string.contains("TRANSLATE_")) {
                object = ChatColor.stripColor((String)string).replace("TRANSLATE_", "");
                BaseComponent[] baseComponentArray = TextComponent.fromLegacyText((String)string);
                ChatColor chatColor = baseComponentArray[0].getColor();
                baseComponentArray[0] = new TranslatableComponent((String)object, new Object[0]);
                baseComponentArray[0].setColor(chatColor);
                baseComponentArray[0].setItalic(Boolean.valueOf(false));
                list2.add(baseComponentArray);
                continue;
            }
            object = TextComponent.fromLegacyText((String)string);
            for (int i = 0; i < ((BaseComponent[])object).length; ++i) {
                object[i].setItalic(Boolean.valueOf(false));
            }
            list2.add(object);
        }
        if (!list.isEmpty()) {
            list.clear();
            list.add("dummy");
        }
    }
}
