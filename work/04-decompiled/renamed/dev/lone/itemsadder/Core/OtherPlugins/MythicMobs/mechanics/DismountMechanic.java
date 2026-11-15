package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.mechanics;

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

public class DismountMechanic
extends SkillMechanic
implements ITargetedEntitySkill {
    private final String[] seatsNames;
    private final boolean all;

    public DismountMechanic(CustomMechanic customMechanic, String string, MythicLineConfig mythicLineConfig) {
        super(customMechanic.getManager(), string, mythicLineConfig);
        this.setAsyncSafe(false);
        String string2 = mythicLineConfig.getString(new String[]{"bones"});
        this.seatsNames = string2.contains(",") ? string2.split(",") : new String[]{string2};
        this.all = mythicLineConfig.getBoolean("all");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            CommandSenderBridge_5.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return SkillResult.INVALID_TARGET;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        if (livingEntityBuilder != null) {
            if (this.all) {
                LivingEntityRegistry.db().f(livingEntityBuilder);
                return SkillResult.SUCCESS;
            }
            if (this.seatsNames == null) return SkillResult.INVALID_CONFIG;
            int n = 0;
            String[] stringArray = this.seatsNames;
            int n2 = stringArray.length;
            if (n >= n2) return SkillResult.CONDITION_FAILED;
            String string = stringArray[n];
            LivingEntityArmorStandHolder livingEntityArmorStandHolder = livingEntityBuilder.as(string);
            if (livingEntityArmorStandHolder == null) return SkillResult.INVALID_CONFIG;
            if (!(abstractEntity.getBukkitEntity() instanceof LivingEntity)) return SkillResult.INVALID_CONFIG;
            LivingEntityRegistry.db().a(livingEntityArmorStandHolder);
            return SkillResult.SUCCESS;
        }
        String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
        CommandSenderBridge_5.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
        return SkillResult.INVALID_TARGET;
    }
}
