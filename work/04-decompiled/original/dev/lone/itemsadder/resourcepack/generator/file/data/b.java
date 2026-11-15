package dev.lone.itemsadder.resourcepack.generator.file.data;

import com.alibaba.fastjson2.JSONReader;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.generator.file.data.JsonAsset;
import dev.lone.itemsadder.resourcepack.generator.file.data.JsonAsset$MissingAssetException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class b
extends JsonAsset {
    public b(String string) {
        InputStream inputStream = Main.rS().getResource(string);
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

    public static void a(String string, Consumer consumer, Consumer consumer2) {
        b b2 = new b(string);
        if (b2.BN()) {
            consumer2.accept(b2);
        } else {
            consumer.accept(b2);
        }
    }
}
