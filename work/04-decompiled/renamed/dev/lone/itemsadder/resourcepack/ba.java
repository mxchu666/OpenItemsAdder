package dev.lone.itemsadder.resourcepack;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.lone.itemsadder.resourcepack.bb;
import dev.lone.itemsadder.resourcepack.bc;
import dev.lone.itemsadder.resourcepack.bd;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ba {
    private static final String auq = "player_model";
    private static final String aur = "_iainternal";
    private static final String aus = "_iainternal\\models\\item\\player_model";
    private static final double aut = 0.0;
    private static final double auu = 0.1;
    private static final double auv = 0.05;
    private static final double auw = 0.15;
    private static final double auxx = 0.8;
    private static final double auy = -1.2;
    private static final double auz = 0.4;
    private static final int auA = 64;
    private static final int auB = 32;
    private static final double auC = 0.25;
    private static final int auD = 8;
    private static final int auE = 12;
    private static final int auF = 4;
    private static final int auG = 8;
    private static final int auH = 8;
    private static final int auI = 8;
    private static final int auJ = 12;
    private static final int auK = 4;
    private static final int auL = 4;
    private static final int auM = 3;
    private static final int auN = 96;
    private static final int auO = 48;
    private static final int auP = 32;
    private static final int auQ = 64;
    private static final int auR = 64;
    private static final int auS = 64;
    private final Gson auT = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final Gson auU = new GsonBuilder().disableHtmlEscaping().create();
    private final Map auV = new LinkedHashMap();

    public Map zG() {
        this.zH();
        this.fx("body");
        this.fx("head");
        this.fx("left_arm");
        this.fx("right_arm");
        this.fx("left_arm_slim");
        this.fx("right_arm_slim");
        this.fx("left_leg");
        this.fx("right_leg");
        bc bc2 = this.zI();
        bc bc3 = this.zJ();
        bc bc4 = this.t("right_arm", false);
        bc bc5 = this.t("left_arm", false);
        bc bc6 = this.t("right_arm", true);
        bc bc7 = this.t("left_arm", true);
        bc bc8 = this.t("right_leg", false);
        bc bc9 = this.t("left_leg", false);
        this.c(bc2.auZ, bc2.ava, ba.fu("_iainternal\\items\\player_model\\torso.json"));
        this.c(bc3.auZ, bc3.ava, ba.fu("_iainternal\\items\\player_model\\head.json"));
        this.c(bc4.auZ, bc4.ava, ba.fu("_iainternal\\items\\player_model\\right_arm.json"));
        this.c(bc6.auZ, bc6.ava, ba.fu("_iainternal\\items\\player_model\\right_arm_slim.json"));
        this.c(bc5.auZ, bc5.ava, ba.fu("_iainternal\\items\\player_model\\left_arm.json"));
        this.c(bc7.auZ, bc7.ava, ba.fu("_iainternal\\items\\player_model\\left_arm_slim.json"));
        this.c(bc8.auZ, bc8.ava, ba.fu("_iainternal\\items\\player_model\\right_leg.json"));
        this.c(bc9.auZ, bc9.ava, ba.fu("_iainternal\\items\\player_model\\left_leg.json"));
        this.d(bc2.auZ, bc2.ava, ba.fu("_iainternal\\items\\player_model\\torso.json"));
        this.d(bc3.auZ, bc3.ava, ba.fu("_iainternal\\items\\player_model\\head.json"));
        this.d(bc4.auZ, bc4.ava, ba.fu("_iainternal\\items\\player_model\\right_arm.json"));
        this.d(bc6.auZ, bc6.ava, ba.fu("_iainternal\\items\\player_model\\right_arm_slim.json"));
        this.d(bc5.auZ, bc5.ava, ba.fu("_iainternal\\items\\player_model\\left_arm.json"));
        this.d(bc7.auZ, bc7.ava, ba.fu("_iainternal\\items\\player_model\\left_arm_slim.json"));
        this.d(bc8.auZ, bc8.ava, ba.fu("_iainternal\\items\\player_model\\right_leg.json"));
        this.d(bc9.auZ, bc9.ava, ba.fu("_iainternal\\items\\player_model\\left_leg.json"));
        this.zK();
        return Collections.unmodifiableMap(this.auV);
    }

    private static String fu(String string) {
        return string;
    }

    private List a(double d, double d2, double d3, double d4, boolean bl, boolean bl2) {
        double d5;
        double d6 = d;
        double d7 = d2;
        double d8 = d + d3;
        double d9 = d2 + d4;
        if (bl) {
            d5 = d6;
            d6 = d8;
            d8 = d5;
        }
        if (bl2) {
            d5 = d7;
            d7 = d9;
            d9 = d5;
        }
        return Arrays.asList(d6, d7, d8, d9);
    }

    private bd a(String string, String string2, int n, String string3) {
        String string4 = string2 != null ? string2 + "_cube_" + n + string3 : string + "_cube_" + n + string3;
        bd bd2 = new bd();
        bd2.avb = "_iainternal\\models\\item\\player_model\\" + string4 + ".json";
        bd2.ps = "_iainternal:item/player_model/" + string4;
        return bd2;
    }

    private bd aj(String string, String string2) {
        String string3 = string2 != null ? string2 + "_cube" : string + "_cube";
        bd bd2 = new bd();
        bd2.avb = "_iainternal\\models\\item\\player_model\\" + string3 + ".json";
        bd2.ps = "_iainternal:item/player_model/" + string3;
        return bd2;
    }

    private bb ak(String string, String string2) {
        List<Integer> list = Arrays.asList(90, 0, 0);
        if ("body".equals(string)) {
            return this.a(Arrays.asList(6.6, -10.0, 23.5), Arrays.asList(0.96, 0.94, 1.0), list);
        }
        if ("head".equals(string)) {
            return this.a(Arrays.asList(6.6, -9.9, 21.1), Arrays.asList(0.96, 0.96, 0.96), list);
        }
        if ("left_arm".equals(string2)) {
            return this.a(Arrays.asList(6.0, -10.0, 13.5), Arrays.asList(0.96, 0.93, 1.0), list);
        }
        if ("right_arm".equals(string2)) {
            return this.a(Arrays.asList(7.1, -10.0, 13.5), Arrays.asList(0.96, 0.93, 1.0), list);
        }
        if ("left_arm_slim".equals(string2)) {
            return this.a(Arrays.asList(6.5, -10.0, 13.5), Arrays.asList(0.96, 0.93, 1.0), list);
        }
        if ("right_arm_slim".equals(string2)) {
            return this.a(Arrays.asList(6.6, -10.0, 13.5), Arrays.asList(0.96, 0.93, 1.0), list);
        }
        if ("right_leg".equals(string2)) {
            return this.a(Arrays.asList(6.6, -10.0, 12.2), Arrays.asList(0.96, 0.93, 1.0), list);
        }
        if ("left_leg".equals(string2)) {
            return this.a(Arrays.asList(6.5, -10.0, 12.2), Arrays.asList(0.96, 0.93, 1.0), list);
        }
        return this.a(Arrays.asList(5.8, -10.0, 14.3), Arrays.asList(1.0, 1.0, 1.0), list);
    }

    private bb a(List list, List list2, List list3) {
        bb bb2 = new bb();
        bb2.auW = list;
        bb2.auXX = list2;
        bb2.auY = list3;
        return bb2;
    }

    private void a(String string, JsonElement jsonElement) {
        String string2 = this.auT.toJson(jsonElement);
        this.auV.put(string, string2.getBytes(StandardCharsets.UTF_8));
    }

    private JsonObject fv(String string) {
        byte[] byArray = (byte[])this.auV.get(string);
        if (byArray == null) {
            throw new IllegalStateException("File not found in memory: " + string);
        }
        String string2 = new String(byArray, StandardCharsets.UTF_8);
        return JsonParser.parseString(string2).getAsJsonObject();
    }

    private String fw(String string) {
        String string2 = "_iainternal:item/player_model/";
        if (!string.startsWith(string2)) {
            throw new IllegalArgumentException("Unexpected modelPath " + string);
        }
        String string3 = string.substring(string2.length());
        return "_iainternal\\models\\item\\player_model\\" + string3 + ".json";
    }

    private String a(int n, double d, double d2, double d3, double d4, double d5, double d6, Map map, String string, String string2) {
        JsonObject jsonObject = new JsonObject();
        String string3 = string2 != null ? string2 : string;
        jsonObject.addProperty("parent", "_iainternal:item/player_model/" + string3 + "_cube");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("shade", false);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(d);
        jsonArray.add(d2);
        jsonArray.add(d3);
        jsonObject2.add("from", jsonArray);
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add(d + d4 + 0.0);
        jsonArray2.add(d2 + d5 + 0.0);
        jsonArray2.add(d3 + d6 + 0.0);
        jsonObject2.add("to", jsonArray2);
        JsonObject jsonObject3 = new JsonObject();
        for (Map.Entry object2 : map.entrySet()) {
            jsonObject3.add((String)object2.getKey(), (JsonElement)object2.getValue());
        }
        jsonObject2.add("faces", jsonObject3);
        JsonArray jsonArray3 = new JsonArray();
        jsonArray3.add(jsonObject2);
        jsonObject.add("elements", jsonArray3);
        bd bd2 = this.a(string, string2, n, "");
        this.a(bd2.avb, jsonObject);
        return bd2.ps;
    }

    private String fx(String string) {
        bb bb2 = this.ak(string, string);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("parent", "_iainternal:item/player_model/parent_cube");
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("translation", this.K(bb2.auW));
        jsonObject3.add("scale", this.K(bb2.auXX));
        jsonObject3.add("rotation", this.L(bb2.auY));
        jsonObject2.add("thirdperson_righthand", jsonObject3);
        jsonObject.add("display", jsonObject2);
        bd bd2 = this.aj(string, string);
        this.a(bd2.avb, jsonObject);
        return bd2.ps;
    }

    private String zH() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("parent", "item/generated");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("0", "_iainternal:item/player_model/player_model_pixel");
        jsonObject2.addProperty("particle", "#0");
        jsonObject.add("textures", jsonObject2);
        jsonObject.addProperty("ambientocclusion", false);
        String string = "_iainternal\\models\\item\\player_model\\parent_cube.json";
        this.a(string, jsonObject);
        return "_iainternal:item/player_model/parent_cube";
    }

    private String g(String string, String string2, String string3) {
        String string4 = this.fw(string);
        JsonObject jsonObject = this.fv(string4);
        String string5 = jsonObject.get("parent").getAsString();
        String string6 = "_iainternal\\models\\item\\player_model\\" + string5.substring(string5.lastIndexOf(47) + 1) + ".json";
        JsonObject jsonObject2 = this.fv(string6);
        JsonObject jsonObject3 = jsonObject2.getAsJsonObject("display").getAsJsonObject("thirdperson_righthand");
        List list = this.b(jsonObject3.getAsJsonArray("translation"));
        List list2 = this.b(jsonObject3.getAsJsonArray("scale"));
        List list3 = this.c(jsonObject3.getAsJsonArray("rotation"));
        JsonObject jsonObject4 = new JsonObject();
        jsonObject4.addProperty("parent", "_iainternal:item/player_model/parent_cube");
        JsonObject jsonObject5 = new JsonObject();
        JsonObject jsonObject6 = new JsonObject();
        jsonObject6.add("translation", this.K(Arrays.asList((Double)list.get(0) + 0.8, (Double)list.get(1) + -1.2, (Double)list.get(2) + 0.4)));
        jsonObject6.add("scale", this.K(Arrays.asList((Double)list2.get(0) + 0.1, (Double)list2.get(1) + 0.05, (Double)list2.get(2) + 0.15)));
        jsonObject6.add("rotation", this.L(list3));
        jsonObject5.add("thirdperson_righthand", jsonObject6);
        jsonObject4.add("display", jsonObject5);
        String string7 = string3 != null ? "_iainternal\\models\\item\\player_model\\parent_" + string3 + "_pixel_layer2.json" : "_iainternal\\models\\item\\player_model\\parent_" + string2 + "_pixel_layer2.json";
        this.a(string7, jsonObject4);
        return this.fy(string7);
    }

    private String a(String string, int n, int n2, String string2, JsonObject jsonObject, String string3, String string4) {
        String string5;
        String string6;
        String string7 = this.fw(string);
        JsonObject jsonObject2 = this.fv(string7);
        JsonObject jsonObject3 = jsonObject2.getAsJsonArray("elements").get(0).getAsJsonObject();
        JsonObject jsonObject4 = new JsonObject();
        String string8 = "_iainternal:item/player_model/parent_" + (string4 != null ? string4 : string3) + "_pixel_layer2";
        jsonObject4.addProperty("parent", string8);
        JsonObject jsonObject5 = new JsonObject();
        jsonObject5.addProperty("shade", false);
        jsonObject5.add("from", jsonObject3.get("from").getAsJsonArray().deepCopy());
        jsonObject5.add("to", jsonObject3.get("to").getAsJsonArray().deepCopy());
        JsonObject jsonObject6 = new JsonObject();
        JsonObject jsonObject7 = new JsonObject();
        jsonObject7.add("uv", jsonObject.get("uv").getAsJsonArray().deepCopy());
        jsonObject7.addProperty("texture", "#0");
        jsonObject7.addProperty("tintindex", 0);
        jsonObject6.add(string2, jsonObject7);
        jsonObject5.add("faces", jsonObject6);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonObject5);
        jsonObject4.add("elements", jsonArray);
        String string9 = n + "_" + n2;
        if (string4 != null) {
            string6 = "_iainternal\\models\\item\\player_model\\" + string4 + "_pixel_" + string9 + "_layer2.json";
            string5 = "_iainternal:item/player_model/" + string4 + "_pixel_" + string9 + "_layer2";
        } else {
            string6 = "_iainternal\\models\\item\\player_model\\" + string3 + "_pixel_" + string9 + "_layer2.json";
            string5 = "_iainternal:item/player_model/" + string3 + "_pixel_" + string9 + "_layer2";
        }
        this.a(string6, jsonObject4);
        return string5;
    }

    private String fy(String string) {
        String string2 = string.substring(aus.length() + 1, string.length() - ".json".length());
        return "_iainternal:item/player_model/" + string2;
    }

    private JsonArray K(List list) {
        JsonArray jsonArray = new JsonArray();
        for (Double d : list) {
            jsonArray.add(d);
        }
        return jsonArray;
    }

    private JsonArray L(List list) {
        JsonArray jsonArray = new JsonArray();
        for (Integer n : list) {
            jsonArray.add(n);
        }
        return jsonArray;
    }

    private List b(JsonArray jsonArray) {
        ArrayList<Double> arrayList = new ArrayList<Double>(jsonArray.size());
        for (JsonElement jsonElement : jsonArray) {
            arrayList.add(jsonElement.getAsDouble());
        }
        return arrayList;
    }

    private List c(JsonArray jsonArray) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(jsonArray.size());
        for (JsonElement jsonElement : jsonArray) {
            arrayList.add(jsonElement.getAsInt());
        }
        return arrayList;
    }

    private JsonObject f(List list, int n) {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (Double d : list) {
            jsonArray.add(d);
        }
        jsonObject.add("uv", jsonArray);
        jsonObject.addProperty("texture", "#0");
        jsonObject.addProperty("tintindex", n);
        return jsonObject;
    }

    private bc zI() {
        String string;
        int n;
        double d;
        double d2;
        ArrayList<Integer> arrayList;
        LinkedHashMap<String, JsonObject> linkedHashMap;
        int n2;
        int n3;
        int n4 = 8;
        int n5 = 12;
        int n6 = 4;
        double d3 = n4;
        double d4 = n5;
        double d5 = n6;
        double d6 = -d3 / 2.0;
        double d7 = -d4 / 2.0;
        double d8 = -d5 / 2.0;
        ArrayList<String> arrayList2 = new ArrayList<String>();
        ArrayList arrayList3 = new ArrayList();
        int n7 = 0;
        double d9 = (double)n4 * 0.25;
        double d10 = (double)n5 * 0.25;
        double d11 = (double)n6 * 0.25;
        double d12 = (double)n5 * 0.25;
        double d13 = (double)n4 * 0.25;
        double d14 = (double)n6 * 0.25;
        int n8 = 0;
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                int n9;
                linkedHashMap = new LinkedHashMap<String, JsonObject>();
                arrayList = new ArrayList<Integer>();
                d2 = (double)(32 - n4 + (n4 - 1 - n2)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                n = n3 * n4 + n2;
                linkedHashMap.put("north", this.f(this.a(d2, d, d9, d10, false, false), 0));
                arrayList.add(n);
                if (n2 == n4 - 1) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    n9 = 192 + (n3 * n6 + n8);
                    linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    n9 = 192 + n6 * n5 + (n3 * n6 + n8);
                    linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                if (n3 == n5 - 1) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    n9 = 192 + n6 * n5 * 2 + (n8 * n4 + n2);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                if (n3 == 0) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    n9 = 192 + n6 * n5 * 2 + 32 + (n8 * n4 + n2);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "body", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n8 = n6 - 1;
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + (n4 - 1 - n2)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                n = 96 + (n3 * n4 + n2);
                linkedHashMap.put("south", this.f(this.a(d2, d, d9, d10, false, false), 0));
                arrayList.add(n);
                if (n2 == n4 - 1) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    int n10 = 192 + (n3 * n6 + n8);
                    linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n10);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    int n11 = 192 + n6 * n5 + (n3 * n6 + n8);
                    linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n11);
                }
                if (n3 == n5 - 1) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n12 = 192 + n6 * n5 * 2 + (n8 * n4 + n2);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n12);
                }
                if (n3 == 0) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n13 = 192 + n6 * n5 * 2 + 32 + (n8 * n4 + n2);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n13);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "body", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n3 = n4 - 1;
        for (n2 = 0; n2 < n5; ++n2) {
            for (n8 = 1; n8 < n6 - 1; ++n8) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n2)) * 0.25;
                n = 192 + (n2 * n6 + n8);
                linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), 0));
                arrayList.add(n);
                if (n2 == n5 - 1) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n14 = 192 + n6 * n5 * 2 + (n8 * n4 + n3);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n14);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n15 = 192 + n6 * n5 * 2 + 32 + (n8 * n4 + n3);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n15);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "body", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n3 = 0;
        for (n2 = 0; n2 < n5; ++n2) {
            for (n8 = 1; n8 < n6 - 1; ++n8) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n2)) * 0.25;
                n = 192 + n6 * n5 + (n2 * n6 + n8);
                linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), 0));
                arrayList.add(n);
                if (n2 == n5 - 1) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n16 = 192 + n6 * n5 * 2 + (n8 * n4 + n3);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n16);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n17 = 192 + n6 * n5 * 2 + 32 + (n8 * n4 + n3);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n17);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "body", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n2 = n5 - 1;
        for (n8 = 1; n8 < n6 - 1; ++n8) {
            for (n3 = 1; n3 < n4 - 1; ++n3) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + n3) * 0.25;
                d = (double)(32 - n6 + n8) * 0.25;
                n = 192 + n6 * n5 * 2 + (n8 * n4 + n3);
                linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), 0));
                arrayList.add(n);
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "body", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n2 = 0;
        for (n8 = 1; n8 < n6 - 1; ++n8) {
            for (n3 = 1; n3 < n4 - 1; ++n3) {
                linkedHashMap = new LinkedHashMap<String, JsonObject>();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + n3) * 0.25;
                d = (double)(32 - n6 + n8) * 0.25;
                n = 192 + n6 * n5 * 2 + 32 + (n8 * n4 + n3);
                linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), 0));
                arrayList.add(n);
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "body", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        linkedHashMap = new bc();
        ((bc)((Object)linkedHashMap)).auZ = arrayList2;
        ((bc)((Object)linkedHashMap)).ava = arrayList3;
        return linkedHashMap;
    }

    private bc zJ() {
        String string;
        int n;
        double d;
        double d2;
        ArrayList<Integer> arrayList;
        LinkedHashMap<String, JsonObject> linkedHashMap;
        int n2;
        int n3;
        int n4 = 8;
        int n5 = 8;
        int n6 = 8;
        double d3 = n4;
        double d4 = n5;
        double d5 = n6;
        double d6 = -d3 / 2.0;
        double d7 = -d4 / 2.0;
        double d8 = -d5 / 2.0;
        ArrayList<String> arrayList2 = new ArrayList<String>();
        ArrayList arrayList3 = new ArrayList();
        int n7 = 0;
        double d9 = (double)n4 * 0.25;
        double d10 = (double)n5 * 0.25;
        double d11 = (double)n6 * 0.25;
        double d12 = (double)n5 * 0.25;
        double d13 = (double)n4 * 0.25;
        double d14 = (double)n6 * 0.25;
        int n8 = 0;
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                int n9;
                linkedHashMap = new LinkedHashMap<String, JsonObject>();
                arrayList = new ArrayList<Integer>();
                d2 = (double)(32 - n4 + (n4 - 1 - n2)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                n = n3 * n4 + n2;
                linkedHashMap.put("north", this.f(this.a(d2, d, d9, d10, false, false), 0));
                arrayList.add(n);
                if (n2 == n4 - 1) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    n9 = 128 + (n3 * n6 + n8);
                    linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    n9 = 128 + n6 * n5 + (n3 * n6 + n8);
                    linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                if (n3 == n5 - 1) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    n9 = 128 + n6 * n5 * 2 + (n8 * n4 + n2);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n9);
                }
                if (n3 == 0) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    n9 = 128 + n6 * n5 * 2 + 64 + (n8 * n4 + n2);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, true, true), arrayList.size()));
                    arrayList.add(n9);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "head", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n8 = n6 - 1;
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + (n4 - 1 - n2)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                n = 64 + (n3 * n4 + n2);
                linkedHashMap.put("south", this.f(this.a(d2, d, d9, d10, false, false), 0));
                arrayList.add(n);
                if (n2 == n4 - 1) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    int n10 = 128 + (n3 * n6 + n8);
                    linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n10);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    int n11 = 128 + n6 * n5 + (n3 * n6 + n8);
                    linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n11);
                }
                if (n3 == n5 - 1) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n12 = 128 + n6 * n5 * 2 + (n8 * n4 + n2);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n12);
                }
                if (n3 == 0) {
                    d2 = (double)(32 - n4 + n2) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n13 = 128 + n6 * n5 * 2 + 64 + (n8 * n4 + n2);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, true, true), arrayList.size()));
                    arrayList.add(n13);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "head", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n3 = n4 - 1;
        for (n2 = 0; n2 < n5; ++n2) {
            for (n8 = 1; n8 < n6 - 1; ++n8) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n2)) * 0.25;
                n = 128 + (n2 * n6 + n8);
                linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), 0));
                arrayList.add(n);
                if (n2 == n5 - 1) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n14 = 128 + n6 * n5 * 2 + (n8 * n4 + n3);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n14);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n15 = 128 + n6 * n5 * 2 + 64 + (n8 * n4 + n3);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, true, true), arrayList.size()));
                    arrayList.add(n15);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "head", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n3 = 0;
        for (n2 = 0; n2 < n5; ++n2) {
            for (n8 = 1; n8 < n6 - 1; ++n8) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + (n6 - 1 - n8)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n2)) * 0.25;
                n = 128 + n6 * n5 + (n2 * n6 + n8);
                linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), 0));
                arrayList.add(n);
                if (n2 == n5 - 1) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n16 = 128 + n6 * n5 * 2 + (n8 * n4 + n3);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n16);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n4 + n3) * 0.25;
                    d = (double)(32 - n6 + n8) * 0.25;
                    int n17 = 128 + n6 * n5 * 2 + 64 + (n8 * n4 + n3);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, true, true), arrayList.size()));
                    arrayList.add(n17);
                }
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "head", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n2 = n5 - 1;
        for (n8 = 1; n8 < n6 - 1; ++n8) {
            for (n3 = 1; n3 < n4 - 1; ++n3) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + n3) * 0.25;
                d = (double)(32 - n6 + n8) * 0.25;
                n = 128 + n6 * n5 * 2 + (n8 * n4 + n3);
                linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), 0));
                arrayList.add(n);
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "head", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n2 = 0;
        for (n8 = 1; n8 < n6 - 1; ++n8) {
            for (n3 = 1; n3 < n4 - 1; ++n3) {
                linkedHashMap = new LinkedHashMap<String, JsonObject>();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + n3) * 0.25;
                d = (double)(32 - n6 + n8) * 0.25;
                n = 128 + n6 * n5 * 2 + 64 + (n8 * n4 + n3);
                linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, true, true), 0));
                arrayList.add(n);
                string = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "head", null);
                arrayList2.add(string);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        linkedHashMap = new bc();
        ((bc)((Object)linkedHashMap)).auZ = arrayList2;
        ((bc)((Object)linkedHashMap)).ava = arrayList3;
        return linkedHashMap;
    }

    private bc t(String string, boolean bl) {
        String string2;
        int n;
        double d;
        double d2;
        ArrayList<Integer> arrayList;
        LinkedHashMap<String, JsonObject> linkedHashMap;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        if (string.contains("arm")) {
            n6 = bl ? 3 : 4;
            n5 = 12;
            n4 = 4;
        } else {
            n6 = 4;
            n5 = 12;
            n4 = 4;
        }
        double d3 = n6;
        double d4 = n5;
        double d5 = n4;
        double d6 = -d3 / 2.0;
        double d7 = -d4 / 2.0;
        double d8 = -d5 / 2.0;
        ArrayList<String> arrayList2 = new ArrayList<String>();
        ArrayList arrayList3 = new ArrayList();
        int n7 = 0;
        double d9 = (double)n6 * 0.25;
        double d10 = (double)n5 * 0.25;
        double d11 = (double)n4 * 0.25;
        double d12 = (double)n5 * 0.25;
        double d13 = (double)n6 * 0.25;
        double d14 = (double)n4 * 0.25;
        Object object = bl ? string + "_slim" : string;
        int n8 = n6 * n5;
        int n9 = n4 * n5;
        int n10 = n6 * n4;
        int n11 = 0;
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n6; ++n2) {
                int n12;
                linkedHashMap = new LinkedHashMap<String, JsonObject>();
                arrayList = new ArrayList<Integer>();
                d2 = (double)(32 - n6 + (n6 - 1 - n2)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                n = n3 * n6 + n2;
                linkedHashMap.put("north", this.f(this.a(d2, d, d9, d10, false, false), 0));
                arrayList.add(n);
                if (n2 == n6 - 1) {
                    d2 = (double)(32 - n4 + (n4 - 1 - n11)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    n12 = n8 * 2 + (n3 * n4 + n11);
                    linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n12);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n4 + (n4 - 1 - n11)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    n12 = n8 * 2 + n4 * n5 + (n3 * n4 + n11);
                    linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n12);
                }
                if (n3 == n5 - 1) {
                    d2 = (double)(32 - n6 + n2) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    n12 = n8 * 2 + n4 * n5 * 2 + (n11 * n6 + n2);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n12);
                }
                if (n3 == 0) {
                    d2 = (double)(32 - n6 + n2) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    n12 = n8 * 2 + n4 * n5 * 2 + n10 + (n11 * n6 + n2);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n12);
                }
                string2 = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "limb", (String)object);
                arrayList2.add(string2);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n11 = n4 - 1;
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n6; ++n2) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + (n6 - 1 - n2)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                n = n8 + (n3 * n6 + n2);
                linkedHashMap.put("south", this.f(this.a(d2, d, d9, d10, false, false), 0));
                arrayList.add(n);
                if (n2 == n6 - 1) {
                    d2 = (double)(32 - n4 + (n4 - 1 - n11)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    int n13 = n8 * 2 + (n3 * n4 + n11);
                    linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n13);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n4 + (n4 - 1 - n11)) * 0.25;
                    d = (double)(32 - n5 + (n5 - 1 - n3)) * 0.25;
                    int n14 = n8 * 2 + n4 * n5 + (n3 * n4 + n11);
                    linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), arrayList.size()));
                    arrayList.add(n14);
                }
                if (n3 == n5 - 1) {
                    d2 = (double)(32 - n6 + n2) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    int n15 = n8 * 2 + n4 * n5 * 2 + (n11 * n6 + n2);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n15);
                }
                if (n3 == 0) {
                    d2 = (double)(32 - n6 + n2) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    int n16 = n8 * 2 + n4 * n5 * 2 + n10 + (n11 * n6 + n2);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n16);
                }
                string2 = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "limb", (String)object);
                arrayList2.add(string2);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n3 = n6 - 1;
        for (n2 = 0; n2 < n5; ++n2) {
            for (n11 = 1; n11 < n4 - 1; ++n11) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + (n4 - 1 - n11)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n2)) * 0.25;
                n = n8 * 2 + (n2 * n4 + n11);
                linkedHashMap.put("east", this.f(this.a(d2, d, d11, d12, false, false), 0));
                arrayList.add(n);
                if (n2 == n5 - 1) {
                    d2 = (double)(32 - n6 + n3) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    int n17 = n8 * 2 + n4 * n5 * 2 + (n11 * n6 + n3);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n17);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n6 + n3) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    int n18 = n8 * 2 + n4 * n5 * 2 + n10 + (n11 * n6 + n3);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n18);
                }
                string2 = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "limb", (String)object);
                arrayList2.add(string2);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n3 = 0;
        for (n2 = 0; n2 < n5; ++n2) {
            for (n11 = 1; n11 < n4 - 1; ++n11) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n4 + (n4 - 1 - n11)) * 0.25;
                d = (double)(32 - n5 + (n5 - 1 - n2)) * 0.25;
                n = n8 * 2 + n4 * n5 + (n2 * n4 + n11);
                linkedHashMap.put("west", this.f(this.a(d2, d, d11, d12, false, false), 0));
                arrayList.add(n);
                if (n2 == n5 - 1) {
                    d2 = (double)(32 - n6 + n3) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    int n19 = n8 * 2 + n4 * n5 * 2 + (n11 * n6 + n3);
                    linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n19);
                }
                if (n2 == 0) {
                    d2 = (double)(32 - n6 + n3) * 0.25;
                    d = (double)(32 - n4 + n11) * 0.25;
                    int n20 = n8 * 2 + n4 * n5 * 2 + n10 + (n11 * n6 + n3);
                    linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), arrayList.size()));
                    arrayList.add(n20);
                }
                string2 = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "limb", (String)object);
                arrayList2.add(string2);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n2 = n5 - 1;
        for (n11 = 1; n11 < n4 - 1; ++n11) {
            for (n3 = 1; n3 < n6 - 1; ++n3) {
                linkedHashMap = new LinkedHashMap();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + n3) * 0.25;
                d = (double)(32 - n4 + n11) * 0.25;
                n = n8 * 2 + n4 * n5 * 2 + (n11 * n6 + n3);
                linkedHashMap.put("up", this.f(this.a(d2, d, d13, d14, false, false), 0));
                arrayList.add(n);
                string2 = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "limb", (String)object);
                arrayList2.add(string2);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        n2 = 0;
        for (n11 = 1; n11 < n4 - 1; ++n11) {
            for (n3 = 1; n3 < n6 - 1; ++n3) {
                linkedHashMap = new LinkedHashMap<String, JsonObject>();
                arrayList = new ArrayList();
                d2 = (double)(32 - n6 + n3) * 0.25;
                d = (double)(32 - n4 + n11) * 0.25;
                n = n8 * 2 + n4 * n5 * 2 + n10 + (n11 * n6 + n3);
                linkedHashMap.put("down", this.f(this.a(d2, d, d13, d14, false, false), 0));
                arrayList.add(n);
                string2 = this.a(n7, d6, d7, d8, d3, d4, d5, linkedHashMap, "limb", (String)object);
                arrayList2.add(string2);
                arrayList3.add(arrayList);
                ++n7;
            }
        }
        linkedHashMap = new bc();
        ((bc)((Object)linkedHashMap)).auZ = arrayList2;
        ((bc)((Object)linkedHashMap)).ava = arrayList3;
        return linkedHashMap;
    }

    private void c(List list, List list2, String string) {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("type", "composite");
        JsonArray jsonArray = new JsonArray();
        this.a(list, list2, jsonArray);
        jsonObject2.add("models", jsonArray);
        jsonObject.add("model", jsonObject2);
        this.a(string, jsonObject);
    }

    private void d(List list, List list2, String string) {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("type", "composite");
        JsonArray jsonArray = new JsonArray();
        int n = -1;
        for (List list3 : list2) {
            for (Object object2 : list3) {
                n = Math.max(n, (Integer)object2);
            }
        }
        int n2 = n + 1;
        this.a(list, list2, jsonArray);
        for (int i = 0; i < list.size(); ++i) {
            String string2;
            Object object;
            Object object2;
            String string3 = (String)list.get(i);
            object2 = (List)list2.get(i);
            String[] stringArray = string3.substring(string3.lastIndexOf(47) + 1).split("_");
            if (string3.contains("slim")) {
                object = String.join((CharSequence)"_", Arrays.asList(stringArray).subList(0, stringArray.length - 2)) + "_slim";
                string2 = "limb";
            } else if (stringArray[0].equals("right") || stringArray[0].equals("left")) {
                object = String.join((CharSequence)"_", Arrays.asList(stringArray).subList(0, stringArray.length - 2));
                string2 = "limb";
            } else {
                object = null;
                string2 = stringArray[0];
            }
            if (object != null) {
                object = ((String)object).replace("_slim_slim", "_slim");
            }
            this.g(string3, string2, (String)object);
            String string4 = this.fw(string3);
            JsonObject jsonObject3 = this.fv(string4);
            JsonObject jsonObject4 = jsonObject3.getAsJsonArray("elements").get(0).getAsJsonObject().getAsJsonObject("faces");
            ArrayList<Map.Entry<String, JsonElement>> arrayList = new ArrayList<Map.Entry<String, JsonElement>>();
            for (Map.Entry<String, JsonElement> entry : jsonObject4.entrySet()) {
                arrayList.add(entry);
            }
            for (int j = 0; j < object2.size(); ++j) {
                if (j >= arrayList.size()) continue;
                Map.Entry entry = (Map.Entry)arrayList.get(j);
                String string5 = (String)entry.getKey();
                JsonObject jsonObject5 = ((JsonElement)entry.getValue()).getAsJsonObject();
                String string6 = this.a(string3, i, j, string5, jsonObject5, string2, (String)object);
                JsonObject jsonObject6 = new JsonObject();
                jsonObject6.addProperty("type", "condition");
                jsonObject6.addProperty("property", "custom_model_data");
                jsonObject6.addProperty("index", (Number)object2.get(j));
                JsonObject jsonObject7 = new JsonObject();
                jsonObject7.addProperty("type", "model");
                jsonObject7.addProperty("model", string6);
                JsonArray jsonArray2 = new JsonArray();
                JsonObject jsonObject8 = new JsonObject();
                jsonObject8.addProperty("type", "custom_model_data");
                jsonObject8.addProperty("index", n2 + (Integer)object2.get(j));
                jsonObject8.addProperty("default", 0);
                jsonArray2.add(jsonObject8);
                jsonObject7.add("tints", jsonArray2);
                JsonObject jsonObject9 = new JsonObject();
                jsonObject9.addProperty("type", "empty");
                jsonObject6.add("on_true", jsonObject7);
                jsonObject6.add("on_false", jsonObject9);
                jsonArray.add(jsonObject6);
            }
        }
        jsonObject2.add("models", jsonArray);
        jsonObject.add("model", jsonObject2);
        this.a(string, jsonObject);
    }

    private void a(List list, List list2, JsonArray jsonArray) {
        for (int i = 0; i < list.size(); ++i) {
            String string = (String)list.get(i);
            List list3 = (List)list2.get(i);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "model");
            jsonObject.addProperty("model", string);
            JsonArray jsonArray2 = new JsonArray();
            for (Integer n : list3) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("type", "custom_model_data");
                jsonObject2.addProperty("index", n);
                jsonObject2.addProperty("default", 0);
                jsonArray2.add(jsonObject2);
            }
            jsonObject.add("tints", jsonArray2);
            jsonArray.add(jsonObject);
        }
    }

    private void zK() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.auV);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String string = (String)entry.getKey();
            if (!string.endsWith(".json")) continue;
            String string2 = new String((byte[])entry.getValue(), StandardCharsets.UTF_8);
            JsonElement jsonElement = JsonParser.parseString(string2);
            String string3 = this.auU.toJson(jsonElement);
            string3 = string3.replace(".0,", ",").replace(".0]", "]").replace(".0}", "}");
            this.auV.put(string, string3.getBytes(StandardCharsets.UTF_8));
        }
    }
}
