package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.aqp;
import itemsadder.m.ari;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class arj
extends ari {
    public static final PacketType amd = PacketType.Play.Server.ENTITY_EQUIPMENT;

    public arj() {
    }

    public arj(PacketContainer packetContainer) {
        super(packetContainer);
    }

    @Override
    public int vc() {
        return (Integer)this.alU.getIntegers().read(0);
    }

    @Override
    public void aM(int n) {
        this.alU.getIntegers().write(0, (Object)n);
    }

    @Override
    public Entity r(World world) {
        return (Entity)this.alU.getEntityModifier(world).read(0);
    }

    @Override
    public Entity b(PacketEvent packetEvent) {
        return this.r(packetEvent.getPlayer().getWorld());
    }

    @Override
    public ItemStack getItem() {
        return (ItemStack)this.alU.getItemModifier().read(0);
    }

    public void a(EnumWrappers.ItemSlot itemSlot, ItemStack itemStack) {
        aqp.uW().a(this.alU, itemSlot, itemStack);
    }
}
