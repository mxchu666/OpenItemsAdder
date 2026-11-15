package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.wt;
import itemsadder.m.xc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class wy
extends wt {
    public static Map OF = new HashMap();

    protected wy(String string, String string2, @NotNull List list, ql ql2, int n, int n2, int n3, double d) {
        super(string, string2, list, ql2, n, n2, n3, d);
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        xc xc3 = xc.md.stream().filter(xc2 -> world.equals((Object)xc2.cE())).findFirst().orElseGet(() -> {
            xc xc2 = new xc(world);
            xc.md.add(xc2);
            return xc2;
        });
        xc3.a(this);
        xc3.hn();
    }

    public static void h(bbf bbf2) {
        d d2 = d.g();
        String string = bbf2.gV("info.namespace");
        List list = bbf2.gR("surface_decorators");
        if (list != null) {
            for (String string2 : list) {
                wy wy2;
                ConfigurationSection configurationSection = bbf2.hi("surface_decorators." + string2);
                assert (configurationSection != null);
                if (!configurationSection.getBoolean("enabled", true)) {
                    if (!Main.KO.gY("debug.surface-decorators.log-loading-disabled")) continue;
                    bce.log("    Ignored disabled surface decorator: " + string2 + ", namespace: " + string);
                    continue;
                }
                ql ql2 = d2.h(configurationSection.getString("block"));
                if (ql2 == null) {
                    bce.error("[surface_decorator} &6'" + string2 + "'. &cError: Unknown block &6'" + configurationSection.getString("block") + "'&c. &6File: " + bbf2.nh());
                    continue;
                }
                try {
                    wy2 = new wy(string2, bbf2.nh(), configurationSection.getStringList("worlds"), ql2, configurationSection.getInt("amount"), configurationSection.getInt("max_height"), configurationSection.getInt("min_height"), configurationSection.getDouble("chance"));
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    bce.error("[surface_decorator} &6'" + string2 + "'. &cError: " + illegalArgumentException.getMessage() + "&c. &6File: " + bbf2.nh());
                    continue;
                }
                if (configurationSection.contains("biomes")) {
                    boolean bl = true;
                    for (String string3 : configurationSection.getStringList("biomes")) {
                        if (wy2.cK(string3)) continue;
                        bce.error("[surface_decorator} &6'" + string2 + "'. &cError: Unknown biome &6'" + string3 + "'&c. &6File: " + bbf2.nh());
                        bl = false;
                    }
                    if (!bl) continue;
                }
                if (configurationSection.contains("bottom_blocks")) {
                    for (Object object : configurationSection.getStringList("bottom_blocks")) {
                        String string3;
                        string3 = (Material)bbi.e(((String)object).toUpperCase(), Material.class);
                        if (string3 == null) continue;
                        wy2.y((Material)string3);
                    }
                }
                OF.put(string2, wy2);
                Bukkit.getWorlds().forEach(wy2::k);
            }
        } else if (Main.KO.gY("debug.surface-decorators.log-loading-no-populators")) {
            bce.log(String.valueOf(ChatColor.YELLOW) + "    No surface_decorators found in file " + bbf2.qd());
        }
    }
}
