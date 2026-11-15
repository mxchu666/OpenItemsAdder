package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PlayerBridge_24;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

class PlayerItemStackHolder {
    public final Player EA;
    public final BlockBreakEnum EB;
    public final BlockBreakEnum EC;
    @Nullable
    public final ItemStackBuilder_4 ED;
    @Nullable
    public final ItemStack EE;
    @Nullable
    public final ItemStackBuilder_4 EF;
    @Nullable
    public final ItemStack EG;

    public PlayerItemStackHolder(EquipmentSlot equipmentSlot, Player player, @Nullable ItemStackBuilder_4 itemStackBuilder_4, @Nullable ItemStackBuilder_4 itemStackBuilder_42) {
        if (ItemStackBridge_2.b(equipmentSlot)) {
            this.EB = BlockBreakEnum.WEAR;
            this.EC = BlockBreakEnum.UNWEAR;
        } else {
            switch (equipmentSlot) {
                case OFF_HAND: {
                    this.EB = BlockBreakEnum.HELD_OFFHAND;
                    this.EC = BlockBreakEnum.UNHELD_OFFHAND;
                    break;
                }
                default: {
                    this.EB = BlockBreakEnum.HELD;
                    this.EC = BlockBreakEnum.UNHELD;
                }
            }
        }
        this.EA = player;
        this.ED = itemStackBuilder_4;
        this.EE = itemStackBuilder_4 != null ? itemStackBuilder_4.mP() : null;
        this.EF = itemStackBuilder_42;
        this.EG = itemStackBuilder_42 != null ? itemStackBuilder_42.mP() : null;
    }

    public void run() {
        this.ms();
        this.mt();
    }

    void ms() {
        if (this.ED != null) {
            this.ED.a((LivingEntity)this.EA, this.EC, builder_14 -> builder_14.a(new PlayerBridge_24(this.EA), this.ED, this.EE));
        }
    }

    void mt() {
        if (this.EF != null) {
            this.EF.a((LivingEntity)this.EA, this.EB, builder_14 -> builder_14.a(new PlayerBridge_24(this.EA), this.EF, this.EG));
        }
    }
}
