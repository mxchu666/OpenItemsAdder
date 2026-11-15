package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.ax;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Crops;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KabKab;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.MaterialBridge_7;
import itemsadder.m.MaterialBridge_8;
import itemsadder.m.PluginContractImpl_7;
import itemsadder.m.Runner;
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

final class PlayerBridge {
    private final Plugin ci;
    private final av cj;

    PlayerBridge(Plugin plugin, av av2) {
        this.ci = plugin;
        this.cj = av2;
    }

    void h(boolean bl) {
        this.cj.auh.asl = true;
        if (!bl && MaterialBarColorHolder.db) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.isOnline() || this.cj.cj(player) == ax.INSTALLED) continue;
                this.cj.aui.cp(player);
            }
        }
    }

    boolean a(HashMap hashMap, HashMap hashMap2, boolean bl, HashMap hashMap3, KabKab kabKab, boolean bl2, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable Runner runner, @Nullable Player player, boolean bl3) {
        if (bl3) {
            if (!ItemStackRegistry.g().t()) {
                throw new IllegalStateException("Resource-pack operation was not reserved");
            }
        } else if (!ItemStackRegistry.g().s()) {
            return false;
        }
        if (!this.cj.aui.j((CommandSender)player)) {
            BossBarBridge_2.clear();
            ItemStackRegistry.g().u();
            if (consumer != null) {
                consumer.accept(false);
            }
            return false;
        }
        boolean bl4 = this.am();
        if (PlayerBridge.b(bl3, bl4)) {
            CommandSenderBridge_5.error("[Pack] Automatic startup generation skipped because ModelEngine is configured to regenerate its pack after server startup.");
            CommandSenderBridge_5.error("[Pack] Wait for ModelEngine to finish and run /iazip, or disable its three 'Post-Server' flags and restart.");
            this.cj.auh.asl = false;
            BossBarBridge_2.clear();
            ItemStackRegistry.g().u();
            if (consumer != null) {
                consumer.accept(false);
            }
            return false;
        }
        try {
            this.a(hashMap, hashMap2, bl, hashMap3, kabKab, bl2, runnable, consumer, runner, player);
            return true;
        }
        catch (Error | RuntimeException throwable) {
            try {
                this.cj.zB();
            }
            catch (Throwable throwable2) {
                throwable.addSuppressed(throwable2);
            }
            BossBarBridge_2.clear();
            ItemStackRegistry.g().u();
            if (consumer != null) {
                consumer.accept(false);
            }
            throw throwable;
        }
    }

    private void a(HashMap hashMap, HashMap hashMap2, boolean bl2, HashMap hashMap3, KabKab kabKab, boolean bl3, @Nullable Runnable runnable, @Nullable Consumer consumer, @Nullable Runner runner, @Nullable Player player) {
        if (runnable != null) {
            runnable.run();
        }
        CommandSenderBridge_5.log(" ");
        CommandSenderBridge_5.log(" ");
        CommandSenderBridge_5.b((CommandSender)player, String.valueOf(ChatColor.GREEN) + "[Pack] Started generation");
        BossBarBridge_2.bf("Handling entities bones...");
        HashMap hashMap4 = new HashMap();
        hashMap.forEach((material, list) -> hashMap4.put(material, new ArrayList(list)));
        LivingEntityRegistry.db().lJ.forEach((string, entityTypeBarStyleHolder) -> entityTypeBarStyleHolder.nO.pC.forEach((string2, instanceRegistry_10) -> {
            Material material;
            if (!instanceRegistry_10.pr) {
                return;
            }
            Material material2 = material = instanceRegistry_10.pw ? Material.PLAYER_HEAD : Material.POTION;
            if (!hashMap4.containsKey(material)) {
                hashMap4.put(material, new ArrayList());
            }
            List list = (List)hashMap4.get(material);
            if (instanceRegistry_10.pw) {
                list.add(new PluginContractImpl_7(instanceRegistry_10.fX(), "_iainternal:entity/player/" + instanceRegistry_10.getId(), "_iainternal", instanceRegistry_10.getId()));
            } else {
                list.add(instanceRegistry_10);
            }
            instanceRegistry_10.fY().forEach((string, n2) -> {
                if (string.equals("1-1-1")) {
                    return;
                }
                if (!instanceRegistry_10.pw && string.equals("0-0-0")) {
                    return;
                }
                list.add(new PluginContractImpl_7((int)n2, instanceRegistry_10.ga() + "_" + string, instanceRegistry_10.getNamespace(), instanceRegistry_10.getId() + "_" + string.replace(".", ",")));
            });
        }));
        BossBarBridge_2.bf("Generating predicates...");
        this.cj.auh.d(hashMap4);
        BossBarBridge_2.bf("Generating models...");
        ArrayList arrayList = new ArrayList();
        hashMap2.forEach((string, itemStackBuilder_4) -> {
            if (itemStackBuilder_4.FX != null) {
                return;
            }
            if (itemStackBuilder_4.mR() != null) {
                MaterialBridge_7 materialBridge_7 = new MaterialBridge_7(Material.PAPER, itemStackBuilder_4.Gf, itemStackBuilder_4.Gg + "_icon", (ItemStackBuilder_4)itemStackBuilder_4, itemStackBuilder_4.mR());
                itemStackBuilder_4.bN(materialBridge_7.g(false, true));
                arrayList.add(materialBridge_7);
            }
            arrayList.add(new MaterialBridge_8(itemStackBuilder_4.getType(), itemStackBuilder_4.Gf, itemStackBuilder_4.Gg, (ItemStackBuilder_4)itemStackBuilder_4));
        });
        this.cj.auh.J(arrayList);
        BossBarBridge_2.bf("Generating modern models...");
        hashMap2.forEach((string, itemStackBuilder_4) -> {
            try {
                this.cj.auh.A((ItemStackBuilder_4)itemStackBuilder_4);
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Error", exception);
            }
        });
        if (bl2) {
            for (MaterialBridge_12 materialBridge_12 : Crops.pr()) {
                this.cj.auh.b(materialBridge_12);
            }
        }
        BossBarBridge_2.bf("Generating block models...");
        this.cj.auh.b(hashMap2);
        BossBarBridge_2.bf("Generating font images...");
        this.cj.auh.c(hashMap3);
        BossBarBridge_2.bf("Generating legacy armors...");
        this.cj.auh.yW();
        this.cj.auh.asP = kabKab.qM();
        if (MaterialBarColorHolder.dh) {
            BossBarBridge_2.bf("Compressing images...");
            this.cj.auh.aU(bl3);
        }
        BossBarBridge_2.bf("Generating pack.mcmeta...");
        this.cj.auh.yY();
        BossBarBridge_2.bf("Processing packs...");
        this.cj.auh.za();
        CommandSenderBridge_5.log(" ");
        CommandSenderBridge_5.b((CommandSender)player, String.valueOf(ChatColor.GREEN) + "[Pack] Generated resourcepack assets.");
        long l = System.currentTimeMillis();
        BossBarBridge_2.bf("Compressing pack...");
        this.cj.auh.a((T bl) -> {
            try {
                if (bl.booleanValue()) {
                    this.cj.aui.co(player);
                    CommandSenderBridge_5.b((CommandSender)player, String.valueOf(ChatColor.GREEN) + "[Pack] Compressed in " + (System.currentTimeMillis() - l) + "ms");
                    if (MaterialBarColorHolder.cB || MaterialBarColorHolder.cC) {
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[OK] Protected from unzip.");
                    } else {
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "[!] NOT protected from unzip. Consider enabling protections in config.yml");
                    }
                    BossBarBridge_2.bf("Pack compressed.");
                } else {
                    CommandSenderBridge_5.b((CommandSender)player, String.valueOf(ChatColor.RED) + "[Pack] Generation failed. The previous resource pack was not replaced.");
                    BossBarBridge_2.bf("Pack generation failed.");
                }
                if (consumer != null) {
                    consumer.accept(bl);
                }
            }
            finally {
                ItemStackRegistry.g().u();
            }
        }, runner);
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
        if (!PlayerBridge.a(bl3, bl2 = yamlConfiguration.getBoolean("Model-Generator.Assets-Post-Server"), bl = yamlConfiguration.getBoolean("Model-Generator.Compile-Post-Server"))) {
            return false;
        }
        CommandSenderBridge_5.warn(" ");
        CommandSenderBridge_5.warn(" ");
        CommandSenderBridge_5.warn("ModelEngine 'Post-Server' flags are enabled. This can make its resource pack change while ItemsAdder is reading it.");
        if (bl3) {
            CommandSenderBridge_5.warn("- 'Register-Post-Server' is enabled.");
        }
        if (bl2) {
            CommandSenderBridge_5.warn("- 'Assets-Post-Server' is enabled.");
        }
        if (bl) {
            CommandSenderBridge_5.warn("- 'Compile-Post-Server' is enabled.");
        }
        CommandSenderBridge_5.warn(" ");
        CommandSenderBridge_5.warn(" ");
        return true;
    }

    static boolean a(boolean bl, boolean bl2, boolean bl3) {
        return bl || bl2 || bl3;
    }

    static boolean b(boolean bl, boolean bl2) {
        return !bl && bl2;
    }
}
