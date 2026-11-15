package ia.sh.libby.transitive;

import ia.sh.libby.Util;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class ExcludedDependency {
    @NotNull
    private final String groupId;
    @NotNull
    private final String artifactId;

    public ExcludedDependency(@NotNull String string, @NotNull String string2) {
        this.groupId = Util.replaceWithDots(Objects.requireNonNull(string, "groupId"));
        this.artifactId = Util.replaceWithDots(Objects.requireNonNull(string2, "artifactId"));
    }

    @NotNull
    public String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public String getArtifactId() {
        return this.artifactId;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ExcludedDependency excludedDependency = (ExcludedDependency)object;
        if (!this.groupId.equals(excludedDependency.groupId)) {
            return false;
        }
        return this.artifactId.equals(excludedDependency.artifactId);
    }

    public int hashCode() {
        int n = this.groupId.hashCode();
        n = 31 * n + this.artifactId.hashCode();
        return n;
    }
}
