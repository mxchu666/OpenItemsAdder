package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.EnumWrappersHelper;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PacketContainerHelper;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketTypeHelper;
import itemsadder.m.PacketTypeHelperImpl;
import itemsadder.m.PacketTypeHelper_2;
import itemsadder.m.PlayerHolder;
import itemsadder.m.PlayerWrapper_5;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public final class PlayerHolder_4 {
    public static final int alD = 36;
    private final PlayerWrapper_5 alE = (PlayerWrapper_5)NmsWrapperFactory.n(PlayerWrapper_5.class);
    private static PlayerHolder_4 alF;

    PlayerHolder_4() {
    }

    private static PlayerHolder_4 uV() {
        if (alF == null) {
            alF = new PlayerHolder_4();
        }
        return alF;
    }

    public static PlayerWrapper_5 uW() {
        return PlayerHolder_4.uV().alE;
    }

    public static void a(Player player, EquipmentSlot equipmentSlot) {
        PlayerHolder_4.uW().a(player, equipmentSlot);
    }

    public static void bW(Player player) {
        PlayerHolder_4.a(player, player.getInventory().getItemInOffHand(), 45, 0);
    }

    public static void c(Player player, ItemStack itemStack) {
        PlayerInventory playerInventory = player.getInventory();
        PlayerHolder_4.a(player, itemStack, 36 + playerInventory.getHeldItemSlot(), 0);
    }

    public static void d(Player player, ItemStack itemStack) {
        PlayerInventory playerInventory = player.getInventory();
        PlayerHolder_4.a(player, itemStack, 45, 0);
    }

    public static void l(Player player, boolean bl) {
        int n = player.getInventory().getHeldItemSlot();
        PlayerInventory playerInventory = player.getInventory();
        int n2 = 36;
        for (int i = 0; i <= 8; ++i) {
            if (bl || n != i) {
                PlayerHolder_4.a(player, playerInventory.getItem(i), n2, 0);
            }
            ++n2;
        }
    }

    public static void b(Player player, ItemStack itemStack, int n) {
        PlayerHolder_4.a(player, itemStack, n, PlayerHolder_4.uV().alE.bT(player));
    }

    public static void a(Player player, ItemStack itemStack, int n, int n2) {
        if (itemStack == null) {
            itemStack = new ItemStack(Material.AIR);
        }
        PacketTypeHelperImpl packetTypeHelperImpl = new PacketTypeHelperImpl();
        packetTypeHelperImpl.aN(n2);
        packetTypeHelperImpl.ad(itemStack);
        ((PacketTypeHelper_2)packetTypeHelperImpl).aO(n);
        packetTypeHelperImpl.cc(player);
    }

    public static String a(EquipmentSlot equipmentSlot) {
        switch (equipmentSlot) {
            case HAND: {
                return "mainhand";
            }
            case OFF_HAND: {
                return "offhand";
            }
            case FEET: {
                return "feet";
            }
            case LEGS: {
                return "legs";
            }
            case CHEST: {
                return "chest";
            }
            case HEAD: {
                return "head";
            }
        }
        return null;
    }

    public static boolean d(PlayerTeleportEvent playerTeleportEvent) {
        return playerTeleportEvent.getCause() == PlayerTeleportEvent.TeleportCause.PLUGIN && playerTeleportEvent.getFrom().getX() == playerTeleportEvent.getTo().getX() && playerTeleportEvent.getFrom().getZ() == playerTeleportEvent.getTo().getZ() && playerTeleportEvent.getTo().getY() - playerTeleportEvent.getFrom().getY() >= (double)0.0049f && playerTeleportEvent.getTo().getY() - playerTeleportEvent.getFrom().getY() <= (double)0.00509f;
    }

    public static void bX(Player player) {
        PlayerHolder.tP().bS(player);
    }

    public static void bY(Player player) {
        Location location = player.getLocation();
        location.setY(location.getY() + 0.005);
        player.teleport(location);
        PlayerHolder.tP().a(player, true, true, 1.0E-10f);
        player.setVelocity(new Vector(0, 0, 0));
    }

    public static void a(Player player, Vector vector, int n, int n2) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
        packetContainer.getBlockPositionModifier().write(0, (Object)new BlockPosition(vector));
        packetContainer.getIntegers().write(0, (Object)n2).write(1, (Object)n);
        for (Player player2 : player.getLocation().getWorld().getPlayers()) {
            if (!(player2.getLocation().distance(player.getLocation()) <= 6.0)) continue;
            PacketListenerRegistry.a(player2, packetContainer, false);
        }
    }

    public static Block bZ(Player player) {
        return player.getTargetBlock(LocationBridge_2.aAP, 8);
    }

    public static Block ca(Player player) {
        return player.getTargetBlock(LocationBridge_2.aAQ, 8);
    }

    public static void cb(Player player) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.ENTITY_STATUS);
        packetContainer.getIntegers().write(0, (Object)player.getEntityId());
        packetContainer.getBytes().write(0, (Object)EntityEffect.TOTEM_RESURRECT.getData());
        PacketListenerRegistry.a(player, packetContainer);
    }

    public static void e(Player player, ItemStack itemStack) {
        boolean bl;
        ItemStack itemStack2 = player.getInventory().getItemInMainHand();
        ItemStack itemStack3 = player.getInventory().getItemInOffHand();
        boolean bl2 = bl = itemStack2.getType() == Material.TOTEM_OF_UNDYING;
        if (bl) {
            PlayerHolder_4.c(player, ItemStackBridge_2.aAp);
        }
        PlayerHolder_4.d(player, itemStack);
        PlayerHolder_4.cb(player);
        PlayerHolder_4.d(player, itemStack3);
        if (bl) {
            PlayerHolder_4.c(player, itemStack2);
        }
    }

    @Nullable
    public static PacketContainerHelper a(Player player, EnumWrappers.ItemSlot itemSlot, ItemStack itemStack) {
        PacketTypeHelper packetTypeHelper = new PacketTypeHelper();
        packetTypeHelper.a(itemSlot, itemStack);
        ((EnumWrappersHelper)packetTypeHelper).aM(player.getEntityId());
        return packetTypeHelper;
    }
}
