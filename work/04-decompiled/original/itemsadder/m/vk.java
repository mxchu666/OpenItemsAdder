package itemsadder.m;

import itemsadder.m.asg;
import itemsadder.m.bbf;
import itemsadder.m.d;
import itemsadder.m.od;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.vj;
import itemsadder.m.vl;
import itemsadder.m.vt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.jetbrains.annotations.Nullable;

public class vk
extends uw {
    List MK;
    private String @Nullable [] ML;
    public String @Nullable [] MM;
    public boolean MN;
    HashMap MO;
    HashMap MP;
    HashMap MQ;
    od MR;
    public boolean MS;

    public vk(bbf bbf2, String string, String string2, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, od od2, ItemStack itemStack, String[] stringArray, List list) {
        super(bbf2, string, string2, itemStack);
        this.a(hashMap, hashMap2, hashMap3, od2, stringArray, list);
    }

    public vk(bbf bbf2, String string, String string2, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, od od2, ItemStack itemStack, List list) {
        super(bbf2, string, string2, itemStack);
        this.a(hashMap, hashMap2, hashMap3, od2, null, list);
    }

    public void a(HashMap hashMap, HashMap hashMap2, HashMap hashMap3, od od2, @Nullable String[] stringArray, List list) {
        this.MP = new HashMap();
        this.MQ = new HashMap();
        this.MO = hashMap;
        this.MR = od2;
        this.MK = list;
        if (stringArray != null) {
            vk.a(stringArray);
            this.ML = stringArray;
            @Nullable String[] stringArray2 = vt.d(stringArray);
            if (stringArray2 != null) {
                this.MN = true;
                this.ML = stringArray2;
                this.MM = this.ML;
            }
            this.MM = vt.b(stringArray);
        } else {
            this.MS = true;
            this.ML = null;
            this.MN = false;
            this.Mc = list.size();
        }
        hashMap2.forEach((itemStack, n) -> this.MP.put(itemStack, new vl((int)n, qm.isCustomItem(itemStack), d.g().a((ItemStack)itemStack))));
        hashMap3.forEach((itemStack, n) -> this.MQ.put(itemStack, new vl((int)n, qm.isCustomItem(itemStack), d.g().a((ItemStack)itemStack))));
    }

    public vk(ItemStack itemStack) {
        super(itemStack);
        this.ML = new String[]{"xxx", "xxx", "xxx"};
        this.MK = new ArrayList();
    }

    public List rl() {
        return this.MK;
    }

    public vj a(Character c) {
        for (vj vj2 : this.MK) {
            if (vj2.ri().compareTo(c) != 0) continue;
            return vj2;
        }
        return null;
    }

    public ItemStack b(Character c) {
        vj vj2 = this.a(c);
        if (vj2 != null) {
            return vj2.getItem();
        }
        return new ItemStack(Material.AIR);
    }

    public String @Nullable [] rm() {
        return this.ML;
    }

    public HashMap rn() {
        return this.MO;
    }

    public HashMap ro() {
        return this.MP;
    }

    public HashMap rp() {
        return this.MQ;
    }

    public od rq() {
        return this.MR;
    }

    @Override
    public void e(NamespacedKey namespacedKey) {
        this.LZ = namespacedKey;
    }

    @Override
    public boolean qS() {
        return !this.MK.isEmpty();
    }

    public void a(ShapedRecipe shapedRecipe) {
        if (this.qO() != null) {
            shapedRecipe.setGroup(this.qO().Gh);
        } else {
            shapedRecipe.setGroup(this.qN().getType().toString());
        }
    }

    public void a(ShapelessRecipe shapelessRecipe) {
        if (this.qO() != null) {
            shapelessRecipe.setGroup(this.qO().Gh);
        } else {
            shapelessRecipe.setGroup(this.qN().getType().toString());
        }
    }

    public static void a(String[] stringArray) {
        Arrays.setAll(stringArray, n -> stringArray[n].toLowerCase());
    }

    public boolean a(CraftingInventory craftingInventory) {
        if (!this.MS) {
            return asg.vq().a((ShapedRecipe)this.qR(), craftingInventory);
        }
        int n = 0;
        block0: for (vj vj2 : this.MK) {
            if (vj2 == null || vj2.ri().charValue() == ' ' || vj2.getItem() == null || vj2.getItem().getType() == Material.AIR) continue;
            for (ItemStack itemStack : craftingInventory.getMatrix()) {
                if (itemStack == null || itemStack.getType() == Material.AIR || !vj2.e(itemStack)) continue;
                ++n;
                continue block0;
            }
        }
        return n == this.MK.size();
    }

    public Map rr() {
        int n;
        HashMap<Integer, vj> hashMap = new HashMap<Integer, vj>();
        for (n = 0; n < 9; ++n) {
            hashMap.put(n, null);
        }
        if (this.ML != null) {
            for (n = 0; n < this.ML.length; ++n) {
                String string = this.ML[n];
                for (int i = 0; i < string.length(); ++i) {
                    char c = string.charAt(i);
                    vj vj2 = this.a(Character.valueOf(c));
                    if (vj2 == null) continue;
                    hashMap.put(n * 3 + i, vj2);
                }
            }
        } else {
            for (n = 0; n < this.MK.size(); ++n) {
                hashMap.put(n, (vj)this.MK.get(n));
            }
        }
        return hashMap;
    }
}
