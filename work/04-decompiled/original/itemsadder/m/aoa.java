package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketListener;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.ana;
import itemsadder.m.anb;
import itemsadder.m.aob;
import itemsadder.m.aow;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.zw;
import java.lang.invoke.MethodHandle;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import net.kyori.adventure.text.Component;
import net.minecraft.Optionull;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.RemoteChatSession;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.network.protocol.game.ClientboundSetCameraPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class aoa
extends ana {
    static MethodHandle ajr = zw.a(ClientboundSetPassengersPacket.class, new Class[]{FriendlyByteBuf.class});

    public static Object i(Object object) {
        try {
            return ajr.invokeExact((FriendlyByteBuf)object);
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    @Override
    protected void um() {
        for (Map.Entry entry : this.ajl.entrySet()) {
            this.a((anb)entry.getValue());
        }
        aow.l(this);
    }

    @Override
    protected void au() {
        bev.a(this);
        aow.a((PacketListener)new aob(this, aow.uO().types(new PacketType[]{aow.o(ServerboundMovePlayerPacket.PosRot.class), aow.o(ServerboundMovePlayerPacket.Pos.class), aow.o(ServerboundMovePlayerPacket.Rot.class)}).optionAsync()));
    }

    @Override
    public boolean i(Player player, Location location) {
        if (aoa.bU(player)) {
            return false;
        }
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        Zombie zombie = new Zombie(EntityTypes.ZOMBIE, (Level)serverPlayer.level());
        Location location2 = player.getLocation().add(player.getLocation().getDirection().normalize().multiply(-3.0));
        zombie.setPosRaw(location2.getX(), location2.getY(), location2.getZ());
        zombie.setNoGravity(true);
        zombie.setInvulnerable(true);
        zombie.setInvisible(true);
        Vec3 vec3 = new Vec3(location.getX(), location.getY(), location.getZ());
        double d = vec3.x - zombie.getX();
        double d2 = vec3.z - zombie.getZ();
        double d3 = vec3.y - (zombie.getY() + (double)zombie.getEyeHeight());
        float f = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        zombie.setYRot(f);
        zombie.setXRot(f2);
        zombie.setYHeadRot(f);
        zombie.lookAt(EntityAnchorArgument.Anchor.EYES, vec3);
        this.a(zombie, player);
        anb anb2 = new anb(player, player.getEyeLocation(), (Entity)zombie.getBukkitEntity(), player.getLocation().clone());
        this.ajl.put((Object)player, (Object)anb2);
        serverPlayer.connection.send((Packet)new ClientboundTeleportEntityPacket(serverPlayer.getId(), new PositionMoveRotation(new Vec3(zombie.getX(), zombie.getY(), zombie.getZ()), Vec3.ZERO, zombie.getYRot(), zombie.getXRot()), Set.of(), false));
        serverPlayer.connection.send((Packet)new ClientboundMoveEntityPacket.Rot(zombie.getId(), Mth.packDegrees((float)zombie.getYRot()), Mth.packDegrees((float)zombie.getXRot()), false));
        serverPlayer.connection.send((Packet)new ClientboundRotateHeadPacket((net.minecraft.world.entity.Entity)zombie, Mth.packDegrees((float)zombie.getYRot())));
        serverPlayer.connection.send((Packet)new ClientboundSetCameraPacket((net.minecraft.world.entity.Entity)zombie));
        int[] nArray = new int[]{serverPlayer.getId()};
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer());
        friendlyByteBuf.writeVarInt(zombie.getId());
        friendlyByteBuf.writeVarIntArray(nArray);
        ClientboundSetPassengersPacket clientboundSetPassengersPacket = (ClientboundSetPassengersPacket)aoa.i(friendlyByteBuf);
        serverPlayer.connection.send((Packet)clientboundSetPassengersPacket);
        serverPlayer.connection.send((Packet)new ClientboundGameEventPacket(ClientboundGameEventPacket.CHANGE_GAME_MODE, (float)GameType.SPECTATOR.getId()));
        player.sendActionBar((Component)Component.text((String)"Press SHIFT to exit"));
        return true;
    }

    @Override
    protected void a(anb anb2) {
        Player player = anb2.un();
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = ((CraftEntity)anb2.up()).getHandle();
        ClientboundSetCameraPacket clientboundSetCameraPacket = new ClientboundSetCameraPacket((net.minecraft.world.entity.Entity)serverPlayer);
        serverPlayer.connection.send((Packet)clientboundSetCameraPacket);
        this.b(player, entity.getId());
        serverPlayer.connection.send((Packet)new ClientboundGameEventPacket(ClientboundGameEventPacket.CHANGE_GAME_MODE, (float)serverPlayer.gameMode.getGameModeForPlayer().getId()));
        serverPlayer.connection.send((Packet)new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.Action.UPDATE_GAME_MODE), new ClientboundPlayerInfoUpdatePacket.Entry(serverPlayer.getUUID(), serverPlayer.getGameProfile(), true, serverPlayer.connection.latency(), serverPlayer.gameMode(), serverPlayer.getTabListDisplayName(), serverPlayer.isModelPartShown(PlayerModelPart.HAT), serverPlayer.getTabListOrder(), (RemoteChatSession.Data)Optionull.map((Object)serverPlayer.getChatSession(), RemoteChatSession::asData))));
        this.ajl.remove((Object)player);
        if (player.getWorld().equals((Object)anb2.uq().getWorld())) {
            bcp.b((Entity)player, anb2.uq());
        }
    }

    @Override
    public void a(Object object, Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = (net.minecraft.world.entity.Entity)object;
        serverPlayer.connection.send((Packet)new ClientboundAddEntityPacket(entity.getId(), entity.getUUID(), entity.trackingPosition().x(), entity.trackingPosition().y(), entity.trackingPosition().z(), entity.getXRot(), entity.getYRot(), entity.getType(), 0, entity.getDeltaMovement(), (double)entity.getYHeadRot()));
        serverPlayer.connection.send((Packet)new ClientboundSetEntityDataPacket(entity.getId(), entity.getEntityData().getNonDefaultValues()));
    }

    @Override
    public void b(Player player, int ... nArray) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundRemoveEntitiesPacket(nArray));
    }

    static /* synthetic */ Object2ObjectOpenHashMap a(aoa aoa2) {
        return aoa2.ajl;
    }

    static /* synthetic */ float y(float f) {
        return aoa.s(f);
    }

    static /* synthetic */ float z(float f) {
        return aoa.s(f);
    }

    static /* synthetic */ Location b(Location location, float f, float f2) {
        return aoa.a(location, f, f2);
    }
}
