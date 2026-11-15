package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity$Bone;
import dev.lone.itemsadder.api.CustomEntity$MountBone;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.do;
import itemsadder.m.dp;
import itemsadder.m.dt;
import itemsadder.m.ej;
import itemsadder.m.ek;
import itemsadder.m.ud;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Consumer;
import org.jetbrains.annotations.Nullable;

public class CustomEntity {
    static final String EXCEPTION = "Entities API not available. Check if it's disabled in config.yml of ItemsAdder";
    dn renderer;

    CustomEntity(dn dn2) {
        this.renderer = dn2;
        this.renderer.mI = this;
    }

    public static Set getNamespacedIdsInRegistry() {
        return da.db().lJ.keySet();
    }

    public static boolean isInRegistry(String string) {
        return da.db().lJ.containsKey(string);
    }

    @Nullable
    public static CustomEntity spawn(String string, Location location) {
        return CustomEntity.spawn(string, location, true);
    }

    @Nullable
    public static CustomEntity spawn(String string, Location location, boolean bl) {
        return CustomEntity.spawn(string, location, bl, false, false);
    }

    @Nullable
    public static CustomEntity spawn(String string, Location location, List list, boolean bl, @Nullable Consumer consumer) {
        return CustomEntity.spawn(string, location, list, bl, false, false, consumer);
    }

