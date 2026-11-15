package itemsadder.m;

import io.netty.buffer.ByteBufInputStream;
import io.netty.handler.codec.http.FullHttpRequest;
import itemsadder.m.bap;
import java.io.InputStream;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.net.URI;

public final class ban
extends Record
implements bap {
    private final FullHttpRequest azd;
    private final URI aze;

    public ban(FullHttpRequest fullHttpRequest) {
        this(fullHttpRequest, URI.create(fullHttpRequest.uri()));
    }

    public ban(FullHttpRequest fullHttpRequest, URI uRI) {
        this.azd = fullHttpRequest;
        this.aze = uRI;
    }

    @Override
    public String Cm() {
        return this.azd.method().name();
    }

    @Override
    public String pK() {
        return this.aze.getPath();
    }

    @Override
    public InputStream Cn() {
        return new ByteBufInputStream(this.azd.content());
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ban.class, "request;uri", "azd", "aze"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ban.class, "request;uri", "azd", "aze"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ban.class, "request;uri", "azd", "aze"}, this, object);
    }

    public FullHttpRequest Co() {
        return this.azd;
    }

    public URI Cp() {
        return this.aze;
    }
}
