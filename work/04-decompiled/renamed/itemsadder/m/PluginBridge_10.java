package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Implemented_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PluginFileConfigurationHolder;
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

public class PluginBridge_10 {
    final ItemStackRegistry ui;
    public final int uj;
    public final List uk = new ArrayList();
    public final List ul = new ArrayList();
    public final LinkedHashMap um = new LinkedHashMap();
    public final HashMap un = new HashMap();
    private final Implemented_2 uo = new Implemented_2();
    private final Implemented_2 up = new Implemented_2();
    public final PluginFileConfigurationHolder uq;

    public PluginBridge_10(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        int n;
        this.ui = itemStackRegistry;
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
        this.uq = new PluginFileConfigurationHolder(plugin, true, "storage/font_images_unicode_cache.yml", false, false);
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
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : this.ui.b()) {
            List list = pluginFileConfigurationHolder.gR("font_images");
            if (list == null) {
                if (!MaterialBarColorHolder.em) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No font_images found in file " + pluginFileConfigurationHolder.qd());
                continue;
            }
            String string2 = pluginFileConfigurationHolder.gV("info.namespace");
            for (String string3 : list) {
                if (MaterialBarColorHolder.em) {
                    CommandSenderBridge_5.log("    Detected font image: " + string3);
                }
                if (!pluginFileConfigurationHolder.z("font_images." + string3 + ".enabled", true)) continue;
                String string4 = null;
                if (pluginFileConfigurationHolder.gP("font_images." + string3 + ".manual_character")) {
                    string4 = pluginFileConfigurationHolder.gV("font_images." + string3 + ".manual_character");
                } else if (pluginFileConfigurationHolder.gP("font_images." + string3 + ".symbol") && Objects.equals(string4 = pluginFileConfigurationHolder.gV("font_images." + string3 + ".symbol"), "")) {
                    CommandSenderBridge_5.error("Error: font_image '" + string3 + "' has empty symbol. Please use a valid unicode character or remove the 'symbol'  property.");
                    string4 = null;
                }
                if (string4 != null) {
                    this.c(string2, string3, string4);
                } else {
                    this.q(string2, string3);
                }
                Integer n = null;
                Color color = ColorBridge.iL(pluginFileConfigurationHolder.az("font_images." + string3 + ".shadow.color", null));
                if (color != null) {
                    n = color.asRGB();
                }
                PermissibleBridge permissibleBridge2 = new PermissibleBridge(pluginFileConfigurationHolder, string2, string3, pluginFileConfigurationHolder.gV("font_images." + string3 + ".path"), pluginFileConfigurationHolder.t("font_images." + string3 + ".y_position", 0), pluginFileConfigurationHolder.t("font_images." + string3 + ".scale_ratio", 0), pluginFileConfigurationHolder.az("font_images." + string3 + ".permission_suffix", pluginFileConfigurationHolder.az("font_images." + string3 + ".permission", null)), pluginFileConfigurationHolder.z("font_images." + string3 + ".show_in_gui", false), pluginFileConfigurationHolder.z("font_images." + string3 + ".shadow", true), n, pluginFileConfigurationHolder.z("font_images." + string3 + ".chat.hover.enabled", true), pluginFileConfigurationHolder.az("font_images." + string3 + ".chat.hover.override_text", null), pluginFileConfigurationHolder.z("font_images." + string3 + ".suggest_in_command", true));
                if (permissibleBridge2.uu) continue;
                String string5 = this.p(string2, string3);
                if (string5.length() > 2 || string5.length() == 2 && (!PermissibleBridge.d(string5.charAt(0)) || !PermissibleBridge.d(string5.charAt(1)))) {
                    string5 = this.p(string2, string3);
                    CommandSenderBridge_5.error("Error: font_image '" + string3 + "' has a bad symbol. Some emojis are not supported, and you can use only 1 character.\nForcing usage of another unicode character.File: " + pluginFileConfigurationHolder.nh());
                }
                permissibleBridge2.aV(string5);
                this.um.put(permissibleBridge2.getNamespacedID(), permissibleBridge2);
                this.un.put(permissibleBridge2.getId(), permissibleBridge2);
                if (permissibleBridge2.ik()) {
                    char c = permissibleBridge2.Q(false).charAt(0);
                    char c2 = permissibleBridge2.Q(false).charAt(1);
                    if (!this.uo.containsKey(Character.valueOf(c))) {
                        this.uo.put(Character.valueOf(c), new HashMap());
                    }
                    ((HashMap)this.uo.get(Character.valueOf(c))).put(Character.valueOf(c2), permissibleBridge2);
                    continue;
                }
                this.up.put(Character.valueOf(permissibleBridge2.Q(false).charAt(0)), permissibleBridge2);
            }
        }
        this.um.forEach((string, permissibleBridge) -> {
            if (permissibleBridge.ih()) {
                this.ul.add(permissibleBridge.ij());
            }
            if (permissibleBridge.ii() != null) {
                permissibleBridge.aW(PermissibleBridge_2.replaceFontImages(permissibleBridge.ii()));
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
            Object v = entry.getValue();
            for (int i = 0; i < this.uk.size(); ++i) {
                Character c = (Character)this.uk.get(i);
                if (!c.toString().equals(v)) continue;
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

    public PermissibleBridge aR(String string) {
        return (PermissibleBridge)this.un.get(string.toLowerCase().replace(":", ""));
    }

    @Deprecated
    @Nullable
    public PermissibleBridge aS(String string) {
        for (PermissibleBridge permissibleBridge : this.um.values()) {
            if (!permissibleBridge.Q(false).equals(string)) continue;
            return permissibleBridge;
        }
        return null;
    }

    public String aT(String string) {
        int n = 0;
        if (ColorBridge.iJ(string = string.replace(":", ""))) {
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
            return (String)Opaque123.wn.get(Math.abs(n));
        }
        return (String)Opaque123.wo.get(Math.abs(n));
    }

    @Nullable
    private PermissibleBridge c(char c) {
        if (PermissibleBridge.d(c)) {
            return null;
        }
        return (PermissibleBridge)this.up.get(Character.valueOf(c));
    }

    @Nullable
    private PermissibleBridge a(char c, char c2) {
        HashMap hashMap = (HashMap)this.uo.get(Character.valueOf(c));
        if (hashMap == null) {
            return null;
        }
        return (PermissibleBridge)hashMap.get(Character.valueOf(c2));
    }

    @Nullable
    public PermissibleBridge a(String string, int n) {
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
