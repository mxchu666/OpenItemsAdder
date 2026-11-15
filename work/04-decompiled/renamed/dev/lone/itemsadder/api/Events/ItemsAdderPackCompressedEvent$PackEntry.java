package dev.lone.itemsadder.api.Events;

import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$EntryWriter;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$InputStreamSupplier;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public class ItemsAdderPackCompressedEvent$PackEntry {
    private final String path;
    @Nullable
    private ItemsAdderPackCompressedEvent$InputStreamSupplier inputStreamSupplier;
    @Nullable
    private ItemsAdderPackCompressedEvent$EntryWriter writer;
    @Nullable
    private byte[] bytes;
    private boolean removed;

    private ItemsAdderPackCompressedEvent$PackEntry(String string, @Nullable ItemsAdderPackCompressedEvent$InputStreamSupplier inputStreamSupplier, @Nullable ItemsAdderPackCompressedEvent$EntryWriter entryWriter) {
        this.path = Objects.requireNonNull(string, "path");
        this.inputStreamSupplier = inputStreamSupplier;
        this.writer = entryWriter;
    }

    public static ItemsAdderPackCompressedEvent$PackEntry stream(String string, ItemsAdderPackCompressedEvent$InputStreamSupplier inputStreamSupplier) {
        return new ItemsAdderPackCompressedEvent$PackEntry(string, Objects.requireNonNull(inputStreamSupplier, "inputStreamSupplier"), null);
    }

    public static ItemsAdderPackCompressedEvent$PackEntry writer(String string, ItemsAdderPackCompressedEvent$EntryWriter entryWriter) {
        return new ItemsAdderPackCompressedEvent$PackEntry(string, null, Objects.requireNonNull(entryWriter, "writer"));
    }

    public static ItemsAdderPackCompressedEvent$PackEntry bytes(String string, byte[] byArray) {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = new ItemsAdderPackCompressedEvent$PackEntry(string, null, null);
        itemsAdderPackCompressedEvent$PackEntry.setBytes(byArray);
        return itemsAdderPackCompressedEvent$PackEntry;
    }

    public String getPath() {
        return this.path;
    }

    public InputStream openStream() {
        if (this.bytes != null) {
            return new ByteArrayInputStream(this.bytes);
        }
        if (this.inputStreamSupplier != null) {
            return this.inputStreamSupplier.openStream();
        }
        if (this.writer != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.writer.writeTo(byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return InputStream.nullInputStream();
    }

    public byte[] getBytes() {
        try (InputStream inputStream = this.openStream();){
            byte[] byArray = inputStream.readAllBytes();
            return byArray;
        }
    }

    public String getText() {
        return new String(this.getBytes(), StandardCharsets.UTF_8);
    }

    public void setBytes(byte[] byArray) {
        this.bytes = Objects.requireNonNull(byArray, "bytes");
        this.inputStreamSupplier = null;
        this.writer = null;
        this.removed = false;
    }

    public void setText(String string) {
        this.setBytes(string.getBytes(StandardCharsets.UTF_8));
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public void remove() {
        this.removed = true;
    }
}
