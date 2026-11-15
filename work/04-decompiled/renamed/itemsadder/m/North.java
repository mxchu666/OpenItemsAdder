package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.c;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import itemsadder.m.BlockBridge_12;
import itemsadder.m.ColorBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_6;
import itemsadder.m.MaterialBridge_7;
import itemsadder.m.MaterialBridge_8;
import itemsadder.m.Textures;
import java.lang.invoke.CallSite;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Material;

public class North {
    private final HashMap axT = new HashMap();
    final String[] axU = new String[]{"down", "east", "north", "south", "up", "west"};
    final String[] axV = new String[]{"fire_floor0", "fire_floor1", "fire_side_alt0", "fire_side_alt1", "fire_side0", "fire_side1", "fire_up_alt0", "fire_up_alt1", "fire_up0", "fire_up1"};
    final MaterialBridge_8 axW;
    e Hd;

    public North(MaterialBridge_8 materialBridge_8) {
        this.axW = materialBridge_8;
        this.Hd = e.R(materialBridge_8.Hc);
    }

    public HashMap Bo() {
        Object object;
        switch (this.axW.Hc) {
            case ELYTRA: {
                this.axT.put("", this.Bp());
                if (this.axW.Hb == null || this.axW.Hb.nn() == null || this.axW.Hb.nn().op() == null) break;
                this.axT.put("_broken", Textures.l(this.Bp(), this.axW.Hb.nn().op()));
                break;
            }
            case BOW: {
                for (int i = 0; i < 4; ++i) {
                    String string = "";
                    if (i == 1) {
                        string = "_0";
                    } else if (i == 2) {
                        string = "_1";
                    } else if (i == 3) {
                        string = "_2";
                    }
                    this.axT.put(string, this.ga(string));
                }
                break;
            }
            case CROSSBOW: {
                for (int i = 0; i < 6; ++i) {
                    String string = "";
                    if (i == 1) {
                        string = "_0";
                    } else if (i == 2) {
                        string = "_1";
                    } else if (i == 3) {
                        string = "_2";
                    } else if (i == 4) {
                        string = "_charged";
                    } else if (i == 5) {
                        string = "_firework";
                    }
                    this.axT.put(string, this.ga(string));
                }
                break;
            }
            case FISHING_ROD: {
                for (int i = 0; i <= 1; ++i) {
                    String string = "";
                    if (i == 1) {
                        string = "_cast";
                    }
                    this.axT.put(string, this.ga(string));
                }
                break;
            }
            case SHIELD: {
                for (int i = 0; i <= 1; ++i) {
                    String string = "";
                    if (i == 1) {
                        string = "_blocking";
                    }
                    this.axT.put(string, this.ga(string));
                }
                break;
            }
            case TRIDENT: {
                for (int i = 0; i <= 1; ++i) {
                    String string = "";
                    if (i == 0) {
                        string = "_in_hand";
                    }
                    if (i == 1) {
                        string = "_throwing";
                    }
                    this.axT.put(string, this.ga(string));
                }
                break;
            }
            default: {
                if (this.axW.Hc == Material.BUNDLE) {
                    this.axT.put("", this.ga(""));
                    this.axT.put("_filled", this.ga("_filled"));
                    break;
                }
                if (this.axW.Hb instanceof BlockBridge_12) {
                    for (String string : this.axV) {
                        object = new c(String.format("internal/fire/%s.json", string));
                        this.axT.put("_" + string, this.a((c)object));
                    }
                    this.axT.put("", this.Bp());
                    break;
                }
                this.axT.put("", this.Bp());
            }
        }
        HashMap<CallSite, String> hashMap = new HashMap<CallSite, String>();
        for (Map.Entry entry : this.axT.entrySet()) {
            String string;
            string = (JSONObject)entry.getValue();
            object = (String)entry.getKey();
            hashMap.put((CallSite)((Object)("assets/" + this.axW.getNamespace() + "/models/" + this.axW.g(false, false) + (String)object + ".json")), string);
        }
        return hashMap;
    }

    private JSONObject a(c c2) {
        assert (this.axW.Hb != null);
        c2.BK().put((Object)"fire", this.axW.Hb.getTextures().get(0));
        return c2.BR();
    }

    private JSONObject Bp() {
        return this.ga("");
    }

    private JSONObject ga(String string) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object)"parent", (Object)this.axW.nm());
        JSONObject jSONObject2 = new JSONObject();
        List list = this.axW.getTextures();
        if (this.axW instanceof MaterialBridge_7) {
            North.a(jSONObject, this.axW, string, list, jSONObject2);
        } else if (!(this.axW.Hb instanceof LocationBridgeBuilder_2) && this.axW.Hc.isBlock()) {
            String string2;
            if (!this.Hd.BN() && !list.isEmpty() && (string2 = this.Hd.BS()) != null && string2.equals("layer0")) {
                jSONObject2.put((Object)this.Hd.BS(), (Object)(((String)list.get(0)).replace(".png", "") + string));
            }
        } else if (this.axW.Hc.isBlock() || this.axW.Hb instanceof LocationBridgeBuilder_2) {
            if (this.axW.Hc == Material.PLAYER_HEAD) {
                jSONObject2.put((Object)"layer0", (Object)(((String)list.get(0)).replace(".png", "") + string));
            } else {
                if (list.size() == 1) {
                    jSONObject2.put((Object)"all", (Object)(((String)list.get(0)).replace(".png", "") + string));
                } else {
                    for (int i = 0; i < list.size(); ++i) {
                        jSONObject2.put((Object)this.axU[i], (Object)(((String)list.get(i)).replace(".png", "") + string));
                    }
                }
                if (list.isEmpty()) {
                    if (this.axW.Hb != null) {
                        CommandSenderBridge_5.error("&cItem &6" + this.axW.getNamespacedID() + " &chas no textures set. Please check the file &6" + this.axW.Hb.nh());
                    }
                } else {
                    jSONObject2.put((Object)"particle", (Object)(((String)list.get(0)).replace(".png", "") + string));
                }
            }
        } else {
            North.a(jSONObject, this.axW, string, list, jSONObject2);
        }
        jSONObject.put((Object)"textures", (Object)jSONObject2);
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, MaterialBridge_8 materialBridge_8, String string, List list, JSONObject jSONObject2) {
        for (int i = 0; i < list.size(); ++i) {
            jSONObject2.put((Object)("layer" + i), (Object)(((String)list.get(i)).replace(".png", "") + string));
        }
        Material material = materialBridge_8.Hc;
        if (materialBridge_8.Hb instanceof MaterialBridge_6) {
            jSONObject.put((Object)"parent", (Object)"minecraft:item/generated");
            if (!jSONObject2.containsKey("layer0")) {
                jSONObject2.put((Object)"layer0", (Object)("item/" + material.toString().toLowerCase().replace("leather_", "iron_")));
                jSONObject2.put((Object)"layer1", (Object)"item/empty");
            } else {
                ColorBridge_2 colorBridge_2 = ((MaterialBridge_6)materialBridge_8.Hb).mB();
                if (colorBridge_2 != null && !colorBridge_2.HI) {
                    jSONObject2.put((Object)"layer1", (Object)jSONObject2.getString("layer0"));
                    jSONObject2.put((Object)"layer0", (Object)"item/empty");
                }
            }
        }
    }
}
