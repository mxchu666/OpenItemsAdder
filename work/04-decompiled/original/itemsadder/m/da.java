package itemsadder.m;

import com.google.common.collect.ImmutableList;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.PlayerEmoteEndEvent;
import dev.lone.itemsadder.api.Events.PlayerEmoteEndEvent$Cause;
import dev.lone.itemsadder.api.Events.PlayerEmotePlayEvent;
import dev.lone.itemsadder.resourcepack.ad;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.aov;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bch;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bec;
import itemsadder.m.bev;
import itemsadder.m.cz;
import itemsadder.m.d;
import itemsadder.m.db;
import itemsadder.m.dc;
import itemsadder.m.dn;
import itemsadder.m.do;
import itemsadder.m.dp;
import itemsadder.m.dq;
import itemsadder.m.dt;
import itemsadder.m.dz;
import itemsadder.m.ec;
import itemsadder.m.ef;
import itemsadder.m.eg;
import itemsadder.m.ek;
import itemsadder.m.eo;
import itemsadder.m.jn;
import itemsadder.m.jp;
import itemsadder.m.la;
import itemsadder.m.w;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
public class da {
    public static int lo = 0;
    public static final int lp = 50;
    private static final long lq = 5L;
    private static final long lr = 200L;
    private static final long ls = 20L;
    public static final int lt = 40;
    public static final double lu = (double)0.3f;
    public static final long lv = 10L;
    public static final double lw = 1.75;
    public static final double lx = -0.0784000015258789;
    public static final NamespacedKey ly = new NamespacedKey("itemsadder", "entity_mount_seat");
    public static final NamespacedKey lz = new NamespacedKey("itemsadder", "entity_mount_seat_custom_entity");
    public static final NamespacedKey lA = new NamespacedKey("itemsadder", "custom_entity");
    public static final NamespacedKey lB = new NamespacedKey("itemsadder", "custom_entity_player_skin");
    public static final String lC = "_iainternal:player";
    public static final String lD = "_iainternal/models/entity/player/";
    public static final String lE = "player_animations";
    public static final String lF = "player_advanced_animations";
    public static final String lG = "player";
    public static final String lH = "internal/player/player.player_animations";
    public static final String lI = "ewogICJ0aW1lc3RhbXAiIDogMTY2NjMwMjkxNzkzOCwKICAicHJvZmlsZUlkIiA6ICJjOWRlZTM4MDUzYjg0YzI5YjZlZjA5YjJlMDM5OTc0ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTQVJfRGVjZW1iZXI1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMxZjQ3N2ViMWE3YmVlZTYzMWMyY2E2NGQwNmY4ZjY4ZmE5M2EzMzg2ZDA0NDUyYWIyN2Y0M2FjZGYxYjYwY2IiCiAgICB9CiAgfQp9";
    public final Map lJ = Collections.synchronizedMap(new HashMap());
    private final List lK = Collections.synchronizedList(new ArrayList());
    private final Map lL = Collections.synchronizedMap(new HashMap());
    private final Map lM = Collections.synchronizedMap(new bec());
    private final Map lN = Collections.synchronizedMap(new HashMap());
    private final Map lO = Collections.synchronizedMap(new bec());
    private List lP = new ArrayList();
    private HashMap lQ = new HashMap();
    private List lR = new ArrayList();
    private final Map lS = Collections.synchronizedMap(new HashMap());
    private final Map lT = Collections.synchronizedMap(new HashMap());
    public final List lU = Collections.synchronizedList(new ArrayList());
    private static da lV;
    private static boolean kR;
    private eo lW;
    ScheduledExecutorService iT = Executors.newScheduledThreadPool(2, runnable -> {
        Thread thread = new Thread(runnable, "ItemsAdder-Entities-Tick");
        thread.setDaemon(true);
        return thread;
    });
    private static final String lX = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAaVBMVEUAAACqcllBNZs6MYmbY0kAr69GOqUrHg0ApKQzJBEElZWQWT8FiIgAf39KSkokGAiBUzk3NzcDeno/KhUKvLw/Pz92SzMAaGiPXj4oKChHIg4AzMy0e2GUYD7///9SPYlVVVV3QjVqQDDj1w1CAAAAAXRSTlMAQObYZgAAAsZJREFUWMPtlt2WojAQhA00kpAo4M+IjjuzM+//kFvVIcvq0RN0LtcihIZjfXQnCFkk1bVDc3U3avGoardFI+ANegYAMzf/pvIPA+h22J8H1LEIH0t4HOAch3G77XwH+eFxAMcAGjrdnpkFx3Gsu+EEdcN8I50t+y0EAk4cD06jOg/gD1vn0ODn1hLHIeX17azaa3ZyPp+NOIaoxWkaoGYBmjHuKQZ+Y0RdsQwWkgfEx09a8/Fp5PPDtOL1kmsVlAc4/lYgY76/jWHUav5tS0h+ENu69TJ0v/xw+vo6IegG8bhIQD0H0Hn4hcY4/34QEPg4ttDMf2UJ9f3xmM7fjQBr3stR6XpVVRalmpuA47Hv/wLEQ3ITYAC/m0EWsAMgn8H9EixLuM6gKMpiuVyWOBQIygbCfUSMrWJs0cNaIcJhBfFkApQTYAk1ITRV1RjDnjGdVfIDcDisEE6A0VgkQNhsgoWFHWMSyIKJkIYAwm4D0DZQMjG2dGFfjTpAPF4AWAYJJURTsAoIjBkSIiKemwonlxmgEcKdaQdrFTCWoAnxn2oEHdwGugRA6RggpozbhhTzlC4iFIA2AaAESLMQmDamj7ECLAEqLeQig1KNxCCCmtCgWU1CIwTwB+avALkCrNflqLUKLjJ0HCm64Q/MPxEuAP0ert+07hnu42QgnwAbA1SEYBkBEgHyL6Dv9zTuewj9+EhjWkKI4wIWenjo1LlksHjpv9QuqrJQhWDx0ktXyn5s+U3i64jxUwsOArwY84MMdpWBfpKB9TKrhLReKIr00V1B6dNO5QHJWQIE6edcCdrPA5QEFBOgiWa2+RkoAFFaDySN74OkCXhvveAp4aby2QxohjQDxgJrXBpEPVYCRIDaSUE0fxAhArwCqEiZ8RClJyHWorWrPQO4t15IftozgNvrBQVIAkgecL1e4AwSkdYHiyv9AfNfNne5fuGHAAAAAElFTkSuQmCC";
    private static BufferedImage lY;

