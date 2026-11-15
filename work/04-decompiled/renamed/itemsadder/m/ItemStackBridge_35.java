package itemsadder.m;

import itemsadder.m.IntBoolRefData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PatternLinesLength;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
import itemsadder.m.SoundCategoryBridge_3;
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

public class ItemStackBridge_35
extends NamespacedKeyItemStackHolder {
    List MK;
    private String @Nullable [] ML;
    public String @Nullable [] MM;
    public boolean MN;
    HashMap MO;
    HashMap MP;
    HashMap MQ;
    SoundCategoryBridge_3 MR;
    public boolean MS;

    public ItemStackBridge_35(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, SoundCategoryBridge_3 soundCategoryBridge_3, ItemStack itemStack, String[] stringArray, List list) {
        super(pluginFileConfigurationHolder, string, string2, itemStack);
        this.a(hashMap, hashMap2, hashMap3, soundCategoryBridge_3, stringArray, list);
    }

    public ItemStackBridge_35(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, SoundCategoryBridge_3 soundCategoryBridge_3, ItemStack itemStack, List list) {
        super(pluginFileConfigurationHolder, string, string2, itemStack);
        this.a(hashMap, hashMap2, hashMap3, soundCategoryBridge_3, null, list);
    }

    public void a(HashMap hashMap, HashMap hashMap2, HashMap hashMap3, SoundCategoryBridge_3 soundCategoryBridge_3, @Nullable String[] stringArray, List list) {
        this.MP = new HashMap();
        this.MQ = new HashMap();
        this.MO = hashMap;
        this.MR = soundCategoryBridge_3;
        this.MK = list;
        if (stringArray != null) {
            ItemStackBridge_35.a(stringArray);
            this.ML = stringArray;
            @Nullable String[] stringArray2 = PatternLinesLength.d(stringArray);
            if (stringArray2 != null) {
                this.MN = true;
                this.ML = stringArray2;
                this.MM = this.ML;
            }
            this.MM = PatternLinesLength.b(stringArray);
        } else {
            this.MS = true;
            this.ML = null;
            this.MN = false;
            this.Mc = list.size();
        }
        hashMap2.forEach((itemStack, n) -> this.MP.put(itemStack, new IntBoolRefData((int)n, ItemStackBuilder_4.isCustomItem(itemStack), ItemStackRegistry.g().a((ItemStack)itemStack))));
        hashMap3.forEach((itemStack, n) -> this.MQ.put(itemStack, new IntBoolRefData((int)n, ItemStackBuilder_4.isCustomItem(itemStack), ItemStackRegistry.g().a((ItemStack)itemStack))));
    }

    public ItemStackBridge_35(ItemStack itemStack) {
        super(itemStack);
        this.ML = new String[]{"xxx", "xxx", "xxx"};
        this.MK = new ArrayList();
    }

    public List rl() {
        return this.MK;
    }

    public RecipeChoiceItemStackHolder_2 a(Character c) {
        for (RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 : this.MK) {
            if (recipeChoiceItemStackHolder_2.ri().compareTo(c) != 0) continue;
            return recipeChoiceItemStackHolder_2;
        }
        return null;
    }

    public ItemStack b(Character c) {
        RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 = this.a(c);
        if (recipeChoiceItemStackHolder_2 != null) {
            return recipeChoiceItemStackHolder_2.getItem();
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

    public SoundCategoryBridge_3 rq() {
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
            return PlayerHolder_5.vq().a((ShapedRecipe)this.qR(), craftingInventory);
        }
        int n = 0;
        block0: for (RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 : this.MK) {
            if (recipeChoiceItemStackHolder_2 == null || recipeChoiceItemStackHolder_2.ri().charValue() == ' ' || recipeChoiceItemStackHolder_2.getItem() == null || recipeChoiceItemStackHolder_2.getItem().getType() == Material.AIR) continue;
            for (ItemStack itemStack : craftingInventory.getMatrix()) {
                if (itemStack == null || itemStack.getType() == Material.AIR || !recipeChoiceItemStackHolder_2.e(itemStack)) continue;
                ++n;
                continue block0;
            }
        }
        return n == this.MK.size();
    }

    public Map rr() {
        int n;
        HashMap<Integer, RecipeChoiceItemStackHolder_2> hashMap = new HashMap<Integer, RecipeChoiceItemStackHolder_2>();
        for (n = 0; n < 9; ++n) {
            hashMap.put(n, null);
        }
        if (this.ML != null) {
            for (n = 0; n < this.ML.length; ++n) {
                String string = this.ML[n];
                for (int i = 0; i < string.length(); ++i) {
                    char c = string.charAt(i);
                    RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2 = this.a(Character.valueOf(c));
                    if (recipeChoiceItemStackHolder_2 == null) continue;
                    hashMap.put(n * 3 + i, recipeChoiceItemStackHolder_2);
                }
            }
        } else {
            for (n = 0; n < this.MK.size(); ++n) {
                hashMap.put(n, (RecipeChoiceItemStackHolder_2)this.MK.get(n));
            }
        }
        return hashMap;
    }
}
