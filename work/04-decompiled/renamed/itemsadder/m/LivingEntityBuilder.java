package itemsadder.m;

import com.google.gson.JsonObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Consumer;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.Hitbox;
import itemsadder.m.InstanceRegistry_10;
import itemsadder.m.InteractEnum;
import itemsadder.m.ItemStackBridge_8;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityBridge;
import itemsadder.m.LivingEntityLocationHolder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LivingEntityWrapper;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.LocationHolder_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.NormalEnum;
import itemsadder.m.Opaque112;
import itemsadder.m.OtherEnum;
import itemsadder.m.PacketContainerHelper_2;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.PluginDisableListener;
import itemsadder.m.RecordOfString_5;
import itemsadder.m.RecordOfValue_3;
import itemsadder.m.SoundCategoryBridge_2;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class LivingEntityBuilder {
    public final EntityTypeBarStyleHolder my;
    public long mz;
    public boolean mA;
    public boolean mB = true;
    public boolean mC;
    public boolean mD;
    public boolean mE;
    public boolean mF;
    public boolean mG;
    public boolean mH;
    public CustomEntity mI;
    Object mJ;
    public Location mK;
    boolean removed;
    boolean mL;
    int mM;
    Opaque112 mN;
    @Nullable
    SoundCategoryBridge_2 mO;
    SoundCategoryBridge_2 mP;
    @Nullable
    SoundCategoryBridge_2 mQ;
    @Nullable
    SoundCategoryBridge_2 mR;
    @Nullable
    SoundCategoryBridge_2 mS;
    @Nullable
    SoundCategoryBridge_2 mT;
    @Nullable
    SoundCategoryBridge_2 mU;
    @Nullable
    SoundCategoryBridge_2 mV;
    @Nullable
    SoundCategoryBridge_2 mW;
    @Nullable
    SoundCategoryBridge_2 mX;
    @Nullable
    SoundCategoryBridge_2 mY;
    public List mZ = new ArrayList();
    public LinkedHashMap na = new LinkedHashMap();
    public LinkedHashMap nb = new LinkedHashMap();
    private int[] nc = new int[0];
    public LocationHolder_2 nd;
    public LocationHolder_2 ne;
    public LocationHolder_2 nf;
    boolean ng;
    boolean nh = true;
    public LivingEntityLocationHolder ni;
    @Nullable
    public PacketContainerHelper_2 nj;
    final List nk = Collections.synchronizedList(new ArrayList());
    final Map nl = Collections.synchronizedMap(new HashMap());
    boolean nm;
    float nn;
    float no;
    float np;
    float nq;
    float nr;
    Location ns;
    boolean nt;
    boolean nu;
    @Nullable
    String playerSkin;
    public boolean nv;
    public boolean nw;
    private boolean nx;
    private boolean ny;
    double nz;
    @Nullable
    private LivingEntityWrapper nA;
    public double nB = 0.0;
    public double nC = 0.0;
    public double nD = 0.0;
    Location nE;
    double nF;

    public LivingEntityBuilder(EntityTypeBarStyleHolder entityTypeBarStyleHolder, boolean bl) {
        this.my = entityTypeBarStyleHolder;
        this.mO = entityTypeBarStyleHolder.nO.pB.values().stream().findFirst().orElse(null);
        this.mE = true;
        this.mP = entityTypeBarStyleHolder.nO.a(OtherEnum.IDLE);
        this.mW = entityTypeBarStyleHolder.nO.a(OtherEnum.IDLE_ANGRY);
        this.mQ = entityTypeBarStyleHolder.nO.a(OtherEnum.WALK);
        this.mU = entityTypeBarStyleHolder.nO.a(OtherEnum.WALK_ANGRY);
        this.mV = entityTypeBarStyleHolder.nO.a(OtherEnum.JUMP);
        this.mR = entityTypeBarStyleHolder.nO.a(OtherEnum.ATTACK);
        this.mS = entityTypeBarStyleHolder.nO.a(OtherEnum.DEATH);
        this.mT = entityTypeBarStyleHolder.nO.a(OtherEnum.FLY);
        this.mX = entityTypeBarStyleHolder.nO.a(OtherEnum.SNEAK);
        this.mY = entityTypeBarStyleHolder.nO.a(OtherEnum.SNEAK_WALK);
        for (Map.Entry entry : entityTypeBarStyleHolder.nO.pC.entrySet()) {
            if (((InstanceRegistry_10)entry.getValue()).po != NormalEnum.HEAD) continue;
            this.mH = true;
            break;
        }
        if (this.my.nO.pD) {
            this.playerSkin = "ewogICJ0aW1lc3RhbXAiIDogMTY2NjMwMjkxNzkzOCwKICAicHJvZmlsZUlkIiA6ICJjOWRlZTM4MDUzYjg0YzI5YjZlZjA5YjJlMDM5OTc0ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTQVJfRGVjZW1iZXI1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMxZjQ3N2ViMWE3YmVlZTYzMWMyY2E2NGQwNmY4ZjY4ZmE5M2EzMzg2ZDA0NDUyYWIyN2Y0M2FjZGYxYjYwY2IiCiAgICB9CiAgfQp9";
        }
        this.nh = bl;
        this.eP();
    }

    LivingEntity q(Location location) {
        return this.a(location, null);
    }

    LivingEntity a(Location location, @Nullable java.util.function.Consumer consumer) {
        Location location2 = location.clone();
        LivingEntity livingEntity = (LivingEntity)location2.getWorld().spawn(location2, this.my.nS.getEntityClass(), entity -> {
            Zombie zombie;
            if (entity instanceof Zombie) {
                zombie = (Zombie)entity;
                zombie.setAdult();
            }
            if (entity instanceof Slime) {
                zombie = (Slime)entity;
                zombie.setSize(1);
            }
            EntityHolder.tK().c((Entity)entity, location.getYaw());
            this.my.a((LivingEntity)entity, this.playerSkin, true);
            if (consumer != null) {
                consumer.accept((LivingEntity)entity);
            }
        });
        Entity entity2 = livingEntity.getVehicle();
        if (entity2 instanceof LivingEntity) {
            LivingEntity livingEntity2 = (LivingEntity)entity2;
            livingEntity2.remove();
        }
        this.ni = new LivingEntityLocationHolder(livingEntity);
        this.ex();
        return this.a(livingEntity, true, true);
    }

    LivingEntity b(LivingEntity livingEntity, boolean bl) {
        return this.a(livingEntity, bl, false);
    }

    LivingEntity a(LivingEntity livingEntity, boolean bl, boolean bl2) {
        LivingEntityBuilder livingEntityBuilder = this.a(livingEntity, null, bl, bl2);
        return livingEntityBuilder.eg();
    }

    LivingEntityBuilder r(@Nullable Location location) {
        return this.a(null, location, false, false);
    }

    LivingEntityBuilder a(@Nullable LivingEntity livingEntity, @Nullable Location location, boolean bl, boolean bl2) {
        this.ng = bl;
        this.ni = livingEntity != null ? new LivingEntityLocationHolder(livingEntity) : new LivingEntityLocationHolder(location);
        if (livingEntity instanceof Player) {
            this.nw = Bukkit.getOnlinePlayers().contains(livingEntity);
        }
        if (this.nw) {
            this.nh = false;
            this.ng = false;
        }
        if (this.ni.oy != null) {
            this.ni.oy.setMetadata("ItemsAdderEntity", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)this.my.nO.getNamespacedID()));
        }
        if (this.ni.fF()) {
            this.mJ = PacketListenerRegistry.uN().aJ(this.ni.oy.getEntityId());
        }
        this.mK = this.ns = this.ni.fE();
        if (this.nh) {
            this.ej();
        }
        this.ex();
        if (this.my.od) {
            this.nj = PacketContainerHelper_2.Z(this.ns);
            if (!(this.ni.oy instanceof Player)) {
                this.eO();
            }
        }
        this.mN = new Opaque112(this, (SoundCategoryBridge_2)this.my.nO.pB.get(this.mO.oz));
        if (!this.nw && bl) {
            if (bl2) {
                this.my.a(this.ni.oy, this.playerSkin, false);
            }
            this.dX();
            LivingEntity livingEntity2 = this.ni.oy;
            if (livingEntity2 instanceof Mob) {
                Mob mob = (Mob)livingEntity2;
                EntityHolder.tK().a(mob, true);
                this.dV();
                this.my.oo.a(mob);
            }
            this.ni.oy.setFireTicks(0);
            this.ni.oy.setVisualFire(false);
        }
        this.mz = System.currentTimeMillis();
        return this;
    }

    public void dV() {
        Hitbox hitbox = this.et();
        this.nA = LivingEntityBridge.a(this.ni.oy, hitbox.pH);
    }

    public void dW() {
        if (this.nA != null) {
            this.nA.j(this.ni.oy);
        }
    }

    public void dX() {
        if (this.nw) {
            return;
        }
        if (!this.ni.fF()) {
            return;
        }
        if (this.my.nO.gi()) {
            EntityHolder.tK().a((Entity)this.ni.oy, this.my.nO.pF.aBp, this.my.nO.pE.aBq + this.my.nO.pF.aBq);
        }
    }

    public void dY() {
        if (!this.ni.fF()) {
            return;
        }
        EntityEquipment entityEquipment = this.ni.oy.getEquipment();
        if (entityEquipment == null) {
            return;
        }
        if (this.ne != null && this.mN.qb != null && !this.mN.qb.oK) {
            this.ne.a(entityEquipment.getItemInMainHand(), EquipmentSlot.HAND);
        }
        if (this.nd != null && this.mN.qb != null && !this.mN.qb.oL) {
            this.nd.a(entityEquipment.getItemInOffHand(), EquipmentSlot.OFF_HAND);
        }
        if (this.nf != null && this.mN.qb != null && !this.mN.qb.oJ) {
            this.nf.a(entityEquipment.getHelmet(), EquipmentSlot.HEAD);
        }
    }

    public void dZ() {
        if (this.my.nO.pD) {
            return;
        }
        if (!this.ni.fF()) {
            return;
        }
        try {
            this.na.forEach((string, locationHolder_2) -> locationHolder_2.qw.b(this.nk, this.ni.oy.getFireTicks() > 0));
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
    }

    public List ea() {
        return this.nk;
    }

    public boolean Z(Player player) {
        return this.nl.containsKey(player);
    }

    public void e(World world) {
        this.a(world, false);
    }

    public void a(World world, boolean bl) {
        for (Player player : world.getPlayers()) {
            this.e(player, bl);
        }
    }

    @Nullable
    public PlayerBridge_7 aa(Player player) {
        return this.e(player, false);
    }

    @Nullable
    public PlayerBridge_7 e(Player player, boolean bl) {
        if (!player.isOnline()) {
            return null;
        }
        if (this.Z(player)) {
            return (PlayerBridge_7)this.nl.get(player);
        }
        PlayerBridge_7 playerBridge_7 = new PlayerBridge_7(player, this);
        this.nk.add(playerBridge_7);
        this.nl.put(player, playerBridge_7);
        if (bl) {
            this.b(playerBridge_7);
        }
        return playerBridge_7;
    }

    public void removeViewer(Player player) {
        this.nk.remove(this.nl.get(player));
        this.nl.remove(player);
    }

    public int[] eb() {
        return this.nc;
    }

    public Opaque112 ec() {
        return this.mN;
    }

    public Location getLocation() {
        return this.ni.fE();
    }

    public Location ed() {
        return this.ns;
    }

    public boolean ee() {
        return this.nt;
    }

    public boolean ef() {
        return this.nu;
    }

    public World cE() {
        return this.getLocation().getWorld();
    }

    @Nullable
    public LivingEntity eg() {
        return this.ni.oy;
    }

    public @UnknownNullability LivingEntity eh() {
        return this.ni.oy;
    }

    public boolean ei() {
        return this.ni.oy != null;
    }

    public void ej() {
        if (this.nh && this.ni.fF()) {
            if (this.nk.size() == 0) {
                return;
            }
            for (PlayerBridge_7 playerBridge_7 : this.nk) {
                PacketListenerRegistry.uN().d(playerBridge_7.iW, this.mJ);
            }
        }
    }

    public void ab(Player player) {
        if (this.nh && this.ni.fF()) {
            PacketListenerRegistry.uN().d(player, this.mJ);
        }
    }

    @Nullable
    public static Entity j(Entity entity) {
        String string = (String)entity.getPersistentDataContainer().get(LivingEntityRegistry.lz, PersistentDataType.STRING);
        if (string == null) {
            return null;
        }
        UUID uUID = UUID.fromString(string);
        return entity.getWorld().getEntity(uUID);
    }

    public static boolean k(Entity entity) {
        return entity.getPersistentDataContainer().has(LivingEntityRegistry.ly, PersistentDataType.INTEGER);
    }

    public LocationHolder_2 an(String string) {
        return (LocationHolder_2)this.na.get(string.toLowerCase());
    }

    public void ao(String string) {
        this.playerSkin = string;
    }

    public void changePlayerSkin(String string) {
        this.g(string, true);
    }

    public void g(String string2, boolean bl) {
        if (string2 == null) {
            string2 = "ewogICJ0aW1lc3RhbXAiIDogMTY2NjMwMjkxNzkzOCwKICAicHJvZmlsZUlkIiA6ICJjOWRlZTM4MDUzYjg0YzI5YjZlZjA5YjJlMDM5OTc0ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTQVJfRGVjZW1iZXI1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMxZjQ3N2ViMWE3YmVlZTYzMWMyY2E2NGQwNmY4ZjY4ZmE5M2EzMzg2ZDA0NDUyYWIyN2Y0M2FjZGYxYjYwY2IiCiAgICB9CiAgfQp9";
        }
        if (string2.length() > 16 && (string2.contains("minesk.in") || string2.contains("mineskin.org"))) {
            try {
                String[] stringArray = string2.split("/");
                String string3 = stringArray[stringArray.length - 1];
                JsonObject jsonObject = Main.g("https://api.mineskin.org/get/uuid/" + string3, 5000);
                string2 = jsonObject.get("data").getAsJsonObject().get("texture").getAsJsonObject().get("value").getAsString();
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Failed to fetch custom player texture: " + string2);
                if (exception instanceof SocketTimeoutException) {
                    CommandSenderBridge_5.error(exception.getMessage());
                } else {
                    exception.printStackTrace();
                }
                string2 = "ewogICJ0aW1lc3RhbXAiIDogMTY2NjMwMjkxNzkzOCwKICAicHJvZmlsZUlkIiA6ICJjOWRlZTM4MDUzYjg0YzI5YjZlZjA5YjJlMDM5OTc0ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTQVJfRGVjZW1iZXI1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMxZjQ3N2ViMWE3YmVlZTYzMWMyY2E2NGQwNmY4ZjY4ZmE5M2EzMzg2ZDA0NDUyYWIyN2Y0M2FjZGYxYjYwY2IiCiAgICB9CiAgfQp9";
            }
        }
        this.playerSkin = string2;
        if (this.ni.fF()) {
            LivingEntityRegistry.b((Entity)this.ni.oy, string2);
        }
        this.na.forEach((string, locationHolder_2) -> locationHolder_2.h(this.playerSkin, bl));
    }

    @Nullable
    public String ek() {
        return this.playerSkin;
    }

    public void a(Opaque112 opaque112) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry entry : this.my.nO.pC.entrySet()) {
            InstanceRegistry_10 instanceRegistry_10 = (InstanceRegistry_10)entry.getValue();
            if (MaterialBarColorHolder.dy && (instanceRegistry_10.pw && instanceRegistry_10.getId().startsWith("dummy_") || instanceRegistry_10.getId().equals("sus_6"))) continue;
            if (MaterialBarColorHolder.fU) {
                CommandSenderBridge_5.log("Initialized bone: " + instanceRegistry_10.getId() + " | " + LocationBridge_2.ae(this.getLocation()) + "(" + String.valueOf(instanceRegistry_10.fT()) + ")");
            }
            LocationHolder_2 locationHolder_22 = new LocationHolder_2(this, instanceRegistry_10, opaque112);
            this.na.put(instanceRegistry_10.getId(), locationHolder_22);
            this.nb.put(instanceRegistry_10.getId(), locationHolder_22);
            arrayList.add(locationHolder_22.qw.Yb);
            arrayList.add(locationHolder_22.qw.Ya);
            if (locationHolder_22.qx.po == NormalEnum.LEFT_HAND_PIVOT) {
                this.nd = locationHolder_22;
                continue;
            }
            if (locationHolder_22.qx.po == NormalEnum.RIGHT_HAND_PIVOT) {
                this.ne = locationHolder_22;
                continue;
            }
            if (locationHolder_22.qx.po != NormalEnum.HAT_PIVOT) continue;
            this.nf = locationHolder_22;
        }
        this.nc = arrayList.stream().mapToInt(Integer::intValue).toArray();
        this.na.forEach((string, locationHolder_2) -> locationHolder_2.a(this.na));
        this.ej();
    }

    public void el() {
        int n = this.nk.size();
        for (int i = 0; i < n; ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)this.nk.get(i);
            playerBridge_7.nN = false;
            this.na.forEach((string, locationHolder_2) -> {
                locationHolder_2.e(playerBridge_7);
                if (locationHolder_2.qx.po == NormalEnum.MOUNT_PIVOT && locationHolder_2.gD() != null) {
                    locationHolder_2.gD().gM();
                }
            });
        }
        this.ej();
    }

    public void ac(Player player) {
        PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)this.nl.get(player);
        if (playerBridge_7 == null) {
            playerBridge_7 = this.aa(player);
        }
        if (playerBridge_7 != null) {
            this.b(playerBridge_7);
        }
    }

    void em() {
        int n = this.nk.size();
        for (int i = 0; i < n; ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)this.nk.get(i);
            this.b(playerBridge_7);
        }
    }

    void a(PlayerBridge_7 playerBridge_7) {
        if (!playerBridge_7.nN) {
            return;
        }
        playerBridge_7.nN = false;
        this.na.forEach((string, locationHolder_2) -> locationHolder_2.a(playerBridge_7, false));
        this.ej();
    }

    void b(PlayerBridge_7 playerBridge_7) {
        playerBridge_7.nN = false;
        this.na.forEach((string, locationHolder_2) -> locationHolder_2.a(playerBridge_7, true));
        this.ej();
        this.dY();
    }

    public void c(PlayerBridge_7 playerBridge_7) {
        if (playerBridge_7.nN) {
            return;
        }
        playerBridge_7.nN = true;
        EntityHolder.tK().a(playerBridge_7.iW, this.nc);
        this.ej();
    }

    public void ad(Player player) {
        PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)this.nl.get(player);
        if (playerBridge_7 == null) {
            return;
        }
        if (playerBridge_7.nN) {
            return;
        }
        playerBridge_7.nN = true;
        EntityHolder.tK().a(playerBridge_7.iW, this.nc);
        this.ej();
    }

    public void en() {
        int n = this.nk.size();
        for (int i = 0; i < n; ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)this.nk.get(i);
            if (playerBridge_7.nN) continue;
            playerBridge_7.nN = true;
            EntityHolder.tK().a(playerBridge_7.iW, this.nc);
        }
    }

    void eo() {
        this.u(true);
    }

    void u(boolean bl) {
        this.removed = true;
        for (Object object : this.mZ) {
            ((LivingEntityArmorStandHolder)object).P(bl);
        }
        for (int i = 0; i < this.nk.size(); ++i) {
            Object object;
            object = (PlayerBridge_7)this.nk.get(i);
            ((PlayerBridge_7)object).nN = true;
            EntityHolder.tK().a(((PlayerBridge_7)object).iW, this.nc);
        }
        if (this.nj != null) {
            this.nj.C(this.nk);
        }
        this.mN.O();
        LivingEntityRegistry.db().c(this);
        this.na.clear();
        this.nk.clear();
        this.nl.clear();
        this.dW();
    }

    public void ap(String string) {
        this.a(string, 0, null);
    }

    public void playAnim(String string, int n) {
        this.a(string, n, null);
    }

    public void a(SoundCategoryBridge_2 soundCategoryBridge_2, int n) {
        if (soundCategoryBridge_2 == null) {
            return;
        }
        if (this.mN.o(soundCategoryBridge_2)) {
            return;
        }
        this.mN.gp();
        this.mN.b(soundCategoryBridge_2, n, null);
    }

    public void a(SoundCategoryBridge_2 soundCategoryBridge_2, int n, @Nullable Runnable runnable) {
        if (soundCategoryBridge_2 == null) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        if (this.mN.o(soundCategoryBridge_2)) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        this.mN.gp();
        this.mN.b(soundCategoryBridge_2, n, runnable);
    }

    public void a(String string, int n, @Nullable Runnable runnable) {
        this.a(string, n, true, runnable);
    }

    public void a(String string, @Nullable Runnable runnable) {
        this.a(string, 0, true, runnable);
    }

    public void a(String string, int n, boolean bl, @Nullable Runnable runnable) {
        if (bl && this.mN.aL(string)) {
            return;
        }
        this.mN.gp();
        SoundCategoryBridge_2 soundCategoryBridge_2 = (SoundCategoryBridge_2)this.my.nO.pB.get(string);
        if (soundCategoryBridge_2 == null) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        this.mN.b(soundCategoryBridge_2, n, runnable);
    }

    public void a(SoundCategoryBridge_2 soundCategoryBridge_2) {
        if (soundCategoryBridge_2 == null) {
            return;
        }
        if (this.mN.aL(soundCategoryBridge_2.oz)) {
            return;
        }
        this.mN.gp();
        this.mN.b(soundCategoryBridge_2, 0, null);
    }

    public void b(SoundCategoryBridge_2 soundCategoryBridge_2) {
        if (soundCategoryBridge_2 == null) {
            return;
        }
        if (this.mN.o(soundCategoryBridge_2)) {
            return;
        }
        if (!this.ew()) {
            return;
        }
        this.mN.m(soundCategoryBridge_2);
    }

    public void aq(String string) {
        SoundCategoryBridge_2 soundCategoryBridge_2 = (SoundCategoryBridge_2)this.my.nO.pB.get(string);
        this.b(soundCategoryBridge_2);
    }

    public void ep() {
        this.na.forEach((string, locationHolder_2) -> locationHolder_2.j(this.nk));
    }

    public void eq() {
        this.playDamageEffect(false);
    }

    public void playDamageEffect(boolean bl) {
        this.at(this.my.ok);
        if (this.my.nO.pD) {
            return;
        }
        this.na.forEach((string, locationHolder_2) -> {
            if (bl) {
                locationHolder_2.qw.b(this.nk, true);
            }
            locationHolder_2.i(this.nk);
            if (this.mL || this.removed) {
                return;
            }
            BukkitTaskBridge.b(() -> {
                if (this.mL || this.removed) {
                    return;
                }
                locationHolder_2.j(this.nk);
            }, 10L);
        });
    }

    public void er() {
        if (this.my.nO.pD) {
            return;
        }
        this.na.forEach((string, locationHolder_2) -> {
            LivingEntity livingEntity;
            LivingEntity livingEntity2 = locationHolder_2.qv.eh();
            if (livingEntity2 instanceof LivingEntity && (livingEntity = livingEntity2).getFireTicks() > 0) {
                locationHolder_2.qw.b(this.nk, true);
            }
            locationHolder_2.i(this.nk);
        });
    }

    public String es() {
        return this.my.nO.getNamespacedID();
    }

    public Hitbox et() {
        return this.my.nO;
    }

    public boolean eu() {
        return this.nm;
    }

    public boolean ev() {
        if (this.ni.oy == null) {
            return false;
        }
        return this.ni.oy.isOnGround();
    }

    public boolean ew() {
        if (this.ni.oy == null) {
            return true;
        }
        return this.ni.oy.isValid() && !this.ni.oy.isDead();
    }

    public boolean ae(Player player) {
        Vector vector;
        if (!player.getWorld().equals((Object)this.ni.fE().getWorld())) {
            return false;
        }
        if (!this.mB) {
            return true;
        }
        Vector vector2 = player.getLocation().getDirection();
        return vector2.distance(vector = this.ni.fE().subtract(player.getLocation()).toVector().normalize()) <= 1.75;
    }

    public void ex() {
        Player player;
        Object object;
        this.ns = this.getLocation();
        if (this.ni.oy != null) {
            if (this.ni.oy.isValid()) {
                if (this.nA != null) {
                    this.nm = this.nA.eu();
                    this.nn = (float)Math.toRadians(this.nA.tm());
                    this.np = (float)Math.toRadians(this.ns.getPitch());
                    this.no = (float)Math.toRadians(this.nA.tn());
                } else {
                    object = this.ni.oy;
                    this.nm = object instanceof Player ? ((object = (RecordOfValue_3)PluginDisableListener.zQ.get(player = (Player)object)) == null ? false : ((RecordOfValue_3)object).eu()) : Math.abs(this.ni.oy.getVelocity().getX()) > 0.0 || Math.abs(this.ni.oy.getVelocity().getZ()) > 0.0;
                    this.nn = (float)Math.toRadians(EntityHolder.tK().L((Entity)this.ni.oy));
                    this.np = (float)Math.toRadians(this.ns.getPitch());
                    this.no = (float)Math.toRadians(EntityHolder.tK().M((Entity)this.ni.oy));
                }
                this.nq = (float)Math.toRadians(this.ns.getPitch());
                this.nr = (float)Math.toRadians(EntityHolder.tK().M((Entity)this.ni.oy));
                this.nt = this.ni.oy.getPose() == Pose.SWIMMING;
                this.nu = this.ni.oy.isGliding();
            }
        } else {
            this.nn = (float)Math.toRadians(this.ns.getYaw());
            this.np = (float)Math.toRadians(this.ns.getPitch());
            this.no = (float)Math.toRadians(this.ns.getYaw());
        }
        if (MaterialBarColorHolder.dQ && this.nw && this.mN != null && this.mN.qb != null) {
            if (this.eJ() && !this.mN.qb.oT && !this.mN.qb.oM) {
                this.nC = 0.0;
                this.nD = 0.0;
                this.nB = 0.0;
                return;
            }
            player = (Player)this.eh();
            object = (RecordOfValue_3)PluginDisableListener.zQ.get(player);
            if (object != null && this.ns != null) {
                double d;
                double d2;
                double d3;
                double d4;
                Location location = this.ns;
                if (this.nE != null && this.nE.getWorld().equals((Object)location.getWorld())) {
                    d4 = location.getX() - this.nE.getX();
                    d3 = location.getY() - this.nE.getY();
                    d2 = location.getZ() - this.nE.getZ();
                    d = Math.sqrt(d4 * d4 + d3 * d3 + d2 * d2);
                    this.nF = d * 20.0;
                }
                this.nE = this.ns.clone();
                d4 = 0.0;
                d3 = 0.0;
                d2 = 0.0;
                d = this.nF / 20.0;
                if (((RecordOfValue_3)object).uG()) {
                    d4 += d;
                } else if (((RecordOfValue_3)object).uH()) {
                    d4 -= d;
                }
                if (((RecordOfValue_3)object).uI()) {
                    d3 += d;
                } else if (((RecordOfValue_3)object).uJ()) {
                    d3 -= d;
                }
                if (Math.abs(player.getVelocity().getY() - -0.0784000015258789) > 0.001) {
                    d2 += player.getVelocity().getY();
                }
                this.nC += (d4 - this.nC) * 0.2;
                this.nD += (d3 - this.nD) * 0.2;
                this.nB += (d2 - this.nB) * 0.6;
            }
        }
    }

    public float ey() {
        return this.no;
    }

    public float ez() {
        return this.nq;
    }

    public float eA() {
        return this.nr;
    }

    public float eB() {
        return this.nn;
    }

    public float eC() {
        return this.np;
    }

    @Nullable
    public SoundCategoryBridge_2 ar(String string) {
        return (SoundCategoryBridge_2)this.my.nO.pB.get(string);
    }

    public boolean eD() {
        if (this.mN.qb != null) {
            return Objects.equals(this.eZ(), this.mN.qb) || Objects.equals(this.fa(), this.mN.qb) || Objects.equals(this.fd(), this.mN.qb) || Objects.equals(this.ff(), this.mN.qb);
        }
        return false;
    }

    public boolean eE() {
        return !this.mZ.isEmpty();
    }

    @Nullable
    public LivingEntityArmorStandHolder eF() {
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.mZ) {
            if (livingEntityArmorStandHolder.gG()) continue;
            return livingEntityArmorStandHolder;
        }
        return null;
    }

    public int eG() {
        int n = 0;
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.mZ) {
            if (!livingEntityArmorStandHolder.gG()) continue;
            ++n;
        }
        return n;
    }

    @Deprecated
    public int[] eH() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.mZ) {
            if (!livingEntityArmorStandHolder.gG()) continue;
            arrayList.add(livingEntityArmorStandHolder.qR.getEntityId());
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void eI() {
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.mZ) {
            if (!livingEntityArmorStandHolder.gG()) continue;
            livingEntityArmorStandHolder.removePassenger();
        }
    }

    @Nullable
    public LivingEntityArmorStandHolder as(String string) {
        LocationHolder_2 locationHolder_2 = (LocationHolder_2)this.na.get(string.toLowerCase());
        if (locationHolder_2.gD() != null) {
            return locationHolder_2.gD();
        }
        return null;
    }

    public boolean eJ() {
        if (this.ni.oy != null) {
            return !this.ni.oy.isOnGround();
        }
        return false;
    }

    public boolean eK() {
        return this.ni.oy != null && EntityHolder.k(this.ni.oy) && this.my.nX.floatValue() > 0.0f;
    }

    void eL() {
        if (this.ni.oy == null) {
            return;
        }
        this.ni.oy.damage(this.ni.oy.getMaxHealth() + 1.0);
        this.eo();
    }

    void c(boolean bl, boolean bl2) {
        if (this.ni.oy != null && this.ng) {
            if (!bl2) {
                this.ni.oy.remove();
            }
            if (bl) {
                for (int i = 0; i < this.nk.size(); ++i) {
                    PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)this.nk.get(i);
                    playerBridge_7.iW.spawnParticle(Particle.POOF, this.ni.fE(), 8, (double)ColorBridge.f(0.02f, 0.3f), (double)(1.0f + ColorBridge.f(0.02f, 0.3f)), (double)ColorBridge.f(0.02f, 0.3f), 0.0);
                }
            }
        }
        this.eo();
    }

    public List getAnimationsNames() {
        return this.my.nO.getAnimationsNames();
    }

    public boolean eM() {
        if (this.mA) {
            return true;
        }
        this.mA = System.currentTimeMillis() - this.mz > 1000L;
        return this.mA;
    }

    public void eN() {
        if (this.nj != null) {
            this.nj.a(this.ns.getX(), this.ns.getY(), this.ns.getZ(), this.nk);
        }
    }

    public void eO() {
        if (this.nj != null) {
            this.nj.B(this.nk);
        }
    }

    public void teleport(Location location) {
        this.ni.s(location);
        this.mN.gl();
    }

    public void eP() {
        if (this.ni == null) {
            this.nz = 60.0;
            return;
        }
        this.nz = Math.max(16, this.cE().getViewDistance() * 16);
        this.nz = Math.min(70.0, this.nz);
    }

    @Nullable
    public SoundCategoryBridge_2 eQ() {
        return this.mN.qb;
    }

    public void eR() {
        this.mL = true;
    }

    public void eS() {
        this.at(this.my.ol);
    }

    public void eT() {
        this.at(this.my.oj);
    }

    public void eU() {
        RecordOfString_5 recordOfString_5 = this.my.oi;
        if (recordOfString_5 == null) {
            return;
        }
        double d = recordOfString_5.fC() / 100.0;
        int n = this.mM++;
        if (ColorBridge.Bl.nextDouble() < d * (double)n) {
            this.mM = -recordOfString_5.fD();
            BukkitTaskBridge.i(() -> LocationBridge_3.a(this.ed(), recordOfString_5.fB(), SoundCategory.NEUTRAL, 1.0f, 1.0f));
        }
    }

    private void at(String string) {
        if (string == null) {
            return;
        }
        LocationBridge_3.a(this.ed(), string, SoundCategory.NEUTRAL, 1.0f, 1.0f);
    }

    public boolean eV() {
        if (this.eg() == null) {
            return false;
        }
        return EntityHolder.tK().R((Entity)this.eg());
    }

    @Nullable
    public SoundCategoryBridge_2 eW() {
        if (EntityHolder.tK().m(this.eh()) && this.mV != null) {
            return this.mV;
        }
        if (this.eJ()) {
            if (this.mT != null) {
                return this.mT;
            }
            return this.mP;
        }
        if (this.eu()) {
            if (this.mU != null && this.eV()) {
                return this.mU;
            }
            return this.mQ;
        }
        if (this.mW != null && this.eV()) {
            return this.mW;
        }
        return this.mP;
    }

    @Nullable
    public LivingEntity eX() {
        Mob mob;
        LivingEntity livingEntity = this.eh();
        if (livingEntity instanceof Mob && (livingEntity = (mob = (Mob)livingEntity).getTarget()) != null && livingEntity.isValid()) {
            return livingEntity;
        }
        return null;
    }

    public void a(Entity entity, InteractEnum interactEnum, Consumer consumer) {
        this.my.on.a(entity, interactEnum, consumer);
    }

    public boolean a(EquipmentSlot equipmentSlot, ItemStackBridge_8 itemStackBridge_8) {
        if (this.ni.oy == null || this.ni.oy.getEquipment() == null) {
            return false;
        }
        ItemStack itemStack = this.ni.oy.getEquipment().getItem(equipmentSlot);
        if (itemStack.getType() == Material.AIR) {
            return false;
        }
        return itemStackBridge_8.e(itemStack);
    }

    @Generated
    public boolean eY() {
        return this.mL;
    }

    @Generated
    public void c(SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mP = soundCategoryBridge_2;
    }

    @Generated
    public SoundCategoryBridge_2 eZ() {
        return this.mP;
    }

    @Generated
    public void d(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mQ = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fa() {
        return this.mQ;
    }

    @Generated
    public void e(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mR = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fb() {
        return this.mR;
    }

    @Generated
    public void f(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mS = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fc() {
        return this.mS;
    }

    @Generated
    public void g(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mT = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fd() {
        return this.mT;
    }

    @Generated
    public void h(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mU = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fe() {
        return this.mU;
    }

    @Generated
    public void i(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mV = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 ff() {
        return this.mV;
    }

    @Generated
    public void j(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mW = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fg() {
        return this.mW;
    }

    @Generated
    public void k(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mX = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fh() {
        return this.mX;
    }

    @Generated
    public void l(@Nullable SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.mY = soundCategoryBridge_2;
    }

    @Nullable
    @Generated
    public SoundCategoryBridge_2 fi() {
        return this.mY;
    }

    @Generated
    public boolean fj() {
        return this.nx;
    }

    @Generated
    public void v(boolean bl) {
        this.nx = bl;
    }

    @Generated
    public boolean fk() {
        return this.ny;
    }

    @Generated
    public void w(boolean bl) {
        this.ny = bl;
    }
}
