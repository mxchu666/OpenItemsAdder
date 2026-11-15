package dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins;

import com.sk89q.worldguard.protection.flags.StateFlag;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.Plugins.Flags;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.Plugins.Flags$Result;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.WorldGuardFlagsManager;
import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import itemsadder.m.bcc;
import itemsadder.m.js;
import itemsadder.m.qm;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ProtectionPlugins {
    public static boolean registered;
    public static boolean hasWorldGuard;

    public static void register() {
        if (registered) {
            return;
        }
        registered = true;
        try {
            Class.forName("com.sk89q.worldguard.WorldGuard");
            hasWorldGuard = true;
            WorldGuardFlagsManager.registerFlags();
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
    }

    public static boolean canSitOnFurniture(Player player, Entity entity, Cancellable cancellable) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(Flags.FURNITURE_SIT, player, entity);
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return !cancellable.isCancelled();
    }

    public static boolean canSitOnFurniture(Player player, Entity entity) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(Flags.FURNITURE_SIT, player, entity);
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return true;
    }

    public static boolean canSitOnVehicle(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, ItemStack itemStack) {
        boolean bl;
        String string = qm.B(itemStack);
        boolean bl2 = bl = string != null && string.equals(playerInteractAtEntityEvent.getPlayer().getUniqueId().toString());
        if (bl) {
            if (hasWorldGuard) {
                Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(Flags.VEHICLE_PERSONAL_SIT, playerInteractAtEntityEvent.getPlayer(), playerInteractAtEntityEvent.getRightClicked());
                if (flags$Result == Flags$Result.ALLOW) {
                    return true;
                }
                if (flags$Result == Flags$Result.DENY) {
                    return false;
                }
                if (flags$Result == Flags$Result.BYPASS) {
                    return true;
                }
            }
        } else if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(Flags.VEHICLE_SIT, playerInteractAtEntityEvent.getPlayer(), playerInteractAtEntityEvent.getRightClicked());
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return !playerInteractAtEntityEvent.isCancelled();
    }

    public static boolean canSitOnVehicle(Player player, Entity entity) {
        Object object;
        boolean bl = false;
        if (js.w(entity) && (object = js.o(entity)) != null) {
            String string = qm.B(object);
            boolean bl2 = bl = string != null && string.equals(player.getUniqueId().toString());
        }
        if (bl) {
            object = WorldGuardFlagsManager.testEntityFlag(Flags.VEHICLE_PERSONAL_SIT, player, entity);
            if (object == Flags$Result.ALLOW) {
                return true;
            }
            if (object == Flags$Result.DENY) {
                return false;
            }
            if (object == Flags$Result.BYPASS) {
                return true;
            }
        } else {
            object = WorldGuardFlagsManager.testEntityFlag(Flags.VEHICLE_SIT, player, entity);
            if (object == Flags$Result.ALLOW) {
                return true;
            }
            if (object == Flags$Result.DENY) {
                return false;
            }
            if (object == Flags$Result.BYPASS) {
                return true;
            }
        }
        return true;
    }

    public static boolean canRemoveVehicle(Player player, Entity entity, ItemStack itemStack) {
        boolean bl;
        String string = qm.B(itemStack);
        boolean bl2 = bl = string != null && string.equals(player.getUniqueId().toString());
        if (bl) {
            if (hasWorldGuard) {
                Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(Flags.VEHICLE_PERSONAL_REMOVE, player, entity);
                if (flags$Result == Flags$Result.ALLOW) {
                    return true;
                }
                if (flags$Result == Flags$Result.DENY) {
                    return false;
                }
                if (flags$Result == Flags$Result.BYPASS) {
                    return true;
                }
            }
        } else if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(Flags.VEHICLE_REMOVE, player, entity);
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return bcc.f((Entity)player, entity);
    }

    public static boolean canPlaceVehicle(Player player, Block block) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testBlockFlag(Flags.VEHICLE_PLACE, player, block);
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return bcc.b(block, player);
    }

    public static boolean canInteract_placedBlock(PlayerInteractEvent playerInteractEvent) {
        return ProtectionPlugins.canInteract_block(playerInteractEvent, Flags.PLACED_BLOCK_INTERACT);
    }

    public static boolean canInteract_tradeMachineArmorstand(Player player, Entity entity, boolean bl) {
        return ProtectionPlugins.canInteract_entity(player, entity, Flags.TRADE_MACHINES_USE, bl);
    }

    public static boolean canInteract_tradeMachineArmorstand(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        return ProtectionPlugins.canInteract_entity(playerInteractAtEntityEvent, Flags.TRADE_MACHINES_USE);
    }

    public static boolean canInteract_furniture(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        return ProtectionPlugins.canInteract_entity(playerInteractAtEntityEvent, Flags.PLACED_FURNITURE_INTERACT);
    }

    private static boolean canInteract_block(PlayerInteractEvent playerInteractEvent, StateFlag stateFlag) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testBlockFlag(stateFlag, playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock());
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return playerInteractEvent.useInteractedBlock() != Event.Result.DENY;
    }

    public static boolean canInteract_tradeMachineBlock(CustomBlockInteractEvent customBlockInteractEvent) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testBlockFlag(Flags.TRADE_MACHINES_USE, customBlockInteractEvent.getPlayer(), customBlockInteractEvent.getBlockClicked());
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return !customBlockInteractEvent.isCancelled();
    }

    private static boolean canInteract_entity(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, StateFlag stateFlag) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(stateFlag, playerInteractAtEntityEvent.getPlayer(), playerInteractAtEntityEvent.getRightClicked());
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return !playerInteractAtEntityEvent.isCancelled();
    }

    private static boolean canInteract_entity(Player player, Entity entity, StateFlag stateFlag, boolean bl) {
        if (hasWorldGuard) {
            Flags$Result flags$Result = WorldGuardFlagsManager.testEntityFlag(stateFlag, player, entity);
            if (flags$Result == Flags$Result.ALLOW) {
                return true;
            }
            if (flags$Result == Flags$Result.DENY) {
                return false;
            }
            if (flags$Result == Flags$Result.BYPASS) {
                return true;
            }
        }
        return !bl;
    }

    public static boolean canRideEntitiesVanilla(Player player, Entity entity) {
        if (!hasWorldGuard) {
            return true;
        }
        return WorldGuardFlagsManager.canRideEntitiesVanilla(player, entity);
    }

    public static boolean isWorldguardInteractFlagAllow(Player player, Location location) {
        if (!hasWorldGuard) {
            return true;
        }
        return WorldGuardFlagsManager.isInteractFlagAllow(player, location);
    }
}
