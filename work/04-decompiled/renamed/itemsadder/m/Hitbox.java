package itemsadder.m;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.f;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.InstanceRegistry_10;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_10;
import itemsadder.m.LocationBridge_8;
import itemsadder.m.LocationBridge_9;
import itemsadder.m.NormalEnum;
import itemsadder.m.Opaque020;
import itemsadder.m.Opaque111;
import itemsadder.m.Opaque114;
import itemsadder.m.Opaque140;
import itemsadder.m.OtherEnum;
import itemsadder.m.RefIntegerData;
import itemsadder.m.SmoothEnum;
import itemsadder.m.SoundCategoryBridge_2;
import itemsadder.m.VectorBridgeImpl;
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

public class Hitbox
extends Opaque140 {
    LinkedHashMap pA = new LinkedHashMap();
    public LinkedHashMap pB = new LinkedHashMap();
    public LinkedHashMap pC = new LinkedHashMap();
    public boolean pD;
    @Nullable
    public VectorBridgeImpl pE;
    @Nullable
    public VectorBridgeImpl pF;
    public float pG = 70.0f;
    public float pH = 45.0f;
    public SmoothEnum pI;
    private boolean pJ;
    private String pK;

    public Hitbox(String string, String string2) {
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
        this.pI = SmoothEnum.aF(c.c(jSONObject2, "rotationMode", "precise"));
        jSONObject = jSONObject2.getJSONArray("bones");
        for (n = 0; n < jSONObject.size(); ++n) {
            void object4;
            object3 = jSONObject.getJSONObject(n);
            object2 = object3.getString("name");
            boolean bl2 = InstanceRegistry_10.aB((String)object2);
            object = NormalEnum.aG(c.c((JSONObject)object3, "boneType", NormalEnum.NORMAL.toString()));
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
            if (!this.pJ && object == NormalEnum.HEAD) {
                this.pG = (float)c.a((JSONObject)object3, "maxHeadRotX", 70.0);
                this.pH = (float)c.a((JSONObject)object3, "maxHeadRotY", 45.0);
                this.pJ = true;
            }
            int n3 = -1;
            if (object.ge()) {
                n3 = f.xl().a(bl2 ? Material.PLAYER_HEAD : Material.POTION, "__manually_handled", this.bL + "__" + this.bM + "_" + (String)object2);
            }
            String string5 = this.getNamespace();
            if (InstanceRegistry_10.aD((String)object2)) {
                String string6 = "_iainternal";
                n3 = f.eb((String)object2);
                if (n3 == -1) {
                    CommandSenderBridge_5.error("Unknown player model bone '" + (String)object2 + "' for model '" + this.getNamespacedID() + "'. This bone will be ignored. Please report this to the developer.");
                    continue;
                }
            }
            InstanceRegistry_10 instanceRegistry_102 = new InstanceRegistry_10(this, (String)object4, (String)object2, string2, c.d(object3.getJSONArray("pos")), c.d(object3.getJSONArray("rot")), n3, (NormalEnum)((Object)object), stringArray, hashMap);
            this.pC.put(instanceRegistry_102.getId(), instanceRegistry_102);
        }
        Opaque114.k(new ArrayList(this.pC.keySet())).forEach(string -> {
            InstanceRegistry_10 instanceRegistry_10 = (InstanceRegistry_10)this.pC.get(string);
            this.pC.remove(string);
            this.pC.put(string, instanceRegistry_10);
        });
        if (bl) {
            for (n = 0; n < 6; ++n) {
                object3 = "dummy_" + n;
                object2 = new InstanceRegistry_10(this, (String)object3, string2, new VectorBridgeImpl(0.0f, 0.0f, 0.0f), new VectorBridgeImpl(0.0f, 0.0f, 0.0f), f.xl().a(Material.PLAYER_HEAD, "__manually_handled", this.bL + "__" + this.bM + "_" + (String)object3), NormalEnum.NORMAL, new String[0], new HashMap());
                this.pC.putFirst(object3, object2);
            }
            LinkedHashMap<String, NormalEnum> linkedHashMap = new LinkedHashMap<String, NormalEnum>();
            object3 = this.pC.entrySet().iterator();
            while (object3.hasNext()) {
                object2 = (Map.Entry)object3.next();
                String string5 = (String)object2.getKey();
                object = (InstanceRegistry_10)object2.getValue();
                if (!((InstanceRegistry_10)object).po.gf()) continue;
                linkedHashMap.put(string5, (NormalEnum)((Object)object));
                object3.remove();
            }
            object3 = new LinkedHashMap();
            ((HashMap)object3).putAll(linkedHashMap);
            ((HashMap)object3).putAll(this.pC);
            this.pC = object3;
        }
        this.pC.forEach((string, instanceRegistry_10) -> {
            for (String string2 : instanceRegistry_10.pn) {
                InstanceRegistry_10 instanceRegistry_102 = (InstanceRegistry_10)this.pC.get(string2);
                if (instanceRegistry_102 == null || instanceRegistry_102.po != NormalEnum.HEAD) continue;
                instanceRegistry_10.a(instanceRegistry_102);
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
            NormalEnum normalEnum = NormalEnum.aG(c.c(jSONObject, "boneType", NormalEnum.NORMAL.toString()));
            if (normalEnum != NormalEnum.LOCATOR_PIVOT) {
                return;
            }
            if (!this.pC.containsKey(string3)) {
                InstanceRegistry_10 instanceRegistry_10 = new InstanceRegistry_10(this, string3, "player", c.d(jSONObject.getJSONArray("pos")), c.d(jSONObject.getJSONArray("rot")), f.xl().a(Material.PLAYER_HEAD, "__manually_handled", this.bL + "__" + this.bM + "_" + string3), normalEnum, stringArray, new HashMap());
                this.pC.put(instanceRegistry_10.getId(), instanceRegistry_10);
            } else {
                CommandSenderBridge_5.warn("Duplicate locator '" + string2 + "' for emotes file: " + ColorBridge.H(file));
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
        Opaque020 opaque020;
        JSONArray jSONArray = jSONObject.getJSONArray("animations");
        jSONArray.forEach(object -> {
            JSONObject jSONObject;
            Object object2;
            JSONObject jSONObject2 = (JSONObject)object;
            SoundCategoryBridge_2 soundCategoryBridge_2 = new SoundCategoryBridge_2(jSONObject2.getString("name"), jSONObject2.getString("loopMode"), c.d(jSONObject2, "canPlayerMove", false), c.c(jSONObject2, "animType", null), jSONObject2.getDouble("length"), c.a(jSONObject2, "loopStartTime", -1.0), c.a(jSONObject2, "loopEndTime", -1.0));
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (jSONObject2.containsKey("effects")) {
                JSONObject jSONObject3;
                ArrayList<LocationBridge_8> arrayList;
                JSONArray jSONArray;
                JSONArray jSONArray2;
                object2 = jSONObject2.getJSONObject("effects");
                if (object2.containsKey("sounds") && (jSONObject = object2.getJSONObject("sounds")).containsKey("keyframes")) {
                    jSONArray2 = jSONObject.getJSONArray("keyframes");
                    for (Object e : jSONArray2) {
                        jSONArray = (JSONArray)e;
                        arrayList = new ArrayList<LocationBridge_8>();
                        linkedList.add(arrayList);
                        for (Object e2 : jSONArray) {
                            jSONObject3 = (JSONObject)e2;
                            arrayList.add(new LocationBridge_10(jSONObject3.getString("name"), jSONObject3.getFloat("volume").floatValue(), jSONObject3.getFloat("pitch").floatValue()));
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
                            InstanceRegistry_10 instanceRegistry_10;
                            jSONObject3 = (JSONObject)e2;
                            String string2 = jSONObject3.getString("locator");
                            String string3 = string3;
                            if (InstanceRegistry_10.aC(string2)) {
                                string3 = null;
                            }
                            if ((instanceRegistry_10 = (InstanceRegistry_10)this.pC.get(string3 == null ? string2 : string3 + "_" + string2)) != null) {
                                arrayList.add(new LocationBridge_9(instanceRegistry_10, jSONObject3.getString("name").toLowerCase(), jSONObject3.getFloat("speed").floatValue(), jSONObject3.getInteger("count"), jSONObject3.getFloat("x_delta").floatValue(), jSONObject3.getFloat("y_delta").floatValue(), jSONObject3.getFloat("z_delta").floatValue()));
                                continue;
                            }
                            String string4 = "Can't find 'locator' '" + string2 + "' for particle effect. Animation: '" + soundCategoryBridge_2.oz + "'.";
                            if (string3 != null) {
                                CommandSenderBridge_5.error("[Entities] '" + string3 + "'. " + string4);
                                continue;
                            }
                            CommandSenderBridge_5.error("[Entities] '" + this.getNamespacedID() + "'. " + string4);
                        }
                    }
                }
            }
            object2 = new ArrayList();
            jSONObject = jSONObject2.getJSONObject("bones");
            jSONObject.entrySet().forEach(arg_0 -> this.a(string3, soundCategoryBridge_2, (List)object2, arg_0));
            soundCategoryBridge_2.h((List)object2);
            soundCategoryBridge_2.a(linkedList, linkedList2);
            this.pB.put(soundCategoryBridge_2.oz, soundCategoryBridge_2);
            this.pA.put(soundCategoryBridge_2.oB, soundCategoryBridge_2);
        });
        if (this.pD) {
            this.pB.forEach((string2, soundCategoryBridge_2) -> this.pC.forEach((string, instanceRegistry_10) -> {
                if (instanceRegistry_10.getId().startsWith("dummy_")) {
                    ArrayList<RefIntegerData> arrayList = new ArrayList<RefIntegerData>();
                    for (int i = 0; i < 2; ++i) {
                        arrayList.add(new RefIntegerData((SoundCategoryBridge_2)soundCategoryBridge_2, new VectorBridgeImpl(0.0f, 0.0f, 0.0f), new VectorBridgeImpl(0.0f, 0.0f, 0.0f), new VectorBridgeImpl(1.0f, 1.0f, 1.0f), "1-1-1"));
                    }
                    soundCategoryBridge_2.fG().add(new Opaque111((SoundCategoryBridge_2)soundCategoryBridge_2, (InstanceRegistry_10)instanceRegistry_10, arrayList));
                }
            }));
        }
        if (!(opaque020 = Opaque020.G((SoundCategoryBridge_2)this.pB.get("idle"))).Dl()) {
            this.pB.entrySet().stream().findFirst().ifPresent(entry -> opaque020.H((SoundCategoryBridge_2)entry.getValue()));
        }
        if (opaque020.aAW != null) {
            this.pC.forEach((string, instanceRegistry_10) -> {
                Opaque111 opaque111 = ((SoundCategoryBridge_2)opaque020.aAW).az((String)string);
                if (opaque111 != null && opaque111.gh() >= 2) {
                    RefIntegerData refIntegerData = opaque111.n(1);
                    instanceRegistry_10.a(refIntegerData.pM, refIntegerData.pN, refIntegerData.pO);
                }
            });
        }
    }

    public void aH(String string) {
        SoundCategoryBridge_2 soundCategoryBridge_2 = (SoundCategoryBridge_2)this.pB.remove(string);
        if (soundCategoryBridge_2 != null) {
            this.pA.remove((Object)soundCategoryBridge_2.oB);
        }
    }

    public boolean aI(String string) {
        File file = ItemStackRegistry.s(string);
        if (file != null && file.exists()) {
            try {
                this.pK = file.getAbsolutePath();
                String string2 = this.aJ(string);
                String string3 = FileUtils.readFileToString((File)file, (String)StandardCharsets.UTF_8.toString());
                this.a(string2, string3, this.pD);
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Error loading model animation for model: " + string);
                iOException.printStackTrace();
                return false;
            }
        } else {
            CommandSenderBridge_5.error("Custom entity model doesn't exists! namespace: " + this.bL + " | id: " + this.bM + " | File: " + string);
            return false;
        }
        return true;
    }

    public String aJ(String string) {
        String string2 = ColorBridge.iR(string);
        string2 = ColorBridge.aF(string2, "/.metadata");
        string2 = ColorBridge.aE(string2, "/");
        string2 = ColorBridge.iS(string2);
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
    public SoundCategoryBridge_2 a(OtherEnum otherEnum) {
        SoundCategoryBridge_2 soundCategoryBridge_2 = (SoundCategoryBridge_2)this.pA.get((Object)otherEnum);
        if (soundCategoryBridge_2 != null) {
            return soundCategoryBridge_2;
        }
        for (Map.Entry entry : this.pB.entrySet()) {
            if (!((SoundCategoryBridge_2)entry.getValue()).oz.equalsIgnoreCase(otherEnum.toString())) continue;
            return (SoundCategoryBridge_2)entry.getValue();
        }
        return null;
    }

    private /* synthetic */ void a(String string, SoundCategoryBridge_2 soundCategoryBridge_2, List list, Map.Entry entry) {
        Object object2 = (String)entry.getKey();
        InstanceRegistry_10 instanceRegistry_10 = (InstanceRegistry_10)this.pC.get(object2);
        if (instanceRegistry_10 == null && string != null) {
            object2 = string + "_" + (String)object2;
            instanceRegistry_10 = (InstanceRegistry_10)this.pC.get(object2);
        }
        if (instanceRegistry_10 == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject)entry.getValue();
        ArrayList arrayList = new ArrayList();
        InstanceRegistry_10 instanceRegistry_102 = instanceRegistry_10;
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
                CommandSenderBridge_5.error("Invalid scale_str '" + string + "' for bone '" + instanceRegistry_102.getNamespacedID() + "' animation '" + soundCategoryBridge_2.oz + "' of model '" + this.getNamespacedID() + "'. Using 1-1-1.");
                stringArray = new String[]{"1", "1", "1"};
                string = "1-1-1";
            }
            RefIntegerData refIntegerData = new RefIntegerData(soundCategoryBridge_2, c.d(jSONObject.getJSONArray("pos")), c.d(jSONObject.getJSONArray("rot")), new VectorBridgeImpl(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1]), Float.parseFloat(stringArray[2])), string);
            arrayList.add(refIntegerData);
        });
        Opaque111 opaque111 = new Opaque111(soundCategoryBridge_2, instanceRegistry_10, arrayList);
        list.add(opaque111);
    }
}
