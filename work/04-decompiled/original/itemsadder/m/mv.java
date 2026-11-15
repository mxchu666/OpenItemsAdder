package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.bcn;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.jh;
import itemsadder.m.ji;
import itemsadder.m.jj;
import itemsadder.m.js;
import itemsadder.m.na;
import itemsadder.m.ne;
import itemsadder.m.nf;
import itemsadder.m.ng;
import itemsadder.m.nh;
import itemsadder.m.ni;
import itemsadder.m.nj;
import itemsadder.m.nk;
import itemsadder.m.nl;
import itemsadder.m.nm;
import itemsadder.m.nn;
import itemsadder.m.no;
import itemsadder.m.np;
import itemsadder.m.nr;
import itemsadder.m.ns;
import itemsadder.m.nt;
import itemsadder.m.nu;
import itemsadder.m.nv;
import itemsadder.m.nw;
import itemsadder.m.nx;
import itemsadder.m.ny;
import itemsadder.m.nz;
import itemsadder.m.oa;
import itemsadder.m.oc;
import itemsadder.m.od;
import itemsadder.m.oe;
import itemsadder.m.of;
import itemsadder.m.og;
import itemsadder.m.oh;
import itemsadder.m.oi;
import itemsadder.m.oj;
import itemsadder.m.ok;
import itemsadder.m.ol;
import itemsadder.m.om;
import itemsadder.m.on;
import itemsadder.m.oo;
import itemsadder.m.op;
import itemsadder.m.oq;
import itemsadder.m.or;
import itemsadder.m.os;
import itemsadder.m.ou;
import itemsadder.m.ox;
import itemsadder.m.oz;
import itemsadder.m.pa;
import itemsadder.m.pb;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.te;
import itemsadder.m.v;
import itemsadder.m.wk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class mv {
    public static boolean Cb;
    final qm Cc;
    public final HashMap Cd = new HashMap();
    public final HashMap Ce = new HashMap();

    public mv(qm qm2) {
        this.Cc = qm2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(d d2) {
        bbg bbg2 = this.Cc.np();
        ConfigurationSection configurationSection = bbg2.hi("events");
        if (configurationSection == null) {
            return;
        }
        jj[] jjArray = jj.values();
        int n = jjArray.length;
        int n2 = 0;
        while (true) {
            block58: {
                ConfigurationSection configurationSection2;
                if (n2 >= n) {
                    return;
                }
                jj jj2 = jjArray[n2];
                if (!configurationSection.contains(jj2.toString())) break block58;
                if (configurationSection.contains(String.valueOf((Object)jj2) + ".cooldown")) {
                    this.Ce.put(jj2, (long)(configurationSection.getInt(String.valueOf((Object)jj2) + ".cooldown", 0) / 20) * 1000L);
                }
                if ((configurationSection2 = configurationSection.getConfigurationSection(jj2.toString())) == null) break block58;
                for (String string : bbf.a(configurationSection2, "")) {
                    ConfigurationSection configurationSection3;
                    block57: {
                        Iterator iterator;
                        Object object;
                        Object object2;
                        block88: {
                            Object object3;
                            block78: {
                                Object object4;
                                block63: {
                                    Object object5;
                                    Object object6;
                                    block59: {
                                        block92: {
                                            block91: {
                                                block90: {
                                                    block89: {
                                                        block87: {
                                                            block86: {
                                                                block85: {
                                                                    block84: {
                                                                        block83: {
                                                                            block82: {
                                                                                on on2;
                                                                                block81: {
                                                                                    block80: {
                                                                                        block79: {
                                                                                            block77: {
                                                                                                block76: {
                                                                                                    block75: {
                                                                                                        block74: {
                                                                                                            block73: {
                                                                                                                block72: {
                                                                                                                    block71: {
                                                                                                                        block70: {
                                                                                                                            block69: {
                                                                                                                                block68: {
                                                                                                                                    block67: {
                                                                                                                                        block66: {
                                                                                                                                            block65: {
                                                                                                                                                block64: {
                                                                                                                                                    block62: {
                                                                                                                                                        block61: {
                                                                                                                                                            block60: {
                                                                                                                                                                configurationSection3 = configurationSection2.getConfigurationSection(string);
                                                                                                                                                                if (configurationSection3 == null) break block59;
                                                                                                                                                                if (!string.startsWith("play_sound")) break block60;
                                                                                                                                                                this.a(jj2, string, new od(configurationSection3.getString("name"), (float)configurationSection3.getDouble("volume", 1.0), (float)configurationSection3.getDouble("pitch", 1.0), configurationSection3.getString("category", null), configurationSection3.getBoolean("stop_previous", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                                break block57;
                                                                                                                                                            }
                                                                                                                                                            if (!string.startsWith("stop_sound")) break block61;
                                                                                                                                                            this.a(jj2, string, new oq(configurationSection3.getString("name"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                            break block57;
                                                                                                                                                        }
                                                                                                                                                        if (!string.startsWith("execute_commands")) break block62;
                                                                                                                                                        object4 = bbf.b(configurationSection3).iterator();
                                                                                                                                                        break block63;
                                                                                                                                                    }
                                                                                                                                                    if (!string.startsWith("play_particle")) break block64;
                                                                                                                                                    object4 = configurationSection3.getString("name");
                                                                                                                                                    object2 = bbi.id((String)object4);
                                                                                                                                                    if (object2 == null) {
                                                                                                                                                        bce.error("&cUnknown particle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available particles: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html");
                                                                                                                                                        continue;
                                                                                                                                                    }
                                                                                                                                                    Object object7 = bbi.a((Particle)object2);
                                                                                                                                                    if (object2.getDataType() != Void.class && object7 == null) {
                                                                                                                                                        bce.error("&cParticle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + " is currently not supported by the plugin.");
                                                                                                                                                        continue;
                                                                                                                                                    }
                                                                                                                                                    this.a(jj2, string, new oc((Particle)object2, object7)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                    break block57;
                                                                                                                                                }
                                                                                                                                                if (!string.startsWith("shoot_particle")) break block65;
                                                                                                                                                object4 = configurationSection3.getString("name");
                                                                                                                                                object2 = bbi.id((String)object4);
                                                                                                                                                if (object2 == null) {
                                                                                                                                                    bce.error("&cUnknown particle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available particles: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html");
                                                                                                                                                    continue;
                                                                                                                                                }
                                                                                                                                                Object object8 = bbi.a((Particle)object2);
                                                                                                                                                if (object2.getDataType() != Void.class && object8 == null) {
                                                                                                                                                    bce.error("&cParticle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + " is currently not supported by the plugin.");
                                                                                                                                                    continue;
                                                                                                                                                }
                                                                                                                                                this.a(jj2, string, new op((Particle)object2, object8, configurationSection3.getInt("distance", 7))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                break block57;
                                                                                                                                            }
                                                                                                                                            if (!string.startsWith("play_effect")) break block66;
                                                                                                                                            object4 = configurationSection3.getString("name");
                                                                                                                                            object2 = bbi.ie((String)object4);
                                                                                                                                            if (object2 == null) {
                                                                                                                                                bce.error("&cUnknown effect &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available effects: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html");
                                                                                                                                                continue;
                                                                                                                                            }
                                                                                                                                            this.a(jj2, string, new oa((Effect)object2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                            break block57;
                                                                                                                                        }
                                                                                                                                        if (!string.startsWith("increment_durability")) break block67;
                                                                                                                                        this.a(jj2, string, new nw(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                        break block57;
                                                                                                                                    }
                                                                                                                                    if (!string.startsWith("decrement_durability")) break block68;
                                                                                                                                    this.a(jj2, string, new nk(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                    break block57;
                                                                                                                                }
                                                                                                                                if (!string.startsWith("decrement_usages")) break block69;
                                                                                                                                this.a(jj2, string, new nm(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                break block57;
                                                                                                                            }
                                                                                                                            if (!string.startsWith("increment_amount")) break block70;
                                                                                                                            this.a(jj2, string, new nv(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                            break block57;
                                                                                                                        }
                                                                                                                        if (!string.startsWith("decrement_amount")) break block71;
                                                                                                                        this.a(jj2, string, new nj(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                        break block57;
                                                                                                                    }
                                                                                                                    if (!string.startsWith("drop_exp")) break block72;
                                                                                                                    this.a(jj2, string, new nn(configurationSection3.getDouble("chance", 0.0), configurationSection3.getInt("min_amount"), configurationSection3.getInt("max_amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                    break block57;
                                                                                                                }
                                                                                                                if (!string.startsWith("drop_item")) break block73;
                                                                                                                object4 = d.g().q(configurationSection3.getString("item"));
                                                                                                                if (object4 == null) {
                                                                                                                    bce.error("Invalid item for 'drop_item' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                                    break;
                                                                                                                }
                                                                                                                this.a(jj2, string, new no((ItemStack)object4, configurationSection3.getDouble("chance", 100.0), configurationSection3.getInt("min_amount", 1), configurationSection3.getInt("max_amount", 1))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                break block57;
                                                                                                            }
                                                                                                            if (!string.startsWith("feed")) break block74;
                                                                                                            this.a(jj2, string, new ns(configurationSection3.getInt("amount"), (float)configurationSection3.getDouble("saturation", 0.0))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                            break block57;
                                                                                                        }
                                                                                                        if (!string.startsWith("replace_properties")) break block75;
                                                                                                        object4 = configurationSection3.getString("custom_model_data.copy_from_item");
                                                                                                        object2 = d2.e((String)object4);
                                                                                                        if (object2 == null) {
                                                                                                            bce.error("&cUnknown item &e'" + object4 + "'&c for action &e'" + string + "'&c of item &e'" + this.Cc.getNamespacedID() + "'&c. File: " + this.Cc.fz().nh());
                                                                                                            continue;
                                                                                                        }
                                                                                                        this.a(jj2, string, new ol((qm)object2, configurationSection3.getBoolean("custom_model_data.restorable", false))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                        break block57;
                                                                                                    }
                                                                                                    if (!string.startsWith("give_item")) break block76;
                                                                                                    object4 = configurationSection3.getString("item");
                                                                                                    object2 = d2.f((String)object4, this.Cc.fz().nh());
                                                                                                    if (object2 == null) {
                                                                                                        bce.error("&cUnknown item &e'" + object4 + "'&c for action &e'" + string + "'&c of item &e'" + this.Cc.getNamespacedID() + "&c'. File: " + this.Cc.fz().nh());
                                                                                                        continue;
                                                                                                    }
                                                                                                    this.a(jj2, string, new nt((ItemStack)object2, configurationSection3.getInt("amount", 1))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                    break block57;
                                                                                                }
                                                                                                if (!string.startsWith("replace_near_blocks")) break block77;
                                                                                                if (configurationSection3.getString("from") == null && configurationSection3.getStringList("from_multiple").isEmpty()) {
                                                                                                    bce.error("Missing 'from' for 'replace_near_blocks' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                    break;
                                                                                                }
                                                                                                object4 = new HashSet<String>(configurationSection3.getStringList("from_multiple"));
                                                                                                ((HashSet)object4).add(configurationSection3.getString("from"));
                                                                                                object2 = new ArrayList();
                                                                                                object3 = ((HashSet)object4).iterator();
                                                                                                break block78;
                                                                                            }
                                                                                            if (!string.startsWith("glow_near_blocks")) break block79;
                                                                                            object4 = configurationSection3.getString("material");
                                                                                            if (object4 == null) {
                                                                                                bce.error("Missing 'material' for 'glow_near_blocks' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                break;
                                                                                            }
                                                                                            try {
                                                                                                object2 = ox.by(object4);
                                                                                            }
                                                                                            catch (IllegalArgumentException illegalArgumentException) {
                                                                                                bce.error("Invalid 'material' for 'glow_near_blocks' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                break;
                                                                                            }
                                                                                            this.a(jj2, string, new nu((ox)object2, configurationSection3.getInt("radius.x"), configurationSection3.getInt("radius.y"), configurationSection3.getInt("radius.z"), configurationSection3.getInt("ticks", 40))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                            break block57;
                                                                                        }
                                                                                        if (!string.startsWith("replace_block")) break block80;
                                                                                        object4 = configurationSection3.getString("from");
                                                                                        if (object4 == null) {
                                                                                            bce.error("Missing 'from' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        try {
                                                                                            object2 = ox.by((String)object4);
                                                                                        }
                                                                                        catch (IllegalArgumentException illegalArgumentException) {
                                                                                            bce.error("Invalid 'from' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        String string2 = configurationSection3.getString("to");
                                                                                        if (string2 == null) {
                                                                                            bce.error("Missing 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        try {
                                                                                            object = ox.by(string2);
                                                                                        }
                                                                                        catch (IllegalArgumentException illegalArgumentException) {
                                                                                            bce.error("Invalid 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        this.a(jj2, string, new oi((ox)object2, (ox)object, configurationSection3.getInt("decrement_durability"), configurationSection3.getInt("decrement_amount"), configurationSection3.getBoolean("no_physics", false))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                        break block57;
                                                                                    }
                                                                                    if (!string.startsWith("multiple_break")) break block81;
                                                                                    this.a(jj2, string, new ny(configurationSection3.getInt("size"), configurationSection3.getInt("depth", 1) - 1, configurationSection3.getBoolean("vertical", false), configurationSection3.getBoolean("keep_ores"), configurationSection3.getBoolean("drop_all_blocks.enabled"), configurationSection3.getBoolean("drop_all_blocks.need_silk_touch"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                    break block57;
                                                                                }
                                                                                if (!string.startsWith("set_block")) break block82;
                                                                                object4 = oo.bv(configurationSection3.getString("target", oo.RELATIVE.toString()));
                                                                                object2 = configurationSection3.getString("block");
                                                                                if (bbi.d((String)object2, Material.class)) {
                                                                                    on2 = new on(Material.valueOf((String)object2), (oo)((Object)object4), configurationSection3.getBoolean("decrement_amount", false));
                                                                                } else {
                                                                                    object = d.g().h((String)object2);
                                                                                    if (object != null) {
                                                                                        on2 = new on((ql)object, (oo)((Object)object4), configurationSection3.getBoolean("decrement_amount", false));
                                                                                    } else {
                                                                                        bce.error("Invalid block for 'set_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                this.a(jj2, string, on2).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                break block57;
                                                                            }
                                                                            if (string.startsWith("place_furniture")) {
                                                                                object4 = (js)d.g().c("furniture", configurationSection3.getString("furniture"));
                                                                                if (object4 != null) {
                                                                                    this.a(jj2, string, new nz((js)object4, configurationSection3.getBoolean("decrement_amount", false)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3)));
                                                                                    break block57;
                                                                                } else {
                                                                                    bce.error("Invalid furniture '" + configurationSection3.getString("furniture") + "' for 'place_furniture' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (string.startsWith("replace_furniture")) {
                                                                                object4 = configurationSection3.getString("furniture");
                                                                                object4 = v.i((String)object4, this.Cc.getNamespace());
                                                                                object2 = (js)d.g().c("furniture", (String)object4);
                                                                                if (object2 != null) {
                                                                                    this.a(jj2, string, new oj((js)object2, configurationSection3.getInt("decrement_durability", 0), configurationSection3.getInt("decrement_amount", 0)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3)));
                                                                                    break block57;
                                                                                } else {
                                                                                    bce.error("Invalid furniture '" + (String)object4 + "' for 'replace_furniture' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (!string.startsWith("remove_furniture")) break block83;
                                                                            this.a(jj2, string, new og()).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                            break block57;
                                                                        }
                                                                        if (!string.startsWith("potion_effect")) break block84;
                                                                        object4 = bbf.hb(configurationSection3.getString("type"));
                                                                        if (object4 == null) {
                                                                            bce.error("Invalid potion effect 'type' for action '" + string + "' of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                            continue;
                                                                        }
                                                                        this.a(jj2, string, new of((PotionEffectType)object4, configurationSection3.getInt("amplifier", 1), configurationSection3.getInt("duration", 40), configurationSection3.getBoolean("ambient"), configurationSection3.getBoolean("icon", true), configurationSection3.getBoolean("particles", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                        break block57;
                                                                    }
                                                                    if (!string.startsWith("remove_potion_effect")) break block85;
                                                                    object4 = bbf.hb(configurationSection3.getString("type"));
                                                                    if (object4 == null) {
                                                                        bce.error("Invalid potion effect 'type' for action '" + string + "' of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                        continue;
                                                                    }
                                                                    this.a(jj2, string, new oh((PotionEffectType)object4)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                    break block57;
                                                                }
                                                                if (!string.startsWith("explosion")) break block86;
                                                                this.a(jj2, string, new nr(configurationSection3.getInt("power", 1), configurationSection3.getBoolean("fire", false), configurationSection3.getBoolean("break_blocks", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                break block57;
                                                            }
                                                            if (!string.startsWith("damage_near_entities")) break block87;
                                                            object4 = configurationSection3.getStringList("entity_groups");
                                                            object2 = new ArrayList<ox>();
                                                            iterator = object4.iterator();
                                                            break block88;
                                                        }
                                                        if (!string.startsWith("damage_entity_in_sight")) break block89;
                                                        this.a(jj2, string, new ng((float)configurationSection3.getDouble("damage", 1.0), configurationSection3.getInt("distance", 3))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                        break block57;
                                                    }
                                                    if (!string.startsWith("damage_entity")) break block90;
                                                    this.a(jj2, string, new nf((float)configurationSection3.getDouble("damage", 1.0))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                    break block57;
                                                }
                                                if (!string.startsWith("target_potion_effect")) break block91;
                                                object4 = bbf.hb(configurationSection3.getString("type"));
                                                if (object4 == null) {
                                                    bce.error("Invalid potion effect 'type' for action '" + string + "' of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                    continue;
                                                }
                                                this.a(jj2, string, new or((PotionEffectType)object4, configurationSection3.getInt("amplifier", 1), configurationSection3.getInt("duration", 40), configurationSection3.getBoolean("ambient"), configurationSection3.getBoolean("particles", true), configurationSection3.getBoolean("icon", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                break block57;
                                            }
                                            if (!string.startsWith("target_remove_potion_effect")) break block92;
                                            this.a(jj2, string, new os(bbf.hb(configurationSection3.getString("type")))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                            break block57;
                                        }
                                        if (string.startsWith("play_totem_animation")) {
                                            object4 = configurationSection2.getString(string);
                                            object2 = d2.b((String)object4, false);
                                            if (object2 == null) {
                                                bce.error("&cUnknown totem &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID());
                                                continue;
                                            }
                                            this.a(jj2, string, new oe((qm)object2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                            break block57;
                                        } else if (string.startsWith("script")) {
                                            wk wk2;
                                            object4 = configurationSection3.getString("name");
                                            if (object4 == null) {
                                                bce.error("&cMissing script name for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID());
                                                continue;
                                            }
                                            object4 = ((String)object4).replace(".jspp", "");
                                            object4 = ((String)object4).replace(".js", "");
                                            object2 = object4 = ((String)object4).replace(".java", "");
                                            if (!((String)object2).contains(":")) {
                                                object2 = this.Cc.getNamespace() + ":" + (String)object4;
                                            }
                                            if ((wk2 = te.ck((String)object2)) == null) {
                                                bce.error("&cScript &e" + (String)object2 + "&c not found for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID());
                                                continue;
                                            }
                                            try {
                                                this.a(jj2, string, new om((String)object2, wk2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                            }
                                            catch (Exception exception) {
                                                bce.error("&cError loading script for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID(), exception);
                                            }
                                        }
                                        break block57;
                                    }
                                    if (string.equals("cancel") && (object6 = configurationSection2.get(string)) instanceof Boolean && ((Boolean)(object4 = (Boolean)object6)).booleanValue()) {
                                        this.a(jj2, string, new ne());
                                        continue;
                                    }
                                    if (!string.startsWith("remove_furniture") || !((object5 = configurationSection2.get(string)) instanceof Boolean) || !((Boolean)(object2 = (Boolean)object5)).booleanValue()) continue;
                                    this.a(jj2, string, new og());
                                    continue;
                                }
                                while (object4.hasNext()) {
                                    object2 = (String)object4.next();
                                    if (jh.bb((String)object2)) continue;
                                    np np2 = new np(configurationSection3.getString((String)object2 + ".command"), configurationSection3.getBoolean((String)object2 + ".as_console"), configurationSection3.getBoolean((String)object2 + ".silent", true), configurationSection3.getString((String)object2 + ".flow_success_if_message_contains", null));
                                    this.a(jj2, string, np2).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt((String)object2 + ".delay", -1)).b(this.a(configurationSection3));
                                }
                                break block57;
                            }
                            while (object3.hasNext()) {
                                object = (String)object3.next();
                                if (object == null) continue;
                                try {
                                    ox ox2 = ox.by((String)object);
                                    object2.add(ox2);
                                }
                                catch (IllegalArgumentException illegalArgumentException) {
                                    bce.error("Invalid 'from' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                    break;
                                }
                            }
                            if ((object3 = configurationSection3.getString("to")) == null) {
                                bce.error("Missing 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                break;
                            }
                            try {
                                object = ox.by((String)object3);
                            }
                            catch (IllegalArgumentException illegalArgumentException) {
                                bce.error("Invalid 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                break;
                            }
                            Iterator iterator2 = object2.iterator();
                            while (iterator2.hasNext()) {
                                ox ox3 = (ox)iterator2.next();
                                this.a(jj2, string, new ok(ox3, (ox)object, configurationSection3.getInt("radius.x"), configurationSection3.getInt("radius.y"), configurationSection3.getInt("radius.z"), configurationSection3.getInt("decrement_durability"), configurationSection3.getInt("decrement_amount"), configurationSection3.getBoolean("no_physics", false))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                            }
                            break block57;
                        }
                        while (iterator.hasNext()) {
                            object = (String)iterator.next();
                            ni ni2 = ni.bu((String)object);
                            if (ni2 == null) {
                                bce.error("&cUnknown entity group &e" + (String)object + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available entity groups: HOSTILE, PLAYERS, PASSIVE");
                                continue;
                            }
                            object2.add(ni2);
                        }
                        int n3 = bbg2.gP(String.valueOf((Object)jj2) + "." + string + ".range") ? configurationSection3.getInt("range", 3) : configurationSection3.getInt("radius", 3);
                        this.a(jj2, string, new nh((float)configurationSection3.getDouble("damage", 1.0), n3, (List)object2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                    }
                    if (d.g().am == null || !d.g().am.isEnabled()) continue;
                    if (string.startsWith("increment_player_stat")) {
                        this.a(jj2, string, new nx(configurationSection3.getString("name"), (float)configurationSection3.getDouble("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                        continue;
                    }
                    if (!string.startsWith("decrement_player_stat")) continue;
                    this.a(jj2, string, new nl(configurationSection3.getString("name"), (float)configurationSection3.getDouble("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                }
            }
            ++n2;
        }
    }

    public jh a(ConfigurationSection configurationSection) {
        for (ji ji2 : ji.values()) {
            if (!configurationSection.contains(ji2.key)) continue;
            String string = null;
            if (!(configurationSection.get(ji2.key) instanceof Boolean)) {
                string = configurationSection.getString(ji2.key);
            }
            return new jh(ji2, string);
        }
        return null;
    }

    public ou a(jj jj2, String string, ou ou2) {
        List<ou> list = this.Cd.containsKey((Object)jj2) ? (List)this.Cd.get((Object)jj2) : new ArrayList<ou>();
        list.add(ou2);
        this.Cd.put(jj2, list);
        ou2.bx(string);
        if (!Cb) {
            switch (jj2) {
                case WEAR: 
                case UNWEAR: 
                case HELD: 
                case UNHELD: 
                case HELD_OFFHAND: 
                case UNHELD_OFFHAND: {
                    Cb = true;
                }
            }
        }
        return ou2;
    }

    public boolean a(jj jj2) {
        return this.Cd.containsKey((Object)jj2);
    }

    public List b(jj jj2) {
        if (this.a(jj2)) {
            return (List)this.Cd.get((Object)jj2);
        }
        return new ArrayList();
    }

    @Deprecated
    public List a(LivingEntity livingEntity, jj jj2) {
        if (this.a(jj2)) {
            if (this.Cc.mW() && !livingEntity.hasPermission(this.Cc.Gr)) {
                bce.f((CommandSender)livingEntity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.Cc.Gr));
                return new ArrayList();
            }
            if (!(livingEntity instanceof Player && !na.md().a(livingEntity, this.Cc) || livingEntity instanceof Player && (!this.Cc.bg((Player)livingEntity) || this.Cc instanceof ql && !((ql)this.Cc).q(((Player)livingEntity).getItemInHand())))) {
                return (List)this.Cd.get((Object)jj2);
            }
        }
        return new ArrayList();
    }

    public void a(Entity entity, jj jj2, oz oz2) {
        Player player;
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        if (entity instanceof Player) {
            player = (Player)entity;
            if (jj2 == jj.HELD) {
                d.g().ar.Co.a(this.Cc, player, true);
            } else if (jj2 == jj.UNHELD) {
                d.g().ar.Co.a(this.Cc, player, false);
            }
            if (jj2 == jj.PLACED_BLOCK_INTERACT || jj2 == jj.PLACED_BLOCK_BREAK || jj2 == jj.PLACED_FURNITURE_BREAK || jj2 == jj.PLACED_FURNITURE_INTERACT || jj2 == jj.PLACED_ARMORSTAND_INTERACT) {
                d.g().ar.Co.a(this.Cc, player, false, 25);
            }
        }
        if (this.a(jj2)) {
            if (entity instanceof Player) {
                EquipmentSlot equipmentSlot;
                player = (Player)entity;
                if (Cb && (equipmentSlot = jj.a(this.Cc, jj2)) != null) {
                    if (jj2 == jj.WEAR || jj2 == jj.HELD || jj2 == jj.HELD_OFFHAND) {
                        d.g().ay.Ew.a((HumanEntity)player, this.Cc, equipmentSlot);
                    } else {
                        d.g().ay.Ew.a((HumanEntity)player, equipmentSlot);
                    }
                }
            }
            if (this.Cc.mW() && !entity.hasPermission(this.Cc.Gr)) {
                bce.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.Cc.Gr));
                return;
            }
            boolean bl = entity instanceof Player;
            if (!(bl && !na.md().a((LivingEntity)entity, this.Cc) || bl && (!this.Cc.bg((Player)entity) || this.Cc instanceof ql && !((ql)this.Cc).q(((Player)entity).getItemInHand())))) {
                boolean bl2 = false;
                pb pb2 = null;
                boolean bl3 = false;
                boolean bl4 = false;
                List list = null;
                List list2 = null;
                List list3 = (List)this.Cd.get((Object)jj2);
                block14: for (ou ou2 : list3) {
                    if (ou2.aE() && !ou2.c(entity)) {
                        if (bl2) continue;
                        bce.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", ou2.gx));
                        bl2 = true;
                        continue;
                    }
                    if (ou2.aD()) {
                        bcp.c(() -> oz2.accept(ou2), ou2.mi());
                        continue;
                    }
                    if (list3.size() <= 1) {
                        oz2.accept(ou2);
                        continue;
                    }
                    jh jh2 = ou2.mh();
                    if (jh2 != null && pb2 != null) {
                        switch (jh2.xm) {
                            case STOP_IF_LAST_SUCCESS: {
                                if (pb2 != pb.SUCCESS) break;
                                return;
                            }
                            case STOP_IF_LAST_FAIL: {
                                if (pb2 != pb.FAILED) break;
                                return;
                            }
                            case SKIP_IF_LAST_SUCCESS: {
                                if (pb2 != pb.SUCCESS) break;
                                continue block14;
                            }
                            case SKIP_IF_LAST_FAIL: {
                                if (pb2 != pb.FAILED) break;
                                continue block14;
                            }
                            case STOP_IF_ANY_SUCCESS: {
                                if (!bl4) break;
                                return;
                            }
                            case STOP_IF_ANY_FAIL: {
                                if (!bl3) break;
                                return;
                            }
                            case SKIP_IF_ANY_SUCCESS: {
                                if (!bl4) break;
                                continue block14;
                            }
                            case SKIP_IF_ANY_FAIL: {
                                if (!bl3) break;
                                continue block14;
                            }
                            case STOP_IF_SUCCESS: {
                                if (!bl4 || !bcn.c(list2, jh2.xn)) break;
                                return;
                            }
                            case STOP_IF_FAIL: {
                                if (!bl3 || !bcn.c(list, jh2.xn)) break;
                                return;
                            }
                            case SKIP_IF_SUCCESS: {
                                if (!bl4 || !bcn.c(list2, jh2.xn)) break;
                                continue block14;
                            }
                            case SKIP_IF_FAIL: {
                                if (!bl3 || !bcn.c(list, jh2.xn)) break;
                                continue block14;
                            }
                        }
                    }
                    pa pa2 = oz2.accept(ou2);
                    pb2 = pa2.Ec;
                    if (pa2.Ec == pb.SUCCESS) {
                        bl4 = true;
                        list2 = bcn.b(list2, (Object)ou2.aF());
                        continue;
                    }
                    if (pa2.Ec != pb.FAILED) continue;
                    bl3 = true;
                    list = bcn.b(list, (Object)ou2.aF());
                }
            }
        }
    }

    public boolean c(jj jj2) {
        return this.Ce.containsKey((Object)jj2);
    }

    public Long d(jj jj2) {
        if (this.c(jj2)) {
            return (Long)this.Ce.get((Object)jj2);
        }
        return 0L;
    }

    public void h(qm qm2) {
        this.a(qm2, false);
    }

    public void a(qm qm2, boolean bl) {
        for (Map.Entry entry : this.Cd.entrySet()) {
            if (bl && qm2.Gd.Cd.containsKey(entry.getKey())) continue;
            qm2.Gd.Cd.put((jj)((Object)entry.getKey()), (List)entry.getValue());
        }
        qm2.i(this.Cc.Gq);
        qm2.Gr = this.Cc.Gr;
    }
}
