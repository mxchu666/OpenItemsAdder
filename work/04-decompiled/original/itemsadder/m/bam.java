package itemsadder.m;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.ReadTimeoutException;
import itemsadder.m.ae;
import itemsadder.m.bak;
import itemsadder.m.ban;
import itemsadder.m.bao;
import itemsadder.m.d;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class bam
extends SimpleChannelInboundHandler {
    protected void a(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        String string2;
        ban ban2 = new ban(fullHttpRequest);
        bao bao2 = new bao(channelHandlerContext);
        String string3 = ban2.Cm();
        if (string3.equalsIgnoreCase("OPTIONS")) {
            bao2.Cq();
            return;
        }
        HttpHeaders httpHeaders = fullHttpRequest.headers();
        if (ae.cp) {
            if (!httpHeaders.contains("User-Agent")) {
                bao2.b(401, "Unauthorized", "text/plain");
                return;
            }
            string2 = httpHeaders.get("User-Agent");
            if (string2.contains("bot") || string2.contains("Bot") || string2.contains("BOT")) {
                bao2.b(401, "Unauthorized", "text/plain");
                return;
            }
            if (!string2.startsWith("Mozilla") && !string2.startsWith("Minecraft")) {
                bao2.b(401, "Unauthorized", "text/plain");
                return;
            }
            if (!(httpHeaders.contains("X-Minecraft-Username") && httpHeaders.contains("X-Minecraft-UUID") && httpHeaders.contains("X-Minecraft-Version") && httpHeaders.contains("X-Minecraft-Version-ID") && httpHeaders.contains("User-Agent") && httpHeaders.get("User-Agent").startsWith("Minecraft Java"))) {
                bao2.b(401, "Unauthorized", "text/plain");
                return;
            }
        }
        if ((string2 = ban2.pK()).equals("/resourcepack")) {
            String string4 = bak.a(channelHandlerContext);
            AtomicInteger atomicInteger = bak.azc.computeIfAbsent(string4, string -> new AtomicInteger());
            if (atomicInteger.incrementAndGet() > bak.azb) {
                atomicInteger.decrementAndGet();
                bao2.b(429, "Too many active downloads", "text/plain");
                return;
            }
            Runnable runnable = () -> {
                int n = atomicInteger.decrementAndGet();
                if (n <= 0) {
                    bak.azc.remove(string4, atomicInteger);
                }
            };
            File file = new File(d.h(), "generated.zip");
            bao2.a(file, "application/zip", runnable, runnable);
            return;
        }
        bao2.b(404, "Not Found", "text/plain");
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        if (throwable instanceof ReadTimeoutException) {
            channelHandlerContext.close();
            return;
        }
        throwable.printStackTrace();
        channelHandlerContext.close();
    }

    protected /* synthetic */ void channelRead0(ChannelHandlerContext channelHandlerContext, Object object) {
        this.a(channelHandlerContext, (FullHttpRequest)object);
    }
}
