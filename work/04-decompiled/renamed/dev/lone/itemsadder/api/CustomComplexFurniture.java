package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_16;
import itemsadder.m.RecordOfValue_20;
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
    private final RecordOfValue_20 internal;
    private final CustomEntity customEntity;

    public CustomComplexFurniture(RecordOfValue_20 recordOfValue_20) {
        this.internal = recordOfValue_20;
        this.customEntity = new CustomEntity(recordOfValue_20.kD());
    }

    public static Set getNamespacedIdsInRegistry() {
        Set set = ItemStackRegistry.g().d("complex_furniture");
        if (set == null) {
            return EMPTY_SET;
        }
        return set;
    }

    @Nullable
    public static CustomComplexFurniture byAlreadySpawned(LivingEntity livingEntity) {
        RecordOfValue_20 recordOfValue_20 = PlayerBridge_16.g(livingEntity);
        if (recordOfValue_20 == null) {
            return null;
        }
        return new CustomComplexFurniture(recordOfValue_20);
    }

    @Nullable
    public static CustomComplexFurniture byAlreadySpawned(Block block) {
        for (Entity entity : block.getLocation().getWorld().getNearbyEntities(block.getLocation().add(0.5, 0.5, 0.5), 0.1, 0.1, 0.1)) {
            LivingEntity livingEntity;
            RecordOfValue_20 recordOfValue_20;
            if (!(entity instanceof LivingEntity) || (recordOfValue_20 = PlayerBridge_16.g(livingEntity = (LivingEntity)entity)) == null) continue;
            return new CustomComplexFurniture(recordOfValue_20);
        }
        return null;
    }

    @Nullable
    public static CustomComplexFurniture spawn(String string, Location location, BlockFace blockFace, boolean bl) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            return null;
        }
        PlayerBridge_16 playerBridge_16 = (PlayerBridge_16)itemStackBuilder_4.Ge.bn("complex_furniture");
        if (playerBridge_16 == null) {
            return null;
        }
        RecordOfValue_20 recordOfValue_20 = playerBridge_16.a(null, itemStackBuilder_4, null, location, blockFace, bl);
        if (recordOfValue_20 == null) {
            return null;
        }
        return new CustomComplexFurniture(recordOfValue_20);
    }

    public void remove(boolean bl) {
        CustomComplexFurniture.remove(this.internal.kD().eh(), bl);
    }

    public static void remove(LivingEntity livingEntity, boolean bl) {
        if (livingEntity == null) {
            return;
        }
        RecordOfValue_20 recordOfValue_20 = PlayerBridge_16.g(livingEntity);
        if (recordOfValue_20 == null) {
            return;
        }
        recordOfValue_20.remove();
    }

    public void teleport(Entity entity) {
        this.teleport(entity.getLocation());
    }

    public void teleport(Location location) {
        PlayerBridge_16.a(this.internal);
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
        BlockBridge_2.bk(this.getEntity().getLocation().getBlock());
        BlockBridge_2.d(this.getEntity().getLocation().getBlock(), n);
    }

    public LivingEntity getEntity() {
        return (LivingEntity)this.customEntity.getEntity();
    }

    @Generated
    public CustomEntity getCustomEntity() {
        return this.customEntity;
    }
}
