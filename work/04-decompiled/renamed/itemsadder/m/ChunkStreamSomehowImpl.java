package itemsadder.m;

import itemsadder.m.Builder_2;
import itemsadder.m.Builder_3;
import itemsadder.m.ChunkStreamSomehow;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque034;
import itemsadder.m.PluginContractBuilder_3;
import itemsadder.m.PluginContractImpl_6;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ChunkStreamSomehowImpl
extends ChunkStreamSomehow {
    public ChunkStreamSomehowImpl(File file) {
        super(file);
    }

    static void a(InputStream inputStream, WdFunction wdFunction, PluginContract_14 pluginContract_14) {
        FluentBuilderBuilder_2 fluentBuilderBuilder_2 = new FluentBuilderBuilder_2(inputStream, true);
        fluentBuilderBuilder_2.cg(Integer.MAX_VALUE);
        pluginContract_14.a(fluentBuilderBuilder_2, (Object)wdFunction);
        fluentBuilderBuilder_2.cc(0);
    }

    public static void a(InputStream inputStream, WdFunction wdFunction) {
        ChunkStreamSomehowImpl.a(inputStream, wdFunction, wdFunction.wd());
    }

    protected Builder_3 a(InputStream inputStream, int n) {
        GZIPInputStream gZIPInputStream;
        try (GZIPInputStream gZIPInputStream2 = gZIPInputStream = new GZIPInputStream(inputStream);){
            Builder_3 builder_3 = Builder_3.wt();
            ChunkStreamSomehowImpl.a(gZIPInputStream, builder_3);
            gZIPInputStream.close();
            Builder_3 builder_32 = builder_3;
            return builder_32;
        }
    }

    protected GZIPOutputStream a(Opaque034 opaque034, Builder_3 builder_3) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(opaque034);
        FluentBuilder_5 fluentBuilder_5 = FluentBuilder_5.cv(16384);
        PluginContractImpl_6 pluginContractImpl_6 = new PluginContractImpl_6(fluentBuilder_5, gZIPOutputStream);
        Builder_3.apQ.a(pluginContractImpl_6, (Object)builder_3);
        FluentBuilder_5.a(gZIPOutputStream, fluentBuilder_5);
        return gZIPOutputStream;
    }

    protected boolean a(Builder_3 builder_3) {
        if (builder_3.wu() == null || builder_3.wu().size() == 0) {
            return false;
        }
        if (MaterialBarColorHolder.eR) {
            this.b(builder_3);
        }
        return true;
    }

    private void b(Builder_3 builder_3) {
        PluginContractBuilder_3 pluginContractBuilder_3 = builder_3.ww();
        if (pluginContractBuilder_3 != null && pluginContractBuilder_3.xa() != null) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (Map.Entry entry : builder_3.wu().entrySet()) {
                arrayList.add(((Builder_2)entry.getValue()).wl());
            }
            if (arrayList.size() > 0) {
                Iterator iterator = pluginContractBuilder_3.xa().entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry;
                    entry = iterator.next();
                    if (arrayList.contains(entry.getKey())) continue;
                    iterator.remove();
                }
            }
        }
    }

    @Override
    protected /* synthetic */ Object b(InputStream inputStream, int n) {
        return this.a(inputStream, n);
    }
}
