package itemsadder.m;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.ReadTimeoutException;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ItemsadderHttpPacket;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.RecordOfChannelHandlerContext;
import itemsadder.m.RecordOfFullHttpRequest;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class OPTIONS
extends SimpleChannelInboundHandler {
    protected void a(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        String string2;
        RecordOfFullHttpRequest recordOfFullHttpRequest = new RecordOfFullHttpRequest(fullHttpRequest);
        RecordOfChannelHandlerContext recordOfChannelHandlerContext = new RecordOfChannelHandlerContext(channelHandlerContext);
        String string3 = recordOfFullHttpRequest.Cm();
        if (string3.equalsIgnoreCase("OPTIONS")) {
            recordOfChannelHandlerContext.Cq();
            return;
        }
        HttpHeaders httpHeaders = fullHttpRequest.headers();
        if (MaterialBarColorHolder.cp) {
            if (!httpHeaders.contains("User-Agent")) {
                recordOfChannelHandlerContext.b(401, "Unauthorized", "text/plain");
                return;
            }
            string2 = httpHeaders.get("User-Agent");
            if (string2.contains("bot") || string2.contains("Bot") || string2.contains("BOT")) {
                recordOfChannelHandlerContext.b(401, "Unauthorized", "text/plain");
                return;
            }
            if (!string2.startsWith("Mozilla") && !string2.startsWith("Minecraft")) {
                recordOfChannelHandlerContext.b(401, "Unauthorized", "text/plain");
                return;
            }
            if (!(httpHeaders.contains("X-Minecraft-Username") && httpHeaders.contains("X-Minecraft-UUID") && httpHeaders.contains("X-Minecraft-Version") && httpHeaders.contains("X-Minecraft-Version-ID") && httpHeaders.contains("User-Agent") && httpHeaders.get("User-Agent").startsWith("Minecraft Java"))) {
                recordOfChannelHandlerContext.b(401, "Unauthorized", "text/plain");
                return;
            }
        }
        if ((string2 = recordOfFullHttpRequest.pK()).equals("/resourcepack")) {
            String string4 = ItemsadderHttpPacket.a(channelHandlerContext);
            AtomicInteger atomicInteger = ItemsadderHttpPacket.azc.computeIfAbsent(string4, string -> new AtomicInteger());
            if (atomicInteger.incrementAndGet() > ItemsadderHttpPacket.azb) {
                atomicInteger.decrementAndGet();
                recordOfChannelHandlerContext.b(429, "Too many active downloads", "text/plain");
                return;
            }
            Runnable runnable = () -> {
                int n = atomicInteger.decrementAndGet();
                if (n <= 0) {
                    ItemsadderHttpPacket.azc.remove(string4, atomicInteger);
                }
            };
            File file = new File(ItemStackRegistry.h(), "generated.zip");
            recordOfChannelHandlerContext.a(file, "application/zip", runnable, runnable);
            return;
        }
        recordOfChannelHandlerContext.b(404, "Not Found", "text/plain");
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
