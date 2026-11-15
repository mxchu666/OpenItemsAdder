package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.resourcepack.ap;
import dev.lone.itemsadder.resourcepack.aq;
import dev.lone.itemsadder.resourcepack.ar;
import dev.lone.itemsadder.resourcepack.k;
import dev.lone.itemsadder.resourcepack.l;
import dev.lone.itemsadder.resourcepack.m;
import dev.lone.itemsadder.resourcepack.n;
import dev.lone.itemsadder.resourcepack.o;
import itemsadder.m.zw;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.bukkit.ChatColor;

final class j {
    private static final int aqV = 25;
    private final Map aqW = new TreeMap(Comparator.comparing(m::xK));
    private final Map aqX = new TreeMap(Comparator.comparing(k::xK));

    j() {
    }

    void a(Version version, aq aq2) {
        if (aq2.xU() != ar.PRE_EXISTING_WARNING) {
            return;
        }
        ap ap2 = aq2.zx();
        m m2 = ap2 == null ? m.a(aq2) : m.a(aq2, ap2);
        l l2 = this.aqW.computeIfAbsent(m2, l::new);
        String string = j.m(version);
        if (string != null) {
            l2.arh.add(string);
        }
        if (ap2 != null) {
            l2.b(ap2.zu(), j.a(ap2));
        }
    }

    void a(Collection collection, Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        map.forEach((string, bl) -> arrayList.add(new k((String)string, (boolean)bl, n.UNKNOWN, o.em(string), null, true)));
        this.a(collection, arrayList);
    }

    void a(Collection collection, Collection collection2) {
        TreeSet treeSet = new TreeSet();
        collection.forEach(version -> {
            String string = j.m(version);
            if (string != null) {
                treeSet.add(string);
            }
        });
        collection2.stream().filter(k2 -> k2.ara.yb()).forEach(k3 -> this.aqX.computeIfAbsent(k3, k2 -> new TreeSet()).addAll(treeSet));
    }

    boolean isEmpty() {
        return this.aqW.isEmpty() && this.aqX.isEmpty();
    }

    boolean xH() {
        return !this.aqX.isEmpty();
    }

    boolean xI() {
        return !this.aqW.isEmpty();
    }

    String xJ() {
        return this.aS(zw.sW());
    }

