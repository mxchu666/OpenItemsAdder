package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import dev.lone.itemsadder.resourcepack.bk;
import dev.lone.itemsadder.resourcepack.bo;
import dev.lone.itemsadder.resourcepack.bq;
import dev.lone.itemsadder.resourcepack.br;
import dev.lone.itemsadder.resourcepack.bs;
import dev.lone.itemsadder.resourcepack.bt;
import dev.lone.itemsadder.resourcepack.bu;
import dev.lone.itemsadder.resourcepack.bv;
import dev.lone.itemsadder.resourcepack.bx;
import dev.lone.itemsadder.resourcepack.bz;
import dev.lone.itemsadder.resourcepack.ca;
import dev.lone.itemsadder.resourcepack.cb;
import dev.lone.itemsadder.resourcepack.cc;
import dev.lone.itemsadder.resourcepack.cd;
import dev.lone.itemsadder.resourcepack.ce;
import dev.lone.itemsadder.resourcepack.cf;
import dev.lone.itemsadder.resourcepack.cg;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;

final class bm {
    private static final int avB = 0x100000;
    private static final int avC = 32;
    private static final String avD = "3.4.1";
    private static final String avE = "dev.lone.itemsadder.resourcepack.NativeGlslangBridge";
    private static final String avF = "itemsadder-shader-validator";
    private static final AtomicBoolean avG = new AtomicBoolean();
    private static final AtomicBoolean avH = new AtomicBoolean();

    private bm() {
    }

    static bz n(Map map) {
        return bm.a(map, bv.INSTANCE, bm::g);
    }

    static bz a(Map map, bo bo2) {
        return bm.a(map, bo2, (Version version, String string) -> null);
    }

    static bz a(Map map, bo bo2, cg cg2) {
        return bm.a(map, bo2, cg2, (T packEntry, U string) -> null);
    }

    static bz a(Map map, bo bo2, cg cg2, BiFunction biFunction) {
        bq bq2 = new bq(map, bo2, cg2, biFunction);
        bq2.Aa();
        return new bz(List.copyOf(bq2.avT));
    }

