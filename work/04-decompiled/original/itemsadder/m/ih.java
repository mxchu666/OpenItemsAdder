package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.axi;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.ij;
import itemsadder.m.ik;
import itemsadder.m.im;
import itemsadder.m.in;
import itemsadder.m.io;
import itemsadder.m.ip;
import itemsadder.m.iq;
import itemsadder.m.ir;
import itemsadder.m.is;
import itemsadder.m.it;
import itemsadder.m.iw;
import itemsadder.m.ix;
import itemsadder.m.iz;
import itemsadder.m.ja;
import itemsadder.m.jb;
import itemsadder.m.jc;
import itemsadder.m.of;
import itemsadder.m.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;

public class ih {
    final Plugin vD;
    final d vE;
    public final HashMap vF = new HashMap();
    private boolean vG = true;
    public final List vH = new ArrayList();

    public ih(Plugin plugin, d d2) {
        this.vD = plugin;
        this.vE = d2;
    }

    public void Z(boolean bl) {
        this.vG = bl;
    }

    public boolean isEnabled() {
        return this.vG;
    }

    public void jG() {
        for (bbf bbf2 : this.vE.b()) {
            List list = bbf2.gR("huds");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-huds-loading")) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No huds found in file " + bbf2.qd());
                continue;
            }
            String string = bbf2.gV("info.namespace");
            int n = 0;
            for (String string2 : list) {
                if (Main.KO.gY("debug.items.log-huds-loading")) {
                    bce.log("    Detected HUD: " + string2);
                }
                if (!bbf2.z("huds." + string2 + ".enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-huds-loading")) continue;
                    bce.log("    Skip disabled HUD");
                    continue;
                }
                Object object = null;
                int n2 = bbf2.gW("huds." + string2 + ".value.min");
                int n3 = bbf2.gW("huds." + string2 + ".value.max");
                @Nullable String string3 = bbf2.gV("huds." + string2 + ".value.player_stat_name");
                switch (bbf2.gV("huds." + string2 + ".type")) {
                    case "STATUS": {
                        Object object2 = (fw)this.vE.al.um.get(bbf2.gV("huds." + string2 + ".images.positive"));
                        fw fw2 = (fw)this.vE.al.um.get(bbf2.gV("huds." + string2 + ".images.half"));
                        fw fw3 = (fw)this.vE.al.um.get(bbf2.gV("huds." + string2 + ".images.negative"));
                        if (object2 == null) {
                            bce.error("Failed to load positive font_image for hud " + string2 + ". font_image doesn't exists. " + bbf2.nh());
                        }
                        if (fw2 == null) {
                            bce.error("Failed to load half font_image for hud " + string2 + ". font_image doesn't exists. " + bbf2.nh());
                        }
                        if (fw3 == null) {
                            bce.error("Failed to load negative font_image for hud " + string2 + ". font_image doesn't exists. " + bbf2.nh());
                        }
                        if (object2 == null || fw2 == null || fw3 == null) break;
                        in in2 = new in(null, string, string2, string3, io.valueOf(bbf2.az("huds." + string2 + ".direction", "RIGHT")), (fw)object2, fw2, fw3, bbf2.gW("huds." + string2 + ".x_position_pixels"), n3, bbf2.z("huds." + string2 + ".show.auto", true), bbf2.z("huds." + string2 + ".show.creative", true), bbf2.z("huds." + string2 + ".show.underwater", true), bbf2.z("huds." + string2 + ".show.riding", true), bbf2.gW("huds." + string2 + ".value.start"), n2, n3, bbf2.hg("huds." + string2 + ".worlds"));
                        this.a(bbf2, string2, in2);
                        this.vF.put(in2.getNamespacedID(), in2);
                        object = in2;
                        break;
                    }
                    case "FRAMES": {
                        Object object2 = bbf2.hg("huds." + string2 + ".images.frames");
                        int n4 = 0;
                        for (int i = n2; i <= n3; ++i) {
                            ++n4;
                        }
                        if (object2.size() != n4) {
                            bce.error("Frames amount " + object2.size() + " is different from total amount of possible values " + n4 + " (" + n2 + " to " + n3 + ") of hud '" + string2 + "'. File: " + bbf2.nh());
                            break;
                        }
                        ArrayList<fw> arrayList = new ArrayList<fw>();
                        int n5 = n2;
                        Object object3 = object2.iterator();
                        while (object3.hasNext()) {
                            String string4 = (String)object3.next();
                            fw fw4 = (fw)this.vE.al.um.get(string4);
                            if (fw4 == null) {
                                bce.error("font_image '" + string4 + "' not found for frame '" + n5 + "' of hud '" + string2 + "'. File: " + bbf2.nh());
                            } else {
                                arrayList.add(fw4);
                            }
                            ++n5;
                        }
                        if (arrayList.isEmpty()) {
                            bce.error("No frame specified for hud '" + string2 + "'. File: " + bbf2.nh());
                            break;
                        }
                        object3 = new im(null, string, string2, string3, arrayList, bbf2.gW("huds." + string2 + ".x_position_pixels"), bbf2.z("huds." + string2 + ".show.auto", true), bbf2.z("huds." + string2 + ".show.creative", true), bbf2.z("huds." + string2 + ".show.underwater", true), bbf2.z("huds." + string2 + ".show.riding", true), bbf2.gW("huds." + string2 + ".value.start"), n2, n3, bbf2.hg("huds." + string2 + ".worlds"));
                        this.a(bbf2, string2, (ij)object3);
                        this.vF.put(((v)object3).getNamespacedID(), object3);
                        object = object3;
                        break;
                    }
                    case "CUSTOM": {
                        Object object2 = new ik(null, string, string2, bbf2.az("huds." + string2 + ".value.player_stat_name", "no_stat"), bbf2.gW("huds." + string2 + ".x_position_pixels"), bbf2.z("huds." + string2 + ".show.auto", true), bbf2.z("huds." + string2 + ".show.creative", true), bbf2.z("huds." + string2 + ".show.underwater", true), bbf2.z("huds." + string2 + ".show.riding", true), bbf2.gW("huds." + string2 + ".value.start"), n2, n3, bbf2.hg("huds." + string2 + ".worlds"));
                        this.a(bbf2, string2, (ij)object2);
                        this.vF.put(((v)object2).getNamespacedID(), object2);
                        object = object2;
                        break;
                    }
                }
                if (object == null) continue;
                s.cX(((v)object).getNamespacedID());
                if (string3 == null) continue;
                this.vH.add(string3);
            }
            ++n;
        }
    }

    void a(bbf bbf2, String string, ij ij2) {
        if (bbf2.gP("huds." + string + ".value.triggers")) {
            Object object;
            Object object2;
            if (bbf2.gP("huds." + string + ".value.triggers.decrement")) {
                object2 = bbf2.hi("huds." + string + ".value.triggers.decrement");
                for (Object object3 : object2.getKeys(false)) {
                    if (((String)object3).startsWith("generic_over_time")) {
                        object = new ja(object2.getInt((String)object3 + ".every_ticks"), -((float)object2.getDouble((String)object3 + ".amount")), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                        ij2.a((jb)object);
                        continue;
                    }
                    if (((String)object3).startsWith("biome_over_time")) {
                        object = new iz(axi.vC().aoJ.dO(object2.getString((String)object3 + ".biome")), object2.getInt((String)object3 + ".every_ticks"), -((float)object2.getDouble((String)object3 + ".amount")), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                        ij2.a((jb)object);
                        continue;
                    }
                    if (!((String)object3).startsWith("food_level_change")) continue;
                    object = new ip((float)object2.getDouble((String)object3 + ".amount"));
                    ij2.a((iq)object);
                }
            }
            if (bbf2.gP("huds." + string + ".value.triggers.increment")) {
                object2 = bbf2.hi("huds." + string + ".value.triggers.increment");
                for (Object object3 : object2.getKeys(false)) {
                    if (((String)object3).startsWith("food_level_change")) {
                        object = new ir((float)object2.getDouble((String)object3 + ".amount"));
                        ij2.a((iq)object);
                        continue;
                    }
                    if (((String)object3).startsWith("player_respawn")) {
                        object = new is((float)object2.getDouble((String)object3 + ".amount"));
                        ij2.a((iq)object);
                        continue;
                    }
                    if (((String)object3).startsWith("generic_over_time")) {
                        object = new ja(object2.getInt((String)object3 + ".every_ticks"), (float)object2.getDouble((String)object3 + ".amount"), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                        ij2.a((jb)object);
                        continue;
                    }
                    if (!((String)object3).startsWith("biome_over_time")) continue;
                    object = new iz(axi.vC().aoJ.dO(object2.getString((String)object3 + ".biome")), object2.getInt((String)object3 + ".every_ticks"), (float)object2.getDouble((String)object3 + ".amount"), object2.getInt((String)object3 + ".min_sky_light", -1), object2.getInt((String)object3 + ".max_sky_light", -1));
                    ij2.a((jb)object);
                }
            }
            if (bbf2.gP("huds." + string + ".value.triggers.on_min_value")) {
                for (Object object4 : bbf2.gR("huds." + string + ".value.triggers.on_min_value")) {
                    Object object3;
                    if (((String)object4).startsWith("damage_player")) {
                        object3 = new it(bbf2.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".every_ticks"), bbf2.gX("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".damage"), ij2.jY(), iw.LESS_EQUAL);
                        ij2.a((jc)object3);
                        continue;
                    }
                    if (!((String)object4).startsWith("potion_effect")) continue;
                    object3 = bbf2.ha("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".type");
                    if (object3 == null) {
                        bce.error("Invalid 'type' for 'potion_effect' of  HUD '" + string + "'. File: " + bbf2.nh());
                        continue;
                    }
                    object = new ix(bbf2.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".every_ticks"), bbf2.gX("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".damage"), new of((PotionEffectType)object3, bbf2.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".amplifier"), bbf2.gW("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".duration"), bbf2.gY("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".ambient"), bbf2.z("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".particles", true), bbf2.z("huds." + string + ".value.triggers.on_min_value." + (String)object4 + ".icon", true)), iw.LESS_EQUAL);
                    ij2.a((jc)object);
                }
            }
        }
    }
}
