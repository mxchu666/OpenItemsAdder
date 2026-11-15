package ia.sh.libby;

import ia.sh.libby.Library;
import ia.sh.libby.Util;
import ia.sh.libby.relocation.Relocation;
import ia.sh.libby.transitive.ExcludedDependency;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public static class Library.Builder {
    private final Collection<String> urls = new LinkedList<String>();
    private final Collection<String> repositories = new LinkedList<String>();
    private final Collection<String> fallbackRepositories = new LinkedList<String>();
    private String groupId;
    private String artifactId;
    private String version;
    private String classifier;
    private byte[] checksum;
    private boolean isolatedLoad;
    private String loaderId;
    private final Collection<Relocation> relocations = new LinkedList<Relocation>();
    private boolean resolveTransitiveDependencies;
    private final Collection<ExcludedDependency> excludedTransitiveDependencies = new LinkedList<ExcludedDependency>();

    @NotNull
    public Library.Builder url(@NotNull String string) {
        this.urls.add(Objects.requireNonNull(string, "url"));
        return this;
    }

    @NotNull
    public Library.Builder repository(@NotNull String string) {
        this.repositories.add(Objects.requireNonNull(string, "repository").endsWith("/") ? string : string + '/');
        return this;
    }

    @NotNull
    public Library.Builder fallbackRepository(@NotNull String string) {
        this.fallbackRepositories.add(Objects.requireNonNull(string, "fallbackRepository").endsWith("/") ? string : string + '/');
        return this;
    }

    @NotNull
    public Library.Builder groupId(@NotNull String string) {
        this.groupId = Objects.requireNonNull(string, "groupId");
        return this;
    }

    @NotNull
    public Library.Builder artifactId(@NotNull String string) {
        this.artifactId = Objects.requireNonNull(string, "artifactId");
        return this;
    }

    @NotNull
    public Library.Builder version(@NotNull String string) {
        this.version = Objects.requireNonNull(string, "version");
        return this;
    }

    @NotNull
    public Library.Builder classifier(@Nullable String string) {
        this.classifier = string;
        return this;
    }

    @NotNull
    public Library.Builder checksum(byte @Nullable [] byArray) {
        this.checksum = byArray;
        return this;
    }

    @NotNull
    public Library.Builder checksum(@Nullable String string) {
        return string != null ? this.checksum(Util.hexStringToByteArray(string)) : this;
    }

    @NotNull
    public Library.Builder checksumFromBase64(@Nullable String string) {
        return string != null ? this.checksum(Base64.getDecoder().decode(string)) : this;
    }

    @NotNull
    public Library.Builder isolatedLoad(boolean bl) {
        this.isolatedLoad = bl;
        return this;
    }

    @NotNull
    public Library.Builder loaderId(@Nullable String string) {
        this.loaderId = string;
        return this;
    }

    @NotNull
    public Library.Builder relocate(@NotNull Relocation relocation) {
        Objects.requireNonNull(relocation, "relocation");
        if (!relocation.getPattern().equals(relocation.getRelocatedPattern())) {
            this.relocations.add(relocation);
        }
        return this;
    }

    @NotNull
    public Library.Builder relocate(@NotNull String string, @NotNull String string2) {
        return this.relocate(new Relocation(string, string2));
    }

    @NotNull
    public Library.Builder resolveTransitiveDependencies(boolean bl) {
        this.resolveTransitiveDependencies = bl;
        return this;
    }

    @NotNull
    public Library.Builder excludeTransitiveDependency(@NotNull ExcludedDependency excludedDependency) {
        this.excludedTransitiveDependencies.add(Objects.requireNonNull(excludedDependency, "excludedDependency"));
        return this;
    }

    @NotNull
    public Library.Builder excludeTransitiveDependency(@NotNull String string, @NotNull String string2) {
        return this.excludeTransitiveDependency(new ExcludedDependency(string, string2));
    }

    @NotNull
    public Library build() {
        return new Library(this.urls, this.repositories, this.fallbackRepositories, this.groupId, this.artifactId, this.version, this.classifier, this.checksum, this.relocations, this.isolatedLoad, this.loaderId, this.resolveTransitiveDependencies, this.excludedTransitiveDependencies, null);
    }
}
