package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.ax;
import itemsadder.m.ae;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.bcm;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.qm;
import itemsadder.m.qr;
import itemsadder.m.qs;
import itemsadder.m.qy;
import itemsadder.m.rq;
import itemsadder.m.sk;
import itemsadder.m.ur;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

final class ac {
    private final Plugin ci;
    private final av cj;

    ac(Plugin plugin, av av2) {
        this.ci = plugin;
        this.cj = av2;
    }

    void h(boolean bl) {
        this.cj.auh.asl = true;
        if (!bl && ae.db) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.isOnline() || this.cj.cj(player) == ax.INSTALLED) continue;
                this.cj.aui.cp(player);
            }
        }
    }

    boolean a(HashMap hashMap, HashMap hashMap2, boolean bl, HashMap hashMap3, ur ur2, boolean bl2, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable bcm bcm2, @Nullable Player player, boolean bl3) {
        if (bl3) {
            if (!d.g().t()) {
                throw new IllegalStateException("Resource-pack operation was not reserved");
            }
        } else if (!d.g().s()) {
            return false;
        }
        if (!this.cj.aui.j((CommandSender)player)) {
            bbr.clear();
            d.g().u();
            if (consumer != null) {
                consumer.accept(false);
            }
            return false;
        }
        boolean bl4 = this.am();
        if (ac.b(bl3, bl4)) {
            bce.error("[Pack] Automatic startup generation skipped because ModelEngine is configured to regenerate its pack after server startup.");
            bce.error("[Pack] Wait for ModelEngine to finish and run /iazip, or disable its three 'Post-Server' flags and restart.");
            this.cj.auh.asl = false;
            bbr.clear();
            d.g().u();
            if (consumer != null) {
                consumer.accept(false);
            }
            return false;
        }
        try {
            this.a(hashMap, hashMap2, bl, hashMap3, ur2, bl2, runnable, consumer, bcm2, player);
            return true;
        }
        catch (Error | RuntimeException throwable) {
            try {
                this.cj.zB();
            }
            catch (Throwable throwable2) {
                throwable.addSuppressed(throwable2);
            }
            bbr.clear();
            d.g().u();
            if (consumer != null) {
                consumer.accept(false);
            }
            throw throwable;
        }
    }

    private void a(HashMap hashMap, HashMap hashMap2, boolean bl2, HashMap hashMap3, ur ur2, boolean bl3, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable bcm bcm2, @Nullable Player player) {
        if (runnable != null) {
            runnable.run();
        }
        bce.log(" ");
        bce.log(" ");
        bce.b((CommandSender)player, String.valueOf(ChatColor.GREEN) + "[Pack] Started generation");
        bbr.bf("Handling entities bones...");
        HashMap hashMap4 = new HashMap();
        hashMap.forEach((material, list) -> hashMap4.put(material, new ArrayList(list)));
        da.db().lJ.forEach((string, dp2) -> dp2.nO.pC.forEach((string2, dx2) -> {
            Material material;
            if (!dx2.pr) {
                return;
            }
            Material material2 = material = dx2.pw ? Material.PLAYER_HEAD : Material.POTION;
            if (!hashMap4.containsKey(material)) {
                hashMap4.put(material, new ArrayList());
            }
            List list = (List)hashMap4.get(material);
            if (dx2.pw) {
                list.add(new qy(dx2.fX(), "_iainternal:entity/player/" + dx2.getId(), "_iainternal", dx2.getId()));
            } else {
                list.add(dx2);
            }
            dx2.fY().forEach((string, n2) -> {
                if (string.equals("1-1-1")) {
                    return;
                }
                if (!dx2.pw && string.equals("0-0-0")) {
                    return;
                }
                list.add(new qy((int)n2, dx2.ga() + "_" + string, dx2.getNamespace(), dx2.getId() + "_" + string.replace(".", ",")));
            });
        }));
        bbr.bf("Generating predicates...");
        this.cj.auh.d(hashMap4);
        bbr.bf("Generating models...");
        ArrayList arrayList = new ArrayList();
        hashMap2.forEach((string, qm2) -> {
            if (qm2.FX != null) {
                return;
            }
            if (qm2.mR() != null) {
                qr qr2 = new qr(Material.PAPER, qm2.Gf, qm2.Gg + "_icon", (qm)qm2, qm2.mR());
                qm2.bN(qr2.g(false, true));
                arrayList.add(qr2);
            }
            arrayList.add(new qs(qm2.getType(), qm2.Gf, qm2.Gg, (qm)qm2));
        });
        this.cj.auh.J(arrayList);
        bbr.bf("Generating modern models...");
        hashMap2.forEach((string, qm2) -> {
            try {
                this.cj.auh.A((qm)qm2);
            }
            catch (Exception exception) {
                bce.error("Error", exception);
            }
        });
        if (bl2) {
            for (rq rq2 : sk.pr()) {
                this.cj.auh.b(rq2);
            }
        }
        bbr.bf("Generating block models...");
        this.cj.auh.b(hashMap2);
        bbr.bf("Generating font images...");
        this.cj.auh.c(hashMap3);
        bbr.bf("Generating legacy armors...");
        this.cj.auh.yW();
        this.cj.auh.asP = ur2.qM();
        if (ae.dh) {
            bbr.bf("Compressing images...");
            this.cj.auh.aU(bl3);
        }
        bbr.bf("Generating pack.mcmeta...");
        this.cj.auh.yY();
        bbr.bf("Processing packs...");
        this.cj.auh.za();
        bce.log(" ");
        bce.b((CommandSender)player, String.valueOf(ChatColor.GREEN) + "[Pack] Generated resourcepack assets.");
        long l = System.currentTimeMillis();
        bbr.bf("Compressing pack...");
        this.cj.auh.a((T bl) -> {
            try {
                if (bl.booleanValue()) {
                    this.cj.aui.co(player);
                    bce.b((CommandSender)player, String.valueOf(ChatColor.GREEN) + "[Pack] Compressed in " + (System.currentTimeMillis() - l) + "ms");
                    if (ae.cB || ae.cC) {
                        bce.log(String.valueOf(ChatColor.GREEN) + "[OK] Protected from unzip.");
                    } else {
                        bce.log(String.valueOf(ChatColor.YELLOW) + "[!] NOT protected from unzip. Consider enabling protections in config.yml");
                    }
                    bbr.bf("Pack compressed.");
                } else {
                    bce.b((CommandSender)player, String.valueOf(ChatColor.RED) + "[Pack] Generation failed. The previous resource pack was not replaced.");
                    bbr.bf("Pack generation failed.");
                }
                if (consumer != null) {
                    consumer.accept(bl);
                }
            }
            finally {
                d.g().u();
            }
        }, bcm2);
    }

    private boolean am() {
        boolean bl;
        boolean bl2;
        if (!Main.PM) {
            return false;
        }
        File file = new File(this.ci.getDataFolder().getParent(), "ModelEngine" + File.separator + "config.yml");
        if (!file.exists()) {
            return false;
        }
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration((File)file);
        boolean bl3 = yamlConfiguration.getBoolean("Model-Generator.Register-Post-Server");
        if (!ac.a(bl3, bl2 = yamlConfiguration.getBoolean("Model-Generator.Assets-Post-Server"), bl = yamlConfiguration.getBoolean("Model-Generator.Compile-Post-Server"))) {
            return false;
        }
        bce.warn(" ");
        bce.warn(" ");
        bce.warn("ModelEngine 'Post-Server' flags are enabled. This can make its resource pack change while ItemsAdder is reading it.");
        if (bl3) {
            bce.warn("- 'Register-Post-Server' is enabled.");
        }
        if (bl2) {
            bce.warn("- 'Assets-Post-Server' is enabled.");
        }
        if (bl) {
            bce.warn("- 'Compile-Post-Server' is enabled.");
        }
        bce.warn(" ");
        bce.warn(" ");
        return true;
    }

    static boolean a(boolean bl, boolean bl2, boolean bl3) {
        return bl || bl2 || bl3;
    }

    static boolean b(boolean bl, boolean bl2) {
        return !bl && bl2;
    }
}
