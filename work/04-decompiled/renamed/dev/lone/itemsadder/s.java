package dev.lone.itemsadder;

import dev.lone.itemsadder.t;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.WorldBridge_4;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.Nullable;

public class s {
    public static String QA = "577960924";
    public static final String QB = "ia.user.ia";
    public static final String QC = "ia.user.ia.categories";
    public static final String QD = "ia.user.ia.categories.others";
    public static String QE = "ia.user.iacraft";
    public static final String QF = "ia.user.iarecipe";
    public static final String QG = "ia.user.iarecipe.others";
    private static final String QH = "ia.user.recipe.";
    private static final String QI = "ia.user.ia.seeitem.";
    private static final String QJ = "ia.user.ia.seeitem.*";
    private static final String QK = "ia.user.block.break.";
    private static final String QL = "ia.user.block.place.";
    private static final String QM = "ia.user.furniture.break.";
    private static final String QN = "ia.user.furniture.place.";
    private static final String QO = "ia.user.complex_furniture.break.";
    private static final String QP = "ia.user.complex_furniture.place.";
    public static final String QQ = "ia.user.image.chat";
    public static final String QR = "ia.user.image.command";
    public static final String QS = "ia.user.image.sign";
    public static final String QT = "ia.user.image.book";
    public static final String QU = "ia.user.image.anvil";
    public static final String QV = "ia.user.image.gui";
    public static final String QW = "ia.user.image.hints";
    private static final String QX = "ia.user.image.use.";
    public static final String QY = "ia.user.iatexture";
    public static final String QZ = "ia.user.iatexture.all";
    public static final String Ra = "ia.user.ia.search";
    public static final String Rb = "ia.user.text_effect.use.";
    public static final String Rc = "ia.user.text_effect.chat";
    public static final String Rd = "ia.user.text_effect.command";
    public static final String Re = "ia.user.text_effect.sign";
    public static final String Rf = "ia.user.text_effect.book";
    public static final String Rg = "ia.user.text_effect.anvil";
    public static final String Rh = "ia.admin.iaget";
    public static final String Ri = "ia.admin.iagive";
    public static final String Rj = "ia.admin.iaremove";
    public static final String Rk = "ia.admin.iatag";
    public static final String Rl = "ia.admin.iatag.show-in-console";
    public static final String Rm = "ia.admin.iarepair";
    public static final String Rn = "ia.admin.iadurability";
    public static final String Ro = "ia.admin.iablock";
    public static final String Rp = "ia.admin.ialiquid";
    public static final String Rq = "ia.admin.iareload";
    public static final String Rr = "ia.admin.iazip";
    public static String Rs = "ia.admin.playerstat";
    public static final String Rt = "ia.admin.iaplayerstat.read";
    public static final String Ru = "ia.admin.iaplayerstat.write";
    public static final String Rv = "ia.admin.iainfo";
    public static final String Rw = "ia.admin.iaspawntree";
    public static final String Rx = "ia.admin.iacolor.others";
    public static String Ry = "ia.admin.edit";
    public static final String Rz = "ia.resourcepack.bypasskick";
    public static final String RA = "ia.admin.bypassblockplaceloot";
    public static final String RB = "ia.user.iaemote.others";
    private static final String RC = "ia.user.iaemote.use.";
    private static final String RD = "ia.user.hud.show.";
    private static final String RE = "ia.user.hud.bypass.triggers.";
    private static final String RF = "ia.user.hud.bypass.commands.";
    private static final String RG = "ia.user.hud.bypass.api.";
    public static final String RH = "ia.admin.crops.others";

    public static boolean a(HumanEntity humanEntity, WorldBridge_4 worldBridge_4) {
        return humanEntity.hasPermission("ia.user.hud.show.*") || humanEntity.hasPermission(RD + worldBridge_4.getNamespacedID());
    }

    public static boolean a(HumanEntity humanEntity, WorldBridge_4 worldBridge_4, t t2) {
        return s.a(humanEntity, worldBridge_4, t2, false);
    }

    public static boolean a(HumanEntity humanEntity, WorldBridge_4 worldBridge_4, t t2, boolean bl) {
        if (bl) {
            return switch (t2.ordinal()) {
                default -> throw new MatchException(null, null);
                case 0 -> {
                    if (humanEntity.hasPermission("ia.user.hud.bypass.triggers.*") || humanEntity.hasPermission(RE + worldBridge_4.getNamespacedID())) {
                        yield true;
                    }
                    yield false;
                }
                case 1 -> {
                    if (humanEntity.hasPermission("ia.user.hud.bypass.commands.*") || humanEntity.hasPermission(RF + worldBridge_4.getNamespacedID())) {
                        yield true;
                    }
                    yield false;
                }
                case 2 -> humanEntity.hasPermission("ia.user.hud.bypass.api.*") || humanEntity.hasPermission(RG + worldBridge_4.getNamespacedID());
            };
        }
        return switch (t2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> humanEntity.hasPermission(RE + worldBridge_4.getNamespacedID());
            case 1 -> humanEntity.hasPermission(RF + worldBridge_4.getNamespacedID());
            case 2 -> humanEntity.hasPermission(RG + worldBridge_4.getNamespacedID());
        };
    }

