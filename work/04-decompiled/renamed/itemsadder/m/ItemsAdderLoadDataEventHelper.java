package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.g;
import dev.lone.itemsadder.q;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.StringDecryptor_37;
import java.util.HashMap;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ItemsAdderLoadDataEventHelper
implements Listener {
    private static g bJ;

    public void register() {
        bJ = new g((Plugin)Main.rS(), 6);
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)Main.rS());
    }

    @EventHandler
    private void a(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        if (Main.KO.z("metrics", true)) {
            Bukkit.getScheduler().runTaskAsynchronously((Plugin)Main.rS(), () -> {
                bJ.a(new q("activations", () -> {
                    boolean bl = FieldUtils.getDeclaredField(Main.class, (String)new StringDecryptor_37(this).toString(), (boolean)true) != null;
                    return bl ? "Yes" : "No";
                }));
                bJ.a(new q("servers_using_custom_entities", () -> {
                    if (!MaterialBarColorHolder.dL || !LivingEntityRegistry.P()) {
                        return "0";
                    }
                    int n = LivingEntityRegistry.db().lJ.size();
                    if (n >= 1 && n <= 5) {
                        return "1-5";
                    }
                    if (n >= 6 && n <= 10) {
                        return "6-10";
                    }
                    if (n >= 11 && n <= 15) {
                        return "11-15";
                    }
                    if (n >= 16 && n <= 20) {
                        return "16-20";
                    }
                    if (n >= 21 && n <= 30) {
                        return "21-30";
                    }
                    if (n >= 31 && n <= 50) {
                        return "31-50";
                    }
                    return "50+";
                }));
                bJ.a(new q("servers_using_emotes", () -> MaterialBarColorHolder.dM ? "true" : "false"));
                bJ.a(new q("pack_hosting_method", () -> ItemStackRegistry.g().as.aui.getName()));
                bJ.a(new q("servers_using_viaversion", () -> Main.PL ? "true" : "false"));
                bJ.a(new q("servers_using_complex_furniture", () -> {
                    if (!MaterialBarColorHolder.dL) {
                        return "0";
                    }
                    int n = ((HashMap)ItemStackRegistry.g().P.get("complex_furniture")).size();
                    if (n >= 1 && n <= 5) {
                        return "1-5";
                    }
                    if (n >= 6 && n <= 10) {
                        return "6-10";
                    }
                    if (n >= 11 && n <= 15) {
                        return "11-15";
                    }
                    if (n >= 16 && n <= 20) {
                        return "16-20";
                    }
                    if (n >= 21 && n <= 30) {
                        return "21-30";
                    }
                    if (n >= 31 && n <= 50) {
                        return "31-50";
                    }
                    return "50+";
                }));
                bJ.a(new q("servers_using_legacy_armors", () -> {
                    if (ItemStackRegistry.g().K.isEmpty()) {
                        return "0";
                    }
                    int n = ItemStackRegistry.g().K.size();
                    if (n <= 5) {
                        return "1-5";
                    }
                    if (n <= 10) {
                        return "6-10";
                    }
                    if (n <= 15) {
                        return "11-15";
                    }
                    if (n <= 20) {
                        return "16-20";
                    }
                    if (n <= 30) {
                        return "21-30";
                    }
                    if (n <= 50) {
                        return "31-50";
                    }
                    return "50+";
                }));
                bJ.a(new q("servers_using_equipments", () -> {
                    if (ItemStackRegistry.g().ad.isEmpty()) {
                        return "0";
                    }
                    int n = ItemStackRegistry.g().ad.size();
                    if (n <= 5) {
                        return "1-5";
                    }
                    if (n <= 10) {
                        return "6-10";
                    }
                    if (n <= 15) {
                        return "11-15";
                    }
                    if (n <= 20) {
                        return "16-20";
                    }
                    if (n <= 30) {
                        return "21-30";
                    }
                    if (n <= 50) {
                        return "31-50";
                    }
                    return "50+";
                }));
            });
        }
    }

    public static void Z() {
        if (bJ != null) {
            bJ.Z();
        }
    }
}
