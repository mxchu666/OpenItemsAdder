package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import itemsadder.m.PacketContainerHelper;
import org.bukkit.Location;
import org.bukkit.World;

public class BlockPositionHelper
extends PacketContainerHelper {
    public static final PacketType amb = PacketType.Play.Server.BLOCK_CHANGE;

    public BlockPositionHelper() {
        super(new PacketContainer(amb), amb);
        this.alU.getModifier().writeDefaults();
    }

    public BlockPositionHelper(PacketContainer packetContainer) {
        super(packetContainer, amb);
    }

    public BlockPosition va() {
        return (BlockPosition)this.alU.getBlockPositionModifier().read(0);
    }

    public void b(BlockPosition blockPosition) {
        this.alU.getBlockPositionModifier().write(0, (Object)blockPosition);
    }

    public Location q(World world) {
        return this.va().toVector().toLocation(world);
    }

    public WrappedBlockData vb() {
        return (WrappedBlockData)this.alU.getBlockData().read(0);
    }

    public void a(WrappedBlockData wrappedBlockData) {
        this.alU.getBlockData().write(0, (Object)wrappedBlockData);
    }
}