    public static boolean a(HumanEntity humanEntity, t t2) {
        return switch (t2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> humanEntity.hasPermission("ia.user.hud.bypass.triggers.*");
            case 1 -> humanEntity.hasPermission("ia.user.hud.bypass.commands.*");
            case 2 -> humanEntity.hasPermission("ia.user.hud.bypass.api.*");
        };
    }

    public static void cX(String string) {
        String string2 = "Allow the player to see the hud. True by default.";
        String string3 = RD + string;
        if (Bukkit.getPluginManager().getPermission(string3) == null) {
            Bukkit.getPluginManager().addPermission(new Permission(string3, string2, PermissionDefault.TRUE));
        }
    }

    public static boolean a(HumanEntity humanEntity, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder) {
        return humanEntity.hasPermission(QH + namespacedKeyItemStackHolder.nf()) || humanEntity.hasPermission("ia.user.craft." + namespacedKeyItemStackHolder.nf());
    }

    public static boolean a(HumanEntity humanEntity, String string) {
        return humanEntity.hasPermission(QI + string) || humanEntity.hasPermission("ia.user.ia." + string);
    }

    public static boolean bm(Player player) {
        return player.hasPermission(Ra) || player.hasPermission("ia.user.iasearchgui");
    }

    public static boolean b(HumanEntity humanEntity, @Nullable String string) {
        if (string == null) {
            return true;
        }
        return s.d((Permissible)humanEntity, QK + string);
    }

    public static boolean c(HumanEntity humanEntity, @Nullable String string) {
        if (string == null) {
            return true;
        }
        return s.d((Permissible)humanEntity, QL + string);
    }

    public static boolean d(HumanEntity humanEntity, @Nullable String string) {
        if (string == null) {
            return true;
        }
        return s.d((Permissible)humanEntity, QM + string);
    }

    public static boolean e(HumanEntity humanEntity, @Nullable String string) {
        if (string == null) {
            return true;
        }
        return s.d((Permissible)humanEntity, QN + string);
    }

    public static boolean f(HumanEntity humanEntity, @Nullable String string) {
        if (string == null) {
            return true;
        }
        return s.d((Permissible)humanEntity, QO + string);
    }

    public static boolean g(HumanEntity humanEntity, @Nullable String string) {
        if (string == null) {
            return true;
        }
        return s.d((Permissible)humanEntity, QP + string);
    }

    public static boolean bn(Player player) {
        return player.hasPermission(QJ) || player.hasPermission("ia.user.ia.*");
    }

    public static String cY(String string) {
        return QX + string;
    }

    public static boolean a(Permissible permissible, @Nullable String string) {
        return string == null || permissible.isOp() || permissible.hasPermission(s.cY("*")) || permissible.hasPermission(string);
    }

    public static String cZ(String string) {
        return RC + string.replace(":", ".");
    }

    public static boolean a(Permissible permissible, String string, boolean bl) {
        if (string == null) {
            return bl;
        }
        if (permissible instanceof Player) {
            return permissible.hasPermission(string);
        }
        return true;
    }

    public static boolean b(Permissible permissible, String string) {
        return s.a(permissible, string, true);
    }

    public static boolean b(Permissible permissible, String string, boolean bl) {
        if (string == null) {
            return true;
        }
        if (permissible instanceof Player) {
            Player player = (Player)permissible;
            if (permissible.hasPermission(string)) {
                return true;
            }
            if (bl) {
                CommandSenderBridge_5.a((CommandSender)player, "no-permission-detail", (Object string2) -> string2.replace("{permission}", string));
            } else {
                CommandSenderBridge_5.g((CommandSender)player, "no-permission");
            }
            return false;
        }
        return permissible.hasPermission(string);
    }

    public static boolean c(Permissible permissible, String string) {
        return s.b(permissible, string, false);
    }

    public static boolean d(Permissible permissible, String string) {
        if (permissible instanceof Player) {
            Player player = (Player)permissible;
            if (permissible.hasPermission(string)) {
                return permissible.hasPermission(string);
            }
            CommandSenderBridge_5.g((CommandSender)player, "no-permission-short");
            return false;
        }
        return permissible.hasPermission(string);
    }
}
