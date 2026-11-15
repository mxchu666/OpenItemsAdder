package itemsadder.m;

import io.netty.buffer.Unpooled;
import itemsadder.m.aow;
import itemsadder.m.aox;
import itemsadder.m.aui;
import itemsadder.m.bcz;
import itemsadder.m.do;
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
import org.bukkit.craftbukkit.v1_21_R6.CraftWorld;
import org.bukkit.entity.Player;

public class aul
extends aui {
    private final Display.ItemDisplay anJ;

    public aul(Location location) {
        this.anG = new bcz(location.getX(), location.getY() + 0.35, location.getZ());
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        this.anJ = new Display.ItemDisplay(EntityTypes.av, (World)worldServer);
        this.anJ.a_(this.anG.akd, this.anG.ake, this.anG.akf);
        this.anJ.w(-90.0f);
        this.anJ.c(0.5f);
        this.anJ.aC().a(Display.r, (Object)1);
    }

    @Override
    public void B(List list) {
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = new PacketPlayOutSpawnEntity(this.anJ.az(), this.anJ.cT(), this.anJ.dE().a(), this.anJ.dE().b(), this.anJ.dE().c(), this.anJ.dZ(), this.anJ.cN(), this.anJ.ax(), 0, this.anJ.dI(), (double)this.anJ.cN());
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(this.anJ.az(), this.anJ.aC().c());
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_.iW, (Packet)packetPlayOutSpawnEntity);
            this.a(do_.iW, (Packet)packetPlayOutEntityMetadata);
        }
    }

    @Override
    public void C(List list) {
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[]{this.anJ.az()});
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            this.a(do_.iW, (Packet)packetPlayOutEntityDestroy);
        }
    }

    @Override
    public void a(double d, double d2, double d3, List list) {
        if (d == this.anG.akd && d2 == this.anG.ake && d3 == this.anG.akf) {
            return;
        }
        this.anG.i(d, d2, d3);
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl() || !do_.fn()) continue;
            PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer((int)30));
            packetDataSerializer.l(aox.aku);
            packetDataSerializer.c(this.anJ.az());
            PositionMoveRotation.a.encode((Object)packetDataSerializer, (Object)new PositionMoveRotation(new Vec3D(d, d2 + 0.35, d3), Vec3D.c, 0.0f, 0.0f));
            Relative.m.encode((Object)packetDataSerializer, Set.of());
            packetDataSerializer.a(false);
            aow.c(do_.iW, packetDataSerializer);
        }
    }

    public void a(Player player, Packet packet) {
        aow.uN().d(player, packet);
    }
}
