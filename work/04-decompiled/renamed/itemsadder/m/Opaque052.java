package itemsadder.m;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import itemsadder.m.Opaque051;
import itemsadder.m.Opaque053;
import java.util.List;
import java.util.ListIterator;

public class Opaque052 {
    private static final AttributeKey aCZ = AttributeKey.valueOf((String)Opaque052.class.getName());
    private final ChannelHandlerContext aDa;
    private final Opaque051 aDb = new Opaque051();
    private final Opaque053 aDc = new Opaque053();

    public Opaque052(ChannelHandlerContext channelHandlerContext) {
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
        Opaque052 opaque052 = Opaque052.c(channelHandlerContext);
        opaque052.aDb.add(object);
        if (opaque052.aDc.Ep()) {
            channelHandlerContext.executor().execute(opaque052::En);
        }
    }

    public static void b(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext == null || channelHandlerContext.channel() == null || !channelHandlerContext.channel().hasAttr(aCZ)) {
            return;
        }
        channelHandlerContext.channel().attr(aCZ).set(null);
    }

    private static Opaque052 c(ChannelHandlerContext channelHandlerContext) {
        Attribute attribute = channelHandlerContext.channel().attr(aCZ);
        Opaque052 opaque052 = (Opaque052)attribute.get();
        if (opaque052 != null) {
            return opaque052;
        }
        Opaque052 opaque0522 = new Opaque052(channelHandlerContext);
        Opaque052 opaque0523 = (Opaque052)attribute.setIfAbsent((Object)opaque0522);
        if (opaque0523 != null) {
            return opaque0523;
        }
        return opaque0522;
    }
}
