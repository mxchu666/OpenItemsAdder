package itemsadder.m;

import com.google.gson.JsonObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.acm;
import itemsadder.m.acn;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.aov;
import itemsadder.m.aow;
import itemsadder.m.au;
import itemsadder.m.aui;
import itemsadder.m.ax;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcv;
import itemsadder.m.bcy;
import itemsadder.m.da;
import itemsadder.m.do;
import itemsadder.m.dp;
import itemsadder.m.dr;
import itemsadder.m.ds;
import itemsadder.m.dt;
import itemsadder.m.dw;
import itemsadder.m.dx;
import itemsadder.m.dz;
import itemsadder.m.ec;
import itemsadder.m.eh;
import itemsadder.m.ej;
import itemsadder.m.ek;
import itemsadder.m.l;
import itemsadder.m.la;
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
import java.util.function.Consumer;
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

public class dn {
    public final dp my;
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
    eh mN;
    @Nullable
    dt mO;
    dt mP;
    @Nullable
    dt mQ;
    @Nullable
    dt mR;
    @Nullable
    dt mS;
    @Nullable
    dt mT;
    @Nullable
    dt mU;
    @Nullable
    dt mV;
    @Nullable
    dt mW;
    @Nullable
    dt mX;
    @Nullable
    dt mY;
    public List mZ = new ArrayList();
    public LinkedHashMap na = new LinkedHashMap();
    public LinkedHashMap nb = new LinkedHashMap();
    private int[] nc = new int[0];
    public ej nd;
    public ej ne;
    public ej nf;
    boolean ng;
    boolean nh = true;
    public ds ni;
    @Nullable
    public aui nj;
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
    private acm nA;
    public double nB = 0.0;
    public double nC = 0.0;
    public double nD = 0.0;
    Location nE;
    double nF;

