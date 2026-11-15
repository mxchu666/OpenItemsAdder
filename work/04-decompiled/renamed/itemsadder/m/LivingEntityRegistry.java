package itemsadder.m;

import com.google.common.collect.ImmutableList;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.PlayerEmoteEndEvent;
import dev.lone.itemsadder.api.Events.PlayerEmoteEndEvent$Cause;
import dev.lone.itemsadder.api.Events.PlayerEmotePlayEvent;
import dev.lone.itemsadder.resourcepack.ad;
import itemsadder.m.BoolStringData;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EntityDismountListener;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.EntityTypeBarStyleHolderBuilder;
import itemsadder.m.Hitbox;
import itemsadder.m.HitboxImpl;
import itemsadder.m.Implemented_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LocationBridge_10;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.NormalEnum;
import itemsadder.m.Opaque020;
import itemsadder.m.PlayEnum;
import itemsadder.m.PlayerBridge_16;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.PlayerBukkitTaskHolder;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PluginDisableListener;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfValue_20;
import itemsadder.m.RecordOfValue_3;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.SoundCategoryBridge_2;
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
public class LivingEntityRegistry {
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
    private final Map lM = Collections.synchronizedMap(new Implemented_2());
    private final Map lN = Collections.synchronizedMap(new HashMap());
    private final Map lO = Collections.synchronizedMap(new Implemented_2());
    private List lP = new ArrayList();
    private HashMap lQ = new HashMap();
    private List lR = new ArrayList();
    private final Map lS = Collections.synchronizedMap(new HashMap());
    private final Map lT = Collections.synchronizedMap(new HashMap());
    public final List lU = Collections.synchronizedList(new ArrayList());
    private static LivingEntityRegistry lV;
    private static boolean kR;
    private EntityDismountListener lW;
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

    public static LivingEntityRegistry db() {
        if (lV == null) {
            lV = new LivingEntityRegistry();
        }
        return lV;
    }

    LivingEntityRegistry() {
        if (!kR) {
            this.lW = new EntityDismountListener();
            this.lW.register((Plugin)Main.rS());
            this.dj();
        }
    }

    public void O() {
        kR = true;
        this.dk();
        BukkitTaskBridge.r(this.getClass());
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

    void a(LivingEntityBuilder livingEntityBuilder) {
        this.lK.add(livingEntityBuilder);
        if (livingEntityBuilder.ni.fF()) {
            this.lL.put(livingEntityBuilder.eg().getUniqueId(), livingEntityBuilder);
            this.lM.put(livingEntityBuilder.eg().getEntityId(), livingEntityBuilder);
        }
        this.lN.computeIfAbsent(livingEntityBuilder.ni.cE(), world -> new ArrayList()).add(livingEntityBuilder);
        livingEntityBuilder.na.forEach((string, locationHolder_2) -> this.lO.put(locationHolder_2.qw.Yb, livingEntityBuilder));
    }

    public void a(EntityTypeBarStyleHolderBuilder entityTypeBarStyleHolderBuilder) {
        this.a(entityTypeBarStyleHolderBuilder.fA());
    }

    public void a(EntityTypeBarStyleHolder entityTypeBarStyleHolder) {
        this.lJ.put(entityTypeBarStyleHolder.nO.getNamespacedID(), entityTypeBarStyleHolder);
    }

    public void dg() {
        Hitbox hitbox;
        String string = lC.split(":")[0];
        String string2 = lC.split(":")[1];
        try {
            hitbox = new Hitbox(string, string2);
            hitbox.a(lG, Main.cQ(lH), true);
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Failed to read player animation data: " + string + ":" + string2, exception);
            return;
        }
        EntityTypeBarStyleHolderBuilder entityTypeBarStyleHolderBuilder = EntityTypeBarStyleHolder.fy().a(hitbox).au(lC).b(EntityType.ZOMBIE).x(false).z(true).A(false).B(false).C(false).D(true).a(20.0).a((BarStyle)null).a((BarColor)null).b((Double)null).a((Float)null).E(false);
        LivingEntityRegistry.db().a(entityTypeBarStyleHolderBuilder);
        for (File file2 : ItemStackRegistry.C()) {
            FileUtils.listFiles((File)file2, (String[])new String[]{lE}, (boolean)true).forEach(file -> {
                try {
                    if (this.g((File)file)) {
                        CommandSenderBridge_5.warn("Warning: Skipped loading of a '.player_animations' file.");
                        CommandSenderBridge_5.warn("Found both '.player_advanced_animations' and '.player_animations' file in folder.");
                        CommandSenderBridge_5.warn("Please delete the folder and regenerate it using Blockbench. File: " + ColorBridge.H(file));
                        return;
                    }
                    hitbox.b((File)file, ad.x(file) + "_" + FilenameUtils.removeExtension((String)file.getName()), FileUtils.readFileToString((File)file, (String)StandardCharsets.UTF_8.toString()));
                }
                catch (Exception exception) {
                    CommandSenderBridge_5.error("Failed to load player animations from file: " + file.getAbsolutePath());
                    exception.printStackTrace();
                }
            });
        }
    }

    public void dh() {
        for (File file2 : ItemStackRegistry.C()) {
            FileUtils.listFiles((File)file2, (String[])new String[]{lF}, (boolean)true).forEach(file -> {
                try {
                    if (this.g((File)file)) {
                        CommandSenderBridge_5.warn("Warning: Skipped loading of advanced player animations. Found duplicate. Please delete it and regenerate it using Blockbench. File: " + ColorBridge.H(file));
                        return;
                    }
                    String string = file.getParentFile().getParentFile().getParentFile().getParentFile().getName();
                    String string2 = file.getParentFile().getName();
                    LivingEntityRegistry.db().m(string + ":" + string2, ColorBridge.aG(ColorBridge.iR(file.getAbsolutePath()), "assets/"));
                }
                catch (Exception exception) {
                    CommandSenderBridge_5.error("Failed to load player animations from file: " + file.getAbsolutePath());
                    exception.printStackTrace();
                }
            });
        }
    }

    public void di() {
        this.lJ.forEach((string, entityTypeBarStyleHolder) -> {
            entityTypeBarStyleHolder.on.aR();
            entityTypeBarStyleHolder.oo.aR();
        });
    }

    private boolean g(File file) {
        for (Map.Entry entry : LivingEntityRegistry.db().lJ.entrySet()) {
            String string = (String)entry.getKey();
            EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)entry.getValue();
            if (string.equals(lC) || !entityTypeBarStyleHolder.nO.pD || !entityTypeBarStyleHolder.nO.i(file)) continue;
            return true;
        }
        return false;
    }

