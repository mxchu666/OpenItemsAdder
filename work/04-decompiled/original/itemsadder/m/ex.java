package itemsadder.m;

import java.util.Comparator;
import java.util.List;

public class ex {
    static String rv = "[^\\d.]";

    public static int aN(String string) {
        if ((string = string.replaceAll(rv, "")).isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    public static Comparator hd() {
        return Comparator.comparingDouble(ex::aN);
    }

    public static List k(List list) {
        list.sort(ex.hd());
        return list;
    }
}
