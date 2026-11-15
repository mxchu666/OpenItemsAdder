package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerHolder_4;
import java.util.function.Consumer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

class UseEntityPacketListener
extends PacketAdapter {
    public UseEntityPacketListener() {
        super(new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).listenerPriority(ListenerPriority.MONITOR).types(new PacketType[]{PacketType.Play.Client.USE_ENTITY}));
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        this.a(packetEvent.getPacket(), (T livingEntityBuilder) -> {
            if (LivingEntityRegistry.db().b((LivingEntity)packetEvent.getPlayer(), (LivingEntityBuilder)livingEntityBuilder)) {
                return;
            }
            if (!livingEntityBuilder.ni.fF()) {
                return;
            }
            if (packetEvent.getPlayer().equals((Object)livingEntityBuilder.eg())) {
                return;
            }
            if (PacketListenerRegistry.a(packetEvent)) {
                BukkitTaskBridge.i(() -> PlayerHolder_4.uW().h(packetEvent.getPlayer(), (Entity)livingEntityBuilder.eg()));
            } else {
                if (Main.PK && CitizensHook.isNPC(livingEntityBuilder.eg())) {
                    this.a(packetEvent, (LivingEntityBuilder)livingEntityBuilder);
                    return;
                }
                this.a(packetEvent, (LivingEntityBuilder)livingEntityBuilder);
                if (livingEntityBuilder.my.oc && livingEntityBuilder.eE() && !packetEvent.getPlayer().isSneaking() && !LivingEntityRegistry.db().b((LivingEntity)packetEvent.getPlayer())) {
                    BukkitTaskBridge.i(() -> {
                        if (!LivingEntityRegistry.db().a((LivingEntity)packetEvent.getPlayer(), (LivingEntityBuilder)livingEntityBuilder)) {
                            CommandSenderBridge_5.g((CommandSender)packetEvent.getPlayer(), "all-mounts-occupied");
                        }
                    });
                }
            }
        });
    }

    private void a(PacketEvent packetEvent, LivingEntityBuilder livingEntityBuilder) {
        BukkitTaskBridge.i(() -> {
            Vector vector = (Vector)packetEvent.getPacket().getVectors().readSafely(0);
            if (vector == null) {
                PlayerHolder_4.uW().j(packetEvent.getPlayer(), (Entity)livingEntityBuilder.eg());
            } else {
                PlayerHolder_4.uW().a(packetEvent.getPlayer(), (Entity)livingEntityBuilder.eg(), vector);
            }
        });
    }

    private void a(PacketContainer packetContainer, Consumer consumer) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().k((Integer)packetContainer.getIntegers().read(0));
        if (livingEntityBuilder != null && livingEntityBuilder.eg() != null && livingEntityBuilder.mE && !livingEntityBuilder.mD) {
            consumer.accept(livingEntityBuilder);
            return;
        }
        livingEntityBuilder = LivingEntityRegistry.db().j((Integer)packetContainer.getIntegers().read(0));
        if (livingEntityBuilder != null && livingEntityBuilder.eg() != null && !livingEntityBuilder.mD) {
            consumer.accept(livingEntityBuilder);
        }
    }
}
