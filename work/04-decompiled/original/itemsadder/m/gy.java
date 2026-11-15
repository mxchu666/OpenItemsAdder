package itemsadder.m;

import itemsadder.m.afz;
import itemsadder.m.akf;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.dp;
import itemsadder.m.fy;
import itemsadder.m.gc;
import itemsadder.m.gd;
import itemsadder.m.ge;
import itemsadder.m.gf;
import itemsadder.m.gh;
import itemsadder.m.gi;
import itemsadder.m.gk;
import itemsadder.m.gl;
import itemsadder.m.gn;
import itemsadder.m.go;
import itemsadder.m.gp;
import itemsadder.m.gq;
import itemsadder.m.gs;
import itemsadder.m.gt;
import itemsadder.m.gv;
import itemsadder.m.gw;
import itemsadder.m.gz;
import itemsadder.m.ha;
import itemsadder.m.hb;
import itemsadder.m.hd;
import itemsadder.m.hf;
import itemsadder.m.hg;
import itemsadder.m.hi;
import itemsadder.m.hj;
import itemsadder.m.hl;
import itemsadder.m.hm;
import itemsadder.m.ho;
import itemsadder.m.hp;
import itemsadder.m.hr;
import itemsadder.m.hs;
import itemsadder.m.hu;
import itemsadder.m.hv;
import itemsadder.m.hx;
import itemsadder.m.hy;
import itemsadder.m.ia;
import itemsadder.m.ib;
import itemsadder.m.id;
import itemsadder.m.ie;
import itemsadder.m.ig;
import itemsadder.m.l;
import itemsadder.m.m;
import itemsadder.m.n;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

public class gy {
    private static final Map va = new HashMap();
    private final dp vb;
    private final List vc = new ArrayList();
    private boolean vd = false;

    private static void a(String string, gz gz2) {
        va.put(string, gz2);
    }

    public gy(dp dp2) {
        this.vb = dp2;
    }

    public void aR() {
        String string = this.vb.nO.getNamespacedID();
        bbf bbf2 = this.vb.fz();
        if (bbf2 == null) {
            return;
        }
        @Nullable bbg bbg2 = bbf2.hj("entities." + this.vb.nO.bM + ".goals");
        if (bbg2 == null) {
            return;
        }
        for (String string2 : bbg2.CK()) {
            bbg bbg3;
            if (bbg2.C("clear_all", false)) {
                this.vd = true;
            }
            if ((bbg3 = bbg2.hj(string2)) == null || !bbg3.C("enabled", true)) continue;
            Optional<Map.Entry> optional = va.entrySet().stream().filter(entry -> string2.startsWith((String)entry.getKey())).findFirst();
            if (optional.isEmpty()) {
                bce.warn("Unknown goal '" + string2 + "' in entity '" + string + "'. File: " + bbf2.nh());
                continue;
            }
            fy fy2 = ((gz)optional.get().getValue()).load(string, this.vb, bbg3, string2, bbf2);
            if (fy2 == null) continue;
            this.vc.add(fy2);
        }
    }

