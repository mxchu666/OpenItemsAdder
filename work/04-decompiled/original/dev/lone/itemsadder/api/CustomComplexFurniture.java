package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.bay;
import itemsadder.m.d;
import itemsadder.m.jn;
import itemsadder.m.jp;
import itemsadder.m.qm;
import java.util.HashSet;
import java.util.Set;
import lombok.Generated;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class CustomComplexFurniture {
    private static final Set EMPTY_SET = new HashSet();
    private final jp internal;
    private final CustomEntity customEntity;

    public CustomComplexFurniture(jp jp2) {
        this.internal = jp2;
        this.customEntity = new CustomEntity(jp2.kD());
    }

    public static Set getNamespacedIdsInRegistry() {
        Set set = d.g().d("complex_furniture");
        if (set == null) {
            return EMPTY_SET;
        }
        return set;
    }

    @Nullable
    public static CustomComplexFurniture byAlreadySpawned(LivingEntity livingEntity) {
        jp jp2 = jn.g(livingEntity);
        if (jp2 == null) {
            return null;
        }
        return new CustomComplexFurniture(jp2);
    }

    @Nullable
    public static CustomComplexFurniture byAlreadySpawned(Block block) {
        for (Entity entity : block.getLocation().getWorld().getNearbyEntities(block.getLocation().add(0.5, 0.5, 0.5), 0.1, 0.1, 0.1)) {
            LivingEntity livingEntity;
            jp jp2;
            if (!(entity instanceof LivingEntity) || (jp2 = jn.g(livingEntity = (LivingEntity)entity)) == null) continue;
            return new CustomComplexFurniture(jp2);
        }
        return null;
    }

    @Nullable
    public static CustomComplexFurniture spawn(String string, Location location, BlockFace blockFace, boolean bl) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            return null;
        }
        jn jn2 = (jn)qm2.Ge.bn("complex_furniture");
        if (jn2 == null) {
            return null;
        }
        jp jp2 = jn2.a(null, qm2, null, location, blockFace, bl);
        if (jp2 == null) {
            return null;
        }
        return new CustomComplexFurniture(jp2);
    }

    public void remove(boolean bl) {
        CustomComplexFurniture.remove(this.internal.kD().eh(), bl);
    }

    public static void remove(LivingEntity livingEntity, boolean bl) {
        if (livingEntity == null) {
            return;
        }
        jp jp2 = jn.g(livingEntity);
        if (jp2 == null) {
            return;
        }
        jp2.remove();
    }

    public void teleport(Entity entity) {
        this.teleport(entity.getLocation());
    }

    public void teleport(Location location) {
        jn.a(this.internal);
        this.internal.kD().teleport(location);
    }

    public void setColor(Color color) {
        this.customEntity.setColorAllBones(color.asRGB());
    }

    @Nullable
    public Integer getOriginalLightLevel() {
        return this.internal.kF().xI;
    }

    @Nullable
    public Boolean getOriginalIsSolid() {
        return this.internal.kF().xJ;
    }

    public void setCurrentLightLevel(int n) {
        bay.bk(this.getEntity().getLocation().getBlock());
        bay.d(this.getEntity().getLocation().getBlock(), n);
    }

    public LivingEntity getEntity() {
        return (LivingEntity)this.customEntity.getEntity();
    }

    @Generated
    public CustomEntity getCustomEntity() {
        return this.customEntity;
    }
}
