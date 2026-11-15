package itemsadder.m;

import itemsadder.m.bey;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.jetbrains.annotations.NotNull;

public class bex
implements EventExecutor {
    private final Class aCM;
    private final bey aCN;

    public bex(Class clazz, bey bey2) {
        this.aCM = clazz;
        this.aCN = bey2;
    }

    public void execute(@NotNull Listener listener, @NotNull Event event) {
        if (this.aCM.isInstance(event)) {
            this.aCN.d((Event)this.aCM.cast(event));
        }
    }
}
