package itemsadder.m;

import itemsadder.m.Opaque050;
import itemsadder.m.StepFunction;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class Opaque049
extends HttpEntityWrapper {
    private final StepFunction aCS;

    public Opaque049(HttpEntity httpEntity, StepFunction stepFunction) {
        super(httpEntity);
        this.aCS = stepFunction;
    }

    public void writeTo(OutputStream outputStream) {
        this.wrappedEntity.writeTo(outputStream instanceof Opaque050 ? outputStream : new Opaque050(outputStream, this.aCS));
    }
}
