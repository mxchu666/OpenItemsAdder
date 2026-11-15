package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerWrapper_4;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public final class PacketListenerRegistry {
    public PlayerWrapper_4 akq;
    static PacketListenerRegistry akr;
    Cache aks = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build();
    private static final Object2ObjectOpenHashMap akt;

    PacketListenerRegistry() {
        this.akq = (PlayerWrapper_4)NmsWrapperFactory.n(PlayerWrapper_4.class);
    }

    public static PlayerWrapper_4 uN() {
        return PacketListenerRegistry.akr.akq;
    }

    public static boolean P() {
        return akr != null && PacketListenerRegistry.akr.akq != null;
    }

    public static void init() {
        akr = new PacketListenerRegistry();
    }

    public static void c(Player player, Object object) {
        PacketListenerRegistry.akr.akq.c(player, object);
    }

    public static void ak(Player player) {
        PacketListenerRegistry.akr.akq.ak(player);
    }

    public static PacketAdapter.AdapterParameteters uO() {
        return new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS());
    }

    public static PacketType o(Class clazz) {
        return PacketType.fromClass((Class)clazz);
    }

    public static void a(PacketListener packetListener) {
        ProtocolLibrary.getProtocolManager().addPacketListener(packetListener);
        ((List)akt.computeIfAbsent((Object)PacketListenerRegistry.uP(), object -> new ArrayList())).add(packetListener);
    }

    private static Class uP() {
        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).walk(stream -> stream.skip(2L).findFirst().map(StackWalker.StackFrame::getDeclaringClass).orElse(null));
    }

    public static void l(Object object) {
        PacketListenerRegistry.p(object.getClass());
    }

    public static void p(Class clazz) {
        if (Modifier.isAbstract(clazz.getModifiers())) {
            throw new IllegalArgumentException("Cannot unregister listeners for abstract class: " + clazz.getName());
        }
        List list = (List)akt.remove((Object)clazz);
        if (list == null) {
            return;
        }
        for (PacketListener packetListener : list) {
            ProtocolLibrary.getProtocolManager().removePacketListener(packetListener);
        }
    }

    public static boolean m(Object object) {
        if (PacketListenerRegistry.akr.aks.asMap().containsKey(object)) {
            PacketListenerRegistry.akr.aks.invalidate(object);
            return true;
        }
        return false;
    }

    public static void a(Object object, boolean bl) {
        if (!bl) {
            PacketListenerRegistry.akr.aks.invalidate(object);
        } else {
            PacketListenerRegistry.akr.aks.put(object, true);
        }
    }

    public static PacketContainer aK(int n) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.ENTITY_DESTROY);
        packetContainer.getIntLists().write(0, Collections.singletonList(n));
        return packetContainer;
    }

    public static void g(Player player, Entity entity) {
        PacketListenerRegistry.f(player, entity.getEntityId());
    }

    public static void U(Entity entity) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.ENTITY_DESTROY);
        packetContainer.getIntLists().write(0, Collections.singletonList(entity.getEntityId()));
        for (Player player : Bukkit.getOnlinePlayers()) {
            PacketListenerRegistry.a(player, packetContainer);
        }
    }

    public static void a(Player player, PacketContainer packetContainer) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer, false);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void a(Player player, PacketContainer packetContainer, boolean bl) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer, bl);
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void b(Player player, PacketContainer packetContainer, boolean bl) {
        try {
            ProtocolLibrary.getProtocolManager().receiveClientPacket(player, packetContainer, bl);
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Nullable
    public static PacketListener b(PacketListener packetListener) {
        if (packetListener != null) {
            ProtocolLibrary.getProtocolManager().addPacketListener(packetListener);
        }
        return packetListener;
    }

    public static void c(PacketListener packetListener) {
        if (packetListener != null) {
            ProtocolLibrary.getProtocolManager().removePacketListener(packetListener);
        }
    }

    public static void f(Player player, int n) {
        PacketListenerRegistry.a(player, PacketListenerRegistry.aK(n));
    }

    public static boolean a(PacketEvent packetEvent) {
        if (Version.isNewerThan((Version)Version.v1_21_11)) {
            return false;
        }
        WrappedEnumEntityUseAction wrappedEnumEntityUseAction = (WrappedEnumEntityUseAction)packetEvent.getPacket().getEnumEntityUseActions().read(0);
        return wrappedEnumEntityUseAction.getAction() == EnumWrappers.EntityUseAction.ATTACK;
    }

    public static boolean a(EnumWrappers.PlayerDigType playerDigType) {
        return playerDigType == EnumWrappers.PlayerDigType.START_DESTROY_BLOCK || playerDigType == EnumWrappers.PlayerDigType.ABORT_DESTROY_BLOCK || playerDigType == EnumWrappers.PlayerDigType.STOP_DESTROY_BLOCK;
    }

    static {
        akt = new Object2ObjectOpenHashMap();
    }
}