    public dn(dp dp2, boolean bl) {
        this.my = dp2;
        this.mO = dp2.nO.pB.values().stream().findFirst().orElse(null);
        this.mE = true;
        this.mP = dp2.nO.a(dw.IDLE);
        this.mW = dp2.nO.a(dw.IDLE_ANGRY);
        this.mQ = dp2.nO.a(dw.WALK);
        this.mU = dp2.nO.a(dw.WALK_ANGRY);
        this.mV = dp2.nO.a(dw.JUMP);
        this.mR = dp2.nO.a(dw.ATTACK);
        this.mS = dp2.nO.a(dw.DEATH);
        this.mT = dp2.nO.a(dw.FLY);
        this.mX = dp2.nO.a(dw.SNEAK);
        this.mY = dp2.nO.a(dw.SNEAK_WALK);
        for (Map.Entry entry : dp2.nO.pC.entrySet()) {
            if (((dx)entry.getValue()).po != dz.HEAD) continue;
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

    LivingEntity a(Location location, @Nullable Consumer consumer) {
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
            afz.tK().c((Entity)entity, location.getYaw());
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
        this.ni = new ds(livingEntity);
        this.ex();
        return this.a(livingEntity, true, true);
    }

    LivingEntity b(LivingEntity livingEntity, boolean bl) {
        return this.a(livingEntity, bl, false);
    }

    LivingEntity a(LivingEntity livingEntity, boolean bl, boolean bl2) {
        dn dn2 = this.a(livingEntity, null, bl, bl2);
        return dn2.eg();
    }

    dn r(@Nullable Location location) {
        return this.a(null, location, false, false);
    }

    dn a(@Nullable LivingEntity livingEntity, @Nullable Location location, boolean bl, boolean bl2) {
        this.ng = bl;
        this.ni = livingEntity != null ? new ds(livingEntity) : new ds(location);
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
            this.mJ = aow.uN().aJ(this.ni.oy.getEntityId());
        }
        this.mK = this.ns = this.ni.fE();
        if (this.nh) {
            this.ej();
        }
        this.ex();
        if (this.my.od) {
            this.nj = aui.Z(this.ns);
            if (!(this.ni.oy instanceof Player)) {
                this.eO();
            }
        }
        this.mN = new eh(this, (dt)this.my.nO.pB.get(this.mO.oz));
        if (!this.nw && bl) {
            if (bl2) {
                this.my.a(this.ni.oy, this.playerSkin, false);
            }
            this.dX();
            LivingEntity livingEntity2 = this.ni.oy;
            if (livingEntity2 instanceof Mob) {
                Mob mob = (Mob)livingEntity2;
                afz.tK().a(mob, true);
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
        ec ec2 = this.et();
        this.nA = acn.a(this.ni.oy, ec2.pH);
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
            afz.tK().a((Entity)this.ni.oy, this.my.nO.pF.aBp, this.my.nO.pE.aBq + this.my.nO.pF.aBq);
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
            this.na.forEach((string, ej2) -> ej2.qw.b(this.nk, this.ni.oy.getFireTicks() > 0));
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
    public do aa(Player player) {
        return this.e(player, false);
    }

    @Nullable
    public do e(Player player, boolean bl) {
        if (!player.isOnline()) {
            return null;
        }
        if (this.Z(player)) {
            return (do)this.nl.get(player);
        }
        do do_ = new do(player, this);
        this.nk.add(do_);
        this.nl.put(player, do_);
        if (bl) {
            this.b(do_);
        }
        return do_;
    }

    public void removeViewer(Player player) {
        this.nk.remove(this.nl.get(player));
        this.nl.remove(player);
    }

    public int[] eb() {
        return this.nc;
    }

    public eh ec() {
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
            for (do do_ : this.nk) {
                aow.uN().d(do_.iW, this.mJ);
            }
        }
    }

    public void ab(Player player) {
        if (this.nh && this.ni.fF()) {
            aow.uN().d(player, this.mJ);
        }
    }

    @Nullable
    public static Entity j(Entity entity) {
        String string = (String)entity.getPersistentDataContainer().get(da.lz, PersistentDataType.STRING);
        if (string == null) {
            return null;
        }
        UUID uUID = UUID.fromString(string);
        return entity.getWorld().getEntity(uUID);
    }

    public static boolean k(Entity entity) {
        return entity.getPersistentDataContainer().has(da.ly, PersistentDataType.INTEGER);
    }

    public ej an(String string) {
        return (ej)this.na.get(string.toLowerCase());
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
                bce.error("Failed to fetch custom player texture: " + string2);
                if (exception instanceof SocketTimeoutException) {
                    bce.error(exception.getMessage());
                } else {
                    exception.printStackTrace();
                }
                string2 = "ewogICJ0aW1lc3RhbXAiIDogMTY2NjMwMjkxNzkzOCwKICAicHJvZmlsZUlkIiA6ICJjOWRlZTM4MDUzYjg0YzI5YjZlZjA5YjJlMDM5OTc0ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTQVJfRGVjZW1iZXI1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMxZjQ3N2ViMWE3YmVlZTYzMWMyY2E2NGQwNmY4ZjY4ZmE5M2EzMzg2ZDA0NDUyYWIyN2Y0M2FjZGYxYjYwY2IiCiAgICB9CiAgfQp9";
            }
        }
        this.playerSkin = string2;
        if (this.ni.fF()) {
            da.b((Entity)this.ni.oy, string2);
        }
        this.na.forEach((string, ej2) -> ej2.h(this.playerSkin, bl));
    }

    @Nullable
    public String ek() {
        return this.playerSkin;
    }

    public void a(eh eh2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry entry : this.my.nO.pC.entrySet()) {
            dx dx2 = (dx)entry.getValue();
            if (ae.dy && (dx2.pw && dx2.getId().startsWith("dummy_") || dx2.getId().equals("sus_6"))) continue;
            if (ae.fU) {
                bce.log("Initialized bone: " + dx2.getId() + " | " + bcc.ae(this.getLocation()) + "(" + String.valueOf(dx2.fT()) + ")");
            }
            ej ej3 = new ej(this, dx2, eh2);
            this.na.put(dx2.getId(), ej3);
            this.nb.put(dx2.getId(), ej3);
            arrayList.add(ej3.qw.Yb);
            arrayList.add(ej3.qw.Ya);
            if (ej3.qx.po == dz.LEFT_HAND_PIVOT) {
                this.nd = ej3;
                continue;
            }
            if (ej3.qx.po == dz.RIGHT_HAND_PIVOT) {
                this.ne = ej3;
                continue;
            }
            if (ej3.qx.po != dz.HAT_PIVOT) continue;
            this.nf = ej3;
        }
        this.nc = arrayList.stream().mapToInt(Integer::intValue).toArray();
        this.na.forEach((string, ej2) -> ej2.a(this.na));
        this.ej();
    }

