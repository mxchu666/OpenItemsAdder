package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity$Bone;
import dev.lone.itemsadder.api.CustomEntity$MountBone;
import itemsadder.m.EntityTypeBarStyleHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationHolder_2;
import itemsadder.m.Opaque136;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.SoundCategoryBridge_2;
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
    LivingEntityBuilder renderer;

    CustomEntity(LivingEntityBuilder livingEntityBuilder) {
        this.renderer = livingEntityBuilder;
        this.renderer.mI = this;
    }

    public static Set getNamespacedIdsInRegistry() {
        return LivingEntityRegistry.db().lJ.keySet();
    }

    public static boolean isInRegistry(String string) {
        return LivingEntityRegistry.db().lJ.containsKey(string);
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
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!LivingEntityRegistry.db().lJ.containsKey(string)) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(string, location, bl, bl2, bl3);
        if (livingEntityBuilder == null) {
            return null;
        }
        return new CustomEntity(livingEntityBuilder);
    }

    @Nullable
    public static CustomEntity spawn(String string, Location location, List list, boolean bl, boolean bl2, boolean bl3, @Nullable Consumer consumer) {
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!LivingEntityRegistry.db().lJ.containsKey(string)) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(string, location, null, list, bl, bl2, bl3, consumer);
        if (livingEntityBuilder == null) {
            return null;
        }
        return new CustomEntity(livingEntityBuilder);
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
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!LivingEntityRegistry.db().lJ.containsKey(string)) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(string, null, livingEntity, bl, bl4, bl2, bl3);
        if (livingEntityBuilder == null) {
            return null;
        }
        return new CustomEntity(livingEntityBuilder);
    }

    @Nullable
    public static CustomEntity convert(String string, LivingEntity livingEntity, List list, boolean bl) {
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        if (!LivingEntityRegistry.db().lJ.containsKey(string)) {
            return null;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().a(string, null, livingEntity, list, bl, true);
        if (livingEntityBuilder == null) {
            return null;
        }
        return new CustomEntity(livingEntityBuilder);
    }

    @Nullable
    public static CustomEntity byAlreadySpawned(Entity entity) {
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        if (livingEntityBuilder == null) {
            return null;
        }
        return new CustomEntity(livingEntityBuilder);
    }

    public static boolean isCustomEntity(Entity entity) {
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        return LivingEntityRegistry.db().f(entity);
    }

    public static boolean isCustomEntity(UUID uUID) {
        if (!LivingEntityRegistry.P()) {
            throw new RuntimeException(EXCEPTION);
        }
        return LivingEntityRegistry.db().d(uUID);
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
        for (PlayerBridge_7 playerBridge_7 : this.renderer.ea()) {
            if (!playerBridge_7.iW.equals((Object)player)) continue;
            this.renderer.removeViewer(player);
            this.renderer.c(playerBridge_7);
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
        SoundCategoryBridge_2 soundCategoryBridge_2 = this.renderer.ar(string);
        if (soundCategoryBridge_2 == null) {
            return false;
        }
        this.renderer.ec().b(soundCategoryBridge_2, 0, runnable);
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
        EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().lJ.get(string);
        if (entityTypeBarStyleHolder == null) {
            throw new NullPointerException("Can't find custom entity '" + string + "' in config files.");
        }
        return entityTypeBarStyleHolder.nO.pB.containsKey(string2);
    }

    public boolean hasAnimation(String string) {
        return this.renderer.et().pB.containsKey(string);
    }

    public static List getAnimationsNames(String string) {
        EntityTypeBarStyleHolder entityTypeBarStyleHolder = (EntityTypeBarStyleHolder)LivingEntityRegistry.db().lJ.get(string);
        if (entityTypeBarStyleHolder == null) {
            throw new NullPointerException("Can't find custom entity '" + string + "' in config files.");
        }
        return entityTypeBarStyleHolder.nO.getAnimationsNames();
    }

    public List getAnimationsNames() {
        return this.renderer.et().getAnimationsNames();
    }

    public void destroy() {
        LivingEntityRegistry.db().a(this.renderer, true, false);
    }

    public void playDamageEffect(boolean bl) {
        this.renderer.playDamageEffect(bl);
    }

    public void setColorAllBones(int n) {
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            if (((LocationHolder_2)entry.getValue()).qw == null) continue;
            ((LocationHolder_2)entry.getValue()).qw.setColor(n);
            ((LocationHolder_2)entry.getValue()).gB();
        }
    }

    public void setEnchantedAllBones(boolean bl) {
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            if (((LocationHolder_2)entry.getValue()).qw == null) continue;
            ((LocationHolder_2)entry.getValue()).qw.setEnchanted(bl);
            ((LocationHolder_2)entry.getValue()).gB();
        }
    }

    public boolean hasMountBones() {
        return this.renderer.eE();
    }

    public boolean addPassenger(LivingEntity livingEntity) {
        if (!this.renderer.eE()) {
            return false;
        }
        return LivingEntityRegistry.db().a(livingEntity, this.renderer);
    }

    public static void removePassenger(LivingEntity livingEntity) {
        LivingEntityRegistry.db().removePassenger(livingEntity);
    }

    public Set getPassengers() {
        HashSet<LivingEntity> hashSet = new HashSet<LivingEntity>();
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.renderer.mZ) {
            if (!livingEntityArmorStandHolder.gG()) continue;
            hashSet.add(livingEntityArmorStandHolder.qR);
        }
        return hashSet;
    }

    public boolean hasPassenger(LivingEntity livingEntity) {
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.renderer.mZ) {
            if (!livingEntityArmorStandHolder.gG() || livingEntityArmorStandHolder.qR != livingEntity) continue;
            return true;
        }
        return false;
    }

    public boolean hasPassenger() {
        for (LivingEntityArmorStandHolder livingEntityArmorStandHolder : this.renderer.mZ) {
            if (!livingEntityArmorStandHolder.gG()) continue;
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
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = (LivingEntityArmorStandHolder)list.get(n);
        if (livingEntityArmorStandHolder == null) {
            return false;
        }
        if (livingEntityArmorStandHolder.gG()) {
            LivingEntityRegistry.db().removePassenger(livingEntityArmorStandHolder.qR);
        }
        return LivingEntityRegistry.db().a(livingEntity, livingEntityArmorStandHolder);
    }

    public Set getBones() {
        HashSet<CustomEntity$Bone> hashSet = new HashSet<CustomEntity$Bone>();
        int n = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            LocationHolder_2 locationHolder_2 = (LocationHolder_2)entry.getValue();
            hashSet.add(CustomEntity$Bone.wrap(locationHolder_2, n));
            ++n;
        }
        return hashSet;
    }

    public Set getMountBones() {
        HashSet<CustomEntity$MountBone> hashSet = new HashSet<CustomEntity$MountBone>();
        int n = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            LocationHolder_2 locationHolder_2 = (LocationHolder_2)entry.getValue();
            if (locationHolder_2.gD() != null) {
                hashSet.add((CustomEntity$MountBone)CustomEntity$Bone.wrap(locationHolder_2, n));
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
            LocationHolder_2 locationHolder_2 = (LocationHolder_2)entry.getValue();
            if (n2 == n) {
                return CustomEntity$Bone.wrap(locationHolder_2, n2);
            }
            ++n2;
        }
        throw new IndexOutOfBoundsException("There is no bone with such index");
    }

    @Nullable
    public CustomEntity$Bone getBone(String string) {
        int n = 0;
        for (Map.Entry entry : this.renderer.na.entrySet()) {
            LocationHolder_2 locationHolder_2 = (LocationHolder_2)entry.getValue();
            if (!locationHolder_2.qx.getId().equals(string)) continue;
            return CustomEntity$Bone.wrap(locationHolder_2, n);
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

    public void internal_changeWrappedCustomEntity(LivingEntityBuilder livingEntityBuilder) {
        this.renderer = livingEntityBuilder;
        livingEntityBuilder.mI = this;
    }

    public List getLoot() {
        return this.getLoot(null);
    }

    public List getLoot(@Nullable ItemStack itemStack) {
        return CustomEntity.getLoot(this.renderer.eg(), itemStack);
    }

    public static List getLoot(LivingEntity livingEntity, @Nullable ItemStack itemStack) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h((Entity)livingEntity);
        if (livingEntityBuilder == null) {
            return new ArrayList();
        }
        return CustomEntity.getLoot0(livingEntityBuilder, itemStack);
    }

    private static List getLoot0(LivingEntityBuilder livingEntityBuilder, @Nullable ItemStack itemStack) {
        ArrayList arrayList = new ArrayList();
        @Nullable List list = ItemStackRegistry.g().aq.m(livingEntityBuilder);
        if (list != null) {
            for (Opaque136 opaque136 : list) {
                arrayList.addAll(opaque136.N(itemStack));
            }
        }
        return arrayList;
    }
}
