package itemsadder.m;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import itemsadder.m.aor;
import java.util.function.Supplier;

class aos
extends ChannelInboundHandlerAdapter {
    final /* synthetic */ String ajX;
    final /* synthetic */ String ajY;
    final /* synthetic */ Supplier ajZ;

    aos(aor aor2, String string, String string2, Supplier supplier) {
        this.ajX = string;
        this.ajY = string2;
        this.ajZ = supplier;
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) {
        if (object instanceof Channel) {
            Channel channel = (Channel)object;
            aor.a(channel, this.ajX, this.ajY, this.ajZ);
        }
        super.channelRead(channelHandlerContext, object);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        throwable.printStackTrace();
        super.exceptionCaught(channelHandlerContext, throwable);
    }
}
