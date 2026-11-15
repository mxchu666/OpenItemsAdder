package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.f;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.qw;
import itemsadder.m.re;
import itemsadder.m.rz;
import itemsadder.m.sd;
import java.io.File;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.block.data.type.Tripwire;
import org.jetbrains.annotations.Nullable;

public class azh {
    private final Collection axN;
    private final JSONArray axO;
    private static final List axP = new ArrayList();

    public azh(Collection collection) {
        this.axN = collection;
        this.axO = new b("internal/multipart_entry/fire.json").gi("multipart");
    }

    private void a(File file, String string, JSONObject jSONObject) {
        File file2 = new File(file, string + ".json");
        if (file2.exists()) {
            try {
                JSONObject jSONObject2 = c.N(file2);
                if (jSONObject2.containsKey("variants")) {
                    Object object;
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("variants");
                    if (jSONObject.containsKey("variants")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("variants");
                        for (Map.Entry entry : jSONObject3.entrySet()) {
                            object = azh.at(string, (String)entry.getKey());
                            if (jSONObject4.containsKey(object)) {
                                bce.warn("Duplicate variant '" + (String)entry.getKey() + "' for blockstate '" + string + "'. File: " + bcy.I(file2));
                                continue;
                            }
                            jSONObject.getJSONObject("variants").put((Object)((String)entry.getKey()), entry.getValue());
                        }
                    } else {
                        jSONObject.put((Object)"variants", (Object)jSONObject3);
                    }
                    for (Object object2 : jSONObject3.entrySet()) {
                        Map.Entry entry;
                        entry = azh.as(string, (String)object2.getKey());
                        object = null;
                        switch (string) {
                            case "note_block": {
                                object = sd.REAL_NOTE;
                                break;
                            }
                            case "brown_mushroom_block": 
                            case "red_mushroom_block": 
                            case "mushroom_stem": {
                                object = sd.REAL;
                                break;
                            }
                            case "chorus_plant": {
                                object = sd.REAL_TRANSPARENT;
                                break;
                            }
                            case "tripwire": {
                                object = sd.REAL_WIRE;
                            }
                        }
                        if (object == null) continue;
                        Object object3 = rz.a((BlockData)entry, (sd)((Object)object));
                        ql ql2 = (ql)d.g().U.get(object3);
                        String string2 = null;
                        if (ql2 == null) continue;
                        if (object2.getValue() instanceof JSONObject) {
                            JSONObject jSONObject5 = (JSONObject)object2.getValue();
                            if (jSONObject5.containsKey("model")) {
                                String string3 = jSONObject5.getString("model");
                                if ((string3 = string3.replace("auto_generated", "ia_auto")).equals(ql2.d(false, true))) continue;
                            }
                            string2 = ((JSONObject)object2.getValue()).getString("model");
                        } else if (object2.getValue() instanceof JSONArray) {
                            if (ql2.FD != null && ql2.FD.Jh != null) continue;
                            string2 = ((JSONArray)object2.getValue()).getJSONObject(0).getString("model");
                        }
                        if (string2 != null) {
                            bce.warn("Manual '" + string + ".json' block variant is already used by ItemsAdder custom block '" + ql2.getNamespacedID() + "'\n-> Variant attribute: " + (String)object2.getKey() + "\n-> Model attribute: " + string2 + "\n-> Block config: " + ql2.nh() + "\n-> Blockstate file: " + bcy.I(file2));
                        }
                        f.xl().e((Integer)object3, string2 + ". File: " + bcy.I(file2));
                    }
                    if (jSONObject.getJSONObject("variants").entrySet().size() > 1 && jSONObject.getJSONObject("variants").containsKey("")) {
                        jSONObject.getJSONObject("variants").remove((Object)"");
                    }
                }
                if (jSONObject2.containsKey("multipart")) {
                    bce.warn("Custom multipart blockstate not supported for now by ItemsAdder, it will be ignored. Consider using 'variants'. File: " + bcy.I(file2));
                }
            }
            catch (Throwable throwable) {
                bce.error("Error opening your custom blockstates file '" + bcy.I(file2) + "'. Please make sure it's valid or delete it.");
                throwable.printStackTrace();
            }
        }
    }

