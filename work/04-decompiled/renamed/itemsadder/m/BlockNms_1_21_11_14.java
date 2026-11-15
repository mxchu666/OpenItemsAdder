package itemsadder.m;

import itemsadder.m.DMFunction;
import java.util.HashMap;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;

public class BlockNms_1_21_11_14
implements DMFunction {
    static final HashMap alt = new HashMap();

    @Override
    public Particle dM(String object) {
        if (!((String)object).contains(":") && !((String)object).startsWith("minecraft:")) {
            object = "minecraft:" + (String)object;
        }
        return (Particle)alt.get(object);
    }

    static {
        for (Particle particle : Particle.values()) {
            try {
                NamespacedKey namespacedKey = particle.getKey();
                alt.put(namespacedKey.getNamespace() + ":" + namespacedKey.getKey(), particle);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
        }
        alt.put("minecraft:ambient_entity_effect", Particle.ENTITY_EFFECT);
    }
}
