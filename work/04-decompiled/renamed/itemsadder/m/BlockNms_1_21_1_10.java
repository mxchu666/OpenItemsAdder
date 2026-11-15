package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import itemsadder.m.PlayerHolder;
import itemsadder.m.PlayerWrapper_2;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutAbilities;
import net.minecraft.network.protocol.game.PacketPlayOutGameStateChange;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.player.PlayerAbilities;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BlockNms_1_21_1_10
implements PlayerWrapper_2 {
    @Override
    public void c(Player player, float f) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE);
        packetContainer.getSpecificModifier(PacketPlayOutGameStateChange.a.class).write(0, (Object)PacketPlayOutGameStateChange.e);
        packetContainer.getFloat().write(0, (Object)Float.valueOf(f));
        PlayerHolder.b(player, packetContainer);
    }

    @Override
    public void bS(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.z();
    }

    @Override
    public void a(Player player, boolean bl, boolean bl2, float f) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PlayerAbilities playerAbilities = entityPlayer.fZ();
        PlayerAbilities playerAbilities2 = new PlayerAbilities();
        playerAbilities2.b = bl2;
        playerAbilities2.c = bl;
        playerAbilities2.f = f;
        playerAbilities2.d = playerAbilities.d;
        playerAbilities2.a = playerAbilities.a;
        playerAbilities2.g = playerAbilities.g;
        entityPlayer.c.b((Packet)new PacketPlayOutAbilities(playerAbilities2));
    }
}
