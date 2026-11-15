package itemsadder.m;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HandlerListItemStackHolder
extends EntityEvent
implements Cancellable {
    private static final HandlerList SN = new HandlerList();
    private final ItemStack SO;
    private final ItemStack SP;
    private Entity SQ;
    private final EquipmentSlot SR;
    private final float SS;
    private boolean ST;
    private boolean cancelled;

    public HandlerListItemStackHolder(@NotNull LivingEntity livingEntity, @Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, @NotNull Entity entity, @NotNull EquipmentSlot equipmentSlot, float f, boolean bl) {
        super((Entity)livingEntity);
        this.SO = itemStack;
        this.SP = itemStack2;
        this.SQ = entity;
        this.SR = equipmentSlot;
        this.SS = f;
        this.ST = bl;
    }

    @NotNull
    public LivingEntity getEntity() {
        return (LivingEntity)this.entity;
    }

    @Nullable
    public ItemStack sx() {
        return this.SO;
    }

    @Nullable
    public ItemStack sy() {
        return this.SP;
    }

    @NotNull
    public Entity sz() {
        return this.SQ;
    }

    public void J(@NotNull Entity entity) {
        this.SQ = entity;
    }

    @NotNull
    public EquipmentSlot getHand() {
        return this.SR;
    }

    public float sA() {
        return this.SS;
    }

    public void aG(boolean bl) {
        this.ST = bl;
    }

    public boolean sB() {
        return this.ST;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean bl) {
        this.cancelled = bl;
    }

    @NotNull
    public HandlerList getHandlers() {
        return SN;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return SN;
    }
}
