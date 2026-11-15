package itemsadder.m;

import io.netty.buffer.Unpooled;
import itemsadder.m.GetPacketID;
import itemsadder.m.PacketContainerHelper_2;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.VectorBridge;
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

public class BlockNms_26_1_2_19
extends PacketContainerHelper_2 {
    private final Display.ItemDisplay anS;

    public BlockNms_26_1_2_19(Location location) {
        this.anG = new VectorBridge(location.getX(), location.getY() + 0.35, location.getZ());
        ServerLevel serverLevel = ((CraftWorld)location.getWorld()).getHandle();
        this.anS = new Display.ItemDisplay(EntityType.ITEM_DISPLAY, (Level)serverLevel);
        this.anS.setPos(this.anG.akd, this.anG.ake, this.anG.akf);
        this.anS.setXRot(-90.0f);
        this.anS.setShadowRadius(0.5f);
        this.anS.getEntityData().set(Display.DATA_POS_ROT_INTERPOLATION_DURATION_ID, (Object)1);
    }

    @Override
    public void B(List list) {
        ClientboundAddEntityPacket clientboundAddEntityPacket = new ClientboundAddEntityPacket(this.anS.getId(), this.anS.getUUID(), this.anS.trackingPosition().x(), this.anS.trackingPosition().y(), this.anS.trackingPosition().z(), this.anS.getXRot(), this.anS.getYHeadRot(), this.anS.getType(), 0, this.anS.getDeltaMovement(), (double)this.anS.getYHeadRot());
        ClientboundSetEntityDataPacket clientboundSetEntityDataPacket = new ClientboundSetEntityDataPacket(this.anS.getId(), this.anS.getEntityData().getNonDefaultValues());
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            if (!playerBridge_7.fl()) continue;
            this.a(playerBridge_7.iW, (Packet)clientboundAddEntityPacket);
            this.a(playerBridge_7.iW, (Packet)clientboundSetEntityDataPacket);
        }
    }

    @Override
    public void C(List list) {
        ClientboundRemoveEntitiesPacket clientboundRemoveEntitiesPacket = new ClientboundRemoveEntitiesPacket(new int[]{this.anS.getId()});
        for (int i = 0; i < list.size(); ++i) {
            PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(i);
            this.a(playerBridge_7.iW, (Packet)clientboundRemoveEntitiesPacket);
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
            FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer((int)30));
            friendlyByteBuf.writeByte(GetPacketID.aku);
            friendlyByteBuf.writeVarInt(this.anS.getId());
            PositionMoveRotation.STREAM_CODEC.encode((Object)friendlyByteBuf, (Object)new PositionMoveRotation(new Vec3(d, d2 + 0.35, d3), Vec3.ZERO, 0.0f, 0.0f));
            Relative.SET_STREAM_CODEC.encode((Object)friendlyByteBuf, Set.of());
            friendlyByteBuf.writeBoolean(false);
            PacketListenerRegistry.c(playerBridge_7.iW, friendlyByteBuf);
        }
    }

    public void a(Player player, Packet packet) {
        PacketListenerRegistry.uN().d(player, packet);
    }
}
