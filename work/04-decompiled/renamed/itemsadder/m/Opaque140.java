package itemsadder.m;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Opaque140 {
    public String bL;
    public String bM;

    public Opaque140(String string, String string2) {
        this.bL = string;
        this.bM = string2;
    }

    public String getNamespacedID() {
        return this.bL + ":" + this.bM;
    }

    public String getNamespace() {
        return this.bL;
    }

    public void H(String string) {
        this.bL = string;
    }

    public String getId() {
        return this.bM;
    }

    public void I(String string) {
        this.bM = string;
    }

    public String toString() {
        return this.bL + ":" + this.bM;
    }

    @Nullable
    public static String i(String string, @NotNull String string2) {
        Opaque140 opaque140 = Opaque140.j(string, string2);
        if (opaque140 == null) {
            return null;
        }
        return opaque140.toString();
    }

    @Nullable
    public static Opaque140 j(String string, @NotNull String string2) {
        String string3;
        String[] stringArray = string.split(":", 3);
        if (stringArray.length > 2) {
            return null;
        }
        String string4 = string3 = stringArray.length == 2 ? stringArray[1] : "";
        if (stringArray.length == 1) {
            String string5 = stringArray[0];
            if (string5.isEmpty() || !Opaque140.K(string5)) {
                return null;
            }
            return new Opaque140(string2, string5);
        }
        if (stringArray.length == 2 && !Opaque140.K(string3)) {
            return null;
        }
        String string6 = stringArray[0];
        if (string6.isEmpty()) {
            return new Opaque140(string2, string3);
        }
        if (!Opaque140.J(string6)) {
            return null;
        }
        return new Opaque140(string6, string3);
    }

    private static boolean J(String string) {
        int n = string.length();
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (Opaque140.b(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    private static boolean K(String string) {
        int n = string.length();
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (Opaque140.a(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    private static boolean a(char c) {
        return Opaque140.b(c) || c == '/';
    }

    private static boolean b(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '.' || c == '_' || c == '-';
    }
}
