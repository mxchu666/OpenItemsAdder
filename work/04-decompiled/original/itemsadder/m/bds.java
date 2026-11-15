package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.bdt;
import itemsadder.m.bdu;
import itemsadder.m.bdv;
import itemsadder.m.bdw;
import itemsadder.m.bdx;
import itemsadder.m.bea;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class bds {
    public static final int aBG = 16384;
    static final int aBH = 4;
    static final int aBI = 1024;
    static final byte[] aBJ = new byte[]{85, 76, 6, 1};
    static final int aBK = aBJ.length;
    static final int aBL = 35;
    static final int aBM = aBK + 4 + 35840;
    static final int aBN = 23;
    private RandomAccessFile aBO;
    public final File aBP;
    boolean aBQ;
    bdu aBR;
    public final Map aBS = new ConcurrentHashMap();

    public bds(File file) {
        this.aBP = file;
        if (file.getParentFile() != null) {
            Files.createDirectories(file.getParentFile().toPath(), new FileAttribute[0]);
        }
        this.DR();
        this.DT();
    }

    @Deprecated
    public Map DQ() {
        return this.aBS;
    }

    @Nullable
    public Object ja(String string) {
        return this.aBS.get(string);
    }

    public boolean jb(String string) {
        return this.aBR != null && this.aBR.je(string) != null;
    }

    @Nullable
    public Object jc(String string) {
        return this.aBS.remove(string);
    }

    public String lO() {
        return this.aBP.getAbsolutePath();
    }

    private void DR() {
        if (!this.DS()) {
            this.aBO = new RandomAccessFile(this.aBP, "rw");
            this.aBQ = true;
        }
    }

    private boolean DS() {
        try {
            if (this.aBO == null) {
                return false;
            }
            return this.aBO.getFD().valid();
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public void DT() {
        this.aBR = new bdu();
        if (!this.aBQ) {
            return;
        }
        this.DR();
        if (this.aBO.length() < (long)aBK) {
            return;
        }
        this.aBO.seek(0L);
        byte[] byArray = new byte[aBK];
        this.aBO.read(byArray);
        if (Arrays.equals(aBJ, byArray)) {
            int n = bdx.a(this.aBO);
            if (n < 0 || n > aBM) {
                throw new IOException("Invalid CData header size! '" + n + "'. " + this.lO());
            }
            this.aBR.bS(n);
            while (this.aBO.getFilePointer() < (long)n) {
                String string = bdx.a(this.aBO, 23L);
                bdw bdw2 = new bdw(bdx.a(this.aBO), bdx.a(this.aBO));
                this.aBR.a(string, bdw2);
            }
        } else {
            throw new IOException("Region header not found! " + this.lO());
        }
    }

    @NotNull
    public Object a(String string, /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @NotNull bdt bdt2) {
        Object object = null;
        try {
            object = this.jd(string);
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        if (object == null) {
            object = bdt2.call(string);
            this.aBS.put(string, object);
        }
        return object;
    }

    @Nullable
    public Object jd(String string) {
        if (!this.aBQ) {
            return null;
        }
        this.DR();
        if (this.aBO.length() < (long)aBK) {
            return null;
        }
        bdw bdw2 = this.aBR.je(string);
        if (bdw2 == null) {
            return null;
        }
        bea bea2 = bdx.a(this.aBO, this.aBR, bdw2);
        if (bea2.size() > 0) {
            try {
                Object object = this.b(bea2.DX(), bdw2.aBY);
                this.aBS.put(string, object);
                return object;
            }
            catch (EOFException eOFException) {
                bce.error("Error reading chunk serialized entry '" + string + "'" + this.lO(), eOFException);
                throw new EOFException("Chunk stream somehow goes outside the file size.");
            }
            catch (Throwable throwable) {
                bce.error("Error reading chunk serialized entry '" + string + "'" + this.lO(), throwable);
                throw throwable;
            }
        }
        return null;
    }

    protected abstract Object b(InputStream var1, int var2);

    protected abstract OutputStream a(bea var1, Object var2);

    protected abstract boolean a(Object var1);

    public void h(boolean bl, boolean bl2) {
        this.DR();
        try {
            bdu bdu2 = this.aBR;
            this.aBR = new bdu();
            bdv bdv2 = this.aBR.DU();
            bea bea2 = new bea();
            this.a(bdu2, bdv2, bea2);
            try {
                Iterator iterator = this.aBS.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = iterator.next();
                    String string = (String)entry.getKey();
                    Object v = entry.getValue();
                    if (!this.a(v)) {
                        if (!bl2) continue;
                        iterator.remove();
                        continue;
                    }
                    this.a(string, v, bdv2, bea2);
                    if (!bl2) continue;
                    iterator.remove();
                }
            }
            catch (Throwable throwable) {
                bce.error("Failed to write chunks to file " + this.lO(), throwable);
            }
            bdv2.DV();
            this.aBO.setLength(bdv2.size() + bea2.size());
            this.aBO.seek(0L);
            bdv2.a(this.aBO);
            bea2.a(this.aBO);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (bl) {
            this.lS();
        }
    }

    private void a(bdu bdu2, bdv bdv2, bea bea2) {
        if (this.aBO.length() < (long)aBK) {
            return;
        }
        for (Map.Entry entry : bdu2.aBU.entrySet()) {
            bea bea3;
            String string = (String)entry.getKey();
            bdw bdw2 = (bdw)entry.getValue();
            if (this.aBS.containsKey(string) || (bea3 = bdx.a(this.aBO, bdu2, bdw2)).size() <= 0) continue;
            try {
                int n = bea2.size();
                bea3.a(bea2);
                bdv2.c(string, n, bea3.size());
            }
            catch (IOException iOException) {
                bce.error("Failed to save chunk to file " + string + " -> " + this.lO());
                iOException.printStackTrace();
            }
        }
    }

    private void a(String string, Object object, bdv bdv2, ByteArrayOutputStream byteArrayOutputStream) {
        bea bea2 = new bea();
        OutputStream outputStream = this.a(bea2, object);
        outputStream.close();
        int n = byteArrayOutputStream.size();
        bea2.a(byteArrayOutputStream);
        bdv2.c(string, n, bea2.size());
    }

    public void lS() {
        if (this.aBO != null) {
            try {
                this.aBO.close();
            }
            catch (Throwable throwable) {
                bce.error("Error closing region file I/O " + this.lO(), throwable);
            }
        }
    }
}
