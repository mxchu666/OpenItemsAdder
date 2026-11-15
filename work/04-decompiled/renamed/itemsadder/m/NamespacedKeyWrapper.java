package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.FurnaceStartSmeltListener;
import itemsadder.m.ItemStackBridgeImpl;
import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.Opaque139;
import itemsadder.m.PrepareAnvilListener;
import itemsadder.m.PrepareItemCraftListener;
import itemsadder.m.PrepareSmithingListener;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

public interface NamespacedKeyWrapper {
    public String ra();

    public void a(NamespacedKeyItemStackHolder var1, String var2, String var3);

    public List w(ItemStackBuilder_4 var1);

    public List x(ItemStackBuilder_4 var1);

    default public Set f(LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List list = (List)ItemStackRegistry.g().aq.Ld.get(locationBridgeBuilder_2);
        if (list != null) {
            for (ItemStackBridgeImpl itemStackBridgeImpl : list) {
                for (ItemStackBridge_32 itemStackBridge_32 : itemStackBridgeImpl.qx()) {
                    if (!itemStackBridge_32.oQ() || locationBridgeBuilder_2.l(itemStackBridge_32.oP())) continue;
                    Set set = NamespacedKeyWrapper.b(itemStackBridge_32.oP(), true);
                    linkedHashSet.addAll(set);
                }
            }
        }
        return linkedHashSet;
    }

    public static Set b(ItemStackBuilder_4 itemStackBuilder_4, boolean bl) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        PrepareItemCraftListener prepareItemCraftListener = itemStackRegistry.aX;
        FurnaceStartSmeltListener furnaceStartSmeltListener = itemStackRegistry.aY;
        PrepareAnvilListener prepareAnvilListener = itemStackRegistry.ba;
        PrepareSmithingListener prepareSmithingListener = itemStackRegistry.aZ;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (prepareItemCraftListener != null) {
            linkedHashSet.addAll(prepareItemCraftListener.y(itemStackBuilder_4));
        }
        if (furnaceStartSmeltListener != null) {
            linkedHashSet.addAll(furnaceStartSmeltListener.y(itemStackBuilder_4));
        }
        if (prepareAnvilListener != null) {
            linkedHashSet.addAll(prepareAnvilListener.y(itemStackBuilder_4));
        }
        if (prepareSmithingListener != null) {
            linkedHashSet.addAll(prepareSmithingListener.y(itemStackBuilder_4));
        }
        if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = (LocationBridgeBuilder_2)itemStackBuilder_4;
            if (prepareItemCraftListener != null) {
                linkedHashSet.addAll(prepareItemCraftListener.f(locationBridgeBuilder_2));
            }
            if (furnaceStartSmeltListener != null) {
                linkedHashSet.addAll(furnaceStartSmeltListener.f(locationBridgeBuilder_2));
            }
            if (prepareAnvilListener != null) {
                linkedHashSet.addAll(prepareAnvilListener.f(locationBridgeBuilder_2));
            }
            if (prepareSmithingListener != null) {
                linkedHashSet.addAll(prepareSmithingListener.f(locationBridgeBuilder_2));
            }
        }
        if (bl) {
            boolean bl2 = false;
            for (NamespacedKeyItemStackHolder namespacedKeyItemStackHolder : linkedHashSet) {
                if (itemStackBuilder_4.l(namespacedKeyItemStackHolder.qO())) {
                    bl2 = false;
                    break;
                }
                bl2 = true;
            }
            if (bl2 || linkedHashSet.isEmpty()) {
                NamespacedKeyItemStackHolder namespacedKeyItemStackHolder;
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                namespacedKeyItemStackHolder = itemStackRegistry.aW.s(itemStackBuilder_4);
                if (!linkedHashSet.contains(namespacedKeyItemStackHolder)) {
                    linkedHashSet2.add(namespacedKeyItemStackHolder);
                }
                linkedHashSet2.addAll(linkedHashSet);
                return linkedHashSet2;
            }
        }
        return linkedHashSet;
    }

    default public NamespacedKey a(Map map, NamespacedKeyItemStackHolder namespacedKeyItemStackHolder, NamespacedKey namespacedKey, String string, String string2) {
        @Nullable NamespacedKeyItemStackHolder namespacedKeyItemStackHolder2 = (NamespacedKeyItemStackHolder)map.get(namespacedKey.toString());
        if (namespacedKeyItemStackHolder2 != null) {
            if (namespacedKeyItemStackHolder.nP != null && namespacedKeyItemStackHolder2.nP != null) {
                String string3 = namespacedKeyItemStackHolder.nP.getFile().getName().replace(".yml", "");
                namespacedKey = new NamespacedKey(string.toLowerCase(), string2.toLowerCase() + "_" + string3);
                CommandSenderBridge_5.warn("[Recipes] Duplicate '" + namespacedKeyItemStackHolder.LY + "'. Registering it anyway with new name '" + String.valueOf(namespacedKey) + "'. Files: " + namespacedKeyItemStackHolder2.nP.nh() + " and " + namespacedKeyItemStackHolder.nP.nh());
                return namespacedKey;
            }
            CommandSenderBridge_5.error("[Recipes] '" + namespacedKeyItemStackHolder.LY + "' already exists. Can't register it. No config file for some reason? Wtf? Is it an internal ItemAdder recipe?");
            throw new Opaque139("Recipe already exists. Unexpected error!");
        }
        return namespacedKey;
    }
}