    private static String g(Version version, String string) {
        if (version == null || version == Version.UNKNOWN) {
            return null;
        }
        try {
            ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
            return itemStackRegistry == null || itemStackRegistry.B == null ? null : itemStackRegistry.B.c(string, version);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static void o(Map map) {
        bm.a(map, (T packEntry, U string) -> null);
    }

    static void a(Map map, BiFunction biFunction) {
        block8: {
            try {
                bz bz2 = bm.a(map, bv.INSTANCE, bm::g, biFunction);
                for (bs bs2 : bz2.AB()) {
                    if (bs2.Ah().equals("SHADER_COMPILER_UNAVAILABLE") && !avG.compareAndSet(false, true)) continue;
                    switch (bs2.Ag().ordinal()) {
                        case 0: {
                            CommandSenderBridge_5.error(bs2.Af());
                            break;
                        }
                        case 1: {
                            CommandSenderBridge_5.warn(bs2.Af());
                            break;
                        }
                        case 2: {
                            CommandSenderBridge_5.log(bs2.Af());
                        }
                    }
                    if (bs2.Ag() != cb.ERROR) continue;
                    bk.k("Shader validation", bs2.Af());
                }
            }
            catch (Throwable throwable) {
                if (!avH.compareAndSet(false, true)) break block8;
                CommandSenderBridge_5.warn("[WARNING] SHADER_VALIDATOR_FAILED\nShader validation was skipped: " + bm.a(throwable));
            }
        }
    }

    private static ca a(String string, String string2, cd cd2) {
        if (string == null) {
            return new ca(List.of(), List.of(), false, 0, 0, Set.of(), List.of());
        }
        ArrayList<bs> arrayList = new ArrayList<bs>();
        ArrayList<bu> arrayList2 = new ArrayList<bu>();
        ArrayList<ce> arrayList3 = new ArrayList<ce>();
        ArrayDeque<br> arrayDeque = new ArrayDeque<br>();
        boolean bl = false;
        boolean bl2 = false;
        char c = '\u0000';
        boolean bl3 = false;
        boolean bl4 = true;
        boolean bl5 = false;
        int n = 0;
        int n2 = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int n3 = 1;
        int n4 = 1;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < string.length()) {
            int n8;
            char c2;
            char c3 = string.charAt(n7);
            char c4 = c2 = n7 + 1 < string.length() ? string.charAt(n7 + 1) : (char)'\u0000';
            if (c3 == '\n') {
                if (c != '\u0000') {
                    arrayList.add(bm.a("SHADER_STRING_UNTERMINATED", cd2, string2, n6, 1, "Unterminated string literal."));
                    c = '\u0000';
                    bl3 = false;
                }
                bl = false;
                bl4 = true;
                ++n3;
                n4 = 1;
                ++n7;
                continue;
            }
            if (bl) {
                ++n7;
                ++n4;
                continue;
            }
            if (bl2) {
                if (c3 == '*' && c2 == '/') {
                    bl2 = false;
                    n7 += 2;
                    n4 += 2;
                    continue;
                }
                ++n7;
                ++n4;
                continue;
            }
            if (c != '\u0000') {
                if (bl3) {
                    bl3 = false;
                } else if (c3 == '\\') {
                    bl3 = true;
                } else if (c3 == c) {
                    c = '\u0000';
                }
                ++n7;
                ++n4;
                continue;
            }
            if (c3 == '/' && c2 == '/') {
                bl = true;
                n7 += 2;
                n4 += 2;
                continue;
            }
            if (c3 == '/' && c2 == '*') {
                bl2 = true;
                n5 = n3;
                n7 += 2;
                n4 += 2;
                continue;
            }
            if (c3 == '\"' || c3 == '\'') {
                c = c3;
                n6 = n3;
                bl5 = true;
                bl4 = false;
                ++n7;
                ++n4;
                continue;
            }
            if (c3 == '#' && bl4) {
                int n9;
                int n10;
                n8 = string.indexOf(10, n7);
                if (n8 < 0) {
                    n8 = string.length();
                }
                String string3 = string.substring(n7 + 1, n8);
                for (n10 = n9 = bm.q(string3, 0); n10 < string3.length() && bm.f(string3.charAt(n10)); ++n10) {
                }
                String string4 = string3.substring(n9, n10);
                if (string4.equals("version")) {
                    hashSet.add(n3);
                    n2 = Math.max(n2, bm.r(string3, n10));
                    if (++n > 1) {
                        arrayList.add(bm.a("SHADER_VERSION_DUPLICATE", cd2, string2, n3, n4, "Shader declares #version more than once."));
                    }
                    if (bl5) {
                        arrayList.add(bm.a("SHADER_VERSION_MISPLACED", cd2, string2, n3, n4, "#version must precede all shader code and directives."));
                    }
                } else {
                    bl5 = true;
                    if (string4.equals("moj_import")) {
                        bu bu2 = bm.a(string3.substring(n10), n3, n4);
                        arrayList2.add(bu2);
                        if (!bu2.As()) {
                            arrayList.add(bm.a("SHADER_IMPORT_MALFORMED", cd2, string2, n3, n4, "Malformed #moj_import directive."));
                        }
                    }
                }
                bl4 = false;
                ++n7;
                ++n4;
                continue;
            }
            if (Character.isWhitespace(c3)) {
                ++n7;
                ++n4;
                continue;
            }
            bl4 = false;
            bl5 = true;
            if (bm.e(c3)) {
                n8 = n7;
                int n11 = n4;
                while (n7 < string.length() && bm.f(string.charAt(n7))) {
                    ++n7;
                    ++n4;
                }
                arrayList3.add(new ce(string.substring(n8, n7), n3, n11, true));
                continue;
            }
            if (c3 == '(' || c3 == ')' || c3 == '[' || c3 == ']' || c3 == '{' || c3 == '}' || c3 == ';' || c3 == ',') {
                arrayList3.add(new ce(String.valueOf(c3), n3, n4, false));
            }
            if (c3 == '(' || c3 == '[' || c3 == '{') {
                arrayDeque.addLast(new br(c3, n3, n4));
            } else if (c3 == ')' || c3 == ']' || c3 == '}') {
                int n12 = c3 == ')' ? 40 : (n8 = c3 == ']' ? 91 : 123);
                if (arrayDeque.isEmpty() || ((br)arrayDeque.getLast()).Ac() != n8) {
                    arrayList.add(bm.a("SHADER_DELIMITER_UNMATCHED", cd2, string2, n3, n4, "Unmatched '" + c3 + "'."));
                } else {
                    arrayDeque.removeLast();
                }
            }
            ++n7;
            ++n4;
        }
        if (bl2) {
            arrayList.add(bm.a("SHADER_COMMENT_UNTERMINATED", cd2, string2, n5, 1, "Unterminated block comment."));
        }
        if (c != '\u0000') {
            arrayList.add(bm.a("SHADER_STRING_UNTERMINATED", cd2, string2, n6, 1, "Unterminated string literal."));
        }
        for (br br2 : arrayDeque) {
            arrayList.add(bm.a("SHADER_DELIMITER_UNMATCHED", cd2, string2, br2.Ad(), br2.Ae(), "Unmatched '" + br2.Ac() + "'."));
        }
        boolean bl6 = false;
        int n13 = 0;
        while (n13 + 2 < arrayList3.size()) {
            if (((ce)arrayList3.get(n13)).AK().equals("void") && ((ce)arrayList3.get(n13 + 1)).AK().equals("main") && ((ce)arrayList3.get(n13 + 2)).AK().equals("(")) {
                bl6 = true;
                break;
            }
            ++n13;
        }
        return new ca(List.copyOf(arrayList), List.copyOf(arrayList2), bl6, n, n2, Set.copyOf(hashSet), List.copyOf(arrayList3));
    }

    private static cf a(bt bt2) {
        List list = bm.a(bt2.Am(), bt2.Aj(), bt2.Ai()).AG();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i = 0; i < list.size(); ++i) {
            int n;
            int n2;
            if (!((ce)list.get(i)).AK().equals("uniform")) continue;
            for (n2 = i + 1; n2 < list.size() && !((ce)list.get(n2)).AK().equals("{") && !((ce)list.get(n2)).AK().equals(";"); ++n2) {
            }
            if (n2 >= list.size()) break;
            if (((ce)list.get(n2)).AK().equals(";")) {
                bm.a(list, i + 1, n2, linkedHashMap);
                i = n2;
                continue;
            }
            int n3 = 1;
            for (n = n2 + 1; n < list.size() && n3 > 0; ++n) {
                if (((ce)list.get(n)).AK().equals("{")) {
                    ++n3;
                    continue;
                }
                if (!((ce)list.get(n)).AK().equals("}")) continue;
                --n3;
            }
            bm.a(list, n2 + 1, Math.max(n2 + 1, n - 1), linkedHashMap2);
            i = n - 1;
        }
        return new cf(Map.copyOf(linkedHashMap), Map.copyOf(linkedHashMap2));
    }

