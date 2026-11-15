package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketListener;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityDamageListenerBase;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_8;
import itemsadder.m.PlayerLocationHolder;
import itemsadder.m.VersionHelper_3;
import java.lang.invoke.MethodHandle;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import net.kyori.adventure.text.Component;
import net.minecraft.Optionull;
import net.minecraft.commands.arguments.ArgumentAnchor;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.chat.RemoteChatSession;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.PacketPlayInFlying;
import net.minecraft.network.protocol.game.PacketPlayOutCamera;
import net.minecraft.network.protocol.game.PacketPlayOutEntity;
import net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy;
import net.minecraft.network.protocol.game.PacketPlayOutEntityHeadRotation;
import net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata;
import net.minecraft.network.protocol.game.PacketPlayOutEntityTeleport;
import net.minecraft.network.protocol.game.PacketPlayOutGameStateChange;
import net.minecraft.network.protocol.game.PacketPlayOutMount;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.level.EnumGamemode;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_21_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class BlockNms_1_21_4_17
extends EntityDamageListenerBase {
    static MethodHandle ajr = VersionHelper_3.a(PacketPlayOutMount.class, new Class[]{PacketDataSerializer.class});

    public static Object i(Object object) {
        try {
            return ajr.invokeExact((PacketDataSerializer)object);
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    @Override
    protected void um() {
        for (Map.Entry entry : this.ajl.entrySet()) {
            this.a((PlayerLocationHolder)entry.getValue());
        }
        PacketListenerRegistry.l(this);
    }

    @Override
    protected void au() {
        ListenerBridge.a(this);
        PacketListenerRegistry.a((PacketListener)new PacketListener_8(this, PacketListenerRegistry.uO().types(new PacketType[]{PacketListenerRegistry.o(PacketPlayInFlying.PacketPlayInPositionLook.class), PacketListenerRegistry.o(PacketPlayInFlying.PacketPlayInPosition.class), PacketListenerRegistry.o(PacketPlayInFlying.PacketPlayInLook.class)}).optionAsync()));
    }

    @Override
    public boolean i(Player player, Location location) {
        if (BlockNms_1_21_4_17.bU(player)) {
            return false;
        }
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        EntityZombie entityZombie = new EntityZombie(EntityTypes.bN, entityPlayer.dV());
        Location location2 = player.getLocation().add(player.getLocation().getDirection().normalize().multiply(-3.0));
        entityZombie.o(location2.getX(), location2.getY(), location2.getZ());
        entityZombie.f(true);
        entityZombie.n(true);
        entityZombie.k(true);
        Vec3D vec3D = new Vec3D(location.getX(), location.getY(), location.getZ());
        double d = vec3D.d - entityZombie.dA();
        double d2 = vec3D.f - entityZombie.dG();
        double d3 = vec3D.e - (entityZombie.dC() + (double)entityZombie.cS());
        float f = (float)(Math.toDegrees(Math.atan2(d2, d)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, Math.sqrt(d * d + d2 * d2))));
        entityZombie.v(f);
        entityZombie.w(f2);
        entityZombie.q(f);
        entityZombie.a(ArgumentAnchor.Anchor.b, vec3D);
        this.a(entityZombie, player);
        PlayerLocationHolder playerLocationHolder = new PlayerLocationHolder(player, player.getEyeLocation(), (Entity)entityZombie.getBukkitEntity(), player.getLocation().clone());
        this.ajl.put((Object)player, (Object)playerLocationHolder);
        entityPlayer.f.b((Packet)new PacketPlayOutEntityTeleport(entityPlayer.ar(), new PositionMoveRotation(new Vec3D(entityZombie.dA(), entityZombie.dC(), entityZombie.dG()), Vec3D.c, entityZombie.dL(), entityZombie.dN()), Set.of(), false));
        entityPlayer.f.b((Packet)new PacketPlayOutEntity.PacketPlayOutEntityLook(entityZombie.ar(), MathHelper.g((float)entityZombie.dL()), MathHelper.g((float)entityZombie.dN()), false));
        entityPlayer.f.b((Packet)new PacketPlayOutEntityHeadRotation((net.minecraft.world.entity.Entity)entityZombie, MathHelper.g((float)entityZombie.dL())));
        entityPlayer.f.b((Packet)new PacketPlayOutCamera((net.minecraft.world.entity.Entity)entityZombie));
        int[] nArray = new int[]{entityPlayer.ar()};
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.buffer());
        packetDataSerializer.c(entityZombie.ar());
        packetDataSerializer.a(nArray);
        PacketPlayOutMount packetPlayOutMount = (PacketPlayOutMount)BlockNms_1_21_4_17.i(packetDataSerializer);
        entityPlayer.f.b((Packet)packetPlayOutMount);
        entityPlayer.f.b((Packet)new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.e, (float)EnumGamemode.d.a()));
        player.sendActionBar((Component)Component.text((String)"Press SHIFT to exit"));
        return true;
    }

    @Override
    protected void a(PlayerLocationHolder playerLocationHolder) {
        Player player = playerLocationHolder.un();
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = ((CraftEntity)playerLocationHolder.up()).getHandle();
        PacketPlayOutCamera packetPlayOutCamera = new PacketPlayOutCamera((net.minecraft.world.entity.Entity)entityPlayer);
        entityPlayer.f.b((Packet)packetPlayOutCamera);
        this.b(player, entity.ar());
        entityPlayer.f.b((Packet)new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.e, (float)entityPlayer.h.b().a()));
        entityPlayer.f.b((Packet)new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.a.c), new ClientboundPlayerInfoUpdatePacket.b(entityPlayer.cG(), entityPlayer.gh(), true, entityPlayer.f.k(), entityPlayer.h.b(), entityPlayer.O(), entityPlayer.a(PlayerModelPart.g), entityPlayer.P(), (RemoteChatSession.a)Optionull.a((Object)entityPlayer.ad(), RemoteChatSession::a))));
        this.ajl.remove((Object)player);
        if (player.getWorld().equals((Object)playerLocationHolder.uq().getWorld())) {
            BukkitTaskBridge.b((Entity)player, playerLocationHolder.uq());
        }
    }

    @Override
    public void a(Object object, Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        net.minecraft.world.entity.Entity entity = (net.minecraft.world.entity.Entity)object;
        entityPlayer.f.b((Packet)new PacketPlayOutSpawnEntity(entity.ar(), entity.cG(), entity.du().a(), entity.du().b(), entity.du().c(), entity.dN(), entity.dL(), entity.aq(), 0, entity.dy(), (double)entity.cA()));
        entityPlayer.f.b((Packet)new PacketPlayOutEntityMetadata(entity.ar(), entity.au().c()));
    }

    @Override
    public void b(Player player, int ... nArray) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.f.b((Packet)new PacketPlayOutEntityDestroy(nArray));
    }

    static /* synthetic */ Object2ObjectOpenHashMap a(BlockNms_1_21_4_17 blockNms_1_21_4_17) {
        return blockNms_1_21_4_17.ajl;
    }

    static /* synthetic */ float y(float f) {
        return BlockNms_1_21_4_17.s(f);
    }

    static /* synthetic */ float z(float f) {
        return BlockNms_1_21_4_17.s(f);
    }

    static /* synthetic */ Location b(Location location, float f, float f2) {
        return BlockNms_1_21_4_17.a(location, f, f2);
    }
}
