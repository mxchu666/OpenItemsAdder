package itemsadder.m;

import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.ImportTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.NewClassTree;
import com.sun.source.util.TreeScanner;
import itemsadder.m.bce;
import itemsadder.m.bcg;
import itemsadder.m.wo;
import java.util.List;

class wp
extends TreeScanner {
    final /* synthetic */ List Oc;
    final /* synthetic */ wo Od;

    wp(wo wo2, List list) {
        this.Oc = list;
        this.Od = wo2;
    }

    @Override
    @bcg
    public Void visitImport(ImportTree importTree, Void void_) {
        String string = importTree.getQualifiedIdentifier().toString();
        bce.iA("Checking import for threats: " + string);
        for (String string2 : this.Od.Ob) {
            if (!string.startsWith(string2)) continue;
            this.Oc.add("Forbidden import: " + string);
        }
        return (Void)super.visitImport(importTree, null);
    }

    @Override
    @bcg
    public Void visitIdentifier(IdentifierTree identifierTree, Void void_) {
        this.cJ(identifierTree.getName().toString());
        return (Void)super.visitIdentifier(identifierTree, null);
    }

    @Override
    @bcg
    public Void visitMemberSelect(MemberSelectTree memberSelectTree, Void void_) {
        this.cJ(memberSelectTree.toString());
        return (Void)super.visitMemberSelect(memberSelectTree, null);
    }

    @Override
    @bcg
    public Void visitNewClass(NewClassTree newClassTree, Void void_) {
        if (newClassTree.getIdentifier() != null) {
            this.cJ(newClassTree.getIdentifier().toString());
        }
        return (Void)super.visitNewClass(newClassTree, null);
    }

    private void cJ(String string) {
        for (String string2 : this.Od.Ob) {
            if (!string.startsWith(string2)) continue;
            this.Oc.add("Forbidden usage: " + string);
        }
    }
}
