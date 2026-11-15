package itemsadder.m;

import io.netty.buffer.Unpooled;
import itemsadder.m.aow;
import itemsadder.m.aox;
import itemsadder.m.aui;
import itemsadder.m.bcz;
import itemsadder.m.do;
import java.util.List;
import java.util.Set;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.entity.Player;

public class aut
extends aui {
    private final Display.ItemDisplay anR;

    public aut(Location location) {
        this.anG = new bcz(location.getX(), location.getY() + 0.35, location.getZ());
        ServerLevel serverLevel = ((CraftWorld)location.getWorld()).getHandle();
        this.anR = new Display.ItemDisplay(EntityType.ITEM_DISPLAY, (Level)serverLevel);
        this.anR.setPos(this.anG.akd, this.anG.ake, this.anG.akf);
        this.anR.setXRot(-90.0f);
        this.anR.setShadowRadius(0.5f);
        this.anR.getEntityData().set(Display.DATA_POS_ROT_INTERPOLATION_DURATION_ID, (Object)1);
    }

    @Override
    public void B(List list) {
        ClientboundAddEntityPacket clientboundAddEntityPacket = new ClientboundAddEntityPacket(this.anR.getId(), this.anR.getUUID(), this.anR.trackingPosition().x(), this.anR.trackingPosition().y(), this.anR.trackingPosition().z(), this.anR.getXRot(), this.anR.getYHeadRot(), this.anR.getType(), 0, this.anR.getDeltaMovement(), (double)this.anR.getYHeadRot());
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(this.anR.getId(), this.anR.getEntityData().getNonDefaultValues());
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            if (!do_.fl()) continue;
            this.a(do_.iW, (Packet)clientboundAddEntityPacket);
            this.a(do_.iW, (Packet)clientboundSetEntityDataPacket);
        }
    }

    @Override
    public void C(List list) {
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(new int[]{this.anR.getId()});
        for (int i = 0; i < list.size(); ++i) {
            do do_ = (do)list.get(i);
            this.a(do_.iW, (Packet)clientboundRemoveEntitiesPacket);
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
            FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer((int)30));
            friendlyByteBuf.writeByte(aox.aku);
            friendlyByteBuf.writeVarInt(this.anR.getId());
            PositionMoveRotation.STREAM_CODEC.encode((Object)friendlyByteBuf, (Object)new PositionMoveRotation(new Vec3(d, d2 + 0.35, d3), Vec3.ZERO, 0.0f, 0.0f));
            Relative.SET_STREAM_CODEC.encode((Object)friendlyByteBuf, Set.of());
            friendlyByteBuf.writeBoolean(false);
            aow.c(do_.iW, friendlyByteBuf);
        }
    }

    public void a(Player player, Packet packet) {
        aow.uN().d(player, packet);
    }
}