    public void el() {
        int n = this.nk.size();
        for (int i = 0; i < n; ++i) {
            do do_ = (do)this.nk.get(i);
            do_.nN = false;
            this.na.forEach((string, ej2) -> {
                ej2.e(do_);
                if (ej2.qx.po == dz.MOUNT_PIVOT && ej2.gD() != null) {
                    ej2.gD().gM();
                }
            });
        }
        this.ej();
    }

    public void ac(Player player) {
        do do_ = (do)this.nl.get(player);
        if (do_ == null) {
            do_ = this.aa(player);
        }
        if (do_ != null) {
            this.b(do_);
        }
    }

    void em() {
        int n = this.nk.size();
        for (int i = 0; i < n; ++i) {
            do do_ = (do)this.nk.get(i);
            this.b(do_);
        }
    }

    void a(do do_) {
        if (!do_.nN) {
            return;
        }
        do_.nN = false;
        this.na.forEach((string, ej2) -> ej2.a(do_, false));
        this.ej();
    }

    void b(do do_) {
        do_.nN = false;
        this.na.forEach((string, ej2) -> ej2.a(do_, true));
        this.ej();
        this.dY();
    }

    public void c(do do_) {
        if (do_.nN) {
            return;
        }
        do_.nN = true;
        afz.tK().a(do_.iW, this.nc);
        this.ej();
    }

    public void ad(Player player) {
        do do_ = (do)this.nl.get(player);
        if (do_ == null) {
            return;
        }
        if (do_.nN) {
            return;
        }
        do_.nN = true;
        afz.tK().a(do_.iW, this.nc);
        this.ej();
    }

    public void en() {
        int n = this.nk.size();
        for (int i = 0; i < n; ++i) {
            do do_ = (do)this.nk.get(i);
            if (do_.nN) continue;
            do_.nN = true;
            afz.tK().a(do_.iW, this.nc);
        }
    }

    void eo() {
        this.u(true);
    }

