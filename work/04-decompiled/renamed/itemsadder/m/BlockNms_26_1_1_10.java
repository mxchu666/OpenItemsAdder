package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import itemsadder.m.PlayerHolder;
import itemsadder.m.PlayerWrapper_2;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Abilities;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BlockNms_26_1_1_10
implements PlayerWrapper_2 {
    @Override
    public void c(Player player, float f) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE);
        packetContainer.getSpecificModifier(ClientboundGameEventPacket.Type.class).write(0, (Object)ClientboundGameEventPacket.CHANGE_GAME_MODE);
        packetContainer.getFloat().write(0, (Object)Float.valueOf(f));
        PlayerHolder.b(player, packetContainer);
    }

    @Override
    public void bS(Player player) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.onUpdateAbilities();
    }

    @Override
    public void a(Player player, boolean bl, boolean bl2, float f) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        Abilities abilities = serverPlayer.getAbilities();
        Abilities abilities2 = new Abilities();
        abilities2.flying = bl2;
        abilities2.mayfly = bl;
        abilities2.flyingSpeed = f;
        abilities2.instabuild = abilities.instabuild;
        abilities2.invulnerable = abilities.invulnerable;
        abilities2.walkingSpeed = abilities.walkingSpeed;
        serverPlayer.connection.send((Packet)new ClientboundPlayerAbilitiesPacket(abilities2));
    }
}
