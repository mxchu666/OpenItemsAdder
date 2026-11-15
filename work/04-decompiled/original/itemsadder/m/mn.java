package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.aya;
import itemsadder.m.ayc;
import itemsadder.m.ayk;
import itemsadder.m.bds;
import itemsadder.m.bea;
import itemsadder.m.biz;
import itemsadder.m.bjq;
import itemsadder.m.bjv;
import itemsadder.m.bkk;
import itemsadder.m.bko;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class mn
extends bds {
    public mn(File file) {
        super(file);
    }

    static void a(InputStream inputStream, bjv bjv2, bko bko2) {
        biz biz2 = new biz(inputStream, true);
        biz2.cg(Integer.MAX_VALUE);
        bko2.a(biz2, (Object)bjv2);
        biz2.cc(0);
    }

    public static void a(InputStream inputStream, bjv bjv2) {
        mn.a(inputStream, bjv2, bjv2.wd());
    }

    protected ayc a(InputStream inputStream, int n) {
        GZIPInputStream gZIPInputStream;
        try (GZIPInputStream gZIPInputStream2 = gZIPInputStream = new GZIPInputStream(inputStream);){
            ayc ayc2 = ayc.wt();
            mn.a(gZIPInputStream, ayc2);
            gZIPInputStream.close();
            ayc ayc3 = ayc2;
            return ayc3;
        }
    }

    protected GZIPOutputStream a(bea bea2, ayc ayc2) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(bea2);
        bjq bjq2 = bjq.cv(16384);
        bkk bkk2 = new bkk(bjq2, gZIPOutputStream);
        ayc.apQ.a(bkk2, (Object)ayc2);
        bjq.a(gZIPOutputStream, bjq2);
        return gZIPOutputStream;
    }

    protected boolean a(ayc ayc2) {
        if (ayc2.wu() == null || ayc2.wu().size() == 0) {
            return false;
        }
        if (ae.eR) {
            this.b(ayc2);
        }
        return true;
    }

    private void b(ayc ayc2) {
        ayk ayk2 = ayc2.ww();
        if (ayk2 != null && ayk2.xa() != null) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (Map.Entry entry : ayc2.wu().entrySet()) {
                arrayList.add(((aya)entry.getValue()).wl());
            }
            if (arrayList.size() > 0) {
                Iterator iterator = ayk2.xa().entrySet().iterator();
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
