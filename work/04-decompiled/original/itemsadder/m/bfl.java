package itemsadder.m;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import itemsadder.m.bfj;
import itemsadder.m.bfm;
import java.util.List;
import java.util.ListIterator;

public class bfl {
    private static final AttributeKey aCZ = AttributeKey.valueOf((String)bfl.class.getName());
    private final ChannelHandlerContext aDa;
    private final bfj aDb = new bfj();
    private final bfm aDc = new bfm();

    public bfl(ChannelHandlerContext channelHandlerContext) {
        this.aDa = channelHandlerContext;
    }

    private void En() {
        while (this.aDc.Eo()) {
            List list = this.aDb.Em();
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                Object e = listIterator.previous();
                this.aDa.write(e);
            }
        }
        this.aDa.flush();
    }

    public static void a(ChannelHandlerContext channelHandlerContext, Object object) {
        bfl bfl2 = bfl.c(channelHandlerContext);
        bfl2.aDb.add(object);
        if (bfl2.aDc.Ep()) {
            channelHandlerContext.executor().execute(bfl2::En);
        }
    }

    public static void b(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext == null || channelHandlerContext.channel() == null || !channelHandlerContext.channel().hasAttr(aCZ)) {
            return;
        }
        channelHandlerContext.channel().attr(aCZ).set(null);
    }

    private static bfl c(ChannelHandlerContext channelHandlerContext) {
        Attribute attribute = channelHandlerContext.channel().attr(aCZ);
        bfl bfl2 = (bfl)attribute.get();
        if (bfl2 != null) {
            return bfl2;
        }
        bfl bfl3 = new bfl(channelHandlerContext);
        bfl bfl4 = (bfl)attribute.setIfAbsent((Object)bfl3);
        if (bfl4 != null) {
            return bfl4;
        }
        return bfl3;
    }
}
