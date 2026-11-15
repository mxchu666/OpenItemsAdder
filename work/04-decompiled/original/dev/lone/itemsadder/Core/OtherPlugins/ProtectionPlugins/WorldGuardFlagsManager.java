package dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.Plugins.Flags;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.Plugins.Flags$Result;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import itemsadder.m.bce;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class WorldGuardFlagsManager {
    private static boolean areFlagsRegistered;
    private static FlagRegistry registry;

    public static void registerFlags() {
        try {
            if (!ProtectionPlugins.hasWorldGuard) {
                return;
            }
            if (areFlagsRegistered) {
                return;
            }
            areFlagsRegistered = true;
            registry = WorldGuard.getInstance().getFlagRegistry();
            Flags.FURNITURE_SIT = WorldGuardFlagsManager.registerFlag("ia-furniture-sit");
            Flags.VEHICLE_SIT = WorldGuardFlagsManager.registerFlag("ia-vehicle-sit", false);
            Flags.VEHICLE_PLACE = WorldGuardFlagsManager.registerFlag("ia-vehicle-place", false);
            Flags.VEHICLE_REMOVE = WorldGuardFlagsManager.registerFlag("ia-vehicle-remove", false);
            Flags.VEHICLE_PERSONAL_SIT = WorldGuardFlagsManager.registerFlag("ia-vehicle-personal-sit");
            Flags.VEHICLE_PERSONAL_REMOVE = WorldGuardFlagsManager.registerFlag("ia-vehicle-personal-remove");
            Flags.TRADE_MACHINES_USE = WorldGuardFlagsManager.registerFlag("ia-trade-machine-use");
            Flags.PLACED_BLOCK_INTERACT = WorldGuardFlagsManager.registerFlag("ia-placed-block-interact");
            Flags.PLACED_FURNITURE_INTERACT = WorldGuardFlagsManager.registerFlag("ia-placed-furniture-interact");
        }
        catch (Exception exception) {
            bce.warn("Failed to register flags with WorldGuard. Please check if you have the latest version of WorldGuard installed.", exception);
        }
    }

    static StateFlag registerFlag(String string) {
        return WorldGuardFlagsManager.registerFlag(string, true);
    }

    static StateFlag registerFlag(String string, boolean bl) {
        Flag flag = registry.get(string);
        if (flag instanceof StateFlag) {
            return (StateFlag)flag;
        }
        StateFlag stateFlag = new StateFlag(string, bl);
        registry.register((Flag)stateFlag);
        return stateFlag;
    }

    public static Flags$Result testEntityFlag(StateFlag stateFlag, Player player, Entity entity) {
        return WorldGuardFlagsManager.test(stateFlag, player, entity.getLocation());
    }

    public static Flags$Result testBlockFlag(StateFlag stateFlag, Player player, Block block) {
        return WorldGuardFlagsManager.test(stateFlag, player, block.getLocation());
    }

    private static boolean hasBypass(LocalPlayer localPlayer, Location location) {
        return WorldGuard.getInstance().getPlatform().getSessionManager().hasBypass(localPlayer, BukkitAdapter.adapt((World)location.getWorld()));
    }

    public static Flags$Result test(StateFlag stateFlag, Player player, Location location) {
        RegionQuery regionQuery = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        com.sk89q.worldedit.util.Location location2 = BukkitAdapter.adapt((Location)location);
        if (regionQuery.getApplicableRegions(location2).getRegions().isEmpty()) {
            return Flags$Result.NO_REGION;
        }
        if (WorldGuardFlagsManager.hasBypass(localPlayer, location)) {
            return Flags$Result.BYPASS;
        }
        if (regionQuery.testState(location2, localPlayer, new StateFlag[]{stateFlag})) {
            return Flags$Result.ALLOW;
        }
        return Flags$Result.DENY;
    }

    public static boolean canRideEntitiesVanilla(Player player, Entity entity) {
        RegionQuery regionQuery = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
        Location location = entity.getLocation();
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        StateFlag.State state = regionQuery.queryState(BukkitAdapter.adapt((Location)location), localPlayer, new StateFlag[]{com.sk89q.worldguard.protection.flags.Flags.RIDE});
        bce.iA("WorldGuard RIDE flag: " + String.valueOf(state));
        return state != StateFlag.State.DENY;
    }

    public static boolean isInteractFlagAllow(Player player, Location location) {
        RegionQuery regionQuery = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        StateFlag.State state = regionQuery.queryState(BukkitAdapter.adapt((Location)location), localPlayer, new StateFlag[]{com.sk89q.worldguard.protection.flags.Flags.INTERACT});
        bce.iA("WorldGuard INTERACT flag: " + String.valueOf(state));
        return state != null;
    }
}
