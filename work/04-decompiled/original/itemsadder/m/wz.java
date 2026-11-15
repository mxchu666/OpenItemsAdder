package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.awb;
import itemsadder.m.awg;
import itemsadder.m.bbf;
import itemsadder.m.bbi;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.wt;
import itemsadder.m.xd;
import java.util.HashMap;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class wz
extends wt {
    public static HashMap Oz = new HashMap();
    public final int OH;
    public final ql OI;
    public final ql OJ;
    public final TreeType OK;
    private final awb OL;

    public wz(String string, String string2, @NotNull List list, int n, int n2, int n3, int n4, double d, ql ql2, ql ql3, TreeType treeType) {
        super(string, string2, list, ql2, n, n2, n3, d);
        this.OH = n4;
        this.OI = ql2;
        this.OJ = ql3;
        this.OK = treeType;
        if (n3 >= n2) {
            throw new IllegalArgumentException("min_height must be less than max_height");
        }
        this.OL = (block, blockData) -> {
            try {
                if (bbs.ac(blockData.getMaterial())) {
                    ql3.a(null, block, true, false, true, false);
                } else if (bbs.ab(blockData.getMaterial())) {
                    ql2.a(null, block, true, false, true, false);
                } else {
                    block.setBlockData(blockData, false);
                }
            }
            catch (Exception exception) {
                bce.warn("Error while setting block " + String.valueOf(block == null ? "" : block));
                exception.printStackTrace();
                Bukkit.getServer().getPluginManager().disablePlugin((Plugin)Main.rS());
            }
            return true;
        };
    }

    public boolean aI(Block block) {
        return this.j(block, true);
    }

    public boolean j(Block block, boolean bl) {
        if (this.z(block.getRelative(BlockFace.DOWN).getType())) {
            try {
                return awg.vB().a(block.getLocation(), this.OK, this.OL, bl);
            }
            catch (Throwable throwable) {
                bce.error("Custom tree '" + this.oz + "' failed to spawn at " + bcc.ae(block.getLocation()), throwable);
                return true;
            }
        }
        return false;
    }

    public static void h(bbf bbf2) {
        List list = bbf2.gR("trees_populators");
        if (list == null) {
            if (Main.KO.gY("debug.trees-populators.log-loading-no-populators")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No trees_populators found in file " + bbf2.qd());
            }
            return;
        }
        d d2 = d.g();
        String string = bbf2.gV("info.namespace");
        for (String string2 : list) {
            wz wz2;
            ConfigurationSection configurationSection = bbf2.hi("trees_populators." + string2);
            assert (configurationSection != null);
            if (!configurationSection.getBoolean("enabled", true)) {
                if (!Main.KO.gY("debug.trees-populators.log-loading-disabled")) continue;
                bce.log("    Ignored disabled trees populator: " + string2 + ", namespace: " + string);
                continue;
            }
            String string3 = configurationSection.getString("log");
            qm qm2 = d2.e(string3);
            if (qm2 == null) {
                bce.error("&cTree populator &6" + string2 + " &cfailed to load. Missing 'log'&c. &6File: " + bbf2.nh());
                continue;
            }
            if (!ql.k(qm2)) {
                bce.error("&cTree populator &6" + string2 + " &cfailed to load. Attribute 'log' is not a custom block '" + string3 + "'&c. &6File: " + bbf2.nh());
                continue;
            }
            String string4 = configurationSection.getString("leaves");
            qm qm3 = d2.e(string4);
            if (qm3 == null) {
                bce.error("&cTree populator &6" + string2 + " &cfailed to load. Missing 'leaves'&c. &6File: " + bbf2.nh());
                continue;
            }
            if (!ql.k(qm3)) {
                bce.error("&cTree populator &6" + string2 + " &cfailed to load. Attribute 'leaves' is not a custom block '" + string4 + "'&c. &6File: " + bbf2.nh());
                continue;
            }
            String string5 = configurationSection.getString("tree_type", "TREE");
            TreeType treeType = (TreeType)bbi.b(string5, TreeType.class, (Enum)TreeType.TREE);
            try {
                wz2 = new wz(string2, bbf2.nh(), configurationSection.getStringList("worlds"), configurationSection.getInt("amount"), configurationSection.getInt("max_height", 100), configurationSection.getInt("min_height", 5), configurationSection.getInt("iterations"), configurationSection.getDouble("chance"), (ql)qm2, (ql)qm3, treeType);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                bce.error("&cTree populator &6" + string2 + " &cfailed to load. " + illegalArgumentException.getMessage() + "&c. &6File: " + bbf2.nh());
                continue;
            }
            d.g().aa.add((ql)qm3);
            if (configurationSection.contains("biomes")) {
                boolean bl = true;
                for (String string6 : configurationSection.getStringList("biomes")) {
                    if (wz2.cK(string6)) continue;
                    bce.error("[tree_populator} &6'" + string2 + "'&c. Error: Unknown biome &6'" + string6 + "'&c. &6File: " + bbf2.nh());
                    bl = false;
                }
                if (!bl) continue;
            }
            if (configurationSection.contains("bottom_blocks")) {
                for (Object object : configurationSection.getStringList("bottom_blocks")) {
                    String string6;
                    string6 = (Material)bbi.e(((String)object).toUpperCase(), Material.class);
                    if (string6 == null) continue;
                    wz2.y((Material)string6);
                }
            }
            Oz.put(string2, wz2);
            Bukkit.getWorlds().forEach(world -> wz2.k((World)world));
        }
    }

    @Override
    public void k(World world) {
        if (!this.j(world)) {
            return;
        }
        xd xd3 = xd.md.stream().filter(xd2 -> world.equals((Object)xd2.cE())).findFirst().orElseGet(() -> {
            xd xd2 = new xd(world);
            xd.md.add(xd2);
            return xd2;
        });
        xd3.a(this);
        xd3.hn();
    }
}
