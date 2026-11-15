package itemsadder.m;

import itemsadder.m.bay;
import itemsadder.m.bce;
import itemsadder.m.dn;
import itemsadder.m.jj;
import itemsadder.m.jn;
import itemsadder.m.qm;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public final class jp
extends Record {
    private final dn xV;
    private final qm xW;
    private final jn xX;

    public jp(dn dn2, qm qm2, jn jn2) {
        this.xV = dn2;
        this.xW = qm2;
        this.xX = jn2;
    }

    public void as(Player player) {
        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5.0, 0.1, entity -> entity.getEntityId() != player.getEntityId() && entity.getEntityId() == this.xV.eg().getEntityId());
        Vector vector = rayTraceResult != null ? rayTraceResult.getHitPosition() : new Vector(0, 0, 0);
        bce.iA("Position: " + String.valueOf(vector));
        PlayerInteractAtEntityEvent playerInteractAtEntityEvent = new PlayerInteractAtEntityEvent(player, (Entity)this.xV.eg(), vector);
        this.xW.a((LivingEntity)player, jj.PLACED_FURNITURE_INTERACT, ou2 -> {
            ItemStack itemStack = this.xW.mP();
            return ou2.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, this.xW, itemStack);
        });
    }

    public void remove() {
        BoundingBox boundingBox = this.xV.eg().getBoundingBox();
        jn.a(this.xV.eg().getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (block.getType() == Material.BARRIER) {
                block.setType(Material.AIR);
            }
            bay.bk(block);
        });
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{jp.class, "renderer;customItem;behaviour", "xV", "xW", "xX"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{jp.class, "renderer;customItem;behaviour", "xV", "xW", "xX"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{jp.class, "renderer;customItem;behaviour", "xV", "xW", "xX"}, this, object);
    }

    public dn kD() {
        return this.xV;
    }

    public qm kE() {
        return this.xW;
    }

    public jn kF() {
        return this.xX;
    }
}
