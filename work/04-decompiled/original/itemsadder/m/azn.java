package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.qx;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class azn {
    private JSONObject LP;
    private final Material ayc;

    public azn(Material material, List list) {
        this.ayc = material;
        e e2 = e.a(material, Version.v1_20_6, true);
        if (e2.BN()) {
            bce.error("Error reading vanilla model for material " + String.valueOf(material) + ", skip: " + String.valueOf(e2.BO()));
            bce.error("Choose another material, " + String.valueOf(material) + " is not supported for these items: " + d.a(list, 5, "...and more"));
            return;
        }
        this.LP = e2.BR();
        JSONArray jSONArray = new JSONArray();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (qx qx2 : list) {
            qm qm2;
            if (qx2 instanceof qm && (qm2 = (qm)qx2).ng() || (qm2 = this.a(qx2)) == null) continue;
            jSONArray.addAll((Collection)((Object)qm2));
            arrayList.add(qx2.fX());
        }
        if (!this.LP.containsKey("overrides")) {
            this.LP.put((Object)"overrides", (Object)jSONArray);
        } else {
            Iterator iterator = this.LP.getJSONArray("overrides").iterator();
            while (iterator.hasNext()) {
                try {
                    qx qx2;
                    qx2 = (JSONObject)iterator.next();
                    int n = qx2.getJSONObject("predicate").getInteger("custom_model_data");
                    if (!arrayList.contains(n)) continue;
                    iterator.remove();
                }
                catch (NullPointerException nullPointerException) {}
            }
            this.LP.getJSONArray("overrides").addAll((Collection)jSONArray);
        }
    }

    @Nullable
    JSONArray a(qx qx2) {
        if (qx2.fX() < 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        e e2 = this.ayc.equals((Object)Material.TRIDENT) ? e.f("trident_in_hand", Version.v1_20_6) : e.a(this.ayc, Version.v1_20_6, true);
        if (e2.BN()) {
            bce.error("Error reading vanilla model for material '" + String.valueOf(this.ayc) + "': " + String.valueOf(e2.BO()));
            return null;
        }
        JSONObject jSONObject = e2.BR();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put((Object)"custom_model_data", (Object)qx2.fX());
        jSONObject2.put((Object)"predicate", (Object)jSONObject3);
        jSONObject2.put((Object)"model", (Object)qx2.d(false, true));
        jSONArray.add((Object)jSONObject2);
        if (jSONObject.containsKey("overrides")) {
            for (Object e3 : jSONObject.getJSONArray("overrides")) {
                Object object;
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = ((JSONObject)e3).getJSONObject("predicate");
                jSONObject5.put((Object)"custom_model_data", (Object)qx2.fX());
                jSONObject4.put((Object)"predicate", (Object)jSONObject5);
                String string = "";
                switch (this.ayc) {
                    case ELYTRA: {
                        if (jSONObject5.containsKey("broken") && qx2 instanceof qm && ((qm)(object = (qm)qx2)).nn() != null && ((qm)object).nn().op() != null) {
                            string = "_broken";
                            break;
                        }
                        if (jSONObject5.containsKey("broken")) break;
                        jSONObject5.put((Object)"broken", (Object)0);
                        break;
                    }
                    case SHIELD: {
                        if (jSONObject5.containsKey("blocking")) {
                            string = "_blocking";
                            break;
                        }
                        jSONObject5.put((Object)"blocking", (Object)0);
                        break;
                    }
                    case BOW: {
                        if (jSONObject5.containsKey("pulling")) {
                            if (jSONObject5.containsKey("pull")) {
                                if (jSONObject5.getString("pull").equals("0.65")) {
                                    string = "_1";
                                    break;
                                }
                                if (!jSONObject5.getString("pull").equals("0.9")) break;
                                string = "_2";
                                break;
                            }
                            string = "_0";
                            break;
                        }
                        jSONObject5.put((Object)"pulling", (Object)0);
                        break;
                    }
                    case CROSSBOW: {
                        if (jSONObject5.containsKey("pulling")) {
                            if (jSONObject5.containsKey("pull")) {
                                if (jSONObject5.getString("pull").equals("0.58")) {
                                    string = "_1";
                                    break;
                                }
                                if (!jSONObject5.getString("pull").equals("1.0")) break;
                                string = "_2";
                                break;
                            }
                            string = "_0";
                            break;
                        }
                        if (jSONObject5.containsKey("firework")) {
                            if (jSONObject5.getInteger("firework") != 1) break;
                            string = "_firework";
                            break;
                        }
                        if (jSONObject5.containsKey("charged")) {
                            if (jSONObject5.getInteger("charged") != 1) break;
                            string = "_charged";
                            break;
                        }
                        jSONObject5.put((Object)"pulling", (Object)0);
                        break;
                    }
                    case FISHING_ROD: {
                        if (jSONObject5.containsKey("cast")) {
                            if (jSONObject5.getInteger("cast") != 1) break;
                            string = "_cast";
                            break;
                        }
                        jSONObject5.put((Object)"cast", (Object)0);
                        break;
                    }
                    case TRIDENT: {
                        if (jSONObject5.containsKey("throwing")) {
                            string = "_throwing";
                            break;
                        }
                        string = "_in_hand";
                        jSONObject5.put((Object)"throwing", (Object)0);
                        break;
                    }
                    default: {
                        if (!this.ayc.toString().equals("BUNDLE")) break;
                        if (jSONObject5.containsKey("filled")) {
                            string = "_filled";
                            break;
                        }
                        jSONObject5.put((Object)"filled", (Object)1.0E-7);
                    }
                }
                if (!qx2.fZ() && qx2.fW()) {
                    if (!qx2.ga().startsWith("minecraft:")) {
                        jSONObject4.put((Object)"model", (Object)azn.a(qx2, string));
                        object = d.h(qx2.getNamespace(), qx2.d(false, false) + string + ".json");
                        File file = d.s((String)object);
                        this.G("------------------ Checking if the file " + (String)object);
                        if (file == null) {
                            if (qx2 instanceof qm) {
                                qm qm2 = (qm)qx2;
                                bce.error(String.valueOf(ChatColor.RED) + "[Pack] Model '" + (String)object + "' not found in your contents. File: " + qm2.nh());
                            } else {
                                bce.error(String.valueOf(ChatColor.RED) + "[Pack] Model '" + (String)object + "' not found in your contents.");
                            }
                        } else {
                            this.G("------------------ The file " + (String)object + " exists in the resource pack.");
                        }
                    } else {
                        jSONObject4.put((Object)"model", (Object)(qx2.ga() + string));
                    }
                } else {
                    jSONObject4.put((Object)"model", (Object)(qx2.getNamespace() + ":item/ia_auto/" + qx2.getId() + string));
                }
                jSONArray.add((Object)jSONObject4);
            }
        }
        return jSONArray;
    }

    static String a(qx qx2, String string) {
        String string2 = qx2.ga();
        return (String)(string2.contains(":") ? string2 : qx2.getNamespace() + ":" + string2) + string;
    }

    public String aW(boolean bl) {
        return azn.O(this.ayc) + (bl ? ".json" : "");
    }

    public String Br() {
        return this.aW(false);
    }

    public String Bs() {
        return azn.P(this.ayc);
    }

    public static String O(Material material) {
        return material.toString().toLowerCase();
    }

    public static String P(Material material) {
        return "minecraft:item/" + azn.O(material);
    }

    public static String Q(Material material) {
        return e.a(material, Version.v1_20_6).oC();
    }

    public JSONObject zd() {
        return this.LP;
    }

    public static JSONArray A(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("overrides");
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.addAll((Collection)jSONArray);
        jSONArray2.sort((object, object2) -> {
            try {
                int n = -100;
                int n2 = -100;
                if (((JSONObject)object).getJSONObject("predicate").containsKey("custom_model_data")) {
                    n = ((JSONObject)object).getJSONObject("predicate").getInteger("custom_model_data");
                }
                if (((JSONObject)object2).getJSONObject("predicate").containsKey("custom_model_data")) {
                    n2 = ((JSONObject)object2).getJSONObject("predicate").getInteger("custom_model_data");
                }
                return Integer.compare(n, n2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return 0;
            }
        });
        return jSONArray2;
    }

    public static void B(JSONObject jSONObject) {
        jSONObject.put((Object)"overrides", (Object)azn.A(jSONObject));
    }

    private void G(String string) {
    }
}
