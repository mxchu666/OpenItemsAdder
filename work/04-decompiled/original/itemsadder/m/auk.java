package itemsadder.m;

import io.netty.buffer.Unpooled;
import itemsadder.m.aow;
import itemsadder.m.aox;
import itemsadder.m.aui;
import itemsadder.m.bcz;
import itemsadder.m.do;
import java.util.List;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R1.CraftWorld;
import org.bukkit.entity.Player;

public class auk
extends aui {
    private final Display.ItemDisplay anI;

    public auk(Location location) {
        this.anG = new bcz(location.getX(), location.getY() + 0.35, location.getZ());
        WorldServer worldServer = ((CraftWorld)location.getWorld()).getHandle();
        this.anI = new Display.ItemDisplay(EntityTypes.ah, (World)worldServer);
        this.anI.a_(this.anG.akd, this.anG.ake, this.anG.akf);
        this.anI.u(-90.0f);
        this.anI.c(0.5f);
        this.anI.ar().a(Display.s, (Object)1);
    }

    @Override
    public void B(List list) {
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = new PacketPlayOutSpawnEntity(this.anI.an(), this.anI.cz(), this.anI.dn().a(), this.anI.dn().b(), this.anI.dn().c(), this.anI.dG(), this.anI.ct(), this.anI.am(), 0, this.anI.dr(), (double)this.anI.ct());
        PacketPlayOutEntityMetadata packetPlayOutEntityMetadata = new PacketPlayOutEntityMetadata(this.anI.an(), this.anI.ar().c());
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_.iW, (Packet)packetPlayOutSpawnEntity);
            this.a(do_.iW, (Packet)packetPlayOutEntityMetadata);
        }
    }

    @Override
    public void C(List list) {
        PacketPlayOutEntityDestroy packetPlayOutEntityDestroy = new PacketPlayOutEntityDestroy(new int[]{this.anI.an()});
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
            packetDataSerializer.k(aox.aku);
            packetDataSerializer.c(this.anI.an());
            packetDataSerializer.a(d);
            packetDataSerializer.a(d2 + 0.35);
            packetDataSerializer.a(d3);
            packetDataSerializer.k(0);
            packetDataSerializer.k(0);
            packetDataSerializer.a(false);
            aow.c(do_.iW, packetDataSerializer);
        }
    }

    public void a(Player player, Packet packet) {
        aow.uN().d(player, packet);
    }
}
