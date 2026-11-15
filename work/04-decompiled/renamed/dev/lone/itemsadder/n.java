package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;

public class n {
    public static final String Qf = "3.1.0";
    private static final String Qg = "https://pstats.devs.beer/api/v2/data/%s";
    private final ScheduledExecutorService Qh;
    private final String Qi;
    private final String Qj;
    private final int Qk;
    private final Consumer Ql;
    private final Consumer Qm;
    private final Consumer Qn;
    private final Supplier Qo;
    private final BiConsumer Qp;
    private final Consumer Qq;
    private final boolean Qr;
    private final boolean Qs;
    private final boolean Qt;
    private final Set Qu = new HashSet();
    private final boolean Qv;

    public n(String string, String string2, int n2, boolean bl, Consumer consumer, Consumer consumer2, Consumer consumer3, Supplier supplier, BiConsumer biConsumer, Consumer consumer4, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, runnable -> {
            Thread thread = new Thread(runnable, "pStats-Metrics");
            thread.setDaemon(true);
            return thread;
        });
        scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        this.Qh = scheduledThreadPoolExecutor;
        this.Qi = string;
        this.Qj = string2;
        this.Qk = n2;
        this.Qv = bl;
        this.Ql = consumer;
        this.Qm = consumer2;
        this.Qn = consumer3;
        this.Qo = supplier;
        this.Qp = biConsumer;
        this.Qq = consumer4;
        this.Qr = bl2;
        this.Qs = bl3;
        this.Qt = bl4;
        if (!bl5) {
            this.checkRelocation();
        }
        if (bl) {
            this.sf();
        }
    }

    public void a(j j2) {
        this.Qu.add(j2);
    }

    public void Z() {
        this.Qh.shutdown();
    }

    private void sf() {
        Runnable runnable = () -> {
            if (!this.Qv || !((Boolean)this.Qo.get()).booleanValue()) {
                this.Qh.shutdown();
                return;
            }
            if (this.Qn != null) {
                this.Qn.accept(this::sg);
            } else {
                this.sg();
            }
        };
        long l = (long)(60000.0 * (3.0 + Math.random() * 3.0));
        long l2 = (long)(60000.0 * (Math.random() * 30.0));
        this.Qh.schedule(runnable, l, TimeUnit.MILLISECONDS);
        this.Qh.scheduleAtFixedRate(runnable, l + l2, 1800000L, TimeUnit.MILLISECONDS);
    }

    private void sg() {
        l l2 = new l();
        this.Ql.accept(l2);
        l l3 = new l();
        this.Qm.accept(l3);
        m[] mArray = (m[])this.Qu.stream().map(j2 -> j2.a(this.Qp, this.Qr)).filter(Objects::nonNull).toArray(m[]::new);
        l3.h("id", this.Qk);
        l3.a("customCharts", mArray);
        l2.a("service", l3.se());
        l2.x("serverUUID", this.Qj);
        l2.x("metricsVersion", Qf);
        m m2 = l2.se();
        this.Qh.execute(() -> {
            block2: {
                try {
                    this.a(m2);
                }
                catch (Exception exception) {
                    if (!this.Qr) break block2;
                    this.Qp.accept("Could not submit pStats metrics data", exception);
                }
            }
        });
    }

    private void a(m m2) {
        if (this.Qs) {
            this.Qq.accept("Sent pStats metrics data: " + m2.toString());
        }
        String string = String.format(Qg, this.Qi);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(string).openConnection();
        byte[] byArray = n.cW(m2.toString());
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.addRequestProperty("Accept", "application/json");
        httpsURLConnection.addRequestProperty("Connection", "close");
        httpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpsURLConnection.addRequestProperty("Content-Length", String.valueOf(byArray.length));
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("User-Agent", "Metrics-Service/1");
        httpsURLConnection.setDoOutput(true);
        try (Object object = new DataOutputStream(httpsURLConnection.getOutputStream());){
            ((FilterOutputStream)object).write(byArray);
        }
        object = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));){
            String string2;
            while ((string2 = bufferedReader.readLine()) != null) {
                ((StringBuilder)object).append(string2);
            }
        }
        if (this.Qt) {
            this.Qq.accept("Sent data to pStats and received response: " + String.valueOf(object));
        }
    }

    private void checkRelocation() {
        if (System.getProperty("pStats.relocatecheck") == null || !System.getProperty("pStats.relocatecheck").equals("false")) {
            String string = new String(new byte[]{111, 114, 103, 46, 98, 115, 116, 97, 116, 115});
            String string2 = new String(new byte[]{121, 111, 117, 114, 46, 112, 97, 99, 107, 97, 103, 101});
            if (n.class.getPackage().getName().startsWith(string) || n.class.getPackage().getName().startsWith(string2)) {
                throw new IllegalStateException("pStats Metrics class has not been relocated correctly!");
            }
        }
    }

    private static byte[] cW(String string) {
        if (string == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);){
            gZIPOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
        }
        return byteArrayOutputStream.toByteArray();
    }
}