    private static void a(List list, int n, int n2, Map map) {
        for (int i = n + 1; i <= n2 && i < list.size(); ++i) {
            String string = ((ce)list.get(i)).AK();
            ce ce2 = (ce)list.get(i - 1);
            if (!ce2.AL() || !string.equals("[") && !string.equals(",") && !string.equals(";")) continue;
            map.putIfAbsent(ce2.AK(), ce2);
        }
    }

    private static bu a(String string, int n, int n2) {
        int n3;
        int n4 = bm.q(string, 0);
        if (n4 >= string.length()) {
            return new bu(n, n2, "", false, false);
        }
        char c = string.charAt(n4);
        int n5 = c == '<' ? 62 : (n3 = c == '\"' ? 34 : 0);
        if (n3 == 0) {
            return new bu(n, n2, "", false, false);
        }
        int n6 = string.indexOf(n3, n4 + 1);
        if (n6 < 0) {
            return new bu(n, n2, "", c == '\"', false);
        }
        String string2 = string.substring(n4 + 1, n6).trim();
        String string3 = string.substring(n6 + 1).trim();
        boolean bl = !string2.isEmpty() && (string3.isEmpty() || string3.startsWith("//"));
        return new bu(n, n2, string2, c == '\"', bl);
    }

    private static bs a(String string, cd cd2, String string2, int n, int n2, String string3) {
        return new bs(cb.ERROR, string, cd2, string2, string2, n, n2, string3, List.of(string2));
    }

