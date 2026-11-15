package itemsadder.m;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.util.JavacTask;
import itemsadder.m.Opaque143;
import itemsadder.m.Opaque148;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;

public class Opaque147 {
    private final JavaCompiler NW;
    private final Opaque143 NX;
    private final List NY;
    private final JavaFileObject NZ;
    String Oa;
    Set Ob;

    public Opaque147(JavaCompiler javaCompiler, Opaque143 opaque143, List list, JavaFileObject javaFileObject, String string, Set set) {
        this.NW = javaCompiler;
        this.NX = opaque143;
        this.NY = list;
        this.NZ = javaFileObject;
        this.Oa = string;
        this.Ob = set;
    }

    public List rL() {
        DiagnosticCollector diagnosticCollector = new DiagnosticCollector();
        JavacTask javacTask = (JavacTask)this.NW.getTask(null, this.NX, diagnosticCollector, this.NY, null, List.of(this.NZ));
        Iterable<? extends CompilationUnitTree> iterable = javacTask.parse();
        ArrayList arrayList = new ArrayList();
        for (CompilationUnitTree compilationUnitTree : iterable) {
            compilationUnitTree.accept(new Opaque148(this, arrayList), null);
        }
        return arrayList.stream().distinct().collect(Collectors.toList());
    }
}