    public void m(String string, String string2) {
        HitboxImpl hitboxImpl;
        String string3 = string.split(":")[0];
        String string4 = string.split(":")[1];
        try {
            hitboxImpl = new HitboxImpl(string3, string4);
            if (!hitboxImpl.aI(string2)) {
                return;
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.error("Failed to load custom player model entity: " + string3 + ":" + string4);
            exception.printStackTrace();
            return;
        }
        EntityTypeBarStyleHolderBuilder entityTypeBarStyleHolderBuilder = EntityTypeBarStyleHolder.fy().a(hitboxImpl).au(string).b(EntityType.ZOMBIE).x(false).z(true).A(false).B(false).C(false).D(true).a(20.0).a((BarStyle)null).a((BarColor)null).b((Double)null).a((Float)null).E(false).F(true).G(true);
        LivingEntityRegistry.db().a(entityTypeBarStyleHolderBuilder);
        CommandSenderBridge_5.log("Loaded player model " + hitboxImpl.getNamespacedID());
    }

    public void c(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        @Nullable ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("emotes");
        if (configurationSectionBridge == null) {
            return;
        }
        Set set = configurationSectionBridge.aX(false);
        for (String string : set) {
            @Nullable ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj(string);
            String string2 = configurationSectionBridge2.az("id", null);
            if (string2 == null) {
                CommandSenderBridge_5.warn("Missing id for emote '" + string + "'. File:" + pluginFileConfigurationHolder.nh());
                continue;
            }
            Opaque020 opaque020 = Opaque020.Dk();
            SoundCategoryBridge_2 soundCategoryBridge_2 = this.a(string, opaque020);
            if (soundCategoryBridge_2 != null) {
                if (!configurationSectionBridge2.C("enabled", true)) {
                    ((Hitbox)opaque020.aAW).aH(string);
                    continue;
                }
                soundCategoryBridge_2.c(configurationSectionBridge2.C("hide_equipment.helmet", false), configurationSectionBridge2.C("hide_equipment.mainhand", false), configurationSectionBridge2.C("hide_equipment.offhand", false));
                soundCategoryBridge_2.H(configurationSectionBridge2.C("can_player_move", true));
                soundCategoryBridge_2.K(configurationSectionBridge2.C("third_person_view", MaterialBarColorHolder.dN));
                soundCategoryBridge_2.L(configurationSectionBridge2.C("track_player_rotation.head", true));
                soundCategoryBridge_2.M(configurationSectionBridge2.C("track_player_rotation.body", true));
                soundCategoryBridge_2.a(configurationSectionBridge2.C("cancel_conditions.sneak", true), configurationSectionBridge2.C("cancel_conditions.take_damage", true), configurationSectionBridge2.C("cancel_conditions.deal_damage", true), configurationSectionBridge2.C("cancel_conditions.in_air", true));
                soundCategoryBridge_2.I(configurationSectionBridge2.C("on_stop.stop_sounds", true));
                soundCategoryBridge_2.J(configurationSectionBridge2.C("on_stop.skip_emote_end", false));
                soundCategoryBridge_2.a(configurationSectionBridge2.a("speed.movement", (Float)null), configurationSectionBridge2.a("speed.flying", (Float)null));
                if (!configurationSectionBridge2.fo("background_music.sound.name")) continue;
                soundCategoryBridge_2.a(configurationSectionBridge2.gV("background_music.sound.name"), SoundCategoryBridge.a(configurationSectionBridge2.gV("background_music.sound.category"), SoundCategory.MUSIC), configurationSectionBridge2.a("background_music.sound.volume", 1.0f), configurationSectionBridge2.a("background_music.sound.pitch", 1.0f), configurationSectionBridge2.a("background_music.repeat_interval_seconds", 0.0f));
                continue;
            }
            CommandSenderBridge_5.warn("Unknown emote '" + string + "'. File:" + pluginFileConfigurationHolder.nh());
        }
    }

    @Nullable
    public LivingEntityBuilder a(String string, Location location, boolean bl, boolean bl2, boolean bl3) {
        return this.a(string, null, location, bl, bl2, bl3);
    }

    @Nullable
    public LivingEntityBuilder a(String string, Location location, boolean bl) {
        return this.a(string, null, location, bl, false, false);
    }

    public LivingEntityBuilder a(String string, Location location, @Nullable String string2, List list, boolean bl, boolean bl2, boolean bl3, @Nullable Consumer consumer) {
        return this.a(string, location, string2, list, bl, bl2, bl3, true, false, consumer);
    }

    @Nullable
    public LivingEntityBuilder a(String string, Location location, @Nullable String string2, List list, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, @Nullable Consumer consumer) {
        if (location == null || location.getWorld() == null) {
            return null;
        }
        if (string2 == null && string.equals(lC)) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = new LivingEntityBuilder((EntityTypeBarStyleHolder)this.lJ.get(string), true);
        livingEntityBuilder.mB = bl;
        livingEntityBuilder.mC = bl2;
        livingEntityBuilder.mD = bl3;
        livingEntityBuilder.mE = bl4;
        livingEntityBuilder.mF = bl5;
        livingEntityBuilder.mG = true;
        if (bl2) {
            livingEntityBuilder.r(location);
            if (consumer != null) {
                consumer.accept(null);
            }
        } else {
            livingEntityBuilder.a(location, (java.util.function.Consumer)consumer);
        }
        for (Player player : list) {
            livingEntityBuilder.e(player, true);
        }
        if (string2 != null) {
            livingEntityBuilder.changePlayerSkin(string2);
        }
        this.a(livingEntityBuilder);
        livingEntityBuilder.ec().gk();
        livingEntityBuilder.eN();
        return livingEntityBuilder;
    }

    @Nullable
    public LivingEntityBuilder a(String string, @Nullable String string2, Location location, boolean bl, boolean bl2, boolean bl3) {
        if (location == null || location.getWorld() == null) {
            return null;
        }
        EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)this.lJ.get(string);
        if (entityTypeBarStyleHolder == null) {
            return null;
        }
        if (string2 == null && string.equals(lC)) {
            return null;
        }
        if (entityTypeBarStyleHolder.nO.pD && string2 == null) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = new LivingEntityBuilder(entityTypeBarStyleHolder, true);
        livingEntityBuilder.e(location.getWorld());
        livingEntityBuilder.mB = bl;
        livingEntityBuilder.mD = bl3;
        livingEntityBuilder.mC = bl2;
        if (bl2) {
            livingEntityBuilder.r(location);
        } else {
            livingEntityBuilder.q(location);
        }
        if (string2 != null) {
            livingEntityBuilder.changePlayerSkin(string2);
        }
        this.a(livingEntityBuilder);
        livingEntityBuilder.ec().gk();
        livingEntityBuilder.eN();
        return livingEntityBuilder;
    }

