package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import it.unimi.dsi.fastutil.ints.IntList;
import itemsadder.m.aos;
import itemsadder.m.aot;
import itemsadder.m.aou;
import itemsadder.m.aov;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.WeakHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public interface aor {
    public static final WeakHashMap ajU = new WeakHashMap();
    public static final WeakHashMap ajV = new WeakHashMap();
    public static final String ajW = "_injector";

    public void c(Player var1, Object var2);

    default public void ak(Player player) {
        ajU.remove(player);
        ajV.remove(player);
    }

    default public void cy() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.ak(player);
        }
    }

    public void d(Player var1, Object var2);

    public Object aJ(int var1);

    default public aot p(World world) {
        this.uv();
        ItemDisplay itemDisplay = this.X(new Location(world, 0.0, 0.0, 0.0));
        return new aot(itemDisplay.getEntityId(), itemDisplay.getUniqueId());
    }

    default public Object a(World world, ItemStack itemStack, int n, int n2, float f) {
        return this.a(world, itemStack, n, n2, f, 2.0f, 2.0f, 2.0f, 1.0f, 1.0f);
    }

    default public Object a(World world, ItemStack itemStack, int n, int n2, float f, float f2, float f3, float f4, float f5, float f6) {
        this.uv();
        ItemDisplay itemDisplay = this.X(new Location(world, 0.0, 0.0, 0.0));
        aor.a(itemDisplay, itemStack, n, n2, f, f2, f3, f4, f5, f6);
        return this.c(itemDisplay);
    }

    default public Object a(World world, float f) {
        return this.a(world, new ItemStack(Material.AIR), 0, 0, f);
    }

    default public boolean ut() {
        return false;
    }

    default public Object c(ItemDisplay itemDisplay) {
        throw aor.uu();
    }

    default public void a(Player player, aot aot2, double d, double d2, double d3, Object object) {
        throw aor.uu();
    }

    default public void a(Player player, int n, Object object) {
        throw aor.uu();
    }

    default public void a(Player player, int n, double d, double d2, double d3) {
        throw aor.uu();
    }

    default public void a(Player player, int[] nArray, int n) {
        this.uv();
        for (int i = 0; i < n; ++i) {
            this.d(player, this.aJ(nArray[i]));
        }
    }

    default public void a(Player player, List list, int[] nArray, int n) {
        this.uv();
        for (aou aou2 : list) {
            if (aou2.akh) {
                this.a(player, aou2.akc, aou2.akd, aou2.ake, aou2.akf, aou2.akg);
                continue;
            }
            if (aou2.aki) {
                this.a(player, aou2.akc.ux(), aou2.akd, aou2.ake, aou2.akf);
            }
            if (aou2.akg == null) continue;
            this.a(player, aou2.akc.ux(), aou2.akg);
        }
        if (n > 0) {
            this.a(player, nArray, n);
        }
    }

    private static UnsupportedOperationException uu() {
        return new UnsupportedOperationException("ENTITY blocks require a Minecraft 1.21.4+ NMS adapter.");
    }

    private void uv() {
        if (!this.ut()) {
            throw aor.uu();
        }
    }

    public static void a(ItemDisplay itemDisplay, ItemStack itemStack, int n, int n2, float f) {
        aor.a(itemDisplay, itemStack, n, n2, f, 2.0f, 2.0f, 2.0f, 1.0f, 1.0f);
    }

    public static void a(ItemDisplay itemDisplay, ItemStack itemStack, int n, int n2, float f, float f2, float f3, float f4, float f5, float f6) {
        itemDisplay.setItemStack(itemStack);
        itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.FIXED);
        itemDisplay.setTransformation(new Transformation(new Vector3f(), new Quaternionf().rotationXYZ((float)Math.toRadians(n), (float)Math.toRadians(n2), 0.0f), new Vector3f(f2, f3, f4), new Quaternionf()));
        itemDisplay.setDisplayWidth(f5);
        itemDisplay.setDisplayHeight(f6);
        itemDisplay.setViewRange(f);
        itemDisplay.setShadowRadius(0.0f);
        itemDisplay.setShadowStrength(0.0f);
        itemDisplay.setInterpolationDuration(0);
        itemDisplay.setTeleportDuration(0);
        itemDisplay.setGlowing(false);
    }

    public void b(Object var1, Object var2);

    public void c(Object var1, Object var2);

    public Object dI(String var1);

    public String j(Object var1);

    public EnumWrappers.PlayerDigType d(PacketContainer var1);

    default public aov e(PacketContainer packetContainer) {
        throw new UnsupportedOperationException("Not supported on this server version.");
    }

    public void a(String var1, float var2, float var3, SoundCategory var4, Location var5);

    public void a(String var1, SoundCategory var2, Location var3);

    public void b(String var1, float var2, float var3, SoundCategory var4, Location var5);

    public void f(PacketContainer var1);

    public void a(Player var1, String var2, int var3);

    public void g(PacketContainer var1);

    public ItemDisplay b(Location var1, Consumer var2);

    default public ItemDisplay X(Location location) {
        return this.b(location, null);
    }

    public void h(Entity var1, Player var2);

    public void S(Entity var1);

    public void a(Entity var1, Location var2);

    public void a(Entity var1, Player var2, Location var3);

    public void c(Entity var1, Player var2, boolean var3);

    public void i(Entity var1, Player var2);

    default public void T(Entity entity) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.i(entity, player);
        }
    }

    public void a(Player var1, IntList var2);

    @Nullable
    public Integer a(PacketType var1);

    public static Field k(Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            Object object2;
            Object object3;
            field.setAccessible(true);
            if (!List.class.isAssignableFrom(field.getType())) continue;
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType && ((Type[])(object3 = (object2 = (ParameterizedType)type).getActualTypeArguments())).length == 1 && object3[0] == ChannelFuture.class) {
                return field;
            }
            object2 = field.get(object);
            if (!(object2 instanceof List) || (object3 = (List)object2).isEmpty() || !(object3.get(0) instanceof ChannelFuture)) continue;
            return field;
        }
        throw new IllegalStateException("Channels field not found");
    }

    public static void a(ChannelPipeline channelPipeline, String string) {
        if (channelPipeline.get(string) != null) {
            channelPipeline.remove(string);
        }
    }

    default public void a(String string, @NonNull Key key, String string2, @NonNull Supplier supplier) {
        try {
            String string3 = string + ajW;
            for (ChannelFuture channelFuture : this.uw()) {
                Channel channel = channelFuture.channel();
                Runnable runnable = () -> this.a(channel, string3, string, string2, (Supplier)supplier);
                if (channel.isRegistered()) {
                    channel.eventLoop().execute(runnable);
                    continue;
                }
                runnable.run();
            }
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to inject channel handler: " + string, throwable);
        }
    }

    public static void a(Channel channel, String string, String string2, Supplier supplier) {
        ChannelPipeline channelPipeline = channel.pipeline();
        aor.a(channelPipeline, string);
        ChannelHandler channelHandler = (ChannelHandler)supplier.get();
        if (string2 != null && channelPipeline.get(string2) != null) {
            channelPipeline.addAfter(string2, string, channelHandler);
        } else if (channelPipeline.get("splitter") != null) {
            channelPipeline.addBefore("splitter", string, channelHandler);
        } else if (channelPipeline.get("decoder") != null) {
            channelPipeline.addBefore("decoder", string, channelHandler);
        } else {
            channelPipeline.addFirst(string, channelHandler);
        }
    }

    default public void dJ(String string) {
        try {
            String string2 = string + ajW;
            for (ChannelFuture channelFuture : this.uw()) {
                Channel channel = channelFuture.channel();
                Runnable runnable = () -> {
                    aor.a(channel.pipeline(), string2);
                    aor.a(channel.pipeline(), string);
                };
                if (channel.isRegistered()) {
                    channel.eventLoop().execute(runnable);
                    continue;
                }
                runnable.run();
            }
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to uninject channel handler: " + string, throwable);
        }
    }

    public List uw();

    private /* synthetic */ void a(Channel channel, String string, String string2, String string3, Supplier supplier) {
        ChannelPipeline channelPipeline = channel.pipeline();
        aor.a(channelPipeline, string);
        channelPipeline.addFirst(string, (ChannelHandler)new aos(this, string2, string3, supplier));
    }
}
