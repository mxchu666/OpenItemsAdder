package dev.lone.itemsadder.api.Events;

import java.io.OutputStream;

@FunctionalInterface
public interface ItemsAdderPackCompressedEvent$EntryWriter {
    public void writeTo(OutputStream var1);
}
