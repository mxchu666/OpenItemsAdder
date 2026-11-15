package ia.sh.libby.configuration;

import ia.sh.libby.Library;
import ia.sh.libby.LibraryManager;
import ia.sh.libby.Util;
import ia.sh.libby.classloader.IsolatedClassLoader;
import ia.sh.libby.configuration.Configuration;
import ia.sh.libby.configuration.ConfigurationException;
import ia.sh.libby.configuration.MalformedConfigurationException;
import ia.sh.libby.relocation.Relocation;
import ia.sh.libby.transitive.ExcludedDependency;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigurationFetcher {
    public static final int CONFIGURATION_VERSION = 0;
    private static final String JSON_PARSER_CLASS = Util.replaceWithDots("com{}grack{}nanojson{}JsonParser");
    private static final String JSON_PARSER_CONTEXT_CLASS = Util.replaceWithDots("com{}grack{}nanojson{}JsonParser$JsonParserContext");
    private static final String JSON_PARSER_EXCEPTION_CLASS = Util.replaceWithDots("com{}grack{}nanojson{}JsonParserException");
    private static final String JSON_OBJECT_CLASS = Util.replaceWithDots("com{}grack{}nanojson{}JsonObject");
    private static final String JSON_ARRAY_CLASS = Util.replaceWithDots("com{}grack{}nanojson{}JsonArray");
    private final Method jsonParserObject;
    private final Method jsonParserFrom;
    private final Method jsonObjectGetArray;
    private final Method jsonObjectGetBoolean;
    private final Method jsonObjectGetString;
    private final Method jsonArrayGetObject;
    private final Class<?> jsonParserException;

    public ConfigurationFetcher(@NotNull LibraryManager libraryManager) {
        Objects.requireNonNull(libraryManager, "libraryManager");
        IsolatedClassLoader isolatedClassLoader = new IsolatedClassLoader(new URL[0]);
        isolatedClassLoader.addPath(libraryManager.downloadLibrary(Library.builder().groupId("com{}grack").artifactId("nanojson").version("1.8").checksumFromBase64("qyhAVZM8LYvqhGQrbmW2aHV4hRzn+2flPCV98wAimJo=").fallbackRepository("https://repo1.maven.org/maven2/").build()));
        try {
            Class<?> clazz = isolatedClassLoader.loadClass(JSON_PARSER_CLASS);
            Class<?> clazz2 = isolatedClassLoader.loadClass(JSON_PARSER_CONTEXT_CLASS);
            Class<?> clazz3 = isolatedClassLoader.loadClass(JSON_OBJECT_CLASS);
            Class<?> clazz4 = isolatedClassLoader.loadClass(JSON_ARRAY_CLASS);
            this.jsonParserException = isolatedClassLoader.loadClass(JSON_PARSER_EXCEPTION_CLASS);
            this.jsonParserObject = clazz.getMethod("object", new Class[0]);
            this.jsonParserFrom = clazz2.getMethod("from", InputStream.class);
            this.jsonObjectGetArray = clazz3.getMethod("getArray", String.class);
            this.jsonObjectGetBoolean = clazz3.getMethod("getBoolean", String.class);
            this.jsonObjectGetString = clazz3.getMethod("getString", String.class);
            this.jsonArrayGetObject = clazz4.getMethod("getObject", Integer.TYPE);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    public Configuration readJsonFile(@NotNull InputStream inputStream) {
        try {
            Map map;
            try {
                map = (Map)this.jsonParserFrom.invoke(this.jsonParserObject.invoke(null, new Object[0]), inputStream);
            }
            catch (InvocationTargetException invocationTargetException) {
                if (this.jsonParserException.isInstance(invocationTargetException.getCause())) {
                    throw new MalformedConfigurationException(invocationTargetException.getCause().getMessage(), invocationTargetException.getCause());
                }
                throw new RuntimeException(invocationTargetException);
            }
            Integer n = this.fetchVersion(map);
            Set<String> set = this.fetchRepositories(map, false);
            Set<Relocation> set2 = this.fetchRelocations(map);
            List<Library> list = this.fetchLibraries(map, set2);
            return new Configuration(n, set, set2, list);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    private Integer fetchVersion(@NotNull Map<String, Object> map) {
        Object object = map.get("version");
        if (object instanceof Number) {
            int n = ((Number)object).intValue();
            if (n != 0) {
                throw new ConfigurationException("The json file is version " + object + " but this version of libby only supports version " + 0);
            }
            return n;
        }
        return null;
    }

    private Set<String> fetchRepositories(@NotNull Map<String, Object> map, boolean bl) {
        HashSet<String> hashSet = new HashSet<String>();
        ArrayList<Object> arrayList = this.getArray(map, bl ? "fallbackRepositories" : "repositories");
        if (arrayList != null) {
            for (Object object : arrayList) {
                if (object instanceof String) {
                    hashSet.add((String)object);
                    continue;
                }
                throw new ConfigurationException("Invalid repository: " + object);
            }
        }
        return hashSet;
    }

    private Set<Relocation> fetchRelocations(@NotNull Map<String, Object> map) {
        ArrayList<Object> arrayList = this.getArray(map, "relocations");
        if (arrayList != null) {
            HashSet<Relocation> hashSet = new HashSet<Relocation>();
            for (int i = 0; i < arrayList.size(); ++i) {
                Object object;
                Object object2;
                Map<String, Object> map2 = this.getObject(arrayList, i);
                if (map2 == null) {
                    throw new ConfigurationException("Invalid relocation: " + arrayList.get(i));
                }
                String string = this.getString(map2, "pattern");
                if (string == null) {
                    throw new ConfigurationException("The pattern property is required for all relocations");
                }
                String string2 = this.getString(map2, "relocatedPattern");
                if (string2 == null) {
                    throw new ConfigurationException("The relocatedPattern property is required for all relocations");
                }
                ArrayList<Object> arrayList2 = this.getArray(map2, "includes");
                if (arrayList2 != null) {
                    object2 = arrayList2.iterator();
                    while (object2.hasNext()) {
                        object = object2.next();
                        if (object instanceof String) continue;
                        throw new ConfigurationException("Invalid relocation include: " + object);
                    }
                }
                if ((object2 = this.getArray(map2, "excludes")) != null) {
                    object = ((ArrayList)object2).iterator();
                    while (object.hasNext()) {
                        Object e = object.next();
                        if (e instanceof String) continue;
                        throw new ConfigurationException("Invalid relocation exclude: " + e);
                    }
                }
                hashSet.add(new Relocation(string, string2, arrayList2, (Collection<String>)object2));
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    @NotNull
    private Set<ExcludedDependency> fetchExcludedTransitiveDependencies(@NotNull Map<String, Object> map) {
        ArrayList<Object> arrayList = this.getArray(map, "excludedTransitiveDependencies");
        if (arrayList != null) {
            HashSet<ExcludedDependency> hashSet = new HashSet<ExcludedDependency>();
            for (int i = 0; i < arrayList.size(); ++i) {
                Map<String, Object> map2 = this.getObject(arrayList, i);
                if (map2 == null) {
                    throw new ConfigurationException("Invalid excluded transitive dependency: " + arrayList.get(i));
                }
                String string = this.getString(map2, "groupId");
                if (string == null) {
                    throw new ConfigurationException("The groupId property is required for all excluded transitive dependencies");
                }
                String string2 = this.getString(map2, "artifactId");
                if (string2 == null) {
                    throw new ConfigurationException("The artifactId property is required for all excluded transitive dependencies");
                }
                hashSet.add(new ExcludedDependency(string, string2));
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    private List<Library> fetchLibraries(@NotNull Map<String, Object> map, @NotNull Set<Relocation> set) {
        ArrayList<Object> arrayList = this.getArray(map, "libraries");
        if (arrayList != null) {
            ArrayList<Library> arrayList2 = new ArrayList<Library>(arrayList.size());
            for (int i = 0; i < arrayList.size(); ++i) {
                String string;
                Map<String, Object> map2 = this.getObject(arrayList, i);
                if (map2 == null) {
                    throw new ConfigurationException("Invalid library: " + arrayList.get(i));
                }
                Library.Builder builder = Library.builder();
                String string2 = this.getString(map2, "groupId");
                if (string2 == null) {
                    throw new ConfigurationException("The groupId property is required for all libraries");
                }
                String string3 = this.getString(map2, "artifactId");
                if (string3 == null) {
                    throw new ConfigurationException("The artifactId property is required for all libraries");
                }
                String string4 = this.getString(map2, "version");
                if (string4 == null) {
                    throw new ConfigurationException("The version property is required for all libraries");
                }
                builder.groupId(string2).artifactId(string3).version(string4);
                String string5 = this.getString(map2, "checksum");
                if (string5 != null) {
                    builder.checksum(string5);
                }
                if ((string = this.getString(map2, "checksumFromBase64")) != null) {
                    try {
                        builder.checksumFromBase64(string);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new ConfigurationException("The checksum property must be a valid base64 encoded SHA-256 checksum");
                    }
                }
                builder.isolatedLoad(this.getBoolean(map2, "isolatedLoad"));
                builder.loaderId(this.getString(map2, "loaderId"));
                builder.classifier(this.getString(map2, "classifier"));
                builder.resolveTransitiveDependencies(this.getBoolean(map2, "resolveTransitiveDependencies"));
                this.fetchExcludedTransitiveDependencies(map2).forEach(builder::excludeTransitiveDependency);
                this.fetchRepositories(map2, false).forEach(builder::repository);
                this.fetchRepositories(map2, true).forEach(builder::fallbackRepository);
                Set<Relocation> set2 = this.fetchRelocations(map2);
                for (Relocation relocation : set2) {
                    builder.relocate(relocation);
                }
                for (Relocation relocation : set) {
                    builder.relocate(relocation);
                }
                arrayList2.add(builder.build());
            }
            return Collections.unmodifiableList(arrayList2);
        }
        return Collections.emptyList();
    }

    private boolean getBoolean(@NotNull Map<String, Object> map, @NotNull String string) {
        return (Boolean)this.jsonObjectGetBoolean.invoke(map, string);
    }

    @Nullable
    private String getString(@NotNull Map<String, Object> map, @NotNull String string) {
        return (String)this.jsonObjectGetString.invoke(map, string);
    }

    @Nullable
    private ArrayList<Object> getArray(@NotNull Map<String, Object> map, @NotNull String string) {
        return (ArrayList)this.jsonObjectGetArray.invoke(map, string);
    }

    @Nullable
    private Map<String, Object> getObject(@NotNull ArrayList<Object> arrayList, int n) {
        return (Map)this.jsonArrayGetObject.invoke(arrayList, n);
    }
}
