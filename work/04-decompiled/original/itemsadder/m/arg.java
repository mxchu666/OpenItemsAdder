package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;
import itemsadder.m.bce;
import java.util.Collection;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class arg {
    private static final long alX = 30000L;
    private static long alY;
    private final Collection alZ;
    private final Object2ObjectOpenHashMap ama = new Object2ObjectOpenHashMap();

    public arg(Collection collection) {
        this.alZ = collection;
    }

    public void a(Vector vector, WrappedBlockData wrappedBlockData) {
        this.a(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ(), wrappedBlockData);
    }

    public void a(int n, int n2, int n3, WrappedBlockData wrappedBlockData) {
        BlockPosition blockPosition = new BlockPosition(n >> 4, n2 >> 4, n3 >> 4);
        Short2ObjectOpenHashMap short2ObjectOpenHashMap = (Short2ObjectOpenHashMap)this.ama.computeIfAbsent((Object)blockPosition, object -> new Short2ObjectOpenHashMap());
        short2ObjectOpenHashMap.put(arg.k(n, n2, n3), (Object)wrappedBlockData);
    }

    private static short k(int n, int n2, int n3) {
        int n4 = n & 0xF;
        int n5 = n2 & 0xF;
        int n6 = n3 & 0xF;
        return (short)(n4 << 8 | n6 << 4 | n5);
    }

    public void uZ() {
        for (Map.Entry entry : this.ama.entrySet()) {
            PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.MULTI_BLOCK_CHANGE);
            packetContainer.getSectionPositions().write(0, (Object)((BlockPosition)entry.getKey()));
            int n = ((Short2ObjectOpenHashMap)entry.getValue()).size();
            WrappedBlockData[] wrappedBlockDataArray = new WrappedBlockData[n];
            short[] sArray = new short[n];
            int n2 = 0;
            for (Short2ObjectMap.Entry entry2 : ((Short2ObjectOpenHashMap)entry.getValue()).short2ObjectEntrySet()) {
                sArray[n2] = entry2.getShortKey();
                wrappedBlockDataArray[n2] = (WrappedBlockData)entry2.getValue();
                ++n2;
            }
            packetContainer.getBlockDataArrays().writeSafely(0, (Object)wrappedBlockDataArray);
            packetContainer.getShortArrays().writeSafely(0, (Object)sArray);
            packetContainer.setMeta("ignore", (Object)true);
            for (Short2ObjectMap.Entry entry2 : this.alZ) {
                try {
                    ProtocolLibrary.getProtocolManager().sendServerPacket((Player)entry2, packetContainer);
                }
                catch (Exception exception) {
                    arg.a(exception);
                }
            }
        }
    }

    private static synchronized void a(Exception exception) {
        long l = System.currentTimeMillis();
        if (l - alY < 30000L) {
            return;
        }
        alY = l;
        bce.error("Failed to send a multi block change packet.", exception);
    }
}
