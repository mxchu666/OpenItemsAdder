package itemsadder.m;

import com.google.common.collect.ImmutableMap;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BreakEnum;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.RecordOfItemStack;
import itemsadder.m.VectorBridge_2;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
public class LocationBridge_7 {
    public final String hD;
    public final ItemStackBuilder_4 hE;
    private final String hF;
    private final String hG;
    private final String hH;
    public final VectorBridge_2 hI;
    final ImmutableMap hJ;
    public final int hK;
    private final String hL;
    private final Material hM;
    public final boolean hN;
    public final boolean hO;
    public final double hP;
    public final int hQ;
    @Nullable
    public final Integer hR;
    public final float hS;
    public final double hT;
    public final float hU;
    public final float hV;
    public final float hW;
    public final boolean hX;
    @Nullable
    public final ImmutableMap hY;

    public boolean i(@NotNull Block block) {
        Object object;
        if (this.hL == null) {
            return true;
        }
        Block block2 = block.getRelative(0, -1, 0);
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block2);
        if (blockBridge_9 != null && (object = blockBridge_9.Y(block)) != null) {
            return ((String)object).endsWith(this.hL);
        }
        object = block2.getBlockData();
        return object.getAsString().endsWith(this.hL);
    }

    public boolean a(BreakEnum breakEnum) {
        return this.hY != null && this.hY.containsKey((Object)breakEnum);
    }

    /*
     * Exception decompiling
     */
    public boolean a(@Nullable Player var1_1, int var2_2, Location var3_3, BreakEnum var4_4, boolean var5_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Can't turn ConstantPoolEntry into Literal - got DynamicInfo value=2,155
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

    public void d(@NotNull Location location) {
        LocationBridge_4.b(location, this.hE.mP());
    }

    public boolean j(@NotNull Block block) {
        if (this.hM == null && this.hL == null) {
            return true;
        }
        Block block2 = block.getRelative(0, -1, 0);
        if (this.hL != null) {
            String string = ItemStackRegistry.c(block);
            if (string == null) {
                return false;
            }
            return this.hL.endsWith(string);
        }
        return block2.getType() == this.hM;
    }

    public void e(Location location) {
        this.playSound(location, this.hG);
    }

    public void f(Location location) {
        this.playSound(location, this.hF);
    }

    public void g(Location location) {
        if (this.hH == null) {
            this.playSound(location, this.hG);
            return;
        }
        this.playSound(location, this.hH);
    }

    public void playSound(Location location, String string) {
        if (string != null) {
            float f = 0.8f + (float)(Math.random() * (double)0.4f - (double)0.2f);
            LocationBridge_3.a(location, string, SoundCategory.BLOCKS, 1.0f, f);
        }
    }

    public void h(Location location) {
        this.playSound(location, Sound.ENTITY_GENERIC_EXTINGUISH_FIRE.getKey().toString());
    }

    @Nullable
    public RecordOfItemStack f(int n) {
        return this.a((byte)n);
    }

    @Nullable
    public RecordOfItemStack a(byte by) {
        return (RecordOfItemStack)this.hJ.get(by);
    }

    @Generated
    private static double bx() {
        return 240.0;
    }

    @Generated
    private static int by() {
        return 9;
    }

    @Generated
    private static float bz() {
        return 0.2f;
    }

    @Generated
    private static double bA() {
        return 0.5;
    }

    @Generated
    private static float bB() {
        return 1.5f;
    }

    @Generated
    private static float bC() {
        return -1.0f;
    }

    @Generated
    private static float bD() {
        return -1.5f;
    }

    @Generated
    private static boolean bE() {
        return true;
    }

    @Generated
    LocationBridge_7(String string, ItemStackBuilder_4 itemStackBuilder_4, String string2, String string3, String string4, VectorBridge_2 vectorBridge_2, ImmutableMap immutableMap, int n, String string5, Material material, boolean bl, boolean bl2, double d, int n2, @Nullable Integer n3, float f, double d2, float f2, float f3, float f4, boolean bl3, @Nullable ImmutableMap immutableMap2) {
        this.hD = string;
        this.hE = itemStackBuilder_4;
        this.hF = string2;
        this.hG = string3;
        this.hH = string4;
        this.hI = vectorBridge_2;
        this.hJ = immutableMap;
        this.hK = n;
        this.hL = string5;
        this.hM = material;
        this.hN = bl;
        this.hO = bl2;
        this.hP = d;
        this.hQ = n2;
        this.hR = n3;
        this.hS = f;
        this.hT = d2;
        this.hU = f2;
        this.hV = f3;
        this.hW = f4;
        this.hX = bl3;
        this.hY = immutableMap2;
    }

    @Generated
    public static LocationBridgeBuilder bF() {
        return new LocationBridgeBuilder();
    }
}
