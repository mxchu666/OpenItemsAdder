package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.wt;
import itemsadder.m.xa;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class wv
extends wt {
    public static HashMap Oz = new HashMap();
    public final int OA;
    public final HashSet OB;

    public wv(String string, String string2, @NotNull List list, ql ql2, int n, int n2, int n3, int n4, double d) {
        super(string, string2, list, ql2, n, n2, n3, d);
        this.OA = n4;
        this.OB = new HashSet();
        if (n3 >= n2) {
            throw new IllegalArgumentException("min_height must be less than max_height");
        }
    }

    public void A(Material material) {
        this.OB.add(material);
    }

    public boolean aH(Block block) {
        if (this.OB.isEmpty()) {
            return true;
        }
        return this.OB.contains(block.getType());
    }

    public static void h(bbf bbf2) {
        d d2 = d.g();
        String string = bbf2.gV("info.namespace");
        List list = bbf2.gR("blocks_populators");
        if (list == null || list.isEmpty()) {
            list = bbf2.gR("worlds_populators");
        }
        if (list == null) {
            if (Main.KO.gY("debug.blocks-populators.log-loading-no-populators")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No blocks_populators found in file " + bbf2.qd());
            }
            return;
        }
        for (String string2 : list) {
            wv wv2;
            ConfigurationSection configurationSection = bbf2.hi("blocks_populators." + string2);
            if (configurationSection == null) {
                configurationSection = bbf2.hi("worlds_populators." + string2);
            }
            assert (configurationSection != null);
            if (!configurationSection.getBoolean("enabled", true)) {
                if (!Main.KO.gY("debug.blocks-populators.log-loading-disabled")) continue;
                bce.log("    Ignored disabled world populator: " + string2 + ", namespace: " + string);
                continue;
            }
            ql ql2 = d2.h(configurationSection.getString("block"));
            if (ql2 == null) {
                bce.error("&cWorld populator &6" + string2 + " &cfailed to load. Unknown block &6" + configurationSection.getString("block") + "&c. &6File: " + bbf2.nh());
                continue;
            }
            try {
                wv2 = new wv(string2, bbf2.nh(), configurationSection.getStringList("worlds"), ql2, configurationSection.getInt("vein_blocks", configurationSection.getInt("amount")), configurationSection.getInt("max_height"), configurationSection.getInt("min_height"), configurationSection.getInt("chunk_veins", configurationSection.getInt("iterations")), configurationSection.getDouble("chunk_chance", (double)configurationSection.getInt("chance")));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                bce.error("&cWorld populator &6" + string2 + " &cfailed to load. " + illegalArgumentException.getMessage() + "&c. &6File: " + bbf2.nh());
                continue;
            }
            if (configurationSection.contains("replaceable_blocks")) {
                for (Object object : configurationSection.getStringList("replaceable_blocks")) {
                    if (!bbs.ip((String)object)) continue;
                    wv2.A(Material.valueOf((String)((String)object).toUpperCase()));
                }
            }
            if (configurationSection.contains("biomes")) {
                Object object;
                boolean bl = true;
                object = configurationSection.getStringList("biomes").iterator();
                while (object.hasNext()) {
                    String string3 = (String)object.next();
                    if (wv2.cK(string3)) continue;
                    bce.error("[world_populator} &6'" + string2 + "'&c. Error: Unknown biome &6'" + string3 + "'&c. &6File: " + bbf2.nh());
                    bl = false;
                }
                if (!bl) continue;
            }
            Oz.put(string2, wv2);
            Bukkit.getWorlds().forEach(wv2::k);
        }
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        xa xa3 = xa.md.stream().filter(xa2 -> world.equals((Object)xa2.cE())).findFirst().orElseGet(() -> {
            xa xa2 = new xa(world);
            xa.md.add(xa2);
            return xa2;
        });
        xa3.a(this);
        xa3.hn();
    }
}
