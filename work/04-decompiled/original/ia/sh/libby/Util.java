package ia.sh.libby;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Util {
    private Util() {
        throw new UnsupportedOperationException("Util class.");
    }

    @NotNull
    public static String replaceWithDots(@NotNull String string) {
        return string.replace("{}", ".");
    }

    public static byte[] hexStringToByteArray(@NotNull String string) {
        int n = string.length();
        byte[] byArray = new byte[n / 2];
        for (int i = 0; i < n; i += 2) {
            byArray[i / 2] = (byte)((Character.digit(string.charAt(i), 16) << 4) + Character.digit(string.charAt(i + 1), 16));
        }
        return byArray;
    }

    @NotNull
    public static String craftPartialPath(@NotNull String string, @NotNull String string2, @NotNull String string3) {
        return string2.replace('.', '/') + '/' + string + '/' + string3 + '/';
    }

    @NotNull
    public static String craftPath(@NotNull String string, @NotNull String string2, @NotNull String string3, @Nullable String string4) {
        String string5 = string + string2 + '-' + string3;
        if (string4 != null && !string4.isEmpty()) {
            string5 = string5 + '-' + string4;
        }
        return string5 + ".jar";
    }
}
