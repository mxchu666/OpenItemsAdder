package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import itemsadder.m.PacketContainerHelper;
import org.bukkit.inventory.ItemStack;

public class PacketTypeHelper_2
extends PacketContainerHelper {
    public static final PacketType amf = PacketType.Play.Server.SET_SLOT;

    public PacketTypeHelper_2() {
        super(new PacketContainer(amf), amf);
        this.alU.getModifier().writeDefaults();
    }

    public PacketTypeHelper_2(PacketContainer packetContainer) {
        super(packetContainer, amf);
    }

    public int vf() {
        return (Integer)this.alU.getIntegers().read(0);
    }

    public void aN(int n) {
        this.alU.getIntegers().write(0, (Object)n);
    }

    public int sC() {
        return (Integer)this.alU.getIntegers().read(1);
    }

    public void aO(int n) {
        this.alU.getIntegers().write(1, (Object)n);
    }

    public ItemStack vg() {
        return (ItemStack)this.alU.getItemModifier().read(0);
    }

    public void ad(ItemStack itemStack) {
        this.alU.getItemModifier().write(0, (Object)itemStack);
    }
}
