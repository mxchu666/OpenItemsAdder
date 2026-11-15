package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs;

import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.drops.CustomItemDrop;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics.BoneMechanic;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics.CustomEntityMechanic;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics.DismountMechanic;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics.MountMechanic;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.targeters.BoneTargeter;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.drops.IDrop;
import io.lumine.mythic.bukkit.events.MythicDropLoadEvent;
import io.lumine.mythic.bukkit.events.MythicMechanicLoadEvent;
import io.lumine.mythic.bukkit.events.MythicTargeterLoadEvent;
import io.lumine.mythic.core.skills.SkillMechanic;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class MythicMobsHook
implements Listener {
    private static MythicMobsHook instance;

    public static MythicMobsHook inst() {
        if (instance == null) {
            instance = new MythicMobsHook();
        }
        return instance;
    }

    public void register(Plugin plugin) {
        ListenerBridge.a(MythicMobsHook.inst(), plugin);
    }

    public static void reload() {
        if (instance != null) {
            try {
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"mythicmobs reload");
            }
            catch (Exception exception) {
                CommandSenderBridge_5.warn("Failed to reload MythicMobs. Probably something is misconfigured in MythicMobs configs.");
                CommandSenderBridge_5.warn("Try to run '/mythicmobs reload' manually to get more info.");
            }
        }
    }

    public void unregister() {
        if (instance != null) {
            ListenerBridge.b(instance);
        }
    }

    @EventHandler
    public void onMythicMechanicLoad(MythicMechanicLoadEvent mythicMechanicLoadEvent) {
        String string;
        SkillMechanic skillMechanic = null;
        switch (string = mythicMechanicLoadEvent.getMechanicName().toLowerCase()) {
            case "customentity": {
                skillMechanic = new CustomEntityMechanic(mythicMechanicLoadEvent.getContainer(), mythicMechanicLoadEvent.getConfig().getLine(), mythicMechanicLoadEvent.getConfig());
                break;
            }
            case "bone": {
                skillMechanic = new BoneMechanic(mythicMechanicLoadEvent.getContainer(), mythicMechanicLoadEvent.getConfig().getLine(), mythicMechanicLoadEvent.getConfig());
                break;
            }
            case "mountentity": {
                skillMechanic = new MountMechanic(mythicMechanicLoadEvent.getContainer(), mythicMechanicLoadEvent.getConfig().getLine(), mythicMechanicLoadEvent.getConfig());
                break;
            }
            case "dismountentity": {
                skillMechanic = new DismountMechanic(mythicMechanicLoadEvent.getContainer(), mythicMechanicLoadEvent.getConfig().getLine(), mythicMechanicLoadEvent.getConfig());
            }
        }
        if (skillMechanic != null) {
            mythicMechanicLoadEvent.register(skillMechanic);
        }
    }

    @EventHandler
    public void onMythicDropLoad(MythicDropLoadEvent mythicDropLoadEvent) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(mythicDropLoadEvent.getConfig().getKey());
        if (itemStackBuilder_4 != null) {
            mythicDropLoadEvent.register((IDrop)new CustomItemDrop(mythicDropLoadEvent.getConfig(), mythicDropLoadEvent.getContainer().getLine(), itemStackBuilder_4));
        }
    }

    @EventHandler
    public void onMythicTargeterLoad(MythicTargeterLoadEvent mythicTargeterLoadEvent) {
        BoneTargeter boneTargeter = null;
        String string = mythicTargeterLoadEvent.getTargeterName();
        switch (string.toLowerCase()) {
            case "bone": {
                boneTargeter = new BoneTargeter(mythicTargeterLoadEvent.getConfig());
            }
        }
        if (boneTargeter != null) {
            mythicTargeterLoadEvent.register(boneTargeter);
        }
    }

    public static boolean hasProp(MythicLineConfig mythicLineConfig, String string) {
        return mythicLineConfig.getString(string) != null;
    }

    @Nullable
    public static Integer getInteger(MythicLineConfig mythicLineConfig, String string) {
        if (MythicMobsHook.hasProp(mythicLineConfig, string)) {
            return mythicLineConfig.getInteger(string);
        }
        return null;
    }

    @Nullable
    public static Boolean getBoolean(MythicLineConfig mythicLineConfig, String string) {
        if (MythicMobsHook.hasProp(mythicLineConfig, string)) {
            return mythicLineConfig.getBoolean(string);
        }
        return null;
    }

    @Nullable
    public static Integer getInteger(MythicLineConfig mythicLineConfig, String[] stringArray) {
        for (String string : stringArray) {
            Integer n = MythicMobsHook.getInteger(mythicLineConfig, string);
            if (n == null) continue;
            return n;
        }
        return null;
    }

    @Nullable
    public static Boolean getBoolean(MythicLineConfig mythicLineConfig, String[] stringArray) {
        for (String string : stringArray) {
            Boolean bl = MythicMobsHook.getBoolean(mythicLineConfig, string);
            if (bl == null) continue;
            return bl;
        }
        return null;
    }
}
