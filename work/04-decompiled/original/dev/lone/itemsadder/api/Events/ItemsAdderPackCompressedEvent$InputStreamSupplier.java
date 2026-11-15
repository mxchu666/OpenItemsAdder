package dev.lone.itemsadder.api.Events;

import java.io.InputStream;

@FunctionalInterface
public interface ItemsAdderPackCompressedEvent$InputStreamSupplier {
    public InputStream openStream();
}
