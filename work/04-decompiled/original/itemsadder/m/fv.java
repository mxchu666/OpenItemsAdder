package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bec;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.il;
import itemsadder.m.xk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.plugin.Plugin;

public class fv {
    final d ui;
    public final int uj;
    public final List uk = new ArrayList();
    public final List ul = new ArrayList();
    public final LinkedHashMap um = new LinkedHashMap();
    public final HashMap un = new HashMap();
    private final bec uo = new bec();
    private final bec up = new bec();
    public final bbf uq;

    public fv(Plugin plugin, d d2) {
        int n;
        this.ui = d2;
        this.uk.clear();
        for (n = 57344; n < 63488; ++n) {
            this.uk.add(Character.valueOf((char)n));
        }
        for (n = 63536; n <= 63743; ++n) {
            this.uk.add(Character.valueOf((char)n));
        }
        for (n = 10240; n <= 10495; ++n) {
            this.uk.add(Character.valueOf((char)n));
        }
        this.uj = this.uk.size();
        this.uq = new bbf(plugin, true, "storage/font_images_unicode_cache.yml", false, false);
        Map map = this.uq.gS("");
        if (map != null && map.size() > 0) {
            map.forEach((string, object) -> {
                if (object instanceof Integer) {
                    this.uq.gQ((String)string);
                    this.uq.d((String)string, String.valueOf(this.uk.get((Integer)object)));
                }
            });
        }
    }

    public void cy() {
        this.um.clear();
        this.un.clear();
        this.uo.clear();
        this.up.clear();
        this.uq.reload();
    }

    public void hU() {
        for (bbf bbf2 : this.ui.b()) {
            List list = bbf2.gR("font_images");
            if (list == null) {
                if (!ae.em) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No font_images found in file " + bbf2.qd());
                continue;
            }
            String string2 = bbf2.gV("info.namespace");
            for (String string3 : list) {
                if (ae.em) {
                    bce.log("    Detected font image: " + string3);
                }
                if (!bbf2.z("font_images." + string3 + ".enabled", true)) continue;
                String string4 = null;
                if (bbf2.gP("font_images." + string3 + ".manual_character")) {
                    string4 = bbf2.gV("font_images." + string3 + ".manual_character");
                } else if (bbf2.gP("font_images." + string3 + ".symbol") && Objects.equals(string4 = bbf2.gV("font_images." + string3 + ".symbol"), "")) {
                    bce.error("Error: font_image '" + string3 + "' has empty symbol. Please use a valid unicode character or remove the 'symbol'  property.");
                    string4 = null;
                }
                if (string4 != null) {
                    this.c(string2, string3, string4);
                } else {
                    this.q(string2, string3);
                }
                Integer n = null;
                Color color = bcy.iL(bbf2.az("font_images." + string3 + ".shadow.color", null));
                if (color != null) {
                    n = color.asRGB();
                }
                fw fw3 = new fw(bbf2, string2, string3, bbf2.gV("font_images." + string3 + ".path"), bbf2.t("font_images." + string3 + ".y_position", 0), bbf2.t("font_images." + string3 + ".scale_ratio", 0), bbf2.az("font_images." + string3 + ".permission_suffix", bbf2.az("font_images." + string3 + ".permission", null)), bbf2.z("font_images." + string3 + ".show_in_gui", false), bbf2.z("font_images." + string3 + ".shadow", true), n, bbf2.z("font_images." + string3 + ".chat.hover.enabled", true), bbf2.az("font_images." + string3 + ".chat.hover.override_text", null), bbf2.z("font_images." + string3 + ".suggest_in_command", true));
                if (fw3.uu) continue;
                String string5 = this.p(string2, string3);
                if (string5.length() > 2 || string5.length() == 2 && (!fw.d(string5.charAt(0)) || !fw.d(string5.charAt(1)))) {
                    string5 = this.p(string2, string3);
                    bce.error("Error: font_image '" + string3 + "' has a bad symbol. Some emojis are not supported, and you can use only 1 character.\nForcing usage of another unicode character.File: " + bbf2.nh());
                }
                fw3.aV(string5);
                this.um.put(fw3.getNamespacedID(), fw3);
                this.un.put(fw3.getId(), fw3);
                if (fw3.ik()) {
                    char c = fw3.Q(false).charAt(0);
                    char c2 = fw3.Q(false).charAt(1);
                    if (!this.uo.containsKey(Character.valueOf(c))) {
                        this.uo.put(Character.valueOf(c), new HashMap());
                    }
                    ((HashMap)this.uo.get(Character.valueOf(c))).put(Character.valueOf(c2), fw3);
                    continue;
                }
                this.up.put(Character.valueOf(fw3.Q(false).charAt(0)), fw3);
            }
        }
        this.um.forEach((string, fw2) -> {
            if (fw2.ih()) {
                this.ul.add(fw2.ij());
            }
            if (fw2.ii() != null) {
                fw2.aW(xk.replaceFontImages(fw2.ii()));
            }
        });
        this.hV();
    }

