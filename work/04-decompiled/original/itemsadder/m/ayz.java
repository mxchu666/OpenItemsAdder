package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import itemsadder.m.ayo;
import itemsadder.m.ayq;
import itemsadder.m.aza;
import itemsadder.m.azr;
import itemsadder.m.rc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
public class ayz {
    private final rc axl;

    public ayz(rc rc2) {
        this.axl = Objects.requireNonNull(rc2, "CustomItem cannot be null");
    }

    /*
     * Exception decompiling
     */
    public aza AU() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Can't turn ConstantPoolEntry into Literal - got DynamicInfo value=1,94
         *     at org.benf.cfr.reader.bytecode.analysis.parse.literal.TypedLiteral.getConstantPoolEntry(TypedLiteral.java:340)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.getBootstrapArg(Op02WithProcessedDataAndRefs.java:538)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.getVarArgs(Op02WithProcessedDataAndRefs.java:671)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.buildInvokeBootstrapArgs(Op02WithProcessedDataAndRefs.java:630)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.buildInvokeDynamic(Op02WithProcessedDataAndRefs.java:411)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.buildInvokeDynamic(Op02WithProcessedDataAndRefs.java:392)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:1215)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:57)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2080)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2077)
         *     at org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2089)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:469)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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
    }

    private aza a(ayo ayo2) {
        ayq ayq2 = ayo2.AS();
        List list = Collections.emptyList();
        if (ayq2.axh != null) {
            list = ayz.y(ayq2.axh.axf, ayq2.axh.axg);
        }
        ArrayList arrayList = new ArrayList();
        ayq2.axi.forEach((string, ayp2) -> {
            if (ayp2.AT()) {
                return;
            }
            arrayList.addAll(ayz.y(ayp2.axf, ayp2.axg));
        });
        List list2 = Collections.emptyList();
        if (ayq2.axj != null) {
            list2 = ayz.y(this.axl.nJ(), ayq2.axj);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.addAll(list);
        arrayList2.addAll(list2);
        return new aza(ayq2.axh, ayq2.axi, ayq2.axj, arrayList2, ayq2.axk);
    }

    private static List y(String string, JSONObject jSONObject) {
        return new azr((String)string).C((JSONObject)jSONObject).ayu;
    }
}
