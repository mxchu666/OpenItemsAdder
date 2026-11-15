package itemsadder.m;

import itemsadder.m.BufferLocked;
import itemsadder.m.CallFunction_4;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.IntData_2;
import itemsadder.m.Opaque030;
import itemsadder.m.Opaque031;
import itemsadder.m.Opaque034;
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

public abstract class ChunkStreamSomehow {
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
    Opaque030 aBR;
    public final Map aBS = new ConcurrentHashMap();

    public ChunkStreamSomehow(File file) {
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
        this.aBR = new Opaque030();
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
            int n = Opaque031.a(this.aBO);
            if (n < 0 || n > aBM) {
                throw new IOException("Invalid CData header size! '" + n + "'. " + this.lO());
            }
            this.aBR.bS(n);
            while (this.aBO.getFilePointer() < (long)n) {
                String string = Opaque031.a(this.aBO, 23L);
                IntData_2 intData_2 = new IntData_2(Opaque031.a(this.aBO), Opaque031.a(this.aBO));
                this.aBR.a(string, intData_2);
            }
        } else {
            throw new IOException("Region header not found! " + this.lO());
        }
    }

    @NotNull
    public Object a(String string, /*
     * Issues handling annotations - annotations may be inaccurate
     */
    @NotNull CallFunction_4 callFunction_4) {
        Object object = null;
        try {
            object = this.jd(string);
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        if (object == null) {
            object = callFunction_4.call(string);
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
        IntData_2 intData_2 = this.aBR.je(string);
        if (intData_2 == null) {
            return null;
        }
        Opaque034 opaque034 = Opaque031.a(this.aBO, this.aBR, intData_2);
        if (opaque034.size() > 0) {
            try {
                Object object = this.b(opaque034.DX(), intData_2.aBY);
                this.aBS.put(string, object);
                return object;
            }
            catch (EOFException eOFException) {
                CommandSenderBridge_5.error("Error reading chunk serialized entry '" + string + "'" + this.lO(), eOFException);
                throw new EOFException("Chunk stream somehow goes outside the file size.");
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error reading chunk serialized entry '" + string + "'" + this.lO(), throwable);
                throw throwable;
            }
        }
        return null;
    }

    protected abstract Object b(InputStream var1, int var2);

    protected abstract OutputStream a(Opaque034 var1, Object var2);

    protected abstract boolean a(Object var1);

    public void h(boolean bl, boolean bl2) {
        this.DR();
        try {
            Opaque030 opaque030 = this.aBR;
            this.aBR = new Opaque030();
            BufferLocked bufferLocked = this.aBR.DU();
            Opaque034 opaque034 = new Opaque034();
            this.a(opaque030, bufferLocked, opaque034);
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
                    this.a(string, v, bufferLocked, opaque034);
                    if (!bl2) continue;
                    iterator.remove();
                }
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Failed to write chunks to file " + this.lO(), throwable);
            }
            bufferLocked.DV();
            this.aBO.setLength(bufferLocked.size() + opaque034.size());
            this.aBO.seek(0L);
            bufferLocked.a(this.aBO);
            opaque034.a(this.aBO);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (bl) {
            this.lS();
        }
    }

    private void a(Opaque030 opaque030, BufferLocked bufferLocked, Opaque034 opaque034) {
        if (this.aBO.length() < (long)aBK) {
            return;
        }
        for (Map.Entry entry : opaque030.aBU.entrySet()) {
            Opaque034 opaque0342;
            String string = (String)entry.getKey();
            IntData_2 intData_2 = (IntData_2)entry.getValue();
            if (this.aBS.containsKey(string) || (opaque0342 = Opaque031.a(this.aBO, opaque030, intData_2)).size() <= 0) continue;
            try {
                int n = opaque034.size();
                opaque0342.a(opaque034);
                bufferLocked.c(string, n, opaque0342.size());
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Failed to save chunk to file " + string + " -> " + this.lO());
                iOException.printStackTrace();
            }
        }
    }

    private void a(String string, Object object, BufferLocked bufferLocked, ByteArrayOutputStream byteArrayOutputStream) {
        Opaque034 opaque034 = new Opaque034();
        OutputStream outputStream = this.a(opaque034, object);
        outputStream.close();
        int n = byteArrayOutputStream.size();
        opaque034.a(byteArrayOutputStream);
        bufferLocked.c(string, n, opaque034.size());
    }

    public void lS() {
        if (this.aBO != null) {
            try {
                this.aBO.close();
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error closing region file I/O " + this.lO(), throwable);
            }
        }
    }
}
