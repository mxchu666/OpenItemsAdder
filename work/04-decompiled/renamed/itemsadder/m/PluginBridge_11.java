package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.EqualEnum;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KfFunction;
import itemsadder.m.NamespacedKeyBridge_2;
import itemsadder.m.Opaque140;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridgeImpl;
import itemsadder.m.PlayerBridgeImpl_2;
import itemsadder.m.PlayerBridgeImpl_3;
import itemsadder.m.PlayerBridge_10;
import itemsadder.m.PlayerBridge_11;
import itemsadder.m.PlayerBridge_12;
import itemsadder.m.PlayerBridge_13;
import itemsadder.m.PlayerBridge_14;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PlayerBridge_9;
import itemsadder.m.PlayerWrapper_6;
import itemsadder.m.PlayerWrapper_7;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.PotionEffectTypeBridge;
import itemsadder.m.RightEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;

public class PluginBridge_11 {
    final Plugin vD;
    final ItemStackRegistry vE;
    public final HashMap vF = new HashMap();
    private boolean vG = true;
    public final List vH = new ArrayList();

    public PluginBridge_11(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.vD = plugin;
        this.vE = itemStackRegistry;
    }

    public void Z(boolean bl) {
        this.vG = bl;
    }

    public boolean isEnabled() {
        return this.vG;
    }

