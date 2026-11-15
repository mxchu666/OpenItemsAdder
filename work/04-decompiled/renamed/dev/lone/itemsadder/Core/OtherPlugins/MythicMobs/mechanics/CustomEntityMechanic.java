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
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class CustomEntityMechanic
extends SkillMechanic
implements ITargetedEntitySkill {
    private final String namespacedId;
    private final String playerSkin;
    private final String animationPlay;
    private final boolean animationStop;
    private final String animationIdle;
    private final String animationWalk;
    private final String animationAttack;
    private final String animationDeath;

    public CustomEntityMechanic(CustomMechanic customMechanic, String string, MythicLineConfig mythicLineConfig) {
        super(customMechanic.getManager(), string, mythicLineConfig);
        this.setAsyncSafe(false);
        this.playerSkin = mythicLineConfig.getString(new String[]{"playerskin"}, null, new String[0]);
        this.namespacedId = this.playerSkin == null ? mythicLineConfig.getString(new String[]{"id", "model", "entity"}) : "_iainternal:player";
        this.animationPlay = mythicLineConfig.getString(new String[]{"play"});
        this.animationStop = mythicLineConfig.getBoolean("stop");
        this.animationIdle = mythicLineConfig.getString("idle");
        this.animationWalk = mythicLineConfig.getString("walk");
        this.animationAttack = mythicLineConfig.getString("attack");
        this.animationDeath = mythicLineConfig.getString("death");
    }

    /*
     * Enabled aggressive block sorting
     */
    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        LivingEntityBuilder livingEntityBuilder;
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            CommandSenderBridge_5.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return SkillResult.INVALID_TARGET;
        }
        this.setAsyncSafe(false);
        if (this.namespacedId != null) {
            if (!LivingEntityRegistry.db().lJ.containsKey(this.namespacedId)) {
                CommandSenderBridge_5.error("Unknown custom entity id '" + this.namespacedId + "' in MythicMobs config.");
                return SkillResult.CONDITION_FAILED;
            }
            livingEntityBuilder = LivingEntityRegistry.db().a(this.namespacedId, this.playerSkin, (LivingEntity)entity, true, true, false, true);
        } else {
            livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        }
        this.setAsyncSafe(true);
        if (livingEntityBuilder == null) {
            String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
            CommandSenderBridge_5.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
            return SkillResult.INVALID_TARGET;
        }
        if (this.animationIdle != null) {
            livingEntityBuilder.c(livingEntityBuilder.ar(this.animationIdle));
        }
        if (this.animationWalk != null) {
            livingEntityBuilder.d(livingEntityBuilder.ar(this.animationWalk));
        }
        if (this.animationAttack != null) {
            livingEntityBuilder.e(livingEntityBuilder.ar(this.animationAttack));
        }
        if (this.animationDeath != null) {
            livingEntityBuilder.f(livingEntityBuilder.ar(this.animationDeath));
        }
        if (this.animationStop) {
            livingEntityBuilder.ec().gm();
            return SkillResult.SUCCESS;
        }
        if (this.animationPlay == null) return SkillResult.SUCCESS;
        livingEntityBuilder.playAnim(this.animationPlay, 0);
        return SkillResult.SUCCESS;
    }
}
