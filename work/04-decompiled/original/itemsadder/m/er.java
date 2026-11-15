package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Main;
import itemsadder.m.aow;
import itemsadder.m.aqp;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.da;
import itemsadder.m.dn;
import java.util.function.Consumer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

class er
extends PacketAdapter {
    public er() {
        super(new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).listenerPriority(ListenerPriority.MONITOR).types(new PacketType[]{PacketType.Play.Client.USE_ENTITY}));
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        this.a(packetEvent.getPacket(), (T dn2) -> {
            if (da.db().b((LivingEntity)packetEvent.getPlayer(), (dn)dn2)) {
                return;
            }
            if (!dn2.ni.fF()) {
                return;
            }
            if (packetEvent.getPlayer().equals((Object)dn2.eg())) {
                return;
            }
            if (aow.a(packetEvent)) {
                bcp.i(() -> aqp.uW().h(packetEvent.getPlayer(), (Entity)dn2.eg()));
            } else {
                if (Main.PK && CitizensHook.isNPC(dn2.eg())) {
                    this.a(packetEvent, (dn)dn2);
                    return;
                }
                this.a(packetEvent, (dn)dn2);
                if (dn2.my.oc && dn2.eE() && !packetEvent.getPlayer().isSneaking() && !da.db().b((LivingEntity)packetEvent.getPlayer())) {
                    bcp.i(() -> {
                        if (!da.db().a((LivingEntity)packetEvent.getPlayer(), (dn)dn2)) {
                            bce.g((CommandSender)packetEvent.getPlayer(), "all-mounts-occupied");
                        }
                    });
                }
            }
        });
    }

    private void a(PacketEvent packetEvent, dn dn2) {
        bcp.i(() -> {
            Vector vector = (Vector)packetEvent.getPacket().getVectors().readSafely(0);
            if (vector == null) {
                aqp.uW().j(packetEvent.getPlayer(), (Entity)dn2.eg());
            } else {
                aqp.uW().a(packetEvent.getPlayer(), (Entity)dn2.eg(), vector);
            }
        });
    }

    private void a(PacketContainer packetContainer, Consumer consumer) {
        dn dn2 = da.db().k((Integer)packetContainer.getIntegers().read(0));
        if (dn2 != null && dn2.eg() != null && dn2.mE && !dn2.mD) {
            consumer.accept(dn2);
            return;
        }
        dn2 = da.db().j((Integer)packetContainer.getIntegers().read(0));
        if (dn2 != null && dn2.eg() != null && !dn2.mD) {
            consumer.accept(dn2);
        }
    }
}