    public static BlockData as(String string, String string2) {
        return Bukkit.createBlockData((String)(string + "[" + string2 + "]"));
    }

    public static String at(String string, String string2) {
        return azh.as(string, string2).getAsString().replace("minecraft:", "");
    }

    public HashMap Bm() {
        int n;
        Object object;
        Object object22;
        f.xl().xF();
        JSONObject jSONObject = new b("internal/blockstates/note_block.json").BR();
        JSONObject jSONObject2 = new b("internal/blockstates/chorus_plant.json").BR();
        JSONObject jSONObject3 = new b("internal/blockstates/brown_mushroom_block.json").BR();
        JSONObject jSONObject4 = new b("internal/blockstates/red_mushroom_block.json").BR();
        JSONObject jSONObject5 = new b("internal/blockstates/mushroom_stem.json").BR();
        JSONObject jSONObject6 = new b("internal/blockstates/tripwire.json").BR();
        JSONObject jSONObject7 = new JSONObject();
        JSONObject jSONObject8 = c.e(jSONObject, "variants", new JSONObject());
        JSONObject jSONObject9 = c.e(jSONObject2, "variants", new JSONObject());
        JSONObject jSONObject10 = c.e(jSONObject3, "variants", new JSONObject());
        JSONObject jSONObject11 = c.e(jSONObject4, "variants", new JSONObject());
        JSONObject jSONObject12 = c.e(jSONObject5, "variants", new JSONObject());
        JSONObject jSONObject13 = c.e(jSONObject6, "variants", new JSONObject());
        JSONArray jSONArray = new JSONArray();
        List list = d.g().x;
        for (Object object3 : list) {
            object22 = new File((File)object3, "minecraft/blockstates");
            if (!((File)object22).exists()) continue;
            this.a((File)object22, "note_block", jSONObject);
            this.a((File)object22, "chorus_plant", jSONObject2);
            this.a((File)object22, "brown_mushroom_block", jSONObject3);
            this.a((File)object22, "red_mushroom_block", jSONObject4);
            this.a((File)object22, "mushroom_stem", jSONObject5);
            this.a((File)object22, "tripwire", jSONObject6);
        }
        ArrayList arrayList = new ArrayList();
        for (Object object22 : this.axN) {
            if (object22 instanceof ql) {
                object = (ql)object22;
                switch (((ql)object).Hq) {
                    case REAL: {
                        if (!ae.cG) break;
                        if (((ql)object).FD.id >= 0 && ((ql)object).FD.id <= 62) {
                            this.a(((ql)object).FD, jSONObject10, ((ql)object).FD.id, (ql)object);
                            break;
                        }
                        if (((ql)object).FD.id >= 64 && ((ql)object).FD.id <= 126) {
                            this.a(((ql)object).FD, jSONObject11, ((ql)object).FD.id, (ql)object);
                            break;
                        }
                        if (((ql)object).FD.id >= 128 && ((ql)object).FD.id <= 190) {
                            this.a(((ql)object).FD, jSONObject12, ((ql)object).FD.id, (ql)object);
                            break;
                        }
                        bce.error("Error: Seems you used all the available REAL blocks. Please consider reducing them and use TILE type.");
                        break;
                    }
                    case REAL_TRANSPARENT: {
                        if (!ae.cH) break;
                        if (((ql)object).FD.id >= 192 && ((ql)object).FD.id < 255) {
                            this.a(((ql)object).FD, jSONObject9, ((ql)object).FD.id, (ql)object);
                            break;
                        }
                        bce.error("Error: Seems you used all the available REAL blocks. Please consider reducing them and use TILE type.");
                        break;
                    }
                    case REAL_NOTE: {
                        if (!ae.cI) break;
                        if (((ql)object).FD.id >= 256 && ((ql)object).FD.id <= 1006) {
                            this.a(((ql)object).FD, jSONObject8, ((ql)object).FD.id, (ql)object);
                            break;
                        }
                        bce.error("Error: Seems you used all the available REAL_NOTE blocks. Please consider reducing them and use TILE type or REAL (if available).");
                        break;
                    }
                    case REAL_WIRE: {
                        if (!ae.cJ) break;
                        if (((ql)object).FD.id >= 1008 && ((ql)object).FD.id < 1136) {
                            this.a(((ql)object).FD, jSONObject13, ((ql)object).FD.id, (ql)object);
                            break;
                        }
                        bce.error("Error: Seems you used all the available REAL_WIRE blocks. Please consider reducing them and use TILE type or REAL_NOTE (if available).");
                        break;
                    }
                }
                continue;
            }
            if (!(object22 instanceof qw) || !ae.cK) continue;
            object = (qw)object22;
            if (((qw)object).Hl.kh >= 1 && ((qw)object).Hl.kh <= 15) {
                jSONArray.addAll((Collection)this.a((qw)object, ((qw)object).Hl.kh));
                arrayList.add(((qw)object).Hl.kh);
                continue;
            }
            bce.error("Error: Seems you used all the available FIRE blocks! (max is 15).");
        }
        for (n = 0; n <= 1136; ++n) {
            if (n >= 0 && n <= 62) {
                if (!ae.cG) continue;
                this.a(jSONObject10, n, sd.REAL, Material.BROWN_MUSHROOM_BLOCK, "block/original/brown_mushroom_block");
                continue;
            }
            if (n >= 64 && n <= 126) {
                if (!ae.cG) continue;
                this.a(jSONObject10, n, sd.REAL, Material.RED_MUSHROOM_BLOCK, "block/original/red_mushroom_block_true");
                continue;
            }
            if (n >= 128 && n <= 190) {
                if (!ae.cG) continue;
                this.a(jSONObject10, n, sd.REAL, Material.MUSHROOM_STEM, "block/original/mushroom_stem");
                continue;
            }
            if (n >= 192 && n < 255) {
                if (!ae.cH) continue;
                this.a(jSONObject10, n, sd.REAL_TRANSPARENT, Material.CHORUS_PLANT, "block/original/chorus_plant");
                continue;
            }
            if (n >= 256 && n < 1006) {
                if (!ae.cI) continue;
                this.a(jSONObject8, n, sd.REAL_NOTE, "block/original/note_block");
                continue;
            }
            if (n < 1007 || n >= 1136 || !ae.cJ) continue;
            this.a(jSONObject13, n, sd.REAL_WIRE, "block/tripwire_attached_n");
        }
        if (ae.cK) {
            for (n = 0; n <= 15; ++n) {
                if (arrayList.contains(n)) continue;
                object22 = c.f(this.axO);
                object = object22.iterator();
                while (object.hasNext()) {
                    Object e = object.next();
                    JSONObject jSONObject14 = (JSONObject)e;
                    this.b(jSONObject14, n);
                }
                jSONArray.addAll((Collection)object22);
            }
        }
        jSONObject3.put((Object)"variants", (Object)jSONObject10);
        jSONObject4.put((Object)"variants", (Object)jSONObject11);
        jSONObject5.put((Object)"variants", (Object)jSONObject12);
        jSONObject2.put((Object)"variants", (Object)jSONObject9);
        jSONObject.put((Object)"variants", (Object)jSONObject8);
        jSONObject7.put((Object)"multipart", (Object)jSONArray);
        jSONObject6.put((Object)"variants", (Object)jSONObject13);
        HashMap hashMap = new HashMap();
        if (ae.cG) {
            hashMap.putAll(this.a(Material.BROWN_MUSHROOM_BLOCK, jSONObject3));
            hashMap.putAll(this.a(Material.RED_MUSHROOM_BLOCK, jSONObject4));
            hashMap.putAll(this.a(Material.MUSHROOM_STEM, jSONObject5));
        }
        if (ae.cH) {
            hashMap.putAll(this.a(Material.CHORUS_PLANT, jSONObject2));
        }
        if (ae.cI) {
            hashMap.putAll(this.a(Material.NOTE_BLOCK, jSONObject));
        }
        if (ae.cK) {
            hashMap.putAll(this.a(Material.FIRE, jSONObject7));
        }
        if (ae.cJ) {
            hashMap.putAll(this.a(Material.TRIPWIRE, jSONObject6));
        }
        return hashMap;
    }

