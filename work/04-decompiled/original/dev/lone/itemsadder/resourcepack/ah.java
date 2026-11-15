package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import dev.lone.itemsadder.resourcepack.aj;
import dev.lone.itemsadder.resourcepack.am;
import itemsadder.m.bcy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

final class ah {
    private final List ath;
    private final Set ati;
    private final Map atj;

    private ah(List list, Map map) {
        this.ath = List.copyOf(list);
        this.ati = list.stream().filter(aj2 -> !aj2.yu().isRemoved()).map(aj::pK).collect(Collectors.toUnmodifiableSet());
        this.atj = Map.copyOf(map);
    }

    private static ah a(Map map, am am2) {
        ArrayList arrayList = new ArrayList(map.size());
        HashMap hashMap = new HashMap(map.size());
        map.forEach((string, packEntry) -> {
            String string2 = bcy.iR(string);
            ++am2.ato;
            arrayList.add(new aj(string2, (ItemsAdderPackCompressedEvent$PackEntry)packEntry));
            hashMap.put(string, string2);
        });
        return new ah(arrayList, hashMap);
    }

    private ah j(Set set) {
        if (set.isEmpty()) {
            return this;
        }
        return new ah(this.ath.stream().filter(aj2 -> !set.contains(aj2.pK())).toList(), this.atj);
    }

    private ItemsAdderPackCompressedEvent$PackEntry fp(String string) {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = null;
        for (aj aj2 : this.ath) {
            if (!aj2.pK().equals(string) || aj2.yu().isRemoved()) continue;
            itemsAdderPackCompressedEvent$PackEntry = aj2.yu();
        }
        return itemsAdderPackCompressedEvent$PackEntry;
    }
}
