package itemsadder.m;

import dev.lone.itemsadder.resourcepack.bk;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bdi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.Logger;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;

public final class bdh {
    private static final Object aBx = new Object();
    private static final Logger aBy = Logger.getLogger("org.bukkit.configuration.file.YamlConstructor");
    private static final Set aBz = new HashSet();

    private bdh() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void gr() {
        Set set = aBz;
        synchronized (set) {
            aBz.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void a(YamlConfiguration yamlConfiguration, File file) {
        Object object;
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        List list = List.of();
        try {
            object = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            try {
                list = bdh.a((Reader)object);
            }
            finally {
                if (object != null) {
                    ((Reader)object).close();
                }
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        object = aBx;
        synchronized (object) {
            long l = Thread.currentThread().getId();
            Filter filter = aBy.getFilter();
            Filter filter2 = logRecord -> {
                if (Thread.currentThread().getId() == l && logRecord.getMessage() != null && logRecord.getMessage().startsWith("duplicate keys found")) {
                    return false;
                }
                return filter == null || filter.isLoggable(logRecord);
            };
            try {
                aBy.setFilter(filter2);
            }
            catch (SecurityException securityException) {
                yamlConfiguration.load(file);
                bdh.a(file, list);
                return;
            }
            try {
                yamlConfiguration.load(file);
            }
            finally {
                try {
                    if (aBy.getFilter() == filter2) {
                        aBy.setFilter(filter);
                    }
                }
                catch (SecurityException securityException) {}
            }
        }
        bdh.a(file, list);
    }

    static List a(Reader reader) {
        ArrayList arrayList = new ArrayList();
        Set set = Collections.newSetFromMap(new IdentityHashMap());
        for (Node node : new Yaml().composeAll(reader)) {
            bdh.a(node, "", arrayList, set);
        }
        return arrayList;
    }

    private static void a(Node node, String string, List list, Set set) {
        block6: {
            block5: {
                if (node == null || !set.add(node)) {
                    return;
                }
                if (!(node instanceof MappingNode)) break block5;
                MappingNode mappingNode = (MappingNode)node;
                HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                for (NodeTuple nodeTuple : mappingNode.getValue()) {
                    Node node2 = nodeTuple.getKeyNode();
                    String string2 = string;
                    if (node2 instanceof ScalarNode) {
                        ScalarNode scalarNode = (ScalarNode)node2;
                        String string3 = scalarNode.getValue();
                        string2 = string.isEmpty() ? string3 : string + "." + string3;
                        int n = node2.getStartMark().getLine() + 1;
                        Integer n2 = hashMap.putIfAbsent(string3, n);
                        if (n2 != null) {
                            list.add(new bdi(string2, n2, n));
                        }
                    }
                    bdh.a(nodeTuple.getValueNode(), string2, list, set);
                }
                break block6;
            }
            if (!(node instanceof SequenceNode)) break block6;
            SequenceNode sequenceNode = (SequenceNode)node;
            for (int i = 0; i < sequenceNode.getValue().size(); ++i) {
                bdh.a((Node)sequenceNode.getValue().get(i), string + "[" + i + "]", list, set);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void a(File file, List list) {
        if (list.isEmpty()) {
            return;
        }
        String string = bcy.iP(file.getPath());
        String string2 = file.getAbsolutePath() + "\u0000" + file.lastModified() + "\u0000" + String.valueOf(list);
        Object object = aBz;
        synchronized (object) {
            if (!aBz.add(string2)) {
                return;
            }
        }
        object = String.join((CharSequence)", ", list.stream().limit(8L).map(bdi2 -> "'" + bdi2.aBA + "' (lines " + bdi2.aBB + " and " + bdi2.aBC + ")").toList());
        String string3 = "Found " + list.size() + " duplicate YAML key" + (list.size() == 1 ? "" : "s") + " in " + string + ". Later values override earlier ones: " + (String)object + (String)(list.size() > 8 ? ", +" + (list.size() - 8) + " more" : "");
        bce.warn(string3);
        bk.k("Duplicate YAML keys", string3);
    }
}
