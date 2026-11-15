package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BoolLongBlockData;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Error;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerJoinListener_5;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

class BlockChangedAckPacketListener
extends PacketAdapter {
    final /* synthetic */ PlayerJoinListener_5 Be;

    BlockChangedAckPacketListener(PlayerJoinListener_5 playerJoinListener_5, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Be = playerJoinListener_5;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        boolean bl;
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (!ItemStackRegistry.g().k()) {
            packetEvent.setCancelled(true);
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        EnumWrappers.PlayerDigType playerDigType = PacketListenerRegistry.uN().d(packetContainer);
        CommandSenderBridge_5.iA("Action " + String.valueOf(playerDigType));
        if (!PacketListenerRegistry.a(playerDigType)) {
            return;
        }
        Block block = ((BlockPosition)packetContainer.getBlockPositionModifier().read(0)).toLocation(player.getWorld()).getBlock();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        try {
            bl = blockBridge_9.F(block.getLocation());
        }
        catch (Error error) {
            packetEvent.setCancelled(true);
            return;
        }
        if (bl) {
            packetEvent.setCancelled(true);
            PacketContainer packetContainer2 = new PacketContainer(PacketType.Play.Server.BLOCK_CHANGED_ACK);
            packetContainer2.getIntegers().write(0, (Object)((Integer)packetContainer.getIntegers().read(0)));
            PacketListenerRegistry.a(player, packetContainer2);
            this.Be.aP(player);
            switch (playerDigType) {
                case START_DESTROY_BLOCK: {
                    this.Be.a(blockBridge_9, player, block);
                    break;
                }
                case ABORT_DESTROY_BLOCK: 
                case STOP_DESTROY_BLOCK: {
                    this.Be.aN(player);
                }
            }
        } else {
            BoolLongBlockData boolLongBlockData = this.Be.aM(player);
            switch (playerDigType) {
                case START_DESTROY_BLOCK: {
                    if (boolLongBlockData.Bj != null) {
                        boolLongBlockData.Bj.cancel();
                        boolLongBlockData.Bj = null;
                    }
                    this.Be.aO(player);
                    break;
                }
                case ABORT_DESTROY_BLOCK: 
                case STOP_DESTROY_BLOCK: {
                    boolLongBlockData.Bj = Bukkit.getScheduler().runTaskLater(Main.rT(), () -> {
                        boolLongBlockData.Bj = null;
                        if (this.Be.aQ(player)) {
                            return;
                        }
                        this.Be.a(player, 1.0f);
                    }, 3L);
                }
            }
        }
    }
}
