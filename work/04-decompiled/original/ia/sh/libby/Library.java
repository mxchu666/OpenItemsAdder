package ia.sh.libby;

import ia.sh.libby.Util;
import ia.sh.libby.relocation.Relocation;
import ia.sh.libby.transitive.ExcludedDependency;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Library {
    @NotNull
    private final Collection<String> urls;
    @NotNull
    private final Collection<String> repositories;
    @NotNull
    private final Collection<String> fallbackRepositories;
    @NotNull
    private final String groupId;
    @NotNull
    private final String artifactId;
    @NotNull
    private final String version;
    @Nullable
    private final String classifier;
    private final byte @Nullable [] checksum;
    @NotNull
    private final Collection<Relocation> relocations;
    @NotNull
    private final String path;
    @NotNull
    private final String partialPath;
    @Nullable
    private final String relocatedPath;
    private final boolean isolatedLoad;
    @Nullable
    private final String loaderId;
    private final boolean resolveTransitiveDependencies;
    @NotNull
    private final Collection<ExcludedDependency> excludedTransitiveDependencies;

    private Library(@Nullable Collection<String> collection, @Nullable Collection<String> collection2, @Nullable Collection<String> collection3, @NotNull String string, @NotNull String string2, @NotNull String string3, @Nullable String string4, byte @Nullable [] byArray, @Nullable Collection<Relocation> collection4, boolean bl, @Nullable String string5, boolean bl2, @Nullable Collection<ExcludedDependency> collection5) {
        this.urls = collection != null ? Collections.unmodifiableList(new LinkedList<String>(collection)) : Collections.emptyList();
        this.groupId = Util.replaceWithDots(Objects.requireNonNull(string, "groupId"));
        this.artifactId = Util.replaceWithDots(Objects.requireNonNull(string2, "artifactId"));
        this.version = Objects.requireNonNull(string3, "version");
        this.classifier = string4;
        this.checksum = byArray;
        this.relocations = collection4 != null ? Collections.unmodifiableList(new LinkedList<Relocation>(collection4)) : Collections.emptyList();
        this.partialPath = Util.craftPartialPath(this.artifactId, this.groupId, string3);
        this.path = Util.craftPath(this.partialPath, this.artifactId, this.version, this.classifier);
        this.repositories = collection2 != null ? Collections.unmodifiableList(new LinkedList<String>(collection2)) : Collections.emptyList();
        this.fallbackRepositories = collection3 != null ? Collections.unmodifiableList(new LinkedList<String>(collection3)) : Collections.emptyList();
        this.relocatedPath = this.hasRelocations() ? this.path + "-relocated-" + Math.abs(this.relocations.hashCode()) + ".jar" : null;
        this.isolatedLoad = bl;
        this.loaderId = string5;
        this.resolveTransitiveDependencies = bl2;
        this.excludedTransitiveDependencies = collection5 != null ? Collections.unmodifiableList(new LinkedList<ExcludedDependency>(collection5)) : Collections.emptyList();
    }

    @NotNull
    public Collection<String> getUrls() {
        return this.urls;
    }

    @NotNull
    public Collection<String> getRepositories() {
        return this.repositories;
    }

    @NotNull
    public Collection<String> getFallbackRepositories() {
        return this.fallbackRepositories;
    }

    @NotNull
    public String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public String getArtifactId() {
        return this.artifactId;
    }

    @NotNull
    public String getVersion() {
        return this.version;
    }

    @Nullable
    public String getClassifier() {
        return this.classifier;
    }

    public boolean hasClassifier() {
        return this.classifier != null && !this.classifier.isEmpty();
    }

    public byte @Nullable [] getChecksum() {
        return this.checksum;
    }

    public boolean hasChecksum() {
        return this.checksum != null;
    }

    @NotNull
    public Collection<Relocation> getRelocations() {
        return this.relocations;
    }

    public boolean hasRelocations() {
        return !this.relocations.isEmpty();
    }

    @NotNull
    public String getPath() {
        return this.path;
    }

    @NotNull
    public String getPartialPath() {
        return this.partialPath;
    }

    @Nullable
    public String getRelocatedPath() {
        return this.relocatedPath;
    }

    public boolean isIsolatedLoad() {
        return this.isolatedLoad;
    }

    @Nullable
    public String getLoaderId() {
        return this.loaderId;
    }

    public boolean isSnapshot() {
        return this.version.endsWith("-SNAPSHOT");
    }

    public boolean resolveTransitiveDependencies() {
        return this.resolveTransitiveDependencies;
    }

    @NotNull
    public Collection<ExcludedDependency> getExcludedTransitiveDependencies() {
        return this.excludedTransitiveDependencies;
    }

    public String toString() {
        String string = this.groupId + ':' + this.artifactId + ':' + this.version;
        if (this.hasClassifier()) {
            string = string + ':' + this.classifier;
        }
        return string;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
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
        public Builder url(@NotNull String string) {
            this.urls.add(Objects.requireNonNull(string, "url"));
            return this;
        }

        @NotNull
        public Builder repository(@NotNull String string) {
            this.repositories.add(Objects.requireNonNull(string, "repository").endsWith("/") ? string : string + '/');
            return this;
        }

        @NotNull
        public Builder fallbackRepository(@NotNull String string) {
            this.fallbackRepositories.add(Objects.requireNonNull(string, "fallbackRepository").endsWith("/") ? string : string + '/');
            return this;
        }

        @NotNull
        public Builder groupId(@NotNull String string) {
            this.groupId = Objects.requireNonNull(string, "groupId");
            return this;
        }

        @NotNull
        public Builder artifactId(@NotNull String string) {
            this.artifactId = Objects.requireNonNull(string, "artifactId");
            return this;
        }

        @NotNull
        public Builder version(@NotNull String string) {
            this.version = Objects.requireNonNull(string, "version");
            return this;
        }

        @NotNull
        public Builder classifier(@Nullable String string) {
            this.classifier = string;
            return this;
        }

        @NotNull
        public Builder checksum(byte @Nullable [] byArray) {
            this.checksum = byArray;
            return this;
        }

        @NotNull
        public Builder checksum(@Nullable String string) {
            return string != null ? this.checksum(Util.hexStringToByteArray(string)) : this;
        }

        @NotNull
        public Builder checksumFromBase64(@Nullable String string) {
            return string != null ? this.checksum(Base64.getDecoder().decode(string)) : this;
        }

        @NotNull
        public Builder isolatedLoad(boolean bl) {
            this.isolatedLoad = bl;
            return this;
        }

        @NotNull
        public Builder loaderId(@Nullable String string) {
            this.loaderId = string;
            return this;
        }

        @NotNull
        public Builder relocate(@NotNull Relocation relocation) {
            Objects.requireNonNull(relocation, "relocation");
            if (!relocation.getPattern().equals(relocation.getRelocatedPattern())) {
                this.relocations.add(relocation);
            }
            return this;
        }

        @NotNull
        public Builder relocate(@NotNull String string, @NotNull String string2) {
            return this.relocate(new Relocation(string, string2));
        }

        @NotNull
        public Builder resolveTransitiveDependencies(boolean bl) {
            this.resolveTransitiveDependencies = bl;
            return this;
        }

        @NotNull
        public Builder excludeTransitiveDependency(@NotNull ExcludedDependency excludedDependency) {
            this.excludedTransitiveDependencies.add(Objects.requireNonNull(excludedDependency, "excludedDependency"));
            return this;
        }

        @NotNull
        public Builder excludeTransitiveDependency(@NotNull String string, @NotNull String string2) {
            return this.excludeTransitiveDependency(new ExcludedDependency(string, string2));
        }

        @NotNull
        public Library build() {
            return new Library(this.urls, this.repositories, this.fallbackRepositories, this.groupId, this.artifactId, this.version, this.classifier, this.checksum, this.relocations, this.isolatedLoad, this.loaderId, this.resolveTransitiveDependencies, this.excludedTransitiveDependencies);
        }
    }
}
