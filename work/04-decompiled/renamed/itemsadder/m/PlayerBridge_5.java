package itemsadder.m;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import itemsadder.m.ColorBridge;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerHolder_2;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_5 {
    private static ItemDisplay a(Player player, @Nullable ItemDisplay itemDisplay, double d, double d2, double d3, double d4, double d5, double d6) {
        World world = player.getWorld();
        boolean bl = itemDisplay != null;
        double d7 = (d + d4) / 2.0;
        double d8 = (d2 + d5) / 2.0;
        double d9 = (d3 + d6) / 2.0;
        double d10 = Math.sqrt(Math.pow(d4 - d, 2.0) + Math.pow(d5 - d2, 2.0) + Math.pow(d6 - d3, 2.0));
        Location location = new Location(world, d7, d8, d9);
        if (itemDisplay == null) {
            itemDisplay = PacketListenerRegistry.uN().X(location);
            itemDisplay.setInvisible(true);
            ItemStack itemStack = new ItemStack(Material.PAPER);
            PlayerHolder_2.tX().d(itemStack, "minecraft:block_outline");
            PlayerHolder_2.tX().a(itemStack, ColorBridge.iL("383838"));
            itemDisplay.setItemStack(itemStack);
            itemDisplay.setTeleportDuration(0);
            itemDisplay.setInterpolationDuration(2);
        }
        if (player.getWorld().getTime() >= 13000L && player.getWorld().getTime() <= 23500L) {
            itemDisplay.setBrightness(new Display.Brightness(8, 8));
        } else {
            itemDisplay.setBrightness(new Display.Brightness(15, 15));
        }
        double d11 = d4 - d;
        double d12 = d5 - d2;
        double d13 = d6 - d3;
        boolean bl2 = Math.abs(d11) >= Math.abs(d12) && Math.abs(d11) >= Math.abs(d13);
        boolean bl3 = Math.abs(d12) >= Math.abs(d11) && Math.abs(d12) >= Math.abs(d13);
        boolean bl4 = Math.abs(d13) >= Math.abs(d11) && Math.abs(d13) >= Math.abs(d12);
        double d14 = player.getEyeLocation().distance(location);
        double d15 = 1.0;
        double d16 = 4.0;
        double d17 = 0.0018;
        double d18 = 0.02;
        double d19 = Math.max(d15, Math.min(d16, d14));
        double d20 = (d19 - d15) / (d16 - d15);
        double d21 = d17 + d20 * (d18 - d17);
        itemDisplay.setBillboard(Display.Billboard.FIXED);
        Transformation transformation = itemDisplay.getTransformation();
        if (bl2) {
            transformation.getScale().set((double)((float)d10), d21, d21);
        } else if (bl3) {
            transformation.getScale().set(d21, (double)((float)d10), d21);
        } else if (bl4) {
            transformation.getScale().set((double)((float)d10), d21, d21);
            location.setYaw(90.0f);
        }
        itemDisplay.setTransformation(transformation);
        if (bl) {
            PacketListenerRegistry.uN().c((Entity)itemDisplay, player, true);
            PacketListenerRegistry.uN().a((Entity)itemDisplay, player, location);
        } else {
            PacketListenerRegistry.uN().h((Entity)itemDisplay, player);
            PacketListenerRegistry.uN().c((Entity)itemDisplay, player, true);
            PacketListenerRegistry.uN().a((Entity)itemDisplay, player, location);
        }
        return itemDisplay;
    }

    public static void a(Player player, BoundingBox boundingBox, ObjectArrayList objectArrayList) {
        double d = boundingBox.getMinX();
        double d2 = boundingBox.getMinY();
        double d3 = boundingBox.getMinZ();
        double d4 = boundingBox.getMaxX();
        double d5 = boundingBox.getMaxY();
        double d6 = boundingBox.getMaxZ();
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d2, d3, d4, d2, d3));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d2, d3, d, d2, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d4, d2, d3, d4, d2, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d2, d6, d4, d2, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d5, d3, d4, d5, d3));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d5, d3, d, d5, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d4, d5, d3, d4, d5, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d5, d6, d4, d5, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d2, d3, d, d5, d3));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d4, d2, d3, d4, d5, d3));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d, d2, d6, d, d5, d6));
        objectArrayList.add((Object)PlayerBridge_5.a(player, null, d4, d2, d6, d4, d5, d6));
    }

    public static void b(Player player, BoundingBox boundingBox, ObjectArrayList objectArrayList) {
        double d = boundingBox.getMinX();
        double d2 = boundingBox.getMinY();
        double d3 = boundingBox.getMinZ();
        double d4 = boundingBox.getMaxX();
        double d5 = boundingBox.getMaxY();
        double d6 = boundingBox.getMaxZ();
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(0), d, d2, d3, d4, d2, d3);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(1), d, d2, d3, d, d2, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(2), d4, d2, d3, d4, d2, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(3), d, d2, d6, d4, d2, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(4), d, d5, d3, d4, d5, d3);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(5), d, d5, d3, d, d5, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(6), d4, d5, d3, d4, d5, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(7), d, d5, d6, d4, d5, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(8), d, d2, d3, d, d5, d3);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(9), d4, d2, d3, d4, d5, d3);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(10), d, d2, d6, d, d5, d6);
        PlayerBridge_5.a(player, (ItemDisplay)objectArrayList.get(11), d4, d2, d6, d4, d5, d6);
    }
}
