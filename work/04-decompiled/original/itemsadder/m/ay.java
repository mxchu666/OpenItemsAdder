package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.as;
import itemsadder.m.au;
import itemsadder.m.av;
import itemsadder.m.aw;
import itemsadder.m.ax;
import itemsadder.m.ba;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bc;
import itemsadder.m.bce;
import itemsadder.m.bcn;
import itemsadder.m.bcp;
import itemsadder.m.bf;
import itemsadder.m.bi;
import itemsadder.m.bj;
import itemsadder.m.da;
import itemsadder.m.dp;
import itemsadder.m.jh;
import itemsadder.m.ji;
import itemsadder.m.te;
import itemsadder.m.wk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class ay {
    final dp gB;
    public final HashMap gC = new HashMap();
    public final HashMap gD = new HashMap();

    public ay(dp dp2) {
        this.gB = dp2;
    }

    public void aR() {
        String string = this.gB.nO.getNamespace();
        String string2 = this.gB.nO.getNamespacedID();
        bbf bbf2 = this.gB.fz();
        if (bbf2 == null) {
            return;
        }
        @Nullable bbg bbg2 = bbf2.hj("entities." + this.gB.nO.bM + ".events");
        if (bbg2 == null) {
            return;
        }
        for (ax ax2 : ax.values()) {
            bbg bbg3;
            if (!bbg2.fo(ax2.toString())) continue;
            if (bbf2.gP("entities." + this.gB.nO.bM + ".events." + String.valueOf((Object)ax2) + ".cooldown")) {
                this.gD.put(ax2, (long)(bbf2.t("entities." + this.gB.nO.bM + ".events." + String.valueOf((Object)ax2) + ".cooldown", 0) / 20) * 1000L);
            }
            if ((bbg3 = bbg2.hj(ax2.toString())) == null) continue;
            for (String string3 : bbf.b(bbg3, "")) {
                wk wk2;
                Object object;
                Object object2;
                bbg bbg4 = bbg3.hj(string3);
                if (bbg4 == null) continue;
                if (string3.startsWith("summon_entity")) {
                    object2 = bbg4.gV("entity");
                    if (object2 == null) {
                        bce.error("Missing 'entity' for action '" + string3 + "' in event '" + String.valueOf((Object)ax2) + "' for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    if (!da.db().lJ.containsKey(object2)) {
                        bce.error("Unknown entity '" + (String)object2 + "' for action '" + string3 + "' in event '" + String.valueOf((Object)ax2) + "' for entity '" + string2 + "'. File: " + bbf2.nh());
                        continue;
                    }
                    try {
                        object = ((bj)((bj)((bj)((bj)bi.Z((String)object2).a(bbg4.c("max_per_chunk", (Integer)null)).U(bbg4.az("permission", null))).a(bbg4.a("delay", (Long)null))).a(this.a(bbg4))).V(string3)).bc();
                        this.a(ax2, (as)object);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        bce.error("Failed to register action '" + string3 + "' in event '" + String.valueOf((Object)ax2) + "' for entity '" + string2 + "'. " + illegalArgumentException.getMessage() + ". File: " + bbf2.nh());
                    }
                    continue;
                }
                if (string3.startsWith("execute_command")) {
                    object2 = ((bc)((bc)((bc)((bc)ba.aS().W(bbg4.gV("command")).k(bbg4.C("as_console", true)).l(bbg4.C("silent", true)).X(bbg4.az("flow_success_if_message_contains", null)).U(bbg4.az("permission", null))).a(bbg4.a("delay", (Long)null))).a(this.a(bbg4))).V(string3)).aU();
                    this.a(ax2, (as)object2);
                    continue;
                }
                if (!string3.startsWith("script")) continue;
                object2 = bbg4.gV("name");
                if (object2 == null) {
                    bce.error("&cMissing script name for action &e" + string3 + "&c of custom entity &e" + string2);
                    continue;
                }
                object2 = ((String)object2).replace(".jspp", "");
                object2 = ((String)object2).replace(".js", "");
                object = object2 = ((String)object2).replace(".java", "");
                if (!((String)object).contains(":")) {
                    object = string + ":" + (String)object2;
                }
                if ((wk2 = te.ck((String)object)) == null) {
                    bce.error("&cScript &e" + (String)object + "&c not found for action &e" + string3 + "&c of item &e" + string2);
                    continue;
                }
                bf bf2 = bf.aW().Y((String)object).a(wk2).aY();
                this.a(ax2, bf2);
            }
        }
    }

    public jh a(bbg bbg2) {
        for (ji ji2 : ji.values()) {
            if (!bbg2.fo(ji2.key)) continue;
            String string = null;
            if (!(bbg2.hm(ji2.key) instanceof Boolean)) {
                string = bbg2.gV(ji2.key);
            }
            return new jh(ji2, string);
        }
        return null;
    }

    public as a(ax ax2, as as2) {
        List<as> list = this.gC.containsKey((Object)ax2) ? (List)this.gC.get((Object)ax2) : new ArrayList<as>();
        list.add(as2);
        this.gC.put(ax2, list);
        return as2;
    }

    public boolean a(ax ax2) {
        return this.gC.containsKey((Object)ax2);
    }

    public List b(ax ax2) {
        if (this.a(ax2)) {
            return (List)this.gC.get((Object)ax2);
        }
        return new ArrayList();
    }

    @Deprecated
    public List a(LivingEntity livingEntity, ax ax2) {
        if (this.a(ax2) && this.gB.om != null && !livingEntity.hasPermission(this.gB.om)) {
            bce.f((CommandSender)livingEntity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.gB.om));
            return new ArrayList();
        }
        return new ArrayList();
    }

    public void a(Entity entity, ax ax2, au au2) {
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        if (this.a(ax2)) {
            if (this.gB.om != null && !entity.hasPermission(this.gB.om)) {
                bce.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.gB.om));
                return;
            }
            boolean bl = false;
            aw aw2 = null;
            boolean bl2 = false;
            boolean bl3 = false;
            List list = null;
            List list2 = null;
            List list3 = (List)this.gC.get((Object)ax2);
            block14: for (as as2 : list3) {
                if (as2.aE() && !as2.c(entity)) {
                    if (bl) continue;
                    bce.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", as2.getPermission()));
                    bl = true;
                    continue;
                }
                if (as2.aD()) {
                    bcp.c(() -> au2.accept(as2), as2.aG());
                    continue;
                }
                if (list3.size() <= 1) {
                    au2.accept(as2);
                    continue;
                }
                jh jh2 = as2.aH();
                if (jh2 != null && aw2 != null) {
                    switch (jh2.xm) {
                        case STOP_IF_LAST_SUCCESS: {
                            if (aw2 != aw.SUCCESS) break;
                            return;
                        }
                        case STOP_IF_LAST_FAIL: {
                            if (aw2 != aw.FAILED) break;
                            return;
                        }
                        case SKIP_IF_LAST_SUCCESS: {
                            if (aw2 != aw.SUCCESS) break;
                            continue block14;
                        }
                        case SKIP_IF_LAST_FAIL: {
                            if (aw2 != aw.FAILED) break;
                            continue block14;
                        }
                        case STOP_IF_ANY_SUCCESS: {
                            if (!bl3) break;
                            return;
                        }
                        case STOP_IF_ANY_FAIL: {
                            if (!bl2) break;
                            return;
                        }
                        case SKIP_IF_ANY_SUCCESS: {
                            if (!bl3) break;
                            continue block14;
                        }
                        case SKIP_IF_ANY_FAIL: {
                            if (!bl2) break;
                            continue block14;
                        }
                        case STOP_IF_SUCCESS: {
                            if (!bl3 || !bcn.c(list2, jh2.xn)) break;
                            return;
                        }
                        case STOP_IF_FAIL: {
                            if (!bl2 || !bcn.c(list, jh2.xn)) break;
                            return;
                        }
                        case SKIP_IF_SUCCESS: {
                            if (!bl3 || !bcn.c(list2, jh2.xn)) break;
                            continue block14;
                        }
                        case SKIP_IF_FAIL: {
                            if (!bl2 || !bcn.c(list, jh2.xn)) break;
                            continue block14;
                        }
                    }
                }
                av av2 = au2.accept(as2);
                aw2 = av2.aO();
                if (av2.aO() == aw.SUCCESS) {
                    bl3 = true;
                    list2 = bcn.b(list2, (Object)as2.aF());
                    continue;
                }
                if (av2.aO() != aw.FAILED) continue;
                bl2 = true;
                list = bcn.b(list, (Object)as2.aF());
            }
        }
    }

    public boolean c(ax ax2) {
        return this.gD.containsKey((Object)ax2);
    }

    public Long d(ax ax2) {
        if (this.c(ax2)) {
            return (Long)this.gD.get((Object)ax2);
        }
        return 0L;
    }
}
