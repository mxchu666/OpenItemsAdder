package dev.lone.itemsadder;

import dev.lone.itemsadder.m;
import java.util.Arrays;
import java.util.stream.Collectors;

public class l {
    private StringBuilder Qc = new StringBuilder();
    private boolean Qd = false;

    public l() {
        this.Qc.append("{");
    }

    public l cT(String string) {
        this.y(string, "null");
        return this;
    }

    public l x(String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("JSON value must not be null");
        }
        this.y(string, "\"" + l.cU(string2) + "\"");
        return this;
    }

    public l h(String string, int n) {
        this.y(string, String.valueOf(n));
        return this;
    }

    public l a(String string, m m2) {
        if (m2 == null) {
            throw new IllegalArgumentException("JSON object must not be null");
        }
        this.y(string, m2.toString());
        return this;
    }

    public l a(String string2, String[] stringArray) {
        if (stringArray == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        String string3 = Arrays.stream(stringArray).map(string -> "\"" + l.cU(string) + "\"").collect(Collectors.joining(","));
        this.y(string2, "[" + string3 + "]");
        return this;
    }

    public l a(String string, int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        String string2 = Arrays.stream(nArray).mapToObj(String::valueOf).collect(Collectors.joining(","));
        this.y(string, "[" + string2 + "]");
        return this;
    }

    public l a(String string, m[] mArray) {
        if (mArray == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        String string2 = Arrays.stream(mArray).map(m::toString).collect(Collectors.joining(","));
        this.y(string, "[" + string2 + "]");
        return this;
    }

    private void y(String string, String string2) {
        if (this.Qc == null) {
            throw new IllegalStateException("JSON has already been built");
        }
        if (string == null) {
            throw new IllegalArgumentException("JSON key must not be null");
        }
        if (this.Qd) {
            this.Qc.append(",");
        }
        this.Qc.append("\"").append(l.cU(string)).append("\":").append(string2);
        this.Qd = true;
    }

    public m se() {
        if (this.Qc == null) {
            throw new IllegalStateException("JSON has already been built");
        }
        m m2 = new m(this.Qc.append("}").toString());
        this.Qc = null;
        return m2;
    }

    private static String cU(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\"') {
                stringBuilder.append("\\\"");
                continue;
            }
            if (c == '\\') {
                stringBuilder.append("\\\\");
                continue;
            }
            if (c <= '\u000f') {
                stringBuilder.append("\\u000").append(Integer.toHexString(c));
                continue;
            }
            if (c <= '\u001f') {
                stringBuilder.append("\\u00").append(Integer.toHexString(c));
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
