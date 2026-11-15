package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.EntityTypeBarStyleHolderBuilder;
import itemsadder.m.Hitbox;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfString_5;
import itemsadder.m.SoundCategoryBridge;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public class InfoNamespace {
    public void c(ItemStackRegistry itemStackRegistry) {
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : itemStackRegistry.b()) {
            String string = pluginFileConfigurationHolder.gV("info.namespace");
            itemStackRegistry.Z.add(string);
            List list = pluginFileConfigurationHolder.gR("entities");
            if (list != null) {
                for (String string2 : list) {
                    String string3;
                    @Nullable ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("entities." + string2);
                    assert (configurationSectionBridge != null);
                    String string4 = configurationSectionBridge.az("model_folder", null);
                    if (string4 == null) {
                        CommandSenderBridge_5.error("Missing 'model_folder' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    EntityType entityType = (EntityType)SoundCategoryBridge.e(configurationSectionBridge.gV("type"), EntityType.class);
                    if (entityType == null) {
                        CommandSenderBridge_5.error("Missing 'type' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    Hitbox hitbox = new Hitbox(string, string2);
                    if (!hitbox.aI("/assets/" + string + "/models/" + string4 + "/.metadata")) {
                        CommandSenderBridge_5.error("Failed to load model data for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    BarStyle barStyle = null;
                    Object object = configurationSectionBridge.az("boss_bar.style", null);
                    if (object instanceof String && (barStyle = SoundCategoryBridge.il(string3 = object)) == null) {
                        CommandSenderBridge_5.error("Invalid 'boss_bar.style' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    string3 = null;
                    Object object2 = configurationSectionBridge.az("boss_bar.color", null);
                    if (object2 instanceof String && (string3 = SoundCategoryBridge.im((String)(object = object2))) == null) {
                        CommandSenderBridge_5.error("Invalid 'boss_bar.color' for entity '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    object = null;
                    String string5 = configurationSectionBridge.az("sounds.ambient.sound", null);
                    if (string5 instanceof String) {
                        object2 = string5;
                        object = new RecordOfString_5((String)object2, configurationSectionBridge.b("sounds.ambient.chance_per_tick", 0.1), configurationSectionBridge.t("sounds.ambient.cooldown_ticks", 100));
                    }
                    object2 = EntityTypeBarStyleHolder.fy().a(hitbox).d(pluginFileConfigurationHolder).au(configurationSectionBridge.az("display_name", string2)).b(entityType).x(configurationSectionBridge.C("boss_bar.enabled", false)).z(configurationSectionBridge.C("silent", true)).A(configurationSectionBridge.C("sun_burn", configurationSectionBridge.C("can_sun_burn", false))).B(configurationSectionBridge.C("drop_vanilla_loot", configurationSectionBridge.C("can_drop_loot", false))).C(configurationSectionBridge.C("mount_on_interact", true)).D(configurationSectionBridge.C("shadow", true)).a(configurationSectionBridge.a("max_health", (Double)null)).a(barStyle).a((BarColor)string3).b(configurationSectionBridge.b("speed.movement", 0.23)).a(Float.valueOf(configurationSectionBridge.a("speed.flying", 0.23f))).E(configurationSectionBridge.hq("invulnerable")).F(configurationSectionBridge.C("gravity", true)).G(configurationSectionBridge.C("ai", true)).e(configurationSectionBridge.b("eyes_height", 0.25)).b((RecordOfString_5)object).av(configurationSectionBridge.az("sounds.attack", null)).aw(configurationSectionBridge.az("sounds.hurt", null)).ax(configurationSectionBridge.az("sounds.death", null)).ay(configurationSectionBridge.az("all_actions_permission", null));
                    LivingEntityRegistry.db().a((EntityTypeBarStyleHolderBuilder)object2);
                }
                continue;
            }
            if (!Main.KO.gY("debug.entities.log-entities-loading")) continue;
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No entity found in file " + pluginFileConfigurationHolder.qd());
        }
    }
}
