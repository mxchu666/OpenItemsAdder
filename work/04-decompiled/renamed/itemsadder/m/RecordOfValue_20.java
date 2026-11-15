package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.PlayerBridge_16;
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

public final class RecordOfValue_20
extends Record {
    private final LivingEntityBuilder xV;
    private final ItemStackBuilder_4 xW;
    private final PlayerBridge_16 xX;

    public RecordOfValue_20(LivingEntityBuilder livingEntityBuilder, ItemStackBuilder_4 itemStackBuilder_4, PlayerBridge_16 playerBridge_16) {
        this.xV = livingEntityBuilder;
        this.xW = itemStackBuilder_4;
        this.xX = playerBridge_16;
    }

    public void as(Player player) {
        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(player.getEyeLocation(), player.getEyeLocation().getDirection(), 5.0, 0.1, entity -> entity.getEntityId() != player.getEntityId() && entity.getEntityId() == this.xV.eg().getEntityId());
        Vector vector = rayTraceResult != null ? rayTraceResult.getHitPosition() : new Vector(0, 0, 0);
        CommandSenderBridge_5.iA("Position: " + String.valueOf(vector));
        PlayerInteractAtEntityEvent playerInteractAtEntityEvent = new PlayerInteractAtEntityEvent(player, (Entity)this.xV.eg(), vector);
        this.xW.a((LivingEntity)player, BlockBreakEnum.PLACED_FURNITURE_INTERACT, builder_14 -> {
            ItemStack itemStack = this.xW.mP();
            return builder_14.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, this.xW, itemStack);
        });
    }

    public void remove() {
        BoundingBox boundingBox = this.xV.eg().getBoundingBox();
        PlayerBridge_16.a(this.xV.eg().getWorld(), boundingBox, false).forEach(location -> {
            Block block = location.getBlock();
            if (block.getType() == Material.BARRIER) {
                block.setType(Material.AIR);
            }
            BlockBridge_2.bk(block);
        });
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_20.class, "renderer;customItem;behaviour", "xV", "xW", "xX"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_20.class, "renderer;customItem;behaviour", "xV", "xW", "xX"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_20.class, "renderer;customItem;behaviour", "xV", "xW", "xX"}, this, object);
    }

    public LivingEntityBuilder kD() {
        return this.xV;
    }

    public ItemStackBuilder_4 kE() {
        return this.xW;
    }

    public PlayerBridge_16 kF() {
        return this.xX;
    }
}
