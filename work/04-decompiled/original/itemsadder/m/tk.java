package itemsadder.m;

import java.lang.reflect.Field;
import org.bukkit.Color;
import org.jetbrains.annotations.Nullable;

public final class tk {
    private tk() {
    }

    @Nullable
    public static Integer co(@Nullable String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        if (string2.isEmpty()) {
            return null;
        }
        Integer n = tk.cp(string2);
        if (n != null) {
            return n;
        }
        n = tk.cq(string2);
        if (n != null) {
            return n;
        }
        n = tk.cr(string2);
        if (n != null) {
            return n;
        }
        n = tk.cs(string2);
        if (n != null) {
            return n;
        }
        return null;
    }

    @Nullable
    private static Integer cp(String string) {
        if (!string.contains(",")) {
            return null;
        }
        String[] stringArray = string.split(",");
        if (stringArray.length != 3) {
            return null;
        }
        try {
            int n = tk.aw(Integer.parseInt(stringArray[0].trim()));
            int n2 = tk.aw(Integer.parseInt(stringArray[1].trim()));
            int n3 = tk.aw(Integer.parseInt(stringArray[2].trim()));
            return n << 16 | n2 << 8 | n3;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private static int aw(int n) {
        if (n < 0) {
            return 0;
        }
        if (n > 255) {
            return 255;
        }
        return n;
    }

    @Nullable
    private static Integer cq(String string) {
        String string2 = string.trim().replace(' ', '_').replace('-', '_').toUpperCase();
        try {
            Field field = Color.class.getField(string2);
            Object object = field.get(null);
            if (object instanceof Color) {
                Color color = (Color)object;
                return color.asRGB() & 0xFFFFFF;
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        return null;
    }

    @Nullable
    private static Integer cr(String string) {
        int n;
        Object object = string.trim();
        if (((String)object).startsWith("#")) {
            object = ((String)object).substring(1);
        } else if (((String)object).startsWith("0x") || ((String)object).startsWith("0X")) {
            object = ((String)object).substring(2);
        }
        if (!((String)object).matches("^[0-9a-fA-F]+$")) {
            return null;
        }
        if (((String)object).length() == 3) {
            n = ((String)object).charAt(0);
            char c = ((String)object).charAt(1);
            char c2 = ((String)object).charAt(2);
            object = "" + (char)n + (char)n + c + c + c2 + c2;
        } else if (((String)object).length() == 4) {
            n = ((String)object).charAt(0);
            char c = ((String)object).charAt(1);
            char c3 = ((String)object).charAt(2);
            char c4 = ((String)object).charAt(3);
            String string2 = "" + c + c;
            String string3 = "" + c3 + c3;
            String string4 = "" + c4 + c4;
            object = string2 + string3 + string4;
        } else if (((String)object).length() == 8) {
            object = ((String)object).substring(2);
        } else if (((String)object).length() != 6) {
            return null;
        }
        try {
            n = (int)Long.parseLong((String)object, 16);
            return n & 0xFFFFFF;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Nullable
    private static Integer cs(String string) {
        if (!string.matches("^[+-]?\\d+$")) {
            return null;
        }
        try {
            int n = Integer.parseInt(string);
            return n & 0xFFFFFF;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}