    private void a(JSONObject jSONObject, int n, sd sd2, @Nullable Material material, String string) {
        this.a(null, jSONObject, n, sd2, material, string);
    }

    private void a(@Nullable rz rz2, JSONObject jSONObject, int n, sd sd2, @Nullable Material material, String string) {
        switch (sd2) {
            case REAL: 
            case REAL_TRANSPARENT: 
            case REAL_NOTE: 
            case REAL_WIRE: {
                this.a(rz2, jSONObject, string, this.a(sd2, material, n));
                break;
            }
            default: {
                throw new RuntimeException("Not implemented!");
            }
        }
    }

    private void a(rz rz2, JSONObject jSONObject, int n, ql ql2) {
        this.a(rz2, jSONObject, n, ql2.Hq, null, ql2.d(false, true));
    }

    private void a(JSONObject jSONObject, int n, sd sd2, String string) {
        this.a(jSONObject, n, sd2, null, string);
    }

    private void a(@Nullable rz rz2, JSONObject jSONObject, String string, String string2) {
        if (rz2 != null) {
            if (rz2.Jh != null) {
                JSONArray jSONArray = new JSONArray();
                for (re re2 : rz2.Jh) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put((Object)"model", (Object)re2.HL);
                    jSONObject2.put((Object)"weight", (Object)re2.HM);
                    jSONObject2.put((Object)"x", (Object)re2.mr);
                    jSONObject2.put((Object)"y", (Object)re2.ms);
                    jSONObject2.put((Object)"uvlock", (Object)re2.HN);
                    jSONArray.add((Object)jSONObject2);
                }
                jSONObject.put((Object)string2, (Object)jSONArray);
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put((Object)"model", (Object)string);
                if (rz2.oY() % 90 == 0) {
                    if (rz2.oY() != 0) {
                        jSONObject3.put((Object)"x", (Object)rz2.oY());
                    }
                } else {
                    bce.error("Invalid 'rotx' for '" + rz2.IX.getNamespacedID() + "' block model. Allowed values: 0,90,180,270. File: " + rz2.IX.nh());
                }
                if (rz2.oZ() % 90 == 0) {
                    if (rz2.oZ() != 0) {
                        jSONObject3.put((Object)"y", (Object)rz2.oZ());
                    }
                } else {
                    bce.error("Invalid 'roty' for '" + rz2.IX.getNamespacedID() + "' block model. Allowed values: 0,90,180,270. File: " + rz2.IX.nh());
                }
                jSONObject.put((Object)string2, (Object)jSONObject3);
            }
        }
    }

    private String a(sd sd2, Material material, int n) {
        switch (sd2) {
            case REAL_NOTE: {
                NoteBlock noteBlock = (NoteBlock)rz.a(n, sd2);
                return "instrument=" + rz.a(noteBlock.getInstrument()) + ",note=" + noteBlock.getNote().getId() + ",powered=" + noteBlock.isPowered();
            }
            case REAL_WIRE: {
                Tripwire tripwire = (Tripwire)rz.aq(n);
                return "attached=" + tripwire.isAttached() + ",east=" + tripwire.hasFace(BlockFace.EAST) + ",north=" + tripwire.hasFace(BlockFace.NORTH) + ",south=" + tripwire.hasFace(BlockFace.SOUTH) + ",disarmed=" + tripwire.isDisarmed() + ",west=" + tripwire.hasFace(BlockFace.WEST) + ",powered=" + tripwire.isPowered();
            }
            case REAL: 
            case REAL_TRANSPARENT: {
                MultipleFacing multipleFacing = rz.a(n, null, material);
                Set set = multipleFacing.getFaces();
                return "down=" + set.contains(BlockFace.DOWN) + ",east=" + set.contains(BlockFace.EAST) + ",north=" + set.contains(BlockFace.NORTH) + ",south=" + set.contains(BlockFace.SOUTH) + ",up=" + set.contains(BlockFace.UP) + ",west=" + set.contains(BlockFace.WEST);
            }
        }
        throw new RuntimeException("Not imlemented");
    }

    private JSONArray a(qw qw2, int n) {
        return this.a(n, qw2.getNamespace() + ":" + qw2.ga(), qw2.Hq);
    }

    private JSONArray a(int n, String string, sd sd2) {
        if (sd2 == sd.FIRE) {
            int n2 = 0;
            JSONArray jSONArray = c.f(this.axO);
            for (Object e : jSONArray) {
                JSONObject jSONObject = (JSONObject)e;
                this.b(jSONObject, n);
                for (Object e2 : jSONObject.getJSONArray("apply")) {
                    ((JSONObject)e2).put((Object)"model", (Object)(string + "_" + (String)axP.get(n2)));
                    ++n2;
                }
            }
            return jSONArray;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = azh.bw(n);
        jSONObject.put((Object)"when", (Object)jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put((Object)"model", (Object)string);
        jSONObject.put((Object)"apply", (Object)jSONObject3);
        jSONArray.add((Object)jSONObject);
        return jSONArray;
    }

    public static JSONObject bw(int n) {
        JSONObject jSONObject = new JSONObject();
        String[] stringArray = new String[]{"down", "east", "north", "south", "up", "west"};
        for (int i = 0; i < stringArray.length; ++i) {
            jSONObject.put((Object)stringArray[stringArray.length - 1 - i], (Object)((n & 1 << i) != 0 ? 1 : 0));
        }
        return jSONObject;
    }

    private void b(JSONObject jSONObject, int n) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("when");
        if (jSONObject2.containsKey("OR")) {
            for (Object e : jSONObject2.getJSONArray("OR")) {
                ((JSONObject)e).put((Object)"age", (Object)String.valueOf(n));
            }
        } else {
            jSONObject2.put((Object)"age", (Object)String.valueOf(n));
        }
    }

    public HashMap a(Material material, JSONObject jSONObject) {
        HashMap<CallSite, JSONObject> hashMap = new HashMap<CallSite, JSONObject>();
        hashMap.put((CallSite)((Object)("assets/minecraft/blockstates/" + material.toString().toLowerCase() + ".json")), jSONObject);
        return hashMap;
    }

    static {
        axP.add("fire_floor0");
        axP.add("fire_floor1");
        axP.add("fire_side0");
        axP.add("fire_side1");
        axP.add("fire_side_alt0");
        axP.add("fire_side_alt1");
        axP.add("fire_side0");
        axP.add("fire_side1");
        axP.add("fire_side_alt0");
        axP.add("fire_side_alt1");
        axP.add("fire_side0");
        axP.add("fire_side1");
        axP.add("fire_side_alt0");
        axP.add("fire_side_alt1");
        axP.add("fire_side0");
        axP.add("fire_side1");
        axP.add("fire_side_alt0");
        axP.add("fire_side_alt1");
        axP.add("fire_up0");
        axP.add("fire_up1");
        axP.add("fire_up_alt0");
        axP.add("fire_up_alt1");
    }
}
