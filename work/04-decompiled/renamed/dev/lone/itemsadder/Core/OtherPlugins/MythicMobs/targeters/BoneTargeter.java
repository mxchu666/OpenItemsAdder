package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.targeters;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.targeters.ILocationTargeter;
import io.lumine.mythic.bukkit.BukkitAdapter;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationHolder_2;
import java.util.Collection;
import java.util.Collections;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class BoneTargeter
implements ILocationTargeter {
    private final String boneName;

    public BoneTargeter(MythicLineConfig mythicLineConfig) {
        this.boneName = mythicLineConfig.getString(new String[]{"bone"});
    }

    public Collection getLocations(SkillMetadata skillMetadata) {
        Entity entity = BukkitAdapter.adapt((AbstractEntity)skillMetadata.getCaster().getEntity());
        if (!(entity instanceof LivingEntity)) {
            CommandSenderBridge_5.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return Collections.emptyList();
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entity);
        if (livingEntityBuilder != null) {
            LocationHolder_2 locationHolder_2 = livingEntityBuilder.an(this.boneName);
            if (locationHolder_2 != null) {
                double[] dArray = locationHolder_2.qw.tv();
                return Collections.singletonList(BukkitAdapter.adapt((Location)new Location(entity.getWorld(), dArray[0], dArray[1], dArray[2])));
            }
            CommandSenderBridge_5.warn("[Mythicmobs] Warning: Unknown bone name for entity " + livingEntityBuilder.es());
        } else {
            String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
            CommandSenderBridge_5.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
        }
        return Collections.emptyList();
    }
}
