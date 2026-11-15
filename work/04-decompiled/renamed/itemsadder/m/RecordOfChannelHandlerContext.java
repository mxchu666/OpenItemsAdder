package itemsadder.m;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.concurrent.GenericFutureListener;
import itemsadder.m.ItemsadderHttpPacket;
import itemsadder.m.PluginContract_3;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public final class RecordOfChannelHandlerContext
extends Record
implements PluginContract_3 {
    private final ChannelHandlerContext azf;
    private final HttpHeaders azg;

    public RecordOfChannelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this(channelHandlerContext, (HttpHeaders)new DefaultHttpHeaders());
    }

    public RecordOfChannelHandlerContext(ChannelHandlerContext channelHandlerContext, HttpHeaders httpHeaders) {
        this.azf = channelHandlerContext;
        this.azg = httpHeaders;
    }

    @Override
    public void a(int n, byte[] byArray, String string) {
        byte[] byArray2 = byArray != null ? byArray : new byte[]{};
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf((int)n), Unpooled.wrappedBuffer((byte[])byArray2));
        defaultFullHttpResponse.headers().set(this.azg);
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, (Object)"*");
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONTENT_TYPE, (Object)string);
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONTENT_LENGTH, (Object)byArray2.length);
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONNECTION, (Object)HttpHeaderValues.CLOSE);
        this.azf.writeAndFlush((Object)defaultFullHttpResponse).addListener((GenericFutureListener)ChannelFutureListener.CLOSE);
    }

    @Override
    public void a(File file, String string, Runnable runnable, Runnable runnable2) {
        if (!file.exists()) {
            this.a(404, "File Not Found".getBytes(StandardCharsets.UTF_8), "text/plain");
            runnable2.run();
            return;
        }
        int n = 65536;
        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        defaultHttpResponse.headers().set(this.azg);
        defaultHttpResponse.headers().set((CharSequence)HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, (Object)"*");
        defaultHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONTENT_TYPE, (Object)string);
        defaultHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONTENT_LENGTH, (Object)file.length());
        defaultHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONNECTION, (Object)HttpHeaderValues.CLOSE);
        this.azf.writeAndFlush((Object)defaultHttpResponse);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        RecordOfChannelHandlerContext.a(this.azf, randomAccessFile, n, runnable);
    }

    private static void a(ChannelHandlerContext channelHandlerContext, RandomAccessFile randomAccessFile, int n, Runnable runnable) {
        channelHandlerContext.executor().execute(() -> RecordOfChannelHandlerContext.a(channelHandlerContext, randomAccessFile, ItemsadderHttpPacket.ayZ, n, runnable));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void a(ChannelHandlerContext channelHandlerContext, RandomAccessFile randomAccessFile, long l, int n, Runnable runnable) {
        try {
            if (!channelHandlerContext.channel().isOpen()) {
                randomAccessFile.close();
                runnable.run();
                return;
            }
            byte[] byArray = new byte[n];
            int n2 = randomAccessFile.read(byArray);
            if (n2 == -1) {
                randomAccessFile.close();
                channelHandlerContext.writeAndFlush((Object)LastHttpContent.EMPTY_LAST_CONTENT).addListener(future -> {
                    try {
                        runnable.run();
                    }
                    finally {
                        channelHandlerContext.close();
                    }
                });
                return;
            }
            ByteBuf byteBuf = channelHandlerContext.alloc().buffer(n2);
            byteBuf.writeBytes(byArray, 0, n2);
            channelHandlerContext.writeAndFlush((Object)new DefaultHttpContent(byteBuf));
            long l2 = Math.max(1L, (long)n2 * 1000L / l);
            channelHandlerContext.executor().schedule(() -> RecordOfChannelHandlerContext.a(channelHandlerContext, randomAccessFile, l, n, runnable), l2, TimeUnit.MILLISECONDS);
        }
        catch (Throwable throwable) {
            try {
                randomAccessFile.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            try {
                runnable.run();
            }
            finally {
                channelHandlerContext.close();
            }
        }
    }

    private void Cq() {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        defaultFullHttpResponse.headers().set(this.azg);
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, (Object)"*");
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.ACCESS_CONTROL_ALLOW_METHODS, (Object)"GET, POST, DELETE, OPTIONS");
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.ACCESS_CONTROL_ALLOW_HEADERS, (Object)"Content-Type, Authorization");
        defaultFullHttpResponse.headers().set((CharSequence)HttpHeaderNames.CONTENT_LENGTH, (Object)0);
        this.azf.writeAndFlush((Object)defaultFullHttpResponse).addListener((GenericFutureListener)ChannelFutureListener.CLOSE);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfChannelHandlerContext.class, "ctx;headers", "azf", "azg"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfChannelHandlerContext.class, "ctx;headers", "azf", "azg"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfChannelHandlerContext.class, "ctx;headers", "azf", "azg"}, this, object);
    }

    public ChannelHandlerContext Cr() {
        return this.azf;
    }

    public HttpHeaders Cs() {
        return this.azg;
    }
}
