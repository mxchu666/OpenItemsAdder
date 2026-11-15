package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.bcn;
import itemsadder.m.d;
import itemsadder.m.qj;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.rp;
import itemsadder.m.rq;
import itemsadder.m.sd;
import itemsadder.m.tk;
import itemsadder.m.v;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class st {
    public static boolean b(qm qm2, bbg bbg2, bbf bbf2, String string, String string2) {
        if (bbg2.fo("resource")) {
            st.d(qm2, bbg2, bbf2, string, string2);
        } else {
            if (bbg2.fo("graphics")) {
                return st.c(qm2, bbg2, bbf2, string, string2);
            }
            if (bbg2.fo("item_model")) {
                if (!Version.isAtLeast((Version)Version.v1_21_4)) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'item_model' is only available in 1.21.4+. File: " + bbf2.nh());
                    return false;
                }
                String string3 = bbg2.gV("item_model");
                assert (string3 != null);
                String[] stringArray = string3.split(":");
                String string4 = stringArray.length == 2 ? stringArray[0] : string;
                String string5 = "assets/" + string4 + "/items/" + stringArray[stringArray.length - 1] + ".json";
                File file = d.s(string5);
                if (file != null && file.exists()) {
                    qm2.bD(bbg2.gV("item_model"));
                } else {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'item_model' path '" + string5 + "' does not exist in any contents folder. File: " + bbf2.nh());
                    return false;
                }
            }
        }
        if (qm2.FX == null) {
            d.g().Y.put(qm2.d(false, true), qm2);
        }
        return true;
    }

    private static boolean c(qm qm2, bbg bbg2, bbf bbf2, String string, String string2) {
        Object object;
        Object object2;
        if (bbg2.gP("graphics.model") && bbg2.gP("graphics.texture")) {
            bce.warn("[Items] '" + string + ":" + string2 + "'. Warning: 'graphics.model' and 'graphics.texture' are set at the same time. File: " + bbf2.nh());
            return false;
        }
        @Nullable Boolean bl = bbg2.a("graphics.hand_animation_on_swap", (Boolean)null);
        @Nullable Boolean bl2 = bbg2.a("graphics.oversized_in_gui", (Boolean)null);
        @Nullable String string3 = bbg2.az("graphics.icon", null);
        if (string3 != null) {
            string3 = v.i(string3, string);
        }
        Object object3 = null;
        if (bbg2.gP("graphics.color")) {
            object2 = bbg2.az("graphics.color", null);
            if (object2 == null) {
                object2 = "WHITE";
            }
            if ((object3 = tk.co((String)object2)) == null) {
                bce.error("[Items] '" + qm2.getNamespacedID() + "'. Invalid 'color' '" + (String)object2 + "'. File: " + bbf2.nh());
            }
        }
        object2 = null;
        if (bbg2.gP("graphics.color2")) {
            object = bbg2.az("graphics.color2", null);
            if (object == null) {
                object = "WHITE";
            }
            if ((object2 = tk.co((String)object)) == null) {
                bce.error("[Items] '" + qm2.getNamespacedID() + "'. Invalid 'color2' '" + (String)object + "'. File: " + bbf2.nh());
            }
        }
        if (object2 != null && object3 == null) {
            object3 = object2;
            object2 = null;
        }
        if (bbg2.gP("graphics.model")) {
            object = bbg2.gV("graphics.model");
            assert (object != null);
            if ((object = v.i((String)object, string)) == null) {
                bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.models' key '" + object + "' is invalid. File: " + bbf2.nh());
                return false;
            }
            if (!r.ew(object)) {
                bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.models' path '" + object + "'. File: " + bbf2.nh());
                return false;
            }
            if (!((String)object).startsWith("minecraft:")) {
                if (d.u(object) == null) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: Model '" + object + "' does not exist in any contents folder. File: " + bbf2.nh());
                    return false;
                }
            } else if (!d.g().B.Q((String)object)) {
                bce.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla model '" + object + "' does not exist. File: " + bbf2.nh());
                return false;
            }
            rp rp2 = new rp(qm2.getNamespacedID(), qm2.getType(), (String)object, string3, bl, bl2, (Integer)object3, (Integer)object2);
            qm2.a(rp2);
        } else if (bbg2.gP("graphics.models")) {
            object = new HashMap();
            bbg bbg3 = bbg2.hj("graphics.models");
            assert (bbg3 != null);
            for (String string4 : bbg3.aX(false)) {
                String string5 = bbg3.gV(string4);
                assert (string5 != null);
                if ((string5 = v.i(string5, string)) == null) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.models' key '" + string5 + "' is invalid. File: " + bbf2.nh());
                    continue;
                }
                if (!r.ew(string5)) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.models' path '" + string5 + "'. File: " + bbf2.nh());
                    continue;
                }
                if (!r.ey(string4)) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.models' key '" + string4 + "'. File: " + bbf2.nh());
                    continue;
                }
                if (!string5.startsWith("minecraft:")) {
                    if (d.u(string5) == null) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Model '" + string5 + "' does not exist in any contents folder. File: " + bbf2.nh());
                        continue;
                    }
                } else if (!d.g().B.Q(string5)) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla model '" + string5 + "' does not exist. File: " + bbf2.nh());
                    continue;
                }
                object.put(string4, string5);
            }
            if (object.isEmpty()) {
                return false;
            }
            rp rp3 = new rp(qm2.getNamespacedID(), qm2.getType(), (Map)object, string3, bl, bl2, (Integer)object3, (Integer)object2);
            qm2.a(rp3);
        } else if (bbg2.gP("graphics.texture") || bbg2.gP("graphics.textures")) {
            Object object4;
            object = new HashMap<String, Object>();
            if (bbg2.gP("graphics.texture")) {
                object4 = bbg2.gV("graphics.texture");
                if (object4 != null) {
                    if ((object4 = v.i((String)object4, string)) == null) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.texture' '" + bbg2.gV("graphics.texture") + "' is invalid. File: " + bbf2.nh());
                        return false;
                    }
                    object4 = st.ch((String)object4);
                    if (qm2 instanceof ql) {
                        object.put("all", object4);
                    } else {
                        object.put("normal", object4);
                    }
                    if (!((String)object4).startsWith("minecraft:")) {
                        if (d.t((String)object4) == null) {
                            bce.error("[Items] '" + string + ":" + string2 + "'. Error: Texture '" + (String)object4 + "' does not exist in any contents folder. File: " + bbf2.nh());
                            return false;
                        }
                    } else if (!d.g().B.R((String)object4)) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla texture '" + (String)object4 + "' does not exist. File: " + bbf2.nh());
                        return false;
                    }
                }
            } else if (bbg2.gP("graphics.textures")) {
                if (!bbg2.hR("graphics.textures")) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.textures' is malformed. File: " + bbf2.nh());
                    return false;
                }
                object4 = bbg2.hj("graphics.textures");
                assert (object4 != null);
                for (String string6 : ((bbg)object4).aX(false)) {
                    String string7 = ((bbg)object4).gV(string6);
                    assert (string7 != null);
                    if ((string7 = v.i(string7, string)) == null) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: 'graphics.textures' key '" + string6 + "' is invalid. File: " + bbf2.nh());
                        continue;
                    }
                    if (!r.ew(string7)) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.textures' path '" + string7 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    if (!r.ey(string6)) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.textures' key '" + string6 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    if (!string7.startsWith("minecraft:")) {
                        if (d.t(string7) == null) {
                            bce.error("[Items] '" + string + ":" + string2 + "'. Error: Texture '" + string7 + "' does not exist in any contents folder. File: " + bbf2.nh());
                            continue;
                        }
                    } else if (!d.g().B.R(string7)) {
                        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Vanilla texture '" + string7 + "' does not exist. File: " + bbf2.nh());
                        continue;
                    }
                    string7 = st.ch(string7);
                    object.put(string6, string7);
                }
            }
            if (object.isEmpty()) {
                return false;
            }
            object4 = bbg2.gV("graphics.parent");
            if (object4 == null) {
                object4 = st.a(qm2, object);
            } else {
                try {
                    object4 = st.t((String)object4, string);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'graphics.parent' '" + (String)object4 + "'. File: " + bbf2.nh());
                    bce.error(illegalArgumentException.getMessage());
                    return false;
                }
            }
            rq rq2 = new rq(qm2.getNamespacedID(), qm2.getType(), (String)object4, (Map)object, string3, bl, bl2, (Integer)object3, (Integer)object2);
            qm2.a(rq2);
        }
        return true;
    }

    private static String ch(String string) {
        return string.replace(".png", "");
    }

    public static String t(String string, String string2) {
        v v2;
        String[] stringArray = string.split(":");
        if (stringArray.length == 2) {
            if (d.a(string)) {
                return string;
            }
            if (stringArray[0].equals("minecraft")) {
                if (d.g().B.Q(string)) {
                    return string;
                }
                throw new IllegalArgumentException("Unknown vanilla model id: " + string);
            }
            if (d.u(string) == null) {
                throw new IllegalArgumentException("Unknown model id: " + string);
            }
        }
        if ((v2 = v.j(string, string2)) == null) {
            throw new IllegalArgumentException("Invalid model id: " + string);
        }
        if (d.u(v2.toString()) == null) {
            v2 = v.j(string, "minecraft");
            if (v2 == null) {
                throw new IllegalArgumentException("Invalid model id: " + string);
            }
            if (!d.g().B.Q(v2.toString())) {
                throw new IllegalArgumentException("Unknown vanilla model id: " + v2.toString());
            }
            return v2.toString();
        }
        return v2.toString();
    }

    private static void d(qm qm2, bbg bbg2, bbf bbf2, String string, String string2) {
        if (!bbg2.hq("resource.generate")) {
            qm2.ap(false);
            String string3 = bbg2.gV("resource.model_path");
            if (string3 == null) {
                qm2.bF("minecraft:item/barrier");
                bce.error("[Items] '" + qm2.getNamespacedID() + "'. Error: no 'model_path' set with 'generate: false'. File: " + bbf2.nh());
            } else if (r.ew(string3)) {
                qm2.bF(string3);
                @Nullable String string4 = bbg2.gV("resource.icon");
                if (string4 != null) {
                    if (Version.isOlderThan((Version)Version.v1_21_4)) {
                        bce.warn("[Items] '" + qm2.getNamespacedID() + "'. Warning: 'resource.icon' is only available in 1.21.4+ clients. File: " + bbf2.nh());
                    }
                    qm2.bG(string4);
                }
            }
            if (Main.KO.gY("debug.items.log-items-loading")) {
                bce.log("      generate = false, model_path: " + qm2.ga());
            }
        } else {
            Object object;
            qm2.ap(true);
            if (bbg2.gP("resource.texture") && (object = bbg2.hm("resource.texture")) instanceof String) {
                String string5 = (String)object;
                qm2.m(bcn.b(string5));
            } else {
                qm2.m(bbg2.hg("resource.textures"));
            }
            if (!(qm2 instanceof qj) && (qm2.getTextures() == null || qm2.getTextures().isEmpty())) {
                bce.error("[Items] '" + string + ":" + string2 + "'. No 'texture' set with 'generate: true'. File: " + bbf2.nh());
                qm2.m(bcn.a("missing_texture_check_server_logs"));
            }
            qm2.bM(bbg2.az("resource.parent", null));
            if (Main.KO.gY("debug.items.log-items-loading")) {
                bce.log("      parent: " + qm2.ga());
            }
        }
    }

    static String a(qm qm2, Map map) {
        if (qm2 instanceof ql) {
            ql ql2 = (ql)qm2;
            return switch (ql2.Hq) {
                case sd.REAL, sd.REAL_TRANSPARENT, sd.REAL_NOTE, sd.ENTITY -> {
                    if (map.size() > 1) {
                        yield "block/cube";
                    }
                    yield "block/cube_all";
                }
                case sd.TILE -> "block/base/block_tile";
                default -> "item/generated";
            };
        }
        File file = d.g().B.a(qm2.getType());
        if (file != null && file.exists()) {
            try {
                JSONObject jSONObject = c.N(file);
                if (jSONObject.containsKey("parent")) {
                    String string = jSONObject.getString("parent");
                    return string;
                }
            }
            catch (IOException iOException) {
                bce.error("Error reading vanilla model file to get parent: " + file.getAbsolutePath());
                bce.error(iOException.getMessage());
            }
        }
        return "item/generated";
    }
}
