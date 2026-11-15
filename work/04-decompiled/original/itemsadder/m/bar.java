package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.baj;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import java.io.File;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.function.Consumer;
import org.bukkit.plugin.Plugin;

public class bar {
    private static ServerSocket azh;
    final Plugin azi;
    public final int azj;
    final File azk;
    boolean kI = false;

    public bar(Plugin plugin, File file, int n) {
        this.azi = plugin;
        this.azj = n;
        this.azk = file;
        baj.w(ae.cv, ae.cw);
    }

    public boolean Ct() {
        return this.kI;
    }

    public void f(Consumer consumer) {
        try {
            Files.createDirectories(this.azk.toPath(), new FileAttribute[0]);
        }
        catch (Throwable throwable) {
            bce.error("\n\n");
            bce.error("Failed to create folder: " + this.azk.getAbsolutePath(), throwable);
            bce.error("\n\n");
            consumer.accept(false);
            return;
        }
        this.kI = true;
        bcp.j(() -> {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
             *     at software.coley.recaf.services.decompile.cfr.CfrDecompiler.decompileInternal(CfrDecompiler.java:61)
             *     at software.coley.recaf.services.decompile.AbstractJvmDecompiler.decompile(AbstractJvmDecompiler.java:49)
             *     at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
             *     at java.base/java.lang.reflect.Method.invoke(Method.java:580)
             *     at org.jboss.weld.bean.proxy.AbstractBeanInstance.invoke(AbstractBeanInstance.java:39)
             *     at org.jboss.weld.bean.proxy.ProxyMethodHandler.invoke(ProxyMethodHandler.java:109)
             *     at software.coley.recaf.services.decompile.Decompiler$JvmDecompiler$1269202896$Proxy$_$$_WeldClientProxy.decompile(Unknown Source)
             *     at software.coley.recaf.services.decompile.DecompilerManager.lambda$decompile$2(DecompilerManager.java:156)
             *     at java.base/java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1768)
             *     at software.coley.recaf.util.threading.ThreadUtil.lambda$wrap$2(ThreadUtil.java:250)
             *     at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
             *     at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
             *     at java.base/java.lang.Thread.run(Thread.java:1570)
             */
            throw new IllegalStateException("Decompilation failed");
        });
    }

    public void bU() {
        this.kI = false;
        try {
            if (azh != null) {
                azh.close();
            }
        }
        catch (Throwable throwable) {
            bce.error("Uncaught error stopping self-host", throwable);
        }
    }
}
