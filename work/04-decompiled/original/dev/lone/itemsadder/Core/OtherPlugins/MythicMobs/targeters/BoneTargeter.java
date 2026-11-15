package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.targeters;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.targeters.ILocationTargeter;
import io.lumine.mythic.bukkit.BukkitAdapter;
import itemsadder.m.bce;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.ej;
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
            bce.error("Error loading MythicMobs entity: " + entity.getName() + ". You must use only living entities. For example: ZOMBIE, SKELETON...");
            return Collections.emptyList();
        }
        dn dn2 = da.db().h(entity);
        if (dn2 != null) {
            ej ej2 = dn2.an(this.boneName);
            if (ej2 != null) {
                double[] dArray = ej2.qw.tv();
                return Collections.singletonList(BukkitAdapter.adapt((Location)new Location(entity.getWorld(), dArray[0], dArray[1], dArray[2])));
            }
            bce.warn("[Mythicmobs] Warning: Unknown bone name for entity " + dn2.es());
        } else {
            String string = String.valueOf(entity.getUniqueId()) + " " + entity.getName() + " - " + String.valueOf(entity.getLocation());
            bce.warn("Warning: MythicMobs entity " + string + " is not a custom entity!");
        }
        return Collections.emptyList();
    }
}
