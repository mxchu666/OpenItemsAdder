package itemsadder.m;

import itemsadder.m.apz;
import java.util.HashMap;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;

public class aqf
implements apz {
    static final HashMap alu = new HashMap();

    @Override
    public Particle dM(String object) {
        if (!((String)object).contains(":") && !((String)object).startsWith("minecraft:")) {
            object = "minecraft:" + (String)object;
        }
        return (Particle)alu.get(object);
    }

    static {
        for (Particle particle : Particle.values()) {
            try {
                NamespacedKey namespacedKey = particle.getKey();
                alu.put(namespacedKey.getNamespace() + ":" + namespacedKey.getKey(), particle);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
        }
        alu.put("minecraft:ambient_entity_effect", Particle.ENTITY_EFFECT);
    }
}
