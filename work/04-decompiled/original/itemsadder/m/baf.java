package itemsadder.m;

import dev.lone.itemsadder.resourcepack.ad;
import itemsadder.m.ah;
import itemsadder.m.bae;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class baf
extends bae {
    public baf() {
        super("https://lobfile.com/api/v3/upload");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String a(ad ad2, @Nullable Player player) {
        BossBar bossBar;
        String string = ah.gc;
        if (string == null || string.length() < 10) {
            bce.error(" ");
            bce.error(String.valueOf(ChatColor.RED) + "[Pack] Can't upload the resourcepack.");
            bce.error(String.valueOf(ChatColor.RED) + "[Pack] Please specify a api_key for LobFile in secret.yml file.");
            bce.error(String.valueOf(ChatColor.RED) + "[Pack] Read more here: https://a.devs.beer/lobfile-userhash");
            bce.error(" ");
            return null;
        }
        this.ayN = true;
        bce.log(String.valueOf(ChatColor.AQUA) + "[Pack] Uploading resourcepack...");
        if (player == null) {
            bossBar = null;
        } else {
            bossBar = Bukkit.createBossBar((String)"Uploading...", (BarColor)BarColor.GREEN, (BarStyle)BarStyle.SEGMENTED_6, (BarFlag[])new BarFlag[0]);
            bossBar.setProgress(0.0);
            bossBar.addPlayer(player);
        }
        try {
            String string3 = baf.a(bossBar, string, ad2.yz());
            if (string3 == null) {
                bce.log("Pack URL is null.");
                String string4 = null;
                return string4;
            }
            if (player != null) {
                bce.a((CommandSender)player, "resourcepack-uploaded-successfully", (Object string2) -> string2.replace("{url}", string3));
            }
            bce.log(String.valueOf(ChatColor.GREEN) + "[Pack] Finished uploading resourcepack: " + string3);
            String string5 = string3;
            return string5;
        }
        catch (Throwable throwable) {
            bce.b((CommandSender)player, String.valueOf(ChatColor.RED) + "[Pack] Can't upload the resourcepack automatically to " + this.ayM + ". Error: " + String.valueOf(throwable));
            String string6 = null;
            return string6;
        }
        finally {
            this.ayN = false;
            if (bossBar != null) {
                bossBar.removeAll();
            }
        }
    }

    /*
     * Exception decompiling
     */
    private static String a(BossBar var0, String var1_1, File var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    private static /* synthetic */ void a(BossBar bossBar, long l, long l2) {
        if (bossBar != null) {
            bossBar.setTitle(bcy.k(l2) + " / " + bcy.k(l));
            float f = Math.max((float)l2 / (float)l, 1.0f);
            bossBar.setProgress((double)f);
        }
    }
}
