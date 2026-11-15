package itemsadder.m;

import itemsadder.m.DMFunction;
import java.util.HashMap;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;

public class BlockNms_1_21_8_14
implements DMFunction {
    static final HashMap alz = new HashMap();

    @Override
    public Particle dM(String object) {
        if (!((String)object).contains(":") && !((String)object).startsWith("minecraft:")) {
            object = "minecraft:" + (String)object;
        }
        return (Particle)alz.get(object);
    }

    static {
        for (Particle particle : Particle.values()) {
            try {
                NamespacedKey namespacedKey = particle.getKey();
                alz.put(namespacedKey.getNamespace() + ":" + namespacedKey.getKey(), particle);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
        }
        alz.put("minecraft:ambient_entity_effect", Particle.ENTITY_EFFECT);
    }
}