    private int o(String string, String string2) {
        if (this.uq.gP(string + ":" + string2)) {
            return this.uq.gW(string + ":" + string2);
        }
        Map map = this.uq.gS("");
        if (map == null || map.size() == 0) {
            this.uq.d(string + ":" + string2, 0);
            return 0;
        }
        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (object, object2) -> object, LinkedHashMap::new));
        int n = -1;
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            if (map.containsValue(i)) continue;
            n = i;
            break;
        }
        this.uq.d(string + ":" + string2, n);
        return n;
    }

    private String p(String string, String string2) {
        if (this.uq.gP(string + ":" + string2)) {
            return this.uq.gV(string + ":" + string2);
        }
        Map map = this.uq.gS("");
        if (map == null || map.size() == 0) {
            String string3 = ((Character)this.uk.get(0)).toString();
            this.uq.d(string + ":" + string2, string3);
            return string3;
        }
        Map<String, Integer> map2 = new HashMap();
        block0: for (Map.Entry entry : map.entrySet()) {
            String string4 = (String)entry.getKey();
            Object v2 = entry.getValue();
            for (int i = 0; i < this.uk.size(); ++i) {
                Character c = (Character)this.uk.get(i);
                if (!c.toString().equals(v2)) continue;
                map2.put(string4, i);
                continue block0;
            }
        }
        map2 = map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (n, n2) -> n, LinkedHashMap::new));
        int n3 = -1;
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            if (map2.containsValue(i)) continue;
            n3 = i;
            break;
        }
        String string5 = ((Character)this.uk.get(n3)).toString();
        this.uq.d(string + ":" + string2, string5);
        return string5;
    }

    public void c(String string, String string2, String string3) {
        if (this.uq.gP(string + ":" + string2)) {
            this.uq.gQ(string + ":" + string2);
        }
        this.uq.d(string + ":" + string2, string3);
    }

    public void q(String string, String string2) {
        if (this.uq.gP(string + ":" + string2)) {
            String string3 = this.uq.gV(string + ":" + string2);
            for (int i = 0; i < this.uk.size(); ++i) {
                Character c = (Character)this.uk.get(i);
                if (!c.toString().equals(string3)) continue;
                return;
            }
            this.uq.gQ(string + ":" + string2);
        }
    }

    private void aQ(String string) {
        this.uq.d(string, null);
    }

    private void hV() {
        this.uq.CJ();
    }

    public int hW() {
        List list = this.uq.gR("");
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    private int hX() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (String string : this.uq.gR("")) {
            arrayList.add(this.uq.gW(string));
        }
        return (Integer)Collections.max(arrayList);
    }

    public fw aR(String string) {
        return (fw)this.un.get(string.toLowerCase().replace(":", ""));
    }

    @Deprecated
    @Nullable
    public fw aS(String string) {
        for (fw fw2 : this.um.values()) {
            if (!fw2.Q(false).equals(string)) continue;
            return fw2;
        }
        return null;
    }

    public String aT(String string) {
        int n = 0;
        if (bcy.iJ(string = string.replace(":", ""))) {
            return null;
        }
        string = string.replace("offset_", "").replace("", "");
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        if (n == 0) {
            return null;
        }
        if (n >= 0) {
            return (String)il.wn.get(Math.abs(n));
        }
        return (String)il.wo.get(Math.abs(n));
    }

    @Nullable
    private fw c(char c) {
        if (fw.d(c)) {
            return null;
        }
        return (fw)this.up.get(Character.valueOf(c));
    }

    @Nullable
    private fw a(char c, char c2) {
        HashMap hashMap = (HashMap)this.uo.get(Character.valueOf(c));
        if (hashMap == null) {
            return null;
        }
        return (fw)hashMap.get(Character.valueOf(c2));
    }

    @Nullable
    public fw a(String string, int n) {
        char c = string.charAt(n);
        if (c >= '\ud7fc' && c <= '\udfff') {
            if (n + 1 > string.length() - 1) {
                return null;
            }
            char c2 = string.charAt(n + 1);
            if (c2 >= '\ud7fc' && c2 <= '\udfff') {
                return this.a(c, c2);
            }
        }
        return this.c(c);
    }
}