    public void a(Mob mob) {
        if (mob == null) {
            bce.error("Failed to apply goals to a null mob for entity '" + this.vb.nO.getNamespacedID() + "'.");
            return;
        }
        if (this.vd) {
            akf.ua().b(mob);
        }
        block18: for (fy fy2 : this.vc) {
            fy fy3;
            Objects.requireNonNull(fy2);
            int n = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{hf.class, ge.class, hr.class, ia.class, hx.class, hu.class, hi.class, id.class, gh.class, ha.class, gk.class, gv.class, hl.class, ho.class, gp.class, gs.class}, (Object)fy3, n)) {
                case 0: {
                    hf hf2 = (hf)fy3;
                    akf.ua().a(mob, fy2.uO, fy2.uN, hf2.vi, hf2.vj, hf2.vk, hf2.vl);
                    continue block18;
                }
                case 1: {
                    ge ge2 = (ge)fy3;
                    akf.ua().a(mob, fy2.uO, fy2.uN, ge2.uP, ge2.uT, ge2.uU, ge2.uV, null);
                    continue block18;
                }
                case 2: {
                    hr hr2 = (hr)fy3;
                    akf.ua().a(mob, hr2.uO, hr2.uN);
                    continue block18;
                }
                case 3: {
                    ia ia2 = (ia)fy3;
                    akf.ua().a(mob, ia2.uO, ia2.uN, ia2.vw, ia2.vx);
                    continue block18;
                }
                case 4: {
                    hx hx2 = (hx)fy3;
                    akf.ua().a(mob, hx2.uN, hx2.vu, hx2.vv);
                    continue block18;
                }
                case 5: {
                    hu hu2 = (hu)fy3;
                    akf.ua().a(mob, hu2.uN, hu2.vs, hu2.vt);
                    continue block18;
                }
                case 6: {
                    hi hi2 = (hi)fy3;
                    akf.ua().a(mob, hi2.uO, hi2.uN, hi2.vm, hi2.vn);
                    continue block18;
                }
                case 7: {
                    id id2 = (id)fy3;
                    akf.ua().a(mob, id2.uO, id2.uN, id2.vz, id2.vA, id2.vB);
                    continue block18;
                }
                case 8: {
                    gh gh2 = (gh)fy3;
                    akf.ua().a(mob, gh2.uO, gh2.uN, gh2.uP, gh2.uW, gh2.uX, gh2.uY, null);
                    continue block18;
                }
                case 9: {
                    ha ha2 = (ha)fy3;
                    akf.ua().a(mob, ha2.uO, ha2.uN, ha2.vf, ha2.vg);
                    continue block18;
                }
                case 10: {
                    gk gk2 = (gk)fy3;
                    akf.ua().b(mob, gk2.uO, gk2.uN);
                    continue block18;
                }
                case 11: {
                    gv gv2 = (gv)fy3;
                    akf.ua().c(mob, gv2.uO, gv2.uN);
                    continue block18;
                }
                case 12: {
                    hl hl2 = (hl)fy3;
                    akf.ua().a(mob, hl2.uO, hl2.uN, hl2.vo, hl2.vp, hl2.vq);
                    continue block18;
                }
                case 13: {
                    ho ho2 = (ho)fy3;
                    akf.ua().a(mob, ho2.uO, ho2.uN, ho2.vr);
                    continue block18;
                }
                case 14: {
                    gp gp2 = (gp)fy3;
                    akf.ua().d(mob, gp2.uO, gp2.uN);
                    continue block18;
                }
                case 15: {
                    gs gs2 = (gs)fy3;
                    akf.ua().a(mob, gs2.uO, gs2.uN, gs2.uZ);
                    continue block18;
                }
            }
            bce.error("Unknown goal type '" + fy2.getClass().getSimpleName() + "' for entity '" + this.vb.nO.getNamespacedID() + "'.");
        }
    }

    @Nullable
    private static Predicate a(List list, String string, String string2, bbf bbf2) {
        if (list.isEmpty()) {
            bce.error("Failed to register action '" + string + "' for entity '" + string2 + "'. No blocks specified. File: " + bbf2.nh());
            return null;
        }
        ArrayList<gn> arrayList = new ArrayList<gn>();
        for (String string3 : list) {
            string3 = string3.toLowerCase();
            if (d.g().g(string3)) {
                arrayList.add(new go(string3));
                continue;
            }
            try {
                BlockData blockData = Bukkit.createBlockData((String)string3);
                arrayList.add(new ig(blockData));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                bce.error("Unknown block '" + string3 + "' for action '" + string + "' for entity '" + string2 + "'. File: " + bbf2.nh());
            }
        }
        if (arrayList.isEmpty()) {
            bce.error("Failed to register action '" + string + "' for entity '" + string2 + "'. No valid blocks specified. File: " + bbf2.nh());
            return null;
        }
        return blockState -> {
            if (blockState == null) {
                return false;
            }
            for (gn gn2 : arrayList) {
                if (!gn2.b((BlockState)blockState)) continue;
                return true;
            }
            return false;
        };
    }

    private static @Nullable gc a(bbg bbg2, String string, String string2, bbf bbf2, @Nullable dp dp2, @Nullable Boolean bl) {
        float f2 = bbg2.a("max_health", 199.0f);
        float f3 = bbg2.a("min_health", 0.0f);
        boolean bl2 = bbg2.C("equipment.match_all", true);
        HashMap<EquipmentSlot, l> hashMap = new HashMap<EquipmentSlot, l>();
        for (String string3 : bbg2.hU("equipment")) {
            String string4 = bbg2.gV("equipment." + string3);
            if (string4 == null || string4.isEmpty()) continue;
            EquipmentSlot equipmentSlot = bbi.ik(string3);
            if (equipmentSlot == null) {
                bce.error("Failed to register action '" + string + "' for entity '" + string2 + "'. Invalid equipment slot '" + string3 + "'. File: " + bbf2.nh());
                return null;
            }
            if (d.g().f(string4)) {
                hashMap.put(equipmentSlot, new m(string4));
                continue;
            }
            Material material = bbi.ig(string4);
            if (material == null) {
                bce.error("Failed to register action '" + string + "' for entity '" + string2 + "'. Invalid item '" + string4 + "' for equipment slot '" + string3 + "'. File: " + bbf2.nh());
                return null;
            }
            hashMap.put(equipmentSlot, new n(material));
        }
        return (livingEntity, livingEntity2) -> {
            dn dn2 = da.db().h((Entity)livingEntity2);
            if (dn2 == null || dn2.my != dp2) {
                return false;
            }
            if (livingEntity2.getHealth() < (double)f3 || livingEntity2.getHealth() > (double)f2) {
                return false;
            }
            if (bl != null && bl.booleanValue() && !afz.tK().a(livingEntity, livingEntity2)) {
                return false;
            }
            if (!hashMap.isEmpty()) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    l l2 = (l)entry.getValue();
                    boolean bl3 = dn2.a((EquipmentSlot)entry.getKey(), l2);
                    if (bl2) {
                        if (bl3) continue;
                        return false;
                    }
                    if (!bl3) continue;
                    return true;
                }
            }
            return bl2;
        };
    }

    @Nullable
    static gd a(bbg bbg2, String string, String string2, bbf bbf2) {
        dp dp2;
        String string3 = bbg2.gV("entity");
        @Nullable EntityType entityType = bbi.ih(string3);
        if (entityType == null) {
            if (!da.db().lJ.containsKey(string3)) {
                return null;
            }
            dp2 = (dp)da.db().lJ.get(string3);
            entityType = dp2.nS;
        } else {
            dp2 = null;
        }
        Boolean bl = null;
        if (string.equals("attack_near")) {
            bl = bbg2.a("must_be_angry_at", (Boolean)null);
        }
        gc gc2 = null;
        if (!bbg2.fo("selector") && dp2 != null) {
            gc2 = (livingEntity, livingEntity2) -> {
                dn dn2 = da.db().h((Entity)livingEntity2);
                return dn2 != null && dn2.my == dp2;
            };
        } else {
            bbg bbg3 = bbg2.hj("selector");
            if (bbg3 != null) {
                gc2 = gy.a(bbg3, string, string2, bbf2, dp2, bl);
            }
        }
        return new gd(entityType, gc2);
    }

    static hb[] a(bbg bbg2, String string, String string2, bbf bbf2, String string3) {
        ArrayList<hb> arrayList = new ArrayList<hb>();
        bbg bbg3 = bbg2.hj(string3);
        if (bbg3 != null) {
            for (String string4 : bbg3.CK()) {
                dp dp2;
                bbg bbg4 = bbg2.hj(string4);
                assert (bbg4 != null);
                String string5 = bbg4.gV("entity");
                @Nullable EntityType entityType = bbi.ih(string5);
                if (entityType == null) {
                    if (!da.db().lJ.containsKey(string5)) {
                        bce.error("Failed to register action '" + string + "' for entity '" + string2 + "'. Invalid entity type '" + string5 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    dp2 = (dp)da.db().lJ.get(string5);
                    entityType = dp2.nS;
                } else {
                    dp2 = null;
                }
                gc gc2 = null;
                bbg bbg5 = bbg4.hj("selector");
                if (bbg5 != null) {
                    gc2 = gy.a(bbg5, string, string2, bbf2, dp2, null);
                }
                arrayList.add(hb.iQ().d(entityType).b(gc2).iR());
            }
        }
        return arrayList.toArray(new hb[0]);
    }

    static {
        gy.a("look_at_entity", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            gd gd2 = gy.a(bbg2, string2, string, bbf2);
            if (gd2 == null) {
                bce.error("Failed to register action '" + string2 + "' for entity '" + string + "'. Invalid entity type or selector. File: " + bbf2.nh());
                return null;
            }
            return ((hg)((hg)((hg)hf.iV().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).e(gd2.ip()).g(bbg2.a("range", 8.0f)).h(bbg2.a("chance", 20.0f) / 100.0f).U(bbg2.C("look_forward", false)).a(gd2.iq())).iX();
        });
        gy.a("random_look_around", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((hs)((hs)hr.jl().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).jn());
        gy.a("random_wander_around", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((ib)((ib)ia.jx().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).l(bbg2.a("speed_modifier", 1.0f)).V(bbg2.t("interval", 10)).Y(bbg2.C("check_no_action_time", true)).jz());
        gy.a("random_teleport_timed", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((hy)hx.jt().Q(bbg2.t("priority", 10))).T(bbg2.t("min_delay", 10)).U(bbg2.t("max_delay", 20)).jv());
        gy.a("random_teleport_on_hit", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((hv)hu.jp().Q(bbg2.t("priority", 10))).X(bbg2.C("check_visibility", true)).i(bbg2.a("chance", 100.0f) / 100.0f).jr());
        gy.a("attack_near", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            gd gd2 = gy.a(bbg2, string2, string, bbf2);
            if (gd2 == null) {
                bce.error("Failed to register action '" + string2 + "' for entity '" + string + "'. Invalid entity type or selector. File: " + bbf2.nh());
                return null;
            }
            return ((gf)((gf)((gf)((gf)ge.ir().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).c(gd2.ip())).R(bbg2.t("interval", 10)).S(bbg2.C("check_visibility", true)).T(bbg2.C("check_can_navigate", true)).a(gd2.iq())).it();
        });
        gy.a("melee_attack", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((hj)((hj)hi.iZ().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).j(bbg2.t("speed_modifier", 1)).V(bbg2.C("pause_when_idle", false)).jb());
        gy.a("ranged_bow_attack", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            if (!id.f(dp2.nS)) {
                bce.warn("Custom entity entity '" + string + "' is not compatible with RangedBowAttackGoal. This goal will not work as expected. File: " + bbf2.nh());
                bce.warn("Compatible types: " + Arrays.toString(id.jB()));
                return null;
            }
            return ((ie)((ie)id.jC().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).m(bbg2.a("speed_modifier", 1.0f)).W(bbg2.t("attack_interval_min", 20)).j(bbg2.a("attack_radius", 15.0f)).jE();
        });
        gy.a("avoid_entity", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            gd gd2 = gy.a(bbg2, string2, string, bbf2);
            if (gd2 == null) {
                bce.error("Failed to register action '" + string2 + "' for entity '" + string + "'. Invalid entity type or selector. File: " + bbf2.nh());
                return null;
            }
            return ((gi)((gi)((gi)((gi)gh.iv().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).c(gd2.ip())).f(bbg2.a("max_distance", 12.0f)).h(bbg2.a("walk_speed_modifier", 1.0f)).i(bbg2.a("sprint_speed_modifier", 1.2f)).a(gd2.iq())).ix();
        });
        gy.a("hurt_by_target", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            hb[] hbArray = gy.a(bbg2, string2, string, bbf2, "ignore_damage_from");
            hb[] hbArray2 = gy.a(bbg2, string2, string, bbf2, "alert_others");
            return ((hd)((hd)ha.iP().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).a(hbArray).b(hbArray2).iT();
        });
        gy.a("avoid_sun", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((gl)((gl)gk.iz().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).iB());
        gy.a("float", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((gw)((gw)gv.iL().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).iN());
        gy.a("move_to_block", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            List list = bbg2.hg("blocks");
            Predicate predicate = gy.a(list, string2, string, bbf2);
            if (predicate == null) {
                return null;
            }
            return ((hm)((hm)hl.jd().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).b(predicate).k(bbg2.a("speed_modifier", 1.0f)).S(bbg2.t("search_range", 16)).jf();
        });
        gy.a("open_door", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((hp)((hp)ho.jh().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).W(bbg2.C("close", true)).jj());
        gy.a("break_door", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> ((gq)((gq)gp.iD().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).iF());
        gy.a("eat_block", (String string, dp dp2, bbg bbg2, String string2, bbf bbf2) -> {
            List list = bbg2.hg("blocks");
            Predicate predicate = gy.a(list, string2, string, bbf2);
            if (predicate == null) {
                return null;
            }
            return ((gt)((gt)gs.iH().R(bbg2.C("replace_vanilla", true))).Q(bbg2.t("priority", 10))).a(predicate).iJ();
        });
    }
}
