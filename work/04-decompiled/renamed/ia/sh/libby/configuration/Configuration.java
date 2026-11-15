package ia.sh.libby.configuration;

import ia.sh.libby.Library;
import ia.sh.libby.relocation.Relocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Configuration {
    @Nullable
    private final Integer version;
    @NotNull
    private final Set<String> repositories;
    @NotNull
    private final Set<Relocation> globalRelocations;
    @NotNull
    private final List<Library> libraries;

    public Configuration(@Nullable Integer n, @Nullable Set<String> set, @Nullable Set<Relocation> set2, @Nullable List<Library> list) {
        this.version = n;
        this.repositories = set != null ? Collections.unmodifiableSet(new HashSet<String>(set)) : Collections.emptySet();
        this.globalRelocations = set2 != null ? Collections.unmodifiableSet(new HashSet<Relocation>(set2)) : Collections.emptySet();
        this.libraries = list != null ? Collections.unmodifiableList(new ArrayList<Library>(list)) : Collections.emptyList();
    }

    @Nullable
    public Integer getVersion() {
        return this.version;
    }

    @NotNull
    public Set<String> getRepositories() {
        return this.repositories;
    }

    @NotNull
    public Set<Relocation> getGlobalRelocations() {
        return this.globalRelocations;
    }

    @NotNull
    public List<Library> getLibraries() {
        return this.libraries;
    }
}
