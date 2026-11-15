package dev.lone.itemsadder.resourcepack.generator.file.data;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONReader;
import dev.lone.itemsadder.resourcepack.generator.file.data.JsonAsset;
import dev.lone.itemsadder.resourcepack.generator.file.data.JsonAsset$MissingAssetException;
import itemsadder.m.ItemStackRegistry;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class f
extends JsonAsset {
    public f(String string) {
        this(string, Version.get());
    }

    public f(String string, Version version) {
        InputStream inputStream = ItemStackRegistry.g().B.a(string, version);
        if (inputStream == null) {
            this.ayq = new JsonAsset$MissingAssetException("OriginalAsset: No vanilla model file: '" + string + "'");
            return;
        }
        try {
            this.KA = string;
            JSONReader jSONReader = JSONReader.of((Reader)new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            this.ayp = jSONReader.readAny();
            jSONReader.close();
        }
        catch (Exception exception) {
            this.ayq = exception;
        }
    }
}
