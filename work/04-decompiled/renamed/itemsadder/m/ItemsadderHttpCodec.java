package itemsadder.m;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import itemsadder.m.OPTIONS;
import java.nio.charset.StandardCharsets;
import org.jetbrains.annotations.NotNull;

final class ItemsadderHttpCodec
extends ChannelDuplexHandler {
    private ItemsadderHttpCodec() {
    }

    public void channelRead(@NotNull ChannelHandlerContext channelHandlerContext, Object object) {
        if (!(object instanceof ByteBuf)) {
            super.channelRead(channelHandlerContext, object);
            return;
        }
        ByteBuf byteBuf = (ByteBuf)object;
        if (byteBuf.readableBytes() < 4) {
            super.channelRead(channelHandlerContext, object);
            return;
        }
        String string = byteBuf.toString(byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), 8), StandardCharsets.US_ASCII);
        if (!string.startsWith("GET ")) {
            super.channelRead(channelHandlerContext, object);
            return;
        }
        ChannelPipeline channelPipeline = channelHandlerContext.pipeline();
        boolean bl = false;
        for (String string2 : channelPipeline.names().toArray(new String[0])) {
            if (string2.equals(channelHandlerContext.name())) {
                bl = true;
            }
            if (!bl || channelPipeline.get(string2) == null) continue;
            channelPipeline.remove(string2);
        }
        channelPipeline.addLast("itemsadder_http_codec", (ChannelHandler)new HttpServerCodec());
        channelPipeline.addLast("itemsadder_http_aggregator", (ChannelHandler)new HttpObjectAggregator(65536));
        channelPipeline.addLast("itemsadder_http_handler", (ChannelHandler)new OPTIONS());
        channelHandlerContext.pipeline().fireChannelRead((Object)byteBuf.retain());
    }
}
