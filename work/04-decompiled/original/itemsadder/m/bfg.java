package itemsadder.m;

import itemsadder.m.bfh;
import itemsadder.m.bfi;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class bfg
extends HttpEntityWrapper {
    private final bfi aCS;

    public bfg(HttpEntity httpEntity, bfi bfi2) {
        super(httpEntity);
        this.aCS = bfi2;
    }

    public void writeTo(OutputStream outputStream) {
        this.wrappedEntity.writeTo(outputStream instanceof bfh ? outputStream : new bfh(outputStream, this.aCS));
    }
}
