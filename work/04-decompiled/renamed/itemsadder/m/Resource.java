package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_11;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.MaterialBridge_6;
import itemsadder.m.Opaque022;
import itemsadder.m.Opaque134;
import itemsadder.m.Opaque140;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RealEnum;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class Resource {
    public static boolean b(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2) {
        if (configurationSectionBridge.fo("resource")) {
            Resource.d(itemStackBuilder_4, configurationSectionBridge, pluginFileConfigurationHolder, string, string2);
        } else {
            if (configurationSectionBridge.fo("graphics")) {
                return Resource.c(itemStackBuilder_4, configurationSectionBridge, pluginFileConfigurationHolder, string, string2);
            }
            if (configurationSectionBridge.fo("item_model")) {
                if (!Version.isAtLeast((Version)Version.v1_21_4)) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'item_model' is only available in 1.21.4+. File: " + pluginFileConfigurationHolder.nh());
                    return false;
                }
                String string3 = configurationSectionBridge.gV("item_model");
                assert (string3 != null);
                String[] stringArray = string3.split(":");
                String string4 = stringArray.length == 2 ? stringArray[0] : string;
                String string5 = "assets/" + string4 + "/items/" + stringArray[stringArray.length - 1] + ".json";
                File file = ItemStackRegistry.s(string5);
                if (file != null && file.exists()) {
                    itemStackBuilder_4.bD(configurationSectionBridge.gV("item_model"));
                } else {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'item_model' path '" + string5 + "' does not exist in any contents folder. File: " + pluginFileConfigurationHolder.nh());
                    return false;
                }
            }
        }
        if (itemStackBuilder_4.FX == null) {
            ItemStackRegistry.g().Y.put(itemStackBuilder_4.d(false, true), itemStackBuilder_4);
        }
        return true;
    }

    private static boolean c(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2) {
        Object object;
        Object object2;
        if (configurationSectionBridge.gP("graphics.model") && configurationSectionBridge.gP("graphics.texture")) {
            CommandSenderBridge_5.warn("[Items] '" + string + ":" + string2 + "'. Warning: 'graphics.model' and 'graphics.texture' are set at the same time. File: " + pluginFileConfigurationHolder.nh());
            return false;
        }
        @Nullable Boolean bl = configurationSectionBridge.a("graphics.hand_animation_on_swap", (Boolean)null);
        @Nullable Boolean bl2 = configurationSectionBridge.a("graphics.oversized_in_gui", (Boolean)null);
        @Nullable String string3 = configurationSectionBridge.az("graphics.icon", null);
        if (string3 != null) {
            string3 = Opaque140.i(string3, string);
        }
        Object object3 = null;
        if (configurationSectionBridge.gP("graphics.color")) {
            object2 = configurationSectionBridge.az("graphics.color", null);
            if (object2 == null) {
                object2 = "WHITE";
            }
            if ((object3 = Opaque134.co((String)object2)) == null) {
                CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Invalid 'color' '" + (String)object2 + "'. File: " + pluginFileConfigurationHolder.nh());
            }
        }
        object2 = null;
        if (configurationSectionBridge.gP("graphics.color2")) {
            object = configurationSectionBridge.az("graphics.color2", null);
            if (object == null) {
                object = "WHITE";
            }
            if ((object2 = Opaque134.co((String)object)) == null) {
                CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Invalid 'color2' '" + (String)object + "'. File: " + pluginFileConfigurationHolder.nh());
            }
        }
        if (object2 != null && object3 == null) {
            object3 = object2;
            object2 = null;
        }
        if (configurationSectionBridge.gP("graphics.model")) {
            object = configurationSectionBridge.gV("graphics.model");
            assert (object != null);
            if ((object = Opaque140.i((String)object, string)) == null) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.models' key '" + object + "' is invalid. File: " + pluginFileConfigurationHolder.nh());
                return false;
            }
            if (!r.ew(object)) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.models' path '" + object + "'. File: " + pluginFileConfigurationHolder.nh());
                return false;
            }
            if (!((String)object).startsWith("minecraft:")) {
                if (ItemStackRegistry.u(object) == null) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Model '" + object + "' does not exist in any contents folder. File: " + pluginFileConfigurationHolder.nh());
                    return false;
                }
            } else if (!ItemStackRegistry.g().B.Q((String)object)) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla model '" + object + "' does not exist. File: " + pluginFileConfigurationHolder.nh());
                return false;
            }
            MaterialBridge_11 materialBridge_11 = new MaterialBridge_11(itemStackBuilder_4.getNamespacedID(), itemStackBuilder_4.getType(), (String)object, string3, bl, bl2, (Integer)object3, (Integer)object2);
            itemStackBuilder_4.a(materialBridge_11);
        } else if (configurationSectionBridge.gP("graphics.models")) {
            object = new HashMap();
            ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("graphics.models");
            assert (configurationSectionBridge2 != null);
            for (String string4 : configurationSectionBridge2.aX(false)) {
                String string5 = configurationSectionBridge2.gV(string4);
                assert (string5 != null);
                if ((string5 = Opaque140.i(string5, string)) == null) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.models' key '" + string5 + "' is invalid. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (!r.ew(string5)) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.models' path '" + string5 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (!r.ey(string4)) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.models' key '" + string4 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (!string5.startsWith("minecraft:")) {
                    if (ItemStackRegistry.u(string5) == null) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Model '" + string5 + "' does not exist in any contents folder. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                } else if (!ItemStackRegistry.g().B.Q(string5)) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla model '" + string5 + "' does not exist. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                object.put(string4, string5);
            }
            if (object.isEmpty()) {
                return false;
            }
            MaterialBridge_11 materialBridge_11 = new MaterialBridge_11(itemStackBuilder_4.getNamespacedID(), itemStackBuilder_4.getType(), (Map)object, string3, bl, bl2, (Integer)object3, (Integer)object2);
            itemStackBuilder_4.a(materialBridge_11);
        } else if (configurationSectionBridge.gP("graphics.texture") || configurationSectionBridge.gP("graphics.textures")) {
            Object object4;
            object = new HashMap<String, Object>();
            if (configurationSectionBridge.gP("graphics.texture")) {
                object4 = configurationSectionBridge.gV("graphics.texture");
                if (object4 != null) {
                    if ((object4 = Opaque140.i((String)object4, string)) == null) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.texture' '" + configurationSectionBridge.gV("graphics.texture") + "' is invalid. File: " + pluginFileConfigurationHolder.nh());
                        return false;
                    }
                    object4 = Resource.ch((String)object4);
                    if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
                        object.put("all", object4);
                    } else {
                        object.put("normal", object4);
                    }
                    if (!((String)object4).startsWith("minecraft:")) {
                        if (ItemStackRegistry.t((String)object4) == null) {
                            CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Texture '" + (String)object4 + "' does not exist in any contents folder. File: " + pluginFileConfigurationHolder.nh());
                            return false;
                        }
                    } else if (!ItemStackRegistry.g().B.R((String)object4)) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla texture '" + (String)object4 + "' does not exist. File: " + pluginFileConfigurationHolder.nh());
                        return false;
                    }
                }
            } else if (configurationSectionBridge.gP("graphics.textures")) {
                if (!configurationSectionBridge.hR("graphics.textures")) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.textures' is malformed. File: " + pluginFileConfigurationHolder.nh());
                    return false;
                }
                object4 = configurationSectionBridge.hj("graphics.textures");
                assert (object4 != null);
                for (String string6 : ((ConfigurationSectionBridge)object4).aX(false)) {
                    String string7 = ((ConfigurationSectionBridge)object4).gV(string6);
                    assert (string7 != null);
                    if ((string7 = Opaque140.i(string7, string)) == null) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.textures' key '" + string6 + "' is invalid. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    if (!r.ew(string7)) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.textures' path '" + string7 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    if (!r.ey(string6)) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.textures' key '" + string6 + "'. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    if (!string7.startsWith("minecraft:")) {
                        if (ItemStackRegistry.t(string7) == null) {
                            CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Texture '" + string7 + "' does not exist in any contents folder. File: " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                    } else if (!ItemStackRegistry.g().B.R(string7)) {
                        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla texture '" + string7 + "' does not exist. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    string7 = Resource.ch(string7);
                    object.put(string6, string7);
                }
            }
            if (object.isEmpty()) {
                return false;
            }
            object4 = configurationSectionBridge.gV("graphics.parent");
            if (object4 == null) {
                object4 = Resource.a(itemStackBuilder_4, object);
            } else {
                try {
                    object4 = Resource.t((String)object4, string);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.parent' '" + (String)object4 + "'. File: " + pluginFileConfigurationHolder.nh());
                    CommandSenderBridge_5.error(illegalArgumentException.getMessage());
                    return false;
                }
            }
            MaterialBridge_12 materialBridge_12 = new MaterialBridge_12(itemStackBuilder_4.getNamespacedID(), itemStackBuilder_4.getType(), (String)object4, (Map)object, string3, bl, bl2, (Integer)object3, (Integer)object2);
            itemStackBuilder_4.a(materialBridge_12);
        }
        return true;
    }

    private static String ch(String string) {
        return string.replace(".png", "");
    }

    public static String t(String string, String string2) {
        Opaque140 opaque140;
        String[] stringArray = string.split(":");
        if (stringArray.length == 2) {
            if (ItemStackRegistry.a(string)) {
                return string;
            }
            if (stringArray[0].equals("minecraft")) {
                if (ItemStackRegistry.g().B.Q(string)) {
                    return string;
                }
                throw new IllegalArgumentException("Unknown vanilla model id: " + string);
            }
            if (ItemStackRegistry.u(string) == null) {
                throw new IllegalArgumentException("Unknown model id: " + string);
            }
        }
        if ((opaque140 = Opaque140.j(string, string2)) == null) {
            throw new IllegalArgumentException("Invalid model id: " + string);
        }
        if (ItemStackRegistry.u(opaque140.toString()) == null) {
            opaque140 = Opaque140.j(string, "minecraft");
            if (opaque140 == null) {
                throw new IllegalArgumentException("Invalid model id: " + string);
            }
            if (!ItemStackRegistry.g().B.Q(opaque140.toString())) {
                throw new IllegalArgumentException("Unknown vanilla model id: " + opaque140.toString());
            }
            return opaque140.toString();
        }
        return opaque140.toString();
    }

    private static void d(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2) {
        if (!configurationSectionBridge.hq("resource.generate")) {
            itemStackBuilder_4.ap(false);
            String string3 = configurationSectionBridge.gV("resource.model_path");
            if (string3 == null) {
                itemStackBuilder_4.bF("minecraft:item/barrier");
                CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Error: no 'model_path' set with 'generate: false'. File: " + pluginFileConfigurationHolder.nh());
            } else if (r.ew(string3)) {
                itemStackBuilder_4.bF(string3);
                @Nullable String string4 = configurationSectionBridge.gV("resource.icon");
                if (string4 != null) {
                    if (Version.isOlderThan((Version)Version.v1_21_4)) {
                        CommandSenderBridge_5.warn("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Warning: 'resource.icon' is only available in 1.21.4+ clients. File: " + pluginFileConfigurationHolder.nh());
                    }
                    itemStackBuilder_4.bG(string4);
                }
            }
            if (Main.KO.gY("debug.items.log-items-loading")) {
                CommandSenderBridge_5.log("      generate = false, model_path: " + itemStackBuilder_4.ga());
            }
        } else {
            Object object;
            itemStackBuilder_4.ap(true);
            if (configurationSectionBridge.gP("resource.texture") && (object = configurationSectionBridge.hm("resource.texture")) instanceof String) {
                String string5 = (String)object;
                itemStackBuilder_4.m(Opaque022.b(string5));
            } else {
                itemStackBuilder_4.m(configurationSectionBridge.hg("resource.textures"));
            }
            if (!(itemStackBuilder_4 instanceof MaterialBridge_6) && (itemStackBuilder_4.getTextures() == null || itemStackBuilder_4.getTextures().isEmpty())) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. No 'texture' set with 'generate: true'. File: " + pluginFileConfigurationHolder.nh());
                itemStackBuilder_4.m(Opaque022.a("missing_texture_check_server_logs"));
            }
            itemStackBuilder_4.bM(configurationSectionBridge.az("resource.parent", null));
            if (Main.KO.gY("debug.items.log-items-loading")) {
                CommandSenderBridge_5.log("      parent: " + itemStackBuilder_4.ga());
            }
        }
    }

    static String a(ItemStackBuilder_4 itemStackBuilder_4, Map map) {
        if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = (LocationBridgeBuilder_2)itemStackBuilder_4;
            return switch (locationBridgeBuilder_2.Hq) {
                case RealEnum.REAL, RealEnum.REAL_TRANSPARENT, RealEnum.REAL_NOTE, RealEnum.ENTITY -> {
                    if (map.size() > 1) {
                        yield "block/cube";
                    }
                    yield "block/cube_all";
                }
                case RealEnum.TILE -> "block/base/block_tile";
                default -> "item/generated";
            };
        }
        File file = ItemStackRegistry.g().B.a(itemStackBuilder_4.getType());
        if (file != null && file.exists()) {
            try {
                JSONObject jSONObject = c.N(file);
                if (jSONObject.containsKey("parent")) {
                    String string = jSONObject.getString("parent");
                    return string;
                }
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Error reading vanilla model file to get parent: " + file.getAbsolutePath());
                CommandSenderBridge_5.error(iOException.getMessage());
            }
        }
        return "item/generated";
    }
}
