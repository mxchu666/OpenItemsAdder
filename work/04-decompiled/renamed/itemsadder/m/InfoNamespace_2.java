package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.ClearEnum;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.CreatureSpawnListener;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.Opaque110;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfValueBuilder;
import itemsadder.m.RecordOfValue_12;
import itemsadder.m.RecordOfValue_13;
import itemsadder.m.RecordOfValue_14;
import itemsadder.m.ReplaceEnum;
import itemsadder.m.ReplaceEnumBuilder;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;

public class InfoNamespace_2 {
    public static void aR() {
        CreatureSpawnListener.dx().clear();
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : itemStackRegistry.b()) {
            String string = pluginFileConfigurationHolder.gV("info.namespace");
            itemStackRegistry.Z.add(string);
            List list = pluginFileConfigurationHolder.gR("entities_populators");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No entity populator found in file " + pluginFileConfigurationHolder.qd());
                continue;
            }
            BossBarBridge_2.bf("Entities Populators '" + string + "'...");
            for (String string2 : list) {
                Object object;
                Object object2;
                int n;
                Object object3;
                Object object4;
                Object object52;
                ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("entities_populators." + string2);
                assert (configurationSectionBridge != null);
                if (!configurationSectionBridge.C("enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                    CommandSenderBridge_5.log("    Ignored disabled entities_populators: " + string2 + ", namespace: " + string);
                    continue;
                }
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    CommandSenderBridge_5.log("    Loading entities_populators: " + string2);
                }
                if (!r.ez(string2)) {
                    CommandSenderBridge_5.error("[Entities] Non [a-z0-9_.-] character in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    r.ym();
                    continue;
                }
                String string3 = configurationSectionBridge.gV("entity");
                if (string3 == null) {
                    CommandSenderBridge_5.error("[Entities] Missing entity in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                EntityTypeBarStyleHolder entityTypeBarStyleHolder = LivingEntityRegistry.db().am(string3);
                if (entityTypeBarStyleHolder == null) {
                    CommandSenderBridge_5.error("[Entities] Invalid entity '" + string3 + "' in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                float f = configurationSectionBridge.a("chance", 15.0f);
                int n2 = configurationSectionBridge.t("amount", 1);
                List list2 = configurationSectionBridge.hg("worlds");
                ArrayList<NamespacedKey> arrayList = new ArrayList<NamespacedKey>();
                for (Object object52 : configurationSectionBridge.hg("biomes")) {
                    object4 = PluginFileConfigurationHolder.a((String)object52, "minecraft", true, arg_0 -> InfoNamespace_2.a((String)object52, string, string2, pluginFileConfigurationHolder, arg_0));
                    if (object4 == null) continue;
                    arrayList.add((NamespacedKey)object4);
                }
                ArrayList arrayList2 = new ArrayList();
                object52 = configurationSectionBridge.a(ClearEnum.class, "weather", arrayList2);
                if (!arrayList2.isEmpty()) {
                    CommandSenderBridge_5.error("[Entities] Invalid weather in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    object4 = arrayList2.iterator();
                    while (object4.hasNext()) {
                        object3 = (String)object4.next();
                        CommandSenderBridge_5.error("[Entities] - " + (String)object3);
                    }
                }
                object4 = new ArrayList();
                if (configurationSectionBridge.hm("time") instanceof ConfigurationSection) {
                    object3 = configurationSectionBridge.hj("time");
                    assert (object3 != null);
                    for (String string4 : ((ConfigurationSectionBridge)object3).aX(false)) {
                        int n3;
                        n = ((ConfigurationSectionBridge)object3).t(string4 + ".min", 0);
                        if (n > (n3 = ((ConfigurationSectionBridge)object3).t(string4 + ".max", 0))) {
                            CommandSenderBridge_5.error("[Entities] Invalid time in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        object4.add(new RecordOfValue_14(n, n3));
                    }
                }
                object3 = null;
                if (configurationSectionBridge.hm("light_level") instanceof ConfigurationSection) {
                    object2 = configurationSectionBridge.hj("light_level");
                    assert (object2 != null);
                    int n4 = ((ConfigurationSectionBridge)object2).t("min", 0);
                    if (n4 > (n = ((ConfigurationSectionBridge)object2).t("max", 0))) {
                        CommandSenderBridge_5.error("[Entities] Invalid light level in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    object3 = new RecordOfValue_14(n4, n);
                }
                object2 = new ReplaceEnumBuilder();
                if (configurationSectionBridge.hm("spawn_logic") instanceof ConfigurationSection) {
                    object = configurationSectionBridge.hj("spawn_logic");
                    assert (object != null);
                    if (!((ConfigurationSectionBridge)object).gP("method")) {
                        CommandSenderBridge_5.error("[Entities] Missing method in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    ((ReplaceEnumBuilder)object2).a((ReplaceEnum)((ConfigurationSectionBridge)object).a("method", (Class)ReplaceEnum.class, (Enum)null));
                    if (((ReplaceEnumBuilder)object2).dQ() == null) {
                        CommandSenderBridge_5.error("[Entities] Invalid method in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    ((ReplaceEnumBuilder)object2).g(((ConfigurationSectionBridge)object).hW("types"));
                    if (((ReplaceEnumBuilder)object2).dR().isEmpty()) {
                        CommandSenderBridge_5.error("[Entities] Missing types in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                } else {
                    CommandSenderBridge_5.warn("[Entities] Missing spawn_logic in entities_populators '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                object = null;
                if (configurationSectionBridge.hm("location_range") instanceof ConfigurationSection) {
                    ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("location_range");
                    assert (configurationSectionBridge2 != null);
                    object = new RecordOfValue_13(new Opaque110(configurationSectionBridge2.c("x.min", (Integer)null), configurationSectionBridge2.c("y.min", (Integer)null), configurationSectionBridge2.c("z.min", (Integer)null)), new Opaque110(configurationSectionBridge2.c("x.max", (Integer)null), configurationSectionBridge2.c("y.max", (Integer)null), configurationSectionBridge2.c("z.max", (Integer)null)));
                }
                RecordOfValueBuilder recordOfValueBuilder = RecordOfValue_12.dz().b(entityTypeBarStyleHolder).e(f).l(n2).c(arrayList).d(list2).a(((ReplaceEnumBuilder)object2).dT()).a((RecordOfValue_13)object).e((List)object52).f((List)object4).a((RecordOfValue_14)object3);
                try {
                    CreatureSpawnListener.dx().a(recordOfValueBuilder.dK());
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    CommandSenderBridge_5.error("[Entities] Failed to register entities_populators '" + string + ":" + string2 + "'. " + illegalArgumentException.getMessage() + " File:" + pluginFileConfigurationHolder.nh());
                    continue;
                }
                CommandSenderBridge_5.iA("Loaded entities_populators: " + string2 + ". File: " + pluginFileConfigurationHolder.nh());
            }
        }
    }

    private static /* synthetic */ void a(String string, String string2, String string3, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string4) {
        CommandSenderBridge_5.error("[Entities] Invalid biome namespaced ID '" + string + "' in entities_populators '" + string2 + ":" + string3 + "' in yml file: " + pluginFileConfigurationHolder.nh());
    }
}
