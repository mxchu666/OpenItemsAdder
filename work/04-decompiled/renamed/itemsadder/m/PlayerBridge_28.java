package itemsadder.m;

import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_27;
import java.util.UUID;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_28
extends PlayerBridge_27 {
    private final String cd = "ia_player_stats";

    public PlayerBridge_28(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        super(plugin, itemStackRegistry);
    }

    @Override
    public boolean a(Player player, String string) {
        return player.getPersistentDataContainer().has(new NamespacedKey("ia_player_stats", string));
    }

    @Override
    public void a(Player player, String string, float f) {
        player.getPersistentDataContainer().set(new NamespacedKey("ia_player_stats", string), PersistentDataType.FLOAT, (Object)Float.valueOf(f));
    }

    @Override
    @Nullable
    public Float a(Player player, String string, @Nullable Float f) {
        NamespacedKey namespacedKey = new NamespacedKey("ia_player_stats", string);
        if (!player.getPersistentDataContainer().has(namespacedKey, PersistentDataType.FLOAT)) {
            return f;
        }
        return (Float)player.getPersistentDataContainer().getOrDefault(namespacedKey, PersistentDataType.FLOAT, (Object)Float.valueOf(0.0f));
    }

    @Override
    void a(UUID uUID) {
    }

    @Override
    public void ak() {
    }

    @Override
    public void e(boolean bl) {
    }
}
