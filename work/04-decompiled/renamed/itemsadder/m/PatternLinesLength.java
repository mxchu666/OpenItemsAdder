package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PatternLinesLength {
    public static String[] b(String[] stringArray) {
        String[] stringArray2 = new String[stringArray.length];
        System.arraycopy(stringArray, 0, stringArray2, 0, stringArray.length);
        for (int i = 0; i < stringArray2.length; ++i) {
            String[] stringArray3 = stringArray2[i].split("");
            if (stringArray3.length == 2) {
                stringArray2[i] = "x" + stringArray2[i];
                continue;
            }
            if (stringArray3.length != 1) continue;
            stringArray2[i] = "xx" + stringArray2[i];
        }
        return stringArray2;
    }

    public static int c(String[] stringArray) {
        @Nullable Integer n = null;
        for (String string : stringArray) {
            if (n == null) {
                n = string.length();
                continue;
            }
            if (n.intValue() == string.length()) continue;
            throw new IllegalArgumentException("Invalid pattern lines length. Each line must have the same length!");
        }
        if (n == null) {
            throw new IllegalArgumentException("No line? Invalid pattern!");
        }
        return n;
    }

    @Nullable
    public static String[] d(String[] stringArray) {
        int n;
        int n2;
        int n3 = Integer.MAX_VALUE;
        int n4 = -1;
        int n5 = Integer.MAX_VALUE;
        int n6 = -1;
        for (n2 = 0; n2 < stringArray.length; ++n2) {
            for (n = 0; n < stringArray[n2].length(); ++n) {
                char c = stringArray[n2].charAt(n);
                if (c == 'x' || c == ' ') continue;
                n3 = Math.min(n3, n2);
                n4 = Math.max(n4, n2);
                n5 = Math.min(n5, n);
                n6 = Math.max(n6, n);
            }
        }
        if (n4 == -1) {
            return null;
        }
        n2 = n4 - n3 + 1;
        n = n6 - n5 + 1;
        if (n2 != 2 || n != 2) {
            return null;
        }
        String[] stringArray2 = new String[2];
        for (int i = 0; i < 2; ++i) {
            stringArray2[i] = stringArray[n3 + i].substring(n5, n5 + 2);
        }
        return stringArray2;
    }

    private static int b(ItemStack[] itemStackArray) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            int n2 = 0;
            for (int j = 0; j < 3; ++j) {
                if (ItemStackBridge_2.at(itemStackArray[j * 3 + i])) continue;
                ++n2;
            }
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }

    private static int c(ItemStack[] itemStackArray) {
        @Nullable Integer n = null;
        for (int i = 0; i < 3; ++i) {
            int n2 = 0;
            for (int j = 0; j < 3; ++j) {
                if (ItemStackBridge_2.at(itemStackArray[i * 3 + j])) continue;
                ++n2;
            }
            if (n == null) {
                n = n2;
                continue;
            }
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }
}
