package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.wt;
import itemsadder.m.wx;
import itemsadder.m.xb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class ww
extends wt {
    public static HashMap Oz = new HashMap();
    public final wx OD;

    public ww(String string, String string2, @NotNull List list, ql ql2, int n, int n2, int n3, double d, wx wx2) {
        super(string, string2, list, ql2, n, n2, n3, d);
        this.OD = wx2;
    }

    public static void h(bbf bbf2) {
        String string = bbf2.gV("info.namespace");
        List list = bbf2.gR("cave_decorators");
        if (list == null) {
            if (Main.KO.gY("debug.cave-decorators.log-loading-no-populators")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No cave_decorators found in file " + bbf2.qd());
            }
            return;
        }
        for (String string2 : list) {
            wx wx2;
            Object object;
            ConfigurationSection configurationSection = bbf2.hi("cave_decorators." + string2);
            assert (configurationSection != null);
            if (!configurationSection.getBoolean("enabled", true)) {
                if (!Main.KO.gY("debug.cave-decorators.log-loading-disabled")) continue;
                bce.log("    Ignored disabled cave decorator: " + string2 + ", namespace: " + string);
                continue;
            }
            ql ql2 = d.g().h(configurationSection.getString("block"));
            if (ql2 == null) {
                bce.error("&cCave decorator &6" + string2 + " &cfailed to load. Unknown block &6" + configurationSection.getString("block") + "&c. &6File: " + bbf2.nh());
                continue;
            }
            Iterator iterator = configurationSection.get("position");
            if (iterator instanceof String) {
                object = (String)((Object)iterator);
                wx2 = (wx)bbi.e((String)object, wx.class);
                if (wx2 == null) {
                    bce.error("&cCave decorator &6" + string2 + " &cfailed to load. Unknown 'position' &6" + (String)object + "&c. &6File: " + bbf2.nh());
                    continue;
                }
            } else {
                wx2 = wx.SURFACE;
            }
            object = new ww(string2, bbf2.nh(), configurationSection.getStringList("worlds"), ql2, configurationSection.getInt("amount"), configurationSection.getInt("max_height"), configurationSection.getInt("min_height"), configurationSection.getDouble("chance"), wx2);
            if (configurationSection.contains("biomes")) {
                boolean bl = true;
                for (String string3 : configurationSection.getStringList("biomes")) {
                    if (((wt)object).cK(string3)) continue;
                    bce.error("[cave_decorator} &6'" + string2 + "'&c. Error: Unknown biome &6'" + string3 + "'&c. &6File: " + bbf2.nh());
                    bl = false;
                }
                if (!bl) continue;
            }
            if (configurationSection.contains("bottom_blocks")) {
                for (Object object2 : configurationSection.getStringList("bottom_blocks")) {
                    String string3;
                    string3 = (Material)bbi.e(((String)object2).toUpperCase(), Material.class);
                    if (string3 == null) continue;
                    ((wt)object).y((Material)string3);
                }
            }
            Oz.put(string2, object);
            Bukkit.getWorlds().forEach(((ww)object)::k);
        }
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        xb xb3 = xb.md.stream().filter(xb2 -> world.equals((Object)xb2.cE())).findFirst().orElseGet(() -> {
            xb xb2 = new xb(world);
            xb.md.add(xb2);
            xb.OQ.put(world.getUID(), xb2);
            return xb2;
        });
        xb3.a(this);
        xb3.hn();
    }
}
