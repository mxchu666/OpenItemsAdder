package itemsadder.m;

import itemsadder.m.DFunction;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.jetbrains.annotations.NotNull;

public class ListenerBridge_2
implements EventExecutor {
    private final Class aCM;
    private final DFunction aCN;

    public ListenerBridge_2(Class clazz, DFunction dFunction) {
        this.aCM = clazz;
        this.aCN = dFunction;
    }

    public void execute(@NotNull Listener listener, @NotNull Event event) {
        if (this.aCM.isInstance(event)) {
            this.aCN.d((Event)this.aCM.cast(event));
        }
    }
}