    public void jG() {
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : this.vE.b()) {
            List list = pluginFileConfigurationHolder.gR("huds");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-huds-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No huds found in file " + pluginFileConfigurationHolder.qd());
                continue;
            }
            String string = pluginFileConfigurationHolder.gV("info.namespace");
            int n = 0;
            for (String string2 : list) {
                if (Main.KO.gY("debug.items.log-huds-loading")) {
                    CommandSenderBridge_5.log("    Detected HUD: " + string2);
                }
                if (!pluginFileConfigurationHolder.z("huds." + string2 + ".enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-huds-loading")) continue;
                    CommandSenderBridge_5.log("    Skip disabled HUD");
                    continue;
                }
                Object object = null;
                int n2 = pluginFileConfigurationHolder.gW("huds." + string2 + ".value.min");
                int n3 = pluginFileConfigurationHolder.gW("huds." + string2 + ".value.max");
                @Nullable String string3 = pluginFileConfigurationHolder.gV("huds." + string2 + ".value.player_stat_name");
                switch (pluginFileConfigurationHolder.gV("huds." + string2 + ".type")) {
                    case "STATUS": {
                        Object object2 = (PermissibleBridge)this.vE.al.um.get(pluginFileConfigurationHolder.gV("huds." + string2 + ".images.positive"));
                        PermissibleBridge permissibleBridge = (PermissibleBridge)this.vE.al.um.get(pluginFileConfigurationHolder.gV("huds." + string2 + ".images.half"));
                        PermissibleBridge permissibleBridge2 = (PermissibleBridge)this.vE.al.um.get(pluginFileConfigurationHolder.gV("huds." + string2 + ".images.negative"));
                        if (object2 == null) {
                            CommandSenderBridge_5.error("Failed to load positive font_image for hud " + string2 + ". font_image doesn't exists. " + pluginFileConfigurationHolder.nh());
                        }
                        if (permissibleBridge == null) {
                            CommandSenderBridge_5.error("Failed to load half font_image for hud " + string2 + ". font_image doesn't exists. " + pluginFileConfigurationHolder.nh());
                        }
                        if (permissibleBridge2 == null) {
                            CommandSenderBridge_5.error("Failed to load negative font_image for hud " + string2 + ". font_image doesn't exists. " + pluginFileConfigurationHolder.nh());
                        }
                        if (object2 == null || permissibleBridge == null || permissibleBridge2 == null) break;
                        PlayerBridgeImpl_3 playerBridgeImpl_3 = new PlayerBridgeImpl_3(null, string, string2, string3, RightEnum.valueOf(pluginFileConfigurationHolder.az("huds." + string2 + ".direction", "RIGHT")), (PermissibleBridge)object2, permissibleBridge, permissibleBridge2, pluginFileConfigurationHolder.gW("huds." + string2 + ".x_position_pixels"), n3, pluginFileConfigurationHolder.z("huds." + string2 + ".show.auto", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.creative", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.underwater", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.riding", true), pluginFileConfigurationHolder.gW("huds." + string2 + ".value.start"), n2, n3, pluginFileConfigurationHolder.hg("huds." + string2 + ".worlds"));
                        this.a(pluginFileConfigurationHolder, string2, playerBridgeImpl_3);
                        this.vF.put(playerBridgeImpl_3.getNamespacedID(), playerBridgeImpl_3);
                        object = playerBridgeImpl_3;
                        break;
                    }
                    case "FRAMES": {
                        Object object2 = pluginFileConfigurationHolder.hg("huds." + string2 + ".images.frames");
                        int n4 = 0;
                        for (int i = n2; i <= n3; ++i) {
                            ++n4;
                        }
                        if (object2.size() != n4) {
                            CommandSenderBridge_5.error("Frames amount " + object2.size() + " is different from total amount of possible values " + n4 + " (" + n2 + " to " + n3 + ") of hud '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                            break;
                        }
                        ArrayList<PermissibleBridge> arrayList = new ArrayList<PermissibleBridge>();
                        int n5 = n2;
                        Object object3 = object2.iterator();
                        while (object3.hasNext()) {
                            String string4 = (String)object3.next();
                            PermissibleBridge permissibleBridge = (PermissibleBridge)this.vE.al.um.get(string4);
                            if (permissibleBridge == null) {
                                CommandSenderBridge_5.error("font_image '" + string4 + "' not found for frame '" + n5 + "' of hud '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                            } else {
                                arrayList.add(permissibleBridge);
                            }
                            ++n5;
                        }
                        if (arrayList.isEmpty()) {
                            CommandSenderBridge_5.error("No frame specified for hud '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                            break;
                        }
                        object3 = new PlayerBridgeImpl_2(null, string, string2, string3, arrayList, pluginFileConfigurationHolder.gW("huds." + string2 + ".x_position_pixels"), pluginFileConfigurationHolder.z("huds." + string2 + ".show.auto", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.creative", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.underwater", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.riding", true), pluginFileConfigurationHolder.gW("huds." + string2 + ".value.start"), n2, n3, pluginFileConfigurationHolder.hg("huds." + string2 + ".worlds"));
                        this.a(pluginFileConfigurationHolder, string2, (PlayerBridge_8)object3);
                        this.vF.put(((Opaque140)object3).getNamespacedID(), object3);
                        object = object3;
                        break;
                    }
                    case "CUSTOM": {
                        Object object2 = new PlayerBridgeImpl(null, string, string2, pluginFileConfigurationHolder.az("huds." + string2 + ".value.player_stat_name", "no_stat"), pluginFileConfigurationHolder.gW("huds." + string2 + ".x_position_pixels"), pluginFileConfigurationHolder.z("huds." + string2 + ".show.auto", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.creative", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.underwater", true), pluginFileConfigurationHolder.z("huds." + string2 + ".show.riding", true), pluginFileConfigurationHolder.gW("huds." + string2 + ".value.start"), n2, n3, pluginFileConfigurationHolder.hg("huds." + string2 + ".worlds"));
                        this.a(pluginFileConfigurationHolder, string2, (PlayerBridge_8)object2);
                        this.vF.put(((Opaque140)object2).getNamespacedID(), object2);
                        object = object2;
                        break;
                    }
                }
                if (object == null) continue;
                s.cX(((Opaque140)object).getNamespacedID());
                if (string3 == null) continue;
                this.vH.add(string3);
            }
            ++n;
        }
    }

    void a(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, PlayerBridge_8 playerBridge_8) {
        if (pluginFileConfigurationHolder.gP("huds." + string + ".value.triggers")) {
            Object object;
            Object object2;
            if (pluginFileConfigurationHolder.gP("huds." + string + ".value.triggers.decrement")) {
                object2 = pluginFileConfigurationHolder.hi("huds." + string + ".value.triggers.decrement");
                for (Object object3 : object2.getKeys(false)) {
                    if (((String)object3).startsWith("generic_over_time")) {
                        object = new PlayerBridge_14(object2.getInt((String)object3 + ".every_ticks"), -((float)object2.getDouble((String)object3 + ".amount")), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                        playerBridge_8.a((PlayerWrapper_6)object);
                        continue;
                    }
                    if (((String)object3).startsWith("biome_over_time")) {
                        object = new NamespacedKeyBridge_2(EnumWrappersHolder.vC().aoJ.dO(object2.getString((String)object3 + ".biome")), object2.getInt((String)object3 + ".every_ticks"), -((float)object2.getDouble((String)object3 + ".amount")), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                        playerBridge_8.a((PlayerWrapper_6)object);
                        continue;
                    }
                    if (!((String)object3).startsWith("food_level_change")) continue;
                    object = new PlayerBridge_9((float)object2.getDouble((String)object3 + ".amount"));
                    playerBridge_8.a((KfFunction)object);
                }
            }
            if (pluginFileConfigurationHolder.gP("huds." + string + ".value.triggers.increment")) {
                object2 = pluginFileConfigurationHolder.hi("huds." + string + ".value.triggers.increment");
                for (Object object3 : object2.getKeys(false)) {
                    if (((String)object3).startsWith("food_level_change")) {
                        object = new PlayerBridge_10((float)object2.getDouble((String)object3 + ".amount"));
                        playerBridge_8.a((KfFunction)object);
                        continue;
                    }
                    if (((String)object3).startsWith("player_respawn")) {
                        object = new PlayerBridge_11((float)object2.getDouble((String)object3 + ".amount"));
                        playerBridge_8.a((KfFunction)object);
                        continue;
                    }
                    if (((String)object3).startsWith("generic_over_time")) {
                        object = new PlayerBridge_14(object2.getInt((String)object3 + ".every_ticks"), (float)object2.getDouble((String)object3 + ".amount"), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                        playerBridge_8.a((PlayerWrapper_6)object);
                        continue;
                    }
                    if (!((String)object3).startsWith("biome_over_time")) continue;
                    object = new NamespacedKeyBridge_2(EnumWrappersHolder.vC().aoJ.dO(object2.getString((String)object3 + ".biome")), object2.getInt((String)object3 + ".every_ticks"), (float)object2.getDouble((String)object3 + ".amount"), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                    playerBridge_8.a((PlayerWrapper_6)object);
                }
            }
            if (pluginFileConfigurationHolder.gP("huds." + string + ".value.triggers.on_min_value")) {
                for (Object object4 : pluginFileConfigurationHolder.gR("huds." + string + ".value.triggers.on_min_value")) {
                    Object object3;
                    if (((String)object4).startsWith("damage_player")) {
                        object3 = new PlayerBridge_12(pluginFileConfigurationHolder.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".every_ticks"), pluginFileConfigurationHolder.gX("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".damage"), playerBridge_8.jY(), EqualEnum.LESS_EQUAL);
                        playerBridge_8.a((PlayerWrapper_7)object3);
                        continue;
                    }
                    if (!((String)object4).startsWith("potion_effect")) continue;
                    object3 = pluginFileConfigurationHolder.ha("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".type");
                    if (object3 == null) {
                        CommandSenderBridge_5.error("Invalid 'type' for 'potion_effect' of  HUD '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    object = new PlayerBridge_13(pluginFileConfigurationHolder.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".every_ticks"), pluginFileConfigurationHolder.gX("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".damage"), new PotionEffectTypeBridge((PotionEffectType)object3, pluginFileConfigurationHolder.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".amplifier"), pluginFileConfigurationHolder.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".duration"), pluginFileConfigurationHolder.gY("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".ambient"), pluginFileConfigurationHolder.z("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".particles", true), pluginFileConfigurationHolder.z("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".icon", true)), EqualEnum.LESS_EQUAL);
                    playerBridge_8.a((PlayerWrapper_7)object);
                }
            }
        }
    }
}
