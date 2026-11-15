package itemsadder.m;

import itemsadder.m.RegexEnum;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_21
extends Record {
    private final RegexEnum bH;
    private final String pattern;

    public RecordOfValue_21(RegexEnum regexEnum, String string) {
        this.bH = regexEnum;
        this.pattern = string;
    }

    public static RecordOfValue_21 E(String string) {
        if (string.startsWith("*") || string.startsWith("?") || string.endsWith("*") || string.endsWith("?")) {
            return new RecordOfValue_21(RegexEnum.WILDCARD, string);
        }
        if (string.matches("[a-zA-Z0-9_:-]+") && string.chars().filter(n -> n == 58).count() <= 1L) {
            return new RecordOfValue_21(RegexEnum.EXACT, string);
        }
        return new RecordOfValue_21(RegexEnum.REGEX, string);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_21.class, "type;pattern", "bH", "pattern"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_21.class, "type;pattern", "bH", "pattern"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_21.class, "type;pattern", "bH", "pattern"}, this, object);
    }

    public RegexEnum W() {
        return this.bH;
    }

    public String X() {
        return this.pattern;
    }
}
