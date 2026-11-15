package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.are;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class ark
extends are {
    public static final PacketType ame = PacketType.Play.Server.MOUNT;

    public ark() {
        super(new PacketContainer(ame), ame);
        this.alU.getModifier().writeDefaults();
    }

    public ark(PacketContainer packetContainer) {
        super(packetContainer, ame);
    }

    public int vc() {
        return (Integer)this.alU.getIntegers().read(0);
    }

    public Entity r(World world) {
        return (Entity)this.alU.getEntityModifier(world).read(0);
    }

    public Entity b(PacketEvent packetEvent) {
        return this.r(packetEvent.getPlayer().getWorld());
    }

    public void aM(int n) {
        this.alU.getIntegers().write(0, (Object)n);
    }

    public int[] ve() {
        return (int[])this.alU.getIntegerArrays().read(0);
    }

    public void a(int[] nArray) {
        this.alU.getIntegerArrays().write(0, (Object)nArray);
    }

    public List c(PacketEvent packetEvent) {
        return this.s(packetEvent.getPlayer().getWorld());
    }

    public List s(World world) {
        int[] nArray = this.ve();
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        for (int n : nArray) {
            Entity entity = protocolManager.getEntityFromID(world, n);
            if (entity == null) continue;
            arrayList.add(entity);
        }
        return arrayList;
    }

    public void A(List list) {
        int[] nArray = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            nArray[i] = ((Entity)list.get(i)).getEntityId();
        }
        this.a(nArray);
    }
}