    String aS(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.aqW.isEmpty()) {
            this.a(stringBuilder, bl);
        }
        if (!this.aqX.isEmpty()) {
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append("\n\n");
            }
            this.b(stringBuilder, bl);
        }
        if (bl && !stringBuilder.isEmpty()) {
            stringBuilder.insert(0, ChatColor.YELLOW);
        }
        return bl ? j.ef(stringBuilder.toString()) : j.ee(stringBuilder.toString());
    }

    String ed(String string2) {
        TreeSet treeSet = new TreeSet();
        TreeSet treeSet2 = new TreeSet();
        TreeSet treeSet3 = new TreeSet();
        this.aqW.values().forEach(l2 -> treeSet.addAll(l2.ari.keySet()));
        this.aqW.keySet().stream().filter(m2 -> m2.arl && !m2.arm.isBlank()).map(m::xX).map(j::ee).forEach(treeSet2::add);
        this.aqW.keySet().stream().filter(m::xT).map(m::xL).map(o::em).map(j::ee).forEach(treeSet3::add);
        long l3 = this.aqW.keySet().stream().filter(m::xT).count();
        StringBuilder stringBuilder = new StringBuilder("[Pack] Resource-pack diagnostics: ");
        if (!this.aqW.isEmpty()) {
            stringBuilder.append(this.aqW.size()).append(" warning group").append(this.aqW.size() == 1 ? "" : "s");
            if (l3 > 0L) {
                stringBuilder.append(" (").append(l3).append(" missing model").append(l3 == 1L ? "" : "s").append(")");
            }
            if (!treeSet.isEmpty()) {
                stringBuilder.append(" affecting ").append(treeSet.size()).append(" custom entr").append(treeSet.size() == 1 ? "y" : "ies");
            }
        }
        if (!this.aqX.isEmpty()) {
            if (!this.aqW.isEmpty()) {
                stringBuilder.append("; ");
            }
            stringBuilder.append(this.aqX.size()).append(" unreferenced model file").append(this.aqX.size() == 1 ? "" : "s").append(" (informational)");
        }
        stringBuilder.append(". Details: ").append(string2);
        if (!treeSet3.isEmpty()) {
            stringBuilder.append("\n  Expected missing model files (").append(treeSet3.size()).append("):");
            treeSet3.forEach(string -> stringBuilder.append("\n    - ").append((String)string));
        }
        if (!treeSet2.isEmpty()) {
            stringBuilder.append("\n  Affected declaration files (").append(treeSet2.size()).append("):");
            treeSet2.forEach(string -> stringBuilder.append("\n    - ").append((String)string));
        }
        return stringBuilder.toString();
    }

    static String ee(String string) {
        return string.replaceAll("assets/_iainternal/models/item_context/([^/\\s]+)/", "assets/$1/models/").replaceAll("_iainternal:item_context/([^/\\s]+)/", "$1:");
    }

    static String ef(String string) {
        return string.replaceAll("(_iainternal:item_context/[^\\s']+)", String.valueOf(ChatColor.GRAY) + "$1" + String.valueOf(ChatColor.YELLOW));
    }

    private void a(StringBuilder stringBuilder, boolean bl) {
        TreeSet treeSet = new TreeSet();
        TreeSet treeSet2 = new TreeSet();
        TreeSet treeSet3 = new TreeSet();
        this.aqW.values().forEach(l2 -> treeSet.addAll(l2.arh));
        this.aqW.values().forEach(l2 -> treeSet2.addAll(l2.ari.keySet()));
        this.aqW.keySet().stream().filter(m::xT).map(m::xL).forEach(treeSet3::add);
        stringBuilder.append("[Pack] Found ").append(this.aqW.size()).append(" grouped resource-pack warning section").append(this.aqW.size() == 1 ? "" : "s");
        if (!treeSet2.isEmpty()) {
            stringBuilder.append(" affecting ").append(treeSet2.size()).append(" custom entr").append(treeSet2.size() == 1 ? "y" : "ies");
        }
        j.a(stringBuilder, treeSet);
        stringBuilder.append(".\n");
        if (!treeSet3.isEmpty()) {
            stringBuilder.append("  Unique missing models: ").append(treeSet3.size()).append('\n');
        }
        for (l l3 : this.aqW.values()) {
            m m2 = l3.arg;
            stringBuilder.append("\n  ").append(m2.sp()).append('\n');
            if (m2.arl) {
                stringBuilder.append("    ").append(m2.xT() ? "Used by" : "Affected custom entries").append(" (").append(l3.ari.size()).append("):\n");
                j.a(stringBuilder, l3.ari);
                stringBuilder.append("\n    Declared from: ").append(m2.arm).append('\n').append("    Minecraft material: ").append(j.eh(m2.arm)).append('\n');
                j.a(stringBuilder, "    Affected ", l3.arh, bl);
                stringBuilder.append("\n    What this means:\n      ").append(j.a(m2)).append('\n').append("\n    How to fix:\n      ").append(j.b(m2)).append('\n');
                j.a(stringBuilder, bl, "    ", "Source classification: " + String.valueOf((Object)m2.ark), "Validation reason: " + m2.aro);
            } else {
                stringBuilder.append("    What this means:\n").append("      ItemsAdder found a resource-pack reference it could not validate.\n").append("    How to fix:\n").append("      Check the referenced model or texture ID, its namespace/path, and the file that supplies it.\n");
            }
            if (m2.arl) continue;
            j.a(stringBuilder, bl, "    ", "Source classification: " + String.valueOf((Object)m2.ark), "Validation message: " + m2.arp);
        }
    }

    private void b(StringBuilder stringBuilder, boolean bl) {
        TreeSet treeSet = new TreeSet();
        this.aqX.values().forEach(treeSet::addAll);
        long l2 = this.aqX.keySet().stream().filter(k2 -> !k2.aqZ).count();
        long l3 = (long)this.aqX.size() - l2;
        stringBuilder.append("[Pack] Found ").append(this.aqX.size()).append(" model file").append(this.aqX.size() == 1 ? "" : "s").append(" with no static item or block reference.\n");
        j.a(stringBuilder, "  Affected ", treeSet, bl);
        EnumMap enumMap = new EnumMap(n.class);
        this.aqX.keySet().forEach(k2 -> enumMap.merge(k2.ara, 1L, Long::sum));
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        arrayList.add((CallSite)((Object)("Fallback contexts: item " + l2 + ", block " + l3)));
        for (n n2 : n.values()) {
            Long l4 = (Long)enumMap.get((Object)n2);
            if (l4 == null) continue;
            arrayList.add((CallSite)((Object)("Source " + n2.xZ() + ": " + l4)));
        }
        j.a(stringBuilder, bl, "  ", (String[])arrayList.toArray(String[]::new));
        stringBuilder.append("\n  These files exist in the generated pack; they are not missing or invalid by themselves.\n").append("  Check them only if a configured item or block was expected to use them.\n");
        this.a(stringBuilder, treeSet, bl);
        this.a(stringBuilder, "Unreferenced model files from resource packs", "No item declaration or blockstate in the pack references these files.", treeSet, bl, n.USER_CONTENT_PACK, n.EXTERNAL_RESOURCE_PACK, n.UNKNOWN);
        this.a(stringBuilder, "Models supplied by plugins or pack events", "No action is needed if the integration selects these models at runtime.", treeSet, bl, n.EVENT_STREAM_OR_WRITER);
    }

    private void a(StringBuilder stringBuilder, Set set, boolean bl) {
        List<Map.Entry> list = this.aqX.entrySet().stream().filter(entry -> ((k)entry.getKey()).arf).toList();
        if (list.isEmpty()) {
            return;
        }
        stringBuilder.append("\n  Unused custom entity model files (").append(list.size()).append(")\n").append("    These files are inside a configured custom entity model folder, but its current .metadata does not use them.\n").append("    You can delete them if they are no longer used by another plugin or runtime integration.\n");
        j.a(stringBuilder, list, set, bl);
    }

    private void a(StringBuilder stringBuilder, String string, String string2, Set set, boolean bl, n ... nArray) {
        ArrayList arrayList = new ArrayList();
        for (n n2 : nArray) {
            this.aqX.entrySet().stream().filter(entry -> !((k)entry.getKey()).arf && ((k)entry.getKey()).ara == n2).forEach(arrayList::add);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        stringBuilder.append("\n  ").append(string).append(" (").append(arrayList.size()).append(")\n").append("    ").append(string2).append('\n');
        j.a(stringBuilder, arrayList, set, bl);
    }

    private static void a(StringBuilder stringBuilder, List list, Set set, boolean bl) {
        TreeMap treeMap = new TreeMap();
        list.forEach(entry -> treeMap.computeIfAbsent(j.ei(((k)entry.getKey()).aqY), string -> new ArrayList()).add(entry));
        for (Map.Entry entry2 : treeMap.entrySet()) {
            stringBuilder.append("      ").append((String)entry2.getKey()).append(" (").append(((List)entry2.getValue()).size()).append("):\n");
            ((List)entry2.getValue()).forEach(entry -> j.a(stringBuilder, (k)entry.getKey(), (Set)entry.getValue(), set, bl));
        }
    }

    private static void a(StringBuilder stringBuilder, k k2, Set set, Set set2, boolean bl) {
        stringBuilder.append("        - ").append(k2.aqY).append('\n').append("          File: ").append(k2.arc).append('\n');
        if (k2.ara.ya()) {
            stringBuilder.append("          Status: normal ItemsAdder internal support model; no fix is needed.\n");
        } else if (k2.ara == n.VANILLA_CLIENT_ASSET) {
            stringBuilder.append("          Status: normal Vanilla client model; no fix is normally needed.\n");
        }
        String string = j.eg(k2.arb);
        if (string != null || !set.equals(set2)) {
            stringBuilder.append("          Applies to: ");
            if (string != null) {
                stringBuilder.append("overlay ").append(string);
            }
            if (!set.isEmpty()) {
                if (string != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append("versions ").append(String.join((CharSequence)", ", set));
            }
            stringBuilder.append('\n');
        }
        if (bl) {
            stringBuilder.append("          ").append(ChatColor.GRAY).append("Context: ").append(k2.aqZ ? "block" : "item").append("; source: ").append(k2.ara.xZ()).append("; reason: ").append(k2.ard).append(ChatColor.YELLOW).append('\n');
        }
    }

    private static void a(StringBuilder stringBuilder, boolean bl, String string, String ... stringArray) {
        if (!bl) {
            return;
        }
        stringBuilder.append(string).append(ChatColor.GRAY).append("Technical details:\n");
        for (int i = 0; i < stringArray.length; ++i) {
            stringBuilder.append(string).append("  ").append(stringArray[i]);
            if (i == stringArray.length - 1) {
                stringBuilder.append(ChatColor.YELLOW);
            }
            stringBuilder.append('\n');
        }
    }

    private static String eg(String string) {
        int n2 = string.indexOf("/assets/");
        return n2 > 0 ? string.substring(0, n2) : null;
    }

    private static void a(StringBuilder stringBuilder, Set set) {
        if (set.isEmpty()) {
            return;
        }
        stringBuilder.append(" across ").append(set.size()).append(" Vanilla asset version").append(set.size() == 1 ? "" : "s");
    }

    private static void a(StringBuilder stringBuilder, String string, Set set, boolean bl) {
        if (bl && !set.isEmpty()) {
            stringBuilder.append(ChatColor.GRAY).append(string).append("Versions: ").append(String.join((CharSequence)", ", set)).append(ChatColor.YELLOW).append('\n');
        }
    }

    private static void a(StringBuilder stringBuilder, Map map) {
        map.entrySet().stream().limit(25L).forEach(entry -> {
            stringBuilder.append("      - ").append((String)entry.getKey()).append('\n');
            if (((Set)entry.getValue()).size() == 1) {
                j.a(stringBuilder, "        Reference chain:", (List)((Set)entry.getValue()).iterator().next());
            } else {
                stringBuilder.append("        Reference chains (").append(((Set)entry.getValue()).size()).append("):\n");
                int n2 = 1;
                for (List list : (Set)entry.getValue()) {
                    j.a(stringBuilder, "          " + n2++ + ".", list);
                }
            }
        });
        int n2 = map.size() - Math.min(map.size(), 25);
        if (n2 > 0) {
            stringBuilder.append("      - ").append(n2).append(" additional custom entries omitted to keep this console warning readable\n");
        }
    }

    private static void a(StringBuilder stringBuilder, String string2, List list) {
        if (list.isEmpty()) {
            return;
        }
        stringBuilder.append(string2).append('\n');
        stringBuilder.append("          ").append((String)list.getFirst()).append('\n');
        list.stream().skip(1L).forEach(string -> stringBuilder.append("          -> ").append((String)string).append('\n'));
    }

    private static String a(m m2) {
        if (m2.xT()) {
            return "The custom entries above eventually reference a model that was not found in the generated resource pack.";
        }
        if (m2.aro.startsWith("item model has unresolved face texture slots")) {
            return "This model contains texture slots that ItemsAdder could not resolve.";
        }
        if (m2.aro.contains("is not selected by the effective item or block atlas")) {
            return "This model uses a texture that is not included in the selected item or block atlas.";
        }
        if (m2.aro.startsWith("cannot read texture value")) {
            return "ItemsAdder could not read one of this model's texture values.";
        }
        if (m2.aro.contains("has no selected pack entry")) {
            return "This model references a texture file that was not found in the generated resource pack.";
        }
        return "ItemsAdder found a model or texture reference it could not validate.";
    }

    private static String b(m m2) {
        if (m2.xT()) {
            String string = m2.arn.substring(m2.arn.indexOf(58) + 1);
            Object object = string.contains("/") ? "" : "\n      If this came from a parent value like '" + string + "', it resolves in the minecraft namespace; use the intended namespace/path or remove a self-parent reference.";
            return "Check for a typo in '" + m2.arn + "'.\n      Make sure '" + o.em(m2.arn) + "' exists with the correct namespace and path.\n      If another plugin or pack event supplies it, verify that the integration adds the file." + (String)object;
        }
        if (m2.aro.startsWith("cannot read texture value")) {
            return "Check the model JSON for an empty or invalid texture value.";
        }
        if (m2.aro.contains("atlas")) {
            return "Check the texture ID, namespace/path, and texture file.\n      Also check the item or block atlas source that should include it.";
        }
        return "Check the referenced model or texture ID, its namespace/path, and the declaration or integration that supplies it.";
    }

    private static List a(ap ap2) {
        ArrayList arrayList = new ArrayList(ap2.zv());
        if (!arrayList.isEmpty() && o.el((String)arrayList.getFirst()).equals(o.el(ap2.zu()))) {
            arrayList.removeFirst();
        }
        return List.copyOf(arrayList);
    }

    private static String m(Version version) {
        return version == Version.UNKNOWN ? null : version.getName();
    }

    private static String eh(String string) {
        int n2 = string.lastIndexOf(47);
        int n3 = string.lastIndexOf(46);
        return string.substring(n2 + 1, n3 > n2 ? n3 : string.length());
    }

    private static String ei(String string) {
        int n2 = string.indexOf(58);
        return n2 < 0 ? "minecraft" : string.substring(0, n2);
    }
}
