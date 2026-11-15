package itemsadder.m;

import io.netty.buffer.Unpooled;
import itemsadder.m.GetPacketID;
import itemsadder.m.PacketContainerHelper_2;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.VectorBridge;
import java.util.List;
import java.util.Set;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.level.World;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R3.CraftWorld;
import org.bukkit.entity.Player;

public class BlockNms_1_21_4_19
extends PacketContainerHelper_2 {
    private final Display.ItemDisplay anM;

    public BlockNms_1_21_4_19(Location location) {
        this.anG = new VectorBridge(location.getX(), location.getY() + 0.35, location.getZ());
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        this.anM = new Display.ItemDisplay(EntityTypes.ar, (World)worldServer);
        this.anM.a_(this.anG.akd, this.anG.ake, this.anG.akf);
        this.anM.w(-90.0f);
        this.anM.c(0.5f);
        this.anM.au().a(Display.r, (Object)1);
    }

    @Override
    public void B(List list) {
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = new PacketPlayOutSpawnEntity(this.anM.ar(), this.anM.cG(), this.anM.du().a(), this.anM.du().b(), this.anM.du().c(), this.anM.dN(), this.anM.cA(), this.anM.aq(), 0, this.anM.dy(), (double)this.anM.cA());
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(this.anM.ar(), this.anM.au().c());
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl()) continue;
            this.a(playerBridge_7.iW, (Packet)packetPlayOutSpawnEntity);
            this.a(playerBridge_7.iW, (Packet)packetPlayOutEntityMetadata);
        }
    }

    @Override
    public void C(List list) {
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[]{this.anM.ar()});
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            this.a(playerBridge_7.iW, (Packet)packetPlayOutEntityDestroy);
        }
    }

    @Override
    public void a(double d, double d2, double d3, List list) {
        if (d == this.anG.akd && d2 == this.anG.ake && d3 == this.anG.akf) {
            return;
        }
        this.anG.i(d, d2, d3);
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl() || !playerBridge_7.fn()) continue;
            PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer((int)30));
            packetDataSerializer.l(GetPacketID.aku);
            packetDataSerializer.c(this.anM.ar());
            PositionMoveRotation.a.encode((Object)packetDataSerializer, (Object)new PositionMoveRotation(new Vec3D(d, d2 + 0.35, d3), Vec3D.c, 0.0f, 0.0f));
            Relative.m.encode((Object)packetDataSerializer, Set.of());
            packetDataSerializer.a(false);
            PacketListenerRegistry.c(playerBridge_7.iW, packetDataSerializer);
        }
    }

    public void a(Player player, Packet packet) {
        PacketListenerRegistry.uN().d(player, packet);
    }
}