    void u(boolean bl) {
        this.removed = true;
        for (Object object : this.mZ) {
            ((ek)object).P(bl);
        }
        for (int i = 0; i < this.nk.size(); ++i) {
            Object object;
            object = (do)this.nk.get(i);
            ((do)object).nN = true;
            afz.tK().a(((do)object).iW, this.nc);
        }
        if (this.nj != null) {
            this.nj.C(this.nk);
        }
        this.mN.O();
        da.db().c(this);
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

    public void a(dt dt2, int n) {
        if (dt2 == null) {
            return;
        }
        if (this.mN.o(dt2)) {
            return;
        }
        this.mN.gp();
        this.mN.b(dt2, n, null);
    }

    public void a(dt dt2, int n, @Nullable Runnable runnable) {
        if (dt2 == null) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        if (this.mN.o(dt2)) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        this.mN.gp();
        this.mN.b(dt2, n, runnable);
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
        dt dt2 = (dt)this.my.nO.pB.get(string);
        if (dt2 == null) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        this.mN.b(dt2, n, runnable);
    }

    public void a(dt dt2) {
        if (dt2 == null) {
            return;
        }
        if (this.mN.aL(dt2.oz)) {
            return;
        }
        this.mN.gp();
        this.mN.b(dt2, 0, null);
    }

    public void b(dt dt2) {
        if (dt2 == null) {
            return;
        }
        if (this.mN.o(dt2)) {
            return;
        }
        if (!this.ew()) {
            return;
        }
        this.mN.m(dt2);
    }

    public void aq(String string) {
        dt dt2 = (dt)this.my.nO.pB.get(string);
        this.b(dt2);
    }

    public void ep() {
        this.na.forEach((string, ej2) -> ej2.j(this.nk));
    }

    public void eq() {
        this.playDamageEffect(false);
    }

    public void playDamageEffect(boolean bl) {
        this.at(this.my.ok);
        if (this.my.nO.pD) {
            return;
        }
        this.na.forEach((string, ej2) -> {
            if (bl) {
                ej2.qw.b(this.nk, true);
            }
            ej2.i(this.nk);
            if (this.mL || this.removed) {
                return;
            }
            bcp.b(() -> {
                if (this.mL || this.removed) {
                    return;
                }
                ej2.j(this.nk);
            }, 10L);
        });
    }

    public void er() {
        if (this.my.nO.pD) {
            return;
        }
        this.na.forEach((string, ej2) -> {
            LivingEntity livingEntity;
            LivingEntity livingEntity2 = ej2.qv.eh();
            if (livingEntity2 instanceof LivingEntity && (livingEntity = livingEntity2).getFireTicks() > 0) {
                ej2.qw.b(this.nk, true);
            }
            ej2.i(this.nk);
        });
    }

    public String es() {
        return this.my.nO.getNamespacedID();
    }

    public ec et() {
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
                    this.nm = object instanceof Player ? ((object = (aov)la.zQ.get(player = (Player)object)) == null ? false : ((aov)object).eu()) : Math.abs(this.ni.oy.getVelocity().getX()) > 0.0 || Math.abs(this.ni.oy.getVelocity().getZ()) > 0.0;
                    this.nn = (float)Math.toRadians(afz.tK().L((Entity)this.ni.oy));
                    this.np = (float)Math.toRadians(this.ns.getPitch());
                    this.no = (float)Math.toRadians(afz.tK().M((Entity)this.ni.oy));
                }
                this.nq = (float)Math.toRadians(this.ns.getPitch());
                this.nr = (float)Math.toRadians(afz.tK().M((Entity)this.ni.oy));
                this.nt = this.ni.oy.getPose() == Pose.SWIMMING;
                this.nu = this.ni.oy.isGliding();
            }
        } else {
            this.nn = (float)Math.toRadians(this.ns.getYaw());
            this.np = (float)Math.toRadians(this.ns.getPitch());
            this.no = (float)Math.toRadians(this.ns.getYaw());
        }
        if (ae.dQ && this.nw && this.mN != null && this.mN.qb != null) {
            if (this.eJ() && !this.mN.qb.oT && !this.mN.qb.oM) {
                this.nC = 0.0;
                this.nD = 0.0;
                this.nB = 0.0;
                return;
            }
            player = (Player)this.eh();
            object = (aov)la.zQ.get(player);
            if (object != null && this.ns != null) {
                double d2;
                double d3;
                double d4;
                double d5;
                Location location = this.ns;
                if (this.nE != null && this.nE.getWorld().equals((Object)location.getWorld())) {
                    d5 = location.getX() - this.nE.getX();
                    d4 = location.getY() - this.nE.getY();
                    d3 = location.getZ() - this.nE.getZ();
                    d2 = Math.sqrt(d5 * d5 + d4 * d4 + d3 * d3);
                    this.nF = d2 * 20.0;
                }
                this.nE = this.ns.clone();
                d5 = 0.0;
                d4 = 0.0;
                d3 = 0.0;
                d2 = this.nF / 20.0;
                if (((aov)object).uG()) {
                    d5 += d2;
                } else if (((aov)object).uH()) {
                    d5 -= d2;
                }
                if (((aov)object).uI()) {
                    d4 += d2;
                } else if (((aov)object).uJ()) {
                    d4 -= d2;
                }
                if (Math.abs(player.getVelocity().getY() - -0.0784000015258789) > 0.001) {
                    d3 += player.getVelocity().getY();
                }
                this.nC += (d5 - this.nC) * 0.2;
                this.nD += (d4 - this.nD) * 0.2;
                this.nB += (d3 - this.nB) * 0.6;
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
    public dt ar(String string) {
        return (dt)this.my.nO.pB.get(string);
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
    public ek eF() {
        for (ek ek2 : this.mZ) {
            if (ek2.gG()) continue;
            return ek2;
        }
        return null;
    }

    public int eG() {
        int n = 0;
        for (ek ek2 : this.mZ) {
            if (!ek2.gG()) continue;
            ++n;
        }
        return n;
    }

    @Deprecated
    public int[] eH() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (ek ek2 : this.mZ) {
            if (!ek2.gG()) continue;
            arrayList.add(ek2.qR.getEntityId());
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void eI() {
        for (ek ek2 : this.mZ) {
            if (!ek2.gG()) continue;
            ek2.removePassenger();
        }
    }

    @Nullable
    public ek as(String string) {
        ej ej2 = (ej)this.na.get(string.toLowerCase());
        if (ej2.gD() != null) {
            return ej2.gD();
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
        return this.ni.oy != null && afz.k(this.ni.oy) && this.my.nX.floatValue() > 0.0f;
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
                    do do_ = (do)this.nk.get(i);
                    do_.iW.spawnParticle(Particle.POOF, this.ni.fE(), 8, (double)bcy.f(0.02f, 0.3f), (double)(1.0f + bcy.f(0.02f, 0.3f)), (double)bcy.f(0.02f, 0.3f), 0.0);
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
    public dt eQ() {
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
        dr dr2 = this.my.oi;
        if (dr2 == null) {
            return;
        }
        double d2 = dr2.fC() / 100.0;
        int n = this.mM++;
        if (bcy.Bl.nextDouble() < d2 * (double)n) {
            this.mM = -dr2.fD();
            bcp.i(() -> bcv.a(this.ed(), dr2.fB(), SoundCategory.NEUTRAL, 1.0f, 1.0f));
        }
    }

    private void at(String string) {
        if (string == null) {
            return;
        }
        bcv.a(this.ed(), string, SoundCategory.NEUTRAL, 1.0f, 1.0f);
    }

    public boolean eV() {
        if (this.eg() == null) {
            return false;
        }
        return afz.tK().R((Entity)this.eg());
    }

    @Nullable
    public dt eW() {
        if (afz.tK().m(this.eh()) && this.mV != null) {
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

    public void a(Entity entity, ax ax2, au au2) {
        this.my.on.a(entity, ax2, au2);
    }

    public boolean a(EquipmentSlot equipmentSlot, l l2) {
        if (this.ni.oy == null || this.ni.oy.getEquipment() == null) {
            return false;
        }
        ItemStack itemStack = this.ni.oy.getEquipment().getItem(equipmentSlot);
        if (itemStack.getType() == Material.AIR) {
            return false;
        }
        return l2.e(itemStack);
    }

    @Generated
    public boolean eY() {
        return this.mL;
    }

    @Generated
    public void c(dt dt2) {
        this.mP = dt2;
    }

    @Generated
    public dt eZ() {
        return this.mP;
    }

    @Generated
    public void d(@Nullable dt dt2) {
        this.mQ = dt2;
    }

    @Nullable
    @Generated
    public dt fa() {
        return this.mQ;
    }

    @Generated
    public void e(@Nullable dt dt2) {
        this.mR = dt2;
    }

    @Nullable
    @Generated
    public dt fb() {
        return this.mR;
    }

    @Generated
    public void f(@Nullable dt dt2) {
        this.mS = dt2;
    }

    @Nullable
    @Generated
    public dt fc() {
        return this.mS;
    }

    @Generated
    public void g(@Nullable dt dt2) {
        this.mT = dt2;
    }

    @Nullable
    @Generated
    public dt fd() {
        return this.mT;
    }

    @Generated
    public void h(@Nullable dt dt2) {
        this.mU = dt2;
    }

    @Nullable
    @Generated
    public dt fe() {
        return this.mU;
    }

    @Generated
    public void i(@Nullable dt dt2) {
        this.mV = dt2;
    }

    @Nullable
    @Generated
    public dt ff() {
        return this.mV;
    }

    @Generated
    public void j(@Nullable dt dt2) {
        this.mW = dt2;
    }

    @Nullable
    @Generated
    public dt fg() {
        return this.mW;
    }

    @Generated
    public void k(@Nullable dt dt2) {
        this.mX = dt2;
    }

    @Nullable
    @Generated
    public dt fh() {
        return this.mX;
    }

    @Generated
    public void l(@Nullable dt dt2) {
        this.mY = dt2;
    }

    @Nullable
    @Generated
    public dt fi() {
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