    public static boolean P() {
        return lV != null;
    }

    public static da db() {
        if (lV == null) {
            lV = new da();
        }
        return lV;
    }

    da() {
        if (!kR) {
            this.lW = new eo();
            this.lW.register((Plugin)Main.rS());
            this.dj();
        }
    }

    public void O() {
        kR = true;
        this.dk();
        bcp.r(this.getClass());
        this.iT.shutdownNow();
    }

    public boolean dc() {
        return this.lJ.containsKey(lC);
    }

    public int dd() {
        return this.lK.size();
    }

    public void de() {
        this.lJ.clear();
    }

    public Map df() {
        return this.lS;
    }

    public List f(String string, boolean bl) {
        Set set = this.lJ.keySet();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : set) {
            if (!string2.contains(string)) continue;
            arrayList.add(string2);
        }
        if (arrayList.size() > 0) {
            if (!bl) {
                arrayList.remove(lC);
            }
            arrayList.removeAll(this.lR);
            return arrayList;
        }
        return Collections.singletonList("MobNotFound");
    }

    void a(dn dn2) {
        this.lK.add(dn2);
        if (dn2.ni.fF()) {
            this.lL.put(dn2.eg().getUniqueId(), dn2);
            this.lM.put(dn2.eg().getEntityId(), dn2);
        }
        this.lN.computeIfAbsent(dn2.ni.cE(), world -> new ArrayList()).add(dn2);
        dn2.na.forEach((string, ej2) -> this.lO.put(ej2.qw.Yb, dn2));
    }

    public void a(dq dq2) {
        this.a(dq2.fA());
    }

    public void a(dp dp2) {
        this.lJ.put(dp2.nO.getNamespacedID(), dp2);
    }

    public void dg() {
        ec ec2;
        String string = lC.split(":")[0];
        String string2 = lC.split(":")[1];
        try {
            ec2 = new ec(string, string2);
            ec2.a(lG, Main.cQ(lH), true);
        }
        catch (Exception exception) {
            bce.error("Failed to read player animation data: " + string + ":" + string2, exception);
            return;
        }
        dq dq2 = dp.fy().a(ec2).au(lC).b(EntityType.ZOMBIE).x(false).z(true).A(false).B(false).C(false).D(true).a(20.0).a((BarStyle)null).a((BarColor)null).b((Double)null).a((Float)null).E(false);
        da.db().a(dq2);
        for (File file2 : d.C()) {
            FileUtils.listFiles((File)file2, (String[])new String[]{lE}, (boolean)true).forEach(file -> {
                try {
                    if (this.g((File)file)) {
                        bce.warn("Warning: Skipped loading of a '.player_animations' file.");
                        bce.warn("Found both '.player_advanced_animations' and '.player_animations' file in folder.");
                        bce.warn("Please delete the folder and regenerate it using Blockbench. File: " + bcy.H(file));
                        return;
                    }
                    ec2.b((File)file, ad.x(file) + "_" + FilenameUtils.removeExtension((String)file.getName()), FileUtils.readFileToString((File)file, (String)StandardCharsets.UTF_8.toString()));
                }
                catch (Exception exception) {
                    bce.error("Failed to load player animations from file: " + file.getAbsolutePath());
                    exception.printStackTrace();
                }
            });
        }
    }

    public void dh() {
        for (File file2 : d.C()) {
            FileUtils.listFiles((File)file2, (String[])new String[]{lF}, (boolean)true).forEach(file -> {
                try {
                    if (this.g((File)file)) {
                        bce.warn("Warning: Skipped loading of advanced player animations. Found duplicate. Please delete it and regenerate it using Blockbench. File: " + bcy.H(file));
                        return;
                    }
                    String string = file.getParentFile().getParentFile().getParentFile().getParentFile().getName();
                    String string2 = file.getParentFile().getName();
                    da.db().m(string + ":" + string2, bcy.aG(bcy.iR(file.getAbsolutePath()), "assets/"));
                }
                catch (Exception exception) {
                    bce.error("Failed to load player animations from file: " + file.getAbsolutePath());
                    exception.printStackTrace();
                }
            });
        }
    }

    public void di() {
        this.lJ.forEach((string, dp2) -> {
            dp2.on.aR();
            dp2.oo.aR();
        });
    }

    private boolean g(File file) {
        for (Map.Entry entry : da.db().lJ.entrySet()) {
            String string = (String)entry.getKey();
            dp dp2 = (dp)entry.getValue();
            if (string.equals(lC) || !dp2.nO.pD || !dp2.nO.i(file)) continue;
            return true;
        }
        return false;
    }

    public void m(String string, String string2) {
        ef ef2;
        String string3 = string.split(":")[0];
        String string4 = string.split(":")[1];
        try {
            ef2 = new ef(string3, string4);
            if (!ef2.aI(string2)) {
                return;
            }
        }
        catch (Exception exception) {
            bce.error("Failed to load custom player model entity: " + string3 + ":" + string4);
            exception.printStackTrace();
            return;
        }
        dq dq2 = dp.fy().a(ef2).au(string).b(EntityType.ZOMBIE).x(false).z(true).A(false).B(false).C(false).D(true).a(20.0).a((BarStyle)null).a((BarColor)null).b((Double)null).a((Float)null).E(false).F(true).G(true);
        da.db().a(dq2);
        bce.log("Loaded player model " + ef2.getNamespacedID());
    }

    public void c(bbf bbf2) {
        @Nullable bbg bbg2 = bbf2.hj("emotes");
        if (bbg2 == null) {
            return;
        }
        Set set = bbg2.aX(false);
        for (String string : set) {
            @Nullable bbg bbg3 = bbg2.hj(string);
            String string2 = bbg3.az("id", null);
            if (string2 == null) {
                bce.warn("Missing id for emote '" + string + "'. File:" + bbf2.nh());
                continue;
            }
            bch bch2 = bch.Dk();
            dt dt2 = this.a(string, bch2);
            if (dt2 != null) {
                if (!bbg3.C("enabled", true)) {
                    ((ec)bch2.aAW).aH(string);
                    continue;
                }
                dt2.c(bbg3.C("hide_equipment.helmet", false), bbg3.C("hide_equipment.mainhand", false), bbg3.C("hide_equipment.offhand", false));
                dt2.H(bbg3.C("can_player_move", true));
                dt2.K(bbg3.C("third_person_view", ae.dN));
                dt2.L(bbg3.C("track_player_rotation.head", true));
                dt2.M(bbg3.C("track_player_rotation.body", true));
                dt2.a(bbg3.C("cancel_conditions.sneak", true), bbg3.C("cancel_conditions.take_damage", true), bbg3.C("cancel_conditions.deal_damage", true), bbg3.C("cancel_conditions.in_air", true));
                dt2.I(bbg3.C("on_stop.stop_sounds", true));
                dt2.J(bbg3.C("on_stop.skip_emote_end", false));
                dt2.a(bbg3.a("speed.movement", (Float)null), bbg3.a("speed.flying", (Float)null));
                if (!bbg3.fo("background_music.sound.name")) continue;
                dt2.a(bbg3.gV("background_music.sound.name"), bbi.a(bbg3.gV("background_music.sound.category"), SoundCategory.MUSIC), bbg3.a("background_music.sound.volume", 1.0f), bbg3.a("background_music.sound.pitch", 1.0f), bbg3.a("background_music.repeat_interval_seconds", 0.0f));
                continue;
            }
            bce.warn("Unknown emote '" + string + "'. File:" + bbf2.nh());
        }
    }

    @Nullable
    public dn a(String string, Location location, boolean bl, boolean bl2, boolean bl3) {
        return this.a(string, null, location, bl, bl2, bl3);
    }

    @Nullable
    public dn a(String string, Location location, boolean bl) {
        return this.a(string, null, location, bl, false, false);
    }

    public dn a(String string, Location location, @Nullable String string2, List list, boolean bl, boolean bl2, boolean bl3, @Nullable Consumer consumer) {
        return this.a(string, location, string2, list, bl, bl2, bl3, true, false, consumer);
    }

    @Nullable
    public dn a(String string, Location location, @Nullable String string2, List list, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, @Nullable Consumer consumer) {
        if (location == null || location.getWorld() == null) {
            return null;
        }
        if (string2 == null && string.equals(lC)) {
            return null;
        }
        dn dn2 = new dn((dp)this.lJ.get(string), true);
        dn2.mB = bl;
        dn2.mC = bl2;
        dn2.mD = bl3;
        dn2.mE = bl4;
        dn2.mF = bl5;
        dn2.mG = true;
        if (bl2) {
            dn2.r(location);
            if (consumer != null) {
                consumer.accept(null);
            }
        } else {
            dn2.a(location, (java.util.function.Consumer)consumer);
        }
        for (Player player : list) {
            dn2.e(player, true);
        }
        if (string2 != null) {
            dn2.changePlayerSkin(string2);
        }
        this.a(dn2);
        dn2.ec().gk();
        dn2.eN();
        return dn2;
    }

    @Nullable
    public dn a(String string, @Nullable String string2, Location location, boolean bl, boolean bl2, boolean bl3) {
        if (location == null || location.getWorld() == null) {
            return null;
        }
        dp dp2 = (dp)this.lJ.get(string);
        if (dp2 == null) {
            return null;
        }
        if (string2 == null && string.equals(lC)) {
            return null;
        }
        if (dp2.nO.pD && string2 == null) {
            return null;
        }
        dn dn2 = new dn(dp2, true);
        dn2.e(location.getWorld());
        dn2.mB = bl;
        dn2.mD = bl3;
        dn2.mC = bl2;
        if (bl2) {
            dn2.r(location);
        } else {
            dn2.q(location);
        }
        if (string2 != null) {
            dn2.changePlayerSkin(string2);
        }
        this.a(dn2);
        dn2.ec().gk();
        dn2.eN();
        return dn2;
    }

    @Nullable
    public dn a(String string, LivingEntity livingEntity, boolean bl) {
        return this.a(string, null, livingEntity, true, bl, false, true);
    }

    @Nullable
    public dn a(String string, @Nullable String string2, LivingEntity livingEntity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.a(string, string2, livingEntity, bl, bl2, bl3, false, bl4);
    }

    @Nullable
    public dn a(String string, @Nullable String string2, LivingEntity livingEntity, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.f((Entity)livingEntity)) {
            this.i((Entity)livingEntity);
        }
        dn dn2 = new dn((dp)this.lJ.get(string), bl2);
        dn2.mB = bl;
        dn2.mD = bl3;
        dn2.mE = bl4;
        dn2.e(livingEntity.getWorld());
        dn2.b(livingEntity, bl5);
        this.a(string2, livingEntity, dn2);
        this.a(dn2);
        return dn2;
    }

    @Nullable
    public dn a(String string, @Nullable String string2, LivingEntity livingEntity, List list, boolean bl, boolean bl2) {
        if (this.f((Entity)livingEntity)) {
            this.i((Entity)livingEntity);
        }
        dn dn2 = new dn((dp)this.lJ.get(string), bl2);
        dn2.mB = bl;
        dn2.mG = true;
        dn2.b(livingEntity, true);
        this.a(string2, livingEntity, dn2);
        for (Player player : list) {
            dn2.e(player, true);
        }
        this.a(dn2);
        return dn2;
    }

    private void a(@Nullable String string, LivingEntity livingEntity, dn dn2) {
        if (string == null) {
            String string2 = (String)livingEntity.getPersistentDataContainer().get(lB, PersistentDataType.STRING);
            if (string2 != null) {
                dn2.changePlayerSkin(string2);
            }
        } else {
            dn2.changePlayerSkin(string);
        }
    }

    @Nullable
    public dn a(LivingEntity livingEntity) {
        return this.a(livingEntity, true);
    }

    @Nullable
    public dn a(LivingEntity livingEntity, boolean bl) {
        if (da.g((Entity)livingEntity)) {
            String string;
            dp dp2;
            if (bl) {
                this.i((Entity)livingEntity);
            }
            if ((dp2 = (dp)this.lJ.get(string = (String)livingEntity.getPersistentDataContainer().get(lA, PersistentDataType.STRING))) == null) {
                return null;
            }
            String string2 = (String)livingEntity.getPersistentDataContainer().get(lB, PersistentDataType.STRING);
            dn dn2 = new dn(dp2, true);
            dn2.e(livingEntity.getWorld());
            dp2.a(livingEntity, null, false);
            dn2.b(livingEntity, true);
            this.a(dn2);
            if (string2 != null) {
                dn2.changePlayerSkin(string2);
            }
            for (do do_ : dn2.nk) {
                dn2.b(do_);
            }
            dn2.ec().gl();
            return dn2;
        }
        return null;
    }

    public void b(dn dn2) {
        if (dn2 != null) {
            do do_;
            int n2;
            dn2.ex();
            if (!dn2.mG) {
                dn2.e(dn2.cE());
            }
            int n3 = dn2.nk.size();
            for (n2 = 0; n2 < n3; ++n2) {
                do_ = (do)dn2.nk.get(n2);
                do_.nN = true;
                afz.tK().a(do_.iW, dn2.eb());
            }
            n3 = dn2.nk.size();
            for (n2 = 0; n2 < n3; ++n2) {
                do_ = (do)dn2.nk.get(n2);
                dn2.na.forEach((string, ej2) -> {
                    do_.nN = false;
                    ej2.e(do_);
                    if (ej2.qx.po == dz.MOUNT_PIVOT && ej2.gD() != null) {
                        ej2.gD().gM();
                    }
                });
            }
            dn2.ej();
            dn2.mN.gl();
        }
    }

    public static void a(Entity entity, String string) {
        entity.getPersistentDataContainer().set(lA, PersistentDataType.STRING, (Object)string);
    }

    public static void b(Entity entity, String string) {
        entity.getPersistentDataContainer().set(lB, PersistentDataType.STRING, (Object)string);
    }

    public void dj() {
        bcp.b(bukkitRunnable -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                dn dn2 = (dn)this.lK.get(i);
                int n = dn2.getLocation().getWorld().getViewDistance() * 16;
                if (dn2.mK.getWorld() != dn2.getLocation().getWorld() || dn2.mK.distance(dn2.getLocation()) >= (double)(n - 1)) {
                    this.b(dn2);
                }
                dn2.mK = dn2.getLocation();
                List list = dn2.ea();
                for (int j = 0; j < list.size(); ++j) {
                    do do_ = (do)list.get(j);
                    do_.fo();
                }
            }
        }, 0L, 5L);
        bcp.b(bukkitRunnable -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                dn dn2 = (dn)this.lK.get(i);
                dn2.dY();
            }
        }, 0L, 200L);
        bcp.b(bukkitRunnable -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                dn dn2 = (dn)this.lK.get(i);
                dn2.dZ();
                for (ek ek2 : dn2.mZ) {
                    if (!ek2.gG()) continue;
                    ek2.gN();
                    ek2.gk();
                }
            }
        }, 0L, 20L);
        bcp.a((T bukkitRunnable) -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                dn dn2 = (dn)this.lK.get(i);
                for (ek ek2 : dn2.mZ) {
                    if (!ek2.gG()) continue;
                    ek2.bV();
                }
                dn2.ej();
                dn2.dX();
                dn2.eP();
            }
        }, 0L, 20L);
        bcp.a(() -> {
            ArrayList<dn> arrayList = new ArrayList<dn>();
            for (int i = 0; i < this.lK.size(); ++i) {
                dn dn2 = (dn)this.lK.get(i);
                if (!dn2.ni.fF() || dn2.mN.gu() || dn2.eg().isValid() && !dn2.eg().isDead()) continue;
                arrayList.add(dn2);
            }
            for (dn dn2 : arrayList) {
                jp jp2 = jn.g(dn2.eg());
                if (jp2 != null) {
                    jp2.remove();
                }
                this.i((Entity)dn2.eg());
            }
        }, 10L);
        this.iT.scheduleAtFixedRate(() -> {
            try {
                for (int i = 0; i < this.lK.size(); ++i) {
                    Object object;
                    Object object2;
                    dn dn2 = (dn)this.lK.get(i);
                    if (dn2.removed || dn2.ea().isEmpty() || dn2.mF && lo % 10000 != 0) continue;
                    if (!dn2.fj()) {
                        if (!dn2.mL) {
                            object2 = dn2.eW();
                            object = dn2.eg();
                            if (object instanceof Player) {
                                Player player = (Player)object;
                                if (w.bN.j(player)) {
                                    object2 = dn2.fb();
                                }
                                this.a(dn2, player);
                                if (dn2.eu()) {
                                    if (dn2.fi() != null && player.isSneaking()) {
                                        object2 = dn2.fi();
                                    }
                                } else if (dn2.fh() != null && player.isSneaking()) {
                                    object2 = dn2.fh();
                                }
                            }
                            if (object2 != null) {
                                if (dn2.eQ() == dn2.mV) {
                                    dn2.b((dt)object2);
                                } else if (!(!dn2.eD() || Main.PK && CitizensHook.isNPC(dn2.eg()))) {
                                    dn2.a((dt)object2);
                                } else {
                                    dn2.b((dt)object2);
                                }
                            }
                        }
                    } else {
                        LivingEntity livingEntity = dn2.eg();
                        if (livingEntity instanceof Player) {
                            object2 = (Player)livingEntity;
                            this.a(dn2, (Player)object2);
                        }
                    }
                    dn2.ec().gk();
                    dn2.eN();
                    dn2.eU();
                    object2 = dn2.ea();
                    for (int j = 0; j < object2.size(); ++j) {
                        object = (do)object2.get(j);
                        ((do)object).fp();
                    }
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            ++lo;
        }, 0L, TimeUnit.MILLISECONDS.toNanos(50L), TimeUnit.NANOSECONDS);
        this.iT.scheduleAtFixedRate(() -> {
            try {
                for (int i = 0; i < this.lK.size(); ++i) {
                    dn dn2 = (dn)this.lK.get(i);
                    if (dn2.removed || dn2.ea().size() == 0) continue;
                    List list = dn2.ea();
                    for (int j = 0; j < list.size(); ++j) {
                        do do_ = (do)list.get(j);
                        if (do_.nL > dn2.nz) {
                            dn2.c(do_);
                            continue;
                        }
                        dn2.a(do_);
                    }
                }
                ++lo;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, 0L, TimeUnit.MILLISECONDS.toNanos(200L), TimeUnit.NANOSECONDS);
        bcp.a(() -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                dn dn2 = (dn)this.lK.get(i);
                if (!dn2.eE()) continue;
                for (ek ek2 : dn2.mZ) {
                    if (!ek2.gG()) continue;
                    ek2.bV();
                }
            }
        }, 1L);
    }

    private void a(dn dn2, Player player) {
        aov aov2;
        if (dn2.eu() && (aov2 = (aov)la.zQ.get(player)) != null) {
            float f2;
            float f3 = f2 = dn2.getLocation().getYaw();
            float f4 = 0.2f;
            if (aov2.uI()) {
                f3 -= 45.0f;
                f4 = 0.8f;
            } else if (aov2.uJ()) {
                f3 += 45.0f;
                f4 = 0.8f;
            } else if (aov2.uG() || aov2.uH()) {
                f3 = f2;
            } else {
                return;
            }
            float f5 = afz.tK().M((Entity)dn2.eg());
            float f6 = f5 + (f3 - f5);
            afz.tK().c((Entity)dn2.eg(), bcc.e(f5, f6, f4));
        }
    }

    public void Q(Player player) {
        ArrayList arrayList = (ArrayList)this.lN.get(player.getWorld());
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            dn dn2 = (dn)arrayList.get(i2);
            if (dn2.mG) continue;
            dn2.e(player, true);
        }
    }

    public void a(Player player, dn dn2) {
        dn2.removeViewer(player);
    }

    public void R(Player player) {
        for (int i2 = 0; i2 < this.lK.size(); ++i2) {
            dn dn2 = (dn)this.lK.get(i2);
            dn2.removeViewer(player);
        }
    }

    public void dk() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i2 = 0; i2 < this.lK.size(); ++i2) {
                dn dn2 = (dn)this.lK.get(i2);
                dn2.u(false);
                this.a(player, dn2);
            }
        }
        this.lK.clear();
        this.lL.clear();
        this.lM.clear();
        this.lN.clear();
        this.lO.clear();
        this.lS.clear();
        this.lT.clear();
        this.lU.clear();
        this.lJ.clear();
    }

    public void a(World world) {
        ArrayList arrayList = (ArrayList)this.lN.get(world);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                dn dn2 = (dn)arrayList.get(i2);
                this.d(dn2);
            }
        }
    }

    public void S(Player player) {
        ArrayList arrayList = (ArrayList)this.lN.get(player.getWorld());
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            dn dn2 = (dn)arrayList.get(i2);
            if (!dn2.mG) {
                do do_ = dn2.aa(player);
                dn2.b(do_);
            } else {
                dn2.ac(player);
            }
            dn2.ab(player);
        }
    }

    public void a(World world, Player player) {
        ArrayList arrayList = (ArrayList)this.lN.get(world);
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            dn dn2 = (dn)arrayList.get(i2);
            dn2.ad(player);
            if (dn2.mG) continue;
            dn2.removeViewer(player);
        }
    }

    public boolean f(Entity entity) {
        return this.lL.containsKey(entity.getUniqueId());
    }

    public boolean d(UUID uUID) {
        return this.lL.containsKey(uUID);
    }

    @Nullable
    public dn n(Location location) {
        ArrayList arrayList = (ArrayList)this.lN.get(location.getWorld());
        if (arrayList == null) {
            return null;
        }
        double d2 = 200.0;
        dn dn2 = null;
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            dn dn3 = (dn)arrayList.get(i2);
            double d3 = dn3.getLocation().distance(location);
            if (d3 > d2) continue;
            d2 = d3;
            dn2 = dn3;
        }
        return dn2;
    }

    public static boolean g(Entity entity) {
        return entity.getPersistentDataContainer().has(lA, PersistentDataType.STRING);
    }

    public dp am(String string) {
        return (dp)this.lJ.get(string);
    }

    @Nullable
    public dn e(UUID uUID) {
        return (dn)this.lL.get(uUID);
    }

    @Nullable
    public dn h(Entity entity) {
        if (entity != null) {
            return (dn)this.lL.get(entity.getUniqueId());
        }
        return null;
    }

    public dn T(Player player) {
        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5.0, 0.1, entity -> entity.getEntityId() != player.getEntityId() && this.lL.containsKey(entity.getUniqueId()));
        if (rayTraceResult != null && rayTraceResult.getHitEntity() != null) {
            Entity entity2 = rayTraceResult.getHitEntity();
            return (dn)this.lL.get(entity2.getUniqueId());
        }
        return null;
    }

    @Nullable
    public dn j(int n2) {
        return (dn)this.lM.get(n2);
    }

    @Nullable
    public dn k(int n2) {
        return (dn)this.lO.get(n2);
    }

    public ImmutableList dl() {
        return ImmutableList.copyOf(this.lK);
    }

    public void c(dn dn2) {
        dn2.na.forEach((string, ej2) -> this.lO.remove(ej2.qw.Yb));
    }

    public void i(Entity entity) {
        if (entity == null) {
            return;
        }
        dn dn2 = this.e(entity.getUniqueId());
        if (dn2 != null) {
            dn2.eo();
            this.lK.remove(dn2);
            ArrayList arrayList = (ArrayList)this.lN.get(dn2.cE());
            if (arrayList != null) {
                arrayList.remove(dn2);
            }
        }
        new HashMap<LivingEntity, ek>(this.lS).forEach((livingEntity, ek2) -> {
            if (ek2.gH() == dn2) {
                this.removePassenger((LivingEntity)livingEntity);
            }
        });
        this.lL.remove(entity.getUniqueId());
        this.lM.remove(entity.getEntityId());
    }

    public void d(dn dn2) {
        if (dn2 != null) {
            if (dn2.eg() != null) {
                this.i((Entity)dn2.eg());
                return;
            }
            dn2.eo();
            this.lK.remove(dn2);
            ArrayList arrayList = (ArrayList)this.lN.get(dn2.cE());
            if (arrayList != null) {
                arrayList.remove(dn2);
            }
        }
        new HashMap<LivingEntity, ek>(this.lS).forEach((livingEntity, ek2) -> {
            if (ek2.gH() == dn2) {
                this.removePassenger((LivingEntity)livingEntity);
            }
        });
    }

    public void a(dn dn2, boolean bl, boolean bl2) {
        cz cz2;
        if (dn2.eg() instanceof Player && (cz2 = (cz)this.lT.get(dn2.eg().getUniqueId())) != null) {
            cz2.cZ();
            this.lT.remove(dn2.eg().getUniqueId());
        }
        dn2.c(bl, bl2);
        this.d(dn2);
    }

    public void a(cz cz2, boolean bl, boolean bl2) {
        dn dn2 = cz2.renderer;
        cz2.cZ();
        this.lT.remove(dn2.eg().getUniqueId());
        dn2.c(bl, bl2);
        this.d(dn2);
    }

    public void e(dn dn2) {
        this.d(dn2);
        dn2.eL();
    }

    public boolean a(LivingEntity livingEntity, ek ek2) {
        if (this.b(livingEntity)) {
            return false;
        }
        ek2.d(livingEntity);
        this.lS.put(livingEntity, ek2);
        return true;
    }

    public boolean a(LivingEntity livingEntity, dn dn2) {
        if (this.b(livingEntity)) {
            return false;
        }
        ek ek2 = dn2.eF();
        if (ek2 == null) {
            return false;
        }
        ek2.d(livingEntity);
        this.lS.put(livingEntity, ek2);
        return true;
    }

    public void removePassenger(LivingEntity livingEntity) {
        ek ek2 = (ek)this.lS.get(livingEntity);
        if (ek2 == null) {
            return;
        }
        ek2.removePassenger();
        this.lS.remove(livingEntity);
    }

    public void a(ek ek2) {
        if (ek2 == null || ek2.qR == null) {
            return;
        }
        this.lS.remove(ek2.qR);
        ek2.removePassenger();
    }

    public void f(dn dn2) {
        for (ek ek2 : dn2.mZ) {
            this.a(ek2);
        }
    }

    public boolean b(LivingEntity livingEntity) {
        return this.lS.containsKey(livingEntity);
    }

    public boolean b(LivingEntity livingEntity, dn dn2) {
        ek ek2 = (ek)this.lS.get(livingEntity);
        if (ek2 == null) {
            return false;
        }
        return ek2.qQ.qv == dn2;
    }

    @Nullable
    public ek c(LivingEntity livingEntity) {
        return (ek)this.lS.get(livingEntity);
    }

    @Nullable
    public dn a(@Nullable LivingEntity livingEntity, String string, Location location, String string2, @Nullable String string3) {
        dn dn2 = new dn((dp)this.lJ.get(string2), false);
        dn2.v(true);
        if (string3 != null && dn2.ar(string3) == null) {
            return null;
        }
        dn2.e(location.getWorld());
        dn2.ao(string);
        dn2.c((dt)null);
        dn2.d(null);
        dn2.g(null);
        dn2.f(null);
        if (livingEntity == null) {
            dn2.q(location);
            dn2.ej();
            this.a(dn2);
        } else {
            dn2.b(livingEntity, false);
            this.a(dn2);
        }
        return dn2;
    }

    @Nullable
    public dn U(Player player) {
        cz cz2 = this.V(player);
        if (cz2 == null) {
            return null;
        }
        return cz2.renderer;
    }

    @Nullable
    public cz V(Player player) {
        return (cz)this.lT.get(player.getUniqueId());
    }

    public dc b(Player player, @NotNull String string) {
        dn dn2;
        if (!bev.b((Event)new PlayerEmotePlayEvent(player, string))) {
            return dc.CANCELLED;
        }
        bch bch2 = bch.Dk();
        dt dt2 = this.a(string, bch2);
        if (dt2 == null || !bch2.Dl()) {
            return dc.UNKNOWN_EMOTE;
        }
        if (!player.isOnGround() && dt2.oT) {
            return dc.CANCELLED;
        }
        cz cz2 = this.V(player);
        if (cz2 != null) {
            this.X(player);
        }
        if ((dn2 = this.a((LivingEntity)player, player.getName(), player.getLocation(), ((ec)bch2.aAW).getNamespacedID(), string)) == null) {
            return dc.UNKNOWN_EMOTE;
        }
        cz cz3 = new cz(player, dn2, true);
        this.lT.put(player.getUniqueId(), cz3);
        bcp.a(() -> {
            try {
                if (cz2.lj.get()) {
                    return;
                }
                cz3.cY();
            }
            catch (Exception exception) {
                bce.error("Error starting emote.", exception);
            }
        }, 5);
        dn2.a(string, 0, false, () -> bcp.i(() -> this.b(cz3)));
        return dc.PLAY;
    }

    public boolean W(Player player) {
        cz cz2 = this.V(player);
        if (cz2 != null) {
            this.X(player);
            da.db().a(cz2.renderer, false, false);
            this.lT.remove(player.getUniqueId());
            return true;
        }
        return false;
    }

    public boolean c(Player player, String string) {
        dn dn2;
        cz cz2 = this.V(player);
        if (cz2 != null) {
            this.X(player);
            da.db().a(cz2.renderer, false, false);
        }
        if ((dn2 = da.db().a(string, null, (LivingEntity)player, false, true, false, false)) == null) {
            return false;
        }
        dn2.w(true);
        cz cz3 = new cz(player, dn2, false);
        this.lT.put(player.getUniqueId(), cz3);
        cz3.cY();
        return true;
    }

    @Nullable
    private dt a(String string, bch bch2) {
        dt dt2 = null;
        for (Map.Entry entry : this.lJ.entrySet()) {
            dp dp2 = (dp)entry.getValue();
            if (!dp2.nO.pD) continue;
            dt2 = (dt)dp2.nO.pB.get(string);
            bch2.H(dp2.nO);
            if (dt2 == null) continue;
            break;
        }
        return dt2;
    }

    public static db a(dn dn2, String string) {
        dp dp2 = (dp)da.db().dq().get(string);
        if (dp2 == null) {
            return new db(false, false, null);
        }
        String string2 = dp2.nO.getNamespacedID();
        if (string2.equals(dn2.es())) {
            dn2.a(string, 0, false, () -> da.g(dn2));
            return new db(true, false, null);
        }
        dn dn3 = da.a(string2, dn2.ek(), dn2.eg());
        dn3.a(string, 0, false, () -> da.g(dn3));
        return new db(true, true, string2);
    }

    private static void g(dn dn2) {
        if (!da.h(dn2)) {
            bcp.c(() -> {
                if (!da.h(dn2)) {
                    String string = dn2.ek();
                    LivingEntity livingEntity = dn2.eg();
                    dn dn3 = da.a(lC, string, livingEntity);
                    dn3.ap("idle");
                }
            }, 1L);
        } else {
            dn2.ap("idle");
        }
    }

    private static dn a(String string, @Nullable String string2, LivingEntity livingEntity) {
        dn dn2 = da.db().a(string, livingEntity, true);
        if (string2 != null) {
            dn2.changePlayerSkin(string2);
        }
        dn2.dV();
        dn2.dX();
        return dn2;
    }

    public dp dm() {
        return (dp)this.lJ.get(lC);
    }

    public List dn() {
        return new ArrayList(this.lP);
    }

    public List t(boolean bl) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry entry : da.db().lJ.entrySet()) {
            if (!bl && ((dp)entry.getValue()).nO.pD) continue;
            arrayList.add((String)entry.getKey());
        }
        return arrayList;
    }

    public void do() {
        ArrayList arrayList = new ArrayList();
        dp dp2 = da.db().dm();
        if (dp2 != null) {
            arrayList.addAll(dp2.nO.getAnimationsNames());
            arrayList.remove("idle");
        }
        for (Map.Entry entry : this.lJ.entrySet()) {
            dp dp3 = (dp)entry.getValue();
            if (!dp3.nO.pD) continue;
            dp3.nO.pB.forEach((string, dt2) -> arrayList.add(string));
            this.lR.add(dp3.nO.getNamespacedID());
            dp3.nO.pB.forEach((string, dt2) -> this.lQ.put(string, dp3));
        }
        this.lP = arrayList;
    }

    public List dp() {
        return this.lR;
    }

    public HashMap dq() {
        return this.lQ;
    }

    public static boolean h(dn dn2) {
        return dn2.es().equals(lC);
    }

    public boolean X(Player player) {
        cz cz2 = this.V(player);
        if (cz2 != null) {
            bev.b((Event)new PlayerEmoteEndEvent(player, cz2.renderer.mN.aM(null), PlayerEmoteEndEvent$Cause.STOP));
            dt dt2 = cz2.renderer.mN.qb;
            if (dt2 != null && dt2.oU) {
                for (List list : dt2.oH) {
                    for (eg eg2 : list) {
                        eg2.u(player.getLocation());
                    }
                }
            }
            this.a(cz2, false, false);
            return true;
        }
        return false;
    }

    public void Y(Player player) {
        cz cz2 = this.V(player);
        if (cz2 != null) {
            this.a(cz2);
        }
    }

    public void a(cz cz2) {
        Player player = cz2.iW;
        dt dt2 = cz2.renderer.mN.qb;
        bev.b((Event)new PlayerEmoteEndEvent(player, cz2.renderer.mN.aM(null), PlayerEmoteEndEvent$Cause.STOP));
        if (dt2 != null) {
            if (dt2.oU) {
                for (List list : dt2.oH) {
                    for (eg eg2 : list) {
                        eg2.u(player.getLocation());
                    }
                }
            }
            if (dt2.oV) {
                this.a(cz2, false, false);
            }
        }
        if (dt2 == null || dt2.oQ) {
            cz2.renderer.ec().e(false, false);
        }
    }

    private void b(cz cz2) {
        if (cz2.renderer.removed) {
            return;
        }
        bev.b((Event)new PlayerEmoteEndEvent(cz2.iW, cz2.renderer.mN.aM(null), PlayerEmoteEndEvent$Cause.FINISHED));
        this.a(cz2.renderer, true, false);
    }

    public static BufferedImage dr() {
        if (lY != null) {
            return lY;
        }
        try {
            String string = lX.split(",")[1];
            byte[] byArray = Base64.getDecoder().decode(string);
            lY = ImageIO.read(new ByteArrayInputStream(byArray));
            return lY;
        }
        catch (IOException iOException) {
            bce.error("Failed to load Steve skin image.", iOException);
            return null;
        }
    }

    static {
        lY = null;
    }
}
