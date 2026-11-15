package itemsadder.m;

import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.ImportTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.NewClassTree;
import com.sun.source.util.TreeScanner;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Opaque147;
import itemsadder.m.PluginContract_4;
import java.util.List;

class Opaque148
extends TreeScanner {
    final /* synthetic */ List Oc;
    final /* synthetic */ Opaque147 Od;

    Opaque148(Opaque147 opaque147, List list) {
        this.Oc = list;
        this.Od = opaque147;
    }

    @Override
    @PluginContract_4
    public Void visitImport(ImportTree importTree, Void void_) {
        String string = importTree.getQualifiedIdentifier().toString();
        CommandSenderBridge_5.iA("Checking import for threats: " + string);
        for (String string2 : this.Od.Ob) {
            if (!string.startsWith(string2)) continue;
            this.Oc.add("Forbidden import: " + string);
        }
        return (Void)super.visitImport(importTree, null);
    }

    @Override
    @PluginContract_4
    public Void visitIdentifier(IdentifierTree identifierTree, Void void_) {
        this.cJ(identifierTree.getName().toString());
        return (Void)super.visitIdentifier(identifierTree, null);
    }

    @Override
    @PluginContract_4
    public Void visitMemberSelect(MemberSelectTree memberSelectTree, Void void_) {
        this.cJ(memberSelectTree.toString());
        return (Void)super.visitMemberSelect(memberSelectTree, null);
    }

    @Override
    @PluginContract_4
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
