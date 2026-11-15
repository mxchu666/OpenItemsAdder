package ia.sh.libby.relocation;

import ia.sh.libby.Util;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Relocation {
    @NotNull
    private final String pattern;
    @NotNull
    private final String relocatedPattern;
    @NotNull
    private final Collection<String> includes;
    @NotNull
    private final Collection<String> excludes;

    public Relocation(@NotNull String string, @NotNull String string2, @Nullable Collection<String> collection, @Nullable Collection<String> collection2) {
        this.pattern = Util.replaceWithDots(Objects.requireNonNull(string, "pattern"));
        this.relocatedPattern = Util.replaceWithDots(Objects.requireNonNull(string2, "relocatedPattern"));
        this.includes = collection != null ? Collections.unmodifiableSet(collection.stream().map(Util::replaceWithDots).collect(Collectors.toSet())) : Collections.emptySet();
        this.excludes = collection2 != null ? Collections.unmodifiableSet(collection2.stream().map(Util::replaceWithDots).collect(Collectors.toSet())) : Collections.emptySet();
    }

    public Relocation(@NotNull String string, @NotNull String string2) {
        this(string, string2, null, null);
    }

    @NotNull
    public String getPattern() {
        return this.pattern;
    }

    @NotNull
    public String getRelocatedPattern() {
        return this.relocatedPattern;
    }

    @NotNull
    public Collection<String> getIncludes() {
        return this.includes;
    }

    @NotNull
    public Collection<String> getExcludes() {
        return this.excludes;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Relocation relocation = (Relocation)object;
        if (!this.pattern.equals(relocation.pattern)) {
            return false;
        }
        if (!this.relocatedPattern.equals(relocation.relocatedPattern)) {
            return false;
        }
        if (!this.includes.equals(relocation.includes)) {
            return false;
        }
        return this.excludes.equals(relocation.excludes);
    }

    public int hashCode() {
        int n = this.pattern.hashCode();
        n = 31 * n + this.relocatedPattern.hashCode();
        n = 31 * n + this.includes.hashCode();
        n = 31 * n + this.excludes.hashCode();
        return n;
    }

    @NotNull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String pattern;
        private String relocatedPattern;
        private final Collection<String> includes = new LinkedList<String>();
        private final Collection<String> excludes = new LinkedList<String>();

        @NotNull
        public Builder pattern(@NotNull String string) {
            this.pattern = Objects.requireNonNull(string, "pattern");
            return this;
        }

        @NotNull
        public Builder relocatedPattern(@NotNull String string) {
            this.relocatedPattern = Objects.requireNonNull(string, "relocatedPattern");
            return this;
        }

        @NotNull
        public Builder include(@NotNull String string) {
            this.includes.add(Objects.requireNonNull(string, "include"));
            return this;
        }

        @NotNull
        public Builder exclude(@NotNull String string) {
            this.excludes.add(Objects.requireNonNull(string, "exclude"));
            return this;
        }

        @NotNull
        public Relocation build() {
            return new Relocation(this.pattern, this.relocatedPattern, this.includes, this.excludes);
        }
    }
}
