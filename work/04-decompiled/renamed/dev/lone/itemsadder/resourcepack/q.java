package dev.lone.itemsadder.resourcepack;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class q
extends FilterOutputStream {
    public q(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void close() {
        this.flush();
    }
}