    @Nullable
    public LivingEntityBuilder a(String string, LivingEntity livingEntity, boolean bl) {
        return this.a(string, null, livingEntity, true, bl, false, true);
    }

    @Nullable
    public LivingEntityBuilder a(String string, @Nullable String string2, LivingEntity livingEntity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.a(string, string2, livingEntity, bl, bl2, bl3, false, bl4);
    }

    @Nullable
    public LivingEntityBuilder a(String string, @Nullable String string2, LivingEntity livingEntity, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.f((Entity)livingEntity)) {
            this.i((Entity)livingEntity);
        }
        LivingEntityBuilder livingEntityBuilder = new LivingEntityBuilder((EntityTypeBarStyleHolder)this.lJ.get(string), bl2);
        livingEntityBuilder.mB = bl;
        livingEntityBuilder.mD = bl3;
        livingEntityBuilder.mE = bl4;
        livingEntityBuilder.e(livingEntity.getWorld());
        livingEntityBuilder.b(livingEntity, bl5);
        this.a(string2, livingEntity, livingEntityBuilder);
        this.a(livingEntityBuilder);
        return livingEntityBuilder;
    }

    @Nullable
    public LivingEntityBuilder a(String string, @Nullable String string2, LivingEntity livingEntity, List list, boolean bl, boolean bl2) {
        if (this.f((Entity)livingEntity)) {
            this.i((Entity)livingEntity);
        }
        LivingEntityBuilder livingEntityBuilder = new LivingEntityBuilder((EntityTypeBarStyleHolder)this.lJ.get(string), bl2);
        livingEntityBuilder.mB = bl;
        livingEntityBuilder.mG = true;
        livingEntityBuilder.b(livingEntity, true);
        this.a(string2, livingEntity, livingEntityBuilder);
        for (Player player : list) {
            livingEntityBuilder.e(player, true);
        }
        this.a(livingEntityBuilder);
        return livingEntityBuilder;
    }

    private void a(@Nullable String string, LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder) {
        if (string == null) {
            String string2 = (String)livingEntity.getPersistentDataContainer().get(lB, PersistentDataType.STRING);
            if (string2 != null) {
                livingEntityBuilder.changePlayerSkin(string2);
            }
        } else {
            livingEntityBuilder.changePlayerSkin(string);
        }
    }

    @Nullable
    public LivingEntityBuilder a(LivingEntity livingEntity) {
        return this.a(livingEntity, true);
    }

    @Nullable
    public LivingEntityBuilder a(LivingEntity livingEntity, boolean bl) {
        if (LivingEntityRegistry.g((Entity)livingEntity)) {
            String string;
            EntityTypeBarStyleHolder entityTypeBarStyleHolder;
            if (bl) {
                this.i((Entity)livingEntity);
            }
            if ((entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)this.lJ.get(string = (String)livingEntity.getPersistentDataContainer().get(lA, PersistentDataType.STRING))) == null) {
                return null;
            }
            String string2 = (String)livingEntity.getPersistentDataContainer().get(lB, PersistentDataType.STRING);
            LivingEntityBuilder livingEntityBuilder = new LivingEntityBuilder(entityTypeBarStyleHolder, true);
            livingEntityBuilder.e(livingEntity.getWorld());
            entityTypeBarStyleHolder.a(livingEntity, null, false);
            livingEntityBuilder.b(livingEntity, true);
            this.a(livingEntityBuilder);
            if (string2 != null) {
                livingEntityBuilder.changePlayerSkin(string2);
            }
            for (PlayerBridge_7 playerBridge_7 : livingEntityBuilder.nk) {
                livingEntityBuilder.b(playerBridge_7);
            }
            livingEntityBuilder.ec().gl();
            return livingEntityBuilder;
        }
        return null;
    }

    public void b(LivingEntityBuilder livingEntityBuilder) {
        if (livingEntityBuilder != null) {
            PlayerBridge_7 playerBridge_7;
            int n2;
            livingEntityBuilder.ex();
            if (!livingEntityBuilder.mG) {
                livingEntityBuilder.e(livingEntityBuilder.cE());
            }
            int n3 = livingEntityBuilder.nk.size();
            for (n2 = 0; n2 < n3; ++n2) {
                playerBridge_7 = (PlayerBridge_7)livingEntityBuilder.nk.get(n2);
                playerBridge_7.nN = true;
                EntityHolder.tK().a(playerBridge_7.iW, livingEntityBuilder.eb());
            }
            n3 = livingEntityBuilder.nk.size();
            for (n2 = 0; n2 < n3; ++n2) {
                playerBridge_7 = (PlayerBridge_7)livingEntityBuilder.nk.get(n2);
                livingEntityBuilder.na.forEach((string, locationHolder_2) -> {
                    playerBridge_7.nN = false;
                    locationHolder_2.e(playerBridge_7);
                    if (locationHolder_2.qx.po == NormalEnum.MOUNT_PIVOT && locationHolder_2.gD() != null) {
                        locationHolder_2.gD().gM();
                    }
                });
            }
            livingEntityBuilder.ej();
            livingEntityBuilder.mN.gl();
        }
    }

    public static void a(Entity entity, String string) {
        entity.getPersistentDataContainer().set(lA, PersistentDataType.STRING, (Object)string);
    }

    public static void b(Entity entity, String string) {
        entity.getPersistentDataContainer().set(lB, PersistentDataType.STRING, (Object)string);
    }

    public void dj() {
        BukkitTaskBridge.b(bukkitRunnable -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                int n = livingEntityBuilder.getLocation().getWorld().getViewDistance() * 16;
                if (livingEntityBuilder.mK.getWorld() != livingEntityBuilder.getLocation().getWorld() || livingEntityBuilder.mK.distance(livingEntityBuilder.getLocation()) >= (double)(n - 1)) {
                    this.b(livingEntityBuilder);
                }
                livingEntityBuilder.mK = livingEntityBuilder.getLocation();
                List list = livingEntityBuilder.ea();
                for (int j = 0; j < list.size(); ++j) {
                    PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(j);
                    playerBridge_7.fo();
                }
            }
        }, 0L, 5L);
        BukkitTaskBridge.b(bukkitRunnable -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                livingEntityBuilder.dY();
            }
        }, 0L, 200L);
        BukkitTaskBridge.b(bukkitRunnable -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                livingEntityBuilder.dZ();
                for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : livingEntityBuilder.mZ) {
                    if (!livingEntityArmorStandHolder.gG()) continue;
                    livingEntityArmorStandHolder.gN();
                    livingEntityArmorStandHolder.gk();
                }
            }
        }, 0L, 20L);
        BukkitTaskBridge.a((T bukkitRunnable) -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : livingEntityBuilder.mZ) {
                    if (!livingEntityArmorStandHolder.gG()) continue;
                    livingEntityArmorStandHolder.bV();
                }
                livingEntityBuilder.ej();
                livingEntityBuilder.dX();
                livingEntityBuilder.eP();
            }
        }, 0L, 20L);
        BukkitTaskBridge.a(() -> {
            ArrayList<LivingEntityBuilder> arrayList = new ArrayList<LivingEntityBuilder>();
            for (int i = 0; i < this.lK.size(); ++i) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                if (!livingEntityBuilder.ni.fF() || livingEntityBuilder.mN.gu() || livingEntityBuilder.eg().isValid() && !livingEntityBuilder.eg().isDead()) continue;
                arrayList.add(livingEntityBuilder);
            }
            for (LivingEntityBuilder livingEntityBuilder : arrayList) {
                RecordOfValue_20 recordOfValue_20 = PlayerBridge_16.g(livingEntityBuilder.eg());
                if (recordOfValue_20 != null) {
                    recordOfValue_20.remove();
                }
                this.i((Entity)livingEntityBuilder.eg());
            }
        }, 10L);
        this.iT.scheduleAtFixedRate(() -> {
            try {
                for (int i = 0; i < this.lK.size(); ++i) {
                    Object object;
                    Object object2;
                    LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                    if (livingEntityBuilder.removed || livingEntityBuilder.ea().isEmpty() || livingEntityBuilder.mF && lo % 10000 != 0) continue;
                    if (!livingEntityBuilder.fj()) {
                        if (!livingEntityBuilder.mL) {
                            object2 = livingEntityBuilder.eW();
                            object = livingEntityBuilder.eg();
                            if (object instanceof Player) {
                                Player player = (Player)object;
                                if (PlayerJoinListener_9.bN.j(player)) {
                                    object2 = livingEntityBuilder.fb();
                                }
                                this.a(livingEntityBuilder, player);
                                if (livingEntityBuilder.eu()) {
                                    if (livingEntityBuilder.fi() != null && player.isSneaking()) {
                                        object2 = livingEntityBuilder.fi();
                                    }
                                } else if (livingEntityBuilder.fh() != null && player.isSneaking()) {
                                    object2 = livingEntityBuilder.fh();
                                }
                            }
                            if (object2 != null) {
                                if (livingEntityBuilder.eQ() == livingEntityBuilder.mV) {
                                    livingEntityBuilder.b((SoundCategoryBridge_2)object2);
                                } else if (!(!livingEntityBuilder.eD() || Main.PK && CitizensHook.isNPC(livingEntityBuilder.eg()))) {
                                    livingEntityBuilder.a((SoundCategoryBridge_2)object2);
                                } else {
                                    livingEntityBuilder.b((SoundCategoryBridge_2)object2);
                                }
                            }
                        }
                    } else {
                        LivingEntity livingEntity = livingEntityBuilder.eg();
                        if (livingEntity instanceof Player) {
                            object2 = (Player)livingEntity;
                            this.a(livingEntityBuilder, (Player)object2);
                        }
                    }
                    livingEntityBuilder.ec().gk();
                    livingEntityBuilder.eN();
                    livingEntityBuilder.eU();
                    object2 = livingEntityBuilder.ea();
                    for (int j = 0; j < object2.size(); ++j) {
                        object = (PlayerBridge_7)object2.get(j);
                        ((PlayerBridge_7)object).fp();
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
                    LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                    if (livingEntityBuilder.removed || livingEntityBuilder.ea().size() == 0) continue;
                    List list = livingEntityBuilder.ea();
                    for (int j = 0; j < list.size(); ++j) {
                        PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(j);
                        if (playerBridge_7.nL > livingEntityBuilder.nz) {
                            livingEntityBuilder.c(playerBridge_7);
                            continue;
                        }
                        livingEntityBuilder.a(playerBridge_7);
                    }
                }
                ++lo;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, 0L, TimeUnit.MILLISECONDS.toNanos(200L), TimeUnit.NANOSECONDS);
        BukkitTaskBridge.a(() -> {
            for (int i = 0; i < this.lK.size(); ++i) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i);
                if (!livingEntityBuilder.eE()) continue;
                for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : livingEntityBuilder.mZ) {
                    if (!livingEntityArmorStandHolder.gG()) continue;
                    livingEntityArmorStandHolder.bV();
                }
            }
        }, 1L);
    }

    private void a(LivingEntityBuilder livingEntityBuilder, Player player) {
        RecordOfValue_3 recordOfValue_3;
        if (livingEntityBuilder.eu() && (recordOfValue_3 = (RecordOfValue_3)PluginDisableListener.zQ.get(player)) != null) {
            float f;
            float f2 = f = livingEntityBuilder.getLocation().getYaw();
            float f3 = 0.2f;
            if (recordOfValue_3.uI()) {
                f2 -= 45.0f;
                f3 = 0.8f;
            } else if (recordOfValue_3.uJ()) {
                f2 += 45.0f;
                f3 = 0.8f;
            } else if (recordOfValue_3.uG() || recordOfValue_3.uH()) {
                f2 = f;
            } else {
                return;
            }
            float f4 = EntityHolder.tK().M((Entity)livingEntityBuilder.eg());
            float f5 = f4 + (f2 - f4);
            EntityHolder.tK().c((Entity)livingEntityBuilder.eg(), LocationBridge_2.e(f4, f5, f3));
        }
    }

    public void Q(Player player) {
        ArrayList arrayList = (ArrayList)this.lN.get(player.getWorld());
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)arrayList.get(i2);
            if (livingEntityBuilder.mG) continue;
            livingEntityBuilder.e(player, true);
        }
    }

    public void a(Player player, LivingEntityBuilder livingEntityBuilder) {
        livingEntityBuilder.removeViewer(player);
    }

    public void R(Player player) {
        for (int i2 = 0; i2 < this.lK.size(); ++i2) {
            LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i2);
            livingEntityBuilder.removeViewer(player);
        }
    }

    public void dk() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i2 = 0; i2 < this.lK.size(); ++i2) {
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)this.lK.get(i2);
                livingEntityBuilder.u(false);
                this.a(player, livingEntityBuilder);
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
                LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)arrayList.get(i2);
                this.d(livingEntityBuilder);
            }
        }
    }

    public void S(Player player) {
        ArrayList arrayList = (ArrayList)this.lN.get(player.getWorld());
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)arrayList.get(i2);
            if (!livingEntityBuilder.mG) {
                PlayerBridge_7 playerBridge_7 = livingEntityBuilder.aa(player);
                livingEntityBuilder.b(playerBridge_7);
            } else {
                livingEntityBuilder.ac(player);
            }
            livingEntityBuilder.ab(player);
        }
    }

    public void a(World world, Player player) {
        ArrayList arrayList = (ArrayList)this.lN.get(world);
        if (arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            LivingEntityBuilder livingEntityBuilder = (LivingEntityBuilder)arrayList.get(i2);
            livingEntityBuilder.ad(player);
            if (livingEntityBuilder.mG) continue;
            livingEntityBuilder.removeViewer(player);
        }
    }

    public boolean f(Entity entity) {
        return this.lL.containsKey(entity.getUniqueId());
    }

    public boolean d(UUID uUID) {
        return this.lL.containsKey(uUID);
    }

    @Nullable
    public LivingEntityBuilder n(Location location) {
        ArrayList arrayList = (ArrayList)this.lN.get(location.getWorld());
        if (arrayList == null) {
            return null;
        }
        double d = 200.0;
        LivingEntityBuilder livingEntityBuilder = null;
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            LivingEntityBuilder livingEntityBuilder2 = (LivingEntityBuilder)arrayList.get(i2);
            double d2 = livingEntityBuilder2.getLocation().distance(location);
            if (d2 > d) continue;
            d = d2;
            livingEntityBuilder = livingEntityBuilder2;
        }
        return livingEntityBuilder;
    }

    public static boolean g(Entity entity) {
        return entity.getPersistentDataContainer().has(lA, PersistentDataType.STRING);
    }

    public EntityTypeBarStyleHolder am(String string) {
        return (EntityTypeBarStyleHolder)this.lJ.get(string);
    }

    @Nullable
    public LivingEntityBuilder e(UUID uUID) {
        return (LivingEntityBuilder)this.lL.get(uUID);
    }

    @Nullable
    public LivingEntityBuilder h(Entity entity) {
        if (entity != null) {
            return (LivingEntityBuilder)this.lL.get(entity.getUniqueId());
        }
        return null;
    }

    public LivingEntityBuilder T(Player player) {
        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5.0, 0.1, entity -> entity.getEntityId() != player.getEntityId() && this.lL.containsKey(entity.getUniqueId()));
        if (rayTraceResult != null && rayTraceResult.getHitEntity() != null) {
            Entity entity2 = rayTraceResult.getHitEntity();
            return (LivingEntityBuilder)this.lL.get(entity2.getUniqueId());
        }
        return null;
    }

    @Nullable
    public LivingEntityBuilder j(int n2) {
        return (LivingEntityBuilder)this.lM.get(n2);
    }

    @Nullable
    public LivingEntityBuilder k(int n2) {
        return (LivingEntityBuilder)this.lO.get(n2);
    }

    public ImmutableList dl() {
        return ImmutableList.copyOf(this.lK);
    }

    public void c(LivingEntityBuilder livingEntityBuilder) {
        livingEntityBuilder.na.forEach((string, locationHolder_2) -> this.lO.remove(locationHolder_2.qw.Yb));
    }

    public void i(Entity entity) {
        if (entity == null) {
            return;
        }
        LivingEntityBuilder livingEntityBuilder = this.e(entity.getUniqueId());
        if (livingEntityBuilder != null) {
            livingEntityBuilder.eo();
            this.lK.remove(livingEntityBuilder);
            ArrayList arrayList = (ArrayList)this.lN.get(livingEntityBuilder.cE());
            if (arrayList != null) {
                arrayList.remove(livingEntityBuilder);
            }
        }
        new HashMap<LivingEntity, LivingEntityArmorStandHolder>(this.lS).forEach((livingEntity, livingEntityArmorStandHolder) -> {
            if (livingEntityArmorStandHolder.gH() == livingEntityBuilder) {
                this.removePassenger((LivingEntity)livingEntity);
            }
        });
        this.lL.remove(entity.getUniqueId());
        this.lM.remove(entity.getEntityId());
    }

    public void d(LivingEntityBuilder livingEntityBuilder) {
        if (livingEntityBuilder != null) {
            if (livingEntityBuilder.eg() != null) {
                this.i((Entity)livingEntityBuilder.eg());
                return;
            }
            livingEntityBuilder.eo();
            this.lK.remove(livingEntityBuilder);
            ArrayList arrayList = (ArrayList)this.lN.get(livingEntityBuilder.cE());
            if (arrayList != null) {
                arrayList.remove(livingEntityBuilder);
            }
        }
        new HashMap<LivingEntity, LivingEntityArmorStandHolder>(this.lS).forEach((livingEntity, livingEntityArmorStandHolder) -> {
            if (livingEntityArmorStandHolder.gH() == livingEntityBuilder) {
                this.removePassenger((LivingEntity)livingEntity);
            }
        });
    }

    public void a(LivingEntityBuilder livingEntityBuilder, boolean bl, boolean bl2) {
        PlayerBukkitTaskHolder playerBukkitTaskHolder;
        if (livingEntityBuilder.eg() instanceof Player && (playerBukkitTaskHolder = (PlayerBukkitTaskHolder)this.lT.get(livingEntityBuilder.eg().getUniqueId())) != null) {
            playerBukkitTaskHolder.cZ();
            this.lT.remove(livingEntityBuilder.eg().getUniqueId());
        }
        livingEntityBuilder.c(bl, bl2);
        this.d(livingEntityBuilder);
    }

    public void a(PlayerBukkitTaskHolder playerBukkitTaskHolder, boolean bl, boolean bl2) {
        LivingEntityBuilder livingEntityBuilder = playerBukkitTaskHolder.renderer;
        playerBukkitTaskHolder.cZ();
        this.lT.remove(livingEntityBuilder.eg().getUniqueId());
        livingEntityBuilder.c(bl, bl2);
        this.d(livingEntityBuilder);
    }

    public void e(LivingEntityBuilder livingEntityBuilder) {
        this.d(livingEntityBuilder);
        livingEntityBuilder.eL();
    }

    public boolean a(LivingEntity livingEntity, LivingEntityArmorStandHolder livingEntityArmorStandHolder) {
        if (this.b(livingEntity)) {
            return false;
        }
        livingEntityArmorStandHolder.d(livingEntity);
        this.lS.put(livingEntity, livingEntityArmorStandHolder);
        return true;
    }

    public boolean a(LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder) {
        if (this.b(livingEntity)) {
            return false;
        }
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = livingEntityBuilder.eF();
        if (livingEntityArmorStandHolder == null) {
            return false;
        }
        livingEntityArmorStandHolder.d(livingEntity);
        this.lS.put(livingEntity, livingEntityArmorStandHolder);
        return true;
    }

    public void removePassenger(LivingEntity livingEntity) {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = (LivingEntityArmorStandHolder)this.lS.get(livingEntity);
        if (livingEntityArmorStandHolder == null) {
            return;
        }
        livingEntityArmorStandHolder.removePassenger();
        this.lS.remove(livingEntity);
    }

    public void a(LivingEntityArmorStandHolder livingEntityArmorStandHolder) {
        if (livingEntityArmorStandHolder == null || livingEntityArmorStandHolder.qR == null) {
            return;
        }
        this.lS.remove(livingEntityArmorStandHolder.qR);
        livingEntityArmorStandHolder.removePassenger();
    }

    public void f(LivingEntityBuilder livingEntityBuilder) {
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : livingEntityBuilder.mZ) {
            this.a(livingEntityArmorStandHolder);
        }
    }

    public boolean b(LivingEntity livingEntity) {
        return this.lS.containsKey(livingEntity);
    }

    public boolean b(LivingEntity livingEntity, LivingEntityBuilder livingEntityBuilder) {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = (LivingEntityArmorStandHolder)this.lS.get(livingEntity);
        if (livingEntityArmorStandHolder == null) {
            return false;
        }
        return livingEntityArmorStandHolder.qQ.qv == livingEntityBuilder;
    }

    @Nullable
    public LivingEntityArmorStandHolder c(LivingEntity livingEntity) {
        return (LivingEntityArmorStandHolder)this.lS.get(livingEntity);
    }

    @Nullable
    public LivingEntityBuilder a(@Nullable LivingEntity livingEntity, String string, Location location, String string2, @Nullable String string3) {
        LivingEntityBuilder livingEntityBuilder = new LivingEntityBuilder((EntityTypeBarStyleHolder)this.lJ.get(string2), false);
        livingEntityBuilder.v(true);
        if (string3 != null && livingEntityBuilder.ar(string3) == null) {
            return null;
        }
        livingEntityBuilder.e(location.getWorld());
        livingEntityBuilder.ao(string);
        livingEntityBuilder.c((SoundCategoryBridge_2)null);
        livingEntityBuilder.d(null);
        livingEntityBuilder.g(null);
        livingEntityBuilder.f(null);
        if (livingEntity == null) {
            livingEntityBuilder.q(location);
            livingEntityBuilder.ej();
            this.a(livingEntityBuilder);
        } else {
            livingEntityBuilder.b(livingEntity, false);
            this.a(livingEntityBuilder);
        }
        return livingEntityBuilder;
    }

    @Nullable
    public LivingEntityBuilder U(Player player) {
        PlayerBukkitTaskHolder playerBukkitTaskHolder = this.V(player);
        if (playerBukkitTaskHolder == null) {
            return null;
        }
        return playerBukkitTaskHolder.renderer;
    }

    @Nullable
    public PlayerBukkitTaskHolder V(Player player) {
        return (PlayerBukkitTaskHolder)this.lT.get(player.getUniqueId());
    }

    public PlayEnum b(Player player, @NotNull String string) {
        LivingEntityBuilder livingEntityBuilder;
        if (!ListenerBridge.b((Event)new PlayerEmotePlayEvent(player, string))) {
            return PlayEnum.CANCELLED;
        }
        Opaque020 opaque020 = Opaque020.Dk();
        SoundCategoryBridge_2 soundCategoryBridge_2 = this.a(string, opaque020);
        if (soundCategoryBridge_2 == null || !opaque020.Dl()) {
            return PlayEnum.UNKNOWN_EMOTE;
        }
        if (!player.isOnGround() && soundCategoryBridge_2.oT) {
            return PlayEnum.CANCELLED;
        }
        PlayerBukkitTaskHolder playerBukkitTaskHolder = this.V(player);
        if (playerBukkitTaskHolder != null) {
            this.X(player);
        }
        if ((livingEntityBuilder = this.a((LivingEntity)player, player.getName(), player.getLocation(), ((Hitbox)opaque020.aAW).getNamespacedID(), string)) == null) {
            return PlayEnum.UNKNOWN_EMOTE;
        }
        PlayerBukkitTaskHolder playerBukkitTaskHolder2 = new PlayerBukkitTaskHolder(player, livingEntityBuilder, true);
        this.lT.put(player.getUniqueId(), playerBukkitTaskHolder2);
        BukkitTaskBridge.a(() -> {
            try {
                if (playerBukkitTaskHolder.lj.get()) {
                    return;
                }
                playerBukkitTaskHolder2.cY();
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Error starting emote.", exception);
            }
        }, 5);
        livingEntityBuilder.a(string, 0, false, () -> BukkitTaskBridge.i(() -> this.b(playerBukkitTaskHolder2)));
        return PlayEnum.PLAY;
    }

    public boolean W(Player player) {
        PlayerBukkitTaskHolder playerBukkitTaskHolder = this.V(player);
        if (playerBukkitTaskHolder != null) {
            this.X(player);
            LivingEntityRegistry.db().a(playerBukkitTaskHolder.renderer, false, false);
            this.lT.remove(player.getUniqueId());
            return true;
        }
        return false;
    }

    public boolean c(Player player, String string) {
        LivingEntityBuilder livingEntityBuilder;
        PlayerBukkitTaskHolder playerBukkitTaskHolder = this.V(player);
        if (playerBukkitTaskHolder != null) {
            this.X(player);
            LivingEntityRegistry.db().a(playerBukkitTaskHolder.renderer, false, false);
        }
        if ((livingEntityBuilder = LivingEntityRegistry.db().a(string, null, (LivingEntity)player, false, true, false, false)) == null) {
            return false;
        }
        livingEntityBuilder.w(true);
        PlayerBukkitTaskHolder playerBukkitTaskHolder2 = new PlayerBukkitTaskHolder(player, livingEntityBuilder, false);
        this.lT.put(player.getUniqueId(), playerBukkitTaskHolder2);
        playerBukkitTaskHolder2.cY();
        return true;
    }

    @Nullable
    private SoundCategoryBridge_2 a(String string, Opaque020 opaque020) {
        SoundCategoryBridge_2 soundCategoryBridge_2 = null;
        for (Map.Entry entry : this.lJ.entrySet()) {
            EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)entry.getValue();
            if (!entityTypeBarStyleHolder.nO.pD) continue;
            soundCategoryBridge_2 = (SoundCategoryBridge_2)entityTypeBarStyleHolder.nO.pB.get(string);
            opaque020.H(entityTypeBarStyleHolder.nO);
            if (soundCategoryBridge_2 == null) continue;
            break;
        }
        return soundCategoryBridge_2;
    }

    public static BoolStringData a(LivingEntityBuilder livingEntityBuilder, String string) {
        EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().dq().get(string);
        if (entityTypeBarStyleHolder == null) {
            return new BoolStringData(false, false, null);
        }
        String string2 = entityTypeBarStyleHolder.nO.getNamespacedID();
        if (string2.equals(livingEntityBuilder.es())) {
            livingEntityBuilder.a(string, 0, false, () -> LivingEntityRegistry.g(livingEntityBuilder));
            return new BoolStringData(true, false, null);
        }
        LivingEntityBuilder livingEntityBuilder2 = LivingEntityRegistry.a(string2, livingEntityBuilder.ek(), livingEntityBuilder.eg());
        livingEntityBuilder2.a(string, 0, false, () -> LivingEntityRegistry.g(livingEntityBuilder2));
        return new BoolStringData(true, true, string2);
    }

    private static void g(LivingEntityBuilder livingEntityBuilder) {
        if (!LivingEntityRegistry.h(livingEntityBuilder)) {
            BukkitTaskBridge.c(() -> {
                if (!LivingEntityRegistry.h(livingEntityBuilder)) {
                    String string = livingEntityBuilder.ek();
                    LivingEntity livingEntity = livingEntityBuilder.eg();
                    LivingEntityBuilder livingEntityBuilder2 = LivingEntityRegistry.a(lC, string, livingEntity);
                    livingEntityBuilder2.ap("idle");
                }
            }, 1L);
        } else {
            livingEntityBuilder.ap("idle");
        }
    }

    private static LivingEntityBuilder a(String string, @Nullable String string2, LivingEntity livingEntity) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(string, livingEntity, true);
        if (string2 != null) {
            livingEntityBuilder.changePlayerSkin(string2);
        }
        livingEntityBuilder.dV();
        livingEntityBuilder.dX();
        return livingEntityBuilder;
    }

    public EntityTypeBarStyleHolder dm() {
        return (EntityTypeBarStyleHolder)this.lJ.get(lC);
    }

    public List dn() {
        return new ArrayList(this.lP);
    }

    public List t(boolean bl) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry entry : LivingEntityRegistry.db().lJ.entrySet()) {
            if (!bl && ((EntityTypeBarStyleHolder)entry.getValue()).nO.pD) continue;
            arrayList.add((String)entry.getKey());
        }
        return arrayList;
    }

    public void do() {
        ArrayList arrayList = new ArrayList();
        EntityTypeBarStyleHolder entityTypeBarStyleHolder = LivingEntityRegistry.db().dm();
        if (entityTypeBarStyleHolder != null) {
            arrayList.addAll(entityTypeBarStyleHolder.nO.getAnimationsNames());
            arrayList.remove("idle");
        }
        for (Map.Entry entry : this.lJ.entrySet()) {
            EntityTypeBarStyleHolder entityTypeBarStyleHolder2 = (EntityTypeBarStyleHolder)entry.getValue();
            if (!entityTypeBarStyleHolder2.nO.pD) continue;
            entityTypeBarStyleHolder2.nO.pB.forEach((string, soundCategoryBridge_2) -> arrayList.add(string));
            this.lR.add(entityTypeBarStyleHolder2.nO.getNamespacedID());
            entityTypeBarStyleHolder2.nO.pB.forEach((string, soundCategoryBridge_2) -> this.lQ.put(string, entityTypeBarStyleHolder2));
        }
        this.lP = arrayList;
    }

    public List dp() {
        return this.lR;
    }

    public HashMap dq() {
        return this.lQ;
    }

    public static boolean h(LivingEntityBuilder livingEntityBuilder) {
        return livingEntityBuilder.es().equals(lC);
    }

    public boolean X(Player player) {
        PlayerBukkitTaskHolder playerBukkitTaskHolder = this.V(player);
        if (playerBukkitTaskHolder != null) {
            ListenerBridge.b((Event)new PlayerEmoteEndEvent(player, playerBukkitTaskHolder.renderer.mN.aM(null), PlayerEmoteEndEvent$Cause.STOP));
            SoundCategoryBridge_2 soundCategoryBridge_2 = playerBukkitTaskHolder.renderer.mN.qb;
            if (soundCategoryBridge_2 != null && soundCategoryBridge_2.oU) {
                for (List list : soundCategoryBridge_2.oH) {
                    for (LocationBridge_10 locationBridge_10 : list) {
                        locationBridge_10.u(player.getLocation());
                    }
                }
            }
            this.a(playerBukkitTaskHolder, false, false);
            return true;
        }
        return false;
    }

    public void Y(Player player) {
        PlayerBukkitTaskHolder playerBukkitTaskHolder = this.V(player);
        if (playerBukkitTaskHolder != null) {
            this.a(playerBukkitTaskHolder);
        }
    }

    public void a(PlayerBukkitTaskHolder playerBukkitTaskHolder) {
        Player player = playerBukkitTaskHolder.iW;
        SoundCategoryBridge_2 soundCategoryBridge_2 = playerBukkitTaskHolder.renderer.mN.qb;
        ListenerBridge.b((Event)new PlayerEmoteEndEvent(player, playerBukkitTaskHolder.renderer.mN.aM(null), PlayerEmoteEndEvent$Cause.STOP));
        if (soundCategoryBridge_2 != null) {
            if (soundCategoryBridge_2.oU) {
                for (List list : soundCategoryBridge_2.oH) {
                    for (LocationBridge_10 locationBridge_10 : list) {
                        locationBridge_10.u(player.getLocation());
                    }
                }
            }
            if (soundCategoryBridge_2.oV) {
                this.a(playerBukkitTaskHolder, false, false);
            }
        }
        if (soundCategoryBridge_2 == null || soundCategoryBridge_2.oQ) {
            playerBukkitTaskHolder.renderer.ec().e(false, false);
        }
    }

    private void b(PlayerBukkitTaskHolder playerBukkitTaskHolder) {
        if (playerBukkitTaskHolder.renderer.removed) {
            return;
        }
        ListenerBridge.b((Event)new PlayerEmoteEndEvent(playerBukkitTaskHolder.iW, playerBukkitTaskHolder.renderer.mN.aM(null), PlayerEmoteEndEvent$Cause.FINISHED));
        this.a(playerBukkitTaskHolder.renderer, true, false);
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
            CommandSenderBridge_5.error("Failed to load Steve skin image.", iOException);
            return null;
        }
    }

    static {
        lY = null;
    }
}
