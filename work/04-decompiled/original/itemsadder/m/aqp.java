package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.aab;
import itemsadder.m.ahs;
import itemsadder.m.aow;
import itemsadder.m.aqo;
import itemsadder.m.are;
import itemsadder.m.ari;
import itemsadder.m.arj;
import itemsadder.m.arl;
import itemsadder.m.arm;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
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

public final class aqp {
    public static final int alD = 36;
    private final aqo alE = (aqo)aab.n(aqo.class);
    private static aqp alF;

    aqp() {
    }

    private static aqp uV() {
        if (alF == null) {
            alF = new aqp();
        }
        return alF;
    }

    public static aqo uW() {
        return aqp.uV().alE;
    }

    public static void a(Player player, EquipmentSlot equipmentSlot) {
        aqp.uW().a(player, equipmentSlot);
    }

    public static void bW(Player player) {
        aqp.a(player, player.getInventory().getItemInOffHand(), 45, 0);
    }

    public static void c(Player player, ItemStack itemStack) {
        PlayerInventory playerInventory = player.getInventory();
        aqp.a(player, itemStack, 36 + playerInventory.getHeldItemSlot(), 0);
    }

    public static void d(Player player, ItemStack itemStack) {
        PlayerInventory playerInventory = player.getInventory();
        aqp.a(player, itemStack, 45, 0);
    }

    public static void l(Player player, boolean bl) {
        int n = player.getInventory().getHeldItemSlot();
        PlayerInventory playerInventory = player.getInventory();
        int n2 = 36;
        for (int i = 0; i <= 8; ++i) {
            if (bl || n != i) {
                aqp.a(player, playerInventory.getItem(i), n2, 0);
            }
            ++n2;
        }
    }

    public static void b(Player player, ItemStack itemStack, int n) {
        aqp.a(player, itemStack, n, aqp.uV().alE.bT(player));
    }

    public static void a(Player player, ItemStack itemStack, int n, int n2) {
        if (itemStack == null) {
            itemStack = new ItemStack(Material.AIR);
        }
        arm arm2 = new arm();
        arm2.aN(n2);
        arm2.ad(itemStack);
        ((arl)arm2).aO(n);
        arm2.cc(player);
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
        ahs.tP().bS(player);
    }

    public static void bY(Player player) {
        Location location = player.getLocation();
        location.setY(location.getY() + 0.005);
        player.teleport(location);
        ahs.tP().a(player, true, true, 1.0E-10f);
        player.setVelocity(new Vector(0, 0, 0));
    }

    public static void a(Player player, Vector vector, int n, int n2) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
        packetContainer.getBlockPositionModifier().write(0, (Object)new BlockPosition(vector));
        packetContainer.getIntegers().write(0, (Object)n2).write(1, (Object)n);
        for (Player player2 : player.getLocation().getWorld().getPlayers()) {
            if (!(player2.getLocation().distance(player.getLocation()) <= 6.0)) continue;
            aow.a(player2, packetContainer, false);
        }
    }

    public static Block bZ(Player player) {
        return player.getTargetBlock(bcc.aAP, 8);
    }

    public static Block ca(Player player) {
        return player.getTargetBlock(bcc.aAQ, 8);
    }

    public static void cb(Player player) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.ENTITY_STATUS);
        packetContainer.getIntegers().write(0, (Object)player.getEntityId());
        packetContainer.getBytes().write(0, (Object)EntityEffect.TOTEM_RESURRECT.getData());
        aow.a(player, packetContainer);
    }

    public static void e(Player player, ItemStack itemStack) {
        boolean bl;
        ItemStack itemStack2 = player.getInventory().getItemInMainHand();
        ItemStack itemStack3 = player.getInventory().getItemInOffHand();
        boolean bl2 = bl = itemStack2.getType() == Material.TOTEM_OF_UNDYING;
        if (bl) {
            aqp.c(player, bbs.aAp);
        }
        aqp.d(player, itemStack);
        aqp.cb(player);
        aqp.d(player, itemStack3);
        if (bl) {
            aqp.c(player, itemStack2);
        }
    }

    @Nullable
    public static are a(Player player, EnumWrappers.ItemSlot itemSlot, ItemStack itemStack) {
        arj arj2 = new arj();
        arj2.a(itemSlot, itemStack);
        ((ari)arj2).aM(player.getEntityId());
        return arj2;
    }
}