    private static bx fF(String string) {
        int n;
        int n2;
        cb cb2 = null;
        String string2 = string;
        if (string.regionMatches(true, 0, "ERROR:", 0, 6)) {
            cb2 = cb.ERROR;
            string2 = string.substring(6).trim();
        } else if (string.regionMatches(true, 0, "WARNING:", 0, 8)) {
            cb2 = cb.WARNING;
            string2 = string.substring(8).trim();
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = string2.indexOf(58);
        if (n5 >= 0 && (n2 = string2.indexOf(58, n5 + 1)) >= 0 && (n = bm.fG(string2.substring(n5 + 1, n2).trim())) > 0) {
            n3 = n;
            int n6 = string2.indexOf(58, n2 + 1);
            if (n6 >= 0) {
                int n7 = bm.fG(string2.substring(n2 + 1, n6).trim());
                if (n7 > 0) {
                    n4 = n7;
                    string2 = string2.substring(n6 + 1).trim();
                } else {
                    string2 = string2.substring(n2 + 1).trim();
                }
            } else {
                string2 = string2.substring(n2 + 1).trim();
            }
        }
        return new bx(cb2, n3, n4, string2);
    }

    private static int fG(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    private static String fH(String string) {
        return switch (string) {
            case "preprocess" -> "SHADER_PREPROCESS_FAILED";
            case "link" -> "SHADER_LINK_FAILED";
            default -> "SHADER_COMPILATION_FAILED";
        };
    }

    private static String h(String string, String string2, String string3) {
        if (string2 == null || string2.isBlank()) {
            return null;
        }
        String string4 = bm.ei(string);
        Object object = string2;
        int n = string2.indexOf(58);
        if (n >= 0) {
            string4 = string2.substring(0, n);
            object = string2.substring(n + 1);
        }
        if (!((String)object).startsWith("core/")) {
            object = "core/" + (String)object;
        }
        if (!((String)object).endsWith(string3)) {
            object = (String)object + string3;
        }
        return "assets/" + string4 + "/shaders/" + (String)object;
    }

    private static boolean u(String string, boolean bl) {
        if (string == null || string.isBlank() || string.contains("\\") || bm.fJ(string)) {
            return false;
        }
        int n = string.indexOf(58);
        if (n < 0) {
            return bl && bm.v(string, true);
        }
        return n > 0 && n == string.lastIndexOf(58) && bm.v(string.substring(0, n), false) && bm.v(string.substring(n + 1), true);
    }

    private static boolean v(String string, boolean bl) {
        if (string.isEmpty() || string.startsWith("/") || string.endsWith("/")) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '_' || c == '-' || c == '.' || bl && c == '/') continue;
            return false;
        }
        return true;
    }

