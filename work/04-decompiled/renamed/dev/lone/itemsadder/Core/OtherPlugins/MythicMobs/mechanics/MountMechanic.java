package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics;

import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.MythicMobsHook;
import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.ITargetedEntitySkill;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.SkillResult;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.core.skills.SkillMechanic;
import io.lumine.mythic.core.skills.mechanics.CustomMechanic;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class MountMechanic
extends SkillMechanic
implements ITargetedEntitySkill {
    private final String seatName;
    @Nullable
    private final Boolean locked;
    @Nullable
    private final Boolean control;

    public MountMechanic(CustomMechanic customMechanic, String string, MythicLineConfig mythicLineConfig) {
        super(customMechanic.getManager(), string, mythicLineConfig);
        this.setAsyncSafe(false);
        this.seatName = mythicLineConfig.getString(new String[]{"bone"});
        this.locked = MythicMobsHook.getBoolean(mythicLineConfig, new String[]{"locked", "lock"});
        this.control = MythicMobsHook.getBoolean(mythicLineConfig, new String[]{"control"});
    }

    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            CommandSenderBridge_5.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return SkillResult.INVALID_TARGET;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        if (livingEntityBuilder != null) {
            if (this.seatName != null) {
                LivingEntityArmorStandHolder livingEntityArmorStandHolder = livingEntityBuilder.as(this.seatName);
                if (livingEntityArmorStandHolder != null) {
                    if (abstractEntity.getBukkitEntity() instanceof LivingEntity) {
                        if (this.locked != null) {
                            livingEntityArmorStandHolder.b(this.locked);
                        }
                        LivingEntityRegistry.db().a((LivingEntity)abstractEntity.getBukkitEntity(), livingEntityArmorStandHolder);
                        if (this.control != null) {
                            livingEntityArmorStandHolder.setCanControl(this.control);
                        }
                        return SkillResult.SUCCESS;
                    }
                    return SkillResult.INVALID_CONFIG;
                }
                return SkillResult.INVALID_CONFIG;
            }
            return SkillResult.INVALID_CONFIG;
        }
        String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
        CommandSenderBridge_5.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
        return SkillResult.INVALID_TARGET;
    }
}
