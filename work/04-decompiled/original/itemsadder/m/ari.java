package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.are;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class ari
extends are {
    public static final PacketType amc = PacketType.Play.Server.ENTITY_EQUIPMENT;

    public ari() {
        super(new PacketContainer(amc), amc);
        this.alU.getModifier().writeDefaults();
    }

    public ari(PacketContainer packetContainer) {
        super(packetContainer, amc);
    }

    public int vc() {
        return (Integer)this.alU.getIntegers().read(0);
    }

    public void aM(int n) {
        this.alU.getIntegers().write(0, (Object)n);
    }

    public Entity r(World world) {
        return (Entity)this.alU.getEntityModifier(world).read(0);
    }

    public Entity b(PacketEvent packetEvent) {
        return this.r(packetEvent.getPlayer().getWorld());
    }

    public EnumWrappers.ItemSlot vd() {
        return (EnumWrappers.ItemSlot)this.alU.getItemSlots().read(0);
    }

    public void a(EnumWrappers.ItemSlot itemSlot) {
        this.alU.getItemSlots().write(0, (Object)itemSlot);
    }

    public ItemStack getItem() {
        return (ItemStack)this.alU.getItemModifier().read(0);
    }

    public void ac(ItemStack itemStack) {
        this.alU.getItemModifier().write(0, (Object)itemStack);
    }
}
