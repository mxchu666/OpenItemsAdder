package itemsadder.m;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.f;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.bbq;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.dt;
import itemsadder.m.dw;
import itemsadder.m.dx;
import itemsadder.m.dy;
import itemsadder.m.dz;
import itemsadder.m.ea;
import itemsadder.m.eb;
import itemsadder.m.ed;
import itemsadder.m.ee;
import itemsadder.m.eg;
import itemsadder.m.ex;
import itemsadder.m.v;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class ec
extends v {
    LinkedHashMap pA = new LinkedHashMap();
    public LinkedHashMap pB = new LinkedHashMap();
    public LinkedHashMap pC = new LinkedHashMap();
    public boolean pD;
    @Nullable
    public bbq pE;
    @Nullable
    public bbq pF;
    public float pG = 70.0f;
    public float pH = 45.0f;
    public dy pI;
    private boolean pJ;
    private String pK;

    public ec(String string, String string2) {
        super(string, string2);
    }

    /*
     * WARNING - void declaration
     */
    public void a(String string2, String string3, boolean bl) {
        Object object;
        Object object2;
        Object object3;
        int n;
        JSONObject jSONObject;
        this.pD = bl;
        JSONObject jSONObject2 = JSON.parseObject((String)string3);
        if (jSONObject2.containsKey("hitbox")) {
            jSONObject = jSONObject2.getJSONObject("hitbox");
            this.pE = c.c(jSONObject.getJSONArray("pos"));
            this.pF = c.c(jSONObject.getJSONArray("size"));
        }
        this.pI = dy.aF(c.c(jSONObject2, "rotationMode", "precise"));
        jSONObject = jSONObject2.getJSONArray("bones");
        for (n = 0; n < jSONObject.size(); ++n) {
            void object4;
            object3 = jSONObject.getJSONObject(n);
            object2 = object3.getString("name");
            boolean bl2 = dx.aB((String)object2);
            object = dz.aG(c.c((JSONObject)object3, "boneType", dz.NORMAL.toString()));
            String[] stringArray = c.e(object3.getJSONArray("parents"));
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            if (object3.containsKey("scales")) {
                String[] stringArray2;
                for (String string4 : stringArray2 = c.e(object3.getJSONArray("scales"))) {
                    if (string4.equals("1-1-1")) continue;
                    int n2 = f.xl().a(bl2 ? Material.PLAYER_HEAD : Material.POTION, "__manually_handled", this.bL + "__" + this.bM + "_" + (String)object2 + "_scale_" + string4.replace(".", ","));
                    hashMap.put(string4, n2);
                }
            }
            if (!this.pJ && object == dz.HEAD) {
                this.pG = (float)c.a((JSONObject)object3, "maxHeadRotX", 70.0);
                this.pH = (float)c.a((JSONObject)object3, "maxHeadRotY", 45.0);
                this.pJ = true;
            }
            int n3 = -1;
            if (object.ge()) {
                n3 = f.xl().a(bl2 ? Material.PLAYER_HEAD : Material.POTION, "__manually_handled", this.bL + "__" + this.bM + "_" + (String)object2);
            }
            String string5 = this.getNamespace();
            if (dx.aD((String)object2)) {
                String string6 = "_iainternal";
                n3 = f.eb((String)object2);
                if (n3 == -1) {
                    bce.error("Unknown player model bone '" + (String)object2 + "' for model '" + this.getNamespacedID() + "'. This bone will be ignored. Please report this to the developer.");
                    continue;
                }
            }
            dx dx3 = new dx(this, (String)object4, (String)object2, string2, c.d(object3.getJSONArray("pos")), c.d(object3.getJSONArray("rot")), n3, (dz)((Object)object), stringArray, hashMap);
            this.pC.put(dx3.getId(), dx3);
        }
        ex.k(new ArrayList(this.pC.keySet())).forEach(string -> {
            dx dx2 = (dx)this.pC.get(string);
            this.pC.remove(string);
            this.pC.put(string, dx2);
        });
        if (bl) {
            for (n = 0; n < 6; ++n) {
                object3 = "dummy_" + n;
                object2 = new dx(this, (String)object3, string2, new bbq(0.0f, 0.0f, 0.0f), new bbq(0.0f, 0.0f, 0.0f), f.xl().a(Material.PLAYER_HEAD, "__manually_handled", this.bL + "__" + this.bM + "_" + (String)object3), dz.NORMAL, new String[0], new HashMap());
                this.pC.putFirst(object3, object2);
            }
            LinkedHashMap<String, dz> linkedHashMap = new LinkedHashMap<String, dz>();
            object3 = this.pC.entrySet().iterator();
            while (object3.hasNext()) {
                object2 = (Map.Entry)object3.next();
                String string5 = (String)object2.getKey();
                object = (dx)object2.getValue();
                if (!((dx)object).po.gf()) continue;
                linkedHashMap.put(string5, (dz)((Object)object));
                object3.remove();
            }
            object3 = new LinkedHashMap();
            ((HashMap)object3).putAll(linkedHashMap);
            ((HashMap)object3).putAll(this.pC);
            this.pC = object3;
        }
        this.pC.forEach((string, dx2) -> {
            for (String string2 : dx2.pn) {
                dx dx3 = (dx)this.pC.get(string2);
                if (dx3 == null || dx3.po != dz.HEAD) continue;
                dx2.a(dx3);
                break;
            }
        });
        this.a((String)null, jSONObject2);
    }

    public void a(File file, String string, String string2) {
        JSONObject jSONObject = JSONObject.parseObject((String)string2);
        JSONArray jSONArray = jSONObject.getJSONArray("bones");
        jSONArray.forEach(object -> {
            JSONObject jSONObject = (JSONObject)object;
            String string2 = jSONObject.getString("name");
            String string3 = string + "_" + string2;
            String[] stringArray = c.e(jSONObject.getJSONArray("parents"));
            dz dz2 = dz.aG(c.c(jSONObject, "boneType", dz.NORMAL.toString()));
            if (dz2 != dz.LOCATOR_PIVOT) {
                return;
            }
            if (!this.pC.containsKey(string3)) {
                dx dx2 = new dx(this, string3, "player", c.d(jSONObject.getJSONArray("pos")), c.d(jSONObject.getJSONArray("rot")), f.xl().a(Material.PLAYER_HEAD, "__manually_handled", this.bL + "__" + this.bM + "_" + string3), dz2, stringArray, new HashMap());
                this.pC.put(dx2.getId(), dx2);
            } else {
                bce.warn("Duplicate locator '" + string2 + "' for emotes file: " + bcy.H(file));
            }
        });
    }

    public void b(File file, String string, String string2) {
        this.a(file, string, string2);
        this.n(string, string2);
    }

    public void n(@Nullable String string, String string2) {
        this.a(string, JSON.parseObject((String)string2));
    }

    private void a(@Nullable String string3, JSONObject jSONObject) {
        bch bch2;
        JSONArray jSONArray = jSONObject.getJSONArray("animations");
        jSONArray.forEach(object -> {
            JSONObject jSONObject;
            Object object2;
            JSONObject jSONObject2 = (JSONObject)object;
            dt dt2 = new dt(jSONObject2.getString("name"), jSONObject2.getString("loopMode"), c.d(jSONObject2, "canPlayerMove", false), c.c(jSONObject2, "animType", null), jSONObject2.getDouble("length"), c.a(jSONObject2, "loopStartTime", -1.0), c.a(jSONObject2, "loopEndTime", -1.0));
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (jSONObject2.containsKey("effects")) {
                JSONObject jSONObject3;
                ArrayList<eb> arrayList;
                JSONArray jSONArray;
                JSONArray jSONArray2;
                object2 = jSONObject2.getJSONObject("effects");
                if (object2.containsKey("sounds") && (jSONObject = object2.getJSONObject("sounds")).containsKey("keyframes")) {
                    jSONArray2 = jSONObject.getJSONArray("keyframes");
                    for (Object e : jSONArray2) {
                        jSONArray = (JSONArray)e;
                        arrayList = new ArrayList<eb>();
                        linkedList.add(arrayList);
                        for (Object e2 : jSONArray) {
                            jSONObject3 = (JSONObject)e2;
                            arrayList.add(new eg(jSONObject3.getString("name"), jSONObject3.getFloat("volume").floatValue(), jSONObject3.getFloat("pitch").floatValue()));
                        }
                    }
                }
                if (object2.containsKey("particles") && (jSONObject = object2.getJSONObject("particles")).containsKey("keyframes")) {
                    jSONArray2 = jSONObject.getJSONArray("keyframes");
                    for (Object e : jSONArray2) {
                        jSONArray = (JSONArray)e;
                        arrayList = new ArrayList();
                        linkedList2.add(arrayList);
                        for (Object e2 : jSONArray) {
                            dx dx2;
                            jSONObject3 = (JSONObject)e2;
                            String string2 = jSONObject3.getString("locator");
                            String string3 = string3;
                            if (dx.aC(string2)) {
                                string3 = null;
                            }
                            if ((dx2 = (dx)this.pC.get(string3 == null ? string2 : string3 + "_" + string2)) != null) {
                                arrayList.add(new ee(dx2, jSONObject3.getString("name").toLowerCase(), jSONObject3.getFloat("speed").floatValue(), jSONObject3.getInteger("count"), jSONObject3.getFloat("x_delta").floatValue(), jSONObject3.getFloat("y_delta").floatValue(), jSONObject3.getFloat("z_delta").floatValue()));
                                continue;
                            }
                            String string4 = "Can't find 'locator' '" + string2 + "' for particle effect. Animation: '" + dt2.oz + "'.";
                            if (string3 != null) {
                                bce.error("[Entities] '" + string3 + "'. " + string4);
                                continue;
                            }
                            bce.error("[Entities] '" + this.getNamespacedID() + "'. " + string4);
                        }
                    }
                }
            }
            object2 = new ArrayList();
            jSONObject = jSONObject2.getJSONObject("bones");
            jSONObject.entrySet().forEach(arg_0 -> this.a(string3, dt2, (List)object2, arg_0));
            dt2.h((List)object2);
            dt2.a(linkedList, linkedList2);
            this.pB.put(dt2.oz, dt2);
            this.pA.put(dt2.oB, dt2);
        });
        if (this.pD) {
            this.pB.forEach((string2, dt2) -> this.pC.forEach((string, dx2) -> {
                if (dx2.getId().startsWith("dummy_")) {
                    ArrayList<ed> arrayList = new ArrayList<ed>();
                    for (int i = 0; i < 2; ++i) {
                        arrayList.add(new ed((dt)dt2, new bbq(0.0f, 0.0f, 0.0f), new bbq(0.0f, 0.0f, 0.0f), new bbq(1.0f, 1.0f, 1.0f), "1-1-1"));
                    }
                    dt2.fG().add(new ea((dt)dt2, (dx)dx2, arrayList));
                }
            }));
        }
        if (!(bch2 = bch.G((dt)this.pB.get("idle"))).Dl()) {
            this.pB.entrySet().stream().findFirst().ifPresent(entry -> bch2.H((dt)entry.getValue()));
        }
        if (bch2.aAW != null) {
            this.pC.forEach((string, dx2) -> {
                ea ea2 = ((dt)bch2.aAW).az((String)string);
                if (ea2 != null && ea2.gh() >= 2) {
                    ed ed2 = ea2.n(1);
                    dx2.a(ed2.pM, ed2.pN, ed2.pO);
                }
            });
        }
    }

    public void aH(String string) {
        dt dt2 = (dt)this.pB.remove(string);
        if (dt2 != null) {
            this.pA.remove((Object)dt2.oB);
        }
    }

    public boolean aI(String string) {
        File file = d.s(string);
        if (file != null && file.exists()) {
            try {
                this.pK = file.getAbsolutePath();
                String string2 = this.aJ(string);
                String string3 = FileUtils.readFileToString((File)file, (String)StandardCharsets.UTF_8.toString());
                this.a(string2, string3, this.pD);
            }
            catch (IOException iOException) {
                bce.error("Error loading model animation for model: " + string);
                iOException.printStackTrace();
                return false;
            }
        } else {
            bce.error("Custom entity model doesn't exists! namespace: " + this.bL + " | id: " + this.bM + " | File: " + string);
            return false;
        }
        return true;
    }

    public String aJ(String string) {
        String string2 = bcy.iR(string);
        string2 = bcy.aF(string2, "/.metadata");
        string2 = bcy.aE(string2, "/");
        string2 = bcy.iS(string2);
        return string2;
    }

    public boolean gi() {
        return this.pF != null && this.pE != null;
    }

    public List getAnimationsNames() {
        return new ArrayList(this.pB.keySet());
    }

    public boolean i(File file) {
        if (this.pK == null) {
            return false;
        }
        return file.getParentFile().equals(new File(this.pK).getParentFile());
    }

    @Nullable
    public dt a(dw dw2) {
        dt dt2 = (dt)this.pA.get((Object)dw2);
        if (dt2 != null) {
            return dt2;
        }
        for (Map.Entry entry : this.pB.entrySet()) {
            if (!((dt)entry.getValue()).oz.equalsIgnoreCase(dw2.toString())) continue;
            return (dt)entry.getValue();
        }
        return null;
    }

    private /* synthetic */ void a(String string, dt dt2, List list, Map.Entry entry) {
        Object object2 = (String)entry.getKey();
        dx dx2 = (dx)this.pC.get(object2);
        if (dx2 == null && string != null) {
            object2 = string + "_" + (String)object2;
            dx2 = (dx)this.pC.get(object2);
        }
        if (dx2 == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject)entry.getValue();
        ArrayList arrayList = new ArrayList();
        dx dx3 = dx2;
        jSONObject.getJSONArray("keyframes").forEach(object -> {
            String[] stringArray;
            String string;
            JSONObject jSONObject = (JSONObject)object;
            if (jSONObject.containsKey("scale_str")) {
                string = jSONObject.getString("scale_str");
                if (string.startsWith("-")) {
                    string = string.substring(1);
                }
            } else {
                string = "1-1-1";
            }
            if ((stringArray = string.split("-")).length != 3) {
                bce.error("Invalid scale_str '" + string + "' for bone '" + dx3.getNamespacedID() + "' animation '" + dt2.oz + "' of model '" + this.getNamespacedID() + "'. Using 1-1-1.");
                stringArray = new String[]{"1", "1", "1"};
                string = "1-1-1";
            }
            ed ed2 = new ed(dt2, c.d(jSONObject.getJSONArray("pos")), c.d(jSONObject.getJSONArray("rot")), new bbq(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1]), Float.parseFloat(stringArray[2])), string);
            arrayList.add(ed2);
        });
        ea ea2 = new ea(dt2, dx2, arrayList);
        list.add(ea2);
    }
}
