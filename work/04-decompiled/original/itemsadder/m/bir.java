package itemsadder.m;

import itemsadder.m.bio;
import itemsadder.m.bit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import org.bukkit.inventory.ItemStack;

public class bir {
    private final List aEj = new ArrayList();
    private final Map aEk = new HashMap();
    private final Map aEl = new HashMap();
    private char aEm;

    public bir jr(String string) {
        Objects.requireNonNull(string);
        this.aEj.add(string.length() > 9 ? string.substring(0, 10) : string);
        return this;
    }

    public bir m(String ... stringArray) {
        for (String string : Objects.requireNonNull(stringArray)) {
            this.jr(string);
        }
        return this;
    }

    public bir a(char c, ItemStack itemStack, Consumer consumer) {
        this.aEk.put(Character.valueOf(c), Objects.requireNonNull(itemStack));
        if (consumer != null) {
            this.aEl.put(Character.valueOf(c), consumer);
        }
        return this;
    }

    public bir a(char c, ItemStack itemStack) {
        return this.a(c, itemStack, null);
    }

    public bir l(char c) {
        this.aEm = c;
        return this;
    }

    public bir m(char c) {
        this.aEk.remove(Character.valueOf(c));
        this.aEl.remove(Character.valueOf(c));
        return this;
    }

    public void a(bio bio2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < this.aEj.size(); ++i) {
            String string = (String)this.aEj.get(i);
            for (int j = 0; j < string.length(); ++j) {
                char c = string.charAt(j);
                if (c == this.aEm) {
                    arrayList.add(9 * i + j);
                    continue;
                }
                ItemStack itemStack = (ItemStack)this.aEk.get(Character.valueOf(c));
                Consumer consumer = (Consumer)this.aEl.get(Character.valueOf(c));
                if (itemStack == null) continue;
                bio2.a(9 * i + j, itemStack, consumer);
            }
        }
        if (bio2 instanceof bit && !arrayList.isEmpty()) {
            ((bit)bio2).V(arrayList);
        }
    }
}
