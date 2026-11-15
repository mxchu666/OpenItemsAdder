package itemsadder.m;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import itemsadder.m.PlayerWrapper_4;
import java.util.function.Supplier;

class Opaque007
extends ChannelInboundHandlerAdapter {
    final /* synthetic */ String ajX;
    final /* synthetic */ String ajY;
    final /* synthetic */ Supplier ajZ;

    Opaque007(PlayerWrapper_4 playerWrapper_4, String string, String string2, Supplier supplier) {
        this.ajX = string;
        this.ajY = string2;
        this.ajZ = supplier;
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) {
        if (object instanceof Channel) {
            Channel channel = (Channel)object;
            PlayerWrapper_4.a(channel, this.ajX, this.ajY, this.ajZ);
        }
        super.channelRead(channelHandlerContext, object);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        throwable.printStackTrace();
        super.exceptionCaught(channelHandlerContext, throwable);
    }
}
