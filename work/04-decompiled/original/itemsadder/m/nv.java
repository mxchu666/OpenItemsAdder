package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class nv
extends ou {
    public final int CU;

    public nv(int n) {
        this.CU = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        itemStack.setAmount(itemStack.getAmount() + this.CU);
        player.updateInventory();
        return pa.ml();
    }

    @Override
    public pa a(ProjectileLaunchEvent projectileLaunchEvent, qm qm2, ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR || itemStack.getAmount() <= 0) {
            return pa.mk();
        }
        return pa.mk();
    }
}
