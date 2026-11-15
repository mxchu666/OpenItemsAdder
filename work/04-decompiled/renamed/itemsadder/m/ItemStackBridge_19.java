package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_19
extends Builder_14 {
    public final int CU;

    public ItemStackBridge_19(int n) {
        this.CU = n;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStack.setAmount(itemStack.getAmount() + this.CU);
        player.updateInventory();
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileLaunchEvent projectileLaunchEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR || itemStack.getAmount() <= 0) {
            return ItemStackBuilder_3.mk();
        }
        return ItemStackBuilder_3.mk();
    }
}