    @Nullable
    public static CustomEntity spawn(String string, Location location, boolean bl, boolean bl2, boolean bl3) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!da.db().lJ.containsKey(string)) {
            return null;
        }
        dn dn2 = da.db().a(string, location, bl, bl2, bl3);
        if (dn2 == null) {
            return null;
        }
        return new CustomEntity(dn2);
    }

    @Nullable
    public static CustomEntity spawn(String string, Location location, List list, boolean bl, boolean bl2, boolean bl3, @Nullable Consumer consumer) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!da.db().lJ.containsKey(string)) {
            return null;
        }
        dn dn2 = da.db().a(string, location, null, list, bl, bl2, bl3, consumer);
        if (dn2 == null) {
            return null;
        }
        return new CustomEntity(dn2);
    }

    @Nullable
    public static CustomEntity convert(String string, LivingEntity livingEntity) {
        return CustomEntity.convert(string, livingEntity, true);
    }

    @Nullable
    public static CustomEntity convert(String string, LivingEntity livingEntity, boolean bl) {
        return CustomEntity.convert(string, livingEntity, bl, false, true, true);
    }

    @Nullable
    public static CustomEntity convert(String string, LivingEntity livingEntity, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!da.db().lJ.containsKey(string)) {
            return null;
        }
        dn dn2 = da.db().a(string, null, livingEntity, bl, bl4, bl2, bl3);
        if (dn2 == null) {
            return null;
        }
        return new CustomEntity(dn2);
    }

    @Nullable
    public static CustomEntity convert(String string, LivingEntity livingEntity, List list, boolean bl) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!da.db().lJ.containsKey(string)) {
            return null;
        }
        dn dn2 = da.db().a(string, null, livingEntity, list, bl, true);
        if (dn2 == null) {
            return null;
        }
        return new CustomEntity(dn2);
    }

    @Nullable
    public static CustomEntity byAlreadySpawned(Entity entity) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        dn dn2 = da.db().h(entity);
        if (dn2 == null) {
            return null;
        }
        return new CustomEntity(dn2);
    }

    public static boolean isCustomEntity(Entity entity) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        return da.db().f(entity);
    }

    public static boolean isCustomEntity(UUID uUID) {
        if (!da.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        return da.db().d(uUID);
    }

    public Entity getEntity() {
        return this.renderer.eg();
    }

    public EntityType getType() {
        return this.renderer.eg().getType();
    }

    public Location getLocation() {
        return this.renderer.getLocation();
    }

    public void teleport(Location location) {
        this.renderer.teleport(location);
    }

    public String getNamespacedID() {
        return this.renderer.es();
    }

    public String getNamespace() {
        return this.renderer.et().getNamespace();
    }

    public String getId() {
        return this.renderer.et().getId();
    }

    public void respawn(Player player) {
        this.renderer.ac(player);
    }

    public void addViewer(Player player) {
        this.renderer.e(player, true);
    }

    public void removeViewer(Player player) {
        for (do do_ : this.renderer.ea()) {
            if (!do_.iW.equals((Object)player)) continue;
            this.renderer.removeViewer(player);
            this.renderer.c(do_);
            break;
        }
    }

    public void setFrustumCulling(boolean bl) {
        this.renderer.mB = bl;
    }

    public boolean getFrustumCulling() {
        return this.renderer.mB;
    }

    public boolean playAnimation(String string, @Nullable Runnable runnable) {
        dt dt2 = this.renderer.ar(string);
        if (dt2 == null) {
            return false;
        }
        this.renderer.ec().b(dt2, 0, runnable);
        return true;
    }

    public boolean playAnimation(String string) {
        return this.playAnimation(string, null);
    }

    public void stopAnimation() {
        this.renderer.ec().gm();
    }

    public boolean isPlayingAnimation(String string) {
        return this.renderer.ec().aL(string);
    }

    public static boolean hasAnimation(String string, String string2) {
        dp dp2 = (dp)da.db().lJ.get(string);
        if (dp2 == null) {
            throw new NullPointerException("Can't find custom entity '" + string + "' in config files.");
        }
        return dp2.nO.pB.containsKey(string2);
    }

    public boolean hasAnimation(String string) {
        return this.renderer.et().pB.containsKey(string);
    }

    public static List getAnimationsNames(String string) {
        dp dp2 = (dp)da.db().lJ.get(string);
        if (dp2 == null) {
            throw new NullPointerException("Can't find custom entity '" + string + "' in config files.");
        }
        return dp2.nO.getAnimationsNames();
    }

    public List getAnimationsNames() {
        return this.renderer.et().getAnimationsNames();
    }

    public void destroy() {
        da.db().a(this.renderer, true, false);
    }

    public void playDamageEffect(boolean bl) {
        this.renderer.playDamageEffect(bl);
    }

    public void setColorAllBones(int n) {
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            if (((ej)entry.getValue()).qw == null) continue;
            ((ej)entry.getValue()).qw.setColor(n);
            ((ej)entry.getValue()).gB();
        }
    }

    public void setEnchantedAllBones(boolean bl) {
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            if (((ej)entry.getValue()).qw == null) continue;
            ((ej)entry.getValue()).qw.setEnchanted(bl);
            ((ej)entry.getValue()).gB();
        }
    }

    public boolean hasMountBones() {
        return this.renderer.eE();
    }

    public boolean addPassenger(LivingEntity livingEntity) {
        if (!this.renderer.eE()) {
            return false;
        }
        return da.db().a(livingEntity, this.renderer);
    }

    public static void removePassenger(LivingEntity livingEntity) {
        da.db().removePassenger(livingEntity);
    }

    public Set getPassengers() {
        HashSet<LivingEntity> hashSet = new HashSet<LivingEntity>();
        for (ek ek2 : this.renderer.mZ) {
            if (!ek2.gG()) continue;
            hashSet.add(ek2.qR);
        }
        return hashSet;
    }

    public boolean hasPassenger(LivingEntity livingEntity) {
        for (ek ek2 : this.renderer.mZ) {
            if (!ek2.gG() || ek2.qR != livingEntity) continue;
            return true;
        }
        return false;
    }

    public boolean hasPassenger() {
        for (ek ek2 : this.renderer.mZ) {
            if (!ek2.gG()) continue;
            return true;
        }
        return false;
    }

    public boolean setPassenger(LivingEntity livingEntity, int n) {
        if (!this.renderer.eE()) {
            return false;
        }
        List list = this.renderer.mZ;
        if (n >= list.size()) {
            throw new IllegalArgumentException("No mount bone with such index. Max mount bone index: " + (list.size() - 1));
        }
        ek ek2 = (ek)list.get(n);
        if (ek2 == null) {
            return false;
        }
        if (ek2.gG()) {
            da.db().removePassenger(ek2.qR);
        }
        return da.db().a(livingEntity, ek2);
    }

    public Set getBones() {
        HashSet<CustomEntity$Bone> hashSet = new HashSet<CustomEntity$Bone>();
        int n = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            ej ej2 = (ej)entry.getValue();
            hashSet.add(CustomEntity$Bone.wrap(ej2, n));
            ++n;
        }
        return hashSet;
    }

    public Set getMountBones() {
        HashSet<CustomEntity$MountBone> hashSet = new HashSet<CustomEntity$MountBone>();
        int n = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            ej ej2 = (ej)entry.getValue();
            if (ej2.gD() != null) {
                hashSet.add((CustomEntity$MountBone)CustomEntity$Bone.wrap(ej2, n));
            }
            ++n;
        }
        return hashSet;
    }

    public CustomEntity$Bone getBone(int n) {
        if (n >= this.renderer.na.size()) {
            throw new IndexOutOfBoundsException("There is no bone with such index");
        }
        int n2 = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            ej ej2 = (ej)entry.getValue();
            if (n2 == n) {
                return CustomEntity$Bone.wrap(ej2, n2);
            }
            ++n2;
        }
        throw new IndexOutOfBoundsException("There is no bone with such index");
    }

    @Nullable
    public CustomEntity$Bone getBone(String string) {
        int n = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            ej ej2 = (ej)entry.getValue();
            if (!ej2.qx.getId().equals(string)) continue;
            return CustomEntity$Bone.wrap(ej2, n);
        }
        return null;
    }

    @Nullable
    public CustomEntity$MountBone getMountBoneByPassenger(LivingEntity livingEntity) {
        Set set = this.getMountBones();
        for (CustomEntity$MountBone customEntity$MountBone : set) {
            if (customEntity$MountBone.internal.gD() == null || customEntity$MountBone.internal.gD().qR != livingEntity) continue;
            return customEntity$MountBone;
        }
        return null;
    }

    public void internal_changeWrappedCustomEntity(dn dn2) {
        this.renderer = dn2;
        dn2.mI = this;
    }

    public List getLoot() {
        return this.getLoot(null);
    }

    public List getLoot(@Nullable ItemStack itemStack) {
        return CustomEntity.getLoot(this.renderer.eg(), itemStack);
    }

    public static List getLoot(LivingEntity livingEntity, @Nullable ItemStack itemStack) {
        dn dn2 = da.db().h((Entity)livingEntity);
        if (dn2 == null) {
            return new ArrayList();
        }
        return CustomEntity.getLoot0(dn2, itemStack);
    }

    private static List getLoot0(dn dn2, @Nullable ItemStack itemStack) {
        ArrayList arrayList = new ArrayList();
        @Nullable List list = d.g().aq.m(dn2);
        if (list != null) {
            for (ud ud2 : list) {
                arrayList.addAll(ud2.N(itemStack));
            }
        }
        return arrayList;
    }
}
