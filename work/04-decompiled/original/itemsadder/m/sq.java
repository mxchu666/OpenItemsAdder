package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dp;
import itemsadder.m.dq;
import itemsadder.m.dr;
import itemsadder.m.ec;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public class sq {
    public void c(d d2) {
        for (bbf bbf2 : d2.b()) {
            String string = bbf2.gV("info.namespace");
            d2.Z.add(string);
            List list = bbf2.gR("entities");
            if (list != null) {
                for (String string2 : list) {
                    String string3;
                    @Nullable bbg bbg2 = bbf2.hj("entities." + string2);
                    assert (bbg2 != null);
                    String string4 = bbg2.az("model_folder", null);
                    if (string4 == null) {
                        bce.error("Missing 'model_folder' for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    EntityType entityType = (EntityType)bbi.e(bbg2.gV("type"), EntityType.class);
                    if (entityType == null) {
                        bce.error("Missing 'type' for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    ec ec2 = new ec(string, string2);
                    if (!ec2.aI("/assets/" + string + "/models/" + string4 + "/.metadata")) {
                        bce.error("Failed to load model data for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    BarStyle barStyle = null;
                    Object object = bbg2.az("boss_bar.style", null);
                    if (object instanceof String && (barStyle = bbi.il(string3 = object)) == null) {
                        bce.error("Invalid 'boss_bar.style' for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    string3 = null;
                    Object object2 = bbg2.az("boss_bar.color", null);
                    if (object2 instanceof String && (string3 = bbi.im((String)(object = object2))) == null) {
                        bce.error("Invalid 'boss_bar.color' for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    object = null;
                    String string5 = bbg2.az("sounds.ambient.sound", null);
                    if (string5 instanceof String) {
                        object2 = string5;
                        object = new dr((String)object2, bbg2.b("sounds.ambient.chance_per_tick", 0.1), bbg2.t("sounds.ambient.cooldown_ticks", 100));
                    }
                    object2 = dp.fy().a(ec2).d(bbf2).au(bbg2.az("display_name", string2)).b(entityType).x(bbg2.C("boss_bar.enabled", false)).z(bbg2.C("silent", true)).A(bbg2.C("sun_burn", bbg2.C("can_sun_burn", false))).B(bbg2.C("drop_vanilla_loot", bbg2.C("can_drop_loot", false))).C(bbg2.C("mount_on_interact", true)).D(bbg2.C("shadow", true)).a(bbg2.a("max_health", (Double)null)).a(barStyle).a((BarColor)string3).b(bbg2.b("speed.movement", 0.23)).a(Float.valueOf(bbg2.a("speed.flying", 0.23f))).E(bbg2.hq("invulnerable")).F(bbg2.C("gravity", true)).G(bbg2.C("ai", true)).e(bbg2.b("eyes_height", 0.25)).b((dr)object).av(bbg2.az("sounds.attack", null)).aw(bbg2.az("sounds.hurt", null)).ax(bbg2.az("sounds.death", null)).ay(bbg2.az("all_actions_permission", null));
                    da.db().a((dq)object2);
                }
                continue;
            }
            if (!Main.KO.gY("debug.entities.log-entities-loading")) continue;
            bce.log(String.valueOf(ChatColor.YELLOW) + "    No entity found in file " + bbf2.qd());
        }
    }
}
