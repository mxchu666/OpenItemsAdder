package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginContract_20;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class MaterialBridge_2 {
    private JSONObject LP;
    private final Material ayc;

    public MaterialBridge_2(Material material, List list) {
        this.ayc = material;
        e e2 = e.a(material, Version.v1_20_6, true);
        if (e2.BN()) {
            CommandSenderBridge_5.error("Error reading vanilla model for material " + String.valueOf(material) + ", skip: " + String.valueOf(e2.BO()));
            CommandSenderBridge_5.error("Choose another material, " + String.valueOf(material) + " is not supported for these items: " + ItemStackRegistry.a(list, 5, "...and more"));
            return;
        }
        this.LP = e2.BR();
        JSONArray jSONArray = new JSONArray();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (PluginContract_20 pluginContract_20 : list) {
            ItemStackBuilder_4 itemStackBuilder_4;
            if (pluginContract_20 instanceof ItemStackBuilder_4 && (itemStackBuilder_4 = (ItemStackBuilder_4)pluginContract_20).ng() || (itemStackBuilder_4 = this.a(pluginContract_20)) == null) continue;
            jSONArray.addAll((Collection)((Object)itemStackBuilder_4));
            arrayList.add(pluginContract_20.fX());
        }
        if (!this.LP.containsKey("overrides")) {
            this.LP.put((Object)"overrides", (Object)jSONArray);
        } else {
            Iterator iterator = this.LP.getJSONArray("overrides").iterator();
            while (iterator.hasNext()) {
                try {
                    PluginContract_20 pluginContract_20;
                    pluginContract_20 = (JSONObject)iterator.next();
                    int n = pluginContract_20.getJSONObject("predicate").getInteger("custom_model_data");
                    if (!arrayList.contains(n)) continue;
                    iterator.remove();
                }
                catch (NullPointerException nullPointerException) {}
            }
            this.LP.getJSONArray("overrides").addAll((Collection)jSONArray);
        }
    }

    @Nullable
    JSONArray a(PluginContract_20 pluginContract_20) {
        if (pluginContract_20.fX() < 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        e e2 = this.ayc.equals((Object)Material.TRIDENT) ? e.f("trident_in_hand", Version.v1_20_6) : e.a(this.ayc, Version.v1_20_6, true);
        if (e2.BN()) {
            CommandSenderBridge_5.error("Error reading vanilla model for material '" + String.valueOf(this.ayc) + "': " + String.valueOf(e2.BO()));
            return null;
        }
        JSONObject jSONObject = e2.BR();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put((Object)"custom_model_data", (Object)pluginContract_20.fX());
        jSONObject2.put((Object)"predicate", (Object)jSONObject3);
        jSONObject2.put((Object)"model", (Object)pluginContract_20.d(false, true));
        jSONArray.add((Object)jSONObject2);
        if (jSONObject.containsKey("overrides")) {
            for (Object e3 : jSONObject.getJSONArray("overrides")) {
                Object object;
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = ((JSONObject)e3).getJSONObject("predicate");
                jSONObject5.put((Object)"custom_model_data", (Object)pluginContract_20.fX());
                jSONObject4.put((Object)"predicate", (Object)jSONObject5);
                String string = "";
                switch (this.ayc) {
                    case ELYTRA: {
                        if (jSONObject5.containsKey("broken") && pluginContract_20 instanceof ItemStackBuilder_4 && ((ItemStackBuilder_4)(object = (ItemStackBuilder_4)pluginContract_20)).nn() != null && ((ItemStackBuilder_4)object).nn().op() != null) {
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
                if (!pluginContract_20.fZ() && pluginContract_20.fW()) {
                    if (!pluginContract_20.ga().startsWith("minecraft:")) {
                        jSONObject4.put((Object)"model", (Object)MaterialBridge_2.a(pluginContract_20, string));
                        object = ItemStackRegistry.h(pluginContract_20.getNamespace(), pluginContract_20.d(false, false) + string + ".json");
                        File file = ItemStackRegistry.s((String)object);
                        this.G("------------------ Checking if the file " + (String)object);
                        if (file == null) {
                            if (pluginContract_20 instanceof ItemStackBuilder_4) {
                                ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)pluginContract_20;
                                CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "[Pack] Model '" + (String)object + "' not found in your contents. File: " + itemStackBuilder_4.nh());
                            } else {
                                CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "[Pack] Model '" + (String)object + "' not found in your contents.");
                            }
                        } else {
                            this.G("------------------ The file " + (String)object + " exists in the resource pack.");
                        }
                    } else {
                        jSONObject4.put((Object)"model", (Object)(pluginContract_20.ga() + string));
                    }
                } else {
                    jSONObject4.put((Object)"model", (Object)(pluginContract_20.getNamespace() + ":item/ia_auto/" + pluginContract_20.getId() + string));
                }
                jSONArray.add((Object)jSONObject4);
            }
        }
        return jSONArray;
    }

    static String a(PluginContract_20 pluginContract_20, String string) {
        String string2 = pluginContract_20.ga();
        return (String)(string2.contains(":") ? string2 : pluginContract_20.getNamespace() + ":" + string2) + string;
    }

    public String aW(boolean bl) {
        return MaterialBridge_2.O(this.ayc) + (bl ? ".json" : "");
    }

    public String Br() {
        return this.aW(false);
    }

    public String Bs() {
        return MaterialBridge_2.P(this.ayc);
    }

    public static String O(Material material) {
        return material.toString().toLowerCase();
    }

    public static String P(Material material) {
        return "minecraft:item/" + MaterialBridge_2.O(material);
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
        jSONObject.put((Object)"overrides", (Object)MaterialBridge_2.A(jSONObject));
    }

    private void G(String string) {
    }
}
