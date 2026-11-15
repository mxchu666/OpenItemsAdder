package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import dev.lone.itemsadder.Main;
import itemsadder.m.aow;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.lw;
import itemsadder.m.lz;
import itemsadder.m.mo;
import itemsadder.m.ms;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

class lx
extends PacketAdapter {
    final /* synthetic */ lw Be;

    lx(lw lw2, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.Be = lw2;
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
        if (!d.g().k()) {
            packetEvent.setCancelled(true);
            return;
        }
        PacketContainer packetContainer = packetEvent.getPacket();
        EnumWrappers.PlayerDigType playerDigType = aow.uN().d(packetContainer);
        bce.iA("Action " + String.valueOf(playerDigType));
        if (!aow.a(playerDigType)) {
            return;
        }
        Block block = ((BlockPosition)packetContainer.getBlockPositionModifier().read(0)).toLocation(player.getWorld()).getBlock();
        ms ms2 = d.g().b(block);
        try {
            bl = ms2.F(block.getLocation());
        }
        catch (mo mo2) {
            packetEvent.setCancelled(true);
            return;
        }
        if (bl) {
            packetEvent.setCancelled(true);
            PacketContainer packetContainer2 = new PacketContainer(PacketType.Play.Server.BLOCK_CHANGED_ACK);
            packetContainer2.getIntegers().write(0, (Object)((Integer)packetContainer.getIntegers().read(0)));
            aow.a(player, packetContainer2);
            this.Be.aP(player);
            switch (playerDigType) {
                case START_DESTROY_BLOCK: {
                    this.Be.a(ms2, player, block);
                    break;
                }
                case ABORT_DESTROY_BLOCK: 
                case STOP_DESTROY_BLOCK: {
                    this.Be.aN(player);
                }
            }
        } else {
            lz lz2 = this.Be.aM(player);
            switch (playerDigType) {
                case START_DESTROY_BLOCK: {
                    if (lz2.Bj != null) {
                        lz2.Bj.cancel();
                        lz2.Bj = null;
                    }
                    this.Be.aO(player);
                    break;
                }
                case ABORT_DESTROY_BLOCK: 
                case STOP_DESTROY_BLOCK: {
                    lz2.Bj = Bukkit.getScheduler().runTaskLater(Main.rT(), () -> {
                        lz2.Bj = null;
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