    private static String fI(String string) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
        for (String string2 : string.split("/")) {
            if (string2.isEmpty() || string2.equals(".")) continue;
            if (string2.equals("..")) {
                if (arrayDeque.isEmpty()) {
                    return null;
                }
                arrayDeque.removeLast();
                continue;
            }
            arrayDeque.addLast(string2);
        }
        return String.join((CharSequence)"/", arrayDeque);
    }

    private static boolean fJ(String string) {
        return Arrays.stream(string.replace('\\', '/').split("/", -1)).anyMatch(".."::equals);
    }

    private static void a(StringBuilder stringBuilder, List list, String string, String string2, int n, Deque deque) {
        stringBuilder.append(string).append('\n');
        list.add(new cc(string2, n, List.copyOf(deque)));
    }

    static String c(ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry) {
        try (InputStream inputStream = itemsAdderPackCompressedEvent$PackEntry.openStream();){
            byte[] byArray = inputStream.readNBytes(0x100001);
            if (byArray.length > 0x100000) {
                throw new IOException("shader file exceeds 1048576 bytes");
            }
            String string = new String(byArray, StandardCharsets.UTF_8);
            return string;
        }
    }

    static boolean fK(String string) {
        int n = string.indexOf("assets/");
        if (n < 0) {
            return false;
        }
        String string2 = string.substring(n);
        int n2 = string2.indexOf("/shaders/");
        if (!string2.startsWith("assets/") || n2 < 0) {
            return false;
        }
        return string2.endsWith(".vsh") || string2.endsWith(".fsh") || string2.endsWith(".glsl") || string2.endsWith(".json") || string2.contains("/shaders/include/");
    }

    private static boolean fL(String string) {
        return string.endsWith(".json") && string.contains("/shaders/core/");
    }

    private static boolean fM(String string) {
        return string.endsWith(".json") && string.contains("/shaders/post/");
    }

    private static cd fN(String string) {
        if (string == null) {
            return cd.NONE;
        }
        if (string.endsWith(".vsh")) {
            return cd.VERTEX;
        }
        if (string.endsWith(".fsh")) {
            return cd.FRAGMENT;
        }
        if (string.endsWith(".glsl") || string.contains("/shaders/include/")) {
            return cd.INCLUDE;
        }
        if (string.endsWith(".json")) {
            return cd.PROGRAM;
        }
        return cd.NONE;
    }

    private static String ei(String string) {
        int n = string.indexOf("assets/");
        if (n < 0) {
            return "minecraft";
        }
        int n2 = n + "assets/".length();
        int n3 = string.indexOf(47, n2);
        return n3 < 0 ? "minecraft" : string.substring(n2, n3);
    }

    private static String fO(String string) {
        String string2 = bm.ei(string);
        int n = string.indexOf("/shaders/");
        return n < 0 ? string : string2 + ":" + string.substring(n + "/shaders/".length());
    }

    private static int q(String string, int n) {
        while (n < string.length() && Character.isWhitespace(string.charAt(n))) {
            ++n;
        }
        return n;
    }

    private static int r(String string, int n) {
        int n2;
        int n3;
        for (n3 = n2 = bm.q(string, n); n3 < string.length() && Character.isDigit(string.charAt(n3)); ++n3) {
        }
        return n2 == n3 ? 0 : bm.fG(string.substring(n2, n3));
    }

    private static String s(String string, int n) {
        int n2;
        int n3 = string.indexOf(35);
        int n4 = bm.q(string, n3 + 1) + "version".length();
        for (n2 = n4 = bm.q(string, n4); n2 < string.length() && Character.isDigit(string.charAt(n2)); ++n2) {
        }
        return n4 == n2 ? string : string.substring(0, n4) + n + string.substring(n2);
    }

    private static boolean e(char c) {
        return c == '_' || Character.isLetter(c);
    }

    private static boolean f(char c) {
        return c == '_' || Character.isLetterOrDigit(c);
    }

    static String a(Throwable throwable) {
        Throwable throwable2;
        for (throwable2 = throwable; throwable2.getCause() != null && throwable2.getCause() != throwable2; throwable2 = throwable2.getCause()) {
        }
        String string = throwable2.getMessage();
        return string == null || string.isBlank() ? throwable2.getClass().getSimpleName() : string;
    }
}
