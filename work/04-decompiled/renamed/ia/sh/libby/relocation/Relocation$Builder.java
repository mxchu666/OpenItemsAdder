package ia.sh.libby.relocation;

import ia.sh.libby.relocation.Relocation;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public static class Relocation.Builder {
    private String pattern;
    private String relocatedPattern;
    private final Collection<String> includes = new LinkedList<String>();
    private final Collection<String> excludes = new LinkedList<String>();

    @NotNull
    public Relocation.Builder pattern(@NotNull String string) {
        this.pattern = Objects.requireNonNull(string, "pattern");
        return this;
    }

    @NotNull
    public Relocation.Builder relocatedPattern(@NotNull String string) {
        this.relocatedPattern = Objects.requireNonNull(string, "relocatedPattern");
        return this;
    }

    @NotNull
    public Relocation.Builder include(@NotNull String string) {
        this.includes.add(Objects.requireNonNull(string, "include"));
        return this;
    }

    @NotNull
    public Relocation.Builder exclude(@NotNull String string) {
        this.excludes.add(Objects.requireNonNull(string, "exclude"));
        return this;
    }

    @NotNull
    public Relocation build() {
        return new Relocation(this.pattern, this.relocatedPattern, this.includes, this.excludes);
    }
}
